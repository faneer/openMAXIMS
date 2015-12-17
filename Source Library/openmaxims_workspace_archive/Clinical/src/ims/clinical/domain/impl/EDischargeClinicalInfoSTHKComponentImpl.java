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
// This code was generated by Peter Martin using IMS Development Environment (version 1.71 build 3940.18071)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.EDischargeHINTConfig;
import ims.admin.domain.impl.EDischargeHINTConfigImpl;
import ims.clinical.domain.EDischargeDiagnosisEtcComponent;
import ims.clinical.domain.base.impl.BaseEDischargeClinicalInfoSTHKComponentImpl;
import ims.clinical.helper.EDischargeHelper;
import ims.clinical.helper.IEDischargeHelper;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.lookups.EDischargeSummarySection;
import ims.clinical.vo.lookups.EDischargeSummarySectionStatus;
import ims.clinicaladmin.vo.lookups.EDischargeHINT;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.domain.Alerts;
import ims.core.domain.impl.AlertsImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.DischargeClinicalInformationSTHKVo;
import ims.core.vo.DischargeClinicalInformationSTHKVoCollection;
import ims.core.vo.FieldHelpVo;
import ims.core.vo.PatientAlertCollection;
import ims.core.vo.PatientDiagnosisEDischargeListVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.DischargeClinicalInformationSTHKVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.DischargeClinicalInformation;
import ims.edischarge.vo.SummaryRefVo;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.ocrr.vo.OrderInvestigationBookingVoCollection;
import ims.ocrr.vo.domain.OrderInvestigationBookingVoAssembler;
import ims.ocrr.vo.lookups.OrderInvStatus;

