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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.35 build 2103.16649)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.nongpselect;

import ims.core.vo.CommChannelVo;
import ims.core.vo.CommChannelVoCollection;
import ims.core.vo.ExternalPersonShortVo;
import ims.core.vo.ExternalPersonVoCollection;
import ims.core.vo.PersonName;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		clearDetailControls();
		refreshLSH();
		form.setMode(FormMode.EDIT);
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getGlobalContext().Correspondence.getExternalPersonIsNotNull())
			engine.close(DialogResult.OK);
		else
		{
			engine.showMessage("Please select a recipient or choose Cancel to exit.");
			return;
		}
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}	
	private void populateExternalPersonTree(ExternalPersonShortVo filterVo) 
	{
		ExternalPersonVoCollection extPerCollVo = domain.listExternalPerson(filterVo);				
		
		if (null == extPerCollVo)
			return;
		
		form.treExternalPerson().clear();			
		if (extPerCollVo.size() > 0)
		{
			for (int i = 0; i < extPerCollVo.size() ; i++)
			{					
				ExternalPersonShortVo extPerVo = extPerCollVo.get(i);
				 
				TreeNode newNode = form.treExternalPerson().getNodes().add(extPerVo, extPerVo.getName().toShortForm());										
				newNode.setCollapsedImage(form.getImages().Admin.StaffBlack);
				newNode.setExpandedImage(form.getImages().Admin.StaffBlack);
			}
		}
		else
			engine.showMessage("No Person found matching that criteria.");
	}
	
	private void populateExternalPersonTree() 
	{
		ExternalPersonShortVo filterVo = new ExternalPersonShortVo();
		PersonName name = new PersonName();
		name.setSurname(form.txtSName().getValue());
		filterVo.setName(name);
		filterVo.setIsActive(Boolean.TRUE);		
		populateExternalPersonTree(filterVo);
	}	
	
	private void setContextVariables(ExternalPersonShortVo extPerVo) 
	{    				
		form.getGlobalContext().Correspondence.setExternalPerson(extPerVo);		
	}
	
	private void populateScreenFromData(ExternalPersonShortVo extPerVo)
	{
		clearDetailControls();
		if (extPerVo.getNameIsNotNull())
		{
			form.txtSurname().setValue(extPerVo.getName().getSurname());					
			form.txtForeName().setValue(extPerVo.getName().getForename());
			form.txtMiddleName().setValue(extPerVo.getName().getMiddleName());
			form.cmbTitle().setValue(extPerVo.getName().getTitle());
			CommChannelVoCollection voCommChannelColl = extPerVo.getCommChannels();

			GenForm.grdContactRow rowCommChannel;

			if (voCommChannelColl != null)
			{
				for (int i = 0; i < voCommChannelColl.size(); i++)
				{
					CommChannelVo voCommChannel = voCommChannelColl.get(i);
				 
					if (voCommChannel.getChannelTypeIsNotNull())
					{
						rowCommChannel = form.grdContact().getRows().newRow();
						rowCommChannel.setcolType(voCommChannel.getChannelType());
						rowCommChannel.setcolContactValue(voCommChannel.getCommValue());
						rowCommChannel.setValue(voCommChannel);
					}
				}

			}
		}
	}
	
	private void clearDetailControls() 
	{
		form.txtSurname().setValue("");
		form.txtForeName().setValue("");
		form.txtMiddleName().setValue("");
		form.cmbTitle().setValue(null);
		form.grdContact().getRows().clear();
	}	
	
	private void refreshLSH() 
	{
		clearDetailControls();
		clearMosTree();
		form.txtSName().setFocus();
	}
	
	private void clearMosTree() 
	{
		form.treExternalPerson().clear();		
	}
	protected void onTreExternalPersonTreeViewSelectionChanged(TreeNode node) throws PresentationLogicException 
	{
		if (node.getValue() instanceof ExternalPersonShortVo)
		{
			ExternalPersonShortVo voExtPer = (ExternalPersonShortVo) node.getValue();
			setContextVariables(voExtPer);
			populateScreenFromData(voExtPer);
		}
		else
		{
			clearDetailControls();
		}
	}
	protected void onImbClearClick() throws PresentationLogicException 
	{
		form.txtSName().setValue(null);
		refreshLSH();
	}
	protected void onImbSearchClick() throws PresentationLogicException 
	{
		populateExternalPersonTree();		
	}
	
}
