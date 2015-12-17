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
 * Linked to core.admin.pas.Inpatient Episode business object (ID: 1014100000).
 */
public class InpatientEpisodeForPendingDischargesVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<InpatientEpisodeForPendingDischargesVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<InpatientEpisodeForPendingDischargesVo> col = new ArrayList<InpatientEpisodeForPendingDischargesVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.pas.domain.objects.InpatientEpisode";
	}
	public boolean add(InpatientEpisodeForPendingDischargesVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, InpatientEpisodeForPendingDischargesVo value)
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
	public int indexOf(InpatientEpisodeForPendingDischargesVo instance)
	{
		return col.indexOf(instance);
	}
	public InpatientEpisodeForPendingDischargesVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, InpatientEpisodeForPendingDischargesVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(InpatientEpisodeForPendingDischargesVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(InpatientEpisodeForPendingDischargesVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		InpatientEpisodeForPendingDischargesVoCollection clone = new InpatientEpisodeForPendingDischargesVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((InpatientEpisodeForPendingDischargesVo)this.col.get(x).clone());
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
	public InpatientEpisodeForPendingDischargesVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public InpatientEpisodeForPendingDischargesVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public InpatientEpisodeForPendingDischargesVoCollection sort(SortOrder order)
	{
		return sort(new InpatientEpisodeForPendingDischargesVoComparator(order));
	}
	public InpatientEpisodeForPendingDischargesVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new InpatientEpisodeForPendingDischargesVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public InpatientEpisodeForPendingDischargesVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.pas.vo.InpatientEpisodeRefVoCollection toRefVoCollection()
	{
		ims.core.admin.pas.vo.InpatientEpisodeRefVoCollection result = new ims.core.admin.pas.vo.InpatientEpisodeRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public InpatientEpisodeForPendingDischargesVo[] toArray()
	{
		InpatientEpisodeForPendingDischargesVo[] arr = new InpatientEpisodeForPendingDischargesVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<InpatientEpisodeForPendingDischargesVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class InpatientEpisodeForPendingDischargesVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public InpatientEpisodeForPendingDischargesVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public InpatientEpisodeForPendingDischargesVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public InpatientEpisodeForPendingDischargesVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			InpatientEpisodeForPendingDischargesVo voObj1 = (InpatientEpisodeForPendingDischargesVo)obj1;
			InpatientEpisodeForPendingDischargesVo voObj2 = (InpatientEpisodeForPendingDischargesVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.InpatientEpisodeForPendingDischargesVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.InpatientEpisodeForPendingDischargesVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.InpatientEpisodeForPendingDischargesVoBean[] result = new ims.core.vo.beans.InpatientEpisodeForPendingDischargesVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			InpatientEpisodeForPendingDischargesVo vo = ((InpatientEpisodeForPendingDischargesVo)col.get(i));
			result[i] = (ims.core.vo.beans.InpatientEpisodeForPendingDischargesVoBean)vo.getBean();
		}
		return result;
	}
	public static InpatientEpisodeForPendingDischargesVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		InpatientEpisodeForPendingDischargesVoCollection coll = new InpatientEpisodeForPendingDischargesVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.InpatientEpisodeForPendingDischargesVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static InpatientEpisodeForPendingDischargesVoCollection buildFromBeanCollection(ims.core.vo.beans.InpatientEpisodeForPendingDischargesVoBean[] beans)
	{
		InpatientEpisodeForPendingDischargesVoCollection coll = new InpatientEpisodeForPendingDischargesVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
