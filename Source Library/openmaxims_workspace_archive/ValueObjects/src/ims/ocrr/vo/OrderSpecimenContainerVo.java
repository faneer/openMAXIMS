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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderSpecimenContainer business object (ID: 1070100014).
 */
public class OrderSpecimenContainerVo extends ims.ocrr.orderingresults.vo.OrderSpecimenContainerRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderSpecimenContainerVo()
	{
	}
	public OrderSpecimenContainerVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderSpecimenContainerVo(ims.ocrr.vo.beans.OrderSpecimenContainerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.container = bean.getContainer() == null ? null : new ims.ocrr.configuration.vo.PathSpecimenContainerRefVo(new Integer(bean.getContainer().getId()), bean.getContainer().getVersion());
		this.containerquantity = bean.getContainerQuantity();
		this.investigationnames = bean.getInvestigationNames();
		this.labelsuffix = bean.getLabelSuffix();
		this.orderinvestigation = ims.ocrr.vo.OrderInvestigationVoCollection.buildFromBeanCollection(bean.getOrderInvestigation());
		this.requiredvolume = bean.getRequiredVolume();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderSpecimenContainerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.container = bean.getContainer() == null ? null : new ims.ocrr.configuration.vo.PathSpecimenContainerRefVo(new Integer(bean.getContainer().getId()), bean.getContainer().getVersion());
		this.containerquantity = bean.getContainerQuantity();
		this.investigationnames = bean.getInvestigationNames();
		this.labelsuffix = bean.getLabelSuffix();
		this.orderinvestigation = ims.ocrr.vo.OrderInvestigationVoCollection.buildFromBeanCollection(bean.getOrderInvestigation());
		this.requiredvolume = bean.getRequiredVolume();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderSpecimenContainerVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderSpecimenContainerVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderSpecimenContainerVoBean();
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
		if(fieldName.equals("CONTAINER"))
			return getContainer();
		if(fieldName.equals("CONTAINERQUANTITY"))
			return getContainerQuantity();
		if(fieldName.equals("INVESTIGATIONNAMES"))
			return getInvestigationNames();
		if(fieldName.equals("LABELSUFFIX"))
			return getLabelSuffix();
		if(fieldName.equals("ORDERINVESTIGATION"))
			return getOrderInvestigation();
		if(fieldName.equals("REQUIREDVOLUME"))
			return getRequiredVolume();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getContainerIsNotNull()
	{
		return this.container != null;
	}
	public ims.ocrr.configuration.vo.PathSpecimenContainerRefVo getContainer()
	{
		return this.container;
	}
	public void setContainer(ims.ocrr.configuration.vo.PathSpecimenContainerRefVo value)
	{
		this.isValidated = false;
		this.container = value;
	}
	public boolean getContainerQuantityIsNotNull()
	{
		return this.containerquantity != null;
	}
	public Integer getContainerQuantity()
	{
		return this.containerquantity;
	}
	public void setContainerQuantity(Integer value)
	{
		this.isValidated = false;
		this.containerquantity = value;
	}
	public boolean getInvestigationNamesIsNotNull()
	{
		return this.investigationnames != null;
	}
	public String getInvestigationNames()
	{
		return this.investigationnames;
	}
	public static int getInvestigationNamesMaxLength()
	{
		return 2000;
	}
	public void setInvestigationNames(String value)
	{
		this.isValidated = false;
		this.investigationnames = value;
	}
	public boolean getLabelSuffixIsNotNull()
	{
		return this.labelsuffix != null;
	}
	public String getLabelSuffix()
	{
		return this.labelsuffix;
	}
	public static int getLabelSuffixMaxLength()
	{
		return 10;
	}
	public void setLabelSuffix(String value)
	{
		this.isValidated = false;
		this.labelsuffix = value;
	}
	public boolean getOrderInvestigationIsNotNull()
	{
		return this.orderinvestigation != null;
	}
	public ims.ocrr.vo.OrderInvestigationVoCollection getOrderInvestigation()
	{
		return this.orderinvestigation;
	}
	public void setOrderInvestigation(ims.ocrr.vo.OrderInvestigationVoCollection value)
	{
		this.isValidated = false;
		this.orderinvestigation = value;
	}
	public boolean getRequiredVolumeIsNotNull()
	{
		return this.requiredvolume != null;
	}
	public Float getRequiredVolume()
	{
		return this.requiredvolume;
	}
	public void setRequiredVolume(Float value)
	{
		this.isValidated = false;
		this.requiredvolume = value;
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
		if(this.orderinvestigation != null)
		{
			if(!this.orderinvestigation.isValidated())
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
		if(this.investigationnames != null)
			if(this.investigationnames.length() > 2000)
				listOfErrors.add("Maximum number of Investigations reached.");
		if(this.labelsuffix != null)
			if(this.labelsuffix.length() > 10)
				listOfErrors.add("The length of the field [labelsuffix] in the value object [ims.ocrr.vo.OrderSpecimenContainerVo] is too big. It should be less or equal to 10");
		if(this.orderinvestigation != null)
		{
			String[] listOfOtherErrors = this.orderinvestigation.validate();
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
	
		OrderSpecimenContainerVo clone = new OrderSpecimenContainerVo(this.id, this.version);
		
		clone.container = this.container;
		clone.containerquantity = this.containerquantity;
		clone.investigationnames = this.investigationnames;
		clone.labelsuffix = this.labelsuffix;
		if(this.orderinvestigation == null)
			clone.orderinvestigation = null;
		else
			clone.orderinvestigation = (ims.ocrr.vo.OrderInvestigationVoCollection)this.orderinvestigation.clone();
		clone.requiredvolume = this.requiredvolume;
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
		if (!(OrderSpecimenContainerVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderSpecimenContainerVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OrderSpecimenContainerVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OrderSpecimenContainerVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.container != null)
			count++;
		if(this.containerquantity != null)
			count++;
		if(this.investigationnames != null)
			count++;
		if(this.labelsuffix != null)
			count++;
		if(this.orderinvestigation != null)
			count++;
		if(this.requiredvolume != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.ocrr.configuration.vo.PathSpecimenContainerRefVo container;
	protected Integer containerquantity;
	protected String investigationnames;
	protected String labelsuffix;
	protected ims.ocrr.vo.OrderInvestigationVoCollection orderinvestigation;
	protected Float requiredvolume;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
