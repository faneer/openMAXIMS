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

package ims.clinical.vo.beans;

public class FinalCountsIntraOpVoBean extends ims.vo.ValueObjectBean
{
	public FinalCountsIntraOpVoBean()
	{
	}
	public FinalCountsIntraOpVoBean(ims.clinical.vo.FinalCountsIntraOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : new ims.vo.RefVoBean(vo.getTheatreAppointment().getBoId(), vo.getTheatreAppointment().getBoVersion());
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureMinVoBean)vo.getProcedure().getBean();
		this.swabsaccountableitemscorrect = vo.getSwabsAccountableItemscorrect() == null ? null : (ims.vo.LookupInstanceBean)vo.getSwabsAccountableItemscorrect().getBean();
		this.instrumentscorrect = vo.getInstrumentsCorrect() == null ? null : (ims.vo.LookupInstanceBean)vo.getInstrumentsCorrect().getBean();
		this.sharpsothercorrectandremovedfromset = vo.getSharpsOtherCorrectAndRemovedFromSet() == null ? null : (ims.vo.LookupInstanceBean)vo.getSharpsOtherCorrectAndRemovedFromSet().getBean();
		this.verifiedby1 = vo.getVerifiedBy1() == null ? null : (ims.core.vo.beans.NurseLiteVoBean)vo.getVerifiedBy1().getBean();
		this.missingitems = vo.getMissingItems() == null ? null : vo.getMissingItems().getBeanCollection();
		this.othermissingitems = vo.getOtherMissingItems();
		this.actionstaken = vo.getActionsTaken() == null ? null : vo.getActionsTaken().getBeanCollection();
		this.verifiedby2 = vo.getVerifiedBy2() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getVerifiedBy2().getBean();
		this.verifiedby = vo.getVerifiedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getVerifiedBy().getBean();
		this.otheractionstaken = vo.getOtherActionsTaken();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.FinalCountsIntraOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : new ims.vo.RefVoBean(vo.getTheatreAppointment().getBoId(), vo.getTheatreAppointment().getBoVersion());
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureMinVoBean)vo.getProcedure().getBean(map);
		this.swabsaccountableitemscorrect = vo.getSwabsAccountableItemscorrect() == null ? null : (ims.vo.LookupInstanceBean)vo.getSwabsAccountableItemscorrect().getBean();
		this.instrumentscorrect = vo.getInstrumentsCorrect() == null ? null : (ims.vo.LookupInstanceBean)vo.getInstrumentsCorrect().getBean();
		this.sharpsothercorrectandremovedfromset = vo.getSharpsOtherCorrectAndRemovedFromSet() == null ? null : (ims.vo.LookupInstanceBean)vo.getSharpsOtherCorrectAndRemovedFromSet().getBean();
		this.verifiedby1 = vo.getVerifiedBy1() == null ? null : (ims.core.vo.beans.NurseLiteVoBean)vo.getVerifiedBy1().getBean(map);
		this.missingitems = vo.getMissingItems() == null ? null : vo.getMissingItems().getBeanCollection();
		this.othermissingitems = vo.getOtherMissingItems();
		this.actionstaken = vo.getActionsTaken() == null ? null : vo.getActionsTaken().getBeanCollection();
		this.verifiedby2 = vo.getVerifiedBy2() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getVerifiedBy2().getBean(map);
		this.verifiedby = vo.getVerifiedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getVerifiedBy().getBean(map);
		this.otheractionstaken = vo.getOtherActionsTaken();
	}

	public ims.clinical.vo.FinalCountsIntraOpVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.FinalCountsIntraOpVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.FinalCountsIntraOpVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.FinalCountsIntraOpVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.FinalCountsIntraOpVo();
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
	public ims.vo.RefVoBean getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.vo.RefVoBean value)
	{
		this.theatreappointment = value;
	}
	public ims.core.vo.beans.PatientProcedureMinVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.PatientProcedureMinVoBean value)
	{
		this.procedure = value;
	}
	public ims.vo.LookupInstanceBean getSwabsAccountableItemscorrect()
	{
		return this.swabsaccountableitemscorrect;
	}
	public void setSwabsAccountableItemscorrect(ims.vo.LookupInstanceBean value)
	{
		this.swabsaccountableitemscorrect = value;
	}
	public ims.vo.LookupInstanceBean getInstrumentsCorrect()
	{
		return this.instrumentscorrect;
	}
	public void setInstrumentsCorrect(ims.vo.LookupInstanceBean value)
	{
		this.instrumentscorrect = value;
	}
	public ims.vo.LookupInstanceBean getSharpsOtherCorrectAndRemovedFromSet()
	{
		return this.sharpsothercorrectandremovedfromset;
	}
	public void setSharpsOtherCorrectAndRemovedFromSet(ims.vo.LookupInstanceBean value)
	{
		this.sharpsothercorrectandremovedfromset = value;
	}
	public ims.core.vo.beans.NurseLiteVoBean getVerifiedBy1()
	{
		return this.verifiedby1;
	}
	public void setVerifiedBy1(ims.core.vo.beans.NurseLiteVoBean value)
	{
		this.verifiedby1 = value;
	}
	public java.util.Collection getMissingItems()
	{
		return this.missingitems;
	}
	public void setMissingItems(java.util.Collection value)
	{
		this.missingitems = value;
	}
	public void addMissingItems(java.util.Collection value)
	{
		if(this.missingitems == null)
			this.missingitems = new java.util.ArrayList();
		this.missingitems.add(value);
	}
	public String getOtherMissingItems()
	{
		return this.othermissingitems;
	}
	public void setOtherMissingItems(String value)
	{
		this.othermissingitems = value;
	}
	public java.util.Collection getActionsTaken()
	{
		return this.actionstaken;
	}
	public void setActionsTaken(java.util.Collection value)
	{
		this.actionstaken = value;
	}
	public void addActionsTaken(java.util.Collection value)
	{
		if(this.actionstaken == null)
			this.actionstaken = new java.util.ArrayList();
		this.actionstaken.add(value);
	}
	public ims.core.vo.beans.HcpLiteVoBean getVerifiedBy2()
	{
		return this.verifiedby2;
	}
	public void setVerifiedBy2(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.verifiedby2 = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getVerifiedBy()
	{
		return this.verifiedby;
	}
	public void setVerifiedBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.verifiedby = value;
	}
	public String getOtherActionsTaken()
	{
		return this.otheractionstaken;
	}
	public void setOtherActionsTaken(String value)
	{
		this.otheractionstaken = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean theatreappointment;
	private ims.core.vo.beans.PatientProcedureMinVoBean procedure;
	private ims.vo.LookupInstanceBean swabsaccountableitemscorrect;
	private ims.vo.LookupInstanceBean instrumentscorrect;
	private ims.vo.LookupInstanceBean sharpsothercorrectandremovedfromset;
	private ims.core.vo.beans.NurseLiteVoBean verifiedby1;
	private java.util.Collection missingitems;
	private String othermissingitems;
	private java.util.Collection actionstaken;
	private ims.core.vo.beans.HcpLiteVoBean verifiedby2;
	private ims.core.vo.beans.HcpLiteVoBean verifiedby;
	private String otheractionstaken;
}
