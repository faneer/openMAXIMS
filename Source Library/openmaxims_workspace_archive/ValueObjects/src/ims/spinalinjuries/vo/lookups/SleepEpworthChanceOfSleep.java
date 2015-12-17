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

package ims.spinalinjuries.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class SleepEpworthChanceOfSleep extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SleepEpworthChanceOfSleep()
	{
		super();
	}
	public SleepEpworthChanceOfSleep(int id)
	{
		super(id, "", true);
	}
	public SleepEpworthChanceOfSleep(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SleepEpworthChanceOfSleep(int id, String text, boolean active, SleepEpworthChanceOfSleep parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SleepEpworthChanceOfSleep(int id, String text, boolean active, SleepEpworthChanceOfSleep parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SleepEpworthChanceOfSleep(int id, String text, boolean active, SleepEpworthChanceOfSleep parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SleepEpworthChanceOfSleep buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SleepEpworthChanceOfSleep(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SleepEpworthChanceOfSleep)super.getParentInstance();
	}
	public SleepEpworthChanceOfSleep getParent()
	{
		return (SleepEpworthChanceOfSleep)super.getParentInstance();
	}
	public void setParent(SleepEpworthChanceOfSleep parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SleepEpworthChanceOfSleep[] typedChildren = new SleepEpworthChanceOfSleep[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SleepEpworthChanceOfSleep)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SleepEpworthChanceOfSleep)
		{
			super.addChild((SleepEpworthChanceOfSleep)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SleepEpworthChanceOfSleep)
		{
			super.removeChild((SleepEpworthChanceOfSleep)child);
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
		SleepEpworthChanceOfSleepCollection result = new SleepEpworthChanceOfSleepCollection();
		result.add(NEVER_DOZE);
		result.add(SLIGHT_CHANCE);
		result.add(MODERATE_CHANCE);
		result.add(HIGH_CHANCE);
		return result;
	}
	public static SleepEpworthChanceOfSleep[] getNegativeInstances()
	{
		SleepEpworthChanceOfSleep[] instances = new SleepEpworthChanceOfSleep[4];
		instances[0] = NEVER_DOZE;
		instances[1] = SLIGHT_CHANCE;
		instances[2] = MODERATE_CHANCE;
		instances[3] = HIGH_CHANCE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "NEVER_DOZE";
		negativeInstances[1] = "SLIGHT_CHANCE";
		negativeInstances[2] = "MODERATE_CHANCE";
		negativeInstances[3] = "HIGH_CHANCE";
		return negativeInstances;
	}
	public static SleepEpworthChanceOfSleep getNegativeInstance(String name)
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
	public static SleepEpworthChanceOfSleep getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SleepEpworthChanceOfSleep[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1051168;
	public static final SleepEpworthChanceOfSleep NEVER_DOZE = new SleepEpworthChanceOfSleep(-705, "0 = Would never doze", true, null, null, Color.Default);
	public static final SleepEpworthChanceOfSleep SLIGHT_CHANCE = new SleepEpworthChanceOfSleep(-706, "1 = Slight chance of dozing", true, null, null, Color.Default);
	public static final SleepEpworthChanceOfSleep MODERATE_CHANCE = new SleepEpworthChanceOfSleep(-707, "2 = Moderate chance of dozing", true, null, null, Color.Default);
	public static final SleepEpworthChanceOfSleep HIGH_CHANCE = new SleepEpworthChanceOfSleep(-708, "3 = High chance of dozing", true, null, null, Color.Default);
}
