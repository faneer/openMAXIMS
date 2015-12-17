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
 * Linked to emergency.EmergencyAttendanceInvestigationCodingSequenceItem business object (ID: 1086100041).
 */
public class EmergencyAttendanceInvestigationCodingSequenceItemVo extends ims.emergency.vo.EmergencyAttendanceInvestigationCodingSequenceItemRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceInvestigationCodingSequenceItemVo()
	{
	}
	public EmergencyAttendanceInvestigationCodingSequenceItemVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceInvestigationCodingSequenceItemVo(ims.emergency.vo.beans.EmergencyAttendanceInvestigationCodingSequenceItemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.orderinvestigation = bean.getOrderInvestigation();
		this.emergencyinvestigation = bean.getEmergencyInvestigation() == null ? null : new ims.emergency.vo.InvestigationAttendenceDetailRefVo(new Integer(bean.getEmergencyInvestigation().getId()), bean.getEmergencyInvestigation().getVersion());
		this.codingsequence = bean.getCodingSequence();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceInvestigationCodingSequenceItemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.orderinvestigation = bean.getOrderInvestigation();
		this.emergencyinvestigation = bean.getEmergencyInvestigation() == null ? null : new ims.emergency.vo.InvestigationAttendenceDetailRefVo(new Integer(bean.getEmergencyInvestigation().getId()), bean.getEmergencyInvestigation().getVersion());
		this.codingsequence = bean.getCodingSequence();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceInvestigationCodingSequenceItemVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceInvestigationCodingSequenceItemVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceInvestigationCodingSequenceItemVoBean();
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
		if(fieldName.equals("ORDERINVESTIGATION"))
			return getOrderInvestigation();
		if(fieldName.equals("EMERGENCYINVESTIGATION"))
			return getEmergencyInvestigation();
		if(fieldName.equals("CODINGSEQUENCE"))
			return getCodingSequence();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOrderInvestigationIsNotNull()
	{
		return this.orderinvestigation != null;
	}
	public Integer getOrderInvestigation()
	{
		return this.orderinvestigation;
	}
	public void setOrderInvestigation(Integer value)
	{
		this.isValidated = false;
		this.orderinvestigation = value;
	}
	public boolean getEmergencyInvestigationIsNotNull()
	{
		return this.emergencyinvestigation != null;
	}
	public ims.emergency.vo.InvestigationAttendenceDetailRefVo getEmergencyInvestigation()
	{
		return this.emergencyinvestigation;
	}
	public void setEmergencyInvestigation(ims.emergency.vo.InvestigationAttendenceDetailRefVo value)
	{
		this.isValidated = false;
		this.emergencyinvestigation = value;
	}
	public boolean getCodingSequenceIsNotNull()
	{
		return this.codingsequence != null;
	}
	public Integer getCodingSequence()
	{
		return this.codingsequence;
	}
	public void setCodingSequence(Integer value)
	{
		this.isValidated = false;
		this.codingsequence = value;
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
		if(this.codingsequence == null)
			listOfErrors.add("CodingSequence is mandatory");
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
	
		EmergencyAttendanceInvestigationCodingSequenceItemVo clone = new EmergencyAttendanceInvestigationCodingSequenceItemVo(this.id, this.version);
		
		clone.orderinvestigation = this.orderinvestigation;
		clone.emergencyinvestigation = this.emergencyinvestigation;
		clone.codingsequence = this.codingsequence;
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
		if (!(EmergencyAttendanceInvestigationCodingSequenceItemVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceInvestigationCodingSequenceItemVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EmergencyAttendanceInvestigationCodingSequenceItemVo compareObj = (EmergencyAttendanceInvestigationCodingSequenceItemVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCodingSequence() == null && compareObj.getCodingSequence() != null)
				return -1;
			if(this.getCodingSequence() != null && compareObj.getCodingSequence() == null)
				return 1;
			if(this.getCodingSequence() != null && compareObj.getCodingSequence() != null)
				retVal = this.getCodingSequence().compareTo(compareObj.getCodingSequence());
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
		if(this.orderinvestigation != null)
			count++;
		if(this.emergencyinvestigation != null)
			count++;
		if(this.codingsequence != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected Integer orderinvestigation;
	protected ims.emergency.vo.InvestigationAttendenceDetailRefVo emergencyinvestigation;
	protected Integer codingsequence;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
