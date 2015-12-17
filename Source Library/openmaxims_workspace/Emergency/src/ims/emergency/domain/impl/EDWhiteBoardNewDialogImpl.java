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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.assessment.configuration.vo.UserAssessmentRefVo;
import ims.assessment.instantiation.domain.objects.PatientAssessment;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.TrackingArea;
import ims.emergency.configuration.vo.TrackingAreaRefVo;
import ims.emergency.domain.base.impl.BaseEDWhiteBoardNewDialogImpl;
import ims.emergency.domain.objects.PatientWhiteboardActions;
import ims.emergency.domain.objects.PatientWhiteboardRecord;
import ims.emergency.vo.PatientAssessmentForWhiteboardVo;
import ims.emergency.vo.PatientWhiteboardActionsVo;
import ims.emergency.vo.PatientWhiteboardRecordVo;
import ims.emergency.vo.TrackingAreaShortVo;
import ims.emergency.vo.TrackingForPatientWhiteBoardVoCollection;
import ims.emergency.vo.WhiteBoardConfigVo;
import ims.emergency.vo.WhiteBoardOtherActionsVo;
import ims.emergency.vo.domain.PatientAssessmentForWhiteboardVoAssembler;
import ims.emergency.vo.domain.PatientWhiteboardActionsVoAssembler;
import ims.emergency.vo.domain.PatientWhiteboardRecordVoAssembler;
import ims.emergency.vo.domain.TrackingAreaShortVoAssembler;
import ims.emergency.vo.domain.TrackingForPatientWhiteBoardVoAssembler;
import ims.emergency.vo.domain.WhiteBoardConfigVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class EDWhiteBoardNewDialogImpl extends BaseEDWhiteBoardNewDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.TrackingAreaShortVoCollection listTrackingAreas(ims.framework.interfaces.ILocation edLoc)
	{
		if( edLoc == null)
			throw new CodingRuntimeException("Cannot list Tracking Area for a null EDLocation Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select ta   from TrackingConfiguration as trc left join trc.areas as ta where ta.eDLocation.id = :EDLocationId and ta.status.id = :ActiveStatus and ta.isRegistrationArea = 0 order by index(ta)";//order by upper(ta.areaDisplayName)";
		List<?> list = factory.find(query, new String[] {"EDLocationId", "ActiveStatus"}, new Object[] {edLoc.getID(), PreActiveActiveInactiveStatus.ACTIVE.getID()});
		
		if( list != null && list.size() > 0)
			return TrackingAreaShortVoAssembler.createTrackingAreaShortVoCollectionFromTrackingArea(list);
		
		
		return null;
	}

	public TrackingForPatientWhiteBoardVoCollection listTrackingPatients(ims.emergency.vo.TrackingAreaShortVo trackingArea, ims.emergency.vo.lookups.TrackingStatus trackingStatus, ims.framework.interfaces.ILocation edLoc)
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuilder hqlJoins = new StringBuilder("select tr from Tracking as tr left join tr.patient as p left join tr.attendance as att left join tr.currentArea as ta");
		StringBuilder hqlConditions = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		String and = "";
		
		if( trackingArea != null )
		{
			if (trackingArea.getIsOverallViewIsNotNull() && trackingArea.getIsOverallView().equals(true))
    		{
				hqlConditions.append(and);
				hqlConditions.append(" ta.id is not null ");
				and = " and ";
    			
    		}
    		else
    		{
    			hqlConditions.append(and);
    			hqlConditions.append(" ta.id = :TrackingAreaId ");
    			paramNames.add("TrackingAreaId");
    			paramValues.add(trackingArea.getID_TrackingArea());
    			and = " and ";
    		}
		}
		
		if( edLoc != null)
		{
			hqlJoins.append(" left join tr.eDLocation as loc ");
			
			hqlConditions.append(and);
			hqlConditions.append(" loc.id = :locId ");
			paramNames.add("locId");
			paramValues.add(edLoc.getID());
			and = " and ";
		}
		else
		{
			if( trackingArea != null )
			{
				hqlJoins.append(" left join tr.eDLocation as loc ");
				
				hqlConditions.append(and);
				hqlConditions.append(" loc.id = :locId ");
				paramNames.add("locId");
				paramValues.add(trackingArea.getEDLocation().getID_Location());
				and = " and ";
			}
		}
		
		if( trackingStatus != null)
		{
						
			hqlJoins.append(" left join tr.currentStatus as cs left join cs.status as s ");
			
			hqlConditions.append(and);
			hqlConditions.append(" s.id = :statusId ");
			paramNames.add("statusId");
			paramValues.add(trackingStatus.getID());
			and = " and ";
		}
		
		if (hqlConditions.length()>0)
		{
			hqlConditions.insert(0, " where ");
		}
		
		List<?> patients = factory.find((hqlJoins.append( hqlConditions)).toString(), paramNames, paramValues);
		
		if( patients != null && patients.size() > 0 )
		{
			return TrackingForPatientWhiteBoardVoAssembler.createTrackingForPatientWhiteBoardVoCollectionFromTracking(patients);
		}
		
		return null;
	}

	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patientRef)
	{
		if (patientRef == null || patientRef.getID_Patient() == null)
		{
			throw new CodingRuntimeException("Cannot get Patient by null Id ");
		}

		DomainFactory factory = getDomainFactory();

		Patient domainPatient = (Patient) factory.getDomainObject(Patient.class, patientRef.getID_Patient());

		return PatientShortAssembler.create(domainPatient);
	}

	public ims.core.vo.CareContextShortVo getCareContextShort(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get CarerContext by null Id ");
		}

		DomainFactory factory = getDomainFactory();

		CareContext domainCareContext = (CareContext) factory.getDomainObject(CareContext.class, careContextRef.getID_CareContext());

		return CareContextShortVoAssembler.create(domainCareContext);
	}

	public WhiteBoardConfigVo getEDWhiteBoardConfigByArea(TrackingAreaRefVo trackingAreaRef)
	{
		if(trackingAreaRef==null)
			throw new CodingRuntimeException("Cannot get EDWhiteBoardConfig value on null AreaID.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select whiteBoardCfg from WhiteBoardConfig as whiteBoardCfg ");
		hql.append("where whiteBoardCfg.currentArea.id = :areaID  and (whiteBoardCfg.isRIE is null or whiteBoardCfg.isRIE=0) ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"areaID"}, new Object[] {trackingAreaRef.getID_TrackingArea()});
		
		if (list!=null && list.size()>0)
		{
			return WhiteBoardConfigVoAssembler.createWhiteBoardConfigVoCollectionFromWhiteBoardConfig(list).get(0);
		}
		return null;
	}

	public PatientWhiteboardRecordVo getPatientWhiteBoard(CareContextRefVo careContextRef, PatientRefVo patientRef)
	{
		if(patientRef==null || careContextRef==null)
			throw new CodingRuntimeException("Cannot get PatientWhiteboardRecordVo value on null Patient or null Attendance.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select patWhiteboard from PatientWhiteboardRecord as patWhiteboard where patWhiteboard.patient.id = :patID  and patWhiteboard.attendance.id= :attendanceID and (patWhiteboard.isRIE is null or patWhiteboard.isRIE=0) ");
		
		DomainFactory factory = getDomainFactory();
		DomainObject doPatWhiteboard = factory.findFirst(hql.toString(), new String[] {"patID","attendanceID"}, new Object[] {patientRef.getID_Patient(), careContextRef.getID_CareContext()});
		
		
		return PatientWhiteboardRecordVoAssembler.create((PatientWhiteboardRecord) doPatWhiteboard);
	}

	public PatientAssessmentForWhiteboardVo getPatientAssessment(CareContextRefVo careContextRef, UserAssessmentRefVo userAssessmentRef)
	{
		if(careContextRef==null || userAssessmentRef==null)
			throw new CodingRuntimeException("Cannot get PatientAssessment value on null Care context or null User Assessment.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select patAssess from PatientAssessment as patAssess left join patAssess.assessmentData as patAssessData where patAssess.careContext.id = :careContextID  and patAssessData.userAssessment.id= :userAssessID and (patAssess.isRIE is null or patAssess.isRIE=0) ");
		
		DomainFactory factory = getDomainFactory();
		DomainObject doPatAssess = factory.findFirst(hql.toString(), new String[] {"careContextID","userAssessID"}, new Object[] {careContextRef.getID_CareContext(), userAssessmentRef.getID_UserAssessment()});
		
		return PatientAssessmentForWhiteboardVoAssembler.create((PatientAssessment) doPatAssess);
	}

	public PatientWhiteboardActionsVo savePatientWhiteBoardActionVo(PatientWhiteboardActionsVo patientWhiteBoardActionVoToSave) throws StaleObjectException
	{
		if (patientWhiteBoardActionVoToSave == null)
			throw new CodingRuntimeException("Cannot save null PatientWhiteboardActionsVo ");

		if (!patientWhiteBoardActionVoToSave.isValidated())
			throw new CodingRuntimeException("PatientWhiteboardActionsVo not Validated");
		
		DomainFactory factory = getDomainFactory();

		PatientWhiteboardActions domainPatWhiteBoardAct = PatientWhiteboardActionsVoAssembler.extractPatientWhiteboardActions(factory, patientWhiteBoardActionVoToSave);
		factory.save(domainPatWhiteBoardAct);
		
		return PatientWhiteboardActionsVoAssembler.create(domainPatWhiteBoardAct);
	}

	public PatientWhiteboardRecordVo savePatientWhiteBoard(PatientWhiteboardRecordVo patientWhiteBoardToSave) throws StaleObjectException
	{
		if (patientWhiteBoardToSave == null)
			throw new CodingRuntimeException("Cannot save null PatientWhiteboardRecordVo ");

		if (!patientWhiteBoardToSave.isValidated())
			throw new CodingRuntimeException("PatientWhiteboardRecordVo not Validated");
		
		DomainFactory factory = getDomainFactory();

		PatientWhiteboardRecord domainPatWhiteBoard = PatientWhiteboardRecordVoAssembler.extractPatientWhiteboardRecord(factory, patientWhiteBoardToSave);
		factory.save(domainPatWhiteBoard);
		
		return PatientWhiteboardRecordVoAssembler.create(domainPatWhiteBoard);
	}

	public PatientWhiteboardActionsVo getPatientWhiteBoardAction(PatientWhiteboardRecordVo patientWhiteBoard, WhiteBoardOtherActionsVo whiteBoardOtherAction)
	{
		if(patientWhiteBoard==null || whiteBoardOtherAction==null)
			throw new CodingRuntimeException("Cannot get PatientWhiteboardActionVo value on null values.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select pwa from PatientWhiteboardRecord as pwr left join pwr.currentActions as pwa left join pwa.actionType as wat where pwr.id = :patWhiteboardID and wat.id = :whiteboardOtherActionID and (pwa.isRIE is null or pwa.isRIE=0) ");
		
		DomainFactory factory = getDomainFactory();
		DomainObject doPatWhiteboardAction = factory.findFirst(hql.toString(), new String[] {"patWhiteboardID","whiteboardOtherActionID"}, new Object[] {patientWhiteBoard.getID_PatientWhiteboardRecord(), whiteBoardOtherAction.getID_WhiteBoardOtherActions()});
		
		
		return PatientWhiteboardActionsVoAssembler.create((PatientWhiteboardActions) doPatWhiteboardAction);
	}

	public TrackingAreaShortVo getTrackingArea(TrackingAreaRefVo trackingAreaRef)
	{
		if(trackingAreaRef == null || trackingAreaRef.getID_TrackingArea() == null)
			throw new CodingRuntimeException("Cannot get TrackingArea record on null TrackingArea Id.");
		
		DomainFactory factory = getDomainFactory();
		TrackingArea doTrackingArea = (TrackingArea) factory.getDomainObject(TrackingArea.class, trackingAreaRef.getID_TrackingArea());
		
		return TrackingAreaShortVoAssembler.create(doTrackingArea);
	}
}
