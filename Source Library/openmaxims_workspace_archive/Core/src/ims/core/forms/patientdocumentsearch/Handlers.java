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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.patientdocumentsearch;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected String[] getLookupUsageErrors();
	abstract protected void bindcmbDocStatusLookup();
	abstract protected void defaultcmbDocStatusLookupValue();
	abstract protected void bindcmbSpecialtyLookup();
	abstract protected void defaultcmbSpecialtyLookupValue();
	abstract protected void bindcmbDocTypeLookup();
	abstract protected void defaultcmbDocTypeLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDocStatusValueSet(Object value);
	abstract protected void oncmbSpecialtyValueSet(Object value);
	abstract protected void oncmbDocTypeValueSet(Object value);
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDetailsGridHeaderClicked(int column) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDetailsSellectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				// Checking lookups usage
				if(getLookupUsageErrors() != null && getLookupUsageErrors().length > 0)
					throw new ims.framework.exceptions.FormMandatoryLookupMissingException(ims.framework.exceptions.FormMandatoryLookupMissingException.getError(getLookupUsageErrors()));
				onFormOpen(args);
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
		this.form.cmbDocStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDocStatusValueSet(value);
			}
		});
		this.form.cmbSpecialty().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSpecialtyValueSet(value);
			}
		});
		this.form.cmbDocType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDocTypeValueSet(value);
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.grdDetails().setGridHeaderClickedEvent(new GridHeaderClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDetailsGridHeaderClicked(column);
			}
		});
		this.form.grdDetails().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDetailsSellectionChanged();
			}
		});
		this.form.getContextMenus().Core.getPatientDocumentSearchMenuNEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.NEW, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientDocumentSearchMenuEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.EDIT, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientDocumentSearchMenuCHANGEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.CHANGE, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientDocumentSearchMenuVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.VIEW, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientDocumentSearchMenuPRINTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.PRINT, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientDocumentSearchMenuPRINTANDLOCKItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.PRINTANDLOCK, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientDocumentSearchMenuWORDPATHItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.WORDPATH, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbDocStatusLookup();
		bindcmbSpecialtyLookup();
		bindcmbDocTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbDocStatusLookup();
		bindcmbSpecialtyLookup();
		bindcmbDocTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbDocStatusLookupValue();
		defaultcmbSpecialtyLookupValue();
		defaultcmbDocTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
