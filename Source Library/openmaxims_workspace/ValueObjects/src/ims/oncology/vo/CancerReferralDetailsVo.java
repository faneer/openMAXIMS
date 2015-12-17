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
 * Linked to Oncology.CancerReferralDetails business object (ID: 1074100046).
 */
public class CancerReferralDetailsVo extends ims.oncology.vo.CancerReferralDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CancerReferralDetailsVo()
	{
	}
	public CancerReferralDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public CancerReferralDetailsVo(ims.oncology.vo.beans.CancerReferralDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.pasreferral = bean.getPASReferral() == null ? null : bean.getPASReferral().buildVo();
		this.assessment = bean.getAssessment() == null ? null : bean.getAssessment().buildVo();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo();
		this.tumourrel = bean.getTumourRel();
		this.firsttherainter = bean.getFirstTheraInter() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getFirstTheraInter());
		this.perfstatus = bean.getPerfStatus() == null ? null : ims.oncology.vo.lookups.PatientPerformanceStatus.buildLookup(bean.getPerfStatus());
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.CancerReferralDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.pasreferral = bean.getPASReferral() == null ? null : bean.getPASReferral().buildVo(map);
		this.assessment = bean.getAssessment() == null ? null : bean.getAssessment().buildVo(map);
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo(map);
		this.tumourrel = bean.getTumourRel();
		this.firsttherainter = bean.getFirstTheraInter() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getFirstTheraInter());
		this.perfstatus = bean.getPerfStatus() == null ? null : ims.oncology.vo.lookups.PatientPerformanceStatus.buildLookup(bean.getPerfStatus());
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.CancerReferralDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.CancerReferralDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.CancerReferralDetailsVoBean();
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
		if(fieldName.equals("PASREFERRAL"))
			return getPASReferral();
		if(fieldName.equals("ASSESSMENT"))
			return getAssessment();
		if(fieldName.equals("AUTHORINGINFO"))
			return getAuthoringInfo();
		if(fieldName.equals("TUMOURREL"))
			return getTumourRel();
		if(fieldName.equals("FIRSTTHERAINTER"))
			return getFirstTheraInter();
		if(fieldName.equals("PERFSTATUS"))
			return getPerfStatus();
		if(fieldName.equals("DIAGNOSIS"))
			return getDiagnosis();
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
	public boolean getPASReferralIsNotNull()
	{
		return this.pasreferral != null;
	}
	public ims.core.vo.PASReferralVo getPASReferral()
	{
		return this.pasreferral;
	}
	public void setPASReferral(ims.core.vo.PASReferralVo value)
	{
		this.isValidated = false;
		this.pasreferral = value;
	}
	public boolean getAssessmentIsNotNull()
	{
		return this.assessment != null;
	}
	public ims.assessment.vo.PatientAssessmentVo getAssessment()
	{
		return this.assessment;
	}
	public void setAssessment(ims.assessment.vo.PatientAssessmentVo value)
	{
		this.isValidated = false;
		this.assessment = value;
	}
	public boolean getAuthoringInfoIsNotNull()
	{
		return this.authoringinfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinfo = value;
	}
	public boolean getTumourRelIsNotNull()
	{
		return this.tumourrel != null;
	}
	public Boolean getTumourRel()
	{
		return this.tumourrel;
	}
	public void setTumourRel(Boolean value)
	{
		this.isValidated = false;
		this.tumourrel = value;
	}
	public boolean getFirstTheraInterIsNotNull()
	{
		return this.firsttherainter != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getFirstTheraInter()
	{
		return this.firsttherainter;
	}
	public void setFirstTheraInter(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.firsttherainter = value;
	}
	public boolean getPerfStatusIsNotNull()
	{
		return this.perfstatus != null;
	}
	public ims.oncology.vo.lookups.PatientPerformanceStatus getPerfStatus()
	{
		return this.perfstatus;
	}
	public void setPerfStatus(ims.oncology.vo.lookups.PatientPerformanceStatus value)
	{
		this.isValidated = false;
		this.perfstatus = value;
	}
	public boolean getDiagnosisIsNotNull()
	{
		return this.diagnosis != null;
	}
	public ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo value)
	{
		this.isValidated = false;
		this.diagnosis = value;
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
		if(this.assessment != null)
		{
			if(!this.assessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinfo != null)
		{
			if(!this.authoringinfo.isValidated())
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
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.pasreferral == null)
			listOfErrors.add("PASReferral is mandatory");
		if(this.assessment != null)
		{
			String[] listOfOtherErrors = this.assessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringinfo != null)
		{
			String[] listOfOtherErrors = this.authoringinfo.validate();
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
	
		CancerReferralDetailsVo clone = new CancerReferralDetailsVo(this.id, this.version);
		
		clone.episodeofcare = this.episodeofcare;
		if(this.pasreferral == null)
			clone.pasreferral = null;
		else
			clone.pasreferral = (ims.core.vo.PASReferralVo)this.pasreferral.clone();
		if(this.assessment == null)
			clone.assessment = null;
		else
			clone.assessment = (ims.assessment.vo.PatientAssessmentVo)this.assessment.clone();
		if(this.authoringinfo == null)
			clone.authoringinfo = null;
		else
			clone.authoringinfo = (ims.core.vo.AuthoringInformationVo)this.authoringinfo.clone();
		clone.tumourrel = this.tumourrel;
		if(this.firsttherainter == null)
			clone.firsttherainter = null;
		else
			clone.firsttherainter = (ims.core.vo.lookups.YesNoUnknown)this.firsttherainter.clone();
		if(this.perfstatus == null)
			clone.perfstatus = null;
		else
			clone.perfstatus = (ims.oncology.vo.lookups.PatientPerformanceStatus)this.perfstatus.clone();
		if(this.diagnosis == null)
			clone.diagnosis = null;
		else
			clone.diagnosis = (ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo)this.diagnosis.clone();
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
		if (!(CancerReferralDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CancerReferralDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CancerReferralDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CancerReferralDetailsVo)obj).getBoId());
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
		if(this.pasreferral != null)
			count++;
		if(this.assessment != null)
			count++;
		if(this.authoringinfo != null)
			count++;
		if(this.tumourrel != null)
			count++;
		if(this.firsttherainter != null)
			count++;
		if(this.perfstatus != null)
			count++;
		if(this.diagnosis != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.vo.PASReferralVo pasreferral;
	protected ims.assessment.vo.PatientAssessmentVo assessment;
	protected ims.core.vo.AuthoringInformationVo authoringinfo;
	protected Boolean tumourrel;
	protected ims.core.vo.lookups.YesNoUnknown firsttherainter;
	protected ims.oncology.vo.lookups.PatientPerformanceStatus perfstatus;
	protected ims.oncology.vo.PatientDiagnosisForPrimaryTumourVo diagnosis;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
