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

public class SecurityLevelConfigVoBean extends ims.vo.ValueObjectBean
{
	public SecurityLevelConfigVoBean()
	{
	}
	public SecurityLevelConfigVoBean(ims.ocrr.vo.SecurityLevelConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.securitylevel = vo.getSecurityLevel();
		this.securityleveldescription = vo.getSecurityLevelDescription();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.SecurityLevelConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.securitylevel = vo.getSecurityLevel();
		this.securityleveldescription = vo.getSecurityLevelDescription();
	}

	public ims.ocrr.vo.SecurityLevelConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.SecurityLevelConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.SecurityLevelConfigVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.SecurityLevelConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.SecurityLevelConfigVo();
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
	public Integer getSecurityLevel()
	{
		return this.securitylevel;
	}
	public void setSecurityLevel(Integer value)
	{
		this.securitylevel = value;
	}
	public String getSecurityLevelDescription()
	{
		return this.securityleveldescription;
	}
	public void setSecurityLevelDescription(String value)
	{
		this.securityleveldescription = value;
	}

	private Integer id;
	private int version;
	private Integer securitylevel;
	private String securityleveldescription;
}
