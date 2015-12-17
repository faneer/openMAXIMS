// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class TCIStatusChangeReason extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TCIStatusChangeReason()
	{
		super();
	}
	public TCIStatusChangeReason(int id)
	{
		super(id, "", true);
	}
	public TCIStatusChangeReason(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TCIStatusChangeReason(int id, String text, boolean active, TCIStatusChangeReason parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TCIStatusChangeReason(int id, String text, boolean active, TCIStatusChangeReason parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TCIStatusChangeReason(int id, String text, boolean active, TCIStatusChangeReason parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TCIStatusChangeReason buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TCIStatusChangeReason(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TCIStatusChangeReason)super.getParentInstance();
	}
	public TCIStatusChangeReason getParent()
	{
		return (TCIStatusChangeReason)super.getParentInstance();
	}
	public void setParent(TCIStatusChangeReason parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TCIStatusChangeReason[] typedChildren = new TCIStatusChangeReason[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TCIStatusChangeReason)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TCIStatusChangeReason)
		{
			super.addChild((TCIStatusChangeReason)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TCIStatusChangeReason)
		{
			super.removeChild((TCIStatusChangeReason)child);
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
		TCIStatusChangeReasonCollection result = new TCIStatusChangeReasonCollection();
		result.add(LINKEDTHEATREAPPTCANCELLED);
		result.add(CANCELLEDBYREMOVALOFELECTIVELISTRECORD);
		return result;
	}
	public static TCIStatusChangeReason[] getNegativeInstances()
	{
		TCIStatusChangeReason[] instances = new TCIStatusChangeReason[2];
		instances[0] = LINKEDTHEATREAPPTCANCELLED;
		instances[1] = CANCELLEDBYREMOVALOFELECTIVELISTRECORD;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "LINKEDTHEATREAPPTCANCELLED";
		negativeInstances[1] = "CANCELLEDBYREMOVALOFELECTIVELISTRECORD";
		return negativeInstances;
	}
	public static TCIStatusChangeReason getNegativeInstance(String name)
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
	public static TCIStatusChangeReason getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TCIStatusChangeReason[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341041;
	public static final TCIStatusChangeReason LINKEDTHEATREAPPTCANCELLED = new TCIStatusChangeReason(-2626, "Associated Theatre appointment Cancelled", true, null, null, Color.Default);
	public static final TCIStatusChangeReason CANCELLEDBYREMOVALOFELECTIVELISTRECORD = new TCIStatusChangeReason(-2632, "Cancelled as Elective List Record was Removed", true, null, null, Color.Default);
}
