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

package ims.clinicaladmin.vo;

/**
 * Linked to core.clinical.TreatmentIntervention business object (ID: 1003100122).
 */
public class TreatmentInterventionLiteVo extends ims.core.clinical.vo.TreatmentInterventionRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IGenericItem, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public TreatmentInterventionLiteVo()
	{
	}
	public TreatmentInterventionLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TreatmentInterventionLiteVo(ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentinterventionname = bean.getTreatmentInterventionName();
		this.isactive = bean.getIsActive();
		this.treatmentinterventiontype = bean.getTreatmentInterventionType() == null ? null : ims.clinical.vo.lookups.TreatmentInterventionType.buildLookup(bean.getTreatmentInterventionType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentinterventionname = bean.getTreatmentInterventionName();
		this.isactive = bean.getIsActive();
		this.treatmentinterventiontype = bean.getTreatmentInterventionType() == null ? null : ims.clinical.vo.lookups.TreatmentInterventionType.buildLookup(bean.getTreatmentInterventionType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TreatmentInterventionLiteVoBean();
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
		if(fieldName.equals("TREATMENTINTERVENTIONNAME"))
			return getTreatmentInterventionName();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("TREATMENTINTERVENTIONTYPE"))
			return getTreatmentInterventionType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentInterventionNameIsNotNull()
	{
		return this.treatmentinterventionname != null;
	}
	public String getTreatmentInterventionName()
	{
		return this.treatmentinterventionname;
	}
	public static int getTreatmentInterventionNameMaxLength()
	{
		return 255;
	}
	public void setTreatmentInterventionName(String value)
	{
		this.isValidated = false;
		this.treatmentinterventionname = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getTreatmentInterventionTypeIsNotNull()
	{
		return this.treatmentinterventiontype != null;
	}
	public ims.clinical.vo.lookups.TreatmentInterventionType getTreatmentInterventionType()
	{
		return this.treatmentinterventiontype;
	}
	public void setTreatmentInterventionType(ims.clinical.vo.lookups.TreatmentInterventionType value)
	{
		this.isValidated = false;
		this.treatmentinterventiontype = value;
	}
	/**
	* IGenericItem Interface Methods
	*/
			
	public String getIGenericItemInfoName()
	{
		return this.getTreatmentInterventionName();
	}
			
	public Boolean getIGenericItemInfoIsActive()
	{
		return this.getIsActive();
	}
			
	public void setIGenericItemName(String name)
	{
		this.setTreatmentInterventionName(name);
	}
	
	public void setIGenericItemIsActive(Boolean b) 
	{
		this.setIsActive(b);
	}
	/**
	* IClinicalCodingValue
	*/
	public Integer getIGenericItemInfoID()
	{
		return super.getID_TreatmentIntervention();
	}
	public ims.vo.ValueObject getIClinicalCodingValue() 
	{
		return this;
	}
	public void setIClinicalCodingValue(ims.vo.ValueObject vo) 
	{
		this.setID_TreatmentIntervention(((ims.clinicaladmin.vo.TreatmentInterventionLiteVo)vo).getID_TreatmentIntervention());		
		this.setTreatmentInterventionName(((ims.clinicaladmin.vo.TreatmentInterventionLiteVo)vo).getTreatmentInterventionName());		
		this.setIsActive(((ims.clinicaladmin.vo.TreatmentInterventionLiteVo)vo).getIsActive());		
	}
	public String getIClinicalCodingValueDescription() 
	{
		return this.treatmentinterventionname;
	}
	public void setIClinicalCodingValueDescription(String value) 
	{
		this.treatmentinterventionname= value;
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
		if(this.treatmentinterventionname == null || this.treatmentinterventionname.length() == 0)
			listOfErrors.add("TreatmentInterventionName is mandatory");
		else if(this.treatmentinterventionname.length() > 255)
			listOfErrors.add("The length of the field [treatmentinterventionname] in the value object [ims.clinicaladmin.vo.TreatmentInterventionLiteVo] is too big. It should be less or equal to 255");
		if(this.treatmentinterventiontype == null)
			listOfErrors.add("TreatmentInterventionType is mandatory");
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
	
		TreatmentInterventionLiteVo clone = new TreatmentInterventionLiteVo(this.id, this.version);
		
		clone.treatmentinterventionname = this.treatmentinterventionname;
		clone.isactive = this.isactive;
		if(this.treatmentinterventiontype == null)
			clone.treatmentinterventiontype = null;
		else
			clone.treatmentinterventiontype = (ims.clinical.vo.lookups.TreatmentInterventionType)this.treatmentinterventiontype.clone();
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
		if (!(TreatmentInterventionLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TreatmentInterventionLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TreatmentInterventionLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TreatmentInterventionLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatmentinterventionname != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.treatmentinterventiontype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String treatmentinterventionname;
	protected Boolean isactive;
	protected ims.clinical.vo.lookups.TreatmentInterventionType treatmentinterventiontype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
