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

package ims.core.vo;

/**
 * Linked to core.clinical.Allergen business object (ID: 1003100018).
 */
public class AllergenVo extends ims.core.clinical.vo.AllergenRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IGenericItem
{
	private static final long serialVersionUID = 1L;

	public AllergenVo()
	{
	}
	public AllergenVo(Integer id, int version)
	{
		super(id, version);
	}
	public AllergenVo(ims.core.vo.beans.AllergenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergenname = bean.getAllergenName();
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.isactive = bean.getIsActive();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AllergenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergenname = bean.getAllergenName();
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.isactive = bean.getIsActive();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AllergenVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AllergenVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AllergenVoBean();
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
		if(fieldName.equals("ALLERGENNAME"))
			return getAllergenName();
		if(fieldName.equals("ALLERGENTYPE"))
			return getAllergenType();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAllergenNameIsNotNull()
	{
		return this.allergenname != null;
	}
	public String getAllergenName()
	{
		return this.allergenname;
	}
	public static int getAllergenNameMaxLength()
	{
		return 255;
	}
	public void setAllergenName(String value)
	{
		this.isValidated = false;
		this.allergenname = value;
	}
	public boolean getAllergenTypeIsNotNull()
	{
		return this.allergentype != null;
	}
	public ims.core.vo.lookups.AllergenType getAllergenType()
	{
		return this.allergentype;
	}
	public void setAllergenType(ims.core.vo.lookups.AllergenType value)
	{
		this.isValidated = false;
		this.allergentype = value;
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
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
	}
	/**
	* IGenericItem methods
	*/
	public String getIGenericItemInfoName()
	{
		return getAllergenName();
	}
	
	public void setIGenericItemName(String cciName)
	{
		setAllergenName(cciName);
	}
	
	public Boolean getIGenericItemInfoIsActive()
	{
		return getIsActive();
	}
	
	public void setIGenericItemIsActive(Boolean cciIsActive)
	{
		setIsActive(cciIsActive);
	}
	
	public Integer getIGenericItemInfoID()
	{
		return this.getID_Allergen();
	}
	/**
	* IClinicalCodingValue Methods
	*/
	public ims.clinical.vo.lookups.CodingItemType getCodingItemType() 
	{
		return ims.clinical.vo.lookups.CodingItemType.ALLERGY;
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
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
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
		if(this.allergenname == null || this.allergenname.length() == 0)
			listOfErrors.add("Allergen is a mandatory field");
		else if(this.allergenname.length() > 255)
			listOfErrors.add("The length of the field [allergenname] in the value object [ims.core.vo.AllergenVo] is too big. It should be less or equal to 255");
		if(this.taxonomymap != null)
		{
			String[] listOfOtherErrors = this.taxonomymap.validate();
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
	
		AllergenVo clone = new AllergenVo(this.id, this.version);
		
		clone.allergenname = this.allergenname;
		if(this.allergentype == null)
			clone.allergentype = null;
		else
			clone.allergentype = (ims.core.vo.lookups.AllergenType)this.allergentype.clone();
		clone.isactive = this.isactive;
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
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
		if (!(AllergenVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AllergenVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AllergenVo compareObj = (AllergenVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAllergenName() == null && compareObj.getAllergenName() != null)
				return -1;
			if(this.getAllergenName() != null && compareObj.getAllergenName() == null)
				return 1;
			if(this.getAllergenName() != null && compareObj.getAllergenName() != null)
			{
				if(caseInsensitive)
					retVal = this.getAllergenName().toLowerCase().compareTo(compareObj.getAllergenName().toLowerCase());
				else
					retVal = this.getAllergenName().compareTo(compareObj.getAllergenName());
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
		int count = 0;
		if(this.allergenname != null)
			count++;
		if(this.allergentype != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.taxonomymap != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String allergenname;
	protected ims.core.vo.lookups.AllergenType allergentype;
	protected Boolean isactive;
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
