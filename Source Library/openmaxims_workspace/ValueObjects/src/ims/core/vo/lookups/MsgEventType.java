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

public class MsgEventType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public MsgEventType()
	{
		super();
	}
	public MsgEventType(int id)
	{
		super(id, "", true);
	}
	public MsgEventType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public MsgEventType(int id, String text, boolean active, MsgEventType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public MsgEventType(int id, String text, boolean active, MsgEventType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public MsgEventType(int id, String text, boolean active, MsgEventType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static MsgEventType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new MsgEventType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (MsgEventType)super.getParentInstance();
	}
	public MsgEventType getParent()
	{
		return (MsgEventType)super.getParentInstance();
	}
	public void setParent(MsgEventType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		MsgEventType[] typedChildren = new MsgEventType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (MsgEventType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof MsgEventType)
		{
			super.addChild((MsgEventType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof MsgEventType)
		{
			super.removeChild((MsgEventType)child);
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
		MsgEventTypeCollection result = new MsgEventTypeCollection();
		result.add(A28);
		result.add(A31);
		result.add(A40);
		result.add(O20);
		result.add(O02);
		result.add(T02);
		result.add(A01);
		result.add(A08);
		result.add(A03);
		result.add(A11);
		result.add(A13);
		result.add(A47);
		return result;
	}
	public static MsgEventType[] getNegativeInstances()
	{
		MsgEventType[] instances = new MsgEventType[12];
		instances[0] = A28;
		instances[1] = A31;
		instances[2] = A40;
		instances[3] = O20;
		instances[4] = O02;
		instances[5] = T02;
		instances[6] = A01;
		instances[7] = A08;
		instances[8] = A03;
		instances[9] = A11;
		instances[10] = A13;
		instances[11] = A47;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[12];
		negativeInstances[0] = "A28";
		negativeInstances[1] = "A31";
		negativeInstances[2] = "A40";
		negativeInstances[3] = "O20";
		negativeInstances[4] = "O02";
		negativeInstances[5] = "T02";
		negativeInstances[6] = "A01";
		negativeInstances[7] = "A08";
		negativeInstances[8] = "A03";
		negativeInstances[9] = "A11";
		negativeInstances[10] = "A13";
		negativeInstances[11] = "A47";
		return negativeInstances;
	}
	public static MsgEventType getNegativeInstance(String name)
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
	public static MsgEventType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		MsgEventType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021260;
	public static final MsgEventType A28 = new MsgEventType(-1852, "A28", true, null, null, Color.Default);
	public static final MsgEventType A31 = new MsgEventType(-1853, "A31", true, null, null, Color.Default);
	public static final MsgEventType A40 = new MsgEventType(-1854, "A40", true, null, null, Color.Default);
	public static final MsgEventType O20 = new MsgEventType(-2142, "O20", true, null, null, Color.Default);
	public static final MsgEventType O02 = new MsgEventType(-2143, "O02", true, null, null, Color.Default);
	public static final MsgEventType T02 = new MsgEventType(-2149, "T02", true, null, null, Color.Default);
	public static final MsgEventType A01 = new MsgEventType(-2546, "A01", true, null, null, Color.Default);
	public static final MsgEventType A08 = new MsgEventType(-2547, "A08", true, null, null, Color.Default);
	public static final MsgEventType A03 = new MsgEventType(-2548, "A03", true, null, null, Color.Default);
	public static final MsgEventType A11 = new MsgEventType(-2549, "A11", true, null, null, Color.Default);
	public static final MsgEventType A13 = new MsgEventType(-2550, "A13", true, null, null, Color.Default);
	public static final MsgEventType A47 = new MsgEventType(-2551, "A47", true, null, null, Color.Default);
}