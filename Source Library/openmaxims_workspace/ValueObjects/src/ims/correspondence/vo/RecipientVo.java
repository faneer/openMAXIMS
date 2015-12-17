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

package ims.correspondence.vo;

/**
 * Linked to correspondence.Recipient business object (ID: 1052100003).
 */
public class RecipientVo extends ims.correspondence.vo.RecipientRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IRecipient
{
	private static final long serialVersionUID = 1L;

	public RecipientVo()
	{
	}
	public RecipientVo(Integer id, int version)
	{
		super(id, version);
	}
	public RecipientVo(ims.correspondence.vo.beans.RecipientVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recipienttype = bean.getRecipientType() == null ? null : ims.correspondence.vo.lookups.RecipientType.buildLookup(bean.getRecipientType());
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.RecipientVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recipienttype = bean.getRecipientType() == null ? null : ims.correspondence.vo.lookups.RecipientType.buildLookup(bean.getRecipientType());
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.RecipientVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.RecipientVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.RecipientVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("RECIPIENTTYPE"))
			return getRecipientType();
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		if(fieldName.equals("COMMCHANNELS"))
			return getCommChannels();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRecipientTypeIsNotNull()
	{
		return this.recipienttype != null;
	}
	public ims.correspondence.vo.lookups.RecipientType getRecipientType()
	{
		return this.recipienttype;
	}
	public void setRecipientType(ims.correspondence.vo.lookups.RecipientType value)
	{
		this.isValidated = false;
		this.recipienttype = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public ims.core.vo.PersonAddress getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.PersonAddress value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getCommChannelsIsNotNull()
	{
		return this.commchannels != null;
	}
	public ims.core.vo.CommChannelVoCollection getCommChannels()
	{
		return this.commchannels;
	}
	public void setCommChannels(ims.core.vo.CommChannelVoCollection value)
	{
		this.isValidated = false;
		this.commchannels = value;
	}
	/**
	* IRecipient Interface Implementation
	*/
	public String getEmailAddress()
	{
	ims.core.vo.CommChannelVo chan = null;
		
	
		if(this.getCommChannels()!= null)
		{
	
		chan = getCommChannel(this.getCommChannels(),ims.core.vo.lookups.ChannelType.EMAIL);
		return chan.getCommValue();
			
		}
	
		return null;
	}
	
	private ims.core.vo.CommChannelVo getCommChannel(ims.core.vo.CommChannelVoCollection commchannels, ims.core.vo.lookups.ChannelType email)
	{
		if (commchannels == null) return null;
		for (int i = 0; i < commchannels.size(); i++)
		{
			ims.core.vo.CommChannelVo chan = commchannels.get(i);
			if (chan.getChannelType().equals(email))
			{
				return chan;
			}
		}
		return null;
	}
	
	public String getRecipientName()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.name != null)
		{
			if(!this.name.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.address != null)
		{
			if(!this.address.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.commchannels != null)
		{
			if(!this.commchannels.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.recipienttype == null)
			listOfErrors.add("RecipientType is mandatory");
		if(this.name == null)
			listOfErrors.add("name is mandatory");
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.address == null)
			listOfErrors.add("address is mandatory");
		if(this.address != null)
		{
			String[] listOfOtherErrors = this.address.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.commchannels != null)
		{
			String[] listOfOtherErrors = this.commchannels.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		RecipientVo clone = new RecipientVo(this.id, this.version);
		
		if(this.recipienttype == null)
			clone.recipienttype = null;
		else
			clone.recipienttype = (ims.correspondence.vo.lookups.RecipientType)this.recipienttype.clone();
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.PersonAddress)this.address.clone();
		if(this.commchannels == null)
			clone.commchannels = null;
		else
			clone.commchannels = (ims.core.vo.CommChannelVoCollection)this.commchannels.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(RecipientVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RecipientVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RecipientVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RecipientVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.recipienttype != null)
			count++;
		if(this.name != null)
			count++;
		if(this.address != null)
			count++;
		if(this.commchannels != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.correspondence.vo.lookups.RecipientType recipienttype;
	protected ims.core.vo.PersonName name;
	protected ims.core.vo.PersonAddress address;
	protected ims.core.vo.CommChannelVoCollection commchannels;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
