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

package ims.scheduling.vo.beans;

public class SessionShortVoBean extends ims.vo.ValueObjectBean
{
	public SessionShortVoBean()
	{
	}
	public SessionShortVoBean(ims.scheduling.vo.SessionShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getSchLocation().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean();
		this.remainingslots = vo.getRemainingSlots();
		this.totalslots = vo.getTotalSlots();
		this.theatretype = vo.getTheatreType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheatreType().getBean();
		this.isfixed = vo.getIsFixed();
		this.starttm = vo.getStartTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTm().getBean();
		this.endtm = vo.getEndTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTm().getBean();
		this.remainingtime = vo.getRemainingTime();
		this.sessiondate = vo.getSessionDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSessionDate().getBean();
		this.exclusiontimes = vo.getExclusionTimes() == null ? null : vo.getExclusionTimes().getBeanCollection();
		this.maxcontinuousavailablemins = vo.getMaxContinuousAvailableMins();
		this.consmediatype = vo.getConsMediaType() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsMediaType().getBean();
		this.sessionstatus = vo.getSessionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSessionStatus().getBean();
		this.description = vo.getDescription();
		this.isactive = vo.getIsActive();
		this.pasclinic = vo.getPASClinic() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASClinic().getBean();
		this.istheatresession = vo.getIsTheatreSession();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.comment = vo.getComment();
		this.wassessionmoved = vo.getWasSessionMoved();
		this.calendarslots = vo.getCalendarSlots() == null ? null : vo.getCalendarSlots().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.SessionShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getSchLocation().getBean(map);
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean(map);
		this.remainingslots = vo.getRemainingSlots();
		this.totalslots = vo.getTotalSlots();
		this.theatretype = vo.getTheatreType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheatreType().getBean();
		this.isfixed = vo.getIsFixed();
		this.starttm = vo.getStartTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTm().getBean();
		this.endtm = vo.getEndTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTm().getBean();
		this.remainingtime = vo.getRemainingTime();
		this.sessiondate = vo.getSessionDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSessionDate().getBean();
		this.exclusiontimes = vo.getExclusionTimes() == null ? null : vo.getExclusionTimes().getBeanCollection();
		this.maxcontinuousavailablemins = vo.getMaxContinuousAvailableMins();
		this.consmediatype = vo.getConsMediaType() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsMediaType().getBean();
		this.sessionstatus = vo.getSessionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSessionStatus().getBean();
		this.description = vo.getDescription();
		this.isactive = vo.getIsActive();
		this.pasclinic = vo.getPASClinic() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASClinic().getBean();
		this.istheatresession = vo.getIsTheatreSession();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.comment = vo.getComment();
		this.wassessionmoved = vo.getWasSessionMoved();
		this.calendarslots = vo.getCalendarSlots() == null ? null : vo.getCalendarSlots().getBeanCollection();
	}

