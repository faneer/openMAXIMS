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

package ims.ocs_if.vo.beans;

public class IfOcsResCommentVoBean extends ims.vo.ValueObjectBean
{
	public IfOcsResCommentVoBean()
	{
	}
	public IfOcsResCommentVoBean(ims.ocs_if.vo.IfOcsResCommentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.commenttype = vo.getCommentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCommentType().getBean();
		this.cmtsrc = vo.getCmtSrc();
		this.cmttext = vo.getCmtText();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.IfOcsResCommentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.commenttype = vo.getCommentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCommentType().getBean();
		this.cmtsrc = vo.getCmtSrc();
		this.cmttext = vo.getCmtText();
	}

	public ims.ocs_if.vo.IfOcsResCommentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.IfOcsResCommentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.IfOcsResCommentVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.IfOcsResCommentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.IfOcsResCommentVo();
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
	public ims.vo.LookupInstanceBean getCommentType()
	{
		return this.commenttype;
	}
	public void setCommentType(ims.vo.LookupInstanceBean value)
	{
		this.commenttype = value;
	}
	public String getCmtSrc()
	{
		return this.cmtsrc;
	}
	public void setCmtSrc(String value)
	{
		this.cmtsrc = value;
	}
	public String getCmtText()
	{
		return this.cmttext;
	}
	public void setCmtText(String value)
	{
		this.cmttext = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean commenttype;
	private String cmtsrc;
	private String cmttext;
}
