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

package ims.nursing.vo;

/**
 * Linked to nursing.PlanOfCareNoting business object (ID: 1009100014).
 */
public class PlanOfCareNotingVo extends ims.nursing.vo.PlanOfCareNotingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PlanOfCareNotingVo()
	{
	}
	public PlanOfCareNotingVo(Integer id, int version)
	{
		super(id, version);
	}
	public PlanOfCareNotingVo(ims.nursing.vo.beans.PlanOfCareNotingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.reviewingdatetime = bean.getReviewingDateTime() == null ? null : bean.getReviewingDateTime().buildDateTime();
		this.reviewinghcp = bean.getReviewingHCP() == null ? null : bean.getReviewingHCP().buildVo();
		this.actionstatus = bean.getActionStatus() == null ? null : ims.nursing.vo.lookups.PlanOfCareActionStatus.buildLookup(bean.getActionStatus());
		this.actions = ims.nursing.vo.PlanOfCareActionsVoCollection.buildFromBeanCollection(bean.getActions());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PlanOfCareNotingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.reviewingdatetime = bean.getReviewingDateTime() == null ? null : bean.getReviewingDateTime().buildDateTime();
		this.reviewinghcp = bean.getReviewingHCP() == null ? null : bean.getReviewingHCP().buildVo(map);
		this.actionstatus = bean.getActionStatus() == null ? null : ims.nursing.vo.lookups.PlanOfCareActionStatus.buildLookup(bean.getActionStatus());
		this.actions = ims.nursing.vo.PlanOfCareActionsVoCollection.buildFromBeanCollection(bean.getActions());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PlanOfCareNotingVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PlanOfCareNotingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PlanOfCareNotingVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("REVIEWINGDATETIME"))
			return getReviewingDateTime();
		if(fieldName.equals("REVIEWINGHCP"))
			return getReviewingHCP();
		if(fieldName.equals("ACTIONSTATUS"))
			return getActionStatus();
		if(fieldName.equals("ACTIONS"))
			return getActions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getReviewingDateTimeIsNotNull()
	{
		return this.reviewingdatetime != null;
	}
	public ims.framework.utils.DateTime getReviewingDateTime()
	{
		return this.reviewingdatetime;
	}
	public void setReviewingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.reviewingdatetime = value;
	}
	public boolean getReviewingHCPIsNotNull()
	{
		return this.reviewinghcp != null;
	}
	public ims.core.vo.HcpLiteVo getReviewingHCP()
	{
		return this.reviewinghcp;
	}
	public void setReviewingHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.reviewinghcp = value;
	}
	public boolean getActionStatusIsNotNull()
	{
		return this.actionstatus != null;
	}
	public ims.nursing.vo.lookups.PlanOfCareActionStatus getActionStatus()
	{
		return this.actionstatus;
	}
	public void setActionStatus(ims.nursing.vo.lookups.PlanOfCareActionStatus value)
	{
		this.isValidated = false;
		this.actionstatus = value;
	}
	public boolean getActionsIsNotNull()
	{
		return this.actions != null;
	}
	public ims.nursing.vo.PlanOfCareActionsVoCollection getActions()
	{
		return this.actions;
	}
	public void setActions(ims.nursing.vo.PlanOfCareActionsVoCollection value)
	{
		this.isValidated = false;
		this.actions = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.reviewinghcp != null)
		{
			if(!this.reviewinghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.actions != null)
		{
			if(!this.actions.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.reviewinghcp != null)
		{
			String[] listOfOtherErrors = this.reviewinghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.actions == null || this.actions.size() == 0)
			listOfErrors.add("Actions are mandatory");
		if(this.actions != null)
		{
			String[] listOfOtherErrors = this.actions.validate();
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
	
		PlanOfCareNotingVo clone = new PlanOfCareNotingVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.reviewingdatetime == null)
			clone.reviewingdatetime = null;
		else
			clone.reviewingdatetime = (ims.framework.utils.DateTime)this.reviewingdatetime.clone();
		if(this.reviewinghcp == null)
			clone.reviewinghcp = null;
		else
			clone.reviewinghcp = (ims.core.vo.HcpLiteVo)this.reviewinghcp.clone();
		if(this.actionstatus == null)
			clone.actionstatus = null;
		else
			clone.actionstatus = (ims.nursing.vo.lookups.PlanOfCareActionStatus)this.actionstatus.clone();
		if(this.actions == null)
			clone.actions = null;
		else
			clone.actions = (ims.nursing.vo.PlanOfCareActionsVoCollection)this.actions.clone();
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
		if (!(PlanOfCareNotingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PlanOfCareNotingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PlanOfCareNotingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PlanOfCareNotingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.reviewingdatetime != null)
			count++;
		if(this.reviewinghcp != null)
			count++;
		if(this.actionstatus != null)
			count++;
		if(this.actions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.framework.utils.DateTime reviewingdatetime;
	protected ims.core.vo.HcpLiteVo reviewinghcp;
	protected ims.nursing.vo.lookups.PlanOfCareActionStatus actionstatus;
	protected ims.nursing.vo.PlanOfCareActionsVoCollection actions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
