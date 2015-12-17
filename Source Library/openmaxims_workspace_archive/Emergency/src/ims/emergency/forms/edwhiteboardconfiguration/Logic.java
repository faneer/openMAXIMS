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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4910.25978)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.edwhiteboardconfiguration;

import ims.admin.vo.AppImageVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.forms.edwhiteboardconfiguration.GenForm.grdAssessmentsRow;
import ims.emergency.forms.edwhiteboardconfiguration.GenForm.grdConfigurableQuestionsRow;
import ims.emergency.forms.edwhiteboardconfiguration.GenForm.grdFixedQuestionsRow;
import ims.emergency.vo.TrackingAreaLiteVoCollection;
import ims.emergency.vo.WhiteBoardAssessmentConfigVo;
import ims.emergency.vo.WhiteBoardAssessmentConfigVoCollection;
import ims.emergency.vo.WhiteBoardConfigVo;
import ims.emergency.vo.WhiteBoardQuestionConfigVo;
import ims.emergency.vo.WhiteBoardQuestionConfigVoCollection;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridCellTable;
import ims.framework.controls.DynamicGridCellTable.TableCell;
import ims.framework.controls.DynamicGridCellTable.TableCellOptions;
import ims.framework.controls.DynamicGridCellTable.TableCellType;
import ims.framework.controls.DynamicGridCellTable.TableRow;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.enumerations.Align;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FontFamily;
import ims.framework.enumerations.FontStyle;
import ims.framework.enumerations.FontWeight;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Color;
import ims.framework.utils.Image;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final String	COLUMN_PATIENT_BUTTON				= "0";
	
	
	private static final String	ROW_MEDS_GIVEN		= "Meds Given";
	private static final String	ROW_OBS_REQUIRED	= "Obs Required";
	private static final String	ROW_ECG				= "ECG";
	private static final String	ROW_NPO				= "NPO";
	private static final String	ROW_ISOLATION		= "Isolation";
	

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	private void updateControlsState()
	{
		WhiteBoardConfigVo whiteboarConfig =form.cmbEDLocation().getValue()!=null &&  form.cmbArea().getValue() != null ? domain.getEDWhiteBoardConfigByLocation(form.cmbEDLocation().getValue(),form.cmbArea().getValue()) : null;
		
		form.btnNew().setVisible(FormMode.VIEW.equals(form.getMode()) && form.cmbArea().getValue() != null && whiteboarConfig == null);
		form.btnNew().setEnabled(FormMode.VIEW.equals(form.getMode()) && form.cmbArea().getValue() != null && whiteboarConfig == null);

		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && !form.btnNew().isVisible() && form.cmbArea().getValue() != null);
		form.btnEdit().setEnabled(FormMode.VIEW.equals(form.getMode()) && !form.btnNew().isVisible() && form.cmbArea().getValue() != null);
		
		form.btnPreview().setVisible(FormMode.VIEW.equals(form.getMode()) && form.cmbArea().getValue() != null && form.getLocalContext().getselectedWhiteBoardConfigIsNotNull());
		
		form.chkComments().setEnabled(FormMode.EDIT.equals(form.getMode()) && form.cmbArea().getValue() != null);
		
		form.getContextMenus().Emergency.hideAllEDWhiteboardConfig_AssessmentsGridMenuMenuItems();
		form.getContextMenus().Emergency.getEDWhiteboardConfig_AssessmentsGridMenuADDItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAssessments().getRows().size()<8);
		form.getContextMenus().Emergency.getEDWhiteboardConfig_AssessmentsGridMenuEDITItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAssessments().getValue()!=null);
		form.getContextMenus().Emergency.getEDWhiteboardConfig_AssessmentsGridMenuREMOVEItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAssessments().getValue()!=null);
		form.getContextMenus().Emergency.getEDWhiteboardConfig_AssessmentsGridMenuMOVE_DOWNItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAssessments().getValue()!=null && form.grdAssessments().canMoveCurrentDown());
		form.getContextMenus().Emergency.getEDWhiteboardConfig_AssessmentsGridMenuMOVE_UPItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAssessments().getValue()!=null && form.grdAssessments().canMoveCurrentUp());
		
		form.getContextMenus().Emergency.hideAllEDWhiteboardConfig_ConfigQuestGridMenuMenuItems();
		form.getContextMenus().Emergency.getEDWhiteboardConfig_ConfigQuestGridMenuADDItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdConfigurableQuestions().getRows().size()<8);
		form.getContextMenus().Emergency.getEDWhiteboardConfig_ConfigQuestGridMenuEDITItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdConfigurableQuestions().getValue()!=null);
		form.getContextMenus().Emergency.getEDWhiteboardConfig_ConfigQuestGridMenuREMOVEItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdConfigurableQuestions().getValue()!=null);
		form.getContextMenus().Emergency.getEDWhiteboardConfig_ConfigQuestGridMenuMOVE_DOWNItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdConfigurableQuestions().getValue()!=null && form.grdConfigurableQuestions().canMoveCurrentDown());
		form.getContextMenus().Emergency.getEDWhiteboardConfig_ConfigQuestGridMenuMOVE_UPItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdConfigurableQuestions().getValue()!=null && form.grdConfigurableQuestions().canMoveCurrentUp());
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		populateLocationCombo();
		ILocation currentLoc = engine.getCurrentLocation();
		if (currentLoc instanceof LocationLiteVo)
			form.cmbEDLocation().setValue((LocationLiteVo) currentLoc);
		
		populatePatientButton();
		initializeFixedQuestionsGrid();
		
		form.getLocalContext().setselectedWhiteBoardConfig(form.cmbEDLocation().getValue()!=null && form.cmbArea().getValue()!=null ? domain.getEDWhiteBoardConfigByLocation(form.cmbEDLocation().getValue(),form.cmbArea().getValue()) : null);
		
		open();
	}
	
	private void populatePatientButton()//WDEV-17131
	{
		form.dyngrdPatientButton().getRows().clear();
		form.dyngrdPatientButton().getColumns().clear();
		form.dyngrdPatientButton().setHeaderHeight(0);
		form.dyngrdPatientButton().setSelectable(false);
		
		DynamicGridColumn columnName = form.dyngrdPatientButton().getColumns().newColumn("Name", COLUMN_PATIENT_BUTTON);
		columnName.setWidth(400);
		columnName.setAlignment(Alignment.LEFT);
		columnName.setReadOnly(true);
		
		DynamicGridCell cellLabel = form.dyngrdPatientButton().getRows().newRow().getCells().newCell(getColumnPatientButton(COLUMN_PATIENT_BUTTON),DynamicCellType.TABLE);
		
		DynamicGridCellTable helper = new DynamicGridCellTable(cellLabel);	
				
		helper.setBorder(4);		
		
		TableRow  tableRow = helper.getRows().newRow();
			
		//Patient			
		TableCell tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);		
		TableCellOptions cellOptions = new TableCellOptions();		
						 cellOptions.setFontFamily(FontFamily.ARIAL);
						 cellOptions.setFontSize(16);
						 cellOptions.setFontWeight(FontWeight.BOLDER);
						 cellOptions.setAlign(Align.LEFT);
						 
		tableCell.setOptions(cellOptions);
		tableCell.setWidth(220);		
		tableCell.setColSpan(4);			
			
		tableCell.setValue("Surname");
		tableCell.setTooltip("Surname:Surname " );
		
		
		tableRow = helper.getRows().newRow();   //wdev-17138
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);		
		cellOptions = new TableCellOptions();		
						 cellOptions.setFontFamily(FontFamily.ARIAL);
						 cellOptions.setFontSize(16);
						 cellOptions.setFontWeight(FontWeight.BOLDER);
						 cellOptions.setAlign(Align.LEFT);
						
						 
		tableCell.setOptions(cellOptions);
		tableCell.setWidth(220);		
		tableCell.setColSpan(4);
		
		tableCell.setValue("Forename");
		tableCell.setTooltip("Forename: Forename" );
			
			
			
		//Hospital
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		cellOptions = new TableCellOptions();		
						 cellOptions.setTextColor(Color.Black);
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(13);
						 cellOptions.setAlign(Align.RIGHT);
		tableCell.setOptions(cellOptions);
		tableCell.setColSpan(2);
		tableCell.setValue("3289537E");
		tableCell.setTooltip("Hospital No.: 3289537E");
				
				
		//Triage priority
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setValue(form.getImages().Emergency.Triage_Priority_P1);
		tableCell.setWidth(18);		
	
		tableCell.setColSpan(2);
		
		//Temporary patient Image 
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setValue(form.getImages().Emergency.EvenHistoryEnabled16);
		
		tableCell.setTooltip("Temporary Patient");
		tableCell.setWidth(17);
		
		//--------------------------
		
		tableRow = helper.getRows().newRow();
		
		//Patient image
		 tableCell = tableRow.getCells().newCell();
					tableCell.setType(TableCellType.IMAGE);		
					tableCell.setRowSpan(3);
					tableCell.setValue(getPatientImage());
					tableCell.setWidth(50);

		//Gender
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setWidth(24);
		tableCell.setValue(form.getImages().Emergency.Male);
				
		
		//Presenting problem
		tableCell = tableRow.getCells().newCell();
		cellOptions = new TableCellOptions();		
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(13);
						 cellOptions.setFontStyle(FontStyle.ITALIC);
						 cellOptions.setFontWeight(FontWeight.BOLD);
						 
						 cellOptions.setAlign(Align.CENTER);					 
		tableCell.setType(TableCellType.STRING);
		tableCell.setOptions(cellOptions);
		
		tableCell.setValue("Presenting Problem");
		
		tableCell.setWidth(140);
		tableCell.setColSpan(3);
		

		//Path Image
			
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		
		tableCell.setValue(form.getImages().OCRR.Pathology48);
		tableCell.setWidth(24);	
		
		//DOB
		tableRow = helper.getRows().newRow();
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		cellOptions = new TableCellOptions();		
						 cellOptions.setTextColor(Color.Black);
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(11);
						 cellOptions.setFontWeight(FontWeight.BOLD);
						 cellOptions.setAlign(Align.LEFT);
		tableCell.setOptions(cellOptions);
		tableCell.setValue("DOB:");
		tableCell.setWidth(30);
		
		//dd/mm/yyy
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		cellOptions = new TableCellOptions();		
						 cellOptions.setTextColor(Color.Black);
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(11);					
						 cellOptions.setAlign(Align.LEFT);
		tableCell.setOptions(cellOptions);
		tableCell.setWidth(105);
		
		tableCell.setValue("11/11/1970 (43) ");
		tableCell.setTooltip("Age at Attendance : 43");
	
		//Time since
		tableCell = tableRow.getCells().newCell();
		cellOptions = new TableCellOptions();		
						 cellOptions.setTextColor(Color.Black);
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(12);
						 cellOptions.setFontWeight(FontWeight.BOLD);										 
						 cellOptions.setAlign(Align.CENTER);
		tableCell.setType(TableCellType.STRING);
		tableCell.setOptions(cellOptions);

		tableCell.setValue("115m");
		tableCell.setTooltip("115m since Triage");
		
		tableCell.setWidth(50);
		
		
		
		//LOS
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		cellOptions = new TableCellOptions();		
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(11);
						 cellOptions.setFontWeight(FontWeight.BOLD);
						 cellOptions.setAlign(Align.CENTER);
						 
		tableCell.setOptions(cellOptions);
		
		tableCell.setValue("135m");
		tableCell.setTooltip("135m since Registration");
		
		tableCell.setWidth(50);
		
		//Allergy
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setWidth(24);
		tableCell.setValue(form.getImages().Core.Allergies48);
		tableCell.setTooltip("The patient has allergies.");
		
		//Alert
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setWidth(24);
		tableCell.setValue(form.getImages().Core.Allergies18);
		tableCell.setTooltip("The patient has alerts." );
		
		
		// STatus
		tableRow = helper.getRows().newRow();  
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);		
		cellOptions = new TableCellOptions();		
						 cellOptions.setFontFamily(FontFamily.ARIAL);
						 cellOptions.setFontSize(10);
						 cellOptions.setFontWeight(FontWeight.BOLDER);
						 cellOptions.setAlign(Align.LEFT);
						
						 
		tableCell.setOptions(cellOptions);
		tableCell.setWidth(140);		
		tableCell.setColSpan(3);
		tableCell.setTooltip("Status: Waiting to be Triaged" );
		
		
		//Current Area
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);		
		cellOptions = new TableCellOptions();		
						 cellOptions.setFontFamily(FontFamily.ARIAL);
						 cellOptions.setFontSize(10);
						 cellOptions.setFontWeight(FontWeight.BOLDER);
						 cellOptions.setAlign(Align.LEFT);
						 //setAwaitingClinicianNameCellOptionsColors(cellOptions, LOS, isSkippedTriage);
						 
		tableCell.setOptions(cellOptions);
		tableCell.setWidth(100);		
		tableCell.setColSpan(4);
		
		tableCell.setTooltip("Current Area: Triage");
		
		
		cellLabel.setValue(helper);
		cellLabel.setReadOnly(true);
		
		
		
		return;

	}
	
	private AppImageVo getPatientImage()
	{
		AppImageVo imageVo = new AppImageVo();
		imageVo.setImagePath(form.getImages().Core.NoPatientImage.getImagePath());
			
		return imageVo;
		
	}
	
	private DynamicGridColumn getColumnPatientButton(String identifier) 
	{
		return form.dyngrdPatientButton().getColumns().getByIdentifier(identifier);
	}
	
	private void initializeFixedQuestionsGrid()
	{
		form.grdFixedQuestions().getRows().clear();
		
		grdFixedQuestionsRow row = form.grdFixedQuestions().getRows().newRow();
		row.setcolName(ROW_MEDS_GIVEN);
		row.setValue(ROW_MEDS_GIVEN);
		
		row = form.grdFixedQuestions().getRows().newRow();
		row.setcolName(ROW_OBS_REQUIRED);
		row.setValue(ROW_OBS_REQUIRED);
		
		row = form.grdFixedQuestions().getRows().newRow();
		row.setcolName(ROW_ECG);
		row.setValue(ROW_ECG);
		
		row = form.grdFixedQuestions().getRows().newRow();
		row.setcolName(ROW_NPO);
		row.setValue(ROW_NPO);
		
		row = form.grdFixedQuestions().getRows().newRow();
		row.setcolName(ROW_ISOLATION);
		row.setValue(ROW_ISOLATION);
	}
	private void open()
	{	
		populateInstanceFromData(form.getLocalContext().getselectedWhiteBoardConfig());
		form.setMode(FormMode.VIEW);
	}
	
	private void populateLocationCombo()
	{
		LocationLiteVoCollection collLocations = domain.listEDLocations();
		if (collLocations == null)
			return;

		for (int i = 0; i < collLocations.size(); i++)
		{
			form.cmbEDLocation().newRow(collLocations.get(i), collLocations.get(i).getName());
		}

	}
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getForms().Emergency.AddEditAssessmentsToWhiteboard.equals(formName) && DialogResult.OK.equals(result) && FormMode.EDIT.equals(form.getMode())) 
		{
			if (form.grdAssessments().getValue() != null)
			{
				updateRowToAssessmentsGrid(form.getGlobalContext().Emergency.getWhiteBoardAssessmentConfig());
			}
			else
			{
				addRowToAssessmentsGrid(form.getGlobalContext().Emergency.getWhiteBoardAssessmentConfig());
				form.grdAssessments().setValue(form.getGlobalContext().Emergency.getWhiteBoardAssessmentConfig());
			}
			
		}
		else if (form.getForms().Emergency.AddEditQuestionsToWhiteboard.equals(formName) && DialogResult.OK.equals(result) && FormMode.EDIT.equals(form.getMode())) 
		{
			if (form.grdConfigurableQuestions().getValue() != null)
			{
				updateRowToQuestionsGrid(form.getGlobalContext().Emergency.getWhiteBoardQuestionConfig());
			}
			else
			{
				addRowToQuestionsGrid(form.getGlobalContext().Emergency.getWhiteBoardQuestionConfig());
				form.grdConfigurableQuestions().setValue(form.getGlobalContext().Emergency.getWhiteBoardQuestionConfig());
			}
		}
		else if (form.getForms().Emergency. ImportWhiteboardConfig.equals(formName) && DialogResult.OK.equals(result)) 
		{
			populateInstanceFromData(form.getGlobalContext().Emergency.getWhiteBoardConfig());
			
		}
		
		updateControlsState();
	}
	private void addRowToQuestionsGrid(WhiteBoardQuestionConfigVo whiteBoardQuestionConfig)
	{
		if (whiteBoardQuestionConfig==null)
			return;
		
		grdConfigurableQuestionsRow row = form.grdConfigurableQuestions().getRows().newRow();
		
		row.setcolText(whiteBoardQuestionConfig.getQuestionText());
		row.setcolAnswerType(whiteBoardQuestionConfig.getAnswerType()!=null ? whiteBoardQuestionConfig.getAnswerType().toString(): null);
		row.setcolWidth(whiteBoardQuestionConfig.getColumnWidth()!=null ? whiteBoardQuestionConfig.getColumnWidth().toString(): null);
		row.setcolGenderSpecific(whiteBoardQuestionConfig.getGenderSpecific()!=null ? whiteBoardQuestionConfig.getGenderSpecific().toString(): null);
		row.setcolAgeRangeMin(whiteBoardQuestionConfig.getAgeRangeMin()!=null ? whiteBoardQuestionConfig.getAgeRangeMin().toString(): null);
		row.setcolAgeRangeMax(whiteBoardQuestionConfig.getAgeRangeMax()!=null ? whiteBoardQuestionConfig.getAgeRangeMax().toString() : null);
		
		row.setValue(whiteBoardQuestionConfig);
	}
	private void updateRowToQuestionsGrid(WhiteBoardQuestionConfigVo whiteBoardQuestionConfig)
	{
		grdConfigurableQuestionsRow row = form.grdConfigurableQuestions().getSelectedRow();
		 
		row.setcolText(whiteBoardQuestionConfig.getQuestionText());
		row.setcolAnswerType(whiteBoardQuestionConfig.getAnswerType()!=null ? whiteBoardQuestionConfig.getAnswerType().toString(): null);
		row.setcolWidth(whiteBoardQuestionConfig.getColumnWidth()!=null ? whiteBoardQuestionConfig.getColumnWidth().toString(): null);
		row.setcolGenderSpecific(whiteBoardQuestionConfig.getGenderSpecific()!=null ? whiteBoardQuestionConfig.getGenderSpecific().toString(): null);
		row.setcolAgeRangeMin(whiteBoardQuestionConfig.getAgeRangeMin()!=null ? whiteBoardQuestionConfig.getAgeRangeMin().toString(): null);
		row.setcolAgeRangeMax(whiteBoardQuestionConfig.getAgeRangeMax()!=null ? whiteBoardQuestionConfig.getAgeRangeMax().toString() : null);
		
		row.setValue(whiteBoardQuestionConfig);
		
	}
	
	private void addRowToAssessmentsGrid(WhiteBoardAssessmentConfigVo whiteBoardAssessmentConfig)
	{
		if (whiteBoardAssessmentConfig==null)
			return;
		
		grdAssessmentsRow row = form.grdAssessments().getRows().newRow();
		
		row.setcolName(whiteBoardAssessmentConfig.getName());
		row.setcolIcon(whiteBoardAssessmentConfig.getIcon()!=null ? engine.getRegisteredImage(whiteBoardAssessmentConfig.getIcon().getID_AppImage()) : null);
		row.setcolTaxonomy(whiteBoardAssessmentConfig.getMAXIMSMappingValue());
		
		row.setValue(whiteBoardAssessmentConfig);
	}
	
	private void updateRowToAssessmentsGrid(WhiteBoardAssessmentConfigVo whiteBoardAssessmentConfig)
	{
		grdAssessmentsRow row = form.grdAssessments().getSelectedRow();
		
		row.setcolName(whiteBoardAssessmentConfig.getName());
		row.setcolIcon((Image) whiteBoardAssessmentConfig.getIcon());
		row.setcolTaxonomy(whiteBoardAssessmentConfig.getMAXIMSMappingValue());
		
		row.setValue(whiteBoardAssessmentConfig);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	
	private boolean save()
	{
		WhiteBoardConfigVo whiteBoardConfigToSave=populateDataFromScreen(form.getLocalContext().getselectedWhiteBoardConfig());
		WhiteBoardConfigVo whiteBoardConfigExistent = domain.getEDWhiteBoardConfigByLocation(form.cmbEDLocation().getValue(),form.cmbArea().getValue());
		
		String[] errors = whiteBoardConfigToSave.validate();
		
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		// Condition to create only one WhiteBoardConfiguration Per Area
		if (whiteBoardConfigExistent != null && form.getLocalContext().getselectedWhiteBoardConfig() == null)
		{
			engine.showMessage("A WhiteBoard Configuration for the selected Area already exist. The screen will be refreshed");
			form.getLocalContext().setselectedWhiteBoardConfig(whiteBoardConfigExistent);
			open();
			return false;
		}
		
		try
		{
			form.getLocalContext().setselectedWhiteBoardConfig(domain.save(whiteBoardConfigToSave));
		}
		catch (StaleObjectException e)
		{
			
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setselectedWhiteBoardConfig(domain.getEDWhiteBoardConfigByLocation(form.cmbEDLocation().getValue(),form.cmbArea().getValue()));
			open();
			return false;
		}
		
		return true;
	}
	
	private WhiteBoardConfigVo populateDataFromScreen(WhiteBoardConfigVo whiteBoardConfigToSave)
	{
		if (whiteBoardConfigToSave==null)
			whiteBoardConfigToSave=new WhiteBoardConfigVo();
		else
			whiteBoardConfigToSave=(WhiteBoardConfigVo) whiteBoardConfigToSave.clone();
		
		whiteBoardConfigToSave.setEDLocation(form.cmbEDLocation().getValue());
		whiteBoardConfigToSave.setCurrentArea(form.cmbArea().getValue());
		whiteBoardConfigToSave.setAssessments(form.grdAssessments().getValues());
		
		whiteBoardConfigToSave.setMedsGiven(form.grdFixedQuestions().getRowByValue(ROW_MEDS_GIVEN).getcolSelect());
		whiteBoardConfigToSave.setObsTaken(form.grdFixedQuestions().getRowByValue(ROW_OBS_REQUIRED).getcolSelect());
		whiteBoardConfigToSave.setECG(form.grdFixedQuestions().getRowByValue(ROW_ECG).getcolSelect());
		whiteBoardConfigToSave.setNPO(form.grdFixedQuestions().getRowByValue(ROW_NPO).getcolSelect());
		whiteBoardConfigToSave.setIsolation(form.grdFixedQuestions().getRowByValue(ROW_ISOLATION).getcolSelect());
		
		whiteBoardConfigToSave.setOtherQuestions(form.grdConfigurableQuestions().getValues());
		whiteBoardConfigToSave.setComments(form.chkComments().getValue());
		whiteBoardConfigToSave.setIsActive(true);
		
		return whiteBoardConfigToSave;
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		//initializeFixedQuestionsGrid();
		
		engine.open(form.getForms().Emergency.ImportWhiteboardConfig);
	}
	@Override
	protected void onCmbEDLocationValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		populateAreaCombo(form.cmbEDLocation().getValue()!=null ? domain.getAreasByLocation(form.cmbEDLocation().getValue()) : null );
		updateControlsState();
	}
	
	@Override
	protected void onCmbAreaValueChanged() throws PresentationLogicException
	{
		form.getLocalContext().setselectedWhiteBoardConfig(form.cmbEDLocation().getValue()!=null && form.cmbArea().getValue()!=null ? domain.getEDWhiteBoardConfigByLocation(form.cmbEDLocation().getValue(),form.cmbArea().getValue()) : null);
		populateInstanceFromData(form.getLocalContext().getselectedWhiteBoardConfig());
		updateControlsState();
	}
	
	private void populateAreaCombo(TrackingAreaLiteVoCollection areaColl)
	{
		form.cmbArea().clear();
		if (areaColl==null || areaColl.size()==0)
			return;
		
		for (int i=0;i<areaColl.size();i++)
		{
			form.cmbArea().newRow(areaColl.get(i), areaColl.get(i).getAreaDisplayName());
		}
	}
	
	private void populateInstanceFromData(WhiteBoardConfigVo whiteBoardConfig)
	{
		clearInstanceControls();
		
		if (whiteBoardConfig==null)
			return;
		
		populateAssessmentsGrid(whiteBoardConfig.getAssessments());
		populateFixedQuestionsGrid(whiteBoardConfig);
		populateConfigurableQuestionsGrid(whiteBoardConfig.getOtherQuestions());
		form.chkComments().setValue(whiteBoardConfig.getComments());
		
	}
	private void populateConfigurableQuestionsGrid(WhiteBoardQuestionConfigVoCollection questions)
	{
		if (questions==null || questions.size()==0)
			return;
		
		for (int i=0;i<questions.size();i++)
		{
			addRowToQuestionsGrid(questions.get(i));
		}	
	}
	
	private void populateFixedQuestionsGrid(WhiteBoardConfigVo whiteBoardConfig)
	{
		form.grdFixedQuestions().getRowByValue(ROW_MEDS_GIVEN).setcolSelect(whiteBoardConfig.getMedsGiven());
		form.grdFixedQuestions().getRowByValue(ROW_OBS_REQUIRED).setcolSelect(whiteBoardConfig.getObsTaken());
		form.grdFixedQuestions().getRowByValue(ROW_ECG).setcolSelect(whiteBoardConfig.getECG());
		form.grdFixedQuestions().getRowByValue(ROW_NPO).setcolSelect(whiteBoardConfig.getNPO());
		form.grdFixedQuestions().getRowByValue(ROW_ISOLATION).setcolSelect(whiteBoardConfig.getIsolation());
	}
	private void clearInstanceControls()
	{
		form.grdAssessments().getRows().clear();
		clearFixedQuestionsGrid();
		form.grdConfigurableQuestions().getRows().clear();
		form.chkComments().setValue(null);
		
	}
	private void clearFixedQuestionsGrid()
	{
		for (int i=0;i<form.grdFixedQuestions().getRows().size();i++)
		{
			form.grdFixedQuestions().getRows().get(i).setcolSelect(false);
		}
	}
	private void populateAssessmentsGrid(WhiteBoardAssessmentConfigVoCollection assessments)
	{
		if (assessments==null || assessments.size()==0)
			return;
		
		for (int i=0;i<assessments.size();i++)
		{
			addRowToAssessmentsGrid(assessments.get(i));
		}
		
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_AssessmentsGridMenu.ADD:
				form.grdAssessments().setValue(null);
				form.getGlobalContext().Emergency.setWhiteBoardAssessmentConfig(null);	
				engine.open(form.getForms().Emergency.AddEditAssessmentsToWhiteboard);
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_AssessmentsGridMenu.EDIT:
				form.getGlobalContext().Emergency.setWhiteBoardAssessmentConfig(form.grdAssessments().getValue());
				engine.open(form.getForms().Emergency.AddEditAssessmentsToWhiteboard);
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_AssessmentsGridMenu.REMOVE:
				form.grdAssessments().removeSelectedRow();
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_AssessmentsGridMenu.MOVE_UP:
				form.grdAssessments().moveUp();
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_AssessmentsGridMenu.MOVE_DOWN:
				form.grdAssessments().moveDown();
			break;
			
			//Configurable Questions Grid Menu
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_ConfigQuestGridMenu.ADD:
				form.grdConfigurableQuestions().setValue(null);
				form.getGlobalContext().Emergency.setWhiteBoardQuestionConfig(null);	
				engine.open(form.getForms().Emergency.AddEditQuestionsToWhiteboard);
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_ConfigQuestGridMenu.EDIT:
				form.getGlobalContext().Emergency.setWhiteBoardQuestionConfig(form.grdConfigurableQuestions().getValue());	
				engine.open(form.getForms().Emergency.AddEditQuestionsToWhiteboard);
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_ConfigQuestGridMenu.REMOVE:
				form.grdConfigurableQuestions().removeSelectedRow();
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_ConfigQuestGridMenu.MOVE_UP:
				form.grdConfigurableQuestions().moveUp();
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDWhiteboardConfig_ConfigQuestGridMenu.MOVE_DOWN:
				form.grdConfigurableQuestions().moveDown();
			break;
			
		}
		
		updateControlsState();
			
	}
	@Override
	protected void onGrdConfigurableQuestionsSelectionChanged() throws PresentationLogicException
	{
		updateControlsState();
	}
	@Override
	protected void onGrdAssessmentsSelectionChanged() throws PresentationLogicException
	{
		updateControlsState();
	}
	@Override
	protected void onBtnPreviewClick() throws PresentationLogicException
	{
		form.getGlobalContext().Emergency.setWhiteBoardConfig(form.getLocalContext().getselectedWhiteBoardConfig());
		engine.open(form.getForms().Emergency.EDWhiteBoardPreviewDialog);
	}
	
}
