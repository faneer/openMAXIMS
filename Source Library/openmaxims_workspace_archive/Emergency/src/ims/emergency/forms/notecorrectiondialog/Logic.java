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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.notecorrectiondialog;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.enums.AuthoringLabelType;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.AttendanceClinicalNotesVo;
import ims.emergency.vo.SystemReviewVo;
import ims.emergency.vo.lookups.AttendanceClinicalNoteType;
import ims.framework.enumerations.DialogResult;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		//wdev-17113
		form.getLocalContext().setAttendanceClinicalNotesVo(null);
		if( args!=null && args.length>0 && args[0]!=null &&  args[0] instanceof AttendanceClinicalNotesVo)
		{
			form.getLocalContext().setAttendanceClinicalNotesVo((AttendanceClinicalNotesVo)args[0]);
		}
		//--------
		initialise();
	}

	private void initialise()
	{
		form.ccAuthoring().initializeComponent();
		form.ccAuthoring().setLabels(AuthoringLabelType.AUTHORING);
		form.ccAuthoring().setIsRequiredPropertyToControls(Boolean.TRUE);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		save();
	}

	private void save()
	{
		//wdev-17113
		if( form.getLocalContext().getAttendanceClinicalNotesVoIsNotNull() )
		{
			AttendanceClinicalNotesVo rec = populateDataFromScreenA();
			String[] errors1 = rec.validate(validateUiRules());

			if (errors1 != null && errors1.length > 0)
			{
				engine.showErrors(errors1);
				return;
			}
			try
			{
				domain.saveAttendanceClinicalNotes(rec);
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			}
			engine.close(DialogResult.OK);
			return;

			
		}
		//wdev-17113
		
		SystemReviewVo record = populateDataFromScreen();

		String[] errors = record.validate(validateUiRules());

		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		try
		{
			domain.saveSystemReview(record);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}

		engine.close(DialogResult.OK);
	}

	private String[] validateUiRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.ccAuthoring().getErrors() != null)
		{
			listOfErrors.add(form.ccAuthoring().getErrors());
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		return result;
	}
	//wdev-17113
	private AttendanceClinicalNotesVo populateDataFromScreenA()
	{
		AttendanceClinicalNotesVo attendanceClinNotesVo = form.getLocalContext().getAttendanceClinicalNotesVo();
		attendanceClinNotesVo.setIsCorrected(Boolean.TRUE);
		attendanceClinNotesVo.setCorrectedAuthoringInformation(form.ccAuthoring().getValue());
		attendanceClinNotesVo.setCorrectionComments(form.richTextCorrectionComments().getValue());

		return attendanceClinNotesVo;
	}

	//------------

	private SystemReviewVo populateDataFromScreen()
	{
		SystemReviewVo systemReview = form.getGlobalContext().Emergency.getSystemReview();
		systemReview.setIsCorrected(Boolean.TRUE);
		systemReview.setCorrectedAuthoringInformation(form.ccAuthoring().getValue());
		systemReview.setCorrectionComments(form.richTextCorrectionComments().getValue());

		return systemReview;
	}
}
