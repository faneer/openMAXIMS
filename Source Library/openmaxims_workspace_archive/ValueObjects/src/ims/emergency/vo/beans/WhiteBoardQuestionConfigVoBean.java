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

package ims.emergency.vo.beans;

public class WhiteBoardQuestionConfigVoBean extends ims.vo.ValueObjectBean
{
	public WhiteBoardQuestionConfigVoBean()
	{
	}
	public WhiteBoardQuestionConfigVoBean(ims.emergency.vo.WhiteBoardQuestionConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.questiontext = vo.getQuestionText();
		this.columnheadertext = vo.getColumnHeaderText();
		this.answertype = vo.getAnswerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnswerType().getBean();
		this.options = vo.getOptions() == null ? null : vo.getOptions().getBeanCollection();
		this.columnwidth = vo.getColumnWidth();
		this.genderspecific = vo.getGenderSpecific() == null ? null : (ims.vo.LookupInstanceBean)vo.getGenderSpecific().getBean();
		this.agerangemin = vo.getAgeRangeMin();
		this.agerangemax = vo.getAgeRangeMax();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.WhiteBoardQuestionConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.questiontext = vo.getQuestionText();
		this.columnheadertext = vo.getColumnHeaderText();
		this.answertype = vo.getAnswerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnswerType().getBean();
		this.options = vo.getOptions() == null ? null : vo.getOptions().getBeanCollection();
		this.columnwidth = vo.getColumnWidth();
		this.genderspecific = vo.getGenderSpecific() == null ? null : (ims.vo.LookupInstanceBean)vo.getGenderSpecific().getBean();
		this.agerangemin = vo.getAgeRangeMin();
		this.agerangemax = vo.getAgeRangeMax();
	}

	public ims.emergency.vo.WhiteBoardQuestionConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.WhiteBoardQuestionConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.WhiteBoardQuestionConfigVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.WhiteBoardQuestionConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.WhiteBoardQuestionConfigVo();
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
	public String getQuestionText()
	{
		return this.questiontext;
	}
	public void setQuestionText(String value)
	{
		this.questiontext = value;
	}
	public String getColumnHeaderText()
	{
		return this.columnheadertext;
	}
	public void setColumnHeaderText(String value)
	{
		this.columnheadertext = value;
	}
	public ims.vo.LookupInstanceBean getAnswerType()
	{
		return this.answertype;
	}
	public void setAnswerType(ims.vo.LookupInstanceBean value)
	{
		this.answertype = value;
	}
	public ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean[] getOptions()
	{
		return this.options;
	}
	public void setOptions(ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean[] value)
	{
		this.options = value;
	}
	public Integer getColumnWidth()
	{
		return this.columnwidth;
	}
	public void setColumnWidth(Integer value)
	{
		this.columnwidth = value;
	}
	public ims.vo.LookupInstanceBean getGenderSpecific()
	{
		return this.genderspecific;
	}
	public void setGenderSpecific(ims.vo.LookupInstanceBean value)
	{
		this.genderspecific = value;
	}
	public Integer getAgeRangeMin()
	{
		return this.agerangemin;
	}
	public void setAgeRangeMin(Integer value)
	{
		this.agerangemin = value;
	}
	public Integer getAgeRangeMax()
	{
		return this.agerangemax;
	}
	public void setAgeRangeMax(Integer value)
	{
		this.agerangemax = value;
	}

	private Integer id;
	private int version;
	private String questiontext;
	private String columnheadertext;
	private ims.vo.LookupInstanceBean answertype;
	private ims.core.vo.beans.AnswerOptionForEDWhiteboardConfigVoBean[] options;
	private Integer columnwidth;
	private ims.vo.LookupInstanceBean genderspecific;
	private Integer agerangemin;
	private Integer agerangemax;
}
