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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.80 build 5443.18271)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.domain.base.impl.BasePdsGPDetailsInDemographicsCCImpl;
import ims.core.resource.place.domain.objects.Organisation;
import ims.core.vo.domain.LocSiteVoAssembler;
import ims.core.vo.domain.OrganisationWithSitesVoAssembler;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class PdsGPDetailsInDemographicsCCImpl extends BasePdsGPDetailsInDemographicsCCImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.OrganisationWithSitesVo getGPPractice(ims.core.resource.place.vo.OrganisationRefVo organisationRef)
	{
		if(organisationRef == null)
			throw new CodingRuntimeException("Cannot get Organisation on null Id.");
		
		return OrganisationWithSitesVoAssembler.create((Organisation) getDomainFactory().getDomainObject(Organisation.class, organisationRef.getID_Organisation()));
	}

	public ims.core.vo.LocSiteVo getLocationSite(ims.core.resource.place.vo.LocationRefVo locSiteId)
	{
		if(locSiteId == null || locSiteId.getID_Location() == null) //WDEV-22208
			return null;
		
		DomainFactory factory = getDomainFactory();
		ims.core.resource.place.domain.objects.LocSite locSiteDO = (ims.core.resource.place.domain.objects.LocSite) factory.getDomainObject(ims.core.resource.place.domain.objects.LocSite.class, locSiteId.getID_Location());
		return LocSiteVoAssembler.create(locSiteDO);
	}
}
