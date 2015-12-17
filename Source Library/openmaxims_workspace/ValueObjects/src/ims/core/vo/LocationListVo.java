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

package ims.core.vo;

/**
 * Linked to core.resource.place.Location business object (ID: 1007100007).
 */
public class LocationListVo extends ims.core.resource.place.vo.LocationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LocationListVo()
	{
	}
	public LocationListVo(Integer id, int version)
	{
		super(id, version);
	}
	public LocationListVo(ims.core.vo.beans.LocationListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.LocationType.buildLookup(bean.getType());
		this.parentlocation = bean.getParentLocation() == null ? null : bean.getParentLocation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.LocationListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.LocationType.buildLookup(bean.getType());
		this.parentlocation = bean.getParentLocation() == null ? null : bean.getParentLocation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.LocationListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.LocationListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.LocationListVoBean();
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
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("PARENTLOCATION"))
			return getParentLocation();
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
		return 120;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public ims.core.vo.AddressVo getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.AddressVo value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.core.vo.lookups.LocationType getType()
	{
		return this.type;
	}
	public void setType(ims.core.vo.lookups.LocationType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getParentLocationIsNotNull()
	{
		return this.parentlocation != null;
	}
	public ims.core.vo.LocationListVo getParentLocation()
	{
		return this.parentlocation;
	}
	public void setParentLocation(ims.core.vo.LocationListVo value)
	{
		this.isValidated = false;
		this.parentlocation = value;
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
		else if(this.name.length() > 120)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.LocationListVo] is too big. It should be less or equal to 120");
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
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
	
		LocationListVo clone = new LocationListVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.AddressVo)this.address.clone();
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.core.vo.lookups.LocationType)this.type.clone();
		if(this.parentlocation == null)
			clone.parentlocation = null;
		else
			clone.parentlocation = (ims.core.vo.LocationListVo)this.parentlocation.clone();
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
		if (!(LocationListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LocationListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((LocationListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((LocationListVo)obj).getBoId());
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
		if(this.address != null)
			count++;
		if(this.type != null)
			count++;
		if(this.parentlocation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected ims.core.vo.AddressVo address;
	protected ims.core.vo.lookups.LocationType type;
	protected ims.core.vo.LocationListVo parentlocation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
