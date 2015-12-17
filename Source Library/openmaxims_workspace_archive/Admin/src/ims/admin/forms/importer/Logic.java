//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by John MacEnri using IMS Development Environment (version 1.53 build 2543.28531)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.importer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

import org.dom4j.Element;

import ims.configuration.gen.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		form.txtXml().setFocus();
	}

	@SuppressWarnings("unchecked")
	protected void onBtnImportClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// May need to get the contents from a file first
		String xml=null;
		String fileName = form.getLocalContext().getUploadFileName();
		if (fileName != null)
		{
			// Sleep for 2 seconds to allow the upload servlet to copy the
			// file to the correct location
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e){}
			xml=getFileContents(fileName);
		}
		
		if (xml == null || xml.length() == 0)
			return;
		
		try
		{
			org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new StringReader(xml));
			Element el = doc.getRootElement();
			if (el.getName().equals("contents"))
			{
				List l = el.elements();
				for (int i = 0; i < l.size(); i++)
				{
					Element elc = (Element)l.get(i);
					processElement(elc);
				}				
			}
			else
			{
				processElement(el);
			}
			
			engine.showMessage("All imports completed successfully");
		}
		catch (Exception e)
		{
			String[] errors = new String[2];
			errors[0] = e.getMessage();			
			StringWriter sw = new StringWriter();			
			e.printStackTrace(new PrintWriter(sw));
			errors[1] = sw.toString();			
			engine.showErrors(errors);			
		}		
	}
	
	private String getFileContents(String fileName)
	{
		String uploadFileName = getBaseName(fileName);
		
		String path=null;
		String mountPoint = EnvironmentConfig.getFileUploadMountpoint();
		if (mountPoint != null && !mountPoint.equals(""))
			path = mountPoint + "/" + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/ObjectImports/" + uploadFileName;
		else
			path = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/ObjectImports/" + uploadFileName;
		
		InputStream is=null;
		ZipInputStream zis=null;
		JarFile jf=null;
		try
		{
			try
			{
				jf = new JarFile(path);
				zis = new ZipInputStream(new FileInputStream(path));
				ZipEntry ze = zis.getNextEntry();
				
				if (ze != null)
				{
					is = jf.getInputStream(ze);
				}
			}
			catch (ZipException ze)
			{
				// Assume a non-compressed file
				is =new FileInputStream(path);
			}
			//wdev 3478 read the zip file entries in chunks!
			StringBuffer strBuff =new StringBuffer(is.available());
			BufferedReader input = new BufferedReader (new InputStreamReader (is));
			String line;
			while ((line = input.readLine()) != null) {
				strBuff.append(line);
			}
			input.close();
			return strBuff.toString();
		}
		catch (FileNotFoundException e)
		{
			engine.showMessage("File cannot be found " + path + " \n Is the FileUpload Servlet Running?");
			return null;
		}
		catch (IOException e)
		{
			engine.showMessage("IOException occurred loading file " + e.getMessage());
			return null;
		}
		finally
		{
			try
			{
				if (is != null)
					is.close();
				if (zis != null)
					zis.close();
				if (jf != null)
					jf.close();
			}
			catch (IOException e)
			{}
		}
	}


	@SuppressWarnings("unchecked")
	private void processElement(Element el)	throws Exception
	{
		if (el.getName().equals("class"))
		{
			domain.importItem(el);
		}
		else if (el.getName().equals("list") || el.getName().equals("set"))
		{
			List items = el.elements("class");
			for (int i = 0; i < items.size(); i++)
			{
				Element item = (Element)items.get(i);
				domain.importItem(item);
			}				
		}
	}

	protected void onupldFromFileFileUploaded(String fileName)
	{
		form.getLocalContext().setUploadFileName(fileName);
	}
		
	
	private String getBaseName(String fullFileName)
	{
		int ind = fullFileName.lastIndexOf("/");
		if (ind == -1)
		{
			ind = fullFileName.lastIndexOf("\\");			
		}
		if (ind == -1)
			return fullFileName;
		
		if (ind + 1 == fullFileName.length())
			return "";
		
		return fullFileName.substring(ind + 1);
	}
}
