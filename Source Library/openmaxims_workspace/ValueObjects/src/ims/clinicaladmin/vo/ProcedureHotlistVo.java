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

package ims.clinicaladmin.vo;

/**
 * Linked to clinical.configuration.ProcedureHotlist business object (ID: 1073100010).
 */
public class ProcedureHotlistVo extends ims.clinicaladmin.vo.ProcedureHotlistShortVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHotlist
{
	private static final long serialVersionUID = 1L;

	public ProcedureHotlistVo()
	{
	}
	public ProcedureHotlistVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProcedureHotlistVo(ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.hotlistitems = ims.clinicaladmin.vo.ProcedureHotlistItemVoCollection.buildFromBeanCollection(bean.getHotlistItems());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.hotlistitems = ims.clinicaladmin.vo.ProcedureHotlistItemVoCollection.buildFromBeanCollection(bean.getHotlistItems());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean();
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
		if(fieldName.equals("HOTLISTITEMS"))
			return getHotlistItems();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHotlistItemsIsNotNull()
	{
		return this.hotlistitems != null;
	}
	public ims.clinicaladmin.vo.ProcedureHotlistItemVoCollection getHotlistItems()
	{
		return this.hotlistitems;
	}
	public void setHotlistItems(ims.clinicaladmin.vo.ProcedureHotlistItemVoCollection value)
	{
		this.isValidated = false;
		this.hotlistitems = value;
	}
	/**
	* list the Procedures associated with this object
	*/
	public ims.core.vo.ProcedureLiteVoCollection listProcedures()
	{
		ims.core.vo.ProcedureLiteVoCollection voCollExistingProcedures = new ims.core.vo.ProcedureLiteVoCollection();
		if (this.getHotlistItems() != null)
		{
			for (int x=0; x < this.getHotlistItems().size();x++)
				voCollExistingProcedures.add(this.getHotlistItems().get(x).getProcedure());
		}
		return voCollExistingProcedures;
	}
	/**
	* IHotlist
	*/
	public ims.vo.interfaces.IHotlistItem[] getIHotlistItems() 
	{
		return this.getHotlistItems().toIHotlistItemArray();
	}
	
	public void removeIHotlistItem(ims.vo.interfaces.IHotlistItem iHotlistItem) 
	{
		this.getHotlistItems().remove((ProcedureHotlistItemVo)iHotlistItem);
	}
	
	public void addIHotlistItem(ims.vo.interfaces.IGenericItemInfo cciItem) 
	{
		ProcedureHotlistItemVo newItem = new ProcedureHotlistItemVo();
		newItem.setProcedure((ims.core.vo.ProcedureLiteVo)cciItem);
		this.getHotlistItems().add(newItem);
	}
	
	public void setIHotlistItems(ims.vo.interfaces.IHotlistItem[] iHotlistItems) 
	{
		if (iHotlistItems == null)
			return;
		
		ProcedureHotlistItemVoCollection voColl = new ProcedureHotlistItemVoCollection();
		for (int i = 0; i < iHotlistItems.length; i++)
		{
			voColl.add((ProcedureHotlistItemVo)iHotlistItems[i]);
		}
		this.setHotlistItems(voColl);
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
		if(this.hotlistitems != null)
		{
			if(!this.hotlistitems.isValidated())
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
		if(this.hotlistitems != null)
		{
			String[] listOfOtherErrors = this.hotlistitems.validate();
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
	
		ProcedureHotlistVo clone = new ProcedureHotlistVo(this.id, this.version);
		
		clone.isglobal = this.isglobal;
		clone.user = this.user;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.hotlistitems == null)
			clone.hotlistitems = null;
		else
			clone.hotlistitems = (ims.clinicaladmin.vo.ProcedureHotlistItemVoCollection)this.hotlistitems.clone();
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
		if (!(ProcedureHotlistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProcedureHotlistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ProcedureHotlistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ProcedureHotlistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.hotlistitems != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.clinicaladmin.vo.ProcedureHotlistItemVoCollection hotlistitems;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
