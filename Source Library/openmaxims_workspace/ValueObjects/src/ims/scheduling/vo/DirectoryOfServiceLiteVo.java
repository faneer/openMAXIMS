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

/**
 * Linked to Scheduling.DirectoryofService business object (ID: 1055100011).
 */
public class DirectoryOfServiceLiteVo extends ims.scheduling.vo.DirectoryofServiceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DirectoryOfServiceLiteVo()
	{
	}
	public DirectoryOfServiceLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public DirectoryOfServiceLiteVo(ims.scheduling.vo.beans.DirectoryOfServiceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dosname = bean.getDoSName();
		this.dosid = bean.getDoSId();
		this.isactive = bean.getIsActive();
		this.rttclockimpact = bean.getRTTClockImpact();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.DirectoryOfServiceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dosname = bean.getDoSName();
		this.dosid = bean.getDoSId();
		this.isactive = bean.getIsActive();
		this.rttclockimpact = bean.getRTTClockImpact();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.DirectoryOfServiceLiteVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.DirectoryOfServiceLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.DirectoryOfServiceLiteVoBean();
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
		if(fieldName.equals("DOSNAME"))
			return getDoSName();
		if(fieldName.equals("DOSID"))
			return getDoSId();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("RTTCLOCKIMPACT"))
			return getRTTClockImpact();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDoSNameIsNotNull()
	{
		return this.dosname != null;
	}
	public String getDoSName()
	{
		return this.dosname;
	}
	public static int getDoSNameMaxLength()
	{
		return 300;
	}
	public void setDoSName(String value)
	{
		this.isValidated = false;
		this.dosname = value;
	}
	public boolean getDoSIdIsNotNull()
	{
		return this.dosid != null;
	}
	public String getDoSId()
	{
		return this.dosid;
	}
	public static int getDoSIdMaxLength()
	{
		return 50;
	}
	public void setDoSId(String value)
	{
		this.isValidated = false;
		this.dosid = value;
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
	public boolean getRTTClockImpactIsNotNull()
	{
		return this.rttclockimpact != null;
	}
	public Boolean getRTTClockImpact()
	{
		return this.rttclockimpact;
	}
	public void setRTTClockImpact(Boolean value)
	{
		this.isValidated = false;
		this.rttclockimpact = value;
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
		if(this.dosname == null || this.dosname.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.dosname.length() > 300)
			listOfErrors.add("The length of the field [dosname] in the value object [ims.scheduling.vo.DirectoryOfServiceLiteVo] is too big. It should be less or equal to 300");
		if(this.dosid == null || this.dosid.length() == 0)
			listOfErrors.add("ID is mandatory");
		else if(this.dosid.length() > 50)
			listOfErrors.add("The length of the field [dosid] in the value object [ims.scheduling.vo.DirectoryOfServiceLiteVo] is too big. It should be less or equal to 50");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
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
	
		DirectoryOfServiceLiteVo clone = new DirectoryOfServiceLiteVo(this.id, this.version);
		
		clone.dosname = this.dosname;
		clone.dosid = this.dosid;
		clone.isactive = this.isactive;
		clone.rttclockimpact = this.rttclockimpact;
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
		if (!(DirectoryOfServiceLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DirectoryOfServiceLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DirectoryOfServiceLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DirectoryOfServiceLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.dosname != null)
			count++;
		if(this.dosid != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.rttclockimpact != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String dosname;
	protected String dosid;
	protected Boolean isactive;
	protected Boolean rttclockimpact;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
