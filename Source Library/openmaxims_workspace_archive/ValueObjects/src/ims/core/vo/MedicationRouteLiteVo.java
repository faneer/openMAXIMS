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
 * Linked to core.clinical.MedicationRoute business object (ID: 1003100113).
 */
public class MedicationRouteLiteVo extends ims.core.clinical.vo.MedicationRouteRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MedicationRouteLiteVo()
	{
	}
	public MedicationRouteLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public MedicationRouteLiteVo(ims.core.vo.beans.MedicationRouteLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.MedicationRouteLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.MedicationRouteLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.MedicationRouteLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.MedicationRouteLiteVoBean();
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
		if(fieldName.equals("ROUTE"))
			return getRoute();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRouteIsNotNull()
	{
		return this.route != null;
	}
	public ims.core.vo.lookups.MedicationRoute getRoute()
	{
		return this.route;
	}
	public void setRoute(ims.core.vo.lookups.MedicationRoute value)
	{
		this.isValidated = false;
		this.route = value;
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
		if(this.route == null)
			listOfErrors.add("Route is mandatory");
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
	
		MedicationRouteLiteVo clone = new MedicationRouteLiteVo(this.id, this.version);
		
		if(this.route == null)
			clone.route = null;
		else
			clone.route = (ims.core.vo.lookups.MedicationRoute)this.route.clone();
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
		if (!(MedicationRouteLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MedicationRouteLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((MedicationRouteLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((MedicationRouteLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.route != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.core.vo.lookups.MedicationRoute route;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
