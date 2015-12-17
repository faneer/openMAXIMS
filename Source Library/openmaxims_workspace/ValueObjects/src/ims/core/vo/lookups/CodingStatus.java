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

public class CodingStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public CodingStatus()
	{
		super();
	}
	public CodingStatus(int id)
	{
		super(id, "", true);
	}
	public CodingStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public CodingStatus(int id, String text, boolean active, CodingStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public CodingStatus(int id, String text, boolean active, CodingStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public CodingStatus(int id, String text, boolean active, CodingStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static CodingStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new CodingStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (CodingStatus)super.getParentInstance();
	}
	public CodingStatus getParent()
	{
		return (CodingStatus)super.getParentInstance();
	}
	public void setParent(CodingStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		CodingStatus[] typedChildren = new CodingStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (CodingStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof CodingStatus)
		{
			super.addChild((CodingStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof CodingStatus)
		{
			super.removeChild((CodingStatus)child);
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
		CodingStatusCollection result = new CodingStatusCollection();
		result.add(CODED);
		result.add(UNCODED);
		result.add(INPROGRESS);
		result.add(FORREVIEW);
		result.add(AMENDMENTRECEIVED);
		return result;
	}
	public static CodingStatus[] getNegativeInstances()
	{
		CodingStatus[] instances = new CodingStatus[5];
		instances[0] = CODED;
		instances[1] = UNCODED;
		instances[2] = INPROGRESS;
		instances[3] = FORREVIEW;
		instances[4] = AMENDMENTRECEIVED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[5];
		negativeInstances[0] = "CODED";
		negativeInstances[1] = "UNCODED";
		negativeInstances[2] = "INPROGRESS";
		negativeInstances[3] = "FORREVIEW";
		negativeInstances[4] = "AMENDMENTRECEIVED";
		return negativeInstances;
	}
	public static CodingStatus getNegativeInstance(String name)
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
	public static CodingStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		CodingStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021321;
	public static final CodingStatus CODED = new CodingStatus(-2982, "Coded", true, null, null, Color.Default);
	public static final CodingStatus UNCODED = new CodingStatus(-2983, "Uncoded", true, null, null, Color.Default);
	public static final CodingStatus INPROGRESS = new CodingStatus(-2984, "In Progress", true, null, null, Color.Default);
	public static final CodingStatus FORREVIEW = new CodingStatus(-2985, "For Review", true, null, null, Color.Default);
	public static final CodingStatus AMENDMENTRECEIVED = new CodingStatus(-3008, "Amendment Received", true, null, null, Color.Default);
}
