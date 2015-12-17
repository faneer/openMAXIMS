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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.ResultDetails business object (ID: 1070100028).
 */
public class ResultDetailsForClinicalImagingResultVo extends ims.ocrr.orderingresults.vo.ResultDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ResultDetailsForClinicalImagingResultVo()
	{
	}
	public ResultDetailsForClinicalImagingResultVo(Integer id, int version)
	{
		super(id, version);
	}
	public ResultDetailsForClinicalImagingResultVo(ims.ocrr.vo.beans.ResultDetailsForClinicalImagingResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.documentresultdetails = bean.getDocumentResultDetails() == null ? null : bean.getDocumentResultDetails().buildVo();
		this.clinicalresultdetails = bean.getClinicalResultDetails() == null ? null : bean.getClinicalResultDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ResultDetailsForClinicalImagingResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.documentresultdetails = bean.getDocumentResultDetails() == null ? null : bean.getDocumentResultDetails().buildVo(map);
		this.clinicalresultdetails = bean.getClinicalResultDetails() == null ? null : bean.getClinicalResultDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ResultDetailsForClinicalImagingResultVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ResultDetailsForClinicalImagingResultVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ResultDetailsForClinicalImagingResultVoBean();
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
		if(fieldName.equals("DOCUMENTRESULTDETAILS"))
			return getDocumentResultDetails();
		if(fieldName.equals("CLINICALRESULTDETAILS"))
			return getClinicalResultDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDocumentResultDetailsIsNotNull()
	{
		return this.documentresultdetails != null;
	}
	public ims.core.vo.PatientDocumentVo getDocumentResultDetails()
	{
		return this.documentresultdetails;
	}
	public void setDocumentResultDetails(ims.core.vo.PatientDocumentVo value)
	{
		this.isValidated = false;
		this.documentresultdetails = value;
	}
	public boolean getClinicalResultDetailsIsNotNull()
	{
		return this.clinicalresultdetails != null;
	}
	public ims.ocrr.vo.RadResultDetailsVo getClinicalResultDetails()
	{
		return this.clinicalresultdetails;
	}
	public void setClinicalResultDetails(ims.ocrr.vo.RadResultDetailsVo value)
	{
		this.isValidated = false;
		this.clinicalresultdetails = value;
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
		if(this.documentresultdetails != null)
		{
			if(!this.documentresultdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinicalresultdetails != null)
		{
			if(!this.clinicalresultdetails.isValidated())
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
		if(this.documentresultdetails != null)
		{
			String[] listOfOtherErrors = this.documentresultdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalresultdetails != null)
		{
			String[] listOfOtherErrors = this.clinicalresultdetails.validate();
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
	
		ResultDetailsForClinicalImagingResultVo clone = new ResultDetailsForClinicalImagingResultVo(this.id, this.version);
		
		if(this.documentresultdetails == null)
			clone.documentresultdetails = null;
		else
			clone.documentresultdetails = (ims.core.vo.PatientDocumentVo)this.documentresultdetails.clone();
		if(this.clinicalresultdetails == null)
			clone.clinicalresultdetails = null;
		else
			clone.clinicalresultdetails = (ims.ocrr.vo.RadResultDetailsVo)this.clinicalresultdetails.clone();
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
		if (!(ResultDetailsForClinicalImagingResultVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ResultDetailsForClinicalImagingResultVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ResultDetailsForClinicalImagingResultVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ResultDetailsForClinicalImagingResultVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.documentresultdetails != null)
			count++;
		if(this.clinicalresultdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.PatientDocumentVo documentresultdetails;
	protected ims.ocrr.vo.RadResultDetailsVo clinicalresultdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
