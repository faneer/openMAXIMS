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

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class Site extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public Site()
	{
		super();
	}
	public Site(int id)
	{
		super(id, "", true);
	}
	public Site(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public Site(int id, String text, boolean active, Site parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public Site(int id, String text, boolean active, Site parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public Site(int id, String text, boolean active, Site parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static Site buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new Site(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (Site)super.getParentInstance();
	}
	public Site getParent()
	{
		return (Site)super.getParentInstance();
	}
	public void setParent(Site parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		Site[] typedChildren = new Site[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (Site)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof Site)
		{
			super.addChild((Site)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof Site)
		{
			super.removeChild((Site)child);
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
		SiteCollection result = new SiteCollection();
		result.add(NOTAPPLICABLE);
		result.add(OTHER);
		return result;
	}
	public static Site[] getNegativeInstances()
	{
		Site[] instances = new Site[2];
		instances[0] = NOTAPPLICABLE;
		instances[1] = OTHER;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "NOTAPPLICABLE";
		negativeInstances[1] = "OTHER";
		return negativeInstances;
	}
	public static Site getNegativeInstance(String name)
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
	public static Site getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		Site[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231021;
	public static final Site NOTAPPLICABLE = new Site(-809, "Not Applicable", true, null, null, Color.Default);
	public static final Site OTHER = new Site(-810, "Other", true, null, null, Color.Default);
}
