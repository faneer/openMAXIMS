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
 * Linked to ICPs.Instantiation.PatientICP business object (ID: 1100100000).
 */
public class PatientICPVo extends ims.icps.instantiation.vo.PatientICPRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPVo()
	{
	}
	public PatientICPVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPVo(ims.icp.vo.beans.PatientICPVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.icp = bean.getICP() == null ? null : bean.getICP().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.stages = ims.icp.vo.PatientICPStageVoCollection.buildFromBeanCollection(bean.getStages());
		this.hasoutstandingadminactions = bean.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = bean.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = bean.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = bean.getHasOutstandingClinicalActions();
		if(bean.getAppointments() != null)
		{
			this.appointments = new ims.scheduling.vo.Booking_AppointmentRefVoCollection();
			for(int appointments_i = 0; appointments_i < bean.getAppointments().length; appointments_i++)
			{
				this.appointments.add(new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointments()[appointments_i].getId()), bean.getAppointments()[appointments_i].getVersion()));
			}
		}
		if(bean.getCriticalEvents() != null)
		{
			this.criticalevents = new ims.icps.instantiation.vo.PatientCriticalEventsRefVoCollection();
			for(int criticalevents_i = 0; criticalevents_i < bean.getCriticalEvents().length; criticalevents_i++)
			{
				this.criticalevents.add(new ims.icps.instantiation.vo.PatientCriticalEventsRefVo(new Integer(bean.getCriticalEvents()[criticalevents_i].getId()), bean.getCriticalEvents()[criticalevents_i].getVersion()));
			}
		}
		this.starteddatetime = bean.getStartedDateTime() == null ? null : bean.getStartedDateTime().buildDateTime();
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		if(bean.getEvaluationNotes() != null)
		{
			this.evaluationnotes = new ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVoCollection();
			for(int evaluationnotes_i = 0; evaluationnotes_i < bean.getEvaluationNotes().length; evaluationnotes_i++)
			{
				this.evaluationnotes.add(new ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVo(new Integer(bean.getEvaluationNotes()[evaluationnotes_i].getId()), bean.getEvaluationNotes()[evaluationnotes_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.pasevent = bean.getPasEvent() == null ? null : new ims.core.admin.pas.vo.PASEventRefVo(new Integer(bean.getPasEvent().getId()), bean.getPasEvent().getVersion());
		this.icp = bean.getICP() == null ? null : bean.getICP().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.stages = ims.icp.vo.PatientICPStageVoCollection.buildFromBeanCollection(bean.getStages());
		this.hasoutstandingadminactions = bean.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = bean.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = bean.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = bean.getHasOutstandingClinicalActions();
		if(bean.getAppointments() != null)
		{
			this.appointments = new ims.scheduling.vo.Booking_AppointmentRefVoCollection();
			for(int appointments_i = 0; appointments_i < bean.getAppointments().length; appointments_i++)
			{
				this.appointments.add(new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointments()[appointments_i].getId()), bean.getAppointments()[appointments_i].getVersion()));
			}
		}
		if(bean.getCriticalEvents() != null)
		{
			this.criticalevents = new ims.icps.instantiation.vo.PatientCriticalEventsRefVoCollection();
			for(int criticalevents_i = 0; criticalevents_i < bean.getCriticalEvents().length; criticalevents_i++)
			{
				this.criticalevents.add(new ims.icps.instantiation.vo.PatientCriticalEventsRefVo(new Integer(bean.getCriticalEvents()[criticalevents_i].getId()), bean.getCriticalEvents()[criticalevents_i].getVersion()));
			}
		}
		this.starteddatetime = bean.getStartedDateTime() == null ? null : bean.getStartedDateTime().buildDateTime();
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		if(bean.getEvaluationNotes() != null)
		{
			this.evaluationnotes = new ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVoCollection();
			for(int evaluationnotes_i = 0; evaluationnotes_i < bean.getEvaluationNotes().length; evaluationnotes_i++)
			{
				this.evaluationnotes.add(new ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVo(new Integer(bean.getEvaluationNotes()[evaluationnotes_i].getId()), bean.getEvaluationNotes()[evaluationnotes_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("ICP"))
			return getICP();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("STAGES"))
			return getStages();
		if(fieldName.equals("HASOUTSTANDINGADMINACTIONS"))
			return getHasOutstandingAdminActions();
		if(fieldName.equals("HASOUTSTANDINGNURSINGACTIONS"))
			return getHasOutstandingNursingActions();
		if(fieldName.equals("HASOUTSTANDINGPHYSIOACTIONS"))
			return getHasOutstandingPhysioActions();
		if(fieldName.equals("HASOUTSTANDINGCLINICALACTIONS"))
			return getHasOutstandingClinicalActions();
		if(fieldName.equals("APPOINTMENTS"))
			return getAppointments();
		if(fieldName.equals("CRITICALEVENTS"))
			return getCriticalEvents();
		if(fieldName.equals("STARTEDDATETIME"))
			return getStartedDateTime();
		if(fieldName.equals("COMPLETEDDATETIME"))
			return getCompletedDateTime();
		if(fieldName.equals("EVALUATIONNOTES"))
			return getEvaluationNotes();
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
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.admin.pas.vo.PASEventRefVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.admin.pas.vo.PASEventRefVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getICPIsNotNull()
	{
		return this.icp != null;
	}
	public ims.icp.vo.ICPLiteVo getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icp.vo.ICPLiteVo value)
	{
		this.isValidated = false;
		this.icp = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getStagesIsNotNull()
	{
		return this.stages != null;
	}
	public ims.icp.vo.PatientICPStageVoCollection getStages()
	{
		return this.stages;
	}
	public void setStages(ims.icp.vo.PatientICPStageVoCollection value)
	{
		this.isValidated = false;
		this.stages = value;
	}
	public boolean getHasOutstandingAdminActionsIsNotNull()
	{
		return this.hasoutstandingadminactions != null;
	}
	public Boolean getHasOutstandingAdminActions()
	{
		return this.hasoutstandingadminactions;
	}
	public void setHasOutstandingAdminActions(Boolean value)
	{
		this.isValidated = false;
		this.hasoutstandingadminactions = value;
	}
	public boolean getHasOutstandingNursingActionsIsNotNull()
	{
		return this.hasoutstandingnursingactions != null;
	}
	public Boolean getHasOutstandingNursingActions()
	{
		return this.hasoutstandingnursingactions;
	}
	public void setHasOutstandingNursingActions(Boolean value)
	{
		this.isValidated = false;
		this.hasoutstandingnursingactions = value;
	}
	public boolean getHasOutstandingPhysioActionsIsNotNull()
	{
		return this.hasoutstandingphysioactions != null;
	}
	public Boolean getHasOutstandingPhysioActions()
	{
		return this.hasoutstandingphysioactions;
	}
	public void setHasOutstandingPhysioActions(Boolean value)
	{
		this.isValidated = false;
		this.hasoutstandingphysioactions = value;
	}
	public boolean getHasOutstandingClinicalActionsIsNotNull()
	{
		return this.hasoutstandingclinicalactions != null;
	}
	public Boolean getHasOutstandingClinicalActions()
	{
		return this.hasoutstandingclinicalactions;
	}
	public void setHasOutstandingClinicalActions(Boolean value)
	{
		this.isValidated = false;
		this.hasoutstandingclinicalactions = value;
	}
	public boolean getAppointmentsIsNotNull()
	{
		return this.appointments != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVoCollection getAppointments()
	{
		return this.appointments;
	}
	public void setAppointments(ims.scheduling.vo.Booking_AppointmentRefVoCollection value)
	{
		this.isValidated = false;
		this.appointments = value;
	}
	public boolean getCriticalEventsIsNotNull()
	{
		return this.criticalevents != null;
	}
	public ims.icps.instantiation.vo.PatientCriticalEventsRefVoCollection getCriticalEvents()
	{
		return this.criticalevents;
	}
	public void setCriticalEvents(ims.icps.instantiation.vo.PatientCriticalEventsRefVoCollection value)
	{
		this.isValidated = false;
		this.criticalevents = value;
	}
	public boolean getStartedDateTimeIsNotNull()
	{
		return this.starteddatetime != null;
	}
	public ims.framework.utils.DateTime getStartedDateTime()
	{
		return this.starteddatetime;
	}
	public void setStartedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.starteddatetime = value;
	}
	public boolean getCompletedDateTimeIsNotNull()
	{
		return this.completeddatetime != null;
	}
	public ims.framework.utils.DateTime getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.completeddatetime = value;
	}
	public boolean getEvaluationNotesIsNotNull()
	{
		return this.evaluationnotes != null;
	}
	public ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVoCollection getEvaluationNotes()
	{
		return this.evaluationnotes;
	}
	public void setEvaluationNotes(ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVoCollection value)
	{
		this.isValidated = false;
		this.evaluationnotes = value;
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
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.stages == null || this.stages.size() == 0)
			listOfErrors.add("Stages are mandatory");
		if(this.hasoutstandingadminactions == null)
			listOfErrors.add("hasOutstandingAdminActions is mandatory");
		if(this.hasoutstandingnursingactions == null)
			listOfErrors.add("hasOutstandingNursingActions is mandatory");
		if(this.hasoutstandingphysioactions == null)
			listOfErrors.add("hasOutstandingPhysioActions is mandatory");
		if(this.hasoutstandingclinicalactions == null)
			listOfErrors.add("hasOutstandingClinicalActions is mandatory");
		if(this.starteddatetime == null)
			listOfErrors.add("StartedDateTime is mandatory");
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
	
		PatientICPVo clone = new PatientICPVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.carecontext = this.carecontext;
		clone.clinicalcontact = this.clinicalcontact;
		clone.pasevent = this.pasevent;
		if(this.icp == null)
			clone.icp = null;
		else
			clone.icp = (ims.icp.vo.ICPLiteVo)this.icp.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.stages == null)
			clone.stages = null;
		else
			clone.stages = (ims.icp.vo.PatientICPStageVoCollection)this.stages.clone();
		clone.hasoutstandingadminactions = this.hasoutstandingadminactions;
		clone.hasoutstandingnursingactions = this.hasoutstandingnursingactions;
		clone.hasoutstandingphysioactions = this.hasoutstandingphysioactions;
		clone.hasoutstandingclinicalactions = this.hasoutstandingclinicalactions;
		clone.appointments = this.appointments;
		clone.criticalevents = this.criticalevents;
		if(this.starteddatetime == null)
			clone.starteddatetime = null;
		else
			clone.starteddatetime = (ims.framework.utils.DateTime)this.starteddatetime.clone();
		if(this.completeddatetime == null)
			clone.completeddatetime = null;
		else
			clone.completeddatetime = (ims.framework.utils.DateTime)this.completeddatetime.clone();
		clone.evaluationnotes = this.evaluationnotes;
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
		if (!(PatientICPVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPVo)obj).getBoId());
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
		if(this.clinicalcontact != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.icp != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.stages != null)
			count++;
		if(this.hasoutstandingadminactions != null)
			count++;
		if(this.hasoutstandingnursingactions != null)
			count++;
		if(this.hasoutstandingphysioactions != null)
			count++;
		if(this.hasoutstandingclinicalactions != null)
			count++;
		if(this.appointments != null)
			count++;
		if(this.criticalevents != null)
			count++;
		if(this.starteddatetime != null)
			count++;
		if(this.completeddatetime != null)
			count++;
		if(this.evaluationnotes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 16;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.pas.vo.PASEventRefVo pasevent;
	protected ims.icp.vo.ICPLiteVo icp;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.icp.vo.PatientICPStageVoCollection stages;
	protected Boolean hasoutstandingadminactions;
	protected Boolean hasoutstandingnursingactions;
	protected Boolean hasoutstandingphysioactions;
	protected Boolean hasoutstandingclinicalactions;
	protected ims.scheduling.vo.Booking_AppointmentRefVoCollection appointments;
	protected ims.icps.instantiation.vo.PatientCriticalEventsRefVoCollection criticalevents;
	protected ims.framework.utils.DateTime starteddatetime;
	protected ims.framework.utils.DateTime completeddatetime;
	protected ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVoCollection evaluationnotes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
