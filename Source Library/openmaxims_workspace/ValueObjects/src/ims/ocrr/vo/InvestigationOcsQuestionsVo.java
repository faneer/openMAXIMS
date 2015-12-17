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

/**
 * Linked to OCRR.Configuration.Investigation business object (ID: 1058100001).
 */
public class InvestigationOcsQuestionsVo extends ims.ocrr.vo.InvestigationLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InvestigationOcsQuestionsVo()
	{
	}
	public InvestigationOcsQuestionsVo(Integer id, int version)
	{
		super(id, version);
	}
	public InvestigationOcsQuestionsVo(ims.ocrr.vo.beans.InvestigationOcsQuestionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigationindex = bean.getInvestigationIndex() == null ? null : bean.getInvestigationIndex().buildVo();
		this.providerservice = bean.getProviderService() == null ? null : bean.getProviderService().buildVo();
		this.pathinvdetails = bean.getPathInvDetails() == null ? null : bean.getPathInvDetails().buildVo();
		this.eventtype = bean.getEventType() == null ? null : ims.ocrr.vo.lookups.InvEventType.buildLookup(bean.getEventType());
		this.assocquestions = ims.ocrr.vo.InvestigationQuestionShortVoCollection.buildFromBeanCollection(bean.getAssocQuestions());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.InvestigationOcsQuestionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigationindex = bean.getInvestigationIndex() == null ? null : bean.getInvestigationIndex().buildVo(map);
		this.providerservice = bean.getProviderService() == null ? null : bean.getProviderService().buildVo(map);
		this.pathinvdetails = bean.getPathInvDetails() == null ? null : bean.getPathInvDetails().buildVo(map);
		this.eventtype = bean.getEventType() == null ? null : ims.ocrr.vo.lookups.InvEventType.buildLookup(bean.getEventType());
		this.assocquestions = ims.ocrr.vo.InvestigationQuestionShortVoCollection.buildFromBeanCollection(bean.getAssocQuestions());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.InvestigationOcsQuestionsVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.InvestigationOcsQuestionsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.InvestigationOcsQuestionsVoBean();
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
		if(fieldName.equals("ASSOCQUESTIONS"))
			return getAssocQuestions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssocQuestionsIsNotNull()
	{
		return this.assocquestions != null;
	}
	public ims.ocrr.vo.InvestigationQuestionShortVoCollection getAssocQuestions()
	{
		return this.assocquestions;
	}
	public void setAssocQuestions(ims.ocrr.vo.InvestigationQuestionShortVoCollection value)
	{
		this.isValidated = false;
		this.assocquestions = value;
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
		if(this.investigationindex != null)
		{
			if(!this.investigationindex.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.providerservice != null)
		{
			if(!this.providerservice.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.assocquestions != null)
		{
			if(!this.assocquestions.isValidated())
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
		if(this.investigationindex == null)
			listOfErrors.add("InvestigationIndex is mandatory");
		if(this.investigationindex != null)
		{
			String[] listOfOtherErrors = this.investigationindex.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.providerservice != null)
		{
			String[] listOfOtherErrors = this.providerservice.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.eventtype == null)
			listOfErrors.add("EventType is mandatory");
		if(this.assocquestions != null)
		{
			String[] listOfOtherErrors = this.assocquestions.validate();
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
	
		InvestigationOcsQuestionsVo clone = new InvestigationOcsQuestionsVo(this.id, this.version);
		
		if(this.investigationindex == null)
			clone.investigationindex = null;
		else
			clone.investigationindex = (ims.ocrr.vo.InvestigationIndexLiteVo)this.investigationindex.clone();
		if(this.providerservice == null)
			clone.providerservice = null;
		else
			clone.providerservice = (ims.ocrr.vo.ProviderServiceOcsVo)this.providerservice.clone();
		if(this.pathinvdetails == null)
			clone.pathinvdetails = null;
		else
			clone.pathinvdetails = (ims.ocrr.vo.PathInvDetailsForNewResultInvestigationVo)this.pathinvdetails.clone();
		if(this.eventtype == null)
			clone.eventtype = null;
		else
			clone.eventtype = (ims.ocrr.vo.lookups.InvEventType)this.eventtype.clone();
		if(this.assocquestions == null)
			clone.assocquestions = null;
		else
			clone.assocquestions = (ims.ocrr.vo.InvestigationQuestionShortVoCollection)this.assocquestions.clone();
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
		if (!(InvestigationOcsQuestionsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InvestigationOcsQuestionsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InvestigationOcsQuestionsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InvestigationOcsQuestionsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.assocquestions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.ocrr.vo.InvestigationQuestionShortVoCollection assocquestions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
