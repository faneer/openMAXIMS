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

package ims.admin.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.clinical.coding.Icd10AmBlock business object (ID: 1037100000).
 */
public class Icd10AmBlockVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<Icd10AmBlockVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Icd10AmBlockVo> col = new ArrayList<Icd10AmBlockVo>();
	public String getBoClassName()
	{
		return "ims.core.clinical.coding.domain.objects.Icd10AmBlock";
	}
	public boolean add(Icd10AmBlockVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Icd10AmBlockVo value)
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
	public int indexOf(Icd10AmBlockVo instance)
	{
		return col.indexOf(instance);
	}
	public Icd10AmBlockVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Icd10AmBlockVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Icd10AmBlockVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Icd10AmBlockVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Icd10AmBlockVoCollection clone = new Icd10AmBlockVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Icd10AmBlockVo)this.col.get(x).clone());
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
	public Icd10AmBlockVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Icd10AmBlockVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public Icd10AmBlockVoCollection sort(SortOrder order)
	{
		return sort(new Icd10AmBlockVoComparator(order));
	}
	public Icd10AmBlockVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new Icd10AmBlockVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public Icd10AmBlockVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.clinical.coding.vo.Icd10AmBlockRefVoCollection toRefVoCollection()
	{
		ims.core.clinical.coding.vo.Icd10AmBlockRefVoCollection result = new ims.core.clinical.coding.vo.Icd10AmBlockRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public Icd10AmBlockVo[] toArray()
	{
		Icd10AmBlockVo[] arr = new Icd10AmBlockVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<Icd10AmBlockVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Icd10AmBlockVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public Icd10AmBlockVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Icd10AmBlockVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public Icd10AmBlockVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			Icd10AmBlockVo voObj1 = (Icd10AmBlockVo)obj1;
			Icd10AmBlockVo voObj2 = (Icd10AmBlockVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.admin.vo.beans.Icd10AmBlockVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.admin.vo.beans.Icd10AmBlockVoBean[] getBeanCollectionArray()
	{
		ims.admin.vo.beans.Icd10AmBlockVoBean[] result = new ims.admin.vo.beans.Icd10AmBlockVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			Icd10AmBlockVo vo = ((Icd10AmBlockVo)col.get(i));
			result[i] = (ims.admin.vo.beans.Icd10AmBlockVoBean)vo.getBean();
		}
		return result;
	}
	public static Icd10AmBlockVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Icd10AmBlockVoCollection coll = new Icd10AmBlockVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.admin.vo.beans.Icd10AmBlockVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static Icd10AmBlockVoCollection buildFromBeanCollection(ims.admin.vo.beans.Icd10AmBlockVoBean[] beans)
	{
		Icd10AmBlockVoCollection coll = new Icd10AmBlockVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
