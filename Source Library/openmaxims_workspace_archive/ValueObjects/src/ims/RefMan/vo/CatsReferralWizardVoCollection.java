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
public class CatsReferralWizardVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<CatsReferralWizardVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<CatsReferralWizardVo> col = new ArrayList<CatsReferralWizardVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.CatsReferral";
	}
	public boolean add(CatsReferralWizardVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, CatsReferralWizardVo value)
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
	public int indexOf(CatsReferralWizardVo instance)
	{
		return col.indexOf(instance);
	}
	public CatsReferralWizardVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, CatsReferralWizardVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(CatsReferralWizardVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(CatsReferralWizardVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		CatsReferralWizardVoCollection clone = new CatsReferralWizardVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((CatsReferralWizardVo)this.col.get(x).clone());
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
	public CatsReferralWizardVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public CatsReferralWizardVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public CatsReferralWizardVoCollection sort(SortOrder order)
	{
		return sort(new CatsReferralWizardVoComparator(order));
	}
	public CatsReferralWizardVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new CatsReferralWizardVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public CatsReferralWizardVoCollection sort(Comparator comparator)
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
	public CatsReferralWizardVo[] toArray()
	{
		CatsReferralWizardVo[] arr = new CatsReferralWizardVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<CatsReferralWizardVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class CatsReferralWizardVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public CatsReferralWizardVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public CatsReferralWizardVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public CatsReferralWizardVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			CatsReferralWizardVo voObj1 = (CatsReferralWizardVo)obj1;
			CatsReferralWizardVo voObj2 = (CatsReferralWizardVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.CatsReferralWizardVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.CatsReferralWizardVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.CatsReferralWizardVoBean[] result = new ims.RefMan.vo.beans.CatsReferralWizardVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			CatsReferralWizardVo vo = ((CatsReferralWizardVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.CatsReferralWizardVoBean)vo.getBean();
		}
		return result;
	}
	public static CatsReferralWizardVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		CatsReferralWizardVoCollection coll = new CatsReferralWizardVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.CatsReferralWizardVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static CatsReferralWizardVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.CatsReferralWizardVoBean[] beans)
	{
		CatsReferralWizardVoCollection coll = new CatsReferralWizardVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
