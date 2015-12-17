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

package ims.eas.vo.beans;

public class DiagnosticImageTransferVoBean extends ims.vo.ValueObjectBean
{
	public DiagnosticImageTransferVoBean()
	{
	}
	public DiagnosticImageTransferVoBean(ims.eas.vo.DiagnosticImageTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.dateseen = vo.getDateSeen() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSeen().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean();
		this.imagetransfer = vo.getImageTransfer() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageTransfer().getBean();
		this.easstatus = vo.getEASStatus() == null ? null : (ims.eas.vo.beans.EasStatusLiteVoBean)vo.getEASStatus().getBean();
		this.removedstat = vo.getRemovedStat();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.DiagnosticImageTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.dateseen = vo.getDateSeen() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSeen().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean(map);
		this.imagetransfer = vo.getImageTransfer() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageTransfer().getBean();
		this.easstatus = vo.getEASStatus() == null ? null : (ims.eas.vo.beans.EasStatusLiteVoBean)vo.getEASStatus().getBean(map);
		this.removedstat = vo.getRemovedStat();
	}

	public ims.eas.vo.DiagnosticImageTransferVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.eas.vo.DiagnosticImageTransferVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.DiagnosticImageTransferVo vo = null;
		if(map != null)
			vo = (ims.eas.vo.DiagnosticImageTransferVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.eas.vo.DiagnosticImageTransferVo();
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
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.framework.utils.beans.DateBean getDateSeen()
	{
		return this.dateseen;
	}
	public void setDateSeen(ims.framework.utils.beans.DateBean value)
	{
		this.dateseen = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.seenby = value;
	}
	public ims.vo.LookupInstanceBean getImageTransfer()
	{
		return this.imagetransfer;
	}
	public void setImageTransfer(ims.vo.LookupInstanceBean value)
	{
		this.imagetransfer = value;
	}
	public ims.eas.vo.beans.EasStatusLiteVoBean getEASStatus()
	{
		return this.easstatus;
	}
	public void setEASStatus(ims.eas.vo.beans.EasStatusLiteVoBean value)
	{
		this.easstatus = value;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.removedstat = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.framework.utils.beans.DateBean dateseen;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.core.vo.beans.HcpLiteVoBean seenby;
	private ims.vo.LookupInstanceBean imagetransfer;
	private ims.eas.vo.beans.EasStatusLiteVoBean easstatus;
	private Boolean removedstat;
}
