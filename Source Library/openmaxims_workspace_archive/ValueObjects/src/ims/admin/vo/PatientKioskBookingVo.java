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

package ims.admin.vo;


public class PatientKioskBookingVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientKioskBookingVo()
	{
	}
	public PatientKioskBookingVo(ims.admin.vo.beans.PatientKioskBookingVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.appointments = ims.admin.vo.PatientKioskAppointmentVoCollection.buildFromBeanCollection(bean.getAppointments());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.PatientKioskBookingVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.appointments = ims.admin.vo.PatientKioskAppointmentVoCollection.buildFromBeanCollection(bean.getAppointments());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.PatientKioskBookingVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.PatientKioskBookingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.PatientKioskBookingVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.admin.vo.PatientKioskPatientVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.admin.vo.PatientKioskPatientVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getAppointmentsIsNotNull()
	{
		return this.appointments != null;
	}
	public ims.admin.vo.PatientKioskAppointmentVoCollection getAppointments()
	{
		return this.appointments;
	}
	public void setAppointments(ims.admin.vo.PatientKioskAppointmentVoCollection value)
	{
		this.isValidated = false;
		this.appointments = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.patient != null)
			sb.append(this.patient);
		return sb.toString();
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof PatientKioskBookingVo))
			return false;
		PatientKioskBookingVo compareObj = (PatientKioskBookingVo)obj;
		if(this.getPatient() == null && compareObj.getPatient() != null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() == null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() != null)
			return this.getPatient().equals(compareObj.getPatient());
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
		if(this.patient != null)
		{
			if(!this.patient.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.appointments != null)
		{
			if(!this.appointments.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.patient != null)
		{
			String[] listOfOtherErrors = this.patient.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.appointments == null || this.appointments.size() == 0)
			listOfErrors.add("Appointments are mandatory");
		if(this.appointments != null)
		{
			String[] listOfOtherErrors = this.appointments.validate();
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
	
		PatientKioskBookingVo clone = new PatientKioskBookingVo();
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.admin.vo.PatientKioskPatientVo)this.patient.clone();
		if(this.appointments == null)
			clone.appointments = null;
		else
			clone.appointments = (ims.admin.vo.PatientKioskAppointmentVoCollection)this.appointments.clone();
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
		if (!(PatientKioskBookingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientKioskBookingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientKioskBookingVo compareObj = (PatientKioskBookingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
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
		if(this.patient != null)
			count++;
		if(this.appointments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.admin.vo.PatientKioskPatientVo patient;
	protected ims.admin.vo.PatientKioskAppointmentVoCollection appointments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
