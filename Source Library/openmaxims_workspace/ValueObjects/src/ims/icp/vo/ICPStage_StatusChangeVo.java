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

package ims.icp.vo;

/**
 * Linked to ICPs.Configuration.ICPStage business object (ID: 1060100001).
 */
public class ICPStage_StatusChangeVo extends ims.icps.configuration.vo.ICPStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPStage_StatusChangeVo()
	{
	}
	public ICPStage_StatusChangeVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPStage_StatusChangeVo(ims.icp.vo.beans.ICPStage_StatusChangeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phases = ims.icp.vo.ICPPhase_StatusChangeVoCollection.buildFromBeanCollection(bean.getPhases());
		this.hasphase = bean.getHasPhase();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.sequence = bean.getSequence();
		this.name = bean.getName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPStage_StatusChangeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phases = ims.icp.vo.ICPPhase_StatusChangeVoCollection.buildFromBeanCollection(bean.getPhases());
		this.hasphase = bean.getHasPhase();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.sequence = bean.getSequence();
		this.name = bean.getName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPStage_StatusChangeVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPStage_StatusChangeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPStage_StatusChangeVoBean();
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
		if(fieldName.equals("PHASES"))
			return getPhases();
		if(fieldName.equals("HASPHASE"))
			return getHasPhase();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("ISACTIVATEDONINITIATION"))
			return getIsActivatedOnInitiation();
		if(fieldName.equals("SEQUENCE"))
			return getSequence();
		if(fieldName.equals("NAME"))
			return getName();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPhasesIsNotNull()
	{
		return this.phases != null;
	}
	public ims.icp.vo.ICPPhase_StatusChangeVoCollection getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.icp.vo.ICPPhase_StatusChangeVoCollection value)
	{
		this.isValidated = false;
		this.phases = value;
	}
	public boolean getHasPhaseIsNotNull()
	{
		return this.hasphase != null;
	}
	public Boolean getHasPhase()
	{
		return this.hasphase;
	}
	public void setHasPhase(Boolean value)
	{
		this.isValidated = false;
		this.hasphase = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getIsActivatedOnInitiationIsNotNull()
	{
		return this.isactivatedoninitiation != null;
	}
	public Boolean getIsActivatedOnInitiation()
	{
		return this.isactivatedoninitiation;
	}
	public void setIsActivatedOnInitiation(Boolean value)
	{
		this.isValidated = false;
		this.isactivatedoninitiation = value;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 50;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
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
		if(this.phases != null)
		{
			if(!this.phases.isValidated())
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
		if(this.phases != null)
		{
			String[] listOfOtherErrors = this.phases.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 50)
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPStage_StatusChangeVo] is too big. It should be less or equal to 50");
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
	
		ICPStage_StatusChangeVo clone = new ICPStage_StatusChangeVo(this.id, this.version);
		
		if(this.phases == null)
			clone.phases = null;
		else
			clone.phases = (ims.icp.vo.ICPPhase_StatusChangeVoCollection)this.phases.clone();
		clone.hasphase = this.hasphase;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.isactivatedoninitiation = this.isactivatedoninitiation;
		clone.sequence = this.sequence;
		clone.name = this.name;
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
		if (!(ICPStage_StatusChangeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPStage_StatusChangeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ICPStage_StatusChangeVo compareObj = (ICPStage_StatusChangeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSequence() == null && compareObj.getSequence() != null)
				return -1;
			if(this.getSequence() != null && compareObj.getSequence() == null)
				return 1;
			if(this.getSequence() != null && compareObj.getSequence() != null)
				retVal = this.getSequence().compareTo(compareObj.getSequence());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.phases != null)
			count++;
		if(this.hasphase != null)
			count++;
		if(this.status != null)
			count++;
		if(this.isactivatedoninitiation != null)
			count++;
		if(this.sequence != null)
			count++;
		if(this.name != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.icp.vo.ICPPhase_StatusChangeVoCollection phases;
	protected Boolean hasphase;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected Boolean isactivatedoninitiation;
	protected Integer sequence;
	protected String name;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
