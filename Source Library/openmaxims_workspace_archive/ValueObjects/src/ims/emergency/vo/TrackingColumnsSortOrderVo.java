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

package ims.emergency.vo;


public class TrackingColumnsSortOrderVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingColumnsSortOrderVo()
	{
	}
	public TrackingColumnsSortOrderVo(ims.emergency.vo.beans.TrackingColumnsSortOrderVoBean bean)
	{
		this.sortorder = bean.getSortOrder();
		this.columntype = bean.getColumnType() == null ? null : ims.emergency.vo.lookups.TrackingAreaColumn.buildLookup(bean.getColumnType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingColumnsSortOrderVoBean bean)
	{
		this.sortorder = bean.getSortOrder();
		this.columntype = bean.getColumnType() == null ? null : ims.emergency.vo.lookups.TrackingAreaColumn.buildLookup(bean.getColumnType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingColumnsSortOrderVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingColumnsSortOrderVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingColumnsSortOrderVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSortOrderIsNotNull()
	{
		return this.sortorder != null;
	}
	public Boolean getSortOrder()
	{
		return this.sortorder;
	}
	public void setSortOrder(Boolean value)
	{
		this.isValidated = false;
		this.sortorder = value;
	}
	public boolean getColumnTypeIsNotNull()
	{
		return this.columntype != null;
	}
	public ims.emergency.vo.lookups.TrackingAreaColumn getColumnType()
	{
		return this.columntype;
	}
	public void setColumnType(ims.emergency.vo.lookups.TrackingAreaColumn value)
	{
		this.isValidated = false;
		this.columntype = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof TrackingColumnsSortOrderVo))
			return false;
		TrackingColumnsSortOrderVo compareObj = (TrackingColumnsSortOrderVo)obj;
		if(this.getColumnType() == null && compareObj.getColumnType() != null)
			return false;
		if(this.getColumnType() != null && compareObj.getColumnType() == null)
			return false;
		if(this.getColumnType() != null && compareObj.getColumnType() != null)
			if(!this.getColumnType().equals(compareObj.getColumnType()))
				return false;
		if(this.getSortOrder() == null && compareObj.getSortOrder() != null)
			return false;
		if(this.getSortOrder() != null && compareObj.getSortOrder() == null)
			return false;
		if(this.getSortOrder() != null && compareObj.getSortOrder() != null)
			return this.getSortOrder().equals(compareObj.getSortOrder());
		return super.equals(obj);
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		TrackingColumnsSortOrderVo clone = new TrackingColumnsSortOrderVo();
		
		clone.sortorder = this.sortorder;
		if(this.columntype == null)
			clone.columntype = null;
		else
			clone.columntype = (ims.emergency.vo.lookups.TrackingAreaColumn)this.columntype.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(TrackingColumnsSortOrderVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingColumnsSortOrderVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TrackingColumnsSortOrderVo compareObj = (TrackingColumnsSortOrderVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getColumnType() == null && compareObj.getColumnType() != null)
				return -1;
			if(this.getColumnType() != null && compareObj.getColumnType() == null)
				return 1;
			if(this.getColumnType() != null && compareObj.getColumnType() != null)
				retVal = this.getColumnType().compareTo(compareObj.getColumnType());
		}
		if (retVal == 0)
		{
			if(this.getSortOrder() == null && compareObj.getSortOrder() != null)
				return -1;
			if(this.getSortOrder() != null && compareObj.getSortOrder() == null)
				return 1;
			if(this.getSortOrder() != null && compareObj.getSortOrder() != null)
				retVal = this.getSortOrder().compareTo(compareObj.getSortOrder());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.sortorder != null)
			count++;
		if(this.columntype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Boolean sortorder;
	protected ims.emergency.vo.lookups.TrackingAreaColumn columntype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
