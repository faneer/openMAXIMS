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

package ims.emergency.vo.beans;

public class TriageForTriageVoBean extends ims.vo.ValueObjectBean
{
	public TriageForTriageVoBean()
	{
	}
	public TriageForTriageVoBean(ims.emergency.vo.TriageForTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.triagestartdatetime = vo.getTriageStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageStartDateTime().getBean();
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.triagecompletiontime = vo.getTriageCompletionTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageCompletionTime().getBean();
		this.currenttriagepriority = vo.getCurrentTriagePriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentTriagePriority().getBean();
		this.mainpresentingproblem = vo.getMainPresentingProblem() == null ? null : (ims.emergency.vo.beans.PatientProblemForTriageVoBean)vo.getMainPresentingProblem().getBean();
		this.currenttriagepathway = vo.getCurrentTriagePathway() == null ? null : new ims.vo.RefVoBean(vo.getCurrentTriagePathway().getBoId(), vo.getCurrentTriagePathway().getBoVersion());
		this.currenttriageassessment = vo.getCurrentTriageAssessment() == null ? null : (ims.emergency.vo.beans.TriageProtocolAssessmentForTriageVoBean)vo.getCurrentTriageAssessment().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TriageForTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.triagestartdatetime = vo.getTriageStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageStartDateTime().getBean();
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.triagecompletiontime = vo.getTriageCompletionTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageCompletionTime().getBean();
		this.currenttriagepriority = vo.getCurrentTriagePriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentTriagePriority().getBean();
		this.mainpresentingproblem = vo.getMainPresentingProblem() == null ? null : (ims.emergency.vo.beans.PatientProblemForTriageVoBean)vo.getMainPresentingProblem().getBean(map);
		this.currenttriagepathway = vo.getCurrentTriagePathway() == null ? null : new ims.vo.RefVoBean(vo.getCurrentTriagePathway().getBoId(), vo.getCurrentTriagePathway().getBoVersion());
		this.currenttriageassessment = vo.getCurrentTriageAssessment() == null ? null : (ims.emergency.vo.beans.TriageProtocolAssessmentForTriageVoBean)vo.getCurrentTriageAssessment().getBean(map);
	}

	public ims.emergency.vo.TriageForTriageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TriageForTriageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TriageForTriageVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TriageForTriageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TriageForTriageVo();
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
	public ims.framework.utils.beans.DateTimeBean getTriageStartDateTime()
	{
		return this.triagestartdatetime;
	}
	public void setTriageStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.triagestartdatetime = value;
	}
	public ims.vo.RefVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.vo.RefVoBean value)
	{
		this.attendance = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.vo.RefVoBean value)
	{
		this.episode = value;
	}
	public ims.vo.RefVoBean getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.vo.RefVoBean value)
	{
		this.trackingarea = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTriageCompletionTime()
	{
		return this.triagecompletiontime;
	}
	public void setTriageCompletionTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.triagecompletiontime = value;
	}
	public ims.vo.LookupInstanceBean getCurrentTriagePriority()
	{
		return this.currenttriagepriority;
	}
	public void setCurrentTriagePriority(ims.vo.LookupInstanceBean value)
	{
		this.currenttriagepriority = value;
	}
	public ims.emergency.vo.beans.PatientProblemForTriageVoBean getMainPresentingProblem()
	{
		return this.mainpresentingproblem;
	}
	public void setMainPresentingProblem(ims.emergency.vo.beans.PatientProblemForTriageVoBean value)
	{
		this.mainpresentingproblem = value;
	}
	public ims.vo.RefVoBean getCurrentTriagePathway()
	{
		return this.currenttriagepathway;
	}
	public void setCurrentTriagePathway(ims.vo.RefVoBean value)
	{
		this.currenttriagepathway = value;
	}
	public ims.emergency.vo.beans.TriageProtocolAssessmentForTriageVoBean getCurrentTriageAssessment()
	{
		return this.currenttriageassessment;
	}
	public void setCurrentTriageAssessment(ims.emergency.vo.beans.TriageProtocolAssessmentForTriageVoBean value)
	{
		this.currenttriageassessment = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean triagestartdatetime;
	private ims.vo.RefVoBean attendance;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episode;
	private ims.vo.RefVoBean trackingarea;
	private ims.framework.utils.beans.DateTimeBean triagecompletiontime;
	private ims.vo.LookupInstanceBean currenttriagepriority;
	private ims.emergency.vo.beans.PatientProblemForTriageVoBean mainpresentingproblem;
	private ims.vo.RefVoBean currenttriagepathway;
	private ims.emergency.vo.beans.TriageProtocolAssessmentForTriageVoBean currenttriageassessment;
}
