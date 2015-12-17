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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ProcedureHighCostDrug extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ProcedureHighCostDrug()
	{
		super();
	}
	public ProcedureHighCostDrug(int id)
	{
		super(id, "", true);
	}
	public ProcedureHighCostDrug(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ProcedureHighCostDrug(int id, String text, boolean active, ProcedureHighCostDrug parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ProcedureHighCostDrug(int id, String text, boolean active, ProcedureHighCostDrug parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ProcedureHighCostDrug(int id, String text, boolean active, ProcedureHighCostDrug parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ProcedureHighCostDrug buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ProcedureHighCostDrug(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ProcedureHighCostDrug)super.getParentInstance();
	}
	public ProcedureHighCostDrug getParent()
	{
		return (ProcedureHighCostDrug)super.getParentInstance();
	}
	public void setParent(ProcedureHighCostDrug parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ProcedureHighCostDrug[] typedChildren = new ProcedureHighCostDrug[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ProcedureHighCostDrug)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ProcedureHighCostDrug)
		{
			super.addChild((ProcedureHighCostDrug)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ProcedureHighCostDrug)
		{
			super.removeChild((ProcedureHighCostDrug)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		ProcedureHighCostDrugCollection result = new ProcedureHighCostDrugCollection();
		result.add(FNA_BREAST_SEROMA_OR_LESION);
		result.add(PERCUTANEOUS_BIOPSY_OF_BREAST_LESION);
		return result;
	}
	public static ProcedureHighCostDrug[] getNegativeInstances()
	{
		ProcedureHighCostDrug[] instances = new ProcedureHighCostDrug[2];
		instances[0] = FNA_BREAST_SEROMA_OR_LESION;
		instances[1] = PERCUTANEOUS_BIOPSY_OF_BREAST_LESION;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "FNA_BREAST_SEROMA_OR_LESION";
		negativeInstances[1] = "PERCUTANEOUS_BIOPSY_OF_BREAST_LESION";
		return negativeInstances;
	}
	public static ProcedureHighCostDrug getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static ProcedureHighCostDrug getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ProcedureHighCostDrug[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1231096;
	public static final ProcedureHighCostDrug FNA_BREAST_SEROMA_OR_LESION = new ProcedureHighCostDrug(-1807, "FNA breast seroma or lesion", true, null, null, Color.Default);
	public static final ProcedureHighCostDrug PERCUTANEOUS_BIOPSY_OF_BREAST_LESION = new ProcedureHighCostDrug(-1808, "Percutaneous biopsy of breast lesion", true, null, null, Color.Default);
}
