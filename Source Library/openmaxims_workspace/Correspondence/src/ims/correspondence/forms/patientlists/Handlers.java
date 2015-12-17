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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.correspondence.forms.patientlists;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbIPDocStatusLookup();
	abstract protected void defaultcmbIPDocStatusLookupValue();
	abstract protected void bindcmbOPDocumentStatusLookup();
	abstract protected void defaultcmbOPDocumentStatusLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrPatientListsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onQmbIPConsultantTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtn2Click() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtn1Click() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdInPatientsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbIPClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbIPSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbIPDocStatusValueSet(Object value);
	abstract protected void onBtn4Click() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtn3Click() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdOutPatientsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbOPClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbOPSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbOPDocumentStatusValueSet(Object value);
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.lyrPatientLists().tabInpatientList().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientListstabInpatientListActivated();
			}
		});
		this.form.lyrPatientLists().tabOutpatientList().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatientListstabOutpatientListActivated();
			}
		});
		this.form.lyrPatientLists().tabInpatientList().qmbIPConsultant().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbIPConsultantTextSubmited(value);
			}
		});
		this.form.lyrPatientLists().tabInpatientList().btn2().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtn2Click();
			}
		});
		this.form.lyrPatientLists().tabInpatientList().btn1().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtn1Click();
			}
		});
		this.form.lyrPatientLists().tabInpatientList().grdIPList().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdInPatientsSelectionChanged();
			}
		});
		this.form.lyrPatientLists().tabInpatientList().imbIPClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbIPClearClick();
			}
		});
		this.form.lyrPatientLists().tabInpatientList().imbIPSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbIPSearchClick();
			}
		});
		this.form.lyrPatientLists().tabInpatientList().cmbIPDocStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbIPDocStatusValueSet(value);
			}
		});
		this.form.lyrPatientLists().tabOutpatientList().btn4().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtn4Click();
			}
		});
		this.form.lyrPatientLists().tabOutpatientList().btn3().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtn3Click();
			}
		});
		this.form.lyrPatientLists().tabOutpatientList().grdOPList().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdOutPatientsSelectionChanged();
			}
		});
		this.form.lyrPatientLists().tabOutpatientList().imbOPClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbOPClearClick();
			}
		});
		this.form.lyrPatientLists().tabOutpatientList().imbOPSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbOPSearchClick();
			}
		});
		this.form.lyrPatientLists().tabOutpatientList().cmbOPDocumentStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOPDocumentStatusValueSet(value);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.Add, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.Edit, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.View, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsPreviewLetterItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.PreviewLetter, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsDocumentStatusItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.DocumentStatus, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsEditDocumentStatusHistoryItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.EditDocumentStatusHistory, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsViewDemographicsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.ViewDemographics, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsVIEWCONTACTSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.VIEWCONTACTS, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsSetLetterRequiredItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.SetLetterRequired, sender);
			}
		});
		this.form.getContextMenus().Correspondence.getCorrespondenceDetailsSetNoLetterRequiredItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceDetails.SetNoLetterRequired, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbIPDocStatusLookup();
		bindcmbOPDocumentStatusLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbIPDocStatusLookup();
		bindcmbOPDocumentStatusLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbIPDocStatusLookupValue();
		defaultcmbOPDocumentStatusLookupValue();
	}
	private void onlyrPatientListstabInpatientListActivated()
	{
		this.form.lyrPatientLists().showtabInpatientList();
		onlyrPatientListsTabChanged(this.form.lyrPatientLists().tabInpatientList());
	}
	private void onlyrPatientListstabOutpatientListActivated()
	{
		this.form.lyrPatientLists().showtabOutpatientList();
		onlyrPatientListsTabChanged(this.form.lyrPatientLists().tabOutpatientList());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
