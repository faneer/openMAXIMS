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
 * Linked to RefMan.SuitableForSurgeryAssessment business object (ID: 1096100015).
 */
public class SuitableForSurgeryAssessmentRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<SuitableForSurgeryAssessmentRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SuitableForSurgeryAssessmentRefVo> col = new ArrayList<SuitableForSurgeryAssessmentRefVo>();
	public final String getBoClassName()
	{
		return "ims.RefMan.domain.objects.SuitableForSurgeryAssessment";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(SuitableForSurgeryAssessmentRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SuitableForSurgeryAssessmentRefVo value)
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
	public int indexOf(SuitableForSurgeryAssessmentRefVo instance)
	{
		return col.indexOf(instance);
	}
	public SuitableForSurgeryAssessmentRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SuitableForSurgeryAssessmentRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SuitableForSurgeryAssessmentRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SuitableForSurgeryAssessmentRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SuitableForSurgeryAssessmentRefVoCollection clone = new SuitableForSurgeryAssessmentRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SuitableForSurgeryAssessmentRefVo)this.col.get(x).clone());
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
	public SuitableForSurgeryAssessmentRefVo[] toArray()
	{
		SuitableForSurgeryAssessmentRefVo[] arr = new SuitableForSurgeryAssessmentRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public SuitableForSurgeryAssessmentRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SuitableForSurgeryAssessmentRefVoCollection sort(SortOrder order)
	{
		return sort(new SuitableForSurgeryAssessmentRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public SuitableForSurgeryAssessmentRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<SuitableForSurgeryAssessmentRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SuitableForSurgeryAssessmentRefVoComparator implements Comparator
	{
		private int direction = 1;
		public SuitableForSurgeryAssessmentRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SuitableForSurgeryAssessmentRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			SuitableForSurgeryAssessmentRefVo voObj1 = (SuitableForSurgeryAssessmentRefVo)obj1;
			SuitableForSurgeryAssessmentRefVo voObj2 = (SuitableForSurgeryAssessmentRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
