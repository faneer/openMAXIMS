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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.admin.domain.ServiceConfiguration;
import ims.admin.domain.impl.ServiceConfigurationImpl;
import ims.RefMan.domain.base.impl.BaseReferralTriageAcceptedImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.vo.domain.CatsReferralForReferralTriageVoAssembler;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.vo.ServiceTriageActionVo;
import ims.core.vo.domain.ServiceFunctionLiteVoAssembler;

public class ReferralTriageAcceptedImpl extends BaseReferralTriageAcceptedImpl
{
	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.CatsReferralForReferralTriageVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
		if(catsReferral == null || catsReferral.getID_CatsReferral() == null)
			return null;
		
		return CatsReferralForReferralTriageVoAssembler.create((CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, catsReferral.getID_CatsReferral()));
	}

	public ims.core.vo.ServiceFunctionLiteVoCollection listServiceFunctions(ims.core.clinical.vo.ServiceRefVo service)
	{
		if(service == null || service.getID_Service() == null)
			return null;
		
		String query = "select sf from ServiceFunction as sf left join sf.service as s left join sf.function as f where s.id = :ServiceId and f.id is not null and sf.isActive = 1";
		
		return ServiceFunctionLiteVoAssembler.createServiceFunctionLiteVoCollectionFromServiceFunction(getDomainFactory().find(query, new String[] {"ServiceId"}, new Object[] {service.getID_Service()}));
	}

	public ServiceTriageActionVo getServiceTriageActions(ServiceRefVo service)
	{
		ServiceConfiguration impl = (ServiceConfiguration) getDomainImpl(ServiceConfigurationImpl.class);
		return impl.getServiceTriageAction(service);
	}
}