	public ims.scheduling.vo.SessionShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.SessionShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.SessionShortVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.SessionShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.SessionShortVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.core.vo.beans.LocShortVoBean getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.vo.beans.LocShortVoBean value)
	{
		this.schlocation = value;
	}
	public ims.core.vo.beans.ServiceShortVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceShortVoBean value)
	{
		this.service = value;
	}
	public Integer getRemainingSlots()
	{
		return this.remainingslots;
	}
	public void setRemainingSlots(Integer value)
	{
		this.remainingslots = value;
	}
	public Integer getTotalSlots()
	{
		return this.totalslots;
	}
	public void setTotalSlots(Integer value)
	{
		this.totalslots = value;
	}
	public ims.vo.LookupInstanceBean getTheatreType()
	{
		return this.theatretype;
	}
	public void setTheatreType(ims.vo.LookupInstanceBean value)
	{
		this.theatretype = value;
	}
	public Boolean getIsFixed()
	{
		return this.isfixed;
	}
	public void setIsFixed(Boolean value)
	{
		this.isfixed = value;
	}
	public ims.framework.utils.beans.TimeBean getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.beans.TimeBean value)
	{
		this.starttm = value;
	}
	public ims.framework.utils.beans.TimeBean getEndTm()
	{
		return this.endtm;
	}
	public void setEndTm(ims.framework.utils.beans.TimeBean value)
	{
		this.endtm = value;
	}
	public Integer getRemainingTime()
	{
		return this.remainingtime;
	}
	public void setRemainingTime(Integer value)
	{
		this.remainingtime = value;
	}
	public ims.framework.utils.beans.DateBean getSessionDate()
	{
		return this.sessiondate;
	}
	public void setSessionDate(ims.framework.utils.beans.DateBean value)
	{
		this.sessiondate = value;
	}
	public ims.scheduling.vo.beans.Session_Exc_TimesVoBean[] getExclusionTimes()
	{
		return this.exclusiontimes;
	}
	public void setExclusionTimes(ims.scheduling.vo.beans.Session_Exc_TimesVoBean[] value)
	{
		this.exclusiontimes = value;
	}
	public Integer getMaxContinuousAvailableMins()
	{
		return this.maxcontinuousavailablemins;
	}
	public void setMaxContinuousAvailableMins(Integer value)
	{
		this.maxcontinuousavailablemins = value;
	}
	public ims.vo.LookupInstanceBean getConsMediaType()
	{
		return this.consmediatype;
	}
	public void setConsMediaType(ims.vo.LookupInstanceBean value)
	{
		this.consmediatype = value;
	}
	public ims.vo.LookupInstanceBean getSessionStatus()
	{
		return this.sessionstatus;
	}
	public void setSessionStatus(ims.vo.LookupInstanceBean value)
	{
		this.sessionstatus = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.LookupInstanceBean getPASClinic()
	{
		return this.pasclinic;
	}
	public void setPASClinic(ims.vo.LookupInstanceBean value)
	{
		this.pasclinic = value;
	}
	public Boolean getIsTheatreSession()
	{
		return this.istheatresession;
	}
	public void setIsTheatreSession(Boolean value)
	{
		this.istheatresession = value;
	}
	public ims.scheduling.vo.beans.Session_ListOwnerVoBean[] getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.scheduling.vo.beans.Session_ListOwnerVoBean[] value)
	{
		this.listowners = value;
	}
	public ims.vo.LookupInstanceBean getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.vo.LookupInstanceBean value)
	{
		this.cancellationreason = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public Boolean getWasSessionMoved()
	{
		return this.wassessionmoved;
	}
	public void setWasSessionMoved(Boolean value)
	{
		this.wassessionmoved = value;
	}
	public ims.scheduling.vo.beans.SessionSlotWithStatusOnlyVoBean[] getCalendarSlots()
	{
		return this.calendarslots;
	}
	public void setCalendarSlots(ims.scheduling.vo.beans.SessionSlotWithStatusOnlyVoBean[] value)
	{
		this.calendarslots = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.core.vo.beans.LocShortVoBean schlocation;
	private ims.core.vo.beans.ServiceShortVoBean service;
	private Integer remainingslots;
	private Integer totalslots;
	private ims.vo.LookupInstanceBean theatretype;
	private Boolean isfixed;
	private ims.framework.utils.beans.TimeBean starttm;
	private ims.framework.utils.beans.TimeBean endtm;
	private Integer remainingtime;
	private ims.framework.utils.beans.DateBean sessiondate;
	private ims.scheduling.vo.beans.Session_Exc_TimesVoBean[] exclusiontimes;
	private Integer maxcontinuousavailablemins;
	private ims.vo.LookupInstanceBean consmediatype;
	private ims.vo.LookupInstanceBean sessionstatus;
	private String description;
	private Boolean isactive;
	private ims.vo.LookupInstanceBean pasclinic;
	private Boolean istheatresession;
	private ims.scheduling.vo.beans.Session_ListOwnerVoBean[] listowners;
	private ims.vo.LookupInstanceBean cancellationreason;
	private String comment;
	private Boolean wassessionmoved;
	private ims.scheduling.vo.beans.SessionSlotWithStatusOnlyVoBean[] calendarslots;
}
