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

package ims.core.vo;

/**
 * Linked to core.resource.people.MemberOfStaff business object (ID: 1006100006).
 */
public class MemberOfStaffShortVo extends ims.core.vo.MemberOfStaffMappingsLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MemberOfStaffShortVo()
	{
	}
	public MemberOfStaffShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public MemberOfStaffShortVo(ims.core.vo.beans.MemberOfStaffShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.initials = bean.getInitials();
		this.signatureblock = bean.getSignatureBlock();
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo();
		this.appuser = bean.getAppUser() == null ? null : bean.getAppUser().buildVo();
		this.stafftype = bean.getStaffType() == null ? null : ims.core.vo.lookups.StaffType.buildLookup(bean.getStaffType());
		this.isactive = bean.getIsActive();
		this.isappuser = bean.getIsAppUser();
		this.primarylocation = bean.getPrimaryLocation() == null ? null : bean.getPrimaryLocation().buildVo();
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.sdsroleid = bean.getSdsRoleId();
		this.canreferpatient = bean.getCanReferPatient();
		this.mappingvalue = bean.getMappingValue();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.MemberOfStaffShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.initials = bean.getInitials();
		this.signatureblock = bean.getSignatureBlock();
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.hcp = bean.getHcp() == null ? null : bean.getHcp().buildVo(map);
		this.appuser = bean.getAppUser() == null ? null : bean.getAppUser().buildVo(map);
		this.stafftype = bean.getStaffType() == null ? null : ims.core.vo.lookups.StaffType.buildLookup(bean.getStaffType());
		this.isactive = bean.getIsActive();
		this.isappuser = bean.getIsAppUser();
		this.primarylocation = bean.getPrimaryLocation() == null ? null : bean.getPrimaryLocation().buildVo(map);
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.sdsroleid = bean.getSdsRoleId();
		this.canreferpatient = bean.getCanReferPatient();
		this.mappingvalue = bean.getMappingValue();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.MemberOfStaffShortVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.MemberOfStaffShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.MemberOfStaffShortVoBean();
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
		if(fieldName.equals("HCP"))
			return getHcp();
		if(fieldName.equals("APPUSER"))
			return getAppUser();
		if(fieldName.equals("STAFFTYPE"))
			return getStaffType();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ISAPPUSER"))
			return getIsAppUser();
		if(fieldName.equals("PRIMARYLOCATION"))
			return getPrimaryLocation();
		if(fieldName.equals("COMMCHANNELS"))
			return getCommChannels();
		if(fieldName.equals("SDSROLEID"))
			return getSdsRoleId();
		if(fieldName.equals("CANREFERPATIENT"))
			return getCanReferPatient();
		if(fieldName.equals("MAPPINGVALUE"))
			return getMappingValue();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHcpIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.Hcp getHcp()
	{
		return this.hcp;
	}
	public void setHcp(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.hcp = value;
	}
	public boolean getAppUserIsNotNull()
	{
		return this.appuser != null;
	}
	public ims.admin.vo.AppUserShortVo getAppUser()
	{
		return this.appuser;
	}
	public void setAppUser(ims.admin.vo.AppUserShortVo value)
	{
		this.isValidated = false;
		this.appuser = value;
	}
	public boolean getStaffTypeIsNotNull()
	{
		return this.stafftype != null;
	}
	public ims.core.vo.lookups.StaffType getStaffType()
	{
		return this.stafftype;
	}
	public void setStaffType(ims.core.vo.lookups.StaffType value)
	{
		this.isValidated = false;
		this.stafftype = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getIsAppUserIsNotNull()
	{
		return this.isappuser != null;
	}
	public Boolean getIsAppUser()
	{
		return this.isappuser;
	}
	public void setIsAppUser(Boolean value)
	{
		this.isValidated = false;
		this.isappuser = value;
	}
	public boolean getPrimaryLocationIsNotNull()
	{
		return this.primarylocation != null;
	}
	public ims.core.vo.LocShortVo getPrimaryLocation()
	{
		return this.primarylocation;
	}
	public void setPrimaryLocation(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.primarylocation = value;
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
	public boolean getSdsRoleIdIsNotNull()
	{
		return this.sdsroleid != null;
	}
	public String getSdsRoleId()
	{
		return this.sdsroleid;
	}
	public static int getSdsRoleIdMaxLength()
	{
		return 50;
	}
	public void setSdsRoleId(String value)
	{
		this.isValidated = false;
		this.sdsroleid = value;
	}
	public boolean getCanReferPatientIsNotNull()
	{
		return this.canreferpatient != null;
	}
	public Boolean getCanReferPatient()
	{
		return this.canreferpatient;
	}
	public void setCanReferPatient(Boolean value)
	{
		this.isValidated = false;
		this.canreferpatient = value;
	}
	public boolean getMappingValueIsNotNull()
	{
		return this.mappingvalue != null;
	}
	public String getMappingValue()
	{
		return this.mappingvalue;
	}
	public static int getMappingValueMaxLength()
	{
		return 255;
	}
	public void setMappingValue(String value)
	{
		this.isValidated = false;
		this.mappingvalue = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.name != null)
			sb.append(this.name);
		return sb.toString();
	}
	/**
	* removeCommChannel
	*/
	public void removeCommChannel(ims.core.vo.lookups.ChannelType commType)
	{
		if (commchannels == null) 
			return;
		
		for (int i =0; i < commchannels.size(); i++)
		{	
			ims.core.vo.CommChannelVo chan = commchannels.get(i);
			if (chan.getChannelType().equals(commType))
			{
				commchannels.remove(i);
				return;
			}
		}
	}
	/**
	* getCommChannel
	*/
	public ims.core.vo.CommChannelVo getCommChannel(ims.core.vo.lookups.ChannelType commType)
	{
		if (commchannels == null) return null;
		for (int i = 0; i < commchannels.size(); i++)
		{
			ims.core.vo.CommChannelVo chan = commchannels.get(i);
			if (chan.getChannelType().equals(commType))
			{
				return chan;
			}
		}
		return null;		
	}
	/**
	* setCommChannel
	*/
	public void setCommChannel(ims.core.vo.lookups.ChannelType commType, String val)
	{
		if (val == null)
		{
			removeCommChannel(commType);
			return;
		}
		ims.core.vo.CommChannelVo chan =  getCommChannel(commType);
		if (chan != null)
		{
			chan.setCommValue(val);
		}
		else
		{
			if (commchannels == null) commchannels = new ims.core.vo.CommChannelVoCollection();
			chan = new ims.core.vo.CommChannelVo();
			chan.setChannelType(commType);
			chan.setCommValue(val);
			commchannels.add(chan);
		}
	}
	/**
	* getBleep
	*/
	public String getBleep()
	{
		ims.core.vo.CommChannelVo chan = getCommChannel(ims.core.vo.lookups.ChannelType.BLEEP);
		if (chan == null) return null;
		else return chan.getCommValue();
	}
	/**
	* setBleep
	*/
	public void setBleep(String bleep)
	{
		setCommChannel(ims.core.vo.lookups.ChannelType.BLEEP, bleep);
	}
	/**
	* getMobile
	*/
	public String getMobile()
	{
		ims.core.vo.CommChannelVo chan = getCommChannel(ims.core.vo.lookups.ChannelType.MOBILE);
		if (chan == null) return null;
		else return chan.getCommValue();
	}
	/**
	* setMobile
	*/
	public void setMobile(String mobile)
	{
		setCommChannel(ims.core.vo.lookups.ChannelType.MOBILE, mobile);
	}
	/**
	* getEmailAddress
	*/
	public String getEmailAddress()
	{
		ims.core.vo.CommChannelVo chan = getCommChannel(ims.core.vo.lookups.ChannelType.EMAIL);
		if (chan == null) return null;
		else return chan.getCommValue();
	}
	/**
	* setEmailAddress
	*/
	public void setEmailAddress(String email)
	{
		setCommChannel(ims.core.vo.lookups.ChannelType.EMAIL, email);
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
		if(this.codemappings != null)
		{
			if(!this.codemappings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.hcp != null)
		{
			if(!this.hcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.appuser != null)
		{
			if(!this.appuser.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.primarylocation != null)
		{
			if(!this.primarylocation.isValidated())
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
		if(this.name == null)
			listOfErrors.add("Name is mandatory");
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
		if(this.initials != null)
			if(this.initials.length() > 5)
				listOfErrors.add("The length of the field [initials] in the value object [ims.core.vo.MemberOfStaffShortVo] is too big. It should be less or equal to 5");
		if(this.signatureblock != null)
			if(this.signatureblock.length() > 255)
				listOfErrors.add("The length of the field [signatureblock] in the value object [ims.core.vo.MemberOfStaffShortVo] is too big. It should be less or equal to 255");
		if(this.codemappings != null)
		{
			String[] listOfOtherErrors = this.codemappings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.hcp != null)
		{
			String[] listOfOtherErrors = this.hcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.appuser != null)
		{
			String[] listOfOtherErrors = this.appuser.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.primarylocation != null)
		{
			String[] listOfOtherErrors = this.primarylocation.validate();
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
		if(this.sdsroleid != null)
			if(this.sdsroleid.length() > 50)
				listOfErrors.add("The length of the field [sdsroleid] in the value object [ims.core.vo.MemberOfStaffShortVo] is too big. It should be less or equal to 50");
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
	
		MemberOfStaffShortVo clone = new MemberOfStaffShortVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		clone.initials = this.initials;
		clone.signatureblock = this.signatureblock;
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.Hcp)this.hcp.clone();
		if(this.appuser == null)
			clone.appuser = null;
		else
			clone.appuser = (ims.admin.vo.AppUserShortVo)this.appuser.clone();
		if(this.stafftype == null)
			clone.stafftype = null;
		else
			clone.stafftype = (ims.core.vo.lookups.StaffType)this.stafftype.clone();
		clone.isactive = this.isactive;
		clone.isappuser = this.isappuser;
		if(this.primarylocation == null)
			clone.primarylocation = null;
		else
			clone.primarylocation = (ims.core.vo.LocShortVo)this.primarylocation.clone();
		if(this.commchannels == null)
			clone.commchannels = null;
		else
			clone.commchannels = (ims.core.vo.CommChannelVoCollection)this.commchannels.clone();
		clone.sdsroleid = this.sdsroleid;
		clone.canreferpatient = this.canreferpatient;
		clone.mappingvalue = this.mappingvalue;
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
		if (!(MemberOfStaffShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MemberOfStaffShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MemberOfStaffShortVo compareObj = (MemberOfStaffShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
				retVal = this.getName().compareTo(compareObj.getName());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.hcp != null)
			count++;
		if(this.appuser != null)
			count++;
		if(this.stafftype != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.isappuser != null)
			count++;
		if(this.primarylocation != null)
			count++;
		if(this.commchannels != null)
			count++;
		if(this.sdsroleid != null)
			count++;
		if(this.canreferpatient != null)
			count++;
		if(this.mappingvalue != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 10;
	}
	protected ims.core.vo.Hcp hcp;
	protected ims.admin.vo.AppUserShortVo appuser;
	protected ims.core.vo.lookups.StaffType stafftype;
	protected Boolean isactive;
	protected Boolean isappuser;
	protected ims.core.vo.LocShortVo primarylocation;
	protected ims.core.vo.CommChannelVoCollection commchannels;
	protected String sdsroleid;
	protected Boolean canreferpatient;
	protected String mappingvalue;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
