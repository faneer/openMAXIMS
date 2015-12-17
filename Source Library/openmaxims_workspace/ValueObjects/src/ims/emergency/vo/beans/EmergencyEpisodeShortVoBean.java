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

package ims.emergency.vo.beans;

public class EmergencyEpisodeShortVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyEpisodeShortVoBean()
	{
	}
	public EmergencyEpisodeShortVoBean(ims.emergency.vo.EmergencyEpisodeShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.injurydatetime = vo.getInjuryDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInjuryDateTime().getBean();
		this.incidentlocation = vo.getIncidentLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getIncidentLocation().getBean();
		this.locationdetails = vo.getLocationDetails();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.presentingcomplaint = vo.getPresentingComplaint() == null ? null : (ims.vo.LookupInstanceBean)vo.getPresentingComplaint().getBean();
		this.elapsedtime = vo.getElapsedTime();
		this.elapsedperiod = vo.getElapsedPeriod() == null ? null : (ims.vo.LookupInstanceBean)vo.getElapsedPeriod().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.emergency.vo.beans.EpisodeOfcareLiteVoBean)vo.getEpisodeOfCare().getBean();
		this.emergencyattendances = vo.getEmergencyAttendances() == null ? null : vo.getEmergencyAttendances().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyEpisodeShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.injurydatetime = vo.getInjuryDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInjuryDateTime().getBean();
		this.incidentlocation = vo.getIncidentLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getIncidentLocation().getBean();
		this.locationdetails = vo.getLocationDetails();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.presentingcomplaint = vo.getPresentingComplaint() == null ? null : (ims.vo.LookupInstanceBean)vo.getPresentingComplaint().getBean();
		this.elapsedtime = vo.getElapsedTime();
		this.elapsedperiod = vo.getElapsedPeriod() == null ? null : (ims.vo.LookupInstanceBean)vo.getElapsedPeriod().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.emergency.vo.beans.EpisodeOfcareLiteVoBean)vo.getEpisodeOfCare().getBean(map);
		this.emergencyattendances = vo.getEmergencyAttendances() == null ? null : vo.getEmergencyAttendances().getBeanCollection();
	}

	public ims.emergency.vo.EmergencyEpisodeShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyEpisodeShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyEpisodeShortVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyEpisodeShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyEpisodeShortVo();
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
	public ims.framework.utils.beans.DateTimeBean getInjuryDateTime()
	{
		return this.injurydatetime;
	}
	public void setInjuryDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.injurydatetime = value;
	}
	public ims.vo.LookupInstanceBean getIncidentLocation()
	{
		return this.incidentlocation;
	}
	public void setIncidentLocation(ims.vo.LookupInstanceBean value)
	{
		this.incidentlocation = value;
	}
	public String getLocationDetails()
	{
		return this.locationdetails;
	}
	public void setLocationDetails(String value)
	{
		this.locationdetails = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getPresentingComplaint()
	{
		return this.presentingcomplaint;
	}
	public void setPresentingComplaint(ims.vo.LookupInstanceBean value)
	{
		this.presentingcomplaint = value;
	}
	public Integer getElapsedTime()
	{
		return this.elapsedtime;
	}
	public void setElapsedTime(Integer value)
	{
		this.elapsedtime = value;
	}
	public ims.vo.LookupInstanceBean getElapsedPeriod()
	{
		return this.elapsedperiod;
	}
	public void setElapsedPeriod(ims.vo.LookupInstanceBean value)
	{
		this.elapsedperiod = value;
	}
	public ims.emergency.vo.beans.EpisodeOfcareLiteVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.emergency.vo.beans.EpisodeOfcareLiteVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.emergency.vo.beans.EmergencyAttendanceShortVoBean[] getEmergencyAttendances()
	{
		return this.emergencyattendances;
	}
	public void setEmergencyAttendances(ims.emergency.vo.beans.EmergencyAttendanceShortVoBean[] value)
	{
		this.emergencyattendances = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean injurydatetime;
	private ims.vo.LookupInstanceBean incidentlocation;
	private String locationdetails;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean presentingcomplaint;
	private Integer elapsedtime;
	private ims.vo.LookupInstanceBean elapsedperiod;
	private ims.emergency.vo.beans.EpisodeOfcareLiteVoBean episodeofcare;
	private ims.emergency.vo.beans.EmergencyAttendanceShortVoBean[] emergencyattendances;
}
