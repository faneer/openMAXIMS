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

package ims.spinalinjuries.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class MSKSenstionModality extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public MSKSenstionModality()
	{
		super();
	}
	public MSKSenstionModality(int id)
	{
		super(id, "", true);
	}
	public MSKSenstionModality(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public MSKSenstionModality(int id, String text, boolean active, MSKSenstionModality parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public MSKSenstionModality(int id, String text, boolean active, MSKSenstionModality parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public MSKSenstionModality(int id, String text, boolean active, MSKSenstionModality parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static MSKSenstionModality buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new MSKSenstionModality(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (MSKSenstionModality)super.getParentInstance();
	}
	public MSKSenstionModality getParent()
	{
		return (MSKSenstionModality)super.getParentInstance();
	}
	public void setParent(MSKSenstionModality parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		MSKSenstionModality[] typedChildren = new MSKSenstionModality[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (MSKSenstionModality)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof MSKSenstionModality)
		{
			super.addChild((MSKSenstionModality)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof MSKSenstionModality)
		{
			super.removeChild((MSKSenstionModality)child);
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
		MSKSenstionModalityCollection result = new MSKSenstionModalityCollection();
		result.add(PINPRICK);
		result.add(LIGHTTOUCH);
		return result;
	}
	public static MSKSenstionModality[] getNegativeInstances()
	{
		MSKSenstionModality[] instances = new MSKSenstionModality[2];
		instances[0] = PINPRICK;
		instances[1] = LIGHTTOUCH;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "PINPRICK";
		negativeInstances[1] = "LIGHTTOUCH";
		return negativeInstances;
	}
	public static MSKSenstionModality getNegativeInstance(String name)
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
	public static MSKSenstionModality getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		MSKSenstionModality[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1051132;
	public static final MSKSenstionModality PINPRICK = new MSKSenstionModality(-226, "Pin-Prick", true, null, null, Color.Default);
	public static final MSKSenstionModality LIGHTTOUCH = new MSKSenstionModality(-227, "Light-Touch", true, null, null, Color.Default);
}
