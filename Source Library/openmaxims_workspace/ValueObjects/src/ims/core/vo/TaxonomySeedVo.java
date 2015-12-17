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
 * Linked to core.admin.TaxonomySeed business object (ID: 1004100054).
 */
public class TaxonomySeedVo extends ims.core.admin.vo.TaxonomySeedRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TaxonomySeedVo()
	{
	}
	public TaxonomySeedVo(Integer id, int version)
	{
		super(id, version);
	}
	public TaxonomySeedVo(ims.core.vo.beans.TaxonomySeedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.lookupinstanceid = bean.getLookupInstanceId();
		this.extsystem = bean.getExtSystem();
		this.extcode = bean.getExtCode();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.TaxonomySeedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.lookupinstanceid = bean.getLookupInstanceId();
		this.extsystem = bean.getExtSystem();
		this.extcode = bean.getExtCode();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.TaxonomySeedVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.TaxonomySeedVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.TaxonomySeedVoBean();
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
		if(fieldName.equals("LOOKUPINSTANCEID"))
			return getLookupInstanceId();
		if(fieldName.equals("EXTSYSTEM"))
			return getExtSystem();
		if(fieldName.equals("EXTCODE"))
			return getExtCode();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLookupInstanceIdIsNotNull()
	{
		return this.lookupinstanceid != null;
	}
	public Integer getLookupInstanceId()
	{
		return this.lookupinstanceid;
	}
	public void setLookupInstanceId(Integer value)
	{
		this.isValidated = false;
		this.lookupinstanceid = value;
	}
	public boolean getExtSystemIsNotNull()
	{
		return this.extsystem != null;
	}
	public String getExtSystem()
	{
		return this.extsystem;
	}
	public static int getExtSystemMaxLength()
	{
		return 100;
	}
	public void setExtSystem(String value)
	{
		this.isValidated = false;
		this.extsystem = value;
	}
	public boolean getExtCodeIsNotNull()
	{
		return this.extcode != null;
	}
	public String getExtCode()
	{
		return this.extcode;
	}
	public static int getExtCodeMaxLength()
	{
		return 30;
	}
	public void setExtCode(String value)
	{
		this.isValidated = false;
		this.extcode = value;
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
		if(this.extsystem != null)
			if(this.extsystem.length() > 100)
				listOfErrors.add("The length of the field [extsystem] in the value object [ims.core.vo.TaxonomySeedVo] is too big. It should be less or equal to 100");
		if(this.extcode != null)
			if(this.extcode.length() > 30)
				listOfErrors.add("The length of the field [extcode] in the value object [ims.core.vo.TaxonomySeedVo] is too big. It should be less or equal to 30");
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
	
		TaxonomySeedVo clone = new TaxonomySeedVo(this.id, this.version);
		
		clone.lookupinstanceid = this.lookupinstanceid;
		clone.extsystem = this.extsystem;
		clone.extcode = this.extcode;
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
		if (!(TaxonomySeedVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TaxonomySeedVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TaxonomySeedVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TaxonomySeedVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.lookupinstanceid != null)
			count++;
		if(this.extsystem != null)
			count++;
		if(this.extcode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected Integer lookupinstanceid;
	protected String extsystem;
	protected String extcode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
