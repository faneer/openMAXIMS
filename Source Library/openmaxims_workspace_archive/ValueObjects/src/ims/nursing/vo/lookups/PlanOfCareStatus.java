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

public class PlanOfCareStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PlanOfCareStatus()
	{
		super();
	}
	public PlanOfCareStatus(int id)
	{
		super(id, "", true);
	}
	public PlanOfCareStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PlanOfCareStatus(int id, String text, boolean active, PlanOfCareStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PlanOfCareStatus(int id, String text, boolean active, PlanOfCareStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PlanOfCareStatus(int id, String text, boolean active, PlanOfCareStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PlanOfCareStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PlanOfCareStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PlanOfCareStatus)super.getParentInstance();
	}
	public PlanOfCareStatus getParent()
	{
		return (PlanOfCareStatus)super.getParentInstance();
	}
	public void setParent(PlanOfCareStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PlanOfCareStatus[] typedChildren = new PlanOfCareStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PlanOfCareStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PlanOfCareStatus)
		{
			super.addChild((PlanOfCareStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PlanOfCareStatus)
		{
			super.removeChild((PlanOfCareStatus)child);
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
		PlanOfCareStatusCollection result = new PlanOfCareStatusCollection();
		result.add(ACTIVE);
		result.add(RESOLVED);
		result.add(REQUIRES_CONFIRMATION);
		result.add(CURRENT);
		return result;
	}
	public static PlanOfCareStatus[] getNegativeInstances()
	{
		PlanOfCareStatus[] instances = new PlanOfCareStatus[4];
		instances[0] = ACTIVE;
		instances[1] = RESOLVED;
		instances[2] = REQUIRES_CONFIRMATION;
		instances[3] = CURRENT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "ACTIVE";
		negativeInstances[1] = "RESOLVED";
		negativeInstances[2] = "REQUIRES_CONFIRMATION";
		negativeInstances[3] = "CURRENT";
		return negativeInstances;
	}
	public static PlanOfCareStatus getNegativeInstance(String name)
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
	public static PlanOfCareStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PlanOfCareStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1001069;
	public static final PlanOfCareStatus ACTIVE = new PlanOfCareStatus(-1089, "Active", true, null, null, Color.Default);
	public static final PlanOfCareStatus RESOLVED = new PlanOfCareStatus(-1090, "Resolved", true, null, null, Color.Default);
	public static final PlanOfCareStatus REQUIRES_CONFIRMATION = new PlanOfCareStatus(-1091, "Requires Confirmation", true, null, null, Color.Default);
	public static final PlanOfCareStatus CURRENT = new PlanOfCareStatus(-1136, "Current", true, null, null, Color.Default);
}
