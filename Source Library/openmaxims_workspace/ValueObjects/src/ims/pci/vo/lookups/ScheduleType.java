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

package ims.pci.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ScheduleType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ScheduleType()
	{
		super();
	}
	public ScheduleType(int id)
	{
		super(id, "", true);
	}
	public ScheduleType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ScheduleType(int id, String text, boolean active, ScheduleType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ScheduleType(int id, String text, boolean active, ScheduleType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ScheduleType(int id, String text, boolean active, ScheduleType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ScheduleType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ScheduleType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ScheduleType)super.getParentInstance();
	}
	public ScheduleType getParent()
	{
		return (ScheduleType)super.getParentInstance();
	}
	public void setParent(ScheduleType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ScheduleType[] typedChildren = new ScheduleType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ScheduleType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ScheduleType)
		{
			super.addChild((ScheduleType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ScheduleType)
		{
			super.removeChild((ScheduleType)child);
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
		ScheduleTypeCollection result = new ScheduleTypeCollection();
		result.add(PCISCHEDULE);
		result.add(OUTBREAKSCHEDULE);
		result.add(INVALIDVACCINESCHEDULE);
		return result;
	}
	public static ScheduleType[] getNegativeInstances()
	{
		ScheduleType[] instances = new ScheduleType[3];
		instances[0] = PCISCHEDULE;
		instances[1] = OUTBREAKSCHEDULE;
		instances[2] = INVALIDVACCINESCHEDULE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "PCISCHEDULE";
		negativeInstances[1] = "OUTBREAKSCHEDULE";
		negativeInstances[2] = "INVALIDVACCINESCHEDULE";
		return negativeInstances;
	}
	public static ScheduleType getNegativeInstance(String name)
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
	public static ScheduleType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ScheduleType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1331014;
	public static final ScheduleType PCISCHEDULE = new ScheduleType(-1472, "PCI Schedule", true, null, null, Color.Default);
	public static final ScheduleType OUTBREAKSCHEDULE = new ScheduleType(-1473, "Outbreak Schedule", true, null, null, Color.Default);
	public static final ScheduleType INVALIDVACCINESCHEDULE = new ScheduleType(-1474, "Invalid Vaccine Schedule", true, null, null, Color.Default);
}
