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

package ims.admin.forms.systemjobs;

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
	public static class cmbRefreshIntervalComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(Integer value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(Integer value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(Integer value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(Integer value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(Integer value)
		{
			return super.control.removeRow(value);
		}
		public Integer getValue()
		{
			return (Integer)super.control.getValue();
		}
		public void setValue(Integer value)
		{
			super.control.setValue(value);
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
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Timers
		timers = new Timers();
		timers.TimerRefresh = factory.createTimer(0, 1, true);
		form.addTimer(timers.TimerRefresh);

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.Admin.contextMenuSystemJob = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Admin.contextMenuSystemJobNewItem = factory.createMenuItem(startControlID.intValue() + 1, "New", true, false, new Integer(102179), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660001)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobNewItem);
		contextMenus.Admin.contextMenuSystemJobEditItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit", true, false, new Integer(102150), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660002)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobEditItem);
		contextMenus.Admin.contextMenuSystemJobRunOnceItem = factory.createMenuItem(startControlID.intValue() + 3, "Run Once", true, false, new Integer(103439), true, true);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660003)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobRunOnceItem);
		contextMenus.Admin.contextMenuSystemJobPauseItem = factory.createMenuItem(startControlID.intValue() + 4, "Pause", true, false, new Integer(103438), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660004)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobPauseItem);
		contextMenus.Admin.contextMenuSystemJobResumeItem = factory.createMenuItem(startControlID.intValue() + 5, "Resume", true, false, new Integer(102169), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660005)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobResumeItem);
		contextMenus.Admin.contextMenuSystemJobStopItem = factory.createMenuItem(startControlID.intValue() + 6, "Stop", true, false, null, true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660006)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobStopItem);
		contextMenus.Admin.contextMenuSystemJobDeleteItem = factory.createMenuItem(startControlID.intValue() + 7, "Delete", true, false, new Integer(102148), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660007)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobDeleteItem);
		contextMenus.Admin.contextMenuSystemJobViewHistoryItem = factory.createMenuItem(startControlID.intValue() + 8, "View History", true, false, new Integer(102555), true, true);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(3660008)))
			contextMenus.Admin.contextMenuSystemJob.add(contextMenus.Admin.contextMenuSystemJobViewHistoryItem);
		form.registerMenu(contextMenus.Admin.contextMenuSystemJob);


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 8, 11, 134, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Select refresh interval:", new Integer(1), null, new Integer(0)}));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 144, 8, 88, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_cmbRefreshIntervalTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(-1), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,Boolean.TRUE, Boolean.TRUE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbRefreshIntervalTemp);
		cmbRefreshIntervalComboBox cmbRefreshInterval = (cmbRefreshIntervalComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbRefreshIntervalComboBox.class, m_cmbRefreshIntervalTemp);
		super.addComboBox(cmbRefreshInterval);

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 8, 32, 408, 584, ims.framework.enumerations.ControlAnchoring.TOPBOTTOMLEFT);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(-1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPBOTTOMLEFT, null, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE}));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 432, 32, 408, 584, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(-1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, contextMenus.Admin.contextMenuSystemJob, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public cmbRefreshIntervalComboBox cmbRefreshInterval()
	{
		return (cmbRefreshIntervalComboBox)super.getComboBox(0);
	}
	public DynamicGrid dyngrdSystemJobs()
	{
		return (DynamicGrid)super.getControl(2);
	}
	public DynamicGrid dyngrdConfiguredJobs()
	{
		return (DynamicGrid)super.getControl(3);
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
				SystemJobDetails = new LocalFormName(139100);
				SystemJobHistory = new LocalFormName(103223);
			}
			public final FormName SystemJobDetails;
			public final FormName SystemJobHistory;
		}

		public AdminForms Admin;
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
			Admin = new AdminImages();
			Core = new CoreImages();
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				SystemJob32 = new ImageHelper(103434, "Images/Admin/SystemJob_32.png", new Integer(32), new Integer(32));
				SystemJobConfigured32 = new ImageHelper(103435, "Images/Admin/SystemJob_ok_32.png", new Integer(32), new Integer(32));
				SystemJobUnconfigured32 = new ImageHelper(103436, "Images/Admin/SystemJob_remove_32.png", new Integer(32), new Integer(32));
			}
			public final ims.framework.utils.Image SystemJob32;
			public final ims.framework.utils.Image SystemJobConfigured32;
			public final ims.framework.utils.Image SystemJobUnconfigured32;
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				User = new ImageHelper(102316, "Images/Core/user.ico", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image User;
		}
		public final AdminImages Admin;
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
			cxl_SelectedConfiguredJob = new ims.framework.ContextVariable("SelectedConfiguredJob", prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier + "");
			cxl_SelectedSystemJob = new ims.framework.ContextVariable("SelectedSystemJob", prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier + "");
		}
		
		public boolean getSelectedConfiguredJobIsNotNull()
		{
			return !cxl_SelectedConfiguredJob.getValueIsNull(context);
		}
		public ims.admin.vo.ConfiguredJobVo getSelectedConfiguredJob()
		{
			return (ims.admin.vo.ConfiguredJobVo)cxl_SelectedConfiguredJob.getValue(context);
		}
		public void setSelectedConfiguredJob(ims.admin.vo.ConfiguredJobVo value)
		{
			cxl_SelectedConfiguredJob.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedConfiguredJob = null;
		public boolean getSelectedSystemJobIsNotNull()
		{
			return !cxl_SelectedSystemJob.getValueIsNull(context);
		}
		public ims.admin.vo.SystemJobVo getSelectedSystemJob()
		{
			return (ims.admin.vo.SystemJobVo)cxl_SelectedSystemJob.getValue(context);
		}
		public void setSelectedSystemJob(ims.admin.vo.SystemJobVo value)
		{
			cxl_SelectedSystemJob.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedSystemJob = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public AdminNamespace Admin = new AdminNamespace();
		public final class AdminNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class SystemJob implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int New = 1;
				public static final int Edit = 2;
				public static final int RunOnce = 3;
				public static final int Pause = 4;
				public static final int Resume = 5;
				public static final int Stop = 6;
				public static final int Delete = 7;
				public static final int ViewHistory = 8;
			}
			public void disableAllSystemJobMenuItems()
			{
				this.contextMenuSystemJobNewItem.setEnabled(false);
				this.contextMenuSystemJobEditItem.setEnabled(false);
				this.contextMenuSystemJobRunOnceItem.setEnabled(false);
				this.contextMenuSystemJobPauseItem.setEnabled(false);
				this.contextMenuSystemJobResumeItem.setEnabled(false);
				this.contextMenuSystemJobStopItem.setEnabled(false);
				this.contextMenuSystemJobDeleteItem.setEnabled(false);
				this.contextMenuSystemJobViewHistoryItem.setEnabled(false);
			}
			public void hideAllSystemJobMenuItems()
			{
				this.contextMenuSystemJobNewItem.setVisible(false);
				this.contextMenuSystemJobEditItem.setVisible(false);
				this.contextMenuSystemJobRunOnceItem.setVisible(false);
				this.contextMenuSystemJobPauseItem.setVisible(false);
				this.contextMenuSystemJobResumeItem.setVisible(false);
				this.contextMenuSystemJobStopItem.setVisible(false);
				this.contextMenuSystemJobDeleteItem.setVisible(false);
				this.contextMenuSystemJobViewHistoryItem.setVisible(false);
			}
			private Menu contextMenuSystemJob;
			public ReadOnlyMenuItem getSystemJobNewItem()
			{
				return this.contextMenuSystemJobNewItem;
			}
			private MenuItem contextMenuSystemJobNewItem;
			public ReadOnlyMenuItem getSystemJobEditItem()
			{
				return this.contextMenuSystemJobEditItem;
			}
			private MenuItem contextMenuSystemJobEditItem;
			public ReadOnlyMenuItem getSystemJobRunOnceItem()
			{
				return this.contextMenuSystemJobRunOnceItem;
			}
			private MenuItem contextMenuSystemJobRunOnceItem;
			public ReadOnlyMenuItem getSystemJobPauseItem()
			{
				return this.contextMenuSystemJobPauseItem;
			}
			private MenuItem contextMenuSystemJobPauseItem;
			public ReadOnlyMenuItem getSystemJobResumeItem()
			{
				return this.contextMenuSystemJobResumeItem;
			}
			private MenuItem contextMenuSystemJobResumeItem;
			public ReadOnlyMenuItem getSystemJobStopItem()
			{
				return this.contextMenuSystemJobStopItem;
			}
			private MenuItem contextMenuSystemJobStopItem;
			public ReadOnlyMenuItem getSystemJobDeleteItem()
			{
				return this.contextMenuSystemJobDeleteItem;
			}
			private MenuItem contextMenuSystemJobDeleteItem;
			public ReadOnlyMenuItem getSystemJobViewHistoryItem()
			{
				return this.contextMenuSystemJobViewHistoryItem;
			}
			private MenuItem contextMenuSystemJobViewHistoryItem;
		}
	}

	private ContextMenus contextMenus;
	public ContextMenus getContextMenus()
	{
		return this.contextMenus;
	}


	public final class Timers implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		private Timer TimerRefresh;
		public Timer getTimerRefresh()
		{
			return TimerRefresh;
		}
		public void enableAll()
		{
			TimerRefresh.setEnabled(true);
		}
		public void disableAll()
		{
			TimerRefresh.setEnabled(false);
		}
	}
	private Timers timers;
	public Timers getTimers()
	{
		return this.timers;
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
			IReportField[] fields = new IReportField[109];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Admin.SystemJob", "BO-1028100056-ID", "ID_SystemJob");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Admin.SystemJob", "BO-1028100056-NAME", "Name");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Admin.SystemJob", "BO-1028100056-DESCRIPTION", "Description");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_Admin.SystemJob", "BO-1028100056-IMPLNAME", "ImplName");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_Admin.SystemJob", "BO-1028100056-ISACTIVE", "IsActive");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_Admin.SystemJob", "BO-1028100056-IMSID", "ImsId");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_Admin.SystemJob", "BO-1028100056-CONFIGFORMID", "ConfigFormId");
			fields[78] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-ID", "ID_ConfiguredJob");
			fields[79] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-STARTDATETIME", "StartDateTime");
			fields[80] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-ENDDATETIME", "EndDateTime");
			fields[81] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-ISCRONTRIGGER", "IsCronTrigger");
			fields[82] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-CRONEXPRESSION", "CronExpression");
			fields[83] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-LASTRUN", "LastRun");
			fields[84] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-NEXTRUN", "NextRun");
			fields[85] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-CRONEXPRESSIONDISPLAY", "CronExpressionDisplay");
			fields[86] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-ISACTIVE", "IsActive");
			fields[87] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-DESCRIPTION", "Description");
			fields[88] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-FREQUENCY", "Frequency");
			fields[89] = new ims.framework.ReportField(this.context, "_cv_Admin.CurrentJobConfiguration", "BO-1028100057-NAME", "Name");
			fields[90] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-ID", "ID_ConfiguredJob");
			fields[91] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-STARTDATETIME", "StartDateTime");
			fields[92] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-ENDDATETIME", "EndDateTime");
			fields[93] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-ISCRONTRIGGER", "IsCronTrigger");
			fields[94] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-CRONEXPRESSION", "CronExpression");
			fields[95] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-LASTRUN", "LastRun");
			fields[96] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-NEXTRUN", "NextRun");
			fields[97] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-CRONEXPRESSIONDISPLAY", "CronExpressionDisplay");
			fields[98] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-ISACTIVE", "IsActive");
			fields[99] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-DESCRIPTION", "Description");
			fields[100] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-FREQUENCY", "Frequency");
			fields[101] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedConfiguredJob_" + componentIdentifier, "BO-1028100057-NAME", "Name");
			fields[102] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier, "BO-1028100056-ID", "ID_SystemJob");
			fields[103] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier, "BO-1028100056-NAME", "Name");
			fields[104] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier, "BO-1028100056-DESCRIPTION", "Description");
			fields[105] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier, "BO-1028100056-IMPLNAME", "ImplName");
			fields[106] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier, "BO-1028100056-ISACTIVE", "IsActive");
			fields[107] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier, "BO-1028100056-IMSID", "ImsId");
			fields[108] = new ims.framework.ReportField(this.context, prefix + "_lv_Admin.SystemJobs.__internal_x_context__SelectedSystemJob_" + componentIdentifier, "BO-1028100056-CONFIGFORMID", "ConfigFormId");
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
