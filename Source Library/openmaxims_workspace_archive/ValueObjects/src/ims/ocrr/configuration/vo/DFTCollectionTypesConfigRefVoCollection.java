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

package ims.ocrr.configuration.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.Configuration.DFTCollectionTypesConfig business object (ID: 1061100027).
 */
public class DFTCollectionTypesConfigRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<DFTCollectionTypesConfigRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<DFTCollectionTypesConfigRefVo> col = new ArrayList<DFTCollectionTypesConfigRefVo>();
	public final String getBoClassName()
	{
		return "ims.ocrr.configuration.domain.objects.DFTCollectionTypesConfig";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(DFTCollectionTypesConfigRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, DFTCollectionTypesConfigRefVo value)
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
	public int indexOf(DFTCollectionTypesConfigRefVo instance)
	{
		return col.indexOf(instance);
	}
	public DFTCollectionTypesConfigRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, DFTCollectionTypesConfigRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(DFTCollectionTypesConfigRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(DFTCollectionTypesConfigRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		DFTCollectionTypesConfigRefVoCollection clone = new DFTCollectionTypesConfigRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((DFTCollectionTypesConfigRefVo)this.col.get(x).clone());
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
	public DFTCollectionTypesConfigRefVo[] toArray()
	{
		DFTCollectionTypesConfigRefVo[] arr = new DFTCollectionTypesConfigRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public DFTCollectionTypesConfigRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public DFTCollectionTypesConfigRefVoCollection sort(SortOrder order)
	{
		return sort(new DFTCollectionTypesConfigRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public DFTCollectionTypesConfigRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<DFTCollectionTypesConfigRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class DFTCollectionTypesConfigRefVoComparator implements Comparator
	{
		private int direction = 1;
		public DFTCollectionTypesConfigRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public DFTCollectionTypesConfigRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			DFTCollectionTypesConfigRefVo voObj1 = (DFTCollectionTypesConfigRefVo)obj1;
			DFTCollectionTypesConfigRefVo voObj2 = (DFTCollectionTypesConfigRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
