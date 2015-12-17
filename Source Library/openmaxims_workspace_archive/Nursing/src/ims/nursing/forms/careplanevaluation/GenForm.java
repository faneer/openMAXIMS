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

package ims.nursing.forms.careplanevaluation;

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
	public static class cmbCarePlanStatusComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.nursing.vo.lookups.CarePlanStatus value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.nursing.vo.lookups.CarePlanStatus value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.nursing.vo.lookups.CarePlanStatus value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.nursing.vo.lookups.CarePlanStatus value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.nursing.vo.lookups.CarePlanStatus value)
		{
			return super.control.removeRow(value);
		}
		public ims.nursing.vo.lookups.CarePlanStatus getValue()
		{
			return (ims.nursing.vo.lookups.CarePlanStatus)super.control.getValue();
		}
		public void setValue(ims.nursing.vo.lookups.CarePlanStatus value)
		{
			super.control.setValue(value);
		}
	}
	public static class qmbConfirmedByComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.core.vo.Hcp value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.core.vo.Hcp value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.core.vo.Hcp value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.core.vo.Hcp value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.core.vo.Hcp value)
		{
			return super.control.removeRow(value);
		}
		public ims.core.vo.Hcp getValue()
		{
			return (ims.core.vo.Hcp)super.control.getValue();
		}
		public void setValue(ims.core.vo.Hcp value)
		{
			super.control.setValue(value);
		}
		public void setEditedText(String text)
		{
			super.control.setEditedText(text);
		}
		public String getEditedText()
		{
			return super.control.getEditedText();
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(488, 344);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 23, 288, 132, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Confirmed Date/Time:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 23, 256, 85, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Confirmed By:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 23, 224, 102, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Care Plan Status:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 24, 120, 105, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Evaluation Notes:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 24, 88, 129, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Next Evaluation Date:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 24, 56, 86, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Evaluation By:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 24, 26, 130, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Authoring Date/Time:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 400, 312, 75, 23, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 13), ControlState.ENABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 312, 312, 75, 23, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1008), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 11), ControlState.ENABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Save", Boolean.TRUE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// TextBox Controls
		RuntimeAnchoring anchoringHelper10 = new RuntimeAnchoring(designSize, runtimeSize, 160, 56, 160, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1009), new Integer(anchoringHelper10.getX()), new Integer(anchoringHelper10.getY()), new Integer(anchoringHelper10.getWidth()), new Integer(anchoringHelper10.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.DISABLED, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.FALSE, new Integer(255), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));
		RuntimeAnchoring anchoringHelper11 = new RuntimeAnchoring(designSize, runtimeSize, 160, 120, 304, 96, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1010), new Integer(anchoringHelper11.getX()), new Integer(anchoringHelper11.getY()), new Integer(anchoringHelper11.getWidth()), new Integer(anchoringHelper11.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, new Integer(1000), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));

		// Date Controls
		RuntimeAnchoring anchoringHelper12 = new RuntimeAnchoring(designSize, runtimeSize, 160, 288, 104, 20, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(DateControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1011), new Integer(anchoringHelper12.getX()), new Integer(anchoringHelper12.getY()), new Integer(anchoringHelper12.getWidth()), new Integer(anchoringHelper12.getHeight()), new Integer(startTabIndex.intValue() + 8), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, null, Boolean.FALSE, null, Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper13 = new RuntimeAnchoring(designSize, runtimeSize, 160, 88, 104, 20, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(DateControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1012), new Integer(anchoringHelper13.getX()), new Integer(anchoringHelper13.getY()), new Integer(anchoringHelper13.getWidth()), new Integer(anchoringHelper13.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, null, Boolean.FALSE, null, Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper14 = new RuntimeAnchoring(designSize, runtimeSize, 160, 24, 104, 20, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(DateControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1013), new Integer(anchoringHelper14.getX()), new Integer(anchoringHelper14.getY()), new Integer(anchoringHelper14.getWidth()), new Integer(anchoringHelper14.getHeight()), new Integer(-1), ControlState.DISABLED, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, null, Boolean.FALSE, null, Boolean.TRUE, null}));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper15 = new RuntimeAnchoring(designSize, runtimeSize, 160, 222, 168, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_cmbCarePlanStatusTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1014), new Integer(anchoringHelper15.getX()), new Integer(anchoringHelper15.getY()), new Integer(anchoringHelper15.getWidth()), new Integer(anchoringHelper15.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,Boolean.TRUE, Boolean.TRUE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.TRUE, new Integer(-1)});
		addControl(m_cmbCarePlanStatusTemp);
		cmbCarePlanStatusComboBox cmbCarePlanStatus = (cmbCarePlanStatusComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbCarePlanStatusComboBox.class, m_cmbCarePlanStatusTemp);
		super.addComboBox(cmbCarePlanStatus);

		// Query ComboBox Controls
		RuntimeAnchoring anchoringHelper16 = new RuntimeAnchoring(designSize, runtimeSize, 160, 256, 168, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		ComboBox m_qmbConfirmedByTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1015), new Integer(anchoringHelper16.getX()), new Integer(anchoringHelper16.getY()), new Integer(anchoringHelper16.getWidth()), new Integer(anchoringHelper16.getHeight()), new Integer(startTabIndex.intValue() + 7), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, Boolean.TRUE, SortOrder.NONE, Boolean.TRUE, new Integer(1), null, Boolean.FALSE, new Integer(-1), Boolean.FALSE});
		addControl(m_qmbConfirmedByTemp);
		qmbConfirmedByComboBox qmbConfirmedBy = (qmbConfirmedByComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(qmbConfirmedByComboBox.class, m_qmbConfirmedByTemp);
		super.addComboBox(qmbConfirmedBy);

		// CheckBox Controls
		RuntimeAnchoring anchoringHelper17 = new RuntimeAnchoring(designSize, runtimeSize, 272, 88, 104, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(CheckBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1016), new Integer(anchoringHelper17.getX()), new Integer(anchoringHelper17.getY()), new Integer(anchoringHelper17.getWidth()), new Integer(anchoringHelper17.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,"Care as planned", Boolean.TRUE, null}));

		// Time Controls
		RuntimeAnchoring anchoringHelper18 = new RuntimeAnchoring(designSize, runtimeSize, 272, 288, 48, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(TimeControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1017), new Integer(anchoringHelper18.getX()), new Integer(anchoringHelper18.getY()), new Integer(anchoringHelper18.getWidth()), new Integer(anchoringHelper18.getHeight()), new Integer(startTabIndex.intValue() + 9), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, Boolean.FALSE, null, Boolean.FALSE, ""}));
		RuntimeAnchoring anchoringHelper19 = new RuntimeAnchoring(designSize, runtimeSize, 272, 24, 48, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(TimeControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1018), new Integer(anchoringHelper19.getX()), new Integer(anchoringHelper19.getY()), new Integer(anchoringHelper19.getWidth()), new Integer(anchoringHelper19.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.DISABLED, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, Boolean.FALSE, null, Boolean.TRUE, ""}));
	}


	public Label labelConfirmedDateTime()
	{
		return (Label)super.getControl(0);
	}
	public Label labelConfirmedBy()
	{
		return (Label)super.getControl(1);
	}
	public Button bCancel()
	{
		return (Button)super.getControl(7);
	}
	public Button bSave()
	{
		return (Button)super.getControl(8);
	}
	public TextBox textEvaluatedBy()
	{
		return (TextBox)super.getControl(9);
	}
	public TextBox textEvaluationNotes()
	{
		return (TextBox)super.getControl(10);
	}
	public DateControl dateConfirmed()
	{
		return (DateControl)super.getControl(11);
	}
	public DateControl dateNextEvaluation()
	{
		return (DateControl)super.getControl(12);
	}
	public DateControl dDate()
	{
		return (DateControl)super.getControl(13);
	}
	public cmbCarePlanStatusComboBox cmbCarePlanStatus()
	{
		return (cmbCarePlanStatusComboBox)super.getComboBox(0);
	}
	public qmbConfirmedByComboBox qmbConfirmedBy()
	{
		return (qmbConfirmedByComboBox)super.getComboBox(1);
	}
	public CheckBox chkCareAsPlanned()
	{
		return (CheckBox)super.getControl(16);
	}
	public TimeControl timeConfirmed()
	{
		return (TimeControl)super.getControl(17);
	}
	public TimeControl tTime()
	{
		return (TimeControl)super.getControl(18);
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
			cxl_Evaluation = new ims.framework.ContextVariable("Evaluation", prefix + "_lv_Nursing.CarePlanEvaluation.__internal_x_context__Evaluation_" + componentIdentifier + "");
			cxl_ConfirmForStudentNurse = new ims.framework.ContextVariable("ConfirmForStudentNurse", prefix + "_lv_Nursing.CarePlanEvaluation.__internal_x_context__ConfirmForStudentNurse_" + componentIdentifier + "");
			cxl_RecordEvaluationTime = new ims.framework.ContextVariable("RecordEvaluationTime", prefix + "_lv_Nursing.CarePlanEvaluation.__internal_x_context__RecordEvaluationTime_" + componentIdentifier + "");
		}
		
		public boolean getEvaluationIsNotNull()
		{
			return !cxl_Evaluation.getValueIsNull(context);
		}
		public ims.nursing.vo.CarePlanEvaluationNote getEvaluation()
		{
			return (ims.nursing.vo.CarePlanEvaluationNote)cxl_Evaluation.getValue(context);
		}
		public void setEvaluation(ims.nursing.vo.CarePlanEvaluationNote value)
		{
			cxl_Evaluation.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_Evaluation = null;
		public boolean getConfirmForStudentNurseIsNotNull()
		{
			return !cxl_ConfirmForStudentNurse.getValueIsNull(context);
		}
		public Boolean getConfirmForStudentNurse()
		{
			return (Boolean)cxl_ConfirmForStudentNurse.getValue(context);
		}
		public void setConfirmForStudentNurse(Boolean value)
		{
			cxl_ConfirmForStudentNurse.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_ConfirmForStudentNurse = null;
		public boolean getRecordEvaluationTimeIsNotNull()
		{
			return !cxl_RecordEvaluationTime.getValueIsNull(context);
		}
		public Boolean getRecordEvaluationTime()
		{
			return (Boolean)cxl_RecordEvaluationTime.getValue(context);
		}
		public void setRecordEvaluationTime(Boolean value)
		{
			cxl_RecordEvaluationTime.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_RecordEvaluationTime = null;
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
			IReportField[] fields = new IReportField[90];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-ID", "ID_CarePlan");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-TITLE", "Title");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-OBJECTIVE", "Objective");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-NEXTEVALUATIONDATE", "NextEvaluationDate");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-LASTREVIEWEDDATE", "LastReviewedDate");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-LASTREVIEWEDBY", "LastReviewedBy");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-CONFIRMEDBY", "ConfirmedBy");
			fields[78] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-CONFIRMEDDATETIME", "ConfirmedDateTime");
			fields[79] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-CLINICALCONTACT", "ClinicalContact");
			fields[80] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlan", "BO-1010100003-CARECONTEXT", "CareContext");
			fields[81] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-ID", "ID_CarePlanEvaluationNote");
			fields[82] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-RECORDEDDATETIME", "RecordedDateTime");
			fields[83] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-NOTE", "Note");
			fields[84] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-CORRECTIONDATETIME", "CorrectionDateTime");
			fields[85] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-CORRECTIONREASON", "CorrectionReason");
			fields[86] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-ACTIVE", "Active");
			fields[87] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-CONFIRMEDBY", "ConfirmedBy");
			fields[88] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-CONFIRMEDDATETIME", "ConfirmedDateTime");
			fields[89] = new ims.framework.ReportField(this.context, "_cv_COE.CarePlanEvaluation", "BO-1010100004-CAREPLAN", "CarePlan");
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
