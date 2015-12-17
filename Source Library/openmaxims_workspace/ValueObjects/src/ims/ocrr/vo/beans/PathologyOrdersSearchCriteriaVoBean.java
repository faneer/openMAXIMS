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

package ims.ocrr.vo.beans;

public class PathologyOrdersSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public PathologyOrdersSearchCriteriaVoBean()
	{
	}
	public PathologyOrdersSearchCriteriaVoBean(ims.ocrr.vo.PathologyOrdersSearchCriteriaVo vo)
	{
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getDiscipline().getBean();
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.PathologyOrdersSearchCriteriaVo vo)
	{
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.discipline = vo.getDiscipline() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getDiscipline().getBean(map);
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
	}

	public ims.ocrr.vo.PathologyOrdersSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.PathologyOrdersSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.PathologyOrdersSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.PathologyOrdersSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.PathologyOrdersSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.LocationLiteVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.location = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.discipline = value;
	}
	public ims.framework.utils.beans.DateBean getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.fromdate = value;
	}
	public ims.framework.utils.beans.DateBean getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.beans.DateBean value)
	{
		this.todate = value;
	}

	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.core.vo.beans.ServiceLiteVoBean discipline;
	private ims.framework.utils.beans.DateBean fromdate;
	private ims.framework.utils.beans.DateBean todate;
}
