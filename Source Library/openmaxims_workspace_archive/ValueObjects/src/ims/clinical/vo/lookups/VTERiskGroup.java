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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class VTERiskGroup extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public VTERiskGroup()
	{
		super();
	}
	public VTERiskGroup(int id)
	{
		super(id, "", true);
	}
	public VTERiskGroup(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public VTERiskGroup(int id, String text, boolean active, VTERiskGroup parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public VTERiskGroup(int id, String text, boolean active, VTERiskGroup parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public VTERiskGroup(int id, String text, boolean active, VTERiskGroup parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static VTERiskGroup buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new VTERiskGroup(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (VTERiskGroup)super.getParentInstance();
	}
	public VTERiskGroup getParent()
	{
		return (VTERiskGroup)super.getParentInstance();
	}
	public void setParent(VTERiskGroup parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		VTERiskGroup[] typedChildren = new VTERiskGroup[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (VTERiskGroup)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof VTERiskGroup)
		{
			super.addChild((VTERiskGroup)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof VTERiskGroup)
		{
			super.removeChild((VTERiskGroup)child);
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
		VTERiskGroupCollection result = new VTERiskGroupCollection();
		result.add(HIGH_RISK_LOW_BLEEDING);
		result.add(HIGH_RISK_SIGNIFICANT_BLEEDING);
		result.add(NO_SIGNIFICANT_INCREASE);
		return result;
	}
	public static VTERiskGroup[] getNegativeInstances()
	{
		VTERiskGroup[] instances = new VTERiskGroup[3];
		instances[0] = HIGH_RISK_LOW_BLEEDING;
		instances[1] = HIGH_RISK_SIGNIFICANT_BLEEDING;
		instances[2] = NO_SIGNIFICANT_INCREASE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "HIGH_RISK_LOW_BLEEDING";
		negativeInstances[1] = "HIGH_RISK_SIGNIFICANT_BLEEDING";
		negativeInstances[2] = "NO_SIGNIFICANT_INCREASE";
		return negativeInstances;
	}
	public static VTERiskGroup getNegativeInstance(String name)
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
	public static VTERiskGroup getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		VTERiskGroup[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231123;
	public static final VTERiskGroup HIGH_RISK_LOW_BLEEDING = new VTERiskGroup(-2253, "High Risk of VTE with low bleeding Risk", true, null, null, Color.Default);
	public static final VTERiskGroup HIGH_RISK_SIGNIFICANT_BLEEDING = new VTERiskGroup(-2254, "High risk of VTE with significant bleeding Risk", true, null, null, Color.Default);
	public static final VTERiskGroup NO_SIGNIFICANT_INCREASE = new VTERiskGroup(-2255, "No significant increase in VTE Risk", true, null, null, Color.Default);
}
