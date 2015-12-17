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

package ims.pathways.vo;


public class PatientPathwaysAwaitingValidationSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientPathwaysAwaitingValidationSearchCriteriaVo()
	{
	}
	public PatientPathwaysAwaitingValidationSearchCriteriaVo(ims.pathways.vo.beans.PatientPathwaysAwaitingValidationSearchCriteriaVoBean bean)
	{
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.rttincluded = bean.getRttIncluded();
		this.noofweeks = bean.getNoOfWeeks();
		this.notvalidatednoofweeks = bean.getNotValidatedNoOfWeeks();
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatientPathwaysAwaitingValidationSearchCriteriaVoBean bean)
	{
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.rttincluded = bean.getRttIncluded();
		this.noofweeks = bean.getNoOfWeeks();
		this.notvalidatednoofweeks = bean.getNotValidatedNoOfWeeks();
		this.services = ims.core.vo.ServiceShortVoCollection.buildFromBeanCollection(bean.getServices());
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatientPathwaysAwaitingValidationSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatientPathwaysAwaitingValidationSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatientPathwaysAwaitingValidationSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
	}
	public boolean getRttIncludedIsNotNull()
	{
		return this.rttincluded != null;
	}
	public Boolean getRttIncluded()
	{
		return this.rttincluded;
	}
	public void setRttIncluded(Boolean value)
	{
		this.isValidated = false;
		this.rttincluded = value;
	}
	public boolean getNoOfWeeksIsNotNull()
	{
		return this.noofweeks != null;
	}
	public Integer getNoOfWeeks()
	{
		return this.noofweeks;
	}
	public void setNoOfWeeks(Integer value)
	{
		this.isValidated = false;
		this.noofweeks = value;
	}
	public boolean getNotValidatedNoOfWeeksIsNotNull()
	{
		return this.notvalidatednoofweeks != null;
	}
	public Integer getNotValidatedNoOfWeeks()
	{
		return this.notvalidatednoofweeks;
	}
	public void setNotValidatedNoOfWeeks(Integer value)
	{
		this.isValidated = false;
		this.notvalidatednoofweeks = value;
	}
	public boolean getServicesIsNotNull()
	{
		return this.services != null;
	}
	public ims.core.vo.ServiceShortVoCollection getServices()
	{
		return this.services;
	}
	public void setServices(ims.core.vo.ServiceShortVoCollection value)
	{
		this.isValidated = false;
		this.services = value;
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
		if(this.services != null)
		{
			if(!this.services.isValidated())
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
		if(this.services != null)
		{
			String[] listOfOtherErrors = this.services.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		PatientPathwaysAwaitingValidationSearchCriteriaVo clone = new PatientPathwaysAwaitingValidationSearchCriteriaVo();
		
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		clone.rttincluded = this.rttincluded;
		clone.noofweeks = this.noofweeks;
		clone.notvalidatednoofweeks = this.notvalidatednoofweeks;
		if(this.services == null)
			clone.services = null;
		else
			clone.services = (ims.core.vo.ServiceShortVoCollection)this.services.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
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
		if (!(PatientPathwaysAwaitingValidationSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientPathwaysAwaitingValidationSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientPathwaysAwaitingValidationSearchCriteriaVo compareObj = (PatientPathwaysAwaitingValidationSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getEndDate() == null && compareObj.getEndDate() != null)
				return -1;
			if(this.getEndDate() != null && compareObj.getEndDate() == null)
				return 1;
			if(this.getEndDate() != null && compareObj.getEndDate() != null)
				retVal = this.getEndDate().compareTo(compareObj.getEndDate());
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
		if(this.startdate != null)
			count++;
		if(this.enddate != null)
			count++;
		if(this.rttincluded != null)
			count++;
		if(this.noofweeks != null)
			count++;
		if(this.notvalidatednoofweeks != null)
			count++;
		if(this.services != null)
			count++;
		if(this.service != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date enddate;
	protected Boolean rttincluded;
	protected Integer noofweeks;
	protected Integer notvalidatednoofweeks;
	protected ims.core.vo.ServiceShortVoCollection services;
	protected ims.core.vo.ServiceShortVo service;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
