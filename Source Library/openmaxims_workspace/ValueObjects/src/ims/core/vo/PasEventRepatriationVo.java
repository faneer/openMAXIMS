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

package ims.core.vo;

/**
 * Linked to core.admin.pas.PAS Event business object (ID: 1014100003).
 */
public class PasEventRepatriationVo extends ims.core.admin.pas.vo.PASEventRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PasEventRepatriationVo()
	{
	}
	public PasEventRepatriationVo(Integer id, int version)
	{
		super(id, version);
	}
	public PasEventRepatriationVo(ims.core.vo.beans.PasEventRepatriationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.paseventid = bean.getPasEventId();
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.location = bean.getLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getLocation().getId()), bean.getLocation().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.eventtype = bean.getEventType() == null ? null : ims.core.vo.lookups.PasEventType.buildLookup(bean.getEventType());
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PasEventRepatriationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.paseventid = bean.getPasEventId();
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.location = bean.getLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getLocation().getId()), bean.getLocation().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.eventtype = bean.getEventType() == null ? null : ims.core.vo.lookups.PasEventType.buildLookup(bean.getEventType());
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PasEventRepatriationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PasEventRepatriationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PasEventRepatriationVoBean();
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
		if(fieldName.equals("EVENTDATETIME"))
			return getEventDateTime();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("PASEVENTID"))
			return getPasEventId();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("SOURCEOFREFERRAL"))
			return getSourceOfReferral();
		if(fieldName.equals("EVENTTYPE"))
			return getEventType();
		if(fieldName.equals("SERVICE"))
			return getService();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEventDateTimeIsNotNull()
	{
		return this.eventdatetime != null;
	}
	public ims.framework.utils.DateTime getEventDateTime()
	{
		return this.eventdatetime;
	}
	public void setEventDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.eventdatetime = value;
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
	public boolean getPasEventIdIsNotNull()
	{
		return this.paseventid != null;
	}
	public String getPasEventId()
	{
		return this.paseventid;
	}
	public static int getPasEventIdMaxLength()
	{
		return 100;
	}
	public void setPasEventId(String value)
	{
		this.isValidated = false;
		this.paseventid = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.resource.people.vo.MedicRefVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.resource.people.vo.MedicRefVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getSourceOfReferralIsNotNull()
	{
		return this.sourceofreferral != null;
	}
	public ims.core.vo.lookups.SourceOfReferral getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.core.vo.lookups.SourceOfReferral value)
	{
		this.isValidated = false;
		this.sourceofreferral = value;
	}
	public boolean getEventTypeIsNotNull()
	{
		return this.eventtype != null;
	}
	public ims.core.vo.lookups.PasEventType getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.core.vo.lookups.PasEventType value)
	{
		this.isValidated = false;
		this.eventtype = value;
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
		if(this.patient == null)
			listOfErrors.add("patient is mandatory");
		if(this.paseventid != null)
			if(this.paseventid.length() > 100)
				listOfErrors.add("The length of the field [paseventid] in the value object [ims.core.vo.PasEventRepatriationVo] is too big. It should be less or equal to 100");
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
	
		PasEventRepatriationVo clone = new PasEventRepatriationVo(this.id, this.version);
		
		if(this.eventdatetime == null)
			clone.eventdatetime = null;
		else
			clone.eventdatetime = (ims.framework.utils.DateTime)this.eventdatetime.clone();
		clone.patient = this.patient;
		clone.paseventid = this.paseventid;
		clone.consultant = this.consultant;
		clone.location = this.location;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.sourceofreferral == null)
			clone.sourceofreferral = null;
		else
			clone.sourceofreferral = (ims.core.vo.lookups.SourceOfReferral)this.sourceofreferral.clone();
		if(this.eventtype == null)
			clone.eventtype = null;
		else
			clone.eventtype = (ims.core.vo.lookups.PasEventType)this.eventtype.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
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
		if (!(PasEventRepatriationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PasEventRepatriationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PasEventRepatriationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PasEventRepatriationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.eventdatetime != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.paseventid != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.location != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.sourceofreferral != null)
			count++;
		if(this.eventtype != null)
			count++;
		if(this.service != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.framework.utils.DateTime eventdatetime;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected String paseventid;
	protected ims.core.resource.people.vo.MedicRefVo consultant;
	protected ims.core.resource.place.vo.LocationRefVo location;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.lookups.SourceOfReferral sourceofreferral;
	protected ims.core.vo.lookups.PasEventType eventtype;
	protected ims.core.vo.ServiceLiteVo service;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
