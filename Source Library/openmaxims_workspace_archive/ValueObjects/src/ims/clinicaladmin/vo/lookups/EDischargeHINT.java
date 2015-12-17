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

package ims.clinicaladmin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class EDischargeHINT extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public EDischargeHINT()
	{
		super();
	}
	public EDischargeHINT(int id)
	{
		super(id, "", true);
	}
	public EDischargeHINT(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public EDischargeHINT(int id, String text, boolean active, EDischargeHINT parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public EDischargeHINT(int id, String text, boolean active, EDischargeHINT parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public EDischargeHINT(int id, String text, boolean active, EDischargeHINT parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static EDischargeHINT buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new EDischargeHINT(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (EDischargeHINT)super.getParentInstance();
	}
	public EDischargeHINT getParent()
	{
		return (EDischargeHINT)super.getParentInstance();
	}
	public void setParent(EDischargeHINT parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		EDischargeHINT[] typedChildren = new EDischargeHINT[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (EDischargeHINT)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof EDischargeHINT)
		{
			super.addChild((EDischargeHINT)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof EDischargeHINT)
		{
			super.removeChild((EDischargeHINT)child);
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
		EDischargeHINTCollection result = new EDischargeHINTCollection();
		result.add(INVESTIGATIONS_COMMENT);
		result.add(ADDITIONAL_COMMENT);
		result.add(HOSPITAL_PLAN);
		result.add(ACTIONS_FOR);
		result.add(OTHER_RESULTS_AWAITED);
		result.add(FUTURE_PLAN_COMMENTS);
		result.add(DATE_OF_DISCHARGE);
		result.add(MEDS_ON_ADMISSION);
		result.add(MEDS_CHANGES);
		result.add(TTO_REQUIRED);
		result.add(MEDS_ON_DISCHARGE);
		result.add(MEDS_RECOMMENDATIONS);
		result.add(CLINICAL_DETAILS_COMPLETE);
		result.add(DATE_OF_DISCHARGE_RTL);
		result.add(PRINT_PATIENT_DISCHARGE);
		result.add(PRINT_DISCHARGE);
		result.add(DEMENTIA_TRUSTS_PROTOCOLS);
		result.add(DEMENTIA_MEDS_REVIEW);
		return result;
	}
	public static EDischargeHINT[] getNegativeInstances()
	{
		EDischargeHINT[] instances = new EDischargeHINT[18];
		instances[0] = INVESTIGATIONS_COMMENT;
		instances[1] = ADDITIONAL_COMMENT;
		instances[2] = HOSPITAL_PLAN;
		instances[3] = ACTIONS_FOR;
		instances[4] = OTHER_RESULTS_AWAITED;
		instances[5] = FUTURE_PLAN_COMMENTS;
		instances[6] = DATE_OF_DISCHARGE;
		instances[7] = MEDS_ON_ADMISSION;
		instances[8] = MEDS_CHANGES;
		instances[9] = TTO_REQUIRED;
		instances[10] = MEDS_ON_DISCHARGE;
		instances[11] = MEDS_RECOMMENDATIONS;
		instances[12] = CLINICAL_DETAILS_COMPLETE;
		instances[13] = DATE_OF_DISCHARGE_RTL;
		instances[14] = PRINT_PATIENT_DISCHARGE;
		instances[15] = PRINT_DISCHARGE;
		instances[16] = DEMENTIA_TRUSTS_PROTOCOLS;
		instances[17] = DEMENTIA_MEDS_REVIEW;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[18];
		negativeInstances[0] = "INVESTIGATIONS_COMMENT";
		negativeInstances[1] = "ADDITIONAL_COMMENT";
		negativeInstances[2] = "HOSPITAL_PLAN";
		negativeInstances[3] = "ACTIONS_FOR";
		negativeInstances[4] = "OTHER_RESULTS_AWAITED";
		negativeInstances[5] = "FUTURE_PLAN_COMMENTS";
		negativeInstances[6] = "DATE_OF_DISCHARGE";
		negativeInstances[7] = "MEDS_ON_ADMISSION";
		negativeInstances[8] = "MEDS_CHANGES";
		negativeInstances[9] = "TTO_REQUIRED";
		negativeInstances[10] = "MEDS_ON_DISCHARGE";
		negativeInstances[11] = "MEDS_RECOMMENDATIONS";
		negativeInstances[12] = "CLINICAL_DETAILS_COMPLETE";
		negativeInstances[13] = "DATE_OF_DISCHARGE_RTL";
		negativeInstances[14] = "PRINT_PATIENT_DISCHARGE";
		negativeInstances[15] = "PRINT_DISCHARGE";
		negativeInstances[16] = "DEMENTIA_TRUSTS_PROTOCOLS";
		negativeInstances[17] = "DEMENTIA_MEDS_REVIEW";
		return negativeInstances;
	}
	public static EDischargeHINT getNegativeInstance(String name)
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
	public static EDischargeHINT getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		EDischargeHINT[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1041001;
	public static final EDischargeHINT INVESTIGATIONS_COMMENT = new EDischargeHINT(-1709, "Investigation Comment", true, null, null, Color.Default);
	public static final EDischargeHINT ADDITIONAL_COMMENT = new EDischargeHINT(-1710, "Additional Comment", true, null, null, Color.Default);
	public static final EDischargeHINT HOSPITAL_PLAN = new EDischargeHINT(-1711, "Hospital Plan", true, null, null, Color.Default);
	public static final EDischargeHINT ACTIONS_FOR = new EDischargeHINT(-1712, "Actions for GP and Community", true, null, null, Color.Default);
	public static final EDischargeHINT OTHER_RESULTS_AWAITED = new EDischargeHINT(-1713, "Other Result Awaited", true, null, null, Color.Default);
	public static final EDischargeHINT FUTURE_PLAN_COMMENTS = new EDischargeHINT(-1714, "Future Plan Comments", true, null, null, Color.Default);
	public static final EDischargeHINT DATE_OF_DISCHARGE = new EDischargeHINT(-1715, "Date of Discharge", true, null, null, Color.Default);
	public static final EDischargeHINT MEDS_ON_ADMISSION = new EDischargeHINT(-1720, "Medication on Admission", true, null, null, Color.Default);
	public static final EDischargeHINT MEDS_CHANGES = new EDischargeHINT(-1721, "Medication Changes", true, null, null, Color.Default);
	public static final EDischargeHINT TTO_REQUIRED = new EDischargeHINT(-1722, "TTO Required", true, null, null, Color.Default);
	public static final EDischargeHINT MEDS_ON_DISCHARGE = new EDischargeHINT(-1723, "Medication on Discharge", true, null, null, Color.Default);
	public static final EDischargeHINT MEDS_RECOMMENDATIONS = new EDischargeHINT(-1724, "Medication Recommendations", true, null, null, Color.Default);
	public static final EDischargeHINT CLINICAL_DETAILS_COMPLETE = new EDischargeHINT(-1725, "Clinical Details Complete", true, null, null, Color.Default);
	public static final EDischargeHINT DATE_OF_DISCHARGE_RTL = new EDischargeHINT(-1743, "Date of Discharge (Ready to Leave)", true, null, null, Color.Default);
	public static final EDischargeHINT PRINT_PATIENT_DISCHARGE = new EDischargeHINT(-1744, "Print Patient Discharge (Ready to Leave)", true, null, null, Color.Default);
	public static final EDischargeHINT PRINT_DISCHARGE = new EDischargeHINT(-1745, "Print Discharge (Ready to Leave)", true, null, null, Color.Default);
	public static final EDischargeHINT DEMENTIA_TRUSTS_PROTOCOLS = new EDischargeHINT(-2446, "Dementia - Confirm that the Trusts protocol for investigations is being followed", true, null, null, Color.Default);
	public static final EDischargeHINT DEMENTIA_MEDS_REVIEW = new EDischargeHINT(-2447, "Dementia - Confirm a medication review is undertaken", true, null, null, Color.Default);
}
