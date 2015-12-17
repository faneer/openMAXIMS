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
 * Linked to ICPs.Instantiation.PatientICPStage business object (ID: 1100100001).
 */
public class PatientICPStage_DisplayVo extends ims.icps.instantiation.vo.PatientICPStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPStage_DisplayVo()
	{
	}
	public PatientICPStage_DisplayVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPStage_DisplayVo(ims.icp.vo.beans.PatientICPStage_DisplayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo();
		this.phases = ims.icp.vo.PatientICPPhase_DisplayVoCollection.buildFromBeanCollection(bean.getPhases());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		if(bean.getStatusHistory() != null)
		{
			this.statushistory = new ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection();
			for(int statushistory_i = 0; statushistory_i < bean.getStatusHistory().length; statushistory_i++)
			{
				this.statushistory.add(new ims.icps.instantiation.vo.PatientICPStageStatusRefVo(new Integer(bean.getStatusHistory()[statushistory_i].getId()), bean.getStatusHistory()[statushistory_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPStage_DisplayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo(map);
		this.phases = ims.icp.vo.PatientICPPhase_DisplayVoCollection.buildFromBeanCollection(bean.getPhases());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		if(bean.getStatusHistory() != null)
		{
			this.statushistory = new ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection();
			for(int statushistory_i = 0; statushistory_i < bean.getStatusHistory().length; statushistory_i++)
			{
				this.statushistory.add(new ims.icps.instantiation.vo.PatientICPStageStatusRefVo(new Integer(bean.getStatusHistory()[statushistory_i].getId()), bean.getStatusHistory()[statushistory_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPStage_DisplayVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPStage_DisplayVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPStage_DisplayVoBean();
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
		if(fieldName.equals("ICP"))
			return getICP();
		if(fieldName.equals("STAGE"))
			return getStage();
		if(fieldName.equals("PHASES"))
			return getPhases();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.icp.vo.ICPStageLiteVo getStage()
	{
		return this.stage;
	}
	public void setStage(ims.icp.vo.ICPStageLiteVo value)
	{
		this.isValidated = false;
		this.stage = value;
	}
	public boolean getPhasesIsNotNull()
	{
		return this.phases != null;
	}
	public ims.icp.vo.PatientICPPhase_DisplayVoCollection getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.icp.vo.PatientICPPhase_DisplayVoCollection value)
	{
		this.isValidated = false;
		this.phases = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.icp.vo.PatientICPStageStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.PatientICPStageStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
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
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.stage == null)
			listOfErrors.add("Stage is mandatory");
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.statushistory == null || this.statushistory.size() == 0)
			listOfErrors.add("StatusHistory are mandatory");
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
	
		PatientICPStage_DisplayVo clone = new PatientICPStage_DisplayVo(this.id, this.version);
		
		clone.icp = this.icp;
		if(this.stage == null)
			clone.stage = null;
		else
			clone.stage = (ims.icp.vo.ICPStageLiteVo)this.stage.clone();
		if(this.phases == null)
			clone.phases = null;
		else
			clone.phases = (ims.icp.vo.PatientICPPhase_DisplayVoCollection)this.phases.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPStageStatusVo)this.currentstatus.clone();
		clone.statushistory = this.statushistory;
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
		if (!(PatientICPStage_DisplayVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPStage_DisplayVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPStage_DisplayVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPStage_DisplayVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.icp != null)
			count++;
		if(this.stage != null)
			count++;
		if(this.phases != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.icps.instantiation.vo.PatientICPRefVo icp;
	protected ims.icp.vo.ICPStageLiteVo stage;
	protected ims.icp.vo.PatientICPPhase_DisplayVoCollection phases;
	protected ims.icp.vo.PatientICPStageStatusVo currentstatus;
	protected ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection statushistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
