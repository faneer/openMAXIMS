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
 * Linked to core.admin.pas.PendingElectiveAdmission business object (ID: 1014100012).
 */
public class PendingElectiveAdmissionHl7Vo extends ims.core.admin.pas.vo.PendingElectiveAdmissionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PendingElectiveAdmissionHl7Vo()
	{
	}
	public PendingElectiveAdmissionHl7Vo(Integer id, int version)
	{
		super(id, version);
	}
	public PendingElectiveAdmissionHl7Vo(ims.core.vo.beans.PendingElectiveAdmissionHl7VoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.allocatedward = bean.getAllocatedWard() == null ? null : bean.getAllocatedWard().buildVo();
		this.electiveadmissionstatus = bean.getElectiveAdmissionStatus() == null ? null : ims.core.vo.lookups.ElectiveAdmissionStatus.buildLookup(bean.getElectiveAdmissionStatus());
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.tcitype = bean.getTCIType() == null ? null : ims.core.vo.lookups.TCIType.buildLookup(bean.getTCIType());
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.admissionsource = bean.getAdmissionSource() == null ? null : ims.core.vo.lookups.SourceOfAdmission.buildLookup(bean.getAdmissionSource());
		this.reasonforadmission = bean.getReasonForAdmission();
		this.expectedstay = bean.getExpectedStay();
		this.managementintention = bean.getManagementIntention() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getManagementIntention());
		this.comments = bean.getComments();
		this.ismaternity = bean.getIsMaternity();
		this.procedures = bean.getProcedures();
		this.admissionmethod = bean.getAdmissionMethod() == null ? null : ims.core.vo.lookups.MethodOfAdmission.buildLookup(bean.getAdmissionMethod());
		this.referringconsultant = bean.getReferringConsultant() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getReferringConsultant().getId()), bean.getReferringConsultant().getVersion());
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PendingElectiveAdmissionHl7VoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.allocatedward = bean.getAllocatedWard() == null ? null : bean.getAllocatedWard().buildVo(map);
		this.electiveadmissionstatus = bean.getElectiveAdmissionStatus() == null ? null : ims.core.vo.lookups.ElectiveAdmissionStatus.buildLookup(bean.getElectiveAdmissionStatus());
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.tcitype = bean.getTCIType() == null ? null : ims.core.vo.lookups.TCIType.buildLookup(bean.getTCIType());
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.admissionsource = bean.getAdmissionSource() == null ? null : ims.core.vo.lookups.SourceOfAdmission.buildLookup(bean.getAdmissionSource());
		this.reasonforadmission = bean.getReasonForAdmission();
		this.expectedstay = bean.getExpectedStay();
		this.managementintention = bean.getManagementIntention() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getManagementIntention());
		this.comments = bean.getComments();
		this.ismaternity = bean.getIsMaternity();
		this.procedures = bean.getProcedures();
		this.admissionmethod = bean.getAdmissionMethod() == null ? null : ims.core.vo.lookups.MethodOfAdmission.buildLookup(bean.getAdmissionMethod());
		this.referringconsultant = bean.getReferringConsultant() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getReferringConsultant().getId()), bean.getReferringConsultant().getVersion());
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PendingElectiveAdmissionHl7VoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PendingElectiveAdmissionHl7VoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PendingElectiveAdmissionHl7VoBean();
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
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("ALLOCATEDWARD"))
			return getAllocatedWard();
		if(fieldName.equals("ELECTIVEADMISSIONSTATUS"))
			return getElectiveAdmissionStatus();
		if(fieldName.equals("WARDTYPE"))
			return getWardType();
		if(fieldName.equals("TCITYPE"))
			return getTCIType();
		if(fieldName.equals("TCIDATE"))
			return getTCIDate();
		if(fieldName.equals("TCITIME"))
			return getTCITime();
		if(fieldName.equals("ADMISSIONSOURCE"))
			return getAdmissionSource();
		if(fieldName.equals("REASONFORADMISSION"))
			return getReasonForAdmission();
		if(fieldName.equals("EXPECTEDSTAY"))
			return getExpectedStay();
		if(fieldName.equals("MANAGEMENTINTENTION"))
			return getManagementIntention();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("ISMATERNITY"))
			return getIsMaternity();
		if(fieldName.equals("PROCEDURES"))
			return getProcedures();
		if(fieldName.equals("ADMISSIONMETHOD"))
			return getAdmissionMethod();
		if(fieldName.equals("REFERRINGCONSULTANT"))
			return getReferringConsultant();
		if(fieldName.equals("PATIENTSTATUS"))
			return getPatientStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.vo.PasEventVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.PasEventVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getAllocatedWardIsNotNull()
	{
		return this.allocatedward != null;
	}
	public ims.core.vo.LocationLiteVo getAllocatedWard()
	{
		return this.allocatedward;
	}
	public void setAllocatedWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.allocatedward = value;
	}
	public boolean getElectiveAdmissionStatusIsNotNull()
	{
		return this.electiveadmissionstatus != null;
	}
	public ims.core.vo.lookups.ElectiveAdmissionStatus getElectiveAdmissionStatus()
	{
		return this.electiveadmissionstatus;
	}
	public void setElectiveAdmissionStatus(ims.core.vo.lookups.ElectiveAdmissionStatus value)
	{
		this.isValidated = false;
		this.electiveadmissionstatus = value;
	}
	public boolean getWardTypeIsNotNull()
	{
		return this.wardtype != null;
	}
	public ims.core.vo.lookups.WardType getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.core.vo.lookups.WardType value)
	{
		this.isValidated = false;
		this.wardtype = value;
	}
	public boolean getTCITypeIsNotNull()
	{
		return this.tcitype != null;
	}
	public ims.core.vo.lookups.TCIType getTCIType()
	{
		return this.tcitype;
	}
	public void setTCIType(ims.core.vo.lookups.TCIType value)
	{
		this.isValidated = false;
		this.tcitype = value;
	}
	public boolean getTCIDateIsNotNull()
	{
		return this.tcidate != null;
	}
	public ims.framework.utils.Date getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.tcidate = value;
	}
	public boolean getTCITimeIsNotNull()
	{
		return this.tcitime != null;
	}
	public ims.framework.utils.Time getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.tcitime = value;
	}
	public boolean getAdmissionSourceIsNotNull()
	{
		return this.admissionsource != null;
	}
	public ims.core.vo.lookups.SourceOfAdmission getAdmissionSource()
	{
		return this.admissionsource;
	}
	public void setAdmissionSource(ims.core.vo.lookups.SourceOfAdmission value)
	{
		this.isValidated = false;
		this.admissionsource = value;
	}
	public boolean getReasonForAdmissionIsNotNull()
	{
		return this.reasonforadmission != null;
	}
	public String getReasonForAdmission()
	{
		return this.reasonforadmission;
	}
	public static int getReasonForAdmissionMaxLength()
	{
		return 255;
	}
	public void setReasonForAdmission(String value)
	{
		this.isValidated = false;
		this.reasonforadmission = value;
	}
	public boolean getExpectedStayIsNotNull()
	{
		return this.expectedstay != null;
	}
	public Integer getExpectedStay()
	{
		return this.expectedstay;
	}
	public void setExpectedStay(Integer value)
	{
		this.isValidated = false;
		this.expectedstay = value;
	}
	public boolean getManagementIntentionIsNotNull()
	{
		return this.managementintention != null;
	}
	public ims.core.vo.lookups.ManagementIntention getManagementIntention()
	{
		return this.managementintention;
	}
	public void setManagementIntention(ims.core.vo.lookups.ManagementIntention value)
	{
		this.isValidated = false;
		this.managementintention = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 1500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getIsMaternityIsNotNull()
	{
		return this.ismaternity != null;
	}
	public Boolean getIsMaternity()
	{
		return this.ismaternity;
	}
	public void setIsMaternity(Boolean value)
	{
		this.isValidated = false;
		this.ismaternity = value;
	}
	public boolean getProceduresIsNotNull()
	{
		return this.procedures != null;
	}
	public String[] getProcedures()
	{
		return this.procedures;
	}
	public static int getProceduresMaxLength()
	{
		return 255;
	}
	public void setProcedures(String[] value)
	{
		this.isValidated = false;
		this.procedures = value;
	}
	public boolean getAdmissionMethodIsNotNull()
	{
		return this.admissionmethod != null;
	}
	public ims.core.vo.lookups.MethodOfAdmission getAdmissionMethod()
	{
		return this.admissionmethod;
	}
	public void setAdmissionMethod(ims.core.vo.lookups.MethodOfAdmission value)
	{
		this.isValidated = false;
		this.admissionmethod = value;
	}
	public boolean getReferringConsultantIsNotNull()
	{
		return this.referringconsultant != null;
	}
	public ims.core.resource.people.vo.MedicRefVo getReferringConsultant()
	{
		return this.referringconsultant;
	}
	public void setReferringConsultant(ims.core.resource.people.vo.MedicRefVo value)
	{
		this.isValidated = false;
		this.referringconsultant = value;
	}
	public boolean getPatientStatusIsNotNull()
	{
		return this.patientstatus != null;
	}
	public ims.core.vo.lookups.PatientStatus getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.core.vo.lookups.PatientStatus value)
	{
		this.isValidated = false;
		this.patientstatus = value;
	}
	/**
	* getPatientString
	*/
		public String getPatientString()
		{
			if(this.getPasEventIsNotNull() && this.getPasEvent().getPatientIsNotNull() && this.getPasEvent().getPatient().getNameIsNotNull())
				return this.getPasEvent().getPatient().getName().toShortForm();
			
			return "";
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
		if(this.pasevent != null)
		{
			if(!this.pasevent.isValidated())
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
		if(this.pasevent == null)
			listOfErrors.add("pasEvent is mandatory");
		if(this.pasevent != null)
		{
			String[] listOfOtherErrors = this.pasevent.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.allocatedward == null)
			listOfErrors.add("AllocatedWard is mandatory");
		if(this.electiveadmissionstatus == null)
			listOfErrors.add("ElectiveAdmissionStatus is mandatory");
		if(this.tcitype == null)
			listOfErrors.add("TCIType is mandatory");
		if(this.tcidate == null)
			listOfErrors.add("TCIDate is mandatory");
		if(this.reasonforadmission != null)
			if(this.reasonforadmission.length() > 255)
				listOfErrors.add("The length of the field [reasonforadmission] in the value object [ims.core.vo.PendingElectiveAdmissionHl7Vo] is too big. It should be less or equal to 255");
		if(this.comments != null)
			if(this.comments.length() > 1500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.core.vo.PendingElectiveAdmissionHl7Vo] is too big. It should be less or equal to 1500");
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
	
		PendingElectiveAdmissionHl7Vo clone = new PendingElectiveAdmissionHl7Vo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventVo)this.pasevent.clone();
		if(this.allocatedward == null)
			clone.allocatedward = null;
		else
			clone.allocatedward = (ims.core.vo.LocationLiteVo)this.allocatedward.clone();
		if(this.electiveadmissionstatus == null)
			clone.electiveadmissionstatus = null;
		else
			clone.electiveadmissionstatus = (ims.core.vo.lookups.ElectiveAdmissionStatus)this.electiveadmissionstatus.clone();
		if(this.wardtype == null)
			clone.wardtype = null;
		else
			clone.wardtype = (ims.core.vo.lookups.WardType)this.wardtype.clone();
		if(this.tcitype == null)
			clone.tcitype = null;
		else
			clone.tcitype = (ims.core.vo.lookups.TCIType)this.tcitype.clone();
		if(this.tcidate == null)
			clone.tcidate = null;
		else
			clone.tcidate = (ims.framework.utils.Date)this.tcidate.clone();
		if(this.tcitime == null)
			clone.tcitime = null;
		else
			clone.tcitime = (ims.framework.utils.Time)this.tcitime.clone();
		if(this.admissionsource == null)
			clone.admissionsource = null;
		else
			clone.admissionsource = (ims.core.vo.lookups.SourceOfAdmission)this.admissionsource.clone();
		clone.reasonforadmission = this.reasonforadmission;
		clone.expectedstay = this.expectedstay;
		if(this.managementintention == null)
			clone.managementintention = null;
		else
			clone.managementintention = (ims.core.vo.lookups.ManagementIntention)this.managementintention.clone();
		clone.comments = this.comments;
		clone.ismaternity = this.ismaternity;
		clone.procedures = this.procedures;
		if(this.admissionmethod == null)
			clone.admissionmethod = null;
		else
			clone.admissionmethod = (ims.core.vo.lookups.MethodOfAdmission)this.admissionmethod.clone();
		clone.referringconsultant = this.referringconsultant;
		if(this.patientstatus == null)
			clone.patientstatus = null;
		else
			clone.patientstatus = (ims.core.vo.lookups.PatientStatus)this.patientstatus.clone();
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
		if (!(PendingElectiveAdmissionHl7Vo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PendingElectiveAdmissionHl7Vo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PendingElectiveAdmissionHl7Vo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PendingElectiveAdmissionHl7Vo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pasevent != null)
			count++;
		if(this.allocatedward != null)
			count++;
		if(this.electiveadmissionstatus != null)
			count++;
		if(this.wardtype != null)
			count++;
		if(this.tcitype != null)
			count++;
		if(this.tcidate != null)
			count++;
		if(this.tcitime != null)
			count++;
		if(this.admissionsource != null)
			count++;
		if(this.reasonforadmission != null)
			count++;
		if(this.expectedstay != null)
			count++;
		if(this.managementintention != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.ismaternity != null)
			count++;
		if(this.procedures != null)
			count++;
		if(this.admissionmethod != null)
			count++;
		if(this.referringconsultant != null)
			count++;
		if(this.patientstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.core.vo.PasEventVo pasevent;
	protected ims.core.vo.LocationLiteVo allocatedward;
	protected ims.core.vo.lookups.ElectiveAdmissionStatus electiveadmissionstatus;
	protected ims.core.vo.lookups.WardType wardtype;
	protected ims.core.vo.lookups.TCIType tcitype;
	protected ims.framework.utils.Date tcidate;
	protected ims.framework.utils.Time tcitime;
	protected ims.core.vo.lookups.SourceOfAdmission admissionsource;
	protected String reasonforadmission;
	protected Integer expectedstay;
	protected ims.core.vo.lookups.ManagementIntention managementintention;
	protected String comments;
	protected Boolean ismaternity;
	protected String[] procedures;
	protected ims.core.vo.lookups.MethodOfAdmission admissionmethod;
	protected ims.core.resource.people.vo.MedicRefVo referringconsultant;
	protected ims.core.vo.lookups.PatientStatus patientstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
