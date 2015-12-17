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

public class NeedsAssessmentListVoBean extends ims.vo.ValueObjectBean
{
	public NeedsAssessmentListVoBean()
	{
	}
	public NeedsAssessmentListVoBean(ims.core.vo.NeedsAssessmentListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.goalplanmeetingdate = vo.getGoalPlanMeetingDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getGoalPlanMeetingDate().getBean();
		this.needassessmentnumber = vo.getNeedAssessmentNumber() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeedAssessmentNumber().getBean();
		this.hadbooklet = vo.getHadBooklet() == null ? null : (ims.vo.LookupInstanceBean)vo.getHadBooklet().getBean();
		this.attachbooklettosummarysheet = vo.getAttachBookletToSummarySheet() == null ? null : (ims.vo.LookupInstanceBean)vo.getAttachBookletToSummarySheet().getBean();
		this.datestarted = vo.getDateStarted() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateStarted().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringHCP().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.NeedsAssessmentListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.goalplanmeetingdate = vo.getGoalPlanMeetingDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getGoalPlanMeetingDate().getBean();
		this.needassessmentnumber = vo.getNeedAssessmentNumber() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeedAssessmentNumber().getBean();
		this.hadbooklet = vo.getHadBooklet() == null ? null : (ims.vo.LookupInstanceBean)vo.getHadBooklet().getBean();
		this.attachbooklettosummarysheet = vo.getAttachBookletToSummarySheet() == null ? null : (ims.vo.LookupInstanceBean)vo.getAttachBookletToSummarySheet().getBean();
		this.datestarted = vo.getDateStarted() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateStarted().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringHCP().getBean(map);
	}

	public ims.core.vo.NeedsAssessmentListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.NeedsAssessmentListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.NeedsAssessmentListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.NeedsAssessmentListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.NeedsAssessmentListVo();
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
	public ims.framework.utils.beans.DateBean getGoalPlanMeetingDate()
	{
		return this.goalplanmeetingdate;
	}
	public void setGoalPlanMeetingDate(ims.framework.utils.beans.DateBean value)
	{
		this.goalplanmeetingdate = value;
	}
	public ims.vo.LookupInstanceBean getNeedAssessmentNumber()
	{
		return this.needassessmentnumber;
	}
	public void setNeedAssessmentNumber(ims.vo.LookupInstanceBean value)
	{
		this.needassessmentnumber = value;
	}
	public ims.vo.LookupInstanceBean getHadBooklet()
	{
		return this.hadbooklet;
	}
	public void setHadBooklet(ims.vo.LookupInstanceBean value)
	{
		this.hadbooklet = value;
	}
	public ims.vo.LookupInstanceBean getAttachBookletToSummarySheet()
	{
		return this.attachbooklettosummarysheet;
	}
	public void setAttachBookletToSummarySheet(ims.vo.LookupInstanceBean value)
	{
		this.attachbooklettosummarysheet = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateStarted()
	{
		return this.datestarted;
	}
	public void setDateStarted(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datestarted = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringhcp = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean goalplanmeetingdate;
	private ims.vo.LookupInstanceBean needassessmentnumber;
	private ims.vo.LookupInstanceBean hadbooklet;
	private ims.vo.LookupInstanceBean attachbooklettosummarysheet;
	private ims.framework.utils.beans.DateTimeBean datestarted;
	private ims.core.vo.beans.HcpBean authoringhcp;
}
