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
//This code was generated by Sean Nesbitt using IMS Development Environment (version 1.25 build 1962.19051)
//Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.templateselect;

import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportTemplateVoCollection;
import ims.core.vo.PasEventVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		
		//open the template selection dialog if more than one template
		PasEventVo voPasEvent = domain.getPasEvent(form.getGlobalContext().Core.getPasEvent());
		ReportTemplateVoCollection voCollRepTemplates = domain.listTemplates(new Boolean(true),getConsultantId(voPasEvent),getLocationId(voPasEvent),getSpecialtyId(voPasEvent));
		
		if ((voCollRepTemplates != null) && (voCollRepTemplates.size() > 0))
		{
			GenForm.grdTemplateRow row;
			for(int i=0;i<voCollRepTemplates.size();i++)
			{
				row = form.grdTemplate().getRows().newRow();
				row.setValue(voCollRepTemplates.get(i));
				row.setcolTemplate(voCollRepTemplates.get(i).getName());
			}
		}
		
		form.btnSave().setEnabled(false);
		
	}
	private Integer getSpecialtyId(PasEventVo voPasEvent) 
	{
		if (voPasEvent != null && voPasEvent.getSpecialtyIsNotNull())
		{
			return (new Integer(voPasEvent.getSpecialty().getId()));
		}
		return null;
	}
	private Integer getConsultantId(PasEventVo voPasEvent) 
	{
		if (voPasEvent != null && voPasEvent.getConsultantIsNotNull())
		{
			return voPasEvent.getConsultant().getID_Hcp();
		}
		return null;
	}
	private Integer getLocationId(PasEventVo voPasEvent) 
	{
		if (voPasEvent != null && voPasEvent.getLocationIsNotNull())
		{
			return (voPasEvent.getLocation().getID_Location());
		}
		return null;
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.grdTemplate().getSelectedRowIndex()>-1)
		{
			ReportTemplateVo voRepTemplate = new ReportTemplateVo();
			voRepTemplate = form.grdTemplate().getRows().get(form.grdTemplate().getSelectedRowIndex()).getValue(); 
			form.getGlobalContext().Correspondence.setReportTemplate(voRepTemplate);
			engine.close(DialogResult.OK);
		}
			
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.templateselect.Handlers#onGrdTemplateSelectionChanged()
	 */
	protected void onGrdTemplateSelectionChanged() throws PresentationLogicException {
	
		form.btnSave().setEnabled(true);
	}
}
