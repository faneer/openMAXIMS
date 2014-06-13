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

package ims.chooseandbook.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to choose_book.Conversation business object (ID: 1069100004).
 */
public class ApptConfirmConvVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ApptConfirmConvVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ApptConfirmConvVo> col = new ArrayList<ApptConfirmConvVo>();
	public String getBoClassName()
	{
		return "ims.choose_book.domain.objects.Conversation";
	}
	public boolean add(ApptConfirmConvVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ApptConfirmConvVo value)
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
	public int indexOf(ApptConfirmConvVo instance)
	{
		return col.indexOf(instance);
	}
	public ApptConfirmConvVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ApptConfirmConvVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ApptConfirmConvVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ApptConfirmConvVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ApptConfirmConvVoCollection clone = new ApptConfirmConvVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ApptConfirmConvVo)this.col.get(x).clone());
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
	public ApptConfirmConvVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ApptConfirmConvVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ApptConfirmConvVoCollection sort(SortOrder order)
	{
		return sort(new ApptConfirmConvVoComparator(order));
	}
	public ApptConfirmConvVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ApptConfirmConvVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ApptConfirmConvVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.choose_book.vo.ConversationRefVoCollection toRefVoCollection()
	{
		ims.choose_book.vo.ConversationRefVoCollection result = new ims.choose_book.vo.ConversationRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ApptConfirmConvVo[] toArray()
	{
		ApptConfirmConvVo[] arr = new ApptConfirmConvVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ApptConfirmConvVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ApptConfirmConvVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ApptConfirmConvVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ApptConfirmConvVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ApptConfirmConvVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ApptConfirmConvVo voObj1 = (ApptConfirmConvVo)obj1;
			ApptConfirmConvVo voObj2 = (ApptConfirmConvVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.chooseandbook.vo.beans.ApptConfirmConvVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.chooseandbook.vo.beans.ApptConfirmConvVoBean[] getBeanCollectionArray()
	{
		ims.chooseandbook.vo.beans.ApptConfirmConvVoBean[] result = new ims.chooseandbook.vo.beans.ApptConfirmConvVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ApptConfirmConvVo vo = ((ApptConfirmConvVo)col.get(i));
			result[i] = (ims.chooseandbook.vo.beans.ApptConfirmConvVoBean)vo.getBean();
		}
		return result;
	}
	public static ApptConfirmConvVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ApptConfirmConvVoCollection coll = new ApptConfirmConvVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.chooseandbook.vo.beans.ApptConfirmConvVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ApptConfirmConvVoCollection buildFromBeanCollection(ims.chooseandbook.vo.beans.ApptConfirmConvVoBean[] beans)
	{
		ApptConfirmConvVoCollection coll = new ApptConfirmConvVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}