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

package ims.pathways.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Pathways.PatientPathwayJourney business object (ID: 1088100000).
 */
public class Journey_ClockImpactVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<Journey_ClockImpactVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Journey_ClockImpactVo> col = new ArrayList<Journey_ClockImpactVo>();
	public String getBoClassName()
	{
		return "ims.pathways.domain.objects.PatientPathwayJourney";
	}
	public boolean add(Journey_ClockImpactVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Journey_ClockImpactVo value)
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
	public int indexOf(Journey_ClockImpactVo instance)
	{
		return col.indexOf(instance);
	}
	public Journey_ClockImpactVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Journey_ClockImpactVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Journey_ClockImpactVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Journey_ClockImpactVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Journey_ClockImpactVoCollection clone = new Journey_ClockImpactVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Journey_ClockImpactVo)this.col.get(x).clone());
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
	public Journey_ClockImpactVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Journey_ClockImpactVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public Journey_ClockImpactVoCollection sort(SortOrder order)
	{
		return sort(new Journey_ClockImpactVoComparator(order));
	}
	public Journey_ClockImpactVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new Journey_ClockImpactVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public Journey_ClockImpactVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.pathways.vo.PatientPathwayJourneyRefVoCollection toRefVoCollection()
	{
		ims.pathways.vo.PatientPathwayJourneyRefVoCollection result = new ims.pathways.vo.PatientPathwayJourneyRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public Journey_ClockImpactVo[] toArray()
	{
		Journey_ClockImpactVo[] arr = new Journey_ClockImpactVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<Journey_ClockImpactVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Journey_ClockImpactVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public Journey_ClockImpactVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Journey_ClockImpactVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public Journey_ClockImpactVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			Journey_ClockImpactVo voObj1 = (Journey_ClockImpactVo)obj1;
			Journey_ClockImpactVo voObj2 = (Journey_ClockImpactVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.pathways.vo.beans.Journey_ClockImpactVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.pathways.vo.beans.Journey_ClockImpactVoBean[] getBeanCollectionArray()
	{
		ims.pathways.vo.beans.Journey_ClockImpactVoBean[] result = new ims.pathways.vo.beans.Journey_ClockImpactVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			Journey_ClockImpactVo vo = ((Journey_ClockImpactVo)col.get(i));
			result[i] = (ims.pathways.vo.beans.Journey_ClockImpactVoBean)vo.getBean();
		}
		return result;
	}
	public static Journey_ClockImpactVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Journey_ClockImpactVoCollection coll = new Journey_ClockImpactVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.pathways.vo.beans.Journey_ClockImpactVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static Journey_ClockImpactVoCollection buildFromBeanCollection(ims.pathways.vo.beans.Journey_ClockImpactVoBean[] beans)
	{
		Journey_ClockImpactVoCollection coll = new Journey_ClockImpactVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
