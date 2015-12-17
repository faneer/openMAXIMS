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

package ims.admin.vo.beans;

public class UserDTOVoBean extends ims.vo.ValueObjectBean
{
	public UserDTOVoBean()
	{
	}
	public UserDTOVoBean(ims.admin.vo.UserDTOVo vo)
	{
		this.username = vo.getUserName();
		this.effectiveto = vo.getEffectiveTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveTo().getBean();
		this.effectivefrom = vo.getEffectiveFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveFrom().getBean();
		this.passwordexpirydate = vo.getPasswordExpiryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPasswordExpiryDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.UserDTOVo vo)
	{
		this.username = vo.getUserName();
		this.effectiveto = vo.getEffectiveTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveTo().getBean();
		this.effectivefrom = vo.getEffectiveFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveFrom().getBean();
		this.passwordexpirydate = vo.getPasswordExpiryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPasswordExpiryDate().getBean();
	}

	public ims.admin.vo.UserDTOVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.UserDTOVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.UserDTOVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.UserDTOVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.UserDTOVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getUserName()
	{
		return this.username;
	}
	public void setUserName(String value)
	{
		this.username = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEffectiveTo()
	{
		return this.effectiveto;
	}
	public void setEffectiveTo(ims.framework.utils.beans.DateTimeBean value)
	{
		this.effectiveto = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEffectiveFrom()
	{
		return this.effectivefrom;
	}
	public void setEffectiveFrom(ims.framework.utils.beans.DateTimeBean value)
	{
		this.effectivefrom = value;
	}
	public ims.framework.utils.beans.DateBean getPasswordExpiryDate()
	{
		return this.passwordexpirydate;
	}
	public void setPasswordExpiryDate(ims.framework.utils.beans.DateBean value)
	{
		this.passwordexpirydate = value;
	}

	private String username;
	private ims.framework.utils.beans.DateTimeBean effectiveto;
	private ims.framework.utils.beans.DateTimeBean effectivefrom;
	private ims.framework.utils.beans.DateBean passwordexpirydate;
}
