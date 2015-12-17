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

/**
 * Linked to clinical.configuration.ClinicalProblem business object (ID: 1073100005).
 */
public class ClinicalProblemVo extends ims.clinical.configuration.vo.ClinicalProblemRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalProblemVo()
	{
	}
	public ClinicalProblemVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalProblemVo(ims.clinical.vo.beans.ClinicalProblemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pcname = bean.getPCName();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ClinicalProblemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pcname = bean.getPCName();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ClinicalProblemVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ClinicalProblemVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ClinicalProblemVoBean();
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
		if(fieldName.equals("PCNAME"))
			return getPCName();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPCNameIsNotNull()
	{
		return this.pcname != null;
	}
	public String getPCName()
	{
		return this.pcname;
	}
	public static int getPCNameMaxLength()
	{
		return 255;
	}
	public void setPCName(String value)
	{
		this.isValidated = false;
		this.pcname = value;
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
		if(this.pcname == null || this.pcname.length() == 0)
			listOfErrors.add("PCName is mandatory");
		else if(this.pcname.length() > 255)
			listOfErrors.add("The length of the field [pcname] in the value object [ims.clinical.vo.ClinicalProblemVo] is too big. It should be less or equal to 255");
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
	
		ClinicalProblemVo clone = new ClinicalProblemVo(this.id, this.version);
		
		clone.pcname = this.pcname;
		clone.isactive = this.isactive;
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
		if (!(ClinicalProblemVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalProblemVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalProblemVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalProblemVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pcname != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String pcname;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
