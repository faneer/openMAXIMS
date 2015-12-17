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

public class PatientCaseNoteVoBean extends ims.vo.ValueObjectBean
{
	public PatientCaseNoteVoBean()
	{
	}
	public PatientCaseNoteVoBean(ims.core.vo.PatientCaseNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.currentlocation = vo.getCurrentLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getCurrentLocation().getBean();
		this.folder = vo.getFolder() == null ? null : (ims.vo.LookupInstanceBean)vo.getFolder().getBean();
		this.trackingid = vo.getTrackingID();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		if(vo.getOpenRequests() != null)
		{
			this.openrequests = new ims.vo.RefVoBean[vo.getOpenRequests().size()];
			for(int openrequests_i = 0; openrequests_i < vo.getOpenRequests().size(); openrequests_i++)
			{
				this.openrequests[openrequests_i] = new ims.vo.RefVoBean(vo.getOpenRequests().get(openrequests_i).getBoId(),vo.getOpenRequests().get(openrequests_i).getBoVersion());
			}
		}
		this.createdby = vo.getCreatedBy() == null ? null : new ims.vo.RefVoBean(vo.getCreatedBy().getBoId(), vo.getCreatedBy().getBoVersion());
		this.creationdate = vo.getCreationDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreationDate().getBean();
		this.currentcomment = vo.getCurrentComment() == null ? null : (ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean)vo.getCurrentComment().getBean();
		this.archivedby = vo.getArchivedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getArchivedBy().getBean();
		this.archiveddate = vo.getArchivedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArchivedDate().getBean();
		this.archivedcomment = vo.getArchivedComment();
		this.destroyedby = vo.getDestroyedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getDestroyedBy().getBean();
		this.destroyeddate = vo.getDestroyedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDestroyedDate().getBean();
		this.destroyedcomment = vo.getDestroyedComment();
		this.mergedby = vo.getMergedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getMergedBy().getBean();
		this.mergeddate = vo.getMergedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMergedDate().getBean();
		this.mergedfrom = vo.getMergedFrom() == null ? null : new ims.vo.RefVoBean(vo.getMergedFrom().getBoId(), vo.getMergedFrom().getBoVersion());
		this.scannedby = vo.getScannedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getScannedBy().getBean();
		this.scanneddate = vo.getScannedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getScannedDate().getBean();
		this.scannedcomment = vo.getScannedComment();
		this.lasttransferdate = vo.getLastTransferDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastTransferDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientCaseNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.currentlocation = vo.getCurrentLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getCurrentLocation().getBean(map);
		this.folder = vo.getFolder() == null ? null : (ims.vo.LookupInstanceBean)vo.getFolder().getBean();
		this.trackingid = vo.getTrackingID();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		if(vo.getOpenRequests() != null)
		{
			this.openrequests = new ims.vo.RefVoBean[vo.getOpenRequests().size()];
			for(int openrequests_i = 0; openrequests_i < vo.getOpenRequests().size(); openrequests_i++)
			{
				this.openrequests[openrequests_i] = new ims.vo.RefVoBean(vo.getOpenRequests().get(openrequests_i).getBoId(),vo.getOpenRequests().get(openrequests_i).getBoVersion());
			}
		}
		this.createdby = vo.getCreatedBy() == null ? null : new ims.vo.RefVoBean(vo.getCreatedBy().getBoId(), vo.getCreatedBy().getBoVersion());
		this.creationdate = vo.getCreationDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreationDate().getBean();
		this.currentcomment = vo.getCurrentComment() == null ? null : (ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean)vo.getCurrentComment().getBean(map);
		this.archivedby = vo.getArchivedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getArchivedBy().getBean(map);
		this.archiveddate = vo.getArchivedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArchivedDate().getBean();
		this.archivedcomment = vo.getArchivedComment();
		this.destroyedby = vo.getDestroyedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getDestroyedBy().getBean(map);
		this.destroyeddate = vo.getDestroyedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDestroyedDate().getBean();
		this.destroyedcomment = vo.getDestroyedComment();
		this.mergedby = vo.getMergedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getMergedBy().getBean(map);
		this.mergeddate = vo.getMergedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMergedDate().getBean();
		this.mergedfrom = vo.getMergedFrom() == null ? null : new ims.vo.RefVoBean(vo.getMergedFrom().getBoId(), vo.getMergedFrom().getBoVersion());
		this.scannedby = vo.getScannedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getScannedBy().getBean(map);
		this.scanneddate = vo.getScannedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getScannedDate().getBean();
		this.scannedcomment = vo.getScannedComment();
		this.lasttransferdate = vo.getLastTransferDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastTransferDate().getBean();
	}

