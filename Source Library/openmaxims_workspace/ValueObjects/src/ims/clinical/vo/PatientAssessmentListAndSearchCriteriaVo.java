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

package ims.clinical.vo;


public class PatientAssessmentListAndSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAssessmentListAndSearchCriteriaVo()
	{
	}
	public PatientAssessmentListAndSearchCriteriaVo(ims.clinical.vo.beans.PatientAssessmentListAndSearchCriteriaVoBean bean)
	{
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo();
		this.assessmentname = bean.getAssessmentName();
		this.assessesmentstatus = bean.getAssessesmentStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getAssessesmentStatus());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.datesearchtype = bean.getDateSearchType();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientAssessmentListAndSearchCriteriaVoBean bean)
	{
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo(map);
		this.assessmentname = bean.getAssessmentName();
		this.assessesmentstatus = bean.getAssessesmentStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getAssessesmentStatus());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.datesearchtype = bean.getDateSearchType();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientAssessmentListAndSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientAssessmentListAndSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientAssessmentListAndSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.HcpLiteVo getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getAssessmentNameIsNotNull()
	{
		return this.assessmentname != null;
	}
	public String getAssessmentName()
	{
		return this.assessmentname;
	}
	public static int getAssessmentNameMaxLength()
	{
		return 255;
	}
	public void setAssessmentName(String value)
	{
		this.isValidated = false;
		this.assessmentname = value;
	}
	public boolean getAssessesmentStatusIsNotNull()
	{
		return this.assessesmentstatus != null;
	}
	public ims.core.vo.lookups.PatientAssessmentStatusReason getAssessesmentStatus()
	{
		return this.assessesmentstatus;
	}
	public void setAssessesmentStatus(ims.core.vo.lookups.PatientAssessmentStatusReason value)
	{
		this.isValidated = false;
		this.assessesmentstatus = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.Date getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.Date getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public boolean getDateSearchTypeIsNotNull()
	{
		return this.datesearchtype != null;
	}
	public Boolean getDateSearchType()
	{
		return this.datesearchtype;
	}
	public void setDateSearchType(Boolean value)
	{
		this.isValidated = false;
		this.datesearchtype = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof PatientAssessmentListAndSearchCriteriaVo))
			return false;
		PatientAssessmentListAndSearchCriteriaVo compareObj = (PatientAssessmentListAndSearchCriteriaVo)obj;
		if(this.getSpecialty() == null && compareObj.getSpecialty() != null)
			return false;
		if(this.getSpecialty() != null && compareObj.getSpecialty() == null)
			return false;
		if(this.getSpecialty() != null && compareObj.getSpecialty() != null)
			if(!this.getSpecialty().equals(compareObj.getSpecialty()))
				return false;
		if(this.getAuthoringHCP() == null && compareObj.getAuthoringHCP() != null)
			return false;
		if(this.getAuthoringHCP() != null && compareObj.getAuthoringHCP() == null)
			return false;
		if(this.getAuthoringHCP() != null && compareObj.getAuthoringHCP() != null)
			if(!this.getAuthoringHCP().equals(compareObj.getAuthoringHCP()))
				return false;
		if(this.getResponsibleHCP() == null && compareObj.getResponsibleHCP() != null)
			return false;
		if(this.getResponsibleHCP() != null && compareObj.getResponsibleHCP() == null)
			return false;
		if(this.getResponsibleHCP() != null && compareObj.getResponsibleHCP() != null)
			if(!this.getResponsibleHCP().equals(compareObj.getResponsibleHCP()))
				return false;
		if(this.getAssessmentName() == null && compareObj.getAssessmentName() != null)
			return false;
		if(this.getAssessmentName() != null && compareObj.getAssessmentName() == null)
			return false;
		if(this.getAssessmentName() != null && compareObj.getAssessmentName() != null)
			if(!this.getAssessmentName().equals(compareObj.getAssessmentName()))
				return false;
		if(this.getAssessesmentStatus() == null && compareObj.getAssessesmentStatus() != null)
			return false;
		if(this.getAssessesmentStatus() != null && compareObj.getAssessesmentStatus() == null)
			return false;
		if(this.getAssessesmentStatus() != null && compareObj.getAssessesmentStatus() != null)
			if(!this.getAssessesmentStatus().equals(compareObj.getAssessesmentStatus()))
				return false;
		if(this.getDateFrom() == null && compareObj.getDateFrom() != null)
			return false;
		if(this.getDateFrom() != null && compareObj.getDateFrom() == null)
			return false;
		if(this.getDateFrom() != null && compareObj.getDateFrom() != null)
			if(!this.getDateFrom().equals(compareObj.getDateFrom()))
				return false;
		if(this.getDateTo() == null && compareObj.getDateTo() != null)
			return false;
		if(this.getDateTo() != null && compareObj.getDateTo() == null)
			return false;
		if(this.getDateTo() != null && compareObj.getDateTo() != null)
			if(!this.getDateTo().equals(compareObj.getDateTo()))
				return false;
		if(this.getDateSearchType() == null && compareObj.getDateSearchType() != null)
			return false;
		if(this.getDateSearchType() != null && compareObj.getDateSearchType() == null)
			return false;
		if(this.getDateSearchType() != null && compareObj.getDateSearchType() != null)
			return this.getDateSearchType().equals(compareObj.getDateSearchType());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientAssessmentListAndSearchCriteriaVo clone = new PatientAssessmentListAndSearchCriteriaVo();
		
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.HcpLiteVo)this.authoringhcp.clone();
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
		clone.assessmentname = this.assessmentname;
		if(this.assessesmentstatus == null)
			clone.assessesmentstatus = null;
		else
			clone.assessesmentstatus = (ims.core.vo.lookups.PatientAssessmentStatusReason)this.assessesmentstatus.clone();
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.Date)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.Date)this.dateto.clone();
		clone.datesearchtype = this.datesearchtype;
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
		if (!(PatientAssessmentListAndSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAssessmentListAndSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientAssessmentListAndSearchCriteriaVo compareObj = (PatientAssessmentListAndSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSpecialty() == null && compareObj.getSpecialty() != null)
				return -1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() == null)
				return 1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() != null)
				retVal = this.getSpecialty().compareTo(compareObj.getSpecialty());
		}
		if (retVal == 0)
		{
			if(this.getAuthoringHCP() == null && compareObj.getAuthoringHCP() != null)
				return -1;
			if(this.getAuthoringHCP() != null && compareObj.getAuthoringHCP() == null)
				return 1;
			if(this.getAuthoringHCP() != null && compareObj.getAuthoringHCP() != null)
				retVal = this.getAuthoringHCP().compareTo(compareObj.getAuthoringHCP());
		}
		if (retVal == 0)
		{
			if(this.getResponsibleHCP() == null && compareObj.getResponsibleHCP() != null)
				return -1;
			if(this.getResponsibleHCP() != null && compareObj.getResponsibleHCP() == null)
				return 1;
			if(this.getResponsibleHCP() != null && compareObj.getResponsibleHCP() != null)
				retVal = this.getResponsibleHCP().compareTo(compareObj.getResponsibleHCP());
		}
		if (retVal == 0)
		{
			if(this.getAssessmentName() == null && compareObj.getAssessmentName() != null)
				return -1;
			if(this.getAssessmentName() != null && compareObj.getAssessmentName() == null)
				return 1;
			if(this.getAssessmentName() != null && compareObj.getAssessmentName() != null)
			{
				if(caseInsensitive)
					retVal = this.getAssessmentName().toLowerCase().compareTo(compareObj.getAssessmentName().toLowerCase());
				else
					retVal = this.getAssessmentName().compareTo(compareObj.getAssessmentName());
			}
		}
		if (retVal == 0)
		{
			if(this.getAssessesmentStatus() == null && compareObj.getAssessesmentStatus() != null)
				return -1;
			if(this.getAssessesmentStatus() != null && compareObj.getAssessesmentStatus() == null)
				return 1;
			if(this.getAssessesmentStatus() != null && compareObj.getAssessesmentStatus() != null)
				retVal = this.getAssessesmentStatus().compareTo(compareObj.getAssessesmentStatus());
		}
		if (retVal == 0)
		{
			if(this.getDateFrom() == null && compareObj.getDateFrom() != null)
				return -1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() == null)
				return 1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() != null)
				retVal = this.getDateFrom().compareTo(compareObj.getDateFrom());
		}
		if (retVal == 0)
		{
			if(this.getDateTo() == null && compareObj.getDateTo() != null)
				return -1;
			if(this.getDateTo() != null && compareObj.getDateTo() == null)
				return 1;
			if(this.getDateTo() != null && compareObj.getDateTo() != null)
				retVal = this.getDateTo().compareTo(compareObj.getDateTo());
		}
		if (retVal == 0)
		{
			if(this.getDateSearchType() == null && compareObj.getDateSearchType() != null)
				return -1;
			if(this.getDateSearchType() != null && compareObj.getDateSearchType() == null)
				return 1;
			if(this.getDateSearchType() != null && compareObj.getDateSearchType() != null)
				retVal = this.getDateSearchType().compareTo(compareObj.getDateSearchType());
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
		if(this.specialty != null)
			count++;
		if(this.authoringhcp != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.assessmentname != null)
			count++;
		if(this.assessesmentstatus != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		if(this.datesearchtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.HcpLiteVo authoringhcp;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	protected String assessmentname;
	protected ims.core.vo.lookups.PatientAssessmentStatusReason assessesmentstatus;
	protected ims.framework.utils.Date datefrom;
	protected ims.framework.utils.Date dateto;
	protected Boolean datesearchtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
