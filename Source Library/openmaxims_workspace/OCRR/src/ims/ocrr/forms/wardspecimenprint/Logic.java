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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2400.41627)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.wardspecimenprint;

import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.PrinterScope;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IPrinter;
import ims.ocrr.orderingresults.vo.SpecimenWorkListItemRefVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		/*String[] printers = domain.getCurrentLocationPrinters();
		addPrinters(printers);
		printers = domain.getCurrentLocationPrinters(true);
		addPrinters(printers);*/
		
		if (engine.getPrinterProvider() == null)
			return;
		
		IPrinter[] printers = engine.getPrinterProvider().getPrintersForLocation(domain.getCurrentLocation());
		if (printers != null)
		{			
			for(int i=0;i<printers.length;i++)
			{
				form.cmbPrinter().newRow(printers[i].getIPrinterName(), printers[i].getIPrinterName());
			}
			
			IPrinter defaultPrinter = engine.getPrinterProvider().getPrinterByLocationAndScope(domain.getCurrentLocation(), PrinterScope.OCSORDER);
			if (defaultPrinter != null)
			{				
				form.cmbPrinter().setValue(defaultPrinter.getIPrinterName());
			}
		}	
	}
/*	private void addPrinters(String[] printers)
	{
		if(printers != null && printers.length > 0)
		{
			for (int i = 0; i < printers.length; i++)
			{
				form.cmbPrinter().newRow(printers[i], printers[i]);
			}
		}
		if(printers != null && printers.length > 0)
			form.cmbPrinter().setValue(printers[0]);
	}
*/	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.cmbPrinter().getValue() == null)
		{
			engine.showMessage("Please select a printer!");
			return;
		}
		engine.open(form.getForms().Core.Reports);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if(formName.equals(form.getForms().Core.Reports) && result.equals(DialogResult.OK))
		{
			if(printWorkListItemCollection());
				engine.close(DialogResult.OK);
		}
		else
		{
			form.btnPrint().setEnabled(false);
		}
	}
	private boolean printWorkListItemCollection()
	{
		SpecimenWorkListItemRefVoCollection voColl = form.getGlobalContext().OCRR.getSpecimenWorkListItemPrintList();
		for (int i = 0; i < voColl.size(); i++)
		{
			//TODO - for Vasile (or the person to to the Print) - get the ids and print theme	
		}
		
		return true;
	}
}
