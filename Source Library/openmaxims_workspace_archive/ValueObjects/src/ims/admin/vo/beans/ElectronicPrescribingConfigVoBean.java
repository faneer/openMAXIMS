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

public class ElectronicPrescribingConfigVoBean extends ims.vo.ValueObjectBean
{
	public ElectronicPrescribingConfigVoBean()
	{
	}
	public ElectronicPrescribingConfigVoBean(ims.admin.vo.ElectronicPrescribingConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.button = vo.getButton() == null ? null : (ims.vo.LookupInstanceBean)vo.getButton().getBean();
		this.buttontext = vo.getButtonText();
		this.labeltext = vo.getLabelText();
		this.buttonexecutablepath = vo.getButtonExecutablePath();
		this.buttonparameter = vo.getButtonParameter();
		this.buttondeniedroleaccess = vo.getButtonDeniedRoleAccess() == null ? null : vo.getButtonDeniedRoleAccess().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ElectronicPrescribingConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.button = vo.getButton() == null ? null : (ims.vo.LookupInstanceBean)vo.getButton().getBean();
		this.buttontext = vo.getButtonText();
		this.labeltext = vo.getLabelText();
		this.buttonexecutablepath = vo.getButtonExecutablePath();
		this.buttonparameter = vo.getButtonParameter();
		this.buttondeniedroleaccess = vo.getButtonDeniedRoleAccess() == null ? null : vo.getButtonDeniedRoleAccess().getBeanCollection();
	}

	public ims.admin.vo.ElectronicPrescribingConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ElectronicPrescribingConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ElectronicPrescribingConfigVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ElectronicPrescribingConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ElectronicPrescribingConfigVo();
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
	public ims.vo.LookupInstanceBean getButton()
	{
		return this.button;
	}
	public void setButton(ims.vo.LookupInstanceBean value)
	{
		this.button = value;
	}
	public String getButtonText()
	{
		return this.buttontext;
	}
	public void setButtonText(String value)
	{
		this.buttontext = value;
	}
	public String getLabelText()
	{
		return this.labeltext;
	}
	public void setLabelText(String value)
	{
		this.labeltext = value;
	}
	public String getButtonExecutablePath()
	{
		return this.buttonexecutablepath;
	}
	public void setButtonExecutablePath(String value)
	{
		this.buttonexecutablepath = value;
	}
	public String getButtonParameter()
	{
		return this.buttonparameter;
	}
	public void setButtonParameter(String value)
	{
		this.buttonparameter = value;
	}
	public ims.admin.vo.beans.AppRoleShortVoBean[] getButtonDeniedRoleAccess()
	{
		return this.buttondeniedroleaccess;
	}
	public void setButtonDeniedRoleAccess(ims.admin.vo.beans.AppRoleShortVoBean[] value)
	{
		this.buttondeniedroleaccess = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean button;
	private String buttontext;
	private String labeltext;
	private String buttonexecutablepath;
	private String buttonparameter;
	private ims.admin.vo.beans.AppRoleShortVoBean[] buttondeniedroleaccess;
}
