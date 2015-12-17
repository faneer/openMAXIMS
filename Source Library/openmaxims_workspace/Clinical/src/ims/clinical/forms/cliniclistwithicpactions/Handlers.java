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

package ims.clinical.forms.cliniclistwithicpactions;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindcmbListTypeLookup();
	abstract protected void defaultcmbListTypeLookupValue();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbListTypeValueSet(Object value);
	abstract protected void onCmbListTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbServiceTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbAddListOwnersClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbAutoRefreshClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdResultsGridButtonClicked(int column, GenForm.grdResultsRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdResultsGridHeaderClicked(int column) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdResultsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDteDateValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbClinicValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcListOwnerValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTimer(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
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
		this.form.cmbListType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbListTypeValueSet(value);
			}
		});
		this.form.cmbListType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbListTypeValueChanged();
			}
		});
		this.form.qmbService().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbServiceTextSubmited(value);
			}
		});
		this.form.imbAddListOwners().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbAddListOwnersClick();
			}
		});
		this.form.imbAutoRefresh().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbAutoRefreshClick();
			}
		});
		this.form.grdResults().setGridButtonClickedEvent(new GridButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdResultsGridButtonClicked(column, new GenForm.grdResultsRow(row));
			}
		});
		this.form.grdResults().setGridHeaderClickedEvent(new GridHeaderClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdResultsGridHeaderClicked(column);
			}
		});
		this.form.grdResults().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdResultsSelectionChanged();
			}
		});
		this.form.dteDate().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDteDateValueChanged();
			}
		});
		this.form.cmbHospital().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbHospitalValueChanged();
			}
		});
		this.form.cmbClinic().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbClinicValueChanged();
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
		this.form.setccListOwnerValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcListOwnerValueChanged();
			}
		});
		this.form.setTimerElapsedEvent(new ims.framework.delegates.TimerElapsed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException
			{
				onTimer(timer);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.Add, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.Edit, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListEditViewICPActionsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.EditViewICPActions, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListADMITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.ADMIT, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListDISCHARGEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.DISCHARGE, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListDNAItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.DNA, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListARRIVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.ARRIVE, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListSEEN_EDIT_NO_ICPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.SEEN_EDIT_NO_ICP, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListSEEN_EDIT_ICPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.SEEN_EDIT_ICP, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListWAIT_FOR_NEXTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.WAIT_FOR_NEXT, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListSEEN_BY_ANAESTHETISTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.SEEN_BY_ANAESTHETIST, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListWITH_PHYSIOTHERAPYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.WITH_PHYSIOTHERAPY, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListSEEN_BY_PREOP_NURSEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.SEEN_BY_PREOP_NURSE, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListWITH_DIAGNOSTIC_SERVICESItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.WITH_DIAGNOSTIC_SERVICES, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListVISIT_COMPLETEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.VISIT_COMPLETE, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListOUTCOMEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.OUTCOME, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListVIEW_EDIT_OUTCOMEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.VIEW_EDIT_OUTCOME, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListVIEW_EDIT_PRE_ASSESSMENT_OUTCOMEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.VIEW_EDIT_PRE_ASSESSMENT_OUTCOME, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListCANCEL_REBOOKItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.CANCEL_REBOOK, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListUNDO_DNAItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.UNDO_DNA, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListUNDO_ARRIVALItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.UNDO_ARRIVAL, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListUNDO_NOT_SEENItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.UNDO_NOT_SEEN, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListUNDO_SEENItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.UNDO_SEEN, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListVIEW_REFERRAL_DETAILItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.VIEW_REFERRAL_DETAIL, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOPClinicViewListVIEW_READ_ONLY_OUTCOMEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OPClinicViewList.VIEW_READ_ONLY_OUTCOME, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbListTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbListTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbListTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	public abstract void clearContextInformation();
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
