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

public class OrderInvestigationVoBean extends ims.vo.ValueObjectBean
{
	public OrderInvestigationVoBean()
	{
	}
	public OrderInvestigationVoBean(ims.ocrr.vo.OrderInvestigationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean)vo.getInvestigation().getBean();
		this.orderpriority = vo.getOrderPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderPriority().getBean();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.wasordered = vo.getWasOrdered();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean();
		if(vo.getSpecimen() != null)
		{
			this.specimen = new ims.vo.RefVoBean[vo.getSpecimen().size()];
			for(int specimen_i = 0; specimen_i < vo.getSpecimen().size(); specimen_i++)
			{
				this.specimen[specimen_i] = new ims.vo.RefVoBean(vo.getSpecimen().get(specimen_i).getBoId(),vo.getSpecimen().get(specimen_i).getBoVersion());
			}
		}
		this.orderdetails = vo.getOrderDetails() == null ? null : new ims.vo.RefVoBean(vo.getOrderDetails().getBoId(), vo.getOrderDetails().getBoVersion());
		this.ordinvseq = vo.getOrdInvSeq();
		this.requestedlocation = vo.getRequestedLocation() == null ? null : new ims.vo.RefVoBean(vo.getRequestedLocation().getBoId(), vo.getRequestedLocation().getBoVersion());
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.accessionnumber = vo.getAccessionNumber();
		this.hascontainerchoice = vo.getHasContainerChoice();
		this.chosencontainer = vo.getChosenContainer() == null ? null : (ims.ocrr.vo.beans.SpecimenContainerVoBean)vo.getChosenContainer().getBean();
		this.container = vo.getContainer() == null ? null : vo.getContainer().getBeanCollection();
		this.reorderreason = vo.getReorderReason();
		this.requiredbydate = vo.getRequiredByDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequiredByDate().getBean();
		this.ordinvstatushistory = vo.getOrdInvStatusHistory() == null ? null : vo.getOrdInvStatusHistory().getBeanCollection();
		this.collectiontype = vo.getCollectionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCollectionType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderInvestigationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean)vo.getInvestigation().getBean(map);
		this.orderpriority = vo.getOrderPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderPriority().getBean();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.wasordered = vo.getWasOrdered();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean(map);
		if(vo.getSpecimen() != null)
		{
			this.specimen = new ims.vo.RefVoBean[vo.getSpecimen().size()];
			for(int specimen_i = 0; specimen_i < vo.getSpecimen().size(); specimen_i++)
			{
				this.specimen[specimen_i] = new ims.vo.RefVoBean(vo.getSpecimen().get(specimen_i).getBoId(),vo.getSpecimen().get(specimen_i).getBoVersion());
			}
		}
		this.orderdetails = vo.getOrderDetails() == null ? null : new ims.vo.RefVoBean(vo.getOrderDetails().getBoId(), vo.getOrderDetails().getBoVersion());
		this.ordinvseq = vo.getOrdInvSeq();
		this.requestedlocation = vo.getRequestedLocation() == null ? null : new ims.vo.RefVoBean(vo.getRequestedLocation().getBoId(), vo.getRequestedLocation().getBoVersion());
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.accessionnumber = vo.getAccessionNumber();
		this.hascontainerchoice = vo.getHasContainerChoice();
		this.chosencontainer = vo.getChosenContainer() == null ? null : (ims.ocrr.vo.beans.SpecimenContainerVoBean)vo.getChosenContainer().getBean(map);
		this.container = vo.getContainer() == null ? null : vo.getContainer().getBeanCollection();
		this.reorderreason = vo.getReorderReason();
		this.requiredbydate = vo.getRequiredByDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequiredByDate().getBean();
		this.ordinvstatushistory = vo.getOrdInvStatusHistory() == null ? null : vo.getOrdInvStatusHistory().getBeanCollection();
		this.collectiontype = vo.getCollectionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCollectionType().getBean();
	}

	public ims.ocrr.vo.OrderInvestigationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderInvestigationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderInvestigationVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderInvestigationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderInvestigationVo();
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
	public ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean value)
	{
		this.investigation = value;
	}
	public ims.vo.LookupInstanceBean getOrderPriority()
	{
		return this.orderpriority;
	}
	public void setOrderPriority(ims.vo.LookupInstanceBean value)
	{
		this.orderpriority = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.displaydatetime = value;
	}
	public ims.vo.LookupInstanceBean getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.vo.LookupInstanceBean value)
	{
		this.displayflag = value;
	}
	public Boolean getWasOrdered()
	{
		return this.wasordered;
	}
	public void setWasOrdered(Boolean value)
	{
		this.wasordered = value;
	}
	public ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean value)
	{
		this.ordinvcurrentstatus = value;
	}
	public ims.vo.RefVoBean[] getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.vo.RefVoBean[] value)
	{
		this.specimen = value;
	}
	public ims.vo.RefVoBean getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.vo.RefVoBean value)
	{
		this.orderdetails = value;
	}
	public Integer getOrdInvSeq()
	{
		return this.ordinvseq;
	}
	public void setOrdInvSeq(Integer value)
	{
		this.ordinvseq = value;
	}
	public ims.vo.RefVoBean getRequestedLocation()
	{
		return this.requestedlocation;
	}
	public void setRequestedLocation(ims.vo.RefVoBean value)
	{
		this.requestedlocation = value;
	}
	public ims.vo.LookupInstanceBean getSiteCd()
	{
		return this.sitecd;
	}
	public void setSiteCd(ims.vo.LookupInstanceBean value)
	{
		this.sitecd = value;
	}
	public String getAccessionNumber()
	{
		return this.accessionnumber;
	}
	public void setAccessionNumber(String value)
	{
		this.accessionnumber = value;
	}
	public Boolean getHasContainerChoice()
	{
		return this.hascontainerchoice;
	}
	public void setHasContainerChoice(Boolean value)
	{
		this.hascontainerchoice = value;
	}
	public ims.ocrr.vo.beans.SpecimenContainerVoBean getChosenContainer()
	{
		return this.chosencontainer;
	}
	public void setChosenContainer(ims.ocrr.vo.beans.SpecimenContainerVoBean value)
	{
		this.chosencontainer = value;
	}
	public ims.ocrr.vo.beans.OrderSpecimenContainerVoBean[] getContainer()
	{
		return this.container;
	}
	public void setContainer(ims.ocrr.vo.beans.OrderSpecimenContainerVoBean[] value)
	{
		this.container = value;
	}
	public String getReorderReason()
	{
		return this.reorderreason;
	}
	public void setReorderReason(String value)
	{
		this.reorderreason = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRequiredByDate()
	{
		return this.requiredbydate;
	}
	public void setRequiredByDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.requiredbydate = value;
	}
	public ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean[] getOrdInvStatusHistory()
	{
		return this.ordinvstatushistory;
	}
	public void setOrdInvStatusHistory(ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean[] value)
	{
		this.ordinvstatushistory = value;
	}
	public ims.vo.LookupInstanceBean getCollectionType()
	{
		return this.collectiontype;
	}
	public void setCollectionType(ims.vo.LookupInstanceBean value)
	{
		this.collectiontype = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean investigation;
	private ims.vo.LookupInstanceBean orderpriority;
	private ims.framework.utils.beans.DateTimeBean displaydatetime;
	private ims.vo.LookupInstanceBean displayflag;
	private Boolean wasordered;
	private ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean ordinvcurrentstatus;
	private ims.vo.RefVoBean[] specimen;
	private ims.vo.RefVoBean orderdetails;
	private Integer ordinvseq;
	private ims.vo.RefVoBean requestedlocation;
	private ims.vo.LookupInstanceBean sitecd;
	private String accessionnumber;
	private Boolean hascontainerchoice;
	private ims.ocrr.vo.beans.SpecimenContainerVoBean chosencontainer;
	private ims.ocrr.vo.beans.OrderSpecimenContainerVoBean[] container;
	private String reorderreason;
	private ims.framework.utils.beans.DateTimeBean requiredbydate;
	private ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean[] ordinvstatushistory;
	private ims.vo.LookupInstanceBean collectiontype;
}
