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

public class ServiceDiagnosticsVoBean extends ims.vo.ValueObjectBean
{
	public ServiceDiagnosticsVoBean()
	{
	}
	public ServiceDiagnosticsVoBean(ims.core.vo.ServiceDiagnosticsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.diagnostics = vo.getDiagnostics() == null ? null : vo.getDiagnostics().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ServiceDiagnosticsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.diagnostics = vo.getDiagnostics() == null ? null : vo.getDiagnostics().getBeanCollection();
	}

	public ims.core.vo.ServiceDiagnosticsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ServiceDiagnosticsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ServiceDiagnosticsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ServiceDiagnosticsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ServiceDiagnosticsVo();
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
	public ims.vo.RefVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.vo.RefVoBean value)
	{
		this.service = value;
	}
	public java.util.Collection getDiagnostics()
	{
		return this.diagnostics;
	}
	public void setDiagnostics(java.util.Collection value)
	{
		this.diagnostics = value;
	}
	public void addDiagnostics(java.util.Collection value)
	{
		if(this.diagnostics == null)
			this.diagnostics = new java.util.ArrayList();
		this.diagnostics.add(value);
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean service;
	private java.util.Collection diagnostics;
}
