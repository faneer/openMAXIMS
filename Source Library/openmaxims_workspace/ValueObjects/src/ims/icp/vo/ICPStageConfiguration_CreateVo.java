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
public class ICPStageConfiguration_CreateVo extends ims.icps.configuration.vo.ICPStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPStageConfiguration_CreateVo()
	{
	}
	public ICPStageConfiguration_CreateVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPStageConfiguration_CreateVo(ims.icp.vo.beans.ICPStageConfiguration_CreateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.phases = ims.icp.vo.ICPPhaseConfiguration_CreateVoCollection.buildFromBeanCollection(bean.getPhases());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPStageConfiguration_CreateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.phases = ims.icp.vo.ICPPhaseConfiguration_CreateVoCollection.buildFromBeanCollection(bean.getPhases());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPStageConfiguration_CreateVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPStageConfiguration_CreateVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPStageConfiguration_CreateVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("PHASES"))
			return getPhases();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("ISACTIVATEDONINITIATION"))
			return getIsActivatedOnInitiation();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getPhasesIsNotNull()
	{
		return this.phases != null;
	}
	public ims.icp.vo.ICPPhaseConfiguration_CreateVoCollection getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.icp.vo.ICPPhaseConfiguration_CreateVoCollection value)
	{
		this.isValidated = false;
		this.phases = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 50)
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPStageConfiguration_CreateVo] is too big. It should be less or equal to 50");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		ICPStageConfiguration_CreateVo clone = new ICPStageConfiguration_CreateVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.phases == null)
			clone.phases = null;
		else
			clone.phases = (ims.icp.vo.ICPPhaseConfiguration_CreateVoCollection)this.phases.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.isactivatedoninitiation = this.isactivatedoninitiation;
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
		if (!(ICPStageConfiguration_CreateVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPStageConfiguration_CreateVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ICPStageConfiguration_CreateVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ICPStageConfiguration_CreateVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.phases != null)
			count++;
		if(this.status != null)
			count++;
		if(this.isactivatedoninitiation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected ims.icp.vo.ICPPhaseConfiguration_CreateVoCollection phases;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected Boolean isactivatedoninitiation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
