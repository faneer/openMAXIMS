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

package ims.pathways.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class RTTClockState extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public RTTClockState()
	{
		super();
	}
	public RTTClockState(int id)
	{
		super(id, "", true);
	}
	public RTTClockState(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public RTTClockState(int id, String text, boolean active, RTTClockState parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public RTTClockState(int id, String text, boolean active, RTTClockState parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public RTTClockState(int id, String text, boolean active, RTTClockState parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static RTTClockState buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new RTTClockState(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (RTTClockState)super.getParentInstance();
	}
	public RTTClockState getParent()
	{
		return (RTTClockState)super.getParentInstance();
	}
	public void setParent(RTTClockState parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		RTTClockState[] typedChildren = new RTTClockState[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (RTTClockState)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof RTTClockState)
		{
			super.addChild((RTTClockState)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof RTTClockState)
		{
			super.removeChild((RTTClockState)child);
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
		RTTClockStateCollection result = new RTTClockStateCollection();
		result.add(NOT_PRESENT);
		result.add(STARTED);
		result.add(STOPPED);
		return result;
	}
	public static RTTClockState[] getNegativeInstances()
	{
		RTTClockState[] instances = new RTTClockState[3];
		instances[0] = NOT_PRESENT;
		instances[1] = STARTED;
		instances[2] = STOPPED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "NOT_PRESENT";
		negativeInstances[1] = "STARTED";
		negativeInstances[2] = "STOPPED";
		return negativeInstances;
	}
	public static RTTClockState getNegativeInstance(String name)
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
	public static RTTClockState getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		RTTClockState[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1321021;
	public static final RTTClockState NOT_PRESENT = new RTTClockState(-3035, "Not Present", true, null, null, Color.Default);
	public static final RTTClockState STARTED = new RTTClockState(-3036, "Started", true, null, null, Color.Default);
	public static final RTTClockState STOPPED = new RTTClockState(-3037, "Stopped", true, null, null, Color.Default);
}
