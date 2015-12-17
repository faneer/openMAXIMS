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
 * Linked to core.configuration.ContractConfig business object (ID: 1096100047).
 */
public class ContractConfigForReferralDetailsComponentVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ContractConfigForReferralDetailsComponentVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ContractConfigForReferralDetailsComponentVo> col = new ArrayList<ContractConfigForReferralDetailsComponentVo>();
	public String getBoClassName()
	{
		return "ims.core.configuration.domain.objects.ContractConfig";
	}
	public boolean add(ContractConfigForReferralDetailsComponentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ContractConfigForReferralDetailsComponentVo value)
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
	public int indexOf(ContractConfigForReferralDetailsComponentVo instance)
	{
		return col.indexOf(instance);
	}
	public ContractConfigForReferralDetailsComponentVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ContractConfigForReferralDetailsComponentVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ContractConfigForReferralDetailsComponentVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ContractConfigForReferralDetailsComponentVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ContractConfigForReferralDetailsComponentVoCollection clone = new ContractConfigForReferralDetailsComponentVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ContractConfigForReferralDetailsComponentVo)this.col.get(x).clone());
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
	public ContractConfigForReferralDetailsComponentVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ContractConfigForReferralDetailsComponentVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ContractConfigForReferralDetailsComponentVoCollection sort(SortOrder order)
	{
		return sort(new ContractConfigForReferralDetailsComponentVoComparator(order));
	}
	public ContractConfigForReferralDetailsComponentVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ContractConfigForReferralDetailsComponentVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ContractConfigForReferralDetailsComponentVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.configuration.vo.ContractConfigRefVoCollection toRefVoCollection()
	{
		ims.core.configuration.vo.ContractConfigRefVoCollection result = new ims.core.configuration.vo.ContractConfigRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ContractConfigForReferralDetailsComponentVo[] toArray()
	{
		ContractConfigForReferralDetailsComponentVo[] arr = new ContractConfigForReferralDetailsComponentVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ContractConfigForReferralDetailsComponentVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ContractConfigForReferralDetailsComponentVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ContractConfigForReferralDetailsComponentVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ContractConfigForReferralDetailsComponentVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ContractConfigForReferralDetailsComponentVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ContractConfigForReferralDetailsComponentVo voObj1 = (ContractConfigForReferralDetailsComponentVo)obj1;
			ContractConfigForReferralDetailsComponentVo voObj2 = (ContractConfigForReferralDetailsComponentVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.ContractConfigForReferralDetailsComponentVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.ContractConfigForReferralDetailsComponentVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.ContractConfigForReferralDetailsComponentVoBean[] result = new ims.RefMan.vo.beans.ContractConfigForReferralDetailsComponentVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ContractConfigForReferralDetailsComponentVo vo = ((ContractConfigForReferralDetailsComponentVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.ContractConfigForReferralDetailsComponentVoBean)vo.getBean();
		}
		return result;
	}
	public static ContractConfigForReferralDetailsComponentVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ContractConfigForReferralDetailsComponentVoCollection coll = new ContractConfigForReferralDetailsComponentVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.ContractConfigForReferralDetailsComponentVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ContractConfigForReferralDetailsComponentVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.ContractConfigForReferralDetailsComponentVoBean[] beans)
	{
		ContractConfigForReferralDetailsComponentVoCollection coll = new ContractConfigForReferralDetailsComponentVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
