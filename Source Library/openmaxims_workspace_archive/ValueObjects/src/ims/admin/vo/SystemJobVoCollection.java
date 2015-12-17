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

package ims.admin.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.configuration.SystemJob business object (ID: 1028100056).
 */
public class SystemJobVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<SystemJobVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SystemJobVo> col = new ArrayList<SystemJobVo>();
	public String getBoClassName()
	{
		return "ims.core.configuration.domain.objects.SystemJob";
	}
	public boolean add(SystemJobVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SystemJobVo value)
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
	public int indexOf(SystemJobVo instance)
	{
		return col.indexOf(instance);
	}
	public SystemJobVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SystemJobVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SystemJobVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SystemJobVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SystemJobVoCollection clone = new SystemJobVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SystemJobVo)this.col.get(x).clone());
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
	public SystemJobVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SystemJobVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public SystemJobVoCollection sort(SortOrder order)
	{
		return sort(new SystemJobVoComparator(order));
	}
	public SystemJobVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new SystemJobVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public SystemJobVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.configuration.vo.SystemJobRefVoCollection toRefVoCollection()
	{
		ims.core.configuration.vo.SystemJobRefVoCollection result = new ims.core.configuration.vo.SystemJobRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public SystemJobVo[] toArray()
	{
		SystemJobVo[] arr = new SystemJobVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.framework.interfaces.IScheduledJob[] toIScheduledJobArray()
	{
		ims.framework.interfaces.IScheduledJob[] arr = new ims.framework.interfaces.IScheduledJob[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<SystemJobVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SystemJobVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public SystemJobVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SystemJobVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public SystemJobVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			SystemJobVo voObj1 = (SystemJobVo)obj1;
			SystemJobVo voObj2 = (SystemJobVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.admin.vo.beans.SystemJobVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.admin.vo.beans.SystemJobVoBean[] getBeanCollectionArray()
	{
		ims.admin.vo.beans.SystemJobVoBean[] result = new ims.admin.vo.beans.SystemJobVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			SystemJobVo vo = ((SystemJobVo)col.get(i));
			result[i] = (ims.admin.vo.beans.SystemJobVoBean)vo.getBean();
		}
		return result;
	}
	public static SystemJobVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SystemJobVoCollection coll = new SystemJobVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.admin.vo.beans.SystemJobVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static SystemJobVoCollection buildFromBeanCollection(ims.admin.vo.beans.SystemJobVoBean[] beans)
	{
		SystemJobVoCollection coll = new SystemJobVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
