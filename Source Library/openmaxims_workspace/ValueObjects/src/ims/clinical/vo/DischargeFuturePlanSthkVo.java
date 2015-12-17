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

package ims.clinical.vo;

/**
 * Linked to eDischarge.FuturePlan business object (ID: 1099100000).
 */
public class DischargeFuturePlanSthkVo extends ims.edischarge.vo.FuturePlanRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IEDischargeSummary
{
	private static final long serialVersionUID = 1L;

	public DischargeFuturePlanSthkVo()
	{
	}
	public DischargeFuturePlanSthkVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeFuturePlanSthkVo(ims.clinical.vo.beans.DischargeFuturePlanSthkVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.followupdetails = ims.clinical.vo.DischargeFuturePlanFollowUpVoCollection.buildFromBeanCollection(bean.getFollowUpDetails());
		this.hospitalplan = bean.getHospitalPlan();
		this.actionsforgpandcommunity = bean.getActionsforGPandCommunity();
		this.livesalone = bean.getLivesAlone() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getLivesAlone());
		this.medicalcertificationissued = bean.getMedicalCertificationIssued() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getMedicalCertificationIssued());
		this.statementoffitnesstoworkissue = bean.getStatementOfFitnessToWorkIssue() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getStatementOfFitnessToWorkIssue());
		this.certificateexpiresdate = bean.getCertificateExpiresDate() == null ? null : bean.getCertificateExpiresDate().buildDate();
		this.certificatestartsdate = bean.getCertificateStartsDate() == null ? null : bean.getCertificateStartsDate().buildDate();
		this.fittoreturntowork = bean.getFitToReturnToWork() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getFitToReturnToWork());
		this.returntoworkadvice = bean.getReturnToWorkAdvice() == null ? null : ims.clinical.vo.lookups.ReturnToWorkAdvice.buildLookup(bean.getReturnToWorkAdvice());
		this.adviceapplicatiablefor = bean.getAdviceApplicatiableFor();
		this.adviceapplicatiableforunit = bean.getAdviceApplicatiableForUnit() == null ? null : ims.clinical.vo.lookups.AdviceApplicatiableForUnit.buildLookup(bean.getAdviceApplicatiableForUnit());
		this.comments = bean.getComments();
		this.wasnurseenableddischarge = bean.getWasNurseEnabledDischarge();
		this.nurseenabledinstructions = bean.getNurseEnabledInstructions() == null ? null : bean.getNurseEnabledInstructions().buildVo();
		this.iscomplete = bean.getIsComplete();
		this.hospitalfollowup = bean.getHospitalFollowUp() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getHospitalFollowUp());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.DischargeFuturePlanSthkVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.followupdetails = ims.clinical.vo.DischargeFuturePlanFollowUpVoCollection.buildFromBeanCollection(bean.getFollowUpDetails());
		this.hospitalplan = bean.getHospitalPlan();
		this.actionsforgpandcommunity = bean.getActionsforGPandCommunity();
		this.livesalone = bean.getLivesAlone() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getLivesAlone());
		this.medicalcertificationissued = bean.getMedicalCertificationIssued() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getMedicalCertificationIssued());
		this.statementoffitnesstoworkissue = bean.getStatementOfFitnessToWorkIssue() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getStatementOfFitnessToWorkIssue());
		this.certificateexpiresdate = bean.getCertificateExpiresDate() == null ? null : bean.getCertificateExpiresDate().buildDate();
		this.certificatestartsdate = bean.getCertificateStartsDate() == null ? null : bean.getCertificateStartsDate().buildDate();
		this.fittoreturntowork = bean.getFitToReturnToWork() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getFitToReturnToWork());
		this.returntoworkadvice = bean.getReturnToWorkAdvice() == null ? null : ims.clinical.vo.lookups.ReturnToWorkAdvice.buildLookup(bean.getReturnToWorkAdvice());
		this.adviceapplicatiablefor = bean.getAdviceApplicatiableFor();
		this.adviceapplicatiableforunit = bean.getAdviceApplicatiableForUnit() == null ? null : ims.clinical.vo.lookups.AdviceApplicatiableForUnit.buildLookup(bean.getAdviceApplicatiableForUnit());
		this.comments = bean.getComments();
		this.wasnurseenableddischarge = bean.getWasNurseEnabledDischarge();
		this.nurseenabledinstructions = bean.getNurseEnabledInstructions() == null ? null : bean.getNurseEnabledInstructions().buildVo(map);
		this.iscomplete = bean.getIsComplete();
		this.hospitalfollowup = bean.getHospitalFollowUp() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getHospitalFollowUp());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.DischargeFuturePlanSthkVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.DischargeFuturePlanSthkVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.DischargeFuturePlanSthkVoBean();
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
		if(fieldName.equals("FOLLOWUPDETAILS"))
			return getFollowUpDetails();
		if(fieldName.equals("HOSPITALPLAN"))
			return getHospitalPlan();
		if(fieldName.equals("ACTIONSFORGPANDCOMMUNITY"))
			return getActionsforGPandCommunity();
		if(fieldName.equals("LIVESALONE"))
			return getLivesAlone();
		if(fieldName.equals("MEDICALCERTIFICATIONISSUED"))
			return getMedicalCertificationIssued();
		if(fieldName.equals("STATEMENTOFFITNESSTOWORKISSUE"))
			return getStatementOfFitnessToWorkIssue();
		if(fieldName.equals("CERTIFICATEEXPIRESDATE"))
			return getCertificateExpiresDate();
		if(fieldName.equals("CERTIFICATESTARTSDATE"))
			return getCertificateStartsDate();
		if(fieldName.equals("FITTORETURNTOWORK"))
			return getFitToReturnToWork();
		if(fieldName.equals("RETURNTOWORKADVICE"))
			return getReturnToWorkAdvice();
		if(fieldName.equals("ADVICEAPPLICATIABLEFOR"))
			return getAdviceApplicatiableFor();
		if(fieldName.equals("ADVICEAPPLICATIABLEFORUNIT"))
			return getAdviceApplicatiableForUnit();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("WASNURSEENABLEDDISCHARGE"))
			return getWasNurseEnabledDischarge();
		if(fieldName.equals("NURSEENABLEDINSTRUCTIONS"))
			return getNurseEnabledInstructions();
		if(fieldName.equals("ISCOMPLETE"))
			return getIsComplete();
		if(fieldName.equals("HOSPITALFOLLOWUP"))
			return getHospitalFollowUp();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getFollowUpDetailsIsNotNull()
	{
		return this.followupdetails != null;
	}
	public ims.clinical.vo.DischargeFuturePlanFollowUpVoCollection getFollowUpDetails()
	{
		return this.followupdetails;
	}
	public void setFollowUpDetails(ims.clinical.vo.DischargeFuturePlanFollowUpVoCollection value)
	{
		this.isValidated = false;
		this.followupdetails = value;
	}
	public boolean getHospitalPlanIsNotNull()
	{
		return this.hospitalplan != null;
	}
	public String getHospitalPlan()
	{
		return this.hospitalplan;
	}
	public static int getHospitalPlanMaxLength()
	{
		return 3500;
	}
	public void setHospitalPlan(String value)
	{
		this.isValidated = false;
		this.hospitalplan = value;
	}
	public boolean getActionsforGPandCommunityIsNotNull()
	{
		return this.actionsforgpandcommunity != null;
	}
	public String getActionsforGPandCommunity()
	{
		return this.actionsforgpandcommunity;
	}
	public static int getActionsforGPandCommunityMaxLength()
	{
		return 3500;
	}
	public void setActionsforGPandCommunity(String value)
	{
		this.isValidated = false;
		this.actionsforgpandcommunity = value;
	}
	public boolean getLivesAloneIsNotNull()
	{
		return this.livesalone != null;
	}
	public ims.core.vo.lookups.YesNo getLivesAlone()
	{
		return this.livesalone;
	}
	public void setLivesAlone(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.livesalone = value;
	}
	public boolean getMedicalCertificationIssuedIsNotNull()
	{
		return this.medicalcertificationissued != null;
	}
	public ims.core.vo.lookups.YesNo getMedicalCertificationIssued()
	{
		return this.medicalcertificationissued;
	}
	public void setMedicalCertificationIssued(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.medicalcertificationissued = value;
	}
	public boolean getStatementOfFitnessToWorkIssueIsNotNull()
	{
		return this.statementoffitnesstoworkissue != null;
	}
	public ims.core.vo.lookups.YesNo getStatementOfFitnessToWorkIssue()
	{
		return this.statementoffitnesstoworkissue;
	}
	public void setStatementOfFitnessToWorkIssue(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.statementoffitnesstoworkissue = value;
	}
	public boolean getCertificateExpiresDateIsNotNull()
	{
		return this.certificateexpiresdate != null;
	}
	public ims.framework.utils.Date getCertificateExpiresDate()
	{
		return this.certificateexpiresdate;
	}
	public void setCertificateExpiresDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.certificateexpiresdate = value;
	}
	public boolean getCertificateStartsDateIsNotNull()
	{
		return this.certificatestartsdate != null;
	}
	public ims.framework.utils.Date getCertificateStartsDate()
	{
		return this.certificatestartsdate;
	}
	public void setCertificateStartsDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.certificatestartsdate = value;
	}
	public boolean getFitToReturnToWorkIsNotNull()
	{
		return this.fittoreturntowork != null;
	}
	public ims.core.vo.lookups.YesNo getFitToReturnToWork()
	{
		return this.fittoreturntowork;
	}
	public void setFitToReturnToWork(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.fittoreturntowork = value;
	}
	public boolean getReturnToWorkAdviceIsNotNull()
	{
		return this.returntoworkadvice != null;
	}
	public ims.clinical.vo.lookups.ReturnToWorkAdvice getReturnToWorkAdvice()
	{
		return this.returntoworkadvice;
	}
	public void setReturnToWorkAdvice(ims.clinical.vo.lookups.ReturnToWorkAdvice value)
	{
		this.isValidated = false;
		this.returntoworkadvice = value;
	}
	public boolean getAdviceApplicatiableForIsNotNull()
	{
		return this.adviceapplicatiablefor != null;
	}
	public Integer getAdviceApplicatiableFor()
	{
		return this.adviceapplicatiablefor;
	}
	public void setAdviceApplicatiableFor(Integer value)
	{
		this.isValidated = false;
		this.adviceapplicatiablefor = value;
	}
	public boolean getAdviceApplicatiableForUnitIsNotNull()
	{
		return this.adviceapplicatiableforunit != null;
	}
	public ims.clinical.vo.lookups.AdviceApplicatiableForUnit getAdviceApplicatiableForUnit()
	{
		return this.adviceapplicatiableforunit;
	}
	public void setAdviceApplicatiableForUnit(ims.clinical.vo.lookups.AdviceApplicatiableForUnit value)
	{
		this.isValidated = false;
		this.adviceapplicatiableforunit = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 3500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getWasNurseEnabledDischargeIsNotNull()
	{
		return this.wasnurseenableddischarge != null;
	}
	public Boolean getWasNurseEnabledDischarge()
	{
		return this.wasnurseenableddischarge;
	}
	public void setWasNurseEnabledDischarge(Boolean value)
	{
		this.isValidated = false;
		this.wasnurseenableddischarge = value;
	}
	public boolean getNurseEnabledInstructionsIsNotNull()
	{
		return this.nurseenabledinstructions != null;
	}
	public ims.clinical.vo.NurseEnabledInstructionsVo getNurseEnabledInstructions()
	{
		return this.nurseenabledinstructions;
	}
	public void setNurseEnabledInstructions(ims.clinical.vo.NurseEnabledInstructionsVo value)
	{
		this.isValidated = false;
		this.nurseenabledinstructions = value;
	}
	public boolean getIsCompleteIsNotNull()
	{
		return this.iscomplete != null;
	}
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.isValidated = false;
		this.iscomplete = value;
	}
	public boolean getHospitalFollowUpIsNotNull()
	{
		return this.hospitalfollowup != null;
	}
	public ims.core.vo.lookups.YesNo getHospitalFollowUp()
	{
		return this.hospitalfollowup;
	}
	public void setHospitalFollowUp(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.hospitalfollowup = value;
	}
	/**
	* getIEDischargeSummaryIsComplete()
	*/
	public Boolean getIEDischargeSummaryIsComplete()
	{
		return Boolean.TRUE.equals(this.iscomplete);
	}
	/**
	* getIEDischargeSummarySection()
	*/
	public ims.clinical.vo.lookups.EDischargeSummarySection getIEDischargeSummarySection()
	{
		return ims.clinical.vo.lookups.EDischargeSummarySection.FUTURE_PLAN;
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
		if(this.followupdetails != null)
		{
			if(!this.followupdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.nurseenabledinstructions != null)
		{
			if(!this.nurseenabledinstructions.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.followupdetails != null)
		{
			String[] listOfOtherErrors = this.followupdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.hospitalplan != null)
			if(this.hospitalplan.length() > 3500)
				listOfErrors.add("The length of the field [hospitalplan] in the value object [ims.clinical.vo.DischargeFuturePlanSthkVo] is too big. It should be less or equal to 3500");
		if(this.actionsforgpandcommunity != null)
			if(this.actionsforgpandcommunity.length() > 3500)
				listOfErrors.add("The length of the field [actionsforgpandcommunity] in the value object [ims.clinical.vo.DischargeFuturePlanSthkVo] is too big. It should be less or equal to 3500");
		if(this.comments != null)
			if(this.comments.length() > 3500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.clinical.vo.DischargeFuturePlanSthkVo] is too big. It should be less or equal to 3500");
		if(this.nurseenabledinstructions != null)
		{
			String[] listOfOtherErrors = this.nurseenabledinstructions.validate();
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
	
		DischargeFuturePlanSthkVo clone = new DischargeFuturePlanSthkVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.followupdetails == null)
			clone.followupdetails = null;
		else
			clone.followupdetails = (ims.clinical.vo.DischargeFuturePlanFollowUpVoCollection)this.followupdetails.clone();
		clone.hospitalplan = this.hospitalplan;
		clone.actionsforgpandcommunity = this.actionsforgpandcommunity;
		if(this.livesalone == null)
			clone.livesalone = null;
		else
			clone.livesalone = (ims.core.vo.lookups.YesNo)this.livesalone.clone();
		if(this.medicalcertificationissued == null)
			clone.medicalcertificationissued = null;
		else
			clone.medicalcertificationissued = (ims.core.vo.lookups.YesNo)this.medicalcertificationissued.clone();
		if(this.statementoffitnesstoworkissue == null)
			clone.statementoffitnesstoworkissue = null;
		else
			clone.statementoffitnesstoworkissue = (ims.core.vo.lookups.YesNo)this.statementoffitnesstoworkissue.clone();
		if(this.certificateexpiresdate == null)
			clone.certificateexpiresdate = null;
		else
			clone.certificateexpiresdate = (ims.framework.utils.Date)this.certificateexpiresdate.clone();
		if(this.certificatestartsdate == null)
			clone.certificatestartsdate = null;
		else
			clone.certificatestartsdate = (ims.framework.utils.Date)this.certificatestartsdate.clone();
		if(this.fittoreturntowork == null)
			clone.fittoreturntowork = null;
		else
			clone.fittoreturntowork = (ims.core.vo.lookups.YesNo)this.fittoreturntowork.clone();
		if(this.returntoworkadvice == null)
			clone.returntoworkadvice = null;
		else
			clone.returntoworkadvice = (ims.clinical.vo.lookups.ReturnToWorkAdvice)this.returntoworkadvice.clone();
		clone.adviceapplicatiablefor = this.adviceapplicatiablefor;
		if(this.adviceapplicatiableforunit == null)
			clone.adviceapplicatiableforunit = null;
		else
			clone.adviceapplicatiableforunit = (ims.clinical.vo.lookups.AdviceApplicatiableForUnit)this.adviceapplicatiableforunit.clone();
		clone.comments = this.comments;
		clone.wasnurseenableddischarge = this.wasnurseenableddischarge;
		if(this.nurseenabledinstructions == null)
			clone.nurseenabledinstructions = null;
		else
			clone.nurseenabledinstructions = (ims.clinical.vo.NurseEnabledInstructionsVo)this.nurseenabledinstructions.clone();
		clone.iscomplete = this.iscomplete;
		if(this.hospitalfollowup == null)
			clone.hospitalfollowup = null;
		else
			clone.hospitalfollowup = (ims.core.vo.lookups.YesNo)this.hospitalfollowup.clone();
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
		if (!(DischargeFuturePlanSthkVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeFuturePlanSthkVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargeFuturePlanSthkVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargeFuturePlanSthkVo)obj).getBoId());
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
		if(this.followupdetails != null)
			count++;
		if(this.hospitalplan != null)
			count++;
		if(this.actionsforgpandcommunity != null)
			count++;
		if(this.livesalone != null)
			count++;
		if(this.medicalcertificationissued != null)
			count++;
		if(this.statementoffitnesstoworkissue != null)
			count++;
		if(this.certificateexpiresdate != null)
			count++;
		if(this.certificatestartsdate != null)
			count++;
		if(this.fittoreturntowork != null)
			count++;
		if(this.returntoworkadvice != null)
			count++;
		if(this.adviceapplicatiablefor != null)
			count++;
		if(this.adviceapplicatiableforunit != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.wasnurseenableddischarge != null)
			count++;
		if(this.nurseenabledinstructions != null)
			count++;
		if(this.iscomplete != null)
			count++;
		if(this.hospitalfollowup != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 18;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.clinical.vo.DischargeFuturePlanFollowUpVoCollection followupdetails;
	protected String hospitalplan;
	protected String actionsforgpandcommunity;
	protected ims.core.vo.lookups.YesNo livesalone;
	protected ims.core.vo.lookups.YesNo medicalcertificationissued;
	protected ims.core.vo.lookups.YesNo statementoffitnesstoworkissue;
	protected ims.framework.utils.Date certificateexpiresdate;
	protected ims.framework.utils.Date certificatestartsdate;
	protected ims.core.vo.lookups.YesNo fittoreturntowork;
	protected ims.clinical.vo.lookups.ReturnToWorkAdvice returntoworkadvice;
	protected Integer adviceapplicatiablefor;
	protected ims.clinical.vo.lookups.AdviceApplicatiableForUnit adviceapplicatiableforunit;
	protected String comments;
	protected Boolean wasnurseenableddischarge;
	protected ims.clinical.vo.NurseEnabledInstructionsVo nurseenabledinstructions;
	protected Boolean iscomplete;
	protected ims.core.vo.lookups.YesNo hospitalfollowup;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
