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

package ims.pci.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to PCI.ExportTransactionLog business object (ID: 1091100012).
 */
public class ExportTransactionLogVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ExportTransactionLogVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ExportTransactionLogVo> col = new ArrayList<ExportTransactionLogVo>();
	public String getBoClassName()
	{
		return "ims.pci.domain.objects.ExportTransactionLog";
	}
	public boolean add(ExportTransactionLogVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ExportTransactionLogVo value)
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
	public int indexOf(ExportTransactionLogVo instance)
	{
		return col.indexOf(instance);
	}
	public ExportTransactionLogVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ExportTransactionLogVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ExportTransactionLogVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ExportTransactionLogVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ExportTransactionLogVoCollection clone = new ExportTransactionLogVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ExportTransactionLogVo)this.col.get(x).clone());
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
	public ExportTransactionLogVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ExportTransactionLogVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ExportTransactionLogVoCollection sort(SortOrder order)
	{
		return sort(new ExportTransactionLogVoComparator(order));
	}
	public ExportTransactionLogVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ExportTransactionLogVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ExportTransactionLogVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.pci.vo.ExportTransactionLogRefVoCollection toRefVoCollection()
	{
		ims.pci.vo.ExportTransactionLogRefVoCollection result = new ims.pci.vo.ExportTransactionLogRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ExportTransactionLogVo[] toArray()
	{
		ExportTransactionLogVo[] arr = new ExportTransactionLogVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ExportTransactionLogVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ExportTransactionLogVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ExportTransactionLogVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ExportTransactionLogVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ExportTransactionLogVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ExportTransactionLogVo voObj1 = (ExportTransactionLogVo)obj1;
			ExportTransactionLogVo voObj2 = (ExportTransactionLogVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.pci.vo.beans.ExportTransactionLogVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.pci.vo.beans.ExportTransactionLogVoBean[] getBeanCollectionArray()
	{
		ims.pci.vo.beans.ExportTransactionLogVoBean[] result = new ims.pci.vo.beans.ExportTransactionLogVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ExportTransactionLogVo vo = ((ExportTransactionLogVo)col.get(i));
			result[i] = (ims.pci.vo.beans.ExportTransactionLogVoBean)vo.getBean();
		}
		return result;
	}
	public static ExportTransactionLogVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ExportTransactionLogVoCollection coll = new ExportTransactionLogVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.pci.vo.beans.ExportTransactionLogVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ExportTransactionLogVoCollection buildFromBeanCollection(ims.pci.vo.beans.ExportTransactionLogVoBean[] beans)
	{
		ExportTransactionLogVoCollection coll = new ExportTransactionLogVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
