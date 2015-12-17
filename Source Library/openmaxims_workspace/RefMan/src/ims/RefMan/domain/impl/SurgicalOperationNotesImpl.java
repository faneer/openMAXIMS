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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4087.18341)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseSurgicalOperationNotesImpl;
import ims.RefMan.domain.objects.SurgicalOpNotes;
import ims.RefMan.vo.SurgicalOpNotesVo;
import ims.RefMan.vo.domain.SurgicalOpNotesVoAssembler;
import ims.clinical.configuration.domain.objects.SurgicalOperationDetailsConfig;
import ims.clinical.vo.IntraOperativeCareRecordLiteVo;
import ims.clinical.vo.IntraOperativeCareRecordShortVo;
import ims.clinical.vo.domain.IntraOperativeCareRecordLiteVoAssembler;
import ims.clinical.vo.domain.IntraOperativeCareRecordShortVoAssembler;
import ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo;
import ims.clinicaladmin.vo.domain.SurgicalOperationDetailsConfigVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.IntraOperativeCareRecord;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.core.clinical.vo.IntraOperativeCareRecordRefVo;
import ims.core.vo.PatientProcedureVo;
import ims.core.vo.domain.PatientProcedureVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class SurgicalOperationNotesImpl extends BaseSurgicalOperationNotesImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.IntraOperativeCareRecordLiteVoCollection listIOCR(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
		if(catsReferral == null || catsReferral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Can not get Session Slot on null Id.");
		
		DomainFactory factory = getDomainFactory();
		
		String query = "select iocr from IntraOperativeCareRecord as iocr left join iocr.careContext as cc1, CatsReferral as cr left join cr.careContext as cc2 where (cc1.id = (cc2.id) and cr.id = :CatsReferral) order by iocr.procedureDate asc";
		List<?> list = factory.find(query, new String[] {"CatsReferral"}, new Object[] {catsReferral.getID_CatsReferral()});
		
		return IntraOperativeCareRecordLiteVoAssembler.createIntraOperativeCareRecordLiteVoCollectionFromIntraOperativeCareRecord(list);
	}

	public SurgicalOpNotesVo getSurgicalOpNote(CareContextRefVo careContext, IntraOperativeCareRecordRefVo iocr) 
	{
		if(careContext == null || !careContext.getID_CareContextIsNotNull())
			throw new CodingRuntimeException("Can not get SurgicalOpNotes on null CareContextId.");
		
		if(iocr == null || !iocr.getID_IntraOperativeCareRecordIsNotNull())
			throw new CodingRuntimeException("Can not get SurgicalOpNotes on null IntraOperativeCareRecordId.");
		
		DomainFactory factory = getDomainFactory();
		
		String query = "from SurgicalOpNotes as sn where sn.careContext.id = :CareContext and sn.intraOperativeCareRecord.id = :IOCR and sn.isRIE is null";
		List<?> list = factory.find(query, new String[] {"CareContext", "IOCR"}, new Object[] {careContext.getID_CareContext(), iocr.getID_IntraOperativeCareRecord()});
		
		if(list != null && list.size() > 1)
			throw new DomainRuntimeException("Can not have more than one record of type SurgicalOpNotes per IntraOperativeCareRecord.");
		
		if(list != null && list.size() == 1)
			return SurgicalOpNotesVoAssembler.create((SurgicalOpNotes) list.get(0));
		
		return null;
	}

	public IntraOperativeCareRecordShortVo getIntraOperativeCareRecords(IntraOperativeCareRecordRefVo iocr) 
	{
		if(iocr == null || iocr.getID_IntraOperativeCareRecord() == null)
			 return null;
		
		DomainFactory factory = getDomainFactory();
		IntraOperativeCareRecord doIntraOperativeCarerecord = (IntraOperativeCareRecord) factory.getDomainObject(IntraOperativeCareRecord.class, iocr.getID_IntraOperativeCareRecord());
		
		return IntraOperativeCareRecordShortVoAssembler.create(doIntraOperativeCarerecord);
	}

	public SurgicalOpNotesVo saveSurgicalOpNotes(SurgicalOpNotesVo surgicalOpNotes) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{
		if(surgicalOpNotes == null)
			throw new CodingRuntimeException("Can not save a null SurgicalOpNotes.");
		
		if(!surgicalOpNotes.isValidated())
			throw new CodingRuntimeException("SurgicalOpNotes is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		if(surgicalOpNotes.getID_SurgicalOpNotes() == null)
		{
			String query = "from SurgicalOpNotes as sn where sn.careContext.id = :CareContext and sn.intraOperativeCareRecord.id = :IOCR and sn.isRIE is null";
			List<?> list = factory.find(query, new String[] {"CareContext", "IOCR"}, new Object[] {surgicalOpNotes.getCareContext().getID_CareContext(), surgicalOpNotes.getIntraOperativeCareRecord().getID_IntraOperativeCareRecord()});
			
			if(list != null && list.size() > 0)
				throw new StaleObjectException((DomainObject) list.get(0));
		}
		
		SurgicalOpNotes doSurgicalOpNotes = SurgicalOpNotesVoAssembler.extractSurgicalOpNotes(factory, surgicalOpNotes);
		
		factory.save(doSurgicalOpNotes);	
		
		return SurgicalOpNotesVoAssembler.create(doSurgicalOpNotes);
	}
	
	public SurgicalOperationDetailsConfigVo getSurgicalOperationDetailsConfig(IntraOperativeCareRecordRefVo iocr) 
	{
		if(iocr == null || iocr.getID_IntraOperativeCareRecord() == null)
			throw new CodingRuntimeException("Can not get SurgicalOperationDetailsConfig on null IntraOperativeCareRecord Id.");
		
		DomainFactory factory = getDomainFactory();
		IntraOperativeCareRecord doIocr = (IntraOperativeCareRecord) factory.getDomainObject(IntraOperativeCareRecord.class, iocr.getID_IntraOperativeCareRecord());
		IntraOperativeCareRecordLiteVo iocrVo = IntraOperativeCareRecordLiteVoAssembler.create(doIocr);
		
		if(iocrVo == null || iocrVo.getActualProcedure() == null || iocrVo.getActualProcedure().getProcedure() == null)
			return null;
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		String hql = "from SurgicalOperationDetailsConfig as s where s.procedureReference.id = :Procedure and  (s.surgeon is null";
		markers.add("Procedure");
		values.add(iocrVo.getActualProcedure().getProcedure().getID_Procedure());
		
		if(iocrVo.getSurgeonIsNotNull() && iocrVo.getSurgeon().getID_HcpIsNotNull())
		{
			hql += " or s.surgeon.id = :Surgeon";
			markers.add("Surgeon");
			values.add(iocrVo.getSurgeon().getID_Hcp());
		}
		
		hql += ") order by s.surgeon desc";
		
		List<?> listSurgicalConfig = factory.find(hql, markers, values);
		
		if(listSurgicalConfig != null && listSurgicalConfig.size() > 0)
			return SurgicalOperationDetailsConfigVoAssembler.create((SurgicalOperationDetailsConfig) listSurgicalConfig.get(0));
		
		return null;
	}

	public PatientProcedureVo getPlannedProcedure(IntraOperativeCareRecordRefVo iocr) 
	{
		if(iocr == null || iocr.getID_IntraOperativeCareRecord() == null)
			throw new CodingRuntimeException("Can not get PlannedProcedure on null IntraOperativeCareRecord Id.");
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "select iocr.plannedProcedure from IntraOperativeCareRecord as iocr where iocr.id = :Iocr and iocr.isRIE is null";

		PatientProcedure plannedProcedure = (PatientProcedure) factory.findFirst(hql, new String[] {"Iocr"}, new Object[] {iocr.getID_IntraOperativeCareRecord()});
		
		return PatientProcedureVoAssembler.create(plannedProcedure);
	}
}
