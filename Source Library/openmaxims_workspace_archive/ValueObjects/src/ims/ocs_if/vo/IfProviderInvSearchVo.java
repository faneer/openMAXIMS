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

package ims.ocs_if.vo;


public class IfProviderInvSearchVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfProviderInvSearchVo()
	{
	}
	public IfProviderInvSearchVo(ims.ocs_if.vo.beans.IfProviderInvSearchVoBean bean)
	{
		this.providerinvcode = bean.getProviderInvCode();
		this.hl7app = bean.getHl7App();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.specimensource = bean.getSpecimenSource();
		this.provider = bean.getProvider() == null ? null : bean.getProvider().buildVo();
		this.specimensite = bean.getSpecimenSite();
		this.isresultmessage = bean.getIsResultMessage();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.IfProviderInvSearchVoBean bean)
	{
		this.providerinvcode = bean.getProviderInvCode();
		this.hl7app = bean.getHl7App();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.specimensource = bean.getSpecimenSource();
		this.provider = bean.getProvider() == null ? null : bean.getProvider().buildVo(map);
		this.specimensite = bean.getSpecimenSite();
		this.isresultmessage = bean.getIsResultMessage();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.IfProviderInvSearchVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.IfProviderInvSearchVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.IfProviderInvSearchVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getProviderInvCodeIsNotNull()
	{
		return this.providerinvcode != null;
	}
	public String getProviderInvCode()
	{
		return this.providerinvcode;
	}
	public static int getProviderInvCodeMaxLength()
	{
		return 255;
	}
	public void setProviderInvCode(String value)
	{
		this.isValidated = false;
		this.providerinvcode = value;
	}
	public boolean getHl7AppIsNotNull()
	{
		return this.hl7app != null;
	}
	public String getHl7App()
	{
		return this.hl7app;
	}
	public static int getHl7AppMaxLength()
	{
		return 255;
	}
	public void setHl7App(String value)
	{
		this.isValidated = false;
		this.hl7app = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getSpecimenSourceIsNotNull()
	{
		return this.specimensource != null;
	}
	public String getSpecimenSource()
	{
		return this.specimensource;
	}
	public static int getSpecimenSourceMaxLength()
	{
		return 255;
	}
	public void setSpecimenSource(String value)
	{
		this.isValidated = false;
		this.specimensource = value;
	}
	public boolean getProviderIsNotNull()
	{
		return this.provider != null;
	}
	public ims.ocrr.vo.ProviderSystemVo getProvider()
	{
		return this.provider;
	}
	public void setProvider(ims.ocrr.vo.ProviderSystemVo value)
	{
		this.isValidated = false;
		this.provider = value;
	}
	public boolean getSpecimenSiteIsNotNull()
	{
		return this.specimensite != null;
	}
	public String getSpecimenSite()
	{
		return this.specimensite;
	}
	public static int getSpecimenSiteMaxLength()
	{
		return 255;
	}
	public void setSpecimenSite(String value)
	{
		this.isValidated = false;
		this.specimensite = value;
	}
	public boolean getIsResultMessageIsNotNull()
	{
		return this.isresultmessage != null;
	}
	public Boolean getIsResultMessage()
	{
		return this.isresultmessage;
	}
	public void setIsResultMessage(Boolean value)
	{
		this.isValidated = false;
		this.isresultmessage = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof IfProviderInvSearchVo))
			return false;
		IfProviderInvSearchVo compareObj = (IfProviderInvSearchVo)obj;
		if(this.getProviderInvCode() == null && compareObj.getProviderInvCode() != null)
			return false;
		if(this.getProviderInvCode() != null && compareObj.getProviderInvCode() == null)
			return false;
		if(this.getProviderInvCode() != null && compareObj.getProviderInvCode() != null)
			if(!this.getProviderInvCode().equals(compareObj.getProviderInvCode()))
				return false;
		if(this.getHl7App() == null && compareObj.getHl7App() != null)
			return false;
		if(this.getHl7App() != null && compareObj.getHl7App() == null)
			return false;
		if(this.getHl7App() != null && compareObj.getHl7App() != null)
			if(!this.getHl7App().equals(compareObj.getHl7App()))
				return false;
		if(this.getSpecimenSource() == null && compareObj.getSpecimenSource() != null)
			return false;
		if(this.getSpecimenSource() != null && compareObj.getSpecimenSource() == null)
			return false;
		if(this.getSpecimenSource() != null && compareObj.getSpecimenSource() != null)
			return this.getSpecimenSource().equals(compareObj.getSpecimenSource());
		return super.equals(obj);
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
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.provider != null)
		{
			if(!this.provider.isValidated())
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
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.provider != null)
		{
			String[] listOfOtherErrors = this.provider.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		IfProviderInvSearchVo clone = new IfProviderInvSearchVo();
		
		clone.providerinvcode = this.providerinvcode;
		clone.hl7app = this.hl7app;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		clone.specimensource = this.specimensource;
		if(this.provider == null)
			clone.provider = null;
		else
			clone.provider = (ims.ocrr.vo.ProviderSystemVo)this.provider.clone();
		clone.specimensite = this.specimensite;
		clone.isresultmessage = this.isresultmessage;
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
		if (!(IfProviderInvSearchVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfProviderInvSearchVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		IfProviderInvSearchVo compareObj = (IfProviderInvSearchVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getProviderInvCode() == null && compareObj.getProviderInvCode() != null)
				return -1;
			if(this.getProviderInvCode() != null && compareObj.getProviderInvCode() == null)
				return 1;
			if(this.getProviderInvCode() != null && compareObj.getProviderInvCode() != null)
			{
				if(caseInsensitive)
					retVal = this.getProviderInvCode().toLowerCase().compareTo(compareObj.getProviderInvCode().toLowerCase());
				else
					retVal = this.getProviderInvCode().compareTo(compareObj.getProviderInvCode());
			}
		}
		if (retVal == 0)
		{
			if(this.getHl7App() == null && compareObj.getHl7App() != null)
				return -1;
			if(this.getHl7App() != null && compareObj.getHl7App() == null)
				return 1;
			if(this.getHl7App() != null && compareObj.getHl7App() != null)
			{
				if(caseInsensitive)
					retVal = this.getHl7App().toLowerCase().compareTo(compareObj.getHl7App().toLowerCase());
				else
					retVal = this.getHl7App().compareTo(compareObj.getHl7App());
			}
		}
		if (retVal == 0)
		{
			if(this.getSpecimenSource() == null && compareObj.getSpecimenSource() != null)
				return -1;
			if(this.getSpecimenSource() != null && compareObj.getSpecimenSource() == null)
				return 1;
			if(this.getSpecimenSource() != null && compareObj.getSpecimenSource() != null)
			{
				if(caseInsensitive)
					retVal = this.getSpecimenSource().toLowerCase().compareTo(compareObj.getSpecimenSource().toLowerCase());
				else
					retVal = this.getSpecimenSource().compareTo(compareObj.getSpecimenSource());
			}
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.providerinvcode != null)
			count++;
		if(this.hl7app != null)
			count++;
		if(this.service != null)
			count++;
		if(this.specimensource != null)
			count++;
		if(this.provider != null)
			count++;
		if(this.specimensite != null)
			count++;
		if(this.isresultmessage != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected String providerinvcode;
	protected String hl7app;
	protected ims.core.vo.ServiceLiteVo service;
	protected String specimensource;
	protected ims.ocrr.vo.ProviderSystemVo provider;
	protected String specimensite;
	protected Boolean isresultmessage;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
