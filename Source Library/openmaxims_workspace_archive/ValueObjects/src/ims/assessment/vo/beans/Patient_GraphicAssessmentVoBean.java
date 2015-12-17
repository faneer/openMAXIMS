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

public class Patient_GraphicAssessmentVoBean extends ims.vo.ValueObjectBean
{
	public Patient_GraphicAssessmentVoBean()
	{
	}
	public Patient_GraphicAssessmentVoBean(ims.assessment.vo.Patient_GraphicAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.graphicimage = vo.getGraphicImage() == null ? null : (ims.core.vo.beans.DrawingGraphicImageVoBean)vo.getGraphicImage().getBean();
		this.patientgraphicfinding = vo.getPatientGraphicFinding() == null ? null : vo.getPatientGraphicFinding().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.Patient_GraphicAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.graphicimage = vo.getGraphicImage() == null ? null : (ims.core.vo.beans.DrawingGraphicImageVoBean)vo.getGraphicImage().getBean(map);
		this.patientgraphicfinding = vo.getPatientGraphicFinding() == null ? null : vo.getPatientGraphicFinding().getBeanCollection();
	}

	public ims.assessment.vo.Patient_GraphicAssessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.Patient_GraphicAssessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.Patient_GraphicAssessmentVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.Patient_GraphicAssessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.Patient_GraphicAssessmentVo();
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
	public ims.core.vo.beans.DrawingGraphicImageVoBean getGraphicImage()
	{
		return this.graphicimage;
	}
	public void setGraphicImage(ims.core.vo.beans.DrawingGraphicImageVoBean value)
	{
		this.graphicimage = value;
	}
	public ims.assessment.vo.beans.Patient_GraphicAssessmentFindingVoBean[] getPatientGraphicFinding()
	{
		return this.patientgraphicfinding;
	}
	public void setPatientGraphicFinding(ims.assessment.vo.beans.Patient_GraphicAssessmentFindingVoBean[] value)
	{
		this.patientgraphicfinding = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.DrawingGraphicImageVoBean graphicimage;
	private ims.assessment.vo.beans.Patient_GraphicAssessmentFindingVoBean[] patientgraphicfinding;
}
