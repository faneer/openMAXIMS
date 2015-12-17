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

public class Specialty extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public Specialty()
	{
		super();
	}
	public Specialty(int id)
	{
		super(id, "", true);
	}
	public Specialty(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public Specialty(int id, String text, boolean active, Specialty parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public Specialty(int id, String text, boolean active, Specialty parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public Specialty(int id, String text, boolean active, Specialty parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static Specialty buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new Specialty(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (Specialty)super.getParentInstance();
	}
	public Specialty getParent()
	{
		return (Specialty)super.getParentInstance();
	}
	public void setParent(Specialty parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		Specialty[] typedChildren = new Specialty[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (Specialty)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof Specialty)
		{
			super.addChild((Specialty)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof Specialty)
		{
			super.removeChild((Specialty)child);
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
		SpecialtyCollection result = new SpecialtyCollection();
		result.add(COE);
		result.add(SPINALINJURIES);
		result.add(PRISONS);
		result.add(POAC);
		result.add(CORRESPONDENCE);
		result.add(EMERGENCY);
		result.add(HEALTHSCREEN);
		result.add(MENTAL_HEALTH);
		result.add(CARE_UK);
		result.add(COMORBIDITY);
		result.add(DAD);
		result.add(CATARACT);
		result.add(PRESCRIPTION);
		result.add(ONCOLOGY);
		result.add(PAEDIATRICS);
		return result;
	}
	public static Specialty[] getNegativeInstances()
	{
		Specialty[] instances = new Specialty[15];
		instances[0] = COE;
		instances[1] = SPINALINJURIES;
		instances[2] = PRISONS;
		instances[3] = POAC;
		instances[4] = CORRESPONDENCE;
		instances[5] = EMERGENCY;
		instances[6] = HEALTHSCREEN;
		instances[7] = MENTAL_HEALTH;
		instances[8] = CARE_UK;
		instances[9] = COMORBIDITY;
		instances[10] = DAD;
		instances[11] = CATARACT;
		instances[12] = PRESCRIPTION;
		instances[13] = ONCOLOGY;
		instances[14] = PAEDIATRICS;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[15];
		negativeInstances[0] = "COE";
		negativeInstances[1] = "SPINALINJURIES";
		negativeInstances[2] = "PRISONS";
		negativeInstances[3] = "POAC";
		negativeInstances[4] = "CORRESPONDENCE";
		negativeInstances[5] = "EMERGENCY";
		negativeInstances[6] = "HEALTHSCREEN";
		negativeInstances[7] = "MENTAL_HEALTH";
		negativeInstances[8] = "CARE_UK";
		negativeInstances[9] = "COMORBIDITY";
		negativeInstances[10] = "DAD";
		negativeInstances[11] = "CATARACT";
		negativeInstances[12] = "PRESCRIPTION";
		negativeInstances[13] = "ONCOLOGY";
		negativeInstances[14] = "PAEDIATRICS";
		return negativeInstances;
	}
	public static Specialty getNegativeInstance(String name)
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
	public static Specialty getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		Specialty[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 621;
	public static final Specialty COE = new Specialty(-153, "Care of the Elderly", true, null, null, Color.Black);
	public static final Specialty SPINALINJURIES = new Specialty(-171, "Spinal Injuries", true, null, null, Color.Default);
	public static final Specialty PRISONS = new Specialty(-283, "Prisons", true, null, null, Color.Default);
	public static final Specialty POAC = new Specialty(-718, "Pre-Operative Assessment Clinic", true, null, null, Color.Default);
	public static final Specialty CORRESPONDENCE = new Specialty(-914, "Correspondence", true, null, null, Color.Default);
	public static final Specialty EMERGENCY = new Specialty(-1213, "Emergency", true, null, null, Color.Default);
	public static final Specialty HEALTHSCREEN = new Specialty(-1411, "Health Screen", true, null, null, Color.Default);
	public static final Specialty MENTAL_HEALTH = new Specialty(-1510, "Mental Health", true, null, null, Color.Default);
	public static final Specialty CARE_UK = new Specialty(-1517, "Care UK", true, null, null, Color.Default);
	public static final Specialty COMORBIDITY = new Specialty(-1522, "Comorbidity", true, null, null, Color.Default);
	public static final Specialty DAD = new Specialty(-1555, "Direct Access Diagnostic", true, null, null, Color.Default);
	public static final Specialty CATARACT = new Specialty(-1814, "Cataract", true, null, null, Color.Default);
	public static final Specialty PRESCRIPTION = new Specialty(-1815, "Prescription", true, null, null, Color.Default);
	public static final Specialty ONCOLOGY = new Specialty(-1975, "Oncology", true, null, null, Color.Default);
	public static final Specialty PAEDIATRICS = new Specialty(-3337, "Paediatrics", true, null, null, Color.Default);
}
