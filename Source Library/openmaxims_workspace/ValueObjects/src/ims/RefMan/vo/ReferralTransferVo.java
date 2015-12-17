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
 * Linked to RefMan.ReferralTransfer business object (ID: 1096100070).
 */
public class ReferralTransferVo extends ims.RefMan.vo.ReferralTransferRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralTransferVo()
	{
	}
	public ReferralTransferVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralTransferVo(ims.RefMan.vo.beans.ReferralTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.otherpatientnumber = bean.getOtherPatientNumber();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo();
		this.otherorganisationcode = bean.getOTherOrganisationCode() == null ? null : ims.RefMan.vo.lookups.OtherProviders.buildLookup(bean.getOTherOrganisationCode());
		this.referringorganisationcode = bean.getReferringOrganisationCode();
		this.pathwayid = bean.getPathwayID();
		this.rttstartdate = bean.getRTTStartDate() == null ? null : bean.getRTTStartDate().buildDate();
		this.rttstatusdate = bean.getRTTStatusDate() == null ? null : bean.getRTTStatusDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ReferralTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.otherpatientnumber = bean.getOtherPatientNumber();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo(map);
		this.otherorganisationcode = bean.getOTherOrganisationCode() == null ? null : ims.RefMan.vo.lookups.OtherProviders.buildLookup(bean.getOTherOrganisationCode());
		this.referringorganisationcode = bean.getReferringOrganisationCode();
		this.pathwayid = bean.getPathwayID();
		this.rttstartdate = bean.getRTTStartDate() == null ? null : bean.getRTTStartDate().buildDate();
		this.rttstatusdate = bean.getRTTStatusDate() == null ? null : bean.getRTTStatusDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ReferralTransferVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ReferralTransferVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ReferralTransferVoBean();
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
		if(fieldName.equals("OTHERPATIENTNUMBER"))
			return getOtherPatientNumber();
		if(fieldName.equals("CURRENTRTTSTATUS"))
			return getCurrentRTTStatus();
		if(fieldName.equals("OTHERORGANISATIONCODE"))
			return getOTherOrganisationCode();
		if(fieldName.equals("REFERRINGORGANISATIONCODE"))
			return getReferringOrganisationCode();
		if(fieldName.equals("PATHWAYID"))
			return getPathwayID();
		if(fieldName.equals("RTTSTARTDATE"))
			return getRTTStartDate();
		if(fieldName.equals("RTTSTATUSDATE"))
			return getRTTStatusDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOtherPatientNumberIsNotNull()
	{
		return this.otherpatientnumber != null;
	}
	public String getOtherPatientNumber()
	{
		return this.otherpatientnumber;
	}
	public static int getOtherPatientNumberMaxLength()
	{
		return 50;
	}
	public void setOtherPatientNumber(String value)
	{
		this.isValidated = false;
		this.otherpatientnumber = value;
	}
	public boolean getCurrentRTTStatusIsNotNull()
	{
		return this.currentrttstatus != null;
	}
	public ims.pathways.vo.RTTStatusPointVo getCurrentRTTStatus()
	{
		return this.currentrttstatus;
	}
	public void setCurrentRTTStatus(ims.pathways.vo.RTTStatusPointVo value)
	{
		this.isValidated = false;
		this.currentrttstatus = value;
	}
	public boolean getOTherOrganisationCodeIsNotNull()
	{
		return this.otherorganisationcode != null;
	}
	public ims.RefMan.vo.lookups.OtherProviders getOTherOrganisationCode()
	{
		return this.otherorganisationcode;
	}
	public void setOTherOrganisationCode(ims.RefMan.vo.lookups.OtherProviders value)
	{
		this.isValidated = false;
		this.otherorganisationcode = value;
	}
	public boolean getReferringOrganisationCodeIsNotNull()
	{
		return this.referringorganisationcode != null;
	}
	public String getReferringOrganisationCode()
	{
		return this.referringorganisationcode;
	}
	public static int getReferringOrganisationCodeMaxLength()
	{
		return 50;
	}
	public void setReferringOrganisationCode(String value)
	{
		this.isValidated = false;
		this.referringorganisationcode = value;
	}
	public boolean getPathwayIDIsNotNull()
	{
		return this.pathwayid != null;
	}
	public String getPathwayID()
	{
		return this.pathwayid;
	}
	public static int getPathwayIDMaxLength()
	{
		return 30;
	}
	public void setPathwayID(String value)
	{
		this.isValidated = false;
		this.pathwayid = value;
	}
	public boolean getRTTStartDateIsNotNull()
	{
		return this.rttstartdate != null;
	}
	public ims.framework.utils.Date getRTTStartDate()
	{
		return this.rttstartdate;
	}
	public void setRTTStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.rttstartdate = value;
	}
	public boolean getRTTStatusDateIsNotNull()
	{
		return this.rttstatusdate != null;
	}
	public ims.framework.utils.DateTime getRTTStatusDate()
	{
		return this.rttstatusdate;
	}
	public void setRTTStatusDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.rttstatusdate = value;
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
		if(this.otherpatientnumber != null)
			if(this.otherpatientnumber.length() > 50)
				listOfErrors.add("The length of the field [otherpatientnumber] in the value object [ims.RefMan.vo.ReferralTransferVo] is too big. It should be less or equal to 50");
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
		if(this.referringorganisationcode != null)
			if(this.referringorganisationcode.length() > 50)
				listOfErrors.add("The length of the field [referringorganisationcode] in the value object [ims.RefMan.vo.ReferralTransferVo] is too big. It should be less or equal to 50");
		if(this.pathwayid != null)
			if(this.pathwayid.length() > 30)
				listOfErrors.add("The length of the field [pathwayid] in the value object [ims.RefMan.vo.ReferralTransferVo] is too big. It should be less or equal to 30");
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
	
		ReferralTransferVo clone = new ReferralTransferVo(this.id, this.version);
		
		clone.otherpatientnumber = this.otherpatientnumber;
		if(this.currentrttstatus == null)
			clone.currentrttstatus = null;
		else
			clone.currentrttstatus = (ims.pathways.vo.RTTStatusPointVo)this.currentrttstatus.clone();
		if(this.otherorganisationcode == null)
			clone.otherorganisationcode = null;
		else
			clone.otherorganisationcode = (ims.RefMan.vo.lookups.OtherProviders)this.otherorganisationcode.clone();
		clone.referringorganisationcode = this.referringorganisationcode;
		clone.pathwayid = this.pathwayid;
		if(this.rttstartdate == null)
			clone.rttstartdate = null;
		else
			clone.rttstartdate = (ims.framework.utils.Date)this.rttstartdate.clone();
		if(this.rttstatusdate == null)
			clone.rttstatusdate = null;
		else
			clone.rttstatusdate = (ims.framework.utils.DateTime)this.rttstatusdate.clone();
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
		if (!(ReferralTransferVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralTransferVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralTransferVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralTransferVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.otherpatientnumber != null)
			count++;
		if(this.currentrttstatus != null)
			count++;
		if(this.otherorganisationcode != null)
			count++;
		if(this.referringorganisationcode != null)
			count++;
		if(this.pathwayid != null)
			count++;
		if(this.rttstartdate != null)
			count++;
		if(this.rttstatusdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected String otherpatientnumber;
	protected ims.pathways.vo.RTTStatusPointVo currentrttstatus;
	protected ims.RefMan.vo.lookups.OtherProviders otherorganisationcode;
	protected String referringorganisationcode;
	protected String pathwayid;
	protected ims.framework.utils.Date rttstartdate;
	protected ims.framework.utils.DateTime rttstatusdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
