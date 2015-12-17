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
 * Linked to core.admin.pas.TrackingMovement business object (ID: 1014100030).
 */
public class TrackingMovementLiteVo extends ims.core.admin.pas.vo.TrackingMovementRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingMovementLiteVo()
	{
	}
	public TrackingMovementLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingMovementLiteVo(ims.core.vo.beans.TrackingMovementLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.movementtype = bean.getMovementType() == null ? null : ims.core.vo.lookups.TrackingMovementType.buildLookup(bean.getMovementType());
		this.patientreturned = bean.getPatientReturned();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.TrackingMovementLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.movementtype = bean.getMovementType() == null ? null : ims.core.vo.lookups.TrackingMovementType.buildLookup(bean.getMovementType());
		this.patientreturned = bean.getPatientReturned();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.TrackingMovementLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.TrackingMovementLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.TrackingMovementLiteVoBean();
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
		if(fieldName.equals("MOVEMENTTYPE"))
			return getMovementType();
		if(fieldName.equals("PATIENTRETURNED"))
			return getPatientReturned();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMovementTypeIsNotNull()
	{
		return this.movementtype != null;
	}
	public ims.core.vo.lookups.TrackingMovementType getMovementType()
	{
		return this.movementtype;
	}
	public void setMovementType(ims.core.vo.lookups.TrackingMovementType value)
	{
		this.isValidated = false;
		this.movementtype = value;
	}
	public boolean getPatientReturnedIsNotNull()
	{
		return this.patientreturned != null;
	}
	public Boolean getPatientReturned()
	{
		return this.patientreturned;
	}
	public void setPatientReturned(Boolean value)
	{
		this.isValidated = false;
		this.patientreturned = value;
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
		if(this.movementtype == null)
			listOfErrors.add("MovementType is mandatory");
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
	
		TrackingMovementLiteVo clone = new TrackingMovementLiteVo(this.id, this.version);
		
		if(this.movementtype == null)
			clone.movementtype = null;
		else
			clone.movementtype = (ims.core.vo.lookups.TrackingMovementType)this.movementtype.clone();
		clone.patientreturned = this.patientreturned;
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
		if (!(TrackingMovementLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingMovementLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingMovementLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingMovementLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.movementtype != null)
			count++;
		if(this.patientreturned != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.lookups.TrackingMovementType movementtype;
	protected Boolean patientreturned;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
