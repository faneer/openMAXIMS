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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.38 build 2144.16652)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.objects.POACChecklist;
import ims.clinical.vo.domain.POACCheckListVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;

public class POACCheckListImpl extends DomainImpl implements ims.clinical.domain.POACCheckList, ims.domain.impl.Transactional
{
	/**
	* Get POAC Checklist for this contact
	*/
	public ims.clinical.vo.POACCheckListVo getPOACCheckList(ims.core.vo.ClinicalContactShortVo voClinicalContact)
	{
		if(voClinicalContact == null || voClinicalContact.getID_ClinicalContact() == null)
			throw new DomainRuntimeException("Contact not provided for get call. ");
		
		return POACCheckListVoAssembler.create(POACChecklist.getPOACChecklistFromClinicalContact(getDomainFactory(), voClinicalContact.getID_ClinicalContact()));
	}

	/**
	* save POAC check list for a contact
	*/
	public ims.clinical.vo.POACCheckListVo savePOACCheckList(ims.clinical.vo.POACCheckListVo voPoacChkList) throws ims.domain.exceptions.StaleObjectException
	{
		if(!voPoacChkList.isValidated())
		{
			throw new DomainRuntimeException("POAC Checklist Value Object has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();
		POACChecklist poacBo = POACCheckListVoAssembler.extractPOACChecklist(factory,voPoacChkList);
		factory.save(poacBo);
					
		return POACCheckListVoAssembler.create(poacBo);		
	}
}
