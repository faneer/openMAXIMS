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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.OrderSet business object (ID: 1058100008).
 */
public class OrderSetShortVo extends ims.ocrr.configuration.vo.OrderSetRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderSetShortVo()
	{
	}
	public OrderSetShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderSetShortVo(ims.ocrr.vo.beans.OrderSetShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.color = bean.getColor() == null ? null : bean.getColor().buildColor();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderSetShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.color = bean.getColor() == null ? null : bean.getColor().buildColor();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderSetShortVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderSetShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderSetShortVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("COLOR"))
			return getColor();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getColorIsNotNull()
	{
		return this.color != null;
	}
	public ims.framework.utils.Color getColor()
	{
		return this.color;
	}
	public void setColor(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.color = value;
	}
	/**
	* OrderSetShortVoColorComparator (class definition)
	*/
	public static class OrderSetShortVoColorComparator implements java.util.Comparator
	{
		private int direction = 1;
		public OrderSetShortVoColorComparator()
		{
			this(ims.framework.enumerations.SortOrder.ASCENDING);
		}
		public OrderSetShortVoColorComparator(ims.framework.enumerations.SortOrder order)
		{
			if (order == ims.framework.enumerations.SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			OrderSetShortVo voObj1 = (OrderSetShortVo)obj1;
			OrderSetShortVo voObj2 = (OrderSetShortVo)obj2;
			if(voObj1.getColorIsNotNull() && voObj2.getColorIsNotNull())
				return direction*(voObj1.getColor().compareTo(voObj2.getColor()));
			else
				return direction;
		}
		public boolean equals(Object obj)
		{
			return false;
		}	
	}
	/**
	* getColourComparator - retrieves a new instance of static class OrderSetShortVoColorComparator 
	*/
	public static OrderSetShortVoColorComparator getColourComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OrderSetShortVo.OrderSetShortVoColorComparator(sortOrder);
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.ocrr.vo.OrderSetShortVo] is too big. It should be less or equal to 255");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 255)
			listOfErrors.add("The length of the field [description] in the value object [ims.ocrr.vo.OrderSetShortVo] is too big. It should be less or equal to 255");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
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
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		OrderSetShortVo clone = new OrderSetShortVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		if(this.color == null)
			clone.color = null;
		else
			clone.color = (ims.framework.utils.Color)this.color.clone();
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
		if (!(OrderSetShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderSetShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OrderSetShortVo compareObj = (OrderSetShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
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
		if(this.name != null)
			count++;
		if(this.description != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.color != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected String description;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected ims.framework.utils.Color color;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
