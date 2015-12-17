//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.37 build 2118.23158)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.batchprintinghistory;

import ims.admin.forms.batchprintinghistory.GenForm.grdDocumentsRow;
import ims.admin.vo.PrintAgentDocumentsVo;
import ims.admin.vo.PrintAgentDocumentsVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.ims.query.builder.client.PrinterAvailableCollection;
import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.cmbExport().newRow(QueryBuilderClient.PDF, QueryBuilderClient.PDF);
		form.cmbExport().newRow(QueryBuilderClient.CSV, QueryBuilderClient.CSV);
		form.cmbExport().newRow(QueryBuilderClient.HTML, QueryBuilderClient.HTML);
		form.cmbExport().newRow(QueryBuilderClient.RTF, QueryBuilderClient.RTF);
		form.cmbExport().newRow(QueryBuilderClient.JPEG, QueryBuilderClient.JPEG);
		
		QueryBuilderClient qb = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());

		PrinterAvailableCollection list = null;
		try
		{
			list = qb.listPrinters(ConfigFlag.GEN.REPORT_SERVER_URL.getValue());
			
			for(int i = 0; i < list.size(); i++)
			{
				form.cmbPrinter().newRow(list.get(i).getName(), list.get(i).getName());
			}
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage("Error getting the printers from report server: " + e.toString());
		}
		
		Date now = new Date();
		now.addDay(-7);
		Time t = new Time(0,0,0);
		
		form.dtimStart().setValue(new DateTime(now, t));
		form.dtimEnd().setValue(new DateTime());
		searchDocuments(true);
	}
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException
	{
		PrintAgentDocumentsVo doc = form.grdDocuments().getValue();
		if(doc == null)
		{
			engine.showMessage("Please select a document to print !");
			return;
		}

		String printer = form.cmbPrinter().getValue();
		if(printer == null || printer.length() == 0)
		{
			engine.showMessage("Please select a printer !");
			return;
		}
		
		QueryBuilderClient qb = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());
		
		try
		{
			qb.printReport(doc.getDocument().getBytes(), ConfigFlag.GEN.REPORT_SERVER_URL.getValue(), printer, 1);
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage("Error printing document: " + e.toString());
			return;
		}
	}
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		searchDocuments(false);
	}

	private void searchDocuments(boolean firstSearch)
	{
		form.grdDocuments().getRows().clear();//	WDEV-15152
		
		if(isSearchCriteriaValid())//	WDEV-15152
		{
			PrintAgentDocumentsVoCollection coll = null;
			
			coll = domain.listDocuments(form.getGlobalContext().getJobId(), form.dtimStart().getValue(), form.dtimEnd().getValue());
			displayDocuments(coll);
			
			if(form.grdDocuments().getRows().size() == 0 && !firstSearch)//	WDEV-15152
				engine.showMessage("No documents found.");
		}
	}
	
	//	WDEV-15152
	private boolean isSearchCriteriaValid() 
	{
		if(form.dtimStart().getValue() == null)
		{
			engine.showMessage("Please enter the start date/time");
			return false; 
		}
		if(form.dtimEnd().getValue() == null)
		{
			engine.showMessage("Please enter the end date/time");
			return false;
		}
		
		if (form.dtimEnd().getValue().isLessThan(form.dtimStart().getValue()))
		{
			engine.showMessage("Start date/time cannot be greater than End date/time");
			return false;
		}
		
		return true;
	}
	
	private void displayDocuments(PrintAgentDocumentsVoCollection coll)
	{
		String letters;

		form.grdDocuments().getRows().clear();
		for(int i = 0; i < coll.size(); i++)
		{
			grdDocumentsRow row = form.grdDocuments().getRows().newRow();

			if(coll.get(i).getPrintedLettersIsNotNull() && coll.get(i).getPrintedLetters().intValue() > 0)
			{
				if(coll.get(i).getPrintedLetters().intValue() == 1)
					letters = "1 letter created";
				else
					letters = coll.get(i).getPrintedLetters().toString() + " letters created";
			}
			else
			{
				letters = "No data to print";
				row.setTextColor(Color.Brown);
			}
			
			row.setValue(coll.get(i));
			row.setColumnDateTime((coll.get(i).getDescriptionIsNotNull() ? coll.get(i).getDescription() + " - " : "") + (coll.get(i).getLastUpdateDateTimeIsNotNull() ? coll.get(i).getLastUpdateDateTime().toString() : ""));
			row.setColumnLetters(letters);
		}
	}
	protected void onBtnViewClick() throws PresentationLogicException
	{
		PrintAgentDocumentsVo doc = form.grdDocuments().getValue();

		if(doc == null)
		{
			engine.showMessage("Please select a document to view !");
			return;
		}

		QueryBuilderClient qb = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());
		
		try
		{
			byte[] pdf = qb.convertReport(ConfigFlag.GEN.REPORT_SERVER_URL.getValue(), doc.getDocument().getBytes(), QueryBuilderClient.PDF, "", 1);
			String url = qb.prepareReportForViewing(pdf, "PDF"); 
			
			engine.openUrl(url);
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage("Error viewing document: " + e.toString());
			return;
		}
	}
	@Override
	protected void onBtnDownloadClick() throws PresentationLogicException
	{
		PrintAgentDocumentsVo doc = form.grdDocuments().getValue();

		if(doc == null)
		{
			engine.showMessage("Please select a document to export and download !");
			return;
		}
		
		if(form.cmbExport().getValue() == null)
		{
			engine.showMessage("Please select the export type !" );
			return;
		}
		
		form.htmDownload().setHTML("");
		
		QueryBuilderClient qb = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());
		
		byte[] rep = null;
		     
		try
		{
			rep = qb.convertReport(ConfigFlag.GEN.REPORT_SERVER_URL.getValue(), doc.getDocument().getBytes(), form.cmbExport().getValue(), "", 1);
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage("Error viewing document: " + e.toString());
			return;
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(doc.getLastUpdateDateTime().getJavaDate());
		
		String fileName = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String folderName = getDownloadFolder();
		
		if(folderName == null)
		{
			engine.showMessage("Could not get the download folder !");
			return;
		}
		
		fileName = folderName + doc.getPrintAgent().getDescription() + "_" + df.format(cal.getTime()) + "." + form.cmbExport().getValue().toLowerCase();
		
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName, true);
			fos.write(rep);
			fos.flush();
			fos.close();
		}
		catch(Exception e)
		{
			engine.showMessage("Error exporting document: " + e.toString());
			return;
		}

		String zipPart = doc.getPrintAgent().getDescription() + "_" + df.format(cal.getTime()) + ".zip";
		String filePart = doc.getPrintAgent().getDescription() + "_" + df.format(cal.getTime()) + "." + form.cmbExport().getValue().toLowerCase();
		String zipFileName = folderName + zipPart;
		byte[] buf = new byte[1024];
		int len;
		
		try
		{
			FileInputStream in = new FileInputStream(fileName); 
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		    out.setLevel(Deflater.DEFAULT_COMPRESSION);
		    out.putNextEntry(new ZipEntry(filePart));
		    while ((len = in.read(buf)) > 0) 
		    { 
		    	out.write(buf, 0, len); 
		    } 
		    out.closeEntry();
		    out.close();
		    in.close();
		}
		catch (IllegalArgumentException iae)
		{
		      iae.printStackTrace();
		      engine.showMessage("Error creating zip file :" + iae.toString());
		}
		catch (FileNotFoundException fnfe)
		{
		      fnfe.printStackTrace();
		      engine.showMessage("Error creating zip file :" + fnfe.toString());
		}
		catch (IOException ioe)
		{
		      ioe.printStackTrace();
		      engine.showMessage("Error creating zip file :" + ioe.toString());
		}

		form.htmDownload().setHTML("<center><b><a style=\"float: center\" href='" + engine.getRequestUrl() + "/download/" + zipPart + "'><font color='blue'>Download file...</font></a><span style=\"float: center\">&nbsp;</span></b></center>");
		form.htmDownload().setEnabled(true);			
	}
	
	private String getDownloadFolder()  
	{
		if ( EnvironmentConfig.getBaseUri() == null || EnvironmentConfig.getBaseUri().length() == 0)
		{
			return null;				
		}
		
		String folderName = EnvironmentConfig.getBaseUri() + "download/";				
		File folder = new File(folderName);
		
		if(folder.exists() == false)
		{
			boolean bSuccess = folder.mkdir();
			
			if(bSuccess == false)
			{
				System.out.println("I could not create the folder '" + folder.getAbsolutePath() + "' !");
				return null;
			}
		}
		
		return folderName;
	}
	@Override
	protected void onCmbExportValueChanged() throws PresentationLogicException
	{
		form.htmDownload().setHTML("");
	}
	@Override
	protected void onGrdDocumentsSelectionChanged() throws PresentationLogicException
	{
		form.htmDownload().setHTML("");
	}
	
}
