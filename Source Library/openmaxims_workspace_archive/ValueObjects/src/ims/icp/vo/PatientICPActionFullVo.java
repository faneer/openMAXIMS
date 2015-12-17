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
 * Linked to ICPs.Instantiation.PatientICPAction business object (ID: 1100100004).
 */
public class PatientICPActionFullVo extends ims.icps.instantiation.vo.PatientICPActionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPActionFullVo()
	{
	}
	public PatientICPActionFullVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPActionFullVo(ims.icp.vo.beans.PatientICPActionFullVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.action = bean.getAction() == null ? null : bean.getAction().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.statushistory = ims.icp.vo.PatientICPActionStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.completedondate = bean.getCompletedOnDate() == null ? null : bean.getCompletedOnDate().buildDateTime();
		this.parentphase = bean.getParentPhase() == null ? null : new ims.icps.instantiation.vo.PatientICPPhaseRefVo(new Integer(bean.getParentPhase().getId()), bean.getParentPhase().getVersion());
		this.requirescountersigning = bean.getRequiresCounterSigning();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPActionFullVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.action = bean.getAction() == null ? null : bean.getAction().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.statushistory = ims.icp.vo.PatientICPActionStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.completedondate = bean.getCompletedOnDate() == null ? null : bean.getCompletedOnDate().buildDateTime();
		this.parentphase = bean.getParentPhase() == null ? null : new ims.icps.instantiation.vo.PatientICPPhaseRefVo(new Integer(bean.getParentPhase().getId()), bean.getParentPhase().getVersion());
		this.requirescountersigning = bean.getRequiresCounterSigning();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPActionFullVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPActionFullVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPActionFullVoBean();
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
		if(fieldName.equals("ICP"))
			return getICP();
		if(fieldName.equals("ACTION"))
			return getAction();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("COMPLETEDONDATE"))
			return getCompletedOnDate();
		if(fieldName.equals("PARENTPHASE"))
			return getParentPhase();
		if(fieldName.equals("REQUIRESCOUNTERSIGNING"))
			return getRequiresCounterSigning();
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
	public boolean getICPIsNotNull()
	{
		return this.icp != null;
	}
	public ims.icps.instantiation.vo.PatientICPRefVo getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icps.instantiation.vo.PatientICPRefVo value)
	{
		this.isValidated = false;
		this.icp = value;
	}
	public boolean getActionIsNotNull()
	{
		return this.action != null;
	}
	public ims.icp.vo.ICPActionShortVo getAction()
	{
		return this.action;
	}
	public void setAction(ims.icp.vo.ICPActionShortVo value)
	{
		this.isValidated = false;
		this.action = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.icp.vo.PatientICPActionStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.PatientICPActionStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.icp.vo.PatientICPActionStatusVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.icp.vo.PatientICPActionStatusVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getCompletedOnDateIsNotNull()
	{
		return this.completedondate != null;
	}
	public ims.framework.utils.DateTime getCompletedOnDate()
	{
		return this.completedondate;
	}
	public void setCompletedOnDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.completedondate = value;
	}
	public boolean getParentPhaseIsNotNull()
	{
		return this.parentphase != null;
	}
	public ims.icps.instantiation.vo.PatientICPPhaseRefVo getParentPhase()
	{
		return this.parentphase;
	}
	public void setParentPhase(ims.icps.instantiation.vo.PatientICPPhaseRefVo value)
	{
		this.isValidated = false;
		this.parentphase = value;
	}
	public boolean getRequiresCounterSigningIsNotNull()
	{
		return this.requirescountersigning != null;
	}
	public Boolean getRequiresCounterSigning()
	{
		return this.requirescountersigning;
	}
	public void setRequiresCounterSigning(Boolean value)
	{
		this.isValidated = false;
		this.requirescountersigning = value;
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
		if(this.action != null)
		{
			if(!this.action.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.statushistory != null)
		{
			if(!this.statushistory.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.action == null)
			listOfErrors.add("Action is mandatory");
		if(this.action != null)
		{
			String[] listOfOtherErrors = this.action.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.statushistory == null || this.statushistory.size() == 0)
			listOfErrors.add("StatusHistory are mandatory");
		if(this.statushistory != null)
		{
			String[] listOfOtherErrors = this.statushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.parentphase == null)
			listOfErrors.add("ParentPhase is mandatory");
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
	
		PatientICPActionFullVo clone = new PatientICPActionFullVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.carecontext = this.carecontext;
		clone.icp = this.icp;
		if(this.action == null)
			clone.action = null;
		else
			clone.action = (ims.icp.vo.ICPActionShortVo)this.action.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPActionStatusVo)this.currentstatus.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.icp.vo.PatientICPActionStatusVoCollection)this.statushistory.clone();
		if(this.completedondate == null)
			clone.completedondate = null;
		else
			clone.completedondate = (ims.framework.utils.DateTime)this.completedondate.clone();
		clone.parentphase = this.parentphase;
		clone.requirescountersigning = this.requirescountersigning;
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
		if (!(PatientICPActionFullVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPActionFullVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPActionFullVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPActionFullVo)obj).getBoId());
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
		if(this.icp != null)
			count++;
		if(this.action != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.completedondate != null)
			count++;
		if(this.parentphase != null)
			count++;
		if(this.requirescountersigning != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.icps.instantiation.vo.PatientICPRefVo icp;
	protected ims.icp.vo.ICPActionShortVo action;
	protected ims.icp.vo.PatientICPActionStatusVo currentstatus;
	protected ims.icp.vo.PatientICPActionStatusVoCollection statushistory;
	protected ims.framework.utils.DateTime completedondate;
	protected ims.icps.instantiation.vo.PatientICPPhaseRefVo parentphase;
	protected Boolean requirescountersigning;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
