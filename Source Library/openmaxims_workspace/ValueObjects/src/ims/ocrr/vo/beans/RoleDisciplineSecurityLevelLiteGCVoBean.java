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

public class RoleDisciplineSecurityLevelLiteGCVoBean extends ims.vo.ValueObjectBean
{
	public RoleDisciplineSecurityLevelLiteGCVoBean()
	{
	}
	public RoleDisciplineSecurityLevelLiteGCVoBean(ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo vo)
	{
		this.roledisciplinesecuritylevels = vo.getRoleDisciplineSecurityLevels() == null ? null : vo.getRoleDisciplineSecurityLevels().getBeanCollection();
		this.isconfigloaded = vo.getIsConfigLoaded();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo vo)
	{
		this.roledisciplinesecuritylevels = vo.getRoleDisciplineSecurityLevels() == null ? null : vo.getRoleDisciplineSecurityLevels().getBeanCollection();
		this.isconfigloaded = vo.getIsConfigLoaded();
	}

	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.ocrr.vo.beans.RoleDisciplineSecurityLevelLiteVoBean[] getRoleDisciplineSecurityLevels()
	{
		return this.roledisciplinesecuritylevels;
	}
	public void setRoleDisciplineSecurityLevels(ims.ocrr.vo.beans.RoleDisciplineSecurityLevelLiteVoBean[] value)
	{
		this.roledisciplinesecuritylevels = value;
	}
	public Boolean getIsConfigLoaded()
	{
		return this.isconfigloaded;
	}
	public void setIsConfigLoaded(Boolean value)
	{
		this.isconfigloaded = value;
	}

	private ims.ocrr.vo.beans.RoleDisciplineSecurityLevelLiteVoBean[] roledisciplinesecuritylevels;
	private Boolean isconfigloaded;
}
