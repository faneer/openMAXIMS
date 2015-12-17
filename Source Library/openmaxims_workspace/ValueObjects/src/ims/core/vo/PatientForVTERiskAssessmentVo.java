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

package ims.core.vo;

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientForVTERiskAssessmentVo extends ims.core.patient.vo.PatientRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientForVTERiskAssessmentVo()
	{
	}
	public PatientForVTERiskAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientForVTERiskAssessmentVo(ims.core.vo.beans.PatientForVTERiskAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientForVTERiskAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientForVTERiskAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientForVTERiskAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientForVTERiskAssessmentVoBean();
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
		if(fieldName.equals("DOB"))
			return getDob();
		if(fieldName.equals("IDENTIFIERS"))
			return getIdentifiers();
		if(fieldName.equals("WARD"))
			return getWard();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getDobIsNotNull()
	{
		return this.dob != null;
	}
	public ims.framework.utils.PartialDate getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.dob = value;
	}
	public boolean getIdentifiersIsNotNull()
	{
		return this.identifiers != null;
	}
	public ims.core.vo.PatientIdCollection getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.PatientIdCollection value)
	{
		this.isValidated = false;
		this.identifiers = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	/**
	* getPatId
	*/
	public ims.core.vo.PatientId getPatId(ims.core.vo.lookups.PatIdType idType)
	{
		if (identifiers == null) return null;
		for (int i = 0; i < identifiers.size(); i++)
		{
			ims.core.vo.PatientId id = identifiers.get(i);
			if (id.getType().equals(idType))
			{
				return id;
			}
		}
		return null;
	}
	/**
	* getHospNum
	*/
	public ims.core.vo.PatientId getHospNum()
	{
		return getPatId(ims.core.vo.lookups.PatIdType.HOSPNUM);
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
	
		PatientForVTERiskAssessmentVo clone = new PatientForVTERiskAssessmentVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.dob == null)
			clone.dob = null;
		else
			clone.dob = (ims.framework.utils.PartialDate)this.dob.clone();
		if(this.identifiers == null)
			clone.identifiers = null;
		else
			clone.identifiers = (ims.core.vo.PatientIdCollection)this.identifiers.clone();
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
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
		if (!(PatientForVTERiskAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientForVTERiskAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientForVTERiskAssessmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientForVTERiskAssessmentVo)obj).getBoId());
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
		if(this.dob != null)
			count++;
		if(this.identifiers != null)
			count++;
		if(this.ward != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.PersonName name;
	protected ims.framework.utils.PartialDate dob;
	protected ims.core.vo.PatientIdCollection identifiers;
	protected ims.core.vo.LocationLiteVo ward;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
