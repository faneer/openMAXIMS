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

public class ActivityType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ActivityType()
	{
		super();
	}
	public ActivityType(int id)
	{
		super(id, "", true);
	}
	public ActivityType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ActivityType(int id, String text, boolean active, ActivityType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ActivityType(int id, String text, boolean active, ActivityType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ActivityType(int id, String text, boolean active, ActivityType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ActivityType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ActivityType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ActivityType)super.getParentInstance();
	}
	public ActivityType getParent()
	{
		return (ActivityType)super.getParentInstance();
	}
	public void setParent(ActivityType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ActivityType[] typedChildren = new ActivityType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ActivityType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ActivityType)
		{
			super.addChild((ActivityType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ActivityType)
		{
			super.removeChild((ActivityType)child);
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
		ActivityTypeCollection result = new ActivityTypeCollection();
		result.add(PROCEDURE);
		result.add(INVESTIGATION);
		result.add(REQUESTFORSERVICES);
		result.add(ADMINFUNCTIONS);
		result.add(CODING);
		result.add(PROCEDUREPRICING);
		result.add(PROCEDURELINKING);
		result.add(CONSULTANTCODING);
		result.add(GPCODING);
		result.add(SYSTEMALERT);
		result.add(DISSUMMLOSEXCEEDED);
		result.add(DISCHCOMPL);
		result.add(ACTLEVELWARNING);
		result.add(ACTIVITYLEVELEXCEED);
		result.add(DISSUMMCONSNOTACC);
		result.add(DISPROCEDUREOUTOFREMIT);
		result.add(HOLDACTIVITYLIMIT);
		result.add(PORNUMBERCANNOTBEGENERATED);
		result.add(WORKQUEUEFOLLOWUPTYPES);
		result.add(LOCALL);
		result.add(CASE);
		result.add(DISCHARGE);
		result.add(INVOICE);
		result.add(OUTLIER);
		result.add(INVOICEAPPROVAL);
		result.add(INVOICENONCARE);
		result.add(APPOINTMENTTYPES);
		return result;
	}
	public static ActivityType[] getNegativeInstances()
	{
		ActivityType[] instances = new ActivityType[27];
		instances[0] = PROCEDURE;
		instances[1] = INVESTIGATION;
		instances[2] = REQUESTFORSERVICES;
		instances[3] = ADMINFUNCTIONS;
		instances[4] = CODING;
		instances[5] = PROCEDUREPRICING;
		instances[6] = PROCEDURELINKING;
		instances[7] = CONSULTANTCODING;
		instances[8] = GPCODING;
		instances[9] = SYSTEMALERT;
		instances[10] = DISSUMMLOSEXCEEDED;
		instances[11] = DISCHCOMPL;
		instances[12] = ACTLEVELWARNING;
		instances[13] = ACTIVITYLEVELEXCEED;
		instances[14] = DISSUMMCONSNOTACC;
		instances[15] = DISPROCEDUREOUTOFREMIT;
		instances[16] = HOLDACTIVITYLIMIT;
		instances[17] = PORNUMBERCANNOTBEGENERATED;
		instances[18] = WORKQUEUEFOLLOWUPTYPES;
		instances[19] = LOCALL;
		instances[20] = CASE;
		instances[21] = DISCHARGE;
		instances[22] = INVOICE;
		instances[23] = OUTLIER;
		instances[24] = INVOICEAPPROVAL;
		instances[25] = INVOICENONCARE;
		instances[26] = APPOINTMENTTYPES;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[27];
		negativeInstances[0] = "PROCEDURE";
		negativeInstances[1] = "INVESTIGATION";
		negativeInstances[2] = "REQUESTFORSERVICES";
		negativeInstances[3] = "ADMINFUNCTIONS";
		negativeInstances[4] = "CODING";
		negativeInstances[5] = "PROCEDUREPRICING";
		negativeInstances[6] = "PROCEDURELINKING";
		negativeInstances[7] = "CONSULTANTCODING";
		negativeInstances[8] = "GPCODING";
		negativeInstances[9] = "SYSTEMALERT";
		negativeInstances[10] = "DISSUMMLOSEXCEEDED";
		negativeInstances[11] = "DISCHCOMPL";
		negativeInstances[12] = "ACTLEVELWARNING";
		negativeInstances[13] = "ACTIVITYLEVELEXCEED";
		negativeInstances[14] = "DISSUMMCONSNOTACC";
		negativeInstances[15] = "DISPROCEDUREOUTOFREMIT";
		negativeInstances[16] = "HOLDACTIVITYLIMIT";
		negativeInstances[17] = "PORNUMBERCANNOTBEGENERATED";
		negativeInstances[18] = "WORKQUEUEFOLLOWUPTYPES";
		negativeInstances[19] = "LOCALL";
		negativeInstances[20] = "CASE";
		negativeInstances[21] = "DISCHARGE";
		negativeInstances[22] = "INVOICE";
		negativeInstances[23] = "OUTLIER";
		negativeInstances[24] = "INVOICEAPPROVAL";
		negativeInstances[25] = "INVOICENONCARE";
		negativeInstances[26] = "APPOINTMENTTYPES";
		return negativeInstances;
	}
	public static ActivityType getNegativeInstance(String name)
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
	public static ActivityType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ActivityType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021125;
	public static final ActivityType PROCEDURE = new ActivityType(-417, "PROCEDURE", true, null, null, Color.Default);
	public static final ActivityType INVESTIGATION = new ActivityType(-418, "INVESTIGATION", true, null, null, Color.Default);
	public static final ActivityType REQUESTFORSERVICES = new ActivityType(-469, "REQUESTFORSERVICES", true, null, null, Color.Default);
	public static final ActivityType ADMINFUNCTIONS = new ActivityType(-470, "ADMINFUNCTIONS", true, null, null, Color.Default);
	public static final ActivityType CODING = new ActivityType(-475, "CODING", true, ActivityType.ADMINFUNCTIONS, null, Color.Default);
	public static final ActivityType PROCEDUREPRICING = new ActivityType(-474, "Procedure Pricing", true, ActivityType.CODING, null, Color.Default);
	public static final ActivityType PROCEDURELINKING = new ActivityType(-473, "PROCEDURELINKING", true, ActivityType.CODING, null, Color.Default);
	public static final ActivityType CONSULTANTCODING = new ActivityType(-472, "CONSULTANTCODING", true, ActivityType.CODING, null, Color.Default);
	public static final ActivityType GPCODING = new ActivityType(-471, "GPCODING", true, ActivityType.CODING, null, Color.Default);
	public static final ActivityType SYSTEMALERT = new ActivityType(-476, "SYSTEMALERT", true, ActivityType.ADMINFUNCTIONS, null, Color.Default);
	public static final ActivityType DISSUMMLOSEXCEEDED = new ActivityType(-477, "DISSUMMLOSEXCEEDED", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType DISCHCOMPL = new ActivityType(-478, "DISCHCOMPL", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType ACTLEVELWARNING = new ActivityType(-479, "ACTLEVELWARNING", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType ACTIVITYLEVELEXCEED = new ActivityType(-480, "ACTIVITYLEVELEXCEED", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType DISSUMMCONSNOTACC = new ActivityType(-481, "DISSUMMCONSNOTACC", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType DISPROCEDUREOUTOFREMIT = new ActivityType(-519, "Discharge - Procedure Out Of Remit", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType HOLDACTIVITYLIMIT = new ActivityType(-528, "Hold Activity Limit", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType PORNUMBERCANNOTBEGENERATED = new ActivityType(-544, "POR Number can not be generated", true, ActivityType.SYSTEMALERT, null, Color.Default);
	public static final ActivityType WORKQUEUEFOLLOWUPTYPES = new ActivityType(-488, "WORKQUEUEFOLLOWUPTYPES", true, ActivityType.ADMINFUNCTIONS, null, Color.Default);
	public static final ActivityType LOCALL = new ActivityType(-489, "LOCALL", true, ActivityType.WORKQUEUEFOLLOWUPTYPES, null, Color.Default);
	public static final ActivityType CASE = new ActivityType(-490, "CASE", true, ActivityType.WORKQUEUEFOLLOWUPTYPES, null, Color.Default);
	public static final ActivityType DISCHARGE = new ActivityType(-491, "DISCHARGE", true, ActivityType.WORKQUEUEFOLLOWUPTYPES, null, Color.Default);
	public static final ActivityType INVOICE = new ActivityType(-492, "INVOICE", true, ActivityType.WORKQUEUEFOLLOWUPTYPES, null, Color.Default);
	public static final ActivityType OUTLIER = new ActivityType(-493, "OUTLIER", true, ActivityType.WORKQUEUEFOLLOWUPTYPES, null, Color.Default);
	public static final ActivityType INVOICEAPPROVAL = new ActivityType(-494, "INVOICEAPPROVAL", true, ActivityType.WORKQUEUEFOLLOWUPTYPES, null, Color.Default);
	public static final ActivityType INVOICENONCARE = new ActivityType(-501, "INVOICE NON CARE", true, ActivityType.WORKQUEUEFOLLOWUPTYPES, null, Color.Default);
	public static final ActivityType APPOINTMENTTYPES = new ActivityType(-599, "Appointment Types", true, null, null, Color.Default);
}
