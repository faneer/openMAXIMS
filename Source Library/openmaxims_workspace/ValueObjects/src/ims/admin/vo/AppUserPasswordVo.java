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

package ims.admin.vo;

/**
 * Linked to core.configuration.AppUserPassword business object (ID: 1028100048).
 */
public class AppUserPasswordVo extends ims.core.configuration.vo.AppUserPasswordRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppUserPasswordVo()
	{
	}
	public AppUserPasswordVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppUserPasswordVo(ims.admin.vo.beans.AppUserPasswordVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.encodedpassword = bean.getEncodedPassword();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppUserPasswordVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.encodedpassword = bean.getEncodedPassword();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppUserPasswordVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppUserPasswordVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppUserPasswordVoBean();
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
		if(fieldName.equals("DATETIME"))
			return getDateTime();
		if(fieldName.equals("ENCODEDPASSWORD"))
			return getEncodedPassword();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateTimeIsNotNull()
	{
		return this.datetime != null;
	}
	public ims.framework.utils.DateTime getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetime = value;
	}
	public boolean getEncodedPasswordIsNotNull()
	{
		return this.encodedpassword != null;
	}
	public String getEncodedPassword()
	{
		return this.encodedpassword;
	}
	public static int getEncodedPasswordMaxLength()
	{
		return 255;
	}
	public void setEncodedPassword(String value)
	{
		this.isValidated = false;
		this.encodedpassword = value;
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
		if(this.datetime == null)
			listOfErrors.add("DateTime is mandatory");
		if(this.encodedpassword == null || this.encodedpassword.length() == 0)
			listOfErrors.add("EncodedPassword is mandatory");
		else if(this.encodedpassword.length() > 255)
			listOfErrors.add("The length of the field [encodedpassword] in the value object [ims.admin.vo.AppUserPasswordVo] is too big. It should be less or equal to 255");
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
	
		AppUserPasswordVo clone = new AppUserPasswordVo(this.id, this.version);
		
		if(this.datetime == null)
			clone.datetime = null;
		else
			clone.datetime = (ims.framework.utils.DateTime)this.datetime.clone();
		clone.encodedpassword = this.encodedpassword;
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
		if (!(AppUserPasswordVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppUserPasswordVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppUserPasswordVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppUserPasswordVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.datetime != null)
			count++;
		if(this.encodedpassword != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.framework.utils.DateTime datetime;
	protected String encodedpassword;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
