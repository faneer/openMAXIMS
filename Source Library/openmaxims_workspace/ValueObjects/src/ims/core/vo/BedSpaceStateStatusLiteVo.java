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
 * Linked to core.admin.pas.BedSpaceStateStatus business object (ID: 1014100010).
 */
public class BedSpaceStateStatusLiteVo extends ims.core.admin.pas.vo.BedSpaceStateStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BedSpaceStateStatusLiteVo()
	{
	}
	public BedSpaceStateStatusLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public BedSpaceStateStatusLiteVo(ims.core.vo.beans.BedSpaceStateStatusLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedstatus = bean.getBedStatus() == null ? null : ims.core.vo.lookups.BedStatus.buildLookup(bean.getBedStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.reasonforclosure = bean.getReasonForClosure() == null ? null : ims.core.vo.lookups.ReasonForBedClosure.buildLookup(bean.getReasonForClosure());
		this.estreopeningdatetime = bean.getEstReopeningDateTime() == null ? null : bean.getEstReopeningDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.BedSpaceStateStatusLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedstatus = bean.getBedStatus() == null ? null : ims.core.vo.lookups.BedStatus.buildLookup(bean.getBedStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.reasonforclosure = bean.getReasonForClosure() == null ? null : ims.core.vo.lookups.ReasonForBedClosure.buildLookup(bean.getReasonForClosure());
		this.estreopeningdatetime = bean.getEstReopeningDateTime() == null ? null : bean.getEstReopeningDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.BedSpaceStateStatusLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.BedSpaceStateStatusLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.BedSpaceStateStatusLiteVoBean();
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
		if(fieldName.equals("BEDSTATUS"))
			return getBedStatus();
		if(fieldName.equals("STATUSDATETIME"))
			return getStatusDateTime();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("REASONFORCLOSURE"))
			return getReasonForClosure();
		if(fieldName.equals("ESTREOPENINGDATETIME"))
			return getEstReopeningDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBedStatusIsNotNull()
	{
		return this.bedstatus != null;
	}
	public ims.core.vo.lookups.BedStatus getBedStatus()
	{
		return this.bedstatus;
	}
	public void setBedStatus(ims.core.vo.lookups.BedStatus value)
	{
		this.isValidated = false;
		this.bedstatus = value;
	}
	public boolean getStatusDateTimeIsNotNull()
	{
		return this.statusdatetime != null;
	}
	public ims.framework.utils.DateTime getStatusDateTime()
	{
		return this.statusdatetime;
	}
	public void setStatusDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdatetime = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getReasonForClosureIsNotNull()
	{
		return this.reasonforclosure != null;
	}
	public ims.core.vo.lookups.ReasonForBedClosure getReasonForClosure()
	{
		return this.reasonforclosure;
	}
	public void setReasonForClosure(ims.core.vo.lookups.ReasonForBedClosure value)
	{
		this.isValidated = false;
		this.reasonforclosure = value;
	}
	public boolean getEstReopeningDateTimeIsNotNull()
	{
		return this.estreopeningdatetime != null;
	}
	public ims.framework.utils.DateTime getEstReopeningDateTime()
	{
		return this.estreopeningdatetime;
	}
	public void setEstReopeningDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.estreopeningdatetime = value;
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
	
		BedSpaceStateStatusLiteVo clone = new BedSpaceStateStatusLiteVo(this.id, this.version);
		
		if(this.bedstatus == null)
			clone.bedstatus = null;
		else
			clone.bedstatus = (ims.core.vo.lookups.BedStatus)this.bedstatus.clone();
		if(this.statusdatetime == null)
			clone.statusdatetime = null;
		else
			clone.statusdatetime = (ims.framework.utils.DateTime)this.statusdatetime.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.reasonforclosure == null)
			clone.reasonforclosure = null;
		else
			clone.reasonforclosure = (ims.core.vo.lookups.ReasonForBedClosure)this.reasonforclosure.clone();
		if(this.estreopeningdatetime == null)
			clone.estreopeningdatetime = null;
		else
			clone.estreopeningdatetime = (ims.framework.utils.DateTime)this.estreopeningdatetime.clone();
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
		if (!(BedSpaceStateStatusLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BedSpaceStateStatusLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BedSpaceStateStatusLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BedSpaceStateStatusLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.bedstatus != null)
			count++;
		if(this.statusdatetime != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.reasonforclosure != null)
			count++;
		if(this.estreopeningdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.lookups.BedStatus bedstatus;
	protected ims.framework.utils.DateTime statusdatetime;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.vo.lookups.ReasonForBedClosure reasonforclosure;
	protected ims.framework.utils.DateTime estreopeningdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
