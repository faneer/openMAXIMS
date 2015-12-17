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

public class ElectiveAdmissionStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ElectiveAdmissionStatus()
	{
		super();
	}
	public ElectiveAdmissionStatus(int id)
	{
		super(id, "", true);
	}
	public ElectiveAdmissionStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ElectiveAdmissionStatus(int id, String text, boolean active, ElectiveAdmissionStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ElectiveAdmissionStatus(int id, String text, boolean active, ElectiveAdmissionStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ElectiveAdmissionStatus(int id, String text, boolean active, ElectiveAdmissionStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ElectiveAdmissionStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ElectiveAdmissionStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ElectiveAdmissionStatus)super.getParentInstance();
	}
	public ElectiveAdmissionStatus getParent()
	{
		return (ElectiveAdmissionStatus)super.getParentInstance();
	}
	public void setParent(ElectiveAdmissionStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ElectiveAdmissionStatus[] typedChildren = new ElectiveAdmissionStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ElectiveAdmissionStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ElectiveAdmissionStatus)
		{
			super.addChild((ElectiveAdmissionStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ElectiveAdmissionStatus)
		{
			super.removeChild((ElectiveAdmissionStatus)child);
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
		ElectiveAdmissionStatusCollection result = new ElectiveAdmissionStatusCollection();
		result.add(TCI);
		result.add(ADMITTED);
		result.add(CANCELLED);
		return result;
	}
	public static ElectiveAdmissionStatus[] getNegativeInstances()
	{
		ElectiveAdmissionStatus[] instances = new ElectiveAdmissionStatus[3];
		instances[0] = TCI;
		instances[1] = ADMITTED;
		instances[2] = CANCELLED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "TCI";
		negativeInstances[1] = "ADMITTED";
		negativeInstances[2] = "CANCELLED";
		return negativeInstances;
	}
	public static ElectiveAdmissionStatus getNegativeInstance(String name)
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
	public static ElectiveAdmissionStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ElectiveAdmissionStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021234;
	public static final ElectiveAdmissionStatus TCI = new ElectiveAdmissionStatus(-1631, "TCI", true, null, null, Color.Default);
	public static final ElectiveAdmissionStatus ADMITTED = new ElectiveAdmissionStatus(-1632, "Admitted", true, null, null, Color.Default);
	public static final ElectiveAdmissionStatus CANCELLED = new ElectiveAdmissionStatus(-1633, "Cancelled", true, null, null, Color.Default);
}
