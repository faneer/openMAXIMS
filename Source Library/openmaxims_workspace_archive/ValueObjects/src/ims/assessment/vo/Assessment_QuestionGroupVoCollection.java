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
 * Linked to Assessment.Configuration.AssessmentQuestionGroup business object (ID: 1003100047).
 */
public class Assessment_QuestionGroupVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<Assessment_QuestionGroupVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Assessment_QuestionGroupVo> col = new ArrayList<Assessment_QuestionGroupVo>();
	public String getBoClassName()
	{
		return "ims.assessment.configuration.domain.objects.AssessmentQuestionGroup";
	}
	public boolean add(Assessment_QuestionGroupVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Assessment_QuestionGroupVo value)
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
	public int indexOf(Assessment_QuestionGroupVo instance)
	{
		return col.indexOf(instance);
	}
	public Assessment_QuestionGroupVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Assessment_QuestionGroupVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Assessment_QuestionGroupVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Assessment_QuestionGroupVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Assessment_QuestionGroupVoCollection clone = new Assessment_QuestionGroupVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Assessment_QuestionGroupVo)this.col.get(x).clone());
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
	public Assessment_QuestionGroupVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Assessment_QuestionGroupVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public Assessment_QuestionGroupVoCollection sort(SortOrder order)
	{
		return sort(new Assessment_QuestionGroupVoComparator(order));
	}
	public Assessment_QuestionGroupVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new Assessment_QuestionGroupVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public Assessment_QuestionGroupVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.assessment.configuration.vo.AssessmentQuestionGroupRefVoCollection toRefVoCollection()
	{
		ims.assessment.configuration.vo.AssessmentQuestionGroupRefVoCollection result = new ims.assessment.configuration.vo.AssessmentQuestionGroupRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public Assessment_QuestionGroupVo[] toArray()
	{
		Assessment_QuestionGroupVo[] arr = new Assessment_QuestionGroupVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<Assessment_QuestionGroupVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Assessment_QuestionGroupVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public Assessment_QuestionGroupVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Assessment_QuestionGroupVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public Assessment_QuestionGroupVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			Assessment_QuestionGroupVo voObj1 = (Assessment_QuestionGroupVo)obj1;
			Assessment_QuestionGroupVo voObj2 = (Assessment_QuestionGroupVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.assessment.vo.beans.Assessment_QuestionGroupVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.assessment.vo.beans.Assessment_QuestionGroupVoBean[] getBeanCollectionArray()
	{
		ims.assessment.vo.beans.Assessment_QuestionGroupVoBean[] result = new ims.assessment.vo.beans.Assessment_QuestionGroupVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			Assessment_QuestionGroupVo vo = ((Assessment_QuestionGroupVo)col.get(i));
			result[i] = (ims.assessment.vo.beans.Assessment_QuestionGroupVoBean)vo.getBean();
		}
		return result;
	}
	public static Assessment_QuestionGroupVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Assessment_QuestionGroupVoCollection coll = new Assessment_QuestionGroupVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.assessment.vo.beans.Assessment_QuestionGroupVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static Assessment_QuestionGroupVoCollection buildFromBeanCollection(ims.assessment.vo.beans.Assessment_QuestionGroupVoBean[] beans)
	{
		Assessment_QuestionGroupVoCollection coll = new Assessment_QuestionGroupVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
