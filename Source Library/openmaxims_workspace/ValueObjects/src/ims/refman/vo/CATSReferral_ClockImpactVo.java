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
public class CATSReferral_ClockImpactVo extends ims.RefMan.vo.CatsReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CATSReferral_ClockImpactVo()
	{
	}
	public CATSReferral_ClockImpactVo(Integer id, int version)
	{
		super(id, version);
	}
	public CATSReferral_ClockImpactVo(ims.RefMan.vo.beans.CATSReferral_ClockImpactVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.journey = bean.getJourney() == null ? null : bean.getJourney().buildVo();
		this.pathwayid = bean.getPathwayID();
		this.rttclockimpact = bean.getRTTClockImpact();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo();
		this.urgency = bean.getUrgency() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getUrgency());
		this.rttclockimpacts = ims.pathways.vo.PathwayRTTClockImpactVoCollection.buildFromBeanCollection(bean.getRTTClockImpacts());
		this.endofcaredate = bean.getEndOfCareDate() == null ? null : bean.getEndOfCareDate().buildDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		if(bean.getStatusHistory() != null)
		{
			this.statushistory = new ims.RefMan.vo.CATSReferralStatusRefVoCollection();
			for(int statushistory_i = 0; statushistory_i < bean.getStatusHistory().length; statushistory_i++)
			{
				this.statushistory.add(new ims.RefMan.vo.CATSReferralStatusRefVo(new Integer(bean.getStatusHistory()[statushistory_i].getId()), bean.getStatusHistory()[statushistory_i].getVersion()));
			}
		}
		this.dos = bean.getDOS() == null ? null : bean.getDOS().buildVo();
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo();
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CATSReferral_ClockImpactVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.journey = bean.getJourney() == null ? null : bean.getJourney().buildVo(map);
		this.pathwayid = bean.getPathwayID();
		this.rttclockimpact = bean.getRTTClockImpact();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo(map);
		this.urgency = bean.getUrgency() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getUrgency());
		this.rttclockimpacts = ims.pathways.vo.PathwayRTTClockImpactVoCollection.buildFromBeanCollection(bean.getRTTClockImpacts());
		this.endofcaredate = bean.getEndOfCareDate() == null ? null : bean.getEndOfCareDate().buildDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		if(bean.getStatusHistory() != null)
		{
			this.statushistory = new ims.RefMan.vo.CATSReferralStatusRefVoCollection();
			for(int statushistory_i = 0; statushistory_i < bean.getStatusHistory().length; statushistory_i++)
			{
				this.statushistory.add(new ims.RefMan.vo.CATSReferralStatusRefVo(new Integer(bean.getStatusHistory()[statushistory_i].getId()), bean.getStatusHistory()[statushistory_i].getVersion()));
			}
		}
		this.dos = bean.getDOS() == null ? null : bean.getDOS().buildVo(map);
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo(map);
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CATSReferral_ClockImpactVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CATSReferral_ClockImpactVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CATSReferral_ClockImpactVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("JOURNEY"))
			return getJourney();
		if(fieldName.equals("PATHWAYID"))
			return getPathwayID();
		if(fieldName.equals("RTTCLOCKIMPACT"))
			return getRTTClockImpact();
		if(fieldName.equals("CURRENTRTTSTATUS"))
			return getCurrentRTTStatus();
		if(fieldName.equals("URGENCY"))
			return getUrgency();
		if(fieldName.equals("RTTCLOCKIMPACTS"))
			return getRTTClockImpacts();
		if(fieldName.equals("ENDOFCAREDATE"))
			return getEndOfCareDate();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("DOS"))
			return getDOS();
		if(fieldName.equals("REFERRALDETAILS"))
			return getReferralDetails();
		if(fieldName.equals("CONTRACT"))
			return getContract();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getJourneyIsNotNull()
	{
		return this.journey != null;
	}
	public ims.pathways.vo.PatientJourneyVo getJourney()
	{
		return this.journey;
	}
	public void setJourney(ims.pathways.vo.PatientJourneyVo value)
	{
		this.isValidated = false;
		this.journey = value;
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
		return 20;
	}
	public void setPathwayID(String value)
	{
		this.isValidated = false;
		this.pathwayid = value;
	}
	public boolean getRTTClockImpactIsNotNull()
	{
		return this.rttclockimpact != null;
	}
	public Boolean getRTTClockImpact()
	{
		return this.rttclockimpact;
	}
	public void setRTTClockImpact(Boolean value)
	{
		this.isValidated = false;
		this.rttclockimpact = value;
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
	public boolean getUrgencyIsNotNull()
	{
		return this.urgency != null;
	}
	public ims.RefMan.vo.lookups.ReferralUrgency getUrgency()
	{
		return this.urgency;
	}
	public void setUrgency(ims.RefMan.vo.lookups.ReferralUrgency value)
	{
		this.isValidated = false;
		this.urgency = value;
	}
	public boolean getRTTClockImpactsIsNotNull()
	{
		return this.rttclockimpacts != null;
	}
	public ims.pathways.vo.PathwayRTTClockImpactVoCollection getRTTClockImpacts()
	{
		return this.rttclockimpacts;
	}
	public void setRTTClockImpacts(ims.pathways.vo.PathwayRTTClockImpactVoCollection value)
	{
		this.isValidated = false;
		this.rttclockimpacts = value;
	}
	public boolean getEndOfCareDateIsNotNull()
	{
		return this.endofcaredate != null;
	}
	public ims.framework.utils.Date getEndOfCareDate()
	{
		return this.endofcaredate;
	}
	public void setEndOfCareDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.endofcaredate = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.RefMan.vo.CatsReferralStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.RefMan.vo.CatsReferralStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.RefMan.vo.CATSReferralStatusRefVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.RefMan.vo.CATSReferralStatusRefVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getDOSIsNotNull()
	{
		return this.dos != null;
	}
	public ims.scheduling.vo.DirectoryOfServiceLiteVo getDOS()
	{
		return this.dos;
	}
	public void setDOS(ims.scheduling.vo.DirectoryOfServiceLiteVo value)
	{
		this.isValidated = false;
		this.dos = value;
	}
	public boolean getReferralDetailsIsNotNull()
	{
		return this.referraldetails != null;
	}
	public ims.RefMan.vo.ReferralLetterDetailsLiteVo getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.RefMan.vo.ReferralLetterDetailsLiteVo value)
	{
		this.isValidated = false;
		this.referraldetails = value;
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
		if(this.journey != null)
		{
			if(!this.journey.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentrttstatus != null)
		{
			if(!this.currentrttstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.rttclockimpacts != null)
		{
			if(!this.rttclockimpacts.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.referraldetails != null)
		{
			if(!this.referraldetails.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.journey != null)
		{
			String[] listOfOtherErrors = this.journey.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.pathwayid != null)
			if(this.pathwayid.length() > 20)
				listOfErrors.add("The length of the field [pathwayid] in the value object [ims.RefMan.vo.CATSReferral_ClockImpactVo] is too big. It should be less or equal to 20");
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
		if(this.rttclockimpacts != null)
		{
			String[] listOfOtherErrors = this.rttclockimpacts.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.referraldetails != null)
		{
			String[] listOfOtherErrors = this.referraldetails.validate();
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
	
		CATSReferral_ClockImpactVo clone = new CATSReferral_ClockImpactVo(this.id, this.version);
		
		clone.patient = this.patient;
		if(this.journey == null)
			clone.journey = null;
		else
			clone.journey = (ims.pathways.vo.PatientJourneyVo)this.journey.clone();
		clone.pathwayid = this.pathwayid;
		clone.rttclockimpact = this.rttclockimpact;
		if(this.currentrttstatus == null)
			clone.currentrttstatus = null;
		else
			clone.currentrttstatus = (ims.pathways.vo.PathwayRTTStatusVo)this.currentrttstatus.clone();
		if(this.urgency == null)
			clone.urgency = null;
		else
			clone.urgency = (ims.RefMan.vo.lookups.ReferralUrgency)this.urgency.clone();
		if(this.rttclockimpacts == null)
			clone.rttclockimpacts = null;
		else
			clone.rttclockimpacts = (ims.pathways.vo.PathwayRTTClockImpactVoCollection)this.rttclockimpacts.clone();
		if(this.endofcaredate == null)
			clone.endofcaredate = null;
		else
			clone.endofcaredate = (ims.framework.utils.Date)this.endofcaredate.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.RefMan.vo.CatsReferralStatusVo)this.currentstatus.clone();
		clone.statushistory = this.statushistory;
		if(this.dos == null)
			clone.dos = null;
		else
			clone.dos = (ims.scheduling.vo.DirectoryOfServiceLiteVo)this.dos.clone();
		if(this.referraldetails == null)
			clone.referraldetails = null;
		else
			clone.referraldetails = (ims.RefMan.vo.ReferralLetterDetailsLiteVo)this.referraldetails.clone();
		if(this.contract == null)
			clone.contract = null;
		else
			clone.contract = (ims.RefMan.vo.ContractConfigShortVo)this.contract.clone();
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
		if (!(CATSReferral_ClockImpactVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CATSReferral_ClockImpactVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CATSReferral_ClockImpactVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CATSReferral_ClockImpactVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.journey != null)
			count++;
		if(this.pathwayid != null)
			count++;
		if(this.rttclockimpact != null)
			count++;
		if(this.currentrttstatus != null)
			count++;
		if(this.urgency != null)
			count++;
		if(this.rttclockimpacts != null)
			count++;
		if(this.endofcaredate != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.dos != null)
			count++;
		if(this.referraldetails != null)
			count++;
		if(this.contract != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.pathways.vo.PatientJourneyVo journey;
	protected String pathwayid;
	protected Boolean rttclockimpact;
	protected ims.pathways.vo.PathwayRTTStatusVo currentrttstatus;
	protected ims.RefMan.vo.lookups.ReferralUrgency urgency;
	protected ims.pathways.vo.PathwayRTTClockImpactVoCollection rttclockimpacts;
	protected ims.framework.utils.Date endofcaredate;
	protected ims.RefMan.vo.CatsReferralStatusVo currentstatus;
	protected ims.RefMan.vo.CATSReferralStatusRefVoCollection statushistory;
	protected ims.scheduling.vo.DirectoryOfServiceLiteVo dos;
	protected ims.RefMan.vo.ReferralLetterDetailsLiteVo referraldetails;
	protected ims.RefMan.vo.ContractConfigShortVo contract;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
