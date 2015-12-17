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

package ims.racpc.vo;

/**
 * Linked to core.clinical.RACPReferral business object (ID: 1003100110).
 */
public class RACPCReferralVo extends ims.core.clinical.vo.RACPReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RACPCReferralVo()
	{
	}
	public RACPCReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public RACPCReferralVo(ims.racpc.vo.beans.RACPCReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.datereferralmade = bean.getDateReferralMade() == null ? null : bean.getDateReferralMade().buildDate();
		this.datereferralreceived = bean.getDateReferralReceived() == null ? null : bean.getDateReferralReceived().buildDate();
		this.waitingtime = bean.getWaitingTime();
		this.referralreason = bean.getReferralReason() == null ? null : ims.core.vo.lookups.ReasonForReferral.buildLookup(bean.getReferralReason());
		this.delayreason = bean.getDelayReason() == null ? null : ims.core.vo.lookups.ReasonForAptDelay.buildLookup(bean.getDelayReason());
		this.cardiologist = bean.getCardiologist() == null ? null : bean.getCardiologist().buildVo();
		this.clinicdoctor = bean.getClinicDoctor() == null ? null : bean.getClinicDoctor().buildVo();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.sourceofreferral = bean.getSourceofReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceofReferral());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.racpc.vo.beans.RACPCReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.datereferralmade = bean.getDateReferralMade() == null ? null : bean.getDateReferralMade().buildDate();
		this.datereferralreceived = bean.getDateReferralReceived() == null ? null : bean.getDateReferralReceived().buildDate();
		this.waitingtime = bean.getWaitingTime();
		this.referralreason = bean.getReferralReason() == null ? null : ims.core.vo.lookups.ReasonForReferral.buildLookup(bean.getReferralReason());
		this.delayreason = bean.getDelayReason() == null ? null : ims.core.vo.lookups.ReasonForAptDelay.buildLookup(bean.getDelayReason());
		this.cardiologist = bean.getCardiologist() == null ? null : bean.getCardiologist().buildVo(map);
		this.clinicdoctor = bean.getClinicDoctor() == null ? null : bean.getClinicDoctor().buildVo(map);
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.sourceofreferral = bean.getSourceofReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceofReferral());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.racpc.vo.beans.RACPCReferralVoBean bean = null;
		if(map != null)
			bean = (ims.racpc.vo.beans.RACPCReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.racpc.vo.beans.RACPCReferralVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("DATEREFERRALMADE"))
			return getDateReferralMade();
		if(fieldName.equals("DATEREFERRALRECEIVED"))
			return getDateReferralReceived();
		if(fieldName.equals("WAITINGTIME"))
			return getWaitingTime();
		if(fieldName.equals("REFERRALREASON"))
			return getReferralReason();
		if(fieldName.equals("DELAYREASON"))
			return getDelayReason();
		if(fieldName.equals("CARDIOLOGIST"))
			return getCardiologist();
		if(fieldName.equals("CLINICDOCTOR"))
			return getClinicDoctor();
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("SOURCEOFREFERRAL"))
			return getSourceofReferral();
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
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.racpc.vo.CareContextForRACPCReferralVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.racpc.vo.CareContextForRACPCReferralVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getDateReferralMadeIsNotNull()
	{
		return this.datereferralmade != null;
	}
	public ims.framework.utils.Date getDateReferralMade()
	{
		return this.datereferralmade;
	}
	public void setDateReferralMade(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datereferralmade = value;
	}
	public boolean getDateReferralReceivedIsNotNull()
	{
		return this.datereferralreceived != null;
	}
	public ims.framework.utils.Date getDateReferralReceived()
	{
		return this.datereferralreceived;
	}
	public void setDateReferralReceived(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datereferralreceived = value;
	}
	public boolean getWaitingTimeIsNotNull()
	{
		return this.waitingtime != null;
	}
	public Integer getWaitingTime()
	{
		return this.waitingtime;
	}
	public void setWaitingTime(Integer value)
	{
		this.isValidated = false;
		this.waitingtime = value;
	}
	public boolean getReferralReasonIsNotNull()
	{
		return this.referralreason != null;
	}
	public ims.core.vo.lookups.ReasonForReferral getReferralReason()
	{
		return this.referralreason;
	}
	public void setReferralReason(ims.core.vo.lookups.ReasonForReferral value)
	{
		this.isValidated = false;
		this.referralreason = value;
	}
	public boolean getDelayReasonIsNotNull()
	{
		return this.delayreason != null;
	}
	public ims.core.vo.lookups.ReasonForAptDelay getDelayReason()
	{
		return this.delayreason;
	}
	public void setDelayReason(ims.core.vo.lookups.ReasonForAptDelay value)
	{
		this.isValidated = false;
		this.delayreason = value;
	}
	public boolean getCardiologistIsNotNull()
	{
		return this.cardiologist != null;
	}
	public ims.core.vo.Hcp getCardiologist()
	{
		return this.cardiologist;
	}
	public void setCardiologist(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.cardiologist = value;
	}
	public boolean getClinicDoctorIsNotNull()
	{
		return this.clinicdoctor != null;
	}
	public ims.core.vo.Hcp getClinicDoctor()
	{
		return this.clinicdoctor;
	}
	public void setClinicDoctor(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.clinicdoctor = value;
	}
	public boolean getAppointmentDateIsNotNull()
	{
		return this.appointmentdate != null;
	}
	public ims.framework.utils.Date getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.appointmentdate = value;
	}
	public boolean getSourceofReferralIsNotNull()
	{
		return this.sourceofreferral != null;
	}
	public ims.core.vo.lookups.SourceOfReferral getSourceofReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceofReferral(ims.core.vo.lookups.SourceOfReferral value)
	{
		this.isValidated = false;
		this.sourceofreferral = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.cardiologist == null)
			listOfErrors.add("Cardiologist is mandatory");
		if(this.clinicdoctor == null)
			listOfErrors.add("ClinicDoctor is mandatory");
		if(this.appointmentdate == null)
			listOfErrors.add("AppointmentDate is mandatory");
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
	
		RACPCReferralVo clone = new RACPCReferralVo(this.id, this.version);
		
		clone.patient = this.patient;
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.racpc.vo.CareContextForRACPCReferralVo)this.carecontext.clone();
		if(this.datereferralmade == null)
			clone.datereferralmade = null;
		else
			clone.datereferralmade = (ims.framework.utils.Date)this.datereferralmade.clone();
		if(this.datereferralreceived == null)
			clone.datereferralreceived = null;
		else
			clone.datereferralreceived = (ims.framework.utils.Date)this.datereferralreceived.clone();
		clone.waitingtime = this.waitingtime;
		if(this.referralreason == null)
			clone.referralreason = null;
		else
			clone.referralreason = (ims.core.vo.lookups.ReasonForReferral)this.referralreason.clone();
		if(this.delayreason == null)
			clone.delayreason = null;
		else
			clone.delayreason = (ims.core.vo.lookups.ReasonForAptDelay)this.delayreason.clone();
		if(this.cardiologist == null)
			clone.cardiologist = null;
		else
			clone.cardiologist = (ims.core.vo.Hcp)this.cardiologist.clone();
		if(this.clinicdoctor == null)
			clone.clinicdoctor = null;
		else
			clone.clinicdoctor = (ims.core.vo.Hcp)this.clinicdoctor.clone();
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.Date)this.appointmentdate.clone();
		if(this.sourceofreferral == null)
			clone.sourceofreferral = null;
		else
			clone.sourceofreferral = (ims.core.vo.lookups.SourceOfReferral)this.sourceofreferral.clone();
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
		if (!(RACPCReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RACPCReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RACPCReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RACPCReferralVo)obj).getBoId());
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
		if(this.carecontext != null)
			count++;
		if(this.datereferralmade != null)
			count++;
		if(this.datereferralreceived != null)
			count++;
		if(this.waitingtime != null)
			count++;
		if(this.referralreason != null)
			count++;
		if(this.delayreason != null)
			count++;
		if(this.cardiologist != null)
			count++;
		if(this.clinicdoctor != null)
			count++;
		if(this.appointmentdate != null)
			count++;
		if(this.sourceofreferral != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.racpc.vo.CareContextForRACPCReferralVo carecontext;
	protected ims.framework.utils.Date datereferralmade;
	protected ims.framework.utils.Date datereferralreceived;
	protected Integer waitingtime;
	protected ims.core.vo.lookups.ReasonForReferral referralreason;
	protected ims.core.vo.lookups.ReasonForAptDelay delayreason;
	protected ims.core.vo.Hcp cardiologist;
	protected ims.core.vo.Hcp clinicdoctor;
	protected ims.framework.utils.Date appointmentdate;
	protected ims.core.vo.lookups.SourceOfReferral sourceofreferral;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
