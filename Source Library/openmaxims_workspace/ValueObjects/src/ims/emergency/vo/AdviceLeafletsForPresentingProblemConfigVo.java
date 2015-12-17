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

package ims.emergency.vo;

/**
 * Linked to emergency.Configuration.AdviceLeafletsConfig business object (ID: 1087100013).
 */
public class AdviceLeafletsForPresentingProblemConfigVo extends ims.emergency.configuration.vo.AdviceLeafletsConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdviceLeafletsForPresentingProblemConfigVo()
	{
	}
	public AdviceLeafletsForPresentingProblemConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdviceLeafletsForPresentingProblemConfigVo(ims.emergency.vo.beans.AdviceLeafletsForPresentingProblemConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo();
		this.problems = ims.clinical.vo.ClinicalProblemShortVoCollection.buildFromBeanCollection(bean.getProblems());
		this.isgenericadviceleaflet = bean.getIsGenericAdviceLeaflet();
		this.adviceleafletname = bean.getAdviceLeafletName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.AdviceLeafletsForPresentingProblemConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo(map);
		this.problems = ims.clinical.vo.ClinicalProblemShortVoCollection.buildFromBeanCollection(bean.getProblems());
		this.isgenericadviceleaflet = bean.getIsGenericAdviceLeaflet();
		this.adviceleafletname = bean.getAdviceLeafletName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.AdviceLeafletsForPresentingProblemConfigVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.AdviceLeafletsForPresentingProblemConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.AdviceLeafletsForPresentingProblemConfigVoBean();
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
		if(fieldName.equals("TEMPLATE"))
			return getTemplate();
		if(fieldName.equals("PROBLEMS"))
			return getProblems();
		if(fieldName.equals("ISGENERICADVICELEAFLET"))
			return getIsGenericAdviceLeaflet();
		if(fieldName.equals("ADVICELEAFLETNAME"))
			return getAdviceLeafletName();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTemplateIsNotNull()
	{
		return this.template != null;
	}
	public ims.core.vo.TemplateForReportTemplateSearchVo getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.core.vo.TemplateForReportTemplateSearchVo value)
	{
		this.isValidated = false;
		this.template = value;
	}
	public boolean getProblemsIsNotNull()
	{
		return this.problems != null;
	}
	public ims.clinical.vo.ClinicalProblemShortVoCollection getProblems()
	{
		return this.problems;
	}
	public void setProblems(ims.clinical.vo.ClinicalProblemShortVoCollection value)
	{
		this.isValidated = false;
		this.problems = value;
	}
	public boolean getIsGenericAdviceLeafletIsNotNull()
	{
		return this.isgenericadviceleaflet != null;
	}
	public Boolean getIsGenericAdviceLeaflet()
	{
		return this.isgenericadviceleaflet;
	}
	public void setIsGenericAdviceLeaflet(Boolean value)
	{
		this.isValidated = false;
		this.isgenericadviceleaflet = value;
	}
	public boolean getAdviceLeafletNameIsNotNull()
	{
		return this.adviceleafletname != null;
	}
	public String getAdviceLeafletName()
	{
		return this.adviceleafletname;
	}
	public static int getAdviceLeafletNameMaxLength()
	{
		return 100;
	}
	public void setAdviceLeafletName(String value)
	{
		this.isValidated = false;
		this.adviceleafletname = value;
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
		if(this.problems != null)
		{
			if(!this.problems.isValidated())
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
		if(this.problems != null)
		{
			String[] listOfOtherErrors = this.problems.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.adviceleafletname != null)
			if(this.adviceleafletname.length() > 100)
				listOfErrors.add("The length of the field [adviceleafletname] in the value object [ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo] is too big. It should be less or equal to 100");
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
	
		AdviceLeafletsForPresentingProblemConfigVo clone = new AdviceLeafletsForPresentingProblemConfigVo(this.id, this.version);
		
		if(this.template == null)
			clone.template = null;
		else
			clone.template = (ims.core.vo.TemplateForReportTemplateSearchVo)this.template.clone();
		if(this.problems == null)
			clone.problems = null;
		else
			clone.problems = (ims.clinical.vo.ClinicalProblemShortVoCollection)this.problems.clone();
		clone.isgenericadviceleaflet = this.isgenericadviceleaflet;
		clone.adviceleafletname = this.adviceleafletname;
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
		if (!(AdviceLeafletsForPresentingProblemConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdviceLeafletsForPresentingProblemConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AdviceLeafletsForPresentingProblemConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AdviceLeafletsForPresentingProblemConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.template != null)
			count++;
		if(this.problems != null)
			count++;
		if(this.isgenericadviceleaflet != null)
			count++;
		if(this.adviceleafletname != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.TemplateForReportTemplateSearchVo template;
	protected ims.clinical.vo.ClinicalProblemShortVoCollection problems;
	protected Boolean isgenericadviceleaflet;
	protected String adviceleafletname;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
