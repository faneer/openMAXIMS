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

public class SplintCategory extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SplintCategory()
	{
		super();
	}
	public SplintCategory(int id)
	{
		super(id, "", true);
	}
	public SplintCategory(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SplintCategory(int id, String text, boolean active, SplintCategory parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SplintCategory(int id, String text, boolean active, SplintCategory parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SplintCategory(int id, String text, boolean active, SplintCategory parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SplintCategory buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SplintCategory(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SplintCategory)super.getParentInstance();
	}
	public SplintCategory getParent()
	{
		return (SplintCategory)super.getParentInstance();
	}
	public void setParent(SplintCategory parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SplintCategory[] typedChildren = new SplintCategory[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SplintCategory)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SplintCategory)
		{
			super.addChild((SplintCategory)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SplintCategory)
		{
			super.removeChild((SplintCategory)child);
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
		SplintCategoryCollection result = new SplintCategoryCollection();
		result.add(CUSTOMISED);
		result.add(COMBINED);
		result.add(COMMERCIAL);
		return result;
	}
	public static SplintCategory[] getNegativeInstances()
	{
		SplintCategory[] instances = new SplintCategory[3];
		instances[0] = CUSTOMISED;
		instances[1] = COMBINED;
		instances[2] = COMMERCIAL;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "CUSTOMISED";
		negativeInstances[1] = "COMBINED";
		negativeInstances[2] = "COMMERCIAL";
		return negativeInstances;
	}
	public static SplintCategory getNegativeInstance(String name)
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
	public static SplintCategory getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SplintCategory[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1041;
	public static final SplintCategory CUSTOMISED = new SplintCategory(-727, "Customised", true, null, null, Color.Default);
	public static final SplintCategory COMBINED = new SplintCategory(-728, "Combined", true, null, null, Color.Default);
	public static final SplintCategory COMMERCIAL = new SplintCategory(-729, "Commercial", true, null, null, Color.Default);
}
