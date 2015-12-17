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
 * Linked to core.generic.GenericIdentifier business object (ID: 1002100007).
 */
public class GenericIdentifierVo extends ims.core.generic.vo.GenericIdentifierRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.IGenericIdentifier
{
	private static final long serialVersionUID = 1L;

	public GenericIdentifierVo()
	{
	}
	public GenericIdentifierVo(Integer id, int version)
	{
		super(id, version);
	}
	public GenericIdentifierVo(ims.core.vo.beans.GenericIdentifierVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.classname = bean.getClassName();
		this.instanceid = bean.getInstanceId();
		this.classtype = bean.getClassType();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.GenericIdentifierVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.classname = bean.getClassName();
		this.instanceid = bean.getInstanceId();
		this.classtype = bean.getClassType();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.GenericIdentifierVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.GenericIdentifierVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.GenericIdentifierVoBean();
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
		if(fieldName.equals("CLASSNAME"))
			return getClassName();
		if(fieldName.equals("INSTANCEID"))
			return getInstanceId();
		if(fieldName.equals("CLASSTYPE"))
			return getClassType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClassNameIsNotNull()
	{
		return this.classname != null;
	}
	public String getClassName()
	{
		return this.classname;
	}
	public static int getClassNameMaxLength()
	{
		return 200;
	}
	public void setClassName(String value)
	{
		this.isValidated = false;
		this.classname = value;
	}
	public boolean getInstanceIdIsNotNull()
	{
		return this.instanceid != null;
	}
	public Integer getInstanceId()
	{
		return this.instanceid;
	}
	public void setInstanceId(Integer value)
	{
		this.isValidated = false;
		this.instanceid = value;
	}
	public boolean getClassTypeIsNotNull()
	{
		return this.classtype != null;
	}
	public String getClassType()
	{
		return this.classtype;
	}
	public static int getClassTypeMaxLength()
	{
		return 255;
	}
	public void setClassType(String value)
	{
		this.isValidated = false;
		this.classtype = value;
	}
	/**
	* IGenericIdentifier interface methods
	*/
		public int getId()
		{
			if (instanceid != null)
				return instanceid.intValue();
			else
				return 0;
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
		if(this.classname != null)
			if(this.classname.length() > 200)
				listOfErrors.add("The length of the field [classname] in the value object [ims.core.vo.GenericIdentifierVo] is too big. It should be less or equal to 200");
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
	
		GenericIdentifierVo clone = new GenericIdentifierVo(this.id, this.version);
		
		clone.classname = this.classname;
		clone.instanceid = this.instanceid;
		clone.classtype = this.classtype;
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
		if (!(GenericIdentifierVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GenericIdentifierVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((GenericIdentifierVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((GenericIdentifierVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.classname != null)
			count++;
		if(this.instanceid != null)
			count++;
		if(this.classtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String classname;
	protected Integer instanceid;
	protected String classtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
