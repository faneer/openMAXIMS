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

package ims.nursing.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AssessmentStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AssessmentStatus()
	{
		super();
	}
	public AssessmentStatus(int id)
	{
		super(id, "", true);
	}
	public AssessmentStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AssessmentStatus(int id, String text, boolean active, AssessmentStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AssessmentStatus(int id, String text, boolean active, AssessmentStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AssessmentStatus(int id, String text, boolean active, AssessmentStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AssessmentStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AssessmentStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AssessmentStatus)super.getParentInstance();
	}
	public AssessmentStatus getParent()
	{
		return (AssessmentStatus)super.getParentInstance();
	}
	public void setParent(AssessmentStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AssessmentStatus[] typedChildren = new AssessmentStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AssessmentStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AssessmentStatus)
		{
			super.addChild((AssessmentStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AssessmentStatus)
		{
			super.removeChild((AssessmentStatus)child);
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
		AssessmentStatusCollection result = new AssessmentStatusCollection();
		result.add(COMPLETE);
		result.add(ACTIVE);
		return result;
	}
	public static AssessmentStatus[] getNegativeInstances()
	{
		AssessmentStatus[] instances = new AssessmentStatus[2];
		instances[0] = COMPLETE;
		instances[1] = ACTIVE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "COMPLETE";
		negativeInstances[1] = "ACTIVE";
		return negativeInstances;
	}
	public static AssessmentStatus getNegativeInstance(String name)
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
	public static AssessmentStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AssessmentStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1211029;
	public static final AssessmentStatus COMPLETE = new AssessmentStatus(-8, "Complete", true, null, null, Color.Black);
	public static final AssessmentStatus ACTIVE = new AssessmentStatus(-34, "In Progress", true, null, null, Color.Black);
}
