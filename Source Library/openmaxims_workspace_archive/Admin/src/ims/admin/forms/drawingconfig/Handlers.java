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

package ims.admin.forms.drawingconfig;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindcmbImageStatusLookup();
	abstract protected void defaultcmbImageStatusLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkReturnToListClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrDrawingTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onGrdImagesSearchSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbImageStatusValueSet(Object value);
	abstract protected void onImbSelectImageClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateImageClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelImageClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveImageClick() throws ims.framework.exceptions.PresentationLogicException;

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
		this.form.lnkReturnToList().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkReturnToListClick();
			}
		});
		this.form.btnSelect().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSelectClick();
			}
		});
		this.form.lyrDrawing().tabImageSearch().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDrawingtabImageSearchActivated();
			}
		});
		this.form.lyrDrawing().tabImageSelect().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDrawingtabImageSelectActivated();
			}
		});
		this.form.lyrDrawing().tabRegionConfig().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDrawingtabRegionConfigActivated();
			}
		});
		this.form.lyrDrawing().tabImageSearch().grdImagesSearch().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdImagesSearchSelectionChanged();
			}
		});
		this.form.lyrDrawing().tabImageSearch().imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.lyrDrawing().tabImageSearch().imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.lyrDrawing().tabImageSelect().cmbImageStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbImageStatusValueSet(value);
			}
		});
		this.form.lyrDrawing().tabImageSelect().imbImage().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSelectImageClick();
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateImageClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelImageClick();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveImageClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbImageStatusLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbImageStatusLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbImageStatusLookupValue();
	}
	private void onlyrDrawingtabImageSearchActivated()
	{
		this.form.lyrDrawing().showtabImageSearch();
		onlyrDrawingTabChanged(this.form.lyrDrawing().tabImageSearch());
	}
	private void onlyrDrawingtabImageSelectActivated()
	{
		this.form.lyrDrawing().showtabImageSelect();
		onlyrDrawingTabChanged(this.form.lyrDrawing().tabImageSelect());
	}
	private void onlyrDrawingtabRegionConfigActivated()
	{
		this.form.lyrDrawing().showtabRegionConfig();
		onlyrDrawingTabChanged(this.form.lyrDrawing().tabRegionConfig());
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
