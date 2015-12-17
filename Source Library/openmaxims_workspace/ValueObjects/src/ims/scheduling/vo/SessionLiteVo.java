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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class SessionLiteVo extends ims.scheduling.vo.Sch_SessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionLiteVo()
	{
	}
	public SessionLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionLiteVo(ims.scheduling.vo.beans.SessionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.isfixed = bean.getIsFixed();
		this.listowners = ims.scheduling.vo.SessionListOwnerLiteVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.sch_profile = bean.getSch_Profile() == null ? null : bean.getSch_Profile().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo(map);
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.isfixed = bean.getIsFixed();
		this.listowners = ims.scheduling.vo.SessionListOwnerLiteVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.sch_profile = bean.getSch_Profile() == null ? null : bean.getSch_Profile().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionLiteVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionLiteVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("SCHLOCATION"))
			return getSchLocation();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("STARTTM"))
			return getStartTm();
		if(fieldName.equals("ENDTM"))
			return getEndTm();
		if(fieldName.equals("ISFIXED"))
			return getIsFixed();
		if(fieldName.equals("LISTOWNERS"))
			return getListOwners();
		if(fieldName.equals("SCH_PROFILE"))
			return getSch_Profile();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getSchLocationIsNotNull()
	{
		return this.schlocation != null;
	}
	public ims.core.vo.LocShortVo getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.schlocation = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getStartTmIsNotNull()
	{
		return this.starttm != null;
	}
	public ims.framework.utils.Time getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttm = value;
	}
	public boolean getEndTmIsNotNull()
	{
		return this.endtm != null;
	}
	public ims.framework.utils.Time getEndTm()
	{
		return this.endtm;
	}
	public void setEndTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.endtm = value;
	}
	public boolean getIsFixedIsNotNull()
	{
		return this.isfixed != null;
	}
	public Boolean getIsFixed()
	{
		return this.isfixed;
	}
	public void setIsFixed(Boolean value)
	{
		this.isValidated = false;
		this.isfixed = value;
	}
	public boolean getListOwnersIsNotNull()
	{
		return this.listowners != null;
	}
	public ims.scheduling.vo.SessionListOwnerLiteVoCollection getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.scheduling.vo.SessionListOwnerLiteVoCollection value)
	{
		this.isValidated = false;
		this.listowners = value;
	}
	public boolean getSch_ProfileIsNotNull()
	{
		return this.sch_profile != null;
	}
	public ims.scheduling.vo.Sch_ProfileLiteVo getSch_Profile()
	{
		return this.sch_profile;
	}
	public void setSch_Profile(ims.scheduling.vo.Sch_ProfileLiteVo value)
	{
		this.isValidated = false;
		this.sch_profile = value;
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
		if(this.schlocation != null)
		{
			if(!this.schlocation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.service != null)
		{
			if(!this.service.isValidated())
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
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.SessionLiteVo] is too big. It should be less or equal to 100");
		if(this.schlocation != null)
		{
			String[] listOfOtherErrors = this.schlocation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
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
	
		SessionLiteVo clone = new SessionLiteVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.schlocation == null)
			clone.schlocation = null;
		else
			clone.schlocation = (ims.core.vo.LocShortVo)this.schlocation.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		if(this.endtm == null)
			clone.endtm = null;
		else
			clone.endtm = (ims.framework.utils.Time)this.endtm.clone();
		clone.isfixed = this.isfixed;
		if(this.listowners == null)
			clone.listowners = null;
		else
			clone.listowners = (ims.scheduling.vo.SessionListOwnerLiteVoCollection)this.listowners.clone();
		if(this.sch_profile == null)
			clone.sch_profile = null;
		else
			clone.sch_profile = (ims.scheduling.vo.Sch_ProfileLiteVo)this.sch_profile.clone();
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
		if (!(SessionLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.schlocation != null)
			count++;
		if(this.service != null)
			count++;
		if(this.starttm != null)
			count++;
		if(this.endtm != null)
			count++;
		if(this.isfixed != null)
			count++;
		if(this.listowners != null)
			count++;
		if(this.sch_profile != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected String name;
	protected ims.core.vo.LocShortVo schlocation;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.framework.utils.Time starttm;
	protected ims.framework.utils.Time endtm;
	protected Boolean isfixed;
	protected ims.scheduling.vo.SessionListOwnerLiteVoCollection listowners;
	protected ims.scheduling.vo.Sch_ProfileLiteVo sch_profile;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
