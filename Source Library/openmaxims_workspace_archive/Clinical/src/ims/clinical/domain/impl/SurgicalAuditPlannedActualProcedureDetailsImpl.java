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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseSurgicalAuditPlannedActualProcedureDetailsImpl;
import ims.clinical.domain.objects.SurgicalAuditActualProcedure;
import ims.clinical.domain.objects.SurgicalAuditOperationDetail;
import ims.clinical.helper.IESurgicalAuditHelper;
import ims.clinical.helper.SurgicalAuditHelper;
import ims.clinical.vo.SurgicalAuditActualProcedureVo;
import ims.clinical.vo.SurgicalAuditOperationDetailVo;
import ims.clinical.vo.domain.SurgicalAuditActualProcedureVoAssembler;
import ims.clinical.vo.domain.SurgicalAuditOperationDetailVoAssembler;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocSiteRefVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PatientProcedureVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class SurgicalAuditPlannedActualProcedureDetailsImpl extends BaseSurgicalAuditPlannedActualProcedureDetailsImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.SurgicalAuditOperationDetailVo saveSurgicalAuditOperationDetail(ims.clinical.vo.SurgicalAuditOperationDetailVo record) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.saveSurgicalAuditOperationDetail(record);
	}

	public ims.clinical.vo.SurgicalAuditOperationDetailVo getSurgicalAuditOperationDetail(ims.clinical.vo.SurgicalAuditOperationDetailRefVo surgicalAuditDetailRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.getSurgicalAuditOperationDetail(surgicalAuditDetailRef);
	}

	public ims.core.vo.LocationLiteVoCollection listActiveLocationsAtTheSameLevelWithLocation(ims.core.resource.place.vo.LocationRefVo locationRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.listActiveLocationsAtTheSameLevelWithLocation(locationRef);	
	}

	public ims.core.vo.LocationLiteVoCollection listLocationsByParentLocation(ims.core.resource.place.vo.LocationRefVo locationRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.listLocationsByParentLocation(locationRef);
	}

	public LocationLiteVo getLocationLiteVo(LocSiteRefVo locRef) 
	{
		if( locRef == null)
			throw new DomainRuntimeException("Location cannot be null.");
		
		
		DomainFactory factory = getDomainFactory();
		Location doLocation = (Location) factory.getDomainObject(Location.class, locRef.getID_Location());
		return LocationLiteVoAssembler.create(doLocation);
	}

	//changes 31/07/2012
	public SurgicalAuditActualProcedureVo saveSurgicalAuditPlannedActualProcDet(SurgicalAuditActualProcedureVo surgAuditActualProcToSave) throws StaleObjectException
	{
		if (surgAuditActualProcToSave == null )
		{
			throw new CodingRuntimeException("Cannot get SurgicalAuditActualProcedureVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		
		 SurgicalAuditActualProcedure domainSurgicalAuditActualProc = SurgicalAuditActualProcedureVoAssembler.extractSurgicalAuditActualProcedure(factory, surgAuditActualProcToSave);
		factory.save(domainSurgicalAuditActualProc);
		return SurgicalAuditActualProcedureVoAssembler.create(domainSurgicalAuditActualProc);
	}

	public Boolean isStale(SurgicalAuditOperationDetailVo surgAudit)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.isStale(surgAudit);	
	}
}
