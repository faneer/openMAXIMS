//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.icp.vo.beans;

public class PatientICPActionStatusVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPActionStatusVoBean()
	{
	}
	public PatientICPActionStatusVoBean(ims.icp.vo.PatientICPActionStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.statusdate = vo.getStatusDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDate().getBean();
		this.changedby = vo.getChangedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getChangedBy().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.variancecategory = vo.getVarianceCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getVarianceCategory().getBean();
		this.variancetype = vo.getVarianceType() == null ? null : (ims.vo.LookupInstanceBean)vo.getVarianceType().getBean();
		this.variancecomment = vo.getVarianceComment();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPActionStatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.statusdate = vo.getStatusDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusDate().getBean();
		this.changedby = vo.getChangedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getChangedBy().getBean(map);
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.variancecategory = vo.getVarianceCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getVarianceCategory().getBean();
		this.variancetype = vo.getVarianceType() == null ? null : (ims.vo.LookupInstanceBean)vo.getVarianceType().getBean();
		this.variancecomment = vo.getVarianceComment();
	}

	public ims.icp.vo.PatientICPActionStatusVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPActionStatusVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPActionStatusVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPActionStatusVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPActionStatusVo();
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
	public ims.framework.utils.beans.DateTimeBean getStatusDate()
	{
		return this.statusdate;
	}
	public void setStatusDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.statusdate = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getChangedBy()
	{
		return this.changedby;
	}
	public void setChangedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.changedby = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.vo.LookupInstanceBean getVarianceCategory()
	{
		return this.variancecategory;
	}
	public void setVarianceCategory(ims.vo.LookupInstanceBean value)
	{
		this.variancecategory = value;
	}
	public ims.vo.LookupInstanceBean getVarianceType()
	{
		return this.variancetype;
	}
	public void setVarianceType(ims.vo.LookupInstanceBean value)
	{
		this.variancetype = value;
	}
	public String getVarianceComment()
	{
		return this.variancecomment;
	}
	public void setVarianceComment(String value)
	{
		this.variancecomment = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean statusdate;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean changedby;
	private ims.vo.LookupInstanceBean status;
	private ims.vo.LookupInstanceBean variancecategory;
	private ims.vo.LookupInstanceBean variancetype;
	private String variancecomment;
}
