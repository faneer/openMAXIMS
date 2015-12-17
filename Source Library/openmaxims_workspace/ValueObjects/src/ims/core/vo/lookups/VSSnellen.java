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

public class VSSnellen extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public VSSnellen()
	{
		super();
	}
	public VSSnellen(int id)
	{
		super(id, "", true);
	}
	public VSSnellen(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public VSSnellen(int id, String text, boolean active, VSSnellen parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public VSSnellen(int id, String text, boolean active, VSSnellen parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public VSSnellen(int id, String text, boolean active, VSSnellen parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static VSSnellen buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new VSSnellen(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (VSSnellen)super.getParentInstance();
	}
	public VSSnellen getParent()
	{
		return (VSSnellen)super.getParentInstance();
	}
	public void setParent(VSSnellen parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		VSSnellen[] typedChildren = new VSSnellen[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (VSSnellen)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof VSSnellen)
		{
			super.addChild((VSSnellen)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof VSSnellen)
		{
			super.removeChild((VSSnellen)child);
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
		VSSnellenCollection result = new VSSnellenCollection();
		result.add(VAL6_3);
		result.add(VAL6_4);
		return result;
	}
	public static VSSnellen[] getNegativeInstances()
	{
		VSSnellen[] instances = new VSSnellen[2];
		instances[0] = VAL6_3;
		instances[1] = VAL6_4;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "VAL6_3";
		negativeInstances[1] = "VAL6_4";
		return negativeInstances;
	}
	public static VSSnellen getNegativeInstance(String name)
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
	public static VSSnellen getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		VSSnellen[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021060;
	public static final VSSnellen VAL6_3 = new VSSnellen(-69, "6/3", true, null, null, Color.Black);
	public static final VSSnellen VAL6_4 = new VSSnellen(-70, "6/4", true, null, null, Color.Black);
}
