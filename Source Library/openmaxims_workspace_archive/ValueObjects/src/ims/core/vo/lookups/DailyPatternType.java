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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class DailyPatternType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public DailyPatternType()
	{
		super();
	}
	public DailyPatternType(int id)
	{
		super(id, "", true);
	}
	public DailyPatternType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public DailyPatternType(int id, String text, boolean active, DailyPatternType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public DailyPatternType(int id, String text, boolean active, DailyPatternType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public DailyPatternType(int id, String text, boolean active, DailyPatternType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static DailyPatternType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new DailyPatternType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (DailyPatternType)super.getParentInstance();
	}
	public DailyPatternType getParent()
	{
		return (DailyPatternType)super.getParentInstance();
	}
	public void setParent(DailyPatternType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		DailyPatternType[] typedChildren = new DailyPatternType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (DailyPatternType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof DailyPatternType)
		{
			super.addChild((DailyPatternType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof DailyPatternType)
		{
			super.removeChild((DailyPatternType)child);
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
		DailyPatternTypeCollection result = new DailyPatternTypeCollection();
		result.add(FLUIDBALANCE);
		return result;
	}
	public static DailyPatternType[] getNegativeInstances()
	{
		DailyPatternType[] instances = new DailyPatternType[1];
		instances[0] = FLUIDBALANCE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[1];
		negativeInstances[0] = "FLUIDBALANCE";
		return negativeInstances;
	}
	public static DailyPatternType getNegativeInstance(String name)
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
	public static DailyPatternType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		DailyPatternType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021171;
	public static final DailyPatternType FLUIDBALANCE = new DailyPatternType(-929, "Fluid Balance", true, null, null, Color.Default);
}
