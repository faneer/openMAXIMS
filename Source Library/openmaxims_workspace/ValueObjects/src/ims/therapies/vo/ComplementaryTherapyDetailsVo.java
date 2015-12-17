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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.ComplementaryTherapyDetails business object (ID: 1019100004).
 */
public class ComplementaryTherapyDetailsVo extends ims.therapies.treatment.vo.ComplementaryTherapyDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ComplementaryTherapyDetailsVo()
	{
	}
	public ComplementaryTherapyDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ComplementaryTherapyDetailsVo(ims.therapies.vo.beans.ComplementaryTherapyDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.complementarytherapy = bean.getComplementaryTherapy() == null ? null : ims.spinalinjuries.vo.lookups.ComplementaryTherapy.buildLookup(bean.getComplementaryTherapy());
		this.contraindicationschecked = bean.getContraIndicationsChecked();
		this.treatment = bean.getTreatment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.ComplementaryTherapyDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.complementarytherapy = bean.getComplementaryTherapy() == null ? null : ims.spinalinjuries.vo.lookups.ComplementaryTherapy.buildLookup(bean.getComplementaryTherapy());
		this.contraindicationschecked = bean.getContraIndicationsChecked();
		this.treatment = bean.getTreatment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.ComplementaryTherapyDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.ComplementaryTherapyDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.ComplementaryTherapyDetailsVoBean();
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
		if(fieldName.equals("COMPLEMENTARYTHERAPY"))
			return getComplementaryTherapy();
		if(fieldName.equals("CONTRAINDICATIONSCHECKED"))
			return getContraIndicationsChecked();
		if(fieldName.equals("TREATMENT"))
			return getTreatment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getComplementaryTherapyIsNotNull()
	{
		return this.complementarytherapy != null;
	}
	public ims.spinalinjuries.vo.lookups.ComplementaryTherapy getComplementaryTherapy()
	{
		return this.complementarytherapy;
	}
	public void setComplementaryTherapy(ims.spinalinjuries.vo.lookups.ComplementaryTherapy value)
	{
		this.isValidated = false;
		this.complementarytherapy = value;
	}
	public boolean getContraIndicationsCheckedIsNotNull()
	{
		return this.contraindicationschecked != null;
	}
	public Boolean getContraIndicationsChecked()
	{
		return this.contraindicationschecked;
	}
	public void setContraIndicationsChecked(Boolean value)
	{
		this.isValidated = false;
		this.contraindicationschecked = value;
	}
	public boolean getTreatmentIsNotNull()
	{
		return this.treatment != null;
	}
	public String getTreatment()
	{
		return this.treatment;
	}
	public static int getTreatmentMaxLength()
	{
		return 255;
	}
	public void setTreatment(String value)
	{
		this.isValidated = false;
		this.treatment = value;
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
		if(this.complementarytherapy == null)
			listOfErrors.add("Complementary Therapy is a mandatory field");
		if(this.treatment != null)
			if(this.treatment.length() > 255)
				listOfErrors.add("The length of the field [treatment] in the value object [ims.therapies.vo.ComplementaryTherapyDetailsVo] is too big. It should be less or equal to 255");
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
	
		ComplementaryTherapyDetailsVo clone = new ComplementaryTherapyDetailsVo(this.id, this.version);
		
		if(this.complementarytherapy == null)
			clone.complementarytherapy = null;
		else
			clone.complementarytherapy = (ims.spinalinjuries.vo.lookups.ComplementaryTherapy)this.complementarytherapy.clone();
		clone.contraindicationschecked = this.contraindicationschecked;
		clone.treatment = this.treatment;
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
		if (!(ComplementaryTherapyDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ComplementaryTherapyDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ComplementaryTherapyDetailsVo compareObj = (ComplementaryTherapyDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ComplementaryTherapyDetails() == null && compareObj.getID_ComplementaryTherapyDetails() != null)
				return -1;
			if(this.getID_ComplementaryTherapyDetails() != null && compareObj.getID_ComplementaryTherapyDetails() == null)
				return 1;
			if(this.getID_ComplementaryTherapyDetails() != null && compareObj.getID_ComplementaryTherapyDetails() != null)
				retVal = this.getID_ComplementaryTherapyDetails().compareTo(compareObj.getID_ComplementaryTherapyDetails());
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
		if(this.complementarytherapy != null)
			count++;
		if(this.contraindicationschecked != null)
			count++;
		if(this.treatment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.spinalinjuries.vo.lookups.ComplementaryTherapy complementarytherapy;
	protected Boolean contraindicationschecked;
	protected String treatment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
