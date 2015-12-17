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


public class InpatientEpisodeWithCareContextVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InpatientEpisodeWithCareContextVo()
	{
	}
	public InpatientEpisodeWithCareContextVo(ims.clinical.vo.beans.InpatientEpisodeWithCareContextVoBean bean)
	{
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : bean.getInpatientEpisode().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.InpatientEpisodeWithCareContextVoBean bean)
	{
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : bean.getInpatientEpisode().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.InpatientEpisodeWithCareContextVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.InpatientEpisodeWithCareContextVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.InpatientEpisodeWithCareContextVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getInpatientEpisodeIsNotNull()
	{
		return this.inpatientepisode != null;
	}
	public ims.clinical.vo.InpatientEpisodeForHospitalAtNightVo getInpatientEpisode()
	{
		return this.inpatientepisode;
	}
	public void setInpatientEpisode(ims.clinical.vo.InpatientEpisodeForHospitalAtNightVo value)
	{
		this.isValidated = false;
		this.inpatientepisode = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
		if(!(obj instanceof InpatientEpisodeWithCareContextVo))
			return false;
		InpatientEpisodeWithCareContextVo compareObj = (InpatientEpisodeWithCareContextVo)obj;
		if(this.getInpatientEpisode() == null && compareObj.getInpatientEpisode() != null)
			return false;
		if(this.getInpatientEpisode() != null && compareObj.getInpatientEpisode() == null)
			return false;
		if(this.getInpatientEpisode() != null && compareObj.getInpatientEpisode() != null)
			if(!this.getInpatientEpisode().equals(compareObj.getInpatientEpisode()))
				return false;
		if(this.getCareContext() == null && compareObj.getCareContext() != null)
			return false;
		if(this.getCareContext() != null && compareObj.getCareContext() == null)
			return false;
		if(this.getCareContext() != null && compareObj.getCareContext() != null)
			return this.getCareContext().equals(compareObj.getCareContext());
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
	
		InpatientEpisodeWithCareContextVo clone = new InpatientEpisodeWithCareContextVo();
		
		if(this.inpatientepisode == null)
			clone.inpatientepisode = null;
		else
			clone.inpatientepisode = (ims.clinical.vo.InpatientEpisodeForHospitalAtNightVo)this.inpatientepisode.clone();
		clone.carecontext = this.carecontext;
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
		if (!(InpatientEpisodeWithCareContextVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InpatientEpisodeWithCareContextVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		InpatientEpisodeWithCareContextVo compareObj = (InpatientEpisodeWithCareContextVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getInpatientEpisode() == null && compareObj.getInpatientEpisode() != null)
				return -1;
			if(this.getInpatientEpisode() != null && compareObj.getInpatientEpisode() == null)
				return 1;
			if(this.getInpatientEpisode() != null && compareObj.getInpatientEpisode() != null)
				retVal = this.getInpatientEpisode().compareTo(compareObj.getInpatientEpisode());
		}
		if (retVal == 0)
		{
			if(this.getCareContext() == null && compareObj.getCareContext() != null)
				return -1;
			if(this.getCareContext() != null && compareObj.getCareContext() == null)
				return 1;
			if(this.getCareContext() != null && compareObj.getCareContext() != null)
				retVal = this.getCareContext().compareTo(compareObj.getCareContext());
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
		if(this.inpatientepisode != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinical.vo.InpatientEpisodeForHospitalAtNightVo inpatientepisode;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
