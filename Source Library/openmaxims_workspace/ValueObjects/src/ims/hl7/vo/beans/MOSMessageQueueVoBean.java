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

package ims.hl7.vo.beans;

public class MOSMessageQueueVoBean extends ims.vo.ValueObjectBean
{
	public MOSMessageQueueVoBean()
	{
	}
	public MOSMessageQueueVoBean(ims.hl7.vo.MOSMessageQueueVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean();
		this.wasprocessed = vo.getWasProcessed();
		this.wasdiscarded = vo.getWasDiscarded();
		this.msgtext = vo.getMsgText();
		this.acktext = vo.getAckText();
		this.failuremsg = vo.getFailureMsg();
		this.messagestatus = vo.getMessageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageStatus().getBean();
		this.msgtype = vo.getMsgType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMsgType().getBean();
		this.queuetype = vo.getQueueType() == null ? null : (ims.vo.LookupInstanceBean)vo.getQueueType().getBean();
		this.mos = vo.getMOS() == null ? null : new ims.vo.RefVoBean(vo.getMOS().getBoId(), vo.getMOS().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.hl7.vo.MOSMessageQueueVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean(map);
		this.wasprocessed = vo.getWasProcessed();
		this.wasdiscarded = vo.getWasDiscarded();
		this.msgtext = vo.getMsgText();
		this.acktext = vo.getAckText();
		this.failuremsg = vo.getFailureMsg();
		this.messagestatus = vo.getMessageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageStatus().getBean();
		this.msgtype = vo.getMsgType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMsgType().getBean();
		this.queuetype = vo.getQueueType() == null ? null : (ims.vo.LookupInstanceBean)vo.getQueueType().getBean();
		this.mos = vo.getMOS() == null ? null : new ims.vo.RefVoBean(vo.getMOS().getBoId(), vo.getMOS().getBoVersion());
	}

	public ims.hl7.vo.MOSMessageQueueVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.hl7.vo.MOSMessageQueueVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.hl7.vo.MOSMessageQueueVo vo = null;
		if(map != null)
			vo = (ims.hl7.vo.MOSMessageQueueVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.hl7.vo.MOSMessageQueueVo();
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
	public ims.ocrr.vo.beans.ProviderSystemVoBean getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.ocrr.vo.beans.ProviderSystemVoBean value)
	{
		this.providersystem = value;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.wasprocessed = value;
	}
	public Boolean getWasDiscarded()
	{
		return this.wasdiscarded;
	}
	public void setWasDiscarded(Boolean value)
	{
		this.wasdiscarded = value;
	}
	public String getMsgText()
	{
		return this.msgtext;
	}
	public void setMsgText(String value)
	{
		this.msgtext = value;
	}
	public String getAckText()
	{
		return this.acktext;
	}
	public void setAckText(String value)
	{
		this.acktext = value;
	}
	public String getFailureMsg()
	{
		return this.failuremsg;
	}
	public void setFailureMsg(String value)
	{
		this.failuremsg = value;
	}
	public ims.vo.LookupInstanceBean getMessageStatus()
	{
		return this.messagestatus;
	}
	public void setMessageStatus(ims.vo.LookupInstanceBean value)
	{
		this.messagestatus = value;
	}
	public ims.vo.LookupInstanceBean getMsgType()
	{
		return this.msgtype;
	}
	public void setMsgType(ims.vo.LookupInstanceBean value)
	{
		this.msgtype = value;
	}
	public ims.vo.LookupInstanceBean getQueueType()
	{
		return this.queuetype;
	}
	public void setQueueType(ims.vo.LookupInstanceBean value)
	{
		this.queuetype = value;
	}
	public ims.vo.RefVoBean getMOS()
	{
		return this.mos;
	}
	public void setMOS(ims.vo.RefVoBean value)
	{
		this.mos = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.ProviderSystemVoBean providersystem;
	private Boolean wasprocessed;
	private Boolean wasdiscarded;
	private String msgtext;
	private String acktext;
	private String failuremsg;
	private ims.vo.LookupInstanceBean messagestatus;
	private ims.vo.LookupInstanceBean msgtype;
	private ims.vo.LookupInstanceBean queuetype;
	private ims.vo.RefVoBean mos;
}
