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
 * Linked to OCRR.OrderingResults.PhlebotomyRound business object (ID: 1070100006).
 */
public class PhlebotomyRoundVo extends ims.ocrr.vo.PhlebotomyRoundShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PhlebotomyRoundVo()
	{
	}
	public PhlebotomyRoundVo(Integer id, int version)
	{
		super(id, version);
	}
	public PhlebotomyRoundVo(ims.ocrr.vo.beans.PhlebotomyRoundVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.collector = bean.getCollector() == null ? null : bean.getCollector().buildVo();
		this.wards = ims.core.vo.LocationLiteVoCollection.buildFromBeanCollection(bean.getWards());
		this.roundtocollect = bean.getRoundToCollect() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionTime.buildLookup(bean.getRoundToCollect());
		this.collectionitems = ims.ocrr.vo.SpecimenWorkListItemVoCollection.buildFromBeanCollection(bean.getCollectionItems());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PhlebotomyRoundVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.collector = bean.getCollector() == null ? null : bean.getCollector().buildVo(map);
		this.wards = ims.core.vo.LocationLiteVoCollection.buildFromBeanCollection(bean.getWards());
		this.roundtocollect = bean.getRoundToCollect() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionTime.buildLookup(bean.getRoundToCollect());
		this.collectionitems = ims.ocrr.vo.SpecimenWorkListItemVoCollection.buildFromBeanCollection(bean.getCollectionItems());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PhlebotomyRoundVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PhlebotomyRoundVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PhlebotomyRoundVoBean();
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
		if(fieldName.equals("COLLECTIONITEMS"))
			return getCollectionItems();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCollectionItemsIsNotNull()
	{
		return this.collectionitems != null;
	}
	public ims.ocrr.vo.SpecimenWorkListItemVoCollection getCollectionItems()
	{
		return this.collectionitems;
	}
	public void setCollectionItems(ims.ocrr.vo.SpecimenWorkListItemVoCollection value)
	{
		this.isValidated = false;
		this.collectionitems = value;
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
		if(this.collector != null)
		{
			if(!this.collector.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.collectionitems != null)
		{
			if(!this.collectionitems.isValidated())
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
		if(this.date == null)
			listOfErrors.add("Date is mandatory");
		if(this.collector == null)
			listOfErrors.add("Collector is mandatory");
		if(this.collector != null)
		{
			String[] listOfOtherErrors = this.collector.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.wards == null || this.wards.size() == 0)
			listOfErrors.add("Wards are mandatory");
		if(this.roundtocollect == null)
			listOfErrors.add("RoundToCollect is mandatory");
		if(this.collectionitems != null)
		{
			String[] listOfOtherErrors = this.collectionitems.validate();
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
	
		PhlebotomyRoundVo clone = new PhlebotomyRoundVo(this.id, this.version);
		
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
		if(this.collector == null)
			clone.collector = null;
		else
			clone.collector = (ims.core.vo.Hcp)this.collector.clone();
		if(this.wards == null)
			clone.wards = null;
		else
			clone.wards = (ims.core.vo.LocationLiteVoCollection)this.wards.clone();
		if(this.roundtocollect == null)
			clone.roundtocollect = null;
		else
			clone.roundtocollect = (ims.ocrr.vo.lookups.SpecimenCollectionTime)this.roundtocollect.clone();
		if(this.collectionitems == null)
			clone.collectionitems = null;
		else
			clone.collectionitems = (ims.ocrr.vo.SpecimenWorkListItemVoCollection)this.collectionitems.clone();
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
		if (!(PhlebotomyRoundVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PhlebotomyRoundVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PhlebotomyRoundVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PhlebotomyRoundVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.collectionitems != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.ocrr.vo.SpecimenWorkListItemVoCollection collectionitems;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
