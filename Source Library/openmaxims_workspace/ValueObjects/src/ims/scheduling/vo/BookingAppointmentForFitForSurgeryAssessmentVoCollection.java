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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class BookingAppointmentForFitForSurgeryAssessmentVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<BookingAppointmentForFitForSurgeryAssessmentVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<BookingAppointmentForFitForSurgeryAssessmentVo> col = new ArrayList<BookingAppointmentForFitForSurgeryAssessmentVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Booking_Appointment";
	}
	public boolean add(BookingAppointmentForFitForSurgeryAssessmentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, BookingAppointmentForFitForSurgeryAssessmentVo value)
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
	public int indexOf(BookingAppointmentForFitForSurgeryAssessmentVo instance)
	{
		return col.indexOf(instance);
	}
	public BookingAppointmentForFitForSurgeryAssessmentVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, BookingAppointmentForFitForSurgeryAssessmentVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(BookingAppointmentForFitForSurgeryAssessmentVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(BookingAppointmentForFitForSurgeryAssessmentVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		BookingAppointmentForFitForSurgeryAssessmentVoCollection clone = new BookingAppointmentForFitForSurgeryAssessmentVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((BookingAppointmentForFitForSurgeryAssessmentVo)this.col.get(x).clone());
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
	public BookingAppointmentForFitForSurgeryAssessmentVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public BookingAppointmentForFitForSurgeryAssessmentVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public BookingAppointmentForFitForSurgeryAssessmentVoCollection sort(SortOrder order)
	{
		return sort(new BookingAppointmentForFitForSurgeryAssessmentVoComparator(order));
	}
	public BookingAppointmentForFitForSurgeryAssessmentVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new BookingAppointmentForFitForSurgeryAssessmentVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public BookingAppointmentForFitForSurgeryAssessmentVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.Booking_AppointmentRefVoCollection result = new ims.scheduling.vo.Booking_AppointmentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public BookingAppointmentForFitForSurgeryAssessmentVo[] toArray()
	{
		BookingAppointmentForFitForSurgeryAssessmentVo[] arr = new BookingAppointmentForFitForSurgeryAssessmentVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<BookingAppointmentForFitForSurgeryAssessmentVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class BookingAppointmentForFitForSurgeryAssessmentVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public BookingAppointmentForFitForSurgeryAssessmentVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public BookingAppointmentForFitForSurgeryAssessmentVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public BookingAppointmentForFitForSurgeryAssessmentVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			BookingAppointmentForFitForSurgeryAssessmentVo voObj1 = (BookingAppointmentForFitForSurgeryAssessmentVo)obj1;
			BookingAppointmentForFitForSurgeryAssessmentVo voObj2 = (BookingAppointmentForFitForSurgeryAssessmentVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.BookingAppointmentForFitForSurgeryAssessmentVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.BookingAppointmentForFitForSurgeryAssessmentVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.BookingAppointmentForFitForSurgeryAssessmentVoBean[] result = new ims.scheduling.vo.beans.BookingAppointmentForFitForSurgeryAssessmentVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			BookingAppointmentForFitForSurgeryAssessmentVo vo = ((BookingAppointmentForFitForSurgeryAssessmentVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.BookingAppointmentForFitForSurgeryAssessmentVoBean)vo.getBean();
		}
		return result;
	}
	public static BookingAppointmentForFitForSurgeryAssessmentVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		BookingAppointmentForFitForSurgeryAssessmentVoCollection coll = new BookingAppointmentForFitForSurgeryAssessmentVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.BookingAppointmentForFitForSurgeryAssessmentVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static BookingAppointmentForFitForSurgeryAssessmentVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.BookingAppointmentForFitForSurgeryAssessmentVoBean[] beans)
	{
		BookingAppointmentForFitForSurgeryAssessmentVoCollection coll = new BookingAppointmentForFitForSurgeryAssessmentVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
