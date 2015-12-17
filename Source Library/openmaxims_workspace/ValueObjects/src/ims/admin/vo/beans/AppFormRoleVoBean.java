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

public class AppFormRoleVoBean extends ims.vo.ValueObjectBean
{
	public AppFormRoleVoBean()
	{
	}
	public AppFormRoleVoBean(ims.admin.vo.AppFormRoleVo vo)
	{
		this.form = vo.getForm() == null ? null : (ims.admin.vo.beans.AppFormVoBean)vo.getForm().getBean();
		this.formreadwrite = vo.getFormReadWrite() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormReadWrite().getBean();
		this.formepisodeaccess = vo.getFormEpisodeAccess() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormEpisodeAccess().getBean();
		this.formpatientaccess = vo.getFormPatientAccess() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormPatientAccess().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.AppFormRoleVo vo)
	{
		this.form = vo.getForm() == null ? null : (ims.admin.vo.beans.AppFormVoBean)vo.getForm().getBean(map);
		this.formreadwrite = vo.getFormReadWrite() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormReadWrite().getBean();
		this.formepisodeaccess = vo.getFormEpisodeAccess() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormEpisodeAccess().getBean();
		this.formpatientaccess = vo.getFormPatientAccess() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormPatientAccess().getBean();
	}

	public ims.admin.vo.AppFormRoleVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.AppFormRoleVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.AppFormRoleVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.AppFormRoleVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.AppFormRoleVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.admin.vo.beans.AppFormVoBean getForm()
	{
		return this.form;
	}
	public void setForm(ims.admin.vo.beans.AppFormVoBean value)
	{
		this.form = value;
	}
	public ims.vo.LookupInstanceBean getFormReadWrite()
	{
		return this.formreadwrite;
	}
	public void setFormReadWrite(ims.vo.LookupInstanceBean value)
	{
		this.formreadwrite = value;
	}
	public ims.vo.LookupInstanceBean getFormEpisodeAccess()
	{
		return this.formepisodeaccess;
	}
	public void setFormEpisodeAccess(ims.vo.LookupInstanceBean value)
	{
		this.formepisodeaccess = value;
	}
	public ims.vo.LookupInstanceBean getFormPatientAccess()
	{
		return this.formpatientaccess;
	}
	public void setFormPatientAccess(ims.vo.LookupInstanceBean value)
	{
		this.formpatientaccess = value;
	}

	private ims.admin.vo.beans.AppFormVoBean form;
	private ims.vo.LookupInstanceBean formreadwrite;
	private ims.vo.LookupInstanceBean formepisodeaccess;
	private ims.vo.LookupInstanceBean formpatientaccess;
}
