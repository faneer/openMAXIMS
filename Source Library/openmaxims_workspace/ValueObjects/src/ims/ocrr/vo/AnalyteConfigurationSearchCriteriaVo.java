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

package ims.ocrr.vo;


public class AnalyteConfigurationSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AnalyteConfigurationSearchCriteriaVo()
	{
	}
	public AnalyteConfigurationSearchCriteriaVo(ims.ocrr.vo.beans.AnalyteConfigurationSearchCriteriaVoBean bean)
	{
		this.analytecode = bean.getAnalyteCode();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.providersystem = bean.getProviderSystem() == null ? null : bean.getProviderSystem().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.AnalyteConfigurationSearchCriteriaVoBean bean)
	{
		this.analytecode = bean.getAnalyteCode();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.providersystem = bean.getProviderSystem() == null ? null : bean.getProviderSystem().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.AnalyteConfigurationSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.AnalyteConfigurationSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.AnalyteConfigurationSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getAnalyteCodeIsNotNull()
	{
		return this.analytecode != null;
	}
	public String getAnalyteCode()
	{
		return this.analytecode;
	}
	public static int getAnalyteCodeMaxLength()
	{
		return 255;
	}
	public void setAnalyteCode(String value)
	{
		this.isValidated = false;
		this.analytecode = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getProviderSystemIsNotNull()
	{
		return this.providersystem != null;
	}
	public ims.ocrr.vo.ProviderSystemLiteVo getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.ocrr.vo.ProviderSystemLiteVo value)
	{
		this.isValidated = false;
		this.providersystem = value;
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
		if(!(obj instanceof AnalyteConfigurationSearchCriteriaVo))
			return false;
		AnalyteConfigurationSearchCriteriaVo compareObj = (AnalyteConfigurationSearchCriteriaVo)obj;
		if(this.getAnalyteCode() == null && compareObj.getAnalyteCode() != null)
			return false;
		if(this.getAnalyteCode() != null && compareObj.getAnalyteCode() == null)
			return false;
		if(this.getAnalyteCode() != null && compareObj.getAnalyteCode() != null)
			return this.getAnalyteCode().equals(compareObj.getAnalyteCode());
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
	
		AnalyteConfigurationSearchCriteriaVo clone = new AnalyteConfigurationSearchCriteriaVo();
		
		clone.analytecode = this.analytecode;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.providersystem == null)
			clone.providersystem = null;
		else
			clone.providersystem = (ims.ocrr.vo.ProviderSystemLiteVo)this.providersystem.clone();
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
		if (!(AnalyteConfigurationSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AnalyteConfigurationSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AnalyteConfigurationSearchCriteriaVo compareObj = (AnalyteConfigurationSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAnalyteCode() == null && compareObj.getAnalyteCode() != null)
				return -1;
			if(this.getAnalyteCode() != null && compareObj.getAnalyteCode() == null)
				return 1;
			if(this.getAnalyteCode() != null && compareObj.getAnalyteCode() != null)
			{
				if(caseInsensitive)
					retVal = this.getAnalyteCode().toLowerCase().compareTo(compareObj.getAnalyteCode().toLowerCase());
				else
					retVal = this.getAnalyteCode().compareTo(compareObj.getAnalyteCode());
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
		if(this.analytecode != null)
			count++;
		if(this.service != null)
			count++;
		if(this.providersystem != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String analytecode;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.ocrr.vo.ProviderSystemLiteVo providersystem;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
