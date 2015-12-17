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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3618.29606)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.ViewPatientCodingRecords;
import ims.RefMan.domain.base.impl.BaseReferralCodingImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.ReferralCoding;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.DischargeAndPASEventForReferralCodingVo;
import ims.RefMan.vo.DischargeAndPASEventForReferralCodingVoCollection;
import ims.RefMan.vo.ReferralCodingForViewVoCollection;
import ims.RefMan.vo.ReferralCodingRefVo;
import ims.RefMan.vo.ReferralCodingVo;
import ims.RefMan.vo.domain.DischargeAndPASEventForReferralCodingVoAssembler;
import ims.RefMan.vo.domain.ReferralCodingVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.pas.domain.objects.DischargedEpisode;
import ims.core.admin.pas.vo.DischargedEpisodeRefVo;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.Diagnosis;
import ims.core.clinical.domain.objects.NonUniqueTaxonomyMap;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.core.clinical.domain.objects.Procedure;
import ims.core.clinical.domain.objects.ReferralLetterDetails;
import ims.core.clinical.domain.objects.Service;
import ims.core.clinical.domain.objects.TaxonomyMap;
import ims.core.clinical.vo.DiagnosisRefVo;
import ims.core.clinical.vo.IntraOperativeCareRecordRefVo;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.clinical.vo.ProcedureRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.DiagnosisVo;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.DischargedEpisodeVoCollection;
import ims.core.vo.PatientListVo;
import ims.core.vo.PatientProcedureShortWithCareIntraOperativeVo;
import ims.core.vo.PatientProcedureShortWithCareIntraOperativeVoCollection;
import ims.core.vo.ProcedureVo;
import ims.core.vo.domain.CareContextLiteVoAssembler;
import ims.core.vo.domain.DiagnosisVoAssembler;
import ims.core.vo.domain.DischargedEpisodeVoAssembler;
import ims.core.vo.domain.PatientDiagnosisListVoAssembler;
import ims.core.vo.domain.PatientListVoAssembler;
import ims.core.vo.domain.PatientProcedureShortWithCareIntraOperativeVoAssembler;
import ims.core.vo.domain.ProcedureVoAssembler;
import ims.core.vo.lookups.PatientProcedureStatus;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.configuration.domain.objects.InvestigationIndex;
import ims.ocrr.configuration.vo.InvestigationIndexRefVo;
import ims.ocrr.vo.InvestigationIndexVo;
import ims.ocrr.vo.OrderInvestigationLiteVoCollection;
import ims.ocrr.vo.domain.InvestigationIndexVoAssembler;
import ims.ocrr.vo.domain.OrderInvestigationLiteVoAssembler;
import ims.ocrr.vo.lookups.Category;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.scheduling.vo.BookingAppointmentOutpatientCodingVoCollection;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.domain.BookingAppointmentOutpatientCodingVoAssembler;
import ims.scheduling.vo.lookups.Status_Reason;

import java.util.ArrayList;
import java.util.List;

public class ReferralCodingImpl extends BaseReferralCodingImpl
{

	private static final long serialVersionUID = 1L;

	private static final String REFERRAL_CODING_SOURCE_DISCHARGE = "DischargeSummary";
	private static final String REFERRAL_CODING_SOURCE_ADMISSIONS = "ReferralAdmissions";

