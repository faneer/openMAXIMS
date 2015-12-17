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

public class AppUserShortWithNameVoBean extends ims.vo.ValueObjectBean
{
	public AppUserShortWithNameVoBean()
	{
	}
	public AppUserShortWithNameVoBean(ims.admin.vo.AppUserShortWithNameVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.username = vo.getUsername();
		this.password = vo.getPassword();
		this.encodedpassword = vo.getEncodedPassword();
		this.theme = vo.getTheme();
		this.pwdexpdate = vo.getPwdExpDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getPwdExpDate().getBean();
		this.effectivefrom = vo.getEffectiveFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveFrom().getBean();
		this.effectiveto = vo.getEffectiveTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveTo().getBean();
		this.isactive = vo.getIsActive();
		this.userrealname = vo.getUserRealName();
		this.debugmode = vo.getDebugMode();
		this.ldapusername = vo.getLDAPUsername();
		this.ldappassword = vo.getLDAPPassword();
		this.mosname = vo.getMosName() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getMosName().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.AppUserShortWithNameVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.username = vo.getUsername();
		this.password = vo.getPassword();
		this.encodedpassword = vo.getEncodedPassword();
		this.theme = vo.getTheme();
		this.pwdexpdate = vo.getPwdExpDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getPwdExpDate().getBean();
		this.effectivefrom = vo.getEffectiveFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveFrom().getBean();
		this.effectiveto = vo.getEffectiveTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEffectiveTo().getBean();
		this.isactive = vo.getIsActive();
		this.userrealname = vo.getUserRealName();
		this.debugmode = vo.getDebugMode();
		this.ldapusername = vo.getLDAPUsername();
		this.ldappassword = vo.getLDAPPassword();
		this.mosname = vo.getMosName() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getMosName().getBean(map);
	}

	public ims.admin.vo.AppUserShortWithNameVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.AppUserShortWithNameVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.AppUserShortWithNameVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.AppUserShortWithNameVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.AppUserShortWithNameVo();
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
	public String getUsername()
	{
		return this.username;
	}
	public void setUsername(String value)
	{
		this.username = value;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String value)
	{
		this.password = value;
	}
	public String getEncodedPassword()
	{
		return this.encodedpassword;
	}
	public void setEncodedPassword(String value)
	{
		this.encodedpassword = value;
	}
	public String getTheme()
	{
		return this.theme;
	}
	public void setTheme(String value)
	{
		this.theme = value;
	}
	public ims.framework.utils.beans.DateTimeBean getPwdExpDate()
	{
		return this.pwdexpdate;
	}
	public void setPwdExpDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.pwdexpdate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEffectiveFrom()
	{
		return this.effectivefrom;
	}
	public void setEffectiveFrom(ims.framework.utils.beans.DateTimeBean value)
	{
		this.effectivefrom = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEffectiveTo()
	{
		return this.effectiveto;
	}
	public void setEffectiveTo(ims.framework.utils.beans.DateTimeBean value)
	{
		this.effectiveto = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public String getUserRealName()
	{
		return this.userrealname;
	}
	public void setUserRealName(String value)
	{
		this.userrealname = value;
	}
	public Boolean getDebugMode()
	{
		return this.debugmode;
	}
	public void setDebugMode(Boolean value)
	{
		this.debugmode = value;
	}
	public String getLDAPUsername()
	{
		return this.ldapusername;
	}
	public void setLDAPUsername(String value)
	{
		this.ldapusername = value;
	}
	public String getLDAPPassword()
	{
		return this.ldappassword;
	}
	public void setLDAPPassword(String value)
	{
		this.ldappassword = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getMosName()
	{
		return this.mosname;
	}
	public void setMosName(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.mosname = value;
	}

	private Integer id;
	private int version;
	private String username;
	private String password;
	private String encodedpassword;
	private String theme;
	private ims.framework.utils.beans.DateTimeBean pwdexpdate;
	private ims.framework.utils.beans.DateTimeBean effectivefrom;
	private ims.framework.utils.beans.DateTimeBean effectiveto;
	private Boolean isactive;
	private String userrealname;
	private Boolean debugmode;
	private String ldapusername;
	private String ldappassword;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean mosname;
}
