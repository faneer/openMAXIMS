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
 * Linked to OCRR.OrderingResults.SpecimenCollectionStatus business object (ID: 1070100012).
 */
public class SpecimenCollectionStatusVo extends ims.ocrr.orderingresults.vo.SpecimenCollectionStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SpecimenCollectionStatusVo()
	{
	}
	public SpecimenCollectionStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public SpecimenCollectionStatusVo(ims.ocrr.vo.beans.SpecimenCollectionStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.listtype = bean.getListType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionMethod.buildLookup(bean.getListType());
		this.collectionstatus = bean.getCollectionStatus() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionStatus.buildLookup(bean.getCollectionStatus());
		this.reason = bean.getReason();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.SpecimenCollectionStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.listtype = bean.getListType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionMethod.buildLookup(bean.getListType());
		this.collectionstatus = bean.getCollectionStatus() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionStatus.buildLookup(bean.getCollectionStatus());
		this.reason = bean.getReason();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.SpecimenCollectionStatusVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.SpecimenCollectionStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.SpecimenCollectionStatusVoBean();
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
		if(fieldName.equals("LISTTYPE"))
			return getListType();
		if(fieldName.equals("COLLECTIONSTATUS"))
			return getCollectionStatus();
		if(fieldName.equals("REASON"))
			return getReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getListTypeIsNotNull()
	{
		return this.listtype != null;
	}
	public ims.ocrr.vo.lookups.SpecimenCollectionMethod getListType()
	{
		return this.listtype;
	}
	public void setListType(ims.ocrr.vo.lookups.SpecimenCollectionMethod value)
	{
		this.isValidated = false;
		this.listtype = value;
	}
	public boolean getCollectionStatusIsNotNull()
	{
		return this.collectionstatus != null;
	}
	public ims.ocrr.vo.lookups.SpecimenCollectionStatus getCollectionStatus()
	{
		return this.collectionstatus;
	}
	public void setCollectionStatus(ims.ocrr.vo.lookups.SpecimenCollectionStatus value)
	{
		this.isValidated = false;
		this.collectionstatus = value;
	}
	public boolean getReasonIsNotNull()
	{
		return this.reason != null;
	}
	public String getReason()
	{
		return this.reason;
	}
	public static int getReasonMaxLength()
	{
		return 255;
	}
	public void setReason(String value)
	{
		this.isValidated = false;
		this.reason = value;
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
	
		SpecimenCollectionStatusVo clone = new SpecimenCollectionStatusVo(this.id, this.version);
		
		if(this.listtype == null)
			clone.listtype = null;
		else
			clone.listtype = (ims.ocrr.vo.lookups.SpecimenCollectionMethod)this.listtype.clone();
		if(this.collectionstatus == null)
			clone.collectionstatus = null;
		else
			clone.collectionstatus = (ims.ocrr.vo.lookups.SpecimenCollectionStatus)this.collectionstatus.clone();
		clone.reason = this.reason;
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
		if (!(SpecimenCollectionStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SpecimenCollectionStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SpecimenCollectionStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SpecimenCollectionStatusVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.listtype != null)
			count++;
		if(this.collectionstatus != null)
			count++;
		if(this.reason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.ocrr.vo.lookups.SpecimenCollectionMethod listtype;
	protected ims.ocrr.vo.lookups.SpecimenCollectionStatus collectionstatus;
	protected String reason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
