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

package ims.pathways.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class EventCreationType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public EventCreationType()
	{
		super();
	}
	public EventCreationType(int id)
	{
		super(id, "", true);
	}
	public EventCreationType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public EventCreationType(int id, String text, boolean active, EventCreationType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public EventCreationType(int id, String text, boolean active, EventCreationType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public EventCreationType(int id, String text, boolean active, EventCreationType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static EventCreationType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new EventCreationType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (EventCreationType)super.getParentInstance();
	}
	public EventCreationType getParent()
	{
		return (EventCreationType)super.getParentInstance();
	}
	public void setParent(EventCreationType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		EventCreationType[] typedChildren = new EventCreationType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (EventCreationType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof EventCreationType)
		{
			super.addChild((EventCreationType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof EventCreationType)
		{
			super.removeChild((EventCreationType)child);
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
		EventCreationTypeCollection result = new EventCreationTypeCollection();
		result.add(EXTERNAL);
		result.add(INTERNAL);
		result.add(BOTH);
		return result;
	}
	public static EventCreationType[] getNegativeInstances()
	{
		EventCreationType[] instances = new EventCreationType[3];
		instances[0] = EXTERNAL;
		instances[1] = INTERNAL;
		instances[2] = BOTH;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "EXTERNAL";
		negativeInstances[1] = "INTERNAL";
		negativeInstances[2] = "BOTH";
		return negativeInstances;
	}
	public static EventCreationType getNegativeInstance(String name)
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
	public static EventCreationType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		EventCreationType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1321008;
	public static final EventCreationType EXTERNAL = new EventCreationType(-1340, "External", true, null, null, Color.Default);
	public static final EventCreationType INTERNAL = new EventCreationType(-1341, "Internal", true, null, null, Color.Default);
	public static final EventCreationType BOTH = new EventCreationType(-1342, "Both", true, null, null, Color.Default);
}
