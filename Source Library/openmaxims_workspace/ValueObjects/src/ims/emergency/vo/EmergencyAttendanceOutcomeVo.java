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

package ims.emergency.vo;

/**
 * Linked to core.admin.EmergencyAttendance business object (ID: 1004100025).
 */
public class EmergencyAttendanceOutcomeVo extends ims.core.admin.vo.EmergencyAttendanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceOutcomeVo()
	{
	}
	public EmergencyAttendanceOutcomeVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceOutcomeVo(ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.emergencyepisode = bean.getEmergencyEpisode() == null ? null : bean.getEmergencyEpisode().buildVo();
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.bedtyperequested = bean.getBedTypeRequested() == null ? null : ims.core.vo.lookups.BedTypeRequested.buildLookup(bean.getBedTypeRequested());
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
		this.destination = bean.getDestination();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.discharginghcp = bean.getDischargingHCP() == null ? null : bean.getDischargingHCP().buildVo();
		this.attendancetype = bean.getAttendanceType() == null ? null : ims.emergency.vo.lookups.AttendanceType.buildLookup(bean.getAttendanceType());
		this.attendanceoutcomecomment = bean.getAttendanceOutcomeComment();
		this.attendancedischargecomment = bean.getAttendanceDischargeComment();
		this.gpletterstatus = bean.getGPLetterStatus() == null ? null : ims.emergency.vo.lookups.GPLetterStatus.buildLookup(bean.getGPLetterStatus());
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.edclinicdetails = bean.getEDClinicDetails() == null ? null : bean.getEDClinicDetails().buildVo();
		this.requiressignoff = bean.getRequiresSignOff() == null ? null : ims.emergency.vo.lookups.RequiresSignOff.buildLookup(bean.getRequiresSignOff());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.emergencyepisode = bean.getEmergencyEpisode() == null ? null : bean.getEmergencyEpisode().buildVo(map);
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.bedtyperequested = bean.getBedTypeRequested() == null ? null : ims.core.vo.lookups.BedTypeRequested.buildLookup(bean.getBedTypeRequested());
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
		this.destination = bean.getDestination();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.discharginghcp = bean.getDischargingHCP() == null ? null : bean.getDischargingHCP().buildVo(map);
		this.attendancetype = bean.getAttendanceType() == null ? null : ims.emergency.vo.lookups.AttendanceType.buildLookup(bean.getAttendanceType());
		this.attendanceoutcomecomment = bean.getAttendanceOutcomeComment();
		this.attendancedischargecomment = bean.getAttendanceDischargeComment();
		this.gpletterstatus = bean.getGPLetterStatus() == null ? null : ims.emergency.vo.lookups.GPLetterStatus.buildLookup(bean.getGPLetterStatus());
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.edclinicdetails = bean.getEDClinicDetails() == null ? null : bean.getEDClinicDetails().buildVo(map);
		this.requiressignoff = bean.getRequiresSignOff() == null ? null : ims.emergency.vo.lookups.RequiresSignOff.buildLookup(bean.getRequiresSignOff());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceOutcomeVoBean();
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
		if(fieldName.equals("EMERGENCYEPISODE"))
			return getEmergencyEpisode();
		if(fieldName.equals("CONCLUSIONDATETIME"))
			return getConclusionDateTime();
		if(fieldName.equals("BEDTYPEREQUESTED"))
			return getBedTypeRequested();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		if(fieldName.equals("DESTINATION"))
			return getDestination();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("REGISTRATIONDATETIME"))
			return getRegistrationDateTime();
		if(fieldName.equals("DISCHARGINGHCP"))
			return getDischargingHCP();
		if(fieldName.equals("ATTENDANCETYPE"))
			return getAttendanceType();
		if(fieldName.equals("ATTENDANCEOUTCOMECOMMENT"))
			return getAttendanceOutcomeComment();
		if(fieldName.equals("ATTENDANCEDISCHARGECOMMENT"))
			return getAttendanceDischargeComment();
		if(fieldName.equals("GPLETTERSTATUS"))
			return getGPLetterStatus();
		if(fieldName.equals("ARRIVALDATETIME"))
			return getArrivalDateTime();
		if(fieldName.equals("EDCLINICDETAILS"))
			return getEDClinicDetails();
		if(fieldName.equals("REQUIRESSIGNOFF"))
			return getRequiresSignOff();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEmergencyEpisodeIsNotNull()
	{
		return this.emergencyepisode != null;
	}
	public ims.emergency.vo.EmergencyEpisode_CatetoryOnlyVo getEmergencyEpisode()
	{
		return this.emergencyepisode;
	}
	public void setEmergencyEpisode(ims.emergency.vo.EmergencyEpisode_CatetoryOnlyVo value)
	{
		this.isValidated = false;
		this.emergencyepisode = value;
	}
	public boolean getConclusionDateTimeIsNotNull()
	{
		return this.conclusiondatetime != null;
	}
	public ims.framework.utils.DateTime getConclusionDateTime()
	{
		return this.conclusiondatetime;
	}
	public void setConclusionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.conclusiondatetime = value;
	}
	public boolean getBedTypeRequestedIsNotNull()
	{
		return this.bedtyperequested != null;
	}
	public ims.core.vo.lookups.BedTypeRequested getBedTypeRequested()
	{
		return this.bedtyperequested;
	}
	public void setBedTypeRequested(ims.core.vo.lookups.BedTypeRequested value)
	{
		this.isValidated = false;
		this.bedtyperequested = value;
	}
	public boolean getOutcomeIsNotNull()
	{
		return this.outcome != null;
	}
	public ims.emergency.vo.lookups.AttendanceOutcome getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.emergency.vo.lookups.AttendanceOutcome value)
	{
		this.isValidated = false;
		this.outcome = value;
	}
	public boolean getDestinationIsNotNull()
	{
		return this.destination != null;
	}
	public String getDestination()
	{
		return this.destination;
	}
	public static int getDestinationMaxLength()
	{
		return 120;
	}
	public void setDestination(String value)
	{
		this.isValidated = false;
		this.destination = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.Patient_DODVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.Patient_DODVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getDischargeDateTimeIsNotNull()
	{
		return this.dischargedatetime != null;
	}
	public ims.framework.utils.DateTime getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedatetime = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextForAttendanceOutcomeVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextForAttendanceOutcomeVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getRegistrationDateTimeIsNotNull()
	{
		return this.registrationdatetime != null;
	}
	public ims.framework.utils.DateTime getRegistrationDateTime()
	{
		return this.registrationdatetime;
	}
	public void setRegistrationDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.registrationdatetime = value;
	}
	public boolean getDischargingHCPIsNotNull()
	{
		return this.discharginghcp != null;
	}
	public ims.core.vo.AuthoringInformationVo getDischargingHCP()
	{
		return this.discharginghcp;
	}
	public void setDischargingHCP(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.discharginghcp = value;
	}
	public boolean getAttendanceTypeIsNotNull()
	{
		return this.attendancetype != null;
	}
	public ims.emergency.vo.lookups.AttendanceType getAttendanceType()
	{
		return this.attendancetype;
	}
	public void setAttendanceType(ims.emergency.vo.lookups.AttendanceType value)
	{
		this.isValidated = false;
		this.attendancetype = value;
	}
	public boolean getAttendanceOutcomeCommentIsNotNull()
	{
		return this.attendanceoutcomecomment != null;
	}
	public String getAttendanceOutcomeComment()
	{
		return this.attendanceoutcomecomment;
	}
	public static int getAttendanceOutcomeCommentMaxLength()
	{
		return 5000;
	}
	public void setAttendanceOutcomeComment(String value)
	{
		this.isValidated = false;
		this.attendanceoutcomecomment = value;
	}
	public boolean getAttendanceDischargeCommentIsNotNull()
	{
		return this.attendancedischargecomment != null;
	}
	public String getAttendanceDischargeComment()
	{
		return this.attendancedischargecomment;
	}
	public static int getAttendanceDischargeCommentMaxLength()
	{
		return 5000;
	}
	public void setAttendanceDischargeComment(String value)
	{
		this.isValidated = false;
		this.attendancedischargecomment = value;
	}
	public boolean getGPLetterStatusIsNotNull()
	{
		return this.gpletterstatus != null;
	}
	public ims.emergency.vo.lookups.GPLetterStatus getGPLetterStatus()
	{
		return this.gpletterstatus;
	}
	public void setGPLetterStatus(ims.emergency.vo.lookups.GPLetterStatus value)
	{
		this.isValidated = false;
		this.gpletterstatus = value;
	}
	public boolean getArrivalDateTimeIsNotNull()
	{
		return this.arrivaldatetime != null;
	}
	public ims.framework.utils.DateTime getArrivalDateTime()
	{
		return this.arrivaldatetime;
	}
	public void setArrivalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.arrivaldatetime = value;
	}
	public boolean getEDClinicDetailsIsNotNull()
	{
		return this.edclinicdetails != null;
	}
	public ims.emergency.vo.EDClinicDetailsVo getEDClinicDetails()
	{
		return this.edclinicdetails;
	}
	public void setEDClinicDetails(ims.emergency.vo.EDClinicDetailsVo value)
	{
		this.isValidated = false;
		this.edclinicdetails = value;
	}
	public boolean getRequiresSignOffIsNotNull()
	{
		return this.requiressignoff != null;
	}
	public ims.emergency.vo.lookups.RequiresSignOff getRequiresSignOff()
	{
		return this.requiressignoff;
	}
	public void setRequiresSignOff(ims.emergency.vo.lookups.RequiresSignOff value)
	{
		this.isValidated = false;
		this.requiressignoff = value;
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
		if(this.emergencyepisode != null)
		{
			if(!this.emergencyepisode.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.carecontext != null)
		{
			if(!this.carecontext.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.discharginghcp != null)
		{
			if(!this.discharginghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.edclinicdetails != null)
		{
			if(!this.edclinicdetails.isValidated())
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
		if(this.emergencyepisode == null)
			listOfErrors.add("EmergencyEpisode is mandatory");
		if(this.emergencyepisode != null)
		{
			String[] listOfOtherErrors = this.emergencyepisode.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.destination != null)
			if(this.destination.length() > 120)
				listOfErrors.add("The length of the field [destination] in the value object [ims.emergency.vo.EmergencyAttendanceOutcomeVo] is too big. It should be less or equal to 120");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.carecontext != null)
		{
			String[] listOfOtherErrors = this.carecontext.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.registrationdatetime == null)
			listOfErrors.add("RegistrationDateTime is mandatory");
		if(this.discharginghcp != null)
		{
			String[] listOfOtherErrors = this.discharginghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.arrivaldatetime == null)
			listOfErrors.add("ArrivalDateTime is mandatory");
		if(this.edclinicdetails != null)
		{
			String[] listOfOtherErrors = this.edclinicdetails.validate();
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
	
		EmergencyAttendanceOutcomeVo clone = new EmergencyAttendanceOutcomeVo(this.id, this.version);
		
		if(this.emergencyepisode == null)
			clone.emergencyepisode = null;
		else
			clone.emergencyepisode = (ims.emergency.vo.EmergencyEpisode_CatetoryOnlyVo)this.emergencyepisode.clone();
		if(this.conclusiondatetime == null)
			clone.conclusiondatetime = null;
		else
			clone.conclusiondatetime = (ims.framework.utils.DateTime)this.conclusiondatetime.clone();
		if(this.bedtyperequested == null)
			clone.bedtyperequested = null;
		else
			clone.bedtyperequested = (ims.core.vo.lookups.BedTypeRequested)this.bedtyperequested.clone();
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.emergency.vo.lookups.AttendanceOutcome)this.outcome.clone();
		clone.destination = this.destination;
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.Patient_DODVo)this.patient.clone();
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextForAttendanceOutcomeVo)this.carecontext.clone();
		if(this.registrationdatetime == null)
			clone.registrationdatetime = null;
		else
			clone.registrationdatetime = (ims.framework.utils.DateTime)this.registrationdatetime.clone();
		if(this.discharginghcp == null)
			clone.discharginghcp = null;
		else
			clone.discharginghcp = (ims.core.vo.AuthoringInformationVo)this.discharginghcp.clone();
		if(this.attendancetype == null)
			clone.attendancetype = null;
		else
			clone.attendancetype = (ims.emergency.vo.lookups.AttendanceType)this.attendancetype.clone();
		clone.attendanceoutcomecomment = this.attendanceoutcomecomment;
		clone.attendancedischargecomment = this.attendancedischargecomment;
		if(this.gpletterstatus == null)
			clone.gpletterstatus = null;
		else
			clone.gpletterstatus = (ims.emergency.vo.lookups.GPLetterStatus)this.gpletterstatus.clone();
		if(this.arrivaldatetime == null)
			clone.arrivaldatetime = null;
		else
			clone.arrivaldatetime = (ims.framework.utils.DateTime)this.arrivaldatetime.clone();
		if(this.edclinicdetails == null)
			clone.edclinicdetails = null;
		else
			clone.edclinicdetails = (ims.emergency.vo.EDClinicDetailsVo)this.edclinicdetails.clone();
		if(this.requiressignoff == null)
			clone.requiressignoff = null;
		else
			clone.requiressignoff = (ims.emergency.vo.lookups.RequiresSignOff)this.requiressignoff.clone();
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
		if (!(EmergencyAttendanceOutcomeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceOutcomeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyAttendanceOutcomeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyAttendanceOutcomeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.emergencyepisode != null)
			count++;
		if(this.conclusiondatetime != null)
			count++;
		if(this.bedtyperequested != null)
			count++;
		if(this.outcome != null)
			count++;
		if(this.destination != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.dischargedatetime != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.registrationdatetime != null)
			count++;
		if(this.discharginghcp != null)
			count++;
		if(this.attendancetype != null)
			count++;
		if(this.attendanceoutcomecomment != null)
			count++;
		if(this.attendancedischargecomment != null)
			count++;
		if(this.gpletterstatus != null)
			count++;
		if(this.arrivaldatetime != null)
			count++;
		if(this.edclinicdetails != null)
			count++;
		if(this.requiressignoff != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.emergency.vo.EmergencyEpisode_CatetoryOnlyVo emergencyepisode;
	protected ims.framework.utils.DateTime conclusiondatetime;
	protected ims.core.vo.lookups.BedTypeRequested bedtyperequested;
	protected ims.emergency.vo.lookups.AttendanceOutcome outcome;
	protected String destination;
	protected ims.core.vo.Patient_DODVo patient;
	protected ims.framework.utils.DateTime dischargedatetime;
	protected ims.core.vo.CareContextForAttendanceOutcomeVo carecontext;
	protected ims.framework.utils.DateTime registrationdatetime;
	protected ims.core.vo.AuthoringInformationVo discharginghcp;
	protected ims.emergency.vo.lookups.AttendanceType attendancetype;
	protected String attendanceoutcomecomment;
	protected String attendancedischargecomment;
	protected ims.emergency.vo.lookups.GPLetterStatus gpletterstatus;
	protected ims.framework.utils.DateTime arrivaldatetime;
	protected ims.emergency.vo.EDClinicDetailsVo edclinicdetails;
	protected ims.emergency.vo.lookups.RequiresSignOff requiressignoff;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
