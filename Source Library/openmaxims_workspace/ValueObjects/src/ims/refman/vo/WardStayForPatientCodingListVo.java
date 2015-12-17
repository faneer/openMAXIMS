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
 * Linked to core.admin.pas.Ward Stay business object (ID: 1014100004).
 */
public class WardStayForPatientCodingListVo extends ims.core.admin.pas.vo.WardStayRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardStayForPatientCodingListVo()
	{
	}
	public WardStayForPatientCodingListVo(Integer id, int version)
	{
		super(id, version);
	}
	public WardStayForPatientCodingListVo(ims.RefMan.vo.beans.WardStayForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.transferdatetime = bean.getTransferDateTime() == null ? null : bean.getTransferDateTime().buildDateTime();
		this.transferoutdatetime = bean.getTransferOutDateTime() == null ? null : bean.getTransferOutDateTime().buildDateTime();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.bedspace = bean.getBedSpace() == null ? null : bean.getBedSpace().buildVo();
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.WardStayForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.transferdatetime = bean.getTransferDateTime() == null ? null : bean.getTransferDateTime().buildDateTime();
		this.transferoutdatetime = bean.getTransferOutDateTime() == null ? null : bean.getTransferOutDateTime().buildDateTime();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.bedspace = bean.getBedSpace() == null ? null : bean.getBedSpace().buildVo(map);
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.WardStayForPatientCodingListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.WardStayForPatientCodingListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.WardStayForPatientCodingListVoBean();
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
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("TRANSFERDATETIME"))
			return getTransferDateTime();
		if(fieldName.equals("TRANSFEROUTDATETIME"))
			return getTransferOutDateTime();
		if(fieldName.equals("WARDTYPE"))
			return getWardType();
		if(fieldName.equals("BEDSPACE"))
			return getBedSpace();
		if(fieldName.equals("BAY"))
			return getBay();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getTransferDateTimeIsNotNull()
	{
		return this.transferdatetime != null;
	}
	public ims.framework.utils.DateTime getTransferDateTime()
	{
		return this.transferdatetime;
	}
	public void setTransferDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.transferdatetime = value;
	}
	public boolean getTransferOutDateTimeIsNotNull()
	{
		return this.transferoutdatetime != null;
	}
	public ims.framework.utils.DateTime getTransferOutDateTime()
	{
		return this.transferoutdatetime;
	}
	public void setTransferOutDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.transferoutdatetime = value;
	}
	public boolean getWardTypeIsNotNull()
	{
		return this.wardtype != null;
	}
	public ims.core.vo.lookups.WardType getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.core.vo.lookups.WardType value)
	{
		this.isValidated = false;
		this.wardtype = value;
	}
	public boolean getBedSpaceIsNotNull()
	{
		return this.bedspace != null;
	}
	public ims.core.vo.BedSpaceLiteVo getBedSpace()
	{
		return this.bedspace;
	}
	public void setBedSpace(ims.core.vo.BedSpaceLiteVo value)
	{
		this.isValidated = false;
		this.bedspace = value;
	}
	public boolean getBayIsNotNull()
	{
		return this.bay != null;
	}
	public ims.core.vo.LocationLiteVo getBay()
	{
		return this.bay;
	}
	public void setBay(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.bay = value;
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
	
		WardStayForPatientCodingListVo clone = new WardStayForPatientCodingListVo(this.id, this.version);
		
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.transferdatetime == null)
			clone.transferdatetime = null;
		else
			clone.transferdatetime = (ims.framework.utils.DateTime)this.transferdatetime.clone();
		if(this.transferoutdatetime == null)
			clone.transferoutdatetime = null;
		else
			clone.transferoutdatetime = (ims.framework.utils.DateTime)this.transferoutdatetime.clone();
		if(this.wardtype == null)
			clone.wardtype = null;
		else
			clone.wardtype = (ims.core.vo.lookups.WardType)this.wardtype.clone();
		if(this.bedspace == null)
			clone.bedspace = null;
		else
			clone.bedspace = (ims.core.vo.BedSpaceLiteVo)this.bedspace.clone();
		if(this.bay == null)
			clone.bay = null;
		else
			clone.bay = (ims.core.vo.LocationLiteVo)this.bay.clone();
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
		if (!(WardStayForPatientCodingListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardStayForPatientCodingListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WardStayForPatientCodingListVo compareObj = (WardStayForPatientCodingListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getTransferDateTime() == null && compareObj.getTransferDateTime() != null)
				return -1;
			if(this.getTransferDateTime() != null && compareObj.getTransferDateTime() == null)
				return 1;
			if(this.getTransferDateTime() != null && compareObj.getTransferDateTime() != null)
				retVal = this.getTransferDateTime().compareTo(compareObj.getTransferDateTime());
		}
		if (retVal == 0)
		{
			if(this.getTransferOutDateTime() == null && compareObj.getTransferOutDateTime() != null)
				return -1;
			if(this.getTransferOutDateTime() != null && compareObj.getTransferOutDateTime() == null)
				return 1;
			if(this.getTransferOutDateTime() != null && compareObj.getTransferOutDateTime() != null)
				retVal = this.getTransferOutDateTime().compareTo(compareObj.getTransferOutDateTime());
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
		if(this.ward != null)
			count++;
		if(this.transferdatetime != null)
			count++;
		if(this.transferoutdatetime != null)
			count++;
		if(this.wardtype != null)
			count++;
		if(this.bedspace != null)
			count++;
		if(this.bay != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.framework.utils.DateTime transferdatetime;
	protected ims.framework.utils.DateTime transferoutdatetime;
	protected ims.core.vo.lookups.WardType wardtype;
	protected ims.core.vo.BedSpaceLiteVo bedspace;
	protected ims.core.vo.LocationLiteVo bay;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
