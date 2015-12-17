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


public class DisplacedAppointmentsSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DisplacedAppointmentsSearchCriteriaVo()
	{
	}
	public DisplacedAppointmentsSearchCriteriaVo(ims.scheduling.vo.beans.DisplacedAppointmentsSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.profile = bean.getProfile() == null ? null : bean.getProfile().buildVo();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.listowners = ims.core.vo.HcpLiteVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.listtype = bean.getListType() == null ? null : ims.scheduling.vo.lookups.ProfileListType.buildLookup(bean.getListType());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.DisplacedAppointmentsSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo(map);
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.profile = bean.getProfile() == null ? null : bean.getProfile().buildVo(map);
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.listowners = ims.core.vo.HcpLiteVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.listtype = bean.getListType() == null ? null : ims.scheduling.vo.lookups.ProfileListType.buildLookup(bean.getListType());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.DisplacedAppointmentsSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.DisplacedAppointmentsSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.DisplacedAppointmentsSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.vo.LocationLiteVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocationLiteVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getProfileIsNotNull()
	{
		return this.profile != null;
	}
	public ims.scheduling.vo.ProfileLiteVo getProfile()
	{
		return this.profile;
	}
	public void setProfile(ims.scheduling.vo.ProfileLiteVo value)
	{
		this.isValidated = false;
		this.profile = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceShortVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceShortVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.Date getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.Date getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public boolean getListOwnersIsNotNull()
	{
		return this.listowners != null;
	}
	public ims.core.vo.HcpLiteVoCollection getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.core.vo.HcpLiteVoCollection value)
	{
		this.isValidated = false;
		this.listowners = value;
	}
	public boolean getListTypeIsNotNull()
	{
		return this.listtype != null;
	}
	public ims.scheduling.vo.lookups.ProfileListType getListType()
	{
		return this.listtype;
	}
	public void setListType(ims.scheduling.vo.lookups.ProfileListType value)
	{
		this.isValidated = false;
		this.listtype = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
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
		if(!(obj instanceof DisplacedAppointmentsSearchCriteriaVo))
			return false;
		DisplacedAppointmentsSearchCriteriaVo compareObj = (DisplacedAppointmentsSearchCriteriaVo)obj;
		if(this.getHospital() == null && compareObj.getHospital() != null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() == null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() != null)
			if(!this.getHospital().equals(compareObj.getHospital()))
				return false;
		if(this.getLocation() == null && compareObj.getLocation() != null)
			return false;
		if(this.getLocation() != null && compareObj.getLocation() == null)
			return false;
		if(this.getLocation() != null && compareObj.getLocation() != null)
			if(!this.getLocation().equals(compareObj.getLocation()))
				return false;
		if(this.getProfile() == null && compareObj.getProfile() != null)
			return false;
		if(this.getProfile() != null && compareObj.getProfile() == null)
			return false;
		if(this.getProfile() != null && compareObj.getProfile() != null)
			if(!this.getProfile().equals(compareObj.getProfile()))
				return false;
		if(this.getService() == null && compareObj.getService() != null)
			return false;
		if(this.getService() != null && compareObj.getService() == null)
			return false;
		if(this.getService() != null && compareObj.getService() != null)
			return this.getService().equals(compareObj.getService());
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
		if(this.hospital != null)
		{
			if(!this.hospital.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.location != null)
		{
			if(!this.location.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.profile != null)
		{
			if(!this.profile.isValidated())
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
		if(this.listowners != null)
		{
			if(!this.listowners.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.consultant != null)
		{
			if(!this.consultant.isValidated())
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
		if(this.hospital != null)
		{
			String[] listOfOtherErrors = this.hospital.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.location != null)
		{
			String[] listOfOtherErrors = this.location.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.profile != null)
		{
			String[] listOfOtherErrors = this.profile.validate();
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
		if(this.listowners != null)
		{
			String[] listOfOtherErrors = this.listowners.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.consultant != null)
		{
			String[] listOfOtherErrors = this.consultant.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		DisplacedAppointmentsSearchCriteriaVo clone = new DisplacedAppointmentsSearchCriteriaVo();
		
		if(this.hospital == null)
			clone.hospital = null;
		else
			clone.hospital = (ims.core.vo.LocationLiteVo)this.hospital.clone();
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocationLiteVo)this.location.clone();
		if(this.profile == null)
			clone.profile = null;
		else
			clone.profile = (ims.scheduling.vo.ProfileLiteVo)this.profile.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.Date)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.Date)this.dateto.clone();
		if(this.listowners == null)
			clone.listowners = null;
		else
			clone.listowners = (ims.core.vo.HcpLiteVoCollection)this.listowners.clone();
		if(this.listtype == null)
			clone.listtype = null;
		else
			clone.listtype = (ims.scheduling.vo.lookups.ProfileListType)this.listtype.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
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
		if (!(DisplacedAppointmentsSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DisplacedAppointmentsSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DisplacedAppointmentsSearchCriteriaVo compareObj = (DisplacedAppointmentsSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getHospital() == null && compareObj.getHospital() != null)
				return -1;
			if(this.getHospital() != null && compareObj.getHospital() == null)
				return 1;
			if(this.getHospital() != null && compareObj.getHospital() != null)
				retVal = this.getHospital().compareTo(compareObj.getHospital());
		}
		if (retVal == 0)
		{
			if(this.getLocation() == null && compareObj.getLocation() != null)
				return -1;
			if(this.getLocation() != null && compareObj.getLocation() == null)
				return 1;
			if(this.getLocation() != null && compareObj.getLocation() != null)
				retVal = this.getLocation().compareTo(compareObj.getLocation());
		}
		if (retVal == 0)
		{
			if(this.getProfile() == null && compareObj.getProfile() != null)
				return -1;
			if(this.getProfile() != null && compareObj.getProfile() == null)
				return 1;
			if(this.getProfile() != null && compareObj.getProfile() != null)
				retVal = this.getProfile().compareTo(compareObj.getProfile());
		}
		if (retVal == 0)
		{
			if(this.getService() == null && compareObj.getService() != null)
				return -1;
			if(this.getService() != null && compareObj.getService() == null)
				return 1;
			if(this.getService() != null && compareObj.getService() != null)
				retVal = this.getService().compareTo(compareObj.getService());
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
		if(this.hospital != null)
			count++;
		if(this.location != null)
			count++;
		if(this.profile != null)
			count++;
		if(this.service != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		if(this.listowners != null)
			count++;
		if(this.listtype != null)
			count++;
		if(this.consultant != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.LocationLiteVo hospital;
	protected ims.core.vo.LocationLiteVo location;
	protected ims.scheduling.vo.ProfileLiteVo profile;
	protected ims.core.vo.ServiceShortVo service;
	protected ims.framework.utils.Date datefrom;
	protected ims.framework.utils.Date dateto;
	protected ims.core.vo.HcpLiteVoCollection listowners;
	protected ims.scheduling.vo.lookups.ProfileListType listtype;
	protected ims.core.vo.HcpLiteVo consultant;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
