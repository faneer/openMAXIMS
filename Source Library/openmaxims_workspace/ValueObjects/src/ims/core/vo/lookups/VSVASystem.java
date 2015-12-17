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

public class VSVASystem extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public VSVASystem()
	{
		super();
	}
	public VSVASystem(int id)
	{
		super(id, "", true);
	}
	public VSVASystem(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public VSVASystem(int id, String text, boolean active, VSVASystem parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public VSVASystem(int id, String text, boolean active, VSVASystem parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public VSVASystem(int id, String text, boolean active, VSVASystem parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static VSVASystem buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new VSVASystem(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (VSVASystem)super.getParentInstance();
	}
	public VSVASystem getParent()
	{
		return (VSVASystem)super.getParentInstance();
	}
	public void setParent(VSVASystem parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		VSVASystem[] typedChildren = new VSVASystem[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (VSVASystem)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof VSVASystem)
		{
			super.addChild((VSVASystem)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof VSVASystem)
		{
			super.removeChild((VSVASystem)child);
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
		VSVASystemCollection result = new VSVASystemCollection();
		result.add(SNELLEN);
		result.add(LOGMAR);
		return result;
	}
	public static VSVASystem[] getNegativeInstances()
	{
		VSVASystem[] instances = new VSVASystem[2];
		instances[0] = SNELLEN;
		instances[1] = LOGMAR;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "SNELLEN";
		negativeInstances[1] = "LOGMAR";
		return negativeInstances;
	}
	public static VSVASystem getNegativeInstance(String name)
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
	public static VSVASystem getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		VSVASystem[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021061;
	public static final VSVASystem SNELLEN = new VSVASystem(-71, "Snellen", true, null, null, Color.Black);
	public static final VSVASystem LOGMAR = new VSVASystem(-80, "Logmar", true, null, null, Color.Black);
}
