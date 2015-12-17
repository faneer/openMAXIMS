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

package ims.icp.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class OutpatientEpisodeWithICPInfoVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OutpatientEpisodeWithICPInfoVo()
	{
	}
	public OutpatientEpisodeWithICPInfoVo(Integer id, int version)
	{
		super(id, version);
	}
	public OutpatientEpisodeWithICPInfoVo(ims.icp.vo.beans.OutpatientEpisodeWithICPInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.appointmenttime = bean.getAppointmentTime() == null ? null : bean.getAppointmentTime().buildTime();
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo();
		this.icpinfo = bean.getICPInfo() == null ? null : bean.getICPInfo().buildVo();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.currentappttrakingstatus = bean.getCurrentApptTrakingStatus() == null ? null : bean.getCurrentApptTrakingStatus().buildVo();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.appointmenttrackingstatus = bean.getAppointmentTrackingStatus() == null ? null : bean.getAppointmentTrackingStatus().buildVo();
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo();
		this.haselectivelist = bean.getHasElectiveList();
		this.outcome = bean.getOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getOutcome());
		this.outcomeactions = ims.scheduling.vo.AppointmentOutcomeActionVoCollection.buildFromBeanCollection(bean.getOutcomeActions());
		this.casenotespulled = bean.getCaseNotesPulled();
		this.wasselected = bean.getWasSelected();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.OutpatientEpisodeWithICPInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.appointmenttime = bean.getAppointmentTime() == null ? null : bean.getAppointmentTime().buildTime();
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo(map);
		this.icpinfo = bean.getICPInfo() == null ? null : bean.getICPInfo().buildVo(map);
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.currentappttrakingstatus = bean.getCurrentApptTrakingStatus() == null ? null : bean.getCurrentApptTrakingStatus().buildVo(map);
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.appointmenttrackingstatus = bean.getAppointmentTrackingStatus() == null ? null : bean.getAppointmentTrackingStatus().buildVo(map);
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo(map);
		this.haselectivelist = bean.getHasElectiveList();
		this.outcome = bean.getOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getOutcome());
		this.outcomeactions = ims.scheduling.vo.AppointmentOutcomeActionVoCollection.buildFromBeanCollection(bean.getOutcomeActions());
		this.casenotespulled = bean.getCaseNotesPulled();
		this.wasselected = bean.getWasSelected();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.OutpatientEpisodeWithICPInfoVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.OutpatientEpisodeWithICPInfoVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.OutpatientEpisodeWithICPInfoVoBean();
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
		if(fieldName.equals("APPOINTMENTTIME"))
			return getAppointmentTime();
		if(fieldName.equals("SESSION"))
			return getSession();
		if(fieldName.equals("ICPINFO"))
			return getICPInfo();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("CURRENTAPPTTRAKINGSTATUS"))
			return getCurrentApptTrakingStatus();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("APPOINTMENTTRACKINGSTATUS"))
			return getAppointmentTrackingStatus();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("HASELECTIVELIST"))
			return getHasElectiveList();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		if(fieldName.equals("OUTCOMEACTIONS"))
			return getOutcomeActions();
		if(fieldName.equals("CASENOTESPULLED"))
			return getCaseNotesPulled();
		if(fieldName.equals("WASSELECTED"))
			return getWasSelected();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getAppointmentTimeIsNotNull()
	{
		return this.appointmenttime != null;
	}
	public ims.framework.utils.Time getAppointmentTime()
	{
		return this.appointmenttime;
	}
	public void setAppointmentTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.appointmenttime = value;
	}
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.SessionLiteWithListownerVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.SessionLiteWithListownerVo value)
	{
		this.isValidated = false;
		this.session = value;
	}
	public boolean getICPInfoIsNotNull()
	{
		return this.icpinfo != null;
	}
	public ims.icp.vo.PatientICPLiteVo getICPInfo()
	{
		return this.icpinfo;
	}
	public void setICPInfo(ims.icp.vo.PatientICPLiteVo value)
	{
		this.isValidated = false;
		this.icpinfo = value;
	}
	public boolean getApptStatusIsNotNull()
	{
		return this.apptstatus != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.apptstatus = value;
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
	public boolean getCurrentApptTrakingStatusIsNotNull()
	{
		return this.currentappttrakingstatus != null;
	}
	public ims.scheduling.vo.Appt_Tracking_Status_HistoryVo getCurrentApptTrakingStatus()
	{
		return this.currentappttrakingstatus;
	}
	public void setCurrentApptTrakingStatus(ims.scheduling.vo.Appt_Tracking_Status_HistoryVo value)
	{
		this.isValidated = false;
		this.currentappttrakingstatus = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityLiteVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityLiteVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getAppointmentTrackingStatusIsNotNull()
	{
		return this.appointmenttrackingstatus != null;
	}
	public ims.admin.vo.AppointmentTrackingstatusColourConfigVo getAppointmentTrackingStatus()
	{
		return this.appointmenttrackingstatus;
	}
	public void setAppointmentTrackingStatus(ims.admin.vo.AppointmentTrackingstatusColourConfigVo value)
	{
		this.isValidated = false;
		this.appointmenttrackingstatus = value;
	}
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.RefMan.vo.CatsReferralBreachDatesVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.CatsReferralBreachDatesVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getHasElectiveListIsNotNull()
	{
		return this.haselectivelist != null;
	}
	public Boolean getHasElectiveList()
	{
		return this.haselectivelist;
	}
	public void setHasElectiveList(Boolean value)
	{
		this.isValidated = false;
		this.haselectivelist = value;
	}
	public boolean getOutcomeIsNotNull()
	{
		return this.outcome != null;
	}
	public ims.scheduling.vo.lookups.ApptOutcome getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.scheduling.vo.lookups.ApptOutcome value)
	{
		this.isValidated = false;
		this.outcome = value;
	}
	public boolean getOutcomeActionsIsNotNull()
	{
		return this.outcomeactions != null;
	}
	public ims.scheduling.vo.AppointmentOutcomeActionVoCollection getOutcomeActions()
	{
		return this.outcomeactions;
	}
	public void setOutcomeActions(ims.scheduling.vo.AppointmentOutcomeActionVoCollection value)
	{
		this.isValidated = false;
		this.outcomeactions = value;
	}
	public boolean getCaseNotesPulledIsNotNull()
	{
		return this.casenotespulled != null;
	}
	public Boolean getCaseNotesPulled()
	{
		return this.casenotespulled;
	}
	public void setCaseNotesPulled(Boolean value)
	{
		this.isValidated = false;
		this.casenotespulled = value;
	}
	public boolean getWasSelectedIsNotNull()
	{
		return this.wasselected != null;
	}
	public Boolean getWasSelected()
	{
		return this.wasselected;
	}
	public void setWasSelected(Boolean value)
	{
		this.isValidated = false;
		this.wasselected = value;
	}
	/**
	* OutpatientEpisodeWithICPInfoVoTimeComparator   (class definition)
	*/
		public static class OutpatientEpisodeWithICPInfoVoTimeComparator implements java.util.Comparator
		{
			private int direction = 1;
			public OutpatientEpisodeWithICPInfoVoTimeComparator ()
			{
				this(ims.framework.enumerations.SortOrder.ASCENDING);
			}
			public OutpatientEpisodeWithICPInfoVoTimeComparator (ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(Object obj1, Object obj2)
			{
				OutpatientEpisodeWithICPInfoVo voObj1 = (OutpatientEpisodeWithICPInfoVo)obj1;
				OutpatientEpisodeWithICPInfoVo voObj2 = (OutpatientEpisodeWithICPInfoVo)obj2;
				if (voObj1.getAppointmentTimeIsNotNull()
					&& voObj2.getAppointmentTimeIsNotNull())
				{	
					if (voObj1.getAppointmentTime() == null)
						return -1;
					if (voObj2.getAppointmentTime() == null)
						return 1;			
			
					return direction*(voObj1.getAppointmentTime().compareTo(voObj2.getAppointmentTime()));
				}
				else
					return direction;
			}
			public boolean equals(Object obj)
			{
				return false;
			}	
		}
	/**
	* getTimeComparator - retrieves a new instance of static class OutpatientEpisodeWithICPInfoVoTimeComparator
	*/
	public static OutpatientEpisodeWithICPInfoVoTimeComparator getTimeComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OutpatientEpisodeWithICPInfoVo.OutpatientEpisodeWithICPInfoVoTimeComparator(sortOrder);
	}
	
	/**
	* getDOBComparator - retrieves a new instance of static class OutpatientEpisodeWithICPInfoVoDOBComparator
	*/
	public static OutpatientEpisodeWithICPInfoVoDOBComparator getDOBComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OutpatientEpisodeWithICPInfoVo.OutpatientEpisodeWithICPInfoVoDOBComparator(sortOrder);
	}
	
	/**
	* OutpatientEpisodeWithICPInfoVoDOBComparator   (class definition)
	*/
			public static class OutpatientEpisodeWithICPInfoVoDOBComparator implements java.util.Comparator
			{
				private int direction = 1;
				public OutpatientEpisodeWithICPInfoVoDOBComparator ()
				{
					this(ims.framework.enumerations.SortOrder.ASCENDING);
				}
				public OutpatientEpisodeWithICPInfoVoDOBComparator (ims.framework.enumerations.SortOrder order)
				{
					if (order == ims.framework.enumerations.SortOrder.DESCENDING)
					{
						direction = -1;
					}
				}
				public int compare(Object obj1, Object obj2)
				{
					OutpatientEpisodeWithICPInfoVo  voObj1 = (OutpatientEpisodeWithICPInfoVo )obj1;
					OutpatientEpisodeWithICPInfoVo  voObj2 = (OutpatientEpisodeWithICPInfoVo )obj2;
					ims.framework.utils.PartialDate pdate1 = null;
					ims.framework.utils.PartialDate pdate2 = null;
	
					pdate1 = voObj1.getPatient().getDob();
					pdate2 = voObj2.getPatient().getDob();
	
					if(pdate1 != null )
						return  pdate1.compareTo(pdate2)*direction;
					if(pdate2 != null)
						return (-1)*direction;
				
					return 0;
				}
				public boolean equals(Object obj)
				{
					return false;
				}	
	}
	/**
	* OutpatientEpisodeWithICPInfoVoICPImageComparator   (class definition)
	*/
		public static class OutpatientEpisodeWithICPInfoVoICPImageComparator implements java.util.Comparator
		{
			private int direction = 1;
			public OutpatientEpisodeWithICPInfoVoICPImageComparator ()
			{
				this(ims.framework.enumerations.SortOrder.ASCENDING);
			}
			public OutpatientEpisodeWithICPInfoVoICPImageComparator (ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(Object obj1, Object obj2)
			{
				OutpatientEpisodeWithICPInfoVo voObj1 = (OutpatientEpisodeWithICPInfoVo)obj1;
				OutpatientEpisodeWithICPInfoVo voObj2 = (OutpatientEpisodeWithICPInfoVo)obj2;
				if( (voObj1.getICPInfoIsNotNull() 
					&& voObj2.getICPInfoIsNotNull() )
				|| (voObj1.getICPInfoIsNotNull() 
					&& voObj2.getICPInfo() == null) )
					return  -1*direction;
					
				if( ( voObj2.getICPInfoIsNotNull() 
					&& voObj1.getICPInfoIsNotNull() )
				|| (voObj2.getICPInfoIsNotNull()
					&& voObj1.getICPInfo() == null ) )
					return 1*direction;
					
				return direction;
			}
			public boolean equals(Object obj)
			{
				return false;
			}	
		}
	/**
	* OutpatientEpisodeWithICPInfoVoNurseImageComparator   (class definition)
	*/
		public static class OutpatientEpisodeWithICPInfoVoNurseImageComparator implements java.util.Comparator
		{
			private int direction = 1;
			public OutpatientEpisodeWithICPInfoVoNurseImageComparator ()
			{
				this(ims.framework.enumerations.SortOrder.ASCENDING);
			}
			public OutpatientEpisodeWithICPInfoVoNurseImageComparator (ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(Object obj1, Object obj2)
			{
				OutpatientEpisodeWithICPInfoVo voObj1 = (OutpatientEpisodeWithICPInfoVo)obj1;
				OutpatientEpisodeWithICPInfoVo voObj2 = (OutpatientEpisodeWithICPInfoVo)obj2;
				if( (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingNursingActions()
					&& voObj2.getICPInfoIsNotNull() &&  ! voObj2.getICPInfo().getHasOutstandingNursingActions())
				|| (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingNursingActions()
					&& voObj2.getICPInfo() == null) )
					return  -1*direction;
					
				if( ( voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingNursingActions()
					&& voObj1.getICPInfoIsNotNull() && ! voObj1.getICPInfo().getHasOutstandingNursingActions())
				|| (voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingNursingActions()
					&& voObj1.getICPInfo() == null ) )
					return 1*direction;
					
				return direction;
			}
			public boolean equals(Object obj)
			{
				return false;
			}	
		}
	/**
	* OutpatientEpisodeWithICPInfoVoMedicImageComparator   (class definition)
	*/
		public static class OutpatientEpisodeWithICPInfoVoMedicImageComparator  implements java.util.Comparator
		{
			private int direction = 1;
			public OutpatientEpisodeWithICPInfoVoMedicImageComparator  ()
			{
				this(ims.framework.enumerations.SortOrder.ASCENDING);
			}
			public OutpatientEpisodeWithICPInfoVoMedicImageComparator  (ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(Object obj1, Object obj2)
			{
				OutpatientEpisodeWithICPInfoVo voObj1 = (OutpatientEpisodeWithICPInfoVo)obj1;
				OutpatientEpisodeWithICPInfoVo voObj2 = (OutpatientEpisodeWithICPInfoVo)obj2;
				if( (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingClinicalActions()
					&& voObj2.getICPInfoIsNotNull() &&  ! voObj2.getICPInfo().getHasOutstandingClinicalActions())
				|| (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingClinicalActions()
					&& voObj2.getICPInfo() == null) )
					return  -1*direction;
					
				if( ( voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingClinicalActions()
					&& voObj1.getICPInfoIsNotNull() && ! voObj1.getICPInfo().getHasOutstandingClinicalActions())
				|| (voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingClinicalActions()
					&& voObj1.getICPInfo() == null ) )
					return 1*direction;
					
				return direction;
			}
			public boolean equals(Object obj)
			{
				return false;
			}	
		}
	/**
	* OutpatientEpisodeWithICPInfoVoPhysioImageComparator   (class definition)
	*/
		public static class OutpatientEpisodeWithICPInfoVoPhysioImageComparator   implements java.util.Comparator
		{
			private int direction = 1;
			public OutpatientEpisodeWithICPInfoVoPhysioImageComparator   ()
			{
				this(ims.framework.enumerations.SortOrder.ASCENDING);
			}
			public OutpatientEpisodeWithICPInfoVoPhysioImageComparator   (ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(Object obj1, Object obj2)
			{
				OutpatientEpisodeWithICPInfoVo voObj1 = (OutpatientEpisodeWithICPInfoVo)obj1;
				OutpatientEpisodeWithICPInfoVo voObj2 = (OutpatientEpisodeWithICPInfoVo)obj2;
				if( (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingPhysioActions()
					&& voObj2.getICPInfoIsNotNull() &&  ! voObj2.getICPInfo().getHasOutstandingPhysioActions())
				|| (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingPhysioActions()
					&& voObj2.getICPInfo() == null) )
					return  -1*direction;
					
				if( ( voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingPhysioActions()
					&& voObj1.getICPInfoIsNotNull() && ! voObj1.getICPInfo().getHasOutstandingPhysioActions())
				|| (voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingPhysioActions()
					&& voObj1.getICPInfo() == null ) )
					return 1*direction;
					
				return direction;
			}
			public boolean equals(Object obj)
			{
				return false;
			}	
		}
	/**
	* OutpatientEpisodeWithICPInfoVoAdminImageComparator   (class definition)
	*/
		public static class OutpatientEpisodeWithICPInfoVoAdminImageComparator    implements java.util.Comparator
		{
			private int direction = 1;
			public OutpatientEpisodeWithICPInfoVoAdminImageComparator    ()
			{
				this(ims.framework.enumerations.SortOrder.ASCENDING);
			}
			public OutpatientEpisodeWithICPInfoVoAdminImageComparator    (ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(Object obj1, Object obj2)
			{
				OutpatientEpisodeWithICPInfoVo voObj1 = (OutpatientEpisodeWithICPInfoVo)obj1;
				OutpatientEpisodeWithICPInfoVo voObj2 = (OutpatientEpisodeWithICPInfoVo)obj2;
				if( (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingAdminActions()
					&& voObj2.getICPInfoIsNotNull() &&  ! voObj2.getICPInfo().getHasOutstandingAdminActions())
				|| (voObj1.getICPInfoIsNotNull() && voObj1.getICPInfo().getHasOutstandingAdminActions()
					&& voObj2.getICPInfo() == null) )
					return  -1*direction;
					
				if( ( voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingAdminActions()
					&& voObj1.getICPInfoIsNotNull() && ! voObj1.getICPInfo().getHasOutstandingAdminActions())
				|| (voObj2.getICPInfoIsNotNull() && voObj2.getICPInfo().getHasOutstandingAdminActions()
					&& voObj1.getICPInfo() == null ) )
					return 1*direction;
					
				return direction;
			}
			public boolean equals(Object obj)
			{
				return false;
			}	
		}
	/**
	* getICPImageComparator - retrieves a new instance of static class OutpatientEpisodeWithICPInfoVoICPImageComparator
	*/
	public static OutpatientEpisodeWithICPInfoVoICPImageComparator getICPImageComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OutpatientEpisodeWithICPInfoVo.OutpatientEpisodeWithICPInfoVoICPImageComparator(sortOrder);
	}
	
	
	/**
	* getNurseImageComparator - retrieves a new instance of static class OutpatientEpisodeWithICPInfoVoNurseImageComparator
	*/
	public static OutpatientEpisodeWithICPInfoVoNurseImageComparator getNurseImageComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OutpatientEpisodeWithICPInfoVo.OutpatientEpisodeWithICPInfoVoNurseImageComparator(sortOrder);
	}
	
	
	/**
	* getMedicImageComparator - retrieves a new instance of static class OutpatientEpisodeWithICPInfoVoMedicImageComparator
	*/
	public static OutpatientEpisodeWithICPInfoVoMedicImageComparator getMedicImageComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OutpatientEpisodeWithICPInfoVo.OutpatientEpisodeWithICPInfoVoMedicImageComparator(sortOrder);
	}
	
	
	/**
	* getPhysioImageComparator - retrieves a new instance of static class OutpatientEpisodeWithICPInfoVoPhysioImageComparator
	*/
	public static OutpatientEpisodeWithICPInfoVoPhysioImageComparator getPhysioImageComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OutpatientEpisodeWithICPInfoVo.OutpatientEpisodeWithICPInfoVoPhysioImageComparator(sortOrder);
	}
	
	
	/**
	* getAdminImageComparator - retrieves a new instance of static class OutpatientEpisodeWithICPInfoVoAdminImageComparator
	*/
	public static OutpatientEpisodeWithICPInfoVoAdminImageComparator getAdminImageComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new OutpatientEpisodeWithICPInfoVo.OutpatientEpisodeWithICPInfoVoAdminImageComparator(sortOrder);
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
		if(this.icpinfo != null)
		{
			if(!this.icpinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.referral != null)
		{
			if(!this.referral.isValidated())
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
		if(this.icpinfo != null)
		{
			String[] listOfOtherErrors = this.icpinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.referral != null)
		{
			String[] listOfOtherErrors = this.referral.validate();
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
	
		OutpatientEpisodeWithICPInfoVo clone = new OutpatientEpisodeWithICPInfoVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.appointmenttime == null)
			clone.appointmenttime = null;
		else
			clone.appointmenttime = (ims.framework.utils.Time)this.appointmenttime.clone();
		if(this.session == null)
			clone.session = null;
		else
			clone.session = (ims.scheduling.vo.SessionLiteWithListownerVo)this.session.clone();
		if(this.icpinfo == null)
			clone.icpinfo = null;
		else
			clone.icpinfo = (ims.icp.vo.PatientICPLiteVo)this.icpinfo.clone();
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.Date)this.appointmentdate.clone();
		if(this.currentappttrakingstatus == null)
			clone.currentappttrakingstatus = null;
		else
			clone.currentappttrakingstatus = (ims.scheduling.vo.Appt_Tracking_Status_HistoryVo)this.currentappttrakingstatus.clone();
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityLiteVo)this.activity.clone();
		if(this.appointmenttrackingstatus == null)
			clone.appointmenttrackingstatus = null;
		else
			clone.appointmenttrackingstatus = (ims.admin.vo.AppointmentTrackingstatusColourConfigVo)this.appointmenttrackingstatus.clone();
		if(this.referral == null)
			clone.referral = null;
		else
			clone.referral = (ims.RefMan.vo.CatsReferralBreachDatesVo)this.referral.clone();
		clone.haselectivelist = this.haselectivelist;
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.scheduling.vo.lookups.ApptOutcome)this.outcome.clone();
		if(this.outcomeactions == null)
			clone.outcomeactions = null;
		else
			clone.outcomeactions = (ims.scheduling.vo.AppointmentOutcomeActionVoCollection)this.outcomeactions.clone();
		clone.casenotespulled = this.casenotespulled;
		clone.wasselected = this.wasselected;
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
		if (!(OutpatientEpisodeWithICPInfoVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OutpatientEpisodeWithICPInfoVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OutpatientEpisodeWithICPInfoVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OutpatientEpisodeWithICPInfoVo)obj).getBoId());
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
		if(this.appointmenttime != null)
			count++;
		if(this.session != null)
			count++;
		if(this.icpinfo != null)
			count++;
		if(this.apptstatus != null)
			count++;
		if(this.appointmentdate != null)
			count++;
		if(this.currentappttrakingstatus != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.appointmenttrackingstatus != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.haselectivelist != null)
			count++;
		if(this.outcome != null)
			count++;
		if(this.outcomeactions != null)
			count++;
		if(this.casenotespulled != null)
			count++;
		if(this.wasselected != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.core.vo.PatientShort patient;
	protected ims.framework.utils.Time appointmenttime;
	protected ims.scheduling.vo.SessionLiteWithListownerVo session;
	protected ims.icp.vo.PatientICPLiteVo icpinfo;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	protected ims.framework.utils.Date appointmentdate;
	protected ims.scheduling.vo.Appt_Tracking_Status_HistoryVo currentappttrakingstatus;
	protected ims.core.vo.ActivityLiteVo activity;
	protected ims.admin.vo.AppointmentTrackingstatusColourConfigVo appointmenttrackingstatus;
	protected ims.RefMan.vo.CatsReferralBreachDatesVo referral;
	protected Boolean haselectivelist;
	protected ims.scheduling.vo.lookups.ApptOutcome outcome;
	protected ims.scheduling.vo.AppointmentOutcomeActionVoCollection outcomeactions;
	protected Boolean casenotespulled;
	protected Boolean wasselected;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
