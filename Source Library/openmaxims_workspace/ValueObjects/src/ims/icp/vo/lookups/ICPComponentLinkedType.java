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

package ims.icp.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ICPComponentLinkedType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ICPComponentLinkedType()
	{
		super();
	}
	public ICPComponentLinkedType(int id)
	{
		super(id, "", true);
	}
	public ICPComponentLinkedType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ICPComponentLinkedType(int id, String text, boolean active, ICPComponentLinkedType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ICPComponentLinkedType(int id, String text, boolean active, ICPComponentLinkedType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ICPComponentLinkedType(int id, String text, boolean active, ICPComponentLinkedType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ICPComponentLinkedType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ICPComponentLinkedType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ICPComponentLinkedType)super.getParentInstance();
	}
	public ICPComponentLinkedType getParent()
	{
		return (ICPComponentLinkedType)super.getParentInstance();
	}
	public void setParent(ICPComponentLinkedType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ICPComponentLinkedType[] typedChildren = new ICPComponentLinkedType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ICPComponentLinkedType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ICPComponentLinkedType)
		{
			super.addChild((ICPComponentLinkedType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ICPComponentLinkedType)
		{
			super.removeChild((ICPComponentLinkedType)child);
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
		ICPComponentLinkedTypeCollection result = new ICPComponentLinkedTypeCollection();
		result.add(USERDEFINEDASSESSMENT);
		result.add(NURSING);
		result.add(WATERLOW);
		result.add(BARTELL);
		result.add(USERDEFINEDGRAPHIC);
		result.add(MEDICALGRAPICS);
		result.add(LUNGFIELDS);
		result.add(ABDOMINALEXAMINATION);
		result.add(NURSINGGRAPHICS);
		result.add(SKINASSESSMENT);
		result.add(PAINASSESSMENT);
		result.add(THERAPIESGRAPHICS);
		result.add(SUBJECTIVEASSESSMENT);
		result.add(OBJECTIVEASSESSMENT);
		result.add(DATACOLLECTIONFORM);
		result.add(MEDICAL);
		result.add(PASTMEDICALHISTORY);
		result.add(SOCIALHISTORY);
		result.add(SYSTEMREVIEW);
		result.add(NONE);
		return result;
	}
	public static ICPComponentLinkedType[] getNegativeInstances()
	{
		ICPComponentLinkedType[] instances = new ICPComponentLinkedType[20];
		instances[0] = USERDEFINEDASSESSMENT;
		instances[1] = NURSING;
		instances[2] = WATERLOW;
		instances[3] = BARTELL;
		instances[4] = USERDEFINEDGRAPHIC;
		instances[5] = MEDICALGRAPICS;
		instances[6] = LUNGFIELDS;
		instances[7] = ABDOMINALEXAMINATION;
		instances[8] = NURSINGGRAPHICS;
		instances[9] = SKINASSESSMENT;
		instances[10] = PAINASSESSMENT;
		instances[11] = THERAPIESGRAPHICS;
		instances[12] = SUBJECTIVEASSESSMENT;
		instances[13] = OBJECTIVEASSESSMENT;
		instances[14] = DATACOLLECTIONFORM;
		instances[15] = MEDICAL;
		instances[16] = PASTMEDICALHISTORY;
		instances[17] = SOCIALHISTORY;
		instances[18] = SYSTEMREVIEW;
		instances[19] = NONE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[20];
		negativeInstances[0] = "USERDEFINEDASSESSMENT";
		negativeInstances[1] = "NURSING";
		negativeInstances[2] = "WATERLOW";
		negativeInstances[3] = "BARTELL";
		negativeInstances[4] = "USERDEFINEDGRAPHIC";
		negativeInstances[5] = "MEDICALGRAPICS";
		negativeInstances[6] = "LUNGFIELDS";
		negativeInstances[7] = "ABDOMINALEXAMINATION";
		negativeInstances[8] = "NURSINGGRAPHICS";
		negativeInstances[9] = "SKINASSESSMENT";
		negativeInstances[10] = "PAINASSESSMENT";
		negativeInstances[11] = "THERAPIESGRAPHICS";
		negativeInstances[12] = "SUBJECTIVEASSESSMENT";
		negativeInstances[13] = "OBJECTIVEASSESSMENT";
		negativeInstances[14] = "DATACOLLECTIONFORM";
		negativeInstances[15] = "MEDICAL";
		negativeInstances[16] = "PASTMEDICALHISTORY";
		negativeInstances[17] = "SOCIALHISTORY";
		negativeInstances[18] = "SYSTEMREVIEW";
		negativeInstances[19] = "NONE";
		return negativeInstances;
	}
	public static ICPComponentLinkedType getNegativeInstance(String name)
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
	public static ICPComponentLinkedType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ICPComponentLinkedType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1181005;
	public static final ICPComponentLinkedType USERDEFINEDASSESSMENT = new ICPComponentLinkedType(-334, "User Defined Assessment", true, null, null, Color.Default);
	public static final ICPComponentLinkedType NURSING = new ICPComponentLinkedType(-366, "Nursing", true, ICPComponentLinkedType.USERDEFINEDASSESSMENT, null, Color.Default);
	public static final ICPComponentLinkedType WATERLOW = new ICPComponentLinkedType(-367, "WaterLow", true, ICPComponentLinkedType.NURSING, null, Color.Default);
	public static final ICPComponentLinkedType BARTELL = new ICPComponentLinkedType(-368, "Bartell", true, ICPComponentLinkedType.NURSING, null, Color.Default);
	public static final ICPComponentLinkedType USERDEFINEDGRAPHIC = new ICPComponentLinkedType(-335, "User Defined Graphic", true, null, null, Color.Default);
	public static final ICPComponentLinkedType MEDICALGRAPICS = new ICPComponentLinkedType(-369, "MedicalGrapics", true, ICPComponentLinkedType.USERDEFINEDGRAPHIC, null, Color.Default);
	public static final ICPComponentLinkedType LUNGFIELDS = new ICPComponentLinkedType(-371, "LungFields", true, ICPComponentLinkedType.MEDICALGRAPICS, null, Color.Default);
	public static final ICPComponentLinkedType ABDOMINALEXAMINATION = new ICPComponentLinkedType(-372, "AbdominalExamination", true, ICPComponentLinkedType.MEDICALGRAPICS, null, Color.Default);
	public static final ICPComponentLinkedType NURSINGGRAPHICS = new ICPComponentLinkedType(-370, "NursingGraphics", true, ICPComponentLinkedType.USERDEFINEDGRAPHIC, null, Color.Default);
	public static final ICPComponentLinkedType SKINASSESSMENT = new ICPComponentLinkedType(-373, "SkinAssessment", true, ICPComponentLinkedType.NURSINGGRAPHICS, null, Color.Default);
	public static final ICPComponentLinkedType PAINASSESSMENT = new ICPComponentLinkedType(-374, "PainAssessment", true, ICPComponentLinkedType.NURSINGGRAPHICS, null, Color.Default);
	public static final ICPComponentLinkedType THERAPIESGRAPHICS = new ICPComponentLinkedType(-377, "TherapiesGraphics", true, ICPComponentLinkedType.USERDEFINEDGRAPHIC, null, Color.Default);
	public static final ICPComponentLinkedType SUBJECTIVEASSESSMENT = new ICPComponentLinkedType(-375, "SubjectiveAssessment", true, ICPComponentLinkedType.THERAPIESGRAPHICS, null, Color.Default);
	public static final ICPComponentLinkedType OBJECTIVEASSESSMENT = new ICPComponentLinkedType(-376, "ObjectiveAssessment", true, ICPComponentLinkedType.THERAPIESGRAPHICS, null, Color.Default);
	public static final ICPComponentLinkedType DATACOLLECTIONFORM = new ICPComponentLinkedType(-336, "Data Collection Form", true, null, null, Color.Default);
	public static final ICPComponentLinkedType MEDICAL = new ICPComponentLinkedType(-362, "Medical", true, ICPComponentLinkedType.DATACOLLECTIONFORM, null, Color.Default);
	public static final ICPComponentLinkedType PASTMEDICALHISTORY = new ICPComponentLinkedType(-363, "PastMedicalHistory", true, ICPComponentLinkedType.MEDICAL, null, Color.Default);
	public static final ICPComponentLinkedType SOCIALHISTORY = new ICPComponentLinkedType(-364, "SocialHistory", true, ICPComponentLinkedType.MEDICAL, null, Color.Default);
	public static final ICPComponentLinkedType SYSTEMREVIEW = new ICPComponentLinkedType(-365, "SystemReview", true, ICPComponentLinkedType.MEDICAL, null, Color.Default);
	public static final ICPComponentLinkedType NONE = new ICPComponentLinkedType(-1922, "None", true, null, null, Color.Default);
}