	public ims.core.vo.PatientCaseNoteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientCaseNoteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientCaseNoteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientCaseNoteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientCaseNoteVo();
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
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getCurrentLocation()
	{
		return this.currentlocation;
	}
	public void setCurrentLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.currentlocation = value;
	}
	public ims.vo.LookupInstanceBean getFolder()
	{
		return this.folder;
	}
	public void setFolder(ims.vo.LookupInstanceBean value)
	{
		this.folder = value;
	}
	public String getTrackingID()
	{
		return this.trackingid;
	}
	public void setTrackingID(String value)
	{
		this.trackingid = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.vo.RefVoBean[] getOpenRequests()
	{
		return this.openrequests;
	}
	public void setOpenRequests(ims.vo.RefVoBean[] value)
	{
		this.openrequests = value;
	}
	public ims.vo.RefVoBean getCreatedBy()
	{
		return this.createdby;
	}
	public void setCreatedBy(ims.vo.RefVoBean value)
	{
		this.createdby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.creationdate = value;
	}
	public ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean getCurrentComment()
	{
		return this.currentcomment;
	}
	public void setCurrentComment(ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean value)
	{
		this.currentcomment = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getArchivedBy()
	{
		return this.archivedby;
	}
	public void setArchivedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.archivedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getArchivedDate()
	{
		return this.archiveddate;
	}
	public void setArchivedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.archiveddate = value;
	}
	public String getArchivedComment()
	{
		return this.archivedcomment;
	}
	public void setArchivedComment(String value)
	{
		this.archivedcomment = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getDestroyedBy()
	{
		return this.destroyedby;
	}
	public void setDestroyedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.destroyedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDestroyedDate()
	{
		return this.destroyeddate;
	}
	public void setDestroyedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.destroyeddate = value;
	}
	public String getDestroyedComment()
	{
		return this.destroyedcomment;
	}
	public void setDestroyedComment(String value)
	{
		this.destroyedcomment = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getMergedBy()
	{
		return this.mergedby;
	}
	public void setMergedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.mergedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getMergedDate()
	{
		return this.mergeddate;
	}
	public void setMergedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.mergeddate = value;
	}
	public ims.vo.RefVoBean getMergedFrom()
	{
		return this.mergedfrom;
	}
	public void setMergedFrom(ims.vo.RefVoBean value)
	{
		this.mergedfrom = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getScannedBy()
	{
		return this.scannedby;
	}
	public void setScannedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.scannedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getScannedDate()
	{
		return this.scanneddate;
	}
	public void setScannedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.scanneddate = value;
	}
	public String getScannedComment()
	{
		return this.scannedcomment;
	}
	public void setScannedComment(String value)
	{
		this.scannedcomment = value;
	}
	public ims.framework.utils.beans.DateTimeBean getLastTransferDate()
	{
		return this.lasttransferdate;
	}
	public void setLastTransferDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.lasttransferdate = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean type;
	private ims.core.vo.beans.LocationLiteVoBean currentlocation;
	private ims.vo.LookupInstanceBean folder;
	private String trackingid;
	private ims.vo.RefVoBean patient;
	private ims.vo.LookupInstanceBean status;
	private ims.vo.RefVoBean[] openrequests;
	private ims.vo.RefVoBean createdby;
	private ims.framework.utils.beans.DateTimeBean creationdate;
	private ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean currentcomment;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean archivedby;
	private ims.framework.utils.beans.DateTimeBean archiveddate;
	private String archivedcomment;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean destroyedby;
	private ims.framework.utils.beans.DateTimeBean destroyeddate;
	private String destroyedcomment;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean mergedby;
	private ims.framework.utils.beans.DateTimeBean mergeddate;
	private ims.vo.RefVoBean mergedfrom;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean scannedby;
	private ims.framework.utils.beans.DateTimeBean scanneddate;
	private String scannedcomment;
	private ims.framework.utils.beans.DateTimeBean lasttransferdate;
}
