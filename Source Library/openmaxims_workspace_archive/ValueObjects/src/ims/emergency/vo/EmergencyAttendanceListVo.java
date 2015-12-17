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

package ims.emergency.vo;


public class EmergencyAttendanceListVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceListVo()
	{
	}
	public EmergencyAttendanceListVo(ims.emergency.vo.beans.EmergencyAttendanceListVoBean bean)
	{
		this.id = bean.getId();
		this.attendancedate = bean.getAttendanceDate() == null ? null : bean.getAttendanceDate().buildDateTime();
		this.hospitalno = bean.getHospitalNo();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.patientcategory = bean.getPatientCategory();
		this.presentingcomplaint = bean.getPresentingComplaint();
		this.injurydate = bean.getInjuryDate() == null ? null : bean.getInjuryDate().buildDateTime();
		this.patientid = bean.getPatientId();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceListVoBean bean)
	{
		this.id = bean.getId();
		this.attendancedate = bean.getAttendanceDate() == null ? null : bean.getAttendanceDate().buildDateTime();
		this.hospitalno = bean.getHospitalNo();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.patientcategory = bean.getPatientCategory();
		this.presentingcomplaint = bean.getPresentingComplaint();
		this.injurydate = bean.getInjuryDate() == null ? null : bean.getInjuryDate().buildDateTime();
		this.patientid = bean.getPatientId();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceListVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceListVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getIdIsNotNull()
	{
		return this.id != null;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.isValidated = false;
		this.id = value;
	}
	public boolean getAttendanceDateIsNotNull()
	{
		return this.attendancedate != null;
	}
	public ims.framework.utils.DateTime getAttendanceDate()
	{
		return this.attendancedate;
	}
	public void setAttendanceDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.attendancedate = value;
	}
	public boolean getHospitalNoIsNotNull()
	{
		return this.hospitalno != null;
	}
	public String getHospitalNo()
	{
		return this.hospitalno;
	}
	public static int getHospitalNoMaxLength()
	{
		return 255;
	}
	public void setHospitalNo(String value)
	{
		this.isValidated = false;
		this.hospitalno = value;
	}
	public boolean getSurnameIsNotNull()
	{
		return this.surname != null;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public static int getSurnameMaxLength()
	{
		return 255;
	}
	public void setSurname(String value)
	{
		this.isValidated = false;
		this.surname = value;
	}
	public boolean getForenameIsNotNull()
	{
		return this.forename != null;
	}
	public String getForename()
	{
		return this.forename;
	}
	public static int getForenameMaxLength()
	{
		return 255;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getPatientCategoryIsNotNull()
	{
		return this.patientcategory != null;
	}
	public String getPatientCategory()
	{
		return this.patientcategory;
	}
	public static int getPatientCategoryMaxLength()
	{
		return 255;
	}
	public void setPatientCategory(String value)
	{
		this.isValidated = false;
		this.patientcategory = value;
	}
	public boolean getPresentingComplaintIsNotNull()
	{
		return this.presentingcomplaint != null;
	}
	public String getPresentingComplaint()
	{
		return this.presentingcomplaint;
	}
	public static int getPresentingComplaintMaxLength()
	{
		return 255;
	}
	public void setPresentingComplaint(String value)
	{
		this.isValidated = false;
		this.presentingcomplaint = value;
	}
	public boolean getInjuryDateIsNotNull()
	{
		return this.injurydate != null;
	}
	public ims.framework.utils.DateTime getInjuryDate()
	{
		return this.injurydate;
	}
	public void setInjuryDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.injurydate = value;
	}
	public boolean getPatientIdIsNotNull()
	{
		return this.patientid != null;
	}
	public Integer getPatientId()
	{
		return this.patientid;
	}
	public void setPatientId(Integer value)
	{
		this.isValidated = false;
		this.patientid = value;
	}
	public boolean getDischargeDateIsNotNull()
	{
		return this.dischargedate != null;
	}
	public ims.framework.utils.DateTime getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedate = value;
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
		if(!(obj instanceof EmergencyAttendanceListVo))
			return false;
		EmergencyAttendanceListVo compareObj = (EmergencyAttendanceListVo)obj;
		if(this.getId() == null && compareObj.getId() != null)
			return false;
		if(this.getId() != null && compareObj.getId() == null)
			return false;
		if(this.getId() != null && compareObj.getId() != null)
			return this.getId().equals(compareObj.getId());
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
	
		EmergencyAttendanceListVo clone = new EmergencyAttendanceListVo();
		
		clone.id = this.id;
		if(this.attendancedate == null)
			clone.attendancedate = null;
		else
			clone.attendancedate = (ims.framework.utils.DateTime)this.attendancedate.clone();
		clone.hospitalno = this.hospitalno;
		clone.surname = this.surname;
		clone.forename = this.forename;
		clone.patientcategory = this.patientcategory;
		clone.presentingcomplaint = this.presentingcomplaint;
		if(this.injurydate == null)
			clone.injurydate = null;
		else
			clone.injurydate = (ims.framework.utils.DateTime)this.injurydate.clone();
		clone.patientid = this.patientid;
		if(this.dischargedate == null)
			clone.dischargedate = null;
		else
			clone.dischargedate = (ims.framework.utils.DateTime)this.dischargedate.clone();
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
		if (!(EmergencyAttendanceListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EmergencyAttendanceListVo compareObj = (EmergencyAttendanceListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getId() == null && compareObj.getId() != null)
				return -1;
			if(this.getId() != null && compareObj.getId() == null)
				return 1;
			if(this.getId() != null && compareObj.getId() != null)
				retVal = this.getId().compareTo(compareObj.getId());
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
		if(this.id != null)
			count++;
		if(this.attendancedate != null)
			count++;
		if(this.hospitalno != null)
			count++;
		if(this.surname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.patientcategory != null)
			count++;
		if(this.presentingcomplaint != null)
			count++;
		if(this.injurydate != null)
			count++;
		if(this.patientid != null)
			count++;
		if(this.dischargedate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected Integer id;
	protected ims.framework.utils.DateTime attendancedate;
	protected String hospitalno;
	protected String surname;
	protected String forename;
	protected String patientcategory;
	protected String presentingcomplaint;
	protected ims.framework.utils.DateTime injurydate;
	protected Integer patientid;
	protected ims.framework.utils.DateTime dischargedate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
