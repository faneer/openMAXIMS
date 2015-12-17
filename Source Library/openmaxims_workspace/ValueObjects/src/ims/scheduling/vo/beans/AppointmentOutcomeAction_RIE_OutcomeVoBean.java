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

package ims.scheduling.vo.beans;

public class AppointmentOutcomeAction_RIE_OutcomeVoBean extends ims.vo.ValueObjectBean
{
	public AppointmentOutcomeAction_RIE_OutcomeVoBean()
	{
	}
	public AppointmentOutcomeAction_RIE_OutcomeVoBean(ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentaction = vo.getAppointmentAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppointmentAction().getBean();
		this.outcomeofaction = vo.getOutcomeOfAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeOfAction().getBean();
		this.patientelectivelist = vo.getPatientElectiveList() == null ? null : new ims.vo.RefVoBean(vo.getPatientElectiveList().getBoId(), vo.getPatientElectiveList().getBoVersion());
		this.futureappointmentdetail = vo.getFutureAppointmentDetail() == null ? null : new ims.vo.RefVoBean(vo.getFutureAppointmentDetail().getBoId(), vo.getFutureAppointmentDetail().getBoVersion());
		this.iptout = vo.getIPTOUT() == null ? null : new ims.vo.RefVoBean(vo.getIPTOUT().getBoId(), vo.getIPTOUT().getBoVersion());
		if(vo.getLinkedRequestForService() != null)
		{
			this.linkedrequestforservice = new ims.vo.RefVoBean[vo.getLinkedRequestForService().size()];
			for(int linkedrequestforservice_i = 0; linkedrequestforservice_i < vo.getLinkedRequestForService().size(); linkedrequestforservice_i++)
			{
				this.linkedrequestforservice[linkedrequestforservice_i] = new ims.vo.RefVoBean(vo.getLinkedRequestForService().get(linkedrequestforservice_i).getBoId(),vo.getLinkedRequestForService().get(linkedrequestforservice_i).getBoVersion());
			}
		}
		this.linkedtransferofcare = vo.getLinkedTransferOfCare() == null ? null : new ims.vo.RefVoBean(vo.getLinkedTransferOfCare().getBoId(), vo.getLinkedTransferOfCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentaction = vo.getAppointmentAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppointmentAction().getBean();
		this.outcomeofaction = vo.getOutcomeOfAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeOfAction().getBean();
		this.patientelectivelist = vo.getPatientElectiveList() == null ? null : new ims.vo.RefVoBean(vo.getPatientElectiveList().getBoId(), vo.getPatientElectiveList().getBoVersion());
		this.futureappointmentdetail = vo.getFutureAppointmentDetail() == null ? null : new ims.vo.RefVoBean(vo.getFutureAppointmentDetail().getBoId(), vo.getFutureAppointmentDetail().getBoVersion());
		this.iptout = vo.getIPTOUT() == null ? null : new ims.vo.RefVoBean(vo.getIPTOUT().getBoId(), vo.getIPTOUT().getBoVersion());
		if(vo.getLinkedRequestForService() != null)
		{
			this.linkedrequestforservice = new ims.vo.RefVoBean[vo.getLinkedRequestForService().size()];
			for(int linkedrequestforservice_i = 0; linkedrequestforservice_i < vo.getLinkedRequestForService().size(); linkedrequestforservice_i++)
			{
				this.linkedrequestforservice[linkedrequestforservice_i] = new ims.vo.RefVoBean(vo.getLinkedRequestForService().get(linkedrequestforservice_i).getBoId(),vo.getLinkedRequestForService().get(linkedrequestforservice_i).getBoVersion());
			}
		}
		this.linkedtransferofcare = vo.getLinkedTransferOfCare() == null ? null : new ims.vo.RefVoBean(vo.getLinkedTransferOfCare().getBoId(), vo.getLinkedTransferOfCare().getBoVersion());
	}

	public ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVo();
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
	public ims.vo.LookupInstanceBean getAppointmentAction()
	{
		return this.appointmentaction;
	}
	public void setAppointmentAction(ims.vo.LookupInstanceBean value)
	{
		this.appointmentaction = value;
	}
	public ims.vo.LookupInstanceBean getOutcomeOfAction()
	{
		return this.outcomeofaction;
	}
	public void setOutcomeOfAction(ims.vo.LookupInstanceBean value)
	{
		this.outcomeofaction = value;
	}
	public ims.vo.RefVoBean getPatientElectiveList()
	{
		return this.patientelectivelist;
	}
	public void setPatientElectiveList(ims.vo.RefVoBean value)
	{
		this.patientelectivelist = value;
	}
	public ims.vo.RefVoBean getFutureAppointmentDetail()
	{
		return this.futureappointmentdetail;
	}
	public void setFutureAppointmentDetail(ims.vo.RefVoBean value)
	{
		this.futureappointmentdetail = value;
	}
	public ims.vo.RefVoBean getIPTOUT()
	{
		return this.iptout;
	}
	public void setIPTOUT(ims.vo.RefVoBean value)
	{
		this.iptout = value;
	}
	public ims.vo.RefVoBean[] getLinkedRequestForService()
	{
		return this.linkedrequestforservice;
	}
	public void setLinkedRequestForService(ims.vo.RefVoBean[] value)
	{
		this.linkedrequestforservice = value;
	}
	public ims.vo.RefVoBean getLinkedTransferOfCare()
	{
		return this.linkedtransferofcare;
	}
	public void setLinkedTransferOfCare(ims.vo.RefVoBean value)
	{
		this.linkedtransferofcare = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean appointmentaction;
	private ims.vo.LookupInstanceBean outcomeofaction;
	private ims.vo.RefVoBean patientelectivelist;
	private ims.vo.RefVoBean futureappointmentdetail;
	private ims.vo.RefVoBean iptout;
	private ims.vo.RefVoBean[] linkedrequestforservice;
	private ims.vo.RefVoBean linkedtransferofcare;
}
