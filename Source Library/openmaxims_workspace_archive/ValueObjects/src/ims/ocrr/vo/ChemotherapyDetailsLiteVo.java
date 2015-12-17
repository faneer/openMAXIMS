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
 * Linked to Oncology.ChemotherapyDetails business object (ID: 1074100004).
 */
public class ChemotherapyDetailsLiteVo extends ims.oncology.vo.ChemotherapyDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChemotherapyDetailsLiteVo()
	{
	}
	public ChemotherapyDetailsLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChemotherapyDetailsLiteVo(ims.ocrr.vo.beans.ChemotherapyDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.drugtherapytype = bean.getDrugTherapyType() == null ? null : ims.oncology.vo.lookups.DrugTherapyType.buildLookup(bean.getDrugTherapyType());
		this.regimenacronym = bean.getRegimenAcronym() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getRegimenAcronym());
		this.cancertreatementintent = bean.getCancerTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getCancerTreatementIntent());
		this.treatmentresponse = bean.getTreatmentResponse() == null ? null : ims.oncology.vo.lookups.DrugProgramResponse.buildLookup(bean.getTreatmentResponse());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ChemotherapyDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.drugtherapytype = bean.getDrugTherapyType() == null ? null : ims.oncology.vo.lookups.DrugTherapyType.buildLookup(bean.getDrugTherapyType());
		this.regimenacronym = bean.getRegimenAcronym() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getRegimenAcronym());
		this.cancertreatementintent = bean.getCancerTreatementIntent() == null ? null : ims.oncology.vo.lookups.CancerTreatmentIntent.buildLookup(bean.getCancerTreatementIntent());
		this.treatmentresponse = bean.getTreatmentResponse() == null ? null : ims.oncology.vo.lookups.DrugProgramResponse.buildLookup(bean.getTreatmentResponse());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ChemotherapyDetailsLiteVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ChemotherapyDetailsLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ChemotherapyDetailsLiteVoBean();
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
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("DATEDECISIONTOTREAT"))
			return getDateDecisionToTreat();
		if(fieldName.equals("DRUGTHERAPYTYPE"))
			return getDrugTherapyType();
		if(fieldName.equals("REGIMENACRONYM"))
			return getRegimenAcronym();
		if(fieldName.equals("CANCERTREATEMENTINTENT"))
			return getCancerTreatementIntent();
		if(fieldName.equals("TREATMENTRESPONSE"))
			return getTreatmentResponse();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
	public boolean getDrugTherapyTypeIsNotNull()
	{
		return this.drugtherapytype != null;
	}
	public ims.oncology.vo.lookups.DrugTherapyType getDrugTherapyType()
	{
		return this.drugtherapytype;
	}
	public void setDrugTherapyType(ims.oncology.vo.lookups.DrugTherapyType value)
	{
		this.isValidated = false;
		this.drugtherapytype = value;
	}
	public boolean getRegimenAcronymIsNotNull()
	{
		return this.regimenacronym != null;
	}
	public ims.oncology.vo.lookups.RegimenAcronym getRegimenAcronym()
	{
		return this.regimenacronym;
	}
	public void setRegimenAcronym(ims.oncology.vo.lookups.RegimenAcronym value)
	{
		this.isValidated = false;
		this.regimenacronym = value;
	}
	public boolean getCancerTreatementIntentIsNotNull()
	{
		return this.cancertreatementintent != null;
	}
	public ims.oncology.vo.lookups.CancerTreatmentIntent getCancerTreatementIntent()
	{
		return this.cancertreatementintent;
	}
	public void setCancerTreatementIntent(ims.oncology.vo.lookups.CancerTreatmentIntent value)
	{
		this.isValidated = false;
		this.cancertreatementintent = value;
	}
	public boolean getTreatmentResponseIsNotNull()
	{
		return this.treatmentresponse != null;
	}
	public ims.oncology.vo.lookups.DrugProgramResponse getTreatmentResponse()
	{
		return this.treatmentresponse;
	}
	public void setTreatmentResponse(ims.oncology.vo.lookups.DrugProgramResponse value)
	{
		this.isValidated = false;
		this.treatmentresponse = value;
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
		if(this.episodeofcare == null)
			listOfErrors.add("Episode Of Care is mandatory");
		if(this.drugtherapytype == null)
			listOfErrors.add("Drug Therapy Type is mandatory");
		if(this.regimenacronym == null)
			listOfErrors.add("Regimen Acronym is mandatory");
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
	
		ChemotherapyDetailsLiteVo clone = new ChemotherapyDetailsLiteVo(this.id, this.version);
		
		clone.episodeofcare = this.episodeofcare;
		clone.carecontext = this.carecontext;
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.datedecisiontotreat == null)
			clone.datedecisiontotreat = null;
		else
			clone.datedecisiontotreat = (ims.framework.utils.Date)this.datedecisiontotreat.clone();
		if(this.drugtherapytype == null)
			clone.drugtherapytype = null;
		else
			clone.drugtherapytype = (ims.oncology.vo.lookups.DrugTherapyType)this.drugtherapytype.clone();
		if(this.regimenacronym == null)
			clone.regimenacronym = null;
		else
			clone.regimenacronym = (ims.oncology.vo.lookups.RegimenAcronym)this.regimenacronym.clone();
		if(this.cancertreatementintent == null)
			clone.cancertreatementintent = null;
		else
			clone.cancertreatementintent = (ims.oncology.vo.lookups.CancerTreatmentIntent)this.cancertreatementintent.clone();
		if(this.treatmentresponse == null)
			clone.treatmentresponse = null;
		else
			clone.treatmentresponse = (ims.oncology.vo.lookups.DrugProgramResponse)this.treatmentresponse.clone();
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
		if (!(ChemotherapyDetailsLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChemotherapyDetailsLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ChemotherapyDetailsLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ChemotherapyDetailsLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.episodeofcare != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.datedecisiontotreat != null)
			count++;
		if(this.drugtherapytype != null)
			count++;
		if(this.regimenacronym != null)
			count++;
		if(this.cancertreatementintent != null)
			count++;
		if(this.treatmentresponse != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date datedecisiontotreat;
	protected ims.oncology.vo.lookups.DrugTherapyType drugtherapytype;
	protected ims.oncology.vo.lookups.RegimenAcronym regimenacronym;
	protected ims.oncology.vo.lookups.CancerTreatmentIntent cancertreatementintent;
	protected ims.oncology.vo.lookups.DrugProgramResponse treatmentresponse;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
