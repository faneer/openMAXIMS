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
public class ReportVo extends ims.admin.vo.ReportLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReportVo()
	{
	}
	public ReportVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReportVo(ims.admin.vo.beans.ReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.reportdescription = bean.getReportDescription();
		this.isactive = bean.getIsActive();
		this.reportxml = bean.getReportXml();
		this.templates = ims.admin.vo.ReportTemplateVoCollection.buildFromBeanCollection(bean.getTemplates());
		this.seeds = ims.admin.vo.ReportSeedVoCollection.buildFromBeanCollection(bean.getSeeds());
		this.imsid = bean.getImsId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.ReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.reportdescription = bean.getReportDescription();
		this.isactive = bean.getIsActive();
		this.reportxml = bean.getReportXml();
		this.templates = ims.admin.vo.ReportTemplateVoCollection.buildFromBeanCollection(bean.getTemplates());
		this.seeds = ims.admin.vo.ReportSeedVoCollection.buildFromBeanCollection(bean.getSeeds());
		this.imsid = bean.getImsId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.ReportVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.ReportVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.ReportVoBean();
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
		if(fieldName.equals("REPORTXML"))
			return getReportXml();
		if(fieldName.equals("TEMPLATES"))
			return getTemplates();
		if(fieldName.equals("SEEDS"))
			return getSeeds();
		if(fieldName.equals("IMSID"))
			return getImsId();
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
	public boolean getTemplatesIsNotNull()
	{
		return this.templates != null;
	}
	public ims.admin.vo.ReportTemplateVoCollection getTemplates()
	{
		return this.templates;
	}
	public void setTemplates(ims.admin.vo.ReportTemplateVoCollection value)
	{
		this.isValidated = false;
		this.templates = value;
	}
	public boolean getSeedsIsNotNull()
	{
		return this.seeds != null;
	}
	public ims.admin.vo.ReportSeedVoCollection getSeeds()
	{
		return this.seeds;
	}
	public void setSeeds(ims.admin.vo.ReportSeedVoCollection value)
	{
		this.isValidated = false;
		this.seeds = value;
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
		if(this.templates != null)
		{
			if(!this.templates.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.seeds != null)
		{
			if(!this.seeds.isValidated())
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
		if(this.reportname == null || this.reportname.length() == 0)
			listOfErrors.add("reportName is mandatory");
		else if(this.reportname.length() > 255)
			listOfErrors.add("The length of the field [reportname] in the value object [ims.admin.vo.ReportVo] is too big. It should be less or equal to 255");
		if(this.reportdescription != null)
			if(this.reportdescription.length() > 255)
				listOfErrors.add("The length of the field [reportdescription] in the value object [ims.admin.vo.ReportVo] is too big. It should be less or equal to 255");
		if(this.templates != null)
		{
			String[] listOfOtherErrors = this.templates.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.seeds != null)
		{
			String[] listOfOtherErrors = this.seeds.validate();
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
	
		ReportVo clone = new ReportVo(this.id, this.version);
		
		clone.reportname = this.reportname;
		clone.reportdescription = this.reportdescription;
		clone.isactive = this.isactive;
		clone.reportxml = this.reportxml;
		if(this.templates == null)
			clone.templates = null;
		else
			clone.templates = (ims.admin.vo.ReportTemplateVoCollection)this.templates.clone();
		if(this.seeds == null)
			clone.seeds = null;
		else
			clone.seeds = (ims.admin.vo.ReportSeedVoCollection)this.seeds.clone();
		clone.imsid = this.imsid;
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
		if (!(ReportVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReportVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ReportVo compareObj = (ReportVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getReportName() == null && compareObj.getReportName() != null)
				return -1;
			if(this.getReportName() != null && compareObj.getReportName() == null)
				return 1;
			if(this.getReportName() != null && compareObj.getReportName() != null)
			{
				if(caseInsensitive)
					retVal = this.getReportName().toLowerCase().compareTo(compareObj.getReportName().toLowerCase());
				else
					retVal = this.getReportName().compareTo(compareObj.getReportName());
			}
		}
		return retVal;
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
		if(this.reportxml != null)
			count++;
		if(this.templates != null)
			count++;
		if(this.seeds != null)
			count++;
		if(this.imsid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected Boolean isactive;
	protected String reportxml;
	protected ims.admin.vo.ReportTemplateVoCollection templates;
	protected ims.admin.vo.ReportSeedVoCollection seeds;
	protected Integer imsid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
