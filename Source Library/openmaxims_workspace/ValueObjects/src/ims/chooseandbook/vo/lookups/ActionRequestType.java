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

package ims.chooseandbook.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ActionRequestType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ActionRequestType()
	{
		super();
	}
	public ActionRequestType(int id)
	{
		super(id, "", true);
	}
	public ActionRequestType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ActionRequestType(int id, String text, boolean active, ActionRequestType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ActionRequestType(int id, String text, boolean active, ActionRequestType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ActionRequestType(int id, String text, boolean active, ActionRequestType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ActionRequestType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ActionRequestType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ActionRequestType)super.getParentInstance();
	}
	public ActionRequestType getParent()
	{
		return (ActionRequestType)super.getParentInstance();
	}
	public void setParent(ActionRequestType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ActionRequestType[] typedChildren = new ActionRequestType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ActionRequestType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ActionRequestType)
		{
			super.addChild((ActionRequestType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ActionRequestType)
		{
			super.removeChild((ActionRequestType)child);
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
		ActionRequestTypeCollection result = new ActionRequestTypeCollection();
		result.add(SLOTS_LIST);
		result.add(NOTIFY_DNA);
		result.add(NOTIFY_APPT_CANCEL);
		result.add(NOTIFY_SLOT_CANCEL);
		return result;
	}
	public static ActionRequestType[] getNegativeInstances()
	{
		ActionRequestType[] instances = new ActionRequestType[4];
		instances[0] = SLOTS_LIST;
		instances[1] = NOTIFY_DNA;
		instances[2] = NOTIFY_APPT_CANCEL;
		instances[3] = NOTIFY_SLOT_CANCEL;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "SLOTS_LIST";
		negativeInstances[1] = "NOTIFY_DNA";
		negativeInstances[2] = "NOTIFY_APPT_CANCEL";
		negativeInstances[3] = "NOTIFY_SLOT_CANCEL";
		return negativeInstances;
	}
	public static ActionRequestType getNegativeInstance(String name)
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
	public static ActionRequestType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ActionRequestType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1001006;
	public static final ActionRequestType SLOTS_LIST = new ActionRequestType(-578, "Available Slots", true, null, null, Color.Default);
	public static final ActionRequestType NOTIFY_DNA = new ActionRequestType(-579, "Notify DNA", true, null, null, Color.Default);
	public static final ActionRequestType NOTIFY_APPT_CANCEL = new ActionRequestType(-580, "Notify Appt Cancel", true, null, null, Color.Default);
	public static final ActionRequestType NOTIFY_SLOT_CANCEL = new ActionRequestType(-581, "Notify Slot Cancel", true, null, null, Color.Default);
}
