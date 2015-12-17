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

public class EDischargeSummarySection extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public EDischargeSummarySection()
	{
		super();
	}
	public EDischargeSummarySection(int id)
	{
		super(id, "", true);
	}
	public EDischargeSummarySection(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public EDischargeSummarySection(int id, String text, boolean active, EDischargeSummarySection parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public EDischargeSummarySection(int id, String text, boolean active, EDischargeSummarySection parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public EDischargeSummarySection(int id, String text, boolean active, EDischargeSummarySection parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static EDischargeSummarySection buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new EDischargeSummarySection(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (EDischargeSummarySection)super.getParentInstance();
	}
	public EDischargeSummarySection getParent()
	{
		return (EDischargeSummarySection)super.getParentInstance();
	}
	public void setParent(EDischargeSummarySection parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		EDischargeSummarySection[] typedChildren = new EDischargeSummarySection[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (EDischargeSummarySection)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof EDischargeSummarySection)
		{
			super.addChild((EDischargeSummarySection)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof EDischargeSummarySection)
		{
			super.removeChild((EDischargeSummarySection)child);
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
		EDischargeSummarySectionCollection result = new EDischargeSummarySectionCollection();
		result.add(DIAGNOSIS);
		result.add(CLINICALINFO);
		result.add(OPERATIONS_AND_PROCS);
		result.add(NEONATAL);
		result.add(PLASTICS);
		result.add(MEDICATIONONADMISSION);
		result.add(FUTURE_PLAN);
		result.add(READY_TO_LEAVE);
		result.add(SUPPLEMENTARY);
		return result;
	}
	public static EDischargeSummarySection[] getNegativeInstances()
	{
		EDischargeSummarySection[] instances = new EDischargeSummarySection[9];
		instances[0] = DIAGNOSIS;
		instances[1] = CLINICALINFO;
		instances[2] = OPERATIONS_AND_PROCS;
		instances[3] = NEONATAL;
		instances[4] = PLASTICS;
		instances[5] = MEDICATIONONADMISSION;
		instances[6] = FUTURE_PLAN;
		instances[7] = READY_TO_LEAVE;
		instances[8] = SUPPLEMENTARY;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[9];
		negativeInstances[0] = "DIAGNOSIS";
		negativeInstances[1] = "CLINICALINFO";
		negativeInstances[2] = "OPERATIONS_AND_PROCS";
		negativeInstances[3] = "NEONATAL";
		negativeInstances[4] = "PLASTICS";
		negativeInstances[5] = "MEDICATIONONADMISSION";
		negativeInstances[6] = "FUTURE_PLAN";
		negativeInstances[7] = "READY_TO_LEAVE";
		negativeInstances[8] = "SUPPLEMENTARY";
		return negativeInstances;
	}
	public static EDischargeSummarySection getNegativeInstance(String name)
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
	public static EDischargeSummarySection getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		EDischargeSummarySection[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231114;
	public static final EDischargeSummarySection DIAGNOSIS = new EDischargeSummarySection(-2087, "Diagnosis", true, null, null, Color.Default);
	public static final EDischargeSummarySection CLINICALINFO = new EDischargeSummarySection(-2088, "Clinical Information", true, null, null, Color.Default);
	public static final EDischargeSummarySection OPERATIONS_AND_PROCS = new EDischargeSummarySection(-2089, "Operations and Procedures", true, null, null, Color.Default);
	public static final EDischargeSummarySection NEONATAL = new EDischargeSummarySection(-2090, "Neo Natal", true, null, null, Color.Default);
	public static final EDischargeSummarySection PLASTICS = new EDischargeSummarySection(-2091, "Plastics", true, null, null, Color.Default);
	public static final EDischargeSummarySection MEDICATIONONADMISSION = new EDischargeSummarySection(-2099, "Medication On Admission", true, null, null, Color.Default);
	public static final EDischargeSummarySection FUTURE_PLAN = new EDischargeSummarySection(-2092, "Future Plan", true, null, null, Color.Default);
	public static final EDischargeSummarySection READY_TO_LEAVE = new EDischargeSummarySection(-2094, "Ready to Leave", true, null, null, Color.Default);
	public static final EDischargeSummarySection SUPPLEMENTARY = new EDischargeSummarySection(-2095, "Supplementary", true, null, null, Color.Default);
}
