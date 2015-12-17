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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3478.14513)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.commentdialog;

import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{

		if(args != null)
		{
			if(args.length > 0 && args[0] instanceof Boolean)
			{
				form.getLocalContext().setCommentForSessionManagement((Boolean) args[0]);
			}
			if(args.length > 1 && args[1] instanceof Boolean)
			{
				form.getLocalContext().setCommentForTCI((Boolean) args[1]);
			}
		}
		
		open();
	}

	private void open()
	{		
		form.txtCommentSession().setValue(Boolean.TRUE.equals(form.getLocalContext().getCommentForSessionManagement()) ? form.getGlobalContext().Core.getCommentDialogString() : null);
		form.txtCommentTCI().setValue(Boolean.TRUE.equals(form.getLocalContext().getCommentForTCI())? form.getGlobalContext().Core.getCommentDialogString() : null);
		form.txtComment().setValue(!Boolean.TRUE.equals(form.getLocalContext().getCommentForSessionManagement()) && !Boolean.TRUE.equals(form.getLocalContext().getCommentForTCI()) ? form.getGlobalContext().Core.getCommentDialogString() : null);			
				
		form.setMode(Boolean.TRUE.equals(form.getGlobalContext().Core.getCommentDialogReadOnly()) ? FormMode.VIEW : FormMode.EDIT);
		
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setCommentDialogString(getComment());
		engine.close(DialogResult.OK);
	}

	private String getComment()
	{
		if (Boolean.TRUE.equals(form.getLocalContext().getCommentForSessionManagement()))
			return form.txtCommentSession().getValue();
		else if (Boolean.TRUE.equals(form.getLocalContext().getCommentForTCI()))
			return form.txtCommentTCI().getValue();
		else 
			return	form.txtComment().getValue();
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
		
	}

	private void updateControlsState()
	{
		form.txtComment().setVisible(!Boolean.TRUE.equals(form.getLocalContext().getCommentForSessionManagement()) && !Boolean.TRUE.equals(form.getLocalContext().getCommentForTCI()));
		form.txtCommentTCI().setVisible(Boolean.TRUE.equals(form.getLocalContext().getCommentForTCI()));
		form.txtCommentSession().setVisible(Boolean.TRUE.equals(form.getLocalContext().getCommentForSessionManagement()));
		form.btnCancel().setText(Boolean.TRUE.equals(form.getGlobalContext().Core.getCommentDialogReadOnly()) ? "Close" : "Cancel");

		if (form.getGlobalContext().Core.getCommentDialogTitle() != null)
		{
			engine.setCaption(form.getGlobalContext().Core.getCommentDialogTitle());
		}		
		form.txtComment().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.txtCommentSession().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.txtCommentTCI().setEnabled(FormMode.EDIT.equals(form.getMode()));
		
	}
}
