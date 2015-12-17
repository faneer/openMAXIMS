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

/**
 * Linked to core.charting.ChartTypeDataset business object (ID: 1081100002).
 */
public class ChartTypeDatasetVo extends ims.core.charting.vo.ChartTypeDatasetRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChartTypeDatasetVo()
	{
	}
	public ChartTypeDatasetVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChartTypeDatasetVo(ims.core.vo.beans.ChartTypeDatasetVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datasettype = bean.getDatasetType() == null ? null : bean.getDatasetType().buildVo();
		this.linetype = bean.getLineType() == null ? null : ims.core.vo.lookups.LineType.buildLookup(bean.getLineType());
		this.linecolourpointicon = bean.getLineColourPointIcon() == null ? null : ims.core.vo.lookups.LineColourPointIcon.buildLookup(bean.getLineColourPointIcon());
		this.sortorder = bean.getSortOrder();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartTypeDatasetVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datasettype = bean.getDatasetType() == null ? null : bean.getDatasetType().buildVo(map);
		this.linetype = bean.getLineType() == null ? null : ims.core.vo.lookups.LineType.buildLookup(bean.getLineType());
		this.linecolourpointicon = bean.getLineColourPointIcon() == null ? null : ims.core.vo.lookups.LineColourPointIcon.buildLookup(bean.getLineColourPointIcon());
		this.sortorder = bean.getSortOrder();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartTypeDatasetVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartTypeDatasetVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartTypeDatasetVoBean();
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
		if(fieldName.equals("DATASETTYPE"))
			return getDatasetType();
		if(fieldName.equals("LINETYPE"))
			return getLineType();
		if(fieldName.equals("LINECOLOURPOINTICON"))
			return getLineColourPointIcon();
		if(fieldName.equals("SORTORDER"))
			return getSortOrder();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDatasetTypeIsNotNull()
	{
		return this.datasettype != null;
	}
	public ims.core.vo.DataSetTypeVo getDatasetType()
	{
		return this.datasettype;
	}
	public void setDatasetType(ims.core.vo.DataSetTypeVo value)
	{
		this.isValidated = false;
		this.datasettype = value;
	}
	public boolean getLineTypeIsNotNull()
	{
		return this.linetype != null;
	}
	public ims.core.vo.lookups.LineType getLineType()
	{
		return this.linetype;
	}
	public void setLineType(ims.core.vo.lookups.LineType value)
	{
		this.isValidated = false;
		this.linetype = value;
	}
	public boolean getLineColourPointIconIsNotNull()
	{
		return this.linecolourpointicon != null;
	}
	public ims.core.vo.lookups.LineColourPointIcon getLineColourPointIcon()
	{
		return this.linecolourpointicon;
	}
	public void setLineColourPointIcon(ims.core.vo.lookups.LineColourPointIcon value)
	{
		this.isValidated = false;
		this.linecolourpointicon = value;
	}
	public boolean getSortOrderIsNotNull()
	{
		return this.sortorder != null;
	}
	public Integer getSortOrder()
	{
		return this.sortorder;
	}
	public void setSortOrder(Integer value)
	{
		this.isValidated = false;
		this.sortorder = value;
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
		if(this.datasettype != null)
		{
			if(!this.datasettype.isValidated())
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
		if(this.datasettype == null)
			listOfErrors.add("DatasetType is mandatory");
		if(this.datasettype != null)
		{
			String[] listOfOtherErrors = this.datasettype.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		ChartTypeDatasetVo clone = new ChartTypeDatasetVo(this.id, this.version);
		
		if(this.datasettype == null)
			clone.datasettype = null;
		else
			clone.datasettype = (ims.core.vo.DataSetTypeVo)this.datasettype.clone();
		if(this.linetype == null)
			clone.linetype = null;
		else
			clone.linetype = (ims.core.vo.lookups.LineType)this.linetype.clone();
		if(this.linecolourpointicon == null)
			clone.linecolourpointicon = null;
		else
			clone.linecolourpointicon = (ims.core.vo.lookups.LineColourPointIcon)this.linecolourpointicon.clone();
		clone.sortorder = this.sortorder;
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
		if (!(ChartTypeDatasetVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartTypeDatasetVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChartTypeDatasetVo compareObj = (ChartTypeDatasetVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ChartTypeDataset() == null && compareObj.getID_ChartTypeDataset() != null)
				return -1;
			if(this.getID_ChartTypeDataset() != null && compareObj.getID_ChartTypeDataset() == null)
				return 1;
			if(this.getID_ChartTypeDataset() != null && compareObj.getID_ChartTypeDataset() != null)
				retVal = this.getID_ChartTypeDataset().compareTo(compareObj.getID_ChartTypeDataset());
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
		if(this.datasettype != null)
			count++;
		if(this.linetype != null)
			count++;
		if(this.linecolourpointicon != null)
			count++;
		if(this.sortorder != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.DataSetTypeVo datasettype;
	protected ims.core.vo.lookups.LineType linetype;
	protected ims.core.vo.lookups.LineColourPointIcon linecolourpointicon;
	protected Integer sortorder;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
