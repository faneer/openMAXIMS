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

package ims.core.vo.beans;

public class MskGroupVoBean extends ims.vo.ValueObjectBean
{
	public MskGroupVoBean()
	{
	}
	public MskGroupVoBean(ims.core.vo.MskGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.isactive = vo.getIsActive();
		this.isjoint = vo.getIsJoint();
		this.bonegeneralfindings = vo.getBoneGeneralFindings() == null ? null : vo.getBoneGeneralFindings().getBeanCollection();
		this.jointgeneralfindings = vo.getJointGeneralFindings() == null ? null : vo.getJointGeneralFindings().getBeanCollection();
		this.bones = vo.getBones() == null ? null : vo.getBones().getBeanCollection();
		this.joints = vo.getJoints() == null ? null : vo.getJoints().getBeanCollection();
		this.grouptype = vo.getGroupType() == null ? null : (ims.vo.LookupInstanceBean)vo.getGroupType().getBean();
		this.handmovementtests = vo.getHandMovementTests() == null ? null : vo.getHandMovementTests().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.MskGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.isactive = vo.getIsActive();
		this.isjoint = vo.getIsJoint();
		this.bonegeneralfindings = vo.getBoneGeneralFindings() == null ? null : vo.getBoneGeneralFindings().getBeanCollection();
		this.jointgeneralfindings = vo.getJointGeneralFindings() == null ? null : vo.getJointGeneralFindings().getBeanCollection();
		this.bones = vo.getBones() == null ? null : vo.getBones().getBeanCollection();
		this.joints = vo.getJoints() == null ? null : vo.getJoints().getBeanCollection();
		this.grouptype = vo.getGroupType() == null ? null : (ims.vo.LookupInstanceBean)vo.getGroupType().getBean();
		this.handmovementtests = vo.getHandMovementTests() == null ? null : vo.getHandMovementTests().getBeanCollection();
	}

	public ims.core.vo.MskGroupVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.MskGroupVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.MskGroupVo vo = null;
		if(map != null)
			vo = (ims.core.vo.MskGroupVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.MskGroupVo();
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
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public Boolean getIsJoint()
	{
		return this.isjoint;
	}
	public void setIsJoint(Boolean value)
	{
		this.isjoint = value;
	}
	public java.util.Collection getBoneGeneralFindings()
	{
		return this.bonegeneralfindings;
	}
	public void setBoneGeneralFindings(java.util.Collection value)
	{
		this.bonegeneralfindings = value;
	}
	public void addBoneGeneralFindings(java.util.Collection value)
	{
		if(this.bonegeneralfindings == null)
			this.bonegeneralfindings = new java.util.ArrayList();
		this.bonegeneralfindings.add(value);
	}
	public java.util.Collection getJointGeneralFindings()
	{
		return this.jointgeneralfindings;
	}
	public void setJointGeneralFindings(java.util.Collection value)
	{
		this.jointgeneralfindings = value;
	}
	public void addJointGeneralFindings(java.util.Collection value)
	{
		if(this.jointgeneralfindings == null)
			this.jointgeneralfindings = new java.util.ArrayList();
		this.jointgeneralfindings.add(value);
	}
	public java.util.Collection getBones()
	{
		return this.bones;
	}
	public void setBones(java.util.Collection value)
	{
		this.bones = value;
	}
	public void addBones(java.util.Collection value)
	{
		if(this.bones == null)
			this.bones = new java.util.ArrayList();
		this.bones.add(value);
	}
	public ims.core.vo.beans.MskJointVoBean[] getJoints()
	{
		return this.joints;
	}
	public void setJoints(ims.core.vo.beans.MskJointVoBean[] value)
	{
		this.joints = value;
	}
	public ims.vo.LookupInstanceBean getGroupType()
	{
		return this.grouptype;
	}
	public void setGroupType(ims.vo.LookupInstanceBean value)
	{
		this.grouptype = value;
	}
	public java.util.Collection getHandMovementTests()
	{
		return this.handmovementtests;
	}
	public void setHandMovementTests(java.util.Collection value)
	{
		this.handmovementtests = value;
	}
	public void addHandMovementTests(java.util.Collection value)
	{
		if(this.handmovementtests == null)
			this.handmovementtests = new java.util.ArrayList();
		this.handmovementtests.add(value);
	}

	private Integer id;
	private int version;
	private String name;
	private String description;
	private Boolean isactive;
	private Boolean isjoint;
	private java.util.Collection bonegeneralfindings;
	private java.util.Collection jointgeneralfindings;
	private java.util.Collection bones;
	private ims.core.vo.beans.MskJointVoBean[] joints;
	private ims.vo.LookupInstanceBean grouptype;
	private java.util.Collection handmovementtests;
}
