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

package ims.emergency.vo.beans;

public class ColumnDetailVoBean extends ims.vo.ValueObjectBean
{
	public ColumnDetailVoBean()
	{
	}
	public ColumnDetailVoBean(ims.emergency.vo.ColumnDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.colheader = vo.getColHeader();
		this.colwidth = vo.getColWidth();
		this.displayimage = vo.getDisplayImage();
		this.image = vo.getImage() == null ? null : new ims.vo.RefVoBean(vo.getImage().getBoId(), vo.getImage().getBoVersion());
		this.column = vo.getColumn() == null ? null : (ims.vo.LookupInstanceBean)vo.getColumn().getBean();
		this.ischecked = vo.getIsChecked();
		this.maskinpublicarea = vo.getMaskInPublicArea();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.ColumnDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.colheader = vo.getColHeader();
		this.colwidth = vo.getColWidth();
		this.displayimage = vo.getDisplayImage();
		this.image = vo.getImage() == null ? null : new ims.vo.RefVoBean(vo.getImage().getBoId(), vo.getImage().getBoVersion());
		this.column = vo.getColumn() == null ? null : (ims.vo.LookupInstanceBean)vo.getColumn().getBean();
		this.ischecked = vo.getIsChecked();
		this.maskinpublicarea = vo.getMaskInPublicArea();
	}

	public ims.emergency.vo.ColumnDetailVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.ColumnDetailVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.ColumnDetailVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.ColumnDetailVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.ColumnDetailVo();
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
	public String getColHeader()
	{
		return this.colheader;
	}
	public void setColHeader(String value)
	{
		this.colheader = value;
	}
	public Integer getColWidth()
	{
		return this.colwidth;
	}
	public void setColWidth(Integer value)
	{
		this.colwidth = value;
	}
	public Boolean getDisplayImage()
	{
		return this.displayimage;
	}
	public void setDisplayImage(Boolean value)
	{
		this.displayimage = value;
	}
	public ims.vo.RefVoBean getImage()
	{
		return this.image;
	}
	public void setImage(ims.vo.RefVoBean value)
	{
		this.image = value;
	}
	public ims.vo.LookupInstanceBean getColumn()
	{
		return this.column;
	}
	public void setColumn(ims.vo.LookupInstanceBean value)
	{
		this.column = value;
	}
	public Boolean getIsChecked()
	{
		return this.ischecked;
	}
	public void setIsChecked(Boolean value)
	{
		this.ischecked = value;
	}
	public Boolean getMaskInPublicArea()
	{
		return this.maskinpublicarea;
	}
	public void setMaskInPublicArea(Boolean value)
	{
		this.maskinpublicarea = value;
	}

	private Integer id;
	private int version;
	private String colheader;
	private Integer colwidth;
	private Boolean displayimage;
	private ims.vo.RefVoBean image;
	private ims.vo.LookupInstanceBean column;
	private Boolean ischecked;
	private Boolean maskinpublicarea;
}
