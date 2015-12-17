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
 * Linked to RefMan.TCIForPatientElectiveList business object (ID: 1096100064).
 */
public class TCIDetailsLiteVo extends ims.RefMan.vo.TCIForPatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TCIDetailsLiteVo()
	{
	}
	public TCIDetailsLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TCIDetailsLiteVo(ims.RefMan.vo.beans.TCIDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.TCIDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.TCIDetailsLiteVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.TCIDetailsLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.TCIDetailsLiteVoBean();
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
		if(fieldName.equals("TCIDATE"))
			return getTCIDate();
		if(fieldName.equals("TCITIME"))
			return getTCITime();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTCIDateIsNotNull()
	{
		return this.tcidate != null;
	}
	public ims.framework.utils.Date getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.tcidate = value;
	}
	public boolean getTCITimeIsNotNull()
	{
		return this.tcitime != null;
	}
	public ims.framework.utils.Time getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.tcitime = value;
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
	
		TCIDetailsLiteVo clone = new TCIDetailsLiteVo(this.id, this.version);
		
		if(this.tcidate == null)
			clone.tcidate = null;
		else
			clone.tcidate = (ims.framework.utils.Date)this.tcidate.clone();
		if(this.tcitime == null)
			clone.tcitime = null;
		else
			clone.tcitime = (ims.framework.utils.Time)this.tcitime.clone();
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
		if (!(TCIDetailsLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TCIDetailsLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TCIDetailsLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TCIDetailsLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.tcidate != null)
			count++;
		if(this.tcitime != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.Date tcidate;
	protected ims.framework.utils.Time tcitime;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
