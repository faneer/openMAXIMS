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
 * Linked to core.clinical.ServiceFunction business object (ID: 1003100034).
 */
public class ServiceFunctionVo extends ims.core.vo.ServiceFunctionLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ServiceFunctionVo()
	{
	}
	public ServiceFunctionVo(Integer id, int version)
	{
		super(id, version);
	}
	public ServiceFunctionVo(ims.core.vo.beans.ServiceFunctionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.function = bean.getFunction() == null ? null : ims.core.vo.lookups.ServiceFunction.buildLookup(bean.getFunction());
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ServiceFunctionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.function = bean.getFunction() == null ? null : ims.core.vo.lookups.ServiceFunction.buildLookup(bean.getFunction());
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ServiceFunctionVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ServiceFunctionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ServiceFunctionVoBean();
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
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
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
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
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
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.function == null)
			listOfErrors.add("Function is mandatory");
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.taxonomymap != null)
		{
			String[] listOfOtherErrors = this.taxonomymap.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
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
	
		ServiceFunctionVo clone = new ServiceFunctionVo(this.id, this.version);
		
		if(this.function == null)
			clone.function = null;
		else
			clone.function = (ims.core.vo.lookups.ServiceFunction)this.function.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
		clone.isactive = this.isactive;
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
		if (!(ServiceFunctionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ServiceFunctionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ServiceFunctionVo compareObj = (ServiceFunctionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getService() == null && compareObj.getService() != null)
				return -1;
			if(this.getService() != null && compareObj.getService() == null)
				return 1;
			if(this.getService() != null && compareObj.getService() != null)
				retVal = this.getService().compareTo(compareObj.getService());
		}
		if (retVal == 0)
		{
			if(this.getFunction() == null && compareObj.getFunction() != null)
				return -1;
			if(this.getFunction() != null && compareObj.getFunction() == null)
				return 1;
			if(this.getFunction() != null && compareObj.getFunction() != null)
				retVal = this.getFunction().compareTo(compareObj.getFunction());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.service != null)
			count++;
		if(this.taxonomymap != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.core.vo.ServiceShortVo service;
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
