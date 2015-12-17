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
 * Linked to core.resource.place.School business object (ID: 1007100014).
 */
public class SchoolVo extends ims.core.vo.SchoolShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SchoolVo()
	{
	}
	public SchoolVo(Integer id, int version)
	{
		super(id, version);
	}
	public SchoolVo(ims.core.vo.beans.SchoolVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.schoolname = bean.getSchoolName();
		this.location = bean.getLocation();
		this.phonenumber = bean.getPhoneNumber();
		this.sector = bean.getSector() == null ? null : bean.getSector().buildVo();
		this.isactive = bean.getIsActive();
		this.uppercasename = bean.getUpperCaseName();
		this.externalmappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getExternalMappings());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.SchoolVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.schoolname = bean.getSchoolName();
		this.location = bean.getLocation();
		this.phonenumber = bean.getPhoneNumber();
		this.sector = bean.getSector() == null ? null : bean.getSector().buildVo(map);
		this.isactive = bean.getIsActive();
		this.uppercasename = bean.getUpperCaseName();
		this.externalmappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getExternalMappings());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.SchoolVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.SchoolVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.SchoolVoBean();
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
		if(fieldName.equals("UPPERCASENAME"))
			return getUpperCaseName();
		if(fieldName.equals("EXTERNALMAPPINGS"))
			return getExternalMappings();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUpperCaseNameIsNotNull()
	{
		return this.uppercasename != null;
	}
	public String getUpperCaseName()
	{
		return this.uppercasename;
	}
	public static int getUpperCaseNameMaxLength()
	{
		return 50;
	}
	public void setUpperCaseName(String value)
	{
		this.isValidated = false;
		this.uppercasename = value;
	}
	public boolean getExternalMappingsIsNotNull()
	{
		return this.externalmappings != null;
	}
	public ims.core.vo.TaxonomyMapCollection getExternalMappings()
	{
		return this.externalmappings;
	}
	public void setExternalMappings(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.externalmappings = value;
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
		if(this.externalmappings != null)
		{
			if(!this.externalmappings.isValidated())
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
		if(this.schoolname == null || this.schoolname.length() == 0)
			listOfErrors.add("School Name is mandatory");
		else if(this.schoolname.length() > 50)
			listOfErrors.add("The length of the field [schoolname] in the value object [ims.core.vo.SchoolVo] is too big. It should be less or equal to 50");
		if(this.location != null)
			if(this.location.length() > 50)
				listOfErrors.add("The length of the field [location] in the value object [ims.core.vo.SchoolVo] is too big. It should be less or equal to 50");
		if(this.phonenumber != null)
			if(this.phonenumber.length() > 20)
				listOfErrors.add("The length of the field [phonenumber] in the value object [ims.core.vo.SchoolVo] is too big. It should be less or equal to 20");
		if(this.sector == null)
			listOfErrors.add("Sector is mandatory");
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
		if(this.uppercasename == null || this.uppercasename.length() == 0)
			listOfErrors.add("School Name is mandatory");
		else if(this.uppercasename.length() > 50)
			listOfErrors.add("The length of the field [uppercasename] in the value object [ims.core.vo.SchoolVo] is too big. It should be less or equal to 50");
		if(this.externalmappings != null)
		{
			String[] listOfOtherErrors = this.externalmappings.validate();
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
	
		SchoolVo clone = new SchoolVo(this.id, this.version);
		
		clone.schoolname = this.schoolname;
		clone.location = this.location;
		clone.phonenumber = this.phonenumber;
		if(this.sector == null)
			clone.sector = null;
		else
			clone.sector = (ims.core.vo.LocationLiteVo)this.sector.clone();
		clone.isactive = this.isactive;
		clone.uppercasename = this.uppercasename;
		if(this.externalmappings == null)
			clone.externalmappings = null;
		else
			clone.externalmappings = (ims.core.vo.TaxonomyMapCollection)this.externalmappings.clone();
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
		if (!(SchoolVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SchoolVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SchoolVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SchoolVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.uppercasename != null)
			count++;
		if(this.externalmappings != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected String uppercasename;
	protected ims.core.vo.TaxonomyMapCollection externalmappings;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
