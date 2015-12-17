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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3497.26747)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseEDischargeDiagnosisEtcComponentImpl;
import ims.clinical.helper.EDischargeHelper;
import ims.clinical.helper.IEDischargeHelper;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.RTLSummaryVo;
import ims.clinical.vo.domain.DischargeDetailsVoAssembler;
import ims.clinical.vo.domain.RTLSummaryVoAssembler;
import ims.clinical.vo.lookups.DischargeLetterStatus;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.PatientDiagnosis;
import ims.core.clinical.domain.objects.PatientNoDiagInfoForCC;
import ims.core.domain.Alerts;
import ims.core.domain.impl.AlertsImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.DischargeClinicalInformationSTHKVo;
import ims.core.vo.EpisodeOfCareCoMorbidityVo;
import ims.core.vo.EpisodeofCareShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientDiagnosisEDischargeListVo;
import ims.core.vo.PatientDiagnosisEDischargeListVoCollection;
import ims.core.vo.PatientNoDiagInfoForCCVo;
import ims.core.vo.domain.DischargeClinicalInformationSTHKVoAssembler;
import ims.core.vo.domain.PatientDiagnosisEDischargeListVoAssembler;
import ims.core.vo.domain.PatientDiagnosisEDischargeVoAssembler;
import ims.core.vo.domain.PatientNoDiagInfoForCCVoAssembler;
import ims.core.vo.lookups.PatientDiagnosisStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.edischarge.domain.objects.DischargeClinicalInformation;
import ims.edischarge.domain.objects.DischargeDetails;
import ims.edischarge.domain.objects.RTLSummary;
import ims.edischarge.vo.SummaryRefVo;
import ims.framework.FormName;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class EDischargeDiagnosisEtcComponentImpl extends BaseEDischargeDiagnosisEtcComponentImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Get OPDEDVo
	*/
	public ims.core.vo.PatientDiagnosisEDischargeVo getDiagnosisVo(ims.core.clinical.vo.PatientDiagnosisRefVo patdiagrefVo)
	{ 
		if(patdiagrefVo == null)
			throw new DomainRuntimeException("Cannot get PatientDiagnosisVo for null PatientDiagnosisRefVo");
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosis doPatientDiagnosis = (PatientDiagnosis)factory.getDomainObject(PatientDiagnosis.class,patdiagrefVo.getID_PatientDiagnosis());
		return PatientDiagnosisEDischargeVoAssembler.create(doPatientDiagnosis);
	}

	/**
	* saveDiagnosisVo
	*/
	public PatientDiagnosisEDischargeListVo saveDiagnosisVo(PatientDiagnosisEDischargeListVo patientDiagnosisEDischargeListVo, SummaryRefVo summaryVo) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException
	{
		// Ensure the value object has been validated
		if (!patientDiagnosisEDischargeListVo.isValidated())
			throw new DomainRuntimeException("Diagnosis has not been validated");
		
		DomainFactory factory = getDomainFactory();
		@SuppressWarnings("rawtypes")
		HashMap map = new HashMap();
		PatientDiagnosis doPatDiag = PatientDiagnosisEDischargeListVoAssembler.extractPatientDiagnosis(factory, patientDiagnosisEDischargeListVo, map);
		
		factory.save(doPatDiag);
		
		if (summaryVo != null
			&& patientDiagnosisEDischargeListVo.getIsComplicationIsNotNull()
			&& patientDiagnosisEDischargeListVo.getIsComorbidityIsNotNull()
			&& ! patientDiagnosisEDischargeListVo.getIsComplication()
			&& ! patientDiagnosisEDischargeListVo.getIsComorbidity())
		{
			IEDischargeHelper impl = (IEDischargeHelper) getDomainImpl(EDischargeHelper.class); 
			impl.updateSummaryIfRequired(patientDiagnosisEDischargeListVo, summaryVo, factory);
		}

		return PatientDiagnosisEDischargeListVoAssembler.create(doPatDiag);//Create here to avoid possible StaleObj in PMH save
	}

	/**
	 * Lists previous diagnosis for patient
	 * @param voPatRef
	 * @param episodeOfCareRefVo
	 * @param bComplication
	 * @param bComorbidity
	 * @param careContextDate
	 * @param ignored
	 * @return
	 */
	private PatientDiagnosisEDischargeListVoCollection domListAll(PatientRefVo voPatRef, EpisodeOfCareRefVo episodeOfCareRefVo, boolean bComplication, boolean bComorbidity, Date careContextDate, String ignored)//WDEV-12105
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " select patdiag from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";
		
		if (voPatRef != null) 
		{
			condStr.append(andStr + " patdiag.careContext.episodeOfCare.careSpell.patient.id = :patientId");
			markers.add("patientId");
			values.add(voPatRef.getID_Patient());
			andStr = " and ";	
			
			if (careContextDate != null)
			{
				condStr.append(andStr + " patdiag.careContext.episodeOfCare.startDate <= :ccStartDate");//WDEV-12042
				markers.add("ccStartDate");
				values.add(careContextDate.getDate());
			}
		}
		
		if (episodeOfCareRefVo != null) 
		{
			condStr.append(andStr).append(" patdiag.careContext.episodeOfCare.id = :epsId");
			
			markers.add("epsId");
			values.add(episodeOfCareRefVo.getID_EpisodeOfCare());
			andStr = " and ";

			condStr.append(andStr).append(" ( patdiag.isComplication = :complication");
			if (!bComplication)
			{
				condStr.append(" or patdiag.isComplication is null");
			}
			condStr.append(" ) ");
			markers.add("complication");
			values.add(bComplication);
		}

		condStr.append(andStr).append(" ( patdiag.isComorbidity = :notCommorb");
		if (!bComorbidity)
		{
			condStr.append(" or patdiag.isComorbidity is null");
		}
		condStr.append(" ) ");
		markers.add("notCommorb");
		values.add(bComorbidity);


		if (ignored!=null && ignored.length() > 0)//WDEV-12105
		{
			condStr.append(andStr+" patdiag.id not in (").append(ignored).append(")");//WDEV-12105
		}
		
		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisEDischargeListVoAssembler.createPatientDiagnosisEDischargeListVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}
	
	public ims.core.vo.PatientDiagnosisEDischargeListVoCollection listDiagnosis(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo)
	{
		return domListAll(null , episodeOfCareRefVo, false, false, null,null);
	}
	
	//WDEV-20225
	
	public PatientDiagnosisEDischargeListVoCollection listRelevantComorbidities(
			EpisodeOfCareRefVo episodeOfCareRefVo,
			CareContextRefVo careContextRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " SELECT pdiag FROM EpisodeOfCareCoMorbidity AS relevantDiag LEFT JOIN relevantDiag.diagnosis AS pdiag LEFT JOIN relevantDiag.careContext AS ccontext";
		
		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";
		
		if (episodeOfCareRefVo != null) 
		{
			condStr.append(andStr + " ccontext.episodeOfCare.id = :epsId");
			
			markers.add("epsId");
			values.add(episodeOfCareRefVo.getID_EpisodeOfCare());
			andStr = " and ";

			condStr.append(andStr + " ( pdiag.isComorbidity = :notCommorb) ");
			markers.add("notCommorb");
			values.add(new Boolean(true));

			condStr.append(andStr + " ( pdiag.isComplication = :complication or pdiag.isComplication is null) ");
			markers.add("complication");
			values.add(new Boolean(false));
		}
		if (careContextRefVo != null)
		{			
			condStr.append(andStr + " ccontext.id = :ccId and relevantDiag.isActive = :inclD ");
			markers.add("ccId");
			values.add(careContextRefVo.getID_CareContext());
			markers.add("inclD");
			values.add(Boolean.TRUE);
			andStr = " and ";	
		}
		

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisEDischargeListVoAssembler.createPatientDiagnosisEDischargeListVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}
	
	//WDEV-19820
	public PatientDiagnosisEDischargeListVoCollection listIncludedComorbidities(EpisodeOfCareRefVo episodeOfCareRefVo, CareContextRefVo careContextRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " select pdiag from IncludeDiagnosisInDischargeReport as inclDiag left join inclDiag.diagnosis as pdiag left join inclDiag.careContext as ccontext";
		
		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";
		
		if (episodeOfCareRefVo != null) 
		{
			condStr.append(andStr + " ccontext.episodeOfCare.id = :epsId");
			
			markers.add("epsId");
			values.add(episodeOfCareRefVo.getID_EpisodeOfCare());
			andStr = " and ";

			condStr.append(andStr + " ( pdiag.isComorbidity = :notCommorb) ");
			markers.add("notCommorb");
			values.add(new Boolean(true));

			condStr.append(andStr + " ( pdiag.isComplication = :complication or pdiag.isComplication is null) ");
			markers.add("complication");
			values.add(new Boolean(false));
		}
		if (careContextRefVo != null)
		{			
			condStr.append(andStr + " ccontext.id = :ccId and inclDiag.includeInReport = :inclD ");
			markers.add("ccId");
			values.add(careContextRefVo.getID_CareContext());
			markers.add("inclD");
			values.add(Boolean.TRUE);
			andStr = " and ";	
		}
		

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisEDischargeListVoAssembler.createPatientDiagnosisEDischargeListVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}

	public PatientDiagnosisEDischargeListVoCollection listComorbidity(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " select patdiag from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";
		
		if (episodeOfCareRefVo != null) 
		{
			condStr.append(andStr + " patdiag.careContext.episodeOfCare.id = :epsId");
			
			markers.add("epsId");
			values.add(episodeOfCareRefVo.getID_EpisodeOfCare());
			andStr = " and ";			

			condStr.append(andStr + " ( patdiag.isComorbidity = :notCommorb) ");
			markers.add("notCommorb");
			values.add(new Boolean(true));

			condStr.append(andStr + " ( patdiag.isComplication = :complication or patdiag.isComplication is null) ");
			markers.add("complication");
			values.add(new Boolean(false));
		}

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisEDischargeListVoAssembler.createPatientDiagnosisEDischargeListVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}

	public PatientDiagnosisEDischargeListVoCollection listComplications(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		return domListAll(null , episodeOfCareRefVo, true, false, null,null);
	}

	public PatientDiagnosisEDischargeListVoCollection listPreviousRecordsForPatient(PatientRefVo voPatRef, Date careContextDate,String ignored) 
	{
		return domListAll(voPatRef , null, true, false, careContextDate,ignored);
	}
	
	public PatientDiagnosisEDischargeListVoCollection listPreviousComorbidity(PatientRefVo patient, Date startDate, String ignored)
	{
		return domListAll(patient, null, false, true, startDate, ignored);
	}


	public DischargeDetailsVo getDischargeDetails(CareContextRefVo careContextRefvo)
	{
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.getDischargeDetails(careContextRefvo);
	}

	public DischargeDetailsVo saveDischargeDetails(DischargeDetailsVo voDischargeDetails, SummaryRefVo summaryVo, RTLSummaryVo rTLSummary, PatientNoDiagInfoForCCVo patientNoDiagInfo) throws DomainInterfaceException, StaleObjectException
	{
		if(voDischargeDetails == null)
			throw new CodingRuntimeException("DischargeDetailsVo is null");
		
		if(!voDischargeDetails.isValidated())
			throw new CodingRuntimeException("DischargeDetailsVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		
		DischargeDetails doDD = DischargeDetailsVoAssembler.extractDischargeDetails(factory, voDischargeDetails);
		factory.save(doDD);
		
		//WDEV-19685
		if (rTLSummary != null)
		{
			RTLSummary rTLSummaryDO = RTLSummaryVoAssembler.extractRTLSummary(factory, rTLSummary);
			factory.save(rTLSummaryDO);
		}
		
		//WDEV-18627
		if (patientNoDiagInfo != null)
		{
			PatientNoDiagInfoForCC patientNoDiagInfoDo = PatientNoDiagInfoForCCVoAssembler.extractPatientNoDiagInfoForCC(factory, patientNoDiagInfo);
			factory.save(patientNoDiagInfoDo);
		}
		
		if (summaryVo != null)
		{
			IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
			impl.updateSummaryIfRequired(voDischargeDetails, summaryVo, factory);
		}

		return DischargeDetailsVoAssembler.create(doDD);

	}

	/**
	 * WDEV-12689
	 * Function used to retrieve Discharge Clinical Information
	 */
	public DischargeClinicalInformationSTHKVo getDischargeClinicalInformation(CareContextRefVo careContext)
	{
		if (careContext == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from DischargeClinicalInformation clininfo where clininfo.careContext.id = :CC_ID and clininfo.isRIE is null");

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Serializable> values = new ArrayList<Serializable>();

		markers.add("CC_ID");
		values.add(careContext.getID_CareContext());

		return DischargeClinicalInformationSTHKVoAssembler.create((DischargeClinicalInformation) factory.findFirst(hql.toString(), markers, values));
	}

	public DischargeDetailsVo save(DischargeDetailsVo dd, PatientDiagnosisEDischargeListVoCollection diags, SummaryRefVo summary, RTLSummaryVo rTLSummaryVo, PatientNoDiagInfoForCCVo patientNoDiagInfo) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException
	{
		if (diags!=null)
		{
			for (int i = 0 ; i < diags.size() ; i++)
			{
				saveDiagnosisVo(diags.get(i),summary);
			}
		}
		
		return saveDischargeDetails(dd, summary,rTLSummaryVo, patientNoDiagInfo); //WDEV-18622
	}

	//WDEV-18622
	public void rieDiagnosis(PatientDiagnosisEDischargeListVo diag, FormName formName, PatientRefVo patientRef, Integer contactId, CareContextRefVo careContextRef, String rieMessage, SummaryRefVo summary, Integer whatsBeingRecordedInError, EpisodeofCareShortVo episodeOfCare) throws StaleObjectException
	{
	 
		if (summary!=null && summary.getID_SummaryIsNotNull())
		{
			//Check to see if letter status is generated 
			String sql = "select count(summ.id) from Summary as summ left join summ.dischargeLetterStatus as lookup where (summ.id=:summId and lookup.id = :idGenerated)";
			
			long count = getDomainFactory().countWithHQL(sql, new String[]{"summId","idGenerated"}, new Object[]{summary.getID_Summary(),DischargeLetterStatus.GENERATED.getID()});
			if (count >0)
				throw new StaleObjectException(null);
		}
		
		markAsRie(diag, formName, patientRef.getID_Patient(), contactId, careContextRef!=null ? careContextRef.getID_CareContext() : null, rieMessage);
		
		//WDEV-18622
		DomainFactory factory = getDomainFactory();
		
		RTLSummaryVo rTLSummary = populateRTLSummary(patientRef,careContextRef,episodeOfCare,whatsBeingRecordedInError);
		
		RTLSummary rTLSummaryDO = RTLSummaryVoAssembler.extractRTLSummary(factory, rTLSummary);
		factory.save(rTLSummaryDO);
		
		if (whatsBeingRecordedInError== -1) //DIAGNOSIS
		{
			PatientNoDiagInfoForCCVo patientNoDiagInfo = populatePatientNoDiagInfo(careContextRef, episodeOfCare, patientRef);
			
			if (patientNoDiagInfo != null)
			{
				PatientNoDiagInfoForCC patientNoDiagInfoDo = PatientNoDiagInfoForCCVoAssembler.extractPatientNoDiagInfoForCC(factory, patientNoDiagInfo);
				factory.save(patientNoDiagInfoDo);
			}
		}
		
	}

	private PatientNoDiagInfoForCCVo populatePatientNoDiagInfo(CareContextRefVo careContext, EpisodeofCareShortVo episodeOfCare, PatientRefVo patientRef)
	{
		if (careContext == null)
			return null;

		PatientDiagnosisEDischargeListVoCollection collDiagnosis = domListAll(null, episodeOfCare, false, false, null, null);

		if (collDiagnosis != null && collDiagnosis.size() > 0) // check if there are other dignoses recorded left
			return null;

		PatientNoDiagInfoForCCVo patientNoDiagInfo = getPatientNoDiagInfoForCareContext(careContext);

		if (patientNoDiagInfo != null)
		{

			AuthoringInformationVo authoringInformation = new AuthoringInformationVo();

			authoringInformation.setAuthoringHcp((HcpLiteVo) getHcpLiteUser());
			authoringInformation.setAuthoringDateTime(new DateTime());

			patientNoDiagInfo.setAuthoringInformation(authoringInformation);
			patientNoDiagInfo.setCareContext(careContext);
			patientNoDiagInfo.setPatient(patientRef);
			patientNoDiagInfo.setDiagnosisStatus(PatientDiagnosisStatus.NOLONGERRELEVANT);
		}

		return patientNoDiagInfo;
	}

	//WDEV-18622
	private RTLSummaryVo populateRTLSummary(PatientRefVo patientRef, CareContextRefVo careContextRef, EpisodeofCareShortVo episodeOfCare, Integer whatsBeingRecordedInError)
	{
		DischargeDetailsVo voDD = getDischargeDetails(careContextRef);
		
		RTLSummaryVo rTLSummary = getRTLSummaryForCareContext(careContextRef);
		
		if (rTLSummary==null)
		{
			rTLSummary=new RTLSummaryVo();
			rTLSummary.setCareContext(careContextRef); //WDEV-19216 
		}
		else
			rTLSummary=(RTLSummaryVo) rTLSummary.clone();
		
		if (whatsBeingRecordedInError== -1) //DIAGNOSIS
		{
			PatientDiagnosisEDischargeListVoCollection collDiagnosis = domListAll(null , episodeOfCare, false, false, null,null);
			rTLSummary.setWereDiagnosisDetailsEntered(Boolean.TRUE.equals(voDD.getHasNoDiagnosis()) || (collDiagnosis!=null && collDiagnosis.size()>0));
		}
		else if (whatsBeingRecordedInError== -2) //COMPLICATIONS
		{
			PatientDiagnosisEDischargeListVoCollection collComplications = domListAll(null , episodeOfCare, true, false, episodeOfCare!=null ? episodeOfCare.getStartDate() : null,null); //WDEV-19845
			rTLSummary.setWereComplicationsEntered(Boolean.TRUE.equals(voDD.getHasNoComplications()) || (collComplications!=null && collComplications.size()>0));
		}
		else if (whatsBeingRecordedInError== -3) //COMORBIDITY
		{
			PatientDiagnosisEDischargeListVoCollection collComorbidities = domListAll(patientRef , null, false, true, episodeOfCare!=null ? episodeOfCare.getStartDate() : null,null); 
			rTLSummary.setWereCoMorbiditiesEntered(Boolean.TRUE.equals(voDD.getHasNoComorbidities()) || isAtLeastOneComorbRelevant(collComorbidities, careContextRef)); //WDEV-20240
		}	
		
		return rTLSummary;
	}
	//WDEV-20240
	private boolean isAtLeastOneComorbRelevant(PatientDiagnosisEDischargeListVoCollection collComorbidities, CareContextRefVo careContextRef)
	{
		if (collComorbidities == null)
			return false;
		
		for (PatientDiagnosisEDischargeListVo comorbidity : collComorbidities)
		{
			if (comorbidity.getCoMorbidityForEpisodeOfCares() != null)
			{
				for (EpisodeOfCareCoMorbidityVo episodeComorbidity : comorbidity.getCoMorbidityForEpisodeOfCares())
				{
					if (episodeComorbidity.getIsActive() && episodeComorbidity.getCareContext().getID_CareContext().equals(careContextRef.getID_CareContext())) //WDEV-20265
						return true;
				}
			}
		}
		return false;
	}
	//--------------

	//WDEV-14653
	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeOfCareRefVo)
	{
		Alerts impl = (Alerts) getDomainImpl(AlertsImpl.class);
		return impl.getPIDDiagnosisInfo(careContextRefVo, episodeOfCareRefVo);
	}

	//WDEV-18622
	public RTLSummaryVo getRTLSummaryForCareContext(CareContextRefVo careContextRefVo)
	{
		IEDischargeHelper eDischImpl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return eDischImpl.getRTLSummaryForCareContext(careContextRefVo);	
	}

	public PatientNoDiagInfoForCCVo getPatientNoDiagInfoForCareContext(CareContextRefVo careContextRef)
	{
		if(careContextRef == null)
			   throw new CodingRuntimeException("Cannot get PatientNoDiagInfo on null careContext ");
		
		List<?> list = getDomainFactory().find("select patNoDiag from PatientNoDiagInfoForCC as patNoDiag left join patNoDiag.careContext as cc where cc.id = :careContextId)", 
				new String[] {"careContextId"}, new Object[] {careContextRef.getID_CareContext()});
		
		if (list == null || list.size() == 0)
			return null;
		
		return PatientNoDiagInfoForCCVoAssembler.createPatientNoDiagInfoForCCVoCollectionFromPatientNoDiagInfoForCC(list).get(0);
	}


	
}
