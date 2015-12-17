//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.generalmedical.vo;

/**
 * Linked to medical.NeuroReflexesPeripheralFindings business object (ID: 1023100019).
 */
public class NeuroReflexPeripheralTestsVo extends ims.medical.vo.NeuroReflexesPeripheralFindingsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NeuroReflexPeripheralTestsVo()
	{
	}
	public NeuroReflexPeripheralTestsVo(Integer id, int version)
	{
		super(id, version);
	}
	public NeuroReflexPeripheralTestsVo(ims.generalmedical.vo.beans.NeuroReflexPeripheralTestsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.peripheralreflex = bean.getPeripheralReflex() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests.buildLookup(bean.getPeripheralReflex());
		this.rightfinding = bean.getRightFinding() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests.buildLookup(bean.getRightFinding());
		this.leftfinding = bean.getLeftFinding() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests.buildLookup(bean.getLeftFinding());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.NeuroReflexPeripheralTestsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.peripheralreflex = bean.getPeripheralReflex() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests.buildLookup(bean.getPeripheralReflex());
		this.rightfinding = bean.getRightFinding() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests.buildLookup(bean.getRightFinding());
		this.leftfinding = bean.getLeftFinding() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests.buildLookup(bean.getLeftFinding());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.NeuroReflexPeripheralTestsVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.NeuroReflexPeripheralTestsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.NeuroReflexPeripheralTestsVoBean();
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
		if(fieldName.equals("PERIPHERALREFLEX"))
			return getPeripheralReflex();
		if(fieldName.equals("RIGHTFINDING"))
			return getRightFinding();
		if(fieldName.equals("LEFTFINDING"))
			return getLeftFinding();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPeripheralReflexIsNotNull()
	{
		return this.peripheralreflex != null;
	}
	public ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests getPeripheralReflex()
	{
		return this.peripheralreflex;
	}
	public void setPeripheralReflex(ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests value)
	{
		this.isValidated = false;
		this.peripheralreflex = value;
	}
	public boolean getRightFindingIsNotNull()
	{
		return this.rightfinding != null;
	}
	public ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests getRightFinding()
	{
		return this.rightfinding;
	}
	public void setRightFinding(ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests value)
	{
		this.isValidated = false;
		this.rightfinding = value;
	}
	public boolean getLeftFindingIsNotNull()
	{
		return this.leftfinding != null;
	}
	public ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests getLeftFinding()
	{
		return this.leftfinding;
	}
	public void setLeftFinding(ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests value)
	{
		this.isValidated = false;
		this.leftfinding = value;
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
		if(this.peripheralreflex == null)
			listOfErrors.add("peripheralReflex is mandatory");
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
	
		NeuroReflexPeripheralTestsVo clone = new NeuroReflexPeripheralTestsVo(this.id, this.version);
		
		if(this.peripheralreflex == null)
			clone.peripheralreflex = null;
		else
			clone.peripheralreflex = (ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests)this.peripheralreflex.clone();
		if(this.rightfinding == null)
			clone.rightfinding = null;
		else
			clone.rightfinding = (ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests)this.rightfinding.clone();
		if(this.leftfinding == null)
			clone.leftfinding = null;
		else
			clone.leftfinding = (ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests)this.leftfinding.clone();
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
		if (!(NeuroReflexPeripheralTestsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NeuroReflexPeripheralTestsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NeuroReflexPeripheralTestsVo compareObj = (NeuroReflexPeripheralTestsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_NeuroReflexesPeripheralFindings() == null && compareObj.getID_NeuroReflexesPeripheralFindings() != null)
				return -1;
			if(this.getID_NeuroReflexesPeripheralFindings() != null && compareObj.getID_NeuroReflexesPeripheralFindings() == null)
				return 1;
			if(this.getID_NeuroReflexesPeripheralFindings() != null && compareObj.getID_NeuroReflexesPeripheralFindings() != null)
				retVal = this.getID_NeuroReflexesPeripheralFindings().compareTo(compareObj.getID_NeuroReflexesPeripheralFindings());
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
		if(this.peripheralreflex != null)
			count++;
		if(this.rightfinding != null)
			count++;
		if(this.leftfinding != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests peripheralreflex;
	protected ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests rightfinding;
	protected ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests leftfinding;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
