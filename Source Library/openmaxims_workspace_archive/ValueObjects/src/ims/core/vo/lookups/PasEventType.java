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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PasEventType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PasEventType()
	{
		super();
	}
	public PasEventType(int id)
	{
		super(id, "", true);
	}
	public PasEventType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PasEventType(int id, String text, boolean active, PasEventType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PasEventType(int id, String text, boolean active, PasEventType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PasEventType(int id, String text, boolean active, PasEventType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PasEventType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PasEventType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PasEventType)super.getParentInstance();
	}
	public PasEventType getParent()
	{
		return (PasEventType)super.getParentInstance();
	}
	public void setParent(PasEventType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PasEventType[] typedChildren = new PasEventType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PasEventType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PasEventType)
		{
			super.addChild((PasEventType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PasEventType)
		{
			super.removeChild((PasEventType)child);
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
		PasEventTypeCollection result = new PasEventTypeCollection();
		result.add(INPATIENT);
		result.add(OUTPATIENT);
		result.add(EMERGENCY);
		result.add(TCI);
		return result;
	}
	public static PasEventType[] getNegativeInstances()
	{
		PasEventType[] instances = new PasEventType[4];
		instances[0] = INPATIENT;
		instances[1] = OUTPATIENT;
		instances[2] = EMERGENCY;
		instances[3] = TCI;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "INPATIENT";
		negativeInstances[1] = "OUTPATIENT";
		negativeInstances[2] = "EMERGENCY";
		negativeInstances[3] = "TCI";
		return negativeInstances;
	}
	public static PasEventType getNegativeInstance(String name)
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
	public static PasEventType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PasEventType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021186;
	public static final PasEventType INPATIENT = new PasEventType(-1184, "Inpatient", true, null, null, Color.Default);
	public static final PasEventType OUTPATIENT = new PasEventType(-1185, "Outpatient", true, null, null, Color.Default);
	public static final PasEventType EMERGENCY = new PasEventType(-1622, "Emergency", true, null, null, Color.Default);
	public static final PasEventType TCI = new PasEventType(-1623, "TCI", true, null, null, Color.Default);
}
