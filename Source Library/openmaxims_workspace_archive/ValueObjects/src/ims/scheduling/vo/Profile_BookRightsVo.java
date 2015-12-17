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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Profile_BookingRight business object (ID: 1005100002).
 */
public class Profile_BookRightsVo extends ims.scheduling.vo.Profile_BookingRightRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Profile_BookRightsVo()
	{
	}
	public Profile_BookRightsVo(Integer id, int version)
	{
		super(id, version);
	}
	public Profile_BookRightsVo(ims.scheduling.vo.beans.Profile_BookRightsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.role = bean.getRole() == null ? null : bean.getRole().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.Profile_BookRightsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.role = bean.getRole() == null ? null : bean.getRole().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.Profile_BookRightsVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.Profile_BookRightsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.Profile_BookRightsVoBean();
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
		if(fieldName.equals("ROLE"))
			return getRole();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRoleIsNotNull()
	{
		return this.role != null;
	}
	public ims.admin.vo.AppRoleShortVo getRole()
	{
		return this.role;
	}
	public void setRole(ims.admin.vo.AppRoleShortVo value)
	{
		this.isValidated = false;
		this.role = value;
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
		if(this.role == null)
			listOfErrors.add("Role is mandatory");
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
	
		Profile_BookRightsVo clone = new Profile_BookRightsVo(this.id, this.version);
		
		if(this.role == null)
			clone.role = null;
		else
			clone.role = (ims.admin.vo.AppRoleShortVo)this.role.clone();
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
		if (!(Profile_BookRightsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Profile_BookRightsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		Profile_BookRightsVo compareObj = (Profile_BookRightsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_Profile_BookingRight() == null && compareObj.getID_Profile_BookingRight() != null)
				return -1;
			if(this.getID_Profile_BookingRight() != null && compareObj.getID_Profile_BookingRight() == null)
				return 1;
			if(this.getID_Profile_BookingRight() != null && compareObj.getID_Profile_BookingRight() != null)
				retVal = this.getID_Profile_BookingRight().compareTo(compareObj.getID_Profile_BookingRight());
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
		if(this.role != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.admin.vo.AppRoleShortVo role;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
