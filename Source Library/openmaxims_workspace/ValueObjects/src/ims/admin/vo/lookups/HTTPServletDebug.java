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

package ims.admin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class HTTPServletDebug extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public HTTPServletDebug()
	{
		super();
	}
	public HTTPServletDebug(int id)
	{
		super(id, "", true);
	}
	public HTTPServletDebug(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public HTTPServletDebug(int id, String text, boolean active, HTTPServletDebug parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public HTTPServletDebug(int id, String text, boolean active, HTTPServletDebug parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public HTTPServletDebug(int id, String text, boolean active, HTTPServletDebug parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static HTTPServletDebug buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new HTTPServletDebug(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (HTTPServletDebug)super.getParentInstance();
	}
	public HTTPServletDebug getParent()
	{
		return (HTTPServletDebug)super.getParentInstance();
	}
	public void setParent(HTTPServletDebug parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		HTTPServletDebug[] typedChildren = new HTTPServletDebug[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (HTTPServletDebug)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof HTTPServletDebug)
		{
			super.addChild((HTTPServletDebug)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof HTTPServletDebug)
		{
			super.removeChild((HTTPServletDebug)child);
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
		HTTPServletDebugCollection result = new HTTPServletDebugCollection();
		result.add(NONE);
		result.add(REQUEST);
		result.add(RESPONSE);
		result.add(REQUEST_AND_RESPONSE);
		return result;
	}
	public static HTTPServletDebug[] getNegativeInstances()
	{
		HTTPServletDebug[] instances = new HTTPServletDebug[4];
		instances[0] = NONE;
		instances[1] = REQUEST;
		instances[2] = RESPONSE;
		instances[3] = REQUEST_AND_RESPONSE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "NONE";
		negativeInstances[1] = "REQUEST";
		negativeInstances[2] = "RESPONSE";
		negativeInstances[3] = "REQUEST_AND_RESPONSE";
		return negativeInstances;
	}
	public static HTTPServletDebug getNegativeInstance(String name)
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
	public static HTTPServletDebug getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		HTTPServletDebug[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031024;
	public static final HTTPServletDebug NONE = new HTTPServletDebug(-2221, "None", true, null, null, Color.Default);
	public static final HTTPServletDebug REQUEST = new HTTPServletDebug(-2222, "Request", true, null, null, Color.Default);
	public static final HTTPServletDebug RESPONSE = new HTTPServletDebug(-2223, "Response", true, null, null, Color.Default);
	public static final HTTPServletDebug REQUEST_AND_RESPONSE = new HTTPServletDebug(-2224, "Request and Response", true, null, null, Color.Default);
}
