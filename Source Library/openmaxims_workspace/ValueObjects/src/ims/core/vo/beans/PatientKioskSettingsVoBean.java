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

public class PatientKioskSettingsVoBean extends ims.vo.ValueObjectBean
{
	public PatientKioskSettingsVoBean()
	{
	}
	public PatientKioskSettingsVoBean(ims.core.vo.PatientKioskSettingsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theme = vo.getTheme() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheme().getBean();
		this.timeout = vo.getTimeout();
		this.webserviceurl = vo.getWebServiceUrl();
		this.appupdateurl = vo.getAppUpdateUrl();
		this.autoinstallupdates = vo.getAutoInstallUpdates();
		this.alloweddelay = vo.getAllowedDelay();
		this.showappointments = vo.getShowAppointments();
		this.messages = vo.getMessages() == null ? null : vo.getMessages().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientKioskSettingsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theme = vo.getTheme() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheme().getBean();
		this.timeout = vo.getTimeout();
		this.webserviceurl = vo.getWebServiceUrl();
		this.appupdateurl = vo.getAppUpdateUrl();
		this.autoinstallupdates = vo.getAutoInstallUpdates();
		this.alloweddelay = vo.getAllowedDelay();
		this.showappointments = vo.getShowAppointments();
		this.messages = vo.getMessages() == null ? null : vo.getMessages().getBeanCollection();
	}

	public ims.core.vo.PatientKioskSettingsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientKioskSettingsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientKioskSettingsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientKioskSettingsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientKioskSettingsVo();
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
	public ims.vo.LookupInstanceBean getTheme()
	{
		return this.theme;
	}
	public void setTheme(ims.vo.LookupInstanceBean value)
	{
		this.theme = value;
	}
	public Integer getTimeout()
	{
		return this.timeout;
	}
	public void setTimeout(Integer value)
	{
		this.timeout = value;
	}
	public String getWebServiceUrl()
	{
		return this.webserviceurl;
	}
	public void setWebServiceUrl(String value)
	{
		this.webserviceurl = value;
	}
	public String getAppUpdateUrl()
	{
		return this.appupdateurl;
	}
	public void setAppUpdateUrl(String value)
	{
		this.appupdateurl = value;
	}
	public Boolean getAutoInstallUpdates()
	{
		return this.autoinstallupdates;
	}
	public void setAutoInstallUpdates(Boolean value)
	{
		this.autoinstallupdates = value;
	}
	public Integer getAllowedDelay()
	{
		return this.alloweddelay;
	}
	public void setAllowedDelay(Integer value)
	{
		this.alloweddelay = value;
	}
	public Boolean getShowAppointments()
	{
		return this.showappointments;
	}
	public void setShowAppointments(Boolean value)
	{
		this.showappointments = value;
	}
	public ims.core.vo.beans.PatientKioskMessageVoBean[] getMessages()
	{
		return this.messages;
	}
	public void setMessages(ims.core.vo.beans.PatientKioskMessageVoBean[] value)
	{
		this.messages = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean theme;
	private Integer timeout;
	private String webserviceurl;
	private String appupdateurl;
	private Boolean autoinstallupdates;
	private Integer alloweddelay;
	private Boolean showappointments;
	private ims.core.vo.beans.PatientKioskMessageVoBean[] messages;
}
