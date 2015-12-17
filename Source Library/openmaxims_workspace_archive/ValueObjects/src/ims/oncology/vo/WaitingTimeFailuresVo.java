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

package ims.oncology.vo;

/**
 * Linked to Oncology.WaitingTimes.WaitingTimeFailures business object (ID: 1098100001).
 */
public class WaitingTimeFailuresVo extends ims.oncology.waitingtimes.vo.WaitingTimeFailuresRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WaitingTimeFailuresVo()
	{
	}
	public WaitingTimeFailuresVo(Integer id, int version)
	{
		super(id, version);
	}
	public WaitingTimeFailuresVo(ims.oncology.vo.beans.WaitingTimeFailuresVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.nhsnumber = bean.getNHSNumber();
		this.reason = bean.getReason();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.WaitingTimeFailuresVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.nhsnumber = bean.getNHSNumber();
		this.reason = bean.getReason();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.WaitingTimeFailuresVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.WaitingTimeFailuresVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.WaitingTimeFailuresVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("NHSNUMBER"))
			return getNHSNumber();
		if(fieldName.equals("REASON"))
			return getReason();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getNHSNumberIsNotNull()
	{
		return this.nhsnumber != null;
	}
	public String getNHSNumber()
	{
		return this.nhsnumber;
	}
	public static int getNHSNumberMaxLength()
	{
		return 10;
	}
	public void setNHSNumber(String value)
	{
		this.isValidated = false;
		this.nhsnumber = value;
	}
	public boolean getReasonIsNotNull()
	{
		return this.reason != null;
	}
	public String getReason()
	{
		return this.reason;
	}
	public static int getReasonMaxLength()
	{
		return 255;
	}
	public void setReason(String value)
	{
		this.isValidated = false;
		this.reason = value;
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
		if(this.nhsnumber != null)
			if(this.nhsnumber.length() > 10)
				listOfErrors.add("The length of the field [nhsnumber] in the value object [ims.oncology.vo.WaitingTimeFailuresVo] is too big. It should be less or equal to 10");
		if(this.reason != null)
			if(this.reason.length() > 255)
				listOfErrors.add("The length of the field [reason] in the value object [ims.oncology.vo.WaitingTimeFailuresVo] is too big. It should be less or equal to 255");
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
	
		WaitingTimeFailuresVo clone = new WaitingTimeFailuresVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		clone.patient = this.patient;
		clone.nhsnumber = this.nhsnumber;
		clone.reason = this.reason;
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
		if (!(WaitingTimeFailuresVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WaitingTimeFailuresVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((WaitingTimeFailuresVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((WaitingTimeFailuresVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.nhsnumber != null)
			count++;
		if(this.reason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected String nhsnumber;
	protected String reason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