	/**
	 * listProcedureByClinicalContact
	 */
	public PatientProcedureShortWithCareIntraOperativeVoCollection listProcedureForReferral(ims.core.admin.vo.CareContextRefVo careContextlRefVo)
	{
		DomainFactory factory = getDomainFactory();

		String hql = new String();
		hql = " from PatientProcedure patproc ";

		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";

		condStr.append(andStr + " patproc.careContext.id = :carecontextId");
		markers.add("carecontextId");
		values.add(careContextlRefVo.getID_CareContext());
		andStr = " and ";

		condStr.append(andStr + " patproc.procedureStatus = :performed");
		markers.add("performed");
		values.add(getDomLookup(PatientProcedureStatus.PERFORMED));

		hql += " where ";
		hql += condStr.toString();

		PatientProcedureShortWithCareIntraOperativeVoCollection voColl = PatientProcedureShortWithCareIntraOperativeVoAssembler.createPatientProcedureShortWithCareIntraOperativeVoCollectionFromPatientProcedure(factory.find(hql, markers, values)).sort();

		// WDEV-15358
		// Populate the planned procedure's intraoperative record
		// this is needed in order to check if the procedures' planned procedure
		// has
		// the intraoperative care record held against it
		if (voColl != null)
		{
			for (int i = 0; i < voColl.size(); i++)
			{
				PatientProcedureShortWithCareIntraOperativeVo vo = voColl.get(i);
				// Only get the planned intraoperative record if this
				// procedure's value is null
				if (!vo.getIntraOperativeRecordIsNotNull() && vo.getPlannedProcIsNotNull())
				{
					PatientProcedure domProc = (PatientProcedure) factory.getDomainObject(PatientProcedure.class, vo.getPlannedProc().getID_PatientProcedure());
					if (domProc != null && domProc.getIntraOperativeRecord() != null)
						vo.setPlannedIntraoperativeRecord(new IntraOperativeCareRecordRefVo(domProc.getIntraOperativeRecord().getId(), domProc.getIntraOperativeRecord().getVersion()));
				}
			}
		}
		return voColl;
	}

	/**
	 * Diagnosis / Complications for a Care Context
	 */
	public ims.core.vo.PatientDiagnosisListVoCollection listDiagnosisComplicationsForReferral(ims.core.admin.vo.CareContextRefVo careContextRefVo)
	{
		DomainFactory factory = getDomainFactory();

		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";

		condStr.append(andStr + " patdiag.careContext.id = :carecontextId");
		markers.add("carecontextId");
		values.add(careContextRefVo.getID_CareContext());
		andStr = " and ";

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisListVoAssembler.createPatientDiagnosisListVoCollectionFromPatientDiagnosis(factory.find(hql, markers, values)).sort();
	}

	public ims.RefMan.vo.ReferralCodingVo saveReferralCoding(ReferralCodingVo referralCodingVo, DischargedEpisodeRefVo dischargedEpisodeRef) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (referralCodingVo == null)
			throw new CodingRuntimeException("Logical error - referralCodingVo is null in domain.save");

		if (!referralCodingVo.isValidated())
			throw new CodingRuntimeException("Logical error - Validate the Vo before saving");

		DomainFactory factory = getDomainFactory();

		// WDEV-18542
		if (dischargedEpisodeRef != null)
		{
			DischargedEpisode domDischargedEpisode = (DischargedEpisode) factory.getDomainObject(dischargedEpisodeRef);

			domDischargedEpisode.setIsCoded(Boolean.TRUE);
			factory.save(domDischargedEpisode);
		}

		ReferralCoding domRC = ReferralCodingVoAssembler.extractReferralCoding(factory, referralCodingVo);
		factory.save(domRC);

