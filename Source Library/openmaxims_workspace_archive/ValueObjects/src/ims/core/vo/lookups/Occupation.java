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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class Occupation extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public Occupation()
	{
		super();
	}
	public Occupation(int id)
	{
		super(id, "", true);
	}
	public Occupation(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public Occupation(int id, String text, boolean active, Occupation parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public Occupation(int id, String text, boolean active, Occupation parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public Occupation(int id, String text, boolean active, Occupation parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static Occupation buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new Occupation(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (Occupation)super.getParentInstance();
	}
	public Occupation getParent()
	{
		return (Occupation)super.getParentInstance();
	}
	public void setParent(Occupation parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		Occupation[] typedChildren = new Occupation[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (Occupation)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof Occupation)
		{
			super.addChild((Occupation)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof Occupation)
		{
			super.removeChild((Occupation)child);
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
		OccupationCollection result = new OccupationCollection();
		result.add(OTHER);
		return result;
	}
	public static Occupation[] getNegativeInstances()
	{
		Occupation[] instances = new Occupation[1];
		instances[0] = OTHER;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[1];
		negativeInstances[0] = "OTHER";
		return negativeInstances;
	}
	public static Occupation getNegativeInstance(String name)
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
	public static Occupation getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		Occupation[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 625;
	public static final Occupation OTHER = new Occupation(-712, "Other", true, null, null, Color.Default);
}
