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

public class CancerTypeItemConfigVoBean extends ims.vo.ValueObjectBean
{
	public CancerTypeItemConfigVoBean()
	{
	}
	public CancerTypeItemConfigVoBean(ims.RefMan.vo.CancerTypeItemConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.cancertype = vo.getCancerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerType().getBean();
		this.day31target = vo.getDay31Target();
		this.day62target = vo.getDay62Target();
		this.availablefornationalscreening = vo.getAvailableForNationalScreening();
		this.noreferralletterrequired = vo.getNoReferralLetterRequired();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.CancerTypeItemConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.cancertype = vo.getCancerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerType().getBean();
		this.day31target = vo.getDay31Target();
		this.day62target = vo.getDay62Target();
		this.availablefornationalscreening = vo.getAvailableForNationalScreening();
		this.noreferralletterrequired = vo.getNoReferralLetterRequired();
	}

	public ims.RefMan.vo.CancerTypeItemConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.CancerTypeItemConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.CancerTypeItemConfigVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.CancerTypeItemConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.CancerTypeItemConfigVo();
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
	public ims.vo.LookupInstanceBean getCancerType()
	{
		return this.cancertype;
	}
	public void setCancerType(ims.vo.LookupInstanceBean value)
	{
		this.cancertype = value;
	}
	public Boolean getDay31Target()
	{
		return this.day31target;
	}
	public void setDay31Target(Boolean value)
	{
		this.day31target = value;
	}
	public Boolean getDay62Target()
	{
		return this.day62target;
	}
	public void setDay62Target(Boolean value)
	{
		this.day62target = value;
	}
	public Boolean getAvailableForNationalScreening()
	{
		return this.availablefornationalscreening;
	}
	public void setAvailableForNationalScreening(Boolean value)
	{
		this.availablefornationalscreening = value;
	}
	public Boolean getNoReferralLetterRequired()
	{
		return this.noreferralletterrequired;
	}
	public void setNoReferralLetterRequired(Boolean value)
	{
		this.noreferralletterrequired = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean cancertype;
	private Boolean day31target;
	private Boolean day62target;
	private Boolean availablefornationalscreening;
	private Boolean noreferralletterrequired;
}
