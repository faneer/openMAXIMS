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

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class SessionForAppLinkedVo extends ims.scheduling.vo.Sch_SessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionForAppLinkedVo()
	{
	}
	public SessionForAppLinkedVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionForAppLinkedVo(ims.scheduling.vo.beans.SessionForAppLinkedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo();
		this.name = bean.getName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionForAppLinkedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo(map);
		this.name = bean.getName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionForAppLinkedVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionForAppLinkedVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionForAppLinkedVoBean();
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
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("SCHLOCATION"))
			return getSchLocation();
		if(fieldName.equals("NAME"))
			return getName();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceShortVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceShortVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getSchLocationIsNotNull()
	{
		return this.schlocation != null;
	}
	public ims.core.vo.LocShortVo getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.schlocation = value;
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
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
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
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.SessionForAppLinkedVo] is too big. It should be less or equal to 100");
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
	
		SessionForAppLinkedVo clone = new SessionForAppLinkedVo(this.id, this.version);
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		if(this.schlocation == null)
			clone.schlocation = null;
		else
			clone.schlocation = (ims.core.vo.LocShortVo)this.schlocation.clone();
		clone.name = this.name;
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
		if (!(SessionForAppLinkedVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionForAppLinkedVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionForAppLinkedVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionForAppLinkedVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.service != null)
			count++;
		if(this.schlocation != null)
			count++;
		if(this.name != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.ServiceShortVo service;
	protected ims.core.vo.LocShortVo schlocation;
	protected String name;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
