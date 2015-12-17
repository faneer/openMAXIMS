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

public class NewResultInvestigationVoBean extends ims.vo.ValueObjectBean
{
	public NewResultInvestigationVoBean()
	{
	}
	public NewResultInvestigationVoBean(ims.ocrr.vo.NewResultInvestigationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providerservice = vo.getProviderService() == null ? null : (ims.ocrr.vo.beans.NewResultProvidorServiceVoBean)vo.getProviderService().getBean();
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocrr.vo.beans.InvestigationIndexLiteVoBean)vo.getInvestigationIndex().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.pathinvdetails = vo.getPathInvDetails() == null ? null : (ims.ocrr.vo.beans.PathInvDetailsForNewResultInvestigationVoBean)vo.getPathInvDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.NewResultInvestigationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providerservice = vo.getProviderService() == null ? null : (ims.ocrr.vo.beans.NewResultProvidorServiceVoBean)vo.getProviderService().getBean(map);
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocrr.vo.beans.InvestigationIndexLiteVoBean)vo.getInvestigationIndex().getBean(map);
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.pathinvdetails = vo.getPathInvDetails() == null ? null : (ims.ocrr.vo.beans.PathInvDetailsForNewResultInvestigationVoBean)vo.getPathInvDetails().getBean(map);
	}

	public ims.ocrr.vo.NewResultInvestigationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.NewResultInvestigationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.NewResultInvestigationVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.NewResultInvestigationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.NewResultInvestigationVo();
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
	public ims.ocrr.vo.beans.NewResultProvidorServiceVoBean getProviderService()
	{
		return this.providerservice;
	}
	public void setProviderService(ims.ocrr.vo.beans.NewResultProvidorServiceVoBean value)
	{
		this.providerservice = value;
	}
	public ims.ocrr.vo.beans.InvestigationIndexLiteVoBean getInvestigationIndex()
	{
		return this.investigationindex;
	}
	public void setInvestigationIndex(ims.ocrr.vo.beans.InvestigationIndexLiteVoBean value)
	{
		this.investigationindex = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public ims.ocrr.vo.beans.PathInvDetailsForNewResultInvestigationVoBean getPathInvDetails()
	{
		return this.pathinvdetails;
	}
	public void setPathInvDetails(ims.ocrr.vo.beans.PathInvDetailsForNewResultInvestigationVoBean value)
	{
		this.pathinvdetails = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.NewResultProvidorServiceVoBean providerservice;
	private ims.ocrr.vo.beans.InvestigationIndexLiteVoBean investigationindex;
	private ims.vo.LookupInstanceBean type;
	private ims.vo.LookupInstanceBean eventtype;
	private ims.ocrr.vo.beans.PathInvDetailsForNewResultInvestigationVoBean pathinvdetails;
}
