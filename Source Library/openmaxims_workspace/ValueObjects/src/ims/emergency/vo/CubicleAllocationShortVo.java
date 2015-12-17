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

package ims.emergency.vo;

/**
 * Linked to emergency.CubicleAllocation business object (ID: 1086100010).
 */
public class CubicleAllocationShortVo extends ims.emergency.vo.CubicleAllocationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CubicleAllocationShortVo()
	{
	}
	public CubicleAllocationShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public CubicleAllocationShortVo(ims.emergency.vo.beans.CubicleAllocationShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.trackingarea = bean.getTrackingArea() == null ? null : bean.getTrackingArea().buildVo();
		this.allocatedcubicledatetime = bean.getAllocatedCubicleDateTime() == null ? null : bean.getAllocatedCubicleDateTime().buildDateTime();
		this.allocatedby = bean.getAllocatedBy() == null ? null : bean.getAllocatedBy().buildVo();
		this.cubicleroombed = bean.getCubicleRoomBed() == null ? null : bean.getCubicleRoomBed().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.CubicleAllocationShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.trackingarea = bean.getTrackingArea() == null ? null : bean.getTrackingArea().buildVo(map);
		this.allocatedcubicledatetime = bean.getAllocatedCubicleDateTime() == null ? null : bean.getAllocatedCubicleDateTime().buildDateTime();
		this.allocatedby = bean.getAllocatedBy() == null ? null : bean.getAllocatedBy().buildVo(map);
		this.cubicleroombed = bean.getCubicleRoomBed() == null ? null : bean.getCubicleRoomBed().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.CubicleAllocationShortVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.CubicleAllocationShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.CubicleAllocationShortVoBean();
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
		if(fieldName.equals("TRACKINGAREA"))
			return getTrackingArea();
		if(fieldName.equals("ALLOCATEDCUBICLEDATETIME"))
			return getAllocatedCubicleDateTime();
		if(fieldName.equals("ALLOCATEDBY"))
			return getAllocatedBy();
		if(fieldName.equals("CUBICLEROOMBED"))
			return getCubicleRoomBed();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTrackingAreaIsNotNull()
	{
		return this.trackingarea != null;
	}
	public ims.emergency.vo.TrackingAreaLiteVo getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.emergency.vo.TrackingAreaLiteVo value)
	{
		this.isValidated = false;
		this.trackingarea = value;
	}
	public boolean getAllocatedCubicleDateTimeIsNotNull()
	{
		return this.allocatedcubicledatetime != null;
	}
	public ims.framework.utils.DateTime getAllocatedCubicleDateTime()
	{
		return this.allocatedcubicledatetime;
	}
	public void setAllocatedCubicleDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.allocatedcubicledatetime = value;
	}
	public boolean getAllocatedByIsNotNull()
	{
		return this.allocatedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getAllocatedBy()
	{
		return this.allocatedby;
	}
	public void setAllocatedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.allocatedby = value;
	}
	public boolean getCubicleRoomBedIsNotNull()
	{
		return this.cubicleroombed != null;
	}
	public ims.emergency.vo.TrackingCubicleRoomBedVo getCubicleRoomBed()
	{
		return this.cubicleroombed;
	}
	public void setCubicleRoomBed(ims.emergency.vo.TrackingCubicleRoomBedVo value)
	{
		this.isValidated = false;
		this.cubicleroombed = value;
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
		if(this.trackingarea != null)
		{
			if(!this.trackingarea.isValidated())
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
		if(this.trackingarea == null)
			listOfErrors.add("TrackingArea is mandatory");
		if(this.trackingarea != null)
		{
			String[] listOfOtherErrors = this.trackingarea.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.allocatedcubicledatetime == null)
			listOfErrors.add("AllocatedCubicleDateTime is mandatory");
		if(this.allocatedby == null)
			listOfErrors.add("AllocatedBy is mandatory");
		if(this.cubicleroombed == null)
			listOfErrors.add("CubicleRoomBed is mandatory");
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
	
		CubicleAllocationShortVo clone = new CubicleAllocationShortVo(this.id, this.version);
		
		if(this.trackingarea == null)
			clone.trackingarea = null;
		else
			clone.trackingarea = (ims.emergency.vo.TrackingAreaLiteVo)this.trackingarea.clone();
		if(this.allocatedcubicledatetime == null)
			clone.allocatedcubicledatetime = null;
		else
			clone.allocatedcubicledatetime = (ims.framework.utils.DateTime)this.allocatedcubicledatetime.clone();
		if(this.allocatedby == null)
			clone.allocatedby = null;
		else
			clone.allocatedby = (ims.core.vo.MemberOfStaffLiteVo)this.allocatedby.clone();
		if(this.cubicleroombed == null)
			clone.cubicleroombed = null;
		else
			clone.cubicleroombed = (ims.emergency.vo.TrackingCubicleRoomBedVo)this.cubicleroombed.clone();
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
		if (!(CubicleAllocationShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CubicleAllocationShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CubicleAllocationShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CubicleAllocationShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.trackingarea != null)
			count++;
		if(this.allocatedcubicledatetime != null)
			count++;
		if(this.allocatedby != null)
			count++;
		if(this.cubicleroombed != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.emergency.vo.TrackingAreaLiteVo trackingarea;
	protected ims.framework.utils.DateTime allocatedcubicledatetime;
	protected ims.core.vo.MemberOfStaffLiteVo allocatedby;
	protected ims.emergency.vo.TrackingCubicleRoomBedVo cubicleroombed;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
