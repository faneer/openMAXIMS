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

package ims.RefMan.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.vitals.Metrics business object (ID: 1022100011).
 */
public class VSMetricsForPreassesOutcVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<VSMetricsForPreassesOutcVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<VSMetricsForPreassesOutcVo> col = new ArrayList<VSMetricsForPreassesOutcVo>();
	public String getBoClassName()
	{
		return "ims.core.vitals.domain.objects.Metrics";
	}
	public boolean add(VSMetricsForPreassesOutcVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, VSMetricsForPreassesOutcVo value)
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
	public int indexOf(VSMetricsForPreassesOutcVo instance)
	{
		return col.indexOf(instance);
	}
	public VSMetricsForPreassesOutcVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, VSMetricsForPreassesOutcVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(VSMetricsForPreassesOutcVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(VSMetricsForPreassesOutcVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		VSMetricsForPreassesOutcVoCollection clone = new VSMetricsForPreassesOutcVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((VSMetricsForPreassesOutcVo)this.col.get(x).clone());
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
	public VSMetricsForPreassesOutcVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public VSMetricsForPreassesOutcVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public VSMetricsForPreassesOutcVoCollection sort(SortOrder order)
	{
		return sort(new VSMetricsForPreassesOutcVoComparator(order));
	}
	public VSMetricsForPreassesOutcVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new VSMetricsForPreassesOutcVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public VSMetricsForPreassesOutcVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.vitals.vo.MetricsRefVoCollection toRefVoCollection()
	{
		ims.core.vitals.vo.MetricsRefVoCollection result = new ims.core.vitals.vo.MetricsRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public VSMetricsForPreassesOutcVo[] toArray()
	{
		VSMetricsForPreassesOutcVo[] arr = new VSMetricsForPreassesOutcVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<VSMetricsForPreassesOutcVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class VSMetricsForPreassesOutcVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public VSMetricsForPreassesOutcVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public VSMetricsForPreassesOutcVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public VSMetricsForPreassesOutcVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			VSMetricsForPreassesOutcVo voObj1 = (VSMetricsForPreassesOutcVo)obj1;
			VSMetricsForPreassesOutcVo voObj2 = (VSMetricsForPreassesOutcVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.VSMetricsForPreassesOutcVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.VSMetricsForPreassesOutcVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.VSMetricsForPreassesOutcVoBean[] result = new ims.RefMan.vo.beans.VSMetricsForPreassesOutcVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			VSMetricsForPreassesOutcVo vo = ((VSMetricsForPreassesOutcVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.VSMetricsForPreassesOutcVoBean)vo.getBean();
		}
		return result;
	}
	public static VSMetricsForPreassesOutcVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		VSMetricsForPreassesOutcVoCollection coll = new VSMetricsForPreassesOutcVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.VSMetricsForPreassesOutcVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static VSMetricsForPreassesOutcVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.VSMetricsForPreassesOutcVoBean[] beans)
	{
		VSMetricsForPreassesOutcVoCollection coll = new VSMetricsForPreassesOutcVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
