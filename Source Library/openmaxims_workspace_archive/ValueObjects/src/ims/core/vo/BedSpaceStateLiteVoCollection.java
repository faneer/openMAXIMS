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

package ims.core.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.admin.pas.BedSpaceState business object (ID: 1014100009).
 */
public class BedSpaceStateLiteVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<BedSpaceStateLiteVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<BedSpaceStateLiteVo> col = new ArrayList<BedSpaceStateLiteVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.pas.domain.objects.BedSpaceState";
	}
	public boolean add(BedSpaceStateLiteVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, BedSpaceStateLiteVo value)
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
	public int indexOf(BedSpaceStateLiteVo instance)
	{
		return col.indexOf(instance);
	}
	public BedSpaceStateLiteVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, BedSpaceStateLiteVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(BedSpaceStateLiteVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(BedSpaceStateLiteVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		BedSpaceStateLiteVoCollection clone = new BedSpaceStateLiteVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((BedSpaceStateLiteVo)this.col.get(x).clone());
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
	public BedSpaceStateLiteVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public BedSpaceStateLiteVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public BedSpaceStateLiteVoCollection sort(SortOrder order)
	{
		return sort(new BedSpaceStateLiteVoComparator(order));
	}
	public BedSpaceStateLiteVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new BedSpaceStateLiteVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public BedSpaceStateLiteVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.pas.vo.BedSpaceStateRefVoCollection toRefVoCollection()
	{
		ims.core.admin.pas.vo.BedSpaceStateRefVoCollection result = new ims.core.admin.pas.vo.BedSpaceStateRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public BedSpaceStateLiteVo[] toArray()
	{
		BedSpaceStateLiteVo[] arr = new BedSpaceStateLiteVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<BedSpaceStateLiteVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class BedSpaceStateLiteVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public BedSpaceStateLiteVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public BedSpaceStateLiteVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public BedSpaceStateLiteVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			BedSpaceStateLiteVo voObj1 = (BedSpaceStateLiteVo)obj1;
			BedSpaceStateLiteVo voObj2 = (BedSpaceStateLiteVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.BedSpaceStateLiteVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.BedSpaceStateLiteVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.BedSpaceStateLiteVoBean[] result = new ims.core.vo.beans.BedSpaceStateLiteVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			BedSpaceStateLiteVo vo = ((BedSpaceStateLiteVo)col.get(i));
			result[i] = (ims.core.vo.beans.BedSpaceStateLiteVoBean)vo.getBean();
		}
		return result;
	}
	public static BedSpaceStateLiteVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		BedSpaceStateLiteVoCollection coll = new BedSpaceStateLiteVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.BedSpaceStateLiteVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static BedSpaceStateLiteVoCollection buildFromBeanCollection(ims.core.vo.beans.BedSpaceStateLiteVoBean[] beans)
	{
		BedSpaceStateLiteVoCollection coll = new BedSpaceStateLiteVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
