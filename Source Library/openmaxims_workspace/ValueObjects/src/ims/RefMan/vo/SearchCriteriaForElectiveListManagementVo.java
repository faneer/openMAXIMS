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


public class SearchCriteriaForElectiveListManagementVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SearchCriteriaForElectiveListManagementVo()
	{
	}
	public SearchCriteriaForElectiveListManagementVo(ims.RefMan.vo.beans.SearchCriteriaForElectiveListManagementVoBean bean)
	{
		this.type = ims.RefMan.vo.lookups.ElectiveAdmissionTypeCollection.buildFromBeanCollection(bean.getType());
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.RefMan.vo.lookups.WaitingCardAdmissionType.buildLookup(bean.getAdmissionType());
		this.urgency = bean.getUrgency() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getUrgency());
		this.onlycancerreferrals = bean.getOnlyCancerReferrals();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.electivelistname = bean.getElectiveListName() == null ? null : bean.getElectiveListName().buildVo();
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.electiveliststatus = bean.getElectiveListStatus();
		this.electiveliststatusrequirestcisuboption = bean.getElectiveListStatusRequiresTCISubOption();
		this.shortnotice = bean.getShortNotice();
		this.daysnoticerequired = bean.getDaysNoticeRequired();
		this.rttbreachin = bean.getRTTBreachIn();
		this.rttbreachinperiod = bean.getRTTBreachInPeriod() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getRTTBreachInPeriod());
		this.includepatientsrttbreached = bean.getIncludePatientsRTTBreached();
		this.planneddatein = bean.getPlannedDateIn();
		this.planneddateinperiod = bean.getPlannedDateInPeriod() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getPlannedDateInPeriod());
		this.includepatientspastplanneddates = bean.getIncludePatientsPastPlannedDates();
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.SearchCriteriaForElectiveListManagementVoBean bean)
	{
		this.type = ims.RefMan.vo.lookups.ElectiveAdmissionTypeCollection.buildFromBeanCollection(bean.getType());
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.RefMan.vo.lookups.WaitingCardAdmissionType.buildLookup(bean.getAdmissionType());
		this.urgency = bean.getUrgency() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getUrgency());
		this.onlycancerreferrals = bean.getOnlyCancerReferrals();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.electivelistname = bean.getElectiveListName() == null ? null : bean.getElectiveListName().buildVo(map);
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.electiveliststatus = bean.getElectiveListStatus();
		this.electiveliststatusrequirestcisuboption = bean.getElectiveListStatusRequiresTCISubOption();
		this.shortnotice = bean.getShortNotice();
		this.daysnoticerequired = bean.getDaysNoticeRequired();
		this.rttbreachin = bean.getRTTBreachIn();
		this.rttbreachinperiod = bean.getRTTBreachInPeriod() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getRTTBreachInPeriod());
		this.includepatientsrttbreached = bean.getIncludePatientsRTTBreached();
		this.planneddatein = bean.getPlannedDateIn();
		this.planneddateinperiod = bean.getPlannedDateInPeriod() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToMonths.buildLookup(bean.getPlannedDateInPeriod());
		this.includepatientspastplanneddates = bean.getIncludePatientsPastPlannedDates();
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.SearchCriteriaForElectiveListManagementVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.SearchCriteriaForElectiveListManagementVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.SearchCriteriaForElectiveListManagementVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.RefMan.vo.lookups.ElectiveAdmissionTypeCollection getType()
	{
		return this.type;
	}
	public void setType(ims.RefMan.vo.lookups.ElectiveAdmissionTypeCollection value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getAdmissionTypeIsNotNull()
	{
		return this.admissiontype != null;
	}
	public ims.RefMan.vo.lookups.WaitingCardAdmissionType getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.RefMan.vo.lookups.WaitingCardAdmissionType value)
	{
		this.isValidated = false;
		this.admissiontype = value;
	}
	public boolean getUrgencyIsNotNull()
	{
		return this.urgency != null;
	}
	public ims.RefMan.vo.lookups.ReferralUrgency getUrgency()
	{
		return this.urgency;
	}
	public void setUrgency(ims.RefMan.vo.lookups.ReferralUrgency value)
	{
		this.isValidated = false;
		this.urgency = value;
	}
	public boolean getOnlyCancerReferralsIsNotNull()
	{
		return this.onlycancerreferrals != null;
	}
	public Boolean getOnlyCancerReferrals()
	{
		return this.onlycancerreferrals;
	}
	public void setOnlyCancerReferrals(Boolean value)
	{
		this.isValidated = false;
		this.onlycancerreferrals = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.admin.vo.ServiceForElectiveListConfigVo getService()
	{
		return this.service;
	}
	public void setService(ims.admin.vo.ServiceForElectiveListConfigVo value)
	{
		this.isValidated = false;
		this.service = value;
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
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getElectiveListNameIsNotNull()
	{
		return this.electivelistname != null;
	}
	public ims.admin.vo.ElectiveListConfigLiteVo getElectiveListName()
	{
		return this.electivelistname;
	}
	public void setElectiveListName(ims.admin.vo.ElectiveListConfigLiteVo value)
	{
		this.isValidated = false;
		this.electivelistname = value;
	}
	public boolean getTheatreTypeIsNotNull()
	{
		return this.theatretype != null;
	}
	public ims.scheduling.vo.lookups.TheatreType getTheatreType()
	{
		return this.theatretype;
	}
	public void setTheatreType(ims.scheduling.vo.lookups.TheatreType value)
	{
		this.isValidated = false;
		this.theatretype = value;
	}
	public boolean getAnaestheticTypeIsNotNull()
	{
		return this.anaesthetictype != null;
	}
	public ims.clinical.vo.lookups.AnaestheticType getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.clinical.vo.lookups.AnaestheticType value)
	{
		this.isValidated = false;
		this.anaesthetictype = value;
	}
	public boolean getElectiveListStatusIsNotNull()
	{
		return this.electiveliststatus != null;
	}
	public Integer getElectiveListStatus()
	{
		return this.electiveliststatus;
	}
	public void setElectiveListStatus(Integer value)
	{
		this.isValidated = false;
		this.electiveliststatus = value;
	}
	public boolean getElectiveListStatusRequiresTCISubOptionIsNotNull()
	{
		return this.electiveliststatusrequirestcisuboption != null;
	}
	public Integer getElectiveListStatusRequiresTCISubOption()
	{
		return this.electiveliststatusrequirestcisuboption;
	}
	public void setElectiveListStatusRequiresTCISubOption(Integer value)
	{
		this.isValidated = false;
		this.electiveliststatusrequirestcisuboption = value;
	}
	public boolean getShortNoticeIsNotNull()
	{
		return this.shortnotice != null;
	}
	public Boolean getShortNotice()
	{
		return this.shortnotice;
	}
	public void setShortNotice(Boolean value)
	{
		this.isValidated = false;
		this.shortnotice = value;
	}
	public boolean getDaysNoticeRequiredIsNotNull()
	{
		return this.daysnoticerequired != null;
	}
	public Integer getDaysNoticeRequired()
	{
		return this.daysnoticerequired;
	}
	public void setDaysNoticeRequired(Integer value)
	{
		this.isValidated = false;
		this.daysnoticerequired = value;
	}
	public boolean getRTTBreachInIsNotNull()
	{
		return this.rttbreachin != null;
	}
	public Integer getRTTBreachIn()
	{
		return this.rttbreachin;
	}
	public void setRTTBreachIn(Integer value)
	{
		this.isValidated = false;
		this.rttbreachin = value;
	}
	public boolean getRTTBreachInPeriodIsNotNull()
	{
		return this.rttbreachinperiod != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToMonths getRTTBreachInPeriod()
	{
		return this.rttbreachinperiod;
	}
	public void setRTTBreachInPeriod(ims.core.vo.lookups.TimeUnitsSecondsToMonths value)
	{
		this.isValidated = false;
		this.rttbreachinperiod = value;
	}
	public boolean getIncludePatientsRTTBreachedIsNotNull()
	{
		return this.includepatientsrttbreached != null;
	}
	public Boolean getIncludePatientsRTTBreached()
	{
		return this.includepatientsrttbreached;
	}
	public void setIncludePatientsRTTBreached(Boolean value)
	{
		this.isValidated = false;
		this.includepatientsrttbreached = value;
	}
	public boolean getPlannedDateInIsNotNull()
	{
		return this.planneddatein != null;
	}
	public Integer getPlannedDateIn()
	{
		return this.planneddatein;
	}
	public void setPlannedDateIn(Integer value)
	{
		this.isValidated = false;
		this.planneddatein = value;
	}
	public boolean getPlannedDateInPeriodIsNotNull()
	{
		return this.planneddateinperiod != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToMonths getPlannedDateInPeriod()
	{
		return this.planneddateinperiod;
	}
	public void setPlannedDateInPeriod(ims.core.vo.lookups.TimeUnitsSecondsToMonths value)
	{
		this.isValidated = false;
		this.planneddateinperiod = value;
	}
	public boolean getIncludePatientsPastPlannedDatesIsNotNull()
	{
		return this.includepatientspastplanneddates != null;
	}
	public Boolean getIncludePatientsPastPlannedDates()
	{
		return this.includepatientspastplanneddates;
	}
	public void setIncludePatientsPastPlannedDates(Boolean value)
	{
		this.isValidated = false;
		this.includepatientspastplanneddates = value;
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
	/**
	* equals
	*/
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
	
	/**
	* compareTo
	*/
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
	
		return 0;
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
	
		SearchCriteriaForElectiveListManagementVo clone = new SearchCriteriaForElectiveListManagementVo();
		
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.RefMan.vo.lookups.ElectiveAdmissionTypeCollection)this.type.clone();
		if(this.admissiontype == null)
			clone.admissiontype = null;
		else
			clone.admissiontype = (ims.RefMan.vo.lookups.WaitingCardAdmissionType)this.admissiontype.clone();
		if(this.urgency == null)
			clone.urgency = null;
		else
			clone.urgency = (ims.RefMan.vo.lookups.ReferralUrgency)this.urgency.clone();
		clone.onlycancerreferrals = this.onlycancerreferrals;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.admin.vo.ServiceForElectiveListConfigVo)this.service.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		if(this.electivelistname == null)
			clone.electivelistname = null;
		else
			clone.electivelistname = (ims.admin.vo.ElectiveListConfigLiteVo)this.electivelistname.clone();
		if(this.theatretype == null)
			clone.theatretype = null;
		else
			clone.theatretype = (ims.scheduling.vo.lookups.TheatreType)this.theatretype.clone();
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticType)this.anaesthetictype.clone();
		clone.electiveliststatus = this.electiveliststatus;
		clone.electiveliststatusrequirestcisuboption = this.electiveliststatusrequirestcisuboption;
		clone.shortnotice = this.shortnotice;
		clone.daysnoticerequired = this.daysnoticerequired;
		clone.rttbreachin = this.rttbreachin;
		if(this.rttbreachinperiod == null)
			clone.rttbreachinperiod = null;
		else
			clone.rttbreachinperiod = (ims.core.vo.lookups.TimeUnitsSecondsToMonths)this.rttbreachinperiod.clone();
		clone.includepatientsrttbreached = this.includepatientsrttbreached;
		clone.planneddatein = this.planneddatein;
		if(this.planneddateinperiod == null)
			clone.planneddateinperiod = null;
		else
			clone.planneddateinperiod = (ims.core.vo.lookups.TimeUnitsSecondsToMonths)this.planneddateinperiod.clone();
		clone.includepatientspastplanneddates = this.includepatientspastplanneddates;
		if(this.hospital == null)
			clone.hospital = null;
		else
			clone.hospital = (ims.core.vo.LocationLiteVo)this.hospital.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.type != null)
			count++;
		if(this.admissiontype != null)
			count++;
		if(this.urgency != null)
			count++;
		if(this.onlycancerreferrals != null)
			count++;
		if(this.service != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.electivelistname != null)
			count++;
		if(this.theatretype != null)
			count++;
		if(this.anaesthetictype != null)
			count++;
		if(this.electiveliststatus != null)
			count++;
		if(this.electiveliststatusrequirestcisuboption != null)
			count++;
		if(this.shortnotice != null)
			count++;
		if(this.daysnoticerequired != null)
			count++;
		if(this.rttbreachin != null)
			count++;
		if(this.rttbreachinperiod != null)
			count++;
		if(this.includepatientsrttbreached != null)
			count++;
		if(this.planneddatein != null)
			count++;
		if(this.planneddateinperiod != null)
			count++;
		if(this.includepatientspastplanneddates != null)
			count++;
		if(this.hospital != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 21;
	}
	protected ims.RefMan.vo.lookups.ElectiveAdmissionTypeCollection type;
	protected ims.RefMan.vo.lookups.WaitingCardAdmissionType admissiontype;
	protected ims.RefMan.vo.lookups.ReferralUrgency urgency;
	protected Boolean onlycancerreferrals;
	protected ims.admin.vo.ServiceForElectiveListConfigVo service;
	protected ims.core.vo.HcpLiteVo consultant;
	protected ims.core.vo.ProcedureLiteVo procedure;
	protected ims.admin.vo.ElectiveListConfigLiteVo electivelistname;
	protected ims.scheduling.vo.lookups.TheatreType theatretype;
	protected ims.clinical.vo.lookups.AnaestheticType anaesthetictype;
	protected Integer electiveliststatus;
	protected Integer electiveliststatusrequirestcisuboption;
	protected Boolean shortnotice;
	protected Integer daysnoticerequired;
	protected Integer rttbreachin;
	protected ims.core.vo.lookups.TimeUnitsSecondsToMonths rttbreachinperiod;
	protected Boolean includepatientsrttbreached;
	protected Integer planneddatein;
	protected ims.core.vo.lookups.TimeUnitsSecondsToMonths planneddateinperiod;
	protected Boolean includepatientspastplanneddates;
	protected ims.core.vo.LocationLiteVo hospital;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
