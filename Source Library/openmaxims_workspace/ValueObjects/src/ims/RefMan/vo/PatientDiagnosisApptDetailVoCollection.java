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

package ims.RefMan.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.clinical.PatientDiagnosis business object (ID: 1003100016).
 */
public class PatientDiagnosisApptDetailVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientDiagnosisApptDetailVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientDiagnosisApptDetailVo> col = new ArrayList<PatientDiagnosisApptDetailVo>();
	public String getBoClassName()
	{
		return "ims.core.clinical.domain.objects.PatientDiagnosis";
	}
	public boolean add(PatientDiagnosisApptDetailVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientDiagnosisApptDetailVo value)
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
	public int indexOf(PatientDiagnosisApptDetailVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientDiagnosisApptDetailVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientDiagnosisApptDetailVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientDiagnosisApptDetailVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientDiagnosisApptDetailVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientDiagnosisApptDetailVoCollection clone = new PatientDiagnosisApptDetailVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientDiagnosisApptDetailVo)this.col.get(x).clone());
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
	public PatientDiagnosisApptDetailVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientDiagnosisApptDetailVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientDiagnosisApptDetailVoCollection sort(SortOrder order)
	{
		return sort(new PatientDiagnosisApptDetailVoComparator(order));
	}
	public PatientDiagnosisApptDetailVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientDiagnosisApptDetailVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientDiagnosisApptDetailVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.clinical.vo.PatientDiagnosisRefVoCollection toRefVoCollection()
	{
		ims.core.clinical.vo.PatientDiagnosisRefVoCollection result = new ims.core.clinical.vo.PatientDiagnosisRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientDiagnosisApptDetailVo[] toArray()
	{
		PatientDiagnosisApptDetailVo[] arr = new PatientDiagnosisApptDetailVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IClinicalCodingValue[] toIClinicalCodingValueArray()
	{
		ims.vo.interfaces.IClinicalCodingValue[] arr = new ims.vo.interfaces.IClinicalCodingValue[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientDiagnosisApptDetailVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientDiagnosisApptDetailVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientDiagnosisApptDetailVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientDiagnosisApptDetailVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientDiagnosisApptDetailVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientDiagnosisApptDetailVo voObj1 = (PatientDiagnosisApptDetailVo)obj1;
			PatientDiagnosisApptDetailVo voObj2 = (PatientDiagnosisApptDetailVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.PatientDiagnosisApptDetailVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.PatientDiagnosisApptDetailVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.PatientDiagnosisApptDetailVoBean[] result = new ims.RefMan.vo.beans.PatientDiagnosisApptDetailVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientDiagnosisApptDetailVo vo = ((PatientDiagnosisApptDetailVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.PatientDiagnosisApptDetailVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientDiagnosisApptDetailVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientDiagnosisApptDetailVoCollection coll = new PatientDiagnosisApptDetailVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.PatientDiagnosisApptDetailVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientDiagnosisApptDetailVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.PatientDiagnosisApptDetailVoBean[] beans)
	{
		PatientDiagnosisApptDetailVoCollection coll = new PatientDiagnosisApptDetailVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
