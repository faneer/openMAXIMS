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

package ims.oncology.vo;

/**
 * Linked to Oncology.PrimaryTumourDetails business object (ID: 1074100007).
 */
public class PrimaryTumourDetailsLiteVo extends ims.oncology.vo.PrimaryTumourDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PrimaryTumourDetailsLiteVo()
	{
	}
	public PrimaryTumourDetailsLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public PrimaryTumourDetailsLiteVo(ims.oncology.vo.beans.PrimaryTumourDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.tumourgroup = bean.getTumourGroup() == null ? null : bean.getTumourGroup().buildVo();
		this.tumoursite = bean.getTumourSite() == null ? null : bean.getTumourSite().buildVo();
		this.tumourlaterality = bean.getTumourLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getTumourLaterality());
		this.iscurrent = bean.getIsCurrent();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.PrimaryTumourDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.tumourgroup = bean.getTumourGroup() == null ? null : bean.getTumourGroup().buildVo(map);
		this.tumoursite = bean.getTumourSite() == null ? null : bean.getTumourSite().buildVo(map);
		this.tumourlaterality = bean.getTumourLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getTumourLaterality());
		this.iscurrent = bean.getIsCurrent();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.PrimaryTumourDetailsLiteVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.PrimaryTumourDetailsLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.PrimaryTumourDetailsLiteVoBean();
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
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("TUMOURGROUP"))
			return getTumourGroup();
		if(fieldName.equals("TUMOURSITE"))
			return getTumourSite();
		if(fieldName.equals("TUMOURLATERALITY"))
			return getTumourLaterality();
		if(fieldName.equals("ISCURRENT"))
			return getIsCurrent();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getTumourGroupIsNotNull()
	{
		return this.tumourgroup != null;
	}
	public ims.clinicaladmin.vo.TumourGroupLiteVo getTumourGroup()
	{
		return this.tumourgroup;
	}
	public void setTumourGroup(ims.clinicaladmin.vo.TumourGroupLiteVo value)
	{
		this.isValidated = false;
		this.tumourgroup = value;
	}
	public boolean getTumourSiteIsNotNull()
	{
		return this.tumoursite != null;
	}
	public ims.clinicaladmin.vo.TumourSiteLiteVo getTumourSite()
	{
		return this.tumoursite;
	}
	public void setTumourSite(ims.clinicaladmin.vo.TumourSiteLiteVo value)
	{
		this.isValidated = false;
		this.tumoursite = value;
	}
	public boolean getTumourLateralityIsNotNull()
	{
		return this.tumourlaterality != null;
	}
	public ims.core.vo.lookups.LateralityLRB getTumourLaterality()
	{
		return this.tumourlaterality;
	}
	public void setTumourLaterality(ims.core.vo.lookups.LateralityLRB value)
	{
		this.isValidated = false;
		this.tumourlaterality = value;
	}
	public boolean getIsCurrentIsNotNull()
	{
		return this.iscurrent != null;
	}
	public Boolean getIsCurrent()
	{
		return this.iscurrent;
	}
	public void setIsCurrent(Boolean value)
	{
		this.isValidated = false;
		this.iscurrent = value;
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.tumourgroup == null)
			listOfErrors.add("TumourGroup is mandatory");
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
	
		PrimaryTumourDetailsLiteVo clone = new PrimaryTumourDetailsLiteVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.tumourgroup == null)
			clone.tumourgroup = null;
		else
			clone.tumourgroup = (ims.clinicaladmin.vo.TumourGroupLiteVo)this.tumourgroup.clone();
		if(this.tumoursite == null)
			clone.tumoursite = null;
		else
			clone.tumoursite = (ims.clinicaladmin.vo.TumourSiteLiteVo)this.tumoursite.clone();
		if(this.tumourlaterality == null)
			clone.tumourlaterality = null;
		else
			clone.tumourlaterality = (ims.core.vo.lookups.LateralityLRB)this.tumourlaterality.clone();
		clone.iscurrent = this.iscurrent;
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
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
		if (!(PrimaryTumourDetailsLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PrimaryTumourDetailsLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PrimaryTumourDetailsLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PrimaryTumourDetailsLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinformation != null)
			count++;
		if(this.tumourgroup != null)
			count++;
		if(this.tumoursite != null)
			count++;
		if(this.tumourlaterality != null)
			count++;
		if(this.iscurrent != null)
			count++;
		if(this.enddate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.clinicaladmin.vo.TumourGroupLiteVo tumourgroup;
	protected ims.clinicaladmin.vo.TumourSiteLiteVo tumoursite;
	protected ims.core.vo.lookups.LateralityLRB tumourlaterality;
	protected Boolean iscurrent;
	protected ims.framework.utils.Date enddate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
