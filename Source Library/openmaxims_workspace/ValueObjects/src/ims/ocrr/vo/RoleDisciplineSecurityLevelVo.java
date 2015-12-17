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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.RoleDisciplineSecurityLevel business object (ID: 1061100020).
 */
public class RoleDisciplineSecurityLevelVo extends ims.ocrr.configuration.vo.RoleDisciplineSecurityLevelRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RoleDisciplineSecurityLevelVo()
	{
	}
	public RoleDisciplineSecurityLevelVo(Integer id, int version)
	{
		super(id, version);
	}
	public RoleDisciplineSecurityLevelVo(ims.ocrr.vo.beans.RoleDisciplineSecurityLevelVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.role = bean.getRole() == null ? null : new ims.core.configuration.vo.AppRoleRefVo(new Integer(bean.getRole().getId()), bean.getRole().getVersion());
		this.service = bean.getService() == null ? null : new ims.core.clinical.vo.ServiceRefVo(new Integer(bean.getService().getId()), bean.getService().getVersion());
		this.orderingsecuritylevel = bean.getOrderingSecurityLevel() == null ? null : new ims.ocrr.configuration.vo.SecurityLevelRefVo(new Integer(bean.getOrderingSecurityLevel().getId()), bean.getOrderingSecurityLevel().getVersion());
		this.viewingsecuritylevel = bean.getViewingSecurityLevel() == null ? null : new ims.ocrr.configuration.vo.SecurityLevelRefVo(new Integer(bean.getViewingSecurityLevel().getId()), bean.getViewingSecurityLevel().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.RoleDisciplineSecurityLevelVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.role = bean.getRole() == null ? null : new ims.core.configuration.vo.AppRoleRefVo(new Integer(bean.getRole().getId()), bean.getRole().getVersion());
		this.service = bean.getService() == null ? null : new ims.core.clinical.vo.ServiceRefVo(new Integer(bean.getService().getId()), bean.getService().getVersion());
		this.orderingsecuritylevel = bean.getOrderingSecurityLevel() == null ? null : new ims.ocrr.configuration.vo.SecurityLevelRefVo(new Integer(bean.getOrderingSecurityLevel().getId()), bean.getOrderingSecurityLevel().getVersion());
		this.viewingsecuritylevel = bean.getViewingSecurityLevel() == null ? null : new ims.ocrr.configuration.vo.SecurityLevelRefVo(new Integer(bean.getViewingSecurityLevel().getId()), bean.getViewingSecurityLevel().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.RoleDisciplineSecurityLevelVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.RoleDisciplineSecurityLevelVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.RoleDisciplineSecurityLevelVoBean();
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
		if(fieldName.equals("ROLE"))
			return getRole();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("ORDERINGSECURITYLEVEL"))
			return getOrderingSecurityLevel();
		if(fieldName.equals("VIEWINGSECURITYLEVEL"))
			return getViewingSecurityLevel();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRoleIsNotNull()
	{
		return this.role != null;
	}
	public ims.core.configuration.vo.AppRoleRefVo getRole()
	{
		return this.role;
	}
	public void setRole(ims.core.configuration.vo.AppRoleRefVo value)
	{
		this.isValidated = false;
		this.role = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.clinical.vo.ServiceRefVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.clinical.vo.ServiceRefVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getOrderingSecurityLevelIsNotNull()
	{
		return this.orderingsecuritylevel != null;
	}
	public ims.ocrr.configuration.vo.SecurityLevelRefVo getOrderingSecurityLevel()
	{
		return this.orderingsecuritylevel;
	}
	public void setOrderingSecurityLevel(ims.ocrr.configuration.vo.SecurityLevelRefVo value)
	{
		this.isValidated = false;
		this.orderingsecuritylevel = value;
	}
	public boolean getViewingSecurityLevelIsNotNull()
	{
		return this.viewingsecuritylevel != null;
	}
	public ims.ocrr.configuration.vo.SecurityLevelRefVo getViewingSecurityLevel()
	{
		return this.viewingsecuritylevel;
	}
	public void setViewingSecurityLevel(ims.ocrr.configuration.vo.SecurityLevelRefVo value)
	{
		this.isValidated = false;
		this.viewingsecuritylevel = value;
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
		if(this.role == null)
			listOfErrors.add("Role is mandatory");
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
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
	
		RoleDisciplineSecurityLevelVo clone = new RoleDisciplineSecurityLevelVo(this.id, this.version);
		
		clone.role = this.role;
		clone.service = this.service;
		clone.orderingsecuritylevel = this.orderingsecuritylevel;
		clone.viewingsecuritylevel = this.viewingsecuritylevel;
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
		if (!(RoleDisciplineSecurityLevelVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RoleDisciplineSecurityLevelVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RoleDisciplineSecurityLevelVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RoleDisciplineSecurityLevelVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.role != null)
			count++;
		if(this.service != null)
			count++;
		if(this.orderingsecuritylevel != null)
			count++;
		if(this.viewingsecuritylevel != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.configuration.vo.AppRoleRefVo role;
	protected ims.core.clinical.vo.ServiceRefVo service;
	protected ims.ocrr.configuration.vo.SecurityLevelRefVo orderingsecuritylevel;
	protected ims.ocrr.configuration.vo.SecurityLevelRefVo viewingsecuritylevel;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
