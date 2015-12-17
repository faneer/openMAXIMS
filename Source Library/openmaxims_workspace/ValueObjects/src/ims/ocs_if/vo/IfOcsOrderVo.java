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

package ims.ocs_if.vo;

/**
 * Linked to OCRR.OrderingResults.OcsOrderSession business object (ID: 1070100000).
 */
public class IfOcsOrderVo extends ims.ocs_if.vo.IfOcsOrderShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfOcsOrderVo()
	{
	}
	public IfOcsOrderVo(Integer id, int version)
	{
		super(id, version);
	}
	public IfOcsOrderVo(ims.ocs_if.vo.beans.IfOcsOrderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.orderedby = bean.getOrderedBy() == null ? null : bean.getOrderedBy().buildVo();
		this.responsibleclinician = bean.getResponsibleClinician() == null ? null : bean.getResponsibleClinician().buildVo();
		this.responsiblegp = bean.getResponsibleGp() == null ? null : bean.getResponsibleGp().buildVo();
		this.patientlocation = bean.getPatientLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getPatientLocation().getId()), bean.getPatientLocation().getVersion());
		this.patientclinic = bean.getPatientClinic() == null ? null : new ims.core.resource.place.vo.ClinicRefVo(new Integer(bean.getPatientClinic().getId()), bean.getPatientClinic().getVersion());
		this.additclinnotes = bean.getAdditClinNotes();
		this.sendnumber = bean.getSendNumber();
		this.investigations = ims.ocs_if.vo.IfOrderInvestigationVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.clinicaltrial = bean.getClinicalTrial();
		this.clinicaltrialtxt = bean.getClinicalTrialTxt();
		this.patmobility = bean.getPatMobility() == null ? null : ims.ocrr.vo.lookups.OrderPatMobility.buildLookup(bean.getPatMobility());
		this.ordercategory = bean.getOrderCategory() == null ? null : ims.ocrr.vo.lookups.OrderCategory.buildLookup(bean.getOrderCategory());
		this.specimens = ims.ocs_if.vo.IfOrderSpecimenVoCollection.buildFromBeanCollection(bean.getSpecimens());
		this.wasprocessed = bean.getWasProcessed();
		this.orderinghospital = bean.getOrderingHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getOrderingHospital().getId()), bean.getOrderingHospital().getVersion());
		this.authorisationorderstatus = bean.getAuthorisationOrderStatus() == null ? null : ims.ocrr.vo.lookups.AuthorisationOrderStatus.buildLookup(bean.getAuthorisationOrderStatus());
		this.outpatientdept = bean.getOutpatientDept() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getOutpatientDept().getId()), bean.getOutpatientDept().getVersion());
		this.primaryidvalueused = bean.getPrimaryIdValueUsed();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.IfOcsOrderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.orderedby = bean.getOrderedBy() == null ? null : bean.getOrderedBy().buildVo(map);
		this.responsibleclinician = bean.getResponsibleClinician() == null ? null : bean.getResponsibleClinician().buildVo(map);
		this.responsiblegp = bean.getResponsibleGp() == null ? null : bean.getResponsibleGp().buildVo(map);
		this.patientlocation = bean.getPatientLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getPatientLocation().getId()), bean.getPatientLocation().getVersion());
		this.patientclinic = bean.getPatientClinic() == null ? null : new ims.core.resource.place.vo.ClinicRefVo(new Integer(bean.getPatientClinic().getId()), bean.getPatientClinic().getVersion());
		this.additclinnotes = bean.getAdditClinNotes();
		this.sendnumber = bean.getSendNumber();
		this.investigations = ims.ocs_if.vo.IfOrderInvestigationVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.clinicaltrial = bean.getClinicalTrial();
		this.clinicaltrialtxt = bean.getClinicalTrialTxt();
		this.patmobility = bean.getPatMobility() == null ? null : ims.ocrr.vo.lookups.OrderPatMobility.buildLookup(bean.getPatMobility());
		this.ordercategory = bean.getOrderCategory() == null ? null : ims.ocrr.vo.lookups.OrderCategory.buildLookup(bean.getOrderCategory());
		this.specimens = ims.ocs_if.vo.IfOrderSpecimenVoCollection.buildFromBeanCollection(bean.getSpecimens());
		this.wasprocessed = bean.getWasProcessed();
		this.orderinghospital = bean.getOrderingHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getOrderingHospital().getId()), bean.getOrderingHospital().getVersion());
		this.authorisationorderstatus = bean.getAuthorisationOrderStatus() == null ? null : ims.ocrr.vo.lookups.AuthorisationOrderStatus.buildLookup(bean.getAuthorisationOrderStatus());
		this.outpatientdept = bean.getOutpatientDept() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getOutpatientDept().getId()), bean.getOutpatientDept().getVersion());
		this.primaryidvalueused = bean.getPrimaryIdValueUsed();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.IfOcsOrderVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.IfOcsOrderVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.IfOcsOrderVoBean();
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
		if(fieldName.equals("INVESTIGATIONS"))
			return getInvestigations();
		if(fieldName.equals("CLINICALTRIAL"))
			return getClinicalTrial();
		if(fieldName.equals("CLINICALTRIALTXT"))
			return getClinicalTrialTxt();
		if(fieldName.equals("PATMOBILITY"))
			return getPatMobility();
		if(fieldName.equals("ORDERCATEGORY"))
			return getOrderCategory();
		if(fieldName.equals("SPECIMENS"))
			return getSpecimens();
		if(fieldName.equals("WASPROCESSED"))
			return getWasProcessed();
		if(fieldName.equals("ORDERINGHOSPITAL"))
			return getOrderingHospital();
		if(fieldName.equals("AUTHORISATIONORDERSTATUS"))
			return getAuthorisationOrderStatus();
		if(fieldName.equals("OUTPATIENTDEPT"))
			return getOutpatientDept();
		if(fieldName.equals("PRIMARYIDVALUEUSED"))
			return getPrimaryIdValueUsed();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationsIsNotNull()
	{
		return this.investigations != null;
	}
	public ims.ocs_if.vo.IfOrderInvestigationVoCollection getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocs_if.vo.IfOrderInvestigationVoCollection value)
	{
		this.isValidated = false;
		this.investigations = value;
	}
	public boolean getClinicalTrialIsNotNull()
	{
		return this.clinicaltrial != null;
	}
	public Boolean getClinicalTrial()
	{
		return this.clinicaltrial;
	}
	public void setClinicalTrial(Boolean value)
	{
		this.isValidated = false;
		this.clinicaltrial = value;
	}
	public boolean getClinicalTrialTxtIsNotNull()
	{
		return this.clinicaltrialtxt != null;
	}
	public String getClinicalTrialTxt()
	{
		return this.clinicaltrialtxt;
	}
	public static int getClinicalTrialTxtMaxLength()
	{
		return 150;
	}
	public void setClinicalTrialTxt(String value)
	{
		this.isValidated = false;
		this.clinicaltrialtxt = value;
	}
	public boolean getPatMobilityIsNotNull()
	{
		return this.patmobility != null;
	}
	public ims.ocrr.vo.lookups.OrderPatMobility getPatMobility()
	{
		return this.patmobility;
	}
	public void setPatMobility(ims.ocrr.vo.lookups.OrderPatMobility value)
	{
		this.isValidated = false;
		this.patmobility = value;
	}
	public boolean getOrderCategoryIsNotNull()
	{
		return this.ordercategory != null;
	}
	public ims.ocrr.vo.lookups.OrderCategory getOrderCategory()
	{
		return this.ordercategory;
	}
	public void setOrderCategory(ims.ocrr.vo.lookups.OrderCategory value)
	{
		this.isValidated = false;
		this.ordercategory = value;
	}
	public boolean getSpecimensIsNotNull()
	{
		return this.specimens != null;
	}
	public ims.ocs_if.vo.IfOrderSpecimenVoCollection getSpecimens()
	{
		return this.specimens;
	}
	public void setSpecimens(ims.ocs_if.vo.IfOrderSpecimenVoCollection value)
	{
		this.isValidated = false;
		this.specimens = value;
	}
	public boolean getWasProcessedIsNotNull()
	{
		return this.wasprocessed != null;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.isValidated = false;
		this.wasprocessed = value;
	}
	public boolean getOrderingHospitalIsNotNull()
	{
		return this.orderinghospital != null;
	}
	public ims.core.resource.place.vo.LocSiteRefVo getOrderingHospital()
	{
		return this.orderinghospital;
	}
	public void setOrderingHospital(ims.core.resource.place.vo.LocSiteRefVo value)
	{
		this.isValidated = false;
		this.orderinghospital = value;
	}
	public boolean getAuthorisationOrderStatusIsNotNull()
	{
		return this.authorisationorderstatus != null;
	}
	public ims.ocrr.vo.lookups.AuthorisationOrderStatus getAuthorisationOrderStatus()
	{
		return this.authorisationorderstatus;
	}
	public void setAuthorisationOrderStatus(ims.ocrr.vo.lookups.AuthorisationOrderStatus value)
	{
		this.isValidated = false;
		this.authorisationorderstatus = value;
	}
	public boolean getOutpatientDeptIsNotNull()
	{
		return this.outpatientdept != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getOutpatientDept()
	{
		return this.outpatientdept;
	}
	public void setOutpatientDept(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.outpatientdept = value;
	}
	public boolean getPrimaryIdValueUsedIsNotNull()
	{
		return this.primaryidvalueused != null;
	}
	public String getPrimaryIdValueUsed()
	{
		return this.primaryidvalueused;
	}
	public static int getPrimaryIdValueUsedMaxLength()
	{
		return 255;
	}
	public void setPrimaryIdValueUsed(String value)
	{
		this.isValidated = false;
		this.primaryidvalueused = value;
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
		if(this.investigations != null)
		{
			if(!this.investigations.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.specimens != null)
		{
			if(!this.specimens.isValidated())
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
		if(this.investigations == null || this.investigations.size() == 0)
			listOfErrors.add("Investigations are mandatory");
		if(this.investigations != null)
		{
			String[] listOfOtherErrors = this.investigations.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicaltrial == null)
			listOfErrors.add("ClinicalTrial is mandatory");
		if(this.clinicaltrialtxt != null)
			if(this.clinicaltrialtxt.length() > 150)
				listOfErrors.add("The length of the field [clinicaltrialtxt] in the value object [ims.ocs_if.vo.IfOcsOrderVo] is too big. It should be less or equal to 150");
		if(this.specimens != null)
		{
			String[] listOfOtherErrors = this.specimens.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.wasprocessed == null)
			listOfErrors.add("wasProcessed is mandatory");
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
	
		IfOcsOrderVo clone = new IfOcsOrderVo(this.id, this.version);
		
		clone.patient = this.patient;
		if(this.orderedby == null)
			clone.orderedby = null;
		else
			clone.orderedby = (ims.core.vo.MemberOfStaffLiteVo)this.orderedby.clone();
		if(this.responsibleclinician == null)
			clone.responsibleclinician = null;
		else
			clone.responsibleclinician = (ims.core.vo.HcpLiteVo)this.responsibleclinician.clone();
		if(this.responsiblegp == null)
			clone.responsiblegp = null;
		else
			clone.responsiblegp = (ims.core.vo.GpLiteVo)this.responsiblegp.clone();
		clone.patientlocation = this.patientlocation;
		clone.patientclinic = this.patientclinic;
		clone.additclinnotes = this.additclinnotes;
		clone.sendnumber = this.sendnumber;
		if(this.investigations == null)
			clone.investigations = null;
		else
			clone.investigations = (ims.ocs_if.vo.IfOrderInvestigationVoCollection)this.investigations.clone();
		clone.clinicaltrial = this.clinicaltrial;
		clone.clinicaltrialtxt = this.clinicaltrialtxt;
		if(this.patmobility == null)
			clone.patmobility = null;
		else
			clone.patmobility = (ims.ocrr.vo.lookups.OrderPatMobility)this.patmobility.clone();
		if(this.ordercategory == null)
			clone.ordercategory = null;
		else
			clone.ordercategory = (ims.ocrr.vo.lookups.OrderCategory)this.ordercategory.clone();
		if(this.specimens == null)
			clone.specimens = null;
		else
			clone.specimens = (ims.ocs_if.vo.IfOrderSpecimenVoCollection)this.specimens.clone();
		clone.wasprocessed = this.wasprocessed;
		clone.orderinghospital = this.orderinghospital;
		if(this.authorisationorderstatus == null)
			clone.authorisationorderstatus = null;
		else
			clone.authorisationorderstatus = (ims.ocrr.vo.lookups.AuthorisationOrderStatus)this.authorisationorderstatus.clone();
		clone.outpatientdept = this.outpatientdept;
		clone.primaryidvalueused = this.primaryidvalueused;
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
		if (!(IfOcsOrderVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfOcsOrderVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IfOcsOrderVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IfOcsOrderVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.investigations != null)
			count++;
		if(this.clinicaltrial != null)
			count++;
		if(this.clinicaltrialtxt != null)
			count++;
		if(this.patmobility != null)
			count++;
		if(this.ordercategory != null)
			count++;
		if(this.specimens != null)
			count++;
		if(this.wasprocessed != null)
			count++;
		if(this.orderinghospital != null)
			count++;
		if(this.authorisationorderstatus != null)
			count++;
		if(this.outpatientdept != null)
			count++;
		if(this.primaryidvalueused != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 11;
	}
	protected ims.ocs_if.vo.IfOrderInvestigationVoCollection investigations;
	protected Boolean clinicaltrial;
	protected String clinicaltrialtxt;
	protected ims.ocrr.vo.lookups.OrderPatMobility patmobility;
	protected ims.ocrr.vo.lookups.OrderCategory ordercategory;
	protected ims.ocs_if.vo.IfOrderSpecimenVoCollection specimens;
	protected Boolean wasprocessed;
	protected ims.core.resource.place.vo.LocSiteRefVo orderinghospital;
	protected ims.ocrr.vo.lookups.AuthorisationOrderStatus authorisationorderstatus;
	protected ims.core.resource.place.vo.LocationRefVo outpatientdept;
	protected String primaryidvalueused;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
