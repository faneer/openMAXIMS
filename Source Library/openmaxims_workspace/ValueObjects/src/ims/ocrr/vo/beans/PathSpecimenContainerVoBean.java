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

public class PathSpecimenContainerVoBean extends ims.vo.ValueObjectBean
{
	public PathSpecimenContainerVoBean()
	{
	}
	public PathSpecimenContainerVoBean(ims.ocrr.vo.PathSpecimenContainerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.volume = vo.getVolume();
		this.colour = vo.getColour() == null ? null : (ims.vo.LookupInstanceBean)vo.getColour().getBean();
		this.manufacturer = vo.getManufacturer() == null ? null : (ims.vo.LookupInstanceBean)vo.getManufacturer().getBean();
		this.manufrefno = vo.getManufRefNo();
		this.size = vo.getSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getSize().getBean();
		this.material = vo.getMaterial() == null ? null : (ims.vo.LookupInstanceBean)vo.getMaterial().getBean();
		this.additive = vo.getAdditive() == null ? null : vo.getAdditive().getBeanCollection();
		this.notes = vo.getNotes();
		this.isactive = vo.getIsActive();
		this.volumeunits = vo.getVolumeUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getVolumeUnits().getBean();
		this.pathspecimenorder = vo.getPathSpecimenOrder();
		this.taxonomymap = vo.getTaxonomyMap() == null ? null : vo.getTaxonomyMap().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.PathSpecimenContainerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.volume = vo.getVolume();
		this.colour = vo.getColour() == null ? null : (ims.vo.LookupInstanceBean)vo.getColour().getBean();
		this.manufacturer = vo.getManufacturer() == null ? null : (ims.vo.LookupInstanceBean)vo.getManufacturer().getBean();
		this.manufrefno = vo.getManufRefNo();
		this.size = vo.getSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getSize().getBean();
		this.material = vo.getMaterial() == null ? null : (ims.vo.LookupInstanceBean)vo.getMaterial().getBean();
		this.additive = vo.getAdditive() == null ? null : vo.getAdditive().getBeanCollection();
		this.notes = vo.getNotes();
		this.isactive = vo.getIsActive();
		this.volumeunits = vo.getVolumeUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getVolumeUnits().getBean();
		this.pathspecimenorder = vo.getPathSpecimenOrder();
		this.taxonomymap = vo.getTaxonomyMap() == null ? null : vo.getTaxonomyMap().getBeanCollection();
	}

	public ims.ocrr.vo.PathSpecimenContainerVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.PathSpecimenContainerVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.PathSpecimenContainerVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.PathSpecimenContainerVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.PathSpecimenContainerVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public Float getVolume()
	{
		return this.volume;
	}
	public void setVolume(Float value)
	{
		this.volume = value;
	}
	public ims.vo.LookupInstanceBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.vo.LookupInstanceBean value)
	{
		this.colour = value;
	}
	public ims.vo.LookupInstanceBean getManufacturer()
	{
		return this.manufacturer;
	}
	public void setManufacturer(ims.vo.LookupInstanceBean value)
	{
		this.manufacturer = value;
	}
	public String getManufRefNo()
	{
		return this.manufrefno;
	}
	public void setManufRefNo(String value)
	{
		this.manufrefno = value;
	}
	public ims.vo.LookupInstanceBean getSize()
	{
		return this.size;
	}
	public void setSize(ims.vo.LookupInstanceBean value)
	{
		this.size = value;
	}
	public ims.vo.LookupInstanceBean getMaterial()
	{
		return this.material;
	}
	public void setMaterial(ims.vo.LookupInstanceBean value)
	{
		this.material = value;
	}
	public java.util.Collection getAdditive()
	{
		return this.additive;
	}
	public void setAdditive(java.util.Collection value)
	{
		this.additive = value;
	}
	public void addAdditive(java.util.Collection value)
	{
		if(this.additive == null)
			this.additive = new java.util.ArrayList();
		this.additive.add(value);
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.LookupInstanceBean getVolumeUnits()
	{
		return this.volumeunits;
	}
	public void setVolumeUnits(ims.vo.LookupInstanceBean value)
	{
		this.volumeunits = value;
	}
	public Integer getPathSpecimenOrder()
	{
		return this.pathspecimenorder;
	}
	public void setPathSpecimenOrder(Integer value)
	{
		this.pathspecimenorder = value;
	}
	public ims.core.vo.beans.TaxonomyMapBean[] getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.beans.TaxonomyMapBean[] value)
	{
		this.taxonomymap = value;
	}

	private Integer id;
	private int version;
	private String name;
	private Float volume;
	private ims.vo.LookupInstanceBean colour;
	private ims.vo.LookupInstanceBean manufacturer;
	private String manufrefno;
	private ims.vo.LookupInstanceBean size;
	private ims.vo.LookupInstanceBean material;
	private java.util.Collection additive;
	private String notes;
	private Boolean isactive;
	private ims.vo.LookupInstanceBean volumeunits;
	private Integer pathspecimenorder;
	private ims.core.vo.beans.TaxonomyMapBean[] taxonomymap;
}
