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

public class QuestionAnswerType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public QuestionAnswerType()
	{
		super();
	}
	public QuestionAnswerType(int id)
	{
		super(id, "", true);
	}
	public QuestionAnswerType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public QuestionAnswerType(int id, String text, boolean active, QuestionAnswerType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public QuestionAnswerType(int id, String text, boolean active, QuestionAnswerType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public QuestionAnswerType(int id, String text, boolean active, QuestionAnswerType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static QuestionAnswerType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new QuestionAnswerType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (QuestionAnswerType)super.getParentInstance();
	}
	public QuestionAnswerType getParent()
	{
		return (QuestionAnswerType)super.getParentInstance();
	}
	public void setParent(QuestionAnswerType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		QuestionAnswerType[] typedChildren = new QuestionAnswerType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (QuestionAnswerType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof QuestionAnswerType)
		{
			super.addChild((QuestionAnswerType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof QuestionAnswerType)
		{
			super.removeChild((QuestionAnswerType)child);
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
		QuestionAnswerTypeCollection result = new QuestionAnswerTypeCollection();
		result.add(PICKLIST);
		result.add(YESNO);
		result.add(TEXT);
		result.add(PARTIALDATE);
		result.add(DATE);
		result.add(INTEGER);
		result.add(DECIMAL);
		result.add(MULTISELECT);
		result.add(TIME);
		result.add(SEPARATOR);
		return result;
	}
	public static QuestionAnswerType[] getNegativeInstances()
	{
		QuestionAnswerType[] instances = new QuestionAnswerType[10];
		instances[0] = PICKLIST;
		instances[1] = YESNO;
		instances[2] = TEXT;
		instances[3] = PARTIALDATE;
		instances[4] = DATE;
		instances[5] = INTEGER;
		instances[6] = DECIMAL;
		instances[7] = MULTISELECT;
		instances[8] = TIME;
		instances[9] = SEPARATOR;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[10];
		negativeInstances[0] = "PICKLIST";
		negativeInstances[1] = "YESNO";
		negativeInstances[2] = "TEXT";
		negativeInstances[3] = "PARTIALDATE";
		negativeInstances[4] = "DATE";
		negativeInstances[5] = "INTEGER";
		negativeInstances[6] = "DECIMAL";
		negativeInstances[7] = "MULTISELECT";
		negativeInstances[8] = "TIME";
		negativeInstances[9] = "SEPARATOR";
		return negativeInstances;
	}
	public static QuestionAnswerType getNegativeInstance(String name)
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
	public static QuestionAnswerType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		QuestionAnswerType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021122;
	public static final QuestionAnswerType PICKLIST = new QuestionAnswerType(-340, "Single Select from a Picklist", true, null, new ims.framework.utils.ImagePath(102232, "Images/Core/SingleSelect.gif"), Color.Default);
	public static final QuestionAnswerType YESNO = new QuestionAnswerType(-350, "Yes/No", true, null, new ims.framework.utils.ImagePath(102241, "Images/Core/Yes_No.gif"), Color.Default);
	public static final QuestionAnswerType TEXT = new QuestionAnswerType(-351, "Text", true, null, new ims.framework.utils.ImagePath(102240, "Images/Core/Textbox.gif"), Color.Default);
	public static final QuestionAnswerType PARTIALDATE = new QuestionAnswerType(-352, "Partial Date", true, null, new ims.framework.utils.ImagePath(102239, "Images/Core/PartialDate.gif"), Color.Default);
	public static final QuestionAnswerType DATE = new QuestionAnswerType(-353, "Date", true, null, new ims.framework.utils.ImagePath(102236, "Images/Core/Control_MonthCalendar.gif"), Color.Default);
	public static final QuestionAnswerType INTEGER = new QuestionAnswerType(-664, "Integer", true, null, new ims.framework.utils.ImagePath(102238, "Images/Core/Number.gif"), Color.Default);
	public static final QuestionAnswerType DECIMAL = new QuestionAnswerType(-665, "Decimal", true, null, new ims.framework.utils.ImagePath(102237, "Images/Core/Decimal.gif"), Color.Default);
	public static final QuestionAnswerType MULTISELECT = new QuestionAnswerType(-666, "Multiselect from a picklist", true, null, new ims.framework.utils.ImagePath(102233, "Images/Core/MultiSelect.gif"), Color.Default);
	public static final QuestionAnswerType TIME = new QuestionAnswerType(-667, "Time", true, null, new ims.framework.utils.ImagePath(102235, "Images/Core/clock.png"), Color.Default);
	public static final QuestionAnswerType SEPARATOR = new QuestionAnswerType(-695, "Separator Label", true, null, new ims.framework.utils.ImagePath(102242, "Images/Core/Separator.gif"), Color.Default);
}
