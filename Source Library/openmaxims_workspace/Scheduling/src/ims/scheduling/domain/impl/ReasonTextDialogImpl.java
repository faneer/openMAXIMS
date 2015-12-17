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
// This code was generated by Silviu Checherita using IMS Development Environment (version 1.80 build 5567.19951)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.scheduling.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.domain.DomainFactory;
import ims.domain.lookups.LookupInstance;
import ims.scheduling.domain.base.impl.BaseReasonTextDialogImpl;
import ims.scheduling.vo.lookups.CancelAppointmentReason;
import ims.scheduling.vo.lookups.CancelAppointmentReasonCollection;
import ims.scheduling.vo.lookups.Status_Reason;

public class ReasonTextDialogImpl extends BaseReasonTextDialogImpl
{

	private static final long serialVersionUID = 1L;
	
	//WDEV-21736
	public CancelAppointmentReasonCollection listReasons() 
	{
		DomainFactory factory = getDomainFactory();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		String hql = "SELECT r FROM CancellationTypeReason AS t LEFT JOIN t.cancellationReason as r WHERE t.cancellationType.id = :cancellationType AND r.active = 1";
		
		markers.add("cancellationType");
		values.add(Status_Reason.HOSPITALCANCELLED.getID());
		
		List results = factory.find(hql.toString(), markers,values);
		
		if (results == null)
			return null;
		
		CancelAppointmentReasonCollection col = new CancelAppointmentReasonCollection();

		for (int i=0; i<results.size(); i++)
		{
			CancelAppointmentReason reason = new CancelAppointmentReason(((LookupInstance) results.get(i)).getId(), ((LookupInstance) results.get(i)).getText(), ((LookupInstance) results.get(i)).isActive());
			col.add(reason);
		}
		return col;
	}
	//WDEV-21736 ends here
}
