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

package ims.oncology.vo;

/**
 * Linked to Oncology.BrachyTxTreatmentDetails business object (ID: 1074100032).
 */
public class BrachyTxTreatmentDetailsVo extends ims.oncology.vo.BrachyTxTreatmentDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BrachyTxTreatmentDetailsVo()
	{
	}
	public BrachyTxTreatmentDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public BrachyTxTreatmentDetailsVo(ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.oncology.vo.lookups.BrachyTxType.buildLookup(bean.getType());
		this.treatmentdate = bean.getTreatmentDate() == null ? null : bean.getTreatmentDate().buildDate();
		this.dose = bean.getDose();
		this.generalanaesthetic = bean.getGeneralAnaesthetic() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getGeneralAnaesthetic());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.oncology.vo.lookups.BrachyTxType.buildLookup(bean.getType());
		this.treatmentdate = bean.getTreatmentDate() == null ? null : bean.getTreatmentDate().buildDate();
		this.dose = bean.getDose();
		this.generalanaesthetic = bean.getGeneralAnaesthetic() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getGeneralAnaesthetic());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean();
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
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("TREATMENTDATE"))
			return getTreatmentDate();
		if(fieldName.equals("DOSE"))
			return getDose();
		if(fieldName.equals("GENERALANAESTHETIC"))
			return getGeneralAnaesthetic();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.oncology.vo.lookups.BrachyTxType getType()
	{
		return this.type;
	}
	public void setType(ims.oncology.vo.lookups.BrachyTxType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getTreatmentDateIsNotNull()
	{
		return this.treatmentdate != null;
	}
	public ims.framework.utils.Date getTreatmentDate()
	{
		return this.treatmentdate;
	}
	public void setTreatmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.treatmentdate = value;
	}
	public boolean getDoseIsNotNull()
	{
		return this.dose != null;
	}
	public Float getDose()
	{
		return this.dose;
	}
	public void setDose(Float value)
	{
		this.isValidated = false;
		this.dose = value;
	}
	public boolean getGeneralAnaestheticIsNotNull()
	{
		return this.generalanaesthetic != null;
	}
	public ims.core.vo.lookups.YesNo getGeneralAnaesthetic()
	{
		return this.generalanaesthetic;
	}
	public void setGeneralAnaesthetic(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.generalanaesthetic = value;
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
	
		BrachyTxTreatmentDetailsVo clone = new BrachyTxTreatmentDetailsVo(this.id, this.version);
		
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.oncology.vo.lookups.BrachyTxType)this.type.clone();
		if(this.treatmentdate == null)
			clone.treatmentdate = null;
		else
			clone.treatmentdate = (ims.framework.utils.Date)this.treatmentdate.clone();
		clone.dose = this.dose;
		if(this.generalanaesthetic == null)
			clone.generalanaesthetic = null;
		else
			clone.generalanaesthetic = (ims.core.vo.lookups.YesNo)this.generalanaesthetic.clone();
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
		if (!(BrachyTxTreatmentDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BrachyTxTreatmentDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BrachyTxTreatmentDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BrachyTxTreatmentDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.type != null)
			count++;
		if(this.treatmentdate != null)
			count++;
		if(this.dose != null)
			count++;
		if(this.generalanaesthetic != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.oncology.vo.lookups.BrachyTxType type;
	protected ims.framework.utils.Date treatmentdate;
	protected Float dose;
	protected ims.core.vo.lookups.YesNo generalanaesthetic;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
