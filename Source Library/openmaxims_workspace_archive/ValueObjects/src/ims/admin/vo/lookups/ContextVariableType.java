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

package ims.admin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ContextVariableType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ContextVariableType()
	{
		super();
	}
	public ContextVariableType(int id)
	{
		super(id, "", true);
	}
	public ContextVariableType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ContextVariableType(int id, String text, boolean active, ContextVariableType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ContextVariableType(int id, String text, boolean active, ContextVariableType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ContextVariableType(int id, String text, boolean active, ContextVariableType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ContextVariableType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ContextVariableType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ContextVariableType)super.getParentInstance();
	}
	public ContextVariableType getParent()
	{
		return (ContextVariableType)super.getParentInstance();
	}
	public void setParent(ContextVariableType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ContextVariableType[] typedChildren = new ContextVariableType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ContextVariableType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ContextVariableType)
		{
			super.addChild((ContextVariableType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ContextVariableType)
		{
			super.removeChild((ContextVariableType)child);
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
		ContextVariableTypeCollection result = new ContextVariableTypeCollection();
		result.add(GLOBAL);
		result.add(PERSISTENT_GLOBAL);
		result.add(LOCAL);
		return result;
	}
	public static ContextVariableType[] getNegativeInstances()
	{
		ContextVariableType[] instances = new ContextVariableType[3];
		instances[0] = GLOBAL;
		instances[1] = PERSISTENT_GLOBAL;
		instances[2] = LOCAL;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "GLOBAL";
		negativeInstances[1] = "PERSISTENT_GLOBAL";
		negativeInstances[2] = "LOCAL";
		return negativeInstances;
	}
	public static ContextVariableType getNegativeInstance(String name)
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
	public static ContextVariableType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ContextVariableType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031010;
	public static final ContextVariableType GLOBAL = new ContextVariableType(-1177, "Global", true, null, null, Color.Default);
	public static final ContextVariableType PERSISTENT_GLOBAL = new ContextVariableType(-1178, "Persistent Global", true, null, null, Color.Default);
	public static final ContextVariableType LOCAL = new ContextVariableType(-1179, "Local", true, null, null, Color.Default);
}
