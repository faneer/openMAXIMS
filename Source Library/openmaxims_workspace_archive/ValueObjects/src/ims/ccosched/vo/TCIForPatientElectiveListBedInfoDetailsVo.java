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

package ims.ccosched.vo;

/**
 * Linked to RefMan.TCIForPatientElectiveList business object (ID: 1096100064).
 */
public class TCIForPatientElectiveListBedInfoDetailsVo extends ims.RefMan.vo.TCIForPatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TCIForPatientElectiveListBedInfoDetailsVo()
	{
	}
	public TCIForPatientElectiveListBedInfoDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public TCIForPatientElectiveListBedInfoDetailsVo(ims.ccosched.vo.beans.TCIForPatientElectiveListBedInfoDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.tciward = bean.getTCIWard() == null ? null : bean.getTCIWard().buildVo();
		this.tcibed = bean.getTCIBed();
		this.bedmanagercomment = bean.getBedManagerComment();
		this.tciconsultant = bean.getTCIConsultant() == null ? null : bean.getTCIConsultant().buildVo();
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : bean.getAdmissionDetail().buildVo();
		this.currentoutcome = bean.getCurrentOutcome() == null ? null : bean.getCurrentOutcome().buildVo();
		if(bean.getOutcomeHistory() != null)
		{
			this.outcomehistory = new ims.RefMan.vo.TCIOutcomeForPatientElectiveListRefVoCollection();
			for(int outcomehistory_i = 0; outcomehistory_i < bean.getOutcomeHistory().length; outcomehistory_i++)
			{
				this.outcomehistory.add(new ims.RefMan.vo.TCIOutcomeForPatientElectiveListRefVo(new Integer(bean.getOutcomeHistory()[outcomehistory_i].getId()), bean.getOutcomeHistory()[outcomehistory_i].getVersion()));
			}
		}
		this.isactive = bean.getIsActive();
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ccosched.vo.beans.TCIForPatientElectiveListBedInfoDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.tciward = bean.getTCIWard() == null ? null : bean.getTCIWard().buildVo(map);
		this.tcibed = bean.getTCIBed();
		this.bedmanagercomment = bean.getBedManagerComment();
		this.tciconsultant = bean.getTCIConsultant() == null ? null : bean.getTCIConsultant().buildVo(map);
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : bean.getAdmissionDetail().buildVo(map);
		this.currentoutcome = bean.getCurrentOutcome() == null ? null : bean.getCurrentOutcome().buildVo(map);
		if(bean.getOutcomeHistory() != null)
		{
			this.outcomehistory = new ims.RefMan.vo.TCIOutcomeForPatientElectiveListRefVoCollection();
			for(int outcomehistory_i = 0; outcomehistory_i < bean.getOutcomeHistory().length; outcomehistory_i++)
			{
				this.outcomehistory.add(new ims.RefMan.vo.TCIOutcomeForPatientElectiveListRefVo(new Integer(bean.getOutcomeHistory()[outcomehistory_i].getId()), bean.getOutcomeHistory()[outcomehistory_i].getVersion()));
			}
		}
		this.isactive = bean.getIsActive();
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ccosched.vo.beans.TCIForPatientElectiveListBedInfoDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.ccosched.vo.beans.TCIForPatientElectiveListBedInfoDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ccosched.vo.beans.TCIForPatientElectiveListBedInfoDetailsVoBean();
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
		if(fieldName.equals("TCIDATE"))
			return getTCIDate();
		if(fieldName.equals("TCITIME"))
			return getTCITime();
		if(fieldName.equals("TCIWARD"))
			return getTCIWard();
		if(fieldName.equals("TCIBED"))
			return getTCIBed();
		if(fieldName.equals("BEDMANAGERCOMMENT"))
			return getBedManagerComment();
		if(fieldName.equals("TCICONSULTANT"))
			return getTCIConsultant();
		if(fieldName.equals("ADMISSIONDETAIL"))
			return getAdmissionDetail();
		if(fieldName.equals("CURRENTOUTCOME"))
			return getCurrentOutcome();
		if(fieldName.equals("OUTCOMEHISTORY"))
			return getOutcomeHistory();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getTCIWardIsNotNull()
	{
		return this.tciward != null;
	}
	public ims.core.vo.LocationLiteVo getTCIWard()
	{
		return this.tciward;
	}
	public void setTCIWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.tciward = value;
	}
	public boolean getTCIBedIsNotNull()
	{
		return this.tcibed != null;
	}
	public String getTCIBed()
	{
		return this.tcibed;
	}
	public static int getTCIBedMaxLength()
	{
		return 255;
	}
	public void setTCIBed(String value)
	{
		this.isValidated = false;
		this.tcibed = value;
	}
	public boolean getBedManagerCommentIsNotNull()
	{
		return this.bedmanagercomment != null;
	}
	public String getBedManagerComment()
	{
		return this.bedmanagercomment;
	}
	public static int getBedManagerCommentMaxLength()
	{
		return 1000;
	}
	public void setBedManagerComment(String value)
	{
		this.isValidated = false;
		this.bedmanagercomment = value;
	}
	public boolean getTCIConsultantIsNotNull()
	{
		return this.tciconsultant != null;
	}
	public ims.core.vo.HcpLiteVo getTCIConsultant()
	{
		return this.tciconsultant;
	}
	public void setTCIConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.tciconsultant = value;
	}
	public boolean getAdmissionDetailIsNotNull()
	{
		return this.admissiondetail != null;
	}
	public ims.core.vo.AdmissionDetailVo getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.core.vo.AdmissionDetailVo value)
	{
		this.isValidated = false;
		this.admissiondetail = value;
	}
	public boolean getCurrentOutcomeIsNotNull()
	{
		return this.currentoutcome != null;
	}
	public ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo getCurrentOutcome()
	{
		return this.currentoutcome;
	}
	public void setCurrentOutcome(ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo value)
	{
		this.isValidated = false;
		this.currentoutcome = value;
	}
	public boolean getOutcomeHistoryIsNotNull()
	{
		return this.outcomehistory != null;
	}
	public ims.RefMan.vo.TCIOutcomeForPatientElectiveListRefVoCollection getOutcomeHistory()
	{
		return this.outcomehistory;
	}
	public void setOutcomeHistory(ims.RefMan.vo.TCIOutcomeForPatientElectiveListRefVoCollection value)
	{
		this.isValidated = false;
		this.outcomehistory = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.scheduling.vo.BookingAppointmentTheatreVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.BookingAppointmentTheatreVo value)
	{
		this.isValidated = false;
		this.appointment = value;
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
		if(this.admissiondetail != null)
		{
			if(!this.admissiondetail.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentoutcome != null)
		{
			if(!this.currentoutcome.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.appointment != null)
		{
			if(!this.appointment.isValidated())
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
		if(this.tcidate == null)
			listOfErrors.add("TCIDate is mandatory");
		if(this.tcibed != null)
			if(this.tcibed.length() > 255)
				listOfErrors.add("The length of the field [tcibed] in the value object [ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo] is too big. It should be less or equal to 255");
		if(this.bedmanagercomment != null)
			if(this.bedmanagercomment.length() > 1000)
				listOfErrors.add("The length of the field [bedmanagercomment] in the value object [ims.ccosched.vo.TCIForPatientElectiveListBedInfoDetailsVo] is too big. It should be less or equal to 1000");
		if(this.admissiondetail != null)
		{
			String[] listOfOtherErrors = this.admissiondetail.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentoutcome != null)
		{
			String[] listOfOtherErrors = this.currentoutcome.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
		if(this.appointment != null)
		{
			String[] listOfOtherErrors = this.appointment.validate();
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
	
		TCIForPatientElectiveListBedInfoDetailsVo clone = new TCIForPatientElectiveListBedInfoDetailsVo(this.id, this.version);
		
		if(this.tcidate == null)
			clone.tcidate = null;
		else
			clone.tcidate = (ims.framework.utils.Date)this.tcidate.clone();
		if(this.tcitime == null)
			clone.tcitime = null;
		else
			clone.tcitime = (ims.framework.utils.Time)this.tcitime.clone();
		if(this.tciward == null)
			clone.tciward = null;
		else
			clone.tciward = (ims.core.vo.LocationLiteVo)this.tciward.clone();
		clone.tcibed = this.tcibed;
		clone.bedmanagercomment = this.bedmanagercomment;
		if(this.tciconsultant == null)
			clone.tciconsultant = null;
		else
			clone.tciconsultant = (ims.core.vo.HcpLiteVo)this.tciconsultant.clone();
		if(this.admissiondetail == null)
			clone.admissiondetail = null;
		else
			clone.admissiondetail = (ims.core.vo.AdmissionDetailVo)this.admissiondetail.clone();
		if(this.currentoutcome == null)
			clone.currentoutcome = null;
		else
			clone.currentoutcome = (ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo)this.currentoutcome.clone();
		clone.outcomehistory = this.outcomehistory;
		clone.isactive = this.isactive;
		if(this.appointment == null)
			clone.appointment = null;
		else
			clone.appointment = (ims.scheduling.vo.BookingAppointmentTheatreVo)this.appointment.clone();
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
		if (!(TCIForPatientElectiveListBedInfoDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TCIForPatientElectiveListBedInfoDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TCIForPatientElectiveListBedInfoDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TCIForPatientElectiveListBedInfoDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.tcidate != null)
			count++;
		if(this.tcitime != null)
			count++;
		if(this.tciward != null)
			count++;
		if(this.tcibed != null)
			count++;
		if(this.bedmanagercomment != null)
			count++;
		if(this.tciconsultant != null)
			count++;
		if(this.admissiondetail != null)
			count++;
		if(this.currentoutcome != null)
			count++;
		if(this.outcomehistory != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.appointment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.framework.utils.Date tcidate;
	protected ims.framework.utils.Time tcitime;
	protected ims.core.vo.LocationLiteVo tciward;
	protected String tcibed;
	protected String bedmanagercomment;
	protected ims.core.vo.HcpLiteVo tciconsultant;
	protected ims.core.vo.AdmissionDetailVo admissiondetail;
	protected ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo currentoutcome;
	protected ims.RefMan.vo.TCIOutcomeForPatientElectiveListRefVoCollection outcomehistory;
	protected Boolean isactive;
	protected ims.scheduling.vo.BookingAppointmentTheatreVo appointment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
