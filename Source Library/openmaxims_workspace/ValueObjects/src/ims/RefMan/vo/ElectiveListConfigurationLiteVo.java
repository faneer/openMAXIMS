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

package ims.RefMan.vo;

/**
 * Linked to core.configuration.ElectiveListConfiguration business object (ID: 1028100072).
 */
public class ElectiveListConfigurationLiteVo extends ims.core.configuration.vo.ElectiveListConfigurationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ElectiveListConfigurationLiteVo()
	{
	}
	public ElectiveListConfigurationLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ElectiveListConfigurationLiteVo(ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.waitinglistname = bean.getWaitingListName();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.waitinglistcode = bean.getWaitingListCode();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.waitinglistname = bean.getWaitingListName();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.waitinglistcode = bean.getWaitingListCode();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean();
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
		if(fieldName.equals("WAITINGLISTNAME"))
			return getWaitingListName();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("WAITINGLISTCODE"))
			return getWaitingListCode();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWaitingListNameIsNotNull()
	{
		return this.waitinglistname != null;
	}
	public String getWaitingListName()
	{
		return this.waitinglistname;
	}
	public static int getWaitingListNameMaxLength()
	{
		return 150;
	}
	public void setWaitingListName(String value)
	{
		this.isValidated = false;
		this.waitinglistname = value;
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.admin.vo.ServiceForElectiveListConfigVo getService()
	{
		return this.service;
	}
	public void setService(ims.admin.vo.ServiceForElectiveListConfigVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getWaitingListCodeIsNotNull()
	{
		return this.waitinglistcode != null;
	}
	public String getWaitingListCode()
	{
		return this.waitinglistcode;
	}
	public static int getWaitingListCodeMaxLength()
	{
		return 20;
	}
	public void setWaitingListCode(String value)
	{
		this.isValidated = false;
		this.waitinglistcode = value;
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
		if(this.waitinglistname == null || this.waitinglistname.length() == 0)
			listOfErrors.add("WaitingListName is mandatory");
		else if(this.waitinglistname.length() > 150)
			listOfErrors.add("The length of the field [waitinglistname] in the value object [ims.RefMan.vo.ElectiveListConfigurationLiteVo] is too big. It should be less or equal to 150");
		if(this.startdate == null)
			listOfErrors.add("StartDate is mandatory");
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.waitinglistcode != null)
			if(this.waitinglistcode.length() > 20)
				listOfErrors.add("The length of the field [waitinglistcode] in the value object [ims.RefMan.vo.ElectiveListConfigurationLiteVo] is too big. It should be less or equal to 20");
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
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
	
		ElectiveListConfigurationLiteVo clone = new ElectiveListConfigurationLiteVo(this.id, this.version);
		
		clone.waitinglistname = this.waitinglistname;
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.admin.vo.ServiceForElectiveListConfigVo)this.service.clone();
		clone.waitinglistcode = this.waitinglistcode;
		clone.isactive = this.isactive;
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
		if (!(ElectiveListConfigurationLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ElectiveListConfigurationLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ElectiveListConfigurationLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ElectiveListConfigurationLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.waitinglistname != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.enddate != null)
			count++;
		if(this.service != null)
			count++;
		if(this.waitinglistcode != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String waitinglistname;
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date enddate;
	protected ims.admin.vo.ServiceForElectiveListConfigVo service;
	protected String waitinglistcode;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
