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
// This code was generated by Ancuta Ciubotaru using IMS Development Environment (version 1.80 build 4696.13908)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseDementiaExcludefromDementiaScreeningDialogImpl;
import ims.clinical.vo.domain.DementiaAssessAndInvestigateVoAssembler;
import ims.clinical.vo.domain.DementiaVoAssembler;
import ims.core.clinical.domain.objects.Dementia;
import ims.core.clinical.domain.objects.DementiaAssessAndInvestigate;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class DementiaExcludefromDementiaScreeningDialogImpl extends BaseDementiaExcludefromDementiaScreeningDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.DementiaVo getDementia(ims.core.clinical.vo.DementiaRefVo dementiaRef)
	{
		if (dementiaRef == null || dementiaRef.getID_Dementia()== null)
		{
			throw new CodingRuntimeException("Cannot get DementiaVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		Dementia domainDementia = (Dementia) factory.getDomainObject(Dementia.class, dementiaRef.getID_Dementia());

		return DementiaVoAssembler.create(domainDementia);
	}

	public void saveDementia(ims.clinical.vo.DementiaVo dementiaToSave) throws ims.domain.exceptions.StaleObjectException
	{
		if (dementiaToSave == null )
		{
			throw new CodingRuntimeException("Cannot get DementiaAssessAndInvestigateVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		
		Dementia domainDementia = DementiaVoAssembler.extractDementia(factory, dementiaToSave);
		factory.save(domainDementia);	
	}
}
