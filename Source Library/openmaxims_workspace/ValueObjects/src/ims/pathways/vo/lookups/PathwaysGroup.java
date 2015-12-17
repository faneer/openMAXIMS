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

package ims.pathways.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PathwaysGroup extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PathwaysGroup()
	{
		super();
	}
	public PathwaysGroup(int id)
	{
		super(id, "", true);
	}
	public PathwaysGroup(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PathwaysGroup(int id, String text, boolean active, PathwaysGroup parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PathwaysGroup(int id, String text, boolean active, PathwaysGroup parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PathwaysGroup(int id, String text, boolean active, PathwaysGroup parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PathwaysGroup buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PathwaysGroup(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PathwaysGroup)super.getParentInstance();
	}
	public PathwaysGroup getParent()
	{
		return (PathwaysGroup)super.getParentInstance();
	}
	public void setParent(PathwaysGroup parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PathwaysGroup[] typedChildren = new PathwaysGroup[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PathwaysGroup)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PathwaysGroup)
		{
			super.addChild((PathwaysGroup)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PathwaysGroup)
		{
			super.removeChild((PathwaysGroup)child);
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
		PathwaysGroupCollection result = new PathwaysGroupCollection();
		result.add(OPD);
		result.add(INP);
		result.add(TCI);
		result.add(WTL);
		result.add(PMI);
		result.add(MRG);
		result.add(RTT);
		result.add(IDN);
		result.add(CPT);
		result.add(INL);
		result.add(EPM);
		return result;
	}
	public static PathwaysGroup[] getNegativeInstances()
	{
		PathwaysGroup[] instances = new PathwaysGroup[11];
		instances[0] = OPD;
		instances[1] = INP;
		instances[2] = TCI;
		instances[3] = WTL;
		instances[4] = PMI;
		instances[5] = MRG;
		instances[6] = RTT;
		instances[7] = IDN;
		instances[8] = CPT;
		instances[9] = INL;
		instances[10] = EPM;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[11];
		negativeInstances[0] = "OPD";
		negativeInstances[1] = "INP";
		negativeInstances[2] = "TCI";
		negativeInstances[3] = "WTL";
		negativeInstances[4] = "PMI";
		negativeInstances[5] = "MRG";
		negativeInstances[6] = "RTT";
		negativeInstances[7] = "IDN";
		negativeInstances[8] = "CPT";
		negativeInstances[9] = "INL";
		negativeInstances[10] = "EPM";
		return negativeInstances;
	}
	public static PathwaysGroup getNegativeInstance(String name)
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
	public static PathwaysGroup getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PathwaysGroup[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1321000;
	public static final PathwaysGroup OPD = new PathwaysGroup(-1266, "Outpatient", true, null, null, Color.Default);
	public static final PathwaysGroup INP = new PathwaysGroup(-1267, "Inpatient", true, null, null, Color.Default);
	public static final PathwaysGroup TCI = new PathwaysGroup(-1268, "ToComeIn", true, null, null, Color.Default);
	public static final PathwaysGroup WTL = new PathwaysGroup(-1269, "WaitingList", true, null, null, Color.Default);
	public static final PathwaysGroup PMI = new PathwaysGroup(-1304, "Patient", true, null, null, Color.Default);
	public static final PathwaysGroup MRG = new PathwaysGroup(-1305, "Patient Merge", true, null, null, Color.Default);
	public static final PathwaysGroup RTT = new PathwaysGroup(-1306, "Clock Status Changes", true, null, null, Color.Default);
	public static final PathwaysGroup IDN = new PathwaysGroup(-1370, "Inpatient Did Not Attend", true, null, null, Color.Default);
	public static final PathwaysGroup CPT = new PathwaysGroup(-1676, "Cancer Pathway Target", true, null, null, Color.Default);
	public static final PathwaysGroup INL = new PathwaysGroup(-1703, "Link/Unlink", true, null, null, Color.Default);
	public static final PathwaysGroup EPM = new PathwaysGroup(-1704, "Episode", true, null, null, Color.Default);
}
