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

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class WeekInTheMonth extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public WeekInTheMonth()
	{
		super();
	}
	public WeekInTheMonth(int id)
	{
		super(id, "", true);
	}
	public WeekInTheMonth(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public WeekInTheMonth(int id, String text, boolean active, WeekInTheMonth parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public WeekInTheMonth(int id, String text, boolean active, WeekInTheMonth parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public WeekInTheMonth(int id, String text, boolean active, WeekInTheMonth parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static WeekInTheMonth buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new WeekInTheMonth(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (WeekInTheMonth)super.getParentInstance();
	}
	public WeekInTheMonth getParent()
	{
		return (WeekInTheMonth)super.getParentInstance();
	}
	public void setParent(WeekInTheMonth parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		WeekInTheMonth[] typedChildren = new WeekInTheMonth[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (WeekInTheMonth)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof WeekInTheMonth)
		{
			super.addChild((WeekInTheMonth)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof WeekInTheMonth)
		{
			super.removeChild((WeekInTheMonth)child);
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
		WeekInTheMonthCollection result = new WeekInTheMonthCollection();
		result.add(FIRST);
		result.add(SECOND);
		result.add(THIRD);
		result.add(FOURTH);
		result.add(FIFTH);
		return result;
	}
	public static WeekInTheMonth[] getNegativeInstances()
	{
		WeekInTheMonth[] instances = new WeekInTheMonth[5];
		instances[0] = FIRST;
		instances[1] = SECOND;
		instances[2] = THIRD;
		instances[3] = FOURTH;
		instances[4] = FIFTH;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[5];
		negativeInstances[0] = "FIRST";
		negativeInstances[1] = "SECOND";
		negativeInstances[2] = "THIRD";
		negativeInstances[3] = "FOURTH";
		negativeInstances[4] = "FIFTH";
		return negativeInstances;
	}
	public static WeekInTheMonth getNegativeInstance(String name)
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
	public static WeekInTheMonth getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		WeekInTheMonth[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341070;
	public static final WeekInTheMonth FIRST = new WeekInTheMonth(-3362, "First", true, null, null, Color.Default);
	public static final WeekInTheMonth SECOND = new WeekInTheMonth(-3363, "Second", true, null, null, Color.Default);
	public static final WeekInTheMonth THIRD = new WeekInTheMonth(-3364, "Third", true, null, null, Color.Default);
	public static final WeekInTheMonth FOURTH = new WeekInTheMonth(-3365, "Fourth", true, null, null, Color.Default);
	public static final WeekInTheMonth FIFTH = new WeekInTheMonth(-3366, "Fifth", true, null, null, Color.Default);
}
