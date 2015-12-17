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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.60 build 2867.20478)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.securitytokenadmin;

import ims.admin.forms.securitytokenadmin.GenForm.grd1SecTokenRow;
import ims.admin.vo.SecurityTokenVoCollection;
import ims.core.admin.vo.SecurityTokenRefVo;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	public void open() 
	{
		form.grd1SecToken().getRows().clear();
		SecurityTokenVoCollection voColl = domain.listStTikens(null);
		if (voColl != null)
		{
			for (int i = 0; i < voColl.size(); i++)
			{
				grd1SecTokenRow row = form.grd1SecToken().getRows().newRow();
				row.setValue(voColl.get(i));
				row.setexpiration(voColl.get(i).getExpirationTimeStampIsNotNull()?voColl.get(i).getExpirationTimeStamp().toString():"");
				row.setsectoken(voColl.get(i).getTokenIDIsNotNull()?voColl.get(i).getTokenID():"");				
				if (voColl.get(i).getParamsIsNotNull())
				{
					String strTooltip;
					strTooltip = "";
					if (voColl.get(i).getParams().size() > 0)
					{
						strTooltip = "Security Paameters found.\r\n";
						for(int j = 0; j < voColl.get(i).getParams().size(); j++)
						{
							strTooltip += (voColl.get(i).getParams().get(j).getItemIsNotNull()?voColl.get(i).getParams().get(j).getItem() + "\r\n":"");							
							row.setTooltip(strTooltip);							
						}
					}
					else
						row.setTooltip("No SecurityToken parameters found.");
				}				
			}
		}
	}

	protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}

	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		if (menuItemID == form.getContextMenus().getAddRemoveItemsREMOVEITEMItem().getID())
		{
			deleteSecToken(form.grd1SecToken().getValue());
			open();
		}
	}

	private void deleteSecToken(SecurityTokenRefVo value) 
	{
		domain.deleteSecToken(value);
	}

	protected void onGrd1SecTokenSelectionChanged() throws PresentationLogicException 
	{
		form.getContextMenus().getAddRemoveItemsADDItem().setVisible(false);
		form.getContextMenus().getAddRemoveItemsREMOVEITEMItem().setVisible(true);
	}
}
