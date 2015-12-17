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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.patient.vo.PatientRefVo;
import ims.emergency.domain.base.impl.BaseAttendanceResultListImpl;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.vo.PathologyResultListShortVo;
import ims.ocrr.vo.PathologyResultListShortVoCollection;
import ims.ocrr.vo.RadiologyResultListVoCollection;
import ims.ocrr.vo.domain.PathologyResultListShortVoAssembler;
import ims.ocrr.vo.domain.RadiologyResultListVoAssembler;
import ims.ocrr.vo.lookups.Category;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AttendanceResultListImpl extends BaseAttendanceResultListImpl
{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PathologyResultListShortVoCollection listPathology(PatientRefVo patient, Date fromDate, Date dateTo)
	{
		if (patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Patient parameter can not be null when listing pathology results");
		

		StringBuilder queryNonDFT = new StringBuilder();
		StringBuilder queryDFT = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		queryNonDFT.append("SELECT orderInv, item.dateToCollect FROM SpecimenWorkListItem AS item RIGHT JOIN item.specimen AS specimen RIGHT JOIN specimen.investigations AS orderInv ");
		queryDFT.append("SELECT orderInv, item.dateToCollect FROM SpecimenWorkListItem AS item RIGHT JOIN item.dFTOrderInvestigation AS orderInv ");
		
		queryNonDFT.append("LEFT JOIN FETCH orderInv.orderDetails AS details LEFT JOIN details.patient AS patient ");
		queryDFT.append("LEFT JOIN FETCH orderInv.orderDetails AS details LEFT JOIN details.patient AS patient ");
		
		queryNonDFT.append("WHERE patient.id = :PATIENT_ID ");
		queryDFT.append("WHERE patient.id = :PATIENT_ID ");
		
		paramNames.add("PATIENT_ID");
		paramValues.add(patient.getID_Patient());
		
		queryNonDFT.append("AND orderInv.investigation.investigationIndex.category.id = :CATEGORY ");
		queryDFT.append("AND orderInv.investigation.investigationIndex.category.id = :CATEGORY ");

		paramNames.add("CATEGORY");
		paramValues.add(Category.PATHOLOGY.getID());
		
		
		if (fromDate != null && dateTo != null)
		{
			queryNonDFT.append(" AND orderInv.systemInformation.creationDateTime BETWEEN :FROM_DATE AND :END_DATE ");
			queryDFT.append(" AND orderInv.systemInformation.creationDateTime BETWEEN :FROM_DATE AND :END_DATE ");
			
			paramNames.add("FROM_DATE");	paramValues.add(new DateTime(fromDate, new Time(0, 0, 0)).getJavaDate());
			paramNames.add("END_DATE");		paramValues.add(new DateTime(dateTo, new Time(23, 59, 59)).getJavaDate());
		}
		else if (fromDate == null && dateTo != null)
		{
			queryNonDFT.append(" AND orderInv.systemInformation.creationDateTime <= :END_DATE ");
			queryDFT.append(" AND orderInv.systemInformation.creationDateTime <= :END_DATE ");
			
			paramNames.add("END_DATE");		paramValues.add(new DateTime(dateTo, new Time(23, 59, 59)).getJavaDate());
		}
		else if (fromDate != null && dateTo == null)
		{
			queryNonDFT.append(" AND orderInv.systemInformation.creationDateTime >= :FROM_DATE ");
			queryDFT.append(" AND orderInv.systemInformation.creationDateTime >= :FROM_DATE ");
			
			paramNames.add("FROM_DATE");	paramValues.add(new DateTime(fromDate, new Time(23,59, 59)).getJavaDate());
		}
		
		queryNonDFT.append(" ORDER BY orderInv.displayDateTime DESC, orderInv.ordInvSeq ASC, orderInv.systemInformation.creationDateTime, orderInv.systemInformation.creationUser");
		queryDFT.append(" ORDER BY orderInv.displayDateTime DESC, orderInv.ordInvSeq ASC, orderInv.systemInformation.creationDateTime, orderInv.systemInformation.creationUser");
		
		
		@SuppressWarnings("unchecked")
		List<Object[]> queryNonDFTResults = getDomainFactory().find(queryNonDFT.toString(), paramNames, paramValues);
		@SuppressWarnings("unchecked")
		List<Object[]> queryDFTResults = getDomainFactory().find(queryDFT.toString(), paramNames, paramValues);

		
		if ((queryNonDFTResults == null || queryNonDFTResults.size() == 0) && (queryDFTResults == null || queryDFTResults.size() == 0))
			return null;
		

		PathologyResultListShortVoCollection results = new PathologyResultListShortVoCollection();
		
		for (int i = 0; i < queryNonDFTResults.size(); i++)
		{
			Object[] queryResult = queryNonDFTResults.get(i);
			
			if (queryResult[0] instanceof OrderInvestigation)
			{
				PathologyResultListShortVo orderInvestigation = PathologyResultListShortVoAssembler.create((OrderInvestigation) queryResult[0]);
				
				if (queryResult[1] instanceof java.util.Date)
				{
					Calendar calendar = Calendar.getInstance();
					calendar.setTime((java.util.Date) queryResult[1]);
					orderInvestigation.setDateRequested(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)));
				}

				results.add(orderInvestigation);
			}
		}
		
		for (int i = 0; i < queryDFTResults.size(); i++)
		{
			Object[] queryResult = queryDFTResults.get(i);
			
			if (queryResult[0] instanceof OrderInvestigation)
			{
				PathologyResultListShortVo orderInvestigation = PathologyResultListShortVoAssembler.create((OrderInvestigation) queryResult[0]);
				
				if (queryResult[1] instanceof java.util.Date)
				{
					Calendar calendar = Calendar.getInstance();
					calendar.setTime((java.util.Date) queryResult[1]);
					orderInvestigation.setDateRequested(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)));
				}

				results.add(orderInvestigation);
			}
		}

		
		return results;
	}


	/**
	 * 
	 */
	public RadiologyResultListVoCollection listClinicalImaging(PatientRefVo patient, Date fromDate, Date toDate)
	{
		if (patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Patient parameter can not be null when listing pathology results");

		StringBuilder query = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		
		query.append("SELECT orderInv FROM OrderInvestigation AS orderInv ");
		query.append(" LEFT JOIN FETCH orderInv.orderDetails AS details LEFT JOIN details.patient AS patient ");
		
		query.append("WHERE patient.id = :PATIENT_ID ");
		
		paramNames.add("PATIENT_ID");
		paramValues.add(patient.getID_Patient());
		
		query.append("AND orderInv.investigation.investigationIndex.category.id = :CATEGORY ");

		paramNames.add("CATEGORY");
		paramValues.add(Category.CLINICALIMAGING.getID());

	
		if (fromDate != null && toDate != null)
		{
			query.append(" AND orderInv.systemInformation.creationDateTime BETWEEN :FROM_DATE AND :END_DATE ");
			
			paramNames.add("FROM_DATE");	paramValues.add(new DateTime(fromDate, new Time(0, 0, 0)).getJavaDate());
			paramNames.add("END_DATE");		paramValues.add(new DateTime(toDate, new Time(23, 59, 59)).getJavaDate());
		}
		else if (fromDate == null && toDate != null)
		{
			query.append(" AND orderInv.systemInformation.creationDateTime <= :END_DATE ");
			
			paramNames.add("END_DATE");		paramValues.add(new DateTime(toDate, new Time(23, 59, 59)).getJavaDate());
		}
		else if (fromDate != null && toDate == null)
		{
			query.append(" AND orderInv.systemInformation.creationDateTime >= :FROM_DATE ");
			
			paramNames.add("FROM_DATE");	paramValues.add(new DateTime(fromDate, new Time(23,59, 59)).getJavaDate());
		}
		
		
		query.append(" ORDER BY orderInv.displayDateTime DESC, orderInv.ordInvSeq ASC, orderInv.systemInformation.creationDateTime, orderInv.systemInformation.creationUser");
		
		return RadiologyResultListVoAssembler.createRadiologyResultListVoCollectionFromOrderInvestigation(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}
}
