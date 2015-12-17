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
 * Linked to nursing.EnvironmentalChecklistDetail business object (ID: 1009100019).
 */
public class EnvironmentalChecklistDetailVo extends ims.nursing.vo.EnvironmentalChecklistDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EnvironmentalChecklistDetailVo()
	{
	}
	public EnvironmentalChecklistDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public EnvironmentalChecklistDetailVo(ims.nursing.vo.beans.EnvironmentalChecklistDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.checklisttype = bean.getChecklistType() == null ? null : ims.nursing.vo.lookups.EnvironmentalChecklist.buildLookup(bean.getChecklistType());
		this.answer = bean.getAnswer() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAnswer());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.EnvironmentalChecklistDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.checklisttype = bean.getChecklistType() == null ? null : ims.nursing.vo.lookups.EnvironmentalChecklist.buildLookup(bean.getChecklistType());
		this.answer = bean.getAnswer() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAnswer());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.EnvironmentalChecklistDetailVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.EnvironmentalChecklistDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.EnvironmentalChecklistDetailVoBean();
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
		if(fieldName.equals("CHECKLISTTYPE"))
			return getChecklistType();
		if(fieldName.equals("ANSWER"))
			return getAnswer();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getChecklistTypeIsNotNull()
	{
		return this.checklisttype != null;
	}
	public ims.nursing.vo.lookups.EnvironmentalChecklist getChecklistType()
	{
		return this.checklisttype;
	}
	public void setChecklistType(ims.nursing.vo.lookups.EnvironmentalChecklist value)
	{
		this.isValidated = false;
		this.checklisttype = value;
	}
	public boolean getAnswerIsNotNull()
	{
		return this.answer != null;
	}
	public ims.core.vo.lookups.YesNo getAnswer()
	{
		return this.answer;
	}
	public void setAnswer(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.answer = value;
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
		if(this.checklisttype == null)
			listOfErrors.add("ChecklistType is mandatory");
		if(this.answer == null)
			listOfErrors.add("Answer is mandatory");
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
	
		EnvironmentalChecklistDetailVo clone = new EnvironmentalChecklistDetailVo(this.id, this.version);
		
		if(this.checklisttype == null)
			clone.checklisttype = null;
		else
			clone.checklisttype = (ims.nursing.vo.lookups.EnvironmentalChecklist)this.checklisttype.clone();
		if(this.answer == null)
			clone.answer = null;
		else
			clone.answer = (ims.core.vo.lookups.YesNo)this.answer.clone();
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
		if (!(EnvironmentalChecklistDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EnvironmentalChecklistDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EnvironmentalChecklistDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EnvironmentalChecklistDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.checklisttype != null)
			count++;
		if(this.answer != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.nursing.vo.lookups.EnvironmentalChecklist checklisttype;
	protected ims.core.vo.lookups.YesNo answer;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
