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

package ims.clinicaladmin.vo;

/**
 * Linked to clinical.configuration.ProblemHotlist business object (ID: 1073100008).
 */
public class ProblemHotlistVo extends ims.clinicaladmin.vo.ProblemHotlistShortVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHotlist
{
	private static final long serialVersionUID = 1L;

	public ProblemHotlistVo()
	{
	}
	public ProblemHotlistVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProblemHotlistVo(ims.clinicaladmin.vo.beans.ProblemHotlistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.hotlistitems = ims.clinicaladmin.vo.ProblemHotlistItemVoCollection.buildFromBeanCollection(bean.getHotlistItems());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.ProblemHotlistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.hotlistitems = ims.clinicaladmin.vo.ProblemHotlistItemVoCollection.buildFromBeanCollection(bean.getHotlistItems());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.ProblemHotlistVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.ProblemHotlistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.ProblemHotlistVoBean();
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
	public ims.clinicaladmin.vo.ProblemHotlistItemVoCollection getHotlistItems()
	{
		return this.hotlistitems;
	}
	public void setHotlistItems(ims.clinicaladmin.vo.ProblemHotlistItemVoCollection value)
	{
		this.isValidated = false;
		this.hotlistitems = value;
	}
	/**
	* list the Problems associated with this object
	*/
	public ims.clinical.vo.ClinicalProblemShortVoCollection listProblems()
	{
		ims.clinical.vo.ClinicalProblemShortVoCollection voCollExistingProblems = new ims.clinical.vo.ClinicalProblemShortVoCollection();
		if (this.getHotlistItems() != null)
		{
			for (int x=0; x < this.getHotlistItems().size();x++)
				voCollExistingProblems .add(this.getHotlistItems().get(x).getProblem());
		}
		return voCollExistingProblems;
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
		this.getHotlistItems().remove((ProblemHotlistItemVo)iHotlistItem);
	}
	
	public void addIHotlistItem(ims.vo.interfaces.IGenericItemInfo cciItem) 
	{
		ProblemHotlistItemVo newItem = new ProblemHotlistItemVo();
		newItem.setProblem((ims.clinical.vo.ClinicalProblemShortVo)cciItem);
		this.getHotlistItems().add(newItem);
	}
	
	public void setIHotlistItems(ims.vo.interfaces.IHotlistItem[] iHotlistItems) 
	{
		if (iHotlistItems == null)
			return;
		
		ProblemHotlistItemVoCollection voColl = new ProblemHotlistItemVoCollection();
		for (int i = 0; i < iHotlistItems.length; i++)
		{
			voColl.add((ProblemHotlistItemVo)iHotlistItems[i]);
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
	
		ProblemHotlistVo clone = new ProblemHotlistVo(this.id, this.version);
		
		clone.isglobal = this.isglobal;
		clone.user = this.user;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.hotlistitems == null)
			clone.hotlistitems = null;
		else
			clone.hotlistitems = (ims.clinicaladmin.vo.ProblemHotlistItemVoCollection)this.hotlistitems.clone();
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
		if (!(ProblemHotlistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProblemHotlistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ProblemHotlistVo compareObj = (ProblemHotlistVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ProblemHotlist() == null && compareObj.getID_ProblemHotlist() != null)
				return -1;
			if(this.getID_ProblemHotlist() != null && compareObj.getID_ProblemHotlist() == null)
				return 1;
			if(this.getID_ProblemHotlist() != null && compareObj.getID_ProblemHotlist() != null)
				retVal = this.getID_ProblemHotlist().compareTo(compareObj.getID_ProblemHotlist());
		}
		return retVal;
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
	protected ims.clinicaladmin.vo.ProblemHotlistItemVoCollection hotlistitems;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
