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

package ims.admin.vo.beans;

public class UserNotificationDetailsVoBean extends ims.vo.ValueObjectBean
{
	public UserNotificationDetailsVoBean()
	{
	}
	public UserNotificationDetailsVoBean(ims.admin.vo.UserNotificationDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.email = vo.getEmail();
		this.mobilephone = vo.getMobilePhone();
		this.mobiledevices = vo.getMobileDevices() == null ? null : vo.getMobileDevices().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.UserNotificationDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.email = vo.getEmail();
		this.mobilephone = vo.getMobilePhone();
		this.mobiledevices = vo.getMobileDevices() == null ? null : vo.getMobileDevices().getBeanCollection();
	}

	public ims.admin.vo.UserNotificationDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.UserNotificationDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.UserNotificationDetailsVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.UserNotificationDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.UserNotificationDetailsVo();
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
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String value)
	{
		this.email = value;
	}
	public String getMobilePhone()
	{
		return this.mobilephone;
	}
	public void setMobilePhone(String value)
	{
		this.mobilephone = value;
	}
	public ims.admin.vo.beans.MobileDeviceVoBean[] getMobileDevices()
	{
		return this.mobiledevices;
	}
	public void setMobileDevices(ims.admin.vo.beans.MobileDeviceVoBean[] value)
	{
		this.mobiledevices = value;
	}

	private Integer id;
	private int version;
	private String email;
	private String mobilephone;
	private ims.admin.vo.beans.MobileDeviceVoBean[] mobiledevices;
}
