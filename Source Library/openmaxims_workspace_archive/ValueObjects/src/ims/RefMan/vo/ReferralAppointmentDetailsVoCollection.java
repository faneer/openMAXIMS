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
 * Linked to RefMan.CatsReferral business object (ID: 1004100035).
 */
public class ReferralAppointmentDetailsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ReferralAppointmentDetailsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ReferralAppointmentDetailsVo> col = new ArrayList<ReferralAppointmentDetailsVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.CatsReferral";
	}
	public boolean add(ReferralAppointmentDetailsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ReferralAppointmentDetailsVo value)
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
	public int indexOf(ReferralAppointmentDetailsVo instance)
	{
		return col.indexOf(instance);
	}
	public ReferralAppointmentDetailsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ReferralAppointmentDetailsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ReferralAppointmentDetailsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ReferralAppointmentDetailsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ReferralAppointmentDetailsVoCollection clone = new ReferralAppointmentDetailsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ReferralAppointmentDetailsVo)this.col.get(x).clone());
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
	public ReferralAppointmentDetailsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ReferralAppointmentDetailsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ReferralAppointmentDetailsVoCollection sort(SortOrder order)
	{
		return sort(new ReferralAppointmentDetailsVoComparator(order));
	}
	public ReferralAppointmentDetailsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ReferralAppointmentDetailsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ReferralAppointmentDetailsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.CatsReferralRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.CatsReferralRefVoCollection result = new ims.RefMan.vo.CatsReferralRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ReferralAppointmentDetailsVo[] toArray()
	{
		ReferralAppointmentDetailsVo[] arr = new ReferralAppointmentDetailsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IReferralApptDetail[] toIReferralApptDetailArray()
	{
		ims.vo.interfaces.IReferralApptDetail[] arr = new ims.vo.interfaces.IReferralApptDetail[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ReferralAppointmentDetailsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ReferralAppointmentDetailsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ReferralAppointmentDetailsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ReferralAppointmentDetailsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ReferralAppointmentDetailsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ReferralAppointmentDetailsVo voObj1 = (ReferralAppointmentDetailsVo)obj1;
			ReferralAppointmentDetailsVo voObj2 = (ReferralAppointmentDetailsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.ReferralAppointmentDetailsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.ReferralAppointmentDetailsVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.ReferralAppointmentDetailsVoBean[] result = new ims.RefMan.vo.beans.ReferralAppointmentDetailsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ReferralAppointmentDetailsVo vo = ((ReferralAppointmentDetailsVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.ReferralAppointmentDetailsVoBean)vo.getBean();
		}
		return result;
	}
	public static ReferralAppointmentDetailsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ReferralAppointmentDetailsVoCollection coll = new ReferralAppointmentDetailsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.ReferralAppointmentDetailsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ReferralAppointmentDetailsVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.ReferralAppointmentDetailsVoBean[] beans)
	{
		ReferralAppointmentDetailsVoCollection coll = new ReferralAppointmentDetailsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
