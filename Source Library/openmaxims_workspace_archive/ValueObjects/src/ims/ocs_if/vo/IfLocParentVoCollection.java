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

package ims.ocs_if.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.resource.place.Location business object (ID: 1007100007).
 */
public class IfLocParentVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<IfLocParentVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<IfLocParentVo> col = new ArrayList<IfLocParentVo>();
	public String getBoClassName()
	{
		return "ims.core.resource.place.domain.objects.Location";
	}
	public boolean add(IfLocParentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, IfLocParentVo value)
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
	public int indexOf(IfLocParentVo instance)
	{
		return col.indexOf(instance);
	}
	public IfLocParentVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, IfLocParentVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(IfLocParentVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(IfLocParentVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		IfLocParentVoCollection clone = new IfLocParentVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((IfLocParentVo)this.col.get(x).clone());
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
	public IfLocParentVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public IfLocParentVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public IfLocParentVoCollection sort(SortOrder order)
	{
		return sort(new IfLocParentVoComparator(order));
	}
	public IfLocParentVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new IfLocParentVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public IfLocParentVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.resource.place.vo.LocationRefVoCollection toRefVoCollection()
	{
		ims.core.resource.place.vo.LocationRefVoCollection result = new ims.core.resource.place.vo.LocationRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public IfLocParentVo[] toArray()
	{
		IfLocParentVo[] arr = new IfLocParentVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<IfLocParentVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class IfLocParentVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public IfLocParentVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public IfLocParentVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public IfLocParentVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			IfLocParentVo voObj1 = (IfLocParentVo)obj1;
			IfLocParentVo voObj2 = (IfLocParentVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocs_if.vo.beans.IfLocParentVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocs_if.vo.beans.IfLocParentVoBean[] getBeanCollectionArray()
	{
		ims.ocs_if.vo.beans.IfLocParentVoBean[] result = new ims.ocs_if.vo.beans.IfLocParentVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			IfLocParentVo vo = ((IfLocParentVo)col.get(i));
			result[i] = (ims.ocs_if.vo.beans.IfLocParentVoBean)vo.getBean();
		}
		return result;
	}
	public static IfLocParentVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		IfLocParentVoCollection coll = new IfLocParentVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocs_if.vo.beans.IfLocParentVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static IfLocParentVoCollection buildFromBeanCollection(ims.ocs_if.vo.beans.IfLocParentVoBean[] beans)
	{
		IfLocParentVoCollection coll = new IfLocParentVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
