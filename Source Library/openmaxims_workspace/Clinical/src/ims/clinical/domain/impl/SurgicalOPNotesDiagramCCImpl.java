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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.assessment.configuration.domain.objects.GraphicAssessment;
import ims.assessment.instantiation.domain.objects.PatientAssessment;
import ims.assessment.instantiation.vo.PatientAssessmentRefVo;
import ims.assessment.vo.PatientAssessmentVo;
import ims.assessment.vo.domain.GraphicAssessmentShortVoAssembler;
import ims.assessment.vo.domain.GraphicAssessmentVoAssembler;
import ims.assessment.vo.domain.PatientAssessmentVoAssembler;
import ims.clinical.domain.base.impl.BaseSurgicalOPNotesDiagramCCImpl;
import ims.clinical.domain.objects.SurgicalOperationNotes;
import ims.clinical.vo.domain.SurgicalOperationNotesDiagramVoAssembler;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.documents.domain.objects.PatientDocument;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;

import java.util.ArrayList;
import java.util.List;

public class SurgicalOPNotesDiagramCCImpl extends BaseSurgicalOPNotesDiagramCCImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.SurgicalOperationNotesDiagramVo getSurgicalOperationNotes(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		String query = "select s1_1 from SurgicalOperationNotes as s1_1 left join s1_1.careContext as c1_1 where (c1_1.id = :CareContext_id)";
		List<?> domObjs = getDomainFactory().find(query, new String[]{"CareContext_id"}, new Object[]{careContextRef.getID_CareContext()});
		if (domObjs == null || domObjs.size() == 0)
			return null;
		return SurgicalOperationNotesDiagramVoAssembler.create((SurgicalOperationNotes) domObjs.get(0));
	}

	public ims.clinical.vo.SurgicalOperationNotesDiagramVo save(ims.clinical.vo.SurgicalOperationNotesDiagramVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.UniqueKeyViolationException, ims.domain.exceptions.StaleObjectException
	{
		if (record == null)
			throw new DomainInterfaceException("Surgical Op Notes Vo must be not  null");
		if (!record.isValidated())
			throw new DomainInterfaceException("Surgical Op Notes Vo must be validated");
		
		if (!record.getID_SurgicalOperationNotesIsNotNull())
		{
			String countQ = "from SurgicalOperationNotes as s1_1 where (s1_1.careContext.id = :CareContext_id) and s1_1.isRIE is null";
			int count = getDomainFactory().count(countQ,new String[]{"CareContext_id"}, new Object[]{record.getCareContext().getID_CareContext()});
			if (count > 0 )
				throw new StaleObjectException(null,"A record is already created for this care context");
		} 
		
		SurgicalOperationNotes domObj = SurgicalOperationNotesDiagramVoAssembler.extractSurgicalOperationNotes(getDomainFactory(),record);
		getDomainFactory().save(domObj);
		return SurgicalOperationNotesDiagramVoAssembler.create(domObj);
	}

	public ims.assessment.vo.GraphicAssessmentShortVoCollection listGraphicalAssesments(ims.core.vo.lookups.Specialty speciality, String filter)
	{
		StringBuffer query = new StringBuffer("select g1_1 from GraphicAssessment as g1_1 left join g1_1.assessmentSpecialties as l1_1 left join l1_1.instance as l2_1 where (upper(g1_1.name) like :filter "); //wdev-13658
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramNames.add("filter");
		paramValues.add("%"+filter.toUpperCase()+"%");     //wdev-13658
		if (speciality != null)
		{
		query.append("and l2_1.id = :specialityId ");
		paramNames.add("specialityId");
		paramValues.add(speciality.getId());
		}		
		query.append("and g1_1.activeStatus.id = :active) order by g1_1.name asc ");
		paramNames.add("active");
		paramValues.add(PreActiveActiveInactiveStatus.ACTIVE.getID());
		List<?> domObj = getDomainFactory().find(query.toString(), paramNames, paramValues);
		if (domObj == null || domObj.size() == 0)
				return null;
		return GraphicAssessmentShortVoAssembler.createGraphicAssessmentShortVoCollectionFromGraphicAssessment(domObj);
	}

	public ims.assessment.vo.GraphicAssessmentVo getFullGraphicalAssessmet(ims.assessment.configuration.vo.GraphicAssessmentRefVo graphicaAssessRef)
	{
		return GraphicAssessmentVoAssembler.create((GraphicAssessment) getDomainFactory().getDomainObject(GraphicAssessment.class, graphicaAssessRef.getID_GraphicAssessment() ));
	}

	//	WDEV-14724
	public Boolean savePatientDocument(PatientDocumentVo patientDocument, PatientAssessmentVo patientAssessment) throws StaleObjectException
	{
		if (patientDocument == null)
			throw new DomainRuntimeException("Invalid PatientDocument record");
		if (!patientDocument.isValidated())
			throw new DomainRuntimeException("PatientDocument record not validated");
		if(patientAssessment == null)
			throw new DomainRuntimeException("Invalid patient assessment");
		if(!patientAssessment.isValidated())
			throw new DomainRuntimeException("Patient assessment not validated");
		
		DomainFactory factory = getDomainFactory();

		// Save PatientDocumet record
		PatientDocument domainPatientDocument = PatientDocumentVoAssembler.extractPatientDocument(factory, patientDocument);
		factory.save(domainPatientDocument);
		
		// Save PatientAssessment record
		PatientAssessment domainObject = PatientAssessmentVoAssembler.extractPatientAssessment(factory, patientAssessment);
		//wdev-15972
		if( domainObject != null && domainPatientDocument != null )
			domainObject.setAssociatedDocument(domainPatientDocument);
		//---------
		factory.save(domainObject);
		
		return true;
	}

	//	WDEV-14724
	public Boolean isSaved(PatientAssessmentRefVo patientAssessment) 
	{
		if (patientAssessment == null || !patientAssessment.getID_PatientAssessmentIsNotNull())
			throw new DomainRuntimeException("Can not check invalid record");
		
		String query = "select ass.isAssessmentDocumentSaved from PatientAssessment as ass where ass.id = " + patientAssessment.getID_PatientAssessment().toString();
		
		List<?> result = getDomainFactory().find(query);
		
		if (result.iterator().hasNext())
		{
			if (Boolean.TRUE.equals((Boolean) result.iterator().next()))
				return true;
		}

		return false;
	}

	//	WDEV-14724
	public String[] getReportAndTemplate(TemplateBoRefVo template) 
	{
		String[] result = null;

		if (template == null || !template.getID_TemplateBoIsNotNull())
			return null;

		@SuppressWarnings("rawtypes")
		List list = getDomainFactory().find("select rep.reportXml, tmpl.templateXml from TemplateBo as tmpl left join tmpl.report as rep where tmpl.id = :ID", "ID", template.getID_TemplateBo());

		if (list.iterator().hasNext())
		{
			Object[] obj = (Object[]) list.iterator().next();

			result = new String[] { (String) obj[0], (String) obj[1] };
		}

		return result;
	}
}
