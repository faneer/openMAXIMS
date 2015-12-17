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

package ims.RefMan.vo;

/**
 * Linked to core.admin.pas.DischargedEpisode business object (ID: 1014100006).
 */
public class DischargedEpisodeForClinicalCodingWorklistVo extends ims.core.admin.pas.vo.DischargedEpisodeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargedEpisodeForClinicalCodingWorklistVo()
	{
	}
	public DischargedEpisodeForClinicalCodingWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargedEpisodeForClinicalCodingWorklistVo(ims.RefMan.vo.beans.DischargedEpisodeForClinicalCodingWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.codingdelay = bean.getCodingDelay() == null ? null : bean.getCodingDelay().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.DischargedEpisodeForClinicalCodingWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.codingdelay = bean.getCodingDelay() == null ? null : bean.getCodingDelay().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.DischargedEpisodeForClinicalCodingWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.DischargedEpisodeForClinicalCodingWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.DischargedEpisodeForClinicalCodingWorklistVoBean();
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
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("CODINGDELAY"))
			return getCodingDelay();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDischargeDateTimeIsNotNull()
	{
		return this.dischargedatetime != null;
	}
	public ims.framework.utils.DateTime getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedatetime = value;
	}
	public boolean getCodingDelayIsNotNull()
	{
		return this.codingdelay != null;
	}
	public ims.core.vo.CodingDelayVo getCodingDelay()
	{
		return this.codingdelay;
	}
	public void setCodingDelay(ims.core.vo.CodingDelayVo value)
	{
		this.isValidated = false;
		this.codingdelay = value;
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
		if(this.codingdelay != null)
		{
			if(!this.codingdelay.isValidated())
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
		if(this.codingdelay != null)
		{
			String[] listOfOtherErrors = this.codingdelay.validate();
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
	
		DischargedEpisodeForClinicalCodingWorklistVo clone = new DischargedEpisodeForClinicalCodingWorklistVo(this.id, this.version);
		
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		if(this.codingdelay == null)
			clone.codingdelay = null;
		else
			clone.codingdelay = (ims.core.vo.CodingDelayVo)this.codingdelay.clone();
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
		if (!(DischargedEpisodeForClinicalCodingWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargedEpisodeForClinicalCodingWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargedEpisodeForClinicalCodingWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargedEpisodeForClinicalCodingWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.dischargedatetime != null)
			count++;
		if(this.codingdelay != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.framework.utils.DateTime dischargedatetime;
	protected ims.core.vo.CodingDelayVo codingdelay;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
