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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.53 build 2592.27837)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.selectlookupinstances;

import ims.framework.cn.data.TreeNode;
import ims.framework.controls.TreeNodeCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.vo.lookups.LookupHelper;
import ims.ocrr.vo.lookups.SpecimenSite;
import ims.ocrr.vo.lookups.SpecimenSiteCollection;
import ims.vo.LookupInstanceCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open()
	{
		LookupInstanceCollection collSelected = form.getGlobalContext().Core.getSelectedLookupInstances();
		loadTree(collSelected);
	}
	
	private void loadTree(LookupInstanceCollection collSelected)
	{
		ims.framework.cn.data.TreeNode[] nodes = null;
		if(form.getGlobalContext().Core.getSelectLookupType().getId() == SpecimenSite.TYPE_ID)
		{
			SpecimenSiteCollection collSites = LookupHelper.getSpecimenSite(domain.getLookupService());
			nodes = collSites.getRootNodes();
		}
			
		populateTree(nodes, null, collSelected);	
	}
	
	private void populateTree(TreeNode[] collAvailable, ims.framework.controls.TreeNode parentNode, LookupInstanceCollection collSelected)
	{
		if (collAvailable == null)
			return;

		for (int i = 0; i < collAvailable.length; i++)
		{
			SpecimenSite site = (SpecimenSite) collAvailable[i];
			
			ims.framework.controls.TreeNode itemNode = null;
			if (parentNode == null)
				itemNode = form.treInstances().getNodes().add(site, site.getText());
			else
				itemNode = parentNode.getNodes().add(site, site.getText());
			
			if(collSelected.indexOf(site) > -1)
			{
				itemNode.setChecked(true);
				if(itemNode.getParent() != null)
					itemNode.getParent().setChecked(true);
			}
				
		
			populateTree(collAvailable[i].getChildren(), itemNode, collSelected);
		}
	}

	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setSelectedLookupInstances(retrieveSelection(form.treInstances().getNodes(), new SpecimenSiteCollection()));
		engine.close(DialogResult.OK);
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private SpecimenSiteCollection retrieveSelection(TreeNodeCollection collection, SpecimenSiteCollection collSelected)
	{			
		for(int i=0;i<collection.size();i++)
		{
			ims.framework.controls.TreeNode node = collection.get(i);
			if(node.isChecked() && (node.getNodes() == null || node.getNodes().size() == 0))
				collSelected.add((SpecimenSite) node.getValue());
			
			retrieveSelection(node.getNodes(), collSelected);
		}
		
		return collSelected;
	}

	protected void onTreInstancesTreeViewCheck(ims.framework.controls.TreeNode node) throws PresentationLogicException
	{
		if(node.getNodes() != null)
		{
			for(int i=0;i<node.getNodes().size();i++)
			{
				node.getNodes().get(i).setChecked(node.isChecked());
			}
		}
	}
}
