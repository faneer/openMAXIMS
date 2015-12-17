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

package ims.core.vo.beans;

public class DischargedEpisodeADTVoBean extends ims.vo.ValueObjectBean
{
	public DischargedEpisodeADTVoBean()
	{
	}
	public DischargedEpisodeADTVoBean(ims.core.vo.DischargedEpisodeADTVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean();
		if(vo.getWardStays() != null)
		{
			this.wardstays = new ims.vo.RefVoBean[vo.getWardStays().size()];
			for(int wardstays_i = 0; wardstays_i < vo.getWardStays().size(); wardstays_i++)
			{
				this.wardstays[wardstays_i] = new ims.vo.RefVoBean(vo.getWardStays().get(wardstays_i).getBoId(),vo.getWardStays().get(wardstays_i).getBoVersion());
			}
		}
		if(vo.getConsultantStays() != null)
		{
			this.consultantstays = new ims.vo.RefVoBean[vo.getConsultantStays().size()];
			for(int consultantstays_i = 0; consultantstays_i < vo.getConsultantStays().size(); consultantstays_i++)
			{
				this.consultantstays[consultantstays_i] = new ims.vo.RefVoBean(vo.getConsultantStays().get(consultantstays_i).getBoId(),vo.getConsultantStays().get(consultantstays_i).getBoVersion());
			}
		}
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.isactive = vo.getIsActive();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.wastreatmentdeferred = vo.getWasTreatmentDeferred();
		this.eighteenweekclockstopped = vo.getEighteenWeekClockStopped();
		this.bedspaceforinfant = vo.getBedSpaceForInfant() == null ? null : (ims.core.vo.beans.BedSpaceStateLiteVoBean)vo.getBedSpaceForInfant().getBean();
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionDetail().getBoId(), vo.getAdmissionDetail().getBoVersion());
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
		this.wasdiagnosticdeferred = vo.getWasDiagnosticDeferred();
		this.wastreatmentgiven = vo.getWasTreatmentGiven();
		this.deferredreason = vo.getDeferredReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeferredReason().getBean();
		this.deferredreasonconfig = vo.getDeferredReasonConfig() == null ? null : (ims.scheduling.vo.beans.CancellationTypeReasonVoBean)vo.getDeferredReasonConfig().getBean();
		this.dischargingward = vo.getDischargingWard() == null ? null : new ims.vo.RefVoBean(vo.getDischargingWard().getBoId(), vo.getDischargingWard().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DischargedEpisodeADTVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean(map);
		if(vo.getWardStays() != null)
		{
			this.wardstays = new ims.vo.RefVoBean[vo.getWardStays().size()];
			for(int wardstays_i = 0; wardstays_i < vo.getWardStays().size(); wardstays_i++)
			{
				this.wardstays[wardstays_i] = new ims.vo.RefVoBean(vo.getWardStays().get(wardstays_i).getBoId(),vo.getWardStays().get(wardstays_i).getBoVersion());
			}
		}
		if(vo.getConsultantStays() != null)
		{
			this.consultantstays = new ims.vo.RefVoBean[vo.getConsultantStays().size()];
			for(int consultantstays_i = 0; consultantstays_i < vo.getConsultantStays().size(); consultantstays_i++)
			{
				this.consultantstays[consultantstays_i] = new ims.vo.RefVoBean(vo.getConsultantStays().get(consultantstays_i).getBoId(),vo.getConsultantStays().get(consultantstays_i).getBoVersion());
			}
		}
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.isactive = vo.getIsActive();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.wastreatmentdeferred = vo.getWasTreatmentDeferred();
		this.eighteenweekclockstopped = vo.getEighteenWeekClockStopped();
		this.bedspaceforinfant = vo.getBedSpaceForInfant() == null ? null : (ims.core.vo.beans.BedSpaceStateLiteVoBean)vo.getBedSpaceForInfant().getBean(map);
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.admissiondetail = vo.getAdmissionDetail() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionDetail().getBoId(), vo.getAdmissionDetail().getBoVersion());
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
		this.wasdiagnosticdeferred = vo.getWasDiagnosticDeferred();
		this.wastreatmentgiven = vo.getWasTreatmentGiven();
		this.deferredreason = vo.getDeferredReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeferredReason().getBean();
		this.deferredreasonconfig = vo.getDeferredReasonConfig() == null ? null : (ims.scheduling.vo.beans.CancellationTypeReasonVoBean)vo.getDeferredReasonConfig().getBean(map);
		this.dischargingward = vo.getDischargingWard() == null ? null : new ims.vo.RefVoBean(vo.getDischargingWard().getBoId(), vo.getDischargingWard().getBoVersion());
	}

	public ims.core.vo.DischargedEpisodeADTVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DischargedEpisodeADTVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DischargedEpisodeADTVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DischargedEpisodeADTVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DischargedEpisodeADTVo();
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
	public ims.core.vo.beans.PasEventADTVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventADTVoBean value)
	{
		this.pasevent = value;
	}
	public ims.vo.RefVoBean[] getWardStays()
	{
		return this.wardstays;
	}
	public void setWardStays(ims.vo.RefVoBean[] value)
	{
		this.wardstays = value;
	}
	public ims.vo.RefVoBean[] getConsultantStays()
	{
		return this.consultantstays;
	}
	public void setConsultantStays(ims.vo.RefVoBean[] value)
	{
		this.consultantstays = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargedatetime = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.LookupInstanceBean getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.vo.LookupInstanceBean value)
	{
		this.dischargedestination = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfDischarge()
	{
		return this.methodofdischarge;
	}
	public void setMethodOfDischarge(ims.vo.LookupInstanceBean value)
	{
		this.methodofdischarge = value;
	}
	public Boolean getWasTreatmentDeferred()
	{
		return this.wastreatmentdeferred;
	}
	public void setWasTreatmentDeferred(Boolean value)
	{
		this.wastreatmentdeferred = value;
	}
	public Boolean getEighteenWeekClockStopped()
	{
		return this.eighteenweekclockstopped;
	}
	public void setEighteenWeekClockStopped(Boolean value)
	{
		this.eighteenweekclockstopped = value;
	}
	public ims.core.vo.beans.BedSpaceStateLiteVoBean getBedSpaceForInfant()
	{
		return this.bedspaceforinfant;
	}
	public void setBedSpaceForInfant(ims.core.vo.beans.BedSpaceStateLiteVoBean value)
	{
		this.bedspaceforinfant = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeReadyDate()
	{
		return this.dischargereadydate;
	}
	public void setDischargeReadyDate(ims.framework.utils.beans.DateBean value)
	{
		this.dischargereadydate = value;
	}
	public ims.vo.RefVoBean getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.vo.RefVoBean value)
	{
		this.admissiondetail = value;
	}
	public ims.vo.LookupInstanceBean getVTEAssessmentStatus()
	{
		return this.vteassessmentstatus;
	}
	public void setVTEAssessmentStatus(ims.vo.LookupInstanceBean value)
	{
		this.vteassessmentstatus = value;
	}
	public ims.vo.RefVoBean getVTERiskAssessment()
	{
		return this.vteriskassessment;
	}
	public void setVTERiskAssessment(ims.vo.RefVoBean value)
	{
		this.vteriskassessment = value;
	}
	public Boolean getWasDiagnosticDeferred()
	{
		return this.wasdiagnosticdeferred;
	}
	public void setWasDiagnosticDeferred(Boolean value)
	{
		this.wasdiagnosticdeferred = value;
	}
	public Boolean getWasTreatmentGiven()
	{
		return this.wastreatmentgiven;
	}
	public void setWasTreatmentGiven(Boolean value)
	{
		this.wastreatmentgiven = value;
	}
	public ims.vo.LookupInstanceBean getDeferredReason()
	{
		return this.deferredreason;
	}
	public void setDeferredReason(ims.vo.LookupInstanceBean value)
	{
		this.deferredreason = value;
	}
	public ims.scheduling.vo.beans.CancellationTypeReasonVoBean getDeferredReasonConfig()
	{
		return this.deferredreasonconfig;
	}
	public void setDeferredReasonConfig(ims.scheduling.vo.beans.CancellationTypeReasonVoBean value)
	{
		this.deferredreasonconfig = value;
	}
	public ims.vo.RefVoBean getDischargingWard()
	{
		return this.dischargingward;
	}
	public void setDischargingWard(ims.vo.RefVoBean value)
	{
		this.dischargingward = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventADTVoBean pasevent;
	private ims.vo.RefVoBean[] wardstays;
	private ims.vo.RefVoBean[] consultantstays;
	private ims.framework.utils.beans.DateTimeBean dischargedatetime;
	private Boolean isactive;
	private ims.vo.LookupInstanceBean dischargedestination;
	private ims.vo.LookupInstanceBean methodofdischarge;
	private Boolean wastreatmentdeferred;
	private Boolean eighteenweekclockstopped;
	private ims.core.vo.beans.BedSpaceStateLiteVoBean bedspaceforinfant;
	private ims.framework.utils.beans.DateBean dischargereadydate;
	private ims.vo.RefVoBean admissiondetail;
	private ims.vo.LookupInstanceBean vteassessmentstatus;
	private ims.vo.RefVoBean vteriskassessment;
	private Boolean wasdiagnosticdeferred;
	private Boolean wastreatmentgiven;
	private ims.vo.LookupInstanceBean deferredreason;
	private ims.scheduling.vo.beans.CancellationTypeReasonVoBean deferredreasonconfig;
	private ims.vo.RefVoBean dischargingward;
}
