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

package ims.admin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class WardDeptCategory extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public WardDeptCategory()
	{
		super();
	}
	public WardDeptCategory(int id)
	{
		super(id, "", true);
	}
	public WardDeptCategory(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public WardDeptCategory(int id, String text, boolean active, WardDeptCategory parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public WardDeptCategory(int id, String text, boolean active, WardDeptCategory parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public WardDeptCategory(int id, String text, boolean active, WardDeptCategory parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static WardDeptCategory buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new WardDeptCategory(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (WardDeptCategory)super.getParentInstance();
	}
	public WardDeptCategory getParent()
	{
		return (WardDeptCategory)super.getParentInstance();
	}
	public void setParent(WardDeptCategory parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		WardDeptCategory[] typedChildren = new WardDeptCategory[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (WardDeptCategory)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof WardDeptCategory)
		{
			super.addChild((WardDeptCategory)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof WardDeptCategory)
		{
			super.removeChild((WardDeptCategory)child);
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
		WardDeptCategoryCollection result = new WardDeptCategoryCollection();
		return result;
	}
	public static WardDeptCategory[] getNegativeInstances()
	{
		return new WardDeptCategory[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static WardDeptCategory getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static WardDeptCategory getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		// No negative instances found
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1031041;
}
