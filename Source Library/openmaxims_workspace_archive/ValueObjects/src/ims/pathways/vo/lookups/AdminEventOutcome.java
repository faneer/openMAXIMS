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

package ims.pathways.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AdminEventOutcome extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AdminEventOutcome()
	{
		super();
	}
	public AdminEventOutcome(int id)
	{
		super(id, "", true);
	}
	public AdminEventOutcome(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AdminEventOutcome(int id, String text, boolean active, AdminEventOutcome parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AdminEventOutcome(int id, String text, boolean active, AdminEventOutcome parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AdminEventOutcome(int id, String text, boolean active, AdminEventOutcome parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AdminEventOutcome buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AdminEventOutcome(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AdminEventOutcome)super.getParentInstance();
	}
	public AdminEventOutcome getParent()
	{
		return (AdminEventOutcome)super.getParentInstance();
	}
	public void setParent(AdminEventOutcome parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AdminEventOutcome[] typedChildren = new AdminEventOutcome[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AdminEventOutcome)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AdminEventOutcome)
		{
			super.addChild((AdminEventOutcome)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AdminEventOutcome)
		{
			super.removeChild((AdminEventOutcome)child);
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
		AdminEventOutcomeCollection result = new AdminEventOutcomeCollection();
		result.add(PATIENT_REFUSES_TREATMENT);
		result.add(DECISION_NOT_TO_TREAT);
		result.add(ACTIVE_MONITORING_INITIATED_BY_PATIENT);
		result.add(ACTIVE_MONITORING_INITIATED_BY_CARE_PROFESSIONAL);
		result.add(START_OF_FIRST_DEFINITIVE_TREATMENT);
		return result;
	}
	public static AdminEventOutcome[] getNegativeInstances()
	{
		AdminEventOutcome[] instances = new AdminEventOutcome[5];
		instances[0] = PATIENT_REFUSES_TREATMENT;
		instances[1] = DECISION_NOT_TO_TREAT;
		instances[2] = ACTIVE_MONITORING_INITIATED_BY_PATIENT;
		instances[3] = ACTIVE_MONITORING_INITIATED_BY_CARE_PROFESSIONAL;
		instances[4] = START_OF_FIRST_DEFINITIVE_TREATMENT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[5];
		negativeInstances[0] = "PATIENT_REFUSES_TREATMENT";
		negativeInstances[1] = "DECISION_NOT_TO_TREAT";
		negativeInstances[2] = "ACTIVE_MONITORING_INITIATED_BY_PATIENT";
		negativeInstances[3] = "ACTIVE_MONITORING_INITIATED_BY_CARE_PROFESSIONAL";
		negativeInstances[4] = "START_OF_FIRST_DEFINITIVE_TREATMENT";
		return negativeInstances;
	}
	public static AdminEventOutcome getNegativeInstance(String name)
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
	public static AdminEventOutcome getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AdminEventOutcome[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1321015;
	public static final AdminEventOutcome PATIENT_REFUSES_TREATMENT = new AdminEventOutcome(-2662, "Patient Refuses Treatment", true, null, null, Color.Default);
	public static final AdminEventOutcome DECISION_NOT_TO_TREAT = new AdminEventOutcome(-2678, "Decision not to Treat", true, null, null, Color.Default);
	public static final AdminEventOutcome ACTIVE_MONITORING_INITIATED_BY_PATIENT = new AdminEventOutcome(-2679, "Active Monitoring initiated by Patient", true, null, null, Color.Default);
	public static final AdminEventOutcome ACTIVE_MONITORING_INITIATED_BY_CARE_PROFESSIONAL = new AdminEventOutcome(-2680, "Active Monitoring initiated by Care Professional ", true, null, null, Color.Default);
	public static final AdminEventOutcome START_OF_FIRST_DEFINITIVE_TREATMENT = new AdminEventOutcome(-2681, "Start of First Definitive Treatment ", true, null, null, Color.Default);
}
