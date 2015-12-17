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

package ims.therapies.vo;

/**
 * Linked to therapies.homeAndEnvironmentalVisit.VisitAssessmentComponent business object (ID: 1019100090).
 */
public class BathingFacilityVo extends ims.therapies.vo.VisitAssessmentComponentVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BathingFacilityVo()
	{
	}
	public BathingFacilityVo(Integer id, int version)
	{
		super(id, version);
	}
	public BathingFacilityVo(ims.therapies.vo.beans.BathingFacilityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.spinalinjuries.vo.lookups.EnvironmentalHomeVisitComponentType.buildLookup(bean.getType());
		this.details = bean.getDetails();
		this.shorttermplan = bean.getShortTermPlan();
		this.longtermplan = bean.getLongTermPlan();
		this.bathheight = bean.getBathHeight();
		this.bathwidth = bean.getBathWidth();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.BathingFacilityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.spinalinjuries.vo.lookups.EnvironmentalHomeVisitComponentType.buildLookup(bean.getType());
		this.details = bean.getDetails();
		this.shorttermplan = bean.getShortTermPlan();
		this.longtermplan = bean.getLongTermPlan();
		this.bathheight = bean.getBathHeight();
		this.bathwidth = bean.getBathWidth();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.BathingFacilityVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.BathingFacilityVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.BathingFacilityVoBean();
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
		if(fieldName.equals("BATHHEIGHT"))
			return getBathHeight();
		if(fieldName.equals("BATHWIDTH"))
			return getBathWidth();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBathHeightIsNotNull()
	{
		return this.bathheight != null;
	}
	public Integer getBathHeight()
	{
		return this.bathheight;
	}
	public void setBathHeight(Integer value)
	{
		this.isValidated = false;
		this.bathheight = value;
	}
	public boolean getBathWidthIsNotNull()
	{
		return this.bathwidth != null;
	}
	public Integer getBathWidth()
	{
		return this.bathwidth;
	}
	public void setBathWidth(Integer value)
	{
		this.isValidated = false;
		this.bathwidth = value;
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
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
		if(this.details != null)
			if(this.details.length() > 500)
				listOfErrors.add("The field Details is too long. Please reduce it");
		if(this.shorttermplan != null)
			if(this.shorttermplan.length() > 250)
				listOfErrors.add("The field ShortTermPlan is too long. Please reduce it");
		if(this.longtermplan != null)
			if(this.longtermplan.length() > 250)
				listOfErrors.add("The length of the field [longtermplan] in the value object [ims.therapies.vo.BathingFacilityVo] is too big. It should be less or equal to 250");
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
	
		BathingFacilityVo clone = new BathingFacilityVo(this.id, this.version);
		
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.spinalinjuries.vo.lookups.EnvironmentalHomeVisitComponentType)this.type.clone();
		clone.details = this.details;
		clone.shorttermplan = this.shorttermplan;
		clone.longtermplan = this.longtermplan;
		clone.bathheight = this.bathheight;
		clone.bathwidth = this.bathwidth;
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
		if (!(BathingFacilityVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BathingFacilityVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BathingFacilityVo compareObj = (BathingFacilityVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_VisitAssessmentComponent() == null && compareObj.getID_VisitAssessmentComponent() != null)
				return -1;
			if(this.getID_VisitAssessmentComponent() != null && compareObj.getID_VisitAssessmentComponent() == null)
				return 1;
			if(this.getID_VisitAssessmentComponent() != null && compareObj.getID_VisitAssessmentComponent() != null)
				retVal = this.getID_VisitAssessmentComponent().compareTo(compareObj.getID_VisitAssessmentComponent());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.bathheight != null)
			count++;
		if(this.bathwidth != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected Integer bathheight;
	protected Integer bathwidth;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
