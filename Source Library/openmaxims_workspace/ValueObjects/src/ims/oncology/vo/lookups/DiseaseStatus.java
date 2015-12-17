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

package ims.oncology.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class DiseaseStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public DiseaseStatus()
	{
		super();
	}
	public DiseaseStatus(int id)
	{
		super(id, "", true);
	}
	public DiseaseStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public DiseaseStatus(int id, String text, boolean active, DiseaseStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public DiseaseStatus(int id, String text, boolean active, DiseaseStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public DiseaseStatus(int id, String text, boolean active, DiseaseStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static DiseaseStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new DiseaseStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (DiseaseStatus)super.getParentInstance();
	}
	public DiseaseStatus getParent()
	{
		return (DiseaseStatus)super.getParentInstance();
	}
	public void setParent(DiseaseStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		DiseaseStatus[] typedChildren = new DiseaseStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (DiseaseStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof DiseaseStatus)
		{
			super.addChild((DiseaseStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof DiseaseStatus)
		{
			super.removeChild((DiseaseStatus)child);
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
		DiseaseStatusCollection result = new DiseaseStatusCollection();
		result.add(PRIMARY_DISEASE);
		result.add(SECONDARY_DISEASE);
		result.add(RECURRENT_DISEASE);
		return result;
	}
	public static DiseaseStatus[] getNegativeInstances()
	{
		DiseaseStatus[] instances = new DiseaseStatus[3];
		instances[0] = PRIMARY_DISEASE;
		instances[1] = SECONDARY_DISEASE;
		instances[2] = RECURRENT_DISEASE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "PRIMARY_DISEASE";
		negativeInstances[1] = "SECONDARY_DISEASE";
		negativeInstances[2] = "RECURRENT_DISEASE";
		return negativeInstances;
	}
	public static DiseaseStatus getNegativeInstance(String name)
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
	public static DiseaseStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		DiseaseStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1251101;
	public static final DiseaseStatus PRIMARY_DISEASE = new DiseaseStatus(-2353, "Primary Disease", true, null, null, Color.Default);
	public static final DiseaseStatus SECONDARY_DISEASE = new DiseaseStatus(-2354, "Secondary Disease", true, null, null, Color.Default);
	public static final DiseaseStatus RECURRENT_DISEASE = new DiseaseStatus(-2355, "Recurrent Disease", true, null, null, Color.Default);
}
