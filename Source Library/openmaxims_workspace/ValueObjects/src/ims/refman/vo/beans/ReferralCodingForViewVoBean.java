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

public class ReferralCodingForViewVoBean extends ims.vo.ValueObjectBean
{
	public ReferralCodingForViewVoBean()
	{
	}
	public ReferralCodingForViewVoBean(ims.RefMan.vo.ReferralCodingForViewVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventForReferralCodingVoBean)vo.getPasEvent().getBean();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.BookingAppointmentOutpatientCodingVoBean)vo.getAppointment().getBean();
		this.codingitems = vo.getCodingItems() == null ? null : vo.getCodingItems().getBeanCollection();
		this.authoringmos = vo.getAuthoringMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringMOS().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.comments = vo.getComments();
		this.active = vo.getActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReferralCodingForViewVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventForReferralCodingVoBean)vo.getPasEvent().getBean(map);
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.BookingAppointmentOutpatientCodingVoBean)vo.getAppointment().getBean(map);
		this.codingitems = vo.getCodingItems() == null ? null : vo.getCodingItems().getBeanCollection();
		this.authoringmos = vo.getAuthoringMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAuthoringMOS().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.comments = vo.getComments();
		this.active = vo.getActive();
	}

	public ims.RefMan.vo.ReferralCodingForViewVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReferralCodingForViewVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReferralCodingForViewVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReferralCodingForViewVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReferralCodingForViewVo();
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
	public ims.vo.RefVoBean getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.vo.RefVoBean value)
	{
		this.catsreferral = value;
	}
	public ims.core.vo.beans.PasEventForReferralCodingVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventForReferralCodingVoBean value)
	{
		this.pasevent = value;
	}
	public ims.scheduling.vo.beans.BookingAppointmentOutpatientCodingVoBean getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.beans.BookingAppointmentOutpatientCodingVoBean value)
	{
		this.appointment = value;
	}
	public ims.RefMan.vo.beans.ReferralCodingItemVoBean[] getCodingItems()
	{
		return this.codingitems;
	}
	public void setCodingItems(ims.RefMan.vo.beans.ReferralCodingItemVoBean[] value)
	{
		this.codingitems = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAuthoringMOS()
	{
		return this.authoringmos;
	}
	public void setAuthoringMOS(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.authoringmos = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.PasEventForReferralCodingVoBean pasevent;
	private ims.scheduling.vo.beans.BookingAppointmentOutpatientCodingVoBean appointment;
	private ims.RefMan.vo.beans.ReferralCodingItemVoBean[] codingitems;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean authoringmos;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private String comments;
	private Boolean active;
}
