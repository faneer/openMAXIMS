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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.70 build 3392.14041)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinical.vo.ProceduresPerformedByHCPVo;
import ims.clinical.vo.ProceduresPerformedByHCPVoCollection;
import ims.clinical.vo.domain.ProceduresPerformedByHCPVoAssembler;
import ims.clinicaladmin.domain.base.impl.BaseProceduresPerformedByHCPImpl;
import ims.core.clinical.domain.objects.Procedure;
import ims.core.clinical.domain.objects.ProceduresPerformedByHCP;
import ims.core.clinical.domain.objects.Service;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.ProcedureLiteVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.IMSCriteria;

import java.util.List;
import java.util.Vector;

public class ProceduresPerformedByHCPImpl extends BaseProceduresPerformedByHCPImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.HcpLiteVoCollection listHCP(String filter)
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(Hcp.class,factory);
		imsc.join("this.mos", "mos");
		imsc.like("mos.name.surname", filter + "%");
		List<Hcp> hcps=imsc.find();
		if (hcps.size()>0)
			return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(hcps);
		return null;
	}

	public ims.core.vo.ServiceLiteVoCollection listActiveServices()
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(ims.core.clinical.domain.objects.Service.class,factory);
		imsc.equal("isActive", true);
		List <Service> services=imsc.find();
		if (services.size()>0)
			return ServiceLiteVoAssembler.createServiceLiteVoCollectionFromService(services);
		return null;
	}

	
	public ProcedureLiteVoCollection listProcedures(String filter) 
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(Procedure.class,factory);
		imsc.like("this.procedureName", filter + "%");
		List procedures=imsc.find();
		if (procedures.size()>0)
			return ProcedureLiteVoAssembler.createProcedureLiteVoCollectionFromProcedure(procedures);
		return null;
	}

	public void saveProcedurePerformedByHCP(ProceduresPerformedByHCPVo procedure) throws StaleObjectException, DomainRuntimeException
	{
		DomainFactory factory=getDomainFactory();
		if (!procedure.isValidated())
		{
			throw new DomainRuntimeException("This Procedure has not be validated.");
		}
		if (procedure!=null)
		{
			factory.save(ProceduresPerformedByHCPVoAssembler.extractProceduresPerformedByHCP(factory, procedure));
		}	
	}

	public ProceduresPerformedByHCPVoCollection listProceduresPerformedByHCP(HcpLiteVo hcp, ServiceLiteVo service)
	{
		DomainFactory factory=getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(ProceduresPerformedByHCP.class, factory);
		if (hcp!=null && hcp.getID_HcpIsNotNull())
			imsc.equal("performingHCP.id", hcp.getID_Hcp());
		if (service!=null && service.getID_ServiceIsNotNull())
			imsc.equal("service.id", service.getID_Service());
		List procedures=imsc.find();
		if (procedures.size()>0)
			return ProceduresPerformedByHCPVoAssembler.createProceduresPerformedByHCPVoCollectionFromProceduresPerformedByHCP(procedures);
		return null;
	}

	public ServiceLiteVoCollection getAvailableServices(HcpRefVo hcp) 
	{
		DomainFactory factory=getDomainFactory();
		IMSCriteria imsc=new IMSCriteria (ProceduresPerformedByHCP.class,factory);
		imsc.equal("performingHCP.id", hcp.getID_Hcp());
		List procedures=imsc.find();
		Vector<ServiceLiteVo> services=new Vector <ServiceLiteVo>();
		for (int i=0;i<procedures.size();i++)
		{
			ProceduresPerformedByHCP proc = (ProceduresPerformedByHCP) procedures.get(i);
			if (proc.getService()!=null)
				services.add(ServiceLiteVoAssembler.create(proc.getService()));
		}
		ServiceLiteVoCollection servs=this.listActiveServices();
		ServiceLiteVoCollection servs2=new ServiceLiteVoCollection();
		if(servs != null)
		{
			for (int i=0;i<servs.size();i++)
			{
				if (!services.contains(servs.get(i)))
					servs2.add(servs.get(i));
			}
		}
		if (servs2.size()>0)
			return servs2;
		return null;
	}

	//WDEV-10772
	public ProcedureLiteVoCollection getAvailableProcedures(String procedures, String filter) 
	{
		DomainFactory factory=getDomainFactory();
		
		String query = "from Procedure as p where p.isActive = 1 ";
		
		if(filter != null && filter.length() > 0)
		{
			query += " and p.procedureName like :Proc";
		}
		if(procedures != null && procedures.length() > 0)
		{
			query += " and p.id not in (" + procedures + ") ";
		}
		
		List<?> procs=factory.find(query, new String[]{"Proc"}, new Object[]{filter + "%"});
		
		return ProcedureLiteVoAssembler.createProcedureLiteVoCollectionFromProcedure(procs);
	}

	public HcpLiteVoCollection getAvailableHCPs(String filter) 
	{
		DomainFactory factory=getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(Hcp.class,factory);
		if (filter!=null)
		{
			imsc.join("this.mos", "mos");
			imsc.like("mos.name.surname", filter + "%");
		}
		List hcpColl=imsc.find();
		
		HcpLiteVoCollection hcps=HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(hcpColl);
		HcpLiteVoCollection availableHcps=new HcpLiteVoCollection();
		
		removeAlreadyUsedHcps(hcps);
		
		for (int i=0;i<hcps.size();i++)
		{
			if (this.getAvailableServices(hcps.get(i).toHcpRefVo())!=null)
				availableHcps.add(hcps.get(i));
		}
		if (availableHcps.size()>0)
			return availableHcps;
		
		return null;
	}

	private void removeAlreadyUsedHcps(HcpLiteVoCollection hcps)
	{
		HcpLiteVoCollection voCollToRemove = new HcpLiteVoCollection();
		if(hcps != null)
		{
			for(HcpLiteVo hcp : hcps)
			{
				List count =getDomainFactory().find("select count(ppbh.id)from ProceduresPerformedByHCP as ppbh where ppbh.performingHCP.id = " + hcp.getID_Hcp());
				if(count != null)
				{
					Long val = (Long) count.get(0);
					if(val.intValue() > 0)
						voCollToRemove.add(hcp);
				}
			}
		}
		
		for(HcpLiteVo removeHcp :voCollToRemove)
			hcps.remove(removeHcp);	
	}

	public void removeProcedure(ProceduresPerformedByHCPVo procedure) throws ForeignKeyViolationException 
	{
		DomainFactory factory=getDomainFactory();
		if (procedure!=null)
			factory.delete(ProceduresPerformedByHCPVoAssembler.extractProceduresPerformedByHCP(factory, procedure));
	}
}
