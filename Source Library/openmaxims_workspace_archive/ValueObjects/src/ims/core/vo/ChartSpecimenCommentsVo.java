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

package ims.core.vo;


public class ChartSpecimenCommentsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChartSpecimenCommentsVo()
	{
	}
	public ChartSpecimenCommentsVo(ims.core.vo.beans.ChartSpecimenCommentsVoBean bean)
	{
		this.specimentype = bean.getSpecimenType();
		this.specimencomments = ims.core.vo.ChartValueCommentVoCollection.buildFromBeanCollection(bean.getSpecimenComments());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartSpecimenCommentsVoBean bean)
	{
		this.specimentype = bean.getSpecimenType();
		this.specimencomments = ims.core.vo.ChartValueCommentVoCollection.buildFromBeanCollection(bean.getSpecimenComments());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartSpecimenCommentsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartSpecimenCommentsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartSpecimenCommentsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSpecimenTypeIsNotNull()
	{
		return this.specimentype != null;
	}
	public String getSpecimenType()
	{
		return this.specimentype;
	}
	public static int getSpecimenTypeMaxLength()
	{
		return 255;
	}
	public void setSpecimenType(String value)
	{
		this.isValidated = false;
		this.specimentype = value;
	}
	public boolean getSpecimenCommentsIsNotNull()
	{
		return this.specimencomments != null;
	}
	public ims.core.vo.ChartValueCommentVoCollection getSpecimenComments()
	{
		return this.specimencomments;
	}
	public void setSpecimenComments(ims.core.vo.ChartValueCommentVoCollection value)
	{
		this.isValidated = false;
		this.specimencomments = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof ChartSpecimenCommentsVo))
			return false;
		ChartSpecimenCommentsVo compareObj = (ChartSpecimenCommentsVo)obj;
		if(this.getSpecimenType() == null && compareObj.getSpecimenType() != null)
			return false;
		if(this.getSpecimenType() != null && compareObj.getSpecimenType() == null)
			return false;
		if(this.getSpecimenType() != null && compareObj.getSpecimenType() != null)
			return this.getSpecimenType().equals(compareObj.getSpecimenType());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ChartSpecimenCommentsVo clone = new ChartSpecimenCommentsVo();
		
		clone.specimentype = this.specimentype;
		if(this.specimencomments == null)
			clone.specimencomments = null;
		else
			clone.specimencomments = (ims.core.vo.ChartValueCommentVoCollection)this.specimencomments.clone();
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
		if (!(ChartSpecimenCommentsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartSpecimenCommentsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChartSpecimenCommentsVo compareObj = (ChartSpecimenCommentsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSpecimenType() == null && compareObj.getSpecimenType() != null)
				return -1;
			if(this.getSpecimenType() != null && compareObj.getSpecimenType() == null)
				return 1;
			if(this.getSpecimenType() != null && compareObj.getSpecimenType() != null)
			{
				if(caseInsensitive)
					retVal = this.getSpecimenType().toLowerCase().compareTo(compareObj.getSpecimenType().toLowerCase());
				else
					retVal = this.getSpecimenType().compareTo(compareObj.getSpecimenType());
			}
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
		if(this.specimentype != null)
			count++;
		if(this.specimencomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String specimentype;
	protected ims.core.vo.ChartValueCommentVoCollection specimencomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