		return ReferralCodingVoAssembler.create(domRC);
	}

	public ims.core.vo.CareContextLiteVo getCareContext(ims.RefMan.vo.CatsReferralRefVo catsRefVo)
	{
		DomainFactory factory = getDomainFactory();

		if (catsRefVo != null && catsRefVo.getID_CatsReferralIsNotNull())
		{
			java.util.List list = factory.find("select careContext from CatsReferral cats where cats.id = :catsID", new String[] { "catsID" }, new Object[] { catsRefVo.getID_CatsReferral() });
			if (list != null && list.size() > 0)
				return CareContextLiteVoAssembler.create((CareContext) list.get(0));
			else
				return null;
		}

		return null;
	}

	public DiagnosisVo getDiagnosisWithTaxonomyMappings(DiagnosisRefVo diagRefVo)
	{
		DomainFactory factory = getDomainFactory();
		Diagnosis med = (Diagnosis) factory.getDomainObject(Diagnosis.class, diagRefVo.getID_Diagnosis());
		return (DiagnosisVoAssembler.create(med));
	}

	public ProcedureVo getProcedureWithTaxonomyMappings(ProcedureRefVo procRefVo)
	{
		DomainFactory factory = getDomainFactory();
		Procedure proc = (Procedure) factory.getDomainObject(Procedure.class, procRefVo.getID_Procedure());
		return (ProcedureVoAssembler.create(proc));
	}

	public ReferralCodingVo getReferralCoding(CatsReferralRefVo catsRefVo, PASEventRefVo pasEventRefVo)
	{
		if (catsRefVo == null && pasEventRefVo == null)
			return null;

		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		if (catsRefVo != null)
		{
			hql = "from ReferralCoding as rc where rc.catsReferral.id = :refID";
			paramNames.add("refID");
			paramValues.add(catsRefVo.getID_CatsReferral());
		}
		else
		{
			hql = "from ReferralCoding as rc where rc.pasEvent.id = :pasID";
			paramNames.add("pasID");
			paramValues.add(pasEventRefVo.getID_PASEvent());
		}
		
		hql += " and (rc.isRIE is null or rc.isRIE = 0)"; //WDEV-19154
		
		List list = factory.find(hql, paramNames, paramValues);

		if (list != null && list.size() > 0)
			return ReferralCodingVoAssembler.create((ReferralCoding) list.get(0));

		return null;
	}

	public DischargeAndPASEventForReferralCodingVoCollection listPASEvents(CatsReferralRefVo voCatsReferralRef)
	{
		if (ConfigFlag.DOM.REFERRAL_CODING_SOURCE.getValue().equals(REFERRAL_CODING_SOURCE_DISCHARGE))
		{
			DomainFactory factory = getDomainFactory();

			String hql = "SELECT dspw from DischargeSummaryPacuAndWard dspw where dspw.catsReferral.id = :catsId";

			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Object> values = new ArrayList<Object>();

			markers.add("catsId");
			values.add(voCatsReferralRef.getID_CatsReferral());

			return DischargeAndPASEventForReferralCodingVoAssembler.createDischargeAndPASEventForReferralCodingVoCollectionFromDischargeSummaryPacuAndWard(factory.find(hql, markers, values)).sort();
		}
		else if (ConfigFlag.DOM.REFERRAL_CODING_SOURCE.getValue().equals(REFERRAL_CODING_SOURCE_ADMISSIONS))
		{
			String query = "SELECT de FROM CatsReferral AS ref LEFT JOIN ref.admissions AS adm, DischargedEpisode AS de RIGHT JOIN de.admissionDetail AS addet WHERE addet.id = adm.id AND ref.id = :CATS_ID AND de is not null";
			DischargedEpisodeVoCollection dischargedEpisodes = DischargedEpisodeVoAssembler.createDischargedEpisodeVoCollectionFromDischargedEpisode(getDomainFactory().find(query, "CATS_ID", voCatsReferralRef.getID_CatsReferral()));

			DischargeAndPASEventForReferralCodingVoCollection results = new DischargeAndPASEventForReferralCodingVoCollection();

			for (DischargedEpisodeVo episode : dischargedEpisodes)
			{
				DischargeAndPASEventForReferralCodingVo result = new DischargeAndPASEventForReferralCodingVo();

				result.setCatsReferral(voCatsReferralRef);
				result.setDischargeEpisode(episode);
				result.setDischargeDateTime(episode.getDischargeDateTime());

				results.add(result);
			}

			return results;
		}

		return null;
	}

	public PatientProcedureShortWithCareIntraOperativeVoCollection listNonSFSProcedures(CareContextRefVo careContextlRefVo)
	{
		String hql = "select c1 from PatientProcedure as c1 left join c1.intraOperativeRecord as i1_1 where (c1.plannedProc is not null " + "and c1.careContext.id = :careContextId " + "and i1_1.wasPlannedProcedure = 1 and " + "c1.plannedProc.id not in (select c12.id from SuitableForSurgeryAssessment as c11 left join c11.procedure as c12 " + "where (c11.procedure is not null and c11.careContext.id = :careContextId)))";

		List dos = getDomainFactory().find(hql, new String[] { "careContextId" }, new Object[] { careContextlRefVo.getID_CareContext() });
		return PatientProcedureShortWithCareIntraOperativeVoAssembler.createPatientProcedureShortWithCareIntraOperativeVoCollectionFromPatientProcedure(dos).sort();
	}

	// WDEV-18539
	public PatientListVo getPatientRef(CatsReferralRefVo catsReferralRef)
	{
		DomainFactory factory = getDomainFactory();

		if (catsReferralRef != null && catsReferralRef.getID_CatsReferralIsNotNull())
		{
			java.util.List list = factory.find("select patient from CatsReferral cats where cats.id = :catsID", new String[] { "catsID" }, new Object[] { catsReferralRef.getID_CatsReferral() });
			if (list != null && list.size() > 0)
				return PatientListVoAssembler.create((Patient) list.get(0));
			else
				return null;
		}

		return null;
	}

	public BookingAppointmentOutpatientCodingVoCollection getSeenAppointmentsForReferral(CatsReferralRefVo referralRef)
	{
		if (referralRef == null)
		{
			throw new CodingRuntimeException("Cannot get Appointments on null ReferralID");
		}

		DomainFactory factory = getDomainFactory();

		String hql = "select appt from CatsReferral as catsRef left join catsRef.appointments as appt left join appt.apptStatus as status where (catsRef.id = :catsRefId and status.id = :seenStatusID) order by appt.appointmentDate desc, appt.apptStartTime desc";

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		markers.add("catsRefId");
		values.add(referralRef.getID_CatsReferral());

		markers.add("seenStatusID");
		values.add(Status_Reason.SEEN.getID());

		return BookingAppointmentOutpatientCodingVoAssembler.createBookingAppointmentOutpatientCodingVoCollectionFromBooking_Appointment(factory.find(hql, markers, values));
	}

	public ReferralCodingVo getReferralCodingForAppointment(Booking_AppointmentRefVo appointmentRef)
	{
		if (appointmentRef == null)
		{
			throw new CodingRuntimeException("Cannot get CodingReferral on null AppointmentId ");
		}

		DomainFactory factory = getDomainFactory();
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		String hql = "select rc from ReferralCoding as rc left join rc.appointment as appt where appt.id = :apptID and (rc.isRIE is null or rc.isRIE = 0)";  //WDEV-19154
		paramNames.add("apptID");
		paramValues.add(appointmentRef.getID_Booking_Appointment());

		List list = factory.find(hql, paramNames, paramValues);

		if (list != null && list.size() > 0)
			return ReferralCodingVoAssembler.create((ReferralCoding) list.get(0));

		return null;
	}

	public InvestigationIndexVo getInvestigationWithTaxonomyMappings(InvestigationIndexRefVo investigationRef)
	{
		DomainFactory factory = getDomainFactory();
		InvestigationIndex inv = (InvestigationIndex) factory.getDomainObject(InvestigationIndex.class, investigationRef.getID_InvestigationIndex());
		return InvestigationIndexVoAssembler.create(inv);
	}

	public OrderInvestigationLiteVoCollection listResultedRadiologyInvForReferral(CatsReferralRefVo referralRef, ReferralCodingRefVo referralCodingRef)
	{
		if (referralRef == null)
		{
			throw new CodingRuntimeException("Cannot get Investigations on null ReferralID");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select orderInvs from CatsReferral as catsRef left join catsRef.investigationOrders as invOrders left join invOrders.investigations as orderInvs left join orderInvs.investigation as investig left join investig.investigationIndex as invIndex left join orderInvs.resultDetails as rezultDet left join orderInvs.ordInvCurrentStatus.ordInvStatus as invStatus where catsRef.id = :catsRefId and invIndex.category.id = :investigationType and invStatus.id <> :cancelledStatus and rezultDet is not null ");

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		markers.add("catsRefId");
		values.add(referralRef.getID_CatsReferral());

		markers.add("investigationType");
		values.add(Category.CLINICALIMAGING.getID());

		markers.add("cancelledStatus");
		values.add(OrderInvStatus.CANCELLED.getID());

		return OrderInvestigationLiteVoAssembler.createOrderInvestigationLiteVoCollectionFromOrderInvestigation(factory.find(hql.toString(), markers, values)).sort();
	}

	public List getAlreadyAddedInvestigationsIDs(CatsReferralRefVo referralRef)
	{
		
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		hql.append(" select distinct orderInvs.id from ReferralCoding as referral left join referral.catsReferral as catsRef left join referral.codingItems as coding left join coding.investigation as orderInvs where catsRef.id = :catsReferralID and orderInvs is not null and (referral.isRIE is null or referral.isRIE = 0) ");

		markers.add("catsReferralID");
		values.add(referralRef.getID_CatsReferral());

		return factory.find(hql.toString(), markers, values);

	}

	public Boolean procedureAlreadyAdded(CatsReferralRefVo referralRef, PatientProcedureRefVo procedureRef)
	{
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();

		hql.append(" select count(referral.id) from ReferralCoding as referral left join referral.catsReferral as catsRef left join referral.codingItems as coding left join coding.patientProcedure as patProc where catsRef.id = :catsReferralID and patProc.id = :procedureID and (referral.isRIE is null or referral.isRIE = 0)");

		Object[] count = factory.find(hql.toString(), new String[] { "catsReferralID", "procedureID" }, new Object[] { referralRef.getID_CatsReferral(), procedureRef.getID_PatientProcedure() }).toArray();

		if (count != null && count.length > 0)
			if (((Long) count[0]).intValue() > 0)
				return true;

		return false;
	}

	public PatientProcedureShortWithCareIntraOperativeVoCollection listOutpatientCodingProceduresForReferral(CatsReferralRefVo catsReferralRef, CareContextRefVo careContextRef)
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		hql.append(" select patProc from PatientProcedure as patProc left join patProc.careContext as cc left join patProc.procedureStatus as procStatus where cc.id = :careContextId and procStatus.id = :statusId");
	
		markers.add("careContextId");
		values.add(careContextRef.getID_CareContext());
		
		markers.add("statusId");
		values.add(PatientProcedureStatus.PERFORMED.getID());
		
		return PatientProcedureShortWithCareIntraOperativeVoAssembler.createPatientProcedureShortWithCareIntraOperativeVoCollectionFromPatientProcedure(factory.find(hql.toString(), markers, values)).sort();
	}

	public List getAlreadyAddedProceduresIDs(CatsReferralRefVo catsReferralRef)
	{
		
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		hql.append(" select distinct patProc.id from ReferralCoding as referral left join referral.catsReferral as catsRef left join referral.codingItems as coding left join coding.patientProcedure as patProc where catsRef.id = :catsReferralID and patProc is not null and (referral.isRIE is null or referral.isRIE = 0)");

		markers.add("catsReferralID");
		values.add(catsReferralRef.getID_CatsReferral());

		return factory.find(hql.toString(), markers, values);

	}

	//WDEV-19351
	public Boolean isInpatientNonSuitableForSurgery(CatsReferralRefVo referralRef)
	{
		if (referralRef == null || referralRef.getID_CatsReferral() == null)
			return false;

		DomainFactory factory = getDomainFactory();

		CatsReferral domRef = (CatsReferral) factory.getDomainObject(CatsReferral.class, referralRef.getID_CatsReferral());

		ReferralLetterDetails domRefLet = domRef.getReferralDetails();

		if (domRefLet == null)
			return false;

		Service service = domRefLet.getService();

		if (service == null || service.getTaxonomyMap() == null)
			return false;

		for (int i = 0; i < service.getTaxonomyMap().size(); i++)
		{
			NonUniqueTaxonomyMap map = (NonUniqueTaxonomyMap) service.getTaxonomyMap().get(i); //WDEV-20760

			if (map.getTaxonomyName().getId() == TaxonomyType.CDS.getID() && map.getTaxonomyCode().startsWith("INPATIENT_NO_SFS"))
			{
				return true;
			}
		}

		return false;
	}

	//WDEV-19610
	public Boolean hasPatientMoreReferralCodings(PatientRefVo patientRef, ReferralCodingVo refCodingToBeExcluded)
	{
		ViewPatientCodingRecords impl = (ViewPatientCodingRecords) getDomainImpl(ViewPatientCodingRecordsImpl.class);
		
		ReferralCodingForViewVoCollection collRefCod = impl.getReferralCodings(patientRef, refCodingToBeExcluded);
		
		if (collRefCod!=null && collRefCod.size()>0)
			return true;
		
		return false;
			
	}

}
