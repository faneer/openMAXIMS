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

package ims.RefMan.vo;

/**
 * Linked to RefMan.CatsReferral business object (ID: 1004100035).
 */
public class CatsReferralBreachDatesVo extends ims.RefMan.vo.CatsReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CatsReferralBreachDatesVo()
	{
	}
	public CatsReferralBreachDatesVo(Integer id, int version)
	{
		super(id, version);
	}
	public CatsReferralBreachDatesVo(ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo();
		this.iscab = bean.getIsCAB();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo();
		this.icabreferral = bean.getICABReferral() == null ? null : bean.getICABReferral().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo(map);
		this.iscab = bean.getIsCAB();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo(map);
		this.icabreferral = bean.getICABReferral() == null ? null : bean.getICABReferral().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean();
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
		if(fieldName.equals("REFERRALDETAILS"))
			return getReferralDetails();
		if(fieldName.equals("ISCAB"))
			return getIsCAB();
		if(fieldName.equals("CURRENTRTTSTATUS"))
			return getCurrentRTTStatus();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CONTRACT"))
			return getContract();
		if(fieldName.equals("ICABREFERRAL"))
			return getICABReferral();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferralDetailsIsNotNull()
	{
		return this.referraldetails != null;
	}
	public ims.RefMan.vo.ReferralLetterDetailsClinicListListVo getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.RefMan.vo.ReferralLetterDetailsClinicListListVo value)
	{
		this.isValidated = false;
		this.referraldetails = value;
	}
	public boolean getIsCABIsNotNull()
	{
		return this.iscab != null;
	}
	public Boolean getIsCAB()
	{
		return this.iscab;
	}
	public void setIsCAB(Boolean value)
	{
		this.isValidated = false;
		this.iscab = value;
	}
	public boolean getCurrentRTTStatusIsNotNull()
	{
		return this.currentrttstatus != null;
	}
	public ims.pathways.vo.PathwayRTTStatusVo getCurrentRTTStatus()
	{
		return this.currentrttstatus;
	}
	public void setCurrentRTTStatus(ims.pathways.vo.PathwayRTTStatusVo value)
	{
		this.isValidated = false;
		this.currentrttstatus = value;
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
	public boolean getContractIsNotNull()
	{
		return this.contract != null;
	}
	public ims.RefMan.vo.ContractConfigShortVo getContract()
	{
		return this.contract;
	}
	public void setContract(ims.RefMan.vo.ContractConfigShortVo value)
	{
		this.isValidated = false;
		this.contract = value;
	}
	public boolean getICABReferralIsNotNull()
	{
		return this.icabreferral != null;
	}
	public ims.admin.vo.ICABReferralLiteVo getICABReferral()
	{
		return this.icabreferral;
	}
	public void setICABReferral(ims.admin.vo.ICABReferralLiteVo value)
	{
		this.isValidated = false;
		this.icabreferral = value;
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
		if(this.currentrttstatus != null)
		{
			if(!this.currentrttstatus.isValidated())
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
		if(this.currentrttstatus != null)
		{
			String[] listOfOtherErrors = this.currentrttstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		CatsReferralBreachDatesVo clone = new CatsReferralBreachDatesVo(this.id, this.version);
		
		if(this.referraldetails == null)
			clone.referraldetails = null;
		else
			clone.referraldetails = (ims.RefMan.vo.ReferralLetterDetailsClinicListListVo)this.referraldetails.clone();
		clone.iscab = this.iscab;
		if(this.currentrttstatus == null)
			clone.currentrttstatus = null;
		else
			clone.currentrttstatus = (ims.pathways.vo.PathwayRTTStatusVo)this.currentrttstatus.clone();
		clone.carecontext = this.carecontext;
		if(this.contract == null)
			clone.contract = null;
		else
			clone.contract = (ims.RefMan.vo.ContractConfigShortVo)this.contract.clone();
		if(this.icabreferral == null)
			clone.icabreferral = null;
		else
			clone.icabreferral = (ims.admin.vo.ICABReferralLiteVo)this.icabreferral.clone();
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
		if (!(CatsReferralBreachDatesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatsReferralBreachDatesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CatsReferralBreachDatesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CatsReferralBreachDatesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.referraldetails != null)
			count++;
		if(this.iscab != null)
			count++;
		if(this.currentrttstatus != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.contract != null)
			count++;
		if(this.icabreferral != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.RefMan.vo.ReferralLetterDetailsClinicListListVo referraldetails;
	protected Boolean iscab;
	protected ims.pathways.vo.PathwayRTTStatusVo currentrttstatus;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.RefMan.vo.ContractConfigShortVo contract;
	protected ims.admin.vo.ICABReferralLiteVo icabreferral;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
