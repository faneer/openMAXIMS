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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.30 build 2046.26491)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.orderentrytemplatepreview;

import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.helper.OrderEntryTemplatePopulation;
import ims.ocrr.vo.OrderEntryTemplateVo;
import ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws FormOpenException 
	{
		initialize();
		preview();
	}
	protected void onBtnCloseClick() throws PresentationLogicException 
	{
		engine.close(DialogResult.OK);
	}
	private void initialize()
	{
		if(form.getGlobalContext().OCRR.getPreviewedOrderEntryTemplateIsNotNull())
			form.getLocalContext().setPreviewedItem(form.getGlobalContext().OCRR.getPreviewedOrderEntryTemplate());
		else if(form.getGlobalContext().OCRR.getSelectedOrderEntryTemplateIDIsNotNull())
			form.getLocalContext().setPreviewedItem(domain.getOrderEntryTemplate(form.getGlobalContext().OCRR.getSelectedOrderEntryTemplateID()));
		
		//security level WDEV-9966
		RoleDisciplineSecurityLevelLiteGCVo voRoleDisciplineSecurityLevels = form.getGlobalContext().OCRR.getRoleDisciplineSecurityLevels();
		if(voRoleDisciplineSecurityLevels == null || (voRoleDisciplineSecurityLevels != null &&  voRoleDisciplineSecurityLevels.getIsConfigLoadedIsNotNull() && !voRoleDisciplineSecurityLevels.getIsConfigLoaded().equals(false)))
			form.getGlobalContext().OCRR.setRoleDisciplineSecurityLevels(domain.getRoleDisciplineSecurityLevels(engine.getLoggedInRole()));
	}		
	
	private void preview()
	{
		if(!form.getLocalContext().getPreviewedItemIsNotNull())
		{
			engine.showMessage("Unable to generate preview: order entry template not found.");
			return;
		}
		
		OrderEntryTemplateVo record = form.getLocalContext().getPreviewedItem();
		if(!record.getColumnsIsNotNull())
		{
			engine.showMessage("Unable to generate preview: order entry template columns not found.");
			return;
		}
		if(!record.getComponentsIsNotNull() || record.getComponents().size() == 0)
		{
			engine.showMessage("Unable to generate preview: no components found.");
			return;
		}
		
		new OrderEntryTemplatePopulation(form.dyngrdPreview(), form.getImages().OCRR.Investigation, form.getImages().OCRR.Profile, form.getImages().OCRR.OrderSet).populate(record);		
	}
}
