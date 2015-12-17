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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.80 build 4027.29767)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.RefMan.domain.objects.CATSReferralStatus;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.DischargeSummaryPacuAndWard;
import ims.RefMan.domain.objects.SuitableForSurgeryAssessment;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.clinical.domain.objects.PatientInvasiveDevice;
import ims.clinical.domain.objects.VIPScore;
import ims.coe.vo.RiskAssessmentCollection;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.QuestionInformation;
import ims.core.domain.base.impl.BasePatientSummaryOverviewImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.domain.objects.GpToPractice;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.vo.AppointmentHistoryForSummaryOverviewVo;
import ims.core.vo.AppointmentHistoryForSummaryOverviewVoCollection;
import ims.core.vo.IntraOperativeCRforSummaryOverviewVo;
import ims.core.vo.PatientSummaryOverviewVo;
import ims.core.vo.RiskAssessmentForSummaryOverviewVo;
import ims.core.vo.RiskAssessmentForSummaryOverviewVoCollection;
import ims.core.vo.domain.GpToPracticesForSummaryOverviewVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.IntraOperativeCRforSummaryOverviewVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.PatientAlertLiteVoAssembler;
import ims.core.vo.domain.PatientAllergyForSummaryOverviewVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.nursing.assessmenttools.domain.objects.MUST;
import ims.nursing.assessmenttools.domain.objects.Waterlow;
import ims.nursing.vo.WaterlowAssessmentDetailsVoCollection;
import ims.nursing.vo.WaterlowAssessmentVo;
import ims.nursing.vo.domain.WaterlowAssessmentVoAssembler;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.domain.objects.Session_ListOwner;
import ims.vo.domain.DomainObjectMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PatientSummaryOverviewImpl extends BasePatientSummaryOverviewImpl
{

	private static final long serialVersionUID = 1L;
	
	public final static HashMap<String, Integer> codeToPosMappings = new HashMap<String, Integer>();
	
	static
	{
	codeToPosMappings.put("VTE", 0);
	codeToPosMappings.put("REP", 2);
	codeToPosMappings.put("FLS", 3);
	codeToPosMappings.put("NVO", 5);
	codeToPosMappings.put("MOH", 6);
	codeToPosMappings.put("BDR",7);
	codeToPosMappings.put("DRM", 8);
	}

	public PatientSummaryOverviewVo getPatientSummaryOverview(CareContextRefVo careContext, PatientRefVo pat)
	{
		DomainObjectMap doMap = new DomainObjectMap();
		String hql = "select gtp from GpToPractice as gtp, Patient as pat	" + "where (pat.gp.id = gtp.gp.id and gtp.isPrimaryPractice = 1 and pat.id = :patId and gtp.isRIE is null  and pat.isRIE is null )";
		PatientSummaryOverviewVo result = new PatientSummaryOverviewVo();
		DomainFactory df = getDomainFactory();
		DomainObject doo = df.findFirst(hql, "patId", pat.getID_Patient());
		if (doo instanceof GpToPractice)
			result.setGp(GpToPracticesForSummaryOverviewVoAssembler.create(doMap,(GpToPractice)doo));

		hql = "select iocr from IntraOperativeCareRecord as iocr left join  iocr.actualProcedure as ap where (iocr.careContext.id = :careId and iocr.isRIE is null and ap.isRIE is null) order by iocr.id desc";
		List<?> find = df.find(hql, "careId", careContext.getID_CareContext());
		if (find != null && find.size() > 0)
		{
			result.setSurgicalHistory(IntraOperativeCRforSummaryOverviewVoAssembler.createIntraOperativeCRforSummaryOverviewVoCollectionFromIntraOperativeCareRecord(doMap,find));
		}
		hql = "from PatientAlert as pa where (pa.patient.id = :patId and pa.isCurrentlyActiveAlert = 1 and pa.isRIE is null)";
		find = df.find(hql, "patId", pat.getID_Patient());
		if (find != null && find.size() > 0)
		{
			result.setPatientAlerts(PatientAlertLiteVoAssembler.createPatientAlertLiteVoCollectionFromPatientAlert(doMap,find));
		}
		hql = "from PatientAllergy as pa where (pa.patient.id =:patId  and pa.isCurrentlyActiveAllergy = 1 and pa.isRIE is null)";
		find = df.find(hql, "patId", pat.getID_Patient());
		if (find != null && find.size() > 0)
		{
			result.setPatientAllergies(PatientAllergyForSummaryOverviewVoAssembler.createPatientAllergyForSummaryOverviewVoCollectionFromPatientAllergy(doMap,find));
		}

		result.setAppointmentsHistory(new AppointmentHistoryForSummaryOverviewVoCollection());
		AppointmentHistoryForSummaryOverviewVo app = new AppointmentHistoryForSummaryOverviewVo();

		app = new AppointmentHistoryForSummaryOverviewVo();
		app.setType(4);
		if (result.getSurgicalHistoryIsNotNull() && result.getSurgicalHistory().size() > 0)
		{
			IntraOperativeCRforSummaryOverviewVo iocr = result.getSurgicalHistory().get(0);
			app.setHcp(iocr.getSurgeonIsNotNull() ? iocr.getSurgeon().getMos() : null);
			app.setDate(iocr.getSurgeryStartTimeIsNotNull() ? iocr.getSurgeryStartTime().getDate() : null);
		}
		result.getAppointmentsHistory().add(app);

		hql = "select cr from CatsReferral as cr where cr.careContext.id = :catId and cr.isRIE is null ) ";
		doo = df.findFirst(hql, "catId", careContext.getID_CareContext());

		if (doo instanceof CatsReferral)
		{

			CatsReferral referral = (CatsReferral) doo;
			if (referral.getReferralDetails() != null)
			{
				app = new AppointmentHistoryForSummaryOverviewVo();
				app.setType(0);
				app.setHcp(MemberOfStaffLiteVoAssembler.create(referral.getReferralDetails().getAuthoringUser()));
				app.setDate(new ims.framework.utils.Date(referral.getReferralDetails().getDateOfReferral()));
				result.getAppointmentsHistory().add(app);
			}
			if (referral.getStatusHistory() != null)
			{
				for (Object object : referral.getStatusHistory())
				{
					if (object instanceof CATSReferralStatus)
					{
						CATSReferralStatus x = (CATSReferralStatus) object;
						if (ReferralApptStatus.REFERRAL_ACCEPTED.getID() == x.getReferralStatus().getId())
						{
							app = new AppointmentHistoryForSummaryOverviewVo();
							app.setType(1);
							app.setHcp(MemberOfStaffLiteVoAssembler.create(doMap,x.getAuthoringUser()));
							app.setDate(new ims.framework.utils.Date(x.getStatusDateTime()));
							result.getAppointmentsHistory().add(app);
						}

					}

				}
			}

			if (referral.getAppointments() != null)
			{
				Iterator iterator = referral.getAppointments().iterator();
				if (iterator.hasNext())
				{
					Object next = iterator.next();
					if (next instanceof Booking_Appointment)
					{
						Booking_Appointment x = (Booking_Appointment) next;
						app = new AppointmentHistoryForSummaryOverviewVo();
						app.setType(2);
						//if (x.getSeenBy() != null)
						//	app.setHcp(MemberOfStaffLiteVoAssembler.create(doMap,x.getSeenBy().getMos()));
						if (x.getSession()!= null && x.getSession().getListOwners()!=null )
						{
							Iterator it = x.getSession().getListOwners().iterator();
							if (it.hasNext())
							{
								Object owner = it.next();
								if (owner instanceof Session_ListOwner)
								{
									Hcp hcp = ((Session_ListOwner) owner).getHcp();
									if (hcp!=null)
										app.setHcp(MemberOfStaffLiteVoAssembler.create(doMap,hcp.getMos()));
								}
							}
						}
						app.setDate(new ims.framework.utils.Date(x.getAppointmentDate()));
						result.getAppointmentsHistory().add(app);

					}
				}
			}

			hql = "select sfsa from SuitableForSurgeryAssessment as sfsa left join sfsa.careContext as cc where" + " (cc.id = :careId and sfsa.isRIE is null) order by sfsa.suitableForSurgeryDate desc ";

			doo = df.findFirst(hql, "careId", careContext.getID_CareContext());
			if (doo instanceof SuitableForSurgeryAssessment)
			{
				SuitableForSurgeryAssessment x = (SuitableForSurgeryAssessment) doo;
				app = new AppointmentHistoryForSummaryOverviewVo();
				app.setType(3);
				if (x.getNamedSurgeon()!=null)
					app.setHcp(MemberOfStaffLiteVoAssembler.create(doMap,x.getNamedSurgeon().getMos()));
				if (x.getSuitableForSurgeryDate()!= null)
					app.setDate(new ims.framework.utils.Date(x.getSuitableForSurgeryDate()));
				result.getAppointmentsHistory().add(app);
			}
			
			hql = "select sdpw from DischargeSummaryPacuAndWard as sdpw left join sdpw.catsReferral as cr left " +
					"join cr.careContext as cc where (cc.id = :careId and sdpw.isRIE is null) order by sdpw.authoringInformation.authoringDateTime desc ";
			doo = df.findFirst(hql,"careId",careContext.getID_CareContext());
			if (doo instanceof DischargeSummaryPacuAndWard)
			{
				DischargeSummaryPacuAndWard x = (DischargeSummaryPacuAndWard) doo;
				
				app = new AppointmentHistoryForSummaryOverviewVo();
				if (x.getAuthoringInformation()!= null)
				{
					if (x.getAuthoringInformation().getAuthoringHcp()!=null)
						app.setHcp(MemberOfStaffLiteVoAssembler.create(doMap,x.getAuthoringInformation().getAuthoringHcp().getMos()));
				}
				if (x.getDischargeDateTime()!=null)
				{
					app.setDate(new ims.framework.utils.Date(x.getDischargeDateTime()));
				}
				app.setType(5);
				
				result.getAppointmentsHistory().add(app);
			}
		}

		// Getting the score and auth info for Assessments
		hql = "select ua.id, tm.taxonomyCode from UserAssessment as ua" + " left join ua.taxonomyMap as tm left join tm.taxonomyName as tn where " + "(tn.id = :idTM and tm.taxonomyCode in ('VTE','REP','FLS','NVO','MOH','BDR','DRM') and ua.activeStatus.id = :active  and ua.isRIE is null) order by tm.taxonomyCode asc";
		find = df.find(hql, new String[] { "idTM", "active" }, new Object[] { TaxonomyType.MAXIMS_INTERNAL.getID(), PreActiveActiveInactiveStatus.ACTIVE.getID() });
		String lastCode = null;
		
		RiskAssessmentForSummaryOverviewVoCollection assessments = new RiskAssessmentForSummaryOverviewVoCollection();
		if (find != null && find.size() > 0)
		{
			for (int i = 0; i < find.size(); i++)
			{
				String code = null;
				Integer id = null;
				if (find.get(i) instanceof Object[])
				{
					Object[] array = (Object[]) find.get(i);
					if (array.length < 2)
						continue;
					if (array[0] instanceof Integer)
					{
						id = (Integer) array[0];
					}
					if (array[1] instanceof String)
					{
						code = (String) array[1];
					}
					if (id == null || code == null)
						throw new DomainRuntimeException("Invalid data found . Id or code null");

				}
				if (lastCode != null && lastCode.equals(code))
				{
					System.out.println("Two assessment with same mapping found: " + lastCode + "Skipping assessment with id: " + id);
					continue;
				}
				if (code != null)
				{
					 RiskAssessmentForSummaryOverviewVo scoreFor = getScoreFor(df, code, id,careContext);
					 if (scoreFor != null)
					 {
						 scoreFor.setAssessmentType(codeToPosMappings.get(code));
						 assessments.add(scoreFor);
					 }
				}

				lastCode = code;

			}
		}
		
		
			hql = "from Waterlow as waw where (waw.careContext.id = :contId and waw.isRIE is null ) order by waw.dateTimeInitiated desc" ;
			doo = df.findFirst(hql,"contId",careContext.getID_CareContext());
			if (doo instanceof Waterlow)
			{
				RiskAssessmentCollection risks = null;
				try
				{
					 risks = ims.core.helper.RiskAssessmentHelper.getWaterlowRisks();
				}
				catch (PresentationLogicException e)
				{
					e.printStackTrace();
				}
				if (risks != null)
				{
					WaterlowAssessmentVo wa = WaterlowAssessmentVoAssembler.create((Waterlow) doo);
					RiskAssessmentForSummaryOverviewVo ras = new RiskAssessmentForSummaryOverviewVo();
					ras.setAssessmentType(1);
					ras.setDate(wa.getDateTimeInitiatedIsNotNull()?wa.getDateTimeInitiated().getDate():null);
					ras.setHcp(wa.getHcpInitiated());
					ras.setScore(calculateScore(wa.getAssessmentDetails(),risks));
					assessments.add(ras);
					
				}
			}
			

			hql = "select  must from MUST as must " +
					"left join must.careContext as cc where (must.isRIE is null and cc.id=:careId)" +
					" order by must.authoringInformation.authoringDateTime desc";
			
			doo = df.findFirst(hql,"careId",careContext.getID_CareContext());
			if (doo instanceof MUST)
			{
				MUST x = (MUST) doo;
				RiskAssessmentForSummaryOverviewVo ras = new RiskAssessmentForSummaryOverviewVo();
				ras.setAssessmentType(9);
				if (x.getAuthoringInformation()!=null)
				{
					if (x.getAuthoringInformation().getAuthoringDateTime()!=null)
						ras.setDate(new ims.framework.utils.Date(x.getAuthoringInformation().getAuthoringDateTime()));
					if (x.getAuthoringInformation().getAuthoringHcp()!=null)
						ras.setHcp(HcpLiteVoAssembler.create(doMap, x.getAuthoringInformation().getAuthoringHcp()));
				}
				if (x.getORMScore()!=null)
					ras.setScore(String.valueOf(x.getORMScore()));
			
				assessments.add(ras);
							
			}
			hql = "from PatientInvasiveDevice as pid  where (pid.careContext.id = :careId) order by pid.systemInformation.creationDateTime desc";
			doo = df.findFirst(hql, "careId", careContext.getID_CareContext());
			if (doo instanceof PatientInvasiveDevice)
			{
				PatientInvasiveDevice x = (PatientInvasiveDevice) doo;
				if (x.getVIPScore()!= null && x.getVIPScore().size() > 0)
				{
					Object object = x.getVIPScore().get(x.getVIPScore().size()-1);
					if (object instanceof VIPScore)
					{
						VIPScore y = (VIPScore) object;
						RiskAssessmentForSummaryOverviewVo ras = new RiskAssessmentForSummaryOverviewVo();
						if (y.getAuthoringInformation()!=null)
						{
							if (y.getAuthoringInformation().getAuthoringDateTime()!=null)
							{
								ras.setDate(new ims.framework.utils.Date(y.getAuthoringInformation().getAuthoringDateTime()));
							}
							if (y.getAuthoringInformation().getAuthoringHcp()!=null)
							{
								ras.setHcp(HcpLiteVoAssembler.create(doMap, y.getAuthoringInformation().getAuthoringHcp()));
							}
							
						}
						if (y.getVIPScale()!=null)
						{
							ras.setScore(ims.clinical.vo.lookups.LookupHelper.getInvasiveDeviceVIPScale(getLookupService()).getInstance(y.getVIPScale().getId()).getText());
						}
						ras.setAssessmentType(4);
						assessments.add(ras);
					}
				}
				
			}
		if (assessments.size() > 0)
			result.setRiskAssessments(assessments);

		return result;

	}

	private String calculateScore(WaterlowAssessmentDetailsVoCollection assessmentDetails, RiskAssessmentCollection risks)
	{
		int score = 0;
		for (int i = 0 ; i < risks.size() ; i++)
		{
			if (!risks.get(i).getRiskFactorsIsNotNull())
				continue;
			for (int x = 0 ; x < risks.get(i).getRiskFactors().size() ; x++)
			{
    			
    			for (int j = 0 ; j < assessmentDetails.size() ; j++)
    			{ 
    				if (assessmentDetails.get(j).getSelectIsNotNull() && assessmentDetails.get(j).getSelect() && risks.get(i).getRiskFactors().get(x).getId().equals(String.valueOf(assessmentDetails.get(j).getAssessment())))
    				{
    					score+=Integer.valueOf(risks.get(i).getRiskFactors().get(x).getScore());
    				}
    			}
			}
		}
		return String.valueOf(score);
	}

	private RiskAssessmentForSummaryOverviewVo getScoreFor(DomainFactory domainFactory, String code, Integer id, CareContextRefVo careContext)
	{
		String hql = "select question from UserAssessment as ua left join ua.questionGroups as qg left join qg.questions as" + " questions left join questions.question as question left join question.taxonomyMap as tm left join tm.taxonomyName" + " as tn left join question.status as status where (ua.id = :assId and tm.taxonomyCode = :code and tn.id = :tnID and status.id = :statusId)";
		
		DomainObject dobj = getDomainFactory().findFirst(hql, new String[] { "assId", "code", "tnID", "statusId" }, new Object[] { id, code, TaxonomyType.MAXIMS_INTERNAL.getID(), PreActiveActiveInactiveStatus.ACTIVE.getID() });
		Integer questionId = null;
		if (dobj instanceof QuestionInformation)
			// Get Score from question
			questionId = ((QuestionInformation) dobj).getId();

		hql = null;
		ArrayList<String> paramName = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramName.add("aId");
		paramValues.add(id);
		paramName.add("careId");
		paramValues.add(careContext.getID_CareContext());
		if (questionId == null)
		{
			hql = "select pa.score, pa.authoringInformation.authoringDateTime, hcp from PatientAssessment as pa " +
				"left join pa.assessmentData as ad left join ad.userAssessment as ua left join" +
				" pa.authoringInformation.authoringHcp as hcp where (ua.id = :aId and pa.isRIE is null and pa.careContext.id=:careId)" +
				" order by pa.authoringInformation.authoringDateTime desc";
			
		}
		else
		{
			hql = "select adet.calculatedScore, pa.authoringInformation.authoringDateTime,pa.authoringInformation.authoringHcp " +
					"from PatientAssessment as pa left join pa.assessmentData as ad left join ad.userAssessment as ua left join " +
					"ad.answerGroups as ag left join ag.assessmentAnswers as aa left join aa.assessmentQuestion as aqs " +
					"left join aqs.question as qu left join aa.patientAnswers as pan left join pan.answerDetails as adet left join pa.authoringInformation.authoringHcp as ahcp " +
					"where (ua.id = :aId and qu.id = :qId and pa.isRIE is null and pa.careContext.id=:careId) order by pa.authoringInformation.authoringDateTime desc ";
			paramName.add("qId");
			paramValues.add(questionId);
		}
		List<?> result =domainFactory.find(hql, paramName,paramValues);
		if (result == null || result.size() == 0)
			return null;
		RiskAssessmentForSummaryOverviewVo voResult = null;
		if (result.get(0) instanceof Object[] )
		{
			Object[] array = (Object[]) result.get(0);
			if (array.length == 3)
			{
				voResult = new RiskAssessmentForSummaryOverviewVo();
				if (array[0] instanceof Float)
				{
					voResult.setScore( array[0].toString());
				}
				else if (array[0] instanceof Integer)
				{
					voResult.setScore(array[0].toString());
				}
				
				if (array[1] instanceof Date)
				{
					voResult.setDate(new ims.framework.utils.Date((Date) array[1]));
				}
				if (array[2] instanceof Hcp)
				{
					voResult.setHcp(HcpLiteVoAssembler.create((Hcp) array[2]));	
				}		
			}
		}
		

		

		return voResult;
	}
}
