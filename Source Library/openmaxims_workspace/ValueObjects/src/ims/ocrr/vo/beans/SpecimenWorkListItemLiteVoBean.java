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

public class SpecimenWorkListItemLiteVoBean extends ims.vo.ValueObjectBean
{
	public SpecimenWorkListItemLiteVoBean()
	{
	}
	public SpecimenWorkListItemLiteVoBean(ims.ocrr.vo.SpecimenWorkListItemLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetocollect = vo.getDateToCollect() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateToCollect().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean();
		this.specimen = vo.getSpecimen() == null ? null : new ims.vo.RefVoBean(vo.getSpecimen().getBoId(), vo.getSpecimen().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.SpecimenWorkListItemLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetocollect = vo.getDateToCollect() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateToCollect().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean(map);
		this.specimen = vo.getSpecimen() == null ? null : new ims.vo.RefVoBean(vo.getSpecimen().getBoId(), vo.getSpecimen().getBoVersion());
	}

	public ims.ocrr.vo.SpecimenWorkListItemLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.SpecimenWorkListItemLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.SpecimenWorkListItemLiteVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.SpecimenWorkListItemLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.SpecimenWorkListItemLiteVo();
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
	public ims.framework.utils.beans.DateBean getDateToCollect()
	{
		return this.datetocollect;
	}
	public void setDateToCollect(ims.framework.utils.beans.DateBean value)
	{
		this.datetocollect = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.ward = value;
	}
	public ims.vo.RefVoBean getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.vo.RefVoBean value)
	{
		this.specimen = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean datetocollect;
	private ims.core.vo.beans.LocationLiteVoBean ward;
	private ims.vo.RefVoBean specimen;
}
