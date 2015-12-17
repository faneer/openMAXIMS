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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4847.21738)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.domain.impl;

import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.domain.base.impl.BaseDiagnosticImageTransferWorklistImpl;
import ims.eas.domain.objects.ElectronicActionSheet;
import ims.eas.domain.objects.ImageTransfer;
import ims.eas.vo.DiagnosticImageTransferVoCollection;
import ims.eas.vo.ElectronicActionSheetRefVo;
import ims.eas.vo.ElectronicActionSheetVo;
import ims.eas.vo.domain.DiagnosticImageTransferVoAssembler;
import ims.eas.vo.domain.ElectronicActionSheetVoAssembler;
import ims.eas.vo.lookups.EASStatus;
import ims.eas.vo.lookups.RemovalReason;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;

import java.util.ArrayList;
import java.util.Iterator;

public class DiagnosticImageTransferWorklistImpl extends BaseDiagnosticImageTransferWorklistImpl
{

	private static final long serialVersionUID = 1L;

	
	public HcpLiteVoCollection listHCP(String name, Boolean responsibleHcp)
	{
		StringBuilder query = new StringBuilder("SELECT hcp FROM Hcp AS hcp LEFT JOIN hcp.mos AS mos");
		query.append(" WHERE (mos.name.upperSurname LIKE :NAME OR mos.name.upperForename LIKE :NAME) AND hcp.isActive = 1");
		
		if (Boolean.TRUE.equals(responsibleHcp))
		{
			query.append(" AND hcp.isHCPaResponsibleHCP = 1 ");
		}
		
		query.append(" ORDER BY UPPER(mos.name.upperSurname)");
		
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(getDomainFactory().find(query.toString(), "NAME", "%" + name + "%"));
	}

	
	public DiagnosticImageTransferVoCollection listDiagnosticImages(Date seenFrom, Date seenTo, Date dtaFrom, Date dtaTo, HcpRefVo seenBy, HcpRefVo responsibleHcp, EASStatus status, Boolean removed)
	{
		StringBuilder query = new StringBuilder("SELECT DISTINCT(eas) FROM ElectronicActionSheet AS eas LEFT JOIN eas.seenBy AS seenHcp LEFT JOIN eas.responsibleHcp AS responsibleHcp ");
		query.append(" LEFT JOIN eas.easStatus AS easStatus LEFT JOIN easStatus.status AS status LEFT JOIN eas.imageTransfers AS imgTransfers");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append(" WHERE imgTransfers is not null");
		
		if (seenFrom != null)
		{
			query.append(" AND eas.dateSeen >= :SEEN_FROM");
			
			paramNames.add("SEEN_FROM");
			paramValues.add(seenFrom.getDate());
		}
		
		if (seenTo != null)
		{
			query.append(" AND eas.dateSeen <= :SEEN_TO");
			
			paramNames.add("SEEN_TO");
			paramValues.add(seenTo.getDate());
		}
		
		if (dtaFrom != null)
		{
			query.append(" AND eas.dateDecisionToTreat >= :DTA_FROM");
			
			paramNames.add("DTA_FROM");
			paramValues.add(dtaFrom.getDate());
		}
		
		if (dtaTo != null)
		{
			query.append(" AND eas.dateDecisionToTreat <= :DTA_TO");
			
			paramNames.add("DTA_TO");
			paramValues.add(dtaTo.getDate());
		}
		
		if (seenBy != null)
		{
			query.append(" AND seenHcp.id = :SEEN_HCP");
			
			paramNames.add("SEEN_HCP");
			paramValues.add(seenBy.getID_Hcp());
		}
		
		if (responsibleHcp != null)
		{
			query.append(" AND responsibleHcp.id = :RESPONSIBLE_HCP");
			
			paramNames.add("RESPONSIBLE_HCP");
			paramValues.add(responsibleHcp.getID_Hcp());
		}
		
		if (status != null)
		{
			query.append(" AND status.id = :EAS_STATUS");
			
			paramNames.add("EAS_STATUS");
			paramValues.add(status.getID());
		}
		
		
		if (removed == false)
		{
			query.append(" AND (eas.removedStat = 0 OR eas.removedStat is null)");
			query.append(" AND (imgTransfers.removedStat = 0 OR imgTransfers.removedStat is null)");
		}
		/* WDEV-17621
		else
		{
			query.append(" AND eas.removedStat = 1");
			query.append(" AND imgTransfers.removedStat = 1");
		}*/ 
		
		
		return DiagnosticImageTransferVoAssembler.createDiagnosticImageTransferVoCollectionFromElectronicActionSheet(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	public ElectronicActionSheetVo getEAS(ElectronicActionSheetRefVo eas)
	{
		if (eas == null || eas.getID_ElectronicActionSheet() == null)
			return null;
		
		return ElectronicActionSheetVoAssembler.create((ElectronicActionSheet) getDomainFactory().getDomainObject(ElectronicActionSheet.class, eas.getID_ElectronicActionSheet()));
	}


	public void recordRemovalReason(ElectronicActionSheetRefVo eas, RemovalReason removalReason) throws StaleObjectException
	{
		if (eas == null || eas.getID_ElectronicActionSheet() == null)
			throw new CodingRuntimeException("Electronic Action Sheet parameter can't be null.");
		
		if (removalReason == null)
			throw new CodingRuntimeException("Removal Reason parmeter can't be null");
		
		ElectronicActionSheet easDom = (ElectronicActionSheet) getDomainFactory().getDomainObject(ElectronicActionSheet.class, eas.getID_ElectronicActionSheet());
		
		
		// Check for stale object
		if (easDom.getVersion() > eas.getVersion_ElectronicActionSheet())
		{
			throw new StaleObjectException(easDom);
		}
		
		easDom.setRemovedStat(Boolean.TRUE);
		easDom.setRemovalReason(getDomainFactory().getLookupInstance(removalReason.getID()));
		
		if (easDom.getImageTransfers() != null)
		{
			// Set Removal reason and flag to ImageTransfers
			@SuppressWarnings("unchecked")
			Iterator<ImageTransfer> imageTransfersIterator = easDom.getImageTransfers().iterator();

			while (imageTransfersIterator.hasNext())
			{
				ImageTransfer imageTransfer = imageTransfersIterator.next();

				imageTransfer.setRemovedStat(Boolean.TRUE);
				imageTransfer.setRemovalReason(getDomainFactory().getLookupInstance(removalReason.getID()));
			}

			getDomainFactory().save(easDom);
		}
	}
}
