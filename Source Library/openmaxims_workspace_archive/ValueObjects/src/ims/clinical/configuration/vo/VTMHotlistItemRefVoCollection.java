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

package ims.clinical.configuration.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to clinical.configuration.VTMHotlistItem business object (ID: 1073100026).
 */
public class VTMHotlistItemRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<VTMHotlistItemRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<VTMHotlistItemRefVo> col = new ArrayList<VTMHotlistItemRefVo>();
	public final String getBoClassName()
	{
		return "ims.clinical.configuration.domain.objects.VTMHotlistItem";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(VTMHotlistItemRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, VTMHotlistItemRefVo value)
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
	public int indexOf(VTMHotlistItemRefVo instance)
	{
		return col.indexOf(instance);
	}
	public VTMHotlistItemRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, VTMHotlistItemRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(VTMHotlistItemRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(VTMHotlistItemRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		VTMHotlistItemRefVoCollection clone = new VTMHotlistItemRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((VTMHotlistItemRefVo)this.col.get(x).clone());
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
	public VTMHotlistItemRefVo[] toArray()
	{
		VTMHotlistItemRefVo[] arr = new VTMHotlistItemRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public VTMHotlistItemRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public VTMHotlistItemRefVoCollection sort(SortOrder order)
	{
		return sort(new VTMHotlistItemRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public VTMHotlistItemRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<VTMHotlistItemRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class VTMHotlistItemRefVoComparator implements Comparator
	{
		private int direction = 1;
		public VTMHotlistItemRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public VTMHotlistItemRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			VTMHotlistItemRefVo voObj1 = (VTMHotlistItemRefVo)obj1;
			VTMHotlistItemRefVo voObj2 = (VTMHotlistItemRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
