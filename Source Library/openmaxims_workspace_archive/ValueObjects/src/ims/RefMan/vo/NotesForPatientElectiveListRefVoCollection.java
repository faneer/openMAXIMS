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
 * Linked to RefMan.NotesForPatientElectiveList business object (ID: 1096100065).
 */
public class NotesForPatientElectiveListRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<NotesForPatientElectiveListRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<NotesForPatientElectiveListRefVo> col = new ArrayList<NotesForPatientElectiveListRefVo>();
	public final String getBoClassName()
	{
		return "ims.RefMan.domain.objects.NotesForPatientElectiveList";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(NotesForPatientElectiveListRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, NotesForPatientElectiveListRefVo value)
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
	public int indexOf(NotesForPatientElectiveListRefVo instance)
	{
		return col.indexOf(instance);
	}
	public NotesForPatientElectiveListRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, NotesForPatientElectiveListRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(NotesForPatientElectiveListRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(NotesForPatientElectiveListRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		NotesForPatientElectiveListRefVoCollection clone = new NotesForPatientElectiveListRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((NotesForPatientElectiveListRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public NotesForPatientElectiveListRefVo[] toArray()
	{
		NotesForPatientElectiveListRefVo[] arr = new NotesForPatientElectiveListRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public NotesForPatientElectiveListRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public NotesForPatientElectiveListRefVoCollection sort(SortOrder order)
	{
		return sort(new NotesForPatientElectiveListRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public NotesForPatientElectiveListRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<NotesForPatientElectiveListRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class NotesForPatientElectiveListRefVoComparator implements Comparator
	{
		private int direction = 1;
		public NotesForPatientElectiveListRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public NotesForPatientElectiveListRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			NotesForPatientElectiveListRefVo voObj1 = (NotesForPatientElectiveListRefVo)obj1;
			NotesForPatientElectiveListRefVo voObj2 = (NotesForPatientElectiveListRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
