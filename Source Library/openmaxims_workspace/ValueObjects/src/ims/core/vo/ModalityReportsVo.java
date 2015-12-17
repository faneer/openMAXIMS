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
 * Linked to core.admin.ModalityReports business object (ID: 1004100060).
 */
public class ModalityReportsVo extends ims.core.admin.vo.ModalityReportsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ModalityReportsVo()
	{
	}
	public ModalityReportsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ModalityReportsVo(ims.core.vo.beans.ModalityReportsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.modality = bean.getModality() == null ? null : bean.getModality().buildVo();
		this.dftreport = bean.getDFTReport();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ModalityReportsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.modality = bean.getModality() == null ? null : bean.getModality().buildVo(map);
		this.dftreport = bean.getDFTReport();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ModalityReportsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ModalityReportsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ModalityReportsVoBean();
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
		if(fieldName.equals("MODALITY"))
			return getModality();
		if(fieldName.equals("DFTREPORT"))
			return getDFTReport();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("TEMPLATE"))
			return getTemplate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getModalityIsNotNull()
	{
		return this.modality != null;
	}
	public ims.core.vo.ServiceLiteVo getModality()
	{
		return this.modality;
	}
	public void setModality(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.modality = value;
	}
	public boolean getDFTReportIsNotNull()
	{
		return this.dftreport != null;
	}
	public Boolean getDFTReport()
	{
		return this.dftreport;
	}
	public void setDFTReport(Boolean value)
	{
		this.isValidated = false;
		this.dftreport = value;
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
	public boolean getTemplateIsNotNull()
	{
		return this.template != null;
	}
	public ims.admin.vo.ReportTemplateLiteVo getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.admin.vo.ReportTemplateLiteVo value)
	{
		this.isValidated = false;
		this.template = value;
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
		if(this.modality == null)
			listOfErrors.add("Modality is mandatory");
		if(this.dftreport == null)
			listOfErrors.add("DFTReport is mandatory");
		if(this.template == null)
			listOfErrors.add("Template is mandatory");
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
	
		ModalityReportsVo clone = new ModalityReportsVo(this.id, this.version);
		
		if(this.modality == null)
			clone.modality = null;
		else
			clone.modality = (ims.core.vo.ServiceLiteVo)this.modality.clone();
		clone.dftreport = this.dftreport;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.template == null)
			clone.template = null;
		else
			clone.template = (ims.admin.vo.ReportTemplateLiteVo)this.template.clone();
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
		if (!(ModalityReportsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ModalityReportsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ModalityReportsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ModalityReportsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.modality != null)
			count++;
		if(this.dftreport != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.template != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.ServiceLiteVo modality;
	protected Boolean dftreport;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.admin.vo.ReportTemplateLiteVo template;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
