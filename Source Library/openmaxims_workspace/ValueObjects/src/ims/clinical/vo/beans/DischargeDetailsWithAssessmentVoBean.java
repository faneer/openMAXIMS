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

package ims.clinical.vo.beans;

public class DischargeDetailsWithAssessmentVoBean extends ims.vo.ValueObjectBean
{
	public DischargeDetailsWithAssessmentVoBean()
	{
	}
	public DischargeDetailsWithAssessmentVoBean(ims.clinical.vo.DischargeDetailsWithAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.dateofdischarge = vo.getDateOfDischarge() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateOfDischarge().getBean();
		this.dischargemethod = vo.getDischargeMethod() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeMethod().getBean();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.dischargingward = vo.getDischargingWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getDischargingWard().getBean();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
		this.initiatinghcp = vo.getInitiatingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getInitiatingHCP().getBean();
		this.dischargeletterstatus = vo.getDischargeLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeLetterStatus().getBean();
		this.hasnocomplications = vo.getHasNoComplications();
		this.hasnocomorbidities = vo.getHasNoComorbidities();
		this.dischargingconsultant = vo.getDischargingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getDischargingConsultant().getBean();
		this.secondarydischargingconsultant = vo.getSecondaryDischargingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSecondaryDischargingConsultant().getBean();
		this.dischargingspecialty = vo.getDischargingSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargingSpecialty().getBean();
		this.dischargesupplementaryletterstatus = vo.getDischargeSupplementaryLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeSupplementaryLetterStatus().getBean();
		this.nurseenabledinstructions = vo.getNurseEnabledInstructions() == null ? null : (ims.clinical.vo.beans.NurseEnabledInstructionsVoBean)vo.getNurseEnabledInstructions().getBean();
		this.hasnodiagnosis = vo.getHasNoDiagnosis();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.isdiagnosiscomplete = vo.getIsDiagnosisComplete();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.patientassessment = vo.getPatientAssessment() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getPatientAssessment().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.DischargeDetailsWithAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.dateofdischarge = vo.getDateOfDischarge() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateOfDischarge().getBean();
		this.dischargemethod = vo.getDischargeMethod() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeMethod().getBean();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.dischargingward = vo.getDischargingWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getDischargingWard().getBean(map);
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
		this.initiatinghcp = vo.getInitiatingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getInitiatingHCP().getBean(map);
		this.dischargeletterstatus = vo.getDischargeLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeLetterStatus().getBean();
		this.hasnocomplications = vo.getHasNoComplications();
		this.hasnocomorbidities = vo.getHasNoComorbidities();
		this.dischargingconsultant = vo.getDischargingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getDischargingConsultant().getBean(map);
		this.secondarydischargingconsultant = vo.getSecondaryDischargingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSecondaryDischargingConsultant().getBean(map);
		this.dischargingspecialty = vo.getDischargingSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargingSpecialty().getBean();
		this.dischargesupplementaryletterstatus = vo.getDischargeSupplementaryLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeSupplementaryLetterStatus().getBean();
		this.nurseenabledinstructions = vo.getNurseEnabledInstructions() == null ? null : (ims.clinical.vo.beans.NurseEnabledInstructionsVoBean)vo.getNurseEnabledInstructions().getBean(map);
		this.hasnodiagnosis = vo.getHasNoDiagnosis();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.isdiagnosiscomplete = vo.getIsDiagnosisComplete();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.patientassessment = vo.getPatientAssessment() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getPatientAssessment().getBean(map);
	}

