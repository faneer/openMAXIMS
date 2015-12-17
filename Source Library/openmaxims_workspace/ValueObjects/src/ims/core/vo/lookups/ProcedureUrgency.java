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

public class ProcedureUrgency extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ProcedureUrgency()
	{
		super();
	}
	public ProcedureUrgency(int id)
	{
		super(id, "", true);
	}
	public ProcedureUrgency(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ProcedureUrgency(int id, String text, boolean active, ProcedureUrgency parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ProcedureUrgency(int id, String text, boolean active, ProcedureUrgency parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ProcedureUrgency(int id, String text, boolean active, ProcedureUrgency parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ProcedureUrgency buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ProcedureUrgency(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ProcedureUrgency)super.getParentInstance();
	}
	public ProcedureUrgency getParent()
	{
		return (ProcedureUrgency)super.getParentInstance();
	}
	public void setParent(ProcedureUrgency parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ProcedureUrgency[] typedChildren = new ProcedureUrgency[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ProcedureUrgency)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ProcedureUrgency)
		{
			super.addChild((ProcedureUrgency)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ProcedureUrgency)
		{
			super.removeChild((ProcedureUrgency)child);
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
		ProcedureUrgencyCollection result = new ProcedureUrgencyCollection();
		result.add(EMERGENCY);
		result.add(ELECTIVE);
		return result;
	}
	public static ProcedureUrgency[] getNegativeInstances()
	{
		ProcedureUrgency[] instances = new ProcedureUrgency[2];
		instances[0] = EMERGENCY;
		instances[1] = ELECTIVE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "EMERGENCY";
		negativeInstances[1] = "ELECTIVE";
		return negativeInstances;
	}
	public static ProcedureUrgency getNegativeInstance(String name)
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
	public static ProcedureUrgency getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ProcedureUrgency[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021161;
	public static final ProcedureUrgency EMERGENCY = new ProcedureUrgency(-1870, "Emergency", true, null, null, Color.Default);
	public static final ProcedureUrgency ELECTIVE = new ProcedureUrgency(-1871, "Elective", true, null, null, Color.Default);
}
