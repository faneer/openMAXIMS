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

public class DementiaWorklistStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public DementiaWorklistStatus()
	{
		super();
	}
	public DementiaWorklistStatus(int id)
	{
		super(id, "", true);
	}
	public DementiaWorklistStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public DementiaWorklistStatus(int id, String text, boolean active, DementiaWorklistStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public DementiaWorklistStatus(int id, String text, boolean active, DementiaWorklistStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public DementiaWorklistStatus(int id, String text, boolean active, DementiaWorklistStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static DementiaWorklistStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new DementiaWorklistStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (DementiaWorklistStatus)super.getParentInstance();
	}
	public DementiaWorklistStatus getParent()
	{
		return (DementiaWorklistStatus)super.getParentInstance();
	}
	public void setParent(DementiaWorklistStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		DementiaWorklistStatus[] typedChildren = new DementiaWorklistStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (DementiaWorklistStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof DementiaWorklistStatus)
		{
			super.addChild((DementiaWorklistStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof DementiaWorklistStatus)
		{
			super.removeChild((DementiaWorklistStatus)child);
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
		DementiaWorklistStatusCollection result = new DementiaWorklistStatusCollection();
		result.add(STEP_ONE_FIND_OUTSTANDING);
		result.add(STEP_TWO_ASSESS_INVESTIGATE_OUTSTANDING);
		result.add(COMPLETED);
		result.add(FOR_REFERRAL);
		result.add(EXCLUDED);
		result.add(RECENTLY_COMPLETED);
		result.add(RECENTLY_REFERRED);
		return result;
	}
	public static DementiaWorklistStatus[] getNegativeInstances()
	{
		DementiaWorklistStatus[] instances = new DementiaWorklistStatus[7];
		instances[0] = STEP_ONE_FIND_OUTSTANDING;
		instances[1] = STEP_TWO_ASSESS_INVESTIGATE_OUTSTANDING;
		instances[2] = COMPLETED;
		instances[3] = FOR_REFERRAL;
		instances[4] = EXCLUDED;
		instances[5] = RECENTLY_COMPLETED;
		instances[6] = RECENTLY_REFERRED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[7];
		negativeInstances[0] = "STEP_ONE_FIND_OUTSTANDING";
		negativeInstances[1] = "STEP_TWO_ASSESS_INVESTIGATE_OUTSTANDING";
		negativeInstances[2] = "COMPLETED";
		negativeInstances[3] = "FOR_REFERRAL";
		negativeInstances[4] = "EXCLUDED";
		negativeInstances[5] = "RECENTLY_COMPLETED";
		negativeInstances[6] = "RECENTLY_REFERRED";
		return negativeInstances;
	}
	public static DementiaWorklistStatus getNegativeInstance(String name)
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
	public static DementiaWorklistStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		DementiaWorklistStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021281;
	public static final DementiaWorklistStatus STEP_ONE_FIND_OUTSTANDING = new DementiaWorklistStatus(-2461, "Step 1 / Find Outstanding ", true, null, null, Color.Default);
	public static final DementiaWorklistStatus STEP_TWO_ASSESS_INVESTIGATE_OUTSTANDING = new DementiaWorklistStatus(-2462, "Step 2 / Assess & Investigate Outstanding", true, null, null, Color.Default);
	public static final DementiaWorklistStatus COMPLETED = new DementiaWorklistStatus(-2463, "Completed", true, null, null, Color.Default);
	public static final DementiaWorklistStatus FOR_REFERRAL = new DementiaWorklistStatus(-2464, "For Referral", true, null, null, Color.Default);
	public static final DementiaWorklistStatus EXCLUDED = new DementiaWorklistStatus(-2465, "Excluded", true, null, null, Color.Default);
	public static final DementiaWorklistStatus RECENTLY_COMPLETED = new DementiaWorklistStatus(-2754, "Recently Completed", true, null, null, Color.Default);
	public static final DementiaWorklistStatus RECENTLY_REFERRED = new DementiaWorklistStatus(-2755, "Recently Referred", true, null, null, Color.Default);
}
