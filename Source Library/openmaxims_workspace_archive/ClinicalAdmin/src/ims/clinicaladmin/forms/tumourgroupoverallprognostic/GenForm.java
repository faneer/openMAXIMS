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

package ims.clinicaladmin.forms.tumourgroupoverallprognostic;

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
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
	}
	private void validateMandatoryContext(Context context)
	{
		if(new ims.framework.ContextVariable("ClinicalAdmin.TumourGroup", "_cv_ClinicalAdmin.TumourGroup").getValueIsNull(context))
			throw new ims.framework.exceptions.FormMandatoryContextMissingException("The required context data 'ClinicalAdmin.TumourGroup' is not available.");
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
			validateMandatoryContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(1000, 600);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.contextMenuGenericGrid = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.contextMenuGenericGridAddItem = factory.createMenuItem(startControlID.intValue() + 1, "New", true, false, new Integer(102179), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridAddItem);
		contextMenus.contextMenuGenericGridUpdateItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit", true, false, new Integer(102150), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridUpdateItem);
		contextMenus.contextMenuGenericGridRemoveItem = factory.createMenuItem(startControlID.intValue() + 3, "Remove", true, false, new Integer(102148), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridRemoveItem);
		contextMenus.contextMenuGenericGridViewItem = factory.createMenuItem(startControlID.intValue() + 4, "View", true, false, new Integer(102223), false, true);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridViewItem);
		contextMenus.contextMenuGenericGridMoveUpItem = factory.createMenuItem(startControlID.intValue() + 5, "Move Up", true, false, new Integer(102197), true, true);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridMoveUpItem);
		contextMenus.contextMenuGenericGridMoveDownItem = factory.createMenuItem(startControlID.intValue() + 6, "Move Down", true, false, new Integer(102198), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridMoveDownItem);
		contextMenus.contextMenuGenericGridReplaceItem = factory.createMenuItem(startControlID.intValue() + 7, "Replace", true, false, new Integer(102255), true, true);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridReplaceItem);
		contextMenus.contextMenuGenericGridConfirmItem = factory.createMenuItem(startControlID.intValue() + 8, "Confirm", true, false, new Integer(102209), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridConfirmItem);
		contextMenus.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem = factory.createMenuItem(startControlID.intValue() + 9, "Edit/View ICP action(s)", true, false, new Integer(118107), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem);
		form.registerMenu(contextMenus.contextMenuGenericGrid);


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 96, 8, 9, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "-", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 79, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Group Name:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 920, 568, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 840, 568, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Save", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// CheckBox Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 656, 8, 128, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(CheckBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,"Generate Default List", Boolean.TRUE, null}));

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 8, 32, 984, 528, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.EDITABLE, ControlState.EDITABLE, ims.framework.enumerations.ControlAnchoring.ALL, contextMenus.contextMenuGenericGrid, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}
	public Label lblGeoup()
	{
		return (Label)super.getControl(0);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(2);
	}
	public Button btnSave()
	{
		return (Button)super.getControl(3);
	}
	public CheckBox chkGenerate()
	{
		return (CheckBox)super.getControl(4);
	}
	public DynamicGrid dyngrdOverall()
	{
		return (DynamicGrid)super.getControl(5);
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
			ClinicalAdmin = new ClinicalAdminForms();
		}
		public final class ClinicalAdminForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private ClinicalAdminForms()
			{
				TumourOverallPrognostic = new LocalFormName(104151);
			}
			public final FormName TumourOverallPrognostic;
		}

		public ClinicalAdminForms ClinicalAdmin;
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
			cxl_SortOrder_T = new ims.framework.ContextVariable("SortOrder_T", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_T_" + componentIdentifier + "");
			cxl_SortOrder_N = new ims.framework.ContextVariable("SortOrder_N", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_N_" + componentIdentifier + "");
			cxl_SortOrder_M = new ims.framework.ContextVariable("SortOrder_M", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_M_" + componentIdentifier + "");
			cxl_SortOrder_HisType = new ims.framework.ContextVariable("SortOrder_HisType", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_HisType_" + componentIdentifier + "");
			cxl_SortOrder_HisGrade = new ims.framework.ContextVariable("SortOrder_HisGrade", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_HisGrade_" + componentIdentifier + "");
			cxl_SortOrder_Loc = new ims.framework.ContextVariable("SortOrder_Loc", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_Loc_" + componentIdentifier + "");
			cxl_SortOrder_Risk = new ims.framework.ContextVariable("SortOrder_Risk", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_Risk_" + componentIdentifier + "");
			cxl_SortOrder_PSA = new ims.framework.ContextVariable("SortOrder_PSA", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_PSA_" + componentIdentifier + "");
			cxl_SortOrder_Gleason = new ims.framework.ContextVariable("SortOrder_Gleason", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_Gleason_" + componentIdentifier + "");
			cxl_SortOrder_Overall = new ims.framework.ContextVariable("SortOrder_Overall", prefix + "_lv_ClinicalAdmin.TumourGroupOverallPrognostic.__internal_x_context__SortOrder_Overall_" + componentIdentifier + "");
		}
		
		public boolean getSortOrder_TIsNotNull()
		{
			return !cxl_SortOrder_T.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_T()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_T.getValue(context);
		}
		public void setSortOrder_T(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_T.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_T = null;
		public boolean getSortOrder_NIsNotNull()
		{
			return !cxl_SortOrder_N.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_N()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_N.getValue(context);
		}
		public void setSortOrder_N(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_N.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_N = null;
		public boolean getSortOrder_MIsNotNull()
		{
			return !cxl_SortOrder_M.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_M()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_M.getValue(context);
		}
		public void setSortOrder_M(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_M.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_M = null;
		public boolean getSortOrder_HisTypeIsNotNull()
		{
			return !cxl_SortOrder_HisType.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_HisType()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_HisType.getValue(context);
		}
		public void setSortOrder_HisType(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_HisType.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_HisType = null;
		public boolean getSortOrder_HisGradeIsNotNull()
		{
			return !cxl_SortOrder_HisGrade.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_HisGrade()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_HisGrade.getValue(context);
		}
		public void setSortOrder_HisGrade(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_HisGrade.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_HisGrade = null;
		public boolean getSortOrder_LocIsNotNull()
		{
			return !cxl_SortOrder_Loc.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_Loc()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_Loc.getValue(context);
		}
		public void setSortOrder_Loc(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_Loc.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_Loc = null;
		public boolean getSortOrder_RiskIsNotNull()
		{
			return !cxl_SortOrder_Risk.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_Risk()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_Risk.getValue(context);
		}
		public void setSortOrder_Risk(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_Risk.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_Risk = null;
		public boolean getSortOrder_PSAIsNotNull()
		{
			return !cxl_SortOrder_PSA.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_PSA()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_PSA.getValue(context);
		}
		public void setSortOrder_PSA(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_PSA.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_PSA = null;
		public boolean getSortOrder_GleasonIsNotNull()
		{
			return !cxl_SortOrder_Gleason.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_Gleason()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_Gleason.getValue(context);
		}
		public void setSortOrder_Gleason(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_Gleason.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_Gleason = null;
		public boolean getSortOrder_OverallIsNotNull()
		{
			return !cxl_SortOrder_Overall.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder_Overall()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder_Overall.getValue(context);
		}
		public void setSortOrder_Overall(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder_Overall.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder_Overall = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public final class GenericGrid implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public static final int Add = 1;
			public static final int Update = 2;
			public static final int Remove = 3;
			public static final int View = 4;
			public static final int MoveUp = 5;
			public static final int MoveDown = 6;
			public static final int Replace = 7;
			public static final int Confirm = 8;
			public static final int EDIT_VIEW_ICP_ACTIONS = 9;
		}
		public void disableAllGenericGridMenuItems()
		{
			this.contextMenuGenericGridAddItem.setEnabled(false);
			this.contextMenuGenericGridUpdateItem.setEnabled(false);
			this.contextMenuGenericGridRemoveItem.setEnabled(false);
			this.contextMenuGenericGridViewItem.setEnabled(false);
			this.contextMenuGenericGridMoveUpItem.setEnabled(false);
			this.contextMenuGenericGridMoveDownItem.setEnabled(false);
			this.contextMenuGenericGridReplaceItem.setEnabled(false);
			this.contextMenuGenericGridConfirmItem.setEnabled(false);
			this.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem.setEnabled(false);
		}
		public void hideAllGenericGridMenuItems()
		{
			this.contextMenuGenericGridAddItem.setVisible(false);
			this.contextMenuGenericGridUpdateItem.setVisible(false);
			this.contextMenuGenericGridRemoveItem.setVisible(false);
			this.contextMenuGenericGridViewItem.setVisible(false);
			this.contextMenuGenericGridMoveUpItem.setVisible(false);
			this.contextMenuGenericGridMoveDownItem.setVisible(false);
			this.contextMenuGenericGridReplaceItem.setVisible(false);
			this.contextMenuGenericGridConfirmItem.setVisible(false);
			this.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem.setVisible(false);
		}
		private Menu contextMenuGenericGrid;
		public MenuItem getGenericGridAddItem()
		{
			return this.contextMenuGenericGridAddItem;
		}
		private MenuItem contextMenuGenericGridAddItem;
		public MenuItem getGenericGridUpdateItem()
		{
			return this.contextMenuGenericGridUpdateItem;
		}
		private MenuItem contextMenuGenericGridUpdateItem;
		public MenuItem getGenericGridRemoveItem()
		{
			return this.contextMenuGenericGridRemoveItem;
		}
		private MenuItem contextMenuGenericGridRemoveItem;
		public MenuItem getGenericGridViewItem()
		{
			return this.contextMenuGenericGridViewItem;
		}
		private MenuItem contextMenuGenericGridViewItem;
		public MenuItem getGenericGridMoveUpItem()
		{
			return this.contextMenuGenericGridMoveUpItem;
		}
		private MenuItem contextMenuGenericGridMoveUpItem;
		public MenuItem getGenericGridMoveDownItem()
		{
			return this.contextMenuGenericGridMoveDownItem;
		}
		private MenuItem contextMenuGenericGridMoveDownItem;
		public MenuItem getGenericGridReplaceItem()
		{
			return this.contextMenuGenericGridReplaceItem;
		}
		private MenuItem contextMenuGenericGridReplaceItem;
		public MenuItem getGenericGridConfirmItem()
		{
			return this.contextMenuGenericGridConfirmItem;
		}
		private MenuItem contextMenuGenericGridConfirmItem;
		public MenuItem getGenericGridEDIT_VIEW_ICP_ACTIONSItem()
		{
			return this.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem;
		}
		private MenuItem contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem;
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
			IReportField[] fields = new IReportField[89];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-ID", "ID_TumourGroup");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-GROUPNAME", "GroupName");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-ISACTIVE", "IsActive");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-HASTNM", "HasTNM");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-ISPROGNOSTICGROUPINGRELEVANT", "IsPrognosticGroupingRelevant");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-GROUPDESCRIPTION", "GroupDescription");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-HASOTHERCLASSIFICATIONS", "HasOtherClassifications");
			fields[78] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-TNMREQUIRESDIFF", "TnmRequiresDiff");
			fields[79] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-TNMREQUIRESOVER45", "TnmRequiresOver45");
			fields[80] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-TNMREQUIRESHISTO", "TnmRequiresHisto");
			fields[81] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-TNMREQUIRESSMARKERS", "TnmRequiresSMarkers");
			fields[82] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.TumourGroup", "BO-1074100009-TNMVERSION", "TNMVersion");
			fields[83] = new ims.framework.ReportField(this.context, "_cv_Oncology.SelectedRecordForOverallPrognosticDialog", "BO-1075100019-ID", "ID_PrognosticGrouping");
			fields[84] = new ims.framework.ReportField(this.context, "_cv_Oncology.SelectedRecordForOverallPrognosticDialog", "BO-1075100019-PROGNOSTICGROUP", "PrognosticGroup");
			fields[85] = new ims.framework.ReportField(this.context, "_cv_Oncology.SelectedRecordForOverallPrognosticDialog", "BO-1075100019-ISACTIVE", "IsActive");
			fields[86] = new ims.framework.ReportField(this.context, "_cv_Oncology.SelectedRecordForOverallPrognosticDialog", "BO-1075100019-TGROUP", "TGroup");
			fields[87] = new ims.framework.ReportField(this.context, "_cv_Oncology.SelectedRecordForOverallPrognosticDialog", "BO-1075100019-TSITE", "TSite");
			fields[88] = new ims.framework.ReportField(this.context, "_cv_Oncology.SelectedRecordForOverallPrognosticDialog", "BO-1075100019-O45", "O45");
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
