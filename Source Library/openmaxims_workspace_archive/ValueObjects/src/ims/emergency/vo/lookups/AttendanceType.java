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

package ims.emergency.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AttendanceType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AttendanceType()
	{
		super();
	}
	public AttendanceType(int id)
	{
		super(id, "", true);
	}
	public AttendanceType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AttendanceType(int id, String text, boolean active, AttendanceType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AttendanceType(int id, String text, boolean active, AttendanceType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AttendanceType(int id, String text, boolean active, AttendanceType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AttendanceType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AttendanceType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AttendanceType)super.getParentInstance();
	}
	public AttendanceType getParent()
	{
		return (AttendanceType)super.getParentInstance();
	}
	public void setParent(AttendanceType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AttendanceType[] typedChildren = new AttendanceType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AttendanceType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AttendanceType)
		{
			super.addChild((AttendanceType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AttendanceType)
		{
			super.removeChild((AttendanceType)child);
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
		AttendanceTypeCollection result = new AttendanceTypeCollection();
		result.add(FIRST);
		result.add(SCHEDULED);
		result.add(UNSCHEDULED);
		return result;
	}
	public static AttendanceType[] getNegativeInstances()
	{
		AttendanceType[] instances = new AttendanceType[3];
		instances[0] = FIRST;
		instances[1] = SCHEDULED;
		instances[2] = UNSCHEDULED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "FIRST";
		negativeInstances[1] = "SCHEDULED";
		negativeInstances[2] = "UNSCHEDULED";
		return negativeInstances;
	}
	public static AttendanceType getNegativeInstance(String name)
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
	public static AttendanceType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AttendanceType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1291007;
	public static final AttendanceType FIRST = new AttendanceType(-1198, "First Visit", true, null, null, Color.Default);
	public static final AttendanceType SCHEDULED = new AttendanceType(-1199, "Scheduled Return", true, null, null, Color.Default);
	public static final AttendanceType UNSCHEDULED = new AttendanceType(-1200, "Unscheduled", true, null, null, Color.Default);
}
