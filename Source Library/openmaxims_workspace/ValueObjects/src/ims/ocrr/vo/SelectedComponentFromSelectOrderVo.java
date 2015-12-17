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


public class SelectedComponentFromSelectOrderVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SelectedComponentFromSelectOrderVo()
	{
	}
	public SelectedComponentFromSelectOrderVo(ims.ocrr.vo.beans.SelectedComponentFromSelectOrderVoBean bean)
	{
		this.id = bean.getID();
		this.componenttype = bean.getComponentType() == null ? null : ims.ocrr.vo.lookups.SelectAndOrderComponentType.buildLookup(bean.getComponentType());
		this.text = bean.getText();
		this.tooltip = bean.getTooltip();
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.helptext = bean.getHelpText();
		this.additionallocationinfo = bean.getAdditionalLocationInfo();
		this.parentinvestigationid = bean.getParentInvestigationId();
		this.isaddon = bean.getIsAddon();
		this.requiressite = bean.getRequiresSite();
		this.serviceid = bean.getServiceID();
		this.minreorderperiod = bean.getMinReOrderPeriod() == null ? null : ims.ocrr.vo.lookups.MinReorderPeriod.buildLookup(bean.getMinReOrderPeriod());
		this.minreorderval = bean.getMinReOrderVal();
		this.minreorderfemaleperiod = bean.getMinReOrderFemalePeriod() == null ? null : ims.ocrr.vo.lookups.MinReorderPeriod.buildLookup(bean.getMinReOrderFemalePeriod());
		this.minreorderfemaleval = bean.getMinReOrderFemaleVal();
		this.genderspecific = bean.getGenderSpecific() == null ? null : ims.admin.vo.lookups.GenderSpecific.buildLookup(bean.getGenderSpecific());
		this.phlebmaycollect = bean.getPhlebMayCollect();
		this.reorderreason = bean.getReOrderReason();
		if(bean.getAssociatedInvestigations() != null)
		{
			this.associatedinvestigations = new ims.ocrr.configuration.vo.InvestigationRefVoCollection();
			for(int associatedinvestigations_i = 0; associatedinvestigations_i < bean.getAssociatedInvestigations().length; associatedinvestigations_i++)
			{
				this.associatedinvestigations.add(new ims.ocrr.configuration.vo.InvestigationRefVo(new Integer(bean.getAssociatedInvestigations()[associatedinvestigations_i].getId()), bean.getAssociatedInvestigations()[associatedinvestigations_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.SelectedComponentFromSelectOrderVoBean bean)
	{
		this.id = bean.getID();
		this.componenttype = bean.getComponentType() == null ? null : ims.ocrr.vo.lookups.SelectAndOrderComponentType.buildLookup(bean.getComponentType());
		this.text = bean.getText();
		this.tooltip = bean.getTooltip();
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.helptext = bean.getHelpText();
		this.additionallocationinfo = bean.getAdditionalLocationInfo();
		this.parentinvestigationid = bean.getParentInvestigationId();
		this.isaddon = bean.getIsAddon();
		this.requiressite = bean.getRequiresSite();
		this.serviceid = bean.getServiceID();
		this.minreorderperiod = bean.getMinReOrderPeriod() == null ? null : ims.ocrr.vo.lookups.MinReorderPeriod.buildLookup(bean.getMinReOrderPeriod());
		this.minreorderval = bean.getMinReOrderVal();
		this.minreorderfemaleperiod = bean.getMinReOrderFemalePeriod() == null ? null : ims.ocrr.vo.lookups.MinReorderPeriod.buildLookup(bean.getMinReOrderFemalePeriod());
		this.minreorderfemaleval = bean.getMinReOrderFemaleVal();
		this.genderspecific = bean.getGenderSpecific() == null ? null : ims.admin.vo.lookups.GenderSpecific.buildLookup(bean.getGenderSpecific());
		this.phlebmaycollect = bean.getPhlebMayCollect();
		this.reorderreason = bean.getReOrderReason();
		if(bean.getAssociatedInvestigations() != null)
		{
			this.associatedinvestigations = new ims.ocrr.configuration.vo.InvestigationRefVoCollection();
			for(int associatedinvestigations_i = 0; associatedinvestigations_i < bean.getAssociatedInvestigations().length; associatedinvestigations_i++)
			{
				this.associatedinvestigations.add(new ims.ocrr.configuration.vo.InvestigationRefVo(new Integer(bean.getAssociatedInvestigations()[associatedinvestigations_i].getId()), bean.getAssociatedInvestigations()[associatedinvestigations_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.SelectedComponentFromSelectOrderVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.SelectedComponentFromSelectOrderVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.SelectedComponentFromSelectOrderVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getIDIsNotNull()
	{
		return this.id != null;
	}
	public Integer getID()
	{
		return this.id;
	}
	public void setID(Integer value)
	{
		this.isValidated = false;
		this.id = value;
	}
	public boolean getComponentTypeIsNotNull()
	{
		return this.componenttype != null;
	}
	public ims.ocrr.vo.lookups.SelectAndOrderComponentType getComponentType()
	{
		return this.componenttype;
	}
	public void setComponentType(ims.ocrr.vo.lookups.SelectAndOrderComponentType value)
	{
		this.isValidated = false;
		this.componenttype = value;
	}
	public boolean getTextIsNotNull()
	{
		return this.text != null;
	}
	public String getText()
	{
		return this.text;
	}
	public static int getTextMaxLength()
	{
		return 255;
	}
	public void setText(String value)
	{
		this.isValidated = false;
		this.text = value;
	}
	public boolean getTooltipIsNotNull()
	{
		return this.tooltip != null;
	}
	public String getTooltip()
	{
		return this.tooltip;
	}
	public static int getTooltipMaxLength()
	{
		return 255;
	}
	public void setTooltip(String value)
	{
		this.isValidated = false;
		this.tooltip = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.ocrr.vo.lookups.Category getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.ocrr.vo.lookups.Category value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getHelpTextIsNotNull()
	{
		return this.helptext != null;
	}
	public String getHelpText()
	{
		return this.helptext;
	}
	public static int getHelpTextMaxLength()
	{
		return 255;
	}
	public void setHelpText(String value)
	{
		this.isValidated = false;
		this.helptext = value;
	}
	public boolean getAdditionalLocationInfoIsNotNull()
	{
		return this.additionallocationinfo != null;
	}
	public String getAdditionalLocationInfo()
	{
		return this.additionallocationinfo;
	}
	public static int getAdditionalLocationInfoMaxLength()
	{
		return 255;
	}
	public void setAdditionalLocationInfo(String value)
	{
		this.isValidated = false;
		this.additionallocationinfo = value;
	}
	public boolean getParentInvestigationIdIsNotNull()
	{
		return this.parentinvestigationid != null;
	}
	public Integer getParentInvestigationId()
	{
		return this.parentinvestigationid;
	}
	public void setParentInvestigationId(Integer value)
	{
		this.isValidated = false;
		this.parentinvestigationid = value;
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
	public boolean getRequiresSiteIsNotNull()
	{
		return this.requiressite != null;
	}
	public Boolean getRequiresSite()
	{
		return this.requiressite;
	}
	public void setRequiresSite(Boolean value)
	{
		this.isValidated = false;
		this.requiressite = value;
	}
	public boolean getServiceIDIsNotNull()
	{
		return this.serviceid != null;
	}
	public Integer getServiceID()
	{
		return this.serviceid;
	}
	public void setServiceID(Integer value)
	{
		this.isValidated = false;
		this.serviceid = value;
	}
	public boolean getMinReOrderPeriodIsNotNull()
	{
		return this.minreorderperiod != null;
	}
	public ims.ocrr.vo.lookups.MinReorderPeriod getMinReOrderPeriod()
	{
		return this.minreorderperiod;
	}
	public void setMinReOrderPeriod(ims.ocrr.vo.lookups.MinReorderPeriod value)
	{
		this.isValidated = false;
		this.minreorderperiod = value;
	}
	public boolean getMinReOrderValIsNotNull()
	{
		return this.minreorderval != null;
	}
	public Integer getMinReOrderVal()
	{
		return this.minreorderval;
	}
	public void setMinReOrderVal(Integer value)
	{
		this.isValidated = false;
		this.minreorderval = value;
	}
	public boolean getMinReOrderFemalePeriodIsNotNull()
	{
		return this.minreorderfemaleperiod != null;
	}
	public ims.ocrr.vo.lookups.MinReorderPeriod getMinReOrderFemalePeriod()
	{
		return this.minreorderfemaleperiod;
	}
	public void setMinReOrderFemalePeriod(ims.ocrr.vo.lookups.MinReorderPeriod value)
	{
		this.isValidated = false;
		this.minreorderfemaleperiod = value;
	}
	public boolean getMinReOrderFemaleValIsNotNull()
	{
		return this.minreorderfemaleval != null;
	}
	public Integer getMinReOrderFemaleVal()
	{
		return this.minreorderfemaleval;
	}
	public void setMinReOrderFemaleVal(Integer value)
	{
		this.isValidated = false;
		this.minreorderfemaleval = value;
	}
	public boolean getGenderSpecificIsNotNull()
	{
		return this.genderspecific != null;
	}
	public ims.admin.vo.lookups.GenderSpecific getGenderSpecific()
	{
		return this.genderspecific;
	}
	public void setGenderSpecific(ims.admin.vo.lookups.GenderSpecific value)
	{
		this.isValidated = false;
		this.genderspecific = value;
	}
	public boolean getPhlebMayCollectIsNotNull()
	{
		return this.phlebmaycollect != null;
	}
	public Boolean getPhlebMayCollect()
	{
		return this.phlebmaycollect;
	}
	public void setPhlebMayCollect(Boolean value)
	{
		this.isValidated = false;
		this.phlebmaycollect = value;
	}
	public boolean getReOrderReasonIsNotNull()
	{
		return this.reorderreason != null;
	}
	public String getReOrderReason()
	{
		return this.reorderreason;
	}
	public static int getReOrderReasonMaxLength()
	{
		return 255;
	}
	public void setReOrderReason(String value)
	{
		this.isValidated = false;
		this.reorderreason = value;
	}
	public boolean getAssociatedInvestigationsIsNotNull()
	{
		return this.associatedinvestigations != null;
	}
	public ims.ocrr.configuration.vo.InvestigationRefVoCollection getAssociatedInvestigations()
	{
		return this.associatedinvestigations;
	}
	public void setAssociatedInvestigations(ims.ocrr.configuration.vo.InvestigationRefVoCollection value)
	{
		this.isValidated = false;
		this.associatedinvestigations = value;
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
		if(!(obj instanceof SelectedComponentFromSelectOrderVo))
			return false;
		SelectedComponentFromSelectOrderVo compareObj = (SelectedComponentFromSelectOrderVo)obj;
		if(this.getComponentType() == null && compareObj.getComponentType() != null)
			return false;
		if(this.getComponentType() != null && compareObj.getComponentType() == null)
			return false;
		if(this.getComponentType() != null && compareObj.getComponentType() != null)
			if(!this.getComponentType().equals(compareObj.getComponentType()))
				return false;
		if(this.getID() == null && compareObj.getID() != null)
			return false;
		if(this.getID() != null && compareObj.getID() == null)
			return false;
		if(this.getID() != null && compareObj.getID() != null)
			return this.getID().equals(compareObj.getID());
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
	
		SelectedComponentFromSelectOrderVo clone = new SelectedComponentFromSelectOrderVo();
		
		clone.id = this.id;
		if(this.componenttype == null)
			clone.componenttype = null;
		else
			clone.componenttype = (ims.ocrr.vo.lookups.SelectAndOrderComponentType)this.componenttype.clone();
		clone.text = this.text;
		clone.tooltip = this.tooltip;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.ocrr.vo.lookups.Category)this.category.clone();
		clone.helptext = this.helptext;
		clone.additionallocationinfo = this.additionallocationinfo;
		clone.parentinvestigationid = this.parentinvestigationid;
		clone.isaddon = this.isaddon;
		clone.requiressite = this.requiressite;
		clone.serviceid = this.serviceid;
		if(this.minreorderperiod == null)
			clone.minreorderperiod = null;
		else
			clone.minreorderperiod = (ims.ocrr.vo.lookups.MinReorderPeriod)this.minreorderperiod.clone();
		clone.minreorderval = this.minreorderval;
		if(this.minreorderfemaleperiod == null)
			clone.minreorderfemaleperiod = null;
		else
			clone.minreorderfemaleperiod = (ims.ocrr.vo.lookups.MinReorderPeriod)this.minreorderfemaleperiod.clone();
		clone.minreorderfemaleval = this.minreorderfemaleval;
		if(this.genderspecific == null)
			clone.genderspecific = null;
		else
			clone.genderspecific = (ims.admin.vo.lookups.GenderSpecific)this.genderspecific.clone();
		clone.phlebmaycollect = this.phlebmaycollect;
		clone.reorderreason = this.reorderreason;
		clone.associatedinvestigations = this.associatedinvestigations;
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
		if (!(SelectedComponentFromSelectOrderVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SelectedComponentFromSelectOrderVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SelectedComponentFromSelectOrderVo compareObj = (SelectedComponentFromSelectOrderVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getComponentType() == null && compareObj.getComponentType() != null)
				return -1;
			if(this.getComponentType() != null && compareObj.getComponentType() == null)
				return 1;
			if(this.getComponentType() != null && compareObj.getComponentType() != null)
				retVal = this.getComponentType().compareTo(compareObj.getComponentType());
		}
		if (retVal == 0)
		{
			if(this.getID() == null && compareObj.getID() != null)
				return -1;
			if(this.getID() != null && compareObj.getID() == null)
				return 1;
			if(this.getID() != null && compareObj.getID() != null)
				retVal = this.getID().compareTo(compareObj.getID());
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
		if(this.id != null)
			count++;
		if(this.componenttype != null)
			count++;
		if(this.text != null)
			count++;
		if(this.tooltip != null)
			count++;
		if(this.category != null)
			count++;
		if(this.helptext != null)
			count++;
		if(this.additionallocationinfo != null)
			count++;
		if(this.parentinvestigationid != null)
			count++;
		if(this.isaddon != null)
			count++;
		if(this.requiressite != null)
			count++;
		if(this.serviceid != null)
			count++;
		if(this.minreorderperiod != null)
			count++;
		if(this.minreorderval != null)
			count++;
		if(this.minreorderfemaleperiod != null)
			count++;
		if(this.minreorderfemaleval != null)
			count++;
		if(this.genderspecific != null)
			count++;
		if(this.phlebmaycollect != null)
			count++;
		if(this.reorderreason != null)
			count++;
		if(this.associatedinvestigations != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 19;
	}
	protected Integer id;
	protected ims.ocrr.vo.lookups.SelectAndOrderComponentType componenttype;
	protected String text;
	protected String tooltip;
	protected ims.ocrr.vo.lookups.Category category;
	protected String helptext;
	protected String additionallocationinfo;
	protected Integer parentinvestigationid;
	protected Boolean isaddon;
	protected Boolean requiressite;
	protected Integer serviceid;
	protected ims.ocrr.vo.lookups.MinReorderPeriod minreorderperiod;
	protected Integer minreorderval;
	protected ims.ocrr.vo.lookups.MinReorderPeriod minreorderfemaleperiod;
	protected Integer minreorderfemaleval;
	protected ims.admin.vo.lookups.GenderSpecific genderspecific;
	protected Boolean phlebmaycollect;
	protected String reorderreason;
	protected ims.ocrr.configuration.vo.InvestigationRefVoCollection associatedinvestigations;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
