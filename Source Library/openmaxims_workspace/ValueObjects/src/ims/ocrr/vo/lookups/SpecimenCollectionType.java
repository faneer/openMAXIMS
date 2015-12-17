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

package ims.ocrr.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class SpecimenCollectionType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SpecimenCollectionType()
	{
		super();
	}
	public SpecimenCollectionType(int id)
	{
		super(id, "", true);
	}
	public SpecimenCollectionType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SpecimenCollectionType(int id, String text, boolean active, SpecimenCollectionType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SpecimenCollectionType(int id, String text, boolean active, SpecimenCollectionType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SpecimenCollectionType(int id, String text, boolean active, SpecimenCollectionType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SpecimenCollectionType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SpecimenCollectionType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SpecimenCollectionType)super.getParentInstance();
	}
	public SpecimenCollectionType getParent()
	{
		return (SpecimenCollectionType)super.getParentInstance();
	}
	public void setParent(SpecimenCollectionType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SpecimenCollectionType[] typedChildren = new SpecimenCollectionType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SpecimenCollectionType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SpecimenCollectionType)
		{
			super.addChild((SpecimenCollectionType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SpecimenCollectionType)
		{
			super.removeChild((SpecimenCollectionType)child);
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
		SpecimenCollectionTypeCollection result = new SpecimenCollectionTypeCollection();
		result.add(NOW);
		result.add(PATIENT);
		result.add(PHLEBOTOMY_OUTPATIENT);
		result.add(PHLEBOTOMY_INPATIENT);
		result.add(OTHER);
		result.add(WARDCOLLECTION);
		result.add(SPECIMEN_COLLECTION_CLINIC);
		result.add(SPECIMEN_ALREADY_COLLECTED);
		return result;
	}
	public static SpecimenCollectionType[] getNegativeInstances()
	{
		SpecimenCollectionType[] instances = new SpecimenCollectionType[8];
		instances[0] = NOW;
		instances[1] = PATIENT;
		instances[2] = PHLEBOTOMY_OUTPATIENT;
		instances[3] = PHLEBOTOMY_INPATIENT;
		instances[4] = OTHER;
		instances[5] = WARDCOLLECTION;
		instances[6] = SPECIMEN_COLLECTION_CLINIC;
		instances[7] = SPECIMEN_ALREADY_COLLECTED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[8];
		negativeInstances[0] = "NOW";
		negativeInstances[1] = "PATIENT";
		negativeInstances[2] = "PHLEBOTOMY_OUTPATIENT";
		negativeInstances[3] = "PHLEBOTOMY_INPATIENT";
		negativeInstances[4] = "OTHER";
		negativeInstances[5] = "WARDCOLLECTION";
		negativeInstances[6] = "SPECIMEN_COLLECTION_CLINIC";
		negativeInstances[7] = "SPECIMEN_ALREADY_COLLECTED";
		return negativeInstances;
	}
	public static SpecimenCollectionType getNegativeInstance(String name)
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
	public static SpecimenCollectionType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SpecimenCollectionType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1161043;
	public static final SpecimenCollectionType NOW = new SpecimenCollectionType(-866, "Now", true, null, null, Color.Default);
	public static final SpecimenCollectionType PATIENT = new SpecimenCollectionType(-867, "Patient", true, null, null, Color.Default);
	public static final SpecimenCollectionType PHLEBOTOMY_OUTPATIENT = new SpecimenCollectionType(-1105, "Phlebotomy Outpatient", true, null, null, Color.Default);
	public static final SpecimenCollectionType PHLEBOTOMY_INPATIENT = new SpecimenCollectionType(-868, "Phlebotomy Inpatient", true, null, null, Color.Default);
	public static final SpecimenCollectionType OTHER = new SpecimenCollectionType(-869, "Ward Collection", true, null, null, Color.Default);
	public static final SpecimenCollectionType WARDCOLLECTION = new SpecimenCollectionType(-903, "Ward Collection", true, SpecimenCollectionType.OTHER, null, Color.Default);
	public static final SpecimenCollectionType SPECIMEN_COLLECTION_CLINIC = new SpecimenCollectionType(-1468, "Specimen Collection Clinic", true, null, null, Color.Default);
	public static final SpecimenCollectionType SPECIMEN_ALREADY_COLLECTED = new SpecimenCollectionType(-1960, "Specimen Already Collected", true, null, null, Color.Default);
}
