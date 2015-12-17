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

package ims.ocrr.vo.beans;

public class NewResultsListVoBean extends ims.vo.ValueObjectBean
{
	public NewResultsListVoBean()
	{
	}
	public NewResultsListVoBean(ims.ocrr.vo.NewResultsListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.NewResultsListOrderDetailsVoBean)vo.getOrderDetails().getBean();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.NewResultsListInvestigationVoBean)vo.getInvestigation().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.NewResultsListOrderInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean();
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.ordinvxostatushistory = vo.getOrdInvXOStatusHistory() == null ? null : vo.getOrdInvXOStatusHistory().getBeanCollection();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForNewResultsListVoBean)vo.getResultDetails().getBean();
		this.allocatedhcpforreview = vo.getAllocatedHCPforReview() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAllocatedHCPforReview().getBean();
		this.allocateddateforreview = vo.getAllocatedDateForReview() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateForReview().getBean();
		this.ordinvseq = vo.getOrdInvSeq();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.NewResultsListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.NewResultsListOrderDetailsVoBean)vo.getOrderDetails().getBean(map);
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.NewResultsListInvestigationVoBean)vo.getInvestigation().getBean(map);
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.NewResultsListOrderInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean(map);
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.ordinvxostatushistory = vo.getOrdInvXOStatusHistory() == null ? null : vo.getOrdInvXOStatusHistory().getBeanCollection();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForNewResultsListVoBean)vo.getResultDetails().getBean(map);
		this.allocatedhcpforreview = vo.getAllocatedHCPforReview() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAllocatedHCPforReview().getBean(map);
		this.allocateddateforreview = vo.getAllocatedDateForReview() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateForReview().getBean();
		this.ordinvseq = vo.getOrdInvSeq();
	}

	public ims.ocrr.vo.NewResultsListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.NewResultsListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.NewResultsListVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.NewResultsListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.NewResultsListVo();
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
	public ims.framework.utils.beans.DateTimeBean getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.displaydatetime = value;
	}
	public ims.ocrr.vo.beans.NewResultsListOrderDetailsVoBean getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.beans.NewResultsListOrderDetailsVoBean value)
	{
		this.orderdetails = value;
	}
	public ims.ocrr.vo.beans.NewResultsListInvestigationVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.NewResultsListInvestigationVoBean value)
	{
		this.investigation = value;
	}
	public ims.ocrr.vo.beans.NewResultsListOrderInvestigationStatusVoBean getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.beans.NewResultsListOrderInvestigationStatusVoBean value)
	{
		this.ordinvcurrentstatus = value;
	}
	public ims.ocrr.vo.beans.OrderSpecimenCommentsVoBean[] getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.beans.OrderSpecimenCommentsVoBean[] value)
	{
		this.specimen = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.repdatetime = value;
	}
	public ims.vo.LookupInstanceBean getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.vo.LookupInstanceBean value)
	{
		this.resultstatus = value;
	}
	public ims.ocrr.vo.beans.OrdInvXOStatusHistoryLiteVoBean[] getOrdInvXOStatusHistory()
	{
		return this.ordinvxostatushistory;
	}
	public void setOrdInvXOStatusHistory(ims.ocrr.vo.beans.OrdInvXOStatusHistoryLiteVoBean[] value)
	{
		this.ordinvxostatushistory = value;
	}
	public ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] getResultConclusionComments()
	{
		return this.resultconclusioncomments;
	}
	public void setResultConclusionComments(ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] value)
	{
		this.resultconclusioncomments = value;
	}
	public ims.ocrr.vo.beans.ResultDetailsForNewResultsListVoBean getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.beans.ResultDetailsForNewResultsListVoBean value)
	{
		this.resultdetails = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAllocatedHCPforReview()
	{
		return this.allocatedhcpforreview;
	}
	public void setAllocatedHCPforReview(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.allocatedhcpforreview = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAllocatedDateForReview()
	{
		return this.allocateddateforreview;
	}
	public void setAllocatedDateForReview(ims.framework.utils.beans.DateTimeBean value)
	{
		this.allocateddateforreview = value;
	}
	public Integer getOrdInvSeq()
	{
		return this.ordinvseq;
	}
	public void setOrdInvSeq(Integer value)
	{
		this.ordinvseq = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean displaydatetime;
	private ims.ocrr.vo.beans.NewResultsListOrderDetailsVoBean orderdetails;
	private ims.ocrr.vo.beans.NewResultsListInvestigationVoBean investigation;
	private ims.ocrr.vo.beans.NewResultsListOrderInvestigationStatusVoBean ordinvcurrentstatus;
	private ims.ocrr.vo.beans.OrderSpecimenCommentsVoBean[] specimen;
	private ims.framework.utils.beans.DateTimeBean repdatetime;
	private ims.vo.LookupInstanceBean resultstatus;
	private ims.ocrr.vo.beans.OrdInvXOStatusHistoryLiteVoBean[] ordinvxostatushistory;
	private ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] resultconclusioncomments;
	private ims.ocrr.vo.beans.ResultDetailsForNewResultsListVoBean resultdetails;
	private ims.core.vo.beans.HcpLiteVoBean allocatedhcpforreview;
	private ims.framework.utils.beans.DateTimeBean allocateddateforreview;
	private Integer ordinvseq;
}
