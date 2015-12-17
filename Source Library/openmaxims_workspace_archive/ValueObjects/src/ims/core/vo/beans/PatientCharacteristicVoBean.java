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

package ims.core.vo.beans;

public class PatientCharacteristicVoBean extends ims.vo.ValueObjectBean
{
	public PatientCharacteristicVoBean()
	{
	}
	public PatientCharacteristicVoBean(ims.core.vo.PatientCharacteristicVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.characterestictype = vo.getCharacteresticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCharacteresticType().getBean();
		this.implanteddevice = vo.getImplantedDevice();
		this.insertionprocedure = vo.getInsertionProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureVoBean)vo.getInsertionProcedure().getBean();
		this.removalprocedure = vo.getRemovalProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureVoBean)vo.getRemovalProcedure().getBean();
		this.isremoved = vo.getIsRemoved();
		this.dateinserted = vo.getDateInserted() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateInserted().getBean();
		this.dateremoved = vo.getDateRemoved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateRemoved().getBean();
		this.isactive = vo.getIsActive();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientCharacteristicVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.characterestictype = vo.getCharacteresticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCharacteresticType().getBean();
		this.implanteddevice = vo.getImplantedDevice();
		this.insertionprocedure = vo.getInsertionProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureVoBean)vo.getInsertionProcedure().getBean(map);
		this.removalprocedure = vo.getRemovalProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureVoBean)vo.getRemovalProcedure().getBean(map);
		this.isremoved = vo.getIsRemoved();
		this.dateinserted = vo.getDateInserted() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateInserted().getBean();
		this.dateremoved = vo.getDateRemoved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateRemoved().getBean();
		this.isactive = vo.getIsActive();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
	}

	public ims.core.vo.PatientCharacteristicVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientCharacteristicVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientCharacteristicVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientCharacteristicVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientCharacteristicVo();
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
	public ims.vo.LookupInstanceBean getCharacteresticType()
	{
		return this.characterestictype;
	}
	public void setCharacteresticType(ims.vo.LookupInstanceBean value)
	{
		this.characterestictype = value;
	}
	public String getImplantedDevice()
	{
		return this.implanteddevice;
	}
	public void setImplantedDevice(String value)
	{
		this.implanteddevice = value;
	}
	public ims.core.vo.beans.PatientProcedureVoBean getInsertionProcedure()
	{
		return this.insertionprocedure;
	}
	public void setInsertionProcedure(ims.core.vo.beans.PatientProcedureVoBean value)
	{
		this.insertionprocedure = value;
	}
	public ims.core.vo.beans.PatientProcedureVoBean getRemovalProcedure()
	{
		return this.removalprocedure;
	}
	public void setRemovalProcedure(ims.core.vo.beans.PatientProcedureVoBean value)
	{
		this.removalprocedure = value;
	}
	public Boolean getIsRemoved()
	{
		return this.isremoved;
	}
	public void setIsRemoved(Boolean value)
	{
		this.isremoved = value;
	}
	public ims.framework.utils.beans.DateBean getDateInserted()
	{
		return this.dateinserted;
	}
	public void setDateInserted(ims.framework.utils.beans.DateBean value)
	{
		this.dateinserted = value;
	}
	public ims.framework.utils.beans.DateBean getDateRemoved()
	{
		return this.dateremoved;
	}
	public void setDateRemoved(ims.framework.utils.beans.DateBean value)
	{
		this.dateremoved = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean characterestictype;
	private String implanteddevice;
	private ims.core.vo.beans.PatientProcedureVoBean insertionprocedure;
	private ims.core.vo.beans.PatientProcedureVoBean removalprocedure;
	private Boolean isremoved;
	private ims.framework.utils.beans.DateBean dateinserted;
	private ims.framework.utils.beans.DateBean dateremoved;
	private Boolean isactive;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.RefVoBean patient;
}
