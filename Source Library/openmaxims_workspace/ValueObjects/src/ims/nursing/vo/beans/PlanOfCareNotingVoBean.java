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

package ims.nursing.vo.beans;

public class PlanOfCareNotingVoBean extends ims.vo.ValueObjectBean
{
	public PlanOfCareNotingVoBean()
	{
	}
	public PlanOfCareNotingVoBean(ims.nursing.vo.PlanOfCareNotingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.reviewingdatetime = vo.getReviewingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewingDateTime().getBean();
		this.reviewinghcp = vo.getReviewingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReviewingHCP().getBean();
		this.actionstatus = vo.getActionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActionStatus().getBean();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.PlanOfCareNotingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.reviewingdatetime = vo.getReviewingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewingDateTime().getBean();
		this.reviewinghcp = vo.getReviewingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReviewingHCP().getBean(map);
		this.actionstatus = vo.getActionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActionStatus().getBean();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
	}

	public ims.nursing.vo.PlanOfCareNotingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.PlanOfCareNotingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.PlanOfCareNotingVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.PlanOfCareNotingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.PlanOfCareNotingVo();
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
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReviewingDateTime()
	{
		return this.reviewingdatetime;
	}
	public void setReviewingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.reviewingdatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getReviewingHCP()
	{
		return this.reviewinghcp;
	}
	public void setReviewingHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.reviewinghcp = value;
	}
	public ims.vo.LookupInstanceBean getActionStatus()
	{
		return this.actionstatus;
	}
	public void setActionStatus(ims.vo.LookupInstanceBean value)
	{
		this.actionstatus = value;
	}
	public ims.nursing.vo.beans.PlanOfCareActionsVoBean[] getActions()
	{
		return this.actions;
	}
	public void setActions(ims.nursing.vo.beans.PlanOfCareActionsVoBean[] value)
	{
		this.actions = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.framework.utils.beans.DateTimeBean reviewingdatetime;
	private ims.core.vo.beans.HcpLiteVoBean reviewinghcp;
	private ims.vo.LookupInstanceBean actionstatus;
	private ims.nursing.vo.beans.PlanOfCareActionsVoBean[] actions;
}
