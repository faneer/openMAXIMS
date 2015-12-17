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

package ims.core.vo;

/**
 * Linked to core.admin.EpisodeOfCareHistory business object (ID: 1004100051).
 */
public class EpisodeOfCareHistVo extends ims.core.admin.vo.EpisodeOfCareHistoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EpisodeOfCareHistVo()
	{
	}
	public EpisodeOfCareHistVo(Integer id, int version)
	{
		super(id, version);
	}
	public EpisodeOfCareHistVo(ims.core.vo.beans.EpisodeOfCareHistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.relationship = bean.getRelationship() == null ? null : ims.core.vo.lookups.CareSpelltoEpisodeRelationship.buildLookup(bean.getRelationship());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.sysinformation = bean.getSysInformation() == null ? null : bean.getSysInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.EpisodeOfCareHistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.relationship = bean.getRelationship() == null ? null : ims.core.vo.lookups.CareSpelltoEpisodeRelationship.buildLookup(bean.getRelationship());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo(map);
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.sysinformation = bean.getSysInformation() == null ? null : bean.getSysInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.EpisodeOfCareHistVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.EpisodeOfCareHistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.EpisodeOfCareHistVoBean();
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
		if(fieldName.equals("RELATIONSHIP"))
			return getRelationship();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		if(fieldName.equals("SYSINFORMATION"))
			return getSysInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRelationshipIsNotNull()
	{
		return this.relationship != null;
	}
	public ims.core.vo.lookups.CareSpelltoEpisodeRelationship getRelationship()
	{
		return this.relationship;
	}
	public void setRelationship(ims.core.vo.lookups.CareSpelltoEpisodeRelationship value)
	{
		this.isValidated = false;
		this.relationship = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
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
	public boolean getSysInformationIsNotNull()
	{
		return this.sysinformation != null;
	}
	public ims.vo.SystemInformation getSysInformation()
	{
		return this.sysinformation;
	}
	public void setSysInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinformation = value;
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
		if(this.specialty == null)
			listOfErrors.add("Specialty is mandatory");
		if(this.startdate == null)
			listOfErrors.add("StartDate is mandatory");
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
	
		EpisodeOfCareHistVo clone = new EpisodeOfCareHistVo(this.id, this.version);
		
		if(this.relationship == null)
			clone.relationship = null;
		else
			clone.relationship = (ims.core.vo.lookups.CareSpelltoEpisodeRelationship)this.relationship.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		if(this.sysinformation == null)
			clone.sysinformation = null;
		else
			clone.sysinformation = (ims.vo.SystemInformation)this.sysinformation.clone();
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
		if (!(EpisodeOfCareHistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EpisodeOfCareHistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EpisodeOfCareHistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EpisodeOfCareHistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.relationship != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.enddate != null)
			count++;
		if(this.sysinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.lookups.CareSpelltoEpisodeRelationship relationship;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date enddate;
	protected ims.vo.SystemInformation sysinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
