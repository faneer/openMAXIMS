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

public class PathologySpecimenLiteVoBean extends ims.vo.ValueObjectBean
{
	public PathologySpecimenLiteVoBean()
	{
	}
	public PathologySpecimenLiteVoBean(ims.ocrr.vo.PathologySpecimenLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.PathologySpecimenLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
	}

	public ims.ocrr.vo.PathologySpecimenLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.PathologySpecimenLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.PathologySpecimenLiteVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.PathologySpecimenLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.PathologySpecimenLiteVo();
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
	public ims.vo.LookupInstanceBean getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.vo.LookupInstanceBean value)
	{
		this.specimensource = value;
	}
	public ims.vo.LookupInstanceBean getSiteCd()
	{
		return this.sitecd;
	}
	public void setSiteCd(ims.vo.LookupInstanceBean value)
	{
		this.sitecd = value;
	}
	public ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] getResultConclusionComments()
	{
		return this.resultconclusioncomments;
	}
	public void setResultConclusionComments(ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] value)
	{
		this.resultconclusioncomments = value;
	}
	public Boolean getColTimeFillerSupplied()
	{
		return this.coltimefillersupplied;
	}
	public void setColTimeFillerSupplied(Boolean value)
	{
		this.coltimefillersupplied = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean specimensource;
	private ims.vo.LookupInstanceBean sitecd;
	private ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] resultconclusioncomments;
	private Boolean coltimefillersupplied;
}
