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

public class HospitalAtNightPatientStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public HospitalAtNightPatientStatus()
	{
		super();
	}
	public HospitalAtNightPatientStatus(int id)
	{
		super(id, "", true);
	}
	public HospitalAtNightPatientStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public HospitalAtNightPatientStatus(int id, String text, boolean active, HospitalAtNightPatientStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public HospitalAtNightPatientStatus(int id, String text, boolean active, HospitalAtNightPatientStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public HospitalAtNightPatientStatus(int id, String text, boolean active, HospitalAtNightPatientStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static HospitalAtNightPatientStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new HospitalAtNightPatientStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (HospitalAtNightPatientStatus)super.getParentInstance();
	}
	public HospitalAtNightPatientStatus getParent()
	{
		return (HospitalAtNightPatientStatus)super.getParentInstance();
	}
	public void setParent(HospitalAtNightPatientStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		HospitalAtNightPatientStatus[] typedChildren = new HospitalAtNightPatientStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (HospitalAtNightPatientStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof HospitalAtNightPatientStatus)
		{
			super.addChild((HospitalAtNightPatientStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof HospitalAtNightPatientStatus)
		{
			super.removeChild((HospitalAtNightPatientStatus)child);
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
		HospitalAtNightPatientStatusCollection result = new HospitalAtNightPatientStatusCollection();
		result.add(NEW);
		result.add(ACTIVE);
		result.add(REMOVE_FROM_LIST);
		return result;
	}
	public static HospitalAtNightPatientStatus[] getNegativeInstances()
	{
		HospitalAtNightPatientStatus[] instances = new HospitalAtNightPatientStatus[3];
		instances[0] = NEW;
		instances[1] = ACTIVE;
		instances[2] = REMOVE_FROM_LIST;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "NEW";
		negativeInstances[1] = "ACTIVE";
		negativeInstances[2] = "REMOVE_FROM_LIST";
		return negativeInstances;
	}
	public static HospitalAtNightPatientStatus getNegativeInstance(String name)
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
	public static HospitalAtNightPatientStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		HospitalAtNightPatientStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231121;
	public static final HospitalAtNightPatientStatus NEW = new HospitalAtNightPatientStatus(-2185, "New", true, null, null, Color.Default);
	public static final HospitalAtNightPatientStatus ACTIVE = new HospitalAtNightPatientStatus(-2186, "Active", true, null, null, Color.Default);
	public static final HospitalAtNightPatientStatus REMOVE_FROM_LIST = new HospitalAtNightPatientStatus(-2187, "Remove From List", true, null, null, Color.Default);
}
