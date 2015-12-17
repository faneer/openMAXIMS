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

package ims.scheduling.vo;


public class SessionServiceProcedureConsultantVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionServiceProcedureConsultantVo()
	{
	}
	public SessionServiceProcedureConsultantVo(ims.scheduling.vo.beans.SessionServiceProcedureConsultantVoBean bean)
	{
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionServiceProcedureConsultantVoBean bean)
	{
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionServiceProcedureConsultantVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionServiceProcedureConsultantVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionServiceProcedureConsultantVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
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
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
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
		if(!(obj instanceof SessionServiceProcedureConsultantVo))
			return false;
		SessionServiceProcedureConsultantVo compareObj = (SessionServiceProcedureConsultantVo)obj;
		if(this.getService() == null && compareObj.getService() != null)
			return false;
		if(this.getService() != null && compareObj.getService() == null)
			return false;
		if(this.getService() != null && compareObj.getService() != null)
			return this.getService().equals(compareObj.getService());
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
	
		SessionServiceProcedureConsultantVo clone = new SessionServiceProcedureConsultantVo();
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
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
		if (!(SessionServiceProcedureConsultantVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionServiceProcedureConsultantVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SessionServiceProcedureConsultantVo compareObj = (SessionServiceProcedureConsultantVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getService() == null && compareObj.getService() != null)
				return -1;
			if(this.getService() != null && compareObj.getService() == null)
				return 1;
			if(this.getService() != null && compareObj.getService() != null)
				retVal = this.getService().compareTo(compareObj.getService());
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
		if(this.service != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.consultant != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.ProcedureLiteVo procedure;
	protected ims.core.vo.HcpLiteVo consultant;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
