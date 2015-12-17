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

package ims.emergency.vo;


public class FlashingKPITextCoulourVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FlashingKPITextCoulourVo()
	{
	}
	public FlashingKPITextCoulourVo(ims.emergency.vo.beans.FlashingKPITextCoulourVoBean bean)
	{
		this.breachwarningflashingtest = bean.getBreachWarningFlashingTest() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachWarningFlashingTest());
		this.breachedkpiflashingtext = bean.getBreachedKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachedKPIFlashingText());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.FlashingKPITextCoulourVoBean bean)
	{
		this.breachwarningflashingtest = bean.getBreachWarningFlashingTest() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachWarningFlashingTest());
		this.breachedkpiflashingtext = bean.getBreachedKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachedKPIFlashingText());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.FlashingKPITextCoulourVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.FlashingKPITextCoulourVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.FlashingKPITextCoulourVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getBreachWarningFlashingTestIsNotNull()
	{
		return this.breachwarningflashingtest != null;
	}
	public ims.core.vo.lookups.YesNo getBreachWarningFlashingTest()
	{
		return this.breachwarningflashingtest;
	}
	public void setBreachWarningFlashingTest(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.breachwarningflashingtest = value;
	}
	public boolean getBreachedKPIFlashingTextIsNotNull()
	{
		return this.breachedkpiflashingtext != null;
	}
	public ims.core.vo.lookups.YesNo getBreachedKPIFlashingText()
	{
		return this.breachedkpiflashingtext;
	}
	public void setBreachedKPIFlashingText(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.breachedkpiflashingtext = value;
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
		if(!(obj instanceof FlashingKPITextCoulourVo))
			return false;
		FlashingKPITextCoulourVo compareObj = (FlashingKPITextCoulourVo)obj;
		if(this.getBreachWarningFlashingTest() == null && compareObj.getBreachWarningFlashingTest() != null)
			return false;
		if(this.getBreachWarningFlashingTest() != null && compareObj.getBreachWarningFlashingTest() == null)
			return false;
		if(this.getBreachWarningFlashingTest() != null && compareObj.getBreachWarningFlashingTest() != null)
			return this.getBreachWarningFlashingTest().equals(compareObj.getBreachWarningFlashingTest());
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
	
		FlashingKPITextCoulourVo clone = new FlashingKPITextCoulourVo();
		
		if(this.breachwarningflashingtest == null)
			clone.breachwarningflashingtest = null;
		else
			clone.breachwarningflashingtest = (ims.core.vo.lookups.YesNo)this.breachwarningflashingtest.clone();
		if(this.breachedkpiflashingtext == null)
			clone.breachedkpiflashingtext = null;
		else
			clone.breachedkpiflashingtext = (ims.core.vo.lookups.YesNo)this.breachedkpiflashingtext.clone();
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
		if (!(FlashingKPITextCoulourVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FlashingKPITextCoulourVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		FlashingKPITextCoulourVo compareObj = (FlashingKPITextCoulourVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getBreachWarningFlashingTest() == null && compareObj.getBreachWarningFlashingTest() != null)
				return -1;
			if(this.getBreachWarningFlashingTest() != null && compareObj.getBreachWarningFlashingTest() == null)
				return 1;
			if(this.getBreachWarningFlashingTest() != null && compareObj.getBreachWarningFlashingTest() != null)
				retVal = this.getBreachWarningFlashingTest().compareTo(compareObj.getBreachWarningFlashingTest());
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
		if(this.breachwarningflashingtest != null)
			count++;
		if(this.breachedkpiflashingtext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.lookups.YesNo breachwarningflashingtest;
	protected ims.core.vo.lookups.YesNo breachedkpiflashingtext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
