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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.65 build 3208.19246)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.referraldetailsnotedialog;

import ims.RefMan.vo.lookups.ReferralNoteType;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.ReferralNoteVo;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getGlobalContext().RefMan.getReferralNoteIsNotNull())
		{
			form.txtUser().setValue(form.getGlobalContext().RefMan.getReferralNote().getRecordingUserIsNotNull() && form.getGlobalContext().RefMan.getReferralNote().getRecordingUser().getNameIsNotNull() ? form.getGlobalContext().RefMan.getReferralNote().getRecordingUser().getName().toString() : null);
			form.dtimDateTime().setValue(form.getGlobalContext().RefMan.getReferralNote().getRecordingDateTimeIsNotNull() ? form.getGlobalContext().RefMan.getReferralNote().getRecordingDateTime() : null);
			form.txtNotes().setValue(form.getGlobalContext().RefMan.getReferralNote().getNote());
		}
		else
		{
			MemberOfStaffLiteVo voMos = (MemberOfStaffLiteVo) domain.getMosUser();
			if (voMos != null)
				form.txtUser().setValue(voMos.getName().toString());
			form.dtimDateTime().setValue(new DateTime());
			form.txtNotes().setValue(null);
		}
			
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.txtNotes().getValue() == null)
		{
			engine.showMessage("Note is mandatory", "Error", MessageButtons.OK, MessageIcon.WARNING);
			return;
		}
		
		ReferralNoteVo voNote = new ReferralNoteVo();
		if (form.getGlobalContext().RefMan.getReferralNoteIsNotNull())
		{
			voNote = form.getGlobalContext().RefMan.getReferralNote();
			voNote.setNote(form.txtNotes().getValue());
		}
		else
		{
			MemberOfStaffLiteVo voMos = (MemberOfStaffLiteVo) domain.getMosUser();
			if (voMos != null)
				voNote.setRecordingUser(voMos);
			voNote.setRecordingDateTime(new DateTime());
			
			voNote.setNote(form.txtNotes().getValue());
			voNote.setNoteType(ReferralNoteType.NON_CLINICAL);
		}
		form.getGlobalContext().RefMan.setReferralNote(voNote);
		
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
