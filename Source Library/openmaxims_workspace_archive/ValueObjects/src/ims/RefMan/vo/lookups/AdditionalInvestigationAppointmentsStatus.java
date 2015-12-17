// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AdditionalInvestigationAppointmentsStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AdditionalInvestigationAppointmentsStatus()
	{
		super();
	}
	public AdditionalInvestigationAppointmentsStatus(int id)
	{
		super(id, "", true);
	}
	public AdditionalInvestigationAppointmentsStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AdditionalInvestigationAppointmentsStatus(int id, String text, boolean active, AdditionalInvestigationAppointmentsStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AdditionalInvestigationAppointmentsStatus(int id, String text, boolean active, AdditionalInvestigationAppointmentsStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AdditionalInvestigationAppointmentsStatus(int id, String text, boolean active, AdditionalInvestigationAppointmentsStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AdditionalInvestigationAppointmentsStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AdditionalInvestigationAppointmentsStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AdditionalInvestigationAppointmentsStatus)super.getParentInstance();
	}
	public AdditionalInvestigationAppointmentsStatus getParent()
	{
		return (AdditionalInvestigationAppointmentsStatus)super.getParentInstance();
	}
	public void setParent(AdditionalInvestigationAppointmentsStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AdditionalInvestigationAppointmentsStatus[] typedChildren = new AdditionalInvestigationAppointmentsStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AdditionalInvestigationAppointmentsStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AdditionalInvestigationAppointmentsStatus)
		{
			super.addChild((AdditionalInvestigationAppointmentsStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AdditionalInvestigationAppointmentsStatus)
		{
			super.removeChild((AdditionalInvestigationAppointmentsStatus)child);
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
		AdditionalInvestigationAppointmentsStatusCollection result = new AdditionalInvestigationAppointmentsStatusCollection();
		result.add(NONE);
		result.add(ALLBOOKED);
		result.add(TOBEBOOKED);
		result.add(DNA);
		return result;
	}
	public static AdditionalInvestigationAppointmentsStatus[] getNegativeInstances()
	{
		AdditionalInvestigationAppointmentsStatus[] instances = new AdditionalInvestigationAppointmentsStatus[4];
		instances[0] = NONE;
		instances[1] = ALLBOOKED;
		instances[2] = TOBEBOOKED;
		instances[3] = DNA;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "NONE";
		negativeInstances[1] = "ALLBOOKED";
		negativeInstances[2] = "TOBEBOOKED";
		negativeInstances[3] = "DNA";
		return negativeInstances;
	}
	public static AdditionalInvestigationAppointmentsStatus getNegativeInstance(String name)
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
	public static AdditionalInvestigationAppointmentsStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AdditionalInvestigationAppointmentsStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341007;
	public static final AdditionalInvestigationAppointmentsStatus NONE = new AdditionalInvestigationAppointmentsStatus(-1524, "None", true, null, null, Color.Default);
	public static final AdditionalInvestigationAppointmentsStatus ALLBOOKED = new AdditionalInvestigationAppointmentsStatus(-1525, "All Additional appointments Booked", true, null, null, Color.Default);
	public static final AdditionalInvestigationAppointmentsStatus TOBEBOOKED = new AdditionalInvestigationAppointmentsStatus(-1526, "To be Booked", true, null, null, Color.Default);
	public static final AdditionalInvestigationAppointmentsStatus DNA = new AdditionalInvestigationAppointmentsStatus(-1527, "DNA", true, null, null, Color.Default);
}
