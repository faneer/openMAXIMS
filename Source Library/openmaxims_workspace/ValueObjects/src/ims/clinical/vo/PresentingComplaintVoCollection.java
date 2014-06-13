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

package ims.clinical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to clinical.configuration.PresentingComplaint business object (ID: 1073100003).
 */
public class PresentingComplaintVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PresentingComplaintVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PresentingComplaintVo> col = new ArrayList<PresentingComplaintVo>();
	public String getBoClassName()
	{
		return "ims.clinical.configuration.domain.objects.PresentingComplaint";
	}
	public boolean add(PresentingComplaintVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PresentingComplaintVo value)
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
	public int indexOf(PresentingComplaintVo instance)
	{
		return col.indexOf(instance);
	}
	public PresentingComplaintVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PresentingComplaintVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PresentingComplaintVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PresentingComplaintVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PresentingComplaintVoCollection clone = new PresentingComplaintVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PresentingComplaintVo)this.col.get(x).clone());
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
	public PresentingComplaintVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PresentingComplaintVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PresentingComplaintVoCollection sort(SortOrder order)
	{
		return sort(new PresentingComplaintVoComparator(order));
	}
	public PresentingComplaintVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PresentingComplaintVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PresentingComplaintVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.clinical.configuration.vo.PresentingComplaintRefVoCollection toRefVoCollection()
	{
		ims.clinical.configuration.vo.PresentingComplaintRefVoCollection result = new ims.clinical.configuration.vo.PresentingComplaintRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PresentingComplaintVo[] toArray()
	{
		PresentingComplaintVo[] arr = new PresentingComplaintVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.ICciFull[] toICciFullArray()
	{
		ims.vo.interfaces.ICciFull[] arr = new ims.vo.interfaces.ICciFull[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PresentingComplaintVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PresentingComplaintVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PresentingComplaintVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PresentingComplaintVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PresentingComplaintVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PresentingComplaintVo voObj1 = (PresentingComplaintVo)obj1;
			PresentingComplaintVo voObj2 = (PresentingComplaintVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.PresentingComplaintVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.PresentingComplaintVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.PresentingComplaintVoBean[] result = new ims.clinical.vo.beans.PresentingComplaintVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PresentingComplaintVo vo = ((PresentingComplaintVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.PresentingComplaintVoBean)vo.getBean();
		}
		return result;
	}
	public static PresentingComplaintVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PresentingComplaintVoCollection coll = new PresentingComplaintVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.PresentingComplaintVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PresentingComplaintVoCollection buildFromBeanCollection(ims.clinical.vo.beans.PresentingComplaintVoBean[] beans)
	{
		PresentingComplaintVoCollection coll = new PresentingComplaintVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}