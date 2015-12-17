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

package ims.clinicaladmin.vo;

/**
 * Linked to Oncology.Configuration.TumourSite business object (ID: 1074100010).
 */
public class TumourSiteVo extends ims.clinicaladmin.vo.TumourSiteListVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourSiteVo()
	{
	}
	public TumourSiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourSiteVo(ims.clinicaladmin.vo.beans.TumourSiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.hassitespecifictnm = bean.getHasSiteSpecificTNM();
		this.hassitespecifichistology = bean.getHasSiteSpecificHistology();
		this.description = bean.getDescription();
		this.histologies = ims.clinicaladmin.vo.TumourGroupHistologyVoCollection.buildFromBeanCollection(bean.getHistologies());
		this.tnmvalues = ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection.buildFromBeanCollection(bean.getTNMValues());
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.tnmversion = bean.getTNMVersion() == null ? null : new ims.oncology.configuration.vo.TNMStagingClassificationVersionRefVo(new Integer(bean.getTNMVersion().getId()), bean.getTNMVersion().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TumourSiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.hassitespecifictnm = bean.getHasSiteSpecificTNM();
		this.hassitespecifichistology = bean.getHasSiteSpecificHistology();
		this.description = bean.getDescription();
		this.histologies = ims.clinicaladmin.vo.TumourGroupHistologyVoCollection.buildFromBeanCollection(bean.getHistologies());
		this.tnmvalues = ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection.buildFromBeanCollection(bean.getTNMValues());
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.tnmversion = bean.getTNMVersion() == null ? null : new ims.oncology.configuration.vo.TNMStagingClassificationVersionRefVo(new Integer(bean.getTNMVersion().getId()), bean.getTNMVersion().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TumourSiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TumourSiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TumourSiteVoBean();
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
		if(fieldName.equals("HISTOLOGIES"))
			return getHistologies();
		if(fieldName.equals("TNMVALUES"))
			return getTNMValues();
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
		if(fieldName.equals("TNMVERSION"))
			return getTNMVersion();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHistologiesIsNotNull()
	{
		return this.histologies != null;
	}
	public ims.clinicaladmin.vo.TumourGroupHistologyVoCollection getHistologies()
	{
		return this.histologies;
	}
	public void setHistologies(ims.clinicaladmin.vo.TumourGroupHistologyVoCollection value)
	{
		this.isValidated = false;
		this.histologies = value;
	}
	public boolean getTNMValuesIsNotNull()
	{
		return this.tnmvalues != null;
	}
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection getTNMValues()
	{
		return this.tnmvalues;
	}
	public void setTNMValues(ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection value)
	{
		this.isValidated = false;
		this.tnmvalues = value;
	}
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
	}
	public boolean getTNMVersionIsNotNull()
	{
		return this.tnmversion != null;
	}
	public ims.oncology.configuration.vo.TNMStagingClassificationVersionRefVo getTNMVersion()
	{
		return this.tnmversion;
	}
	public void setTNMVersion(ims.oncology.configuration.vo.TNMStagingClassificationVersionRefVo value)
	{
		this.isValidated = false;
		this.tnmversion = value;
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
		if(this.histologies != null)
		{
			if(!this.histologies.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.tnmvalues != null)
		{
			if(!this.tnmvalues.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.clinicaladmin.vo.TumourSiteVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.clinicaladmin.vo.TumourSiteVo] is too big. It should be less or equal to 255");
		if(this.histologies != null)
		{
			String[] listOfOtherErrors = this.histologies.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.tnmvalues != null)
		{
			String[] listOfOtherErrors = this.tnmvalues.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.taxonomymap != null)
		{
			String[] listOfOtherErrors = this.taxonomymap.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.tnmversion == null)
			listOfErrors.add("TNMVersion is mandatory");
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
	
		TumourSiteVo clone = new TumourSiteVo(this.id, this.version);
		
		clone.name = this.name;
		clone.isactive = this.isactive;
		clone.hassitespecifictnm = this.hassitespecifictnm;
		clone.hassitespecifichistology = this.hassitespecifichistology;
		clone.description = this.description;
		if(this.histologies == null)
			clone.histologies = null;
		else
			clone.histologies = (ims.clinicaladmin.vo.TumourGroupHistologyVoCollection)this.histologies.clone();
		if(this.tnmvalues == null)
			clone.tnmvalues = null;
		else
			clone.tnmvalues = (ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection)this.tnmvalues.clone();
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
		clone.tnmversion = this.tnmversion;
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
		if (!(TumourSiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourSiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TumourSiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TumourSiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.histologies != null)
			count++;
		if(this.tnmvalues != null)
			count++;
		if(this.taxonomymap != null)
			count++;
		if(this.tnmversion != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.clinicaladmin.vo.TumourGroupHistologyVoCollection histologies;
	protected ims.clinicaladmin.vo.TumourGroupSiteTNMValueVoCollection tnmvalues;
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	protected ims.oncology.configuration.vo.TNMStagingClassificationVersionRefVo tnmversion;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
