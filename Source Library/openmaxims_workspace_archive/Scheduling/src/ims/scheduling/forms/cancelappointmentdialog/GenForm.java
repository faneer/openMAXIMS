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

package ims.scheduling.forms.cancelappointmentdialog;

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
	public static class cmbCancellationReasonComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.scheduling.vo.lookups.CancelAppointmentReason value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.scheduling.vo.lookups.CancelAppointmentReason value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.scheduling.vo.lookups.CancelAppointmentReason value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.scheduling.vo.lookups.CancelAppointmentReason value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.scheduling.vo.lookups.CancelAppointmentReason value)
		{
			return super.control.removeRow(value);
		}
		public ims.scheduling.vo.lookups.CancelAppointmentReason getValue()
		{
			return (ims.scheduling.vo.lookups.CancelAppointmentReason)super.control.getValue();
		}
		public void setValue(ims.scheduling.vo.lookups.CancelAppointmentReason value)
		{
			super.control.setValue(value);
		}
	}
	public static class cmbCancellationTypeComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.scheduling.vo.lookups.Status_Reason value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.scheduling.vo.lookups.Status_Reason value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.scheduling.vo.lookups.Status_Reason value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.scheduling.vo.lookups.Status_Reason value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.scheduling.vo.lookups.Status_Reason value)
		{
			return super.control.removeRow(value);
		}
		public ims.scheduling.vo.lookups.Status_Reason getValue()
		{
			return (ims.scheduling.vo.lookups.Status_Reason)super.control.getValue();
		}
		public void setValue(ims.scheduling.vo.lookups.Status_Reason value)
		{
			super.control.setValue(value);
		}
	}

	public static class ansRebookAnswerBox extends AnswerBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void clear()
		{
			control.clear();
		}
		public java.util.ArrayList getValues()
		{
			return control.getValues();
		}
		public void addOption(ims.core.vo.lookups.YesNo option)
		{
			control.addOption(option);
		}
		public ims.core.vo.lookups.YesNo getValue()
		{
			return (ims.core.vo.lookups.YesNo)super.control.getValue();
		}
		public void setValue(ims.core.vo.lookups.YesNo value)
		{
			super.control.setValue(value);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.RefMan.vo.CatsReferralRefVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.RefMan.vo.CatsReferralRefVo' of the global context variable 'RefMan.CatsReferral' is not supported.");
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(520, 280);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 16, 250, 128, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Non-Medical  Reason:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 16, 236, 84, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Cancelled For ", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 16, 96, 124, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Rebooking Required:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 16, 216, 69, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Cancel TCI:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 16, 136, 63, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Comment:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 16, 56, 50, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Reason:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 109, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Cancellation Type:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 424, 248, 80, 24, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 10), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 336, 248, 80, 24, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1008), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 8), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Save", Boolean.TRUE, null, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// TextBox Controls
		RuntimeAnchoring anchoringHelper10 = new RuntimeAnchoring(designSize, runtimeSize, 144, 136, 360, 64, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1009), new Integer(anchoringHelper10.getX()), new Integer(anchoringHelper10.getY()), new Integer(anchoringHelper10.getWidth()), new Integer(anchoringHelper10.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, new Integer(255), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper11 = new RuntimeAnchoring(designSize, runtimeSize, 144, 56, 360, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_cmbCancellationReasonTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1010), new Integer(anchoringHelper11.getX()), new Integer(anchoringHelper11.getY()), new Integer(anchoringHelper11.getWidth()), new Integer(anchoringHelper11.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,Boolean.TRUE, Boolean.FALSE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.TRUE, new Integer(-1)});
		addControl(m_cmbCancellationReasonTemp);
		cmbCancellationReasonComboBox cmbCancellationReason = (cmbCancellationReasonComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbCancellationReasonComboBox.class, m_cmbCancellationReasonTemp);
		super.addComboBox(cmbCancellationReason);
		RuntimeAnchoring anchoringHelper12 = new RuntimeAnchoring(designSize, runtimeSize, 144, 16, 360, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_cmbCancellationTypeTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1011), new Integer(anchoringHelper12.getX()), new Integer(anchoringHelper12.getY()), new Integer(anchoringHelper12.getWidth()), new Integer(anchoringHelper12.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,Boolean.TRUE, Boolean.TRUE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.TRUE, new Integer(-1)});
		addControl(m_cmbCancellationTypeTemp);
		cmbCancellationTypeComboBox cmbCancellationType = (cmbCancellationTypeComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbCancellationTypeComboBox.class, m_cmbCancellationTypeTemp);
		super.addComboBox(cmbCancellationType);

		// CheckBox Controls
		RuntimeAnchoring anchoringHelper13 = new RuntimeAnchoring(designSize, runtimeSize, 144, 248, 16, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(CheckBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1012), new Integer(anchoringHelper13.getX()), new Integer(anchoringHelper13.getY()), new Integer(anchoringHelper13.getWidth()), new Integer(anchoringHelper13.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,"", Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper14 = new RuntimeAnchoring(designSize, runtimeSize, 144, 216, 16, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(CheckBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1013), new Integer(anchoringHelper14.getX()), new Integer(anchoringHelper14.getY()), new Integer(anchoringHelper14.getWidth()), new Integer(anchoringHelper14.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,"", Boolean.TRUE, null}));

		// AnswerBox Controls
		RuntimeAnchoring anchoringHelper15 = new RuntimeAnchoring(designSize, runtimeSize, 142, 96, 16, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		AnswerBox tmpansRebook = (AnswerBox)factory.getControl(AnswerBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1014), new Integer(anchoringHelper15.getX()), new Integer(anchoringHelper15.getY()), new Integer(anchoringHelper15.getWidth()), new Integer(anchoringHelper15.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "", Boolean.FALSE, Boolean.TRUE, new Integer(10), Boolean.FALSE});
		super.addControl(tmpansRebook);
		ansRebookAnswerBox ansRebook = (ansRebookAnswerBox)AnswerBoxBridgeFlyweightFactory.getInstance().createAnswerBoxBridge(ansRebookAnswerBox.class, tmpansRebook);
		super.addAnswerBox(ansRebook);
	}


	public Label lblNonMedicalReason()
	{
		return (Label)super.getControl(0);
	}
	public Label lblCanceleTCI()
	{
		return (Label)super.getControl(1);
	}
	public Label lblRebookingRequred()
	{
		return (Label)super.getControl(2);
	}
	public Label lblCancelTCI()
	{
		return (Label)super.getControl(3);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(7);
	}
	public Button btnOK()
	{
		return (Button)super.getControl(8);
	}
	public TextBox txtComment()
	{
		return (TextBox)super.getControl(9);
	}
	public cmbCancellationReasonComboBox cmbCancellationReason()
	{
		return (cmbCancellationReasonComboBox)super.getComboBox(0);
	}
	public cmbCancellationTypeComboBox cmbCancellationType()
	{
		return (cmbCancellationTypeComboBox)super.getComboBox(1);
	}
	public CheckBox chkCancelledForNonMedicalReason()
	{
		return (CheckBox)super.getControl(12);
	}
	public CheckBox chkCancelTCI()
	{
		return (CheckBox)super.getControl(13);
	}
	public ansRebookAnswerBox ansRebook()
	{
		return (ansRebookAnswerBox)super.getAnswerBox(0);
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
			cxl_PatientCancelledReasons = new ims.framework.ContextVariable("PatientCancelledReasons", prefix + "_lv_Scheduling.CancelAppointmentDialog.__internal_x_context__PatientCancelledReasons_" + componentIdentifier + "");
			cxl_HospitalCancelledReasons = new ims.framework.ContextVariable("HospitalCancelledReasons", prefix + "_lv_Scheduling.CancelAppointmentDialog.__internal_x_context__HospitalCancelledReasons_" + componentIdentifier + "");
		}
		
		public boolean getPatientCancelledReasonsIsNotNull()
		{
			return !cxl_PatientCancelledReasons.getValueIsNull(context);
		}
		public ims.scheduling.vo.lookups.CancelAppointmentReasonCollection getPatientCancelledReasons()
		{
			return (ims.scheduling.vo.lookups.CancelAppointmentReasonCollection)cxl_PatientCancelledReasons.getValue(context);
		}
		public void setPatientCancelledReasons(ims.scheduling.vo.lookups.CancelAppointmentReasonCollection value)
		{
			cxl_PatientCancelledReasons.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_PatientCancelledReasons = null;
		public boolean getHospitalCancelledReasonsIsNotNull()
		{
			return !cxl_HospitalCancelledReasons.getValueIsNull(context);
		}
		public ims.scheduling.vo.lookups.CancelAppointmentReasonCollection getHospitalCancelledReasons()
		{
			return (ims.scheduling.vo.lookups.CancelAppointmentReasonCollection)cxl_HospitalCancelledReasons.getValue(context);
		}
		public void setHospitalCancelledReasons(ims.scheduling.vo.lookups.CancelAppointmentReasonCollection value)
		{
			cxl_HospitalCancelledReasons.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_HospitalCancelledReasons = null;
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
			IReportField[] fields = new IReportField[118];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-ID", "ID_Booking_Appointment");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-APPOINTMENTDATE", "AppointmentDate");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-APPTSTARTTIME", "ApptStartTime");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-APPTENDTIME", "ApptEndTime");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-APPTSTATUS", "ApptStatus");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-APPTSTATUSREAS", "ApptStatusReas");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-PRIORITY", "Priority");
			fields[78] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-ISCABBOOKING", "IsCABBooking");
			fields[79] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-REQUIRESREBOOK", "RequiresRebook");
			fields[80] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-EARLIESTOFFEREDDATE", "EarliestOfferedDate");
			fields[81] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-TRANSPORTTYPE", "TransportType");
			fields[82] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-ISTRANSPORTREQUIRED", "IsTransportRequired");
			fields[83] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-ISTRANSPORTBOOKED", "IsTransportBooked");
			fields[84] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-OUTCOME", "Outcome");
			fields[85] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-COMMENTS", "Comments");
			fields[86] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-ARRIVALTIME", "ArrivalTime");
			fields[87] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-SEENTIME", "SeenTime");
			fields[88] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-CARECONTEXT", "CareContext");
			fields[89] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-WASREVIEWED", "WasReviewed");
			fields[90] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-SEENBY", "SeenBy");
			fields[91] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-OUTCOMECOMMENTS", "OutcomeComments");
			fields[92] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-PATHWAYCLOCK", "PathwayClock");
			fields[93] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-CONSMEDIATYPE", "ConsMediaType");
			fields[94] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointment", "BO-1055100007-CATEGORY", "Category");
			fields[95] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-ID", "ID_Appointment_Status");
			fields[96] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-STATUS", "Status");
			fields[97] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-STATUSREASON", "StatusReason");
			fields[98] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-APPTDATE", "ApptDate");
			fields[99] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-APPTTIME", "ApptTime");
			fields[100] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-PASCLINIC", "PASClinic");
			fields[101] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-DOS", "DoS");
			fields[102] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-PRIORITY", "Priority");
			fields[103] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-CANCELLATIONREASON", "CancellationReason");
			fields[104] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-COMMENT", "Comment");
			fields[105] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-REBOOKSELECTED", "RebookSelected");
			fields[106] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-EARLIESTOFFEREDDATE", "EarliestOfferedDate");
			fields[107] = new ims.framework.ReportField(this.context, "_cv_Scheduling.ApptCancelStatus", "BO-1055100008-STATUSCHANGEDATETIME", "StatusChangeDateTime");
			fields[108] = new ims.framework.ReportField(this.context, "_cv_RefMan.CatsReferralStatus", "BO-1096100007-ID", "ID_CATSReferralStatus");
			fields[109] = new ims.framework.ReportField(this.context, "_cv_RefMan.CatsReferralStatus", "BO-1096100007-REFERRALSTATUS", "ReferralStatus");
			fields[110] = new ims.framework.ReportField(this.context, "_cv_RefMan.CatsReferralStatus", "BO-1096100007-AUTHORINGUSER", "AuthoringUser");
			fields[111] = new ims.framework.ReportField(this.context, "_cv_RefMan.CatsReferralStatus", "BO-1096100007-STATUSDATETIME", "StatusDateTime");
			fields[112] = new ims.framework.ReportField(this.context, "_cv_RefMan.CatsReferralStatus", "BO-1096100007-COMMENT", "Comment");
			fields[113] = new ims.framework.ReportField(this.context, "_cv_RefMan.CatsReferralStatus", "BO-1096100007-SECONDOPINIONCATEGORY", "SecondOpinionCategory");
			fields[114] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingActivity", "BO-1007100005-ID", "ID_Activity");
			fields[115] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingService", "BO-1003100032-ID", "ID_Service");
			fields[116] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingSession", "BO-1055100010-ID", "ID_Sch_Session");
			fields[117] = new ims.framework.ReportField(this.context, "_cv_Scheduling.BookingAppointmentRef", "BO-1055100007-ID", "ID_Booking_Appointment");
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
