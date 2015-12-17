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

public class VSType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public VSType()
	{
		super();
	}
	public VSType(int id)
	{
		super(id, "", true);
	}
	public VSType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public VSType(int id, String text, boolean active, VSType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public VSType(int id, String text, boolean active, VSType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public VSType(int id, String text, boolean active, VSType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static VSType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new VSType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (VSType)super.getParentInstance();
	}
	public VSType getParent()
	{
		return (VSType)super.getParentInstance();
	}
	public void setParent(VSType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		VSType[] typedChildren = new VSType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (VSType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof VSType)
		{
			super.addChild((VSType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof VSType)
		{
			super.removeChild((VSType)child);
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
		VSTypeCollection result = new VSTypeCollection();
		result.add(BP);
		result.add(TEMP);
		result.add(OXYGEN);
		result.add(PULSE);
		result.add(RESPIRATION);
		result.add(PUPILS);
		result.add(VISUALACUITY);
		result.add(GLASGOWCOMASCALE);
		result.add(BLOODSUGAR);
		result.add(PEAKFLOW);
		result.add(METRICS);
		result.add(VITALCAPACITY);
		result.add(ABG);
		result.add(VENTILATIONCHART);
		result.add(KETONES);
		result.add(CBGM);
		result.add(FBAL);
		result.add(PAIN);
		return result;
	}
	public static VSType[] getNegativeInstances()
	{
		VSType[] instances = new VSType[18];
		instances[0] = BP;
		instances[1] = TEMP;
		instances[2] = OXYGEN;
		instances[3] = PULSE;
		instances[4] = RESPIRATION;
		instances[5] = PUPILS;
		instances[6] = VISUALACUITY;
		instances[7] = GLASGOWCOMASCALE;
		instances[8] = BLOODSUGAR;
		instances[9] = PEAKFLOW;
		instances[10] = METRICS;
		instances[11] = VITALCAPACITY;
		instances[12] = ABG;
		instances[13] = VENTILATIONCHART;
		instances[14] = KETONES;
		instances[15] = CBGM;
		instances[16] = FBAL;
		instances[17] = PAIN;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[18];
		negativeInstances[0] = "BP";
		negativeInstances[1] = "TEMP";
		negativeInstances[2] = "OXYGEN";
		negativeInstances[3] = "PULSE";
		negativeInstances[4] = "RESPIRATION";
		negativeInstances[5] = "PUPILS";
		negativeInstances[6] = "VISUALACUITY";
		negativeInstances[7] = "GLASGOWCOMASCALE";
		negativeInstances[8] = "BLOODSUGAR";
		negativeInstances[9] = "PEAKFLOW";
		negativeInstances[10] = "METRICS";
		negativeInstances[11] = "VITALCAPACITY";
		negativeInstances[12] = "ABG";
		negativeInstances[13] = "VENTILATIONCHART";
		negativeInstances[14] = "KETONES";
		negativeInstances[15] = "CBGM";
		negativeInstances[16] = "FBAL";
		negativeInstances[17] = "PAIN";
		return negativeInstances;
	}
	public static VSType getNegativeInstance(String name)
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
	public static VSType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		VSType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021058;
	public static final VSType BP = new VSType(-51, "Blood Pressure", true, null, null, Color.Black);
	public static final VSType TEMP = new VSType(-98, "Temperature", true, null, null, Color.Black);
	public static final VSType OXYGEN = new VSType(-54, "Oxygen Saturation", true, null, null, Color.Black);
	public static final VSType PULSE = new VSType(-100, "Pulse", true, null, null, Color.Black);
	public static final VSType RESPIRATION = new VSType(-55, "Respiration", true, null, null, Color.Black);
	public static final VSType PUPILS = new VSType(-101, "Pupils", true, null, null, Color.Black);
	public static final VSType VISUALACUITY = new VSType(-56, "VisualAcuity", true, null, null, Color.Black);
	public static final VSType GLASGOWCOMASCALE = new VSType(-102, "Glasgow Coma Scale", true, null, null, Color.Black);
	public static final VSType BLOODSUGAR = new VSType(-57, "Blood Sugar", true, null, null, Color.Black);
	public static final VSType PEAKFLOW = new VSType(-103, "Peak Flow", true, null, null, Color.Black);
	public static final VSType METRICS = new VSType(-58, "Metrics", true, null, null, Color.Black);
	public static final VSType VITALCAPACITY = new VSType(-185, "Vital Capacity", true, null, null, Color.Default);
	public static final VSType ABG = new VSType(-186, "Arterial Blood Gas", true, null, null, Color.Default);
	public static final VSType VENTILATIONCHART = new VSType(-219, "Ventilation Chart", true, null, null, Color.Default);
	public static final VSType KETONES = new VSType(-982, "Ketones", true, null, null, Color.Default);
	public static final VSType CBGM = new VSType(-983, "Capillary Blood Glucose Monitoring", true, null, null, Color.Default);
	public static final VSType FBAL = new VSType(-1154, "Fluid Balance", true, null, null, Color.Default);
	public static final VSType PAIN = new VSType(-1155, "PAIN", true, null, null, Color.Default);
}
