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
public class PatientICPShortVo extends ims.icp.vo.PatientICPLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPShortVo()
	{
	}
	public PatientICPShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPShortVo(ims.icp.vo.beans.PatientICPShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hasoutstandingadminactions = bean.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = bean.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = bean.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = bean.getHasOutstandingClinicalActions();
		this.icp = bean.getICP() == null ? null : bean.getICP().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.stages = ims.icp.vo.PatientICPStagesLiteVoCollection.buildFromBeanCollection(bean.getStages());
		this.criticalevents = ims.icp.vo.PatientCriticalEventsVoCollection.buildFromBeanCollection(bean.getCriticalEvents());
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.evaluationnotes = ims.icp.vo.PatientICPEvaluationNoteVoCollection.buildFromBeanCollection(bean.getEvaluationNotes());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hasoutstandingadminactions = bean.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = bean.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = bean.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = bean.getHasOutstandingClinicalActions();
		this.icp = bean.getICP() == null ? null : bean.getICP().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.stages = ims.icp.vo.PatientICPStagesLiteVoCollection.buildFromBeanCollection(bean.getStages());
		this.criticalevents = ims.icp.vo.PatientCriticalEventsVoCollection.buildFromBeanCollection(bean.getCriticalEvents());
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.evaluationnotes = ims.icp.vo.PatientICPEvaluationNoteVoCollection.buildFromBeanCollection(bean.getEvaluationNotes());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPShortVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPShortVoBean();
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
		if(fieldName.equals("STAGES"))
			return getStages();
		if(fieldName.equals("CRITICALEVENTS"))
			return getCriticalEvents();
		if(fieldName.equals("COMPLETEDDATETIME"))
			return getCompletedDateTime();
		if(fieldName.equals("EVALUATIONNOTES"))
			return getEvaluationNotes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStagesIsNotNull()
	{
		return this.stages != null;
	}
	public ims.icp.vo.PatientICPStagesLiteVoCollection getStages()
	{
		return this.stages;
	}
	public void setStages(ims.icp.vo.PatientICPStagesLiteVoCollection value)
	{
		this.isValidated = false;
		this.stages = value;
	}
	public boolean getCriticalEventsIsNotNull()
	{
		return this.criticalevents != null;
	}
	public ims.icp.vo.PatientCriticalEventsVoCollection getCriticalEvents()
	{
		return this.criticalevents;
	}
	public void setCriticalEvents(ims.icp.vo.PatientCriticalEventsVoCollection value)
	{
		this.isValidated = false;
		this.criticalevents = value;
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
	public ims.icp.vo.PatientICPEvaluationNoteVoCollection getEvaluationNotes()
	{
		return this.evaluationnotes;
	}
	public void setEvaluationNotes(ims.icp.vo.PatientICPEvaluationNoteVoCollection value)
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
		if(this.hasoutstandingadminactions == null)
			listOfErrors.add("hasOutstandingAdminActions is mandatory");
		if(this.hasoutstandingnursingactions == null)
			listOfErrors.add("hasOutstandingNursingActions is mandatory");
		if(this.hasoutstandingphysioactions == null)
			listOfErrors.add("hasOutstandingPhysioActions is mandatory");
		if(this.hasoutstandingclinicalactions == null)
			listOfErrors.add("hasOutstandingClinicalActions is mandatory");
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.stages == null || this.stages.size() == 0)
			listOfErrors.add("Stages are mandatory");
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
	
		PatientICPShortVo clone = new PatientICPShortVo(this.id, this.version);
		
		clone.hasoutstandingadminactions = this.hasoutstandingadminactions;
		clone.hasoutstandingnursingactions = this.hasoutstandingnursingactions;
		clone.hasoutstandingphysioactions = this.hasoutstandingphysioactions;
		clone.hasoutstandingclinicalactions = this.hasoutstandingclinicalactions;
		if(this.icp == null)
			clone.icp = null;
		else
			clone.icp = (ims.icp.vo.ICPLiteVo)this.icp.clone();
		clone.carecontext = this.carecontext;
		if(this.stages == null)
			clone.stages = null;
		else
			clone.stages = (ims.icp.vo.PatientICPStagesLiteVoCollection)this.stages.clone();
		if(this.criticalevents == null)
			clone.criticalevents = null;
		else
			clone.criticalevents = (ims.icp.vo.PatientCriticalEventsVoCollection)this.criticalevents.clone();
		if(this.completeddatetime == null)
			clone.completeddatetime = null;
		else
			clone.completeddatetime = (ims.framework.utils.DateTime)this.completeddatetime.clone();
		if(this.evaluationnotes == null)
			clone.evaluationnotes = null;
		else
			clone.evaluationnotes = (ims.icp.vo.PatientICPEvaluationNoteVoCollection)this.evaluationnotes.clone();
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
		if (!(PatientICPShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.stages != null)
			count++;
		if(this.criticalevents != null)
			count++;
		if(this.completeddatetime != null)
			count++;
		if(this.evaluationnotes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.icp.vo.PatientICPStagesLiteVoCollection stages;
	protected ims.icp.vo.PatientCriticalEventsVoCollection criticalevents;
	protected ims.framework.utils.DateTime completeddatetime;
	protected ims.icp.vo.PatientICPEvaluationNoteVoCollection evaluationnotes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
