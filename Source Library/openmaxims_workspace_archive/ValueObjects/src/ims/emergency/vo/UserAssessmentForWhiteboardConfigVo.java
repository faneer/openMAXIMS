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

package ims.emergency.vo;

/**
 * Linked to Assessment.Configuration.UserAssessment business object (ID: 1003100043).
 */
public class UserAssessmentForWhiteboardConfigVo extends ims.assessment.configuration.vo.UserAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserAssessmentForWhiteboardConfigVo()
	{
	}
	public UserAssessmentForWhiteboardConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public UserAssessmentForWhiteboardConfigVo(ims.emergency.vo.beans.UserAssessmentForWhiteboardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		if(bean.getTaxonomyMap() != null)
		{
			this.taxonomymap = new ims.core.clinical.vo.TaxonomyMapRefVoCollection();
			for(int taxonomymap_i = 0; taxonomymap_i < bean.getTaxonomyMap().length; taxonomymap_i++)
			{
				this.taxonomymap.add(new ims.core.clinical.vo.TaxonomyMapRefVo(new Integer(bean.getTaxonomyMap()[taxonomymap_i].getId()), bean.getTaxonomyMap()[taxonomymap_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.UserAssessmentForWhiteboardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		if(bean.getTaxonomyMap() != null)
		{
			this.taxonomymap = new ims.core.clinical.vo.TaxonomyMapRefVoCollection();
			for(int taxonomymap_i = 0; taxonomymap_i < bean.getTaxonomyMap().length; taxonomymap_i++)
			{
				this.taxonomymap.add(new ims.core.clinical.vo.TaxonomyMapRefVo(new Integer(bean.getTaxonomyMap()[taxonomymap_i].getId()), bean.getTaxonomyMap()[taxonomymap_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.UserAssessmentForWhiteboardConfigVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.UserAssessmentForWhiteboardConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.UserAssessmentForWhiteboardConfigVoBean();
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
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ASSESSMENTTYPE"))
			return getAssessmentType();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
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
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 500;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getAssessmentTypeIsNotNull()
	{
		return this.assessmenttype != null;
	}
	public ims.core.vo.lookups.UserDefinedAssessmentType getAssessmentType()
	{
		return this.assessmenttype;
	}
	public void setAssessmentType(ims.core.vo.lookups.UserDefinedAssessmentType value)
	{
		this.isValidated = false;
		this.assessmenttype = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.clinical.vo.TaxonomyMapRefVoCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.clinical.vo.TaxonomyMapRefVoCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
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
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.emergency.vo.UserAssessmentForWhiteboardConfigVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.emergency.vo.UserAssessmentForWhiteboardConfigVo] is too big. It should be less or equal to 500");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
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
	
		UserAssessmentForWhiteboardConfigVo clone = new UserAssessmentForWhiteboardConfigVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.assessmenttype == null)
			clone.assessmenttype = null;
		else
			clone.assessmenttype = (ims.core.vo.lookups.UserDefinedAssessmentType)this.assessmenttype.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		clone.taxonomymap = this.taxonomymap;
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
		if (!(UserAssessmentForWhiteboardConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserAssessmentForWhiteboardConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		UserAssessmentForWhiteboardConfigVo compareObj = (UserAssessmentForWhiteboardConfigVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
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
		if(this.name != null)
			count++;
		if(this.description != null)
			count++;
		if(this.assessmenttype != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.taxonomymap != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String name;
	protected String description;
	protected ims.core.vo.lookups.UserDefinedAssessmentType assessmenttype;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected ims.core.clinical.vo.TaxonomyMapRefVoCollection taxonomymap;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
