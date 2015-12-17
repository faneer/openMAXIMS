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

package ims.nursing.vo;

/**
 * Linked to nursing.assessment tools.MRSATreatment business object (ID: 1016100013).
 */
public class MRSATreatmentVo extends ims.nursing.assessmenttools.vo.MRSATreatmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MRSATreatmentVo()
	{
	}
	public MRSATreatmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public MRSATreatmentVo(ims.nursing.vo.beans.MRSATreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.rescreendate = bean.getRescreenDate() == null ? null : bean.getRescreenDate().buildDate();
		this.treatmentnumber = bean.getTreatmentNumber();
		this.treatmentdetails = ims.nursing.vo.MRSATreatmentDetailsVoCollection.buildFromBeanCollection(bean.getTreatmentDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.MRSATreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.rescreendate = bean.getRescreenDate() == null ? null : bean.getRescreenDate().buildDate();
		this.treatmentnumber = bean.getTreatmentNumber();
		this.treatmentdetails = ims.nursing.vo.MRSATreatmentDetailsVoCollection.buildFromBeanCollection(bean.getTreatmentDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.MRSATreatmentVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.MRSATreatmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.MRSATreatmentVoBean();
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
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("RESCREENDATE"))
			return getRescreenDate();
		if(fieldName.equals("TREATMENTNUMBER"))
			return getTreatmentNumber();
		if(fieldName.equals("TREATMENTDETAILS"))
			return getTreatmentDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
	}
	public boolean getRescreenDateIsNotNull()
	{
		return this.rescreendate != null;
	}
	public ims.framework.utils.Date getRescreenDate()
	{
		return this.rescreendate;
	}
	public void setRescreenDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.rescreendate = value;
	}
	public boolean getTreatmentNumberIsNotNull()
	{
		return this.treatmentnumber != null;
	}
	public Integer getTreatmentNumber()
	{
		return this.treatmentnumber;
	}
	public void setTreatmentNumber(Integer value)
	{
		this.isValidated = false;
		this.treatmentnumber = value;
	}
	public boolean getTreatmentDetailsIsNotNull()
	{
		return this.treatmentdetails != null;
	}
	public ims.nursing.vo.MRSATreatmentDetailsVoCollection getTreatmentDetails()
	{
		return this.treatmentdetails;
	}
	public void setTreatmentDetails(ims.nursing.vo.MRSATreatmentDetailsVoCollection value)
	{
		this.isValidated = false;
		this.treatmentdetails = value;
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
		if(this.treatmentdetails != null)
		{
			if(!this.treatmentdetails.isValidated())
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
		if(this.treatmentdetails != null)
		{
			String[] listOfOtherErrors = this.treatmentdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		MRSATreatmentVo clone = new MRSATreatmentVo(this.id, this.version);
		
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.rescreendate == null)
			clone.rescreendate = null;
		else
			clone.rescreendate = (ims.framework.utils.Date)this.rescreendate.clone();
		clone.treatmentnumber = this.treatmentnumber;
		if(this.treatmentdetails == null)
			clone.treatmentdetails = null;
		else
			clone.treatmentdetails = (ims.nursing.vo.MRSATreatmentDetailsVoCollection)this.treatmentdetails.clone();
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
		if (!(MRSATreatmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MRSATreatmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MRSATreatmentVo compareObj = (MRSATreatmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_MRSATreatment() == null && compareObj.getID_MRSATreatment() != null)
				return -1;
			if(this.getID_MRSATreatment() != null && compareObj.getID_MRSATreatment() == null)
				return 1;
			if(this.getID_MRSATreatment() != null && compareObj.getID_MRSATreatment() != null)
				retVal = this.getID_MRSATreatment().compareTo(compareObj.getID_MRSATreatment());
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
		if(this.startdate != null)
			count++;
		if(this.rescreendate != null)
			count++;
		if(this.treatmentnumber != null)
			count++;
		if(this.treatmentdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date rescreendate;
	protected Integer treatmentnumber;
	protected ims.nursing.vo.MRSATreatmentDetailsVoCollection treatmentdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
