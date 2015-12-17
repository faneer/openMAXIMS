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

package ims.generalmedical.vo.beans;

public class AdmisSysRevewVoBean extends ims.vo.ValueObjectBean
{
	public AdmisSysRevewVoBean()
	{
	}
	public AdmisSysRevewVoBean(ims.generalmedical.vo.AdmisSysRevewVo vo)
	{
		this.systemreview = vo.getSystemReview() == null ? null : (ims.generalmedical.vo.beans.SystemReviewVoBean)vo.getSystemReview().getBean();
		this.problemsonadmission = vo.getProblemsOnAdmission() == null ? null : vo.getProblemsOnAdmission().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.AdmisSysRevewVo vo)
	{
		this.systemreview = vo.getSystemReview() == null ? null : (ims.generalmedical.vo.beans.SystemReviewVoBean)vo.getSystemReview().getBean(map);
		this.problemsonadmission = vo.getProblemsOnAdmission() == null ? null : vo.getProblemsOnAdmission().getBeanCollection();
	}

	public ims.generalmedical.vo.AdmisSysRevewVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.AdmisSysRevewVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.AdmisSysRevewVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.AdmisSysRevewVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.AdmisSysRevewVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.generalmedical.vo.beans.SystemReviewVoBean getSystemReview()
	{
		return this.systemreview;
	}
	public void setSystemReview(ims.generalmedical.vo.beans.SystemReviewVoBean value)
	{
		this.systemreview = value;
	}
	public ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean[] getProblemsOnAdmission()
	{
		return this.problemsonadmission;
	}
	public void setProblemsOnAdmission(ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean[] value)
	{
		this.problemsonadmission = value;
	}

	private ims.generalmedical.vo.beans.SystemReviewVoBean systemreview;
	private ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean[] problemsonadmission;
}
