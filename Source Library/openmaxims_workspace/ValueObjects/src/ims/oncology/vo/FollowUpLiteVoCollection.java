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

package ims.oncology.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Oncology.FollowUp business object (ID: 1074100000).
 */
public class FollowUpLiteVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<FollowUpLiteVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<FollowUpLiteVo> col = new ArrayList<FollowUpLiteVo>();
	public String getBoClassName()
	{
		return "ims.oncology.domain.objects.FollowUp";
	}
	public boolean add(FollowUpLiteVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, FollowUpLiteVo value)
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
	public int indexOf(FollowUpLiteVo instance)
	{
		return col.indexOf(instance);
	}
	public FollowUpLiteVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, FollowUpLiteVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(FollowUpLiteVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(FollowUpLiteVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		FollowUpLiteVoCollection clone = new FollowUpLiteVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((FollowUpLiteVo)this.col.get(x).clone());
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
	public FollowUpLiteVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public FollowUpLiteVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public FollowUpLiteVoCollection sort(SortOrder order)
	{
		return sort(new FollowUpLiteVoComparator(order));
	}
	public FollowUpLiteVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new FollowUpLiteVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public FollowUpLiteVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.oncology.vo.FollowUpRefVoCollection toRefVoCollection()
	{
		ims.oncology.vo.FollowUpRefVoCollection result = new ims.oncology.vo.FollowUpRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public FollowUpLiteVo[] toArray()
	{
		FollowUpLiteVo[] arr = new FollowUpLiteVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<FollowUpLiteVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class FollowUpLiteVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public FollowUpLiteVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public FollowUpLiteVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public FollowUpLiteVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			FollowUpLiteVo voObj1 = (FollowUpLiteVo)obj1;
			FollowUpLiteVo voObj2 = (FollowUpLiteVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.oncology.vo.beans.FollowUpLiteVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.oncology.vo.beans.FollowUpLiteVoBean[] getBeanCollectionArray()
	{
		ims.oncology.vo.beans.FollowUpLiteVoBean[] result = new ims.oncology.vo.beans.FollowUpLiteVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			FollowUpLiteVo vo = ((FollowUpLiteVo)col.get(i));
			result[i] = (ims.oncology.vo.beans.FollowUpLiteVoBean)vo.getBean();
		}
		return result;
	}
	public static FollowUpLiteVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		FollowUpLiteVoCollection coll = new FollowUpLiteVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.oncology.vo.beans.FollowUpLiteVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static FollowUpLiteVoCollection buildFromBeanCollection(ims.oncology.vo.beans.FollowUpLiteVoBean[] beans)
	{
		FollowUpLiteVoCollection coll = new FollowUpLiteVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
