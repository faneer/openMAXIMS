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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4868.26580)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.forms.requestimagetransfer;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.forms.requestimagetransfer.GenForm.grdImageTransfersRow;
import ims.eas.vo.EASImageTransferVo;
import ims.eas.vo.EASImageTransferVoCollection;
import ims.eas.vo.EASwithImageTransfersVo;
import ims.eas.vo.ElectronicActionSheetRefVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;


	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		if (args == null || args.length < 1)
			throw new CodingRuntimeException("Improper use of dialog - EAS record must be passed as a parameter.");
		
		if (!(args[0] instanceof ElectronicActionSheetRefVo))
			throw new CodingRuntimeException("Improper use of dialog - first parameter must be EAS record.");
		
		form.getLocalContext().setElectronicActionSheet(domain.getElectronicActionSheet((ElectronicActionSheetRefVo) args[0]));
		
		if (form.getLocalContext().getElectronicActionSheet() == null)
			throw new CodingRuntimeException("Improper use of dialog - EAS record must be passed as a parameter and must be in the database.");
		
		open(form.getLocalContext().getElectronicActionSheet());
	}

	
	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}


	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	
	private void open(EASwithImageTransfersVo easRecord) throws PresentationLogicException
	{
		populateImageTransfers(easRecord.getImageTransfers());
	}


	private void populateImageTransfers(EASImageTransferVoCollection imageTransfers)
	{
		form.grdImageTransfers().getRows().clear();
		
		if (imageTransfers == null || imageTransfers.size() == 0)
			return;
		
		for (EASImageTransferVo image : imageTransfers)
		{
			grdImageTransfersRow row = form.grdImageTransfers().getRows().newRow();
			
			row.setColImageType(image.getImageType().getText());
			row.setTooltipForColImageType(image.getImageType().getText());
			row.setColImageTypeReadOnly(true);

			row.setColDate(image.getImageDate());
			row.setTooltipForColDate(image.getImageDate() != null ? image.getImageDate().toString() : "");
			row.setColDateReadOnly(true);
			
			row.setColLocationTaken(image.getImageTakenAt().getText());
			row.setTooltipForColLocationTaken(image.getImageTakenAt() != null ? image.getImageTakenAt().getText() : "");
			row.setColLocationTakenReadOnly(true);
			
			row.setColComments(image.getLocationTaken());
			row.setTooltipForColComments(image.getLocationTaken());
			row.setColCommentsReadOnly(true);
			
			row.setColAnatomicalSite(image.getAnatomicalSite());
			row.setTooltipForColAnatomicalSite(image.getAnatomicalSite());
			row.setColAnatomicalSiteReadOnly(true);
			
			row.setColRequested(Boolean.TRUE.equals(image.getImageRequested()));
			row.setColRequestedReadOnly(false);
			
			row.setValue(image);
			row.setReadOnly(false);
		}
	}


	private boolean save() throws PresentationLogicException
	{
		try
		{
			// Populate data from screen
			form.getLocalContext().setElectronicActionSheet(populateDataFromScreen(form.getLocalContext().getElectronicActionSheet()));

			domain.save(form.getLocalContext().getElectronicActionSheet());

			return true;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setElectronicActionSheet(domain.getElectronicActionSheet(form.getLocalContext().getElectronicActionSheet()));
			open(form.getLocalContext().getElectronicActionSheet());
			return false;
		}
	}


	private EASwithImageTransfersVo populateDataFromScreen(EASwithImageTransfersVo eas)
	{
		if (eas == null)
			throw new CodingRuntimeException("EAS record can not be null");
		
		eas.setImageTransfers(new EASImageTransferVoCollection());
		
		boolean markAsRemoved = true;
		
		for (int i = 0; i < form.grdImageTransfers().getRows().size(); i++)
		{
			grdImageTransfersRow row = form.grdImageTransfers().getRows().get(i);
			
			EASImageTransferVo image = row.getValue();
			image.setImageRequested(row.getColRequested());
			image.setRemovedStat(row.getColRequested());
			
			if (row.getColRequested() == false)
				markAsRemoved = false;
			
			eas.getImageTransfers().add(image);
		}
		
		if (markAsRemoved)
			eas.setRemovedStat(Boolean.TRUE);
		
		return eas;
	}
}
