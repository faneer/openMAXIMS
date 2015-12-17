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

package ims.ocs_if.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.Configuration.Analyte business object (ID: 1061100009).
 */
public class IfAnalyteVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<IfAnalyteVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<IfAnalyteVo> col = new ArrayList<IfAnalyteVo>();
	public String getBoClassName()
	{
		return "ims.ocrr.configuration.domain.objects.Analyte";
	}
	public boolean add(IfAnalyteVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, IfAnalyteVo value)
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
	public int indexOf(IfAnalyteVo instance)
	{
		return col.indexOf(instance);
	}
	public IfAnalyteVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, IfAnalyteVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(IfAnalyteVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(IfAnalyteVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		IfAnalyteVoCollection clone = new IfAnalyteVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((IfAnalyteVo)this.col.get(x).clone());
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
	public IfAnalyteVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public IfAnalyteVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public IfAnalyteVoCollection sort(SortOrder order)
	{
		return sort(new IfAnalyteVoComparator(order));
	}
	public IfAnalyteVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new IfAnalyteVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public IfAnalyteVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.ocrr.configuration.vo.AnalyteRefVoCollection toRefVoCollection()
	{
		ims.ocrr.configuration.vo.AnalyteRefVoCollection result = new ims.ocrr.configuration.vo.AnalyteRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public IfAnalyteVo[] toArray()
	{
		IfAnalyteVo[] arr = new IfAnalyteVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<IfAnalyteVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class IfAnalyteVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public IfAnalyteVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public IfAnalyteVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public IfAnalyteVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			IfAnalyteVo voObj1 = (IfAnalyteVo)obj1;
			IfAnalyteVo voObj2 = (IfAnalyteVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocs_if.vo.beans.IfAnalyteVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocs_if.vo.beans.IfAnalyteVoBean[] getBeanCollectionArray()
	{
		ims.ocs_if.vo.beans.IfAnalyteVoBean[] result = new ims.ocs_if.vo.beans.IfAnalyteVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			IfAnalyteVo vo = ((IfAnalyteVo)col.get(i));
			result[i] = (ims.ocs_if.vo.beans.IfAnalyteVoBean)vo.getBean();
		}
		return result;
	}
	public static IfAnalyteVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		IfAnalyteVoCollection coll = new IfAnalyteVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocs_if.vo.beans.IfAnalyteVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static IfAnalyteVoCollection buildFromBeanCollection(ims.ocs_if.vo.beans.IfAnalyteVoBean[] beans)
	{
		IfAnalyteVoCollection coll = new IfAnalyteVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
