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

package ims.clinical.vo;

/**
 * Linked to clinical.AnaestheticSignIn business object (ID: 1072100129).
 */
public class AnaestheticSignInVo extends ims.clinical.vo.AnaestheticSignInRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AnaestheticSignInVo()
	{
	}
	public AnaestheticSignInVo(Integer id, int version)
	{
		super(id, version);
	}
	public AnaestheticSignInVo(ims.clinical.vo.beans.AnaestheticSignInVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.patientconfirmedidentity = bean.getPatientConfirmedIdentity();
		this.idbraceletchecked = bean.getIdBraceletChecked();
		this.allergieschecked = bean.getAllergiesChecked();
		this.allergybraceletpresen = bean.getAllergyBraceletPresen();
		this.ispatientdiabetic = bean.getIsPatientDiabetic() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getIsPatientDiabetic());
		this.procedureandsiteconfirmedbypatient = bean.getProcedureAndSiteConfirmedByPatient() == null ? null : ims.core.vo.lookups.YesUnable.buildLookup(bean.getProcedureAndSiteConfirmedByPatient());
		this.procedureandsiteconfirmedbypractitioner = bean.getProcedureAndSiteConfirmedByPractitioner() == null ? null : ims.core.vo.lookups.YesNotApplicable.buildLookup(bean.getProcedureAndSiteConfirmedByPractitioner());
		this.operationsitemarked = bean.getOperationSiteMarked() == null ? null : ims.core.vo.lookups.YesNotApplicable.buildLookup(bean.getOperationSiteMarked());
		this.patientstarved = bean.getPatientStarved() == null ? null : ims.core.vo.lookups.YesNoNotApplicable.buildLookup(bean.getPatientStarved());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.regionalblockrequired = bean.getRegionalBlockRequired();
		this.anticoagulantstatusconfirmed = bean.getAnticoagulantStatusConfirmed();
		this.asaclass = bean.getASAClass();
		this.anaesthesiamachineandmedicationcheckcomplete = bean.getAnaesthesiaMachineAndMedicationCheckComplete();
		this.knowndifficultairway = bean.getKnownDifficultAirway() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getKnownDifficultAirway());
		this.riskorgreaterthan500mlbloodloss = bean.getRiskOrGreaterThan500mlBloodLoss() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getRiskOrGreaterThan500mlBloodLoss());
		this.gandselectronicissues = bean.getGandSElectronicIssues();
		this.intraoperativefluidsrequired = bean.getIntraoperativeFluidsRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getIntraoperativeFluidsRequired());
		this.antibioticsrequired = bean.getAntibioticsRequired();
		this.antibioticsgivendatetime = bean.getAntibioticsGivenDateTime() == null ? null : bean.getAntibioticsGivenDateTime().buildDateTime();
		this.patientpreinductiontemperature = bean.getPatientPreinductionTemperature();
		this.preopbloodglucoseresult = bean.getPreopBloodGlucoseResult();
		// Interface field type not supported.
		this.laanaestheticblocktype = ims.clinical.vo.lookups.LAAnaestheticBlockTypeCollection.buildFromBeanCollection(bean.getLAAnaestheticBlockType());
		this.interscalene = bean.getInterscalene();
		this.axillary = bean.getAxillary();
		this.leftandrightsidecheckedandsorrectsidemarked = bean.getLeftAndRightSideCheckedAndSorrectSideMarked() == null ? null : ims.clinical.vo.lookups.LeftAndRightSideCheckedAndCorrectSideMarked.buildLookup(bean.getLeftAndRightSideCheckedAndSorrectSideMarked());
		// Interface field type not supported.
		this.denturesimplantslooseteeth = bean.getDenturesImplantsLooseTeeth();
		this.relevantchartsnotespresent = bean.getRelevantChartsNotesPresent();
		this.allergiesconfirmedbypatient = bean.getAllergiesConfirmedByPatient() == null ? null : ims.core.vo.lookups.YesUnable.buildLookup(bean.getAllergiesConfirmedByPatient());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.AnaestheticSignInVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.patientconfirmedidentity = bean.getPatientConfirmedIdentity();
		this.idbraceletchecked = bean.getIdBraceletChecked();
		this.allergieschecked = bean.getAllergiesChecked();
		this.allergybraceletpresen = bean.getAllergyBraceletPresen();
		this.ispatientdiabetic = bean.getIsPatientDiabetic() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getIsPatientDiabetic());
		this.procedureandsiteconfirmedbypatient = bean.getProcedureAndSiteConfirmedByPatient() == null ? null : ims.core.vo.lookups.YesUnable.buildLookup(bean.getProcedureAndSiteConfirmedByPatient());
		this.procedureandsiteconfirmedbypractitioner = bean.getProcedureAndSiteConfirmedByPractitioner() == null ? null : ims.core.vo.lookups.YesNotApplicable.buildLookup(bean.getProcedureAndSiteConfirmedByPractitioner());
		this.operationsitemarked = bean.getOperationSiteMarked() == null ? null : ims.core.vo.lookups.YesNotApplicable.buildLookup(bean.getOperationSiteMarked());
		this.patientstarved = bean.getPatientStarved() == null ? null : ims.core.vo.lookups.YesNoNotApplicable.buildLookup(bean.getPatientStarved());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.regionalblockrequired = bean.getRegionalBlockRequired();
		this.anticoagulantstatusconfirmed = bean.getAnticoagulantStatusConfirmed();
		this.asaclass = bean.getASAClass();
		this.anaesthesiamachineandmedicationcheckcomplete = bean.getAnaesthesiaMachineAndMedicationCheckComplete();
		this.knowndifficultairway = bean.getKnownDifficultAirway() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getKnownDifficultAirway());
		this.riskorgreaterthan500mlbloodloss = bean.getRiskOrGreaterThan500mlBloodLoss() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getRiskOrGreaterThan500mlBloodLoss());
		this.gandselectronicissues = bean.getGandSElectronicIssues();
		this.intraoperativefluidsrequired = bean.getIntraoperativeFluidsRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getIntraoperativeFluidsRequired());
		this.antibioticsrequired = bean.getAntibioticsRequired();
		this.antibioticsgivendatetime = bean.getAntibioticsGivenDateTime() == null ? null : bean.getAntibioticsGivenDateTime().buildDateTime();
		this.patientpreinductiontemperature = bean.getPatientPreinductionTemperature();
		this.preopbloodglucoseresult = bean.getPreopBloodGlucoseResult();
		// Interface field type not supported.
		this.laanaestheticblocktype = ims.clinical.vo.lookups.LAAnaestheticBlockTypeCollection.buildFromBeanCollection(bean.getLAAnaestheticBlockType());
		this.interscalene = bean.getInterscalene();
		this.axillary = bean.getAxillary();
		this.leftandrightsidecheckedandsorrectsidemarked = bean.getLeftAndRightSideCheckedAndSorrectSideMarked() == null ? null : ims.clinical.vo.lookups.LeftAndRightSideCheckedAndCorrectSideMarked.buildLookup(bean.getLeftAndRightSideCheckedAndSorrectSideMarked());
		// Interface field type not supported.
		this.denturesimplantslooseteeth = bean.getDenturesImplantsLooseTeeth();
		this.relevantchartsnotespresent = bean.getRelevantChartsNotesPresent();
		this.allergiesconfirmedbypatient = bean.getAllergiesConfirmedByPatient() == null ? null : ims.core.vo.lookups.YesUnable.buildLookup(bean.getAllergiesConfirmedByPatient());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.AnaestheticSignInVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.AnaestheticSignInVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.AnaestheticSignInVoBean();
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
		if(fieldName.equals("THEATREAPPOINTMENT"))
			return getTheatreAppointment();
		if(fieldName.equals("PATIENTCONFIRMEDIDENTITY"))
			return getPatientConfirmedIdentity();
		if(fieldName.equals("IDBRACELETCHECKED"))
			return getIdBraceletChecked();
		if(fieldName.equals("ALLERGIESCHECKED"))
			return getAllergiesChecked();
		if(fieldName.equals("ALLERGYBRACELETPRESEN"))
			return getAllergyBraceletPresen();
		if(fieldName.equals("ISPATIENTDIABETIC"))
			return getIsPatientDiabetic();
		if(fieldName.equals("PROCEDUREANDSITECONFIRMEDBYPATIENT"))
			return getProcedureAndSiteConfirmedByPatient();
		if(fieldName.equals("PROCEDUREANDSITECONFIRMEDBYPRACTITIONER"))
			return getProcedureAndSiteConfirmedByPractitioner();
		if(fieldName.equals("OPERATIONSITEMARKED"))
			return getOperationSiteMarked();
		if(fieldName.equals("PATIENTSTARVED"))
			return getPatientStarved();
		if(fieldName.equals("ANAESTHETICTYPE"))
			return getAnaestheticType();
		if(fieldName.equals("REGIONALBLOCKREQUIRED"))
			return getRegionalBlockRequired();
		if(fieldName.equals("ANTICOAGULANTSTATUSCONFIRMED"))
			return getAnticoagulantStatusConfirmed();
		if(fieldName.equals("ASACLASS"))
			return getASAClass();
		if(fieldName.equals("ANAESTHESIAMACHINEANDMEDICATIONCHECKCOMPLETE"))
			return getAnaesthesiaMachineAndMedicationCheckComplete();
		if(fieldName.equals("KNOWNDIFFICULTAIRWAY"))
			return getKnownDifficultAirway();
		if(fieldName.equals("RISKORGREATERTHAN500MLBLOODLOSS"))
			return getRiskOrGreaterThan500mlBloodLoss();
		if(fieldName.equals("GANDSELECTRONICISSUES"))
			return getGandSElectronicIssues();
		if(fieldName.equals("INTRAOPERATIVEFLUIDSREQUIRED"))
			return getIntraoperativeFluidsRequired();
		if(fieldName.equals("ANTIBIOTICSREQUIRED"))
			return getAntibioticsRequired();
		if(fieldName.equals("ANTIBIOTICSGIVENDATETIME"))
			return getAntibioticsGivenDateTime();
		if(fieldName.equals("PATIENTPREINDUCTIONTEMPERATURE"))
			return getPatientPreinductionTemperature();
		if(fieldName.equals("PREOPBLOODGLUCOSERESULT"))
			return getPreopBloodGlucoseResult();
		if(fieldName.equals("SIGNATUREBYREGISTEREDPRACTITIONER"))
			return getSignatureByRegisteredPractitioner();
		if(fieldName.equals("LAANAESTHETICBLOCKTYPE"))
			return getLAAnaestheticBlockType();
		if(fieldName.equals("INTERSCALENE"))
			return getInterscalene();
		if(fieldName.equals("AXILLARY"))
			return getAxillary();
		if(fieldName.equals("LEFTANDRIGHTSIDECHECKEDANDSORRECTSIDEMARKED"))
			return getLeftAndRightSideCheckedAndSorrectSideMarked();
		if(fieldName.equals("ANAESTHETISTSIGN"))
			return getAnaesthetistSign();
		if(fieldName.equals("DENTURESIMPLANTSLOOSETEETH"))
			return getDenturesImplantsLooseTeeth();
		if(fieldName.equals("RELEVANTCHARTSNOTESPRESENT"))
			return getRelevantChartsNotesPresent();
		if(fieldName.equals("ALLERGIESCONFIRMEDBYPATIENT"))
			return getAllergiesConfirmedByPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTheatreAppointmentIsNotNull()
	{
		return this.theatreappointment != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVo getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
	{
		this.isValidated = false;
		this.theatreappointment = value;
	}
	public boolean getPatientConfirmedIdentityIsNotNull()
	{
		return this.patientconfirmedidentity != null;
	}
	public Boolean getPatientConfirmedIdentity()
	{
		return this.patientconfirmedidentity;
	}
	public void setPatientConfirmedIdentity(Boolean value)
	{
		this.isValidated = false;
		this.patientconfirmedidentity = value;
	}
	public boolean getIdBraceletCheckedIsNotNull()
	{
		return this.idbraceletchecked != null;
	}
	public Boolean getIdBraceletChecked()
	{
		return this.idbraceletchecked;
	}
	public void setIdBraceletChecked(Boolean value)
	{
		this.isValidated = false;
		this.idbraceletchecked = value;
	}
	public boolean getAllergiesCheckedIsNotNull()
	{
		return this.allergieschecked != null;
	}
	public Boolean getAllergiesChecked()
	{
		return this.allergieschecked;
	}
	public void setAllergiesChecked(Boolean value)
	{
		this.isValidated = false;
		this.allergieschecked = value;
	}
	public boolean getAllergyBraceletPresenIsNotNull()
	{
		return this.allergybraceletpresen != null;
	}
	public Boolean getAllergyBraceletPresen()
	{
		return this.allergybraceletpresen;
	}
	public void setAllergyBraceletPresen(Boolean value)
	{
		this.isValidated = false;
		this.allergybraceletpresen = value;
	}
	public boolean getIsPatientDiabeticIsNotNull()
	{
		return this.ispatientdiabetic != null;
	}
	public ims.core.vo.lookups.YesNo getIsPatientDiabetic()
	{
		return this.ispatientdiabetic;
	}
	public void setIsPatientDiabetic(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.ispatientdiabetic = value;
	}
	public boolean getProcedureAndSiteConfirmedByPatientIsNotNull()
	{
		return this.procedureandsiteconfirmedbypatient != null;
	}
	public ims.core.vo.lookups.YesUnable getProcedureAndSiteConfirmedByPatient()
	{
		return this.procedureandsiteconfirmedbypatient;
	}
	public void setProcedureAndSiteConfirmedByPatient(ims.core.vo.lookups.YesUnable value)
	{
		this.isValidated = false;
		this.procedureandsiteconfirmedbypatient = value;
	}
	public boolean getProcedureAndSiteConfirmedByPractitionerIsNotNull()
	{
		return this.procedureandsiteconfirmedbypractitioner != null;
	}
	public ims.core.vo.lookups.YesNotApplicable getProcedureAndSiteConfirmedByPractitioner()
	{
		return this.procedureandsiteconfirmedbypractitioner;
	}
	public void setProcedureAndSiteConfirmedByPractitioner(ims.core.vo.lookups.YesNotApplicable value)
	{
		this.isValidated = false;
		this.procedureandsiteconfirmedbypractitioner = value;
	}
	public boolean getOperationSiteMarkedIsNotNull()
	{
		return this.operationsitemarked != null;
	}
	public ims.core.vo.lookups.YesNotApplicable getOperationSiteMarked()
	{
		return this.operationsitemarked;
	}
	public void setOperationSiteMarked(ims.core.vo.lookups.YesNotApplicable value)
	{
		this.isValidated = false;
		this.operationsitemarked = value;
	}
	public boolean getPatientStarvedIsNotNull()
	{
		return this.patientstarved != null;
	}
	public ims.core.vo.lookups.YesNoNotApplicable getPatientStarved()
	{
		return this.patientstarved;
	}
	public void setPatientStarved(ims.core.vo.lookups.YesNoNotApplicable value)
	{
		this.isValidated = false;
		this.patientstarved = value;
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
	public boolean getRegionalBlockRequiredIsNotNull()
	{
		return this.regionalblockrequired != null;
	}
	public Boolean getRegionalBlockRequired()
	{
		return this.regionalblockrequired;
	}
	public void setRegionalBlockRequired(Boolean value)
	{
		this.isValidated = false;
		this.regionalblockrequired = value;
	}
	public boolean getAnticoagulantStatusConfirmedIsNotNull()
	{
		return this.anticoagulantstatusconfirmed != null;
	}
	public Boolean getAnticoagulantStatusConfirmed()
	{
		return this.anticoagulantstatusconfirmed;
	}
	public void setAnticoagulantStatusConfirmed(Boolean value)
	{
		this.isValidated = false;
		this.anticoagulantstatusconfirmed = value;
	}
	public boolean getASAClassIsNotNull()
	{
		return this.asaclass != null;
	}
	public Integer getASAClass()
	{
		return this.asaclass;
	}
	public void setASAClass(Integer value)
	{
		this.isValidated = false;
		this.asaclass = value;
	}
	public boolean getAnaesthesiaMachineAndMedicationCheckCompleteIsNotNull()
	{
		return this.anaesthesiamachineandmedicationcheckcomplete != null;
	}
	public Boolean getAnaesthesiaMachineAndMedicationCheckComplete()
	{
		return this.anaesthesiamachineandmedicationcheckcomplete;
	}
	public void setAnaesthesiaMachineAndMedicationCheckComplete(Boolean value)
	{
		this.isValidated = false;
		this.anaesthesiamachineandmedicationcheckcomplete = value;
	}
	public boolean getKnownDifficultAirwayIsNotNull()
	{
		return this.knowndifficultairway != null;
	}
	public ims.core.vo.lookups.YesNo getKnownDifficultAirway()
	{
		return this.knowndifficultairway;
	}
	public void setKnownDifficultAirway(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.knowndifficultairway = value;
	}
	public boolean getRiskOrGreaterThan500mlBloodLossIsNotNull()
	{
		return this.riskorgreaterthan500mlbloodloss != null;
	}
	public ims.core.vo.lookups.YesNo getRiskOrGreaterThan500mlBloodLoss()
	{
		return this.riskorgreaterthan500mlbloodloss;
	}
	public void setRiskOrGreaterThan500mlBloodLoss(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.riskorgreaterthan500mlbloodloss = value;
	}
	public boolean getGandSElectronicIssuesIsNotNull()
	{
		return this.gandselectronicissues != null;
	}
	public Boolean getGandSElectronicIssues()
	{
		return this.gandselectronicissues;
	}
	public void setGandSElectronicIssues(Boolean value)
	{
		this.isValidated = false;
		this.gandselectronicissues = value;
	}
	public boolean getIntraoperativeFluidsRequiredIsNotNull()
	{
		return this.intraoperativefluidsrequired != null;
	}
	public ims.core.vo.lookups.YesNo getIntraoperativeFluidsRequired()
	{
		return this.intraoperativefluidsrequired;
	}
	public void setIntraoperativeFluidsRequired(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.intraoperativefluidsrequired = value;
	}
	public boolean getAntibioticsRequiredIsNotNull()
	{
		return this.antibioticsrequired != null;
	}
	public Boolean getAntibioticsRequired()
	{
		return this.antibioticsrequired;
	}
	public void setAntibioticsRequired(Boolean value)
	{
		this.isValidated = false;
		this.antibioticsrequired = value;
	}
	public boolean getAntibioticsGivenDateTimeIsNotNull()
	{
		return this.antibioticsgivendatetime != null;
	}
	public ims.framework.utils.DateTime getAntibioticsGivenDateTime()
	{
		return this.antibioticsgivendatetime;
	}
	public void setAntibioticsGivenDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.antibioticsgivendatetime = value;
	}
	public boolean getPatientPreinductionTemperatureIsNotNull()
	{
		return this.patientpreinductiontemperature != null;
	}
	public Float getPatientPreinductionTemperature()
	{
		return this.patientpreinductiontemperature;
	}
	public void setPatientPreinductionTemperature(Float value)
	{
		this.isValidated = false;
		this.patientpreinductiontemperature = value;
	}
	public boolean getPreopBloodGlucoseResultIsNotNull()
	{
		return this.preopbloodglucoseresult != null;
	}
	public Float getPreopBloodGlucoseResult()
	{
		return this.preopbloodglucoseresult;
	}
	public void setPreopBloodGlucoseResult(Float value)
	{
		this.isValidated = false;
		this.preopbloodglucoseresult = value;
	}
	public boolean getSignatureByRegisteredPractitionerIsNotNull()
	{
		return this.signaturebyregisteredpractitioner != null;
	}
	public ims.vo.interfaces.IMos getSignatureByRegisteredPractitioner()
	{
		return this.signaturebyregisteredpractitioner;
	}
	public void setSignatureByRegisteredPractitioner(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.signaturebyregisteredpractitioner = (ims.core.vo.MedicVo)value;
	}
	public boolean getLAAnaestheticBlockTypeIsNotNull()
	{
		return this.laanaestheticblocktype != null;
	}
	public ims.clinical.vo.lookups.LAAnaestheticBlockTypeCollection getLAAnaestheticBlockType()
	{
		return this.laanaestheticblocktype;
	}
	public void setLAAnaestheticBlockType(ims.clinical.vo.lookups.LAAnaestheticBlockTypeCollection value)
	{
		this.isValidated = false;
		this.laanaestheticblocktype = value;
	}
	public boolean getInterscaleneIsNotNull()
	{
		return this.interscalene != null;
	}
	public Boolean getInterscalene()
	{
		return this.interscalene;
	}
	public void setInterscalene(Boolean value)
	{
		this.isValidated = false;
		this.interscalene = value;
	}
	public boolean getAxillaryIsNotNull()
	{
		return this.axillary != null;
	}
	public Boolean getAxillary()
	{
		return this.axillary;
	}
	public void setAxillary(Boolean value)
	{
		this.isValidated = false;
		this.axillary = value;
	}
	public boolean getLeftAndRightSideCheckedAndSorrectSideMarkedIsNotNull()
	{
		return this.leftandrightsidecheckedandsorrectsidemarked != null;
	}
	public ims.clinical.vo.lookups.LeftAndRightSideCheckedAndCorrectSideMarked getLeftAndRightSideCheckedAndSorrectSideMarked()
	{
		return this.leftandrightsidecheckedandsorrectsidemarked;
	}
	public void setLeftAndRightSideCheckedAndSorrectSideMarked(ims.clinical.vo.lookups.LeftAndRightSideCheckedAndCorrectSideMarked value)
	{
		this.isValidated = false;
		this.leftandrightsidecheckedandsorrectsidemarked = value;
	}
	public boolean getAnaesthetistSignIsNotNull()
	{
		return this.anaesthetistsign != null;
	}
	public ims.vo.interfaces.IMos getAnaesthetistSign()
	{
		return this.anaesthetistsign;
	}
	public void setAnaesthetistSign(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.anaesthetistsign = (ims.core.vo.MedicVo)value;
	}
	public boolean getDenturesImplantsLooseTeethIsNotNull()
	{
		return this.denturesimplantslooseteeth != null;
	}
	public Boolean getDenturesImplantsLooseTeeth()
	{
		return this.denturesimplantslooseteeth;
	}
	public void setDenturesImplantsLooseTeeth(Boolean value)
	{
		this.isValidated = false;
		this.denturesimplantslooseteeth = value;
	}
	public boolean getRelevantChartsNotesPresentIsNotNull()
	{
		return this.relevantchartsnotespresent != null;
	}
	public Boolean getRelevantChartsNotesPresent()
	{
		return this.relevantchartsnotespresent;
	}
	public void setRelevantChartsNotesPresent(Boolean value)
	{
		this.isValidated = false;
		this.relevantchartsnotespresent = value;
	}
	public boolean getAllergiesConfirmedByPatientIsNotNull()
	{
		return this.allergiesconfirmedbypatient != null;
	}
	public ims.core.vo.lookups.YesUnable getAllergiesConfirmedByPatient()
	{
		return this.allergiesconfirmedbypatient;
	}
	public void setAllergiesConfirmedByPatient(ims.core.vo.lookups.YesUnable value)
	{
		this.isValidated = false;
		this.allergiesconfirmedbypatient = value;
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
		if(this.theatreappointment == null)
			listOfErrors.add("Theatre Appointment is mandatory");
		if(this.allergieschecked == null)
			listOfErrors.add("Allergies Checked is mandatory");
		if(this.allergybraceletpresen == null)
			listOfErrors.add("Allergy bracelet present and correct is mandatory");
		if(this.ispatientdiabetic == null)
			listOfErrors.add("Is the patient diabetic is mandatory");
		if(this.procedureandsiteconfirmedbypatient == null)
			listOfErrors.add("Procedure and Site Confirmed by Patient is mandatory");
		if(this.procedureandsiteconfirmedbypractitioner == null)
			listOfErrors.add("Procedure and Site Confirmed by Practitioner  is mandatory");
		if(this.operationsitemarked == null)
			listOfErrors.add("Operation site Marked is mandatory");
		if(this.anaesthetictype == null)
			listOfErrors.add("Anaesthetic Type is mandatory");
		if(this.anticoagulantstatusconfirmed == null)
			listOfErrors.add("AnticoagulantStatusConfirmed is mandatory");
		if(this.signaturebyregisteredpractitioner == null)
			listOfErrors.add("Signature by registered practitioner is mandatory");
		if(this.relevantchartsnotespresent == null)
			listOfErrors.add("RelevantChartsNotesPresent is mandatory");
		if(this.allergiesconfirmedbypatient == null)
			listOfErrors.add("Allergies confirmed by patient is mandatory");
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
	
		AnaestheticSignInVo clone = new AnaestheticSignInVo(this.id, this.version);
		
		clone.theatreappointment = this.theatreappointment;
		clone.patientconfirmedidentity = this.patientconfirmedidentity;
		clone.idbraceletchecked = this.idbraceletchecked;
		clone.allergieschecked = this.allergieschecked;
		clone.allergybraceletpresen = this.allergybraceletpresen;
		if(this.ispatientdiabetic == null)
			clone.ispatientdiabetic = null;
		else
			clone.ispatientdiabetic = (ims.core.vo.lookups.YesNo)this.ispatientdiabetic.clone();
		if(this.procedureandsiteconfirmedbypatient == null)
			clone.procedureandsiteconfirmedbypatient = null;
		else
			clone.procedureandsiteconfirmedbypatient = (ims.core.vo.lookups.YesUnable)this.procedureandsiteconfirmedbypatient.clone();
		if(this.procedureandsiteconfirmedbypractitioner == null)
			clone.procedureandsiteconfirmedbypractitioner = null;
		else
			clone.procedureandsiteconfirmedbypractitioner = (ims.core.vo.lookups.YesNotApplicable)this.procedureandsiteconfirmedbypractitioner.clone();
		if(this.operationsitemarked == null)
			clone.operationsitemarked = null;
		else
			clone.operationsitemarked = (ims.core.vo.lookups.YesNotApplicable)this.operationsitemarked.clone();
		if(this.patientstarved == null)
			clone.patientstarved = null;
		else
			clone.patientstarved = (ims.core.vo.lookups.YesNoNotApplicable)this.patientstarved.clone();
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticType)this.anaesthetictype.clone();
		clone.regionalblockrequired = this.regionalblockrequired;
		clone.anticoagulantstatusconfirmed = this.anticoagulantstatusconfirmed;
		clone.asaclass = this.asaclass;
		clone.anaesthesiamachineandmedicationcheckcomplete = this.anaesthesiamachineandmedicationcheckcomplete;
		if(this.knowndifficultairway == null)
			clone.knowndifficultairway = null;
		else
			clone.knowndifficultairway = (ims.core.vo.lookups.YesNo)this.knowndifficultairway.clone();
		if(this.riskorgreaterthan500mlbloodloss == null)
			clone.riskorgreaterthan500mlbloodloss = null;
		else
			clone.riskorgreaterthan500mlbloodloss = (ims.core.vo.lookups.YesNo)this.riskorgreaterthan500mlbloodloss.clone();
		clone.gandselectronicissues = this.gandselectronicissues;
		if(this.intraoperativefluidsrequired == null)
			clone.intraoperativefluidsrequired = null;
		else
			clone.intraoperativefluidsrequired = (ims.core.vo.lookups.YesNo)this.intraoperativefluidsrequired.clone();
		clone.antibioticsrequired = this.antibioticsrequired;
		if(this.antibioticsgivendatetime == null)
			clone.antibioticsgivendatetime = null;
		else
			clone.antibioticsgivendatetime = (ims.framework.utils.DateTime)this.antibioticsgivendatetime.clone();
		clone.patientpreinductiontemperature = this.patientpreinductiontemperature;
		clone.preopbloodglucoseresult = this.preopbloodglucoseresult;
		clone.signaturebyregisteredpractitioner = this.signaturebyregisteredpractitioner;
		if(this.laanaestheticblocktype == null)
			clone.laanaestheticblocktype = null;
		else
			clone.laanaestheticblocktype = (ims.clinical.vo.lookups.LAAnaestheticBlockTypeCollection)this.laanaestheticblocktype.clone();
		clone.interscalene = this.interscalene;
		clone.axillary = this.axillary;
		if(this.leftandrightsidecheckedandsorrectsidemarked == null)
			clone.leftandrightsidecheckedandsorrectsidemarked = null;
		else
			clone.leftandrightsidecheckedandsorrectsidemarked = (ims.clinical.vo.lookups.LeftAndRightSideCheckedAndCorrectSideMarked)this.leftandrightsidecheckedandsorrectsidemarked.clone();
		clone.anaesthetistsign = this.anaesthetistsign;
		clone.denturesimplantslooseteeth = this.denturesimplantslooseteeth;
		clone.relevantchartsnotespresent = this.relevantchartsnotespresent;
		if(this.allergiesconfirmedbypatient == null)
			clone.allergiesconfirmedbypatient = null;
		else
			clone.allergiesconfirmedbypatient = (ims.core.vo.lookups.YesUnable)this.allergiesconfirmedbypatient.clone();
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
		if (!(AnaestheticSignInVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AnaestheticSignInVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AnaestheticSignInVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AnaestheticSignInVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.theatreappointment != null)
			count++;
		if(this.patientconfirmedidentity != null)
			count++;
		if(this.idbraceletchecked != null)
			count++;
		if(this.allergieschecked != null)
			count++;
		if(this.allergybraceletpresen != null)
			count++;
		if(this.ispatientdiabetic != null)
			count++;
		if(this.procedureandsiteconfirmedbypatient != null)
			count++;
		if(this.procedureandsiteconfirmedbypractitioner != null)
			count++;
		if(this.operationsitemarked != null)
			count++;
		if(this.patientstarved != null)
			count++;
		if(this.anaesthetictype != null)
			count++;
		if(this.regionalblockrequired != null)
			count++;
		if(this.anticoagulantstatusconfirmed != null)
			count++;
		if(this.asaclass != null)
			count++;
		if(this.anaesthesiamachineandmedicationcheckcomplete != null)
			count++;
		if(this.knowndifficultairway != null)
			count++;
		if(this.riskorgreaterthan500mlbloodloss != null)
			count++;
		if(this.gandselectronicissues != null)
			count++;
		if(this.intraoperativefluidsrequired != null)
			count++;
		if(this.antibioticsrequired != null)
			count++;
		if(this.antibioticsgivendatetime != null)
			count++;
		if(this.patientpreinductiontemperature != null)
			count++;
		if(this.preopbloodglucoseresult != null)
			count++;
		if(this.signaturebyregisteredpractitioner != null)
			count++;
		if(this.laanaestheticblocktype != null)
			count++;
		if(this.interscalene != null)
			count++;
		if(this.axillary != null)
			count++;
		if(this.leftandrightsidecheckedandsorrectsidemarked != null)
			count++;
		if(this.anaesthetistsign != null)
			count++;
		if(this.denturesimplantslooseteeth != null)
			count++;
		if(this.relevantchartsnotespresent != null)
			count++;
		if(this.allergiesconfirmedbypatient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 32;
	}
	protected ims.scheduling.vo.Booking_AppointmentRefVo theatreappointment;
	protected Boolean patientconfirmedidentity;
	protected Boolean idbraceletchecked;
	protected Boolean allergieschecked;
	protected Boolean allergybraceletpresen;
	protected ims.core.vo.lookups.YesNo ispatientdiabetic;
	protected ims.core.vo.lookups.YesUnable procedureandsiteconfirmedbypatient;
	protected ims.core.vo.lookups.YesNotApplicable procedureandsiteconfirmedbypractitioner;
	protected ims.core.vo.lookups.YesNotApplicable operationsitemarked;
	protected ims.core.vo.lookups.YesNoNotApplicable patientstarved;
	protected ims.clinical.vo.lookups.AnaestheticType anaesthetictype;
	protected Boolean regionalblockrequired;
	protected Boolean anticoagulantstatusconfirmed;
	protected Integer asaclass;
	protected Boolean anaesthesiamachineandmedicationcheckcomplete;
	protected ims.core.vo.lookups.YesNo knowndifficultairway;
	protected ims.core.vo.lookups.YesNo riskorgreaterthan500mlbloodloss;
	protected Boolean gandselectronicissues;
	protected ims.core.vo.lookups.YesNo intraoperativefluidsrequired;
	protected Boolean antibioticsrequired;
	protected ims.framework.utils.DateTime antibioticsgivendatetime;
	protected Float patientpreinductiontemperature;
	protected Float preopbloodglucoseresult;
	protected ims.core.vo.MedicVo signaturebyregisteredpractitioner;
	protected ims.clinical.vo.lookups.LAAnaestheticBlockTypeCollection laanaestheticblocktype;
	protected Boolean interscalene;
	protected Boolean axillary;
	protected ims.clinical.vo.lookups.LeftAndRightSideCheckedAndCorrectSideMarked leftandrightsidecheckedandsorrectsidemarked;
	protected ims.core.vo.MedicVo anaesthetistsign;
	protected Boolean denturesimplantslooseteeth;
	protected Boolean relevantchartsnotespresent;
	protected ims.core.vo.lookups.YesUnable allergiesconfirmedbypatient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
