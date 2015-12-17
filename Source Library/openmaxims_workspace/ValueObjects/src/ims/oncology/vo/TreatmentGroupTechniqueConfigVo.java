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

package ims.oncology.vo;

/**
 * Linked to Oncology.TreatmentGroupTechniqueConfig business object (ID: 1074100050).
 */
public class TreatmentGroupTechniqueConfigVo extends ims.oncology.vo.TreatmentGroupTechniqueConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TreatmentGroupTechniqueConfigVo()
	{
	}
	public TreatmentGroupTechniqueConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public TreatmentGroupTechniqueConfigVo(ims.oncology.vo.beans.TreatmentGroupTechniqueConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentgroup = bean.getTreatmentGroup() == null ? null : ims.oncology.vo.lookups.TreatmentGroupSite.buildLookup(bean.getTreatmentGroup());
		this.treatmenttechniques = ims.ccosched.vo.lookups.TechniquesCollection.buildFromBeanCollection(bean.getTreatmentTechniques());
		this.active = bean.getActive() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActive());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.TreatmentGroupTechniqueConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentgroup = bean.getTreatmentGroup() == null ? null : ims.oncology.vo.lookups.TreatmentGroupSite.buildLookup(bean.getTreatmentGroup());
		this.treatmenttechniques = ims.ccosched.vo.lookups.TechniquesCollection.buildFromBeanCollection(bean.getTreatmentTechniques());
		this.active = bean.getActive() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActive());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.TreatmentGroupTechniqueConfigVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.TreatmentGroupTechniqueConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.TreatmentGroupTechniqueConfigVoBean();
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
		if(fieldName.equals("TREATMENTGROUP"))
			return getTreatmentGroup();
		if(fieldName.equals("TREATMENTTECHNIQUES"))
			return getTreatmentTechniques();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentGroupIsNotNull()
	{
		return this.treatmentgroup != null;
	}
	public ims.oncology.vo.lookups.TreatmentGroupSite getTreatmentGroup()
	{
		return this.treatmentgroup;
	}
	public void setTreatmentGroup(ims.oncology.vo.lookups.TreatmentGroupSite value)
	{
		this.isValidated = false;
		this.treatmentgroup = value;
	}
	public boolean getTreatmentTechniquesIsNotNull()
	{
		return this.treatmenttechniques != null;
	}
	public ims.ccosched.vo.lookups.TechniquesCollection getTreatmentTechniques()
	{
		return this.treatmenttechniques;
	}
	public void setTreatmentTechniques(ims.ccosched.vo.lookups.TechniquesCollection value)
	{
		this.isValidated = false;
		this.treatmenttechniques = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActive()
	{
		return this.active;
	}
	public void setActive(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.active = value;
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
	
		TreatmentGroupTechniqueConfigVo clone = new TreatmentGroupTechniqueConfigVo(this.id, this.version);
		
		if(this.treatmentgroup == null)
			clone.treatmentgroup = null;
		else
			clone.treatmentgroup = (ims.oncology.vo.lookups.TreatmentGroupSite)this.treatmentgroup.clone();
		if(this.treatmenttechniques == null)
			clone.treatmenttechniques = null;
		else
			clone.treatmenttechniques = (ims.ccosched.vo.lookups.TechniquesCollection)this.treatmenttechniques.clone();
		if(this.active == null)
			clone.active = null;
		else
			clone.active = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.active.clone();
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
		if (!(TreatmentGroupTechniqueConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TreatmentGroupTechniqueConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TreatmentGroupTechniqueConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TreatmentGroupTechniqueConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatmentgroup != null)
			count++;
		if(this.treatmenttechniques != null)
			count++;
		if(this.active != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.oncology.vo.lookups.TreatmentGroupSite treatmentgroup;
	protected ims.ccosched.vo.lookups.TechniquesCollection treatmenttechniques;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus active;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
