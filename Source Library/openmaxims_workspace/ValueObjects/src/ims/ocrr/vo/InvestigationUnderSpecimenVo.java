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
 * Linked to OCRR.Configuration.Investigation business object (ID: 1058100001).
 */
public class InvestigationUnderSpecimenVo extends ims.ocrr.configuration.vo.InvestigationRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IGenericItemType
{
	private static final long serialVersionUID = 1L;

	public InvestigationUnderSpecimenVo()
	{
	}
	public InvestigationUnderSpecimenVo(Integer id, int version)
	{
		super(id, version);
	}
	public InvestigationUnderSpecimenVo(ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.providerservice = bean.getProviderService() == null ? null : bean.getProviderService().buildVo();
		this.pathinvdetails = bean.getPathInvDetails() == null ? null : bean.getPathInvDetails().buildVo();
		this.separateorder = bean.getSeparateOrder();
		this.investigationindex = bean.getInvestigationIndex() == null ? null : bean.getInvestigationIndex().buildVo();
		this.isaddon = bean.getIsAddon();
		this.helptext = ims.ocrr.vo.HelpTextVoCollection.buildFromBeanCollection(bean.getHelpText());
		this.parentinvestigationpathdetails = bean.getParentInvestigationPathDetails() == null ? null : bean.getParentInvestigationPathDetails().buildVo();
		this.parentphlebmaycollect = bean.getParentPhlebMayCollect();
		this.type = bean.getType() == null ? null : ims.ocrr.vo.lookups.InvType.buildLookup(bean.getType());
		this.eventtype = bean.getEventType() == null ? null : ims.ocrr.vo.lookups.InvEventType.buildLookup(bean.getEventType());
		this.nolabelsets = bean.getNoLabelSets();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.providerservice = bean.getProviderService() == null ? null : bean.getProviderService().buildVo(map);
		this.pathinvdetails = bean.getPathInvDetails() == null ? null : bean.getPathInvDetails().buildVo(map);
		this.separateorder = bean.getSeparateOrder();
		this.investigationindex = bean.getInvestigationIndex() == null ? null : bean.getInvestigationIndex().buildVo(map);
		this.isaddon = bean.getIsAddon();
		this.helptext = ims.ocrr.vo.HelpTextVoCollection.buildFromBeanCollection(bean.getHelpText());
		this.parentinvestigationpathdetails = bean.getParentInvestigationPathDetails() == null ? null : bean.getParentInvestigationPathDetails().buildVo(map);
		this.parentphlebmaycollect = bean.getParentPhlebMayCollect();
		this.type = bean.getType() == null ? null : ims.ocrr.vo.lookups.InvType.buildLookup(bean.getType());
		this.eventtype = bean.getEventType() == null ? null : ims.ocrr.vo.lookups.InvEventType.buildLookup(bean.getEventType());
		this.nolabelsets = bean.getNoLabelSets();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean();
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
		if(fieldName.equals("PROVIDERSERVICE"))
			return getProviderService();
		if(fieldName.equals("PATHINVDETAILS"))
			return getPathInvDetails();
		if(fieldName.equals("SEPARATEORDER"))
			return getSeparateOrder();
		if(fieldName.equals("INVESTIGATIONINDEX"))
			return getInvestigationIndex();
		if(fieldName.equals("ISADDON"))
			return getIsAddon();
		if(fieldName.equals("HELPTEXT"))
			return getHelpText();
		if(fieldName.equals("PARENTINVESTIGATIONPATHDETAILS"))
			return getParentInvestigationPathDetails();
		if(fieldName.equals("PARENTPHLEBMAYCOLLECT"))
			return getParentPhlebMayCollect();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("EVENTTYPE"))
			return getEventType();
		if(fieldName.equals("NOLABELSETS"))
			return getNoLabelSets();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProviderServiceIsNotNull()
	{
		return this.providerservice != null;
	}
	public ims.ocrr.vo.LocSvcProviderSysVo getProviderService()
	{
		return this.providerservice;
	}
	public void setProviderService(ims.ocrr.vo.LocSvcProviderSysVo value)
	{
		this.isValidated = false;
		this.providerservice = value;
	}
	public boolean getPathInvDetailsIsNotNull()
	{
		return this.pathinvdetails != null;
	}
	public ims.ocrr.vo.PathInvDetailsVo getPathInvDetails()
	{
		return this.pathinvdetails;
	}
	public void setPathInvDetails(ims.ocrr.vo.PathInvDetailsVo value)
	{
		this.isValidated = false;
		this.pathinvdetails = value;
	}
	public boolean getSeparateOrderIsNotNull()
	{
		return this.separateorder != null;
	}
	public Boolean getSeparateOrder()
	{
		return this.separateorder;
	}
	public void setSeparateOrder(Boolean value)
	{
		this.isValidated = false;
		this.separateorder = value;
	}
	public boolean getInvestigationIndexIsNotNull()
	{
		return this.investigationindex != null;
	}
	public ims.ocrr.vo.InvestigationIndexShortVo getInvestigationIndex()
	{
		return this.investigationindex;
	}
	public void setInvestigationIndex(ims.ocrr.vo.InvestigationIndexShortVo value)
	{
		this.isValidated = false;
		this.investigationindex = value;
	}
	public boolean getIsAddonIsNotNull()
	{
		return this.isaddon != null;
	}
	public Boolean getIsAddon()
	{
		return this.isaddon;
	}
	public void setIsAddon(Boolean value)
	{
		this.isValidated = false;
		this.isaddon = value;
	}
	public boolean getHelpTextIsNotNull()
	{
		return this.helptext != null;
	}
	public ims.ocrr.vo.HelpTextVoCollection getHelpText()
	{
		return this.helptext;
	}
	public void setHelpText(ims.ocrr.vo.HelpTextVoCollection value)
	{
		this.isValidated = false;
		this.helptext = value;
	}
	public boolean getParentInvestigationPathDetailsIsNotNull()
	{
		return this.parentinvestigationpathdetails != null;
	}
	public ims.ocrr.vo.PathInvDetailsVo getParentInvestigationPathDetails()
	{
		return this.parentinvestigationpathdetails;
	}
	public void setParentInvestigationPathDetails(ims.ocrr.vo.PathInvDetailsVo value)
	{
		this.isValidated = false;
		this.parentinvestigationpathdetails = value;
	}
	public boolean getParentPhlebMayCollectIsNotNull()
	{
		return this.parentphlebmaycollect != null;
	}
	public Boolean getParentPhlebMayCollect()
	{
		return this.parentphlebmaycollect;
	}
	public void setParentPhlebMayCollect(Boolean value)
	{
		this.isValidated = false;
		this.parentphlebmaycollect = value;
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
	public boolean getNoLabelSetsIsNotNull()
	{
		return this.nolabelsets != null;
	}
	public Integer getNoLabelSets()
	{
		return this.nolabelsets;
	}
	public void setNoLabelSets(Integer value)
	{
		this.isValidated = false;
		this.nolabelsets = value;
	}
	/**
	* IGenericItemType Interface methods
	*/
	public Integer getIGenericItemInfoID()
	{
		return getID_Investigation();
	}
	public String getIGenericItemInfoName()
	{
		return getNameWithLocationInfo();
	}
	public Boolean getIGenericItemInfoIsActive()
	{
		return Boolean.TRUE;
	}
	public ims.core.vo.enums.SelectItemType getIGenericItemTypeSelectItemType()
	{
		return ims.core.vo.enums.SelectItemType.INVESTIGATION;
	}
	/**
	* getNameWithLocationInfo
	*/
	public String getNameWithLocationInfo()
	{
		if(this.investigationindex == null)
			return "";
		if(this.investigationindex.getName() == null)
			return "";
			
		String additional = getLocationInfo();
		return this.investigationindex.getName() + additional;
	}
	/**
	* getLocationInfo
	*/
	public String getLocationInfo()
	{
		String additional = "";		
		if(this.providerservice != null && this.providerservice.getLocationServiceIsNotNull() && this.providerservice.getLocationService().getLocationIsNotNull())
			additional = " (" + this.providerservice.getLocationService().getLocation().getName();
			
		if(this.providerservice != null && this.providerservice.getLocationServiceIsNotNull() && this.providerservice.getLocationService().getServiceIsNotNull() && this.providerservice.getLocationService().getService().getServiceNameIsNotNull())
		{
			if(additional.length() > 0)
				additional += ", ";
			else
				additional = " (";
				
			additional += this.providerservice.getLocationService().getService().getServiceName() + ")";
		}
		else if(additional.length() > 0)
			additional += ")";
		return additional;
	}
	/**
	* buildHelpTextTooltip
	*/
	public String buildHelpTextTooltip()
	{
		if(this.helptext == null)
			return null;
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<this.helptext.size();i++)
		{
			
			if(this.helptext.get(i).getTextCategoryIsNotNull())
				sb.append( new ims.utils.textile.Textile().process(ims.utils.textile.Textile.setBold(this.helptext.get(i).getTextCategory().getText()) + "\n" + this.helptext.get(i).getHelpText()));	}
		
		return sb.toString();
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
		if(this.providerservice != null)
		{
			if(!this.providerservice.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.helptext != null)
		{
			if(!this.helptext.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.parentinvestigationpathdetails != null)
		{
			if(!this.parentinvestigationpathdetails.isValidated())
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
		if(this.providerservice != null)
		{
			String[] listOfOtherErrors = this.providerservice.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.investigationindex == null)
			listOfErrors.add("InvestigationIndex is mandatory");
		if(this.helptext != null)
		{
			String[] listOfOtherErrors = this.helptext.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.parentinvestigationpathdetails != null)
		{
			String[] listOfOtherErrors = this.parentinvestigationpathdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		InvestigationUnderSpecimenVo clone = new InvestigationUnderSpecimenVo(this.id, this.version);
		
		if(this.providerservice == null)
			clone.providerservice = null;
		else
			clone.providerservice = (ims.ocrr.vo.LocSvcProviderSysVo)this.providerservice.clone();
		if(this.pathinvdetails == null)
			clone.pathinvdetails = null;
		else
			clone.pathinvdetails = (ims.ocrr.vo.PathInvDetailsVo)this.pathinvdetails.clone();
		clone.separateorder = this.separateorder;
		if(this.investigationindex == null)
			clone.investigationindex = null;
		else
			clone.investigationindex = (ims.ocrr.vo.InvestigationIndexShortVo)this.investigationindex.clone();
		clone.isaddon = this.isaddon;
		if(this.helptext == null)
			clone.helptext = null;
		else
			clone.helptext = (ims.ocrr.vo.HelpTextVoCollection)this.helptext.clone();
		if(this.parentinvestigationpathdetails == null)
			clone.parentinvestigationpathdetails = null;
		else
			clone.parentinvestigationpathdetails = (ims.ocrr.vo.PathInvDetailsVo)this.parentinvestigationpathdetails.clone();
		clone.parentphlebmaycollect = this.parentphlebmaycollect;
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.ocrr.vo.lookups.InvType)this.type.clone();
		if(this.eventtype == null)
			clone.eventtype = null;
		else
			clone.eventtype = (ims.ocrr.vo.lookups.InvEventType)this.eventtype.clone();
		clone.nolabelsets = this.nolabelsets;
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
		if (!(InvestigationUnderSpecimenVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InvestigationUnderSpecimenVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InvestigationUnderSpecimenVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InvestigationUnderSpecimenVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.providerservice != null)
			count++;
		if(this.pathinvdetails != null)
			count++;
		if(this.separateorder != null)
			count++;
		if(this.investigationindex != null)
			count++;
		if(this.isaddon != null)
			count++;
		if(this.helptext != null)
			count++;
		if(this.parentinvestigationpathdetails != null)
			count++;
		if(this.parentphlebmaycollect != null)
			count++;
		if(this.type != null)
			count++;
		if(this.eventtype != null)
			count++;
		if(this.nolabelsets != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.ocrr.vo.LocSvcProviderSysVo providerservice;
	protected ims.ocrr.vo.PathInvDetailsVo pathinvdetails;
	protected Boolean separateorder;
	protected ims.ocrr.vo.InvestigationIndexShortVo investigationindex;
	protected Boolean isaddon;
	protected ims.ocrr.vo.HelpTextVoCollection helptext;
	protected ims.ocrr.vo.PathInvDetailsVo parentinvestigationpathdetails;
	protected Boolean parentphlebmaycollect;
	protected ims.ocrr.vo.lookups.InvType type;
	protected ims.ocrr.vo.lookups.InvEventType eventtype;
	protected Integer nolabelsets;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
