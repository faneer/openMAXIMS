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

package ims.icp.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to ICPs.Configuration.ICPAction business object (ID: 1060100008).
 */
public class ICPAction_StatusChangeVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ICPAction_StatusChangeVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ICPAction_StatusChangeVo> col = new ArrayList<ICPAction_StatusChangeVo>();
	public String getBoClassName()
	{
		return "ims.icps.configuration.domain.objects.ICPAction";
	}
	public boolean add(ICPAction_StatusChangeVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ICPAction_StatusChangeVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(ICPAction_StatusChangeVo instance)
	{
		return col.indexOf(instance);
	}
	public ICPAction_StatusChangeVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ICPAction_StatusChangeVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ICPAction_StatusChangeVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ICPAction_StatusChangeVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ICPAction_StatusChangeVoCollection clone = new ICPAction_StatusChangeVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ICPAction_StatusChangeVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public ICPAction_StatusChangeVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ICPAction_StatusChangeVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ICPAction_StatusChangeVoCollection sort(SortOrder order)
	{
		return sort(new ICPAction_StatusChangeVoComparator(order));
	}
	public ICPAction_StatusChangeVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ICPAction_StatusChangeVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ICPAction_StatusChangeVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.icps.configuration.vo.ICPActionRefVoCollection toRefVoCollection()
	{
		ims.icps.configuration.vo.ICPActionRefVoCollection result = new ims.icps.configuration.vo.ICPActionRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ICPAction_StatusChangeVo[] toArray()
	{
		ICPAction_StatusChangeVo[] arr = new ICPAction_StatusChangeVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ICPAction_StatusChangeVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ICPAction_StatusChangeVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ICPAction_StatusChangeVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ICPAction_StatusChangeVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ICPAction_StatusChangeVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ICPAction_StatusChangeVo voObj1 = (ICPAction_StatusChangeVo)obj1;
			ICPAction_StatusChangeVo voObj2 = (ICPAction_StatusChangeVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.icp.vo.beans.ICPAction_StatusChangeVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.icp.vo.beans.ICPAction_StatusChangeVoBean[] getBeanCollectionArray()
	{
		ims.icp.vo.beans.ICPAction_StatusChangeVoBean[] result = new ims.icp.vo.beans.ICPAction_StatusChangeVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ICPAction_StatusChangeVo vo = ((ICPAction_StatusChangeVo)col.get(i));
			result[i] = (ims.icp.vo.beans.ICPAction_StatusChangeVoBean)vo.getBean();
		}
		return result;
	}
	public static ICPAction_StatusChangeVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ICPAction_StatusChangeVoCollection coll = new ICPAction_StatusChangeVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.icp.vo.beans.ICPAction_StatusChangeVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ICPAction_StatusChangeVoCollection buildFromBeanCollection(ims.icp.vo.beans.ICPAction_StatusChangeVoBean[] beans)
	{
		ICPAction_StatusChangeVoCollection coll = new ICPAction_StatusChangeVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
