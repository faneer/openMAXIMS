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
 * Linked to RefMan.TCIForPatientElectiveList business object (ID: 1096100064).
 */
public class TCIForPatientElectiveListDetailsVo extends ims.RefMan.vo.TCIForPatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TCIForPatientElectiveListDetailsVo()
	{
	}
	public TCIForPatientElectiveListDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public TCIForPatientElectiveListDetailsVo(ims.RefMan.vo.beans.TCIForPatientElectiveListDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.tcihospital = bean.getTCIHospital() == null ? null : bean.getTCIHospital().buildVo();
		this.tciward = bean.getTCIWard() == null ? null : bean.getTCIWard().buildVo();
		this.rttbreachreason = bean.getRTTBreachReason() == null ? null : ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason.buildLookup(bean.getRTTBreachReason());
		this.tcioffermethod = bean.getTCIOfferMethod() == null ? null : ims.core.vo.lookups.TCIOfferMethod.buildLookup(bean.getTCIOfferMethod());
		this.datetcioffered = bean.getDateTCIOffered() == null ? null : bean.getDateTCIOffered().buildDate();
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo();
		this.isactive = bean.getIsActive();
		this.day28breachreason = bean.getDay28BreachReason() == null ? null : ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason.buildLookup(bean.getDay28BreachReason());
		this.wasreasonable28dayoffermade = bean.getWasReasonable28dayOfferMade();
		this.daytcidate28offered = bean.getDayTCIDate28Offered() == null ? null : bean.getDayTCIDate28Offered().buildDate();
		this.date28ofoffer = bean.getDate28OfOffer() == null ? null : bean.getDate28OfOffer().buildDate();
		this.reasondeclined28 = bean.getReasonDeclined28() == null ? null : ims.RefMan.vo.lookups.ReasonDeclined28DayOffer.buildLookup(bean.getReasonDeclined28());
		this.currentoutcome = bean.getCurrentOutcome() == null ? null : bean.getCurrentOutcome().buildVo();
		this.outcomehistory = ims.RefMan.vo.TCIOutcomeForPatientElectiveListVoCollection.buildFromBeanCollection(bean.getOutcomeHistory());
		this.subjectto28dayrule = bean.getSubjectTo28DayRule();
		this.rule28daystatus = bean.getRule28DayStatus() == null ? null : ims.scheduling.vo.lookups.Rule28DayStatus.buildLookup(bean.getRule28DayStatus());
		this.rule28dayperiodstart = bean.getRule28DayPeriodStart() == null ? null : bean.getRule28DayPeriodStart().buildDate();
		this.plannedtcidate = bean.getPlannedTCIDate() == null ? null : bean.getPlannedTCIDate().buildDate();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.comments = bean.getComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.TCIForPatientElectiveListDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.tcihospital = bean.getTCIHospital() == null ? null : bean.getTCIHospital().buildVo(map);
		this.tciward = bean.getTCIWard() == null ? null : bean.getTCIWard().buildVo(map);
		this.rttbreachreason = bean.getRTTBreachReason() == null ? null : ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason.buildLookup(bean.getRTTBreachReason());
		this.tcioffermethod = bean.getTCIOfferMethod() == null ? null : ims.core.vo.lookups.TCIOfferMethod.buildLookup(bean.getTCIOfferMethod());
		this.datetcioffered = bean.getDateTCIOffered() == null ? null : bean.getDateTCIOffered().buildDate();
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo(map);
		this.isactive = bean.getIsActive();
		this.day28breachreason = bean.getDay28BreachReason() == null ? null : ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason.buildLookup(bean.getDay28BreachReason());
		this.wasreasonable28dayoffermade = bean.getWasReasonable28dayOfferMade();
		this.daytcidate28offered = bean.getDayTCIDate28Offered() == null ? null : bean.getDayTCIDate28Offered().buildDate();
		this.date28ofoffer = bean.getDate28OfOffer() == null ? null : bean.getDate28OfOffer().buildDate();
		this.reasondeclined28 = bean.getReasonDeclined28() == null ? null : ims.RefMan.vo.lookups.ReasonDeclined28DayOffer.buildLookup(bean.getReasonDeclined28());
		this.currentoutcome = bean.getCurrentOutcome() == null ? null : bean.getCurrentOutcome().buildVo(map);
		this.outcomehistory = ims.RefMan.vo.TCIOutcomeForPatientElectiveListVoCollection.buildFromBeanCollection(bean.getOutcomeHistory());
		this.subjectto28dayrule = bean.getSubjectTo28DayRule();
		this.rule28daystatus = bean.getRule28DayStatus() == null ? null : ims.scheduling.vo.lookups.Rule28DayStatus.buildLookup(bean.getRule28DayStatus());
		this.rule28dayperiodstart = bean.getRule28DayPeriodStart() == null ? null : bean.getRule28DayPeriodStart().buildDate();
		this.plannedtcidate = bean.getPlannedTCIDate() == null ? null : bean.getPlannedTCIDate().buildDate();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.comments = bean.getComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.TCIForPatientElectiveListDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.TCIForPatientElectiveListDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.TCIForPatientElectiveListDetailsVoBean();
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
		if(fieldName.equals("TCIDATE"))
			return getTCIDate();
		if(fieldName.equals("TCITIME"))
			return getTCITime();
		if(fieldName.equals("TCIHOSPITAL"))
			return getTCIHospital();
		if(fieldName.equals("TCIWARD"))
			return getTCIWard();
		if(fieldName.equals("RTTBREACHREASON"))
			return getRTTBreachReason();
		if(fieldName.equals("TCIOFFERMETHOD"))
			return getTCIOfferMethod();
		if(fieldName.equals("DATETCIOFFERED"))
			return getDateTCIOffered();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("DAY28BREACHREASON"))
			return getDay28BreachReason();
		if(fieldName.equals("WASREASONABLE28DAYOFFERMADE"))
			return getWasReasonable28dayOfferMade();
		if(fieldName.equals("DAYTCIDATE28OFFERED"))
			return getDayTCIDate28Offered();
		if(fieldName.equals("DATE28OFOFFER"))
			return getDate28OfOffer();
		if(fieldName.equals("REASONDECLINED28"))
			return getReasonDeclined28();
		if(fieldName.equals("CURRENTOUTCOME"))
			return getCurrentOutcome();
		if(fieldName.equals("OUTCOMEHISTORY"))
			return getOutcomeHistory();
		if(fieldName.equals("SUBJECTTO28DAYRULE"))
			return getSubjectTo28DayRule();
		if(fieldName.equals("RULE28DAYSTATUS"))
			return getRule28DayStatus();
		if(fieldName.equals("RULE28DAYPERIODSTART"))
			return getRule28DayPeriodStart();
		if(fieldName.equals("PLANNEDTCIDATE"))
			return getPlannedTCIDate();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTCIDateIsNotNull()
	{
		return this.tcidate != null;
	}
	public ims.framework.utils.Date getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.tcidate = value;
	}
	public boolean getTCITimeIsNotNull()
	{
		return this.tcitime != null;
	}
	public ims.framework.utils.Time getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.tcitime = value;
	}
	public boolean getTCIHospitalIsNotNull()
	{
		return this.tcihospital != null;
	}
	public ims.core.vo.LocationLiteVo getTCIHospital()
	{
		return this.tcihospital;
	}
	public void setTCIHospital(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.tcihospital = value;
	}
	public boolean getTCIWardIsNotNull()
	{
		return this.tciward != null;
	}
	public ims.core.vo.LocationLiteVo getTCIWard()
	{
		return this.tciward;
	}
	public void setTCIWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.tciward = value;
	}
	public boolean getRTTBreachReasonIsNotNull()
	{
		return this.rttbreachreason != null;
	}
	public ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason getRTTBreachReason()
	{
		return this.rttbreachreason;
	}
	public void setRTTBreachReason(ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason value)
	{
		this.isValidated = false;
		this.rttbreachreason = value;
	}
	public boolean getTCIOfferMethodIsNotNull()
	{
		return this.tcioffermethod != null;
	}
	public ims.core.vo.lookups.TCIOfferMethod getTCIOfferMethod()
	{
		return this.tcioffermethod;
	}
	public void setTCIOfferMethod(ims.core.vo.lookups.TCIOfferMethod value)
	{
		this.isValidated = false;
		this.tcioffermethod = value;
	}
	public boolean getDateTCIOfferedIsNotNull()
	{
		return this.datetcioffered != null;
	}
	public ims.framework.utils.Date getDateTCIOffered()
	{
		return this.datetcioffered;
	}
	public void setDateTCIOffered(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datetcioffered = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.RefMan.vo.BookingAppointmentForTCIVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.RefMan.vo.BookingAppointmentForTCIVo value)
	{
		this.isValidated = false;
		this.appointment = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getDay28BreachReasonIsNotNull()
	{
		return this.day28breachreason != null;
	}
	public ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason getDay28BreachReason()
	{
		return this.day28breachreason;
	}
	public void setDay28BreachReason(ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason value)
	{
		this.isValidated = false;
		this.day28breachreason = value;
	}
	public boolean getWasReasonable28dayOfferMadeIsNotNull()
	{
		return this.wasreasonable28dayoffermade != null;
	}
	public Boolean getWasReasonable28dayOfferMade()
	{
		return this.wasreasonable28dayoffermade;
	}
	public void setWasReasonable28dayOfferMade(Boolean value)
	{
		this.isValidated = false;
		this.wasreasonable28dayoffermade = value;
	}
	public boolean getDayTCIDate28OfferedIsNotNull()
	{
		return this.daytcidate28offered != null;
	}
	public ims.framework.utils.Date getDayTCIDate28Offered()
	{
		return this.daytcidate28offered;
	}
	public void setDayTCIDate28Offered(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.daytcidate28offered = value;
	}
	public boolean getDate28OfOfferIsNotNull()
	{
		return this.date28ofoffer != null;
	}
	public ims.framework.utils.Date getDate28OfOffer()
	{
		return this.date28ofoffer;
	}
	public void setDate28OfOffer(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.date28ofoffer = value;
	}
	public boolean getReasonDeclined28IsNotNull()
	{
		return this.reasondeclined28 != null;
	}
	public ims.RefMan.vo.lookups.ReasonDeclined28DayOffer getReasonDeclined28()
	{
		return this.reasondeclined28;
	}
	public void setReasonDeclined28(ims.RefMan.vo.lookups.ReasonDeclined28DayOffer value)
	{
		this.isValidated = false;
		this.reasondeclined28 = value;
	}
	public boolean getCurrentOutcomeIsNotNull()
	{
		return this.currentoutcome != null;
	}
	public ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo getCurrentOutcome()
	{
		return this.currentoutcome;
	}
	public void setCurrentOutcome(ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo value)
	{
		this.isValidated = false;
		this.currentoutcome = value;
	}
	public boolean getOutcomeHistoryIsNotNull()
	{
		return this.outcomehistory != null;
	}
	public ims.RefMan.vo.TCIOutcomeForPatientElectiveListVoCollection getOutcomeHistory()
	{
		return this.outcomehistory;
	}
	public void setOutcomeHistory(ims.RefMan.vo.TCIOutcomeForPatientElectiveListVoCollection value)
	{
		this.isValidated = false;
		this.outcomehistory = value;
	}
	public boolean getSubjectTo28DayRuleIsNotNull()
	{
		return this.subjectto28dayrule != null;
	}
	public Boolean getSubjectTo28DayRule()
	{
		return this.subjectto28dayrule;
	}
	public void setSubjectTo28DayRule(Boolean value)
	{
		this.isValidated = false;
		this.subjectto28dayrule = value;
	}
	public boolean getRule28DayStatusIsNotNull()
	{
		return this.rule28daystatus != null;
	}
	public ims.scheduling.vo.lookups.Rule28DayStatus getRule28DayStatus()
	{
		return this.rule28daystatus;
	}
	public void setRule28DayStatus(ims.scheduling.vo.lookups.Rule28DayStatus value)
	{
		this.isValidated = false;
		this.rule28daystatus = value;
	}
	public boolean getRule28DayPeriodStartIsNotNull()
	{
		return this.rule28dayperiodstart != null;
	}
	public ims.framework.utils.Date getRule28DayPeriodStart()
	{
		return this.rule28dayperiodstart;
	}
	public void setRule28DayPeriodStart(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.rule28dayperiodstart = value;
	}
	public boolean getPlannedTCIDateIsNotNull()
	{
		return this.plannedtcidate != null;
	}
	public ims.framework.utils.Date getPlannedTCIDate()
	{
		return this.plannedtcidate;
	}
	public void setPlannedTCIDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.plannedtcidate = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 1000;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
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
		if(this.currentoutcome != null)
		{
			if(!this.currentoutcome.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.outcomehistory != null)
		{
			if(!this.outcomehistory.isValidated())
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
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
		if(this.currentoutcome != null)
		{
			String[] listOfOtherErrors = this.currentoutcome.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.outcomehistory != null)
		{
			String[] listOfOtherErrors = this.outcomehistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comments != null)
			if(this.comments.length() > 1000)
				listOfErrors.add("The length of the field [comments] in the value object [ims.RefMan.vo.TCIForPatientElectiveListDetailsVo] is too big. It should be less or equal to 1000");
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
	
		TCIForPatientElectiveListDetailsVo clone = new TCIForPatientElectiveListDetailsVo(this.id, this.version);
		
		if(this.tcidate == null)
			clone.tcidate = null;
		else
			clone.tcidate = (ims.framework.utils.Date)this.tcidate.clone();
		if(this.tcitime == null)
			clone.tcitime = null;
		else
			clone.tcitime = (ims.framework.utils.Time)this.tcitime.clone();
		if(this.tcihospital == null)
			clone.tcihospital = null;
		else
			clone.tcihospital = (ims.core.vo.LocationLiteVo)this.tcihospital.clone();
		if(this.tciward == null)
			clone.tciward = null;
		else
			clone.tciward = (ims.core.vo.LocationLiteVo)this.tciward.clone();
		if(this.rttbreachreason == null)
			clone.rttbreachreason = null;
		else
			clone.rttbreachreason = (ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason)this.rttbreachreason.clone();
		if(this.tcioffermethod == null)
			clone.tcioffermethod = null;
		else
			clone.tcioffermethod = (ims.core.vo.lookups.TCIOfferMethod)this.tcioffermethod.clone();
		if(this.datetcioffered == null)
			clone.datetcioffered = null;
		else
			clone.datetcioffered = (ims.framework.utils.Date)this.datetcioffered.clone();
		if(this.appointment == null)
			clone.appointment = null;
		else
			clone.appointment = (ims.RefMan.vo.BookingAppointmentForTCIVo)this.appointment.clone();
		clone.isactive = this.isactive;
		if(this.day28breachreason == null)
			clone.day28breachreason = null;
		else
			clone.day28breachreason = (ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason)this.day28breachreason.clone();
		clone.wasreasonable28dayoffermade = this.wasreasonable28dayoffermade;
		if(this.daytcidate28offered == null)
			clone.daytcidate28offered = null;
		else
			clone.daytcidate28offered = (ims.framework.utils.Date)this.daytcidate28offered.clone();
		if(this.date28ofoffer == null)
			clone.date28ofoffer = null;
		else
			clone.date28ofoffer = (ims.framework.utils.Date)this.date28ofoffer.clone();
		if(this.reasondeclined28 == null)
			clone.reasondeclined28 = null;
		else
			clone.reasondeclined28 = (ims.RefMan.vo.lookups.ReasonDeclined28DayOffer)this.reasondeclined28.clone();
		if(this.currentoutcome == null)
			clone.currentoutcome = null;
		else
			clone.currentoutcome = (ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo)this.currentoutcome.clone();
		if(this.outcomehistory == null)
			clone.outcomehistory = null;
		else
			clone.outcomehistory = (ims.RefMan.vo.TCIOutcomeForPatientElectiveListVoCollection)this.outcomehistory.clone();
		clone.subjectto28dayrule = this.subjectto28dayrule;
		if(this.rule28daystatus == null)
			clone.rule28daystatus = null;
		else
			clone.rule28daystatus = (ims.scheduling.vo.lookups.Rule28DayStatus)this.rule28daystatus.clone();
		if(this.rule28dayperiodstart == null)
			clone.rule28dayperiodstart = null;
		else
			clone.rule28dayperiodstart = (ims.framework.utils.Date)this.rule28dayperiodstart.clone();
		if(this.plannedtcidate == null)
			clone.plannedtcidate = null;
		else
			clone.plannedtcidate = (ims.framework.utils.Date)this.plannedtcidate.clone();
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
		clone.comments = this.comments;
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
		if (!(TCIForPatientElectiveListDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TCIForPatientElectiveListDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TCIForPatientElectiveListDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TCIForPatientElectiveListDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.tcidate != null)
			count++;
		if(this.tcitime != null)
			count++;
		if(this.tcihospital != null)
			count++;
		if(this.tciward != null)
			count++;
		if(this.rttbreachreason != null)
			count++;
		if(this.tcioffermethod != null)
			count++;
		if(this.datetcioffered != null)
			count++;
		if(this.appointment != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.day28breachreason != null)
			count++;
		if(this.wasreasonable28dayoffermade != null)
			count++;
		if(this.daytcidate28offered != null)
			count++;
		if(this.date28ofoffer != null)
			count++;
		if(this.reasondeclined28 != null)
			count++;
		if(this.currentoutcome != null)
			count++;
		if(this.outcomehistory != null)
			count++;
		if(this.subjectto28dayrule != null)
			count++;
		if(this.rule28daystatus != null)
			count++;
		if(this.rule28dayperiodstart != null)
			count++;
		if(this.plannedtcidate != null)
			count++;
		if(this.systeminformation != null)
			count++;
		if(this.comments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 22;
	}
	protected ims.framework.utils.Date tcidate;
	protected ims.framework.utils.Time tcitime;
	protected ims.core.vo.LocationLiteVo tcihospital;
	protected ims.core.vo.LocationLiteVo tciward;
	protected ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason rttbreachreason;
	protected ims.core.vo.lookups.TCIOfferMethod tcioffermethod;
	protected ims.framework.utils.Date datetcioffered;
	protected ims.RefMan.vo.BookingAppointmentForTCIVo appointment;
	protected Boolean isactive;
	protected ims.scheduling.vo.lookups.RTTWeekWaitOr28DayRuleBreachReason day28breachreason;
	protected Boolean wasreasonable28dayoffermade;
	protected ims.framework.utils.Date daytcidate28offered;
	protected ims.framework.utils.Date date28ofoffer;
	protected ims.RefMan.vo.lookups.ReasonDeclined28DayOffer reasondeclined28;
	protected ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo currentoutcome;
	protected ims.RefMan.vo.TCIOutcomeForPatientElectiveListVoCollection outcomehistory;
	protected Boolean subjectto28dayrule;
	protected ims.scheduling.vo.lookups.Rule28DayStatus rule28daystatus;
	protected ims.framework.utils.Date rule28dayperiodstart;
	protected ims.framework.utils.Date plannedtcidate;
	protected ims.vo.SystemInformation systeminformation;
	protected String comments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
