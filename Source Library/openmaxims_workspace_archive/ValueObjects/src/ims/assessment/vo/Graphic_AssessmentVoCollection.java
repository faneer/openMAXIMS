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

package ims.assessment.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Assessment.Configuration.GraphicAssessment business object (ID: 1028100006).
 */
public class Graphic_AssessmentVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<Graphic_AssessmentVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Graphic_AssessmentVo> col = new ArrayList<Graphic_AssessmentVo>();
	public String getBoClassName()
	{
		return "ims.assessment.configuration.domain.objects.GraphicAssessment";
	}
	public boolean add(Graphic_AssessmentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Graphic_AssessmentVo value)
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
	public int indexOf(Graphic_AssessmentVo instance)
	{
		return col.indexOf(instance);
	}
	public Graphic_AssessmentVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Graphic_AssessmentVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Graphic_AssessmentVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Graphic_AssessmentVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Graphic_AssessmentVoCollection clone = new Graphic_AssessmentVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Graphic_AssessmentVo)this.col.get(x).clone());
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
	public Graphic_AssessmentVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Graphic_AssessmentVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public Graphic_AssessmentVoCollection sort(SortOrder order)
	{
		return sort(new Graphic_AssessmentVoComparator(order));
	}
	public Graphic_AssessmentVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new Graphic_AssessmentVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public Graphic_AssessmentVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.assessment.configuration.vo.GraphicAssessmentRefVoCollection toRefVoCollection()
	{
		ims.assessment.configuration.vo.GraphicAssessmentRefVoCollection result = new ims.assessment.configuration.vo.GraphicAssessmentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public Graphic_AssessmentVo[] toArray()
	{
		Graphic_AssessmentVo[] arr = new Graphic_AssessmentVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<Graphic_AssessmentVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Graphic_AssessmentVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public Graphic_AssessmentVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Graphic_AssessmentVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public Graphic_AssessmentVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			Graphic_AssessmentVo voObj1 = (Graphic_AssessmentVo)obj1;
			Graphic_AssessmentVo voObj2 = (Graphic_AssessmentVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.assessment.vo.beans.Graphic_AssessmentVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.assessment.vo.beans.Graphic_AssessmentVoBean[] getBeanCollectionArray()
	{
		ims.assessment.vo.beans.Graphic_AssessmentVoBean[] result = new ims.assessment.vo.beans.Graphic_AssessmentVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			Graphic_AssessmentVo vo = ((Graphic_AssessmentVo)col.get(i));
			result[i] = (ims.assessment.vo.beans.Graphic_AssessmentVoBean)vo.getBean();
		}
		return result;
	}
	public static Graphic_AssessmentVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Graphic_AssessmentVoCollection coll = new Graphic_AssessmentVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.assessment.vo.beans.Graphic_AssessmentVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static Graphic_AssessmentVoCollection buildFromBeanCollection(ims.assessment.vo.beans.Graphic_AssessmentVoBean[] beans)
	{
		Graphic_AssessmentVoCollection coll = new Graphic_AssessmentVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
