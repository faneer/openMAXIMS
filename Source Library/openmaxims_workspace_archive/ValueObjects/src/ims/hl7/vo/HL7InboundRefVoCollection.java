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

package ims.hl7.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to hl7.HL7Inbound business object (ID: 1106100000).
 */
public class HL7InboundRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<HL7InboundRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<HL7InboundRefVo> col = new ArrayList<HL7InboundRefVo>();
	public final String getBoClassName()
	{
		return "ims.hl7.domain.objects.HL7Inbound";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(HL7InboundRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, HL7InboundRefVo value)
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
	public int indexOf(HL7InboundRefVo instance)
	{
		return col.indexOf(instance);
	}
	public HL7InboundRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, HL7InboundRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(HL7InboundRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(HL7InboundRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		HL7InboundRefVoCollection clone = new HL7InboundRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((HL7InboundRefVo)this.col.get(x).clone());
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
	public HL7InboundRefVo[] toArray()
	{
		HL7InboundRefVo[] arr = new HL7InboundRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public HL7InboundRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public HL7InboundRefVoCollection sort(SortOrder order)
	{
		return sort(new HL7InboundRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public HL7InboundRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<HL7InboundRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class HL7InboundRefVoComparator implements Comparator
	{
		private int direction = 1;
		public HL7InboundRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public HL7InboundRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			HL7InboundRefVo voObj1 = (HL7InboundRefVo)obj1;
			HL7InboundRefVo voObj2 = (HL7InboundRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
