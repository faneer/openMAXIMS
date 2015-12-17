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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4680.16533)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.oncology.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.domain.objects.ElectronicActionSheet;
import ims.eas.vo.ElectronicActionSheetVo;
import ims.eas.vo.domain.ElectronicActionSheetVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.oncology.domain.base.impl.BasePatientActionSheetWizardImpl;

import java.util.List;

public class PatientActionSheetWizardImpl extends BasePatientActionSheetWizardImpl
{

	private static final long serialVersionUID = 1L;

	public ims.oncology.vo.CancerContactsVo getContact()
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	/**
	* getSystemReportAndTemplate
	*/
	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}

	public ElectronicActionSheetVo saveElectronicActionSheet(ElectronicActionSheetVo voEAS) throws DomainInterfaceException,StaleObjectException 
	{
		if(voEAS == null)
			throw new CodingRuntimeException("voEAS is null");
		
		if(!voEAS.isValidated())
			throw new CodingRuntimeException("voEAS Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		ElectronicActionSheet doEas = ElectronicActionSheetVoAssembler.extractElectronicActionSheet(factory, voEAS);

		factory.save(doEas);
		return ElectronicActionSheetVoAssembler.create(doEas);			
	}

	public ElectronicActionSheetVo getElectronicActionSheet(ElectronicActionSheetVo voEAS) 
	{
		if (voEAS == null || voEAS.getID_ElectronicActionSheet()== null)
		{
			throw new CodingRuntimeException("Cannot get EASVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		ElectronicActionSheet domainEas = (ElectronicActionSheet) factory.getDomainObject(ElectronicActionSheet.class, voEAS.getID_ElectronicActionSheet());

		return ElectronicActionSheetVoAssembler.create(domainEas);
	}
}
