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

package ims.core.forms.transport;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}
	public static class grdSearchResultsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdSearchResultsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolAppointmentDateReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolAppointmentDateReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolAppointmentDateOpened()
		{
			super.row.showOpened(0);
		}
		public ims.framework.utils.Date getcolAppointmentDate()
		{
			return (ims.framework.utils.Date)super.row.get(0);
		}
		public void setcolAppointmentDate(ims.framework.utils.Date value)
		{
			super.row.set(0, value);
		}
		public void setCellcolAppointmentDateTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setcolAppointmentPatientReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean iscolAppointmentPatientReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showcolAppointmentPatientOpened()
		{
			super.row.showOpened(1);
		}
		public String getcolAppointmentPatient()
		{
			return (String)super.row.get(1);
		}
		public void setcolAppointmentPatient(String value)
		{
			super.row.set(1, value);
		}
		public void setCellcolAppointmentPatientTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setcolAppointmentClinicReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean iscolAppointmentClinicReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showcolAppointmentClinicOpened()
		{
			super.row.showOpened(2);
		}
		public String getcolAppointmentClinic()
		{
			return (String)super.row.get(2);
		}
		public void setcolAppointmentClinic(String value)
		{
			super.row.set(2, value);
		}
		public void setCellcolAppointmentClinicTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public void setcolAppointmentStartTimeReadOnly(boolean value)
		{
			super.row.setReadOnly(3, value);
		}
		public boolean iscolAppointmentStartTimeReadOnly()
		{
			return super.row.isReadOnly(3);
		}
		public void showcolAppointmentStartTimeOpened()
		{
			super.row.showOpened(3);
		}
		public ims.framework.utils.Time getcolAppointmentStartTime()
		{
			return (ims.framework.utils.Time)super.row.get(3);
		}
		public void setcolAppointmentStartTime(ims.framework.utils.Time value)
		{
			super.row.set(3, value);
		}
		public void setCellcolAppointmentStartTimeTooltip(String value)
		{
			super.row.setTooltip(3, value);
		}
		public void setcolAppointmentEndTimeReadOnly(boolean value)
		{
			super.row.setReadOnly(4, value);
		}
		public boolean iscolAppointmentEndTimeReadOnly()
		{
			return super.row.isReadOnly(4);
		}
		public void showcolAppointmentEndTimeOpened()
		{
			super.row.showOpened(4);
		}
		public ims.framework.utils.Time getcolAppointmentEndTime()
		{
			return (ims.framework.utils.Time)super.row.get(4);
		}
		public void setcolAppointmentEndTime(ims.framework.utils.Time value)
		{
			super.row.set(4, value);
		}
		public void setCellcolAppointmentEndTimeTooltip(String value)
		{
			super.row.setTooltip(4, value);
		}
		public ims.scheduling.vo.Booking_AppointmentTransportVo getValue()
		{
			return (ims.scheduling.vo.Booking_AppointmentTransportVo)super.row.getValue();
		}
		public void setValue(ims.scheduling.vo.Booking_AppointmentTransportVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdSearchResultsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdSearchResultsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdSearchResultsRow get(int index)
		{
			return new grdSearchResultsRow(super.collection.get(index));
		}
		public grdSearchResultsRow newRow()
		{
			return new grdSearchResultsRow(super.collection.newRow());
		}
		public grdSearchResultsRow newRow(boolean autoSelect)
		{
			return new grdSearchResultsRow(super.collection.newRow(autoSelect));
		}
		public grdSearchResultsRow newRowAt(int index)
		{
			return new grdSearchResultsRow(super.collection.newRowAt(index));
		}
		public grdSearchResultsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdSearchResultsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdSearchResultsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addDateColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean canBeEmpty, String validationString, boolean bold, int sortOrder, boolean canGrow)
		{
			super.grid.addDateColumn(caption, captionAlignment, alignment, width, readOnly, canBeEmpty, validationString, bold, sortOrder, canGrow);
		}
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		private void addTimeColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean canBeEmpty, boolean autoPostBack, String validationString, boolean bold, int sortOrder, boolean canGrow)
		{
			super.grid.addTimeColumn(caption, captionAlignment, alignment, width, readOnly, canBeEmpty, autoPostBack, validationString, bold, sortOrder, canGrow);
		}
		public ims.scheduling.vo.Booking_AppointmentTransportVoCollection getValues()
		{
			ims.scheduling.vo.Booking_AppointmentTransportVoCollection listOfValues = new ims.scheduling.vo.Booking_AppointmentTransportVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.scheduling.vo.Booking_AppointmentTransportVo getValue()
		{
			return (ims.scheduling.vo.Booking_AppointmentTransportVo)super.grid.getValue();
		}
		public void setValue(ims.scheduling.vo.Booking_AppointmentTransportVo value)
		{
			super.grid.setValue(value);
		}
		public grdSearchResultsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdSearchResultsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdSearchResultsRowCollection getRows()
		{
			return new grdSearchResultsRowCollection(super.grid.getRows());
		}
		public grdSearchResultsRow getRowByValue(ims.scheduling.vo.Booking_AppointmentTransportVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdSearchResultsRow(row);
		}
		public void setcolAppointmentDateHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolAppointmentDateHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setcolAppointmentPatientHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getcolAppointmentPatientHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setcolAppointmentClinicHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getcolAppointmentClinicHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
		public void setcolAppointmentStartTimeHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(3, value);
		}
		public String getcolAppointmentStartTimeHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(3);
		}
		public void setcolAppointmentEndTimeHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(4, value);
		}
		public String getcolAppointmentEndTimeHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(4);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.core.vo.PatientShort.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.PatientShort' of the global context variable 'Core.PatientShort' is not supported.");
		if(!context.isValidContextType(ims.core.vo.CareContextShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.CareContextShortVo' of the global context variable 'Core.CurrentCareContext' is not supported.");
	}
	public boolean supportsRecordedInError()
	{
		return false;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return null;
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
		}
	
		super.setContext(form);

		form.setDarkHeight(52);
		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 632);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.RefMan.contextMenuTansport = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.RefMan.contextMenuTansportEditItem = factory.createMenuItem(startControlID.intValue() + 1, "Edit Transport Booking Details", true, false, new Integer(103102), true, false);
		contextMenus.RefMan.contextMenuTansport.add(contextMenus.RefMan.contextMenuTansportEditItem);
		form.registerMenu(contextMenus.RefMan.contextMenuTansport);


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 328, 10, 22, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.ENABLED, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "To:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 15, 10, 145, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.ENABLED, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Appointment Date From:", new Integer(1), null, new Integer(0)}));

		// Date Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 352, 8, 144, 20, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(DateControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.ENABLED, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, null, Boolean.FALSE, null, Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 160, 8, 144, 20, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(DateControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.ENABLED, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, null, Boolean.FALSE, null, Boolean.TRUE, null}));

		// CheckBox Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 16, 32, 160, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(CheckBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,"Display removed entries only", Boolean.FALSE, null}));

		// Grid Controls
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 16, 72, 816, 544, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdSearchResultsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 7), ControlState.READONLY, ControlState.READONLY, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.TRUE, new Integer(24), Boolean.TRUE, contextMenus.RefMan.contextMenuTansport, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdSearchResultsTemp);
		grdSearchResultsGrid grdSearchResults = (grdSearchResultsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdSearchResultsGrid.class, m_grdSearchResultsTemp);
		grdSearchResults.addDateColumn("Date", 0, 0, 100, true, true, null, false, 0, false);
		grdSearchResults.addStringColumn("Patient", 0, 0, 350, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdSearchResults.addStringColumn("Clinic", 0, 0, 150, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdSearchResults.addTimeColumn("Start Time", 0, 0, 100, true, true, false, null, false, 0, false);
		grdSearchResults.addTimeColumn("End Time", 0, 0, 100, true, true, false, null, false, 0, false);
		super.addGrid(grdSearchResults);

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 800, 16, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.ENABLED, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.ClearEnabled24, this.getImages().Core.ClearDisabled24, "Clear search criteria and results", Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 760, 16, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.ENABLED, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.FindEnabled24, this.getImages().Core.FindDisabled24, "Search for appointments matching 'Search Criteria'", Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public DateControl dteAppoinmentTo()
	{
		return (DateControl)super.getControl(2);
	}
	public DateControl dteAppoinmentFrom()
	{
		return (DateControl)super.getControl(3);
	}
	public CheckBox chkDisplayBooked()
	{
		return (CheckBox)super.getControl(4);
	}
	public grdSearchResultsGrid grdSearchResults()
	{
		return (grdSearchResultsGrid)super.getGrid(0);
	}
	public ImageButton imbClear()
	{
		return (ImageButton)super.getControl(6);
	}
	public ImageButton imbSearch()
	{
		return (ImageButton)super.getControl(7);
	}

	public static class Forms implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			private LocalFormName(int name)
			{
				super(name);
			}
		}

		private Forms()
		{
			Core = new CoreForms();
		}
		public final class CoreForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreForms()
			{
				TransportBooking = new LocalFormName(134137);
			}
			public final FormName TransportBooking;
		}

		public CoreForms Core;
	}


	public static class Images implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		private final class ImageHelper extends ims.framework.utils.ImagePath
		{
			private static final long serialVersionUID = 1L;
			
			private ImageHelper(int id, String path, Integer width, Integer height)
			{
				super(id, path, width, height);
			}
		}
		private Images()
		{
			Core = new CoreImages();
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				FindDisabled16 = new ImageHelper(102165, "Images/Core/FindDisabled16.gif", new Integer(16), new Integer(16));
				FindDisabled24 = new ImageHelper(102172, "Images/Core/FindDisabled_24.png", new Integer(24), new Integer(24));
				FindEnabled16 = new ImageHelper(102164, "Images/Core/Find.gif", new Integer(16), new Integer(16));
				FindEnabled24 = new ImageHelper(102175, "Images/Core/Find_24.png", new Integer(24), new Integer(24));
				ClearDisabled16 = new ImageHelper(102167, "Images/Core/ClearDisabled16.gif", new Integer(16), new Integer(16));
				ClearDisabled24 = new ImageHelper(102173, "Images/Core/ClearDisabled_24.png", new Integer(24), new Integer(24));
				ClearEnabled16 = new ImageHelper(102168, "Images/Core/Clear.gif", new Integer(16), new Integer(16));
				ClearEnabled24 = new ImageHelper(102174, "Images/Core/ClearEnabled_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image FindDisabled16;
			public final ims.framework.utils.Image FindDisabled24;
			public final ims.framework.utils.Image FindEnabled16;
			public final ims.framework.utils.Image FindEnabled24;
			public final ims.framework.utils.Image ClearDisabled16;
			public final ims.framework.utils.Image ClearDisabled24;
			public final ims.framework.utils.Image ClearEnabled16;
			public final ims.framework.utils.Image ClearEnabled24;
		}
		public final CoreImages Core;
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}
	public LocalContext getLocalContext()
	{
		return (LocalContext)super.getLocalCtx();
	}
	public class LocalContext extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
		
		public LocalContext(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			super.setContext(context);
			String prefix = formInfo.getLocalVariablesPrefix();
			cxl_ReportContext = new ims.framework.ContextVariable("ReportContext", prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier + "");
		}
		
		public boolean getReportContextIsNotNull()
		{
			return !cxl_ReportContext.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentTransportVo getReportContext()
		{
			return (ims.scheduling.vo.Booking_AppointmentTransportVo)cxl_ReportContext.getValue(context);
		}
		public void setReportContext(ims.scheduling.vo.Booking_AppointmentTransportVo value)
		{
			cxl_ReportContext.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_ReportContext = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public RefManNamespace RefMan = new RefManNamespace();
		public final class RefManNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class Tansport implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int Edit = 1;
			}
			public void disableAllTansportMenuItems()
			{
				this.contextMenuTansportEditItem.setEnabled(false);
			}
			public void hideAllTansportMenuItems()
			{
				this.contextMenuTansportEditItem.setVisible(false);
			}
			private Menu contextMenuTansport;
			public MenuItem getTansportEditItem()
			{
				return this.contextMenuTansportEditItem;
			}
			private MenuItem contextMenuTansportEditItem;
		}
	}

	private ContextMenus contextMenus;
	public ContextMenus getContextMenus()
	{
		return this.contextMenus;
	}

	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[80];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_RefMan.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			fields[71] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-ID", "ID_Booking_Appointment");
			fields[72] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-APPOINTMENTDATE", "AppointmentDate");
			fields[73] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-APPTSTARTTIME", "ApptStartTime");
			fields[74] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-APPTENDTIME", "ApptEndTime");
			fields[75] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-EARLIESTOFFEREDDATE", "EarliestOfferedDate");
			fields[76] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-TRANSPORTTYPE", "TransportType");
			fields[77] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-ISTRANSPORTREQUIRED", "IsTransportRequired");
			fields[78] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-ISTRANSPORTBOOKED", "IsTransportBooked");
			fields[79] = new ims.framework.ReportField(this.context, prefix + "_lv_Core.Transport.__internal_x_context__ReportContext_" + componentIdentifier, "BO-1055100007-CARECONTEXT", "CareContext");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
