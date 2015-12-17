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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.70 build 3545.21176)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.RefMan.domain.base.impl.BaseFollowUpNotesComponentImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.ConsultationClinicalNotes;
import ims.RefMan.domain.objects.FollowUpNote;
import ims.RefMan.vo.ConsultationClinicalNotesRefVo;
import ims.RefMan.vo.FollowUpNoteRefVo;
import ims.RefMan.vo.FollowUpNoteVo;
import ims.RefMan.vo.FollowUpNoteVoCollection;
import ims.RefMan.vo.domain.CatsReferralReportsVoAssembler;
import ims.RefMan.vo.domain.ConsultationClinicalNotesVoAssembler;
import ims.RefMan.vo.domain.FollowUpNoteVoAssembler;
import ims.RefMan.vo.lookups.ReportStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;

public class FollowUpNotesComponentImpl extends BaseFollowUpNotesComponentImpl
{

	private static final long serialVersionUID = 1L;
	
	public FollowUpNoteVoCollection listFollowUpNotes(ims.RefMan.vo.CatsReferralRefVo catsRefVo)
	{
		if(catsRefVo == null || catsRefVo.getID_CatsReferral() == null) {
			throw new CodingRuntimeException("CatsReferralVo is null or id not provided");
		}
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select notes from FollowUpNote as notes left join notes.catsReferral as cats ");
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		hql.append("  where cats.id = :idCatsRefferal");
		names.add("idCatsRefferal");
		values.add(catsRefVo.getID_CatsReferral());	
				
		List result = factory.find(hql.toString(),names,values);
		
		if (result != null && result.size() > 0) {
			FollowUpNoteVoCollection voColl = FollowUpNoteVoAssembler.createFollowUpNoteVoCollectionFromFollowUpNote(result);
			if(voColl != null && voColl.size() > 0) 
			{
				voColl.sort(SortOrder.DESCENDING);
				return voColl;
			}
		}
		
		return null;
	}
	
	public FollowUpNoteVo saveFollowUpNote(FollowUpNoteVo followUpNoteVo) throws StaleObjectException 
	{
		if(followUpNoteVo == null) {
			throw new CodingRuntimeException("FollowUpNoteVo is null");
		}	
		
		DomainFactory factory = getDomainFactory();
		FollowUpNote dom = FollowUpNoteVoAssembler.extractFollowUpNote(factory, followUpNoteVo);
		factory.save(dom);
		
		return FollowUpNoteVoAssembler.create(dom);
	}	
	
	public ims.RefMan.vo.FollowUpNoteVo getFollowUpNote(FollowUpNoteRefVo note)
	{
		if (note == null)
			throw new RuntimeException("Cannot get FollowUpNoteVo for null FollowUpNoteRefVo");

		FollowUpNote doFollowUpNote = (FollowUpNote) getDomainFactory().getDomainObject(FollowUpNote.class, note.getID_FollowUpNote());
		return FollowUpNoteVoAssembler.create(doFollowUpNote);		
	}
	
	/**
	* getCatsReferral
	*/
	public ims.RefMan.vo.CatsReferralReportsVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef)
	{
		return CatsReferralReportsVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsRef.getID_CatsReferral()));
	}
	
}
