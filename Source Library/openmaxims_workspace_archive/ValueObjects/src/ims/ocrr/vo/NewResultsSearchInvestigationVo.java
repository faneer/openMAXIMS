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
 * Linked to OCRR.Configuration.Investigation business object (ID: 1058100001).
 */
public class NewResultsSearchInvestigationVo extends ims.ocrr.configuration.vo.InvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NewResultsSearchInvestigationVo()
	{
	}
	public NewResultsSearchInvestigationVo(Integer id, int version)
	{
		super(id, version);
	}
	public NewResultsSearchInvestigationVo(ims.ocrr.vo.beans.NewResultsSearchInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigationindex = bean.getInvestigationIndex() == null ? null : bean.getInvestigationIndex().buildVo();
		this.type = bean.getType() == null ? null : ims.ocrr.vo.lookups.InvType.buildLookup(bean.getType());
		this.eventtype = bean.getEventType() == null ? null : ims.ocrr.vo.lookups.InvEventType.buildLookup(bean.getEventType());
		this.providerservice = bean.getProviderService() == null ? null : bean.getProviderService().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.NewResultsSearchInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigationindex = bean.getInvestigationIndex() == null ? null : bean.getInvestigationIndex().buildVo(map);
		this.type = bean.getType() == null ? null : ims.ocrr.vo.lookups.InvType.buildLookup(bean.getType());
		this.eventtype = bean.getEventType() == null ? null : ims.ocrr.vo.lookups.InvEventType.buildLookup(bean.getEventType());
		this.providerservice = bean.getProviderService() == null ? null : bean.getProviderService().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.NewResultsSearchInvestigationVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.NewResultsSearchInvestigationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.NewResultsSearchInvestigationVoBean();
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
		if(fieldName.equals("INVESTIGATIONINDEX"))
			return getInvestigationIndex();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("EVENTTYPE"))
			return getEventType();
		if(fieldName.equals("PROVIDERSERVICE"))
			return getProviderService();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIndexIsNotNull()
	{
		return this.investigationindex != null;
	}
	public ims.ocrr.vo.InvestigationIndexLiteVo getInvestigationIndex()
	{
		return this.investigationindex;
	}
	public void setInvestigationIndex(ims.ocrr.vo.InvestigationIndexLiteVo value)
	{
		this.isValidated = false;
		this.investigationindex = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.ocrr.vo.lookups.InvType getType()
	{
		return this.type;
	}
	public void setType(ims.ocrr.vo.lookups.InvType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getEventTypeIsNotNull()
	{
		return this.eventtype != null;
	}
	public ims.ocrr.vo.lookups.InvEventType getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.ocrr.vo.lookups.InvEventType value)
	{
		this.isValidated = false;
		this.eventtype = value;
	}
	public boolean getProviderServiceIsNotNull()
	{
		return this.providerservice != null;
	}
	public ims.ocrr.vo.NewResultsListProviderServiceVo getProviderService()
	{
		return this.providerservice;
	}
	public void setProviderService(ims.ocrr.vo.NewResultsListProviderServiceVo value)
	{
		this.isValidated = false;
		this.providerservice = value;
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
		if(this.investigationindex == null)
			listOfErrors.add("InvestigationIndex is mandatory");
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
		if(this.eventtype == null)
			listOfErrors.add("EventType is mandatory");
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
	
		NewResultsSearchInvestigationVo clone = new NewResultsSearchInvestigationVo(this.id, this.version);
		
		if(this.investigationindex == null)
			clone.investigationindex = null;
		else
			clone.investigationindex = (ims.ocrr.vo.InvestigationIndexLiteVo)this.investigationindex.clone();
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.ocrr.vo.lookups.InvType)this.type.clone();
		if(this.eventtype == null)
			clone.eventtype = null;
		else
			clone.eventtype = (ims.ocrr.vo.lookups.InvEventType)this.eventtype.clone();
		if(this.providerservice == null)
			clone.providerservice = null;
		else
			clone.providerservice = (ims.ocrr.vo.NewResultsListProviderServiceVo)this.providerservice.clone();
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
		if (!(NewResultsSearchInvestigationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NewResultsSearchInvestigationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NewResultsSearchInvestigationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NewResultsSearchInvestigationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.investigationindex != null)
			count++;
		if(this.type != null)
			count++;
		if(this.eventtype != null)
			count++;
		if(this.providerservice != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.ocrr.vo.InvestigationIndexLiteVo investigationindex;
	protected ims.ocrr.vo.lookups.InvType type;
	protected ims.ocrr.vo.lookups.InvEventType eventtype;
	protected ims.ocrr.vo.NewResultsListProviderServiceVo providerservice;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
