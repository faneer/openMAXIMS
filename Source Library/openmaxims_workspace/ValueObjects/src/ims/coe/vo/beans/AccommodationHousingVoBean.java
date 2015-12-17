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

package ims.coe.vo.beans;

public class AccommodationHousingVoBean extends ims.vo.ValueObjectBean
{
	public AccommodationHousingVoBean()
	{
	}
	public AccommodationHousingVoBean(ims.coe.vo.AccommodationHousingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.currentlivingarrangements = vo.getCurrentLivingArrangements() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentLivingArrangements().getBean();
		this.currentlivingarrangementsnotes = vo.getCurrentLivingArrangementsNotes();
		this.accommodation = vo.getAccommodation() == null ? null : (ims.vo.LookupInstanceBean)vo.getAccommodation().getBean();
		this.accommodationnotes = vo.getAccommodationNotes();
		this.assisstancetoothers = vo.getAssisstanceToOthers() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssisstanceToOthers().getBean();
		this.assistancetoothersnotes = vo.getAssistanceToOthersNotes();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.AccommodationHousingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.currentlivingarrangements = vo.getCurrentLivingArrangements() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentLivingArrangements().getBean();
		this.currentlivingarrangementsnotes = vo.getCurrentLivingArrangementsNotes();
		this.accommodation = vo.getAccommodation() == null ? null : (ims.vo.LookupInstanceBean)vo.getAccommodation().getBean();
		this.accommodationnotes = vo.getAccommodationNotes();
		this.assisstancetoothers = vo.getAssisstanceToOthers() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssisstanceToOthers().getBean();
		this.assistancetoothersnotes = vo.getAssistanceToOthersNotes();
	}

	public ims.coe.vo.AccommodationHousingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.AccommodationHousingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.AccommodationHousingVo vo = null;
		if(map != null)
			vo = (ims.coe.vo.AccommodationHousingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.AccommodationHousingVo();
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
	public ims.vo.LookupInstanceBean getCurrentLivingArrangements()
	{
		return this.currentlivingarrangements;
	}
	public void setCurrentLivingArrangements(ims.vo.LookupInstanceBean value)
	{
		this.currentlivingarrangements = value;
	}
	public String getCurrentLivingArrangementsNotes()
	{
		return this.currentlivingarrangementsnotes;
	}
	public void setCurrentLivingArrangementsNotes(String value)
	{
		this.currentlivingarrangementsnotes = value;
	}
	public ims.vo.LookupInstanceBean getAccommodation()
	{
		return this.accommodation;
	}
	public void setAccommodation(ims.vo.LookupInstanceBean value)
	{
		this.accommodation = value;
	}
	public String getAccommodationNotes()
	{
		return this.accommodationnotes;
	}
	public void setAccommodationNotes(String value)
	{
		this.accommodationnotes = value;
	}
	public ims.vo.LookupInstanceBean getAssisstanceToOthers()
	{
		return this.assisstancetoothers;
	}
	public void setAssisstanceToOthers(ims.vo.LookupInstanceBean value)
	{
		this.assisstancetoothers = value;
	}
	public String getAssistanceToOthersNotes()
	{
		return this.assistancetoothersnotes;
	}
	public void setAssistanceToOthersNotes(String value)
	{
		this.assistancetoothersnotes = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean currentlivingarrangements;
	private String currentlivingarrangementsnotes;
	private ims.vo.LookupInstanceBean accommodation;
	private String accommodationnotes;
	private ims.vo.LookupInstanceBean assisstancetoothers;
	private String assistancetoothersnotes;
}
