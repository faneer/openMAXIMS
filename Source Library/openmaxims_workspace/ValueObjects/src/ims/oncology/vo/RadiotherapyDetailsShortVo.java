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
 * Linked to Oncology.RadiotherapyDetails business object (ID: 1074100003).
 */
public class RadiotherapyDetailsShortVo extends ims.oncology.vo.RadiotherapyDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RadiotherapyDetailsShortVo()
	{
	}
	public RadiotherapyDetailsShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public RadiotherapyDetailsShortVo(ims.oncology.vo.beans.RadiotherapyDetailsShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.radiotherapytype = bean.getRadiotherapyType() == null ? null : ims.oncology.vo.lookups.RadiotherapyType.buildLookup(bean.getRadiotherapyType());
		// Interface field type not supported.
		this.treatementintent = bean.getTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getTreatementIntent());
		this.anatomicaltreatmentsite = bean.getAnatomicalTreatmentSite() == null ? null : ims.oncology.vo.lookups.AnatomicalTreatmentSite.buildLookup(bean.getAnatomicalTreatmentSite());
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.RadiotherapyDetailsShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.radiotherapytype = bean.getRadiotherapyType() == null ? null : ims.oncology.vo.lookups.RadiotherapyType.buildLookup(bean.getRadiotherapyType());
		// Interface field type not supported.
		this.treatementintent = bean.getTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getTreatementIntent());
		this.anatomicaltreatmentsite = bean.getAnatomicalTreatmentSite() == null ? null : ims.oncology.vo.lookups.AnatomicalTreatmentSite.buildLookup(bean.getAnatomicalTreatmentSite());
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.RadiotherapyDetailsShortVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.RadiotherapyDetailsShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.RadiotherapyDetailsShortVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("RADIOTHERAPYTYPE"))
			return getRadiotherapyType();
		if(fieldName.equals("TREATINGCONSULTANT"))
			return getTreatingConsultant();
		if(fieldName.equals("TREATEMENTINTENT"))
			return getTreatementIntent();
		if(fieldName.equals("ANATOMICALTREATMENTSITE"))
			return getAnatomicalTreatmentSite();
		if(fieldName.equals("DATEDECISIONTOTREAT"))
			return getDateDecisionToTreat();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getRadiotherapyTypeIsNotNull()
	{
		return this.radiotherapytype != null;
	}
	public ims.oncology.vo.lookups.RadiotherapyType getRadiotherapyType()
	{
		return this.radiotherapytype;
	}
	public void setRadiotherapyType(ims.oncology.vo.lookups.RadiotherapyType value)
	{
		this.isValidated = false;
		this.radiotherapytype = value;
	}
	public boolean getTreatingConsultantIsNotNull()
	{
		return this.treatingconsultant != null;
	}
	public ims.vo.interfaces.IMos getTreatingConsultant()
	{
		return this.treatingconsultant;
	}
	public void setTreatingConsultant(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.treatingconsultant = (ims.core.vo.Hcp)value;
	}
	public boolean getTreatementIntentIsNotNull()
	{
		return this.treatementintent != null;
	}
	public ims.oncology.vo.lookups.CancerTreatmentIntent getTreatementIntent()
	{
		return this.treatementintent;
	}
	public void setTreatementIntent(ims.oncology.vo.lookups.CancerTreatmentIntent value)
	{
		this.isValidated = false;
		this.treatementintent = value;
	}
	public boolean getAnatomicalTreatmentSiteIsNotNull()
	{
		return this.anatomicaltreatmentsite != null;
	}
	public ims.oncology.vo.lookups.AnatomicalTreatmentSite getAnatomicalTreatmentSite()
	{
		return this.anatomicaltreatmentsite;
	}
	public void setAnatomicalTreatmentSite(ims.oncology.vo.lookups.AnatomicalTreatmentSite value)
	{
		this.isValidated = false;
		this.anatomicaltreatmentsite = value;
	}
	public boolean getDateDecisionToTreatIsNotNull()
	{
		return this.datedecisiontotreat != null;
	}
	public ims.framework.utils.Date getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datedecisiontotreat = value;
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
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
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
		if(this.radiotherapytype == null)
			listOfErrors.add("RadiotherapyType is mandatory");
		if(this.treatingconsultant == null)
			listOfErrors.add("TreatingConsultant is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
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
	
		RadiotherapyDetailsShortVo clone = new RadiotherapyDetailsShortVo(this.id, this.version);
		
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.radiotherapytype == null)
			clone.radiotherapytype = null;
		else
			clone.radiotherapytype = (ims.oncology.vo.lookups.RadiotherapyType)this.radiotherapytype.clone();
		clone.treatingconsultant = this.treatingconsultant;
		if(this.treatementintent == null)
			clone.treatementintent = null;
		else
			clone.treatementintent = (ims.oncology.vo.lookups.CancerTreatmentIntent)this.treatementintent.clone();
		if(this.anatomicaltreatmentsite == null)
			clone.anatomicaltreatmentsite = null;
		else
			clone.anatomicaltreatmentsite = (ims.oncology.vo.lookups.AnatomicalTreatmentSite)this.anatomicaltreatmentsite.clone();
		if(this.datedecisiontotreat == null)
			clone.datedecisiontotreat = null;
		else
			clone.datedecisiontotreat = (ims.framework.utils.Date)this.datedecisiontotreat.clone();
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		clone.episodeofcare = this.episodeofcare;
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
		if (!(RadiotherapyDetailsShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RadiotherapyDetailsShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RadiotherapyDetailsShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RadiotherapyDetailsShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.radiotherapytype != null)
			count++;
		if(this.treatingconsultant != null)
			count++;
		if(this.treatementintent != null)
			count++;
		if(this.anatomicaltreatmentsite != null)
			count++;
		if(this.datedecisiontotreat != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.oncology.vo.lookups.RadiotherapyType radiotherapytype;
	protected ims.core.vo.Hcp treatingconsultant;
	protected ims.oncology.vo.lookups.CancerTreatmentIntent treatementintent;
	protected ims.oncology.vo.lookups.AnatomicalTreatmentSite anatomicaltreatmentsite;
	protected ims.framework.utils.Date datedecisiontotreat;
	protected ims.framework.utils.Date startdate;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
