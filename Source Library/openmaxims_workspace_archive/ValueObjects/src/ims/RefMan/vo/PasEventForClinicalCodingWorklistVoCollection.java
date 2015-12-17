// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.admin.pas.PAS Event business object (ID: 1014100003).
 */
public class PasEventForClinicalCodingWorklistVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PasEventForClinicalCodingWorklistVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PasEventForClinicalCodingWorklistVo> col = new ArrayList<PasEventForClinicalCodingWorklistVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.pas.domain.objects.PASEvent";
	}
	public boolean add(PasEventForClinicalCodingWorklistVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PasEventForClinicalCodingWorklistVo value)
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
	public int indexOf(PasEventForClinicalCodingWorklistVo instance)
	{
		return col.indexOf(instance);
	}
	public PasEventForClinicalCodingWorklistVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PasEventForClinicalCodingWorklistVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PasEventForClinicalCodingWorklistVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PasEventForClinicalCodingWorklistVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PasEventForClinicalCodingWorklistVoCollection clone = new PasEventForClinicalCodingWorklistVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PasEventForClinicalCodingWorklistVo)this.col.get(x).clone());
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
	public PasEventForClinicalCodingWorklistVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PasEventForClinicalCodingWorklistVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PasEventForClinicalCodingWorklistVoCollection sort(SortOrder order)
	{
		return sort(new PasEventForClinicalCodingWorklistVoComparator(order));
	}
	public PasEventForClinicalCodingWorklistVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PasEventForClinicalCodingWorklistVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PasEventForClinicalCodingWorklistVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.pas.vo.PASEventRefVoCollection toRefVoCollection()
	{
		ims.core.admin.pas.vo.PASEventRefVoCollection result = new ims.core.admin.pas.vo.PASEventRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PasEventForClinicalCodingWorklistVo[] toArray()
	{
		PasEventForClinicalCodingWorklistVo[] arr = new PasEventForClinicalCodingWorklistVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PasEventForClinicalCodingWorklistVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PasEventForClinicalCodingWorklistVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PasEventForClinicalCodingWorklistVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PasEventForClinicalCodingWorklistVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PasEventForClinicalCodingWorklistVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PasEventForClinicalCodingWorklistVo voObj1 = (PasEventForClinicalCodingWorklistVo)obj1;
			PasEventForClinicalCodingWorklistVo voObj2 = (PasEventForClinicalCodingWorklistVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean[] result = new ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PasEventForClinicalCodingWorklistVo vo = ((PasEventForClinicalCodingWorklistVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean)vo.getBean();
		}
		return result;
	}
	public static PasEventForClinicalCodingWorklistVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PasEventForClinicalCodingWorklistVoCollection coll = new PasEventForClinicalCodingWorklistVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PasEventForClinicalCodingWorklistVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.PasEventForClinicalCodingWorklistVoBean[] beans)
	{
		PasEventForClinicalCodingWorklistVoCollection coll = new PasEventForClinicalCodingWorklistVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
