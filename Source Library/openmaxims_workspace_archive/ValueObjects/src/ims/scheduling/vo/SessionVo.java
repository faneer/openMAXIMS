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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class SessionVo extends ims.scheduling.vo.SessionShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionVo()
	{
	}
	public SessionVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionVo(ims.scheduling.vo.beans.SessionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.remainingslots = bean.getRemainingSlots();
		this.totalslots = bean.getTotalSlots();
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.isfixed = bean.getIsFixed();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.remainingtime = bean.getRemainingTime();
		this.sessiondate = bean.getSessionDate() == null ? null : bean.getSessionDate().buildDate();
		this.exclusiontimes = ims.scheduling.vo.Session_Exc_TimesVoCollection.buildFromBeanCollection(bean.getExclusionTimes());
		this.maxcontinuousavailablemins = bean.getMaxContinuousAvailableMins();
		this.consmediatype = bean.getConsMediaType() == null ? null : ims.scheduling.vo.lookups.ConsultationMediaType.buildLookup(bean.getConsMediaType());
		this.sessionstatus = bean.getSessionStatus() == null ? null : ims.scheduling.vo.lookups.Session_Status_and_Reason.buildLookup(bean.getSessionStatus());
		this.description = bean.getDescription();
		this.isactive = bean.getIsActive();
		this.pasclinic = bean.getPASClinic() == null ? null : ims.scheduling.vo.lookups.SchedPASClinic.buildLookup(bean.getPASClinic());
		this.istheatresession = bean.getIsTheatreSession();
		this.listowners = ims.scheduling.vo.Session_ListOwnerVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancellationReason());
		this.comment = bean.getComment();
		this.wassessionmoved = bean.getWasSessionMoved();
		this.calendarslots = ims.scheduling.vo.SessionSlotWithStatusOnlyVoCollection.buildFromBeanCollection(bean.getCalendarSlots());
		this.statusreason = bean.getStatusReason() == null ? null : ims.scheduling.vo.lookups.Session_Status_and_Reason.buildLookup(bean.getStatusReason());
		this.duration = bean.getDuration();
		this.sessiontype = bean.getSessionType() == null ? null : ims.scheduling.vo.lookups.Sched_Profile_Type.buildLookup(bean.getSessionType());
		this.minint = bean.getMinInt();
		this.roundatttime = bean.getRoundAttTime();
		this.lastappinterval = bean.getLastAppInterval();
		this.maxnoappts = bean.getMaxNoAppts();
		this.sessionslots = ims.scheduling.vo.SessionSlotVoCollection.buildFromBeanCollection(bean.getSessionSlots());
		this.directoryofservices = ims.scheduling.vo.DirectoryOfServiceVoCollection.buildFromBeanCollection(bean.getDirectoryofServices());
		this.ismodified = bean.getIsModified();
		this.isadhocsession = bean.getIsAdHocSession();
		this.bookingrights = ims.scheduling.vo.Session_BookingRightVoCollection.buildFromBeanCollection(bean.getBookingRights());
		this.sessionactivities = ims.scheduling.vo.SessionActivityLiteVoCollection.buildFromBeanCollection(bean.getSessionActivities());
		this.theatreproceduresremaining = bean.getTheatreProceduresRemaining() == null ? null : bean.getTheatreProceduresRemaining().buildVo();
		this.theatreslots = ims.scheduling.vo.SessionTheatreTCISlotLiteVoCollection.buildFromBeanCollection(bean.getTheatreSlots());
		this.parentchildslots = ims.scheduling.vo.SessionParentChildSlotVoCollection.buildFromBeanCollection(bean.getParentChildSlots());
		this.slottype = bean.getSlotType() == null ? null : ims.scheduling.vo.lookups.SlotType.buildLookup(bean.getSlotType());
		this.anaesthetictype = ims.clinical.vo.lookups.AnaestheticTypeCollection.buildFromBeanCollection(bean.getAnaestheticType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo(map);
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.remainingslots = bean.getRemainingSlots();
		this.totalslots = bean.getTotalSlots();
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.isfixed = bean.getIsFixed();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.remainingtime = bean.getRemainingTime();
		this.sessiondate = bean.getSessionDate() == null ? null : bean.getSessionDate().buildDate();
		this.exclusiontimes = ims.scheduling.vo.Session_Exc_TimesVoCollection.buildFromBeanCollection(bean.getExclusionTimes());
		this.maxcontinuousavailablemins = bean.getMaxContinuousAvailableMins();
		this.consmediatype = bean.getConsMediaType() == null ? null : ims.scheduling.vo.lookups.ConsultationMediaType.buildLookup(bean.getConsMediaType());
		this.sessionstatus = bean.getSessionStatus() == null ? null : ims.scheduling.vo.lookups.Session_Status_and_Reason.buildLookup(bean.getSessionStatus());
		this.description = bean.getDescription();
		this.isactive = bean.getIsActive();
		this.pasclinic = bean.getPASClinic() == null ? null : ims.scheduling.vo.lookups.SchedPASClinic.buildLookup(bean.getPASClinic());
		this.istheatresession = bean.getIsTheatreSession();
		this.listowners = ims.scheduling.vo.Session_ListOwnerVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancellationReason());
		this.comment = bean.getComment();
		this.wassessionmoved = bean.getWasSessionMoved();
		this.calendarslots = ims.scheduling.vo.SessionSlotWithStatusOnlyVoCollection.buildFromBeanCollection(bean.getCalendarSlots());
		this.statusreason = bean.getStatusReason() == null ? null : ims.scheduling.vo.lookups.Session_Status_and_Reason.buildLookup(bean.getStatusReason());
		this.duration = bean.getDuration();
		this.sessiontype = bean.getSessionType() == null ? null : ims.scheduling.vo.lookups.Sched_Profile_Type.buildLookup(bean.getSessionType());
		this.minint = bean.getMinInt();
		this.roundatttime = bean.getRoundAttTime();
		this.lastappinterval = bean.getLastAppInterval();
		this.maxnoappts = bean.getMaxNoAppts();
		this.sessionslots = ims.scheduling.vo.SessionSlotVoCollection.buildFromBeanCollection(bean.getSessionSlots());
		this.directoryofservices = ims.scheduling.vo.DirectoryOfServiceVoCollection.buildFromBeanCollection(bean.getDirectoryofServices());
		this.ismodified = bean.getIsModified();
		this.isadhocsession = bean.getIsAdHocSession();
		this.bookingrights = ims.scheduling.vo.Session_BookingRightVoCollection.buildFromBeanCollection(bean.getBookingRights());
		this.sessionactivities = ims.scheduling.vo.SessionActivityLiteVoCollection.buildFromBeanCollection(bean.getSessionActivities());
		this.theatreproceduresremaining = bean.getTheatreProceduresRemaining() == null ? null : bean.getTheatreProceduresRemaining().buildVo(map);
		this.theatreslots = ims.scheduling.vo.SessionTheatreTCISlotLiteVoCollection.buildFromBeanCollection(bean.getTheatreSlots());
		this.parentchildslots = ims.scheduling.vo.SessionParentChildSlotVoCollection.buildFromBeanCollection(bean.getParentChildSlots());
		this.slottype = bean.getSlotType() == null ? null : ims.scheduling.vo.lookups.SlotType.buildLookup(bean.getSlotType());
		this.anaesthetictype = ims.clinical.vo.lookups.AnaestheticTypeCollection.buildFromBeanCollection(bean.getAnaestheticType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionVoBean();
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
		if(fieldName.equals("STATUSREASON"))
			return getStatusReason();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("SESSIONTYPE"))
			return getSessionType();
		if(fieldName.equals("MININT"))
			return getMinInt();
		if(fieldName.equals("ROUNDATTTIME"))
			return getRoundAttTime();
		if(fieldName.equals("LASTAPPINTERVAL"))
			return getLastAppInterval();
		if(fieldName.equals("MAXNOAPPTS"))
			return getMaxNoAppts();
		if(fieldName.equals("SESSIONSLOTS"))
			return getSessionSlots();
		if(fieldName.equals("DIRECTORYOFSERVICES"))
			return getDirectoryofServices();
		if(fieldName.equals("ISMODIFIED"))
			return getIsModified();
		if(fieldName.equals("ISADHOCSESSION"))
			return getIsAdHocSession();
		if(fieldName.equals("BOOKINGRIGHTS"))
			return getBookingRights();
		if(fieldName.equals("SESSIONACTIVITIES"))
			return getSessionActivities();
		if(fieldName.equals("THEATREPROCEDURESREMAINING"))
			return getTheatreProceduresRemaining();
		if(fieldName.equals("THEATRESLOTS"))
			return getTheatreSlots();
		if(fieldName.equals("PARENTCHILDSLOTS"))
			return getParentChildSlots();
		if(fieldName.equals("SLOTTYPE"))
			return getSlotType();
		if(fieldName.equals("ANAESTHETICTYPE"))
			return getAnaestheticType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusReasonIsNotNull()
	{
		return this.statusreason != null;
	}
	public ims.scheduling.vo.lookups.Session_Status_and_Reason getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(ims.scheduling.vo.lookups.Session_Status_and_Reason value)
	{
		this.isValidated = false;
		this.statusreason = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
	}
	public boolean getSessionTypeIsNotNull()
	{
		return this.sessiontype != null;
	}
	public ims.scheduling.vo.lookups.Sched_Profile_Type getSessionType()
	{
		return this.sessiontype;
	}
	public void setSessionType(ims.scheduling.vo.lookups.Sched_Profile_Type value)
	{
		this.isValidated = false;
		this.sessiontype = value;
	}
	public boolean getMinIntIsNotNull()
	{
		return this.minint != null;
	}
	public Integer getMinInt()
	{
		return this.minint;
	}
	public void setMinInt(Integer value)
	{
		this.isValidated = false;
		this.minint = value;
	}
	public boolean getRoundAttTimeIsNotNull()
	{
		return this.roundatttime != null;
	}
	public Integer getRoundAttTime()
	{
		return this.roundatttime;
	}
	public void setRoundAttTime(Integer value)
	{
		this.isValidated = false;
		this.roundatttime = value;
	}
	public boolean getLastAppIntervalIsNotNull()
	{
		return this.lastappinterval != null;
	}
	public Integer getLastAppInterval()
	{
		return this.lastappinterval;
	}
	public void setLastAppInterval(Integer value)
	{
		this.isValidated = false;
		this.lastappinterval = value;
	}
	public boolean getMaxNoApptsIsNotNull()
	{
		return this.maxnoappts != null;
	}
	public Integer getMaxNoAppts()
	{
		return this.maxnoappts;
	}
	public void setMaxNoAppts(Integer value)
	{
		this.isValidated = false;
		this.maxnoappts = value;
	}
	public boolean getSessionSlotsIsNotNull()
	{
		return this.sessionslots != null;
	}
	public ims.scheduling.vo.SessionSlotVoCollection getSessionSlots()
	{
		return this.sessionslots;
	}
	public void setSessionSlots(ims.scheduling.vo.SessionSlotVoCollection value)
	{
		this.isValidated = false;
		this.sessionslots = value;
	}
	public boolean getDirectoryofServicesIsNotNull()
	{
		return this.directoryofservices != null;
	}
	public ims.scheduling.vo.DirectoryOfServiceVoCollection getDirectoryofServices()
	{
		return this.directoryofservices;
	}
	public void setDirectoryofServices(ims.scheduling.vo.DirectoryOfServiceVoCollection value)
	{
		this.isValidated = false;
		this.directoryofservices = value;
	}
	public boolean getIsModifiedIsNotNull()
	{
		return this.ismodified != null;
	}
	public Boolean getIsModified()
	{
		return this.ismodified;
	}
	public void setIsModified(Boolean value)
	{
		this.isValidated = false;
		this.ismodified = value;
	}
	public boolean getIsAdHocSessionIsNotNull()
	{
		return this.isadhocsession != null;
	}
	public Boolean getIsAdHocSession()
	{
		return this.isadhocsession;
	}
	public void setIsAdHocSession(Boolean value)
	{
		this.isValidated = false;
		this.isadhocsession = value;
	}
	public boolean getBookingRightsIsNotNull()
	{
		return this.bookingrights != null;
	}
	public ims.scheduling.vo.Session_BookingRightVoCollection getBookingRights()
	{
		return this.bookingrights;
	}
	public void setBookingRights(ims.scheduling.vo.Session_BookingRightVoCollection value)
	{
		this.isValidated = false;
		this.bookingrights = value;
	}
	public boolean getSessionActivitiesIsNotNull()
	{
		return this.sessionactivities != null;
	}
	public ims.scheduling.vo.SessionActivityLiteVoCollection getSessionActivities()
	{
		return this.sessionactivities;
	}
	public void setSessionActivities(ims.scheduling.vo.SessionActivityLiteVoCollection value)
	{
		this.isValidated = false;
		this.sessionactivities = value;
	}
	public boolean getTheatreProceduresRemainingIsNotNull()
	{
		return this.theatreproceduresremaining != null;
	}
	public ims.scheduling.vo.SessionTheatreProceduresRemainingVo getTheatreProceduresRemaining()
	{
		return this.theatreproceduresremaining;
	}
	public void setTheatreProceduresRemaining(ims.scheduling.vo.SessionTheatreProceduresRemainingVo value)
	{
		this.isValidated = false;
		this.theatreproceduresremaining = value;
	}
	public boolean getTheatreSlotsIsNotNull()
	{
		return this.theatreslots != null;
	}
	public ims.scheduling.vo.SessionTheatreTCISlotLiteVoCollection getTheatreSlots()
	{
		return this.theatreslots;
	}
	public void setTheatreSlots(ims.scheduling.vo.SessionTheatreTCISlotLiteVoCollection value)
	{
		this.isValidated = false;
		this.theatreslots = value;
	}
	public boolean getParentChildSlotsIsNotNull()
	{
		return this.parentchildslots != null;
	}
	public ims.scheduling.vo.SessionParentChildSlotVoCollection getParentChildSlots()
	{
		return this.parentchildslots;
	}
	public void setParentChildSlots(ims.scheduling.vo.SessionParentChildSlotVoCollection value)
	{
		this.isValidated = false;
		this.parentchildslots = value;
	}
	public boolean getSlotTypeIsNotNull()
	{
		return this.slottype != null;
	}
	public ims.scheduling.vo.lookups.SlotType getSlotType()
	{
		return this.slottype;
	}
	public void setSlotType(ims.scheduling.vo.lookups.SlotType value)
	{
		this.isValidated = false;
		this.slottype = value;
	}
	public boolean getAnaestheticTypeIsNotNull()
	{
		return this.anaesthetictype != null;
	}
	public ims.clinical.vo.lookups.AnaestheticTypeCollection getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.clinical.vo.lookups.AnaestheticTypeCollection value)
	{
		this.isValidated = false;
		this.anaesthetictype = value;
	}
	/**
	* getAnaestheticTypesAsString
	*/
	public String getAnaestheticTypesAsString()
	{
		if(this.anaesthetictype == null || this.anaesthetictype.size() == 0)
			return "";
		
		String retString = "";
		for(int i=0;i<this.anaesthetictype.size();i++)
		{
			retString += this.anaesthetictype.get(i).getText();
			retString += ((this.anaesthetictype.size() - (i+1)) > 0 ? "\n" : "");
		}
		
		return retString;
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
		if(this.schlocation != null)
		{
			if(!this.schlocation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.exclusiontimes != null)
		{
			if(!this.exclusiontimes.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.listowners != null)
		{
			if(!this.listowners.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.sessionslots != null)
		{
			if(!this.sessionslots.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.directoryofservices != null)
		{
			if(!this.directoryofservices.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.bookingrights != null)
		{
			if(!this.bookingrights.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.sessionactivities != null)
		{
			if(!this.sessionactivities.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.theatreproceduresremaining != null)
		{
			if(!this.theatreproceduresremaining.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.theatreslots != null)
		{
			if(!this.theatreslots.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.parentchildslots != null)
		{
			if(!this.parentchildslots.isValidated())
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
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.SessionVo] is too big. It should be less or equal to 100");
		if(this.schlocation != null)
		{
			String[] listOfOtherErrors = this.schlocation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
		if(this.remainingslots == null)
			listOfErrors.add("RemainingSlots is mandatory");
		if(this.totalslots == null)
			listOfErrors.add("TotalSlots is mandatory");
		if(this.exclusiontimes != null)
		{
			String[] listOfOtherErrors = this.exclusiontimes.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.scheduling.vo.SessionVo] is too big. It should be less or equal to 255");
		if(this.listowners != null)
		{
			String[] listOfOtherErrors = this.listowners.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.scheduling.vo.SessionVo] is too big. It should be less or equal to 255");
		if(this.sessionslots != null)
		{
			String[] listOfOtherErrors = this.sessionslots.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.directoryofservices != null)
		{
			String[] listOfOtherErrors = this.directoryofservices.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.bookingrights != null)
		{
			String[] listOfOtherErrors = this.bookingrights.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.sessionactivities != null)
		{
			String[] listOfOtherErrors = this.sessionactivities.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.theatreproceduresremaining != null)
		{
			String[] listOfOtherErrors = this.theatreproceduresremaining.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.theatreslots != null)
		{
			String[] listOfOtherErrors = this.theatreslots.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.parentchildslots != null)
		{
			String[] listOfOtherErrors = this.parentchildslots.validate();
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
	
		SessionVo clone = new SessionVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.schlocation == null)
			clone.schlocation = null;
		else
			clone.schlocation = (ims.core.vo.LocShortVo)this.schlocation.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		clone.remainingslots = this.remainingslots;
		clone.totalslots = this.totalslots;
		if(this.theatretype == null)
			clone.theatretype = null;
		else
			clone.theatretype = (ims.scheduling.vo.lookups.TheatreType)this.theatretype.clone();
		clone.isfixed = this.isfixed;
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		if(this.endtm == null)
			clone.endtm = null;
		else
			clone.endtm = (ims.framework.utils.Time)this.endtm.clone();
		clone.remainingtime = this.remainingtime;
		if(this.sessiondate == null)
			clone.sessiondate = null;
		else
			clone.sessiondate = (ims.framework.utils.Date)this.sessiondate.clone();
		if(this.exclusiontimes == null)
			clone.exclusiontimes = null;
		else
			clone.exclusiontimes = (ims.scheduling.vo.Session_Exc_TimesVoCollection)this.exclusiontimes.clone();
		clone.maxcontinuousavailablemins = this.maxcontinuousavailablemins;
		if(this.consmediatype == null)
			clone.consmediatype = null;
		else
			clone.consmediatype = (ims.scheduling.vo.lookups.ConsultationMediaType)this.consmediatype.clone();
		if(this.sessionstatus == null)
			clone.sessionstatus = null;
		else
			clone.sessionstatus = (ims.scheduling.vo.lookups.Session_Status_and_Reason)this.sessionstatus.clone();
		clone.description = this.description;
		clone.isactive = this.isactive;
		if(this.pasclinic == null)
			clone.pasclinic = null;
		else
			clone.pasclinic = (ims.scheduling.vo.lookups.SchedPASClinic)this.pasclinic.clone();
		clone.istheatresession = this.istheatresession;
		if(this.listowners == null)
			clone.listowners = null;
		else
			clone.listowners = (ims.scheduling.vo.Session_ListOwnerVoCollection)this.listowners.clone();
		if(this.cancellationreason == null)
			clone.cancellationreason = null;
		else
			clone.cancellationreason = (ims.scheduling.vo.lookups.CancelAppointmentReason)this.cancellationreason.clone();
		clone.comment = this.comment;
		clone.wassessionmoved = this.wassessionmoved;
		if(this.calendarslots == null)
			clone.calendarslots = null;
		else
			clone.calendarslots = (ims.scheduling.vo.SessionSlotWithStatusOnlyVoCollection)this.calendarslots.clone();
		if(this.statusreason == null)
			clone.statusreason = null;
		else
			clone.statusreason = (ims.scheduling.vo.lookups.Session_Status_and_Reason)this.statusreason.clone();
		clone.duration = this.duration;
		if(this.sessiontype == null)
			clone.sessiontype = null;
		else
			clone.sessiontype = (ims.scheduling.vo.lookups.Sched_Profile_Type)this.sessiontype.clone();
		clone.minint = this.minint;
		clone.roundatttime = this.roundatttime;
		clone.lastappinterval = this.lastappinterval;
		clone.maxnoappts = this.maxnoappts;
		if(this.sessionslots == null)
			clone.sessionslots = null;
		else
			clone.sessionslots = (ims.scheduling.vo.SessionSlotVoCollection)this.sessionslots.clone();
		if(this.directoryofservices == null)
			clone.directoryofservices = null;
		else
			clone.directoryofservices = (ims.scheduling.vo.DirectoryOfServiceVoCollection)this.directoryofservices.clone();
		clone.ismodified = this.ismodified;
		clone.isadhocsession = this.isadhocsession;
		if(this.bookingrights == null)
			clone.bookingrights = null;
		else
			clone.bookingrights = (ims.scheduling.vo.Session_BookingRightVoCollection)this.bookingrights.clone();
		if(this.sessionactivities == null)
			clone.sessionactivities = null;
		else
			clone.sessionactivities = (ims.scheduling.vo.SessionActivityLiteVoCollection)this.sessionactivities.clone();
		if(this.theatreproceduresremaining == null)
			clone.theatreproceduresremaining = null;
		else
			clone.theatreproceduresremaining = (ims.scheduling.vo.SessionTheatreProceduresRemainingVo)this.theatreproceduresremaining.clone();
		if(this.theatreslots == null)
			clone.theatreslots = null;
		else
			clone.theatreslots = (ims.scheduling.vo.SessionTheatreTCISlotLiteVoCollection)this.theatreslots.clone();
		if(this.parentchildslots == null)
			clone.parentchildslots = null;
		else
			clone.parentchildslots = (ims.scheduling.vo.SessionParentChildSlotVoCollection)this.parentchildslots.clone();
		if(this.slottype == null)
			clone.slottype = null;
		else
			clone.slottype = (ims.scheduling.vo.lookups.SlotType)this.slottype.clone();
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticTypeCollection)this.anaesthetictype.clone();
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
		if (!(SessionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SessionVo compareObj = (SessionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSessionDate() == null && compareObj.getSessionDate() != null)
				return -1;
			if(this.getSessionDate() != null && compareObj.getSessionDate() == null)
				return 1;
			if(this.getSessionDate() != null && compareObj.getSessionDate() != null)
				retVal = this.getSessionDate().compareTo(compareObj.getSessionDate());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.statusreason != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.sessiontype != null)
			count++;
		if(this.minint != null)
			count++;
		if(this.roundatttime != null)
			count++;
		if(this.lastappinterval != null)
			count++;
		if(this.maxnoappts != null)
			count++;
		if(this.sessionslots != null)
			count++;
		if(this.directoryofservices != null)
			count++;
		if(this.ismodified != null)
			count++;
		if(this.isadhocsession != null)
			count++;
		if(this.bookingrights != null)
			count++;
		if(this.sessionactivities != null)
			count++;
		if(this.theatreproceduresremaining != null)
			count++;
		if(this.theatreslots != null)
			count++;
		if(this.parentchildslots != null)
			count++;
		if(this.slottype != null)
			count++;
		if(this.anaesthetictype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 18;
	}
	protected ims.scheduling.vo.lookups.Session_Status_and_Reason statusreason;
	protected Integer duration;
	protected ims.scheduling.vo.lookups.Sched_Profile_Type sessiontype;
	protected Integer minint;
	protected Integer roundatttime;
	protected Integer lastappinterval;
	protected Integer maxnoappts;
	protected ims.scheduling.vo.SessionSlotVoCollection sessionslots;
	protected ims.scheduling.vo.DirectoryOfServiceVoCollection directoryofservices;
	protected Boolean ismodified;
	protected Boolean isadhocsession;
	protected ims.scheduling.vo.Session_BookingRightVoCollection bookingrights;
	protected ims.scheduling.vo.SessionActivityLiteVoCollection sessionactivities;
	protected ims.scheduling.vo.SessionTheatreProceduresRemainingVo theatreproceduresremaining;
	protected ims.scheduling.vo.SessionTheatreTCISlotLiteVoCollection theatreslots;
	protected ims.scheduling.vo.SessionParentChildSlotVoCollection parentchildslots;
	protected ims.scheduling.vo.lookups.SlotType slottype;
	protected ims.clinical.vo.lookups.AnaestheticTypeCollection anaesthetictype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
