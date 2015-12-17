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

public class ReferralDetailsEmergencyAdmissionVoBean extends ims.vo.ValueObjectBean
{
	public ReferralDetailsEmergencyAdmissionVoBean()
	{
	}
	public ReferralDetailsEmergencyAdmissionVoBean(ims.core.vo.ReferralDetailsEmergencyAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.consultant = vo.getConsultant() == null ? null : new ims.vo.RefVoBean(vo.getConsultant().getBoId(), vo.getConsultant().getBoVersion());
		this.authoringuser = vo.getAuthoringUser() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringUser().getBoId(), vo.getAuthoringUser().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.pct = vo.getPCT();
		this.gpname = vo.getGPName() == null ? null : new ims.vo.RefVoBean(vo.getGPName().getBoId(), vo.getGPName().getBoVersion());
		this.practice = vo.getPractice() == null ? null : new ims.vo.RefVoBean(vo.getPractice().getBoId(), vo.getPractice().getBoVersion());
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.enddatekpi = vo.getEndDateKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateKPI().getBean();
		this.enddateemailkpi = vo.getEndDateEmailKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateEmailKPI().getBean();
		this.enddatepaperkpi = vo.getEndDatePaperKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDatePaperKPI().getBean();
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ReferralDetailsEmergencyAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.consultant = vo.getConsultant() == null ? null : new ims.vo.RefVoBean(vo.getConsultant().getBoId(), vo.getConsultant().getBoVersion());
		this.authoringuser = vo.getAuthoringUser() == null ? null : new ims.vo.RefVoBean(vo.getAuthoringUser().getBoId(), vo.getAuthoringUser().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.pct = vo.getPCT();
		this.gpname = vo.getGPName() == null ? null : new ims.vo.RefVoBean(vo.getGPName().getBoId(), vo.getGPName().getBoVersion());
		this.practice = vo.getPractice() == null ? null : new ims.vo.RefVoBean(vo.getPractice().getBoId(), vo.getPractice().getBoVersion());
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
		this.enddatekpi = vo.getEndDateKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateKPI().getBean();
		this.enddateemailkpi = vo.getEndDateEmailKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDateEmailKPI().getBean();
		this.enddatepaperkpi = vo.getEndDatePaperKPI() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDatePaperKPI().getBean();
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
	}

	public ims.core.vo.ReferralDetailsEmergencyAdmissionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ReferralDetailsEmergencyAdmissionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ReferralDetailsEmergencyAdmissionVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ReferralDetailsEmergencyAdmissionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ReferralDetailsEmergencyAdmissionVo();
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
	public ims.vo.RefVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.vo.RefVoBean value)
	{
		this.service = value;
	}
	public ims.vo.RefVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.vo.RefVoBean value)
	{
		this.consultant = value;
	}
	public ims.vo.RefVoBean getAuthoringUser()
	{
		return this.authoringuser;
	}
	public void setAuthoringUser(ims.vo.RefVoBean value)
	{
		this.authoringuser = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.framework.utils.beans.DateBean getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.beans.DateBean value)
	{
		this.dateofreferral = value;
	}
	public ims.framework.utils.beans.DateBean getEnd18WW()
	{
		return this.end18ww;
	}
	public void setEnd18WW(ims.framework.utils.beans.DateBean value)
	{
		this.end18ww = value;
	}
	public String getPCT()
	{
		return this.pct;
	}
	public void setPCT(String value)
	{
		this.pct = value;
	}
	public ims.vo.RefVoBean getGPName()
	{
		return this.gpname;
	}
	public void setGPName(ims.vo.RefVoBean value)
	{
		this.gpname = value;
	}
	public ims.vo.RefVoBean getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.vo.RefVoBean value)
	{
		this.practice = value;
	}
	public ims.framework.utils.beans.DateBean getDateReferralReceived()
	{
		return this.datereferralreceived;
	}
	public void setDateReferralReceived(ims.framework.utils.beans.DateBean value)
	{
		this.datereferralreceived = value;
	}
	public ims.framework.utils.beans.DateBean getEndDateKPI()
	{
		return this.enddatekpi;
	}
	public void setEndDateKPI(ims.framework.utils.beans.DateBean value)
	{
		this.enddatekpi = value;
	}
	public ims.framework.utils.beans.DateBean getEndDateEmailKPI()
	{
		return this.enddateemailkpi;
	}
	public void setEndDateEmailKPI(ims.framework.utils.beans.DateBean value)
	{
		this.enddateemailkpi = value;
	}
	public ims.framework.utils.beans.DateBean getEndDatePaperKPI()
	{
		return this.enddatepaperkpi;
	}
	public void setEndDatePaperKPI(ims.framework.utils.beans.DateBean value)
	{
		this.enddatepaperkpi = value;
	}
	public ims.vo.LookupInstanceBean getReferrerType()
	{
		return this.referrertype;
	}
	public void setReferrerType(ims.vo.LookupInstanceBean value)
	{
		this.referrertype = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean service;
	private ims.vo.RefVoBean consultant;
	private ims.vo.RefVoBean authoringuser;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.framework.utils.beans.DateBean dateofreferral;
	private ims.framework.utils.beans.DateBean end18ww;
	private String pct;
	private ims.vo.RefVoBean gpname;
	private ims.vo.RefVoBean practice;
	private ims.framework.utils.beans.DateBean datereferralreceived;
	private ims.framework.utils.beans.DateBean enddatekpi;
	private ims.framework.utils.beans.DateBean enddateemailkpi;
	private ims.framework.utils.beans.DateBean enddatepaperkpi;
	private ims.vo.LookupInstanceBean referrertype;
}