	public ims.clinical.vo.DischargeDetailsWithAssessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.DischargeDetailsWithAssessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.DischargeDetailsWithAssessmentVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.DischargeDetailsWithAssessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.DischargeDetailsWithAssessmentVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateOfDischarge()
	{
		return this.dateofdischarge;
	}
	public void setDateOfDischarge(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dateofdischarge = value;
	}
	public ims.vo.LookupInstanceBean getDischargeMethod()
	{
		return this.dischargemethod;
	}
	public void setDischargeMethod(ims.vo.LookupInstanceBean value)
	{
		this.dischargemethod = value;
	}
	public ims.vo.LookupInstanceBean getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.vo.LookupInstanceBean value)
	{
		this.dischargedestination = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getDischargingWard()
	{
		return this.dischargingward;
	}
	public void setDischargingWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.dischargingward = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getInitiatingHCP()
	{
		return this.initiatinghcp;
	}
	public void setInitiatingHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.initiatinghcp = value;
	}
	public ims.vo.LookupInstanceBean getDischargeLetterStatus()
	{
		return this.dischargeletterstatus;
	}
	public void setDischargeLetterStatus(ims.vo.LookupInstanceBean value)
	{
		this.dischargeletterstatus = value;
	}
	public Boolean getHasNoComplications()
	{
		return this.hasnocomplications;
	}
	public void setHasNoComplications(Boolean value)
	{
		this.hasnocomplications = value;
	}
	public Boolean getHasNoComorbidities()
	{
		return this.hasnocomorbidities;
	}
	public void setHasNoComorbidities(Boolean value)
	{
		this.hasnocomorbidities = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getDischargingConsultant()
	{
		return this.dischargingconsultant;
	}
	public void setDischargingConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.dischargingconsultant = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSecondaryDischargingConsultant()
	{
		return this.secondarydischargingconsultant;
	}
	public void setSecondaryDischargingConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.secondarydischargingconsultant = value;
	}
	public ims.vo.LookupInstanceBean getDischargingSpecialty()
	{
		return this.dischargingspecialty;
	}
	public void setDischargingSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.dischargingspecialty = value;
	}
	public ims.vo.LookupInstanceBean getDischargeSupplementaryLetterStatus()
	{
		return this.dischargesupplementaryletterstatus;
	}
	public void setDischargeSupplementaryLetterStatus(ims.vo.LookupInstanceBean value)
	{
		this.dischargesupplementaryletterstatus = value;
	}
	public ims.clinical.vo.beans.NurseEnabledInstructionsVoBean getNurseEnabledInstructions()
	{
		return this.nurseenabledinstructions;
	}
	public void setNurseEnabledInstructions(ims.clinical.vo.beans.NurseEnabledInstructionsVoBean value)
	{
		this.nurseenabledinstructions = value;
	}
	public Boolean getHasNoDiagnosis()
	{
		return this.hasnodiagnosis;
	}
	public void setHasNoDiagnosis(Boolean value)
	{
		this.hasnodiagnosis = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfDischarge()
	{
		return this.methodofdischarge;
	}
	public void setMethodOfDischarge(ims.vo.LookupInstanceBean value)
	{
		this.methodofdischarge = value;
	}
	public Boolean getIsDiagnosisComplete()
	{
		return this.isdiagnosiscomplete;
	}
	public void setIsDiagnosisComplete(Boolean value)
	{
		this.isdiagnosiscomplete = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.assessment.vo.beans.PatientAssessmentVoBean getPatientAssessment()
	{
		return this.patientassessment;
	}
	public void setPatientAssessment(ims.assessment.vo.beans.PatientAssessmentVoBean value)
	{
		this.patientassessment = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.framework.utils.beans.DateTimeBean dateofdischarge;
	private ims.vo.LookupInstanceBean dischargemethod;
	private ims.vo.LookupInstanceBean dischargedestination;
	private ims.core.vo.beans.LocationLiteVoBean dischargingward;
	private ims.vo.SysInfoBean systeminformation;
	private ims.core.vo.beans.HcpLiteVoBean initiatinghcp;
	private ims.vo.LookupInstanceBean dischargeletterstatus;
	private Boolean hasnocomplications;
	private Boolean hasnocomorbidities;
	private ims.core.vo.beans.HcpLiteVoBean dischargingconsultant;
	private ims.core.vo.beans.HcpLiteVoBean secondarydischargingconsultant;
	private ims.vo.LookupInstanceBean dischargingspecialty;
	private ims.vo.LookupInstanceBean dischargesupplementaryletterstatus;
	private ims.clinical.vo.beans.NurseEnabledInstructionsVoBean nurseenabledinstructions;
	private Boolean hasnodiagnosis;
	private ims.vo.LookupInstanceBean methodofdischarge;
	private Boolean isdiagnosiscomplete;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.assessment.vo.beans.PatientAssessmentVoBean patientassessment;
}
