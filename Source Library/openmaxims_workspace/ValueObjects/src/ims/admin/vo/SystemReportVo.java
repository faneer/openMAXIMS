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

package ims.admin.vo;

/**
 * Linked to core.admin.ReportBo business object (ID: 1004100009).
 */
public class SystemReportVo extends ims.admin.vo.ReportLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SystemReportVo()
	{
	}
	public SystemReportVo(Integer id, int version)
	{
		super(id, version);
	}
	public SystemReportVo(ims.admin.vo.beans.SystemReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.reportdescription = bean.getReportDescription();
		this.isactive = bean.getIsActive();
		this.imsid = bean.getImsId();
		this.exportfilename = bean.getExportFileName();
		this.queryeditable = bean.getQueryEditable();
		this.templateeditable = bean.getTemplateEditable();
		this.lastdeployment = bean.getLastDeployment() == null ? null : bean.getLastDeployment().buildDateTime();
		this.lastupdated = bean.getLastUpdated() == null ? null : bean.getLastUpdated().buildDateTime();
		this.templates = ims.core.vo.TemplateBoLiteVoCollection.buildFromBeanCollection(bean.getTemplates());
		this.reportxml = bean.getReportXml();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.SystemReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.reportdescription = bean.getReportDescription();
		this.isactive = bean.getIsActive();
		this.imsid = bean.getImsId();
		this.exportfilename = bean.getExportFileName();
		this.queryeditable = bean.getQueryEditable();
		this.templateeditable = bean.getTemplateEditable();
		this.lastdeployment = bean.getLastDeployment() == null ? null : bean.getLastDeployment().buildDateTime();
		this.lastupdated = bean.getLastUpdated() == null ? null : bean.getLastUpdated().buildDateTime();
		this.templates = ims.core.vo.TemplateBoLiteVoCollection.buildFromBeanCollection(bean.getTemplates());
		this.reportxml = bean.getReportXml();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.SystemReportVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.SystemReportVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.SystemReportVoBean();
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
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("IMSID"))
			return getImsId();
		if(fieldName.equals("EXPORTFILENAME"))
			return getExportFileName();
		if(fieldName.equals("QUERYEDITABLE"))
			return getQueryEditable();
		if(fieldName.equals("TEMPLATEEDITABLE"))
			return getTemplateEditable();
		if(fieldName.equals("LASTDEPLOYMENT"))
			return getLastDeployment();
		if(fieldName.equals("LASTUPDATED"))
			return getLastUpdated();
		if(fieldName.equals("TEMPLATES"))
			return getTemplates();
		if(fieldName.equals("REPORTXML"))
			return getReportXml();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getImsIdIsNotNull()
	{
		return this.imsid != null;
	}
	public Integer getImsId()
	{
		return this.imsid;
	}
	public void setImsId(Integer value)
	{
		this.isValidated = false;
		this.imsid = value;
	}
	public boolean getExportFileNameIsNotNull()
	{
		return this.exportfilename != null;
	}
	public String getExportFileName()
	{
		return this.exportfilename;
	}
	public static int getExportFileNameMaxLength()
	{
		return 255;
	}
	public void setExportFileName(String value)
	{
		this.isValidated = false;
		this.exportfilename = value;
	}
	public boolean getQueryEditableIsNotNull()
	{
		return this.queryeditable != null;
	}
	public Boolean getQueryEditable()
	{
		return this.queryeditable;
	}
	public void setQueryEditable(Boolean value)
	{
		this.isValidated = false;
		this.queryeditable = value;
	}
	public boolean getTemplateEditableIsNotNull()
	{
		return this.templateeditable != null;
	}
	public Boolean getTemplateEditable()
	{
		return this.templateeditable;
	}
	public void setTemplateEditable(Boolean value)
	{
		this.isValidated = false;
		this.templateeditable = value;
	}
	public boolean getLastDeploymentIsNotNull()
	{
		return this.lastdeployment != null;
	}
	public ims.framework.utils.DateTime getLastDeployment()
	{
		return this.lastdeployment;
	}
	public void setLastDeployment(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastdeployment = value;
	}
	public boolean getLastUpdatedIsNotNull()
	{
		return this.lastupdated != null;
	}
	public ims.framework.utils.DateTime getLastUpdated()
	{
		return this.lastupdated;
	}
	public void setLastUpdated(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastupdated = value;
	}
	public boolean getTemplatesIsNotNull()
	{
		return this.templates != null;
	}
	public ims.core.vo.TemplateBoLiteVoCollection getTemplates()
	{
		return this.templates;
	}
	public void setTemplates(ims.core.vo.TemplateBoLiteVoCollection value)
	{
		this.isValidated = false;
		this.templates = value;
	}
	public boolean getReportXmlIsNotNull()
	{
		return this.reportxml != null;
	}
	public String getReportXml()
	{
		return this.reportxml;
	}
	public static int getReportXmlMaxLength()
	{
		return 200000;
	}
	public void setReportXml(String value)
	{
		this.isValidated = false;
		this.reportxml = value;
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
		if(this.reportname == null || this.reportname.length() == 0)
			listOfErrors.add("reportName is mandatory");
		else if(this.reportname.length() > 255)
			listOfErrors.add("The length of the field [reportname] in the value object [ims.admin.vo.SystemReportVo] is too big. It should be less or equal to 255");
		if(this.reportdescription != null)
			if(this.reportdescription.length() > 255)
				listOfErrors.add("The length of the field [reportdescription] in the value object [ims.admin.vo.SystemReportVo] is too big. It should be less or equal to 255");
		if(this.exportfilename != null)
			if(this.exportfilename.length() > 255)
				listOfErrors.add("The length of the field [exportfilename] in the value object [ims.admin.vo.SystemReportVo] is too big. It should be less or equal to 255");
		if(this.queryeditable == null)
			listOfErrors.add("QueryEditable is mandatory");
		if(this.templateeditable == null)
			listOfErrors.add("TemplateEditable is mandatory");
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
	
		SystemReportVo clone = new SystemReportVo(this.id, this.version);
		
		clone.reportname = this.reportname;
		clone.reportdescription = this.reportdescription;
		clone.isactive = this.isactive;
		clone.imsid = this.imsid;
		clone.exportfilename = this.exportfilename;
		clone.queryeditable = this.queryeditable;
		clone.templateeditable = this.templateeditable;
		if(this.lastdeployment == null)
			clone.lastdeployment = null;
		else
			clone.lastdeployment = (ims.framework.utils.DateTime)this.lastdeployment.clone();
		if(this.lastupdated == null)
			clone.lastupdated = null;
		else
			clone.lastupdated = (ims.framework.utils.DateTime)this.lastupdated.clone();
		if(this.templates == null)
			clone.templates = null;
		else
			clone.templates = (ims.core.vo.TemplateBoLiteVoCollection)this.templates.clone();
		clone.reportxml = this.reportxml;
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
		if (!(SystemReportVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SystemReportVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SystemReportVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SystemReportVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.isactive != null)
			count++;
		if(this.imsid != null)
			count++;
		if(this.exportfilename != null)
			count++;
		if(this.queryeditable != null)
			count++;
		if(this.templateeditable != null)
			count++;
		if(this.lastdeployment != null)
			count++;
		if(this.lastupdated != null)
			count++;
		if(this.templates != null)
			count++;
		if(this.reportxml != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected Boolean isactive;
	protected Integer imsid;
	protected String exportfilename;
	protected Boolean queryeditable;
	protected Boolean templateeditable;
	protected ims.framework.utils.DateTime lastdeployment;
	protected ims.framework.utils.DateTime lastupdated;
	protected ims.core.vo.TemplateBoLiteVoCollection templates;
	protected String reportxml;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
