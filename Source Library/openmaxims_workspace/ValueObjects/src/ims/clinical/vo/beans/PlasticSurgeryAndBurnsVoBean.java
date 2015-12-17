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

package ims.clinical.vo.beans;

public class PlasticSurgeryAndBurnsVoBean extends ims.vo.ValueObjectBean
{
	public PlasticSurgeryAndBurnsVoBean()
	{
	}
	public PlasticSurgeryAndBurnsVoBean(ims.clinical.vo.PlasticSurgeryAndBurnsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.anaesthetictype = vo.getAnaestheticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticType().getBean();
		this.skinforstorage = vo.getSkinForStorage() == null ? null : (ims.vo.LookupInstanceBean)vo.getSkinForStorage().getBean();
		this.scheduledfirstdressingdate = vo.getScheduledFirstDressingDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getScheduledFirstDressingDate().getBean();
		this.scheduledsutureremoval = vo.getScheduledSutureRemoval() == null ? null : (ims.framework.utils.beans.DateBean)vo.getScheduledSutureRemoval().getBean();
		this.surgeon = vo.getSurgeon() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSurgeon().getBean();
		this.iscomplete = vo.getIsComplete();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PlasticSurgeryAndBurnsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.anaesthetictype = vo.getAnaestheticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticType().getBean();
		this.skinforstorage = vo.getSkinForStorage() == null ? null : (ims.vo.LookupInstanceBean)vo.getSkinForStorage().getBean();
		this.scheduledfirstdressingdate = vo.getScheduledFirstDressingDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getScheduledFirstDressingDate().getBean();
		this.scheduledsutureremoval = vo.getScheduledSutureRemoval() == null ? null : (ims.framework.utils.beans.DateBean)vo.getScheduledSutureRemoval().getBean();
		this.surgeon = vo.getSurgeon() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSurgeon().getBean(map);
		this.iscomplete = vo.getIsComplete();
	}

	public ims.clinical.vo.PlasticSurgeryAndBurnsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PlasticSurgeryAndBurnsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PlasticSurgeryAndBurnsVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PlasticSurgeryAndBurnsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PlasticSurgeryAndBurnsVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.LookupInstanceBean getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.vo.LookupInstanceBean value)
	{
		this.anaesthetictype = value;
	}
	public ims.vo.LookupInstanceBean getSkinForStorage()
	{
		return this.skinforstorage;
	}
	public void setSkinForStorage(ims.vo.LookupInstanceBean value)
	{
		this.skinforstorage = value;
	}
	public ims.framework.utils.beans.DateBean getScheduledFirstDressingDate()
	{
		return this.scheduledfirstdressingdate;
	}
	public void setScheduledFirstDressingDate(ims.framework.utils.beans.DateBean value)
	{
		this.scheduledfirstdressingdate = value;
	}
	public ims.framework.utils.beans.DateBean getScheduledSutureRemoval()
	{
		return this.scheduledsutureremoval;
	}
	public void setScheduledSutureRemoval(ims.framework.utils.beans.DateBean value)
	{
		this.scheduledsutureremoval = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSurgeon()
	{
		return this.surgeon;
	}
	public void setSurgeon(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.surgeon = value;
	}
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.iscomplete = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.LookupInstanceBean anaesthetictype;
	private ims.vo.LookupInstanceBean skinforstorage;
	private ims.framework.utils.beans.DateBean scheduledfirstdressingdate;
	private ims.framework.utils.beans.DateBean scheduledsutureremoval;
	private ims.core.vo.beans.HcpLiteVoBean surgeon;
	private Boolean iscomplete;
}
