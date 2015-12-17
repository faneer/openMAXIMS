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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class TimeUnitsSecondsToYears extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TimeUnitsSecondsToYears()
	{
		super();
	}
	public TimeUnitsSecondsToYears(int id)
	{
		super(id, "", true);
	}
	public TimeUnitsSecondsToYears(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TimeUnitsSecondsToYears(int id, String text, boolean active, TimeUnitsSecondsToYears parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TimeUnitsSecondsToYears(int id, String text, boolean active, TimeUnitsSecondsToYears parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TimeUnitsSecondsToYears(int id, String text, boolean active, TimeUnitsSecondsToYears parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TimeUnitsSecondsToYears buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TimeUnitsSecondsToYears(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TimeUnitsSecondsToYears)super.getParentInstance();
	}
	public TimeUnitsSecondsToYears getParent()
	{
		return (TimeUnitsSecondsToYears)super.getParentInstance();
	}
	public void setParent(TimeUnitsSecondsToYears parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TimeUnitsSecondsToYears[] typedChildren = new TimeUnitsSecondsToYears[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TimeUnitsSecondsToYears)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TimeUnitsSecondsToYears)
		{
			super.addChild((TimeUnitsSecondsToYears)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TimeUnitsSecondsToYears)
		{
			super.removeChild((TimeUnitsSecondsToYears)child);
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
		TimeUnitsSecondsToYearsCollection result = new TimeUnitsSecondsToYearsCollection();
		result.add(YEARS);
		result.add(MONTHS);
		result.add(WEEKS);
		result.add(DAYS);
		result.add(HOURS);
		result.add(MINUTES);
		result.add(SECONDS);
		return result;
	}
	public static TimeUnitsSecondsToYears[] getNegativeInstances()
	{
		TimeUnitsSecondsToYears[] instances = new TimeUnitsSecondsToYears[7];
		instances[0] = YEARS;
		instances[1] = MONTHS;
		instances[2] = WEEKS;
		instances[3] = DAYS;
		instances[4] = HOURS;
		instances[5] = MINUTES;
		instances[6] = SECONDS;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[7];
		negativeInstances[0] = "YEARS";
		negativeInstances[1] = "MONTHS";
		negativeInstances[2] = "WEEKS";
		negativeInstances[3] = "DAYS";
		negativeInstances[4] = "HOURS";
		negativeInstances[5] = "MINUTES";
		negativeInstances[6] = "SECONDS";
		return negativeInstances;
	}
	public static TimeUnitsSecondsToYears getNegativeInstance(String name)
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
	public static TimeUnitsSecondsToYears getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TimeUnitsSecondsToYears[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021390;
	public static final TimeUnitsSecondsToYears YEARS = new TimeUnitsSecondsToYears(-3370, "Years", true, null, null, Color.Default);
	public static final TimeUnitsSecondsToYears MONTHS = new TimeUnitsSecondsToYears(-3371, "Months", true, null, null, Color.Default);
	public static final TimeUnitsSecondsToYears WEEKS = new TimeUnitsSecondsToYears(-3372, "Weeks", true, null, null, Color.Default);
	public static final TimeUnitsSecondsToYears DAYS = new TimeUnitsSecondsToYears(-3373, "Days", true, null, null, Color.Default);
	public static final TimeUnitsSecondsToYears HOURS = new TimeUnitsSecondsToYears(-3374, "Hours", true, null, null, Color.Default);
	public static final TimeUnitsSecondsToYears MINUTES = new TimeUnitsSecondsToYears(-3375, "Minutes", true, null, null, Color.Default);
	public static final TimeUnitsSecondsToYears SECONDS = new TimeUnitsSecondsToYears(-3376, "Seconds", true, null, null, Color.Default);
}
