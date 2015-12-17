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

package ims.ocrr.forms.phlebotomycollect;

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
	public static class cmbRoundComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.ocrr.vo.PhlebotomyRoundShortVo value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.ocrr.vo.PhlebotomyRoundShortVo value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.ocrr.vo.PhlebotomyRoundShortVo value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.ocrr.vo.PhlebotomyRoundShortVo value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.ocrr.vo.PhlebotomyRoundShortVo value)
		{
			return super.control.removeRow(value);
		}
		public ims.ocrr.vo.PhlebotomyRoundShortVo getValue()
		{
			return (ims.ocrr.vo.PhlebotomyRoundShortVo)super.control.getValue();
		}
		public void setValue(ims.ocrr.vo.PhlebotomyRoundShortVo value)
		{
			super.control.setValue(value);
		}
	}

	public static class GroupFilterRadioButton extends RadioButtonBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected void setContext(Integer startTabIndex, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize)
		{
			if(startTabIndex == null)
				throw new RuntimeException("Invalid startTabIndex ");
			RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 616, 24, 136, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(0, anchoringHelper1.getX(), anchoringHelper1.getY(), anchoringHelper1.getWidth(), "Could not collect", startTabIndex.intValue() + 4);
			RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 512, 24, 88, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(1, anchoringHelper2.getX(), anchoringHelper2.getY(), anchoringHelper2.getWidth(), "Collected", startTabIndex.intValue() + 3);
			RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 392, 24, 88, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(2, anchoringHelper3.getX(), anchoringHelper3.getY(), anchoringHelper3.getWidth(), "For collection", startTabIndex.intValue() + 2);
			RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 320, 24, 48, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(3, anchoringHelper4.getX(), anchoringHelper4.getY(), anchoringHelper4.getWidth(), "All", startTabIndex.intValue() + 1);
		}
		public void setText(GroupFilterEnumeration option, String value)
		{
			if(option != null && option.id >= 0 && value != null)
				control.setText(option.id, value);
		}
		public GroupFilterEnumeration getValue()
		{
			switch (super.control.getValue())
			{
				case -1: return GroupFilterEnumeration.None;
				case 0: return GroupFilterEnumeration.rdoCouldNotCollect;
				case 1: return GroupFilterEnumeration.rdoCollected;
				case 2: return GroupFilterEnumeration.rdoForCollection;
				case 3: return GroupFilterEnumeration.rdoAll;
			}
			return null;
		}
		public void setValue(GroupFilterEnumeration value)
		{
			if(value != null)
				super.control.setValue(value.id);
			else
				super.control.setValue(GroupFilterEnumeration.None.id);
		}
		public boolean isEnabled(GroupFilterEnumeration option)
		{
			return super.control.isEnabled(option.id);
		}
		public void setEnabled(GroupFilterEnumeration option, boolean value)
		{
			super.control.setEnabled(option.id, value);
		}
		public boolean isVisible(GroupFilterEnumeration option)
		{
			return super.control.isVisible(option.id);
		}
		public void setVisible(GroupFilterEnumeration option, boolean value)
		{
			super.control.setVisible(option.id, value);
		}
		public void setVisible(boolean value)
		{
			super.control.setVisible(value);
		}
		public void setEnabled(boolean value)
		{
			super.control.setEnabled(value);
		}
	}
	public static class GroupFilterEnumeration implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public static GroupFilterEnumeration None = new GroupFilterEnumeration(-1);
		public static GroupFilterEnumeration rdoCouldNotCollect = new GroupFilterEnumeration(0);
		public static GroupFilterEnumeration rdoCollected = new GroupFilterEnumeration(1);
		public static GroupFilterEnumeration rdoForCollection = new GroupFilterEnumeration(2);
		public static GroupFilterEnumeration rdoAll = new GroupFilterEnumeration(3);
		private GroupFilterEnumeration(int id)
		{
			this.id = id;
		}
		public boolean equals(Object o)
		{
			return this.id == ((GroupFilterEnumeration)o).id;
		}
		private int id;
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.core.vo.PatientShort.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.PatientShort' of the global context variable 'Core.PatientShort' is not supported.");
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


		// Panel Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 832, 80, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		super.addControl(factory.getControl(Panel.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT,"Worklist", new Integer(2), ""}));

		// Label Controls
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 216, 48, 105, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Collection Round:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 16, 48, 35, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Date:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 8, 600, 88, 24, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 9), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Print", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Date Controls
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 56, 48, 152, 20, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(DateControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE, null, Boolean.TRUE, null, Boolean.FALSE, null}));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper10 = new RuntimeAnchoring(designSize, runtimeSize, 320, 48, 512, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		ComboBox m_cmbRoundTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper10.getX()), new Integer(anchoringHelper10.getY()), new Integer(anchoringHelper10.getWidth()), new Integer(anchoringHelper10.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT ,Boolean.TRUE, Boolean.TRUE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbRoundTemp);
		cmbRoundComboBox cmbRound = (cmbRoundComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbRoundComboBox.class, m_cmbRoundTemp);
		super.addComboBox(cmbRound);

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper11 = new RuntimeAnchoring(designSize, runtimeSize, 8, 96, 832, 496, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper11.getX()), new Integer(anchoringHelper11.getY()), new Integer(anchoringHelper11.getWidth()), new Integer(anchoringHelper11.getHeight()), new Integer(startTabIndex.intValue() + 7), ControlState.EDITABLE, ControlState.EDITABLE, ims.framework.enumerations.ControlAnchoring.ALL, null, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE}));

		// RadioButton Controls
		RadioButton tmpGroupFilter = (RadioButton)factory.getControl(RadioButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(0), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE});
		super.addControl(tmpGroupFilter);
		GroupFilterRadioButton GroupFilter = (GroupFilterRadioButton)RadioButtonBridgeFlyweightFactory.getInstance().createRadioButtonBridge(GroupFilterRadioButton.class, tmpGroupFilter);
		GroupFilter.setContext(startTabIndex, designSize, runtimeSize);
		super.addRadioButton(GroupFilter);
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public Button btnPrint()
	{
		return (Button)super.getControl(3);
	}
	public DateControl dteSearchDate()
	{
		return (DateControl)super.getControl(4);
	}
	public cmbRoundComboBox cmbRound()
	{
		return (cmbRoundComboBox)super.getComboBox(0);
	}
	public DynamicGrid dyngrdCollect()
	{
		return (DynamicGrid)super.getControl(6);
	}
	public GroupFilterRadioButton GroupFilter()
	{
		return (GroupFilterRadioButton)super.getRadioButton(0);
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
				PrintReport = new LocalFormName(102180);
				PrintMultipleOrders = new LocalFormName(102415);
			}
			public final FormName PrintReport;
			public final FormName PrintMultipleOrders;
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
			Admin = new AdminImages();
			OCRR = new OCRRImages();
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				ClearDisabled24 = new ImageHelper(102173, "Images/Core/ClearDisabled_24.png", new Integer(24), new Integer(24));
				ClearEnabled24 = new ImageHelper(102174, "Images/Core/ClearEnabled_24.png", new Integer(24), new Integer(24));
				FindDisabled24 = new ImageHelper(102172, "Images/Core/FindDisabled_24.png", new Integer(24), new Integer(24));
				FindEnabled24 = new ImageHelper(102175, "Images/Core/Find_24.png", new Integer(24), new Integer(24));
				Tick = new ImageHelper(102209, "Images/Core/tick.png", new Integer(16), new Integer(16));
				AnswerBox_No = new ImageHelper(102100, "Images/Core/answer_no.png", new Integer(10), new Integer(10));
				AnswerBox_Yes = new ImageHelper(102101, "Images/Core/answer_yes.png", new Integer(10), new Integer(10));
				AI = new ImageHelper(102264, "Images/Core/ai.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image ClearDisabled24;
			public final ims.framework.utils.Image ClearEnabled24;
			public final ims.framework.utils.Image FindDisabled24;
			public final ims.framework.utils.Image FindEnabled24;
			public final ims.framework.utils.Image Tick;
			public final ims.framework.utils.Image AnswerBox_No;
			public final ims.framework.utils.Image AnswerBox_Yes;
			public final ims.framework.utils.Image AI;
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				Location = new ImageHelper(103104, "Images/Admin/location.png", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image Location;
		}
		public final class OCRRImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private OCRRImages()
			{
				Patient = new ImageHelper(116140, "Images/OCRR/Patient.gif", new Integer(16), new Integer(16));
				TestTube = new ImageHelper(116118, "Images/OCRR/itesttube.gif", new Integer(19), new Integer(19));
				SaveGrid = new ImageHelper(116143, "Images/OCRR/saveSmall.gif", new Integer(14), new Integer(14));
			}
			public final ims.framework.utils.Image Patient;
			public final ims.framework.utils.Image TestTube;
			public final ims.framework.utils.Image SaveGrid;
		}
		public final CoreImages Core;
		public final AdminImages Admin;
		public final OCRRImages OCRR;
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
			cxl_SelectedRound = new ims.framework.ContextVariable("SelectedRound", prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedRound_" + componentIdentifier + "");
			cxl_SelectedPatient = new ims.framework.ContextVariable("SelectedPatient", prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier + "");
			cxl_ContextDummyForReportsLabel = new ims.framework.ContextVariable("ContextDummyForReportsLabel", prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier + "");
		}
		
		public boolean getSelectedRoundIsNotNull()
		{
			return !cxl_SelectedRound.getValueIsNull(context);
		}
		public ims.ocrr.vo.PhlebotomyRoundShortVo getSelectedRound()
		{
			return (ims.ocrr.vo.PhlebotomyRoundShortVo)cxl_SelectedRound.getValue(context);
		}
		public void setSelectedRound(ims.ocrr.vo.PhlebotomyRoundShortVo value)
		{
			cxl_SelectedRound.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedRound = null;
		public boolean getSelectedPatientIsNotNull()
		{
			return !cxl_SelectedPatient.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getSelectedPatient()
		{
			return (ims.core.vo.PatientShort)cxl_SelectedPatient.getValue(context);
		}
		public void setSelectedPatient(ims.core.vo.PatientShort value)
		{
			cxl_SelectedPatient.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedPatient = null;
		public boolean getContextDummyForReportsLabelIsNotNull()
		{
			return !cxl_ContextDummyForReportsLabel.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderSpecimenVo getContextDummyForReportsLabel()
		{
			return (ims.ocrr.vo.OrderSpecimenVo)cxl_ContextDummyForReportsLabel.getValue(context);
		}
		public void setContextDummyForReportsLabel(ims.ocrr.vo.OrderSpecimenVo value)
		{
			cxl_ContextDummyForReportsLabel.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_ContextDummyForReportsLabel = null;
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
			IReportField[] fields = new IReportField[99];
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
			fields[71] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedRound_" + componentIdentifier, "BO-1070100006-ID", "ID_PhlebotomyRound");
			fields[72] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedRound_" + componentIdentifier, "BO-1070100006-DATE", "Date");
			fields[73] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedRound_" + componentIdentifier, "BO-1070100006-ROUNDTOCOLLECT", "RoundToCollect");
			fields[74] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-ID", "ID_Patient");
			fields[75] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-SEX", "Sex");
			fields[76] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-DOB", "Dob");
			fields[77] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-DOD", "Dod");
			fields[78] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-RELIGION", "Religion");
			fields[79] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-ISACTIVE", "IsActive");
			fields[80] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[81] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[82] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-SCN", "SCN");
			fields[83] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[84] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[85] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[86] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__SelectedPatient_" + componentIdentifier, "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[87] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-ID", "ID_OrderSpecimen");
			fields[88] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-COLLDATETIMEPLACER", "CollDateTimePlacer");
			fields[89] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-COLLECTINGMOS", "CollectingMos");
			fields[90] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-ISPATIENTCOLLECT", "IsPatientCollect");
			fields[91] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-ISAWAITINGCOLLECTION", "IsAwaitingCollection");
			fields[92] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-SPECIMENSOURCE", "SpecimenSource");
			fields[93] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-DISCIPLINE", "Discipline");
			fields[94] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-ORDER", "Order");
			fields[95] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-INSTRUCTIONSTOCOLLECTOR", "InstructionsToCollector");
			fields[96] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-COLLECTORCOMMENT", "CollectorComment");
			fields[97] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-SITECD", "SiteCd");
			fields[98] = new ims.framework.ReportField(this.context, prefix + "_lv_OCRR.PhlebotomyCollect.__internal_x_context__ContextDummyForReportsLabel_" + componentIdentifier, "BO-1070100010-REQUESTEDTYPE", "RequestedType");
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
