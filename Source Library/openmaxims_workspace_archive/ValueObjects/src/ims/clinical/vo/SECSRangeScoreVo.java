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

package ims.clinical.vo;

/**
 * Linked to clinical.configuration.SECSRangeScore business object (ID: 1028100040).
 */
public class SECSRangeScoreVo extends ims.clinical.configuration.vo.SECSRangeScoreRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SECSRangeScoreVo()
	{
	}
	public SECSRangeScoreVo(Integer id, int version)
	{
		super(id, version);
	}
	public SECSRangeScoreVo(ims.clinical.vo.beans.SECSRangeScoreVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.greaterthanintvalue = bean.getGreaterThanIntValue();
		this.lessthanintvalue = bean.getLessThanIntValue();
		this.warningtext = bean.getWarningText();
		this.score = bean.getScore();
		this.greaterthandecvalue = bean.getGreaterThanDecValue();
		this.lessthandecvalue = bean.getLessThanDecValue();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SECSRangeScoreVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.greaterthanintvalue = bean.getGreaterThanIntValue();
		this.lessthanintvalue = bean.getLessThanIntValue();
		this.warningtext = bean.getWarningText();
		this.score = bean.getScore();
		this.greaterthandecvalue = bean.getGreaterThanDecValue();
		this.lessthandecvalue = bean.getLessThanDecValue();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SECSRangeScoreVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SECSRangeScoreVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SECSRangeScoreVoBean();
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
		if(fieldName.equals("GREATERTHANINTVALUE"))
			return getGreaterThanIntValue();
		if(fieldName.equals("LESSTHANINTVALUE"))
			return getLessThanIntValue();
		if(fieldName.equals("WARNINGTEXT"))
			return getWarningText();
		if(fieldName.equals("SCORE"))
			return getScore();
		if(fieldName.equals("GREATERTHANDECVALUE"))
			return getGreaterThanDecValue();
		if(fieldName.equals("LESSTHANDECVALUE"))
			return getLessThanDecValue();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGreaterThanIntValueIsNotNull()
	{
		return this.greaterthanintvalue != null;
	}
	public Integer getGreaterThanIntValue()
	{
		return this.greaterthanintvalue;
	}
	public void setGreaterThanIntValue(Integer value)
	{
		this.isValidated = false;
		this.greaterthanintvalue = value;
	}
	public boolean getLessThanIntValueIsNotNull()
	{
		return this.lessthanintvalue != null;
	}
	public Integer getLessThanIntValue()
	{
		return this.lessthanintvalue;
	}
	public void setLessThanIntValue(Integer value)
	{
		this.isValidated = false;
		this.lessthanintvalue = value;
	}
	public boolean getWarningTextIsNotNull()
	{
		return this.warningtext != null;
	}
	public String getWarningText()
	{
		return this.warningtext;
	}
	public static int getWarningTextMaxLength()
	{
		return 255;
	}
	public void setWarningText(String value)
	{
		this.isValidated = false;
		this.warningtext = value;
	}
	public boolean getScoreIsNotNull()
	{
		return this.score != null;
	}
	public Integer getScore()
	{
		return this.score;
	}
	public void setScore(Integer value)
	{
		this.isValidated = false;
		this.score = value;
	}
	public boolean getGreaterThanDecValueIsNotNull()
	{
		return this.greaterthandecvalue != null;
	}
	public Float getGreaterThanDecValue()
	{
		return this.greaterthandecvalue;
	}
	public void setGreaterThanDecValue(Float value)
	{
		this.isValidated = false;
		this.greaterthandecvalue = value;
	}
	public boolean getLessThanDecValueIsNotNull()
	{
		return this.lessthandecvalue != null;
	}
	public Float getLessThanDecValue()
	{
		return this.lessthandecvalue;
	}
	public void setLessThanDecValue(Float value)
	{
		this.isValidated = false;
		this.lessthandecvalue = value;
	}
	/**
	* toString
	*/
		public String toString()
		{
			StringBuffer str = new StringBuffer();
			if(this.greaterthanintvalue != null)
			{	
				str.append(" > ");
				str.append(this.greaterthanintvalue);
			}
			if(this.lessthanintvalue != null)
			{
				str.append(" < ");
				str.append(this.lessthanintvalue);
			}
			if(this.greaterthandecvalue != null)
			{	
				str.append(" > ");
				str.append(this.greaterthandecvalue);
			}
			if(this.lessthandecvalue != null)
			{
				str.append(" < ");
				str.append(this.lessthandecvalue);
			}
	
			str.append(" Warning Text : ");
			str.append(this.warningtext);
			str.append(" Score : ");
			str.append(this.score);
			return str.toString();
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
		if(this.warningtext != null)
			if(this.warningtext.length() > 255)
				listOfErrors.add("The length of the field [warningtext] in the value object [ims.clinical.vo.SECSRangeScoreVo] is too big. It should be less or equal to 255");
		if(this.score == null)
			listOfErrors.add("Score is mandatory");
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
	
		SECSRangeScoreVo clone = new SECSRangeScoreVo(this.id, this.version);
		
		clone.greaterthanintvalue = this.greaterthanintvalue;
		clone.lessthanintvalue = this.lessthanintvalue;
		clone.warningtext = this.warningtext;
		clone.score = this.score;
		clone.greaterthandecvalue = this.greaterthandecvalue;
		clone.lessthandecvalue = this.lessthandecvalue;
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
		if (!(SECSRangeScoreVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SECSRangeScoreVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SECSRangeScoreVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SECSRangeScoreVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.greaterthanintvalue != null)
			count++;
		if(this.lessthanintvalue != null)
			count++;
		if(this.warningtext != null)
			count++;
		if(this.score != null)
			count++;
		if(this.greaterthandecvalue != null)
			count++;
		if(this.lessthandecvalue != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected Integer greaterthanintvalue;
	protected Integer lessthanintvalue;
	protected String warningtext;
	protected Integer score;
	protected Float greaterthandecvalue;
	protected Float lessthandecvalue;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
