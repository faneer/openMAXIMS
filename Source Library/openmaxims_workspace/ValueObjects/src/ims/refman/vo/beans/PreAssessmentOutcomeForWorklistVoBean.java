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

package ims.RefMan.vo.beans;

public class PreAssessmentOutcomeForWorklistVoBean extends ims.vo.ValueObjectBean
{
	public PreAssessmentOutcomeForWorklistVoBean()
	{
	}
	public PreAssessmentOutcomeForWorklistVoBean(ims.RefMan.vo.PreAssessmentOutcomeForWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.waitingfordetails = vo.getWaitingForDetails() == null ? null : vo.getWaitingForDetails().getBeanCollection();
		this.fittoproceed = vo.getFitToProceed();
		this.detailsoutstanding = vo.getDetailsOutstanding();
		this.preassessmentappointment = vo.getPreAssessmentAppointment() == null ? null : (ims.RefMan.vo.beans.BookAppointmentForPreAssessmentWorklistVoBean)vo.getPreAssessmentAppointment().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.PreAssessmentOutcomeForWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.waitingfordetails = vo.getWaitingForDetails() == null ? null : vo.getWaitingForDetails().getBeanCollection();
		this.fittoproceed = vo.getFitToProceed();
		this.detailsoutstanding = vo.getDetailsOutstanding();
		this.preassessmentappointment = vo.getPreAssessmentAppointment() == null ? null : (ims.RefMan.vo.beans.BookAppointmentForPreAssessmentWorklistVoBean)vo.getPreAssessmentAppointment().getBean(map);
	}

	public ims.RefMan.vo.PreAssessmentOutcomeForWorklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.PreAssessmentOutcomeForWorklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.PreAssessmentOutcomeForWorklistVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.PreAssessmentOutcomeForWorklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.PreAssessmentOutcomeForWorklistVo();
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
	public ims.RefMan.vo.beans.PreAssessmentInformationVoBean[] getWaitingForDetails()
	{
		return this.waitingfordetails;
	}
	public void setWaitingForDetails(ims.RefMan.vo.beans.PreAssessmentInformationVoBean[] value)
	{
		this.waitingfordetails = value;
	}
	public Boolean getFitToProceed()
	{
		return this.fittoproceed;
	}
	public void setFitToProceed(Boolean value)
	{
		this.fittoproceed = value;
	}
	public Boolean getDetailsOutstanding()
	{
		return this.detailsoutstanding;
	}
	public void setDetailsOutstanding(Boolean value)
	{
		this.detailsoutstanding = value;
	}
	public ims.RefMan.vo.beans.BookAppointmentForPreAssessmentWorklistVoBean getPreAssessmentAppointment()
	{
		return this.preassessmentappointment;
	}
	public void setPreAssessmentAppointment(ims.RefMan.vo.beans.BookAppointmentForPreAssessmentWorklistVoBean value)
	{
		this.preassessmentappointment = value;
	}

	private Integer id;
	private int version;
	private ims.RefMan.vo.beans.PreAssessmentInformationVoBean[] waitingfordetails;
	private Boolean fittoproceed;
	private Boolean detailsoutstanding;
	private ims.RefMan.vo.beans.BookAppointmentForPreAssessmentWorklistVoBean preassessmentappointment;
}
