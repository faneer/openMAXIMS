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

package ims.emergency.vo;

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientForTriageVo extends ims.core.patient.vo.PatientRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientForTriageVo()
	{
	}
	public PatientForTriageVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientForTriageVo(ims.emergency.vo.beans.PatientForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.hasalerts = bean.getHasAlerts();
		this.hasallergies = bean.getHasAllergies();
		this.photo = bean.getPhoto() == null ? null : bean.getPhoto().buildVo();
		this.isquickregistrationpatient = bean.getIsQuickRegistrationPatient();
		this.ocsnotification = bean.getOCSNotification() == null ? null : bean.getOCSNotification().buildVo();
		this.mrnstatus = bean.getMRNStatus() == null ? null : ims.core.vo.lookups.MRNStatus.buildLookup(bean.getMRNStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.PatientForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.hasalerts = bean.getHasAlerts();
		this.hasallergies = bean.getHasAllergies();
		this.photo = bean.getPhoto() == null ? null : bean.getPhoto().buildVo(map);
		this.isquickregistrationpatient = bean.getIsQuickRegistrationPatient();
		this.ocsnotification = bean.getOCSNotification() == null ? null : bean.getOCSNotification().buildVo(map);
		this.mrnstatus = bean.getMRNStatus() == null ? null : ims.core.vo.lookups.MRNStatus.buildLookup(bean.getMRNStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.PatientForTriageVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.PatientForTriageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.PatientForTriageVoBean();
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
		if(fieldName.equals("SEX"))
			return getSex();
		if(fieldName.equals("DOB"))
			return getDob();
		if(fieldName.equals("IDENTIFIERS"))
			return getIdentifiers();
		if(fieldName.equals("HASALERTS"))
			return getHasAlerts();
		if(fieldName.equals("HASALLERGIES"))
			return getHasAllergies();
		if(fieldName.equals("PHOTO"))
			return getPhoto();
		if(fieldName.equals("ISQUICKREGISTRATIONPATIENT"))
			return getIsQuickRegistrationPatient();
		if(fieldName.equals("OCSNOTIFICATION"))
			return getOCSNotification();
		if(fieldName.equals("MRNSTATUS"))
			return getMRNStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getSexIsNotNull()
	{
		return this.sex != null;
	}
	public ims.core.vo.lookups.Sex getSex()
	{
		return this.sex;
	}
	public void setSex(ims.core.vo.lookups.Sex value)
	{
		this.isValidated = false;
		this.sex = value;
	}
	public boolean getDobIsNotNull()
	{
		return this.dob != null;
	}
	public ims.framework.utils.PartialDate getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.dob = value;
	}
	public boolean getIdentifiersIsNotNull()
	{
		return this.identifiers != null;
	}
	public ims.core.vo.PatientIdCollection getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.PatientIdCollection value)
	{
		this.isValidated = false;
		this.identifiers = value;
	}
	public boolean getHasAlertsIsNotNull()
	{
		return this.hasalerts != null;
	}
	public Boolean getHasAlerts()
	{
		return this.hasalerts;
	}
	public void setHasAlerts(Boolean value)
	{
		this.isValidated = false;
		this.hasalerts = value;
	}
	public boolean getHasAllergiesIsNotNull()
	{
		return this.hasallergies != null;
	}
	public Boolean getHasAllergies()
	{
		return this.hasallergies;
	}
	public void setHasAllergies(Boolean value)
	{
		this.isValidated = false;
		this.hasallergies = value;
	}
	public boolean getPhotoIsNotNull()
	{
		return this.photo != null;
	}
	public ims.core.vo.AppDBImageVo getPhoto()
	{
		return this.photo;
	}
	public void setPhoto(ims.core.vo.AppDBImageVo value)
	{
		this.isValidated = false;
		this.photo = value;
	}
	public boolean getIsQuickRegistrationPatientIsNotNull()
	{
		return this.isquickregistrationpatient != null;
	}
	public Boolean getIsQuickRegistrationPatient()
	{
		return this.isquickregistrationpatient;
	}
	public void setIsQuickRegistrationPatient(Boolean value)
	{
		this.isValidated = false;
		this.isquickregistrationpatient = value;
	}
	public boolean getOCSNotificationIsNotNull()
	{
		return this.ocsnotification != null;
	}
	public ims.core.vo.PatientNotificationsFillerOnlyVo getOCSNotification()
	{
		return this.ocsnotification;
	}
	public void setOCSNotification(ims.core.vo.PatientNotificationsFillerOnlyVo value)
	{
		this.isValidated = false;
		this.ocsnotification = value;
	}
	public boolean getMRNStatusIsNotNull()
	{
		return this.mrnstatus != null;
	}
	public ims.core.vo.lookups.MRNStatus getMRNStatus()
	{
		return this.mrnstatus;
	}
	public void setMRNStatus(ims.core.vo.lookups.MRNStatus value)
	{
		this.isValidated = false;
		this.mrnstatus = value;
	}
	/**
	* getPatId
	*/
	public ims.core.vo.PatientId getPatId(ims.core.vo.lookups.PatIdType idType)
	{
		if (identifiers == null) return null;
		for (int i = 0; i < identifiers.size(); i++)
		{
			ims.core.vo.PatientId id = identifiers.get(i);
			if (id.getType().equals(idType))
			{
				return id;
			}
		}
		return null;
	}
	
	
	/**
	* getHospnum
	*/
	public ims.core.vo.PatientId getHospnum()
	{
		return getPatId(ims.core.vo.lookups.PatIdType.HOSPNUM);
	}
	
	/**
	* hasPatientNotification
	*/
	public boolean hasPatientNotification()
	{
		if (this.ocsnotification == null)
			return false;
		
		if (this.ocsnotification.getNewResults()== null && this.ocsnotification.getSeenResults()== null)
			return false;
	
		if (this.ocsnotification.getNewResults()!= null && this.ocsnotification.getSeenResults()== null)
			return true;
	
		if (this.ocsnotification.getNewResults().getNewCount()== null && this.ocsnotification.getSeenResults().getSeenCount()== null)
			return false;
	
		if (this.ocsnotification.getNewResults().getNewCount()!= null && this.ocsnotification.getSeenResults().getSeenCount()== null)
			return true;
		
		if (this.ocsnotification.getNewResults().getNewCount()> this.ocsnotification.getSeenResults().getSeenCount())
			return true;
		
		return false;
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
	
		PatientForTriageVo clone = new PatientForTriageVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.sex == null)
			clone.sex = null;
		else
			clone.sex = (ims.core.vo.lookups.Sex)this.sex.clone();
		if(this.dob == null)
			clone.dob = null;
		else
			clone.dob = (ims.framework.utils.PartialDate)this.dob.clone();
		if(this.identifiers == null)
			clone.identifiers = null;
		else
			clone.identifiers = (ims.core.vo.PatientIdCollection)this.identifiers.clone();
		clone.hasalerts = this.hasalerts;
		clone.hasallergies = this.hasallergies;
		if(this.photo == null)
			clone.photo = null;
		else
			clone.photo = (ims.core.vo.AppDBImageVo)this.photo.clone();
		clone.isquickregistrationpatient = this.isquickregistrationpatient;
		if(this.ocsnotification == null)
			clone.ocsnotification = null;
		else
			clone.ocsnotification = (ims.core.vo.PatientNotificationsFillerOnlyVo)this.ocsnotification.clone();
		if(this.mrnstatus == null)
			clone.mrnstatus = null;
		else
			clone.mrnstatus = (ims.core.vo.lookups.MRNStatus)this.mrnstatus.clone();
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
		if (!(PatientForTriageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientForTriageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientForTriageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientForTriageVo)obj).getBoId());
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
		if(this.sex != null)
			count++;
		if(this.dob != null)
			count++;
		if(this.identifiers != null)
			count++;
		if(this.hasalerts != null)
			count++;
		if(this.hasallergies != null)
			count++;
		if(this.photo != null)
			count++;
		if(this.isquickregistrationpatient != null)
			count++;
		if(this.ocsnotification != null)
			count++;
		if(this.mrnstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.core.vo.PersonName name;
	protected ims.core.vo.lookups.Sex sex;
	protected ims.framework.utils.PartialDate dob;
	protected ims.core.vo.PatientIdCollection identifiers;
	protected Boolean hasalerts;
	protected Boolean hasallergies;
	protected ims.core.vo.AppDBImageVo photo;
	protected Boolean isquickregistrationpatient;
	protected ims.core.vo.PatientNotificationsFillerOnlyVo ocsnotification;
	protected ims.core.vo.lookups.MRNStatus mrnstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
