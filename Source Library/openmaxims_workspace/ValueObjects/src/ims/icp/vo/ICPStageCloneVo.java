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
public class ICPStageCloneVo extends ims.icp.vo.ICPStageLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPStageCloneVo()
	{
	}
	public ICPStageCloneVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPStageCloneVo(ims.icp.vo.beans.ICPStageCloneVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.helpurl = bean.getHelpURL();
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.hasphase = bean.getHasPhase();
		this.phases = ims.icp.vo.ICPPhaseCloneVoCollection.buildFromBeanCollection(bean.getPhases());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPStageCloneVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.helpurl = bean.getHelpURL();
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.hasphase = bean.getHasPhase();
		this.phases = ims.icp.vo.ICPPhaseCloneVoCollection.buildFromBeanCollection(bean.getPhases());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPStageCloneVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPStageCloneVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPStageCloneVoBean();
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
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPhasesIsNotNull()
	{
		return this.phases != null;
	}
	public ims.icp.vo.ICPPhaseCloneVoCollection getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.icp.vo.ICPPhaseCloneVoCollection value)
	{
		this.isValidated = false;
		this.phases = value;
	}
	/**
	* public ICPStageFullVo getCloneStageFullVo();
	*/
	/**
	 * WDEV-13773
	 * <br>Function used to create an ICP Stage Full clone from current VO
	 * <br>Will not contain the business rules
	 */
	public ICPStageFullVo getCloneStageFullVo()
	{
		// Create ICP Stage Full
		ICPStageFullVo fullStage = new ICPStageFullVo(this.id, this.version);
		
		// Copy simple fields
		fullStage.setName(this.name);
		fullStage.setDescription(this.description);
		fullStage.setSequence(this.sequence);
		fullStage.setStatus(this.status);
		fullStage.setHelpURL(this.helpurl);
		fullStage.setIsActivatedOnInitiation(this.isactivatedoninitiation);
		fullStage.setHasPhase(this.hasphase);
		
		// Business rules will be an empty collection
		fullStage.setRules(new ims.admin.vo.BusinessRuleVoCollection());
		
		// Copy ICP Phases collection
		fullStage.setPhases(new ICPPhaseFullVoCollection());
		
		if (this.phases != null)
		{
			for (ICPPhaseCloneVo phase : this.phases)
			{
				fullStage.getPhases().add(phase.getClonePhaseFullVo());
			}
		}
		
		// Return stage
		return fullStage;
	}
	/**
	* Custom constructor for queries.
	*/
	/**
	 * WDEV-13773
	 * Custom constructor used in query
	 */
	public ICPStageCloneVo(Integer id, int version, String name, String description, Integer sequence, String helpURL, Boolean isActivated, Boolean hasPhases)
	{
		this.id = id;
		this.version = version;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.status = ims.core.vo.lookups.PreActiveActiveInactiveStatus.PREACTIVE;
		this.helpurl = helpURL;
		this.isactivatedoninitiation = isActivated;
		this.hasphase = hasPhases;
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
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPStageCloneVo] is too big. It should be less or equal to 50");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.icp.vo.ICPStageCloneVo] is too big. It should be less or equal to 500");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.helpurl != null)
			if(this.helpurl.length() > 1024)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.icp.vo.ICPStageCloneVo] is too big. It should be less or equal to 1024");
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
	
		ICPStageCloneVo clone = new ICPStageCloneVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		clone.sequence = this.sequence;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.helpurl = this.helpurl;
		clone.isactivatedoninitiation = this.isactivatedoninitiation;
		clone.hasphase = this.hasphase;
		if(this.phases == null)
			clone.phases = null;
		else
			clone.phases = (ims.icp.vo.ICPPhaseCloneVoCollection)this.phases.clone();
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
		if (!(ICPStageCloneVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPStageCloneVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ICPStageCloneVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ICPStageCloneVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.phases != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.icp.vo.ICPPhaseCloneVoCollection phases;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
