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

package ims.spinalinjuries.vo;

/**
 * Linked to spinalinjuries.Shared.RespLungFields business object (ID: 1024100003).
 */
public class RespExamLungF extends ims.spinalinjuries.shared.vo.RespLungFieldsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RespExamLungF()
	{
	}
	public RespExamLungF(Integer id, int version)
	{
		super(id, version);
	}
	public RespExamLungF(ims.spinalinjuries.vo.beans.RespExamLungFBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.lungfield = bean.getLungField() == null ? null : ims.spinalinjuries.vo.lookups.RespExamLungFields.buildLookup(bean.getLungField());
		this.isdecreased = bean.getIsDecreased();
		this.isabsent = bean.getIsAbsent();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.beans.RespExamLungFBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.lungfield = bean.getLungField() == null ? null : ims.spinalinjuries.vo.lookups.RespExamLungFields.buildLookup(bean.getLungField());
		this.isdecreased = bean.getIsDecreased();
		this.isabsent = bean.getIsAbsent();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.beans.RespExamLungFBean bean = null;
		if(map != null)
			bean = (ims.spinalinjuries.vo.beans.RespExamLungFBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.spinalinjuries.vo.beans.RespExamLungFBean();
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
		if(fieldName.equals("LUNGFIELD"))
			return getLungField();
		if(fieldName.equals("ISDECREASED"))
			return getIsDecreased();
		if(fieldName.equals("ISABSENT"))
			return getIsAbsent();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLungFieldIsNotNull()
	{
		return this.lungfield != null;
	}
	public ims.spinalinjuries.vo.lookups.RespExamLungFields getLungField()
	{
		return this.lungfield;
	}
	public void setLungField(ims.spinalinjuries.vo.lookups.RespExamLungFields value)
	{
		this.isValidated = false;
		this.lungfield = value;
	}
	public boolean getIsDecreasedIsNotNull()
	{
		return this.isdecreased != null;
	}
	public Boolean getIsDecreased()
	{
		return this.isdecreased;
	}
	public void setIsDecreased(Boolean value)
	{
		this.isValidated = false;
		this.isdecreased = value;
	}
	public boolean getIsAbsentIsNotNull()
	{
		return this.isabsent != null;
	}
	public Boolean getIsAbsent()
	{
		return this.isabsent;
	}
	public void setIsAbsent(Boolean value)
	{
		this.isValidated = false;
		this.isabsent = value;
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
	
		RespExamLungF clone = new RespExamLungF(this.id, this.version);
		
		if(this.lungfield == null)
			clone.lungfield = null;
		else
			clone.lungfield = (ims.spinalinjuries.vo.lookups.RespExamLungFields)this.lungfield.clone();
		clone.isdecreased = this.isdecreased;
		clone.isabsent = this.isabsent;
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
		if (!(RespExamLungF.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RespExamLungF object cannot be compared an Object of type " + obj.getClass().getName());
		}
		RespExamLungF compareObj = (RespExamLungF)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_RespLungFields() == null && compareObj.getID_RespLungFields() != null)
				return -1;
			if(this.getID_RespLungFields() != null && compareObj.getID_RespLungFields() == null)
				return 1;
			if(this.getID_RespLungFields() != null && compareObj.getID_RespLungFields() != null)
				retVal = this.getID_RespLungFields().compareTo(compareObj.getID_RespLungFields());
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
		if(this.lungfield != null)
			count++;
		if(this.isdecreased != null)
			count++;
		if(this.isabsent != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.spinalinjuries.vo.lookups.RespExamLungFields lungfield;
	protected Boolean isdecreased;
	protected Boolean isabsent;
	private boolean isValidated = false;
	private boolean isBusy = false;
}