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
 * Linked to Oncology.FollowUp business object (ID: 1074100000).
 */
public class FollowUpShortVo extends ims.oncology.vo.FollowUpLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FollowUpShortVo()
	{
	}
	public FollowUpShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public FollowUpShortVo(ims.oncology.vo.beans.FollowUpShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentdate = bean.getAssessmentDate() == null ? null : bean.getAssessmentDate().buildDate();
		this.patientfollowupstatus = bean.getPatientFollowUpStatus() == null ? null : ims.oncology.vo.lookups.FUPatientFollowUpStatus.buildLookup(bean.getPatientFollowUpStatus());
		this.treatmenttype = bean.getTreatmentType() == null ? null : ims.oncology.vo.lookups.FUTreatmentType.buildLookup(bean.getTreatmentType());
		this.primarytumourstatus = bean.getPrimaryTumourStatus() == null ? null : ims.oncology.vo.lookups.FUPrimaryTumourStatus.buildLookup(bean.getPrimaryTumourStatus());
		this.nodalstatus = bean.getNodalStatus() == null ? null : ims.oncology.vo.lookups.FUNodalStatus.buildLookup(bean.getNodalStatus());
		this.metastaticstatus = bean.getMetastaticStatus() == null ? null : ims.oncology.vo.lookups.FUMetastaticStatus.buildLookup(bean.getMetastaticStatus());
		this.markerresponsestatus = bean.getMarkerResponseStatus() == null ? null : ims.oncology.vo.lookups.FUMarkerResponseStatus.buildLookup(bean.getMarkerResponseStatus());
		this.performancestatus = bean.getPerformanceStatus() == null ? null : ims.oncology.vo.lookups.WHOPerformanceStatus.buildLookup(bean.getPerformanceStatus());
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.morbiditycodesurgery = bean.getMorbidityCodeSurgery() == null ? null : ims.oncology.vo.lookups.FUMorbiditySurgery.buildLookup(bean.getMorbidityCodeSurgery());
		this.morbiditycodecancerchemotherapy = bean.getMorbidityCodeCancerChemotherapy() == null ? null : ims.oncology.vo.lookups.FUMorbidityChemoTx.buildLookup(bean.getMorbidityCodeCancerChemotherapy());
		this.morbiditycodecancerradiotherapy = bean.getMorbidityCodeCancerRadiotherapy() == null ? null : ims.oncology.vo.lookups.FUMorbidityRadiotx.buildLookup(bean.getMorbidityCodeCancerRadiotherapy());
		this.morbiditycodecancercombination = bean.getMorbidityCodeCancerCombination() == null ? null : ims.oncology.vo.lookups.FUMorbidityCombination.buildLookup(bean.getMorbidityCodeCancerCombination());
		this.dyspneascore = bean.getDyspneaScore() == null ? null : ims.oncology.vo.lookups.FUDyspneaScore.buildLookup(bean.getDyspneaScore());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.FollowUpShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentdate = bean.getAssessmentDate() == null ? null : bean.getAssessmentDate().buildDate();
		this.patientfollowupstatus = bean.getPatientFollowUpStatus() == null ? null : ims.oncology.vo.lookups.FUPatientFollowUpStatus.buildLookup(bean.getPatientFollowUpStatus());
		this.treatmenttype = bean.getTreatmentType() == null ? null : ims.oncology.vo.lookups.FUTreatmentType.buildLookup(bean.getTreatmentType());
		this.primarytumourstatus = bean.getPrimaryTumourStatus() == null ? null : ims.oncology.vo.lookups.FUPrimaryTumourStatus.buildLookup(bean.getPrimaryTumourStatus());
		this.nodalstatus = bean.getNodalStatus() == null ? null : ims.oncology.vo.lookups.FUNodalStatus.buildLookup(bean.getNodalStatus());
		this.metastaticstatus = bean.getMetastaticStatus() == null ? null : ims.oncology.vo.lookups.FUMetastaticStatus.buildLookup(bean.getMetastaticStatus());
		this.markerresponsestatus = bean.getMarkerResponseStatus() == null ? null : ims.oncology.vo.lookups.FUMarkerResponseStatus.buildLookup(bean.getMarkerResponseStatus());
		this.performancestatus = bean.getPerformanceStatus() == null ? null : ims.oncology.vo.lookups.WHOPerformanceStatus.buildLookup(bean.getPerformanceStatus());
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo(map);
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.morbiditycodesurgery = bean.getMorbidityCodeSurgery() == null ? null : ims.oncology.vo.lookups.FUMorbiditySurgery.buildLookup(bean.getMorbidityCodeSurgery());
		this.morbiditycodecancerchemotherapy = bean.getMorbidityCodeCancerChemotherapy() == null ? null : ims.oncology.vo.lookups.FUMorbidityChemoTx.buildLookup(bean.getMorbidityCodeCancerChemotherapy());
		this.morbiditycodecancerradiotherapy = bean.getMorbidityCodeCancerRadiotherapy() == null ? null : ims.oncology.vo.lookups.FUMorbidityRadiotx.buildLookup(bean.getMorbidityCodeCancerRadiotherapy());
		this.morbiditycodecancercombination = bean.getMorbidityCodeCancerCombination() == null ? null : ims.oncology.vo.lookups.FUMorbidityCombination.buildLookup(bean.getMorbidityCodeCancerCombination());
		this.dyspneascore = bean.getDyspneaScore() == null ? null : ims.oncology.vo.lookups.FUDyspneaScore.buildLookup(bean.getDyspneaScore());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.FollowUpShortVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.FollowUpShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.FollowUpShortVoBean();
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
		if(fieldName.equals("MORBIDITYCODESURGERY"))
			return getMorbidityCodeSurgery();
		if(fieldName.equals("MORBIDITYCODECANCERCHEMOTHERAPY"))
			return getMorbidityCodeCancerChemotherapy();
		if(fieldName.equals("MORBIDITYCODECANCERRADIOTHERAPY"))
			return getMorbidityCodeCancerRadiotherapy();
		if(fieldName.equals("MORBIDITYCODECANCERCOMBINATION"))
			return getMorbidityCodeCancerCombination();
		if(fieldName.equals("DYSPNEASCORE"))
			return getDyspneaScore();
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
	public boolean getMorbidityCodeSurgeryIsNotNull()
	{
		return this.morbiditycodesurgery != null;
	}
	public ims.oncology.vo.lookups.FUMorbiditySurgery getMorbidityCodeSurgery()
	{
		return this.morbiditycodesurgery;
	}
	public void setMorbidityCodeSurgery(ims.oncology.vo.lookups.FUMorbiditySurgery value)
	{
		this.isValidated = false;
		this.morbiditycodesurgery = value;
	}
	public boolean getMorbidityCodeCancerChemotherapyIsNotNull()
	{
		return this.morbiditycodecancerchemotherapy != null;
	}
	public ims.oncology.vo.lookups.FUMorbidityChemoTx getMorbidityCodeCancerChemotherapy()
	{
		return this.morbiditycodecancerchemotherapy;
	}
	public void setMorbidityCodeCancerChemotherapy(ims.oncology.vo.lookups.FUMorbidityChemoTx value)
	{
		this.isValidated = false;
		this.morbiditycodecancerchemotherapy = value;
	}
	public boolean getMorbidityCodeCancerRadiotherapyIsNotNull()
	{
		return this.morbiditycodecancerradiotherapy != null;
	}
	public ims.oncology.vo.lookups.FUMorbidityRadiotx getMorbidityCodeCancerRadiotherapy()
	{
		return this.morbiditycodecancerradiotherapy;
	}
	public void setMorbidityCodeCancerRadiotherapy(ims.oncology.vo.lookups.FUMorbidityRadiotx value)
	{
		this.isValidated = false;
		this.morbiditycodecancerradiotherapy = value;
	}
	public boolean getMorbidityCodeCancerCombinationIsNotNull()
	{
		return this.morbiditycodecancercombination != null;
	}
	public ims.oncology.vo.lookups.FUMorbidityCombination getMorbidityCodeCancerCombination()
	{
		return this.morbiditycodecancercombination;
	}
	public void setMorbidityCodeCancerCombination(ims.oncology.vo.lookups.FUMorbidityCombination value)
	{
		this.isValidated = false;
		this.morbiditycodecancercombination = value;
	}
	public boolean getDyspneaScoreIsNotNull()
	{
		return this.dyspneascore != null;
	}
	public ims.oncology.vo.lookups.FUDyspneaScore getDyspneaScore()
	{
		return this.dyspneascore;
	}
	public void setDyspneaScore(ims.oncology.vo.lookups.FUDyspneaScore value)
	{
		this.isValidated = false;
		this.dyspneascore = value;
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
		if(this.assessmentdate == null)
			listOfErrors.add("Assessment Date is mandatory");
		if(this.seenby == null)
			listOfErrors.add("SeenBy is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("Episode Of Care is mandatory");
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
	
		FollowUpShortVo clone = new FollowUpShortVo(this.id, this.version);
		
		if(this.assessmentdate == null)
			clone.assessmentdate = null;
		else
			clone.assessmentdate = (ims.framework.utils.Date)this.assessmentdate.clone();
		if(this.patientfollowupstatus == null)
			clone.patientfollowupstatus = null;
		else
			clone.patientfollowupstatus = (ims.oncology.vo.lookups.FUPatientFollowUpStatus)this.patientfollowupstatus.clone();
		if(this.treatmenttype == null)
			clone.treatmenttype = null;
		else
			clone.treatmenttype = (ims.oncology.vo.lookups.FUTreatmentType)this.treatmenttype.clone();
		if(this.primarytumourstatus == null)
			clone.primarytumourstatus = null;
		else
			clone.primarytumourstatus = (ims.oncology.vo.lookups.FUPrimaryTumourStatus)this.primarytumourstatus.clone();
		if(this.nodalstatus == null)
			clone.nodalstatus = null;
		else
			clone.nodalstatus = (ims.oncology.vo.lookups.FUNodalStatus)this.nodalstatus.clone();
		if(this.metastaticstatus == null)
			clone.metastaticstatus = null;
		else
			clone.metastaticstatus = (ims.oncology.vo.lookups.FUMetastaticStatus)this.metastaticstatus.clone();
		if(this.markerresponsestatus == null)
			clone.markerresponsestatus = null;
		else
			clone.markerresponsestatus = (ims.oncology.vo.lookups.FUMarkerResponseStatus)this.markerresponsestatus.clone();
		if(this.performancestatus == null)
			clone.performancestatus = null;
		else
			clone.performancestatus = (ims.oncology.vo.lookups.WHOPerformanceStatus)this.performancestatus.clone();
		if(this.seenby == null)
			clone.seenby = null;
		else
			clone.seenby = (ims.core.vo.HcpLiteVo)this.seenby.clone();
		clone.episodeofcare = this.episodeofcare;
		clone.carecontext = this.carecontext;
		if(this.morbiditycodesurgery == null)
			clone.morbiditycodesurgery = null;
		else
			clone.morbiditycodesurgery = (ims.oncology.vo.lookups.FUMorbiditySurgery)this.morbiditycodesurgery.clone();
		if(this.morbiditycodecancerchemotherapy == null)
			clone.morbiditycodecancerchemotherapy = null;
		else
			clone.morbiditycodecancerchemotherapy = (ims.oncology.vo.lookups.FUMorbidityChemoTx)this.morbiditycodecancerchemotherapy.clone();
		if(this.morbiditycodecancerradiotherapy == null)
			clone.morbiditycodecancerradiotherapy = null;
		else
			clone.morbiditycodecancerradiotherapy = (ims.oncology.vo.lookups.FUMorbidityRadiotx)this.morbiditycodecancerradiotherapy.clone();
		if(this.morbiditycodecancercombination == null)
			clone.morbiditycodecancercombination = null;
		else
			clone.morbiditycodecancercombination = (ims.oncology.vo.lookups.FUMorbidityCombination)this.morbiditycodecancercombination.clone();
		if(this.dyspneascore == null)
			clone.dyspneascore = null;
		else
			clone.dyspneascore = (ims.oncology.vo.lookups.FUDyspneaScore)this.dyspneascore.clone();
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
		if (!(FollowUpShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FollowUpShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((FollowUpShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((FollowUpShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.episodeofcare != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.morbiditycodesurgery != null)
			count++;
		if(this.morbiditycodecancerchemotherapy != null)
			count++;
		if(this.morbiditycodecancerradiotherapy != null)
			count++;
		if(this.morbiditycodecancercombination != null)
			count++;
		if(this.dyspneascore != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.oncology.vo.lookups.FUMorbiditySurgery morbiditycodesurgery;
	protected ims.oncology.vo.lookups.FUMorbidityChemoTx morbiditycodecancerchemotherapy;
	protected ims.oncology.vo.lookups.FUMorbidityRadiotx morbiditycodecancerradiotherapy;
	protected ims.oncology.vo.lookups.FUMorbidityCombination morbiditycodecancercombination;
	protected ims.oncology.vo.lookups.FUDyspneaScore dyspneascore;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
