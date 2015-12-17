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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class SessionLocationVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<SessionLocationVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SessionLocationVo> col = new ArrayList<SessionLocationVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Sch_Session";
	}
	public boolean add(SessionLocationVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SessionLocationVo value)
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
	public int indexOf(SessionLocationVo instance)
	{
		return col.indexOf(instance);
	}
	public SessionLocationVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SessionLocationVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SessionLocationVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SessionLocationVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SessionLocationVoCollection clone = new SessionLocationVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SessionLocationVo)this.col.get(x).clone());
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
	public SessionLocationVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SessionLocationVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public SessionLocationVoCollection sort(SortOrder order)
	{
		return sort(new SessionLocationVoComparator(order));
	}
	public SessionLocationVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new SessionLocationVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public SessionLocationVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.Sch_SessionRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.Sch_SessionRefVoCollection result = new ims.scheduling.vo.Sch_SessionRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public SessionLocationVo[] toArray()
	{
		SessionLocationVo[] arr = new SessionLocationVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<SessionLocationVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SessionLocationVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public SessionLocationVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SessionLocationVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public SessionLocationVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			SessionLocationVo voObj1 = (SessionLocationVo)obj1;
			SessionLocationVo voObj2 = (SessionLocationVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.SessionLocationVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.SessionLocationVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.SessionLocationVoBean[] result = new ims.scheduling.vo.beans.SessionLocationVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			SessionLocationVo vo = ((SessionLocationVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.SessionLocationVoBean)vo.getBean();
		}
		return result;
	}
	public static SessionLocationVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SessionLocationVoCollection coll = new SessionLocationVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.SessionLocationVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static SessionLocationVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.SessionLocationVoBean[] beans)
	{
		SessionLocationVoCollection coll = new SessionLocationVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
