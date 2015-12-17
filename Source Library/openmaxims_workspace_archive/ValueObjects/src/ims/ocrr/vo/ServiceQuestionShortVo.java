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
 * Linked to OCRR.Configuration.ServiceQuestion business object (ID: 1061100008).
 */
public class ServiceQuestionShortVo extends ims.ocrr.configuration.vo.ServiceQuestionRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IQuestionType
{
	private static final long serialVersionUID = 1L;

	public ServiceQuestionShortVo()
	{
	}
	public ServiceQuestionShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public ServiceQuestionShortVo(ims.ocrr.vo.beans.ServiceQuestionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.ismandatory = bean.getIsMandatory();
		this.askforinvestigations = bean.getAskForInvestigations();
		this.questioninformation = bean.getQuestionInformation() == null ? null : bean.getQuestionInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ServiceQuestionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.ismandatory = bean.getIsMandatory();
		this.askforinvestigations = bean.getAskForInvestigations();
		this.questioninformation = bean.getQuestionInformation() == null ? null : bean.getQuestionInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ServiceQuestionShortVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ServiceQuestionShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ServiceQuestionShortVoBean();
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
		if(fieldName.equals("ISMANDATORY"))
			return getIsMandatory();
		if(fieldName.equals("ASKFORINVESTIGATIONS"))
			return getAskForInvestigations();
		if(fieldName.equals("QUESTIONINFORMATION"))
			return getQuestionInformation();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getIsMandatoryIsNotNull()
	{
		return this.ismandatory != null;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.isValidated = false;
		this.ismandatory = value;
	}
	public boolean getAskForInvestigationsIsNotNull()
	{
		return this.askforinvestigations != null;
	}
	public Boolean getAskForInvestigations()
	{
		return this.askforinvestigations;
	}
	public void setAskForInvestigations(Boolean value)
	{
		this.isValidated = false;
		this.askforinvestigations = value;
	}
	public boolean getQuestionInformationIsNotNull()
	{
		return this.questioninformation != null;
	}
	public ims.core.vo.QuestionInformationShortVo getQuestionInformation()
	{
		return this.questioninformation;
	}
	public void setQuestionInformation(ims.core.vo.QuestionInformationShortVo value)
	{
		this.isValidated = false;
		this.questioninformation = value;
	}
	/**
	* IQuestionType interface methods
	*/
	public ims.core.vo.QuestionInformationShortVo getIQuestionTypeQuestion() 
	{	
		return this.questioninformation;
	}
	public ims.ocrr.vo.lookups.OrderQuestionType getIQuestionTypeOrderQuestionType() 
	{
		return ims.ocrr.vo.lookups.OrderQuestionType.SERVICE;
	}
	public Boolean getIQuestionTypeIsMandatory()
	{
		return getIsMandatory();
	}
	public String getIQuestionTypeItemName()
	{
		return service != null ? service.getServiceName() : "";
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
		if(this.questioninformation != null)
		{
			if(!this.questioninformation.isValidated())
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
		if(this.askforinvestigations == null)
			listOfErrors.add("askForInvestigations is mandatory");
		if(this.questioninformation == null)
			listOfErrors.add("QuestionInformation is mandatory");
		if(this.questioninformation != null)
		{
			String[] listOfOtherErrors = this.questioninformation.validate();
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
	
		ServiceQuestionShortVo clone = new ServiceQuestionShortVo(this.id, this.version);
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		clone.ismandatory = this.ismandatory;
		clone.askforinvestigations = this.askforinvestigations;
		if(this.questioninformation == null)
			clone.questioninformation = null;
		else
			clone.questioninformation = (ims.core.vo.QuestionInformationShortVo)this.questioninformation.clone();
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
		if (!(ServiceQuestionShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ServiceQuestionShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ServiceQuestionShortVo compareObj = (ServiceQuestionShortVo)obj;
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
			if(this.getQuestionInformation() == null && compareObj.getQuestionInformation() != null)
				return -1;
			if(this.getQuestionInformation() != null && compareObj.getQuestionInformation() == null)
				return 1;
			if(this.getQuestionInformation() != null && compareObj.getQuestionInformation() != null)
				retVal = this.getQuestionInformation().compareTo(compareObj.getQuestionInformation());
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
		if(this.service != null)
			count++;
		if(this.ismandatory != null)
			count++;
		if(this.askforinvestigations != null)
			count++;
		if(this.questioninformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.ServiceLiteVo service;
	protected Boolean ismandatory;
	protected Boolean askforinvestigations;
	protected ims.core.vo.QuestionInformationShortVo questioninformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
