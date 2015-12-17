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
 * Linked to OCRR.OrderingResults.OcsOrderSession business object (ID: 1070100000).
 */
public class OcsOrderListVo extends ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OcsOrderListVo()
	{
	}
	public OcsOrderListVo(Integer id, int version)
	{
		super(id, version);
	}
	public OcsOrderListVo(ims.ocrr.vo.beans.OcsOrderListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.responsibleclinician = bean.getResponsibleClinician() == null ? null : bean.getResponsibleClinician().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OcsOrderListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.responsibleclinician = bean.getResponsibleClinician() == null ? null : bean.getResponsibleClinician().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OcsOrderListVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OcsOrderListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OcsOrderListVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("RESPONSIBLECLINICIAN"))
			return getResponsibleClinician();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShortListVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShortListVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getResponsibleClinicianIsNotNull()
	{
		return this.responsibleclinician != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsibleclinician = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
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
		if(this.patient != null)
		{
			if(!this.patient.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.responsibleclinician != null)
		{
			if(!this.responsibleclinician.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.patient != null)
		{
			String[] listOfOtherErrors = this.patient.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.responsibleclinician != null)
		{
			String[] listOfOtherErrors = this.responsibleclinician.validate();
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
	
		OcsOrderListVo clone = new OcsOrderListVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShortListVo)this.patient.clone();
		if(this.responsibleclinician == null)
			clone.responsibleclinician = null;
		else
			clone.responsibleclinician = (ims.core.vo.HcpLiteVo)this.responsibleclinician.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
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
		if (!(OcsOrderListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OcsOrderListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OcsOrderListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OcsOrderListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.responsibleclinician != null)
			count++;
		if(this.sysinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.PatientShortListVo patient;
	protected ims.core.vo.HcpLiteVo responsibleclinician;
	protected ims.vo.SystemInformation sysinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
