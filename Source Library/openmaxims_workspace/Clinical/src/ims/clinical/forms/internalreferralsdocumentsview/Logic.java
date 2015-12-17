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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.internalreferralsdocumentsview;

import ims.core.vo.enums.DocumentViewLevel;
import ims.core.vo.enums.UploadDocumentStoreLevel;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if (args != null && args.length > 0 && args[0] != null && args[0] instanceof FormMode)
		{
			initialise((FormMode) args[0]);
		}
		else
			initialise(FormMode.EDIT);
		
	}

	private void initialise(FormMode formMode)
	{
		form.getLocalContext().setSelectedDocument(null);
		form.ccDocuments().initialize(null, UploadDocumentStoreLevel.PATIENT, DocumentViewLevel.CLINICALREFERRAL);
		form.ccDocuments().setMode(formMode);

	}

	@Override
	protected void onCcDocumentsValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedDocument(form.ccDocuments().getSelectedRecord());
	}

	@Override
	protected void onRIEDialogClosed(ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		form.ccDocuments().showHtmlControl();
	}

	@Override
	protected void onRIEDialogOpened() throws ims.framework.exceptions.PresentationLogicException
	{
		form.ccDocuments().hideHtmlControl();
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}

}
