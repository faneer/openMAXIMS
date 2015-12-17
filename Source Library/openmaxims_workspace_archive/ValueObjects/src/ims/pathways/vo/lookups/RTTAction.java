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

public class RTTAction extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public RTTAction()
	{
		super();
	}
	public RTTAction(int id)
	{
		super(id, "", true);
	}
	public RTTAction(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public RTTAction(int id, String text, boolean active, RTTAction parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public RTTAction(int id, String text, boolean active, RTTAction parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public RTTAction(int id, String text, boolean active, RTTAction parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static RTTAction buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new RTTAction(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (RTTAction)super.getParentInstance();
	}
	public RTTAction getParent()
	{
		return (RTTAction)super.getParentInstance();
	}
	public void setParent(RTTAction parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		RTTAction[] typedChildren = new RTTAction[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (RTTAction)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof RTTAction)
		{
			super.addChild((RTTAction)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof RTTAction)
		{
			super.removeChild((RTTAction)child);
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
		RTTActionCollection result = new RTTActionCollection();
		result.add(ONE);
		result.add(TWO);
		result.add(THREE);
		result.add(FOUR);
		result.add(FIVE);
		return result;
	}
	public static RTTAction[] getNegativeInstances()
	{
		RTTAction[] instances = new RTTAction[5];
		instances[0] = ONE;
		instances[1] = TWO;
		instances[2] = THREE;
		instances[3] = FOUR;
		instances[4] = FIVE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[5];
		negativeInstances[0] = "ONE";
		negativeInstances[1] = "TWO";
		negativeInstances[2] = "THREE";
		negativeInstances[3] = "FOUR";
		negativeInstances[4] = "FIVE";
		return negativeInstances;
	}
	public static RTTAction getNegativeInstance(String name)
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
	public static RTTAction getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		RTTAction[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1321003;
	public static final RTTAction ONE = new RTTAction(-1317, "1", true, null, null, Color.Default);
	public static final RTTAction TWO = new RTTAction(-1318, "2", true, null, null, Color.Default);
	public static final RTTAction THREE = new RTTAction(-1319, "3", true, null, null, Color.Default);
	public static final RTTAction FOUR = new RTTAction(-1320, "4", true, null, null, Color.Default);
	public static final RTTAction FIVE = new RTTAction(-1321, "5", true, null, null, Color.Default);
}
