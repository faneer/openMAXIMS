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

package ims.nursing.vo;


public class ContactFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ContactFilterVo()
	{
	}
	public ContactFilterVo(ims.nursing.vo.beans.ContactFilterVoBean bean)
	{
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo();
		this.active = bean.getActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.ContactFilterVoBean bean)
	{
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo(map);
		this.active = bean.getActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.ContactFilterVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.ContactFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.ContactFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getDisciplineIsNotNull()
	{
		return this.discipline != null;
	}
	public ims.core.vo.lookups.HcpDisType getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.discipline = value;
	}
	public boolean getHcpIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.Hcp getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.hcp = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof ContactFilterVo))
			return false;
		ContactFilterVo compareObj = (ContactFilterVo)obj;
		if(this.getDiscipline() == null && compareObj.getDiscipline() != null)
			return false;
		if(this.getDiscipline() != null && compareObj.getDiscipline() == null)
			return false;
		if(this.getDiscipline() != null && compareObj.getDiscipline() != null)
			if(!this.getDiscipline().equals(compareObj.getDiscipline()))
				return false;
		if(this.getHcp() == null && compareObj.getHcp() != null)
			return false;
		if(this.getHcp() != null && compareObj.getHcp() == null)
			return false;
		if(this.getHcp() != null && compareObj.getHcp() != null)
			if(!this.getHcp().equals(compareObj.getHcp()))
				return false;
		if(this.getActive() == null && compareObj.getActive() != null)
			return false;
		if(this.getActive() != null && compareObj.getActive() == null)
			return false;
		if(this.getActive() != null && compareObj.getActive() != null)
			return this.getActive().equals(compareObj.getActive());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ContactFilterVo clone = new ContactFilterVo();
		
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.lookups.HcpDisType)this.discipline.clone();
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.Hcp)this.hcp.clone();
		clone.active = this.active;
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
		if (!(ContactFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ContactFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ContactFilterVo compareObj = (ContactFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDiscipline() == null && compareObj.getDiscipline() != null)
				return -1;
			if(this.getDiscipline() != null && compareObj.getDiscipline() == null)
				return 1;
			if(this.getDiscipline() != null && compareObj.getDiscipline() != null)
				retVal = this.getDiscipline().compareTo(compareObj.getDiscipline());
		}
		if (retVal == 0)
		{
			if(this.getHcp() == null && compareObj.getHcp() != null)
				return -1;
			if(this.getHcp() != null && compareObj.getHcp() == null)
				return 1;
			if(this.getHcp() != null && compareObj.getHcp() != null)
				retVal = this.getHcp().compareTo(compareObj.getHcp());
		}
		if (retVal == 0)
		{
			if(this.getActive() == null && compareObj.getActive() != null)
				return -1;
			if(this.getActive() != null && compareObj.getActive() == null)
				return 1;
			if(this.getActive() != null && compareObj.getActive() != null)
				retVal = this.getActive().compareTo(compareObj.getActive());
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
		if(this.discipline != null)
			count++;
		if(this.hcp != null)
			count++;
		if(this.active != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.HcpDisType discipline;
	protected ims.core.vo.Hcp hcp;
	protected Boolean active;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
