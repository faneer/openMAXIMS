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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class YesNoNotApplicable extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public YesNoNotApplicable()
	{
		super();
	}
	public YesNoNotApplicable(int id)
	{
		super(id, "", true);
	}
	public YesNoNotApplicable(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public YesNoNotApplicable(int id, String text, boolean active, YesNoNotApplicable parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public YesNoNotApplicable(int id, String text, boolean active, YesNoNotApplicable parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public YesNoNotApplicable(int id, String text, boolean active, YesNoNotApplicable parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static YesNoNotApplicable buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new YesNoNotApplicable(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (YesNoNotApplicable)super.getParentInstance();
	}
	public YesNoNotApplicable getParent()
	{
		return (YesNoNotApplicable)super.getParentInstance();
	}
	public void setParent(YesNoNotApplicable parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		YesNoNotApplicable[] typedChildren = new YesNoNotApplicable[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (YesNoNotApplicable)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof YesNoNotApplicable)
		{
			super.addChild((YesNoNotApplicable)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof YesNoNotApplicable)
		{
			super.removeChild((YesNoNotApplicable)child);
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
		YesNoNotApplicableCollection result = new YesNoNotApplicableCollection();
		result.add(YES);
		result.add(NO);
		result.add(NOTAPPLICABLE);
		return result;
	}
	public static YesNoNotApplicable[] getNegativeInstances()
	{
		YesNoNotApplicable[] instances = new YesNoNotApplicable[3];
		instances[0] = YES;
		instances[1] = NO;
		instances[2] = NOTAPPLICABLE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "YES";
		negativeInstances[1] = "NO";
		negativeInstances[2] = "NOTAPPLICABLE";
		return negativeInstances;
	}
	public static YesNoNotApplicable getNegativeInstance(String name)
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
	public static YesNoNotApplicable getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		YesNoNotApplicable[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021377;
	public static final YesNoNotApplicable YES = new YesNoNotApplicable(-3291, "Yes", true, null, null, Color.Default);
	public static final YesNoNotApplicable NO = new YesNoNotApplicable(-3292, "No", true, null, null, Color.Default);
	public static final YesNoNotApplicable NOTAPPLICABLE = new YesNoNotApplicable(-3293, "Not Applicable", true, null, null, Color.Default);
}
