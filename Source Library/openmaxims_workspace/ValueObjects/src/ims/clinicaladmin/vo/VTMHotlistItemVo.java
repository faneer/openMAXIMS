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
 * Linked to clinical.configuration.VTMHotlistItem business object (ID: 1073100026).
 */
public class VTMHotlistItemVo extends ims.clinical.configuration.vo.VTMHotlistItemRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHotlistItem
{
	private static final long serialVersionUID = 1L;

	public VTMHotlistItemVo()
	{
	}
	public VTMHotlistItemVo(Integer id, int version)
	{
		super(id, version);
	}
	public VTMHotlistItemVo(ims.clinicaladmin.vo.beans.VTMHotlistItemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.vtm = bean.getVTM() == null ? null : bean.getVTM().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.VTMHotlistItemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.vtm = bean.getVTM() == null ? null : bean.getVTM().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.VTMHotlistItemVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.VTMHotlistItemVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.VTMHotlistItemVoBean();
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
		if(fieldName.equals("VTM"))
			return getVTM();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getVTMIsNotNull()
	{
		return this.vtm != null;
	}
	public ims.clinical.vo.VTMVo getVTM()
	{
		return this.vtm;
	}
	public void setVTM(ims.clinical.vo.VTMVo value)
	{
		this.isValidated = false;
		this.vtm = value;
	}
	/**
	* IHotlistItem
	*/
		public ims.vo.interfaces.IGenericItem getIGenericItem() 
		{
			return null;
		}
		public Integer getIHotlistItemID() 
		{
			return null;
		}
		public void setIGenericItem(ims.vo.interfaces.IGenericItem genericItem) 
		{
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
		if(this.vtm != null)
		{
			if(!this.vtm.isValidated())
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
		if(this.vtm == null)
			listOfErrors.add("VTM is mandatory");
		if(this.vtm != null)
		{
			String[] listOfOtherErrors = this.vtm.validate();
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
	
		VTMHotlistItemVo clone = new VTMHotlistItemVo(this.id, this.version);
		
		if(this.vtm == null)
			clone.vtm = null;
		else
			clone.vtm = (ims.clinical.vo.VTMVo)this.vtm.clone();
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
		if (!(VTMHotlistItemVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VTMHotlistItemVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((VTMHotlistItemVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((VTMHotlistItemVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.vtm != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.clinical.vo.VTMVo vtm;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
