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

package ims.ocrr.orderingresults.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.OrderingResults.SpecimenWorkListItem business object (ID: 1061100014).
 */
public class SpecimenWorkListItemRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<SpecimenWorkListItemRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SpecimenWorkListItemRefVo> col = new ArrayList<SpecimenWorkListItemRefVo>();
	public final String getBoClassName()
	{
		return "ims.ocrr.orderingresults.domain.objects.SpecimenWorkListItem";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(SpecimenWorkListItemRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SpecimenWorkListItemRefVo value)
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
	public int indexOf(SpecimenWorkListItemRefVo instance)
	{
		return col.indexOf(instance);
	}
	public SpecimenWorkListItemRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SpecimenWorkListItemRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SpecimenWorkListItemRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SpecimenWorkListItemRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SpecimenWorkListItemRefVoCollection clone = new SpecimenWorkListItemRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SpecimenWorkListItemRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public SpecimenWorkListItemRefVo[] toArray()
	{
		SpecimenWorkListItemRefVo[] arr = new SpecimenWorkListItemRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public SpecimenWorkListItemRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SpecimenWorkListItemRefVoCollection sort(SortOrder order)
	{
		return sort(new SpecimenWorkListItemRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public SpecimenWorkListItemRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<SpecimenWorkListItemRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SpecimenWorkListItemRefVoComparator implements Comparator
	{
		private int direction = 1;
		public SpecimenWorkListItemRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SpecimenWorkListItemRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			SpecimenWorkListItemRefVo voObj1 = (SpecimenWorkListItemRefVo)obj1;
			SpecimenWorkListItemRefVo voObj2 = (SpecimenWorkListItemRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
