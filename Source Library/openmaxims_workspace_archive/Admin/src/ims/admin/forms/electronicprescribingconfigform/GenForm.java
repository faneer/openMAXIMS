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

package ims.admin.forms.electronicprescribingconfigform;

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
	public static class grdDetailsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdDetailsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setColButtonReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean isColButtonReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showColButtonOpened()
		{
			super.row.showOpened(0);
		}
		public void setTooltipForColButton(String value)
		{
			super.row.setTooltip(0, value);
		}
		public String getColButton()
		{
			return (String)super.row.get(0);
		}
		public void setColButton(String value)
		{
			super.row.set(0, value);
		}
		public void setCellColButtonTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setColButtonTextReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean isColButtonTextReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showColButtonTextOpened()
		{
			super.row.showOpened(1);
		}
		public void setTooltipForColButtonText(String value)
		{
			super.row.setTooltip(1, value);
		}
		public String getColButtonText()
		{
			return (String)super.row.get(1);
		}
		public void setColButtonText(String value)
		{
			super.row.set(1, value);
		}
		public void setCellColButtonTextTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setColLabelTextReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean isColLabelTextReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showColLabelTextOpened()
		{
			super.row.showOpened(2);
		}
		public void setTooltipForColLabelText(String value)
		{
			super.row.setTooltip(2, value);
		}
		public String getColLabelText()
		{
			return (String)super.row.get(2);
		}
		public void setColLabelText(String value)
		{
			super.row.set(2, value);
		}
		public void setCellColLabelTextTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public void setColExePathReadOnly(boolean value)
		{
			super.row.setReadOnly(3, value);
		}
		public boolean isColExePathReadOnly()
		{
			return super.row.isReadOnly(3);
		}
		public void showColExePathOpened()
		{
			super.row.showOpened(3);
		}
		public void setTooltipForColExePath(String value)
		{
			super.row.setTooltip(3, value);
		}
		public String getColExePath()
		{
			return (String)super.row.get(3);
		}
		public void setColExePath(String value)
		{
			super.row.set(3, value);
		}
		public void setCellColExePathTooltip(String value)
		{
			super.row.setTooltip(3, value);
		}
		public void setColParameterReadOnly(boolean value)
		{
			super.row.setReadOnly(4, value);
		}
		public boolean isColParameterReadOnly()
		{
			return super.row.isReadOnly(4);
		}
		public void showColParameterOpened()
		{
			super.row.showOpened(4);
		}
		public void setTooltipForColParameter(String value)
		{
			super.row.setTooltip(4, value);
		}
		public String getColParameter()
		{
			return (String)super.row.get(4);
		}
		public void setColParameter(String value)
		{
			super.row.set(4, value);
		}
		public void setCellColParameterTooltip(String value)
		{
			super.row.setTooltip(4, value);
		}
		public void setColRolesReadOnly(boolean value)
		{
			super.row.setReadOnly(5, value);
		}
		public boolean isColRolesReadOnly()
		{
			return super.row.isReadOnly(5);
		}
		public void showColRolesOpened()
		{
			super.row.showOpened(5);
		}
		public void setTooltipForColRoles(String value)
		{
			super.row.setTooltip(5, value);
		}
		public String getColRoles()
		{
			return (String)super.row.get(5);
		}
		public void setColRoles(String value)
		{
			super.row.set(5, value);
		}
		public void setCellColRolesTooltip(String value)
		{
			super.row.setTooltip(5, value);
		}
		public java.lang.Object getValue()
		{
			return super.row.getValue();
		}
		public void setValue(java.lang.Object value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdDetailsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdDetailsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdDetailsRow get(int index)
		{
			return new grdDetailsRow(super.collection.get(index));
		}
		public grdDetailsRow newRow()
		{
			return new grdDetailsRow(super.collection.newRow());
		}
		public grdDetailsRow newRow(boolean autoSelect)
		{
			return new grdDetailsRow(super.collection.newRow(autoSelect));
		}
		public grdDetailsRow newRowAt(int index)
		{
			return new grdDetailsRow(super.collection.newRowAt(index));
		}
		public grdDetailsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdDetailsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdDetailsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public java.lang.Object[] getValues()
		{
			java.lang.Object[] listOfValues = new java.lang.Object[this.getRows().size()];
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues[x] = this.getRows().get(x).getValue();
			}
			return listOfValues;
		}
		public java.lang.Object getValue()
		{
			return super.grid.getValue();
		}
		public void setValue(java.lang.Object value)
		{
			super.grid.setValue(value);
		}
		public grdDetailsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdDetailsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdDetailsRowCollection getRows()
		{
			return new grdDetailsRowCollection(super.grid.getRows());
		}
		public grdDetailsRow getRowByValue(java.lang.Object value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdDetailsRow(row);
		}
		public void setColButtonHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getColButtonHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setColButtonTextHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getColButtonTextHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setColLabelTextHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getColLabelTextHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
		public void setColExePathHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(3, value);
		}
		public String getColExePathHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(3);
		}
		public void setColParameterHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(4, value);
		}
		public String getColParameterHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(4);
		}
		public void setColRolesHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(5, value);
		}
		public String getColRolesHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(5);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 632);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.Admin.contextMenuElectronicPrescribingMenu = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Admin.contextMenuElectronicPrescribingMenuEditButtonConfigurationItem = factory.createMenuItem(startControlID.intValue() + 1, "Edit Button Configuration ", true, false, new Integer(102150), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4490001)))
			contextMenus.Admin.contextMenuElectronicPrescribingMenu.add(contextMenus.Admin.contextMenuElectronicPrescribingMenuEditButtonConfigurationItem);
		contextMenus.Admin.contextMenuElectronicPrescribingMenuRemoveButtonConfigurationItem = factory.createMenuItem(startControlID.intValue() + 2, "Remove Button Configuration", true, false, new Integer(102300), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4490002)))
			contextMenus.Admin.contextMenuElectronicPrescribingMenu.add(contextMenus.Admin.contextMenuElectronicPrescribingMenuRemoveButtonConfigurationItem);
		contextMenus.Admin.contextMenuElectronicPrescribingMenuDenyRoleAccessItem = factory.createMenuItem(startControlID.intValue() + 3, "Deny Role Access", true, false, new Integer(102141), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4490003)))
			contextMenus.Admin.contextMenuElectronicPrescribingMenu.add(contextMenus.Admin.contextMenuElectronicPrescribingMenuDenyRoleAccessItem);
		form.registerMenu(contextMenus.Admin.contextMenuElectronicPrescribingMenu);


		// Grid Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 816, 600, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdDetailsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), new Integer(-1), ControlState.READONLY, ControlState.EDITABLE, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, contextMenus.Admin.contextMenuElectronicPrescribingMenu, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.TRUE, Boolean.TRUE});
		addControl(m_grdDetailsTemp);
		grdDetailsGrid grdDetails = (grdDetailsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdDetailsGrid.class, m_grdDetailsTemp);
		grdDetails.addStringColumn("Button", 0, 0, 100, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdDetails.addStringColumn("Button Text", 0, 0, 130, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdDetails.addStringColumn("Label Text", 0, 0, 130, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdDetails.addStringColumn("Executable Path ", 0, 0, 150, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdDetails.addStringColumn("Parameter", 0, 0, 70, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdDetails.addStringColumn("Roles", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdDetails);
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}
	public grdDetailsGrid grdDetails()
	{
		return (grdDetailsGrid)super.getGrid(0);
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
			Admin = new AdminForms();
		}
		public final class AdminForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminForms()
			{
				ElectronicPrescribingConfigDialog = new LocalFormName(103240);
				RoleSelect = new LocalFormName(103172);
			}
			public final FormName ElectronicPrescribingConfigDialog;
			public final FormName RoleSelect;
		}

		public AdminForms Admin;
	}

	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public AdminNamespace Admin = new AdminNamespace();
		public final class AdminNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class ElectronicPrescribingMenu implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int EditButtonConfiguration = 1;
				public static final int RemoveButtonConfiguration = 2;
				public static final int DenyRoleAccess = 3;
			}
			public void disableAllElectronicPrescribingMenuMenuItems()
			{
				this.contextMenuElectronicPrescribingMenuEditButtonConfigurationItem.setEnabled(false);
				this.contextMenuElectronicPrescribingMenuRemoveButtonConfigurationItem.setEnabled(false);
				this.contextMenuElectronicPrescribingMenuDenyRoleAccessItem.setEnabled(false);
			}
			public void hideAllElectronicPrescribingMenuMenuItems()
			{
				this.contextMenuElectronicPrescribingMenuEditButtonConfigurationItem.setVisible(false);
				this.contextMenuElectronicPrescribingMenuRemoveButtonConfigurationItem.setVisible(false);
				this.contextMenuElectronicPrescribingMenuDenyRoleAccessItem.setVisible(false);
			}
			private Menu contextMenuElectronicPrescribingMenu;
			public ReadOnlyMenuItem getElectronicPrescribingMenuEditButtonConfigurationItem()
			{
				return this.contextMenuElectronicPrescribingMenuEditButtonConfigurationItem;
			}
			private MenuItem contextMenuElectronicPrescribingMenuEditButtonConfigurationItem;
			public ReadOnlyMenuItem getElectronicPrescribingMenuRemoveButtonConfigurationItem()
			{
				return this.contextMenuElectronicPrescribingMenuRemoveButtonConfigurationItem;
			}
			private MenuItem contextMenuElectronicPrescribingMenuRemoveButtonConfigurationItem;
			public ReadOnlyMenuItem getElectronicPrescribingMenuDenyRoleAccessItem()
			{
				return this.contextMenuElectronicPrescribingMenuDenyRoleAccessItem;
			}
			private MenuItem contextMenuElectronicPrescribingMenuDenyRoleAccessItem;
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
			IReportField[] fields = new IReportField[77];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Admin.ElectronicPrescribingConfigVo", "BO-1004100055-ID", "ID_ElectronicPrescribingConfig");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Admin.ElectronicPrescribingConfigVo", "BO-1004100055-BUTTON", "Button");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Admin.ElectronicPrescribingConfigVo", "BO-1004100055-BUTTONTEXT", "ButtonText");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_Admin.ElectronicPrescribingConfigVo", "BO-1004100055-LABELTEXT", "LabelText");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_Admin.ElectronicPrescribingConfigVo", "BO-1004100055-BUTTONEXECUTABLEPATH", "ButtonExecutablePath");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_Admin.ElectronicPrescribingConfigVo", "BO-1004100055-BUTTONPARAMETER", "ButtonParameter");
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
