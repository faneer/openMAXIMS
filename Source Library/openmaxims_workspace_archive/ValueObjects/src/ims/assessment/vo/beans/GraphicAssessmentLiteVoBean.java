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

package ims.assessment.vo.beans;

public class GraphicAssessmentLiteVoBean extends ims.vo.ValueObjectBean
{
	public GraphicAssessmentLiteVoBean()
	{
	}
	public GraphicAssessmentLiteVoBean(ims.assessment.vo.GraphicAssessmentLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.helpurl = vo.getHelpUrl();
		this.storeprintedreport = vo.getStorePrintedReport();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.GraphicAssessmentLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.helpurl = vo.getHelpUrl();
		this.storeprintedreport = vo.getStorePrintedReport();
	}

	public ims.assessment.vo.GraphicAssessmentLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.GraphicAssessmentLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.GraphicAssessmentLiteVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.GraphicAssessmentLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.GraphicAssessmentLiteVo();
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
	public ims.vo.LookupInstanceBean getAssessmentType()
	{
		return this.assessmenttype;
	}
	public void setAssessmentType(ims.vo.LookupInstanceBean value)
	{
		this.assessmenttype = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public String getHelpUrl()
	{
		return this.helpurl;
	}
	public void setHelpUrl(String value)
	{
		this.helpurl = value;
	}
	public Boolean getStorePrintedReport()
	{
		return this.storeprintedreport;
	}
	public void setStorePrintedReport(Boolean value)
	{
		this.storeprintedreport = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.vo.LookupInstanceBean assessmenttype;
	private ims.vo.LookupInstanceBean activestatus;
	private String helpurl;
	private Boolean storeprintedreport;
}
