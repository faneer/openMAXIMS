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

public class ContextVariableValType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ContextVariableValType()
	{
		super();
	}
	public ContextVariableValType(int id)
	{
		super(id, "", true);
	}
	public ContextVariableValType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ContextVariableValType(int id, String text, boolean active, ContextVariableValType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ContextVariableValType(int id, String text, boolean active, ContextVariableValType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ContextVariableValType(int id, String text, boolean active, ContextVariableValType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ContextVariableValType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ContextVariableValType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ContextVariableValType)super.getParentInstance();
	}
	public ContextVariableValType getParent()
	{
		return (ContextVariableValType)super.getParentInstance();
	}
	public void setParent(ContextVariableValType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ContextVariableValType[] typedChildren = new ContextVariableValType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ContextVariableValType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ContextVariableValType)
		{
			super.addChild((ContextVariableValType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ContextVariableValType)
		{
			super.removeChild((ContextVariableValType)child);
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
		ContextVariableValTypeCollection result = new ContextVariableValTypeCollection();
		result.add(BUSINESS_OBJECT);
		result.add(LOOKUP_INSTANCE);
		result.add(LOOKUP_TYPE);
		result.add(SIMPLE);
		return result;
	}
	public static ContextVariableValType[] getNegativeInstances()
	{
		ContextVariableValType[] instances = new ContextVariableValType[4];
		instances[0] = BUSINESS_OBJECT;
		instances[1] = LOOKUP_INSTANCE;
		instances[2] = LOOKUP_TYPE;
		instances[3] = SIMPLE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "BUSINESS_OBJECT";
		negativeInstances[1] = "LOOKUP_INSTANCE";
		negativeInstances[2] = "LOOKUP_TYPE";
		negativeInstances[3] = "SIMPLE";
		return negativeInstances;
	}
	public static ContextVariableValType getNegativeInstance(String name)
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
	public static ContextVariableValType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ContextVariableValType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031011;
	public static final ContextVariableValType BUSINESS_OBJECT = new ContextVariableValType(-1180, "Business Object", true, null, null, Color.Default);
	public static final ContextVariableValType LOOKUP_INSTANCE = new ContextVariableValType(-1181, "Lookup Instance", true, null, null, Color.Default);
	public static final ContextVariableValType LOOKUP_TYPE = new ContextVariableValType(-1182, "Lookup Type", true, null, null, Color.Default);
	public static final ContextVariableValType SIMPLE = new ContextVariableValType(-1183, "Simple", true, null, null, Color.Default);
}
