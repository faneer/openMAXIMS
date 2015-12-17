// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ReferralNoteType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReferralNoteType()
	{
		super();
	}
	public ReferralNoteType(int id)
	{
		super(id, "", true);
	}
	public ReferralNoteType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReferralNoteType(int id, String text, boolean active, ReferralNoteType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReferralNoteType(int id, String text, boolean active, ReferralNoteType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReferralNoteType(int id, String text, boolean active, ReferralNoteType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReferralNoteType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReferralNoteType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReferralNoteType)super.getParentInstance();
	}
	public ReferralNoteType getParent()
	{
		return (ReferralNoteType)super.getParentInstance();
	}
	public void setParent(ReferralNoteType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReferralNoteType[] typedChildren = new ReferralNoteType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReferralNoteType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReferralNoteType)
		{
			super.addChild((ReferralNoteType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReferralNoteType)
		{
			super.removeChild((ReferralNoteType)child);
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
		ReferralNoteTypeCollection result = new ReferralNoteTypeCollection();
		result.add(CLINICAL);
		result.add(NON_CLINICAL);
		return result;
	}
	public static ReferralNoteType[] getNegativeInstances()
	{
		ReferralNoteType[] instances = new ReferralNoteType[2];
		instances[0] = CLINICAL;
		instances[1] = NON_CLINICAL;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "CLINICAL";
		negativeInstances[1] = "NON_CLINICAL";
		return negativeInstances;
	}
	public static ReferralNoteType getNegativeInstance(String name)
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
	public static ReferralNoteType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReferralNoteType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341018;
	public static final ReferralNoteType CLINICAL = new ReferralNoteType(-1672, "Clinical", true, null, null, Color.Default);
	public static final ReferralNoteType NON_CLINICAL = new ReferralNoteType(-1673, "NON_CLINICAL", true, null, null, Color.Default);
}
