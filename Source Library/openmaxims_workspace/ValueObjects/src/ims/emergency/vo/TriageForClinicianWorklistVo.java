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
 * Linked to emergency.Triage business object (ID: 1086100004).
 */
public class TriageForClinicianWorklistVo extends ims.emergency.vo.TriageListForClinicianWorklistVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TriageForClinicianWorklistVo()
	{
	}
	public TriageForClinicianWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public TriageForClinicianWorklistVo(ims.emergency.vo.beans.TriageForClinicianWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo();
		this.triagestartdatetime = bean.getTriageStartDateTime() == null ? null : bean.getTriageStartDateTime().buildDateTime();
		this.medicinterventionstartdatetime = bean.getMedicInterventionStartDateTime() == null ? null : bean.getMedicInterventionStartDateTime().buildDateTime();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.trackingarea = bean.getTrackingArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getTrackingArea().getId()), bean.getTrackingArea().getVersion());
		this.triagecompletiontime = bean.getTriageCompletionTime() == null ? null : bean.getTriageCompletionTime().buildDateTime();
		this.currenttriageassessment = bean.getCurrentTriageAssessment() == null ? null : bean.getCurrentTriageAssessment().buildVo();
		this.currenttriagepathway = bean.getCurrentTriagePathway() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getCurrentTriagePathway().getId()), bean.getCurrentTriagePathway().getVersion());
		this.triageprioritychange = bean.getTriagePriorityChange() == null ? null : ims.emergency.vo.lookups.TriagePriorityChange.buildLookup(bean.getTriagePriorityChange());
		this.obsscore = bean.getOBSScore();
		this.vitalstakendatetime = bean.getVitalsTakenDateTime() == null ? null : bean.getVitalsTakenDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TriageForClinicianWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo(map);
		this.triagestartdatetime = bean.getTriageStartDateTime() == null ? null : bean.getTriageStartDateTime().buildDateTime();
		this.medicinterventionstartdatetime = bean.getMedicInterventionStartDateTime() == null ? null : bean.getMedicInterventionStartDateTime().buildDateTime();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.trackingarea = bean.getTrackingArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getTrackingArea().getId()), bean.getTrackingArea().getVersion());
		this.triagecompletiontime = bean.getTriageCompletionTime() == null ? null : bean.getTriageCompletionTime().buildDateTime();
		this.currenttriageassessment = bean.getCurrentTriageAssessment() == null ? null : bean.getCurrentTriageAssessment().buildVo(map);
		this.currenttriagepathway = bean.getCurrentTriagePathway() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getCurrentTriagePathway().getId()), bean.getCurrentTriagePathway().getVersion());
		this.triageprioritychange = bean.getTriagePriorityChange() == null ? null : ims.emergency.vo.lookups.TriagePriorityChange.buildLookup(bean.getTriagePriorityChange());
		this.obsscore = bean.getOBSScore();
		this.vitalstakendatetime = bean.getVitalsTakenDateTime() == null ? null : bean.getVitalsTakenDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TriageForClinicianWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TriageForClinicianWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TriageForClinicianWorklistVoBean();
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
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("TRACKINGAREA"))
			return getTrackingArea();
		if(fieldName.equals("TRIAGECOMPLETIONTIME"))
			return getTriageCompletionTime();
		if(fieldName.equals("CURRENTTRIAGEASSESSMENT"))
			return getCurrentTriageAssessment();
		if(fieldName.equals("CURRENTTRIAGEPATHWAY"))
			return getCurrentTriagePathway();
		if(fieldName.equals("TRIAGEPRIORITYCHANGE"))
			return getTriagePriorityChange();
		if(fieldName.equals("OBSSCORE"))
			return getOBSScore();
		if(fieldName.equals("VITALSTAKENDATETIME"))
			return getVitalsTakenDateTime();
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
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getTrackingAreaIsNotNull()
	{
		return this.trackingarea != null;
	}
	public ims.emergency.configuration.vo.TrackingAreaRefVo getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.emergency.configuration.vo.TrackingAreaRefVo value)
	{
		this.isValidated = false;
		this.trackingarea = value;
	}
	public boolean getTriageCompletionTimeIsNotNull()
	{
		return this.triagecompletiontime != null;
	}
	public ims.framework.utils.DateTime getTriageCompletionTime()
	{
		return this.triagecompletiontime;
	}
	public void setTriageCompletionTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.triagecompletiontime = value;
	}
	public boolean getCurrentTriageAssessmentIsNotNull()
	{
		return this.currenttriageassessment != null;
	}
	public ims.emergency.vo.TriageProtocolAssessmentForTriageVo getCurrentTriageAssessment()
	{
		return this.currenttriageassessment;
	}
	public void setCurrentTriageAssessment(ims.emergency.vo.TriageProtocolAssessmentForTriageVo value)
	{
		this.isValidated = false;
		this.currenttriageassessment = value;
	}
	public boolean getCurrentTriagePathwayIsNotNull()
	{
		return this.currenttriagepathway != null;
	}
	public ims.icps.instantiation.vo.PatientICPRefVo getCurrentTriagePathway()
	{
		return this.currenttriagepathway;
	}
	public void setCurrentTriagePathway(ims.icps.instantiation.vo.PatientICPRefVo value)
	{
		this.isValidated = false;
		this.currenttriagepathway = value;
	}
	public boolean getTriagePriorityChangeIsNotNull()
	{
		return this.triageprioritychange != null;
	}
	public ims.emergency.vo.lookups.TriagePriorityChange getTriagePriorityChange()
	{
		return this.triageprioritychange;
	}
	public void setTriagePriorityChange(ims.emergency.vo.lookups.TriagePriorityChange value)
	{
		this.isValidated = false;
		this.triageprioritychange = value;
	}
	public boolean getOBSScoreIsNotNull()
	{
		return this.obsscore != null;
	}
	public Integer getOBSScore()
	{
		return this.obsscore;
	}
	public void setOBSScore(Integer value)
	{
		this.isValidated = false;
		this.obsscore = value;
	}
	public boolean getVitalsTakenDateTimeIsNotNull()
	{
		return this.vitalstakendatetime != null;
	}
	public ims.framework.utils.DateTime getVitalsTakenDateTime()
	{
		return this.vitalstakendatetime;
	}
	public void setVitalsTakenDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.vitalstakendatetime = value;
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
		if(this.triagestartdatetime == null)
			listOfErrors.add("TriageStartDateTime is mandatory");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.trackingarea == null)
			listOfErrors.add("TrackingArea is mandatory");
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
	
		TriageForClinicianWorklistVo clone = new TriageForClinicianWorklistVo(this.id, this.version);
		
		if(this.currenttriagepriority == null)
			clone.currenttriagepriority = null;
		else
			clone.currenttriagepriority = (ims.emergency.vo.lookups.TriagePriority)this.currenttriagepriority.clone();
		if(this.mainpresentingproblem == null)
			clone.mainpresentingproblem = null;
		else
			clone.mainpresentingproblem = (ims.emergency.vo.PatientProblemForClinicianWorklistVo)this.mainpresentingproblem.clone();
		if(this.triagestartdatetime == null)
			clone.triagestartdatetime = null;
		else
			clone.triagestartdatetime = (ims.framework.utils.DateTime)this.triagestartdatetime.clone();
		if(this.medicinterventionstartdatetime == null)
			clone.medicinterventionstartdatetime = null;
		else
			clone.medicinterventionstartdatetime = (ims.framework.utils.DateTime)this.medicinterventionstartdatetime.clone();
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
		clone.trackingarea = this.trackingarea;
		if(this.triagecompletiontime == null)
			clone.triagecompletiontime = null;
		else
			clone.triagecompletiontime = (ims.framework.utils.DateTime)this.triagecompletiontime.clone();
		if(this.currenttriageassessment == null)
			clone.currenttriageassessment = null;
		else
			clone.currenttriageassessment = (ims.emergency.vo.TriageProtocolAssessmentForTriageVo)this.currenttriageassessment.clone();
		clone.currenttriagepathway = this.currenttriagepathway;
		if(this.triageprioritychange == null)
			clone.triageprioritychange = null;
		else
			clone.triageprioritychange = (ims.emergency.vo.lookups.TriagePriorityChange)this.triageprioritychange.clone();
		clone.obsscore = this.obsscore;
		if(this.vitalstakendatetime == null)
			clone.vitalstakendatetime = null;
		else
			clone.vitalstakendatetime = (ims.framework.utils.DateTime)this.vitalstakendatetime.clone();
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
		if (!(TriageForClinicianWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TriageForClinicianWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TriageForClinicianWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TriageForClinicianWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.patient != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.trackingarea != null)
			count++;
		if(this.triagecompletiontime != null)
			count++;
		if(this.currenttriageassessment != null)
			count++;
		if(this.currenttriagepathway != null)
			count++;
		if(this.triageprioritychange != null)
			count++;
		if(this.obsscore != null)
			count++;
		if(this.vitalstakendatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 10;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.emergency.configuration.vo.TrackingAreaRefVo trackingarea;
	protected ims.framework.utils.DateTime triagecompletiontime;
	protected ims.emergency.vo.TriageProtocolAssessmentForTriageVo currenttriageassessment;
	protected ims.icps.instantiation.vo.PatientICPRefVo currenttriagepathway;
	protected ims.emergency.vo.lookups.TriagePriorityChange triageprioritychange;
	protected Integer obsscore;
	protected ims.framework.utils.DateTime vitalstakendatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
