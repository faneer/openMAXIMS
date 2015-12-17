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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3915.24993)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.oncology.domain.impl;

import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.oncology.domain.base.impl.BaseInternalReferralsImpl;
import ims.oncology.vo.InternalReferralVoCollection;
import ims.oncology.vo.domain.InternalReferralVoAssembler;

public class InternalReferralsImpl extends BaseInternalReferralsImpl
{

	private static final long serialVersionUID = 1L;

	public InternalReferralVoCollection listInternalReferrals(PatientRefVo patRefVo, Boolean bCurrentOnly)
	{
		DomainFactory factory = getDomainFactory();
		String hql = "from InternalReferral ir where ir.patient.id = " + patRefVo.getID_Patient();
		
		if (bCurrentOnly)
			hql += " and ir.status.id= "+ PreActiveActiveInactiveStatus.ACTIVE.getId();
		
		return InternalReferralVoAssembler.createInternalReferralVoCollectionFromInternalReferral((factory.find(hql))).sort();
	}

}
