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

package ims.therapies.vo;

/**
 * Linked to therapies.MobilityTransfers.WheelchairSurfaceDistance business object (ID: 1019100046).
 */
public class WheelchairSurfaceDistanceVo extends ims.therapies.mobilitytransfers.vo.WheelchairSurfaceDistanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WheelchairSurfaceDistanceVo()
	{
	}
	public WheelchairSurfaceDistanceVo(Integer id, int version)
	{
		super(id, version);
	}
	public WheelchairSurfaceDistanceVo(ims.therapies.vo.beans.WheelchairSurfaceDistanceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surface = bean.getSurface() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairSurface.buildLookup(bean.getSurface());
		this.distance = bean.getDistance();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.WheelchairSurfaceDistanceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surface = bean.getSurface() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairSurface.buildLookup(bean.getSurface());
		this.distance = bean.getDistance();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.WheelchairSurfaceDistanceVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.WheelchairSurfaceDistanceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.WheelchairSurfaceDistanceVoBean();
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
		if(fieldName.equals("SURFACE"))
			return getSurface();
		if(fieldName.equals("DISTANCE"))
			return getDistance();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSurfaceIsNotNull()
	{
		return this.surface != null;
	}
	public ims.spinalinjuries.vo.lookups.WheelchairSurface getSurface()
	{
		return this.surface;
	}
	public void setSurface(ims.spinalinjuries.vo.lookups.WheelchairSurface value)
	{
		this.isValidated = false;
		this.surface = value;
	}
	public boolean getDistanceIsNotNull()
	{
		return this.distance != null;
	}
	public String getDistance()
	{
		return this.distance;
	}
	public static int getDistanceMaxLength()
	{
		return 255;
	}
	public void setDistance(String value)
	{
		this.isValidated = false;
		this.distance = value;
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
		if(this.surface == null)
			listOfErrors.add("Please enter Surface.");
		if(this.distance == null || this.distance.length() == 0)
			listOfErrors.add("Please enter Distance.");
		else if(this.distance.length() > 255)
			listOfErrors.add("The length of the field [distance] in the value object [ims.therapies.vo.WheelchairSurfaceDistanceVo] is too big. It should be less or equal to 255");
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
	
		WheelchairSurfaceDistanceVo clone = new WheelchairSurfaceDistanceVo(this.id, this.version);
		
		if(this.surface == null)
			clone.surface = null;
		else
			clone.surface = (ims.spinalinjuries.vo.lookups.WheelchairSurface)this.surface.clone();
		clone.distance = this.distance;
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
		if (!(WheelchairSurfaceDistanceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WheelchairSurfaceDistanceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WheelchairSurfaceDistanceVo compareObj = (WheelchairSurfaceDistanceVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_WheelchairSurfaceDistance() == null && compareObj.getID_WheelchairSurfaceDistance() != null)
				return -1;
			if(this.getID_WheelchairSurfaceDistance() != null && compareObj.getID_WheelchairSurfaceDistance() == null)
				return 1;
			if(this.getID_WheelchairSurfaceDistance() != null && compareObj.getID_WheelchairSurfaceDistance() != null)
				retVal = this.getID_WheelchairSurfaceDistance().compareTo(compareObj.getID_WheelchairSurfaceDistance());
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
		if(this.surface != null)
			count++;
		if(this.distance != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.spinalinjuries.vo.lookups.WheelchairSurface surface;
	protected String distance;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
