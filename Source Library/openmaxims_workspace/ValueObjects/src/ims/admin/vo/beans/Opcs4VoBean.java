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

public class Opcs4VoBean extends ims.vo.ValueObjectBean
{
	public Opcs4VoBean()
	{
	}
	public Opcs4VoBean(ims.admin.vo.Opcs4Vo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.selindic = vo.getSelindic();
		this.opprefix = vo.getOpprefix();
		this.opcode = vo.getOpcode();
		this.opname3 = vo.getOpname3();
		this.opname4 = vo.getOpname4();
		this.sexa = vo.getSexa();
		this.sexs = vo.getSexs();
		this.opstatus = vo.getOpstatus();
		this.delmetod = vo.getDelmetod();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.Opcs4Vo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.selindic = vo.getSelindic();
		this.opprefix = vo.getOpprefix();
		this.opcode = vo.getOpcode();
		this.opname3 = vo.getOpname3();
		this.opname4 = vo.getOpname4();
		this.sexa = vo.getSexa();
		this.sexs = vo.getSexs();
		this.opstatus = vo.getOpstatus();
		this.delmetod = vo.getDelmetod();
	}

	public ims.admin.vo.Opcs4Vo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.Opcs4Vo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.Opcs4Vo vo = null;
		if(map != null)
			vo = (ims.admin.vo.Opcs4Vo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.Opcs4Vo();
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
	public String getSelindic()
	{
		return this.selindic;
	}
	public void setSelindic(String value)
	{
		this.selindic = value;
	}
	public String getOpprefix()
	{
		return this.opprefix;
	}
	public void setOpprefix(String value)
	{
		this.opprefix = value;
	}
	public String getOpcode()
	{
		return this.opcode;
	}
	public void setOpcode(String value)
	{
		this.opcode = value;
	}
	public String getOpname3()
	{
		return this.opname3;
	}
	public void setOpname3(String value)
	{
		this.opname3 = value;
	}
	public String getOpname4()
	{
		return this.opname4;
	}
	public void setOpname4(String value)
	{
		this.opname4 = value;
	}
	public String getSexa()
	{
		return this.sexa;
	}
	public void setSexa(String value)
	{
		this.sexa = value;
	}
	public String getSexs()
	{
		return this.sexs;
	}
	public void setSexs(String value)
	{
		this.sexs = value;
	}
	public String getOpstatus()
	{
		return this.opstatus;
	}
	public void setOpstatus(String value)
	{
		this.opstatus = value;
	}
	public String getDelmetod()
	{
		return this.delmetod;
	}
	public void setDelmetod(String value)
	{
		this.delmetod = value;
	}

	private Integer id;
	private int version;
	private String selindic;
	private String opprefix;
	private String opcode;
	private String opname3;
	private String opname4;
	private String sexa;
	private String sexs;
	private String opstatus;
	private String delmetod;
}
