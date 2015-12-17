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

package ims.emergency.configuration.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to emergency.Configuration.TriageTabConfiguration business object (ID: 1087100025).
 */
public class TriageTabConfigurationRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<TriageTabConfigurationRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TriageTabConfigurationRefVo> col = new ArrayList<TriageTabConfigurationRefVo>();
	public final String getBoClassName()
	{
		return "ims.emergency.configuration.domain.objects.TriageTabConfiguration";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(TriageTabConfigurationRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TriageTabConfigurationRefVo value)
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
	public int indexOf(TriageTabConfigurationRefVo instance)
	{
		return col.indexOf(instance);
	}
	public TriageTabConfigurationRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TriageTabConfigurationRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TriageTabConfigurationRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TriageTabConfigurationRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TriageTabConfigurationRefVoCollection clone = new TriageTabConfigurationRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TriageTabConfigurationRefVo)this.col.get(x).clone());
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
	public TriageTabConfigurationRefVo[] toArray()
	{
		TriageTabConfigurationRefVo[] arr = new TriageTabConfigurationRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public TriageTabConfigurationRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TriageTabConfigurationRefVoCollection sort(SortOrder order)
	{
		return sort(new TriageTabConfigurationRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public TriageTabConfigurationRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<TriageTabConfigurationRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TriageTabConfigurationRefVoComparator implements Comparator
	{
		private int direction = 1;
		public TriageTabConfigurationRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TriageTabConfigurationRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			TriageTabConfigurationRefVo voObj1 = (TriageTabConfigurationRefVo)obj1;
			TriageTabConfigurationRefVo voObj2 = (TriageTabConfigurationRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