public class EDischargeClinicalInfoSTHKComponentImpl extends BaseEDischargeClinicalInfoSTHKComponentImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * get Clinicalinte
	 */
	public ims.core.vo.DischargeClinicalInformationSTHKVo getClinicalInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo)
	{
		if (careContextRefVo == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if (careContextRefVo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from DischargeClinicalInformation clininfo where ");
			String andStr = " ";

			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();

			hql.append(andStr + " clininfo.careContext.id = :careContextId");
			markers.add("careContextId");
			values.add(careContextRefVo.getID_CareContext());
			andStr = " and ";

			List listNotes = factory.find(hql.toString(), markers, values);
			if (listNotes != null && listNotes.size() > 0)
			{
				DischargeClinicalInformationSTHKVoCollection voColl = DischargeClinicalInformationSTHKVoAssembler.createDischargeClinicalInformationSTHKVoCollectionFromDischargeClinicalInformation(listNotes);
				if (voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	/**
	 * Save clinical info
	 */
	public ims.core.vo.DischargeClinicalInformationSTHKVo saveClinicalInfo(DischargeClinicalInformationSTHKVo voClinicalInfo, SummaryRefVo summary) throws ims.domain.exceptions.StaleObjectException
	{
		if (voClinicalInfo == null)
			throw new CodingRuntimeException("DischargeClinicalInformationVo is null");

		if (!voClinicalInfo.isValidated())
			throw new CodingRuntimeException("DischargeClinicalInformationVo Value Object Alert has not been validated");

		DomainFactory factory = getDomainFactory();
		DischargeClinicalInformation doClinInfo = DischargeClinicalInformationSTHKVoAssembler.extractDischargeClinicalInformation(factory, voClinicalInfo);// //

		if (!voClinicalInfo.getID_DischargeClinicalInformationIsNotNull())
		{
			List list = factory.find("from DischargeClinicalInformation as dci where dci.careContext.id = :CONTEXTID and dci.isRIE is null", new String[] { "CONTEXTID" }, new Object[] { voClinicalInfo.getCareContext().getID_CareContext() });
			if (list != null && list.size() > 0)
			{
				throw new StaleObjectException(null);
			}
		}

		factory.save(doClinInfo);
		
		IEDischargeHelper impl = (IEDischargeHelper) getDomainImpl(EDischargeHelper.class); 
		impl.updateSummaryIfRequired(voClinicalInfo, summary, factory);
		
		return DischargeClinicalInformationSTHKVoAssembler.create(doClinInfo);
	}

	public FieldHelpVo getHintByLookupID(EDischargeHINT voLookup)
	{
		EDischargeHINTConfig impl = (EDischargeHINTConfig) getDomainImpl(EDischargeHINTConfigImpl.class);
		return impl.getHintByLookupID(voLookup);
	}

	public OrderInvestigationBookingVoCollection listInvestigationResults(PatientRefVo patientRefVo, Integer numDays)
	{
		if (numDays == null)
			throw new CodingRuntimeException("Invalid numDays");

		if (patientRefVo == null)
			throw new CodingRuntimeException("Invalid patientRefVo");

		Date dtFrom = new Date().addDay(-numDays);

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		StringBuffer sb = new StringBuffer(" from OrderInvestigation as oi where ");

		sb.append(" oi.systemInformation.creationDateTime >= :fromDate");
		markers.add("fromDate");
		values.add(dtFrom.getDate());

		sb.append(" and ( oi.pathResultDetails != null");
		sb.append(" or oi.radReportingDetails != null)");

		sb.append(" and ");
		sb.append(" oi.orderDetails.patient.id = :pat ");
		markers.add("pat");
		values.add(patientRefVo.getID_Patient());

		sb.append(" order by oi.repDateTime desc, oi.ordInvSeq asc");

		List result = getDomainFactory().find(sb.toString(), markers, values);
		return OrderInvestigationBookingVoAssembler.createOrderInvestigationBookingVoCollectionFromOrderInvestigation(result);
	}

	public PatientAlertCollection listPatientAlerts(PatientShort patient, Boolean active) {
		Alerts impl = (Alerts) getDomainImpl(AlertsImpl.class);
		return impl.listPatientAlerts(patient, active);
	}

	public DischargeDetailsVo getDischargeDetails(CareContextRefVo careContextRefvo) {
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.getDischargeDetails(careContextRefvo);
	}

	public DischargeDetailsVo saveDischargeDetails(DischargeDetailsVo voDischargeDetails, SummaryRefVo summary) throws StaleObjectException, DomainInterfaceException {
		EDischargeDiagnosisEtcComponent impl = (EDischargeDiagnosisEtcComponent)getDomainImpl(EDischargeDiagnosisEtcComponentImpl.class);
		return impl.saveDischargeDetails(voDischargeDetails, summary);
	}


	public Boolean hasDiagnosis(EpisodeOfCareRefVo episodeOfCareRefVo) {
		EDischargeDiagnosisEtcComponent impl = (EDischargeDiagnosisEtcComponent) getDomainImpl(EDischargeDiagnosisEtcComponentImpl.class);
		PatientDiagnosisEDischargeListVoCollection coll = impl.listDiagnosis(episodeOfCareRefVo);
		if(coll==null || coll.size()==0)
			return false;
		
		return true;
	}

	public Boolean hasComorbidity(EpisodeOfCareRefVo episodeOfCareRefVo) {
		EDischargeDiagnosisEtcComponent impl = (EDischargeDiagnosisEtcComponent) getDomainImpl(EDischargeDiagnosisEtcComponentImpl.class);
		PatientDiagnosisEDischargeListVoCollection coll = impl.listComorbidity(episodeOfCareRefVo);
		if(coll==null || coll.size()==0)
			return false;
		
		return true;
	}

	public Boolean hasComplications(EpisodeOfCareRefVo episodeOfCareRefVo) {
		EDischargeDiagnosisEtcComponent impl = (EDischargeDiagnosisEtcComponent) getDomainImpl(EDischargeDiagnosisEtcComponentImpl.class);
		PatientDiagnosisEDischargeListVoCollection coll = impl.listComplications(episodeOfCareRefVo);
		if(coll==null || coll.size()==0)
			return false;
		
		return true;
	}

	//WDEV-11817
	public Boolean isSectionComplete(SummaryRefVo summary, EDischargeSummarySection section)
	{
		final String hql = "select count(summ.id) from Summary as summ left join summ.summaryDetails " +
				"as sd left join sd.section as sec left join sd.progressStatus as prgress where " +
				"(summ.id = :summary and prgress.id = :progress and sec.id = :section and summ.isRIE is null)";
		
		long count = getDomainFactory().countWithHQL(hql, new String[]{"summary","progress","section"}, new Object[]{summary.getID_Summary(),EDischargeSummarySectionStatus.COMPLETED.getID(),section.getID()});
		return count > 0;
	}

	//WDEV-13046
	public OrderInvestigationBookingVoCollection listPendingResults(PatientRefVo patient, CareContextShortVo careContext) 
	{
		if(patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Can not list investigations that are requested during the inpatient stay on null Patient.");
		if(careContext == null)
			throw new CodingRuntimeException("Can not list investigations that are requested during the inpatient stay on null CareContext.");
		
		StringBuffer sb = new StringBuffer(" from OrderInvestigation as oi where ");
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		sb.append(" oi.orderDetails.patient.id = :pat ");
		markers.add("pat");
		values.add(patient.getID_Patient());
		
		sb.append(" and ");
		sb.append(" oi.systemInformation.creationDateTime >= :fromDate");
		markers.add("fromDate");
		values.add(careContext.getStartDateTime().getJavaDate());
		
		sb.append(" and ");
		sb.append(" oi.systemInformation.creationDateTime <= :toDate");
		markers.add("toDate");
		values.add(careContext.getEndDateTime() != null ? careContext.getEndDateTime().getJavaDate() : new DateTime().getJavaDate());
		
		sb.append(" and ");
		sb.append(" oi.ordInvCurrentStatus.ordInvStatus.id in (:statusAwaiting, :statusOrdered, :statusSent, :statusReceived, :statusAccepted, :statusInProgress, :statusScheduled, :statusCompleted, :statusAwaitingAppointment, :statusHeld) ");
		markers.add("statusAwaiting");
		values.add(OrderInvStatus.AWAITING_AUTHORISATION.getID());
		markers.add("statusOrdered");
		values.add(OrderInvStatus.ORDERED.getID());
		markers.add("statusSent");
		values.add(OrderInvStatus.SENT.getID());
		markers.add("statusReceived");
		values.add(OrderInvStatus.RECEIVED.getID());
		markers.add("statusAccepted");
		values.add(OrderInvStatus.ACCEPTED.getID());
		markers.add("statusInProgress");
		values.add(OrderInvStatus.INPROGRESS.getID());
		markers.add("statusScheduled");
		values.add(OrderInvStatus.INPROGRESS_SCH.getID());
		markers.add("statusCompleted");
		values.add(OrderInvStatus.COMPLETE.getID());
		markers.add("statusAwaitingAppointment");
		values.add(OrderInvStatus.ORDERED_AWAITING_APPT.getID());
		markers.add("statusHeld");
		values.add(OrderInvStatus.HELD.getID());
		
		sb.append(" order by oi.displayDateTime desc");

		List<?> result = getDomainFactory().find(sb.toString(), markers, values);
		return OrderInvestigationBookingVoAssembler.createOrderInvestigationBookingVoCollectionFromOrderInvestigation(result);
	}
}
