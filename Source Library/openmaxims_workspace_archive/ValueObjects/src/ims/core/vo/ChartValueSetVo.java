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


public class ChartValueSetVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IChartValueSet
{
	private static final long serialVersionUID = 1L;

	public ChartValueSetVo()
	{
	}
	public ChartValueSetVo(ims.core.vo.beans.ChartValueSetVoBean bean)
	{
		this.maxfactor = bean.getMaxFactor();
		this.minfactor = bean.getMinFactor();
		this.belowbandpercent = bean.getBelowBandPercent();
		this.abovebandpercent = bean.getAboveBandPercent();
		this.groups = ims.core.vo.ChartValueGroupVoCollection.buildFromBeanCollection(bean.getGroups());
		this.title = bean.getTitle();
		this.subtitle = bean.getSubTitle();
		this.normalbandcolor = bean.getNormalBandColor() == null ? null : bean.getNormalBandColor().buildColor();
		this.backgroundcolor = bean.getBackgroundColor() == null ? null : bean.getBackgroundColor().buildColor();
		this.foregroundcolor = bean.getForegroundColor() == null ? null : bean.getForegroundColor().buildColor();
		this.description = bean.getDescription();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartValueSetVoBean bean)
	{
		this.maxfactor = bean.getMaxFactor();
		this.minfactor = bean.getMinFactor();
		this.belowbandpercent = bean.getBelowBandPercent();
		this.abovebandpercent = bean.getAboveBandPercent();
		this.groups = ims.core.vo.ChartValueGroupVoCollection.buildFromBeanCollection(bean.getGroups());
		this.title = bean.getTitle();
		this.subtitle = bean.getSubTitle();
		this.normalbandcolor = bean.getNormalBandColor() == null ? null : bean.getNormalBandColor().buildColor();
		this.backgroundcolor = bean.getBackgroundColor() == null ? null : bean.getBackgroundColor().buildColor();
		this.foregroundcolor = bean.getForegroundColor() == null ? null : bean.getForegroundColor().buildColor();
		this.description = bean.getDescription();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartValueSetVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartValueSetVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartValueSetVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getMaxFactorIsNotNull()
	{
		return this.maxfactor != null;
	}
	public Integer getMaxFactor()
	{
		return this.maxfactor;
	}
	public void setMaxFactor(Integer value)
	{
		this.isValidated = false;
		this.maxfactor = value;
	}
	public boolean getMinFactorIsNotNull()
	{
		return this.minfactor != null;
	}
	public Integer getMinFactor()
	{
		return this.minfactor;
	}
	public void setMinFactor(Integer value)
	{
		this.isValidated = false;
		this.minfactor = value;
	}
	public boolean getBelowBandPercentIsNotNull()
	{
		return this.belowbandpercent != null;
	}
	public Integer getBelowBandPercent()
	{
		return this.belowbandpercent;
	}
	public void setBelowBandPercent(Integer value)
	{
		this.isValidated = false;
		this.belowbandpercent = value;
	}
	public boolean getAboveBandPercentIsNotNull()
	{
		return this.abovebandpercent != null;
	}
	public Integer getAboveBandPercent()
	{
		return this.abovebandpercent;
	}
	public void setAboveBandPercent(Integer value)
	{
		this.isValidated = false;
		this.abovebandpercent = value;
	}
	public boolean getGroupsIsNotNull()
	{
		return this.groups != null;
	}
	public ims.core.vo.ChartValueGroupVoCollection getGroups()
	{
		return this.groups;
	}
	public void setGroups(ims.core.vo.ChartValueGroupVoCollection value)
	{
		this.isValidated = false;
		this.groups = value;
	}
	public boolean getTitleIsNotNull()
	{
		return this.title != null;
	}
	public String getTitle()
	{
		return this.title;
	}
	public static int getTitleMaxLength()
	{
		return 255;
	}
	public void setTitle(String value)
	{
		this.isValidated = false;
		this.title = value;
	}
	public boolean getSubTitleIsNotNull()
	{
		return this.subtitle != null;
	}
	public String getSubTitle()
	{
		return this.subtitle;
	}
	public static int getSubTitleMaxLength()
	{
		return 255;
	}
	public void setSubTitle(String value)
	{
		this.isValidated = false;
		this.subtitle = value;
	}
	public boolean getNormalBandColorIsNotNull()
	{
		return this.normalbandcolor != null;
	}
	public ims.framework.utils.Color getNormalBandColor()
	{
		return this.normalbandcolor;
	}
	public void setNormalBandColor(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.normalbandcolor = value;
	}
	public boolean getBackgroundColorIsNotNull()
	{
		return this.backgroundcolor != null;
	}
	public ims.framework.utils.Color getBackgroundColor()
	{
		return this.backgroundcolor;
	}
	public void setBackgroundColor(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.backgroundcolor = value;
	}
	public boolean getForegroundColorIsNotNull()
	{
		return this.foregroundcolor != null;
	}
	public ims.framework.utils.Color getForegroundColor()
	{
		return this.foregroundcolor;
	}
	public void setForegroundColor(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.foregroundcolor = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
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
	/**
	* IChartValueSet methods
	*/
	public ims.vo.interfaces.IChartValueGroup[] getIChartValueSetGroups()
	{
		if(getGroups() == null)
			return null;		
		int size = getGroups().size();		
		ims.vo.interfaces.IChartValueGroup[] result = new ims.vo.interfaces.IChartValueGroup[size];		
		for(int x = 0; x < size; x++)
		{
			result[x] = getGroups().get(x);
		}		
		return result;
	}
	public Integer getIChartValueSetMaxFactor() 
	{		
		return getMaxFactor();
	}
	public Integer getIChartValueSetMinFactor() 
	{
		return getMinFactor();
	}
	public Integer getIChartValueSetBelowBandPercent() 
	{
		return getBelowBandPercent();
	}
	public Integer getIChartValueSetAboveBandPercent() 
	{
		return getAboveBandPercent();
	}
	public String getIChartValueSetTitle()
	{
		return getTitle();
	}
	public String getIChartValueSetSubTitle()
	{
		return getSubTitle();
	}
	public ims.framework.utils.Color getIChartValueSetNormalBandColor() 
	{
		return getNormalBandColor();
	}
	public String getIChartValueSetDescription() 
	{
		return getDescription();
	}
	public ims.framework.utils.Color getIChartValueSetBackgroundColor() 
	{
		return getBackgroundColor();
	}
	public ims.framework.utils.Color getIChartValueSetForegroundColor() 
	{
		return getForegroundColor();
	}
	
	//WDEV-12548
	public void setIChartValueSetGroups(ims.vo.interfaces.IChartValueGroup[] group)
	{
		if(group == null || group.length == 0)
			return;	
			
		int size = group.length;		
		ChartValueGroupVoCollection result = new ChartValueGroupVoCollection();
			
		for(int x = 0; x < size; x++)
		{
			if( group[x] instanceof ChartValueGroupVo)
			{
				result.add((ChartValueGroupVo) group[x]);
			}
		}
			
		setGroups(result);
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
		if(this.groups != null)
		{
			if(!this.groups.isValidated())
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
		if(this.maxfactor == null)
			listOfErrors.add("Chart max factor is invalid");
		if(this.minfactor == null)
			listOfErrors.add("Chart min factor is invalid");
		if(this.belowbandpercent == null)
			listOfErrors.add("Chart below band percent is invalid");
		if(this.belowbandpercent != null && (this.belowbandpercent.intValue() < 0 || this.belowbandpercent.intValue() > 100))
			listOfErrors.add("The field [belowbandpercent] in the value object [ims.core.vo.ChartValueSetVo] has an invalid value. The valid range of values is between 0 and 100");
		if(this.abovebandpercent == null)
			listOfErrors.add("Chart above band percent is invalid");
		if(this.abovebandpercent != null && (this.abovebandpercent.intValue() < 0 || this.abovebandpercent.intValue() > 100))
			listOfErrors.add("The field [abovebandpercent] in the value object [ims.core.vo.ChartValueSetVo] has an invalid value. The valid range of values is between 0 and 100");
		if(this.groups != null)
		{
			String[] listOfOtherErrors = this.groups.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.title == null || this.title.length() == 0)
			listOfErrors.add("Chart title is invalid");
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
	
		ChartValueSetVo clone = new ChartValueSetVo();
		
		clone.maxfactor = this.maxfactor;
		clone.minfactor = this.minfactor;
		clone.belowbandpercent = this.belowbandpercent;
		clone.abovebandpercent = this.abovebandpercent;
		if(this.groups == null)
			clone.groups = null;
		else
			clone.groups = (ims.core.vo.ChartValueGroupVoCollection)this.groups.clone();
		clone.title = this.title;
		clone.subtitle = this.subtitle;
		if(this.normalbandcolor == null)
			clone.normalbandcolor = null;
		else
			clone.normalbandcolor = (ims.framework.utils.Color)this.normalbandcolor.clone();
		if(this.backgroundcolor == null)
			clone.backgroundcolor = null;
		else
			clone.backgroundcolor = (ims.framework.utils.Color)this.backgroundcolor.clone();
		if(this.foregroundcolor == null)
			clone.foregroundcolor = null;
		else
			clone.foregroundcolor = (ims.framework.utils.Color)this.foregroundcolor.clone();
		clone.description = this.description;
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
		if (!(ChartValueSetVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartValueSetVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChartValueSetVo compareObj = (ChartValueSetVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getMaxFactor() == null && compareObj.getMaxFactor() != null)
				return -1;
			if(this.getMaxFactor() != null && compareObj.getMaxFactor() == null)
				return 1;
			if(this.getMaxFactor() != null && compareObj.getMaxFactor() != null)
				retVal = this.getMaxFactor().compareTo(compareObj.getMaxFactor());
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
		if(this.maxfactor != null)
			count++;
		if(this.minfactor != null)
			count++;
		if(this.belowbandpercent != null)
			count++;
		if(this.abovebandpercent != null)
			count++;
		if(this.groups != null)
			count++;
		if(this.title != null)
			count++;
		if(this.subtitle != null)
			count++;
		if(this.normalbandcolor != null)
			count++;
		if(this.backgroundcolor != null)
			count++;
		if(this.foregroundcolor != null)
			count++;
		if(this.description != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected Integer maxfactor;
	protected Integer minfactor;
	protected Integer belowbandpercent;
	protected Integer abovebandpercent;
	protected ims.core.vo.ChartValueGroupVoCollection groups;
	protected String title;
	protected String subtitle;
	protected ims.framework.utils.Color normalbandcolor;
	protected ims.framework.utils.Color backgroundcolor;
	protected ims.framework.utils.Color foregroundcolor;
	protected String description;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
