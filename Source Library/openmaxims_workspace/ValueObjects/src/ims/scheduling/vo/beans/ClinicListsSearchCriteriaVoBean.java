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

package ims.scheduling.vo.beans;

public class ClinicListsSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public ClinicListsSearchCriteriaVoBean()
	{
	}
	public ClinicListsSearchCriteriaVoBean(ims.scheduling.vo.ClinicListsSearchCriteriaVo vo)
	{
		this.profile = vo.getProfile() == null ? null : (ims.scheduling.vo.beans.ProfileShortVoBean)vo.getProfile().getBean();
		this.clinic = vo.getClinic() == null ? null : (ims.scheduling.vo.beans.SessionShortVoBean)vo.getClinic().getBean();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivity().getBean();
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.ClinicListsSearchCriteriaVo vo)
	{
		this.profile = vo.getProfile() == null ? null : (ims.scheduling.vo.beans.ProfileShortVoBean)vo.getProfile().getBean(map);
		this.clinic = vo.getClinic() == null ? null : (ims.scheduling.vo.beans.SessionShortVoBean)vo.getClinic().getBean(map);
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivity().getBean();
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
	}

	public ims.scheduling.vo.ClinicListsSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.ClinicListsSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.ClinicListsSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.ClinicListsSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.ClinicListsSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.scheduling.vo.beans.ProfileShortVoBean getProfile()
	{
		return this.profile;
	}
	public void setProfile(ims.scheduling.vo.beans.ProfileShortVoBean value)
	{
		this.profile = value;
	}
	public ims.scheduling.vo.beans.SessionShortVoBean getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.scheduling.vo.beans.SessionShortVoBean value)
	{
		this.clinic = value;
	}
	public ims.framework.utils.beans.DateBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateBean value)
	{
		this.date = value;
	}
	public ims.vo.LookupInstanceBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.vo.LookupInstanceBean value)
	{
		this.activity = value;
	}
	public ims.vo.LookupInstanceBean getListType()
	{
		return this.listtype;
	}
	public void setListType(ims.vo.LookupInstanceBean value)
	{
		this.listtype = value;
	}

	private ims.scheduling.vo.beans.ProfileShortVoBean profile;
	private ims.scheduling.vo.beans.SessionShortVoBean clinic;
	private ims.framework.utils.beans.DateBean date;
	private ims.vo.LookupInstanceBean activity;
	private ims.vo.LookupInstanceBean listtype;
}
