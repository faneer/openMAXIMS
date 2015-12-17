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

package ims.admin.domain.impl;

import ims.admin.domain.ServiceConfiguration;
import ims.admin.domain.base.impl.BaseHcpServiceFunctionComponentImpl;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.vo.domain.HCPWithServiceAndFunctionVoAssembler;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class HcpServiceFunctionComponentImpl extends BaseHcpServiceFunctionComponentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.HCPWithServiceAndFunctionVo get(ims.core.resource.people.vo.HcpRefVo hcp)
	{
		if(hcp == null || hcp.getID_Hcp() == null)
			return null;
		
		return HCPWithServiceAndFunctionVoAssembler.create((Hcp) getDomainFactory().getDomainObject(Hcp.class, hcp.getID_Hcp()));
	}

	public ims.core.vo.HCPWithServiceAndFunctionVo save(ims.core.vo.HCPWithServiceAndFunctionVo hcp) throws ims.domain.exceptions.StaleObjectException
	{
		if(hcp == null)
			throw new CodingRuntimeException("Cannot save a null HCPWithServiceAndFunctionVo.");
		
		if(!hcp.isValidated())
			throw new CodingRuntimeException("HCPWithServiceAndFunctionVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		Hcp doHcp = HCPWithServiceAndFunctionVoAssembler.extractHcp(factory, hcp);
		
		factory.save(doHcp);
		
		return HCPWithServiceAndFunctionVoAssembler.create(doHcp);
	}

	public ims.core.vo.ServiceLiteVoCollection listServices(String serviceName)
	{
		ServiceConfiguration impl = (ServiceConfiguration) getDomainImpl(ServiceConfigurationImpl.class);
		return impl.listServices(serviceName, null, null, true);
	}

	public ims.core.vo.ServiceFunctionForServiceConfigurationVoCollection listServiceFunctionByService(ims.core.clinical.vo.ServiceRefVo service)
	{
		ServiceConfiguration impl = (ServiceConfiguration) getDomainImpl(ServiceConfigurationImpl.class);
		return impl.listServiceFunctionByService(service, true);
	}
}
