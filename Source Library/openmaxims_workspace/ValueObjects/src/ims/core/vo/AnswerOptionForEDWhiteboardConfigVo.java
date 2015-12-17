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
 * Linked to core.clinical.AnswerOption business object (ID: 1003100046).
 */
public class AnswerOptionForEDWhiteboardConfigVo extends ims.core.clinical.vo.AnswerOptionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AnswerOptionForEDWhiteboardConfigVo()
	{
	}
	public AnswerOptionForEDWhiteboardConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public AnswerOptionForEDWhiteboardConfigVo(ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.optiontext = bean.getOptionText();
		this.optiondescription = bean.getOptionDescription();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.optiontext = bean.getOptionText();
		this.optiondescription = bean.getOptionDescription();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean();
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
		if(fieldName.equals("OPTIONTEXT"))
			return getOptionText();
		if(fieldName.equals("OPTIONDESCRIPTION"))
			return getOptionDescription();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOptionTextIsNotNull()
	{
		return this.optiontext != null;
	}
	public String getOptionText()
	{
		return this.optiontext;
	}
	public static int getOptionTextMaxLength()
	{
		return 200;
	}
	public void setOptionText(String value)
	{
		this.isValidated = false;
		this.optiontext = value;
	}
	public boolean getOptionDescriptionIsNotNull()
	{
		return this.optiondescription != null;
	}
	public String getOptionDescription()
	{
		return this.optiondescription;
	}
	public static int getOptionDescriptionMaxLength()
	{
		return 250;
	}
	public void setOptionDescription(String value)
	{
		this.isValidated = false;
		this.optiondescription = value;
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
		if(this.optiontext == null || this.optiontext.length() == 0)
			listOfErrors.add("OptionText is mandatory");
		else if(this.optiontext.length() > 200)
			listOfErrors.add("The length of the field [optiontext] in the value object [ims.core.vo.AnswerOptionForEDWhiteboardConfigVo] is too big. It should be less or equal to 200");
		if(this.optiondescription != null)
			if(this.optiondescription.length() > 250)
				listOfErrors.add("The length of the field [optiondescription] in the value object [ims.core.vo.AnswerOptionForEDWhiteboardConfigVo] is too big. It should be less or equal to 250");
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
	
		AnswerOptionForEDWhiteboardConfigVo clone = new AnswerOptionForEDWhiteboardConfigVo(this.id, this.version);
		
		clone.optiontext = this.optiontext;
		clone.optiondescription = this.optiondescription;
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
		if (!(AnswerOptionForEDWhiteboardConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AnswerOptionForEDWhiteboardConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AnswerOptionForEDWhiteboardConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AnswerOptionForEDWhiteboardConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.optiontext != null)
			count++;
		if(this.optiondescription != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String optiontext;
	protected String optiondescription;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
