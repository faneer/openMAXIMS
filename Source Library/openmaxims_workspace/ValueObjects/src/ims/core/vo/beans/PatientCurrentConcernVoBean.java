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

public class PatientCurrentConcernVoBean extends ims.vo.ValueObjectBean
{
	public PatientCurrentConcernVoBean()
	{
	}
	public PatientCurrentConcernVoBean(ims.core.vo.PatientCurrentConcernVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assocproblem = vo.getAssocProblem() == null ? null : vo.getAssocProblem().getBeanCollection();
		this.concerndescription = vo.getConcernDescription();
		this.datetimeidentified = vo.getDateTimeIdentified() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeIdentified().getBean();
		this.teamidentified = vo.getTeamIdentified() == null ? null : (ims.vo.LookupInstanceBean)vo.getTeamIdentified().getBean();
		this.memberidentified = vo.getMemberIdentified() == null ? null : (ims.core.vo.beans.HcpBean)vo.getMemberIdentified().getBean();
		this.associatednote = vo.getAssociatedNote();
		this.allocatedtoteam = vo.getAllocatedToTeam() == null ? null : (ims.vo.LookupInstanceBean)vo.getAllocatedToTeam().getBean();
		this.alloctoteammember = vo.getAllocToTeamMember() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAllocToTeamMember().getBean();
		this.datetimeallocated = vo.getDateTimeAllocated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeAllocated().getBean();
		this.concernstatus = vo.getConcernStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcernStatus().getBean();
		this.recordinghcp = vo.getRecordingHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getRecordingHCP().getBean();
		this.updatinghcp = vo.getUpdatingHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getUpdatingHCP().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientCurrentConcernVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assocproblem = vo.getAssocProblem() == null ? null : vo.getAssocProblem().getBeanCollection();
		this.concerndescription = vo.getConcernDescription();
		this.datetimeidentified = vo.getDateTimeIdentified() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeIdentified().getBean();
		this.teamidentified = vo.getTeamIdentified() == null ? null : (ims.vo.LookupInstanceBean)vo.getTeamIdentified().getBean();
		this.memberidentified = vo.getMemberIdentified() == null ? null : (ims.core.vo.beans.HcpBean)vo.getMemberIdentified().getBean(map);
		this.associatednote = vo.getAssociatedNote();
		this.allocatedtoteam = vo.getAllocatedToTeam() == null ? null : (ims.vo.LookupInstanceBean)vo.getAllocatedToTeam().getBean();
		this.alloctoteammember = vo.getAllocToTeamMember() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAllocToTeamMember().getBean(map);
		this.datetimeallocated = vo.getDateTimeAllocated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeAllocated().getBean();
		this.concernstatus = vo.getConcernStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcernStatus().getBean();
		this.recordinghcp = vo.getRecordingHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getRecordingHCP().getBean(map);
		this.updatinghcp = vo.getUpdatingHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getUpdatingHCP().getBean(map);
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.core.vo.PatientCurrentConcernVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientCurrentConcernVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientCurrentConcernVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientCurrentConcernVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientCurrentConcernVo();
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
	public ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean[] getAssocProblem()
	{
		return this.assocproblem;
	}
	public void setAssocProblem(ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean[] value)
	{
		this.assocproblem = value;
	}
	public String getConcernDescription()
	{
		return this.concerndescription;
	}
	public void setConcernDescription(String value)
	{
		this.concerndescription = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeIdentified()
	{
		return this.datetimeidentified;
	}
	public void setDateTimeIdentified(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimeidentified = value;
	}
	public ims.vo.LookupInstanceBean getTeamIdentified()
	{
		return this.teamidentified;
	}
	public void setTeamIdentified(ims.vo.LookupInstanceBean value)
	{
		this.teamidentified = value;
	}
	public ims.core.vo.beans.HcpBean getMemberIdentified()
	{
		return this.memberidentified;
	}
	public void setMemberIdentified(ims.core.vo.beans.HcpBean value)
	{
		this.memberidentified = value;
	}
	public String getAssociatedNote()
	{
		return this.associatednote;
	}
	public void setAssociatedNote(String value)
	{
		this.associatednote = value;
	}
	public ims.vo.LookupInstanceBean getAllocatedToTeam()
	{
		return this.allocatedtoteam;
	}
	public void setAllocatedToTeam(ims.vo.LookupInstanceBean value)
	{
		this.allocatedtoteam = value;
	}
	public ims.core.vo.beans.HcpBean getAllocToTeamMember()
	{
		return this.alloctoteammember;
	}
	public void setAllocToTeamMember(ims.core.vo.beans.HcpBean value)
	{
		this.alloctoteammember = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeAllocated()
	{
		return this.datetimeallocated;
	}
	public void setDateTimeAllocated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimeallocated = value;
	}
	public ims.vo.LookupInstanceBean getConcernStatus()
	{
		return this.concernstatus;
	}
	public void setConcernStatus(ims.vo.LookupInstanceBean value)
	{
		this.concernstatus = value;
	}
	public ims.core.vo.beans.HcpBean getRecordingHCP()
	{
		return this.recordinghcp;
	}
	public void setRecordingHCP(ims.core.vo.beans.HcpBean value)
	{
		this.recordinghcp = value;
	}
	public ims.core.vo.beans.HcpBean getUpdatingHCP()
	{
		return this.updatinghcp;
	}
	public void setUpdatingHCP(ims.core.vo.beans.HcpBean value)
	{
		this.updatinghcp = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean[] assocproblem;
	private String concerndescription;
	private ims.framework.utils.beans.DateTimeBean datetimeidentified;
	private ims.vo.LookupInstanceBean teamidentified;
	private ims.core.vo.beans.HcpBean memberidentified;
	private String associatednote;
	private ims.vo.LookupInstanceBean allocatedtoteam;
	private ims.core.vo.beans.HcpBean alloctoteammember;
	private ims.framework.utils.beans.DateTimeBean datetimeallocated;
	private ims.vo.LookupInstanceBean concernstatus;
	private ims.core.vo.beans.HcpBean recordinghcp;
	private ims.core.vo.beans.HcpBean updatinghcp;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.RefVoBean carecontext;
}
