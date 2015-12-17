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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.edischargelist;

import ims.clinical.forms.edischargelist.GenForm.GroupSearchByEnumeration;
import ims.clinical.forms.edischargelist.GenForm.GroupSearchDateIntervalEnumeration;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.DischargeDetailsVoCollection;
import ims.clinical.vo.DischargeReportDetailVo;
import ims.clinical.vo.EDischargeSearchCriteriaVo;
import ims.clinical.vo.lookups.TTORequired;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.helper.ResetPIDBarHelper;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ColumnSortOrderVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.HcpDisType;
import ims.framework.Control;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.SortMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.vo.interfaces.IMos;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;	
	
	//Define the values for date interval Search 
	private static final int DISCHARGE_DATE	= -1;
	private static final int COMPLETED_DATE	= -2;
	private static final int INITIATED_DAE	= -3;
	
	private static final int CONSULTANT_COLUMN		= 0;
	private static final int WARD_COLUMN			= 1;
	private static final int DISCHARGE_DATE_COLUMN	= 2;
	private static final int PATIENT_NAME_COLUMN	= 3;
	private static final int IDENTIFIER_COLUMN	    = 4;
	private static final int LETTER_STATUS_COLUMN	= 5;
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		
		open();
		
		if (form.getGlobalContext().getEDischargeSearchCriteriaIsNotNull())
			refreshSearchCriteria();
	}
	
	
	private void refreshSearchCriteria() 
	{
		EDischargeSearchCriteriaVo voCriteria = form.getGlobalContext().getEDischargeSearchCriteria();
		
		form.cmbWard().setValue(domain.getWard(voCriteria.getWard()));
		form.cmbStatus().setValue(voCriteria.getStatus());
		form.cmbSpecialty().setValue(voCriteria.getSpecialty());
		form.dteFrom().setValue(voCriteria.getFromDate());
		form.dteTo().setValue(voCriteria.getToDate());
		
		if (voCriteria.getCompletingIsNotNull() && voCriteria.getCompleting().equals(false)) //WDEV-15428
		{
			form.lblCompletingOrInitiating().setValue("Initiating HCP :");
			form.GroupSearchBy().setValue(GroupSearchByEnumeration.rdoInitiatingHCP);
		}
		
				
		if(voCriteria.getCompletingHCPIsNotNull())
		{
			form.ccCompletingHCP().initialize(MosType.MEDIC);
			form.lblCompletingOrInitiating().setValue("Completing HCP :");
			form.ccCompletingHCP().setValue((IMos)voCriteria.getCompletingHCP());
			form.GroupSearchBy().setValue(GroupSearchByEnumeration.rdoCompletingHCP);
		}
		if(voCriteria.getInitiatingHCPIsNotNull())
		{
			form.ccCompletingHCP().initialize(MosType.HCP);
			form.lblCompletingOrInitiating().setValue("Initiating HCP :");
			form.ccCompletingHCP().setValue((IMos)voCriteria.getInitiatingHCP());
			form.GroupSearchBy().setValue(GroupSearchByEnumeration.rdoInitiatingHCP);
		}
		
		form.ccResponsibleHCP().setValue((IMos)voCriteria.getResponsibleHCP());

		//wdev-8700
		form.cmbComplete().setValue(voCriteria.getClinicaDetailsComplete());
		form.cmbTTA().setValue(voCriteria.getTTA());
		form.chkNonCornish().setValue(voCriteria.getNonCornish());
		form.chkTTA().setValue(voCriteria.getTTAFeedBack());
		
		//WDEV-18634 
		form.cmbCurrentWard().setValue(domain.getWard(voCriteria.getCurrentWard()));
		form.chkExcludeDischarged().setValue(voCriteria.getExcludeDischarged());
		setSearchDateIntervalType(voCriteria.getSearchType());
		
		initializeDynamicGrid(form.GroupSearchBy().getValue());
		
		search();
	}

	private void initialize()
	{
		clearAll();
		clearSelectedPatient();
		initializeComponents();		
		populateWards();	
		
		form.GroupSearchDateInterval().setValue(GroupSearchDateIntervalEnumeration.rdoDischarge); // WDEV-18634 
		form.cmbTTA().removeRow(TTORequired.NOT_SPECIFIED);
	}
	
	private void populateWards() 
	{
		ILocation currentLocation = domain.getCurrentLocation();
		
		if (currentLocation == null)
			return;
		
		LocationLiteVoCollection wards = domain.listActiveWardsForHospitalLite((LocationRefVo) currentLocation);
		for (int i = 0; i < wards.size(); i++) 
		{
			form.cmbWard().newRow(wards.get(i), wards.get(i).getName());
			form.cmbCurrentWard().newRow(wards.get(i), wards.get(i).getName()); //WDEV-18634 - Add a new search criteria field called "Current Ward:" (combo with save ward objects as existing ward combo)
		}
	}
	private void initializeComponents() 
	{
		form.ccCompletingHCP().initialize(MosType.MEDIC);
		form.ccResponsibleHCP().initialize(MosType.HCP);
	}
	
	private boolean getUIErrors()
	{
		if (form.ccCompletingHCP().getValue() == null &&
				form.ccResponsibleHCP().getValue() == null &&
					form.cmbWard().getValue() == null &&
						form.cmbStatus().getValue() == null &&
							form.cmbSpecialty().getValue() == null &&
								form.dteFrom().getValue() == null &&
									form.dteTo().getValue() == null
									&& form.cmbComplete().getValue() == null
									&& form.cmbTTA().getValue() == null
									&& ! form.chkNonCornish().getValue()
									&& form.cmbCurrentWard().getValue() == null
									&& ! form.chkExcludeDischarged().getValue())
		{
			engine.showMessage("Please select some search criteria");
			return true;
		}
		
		if (form.dteFrom().getValue() == null &&
				form.dteTo().getValue() != null)
		{
			engine.showMessage("From Date cannot be empty");			
			return true;
		}
		if (form.dteFrom().getValue() != null &&
				form.dteTo().getValue() == null)
		{
			engine.showMessage("To Date cannot be empty");			
			return true;
		}		
		if (form.dteFrom().getValue() != null &&
				form.dteTo().getValue() != null &&
					form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
		{
			engine.showMessage("From Date cannot be greater than To Date");			
			return true;
		}
			
		return false;		
	}
	
	private void open() 
	{	
		form.GroupSearchBy().setValue(GroupSearchByEnumeration.rdoCompletingHCP);
		form.lblCompletingOrInitiating().setValue("Completing HCP :");
		initializeDynamicGrid(GroupSearchByEnumeration.rdoCompletingHCP);
	}
	@Override
	protected void onImbClearHcpClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().setEDischargeSearchCriteria(null);
		initialize();
		open();
	}
	
	private void setFooter(int size, long milisecondsDB, long milisecondsDisplay )
	{
		String suffix = size>1?"s":"";
		String footer = "(" + size + ") patient" + suffix + " records";
		String milisName = "";
		if(ims.configuration.gen.ConfigFlag.GEN.RELEASE_MODE.getValue() == false)
		{
			if(milisecondsDB == 0)
			{
				milisName = "";
			}
			else if(milisecondsDB < 1000)
			{
				milisName = " - returned in " + milisecondsDB + " milisecond" + suffix;
			}
			else
			{
				milisName = " - returned in " + new Float(milisecondsDB)/1000 + " second" + suffix;
			}
			if(milisecondsDisplay == 0)
			{
				milisName += "";
			}
			else if(milisecondsDisplay < 1000)
			{
				milisName += " - displayed in " + milisecondsDisplay + " milisecond" + suffix;
			}
			else
			{
				milisName += " - displayed in " + new Float(milisecondsDisplay)/1000 + " second" + suffix;
			}
		}
		
		form.dyngrdDischargeDetails().setFooterValue(footer + milisName);
	}
	
	private String createHtmlSpace(int nrOfSpaces)
	{
		String spaces = "";
		for (int i = 1; i < nrOfSpaces; i++) 
		{
			spaces += "&nbsp;";
		}
		
		return spaces;
	}
	
	@Override
	protected void onImbSearchHcpClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
		if (getUIErrors())
		{
			clearResults();
			return;
		}
		initializeDynamicGrid(form.GroupSearchBy().getValue());
		search();
	}
	
	private void search() 
	{
		clearResults();
				
		EDischargeSearchCriteriaVo voCriteria = populateSearchCriteria();
		
		DischargeDetailsVoCollection dischargeDetails = domain.searchByCriteria(voCriteria);
		
		//start WDEV-14703
		if (dischargeDetails == null || dischargeDetails.size() == 0)
		{
			engine.showMessage("No matching discharged patients found.");
			return;
		}
		//end
		
		populateDischargesGrid(dischargeDetails);
		
		if (voCriteria != null && voCriteria.getColumnSortOrder() != null)
		{
			setSortOrderForColumn(voCriteria.getColumnSortOrder().getColumnId(), voCriteria.getColumnSortOrder().getSortOrder());
		}
	}


	private void setSortOrderForColumn(Integer columnId, Integer sortOrderId)
	{
		SortOrder order;
		
		if (sortOrderId == 1) // 1 is ascending but for the form to work correct we need to reverse this
			order = SortOrder.DESCENDING;
		else
			order = SortOrder.ASCENDING;
		
		if (WARD_COLUMN == columnId)
		{
			form.getLocalContext().setSortOrderWard(order);
			sortColumn(WARD_COLUMN);
		}
		else if (DISCHARGE_DATE_COLUMN == columnId)
		{
			form.getLocalContext().setSortOrderDischargeDate(order);
			sortColumn(DISCHARGE_DATE_COLUMN);
		}
		else if (PATIENT_NAME_COLUMN == columnId)
		{
			form.getLocalContext().setSortOrderPatientName(order);
			sortColumn(PATIENT_NAME_COLUMN);
		}
		else if (IDENTIFIER_COLUMN == columnId)
		{
			form.getLocalContext().setSortOrderIdentifier(order);
			sortColumn(IDENTIFIER_COLUMN);
		}
		else if (LETTER_STATUS_COLUMN == columnId)
		{
			form.getLocalContext().setSortOrderLetterStatus(order);
			sortColumn(LETTER_STATUS_COLUMN);
		}
		
	}


	private EDischargeSearchCriteriaVo populateSearchCriteria()
	{
		EDischargeSearchCriteriaVo voCriteria;
		
		if (form.getGlobalContext().getEDischargeSearchCriteria() == null)
			voCriteria = new EDischargeSearchCriteriaVo();
		else
			voCriteria = (EDischargeSearchCriteriaVo) form.getGlobalContext().getEDischargeSearchCriteria().clone();
		
		voCriteria.setResponsibleHCP((HcpRefVo)form.ccResponsibleHCP().getValue());
		voCriteria.setWard(form.cmbWard().getValue());
		voCriteria.setStatus(form.cmbStatus().getValue());
		voCriteria.setSpecialty(form.cmbSpecialty().getValue());
		voCriteria.setFromDate(form.dteFrom().getValue());
		voCriteria.setToDate(form.dteTo().getValue());
				
		if (form.GroupSearchBy().getValue()  != null)
		{
			if (form.GroupSearchBy().getValue().equals(GroupSearchByEnumeration.rdoCompletingHCP) && form.ccCompletingHCP().getValue() == null)
			{
				voCriteria.setCompleting(true); //WDEV-15428
			}
			
			if (form.GroupSearchBy().getValue().equals(GroupSearchByEnumeration.rdoInitiatingHCP) && form.ccCompletingHCP().getValue() == null)
			{
				voCriteria.setCompleting(false); //WDEV-15428
			}
			
			if (form.GroupSearchBy().getValue().equals(GroupSearchByEnumeration.rdoCompletingHCP) &&
					form.ccCompletingHCP().getValue() != null)
			{
				voCriteria.setCompletingHCP((HcpRefVo)form.ccCompletingHCP().getValue());
				voCriteria.setInitiatingHCP(null);
			}
			if (form.GroupSearchBy().getValue().equals(GroupSearchByEnumeration.rdoInitiatingHCP) &&
					form.ccCompletingHCP().getValue() != null)
			{
				voCriteria.setCompletingHCP(null);
				voCriteria.setInitiatingHCP((HcpRefVo)form.ccCompletingHCP().getValue());
			}			
		}
		
		//wdev-8700
		voCriteria.setClinicaDetailsComplete(form.cmbComplete().getValue());
		voCriteria.setTTA(form.cmbTTA().getValue());
		voCriteria.setNonCornish(form.chkNonCornish().getValue());
		voCriteria.setTTAFeedBack(form.chkTTA().getValue());
		
		//WDEV-18634 
		voCriteria.setSearchType(getSearchDateIntervalType());
		voCriteria.setExcludeDischarged(form.chkExcludeDischarged().getValue());
		voCriteria.setCurrentWard(form.cmbCurrentWard().getValue());
		
		form.getGlobalContext().setEDischargeSearchCriteria(voCriteria);
		return voCriteria;
	}


	private void populateDischargesGrid(DischargeDetailsVoCollection dischargeDetails)
	{
		long startTimeDB = System.currentTimeMillis();				
		long endTimeDB = System.currentTimeMillis();		
		long startTimeDisplay = System.currentTimeMillis();
		
		if (dischargeDetails == null || dischargeDetails.size() == 0)
			return;

		for (int i = 0; i < dischargeDetails.size(); i++)
		{
			DynamicGridRow row = form.dyngrdDischargeDetails().getRows().newRow();
			if (dischargeDetails.get(i) != null && dischargeDetails.get(i).getCareContextIsNotNull())
			{
				DischargeReportDetailVo dischargeReportDetails = domain.getDischargeReportDetailsForCareContext(dischargeDetails.get(i).getCareContext());
				if (dischargeReportDetails != null)
				{
					if (dischargeReportDetails.getDateOfCompletionIsNotNull() && dischargeReportDetails.getCompletingHCPIsNotNull())
					{
						MedicLiteVo voMedicLite = new MedicLiteVo();
						voMedicLite.setID_Hcp(dischargeReportDetails.getCompletingHCP().getID_Hcp());

						DynamicGridCell consultantCell = row.getCells().newCell(getColumnByIdentifier(CONSULTANT_COLUMN), DynamicCellType.HTMLVIEW);
						String display = "<font color='blue'>Initiating HCP: </font><b>" + createHtmlSpace(6) + dischargeDetails.get(i).getInitiatingHCP().getIMosName() + "</b> on <b> " + (dischargeDetails.get(i).getSystemInformationIsNotNull() ? dischargeDetails.get(i).getSystemInformation().getCreationDateTime() : null) + "</b><br>" + "<font color='blue'>Completing HCP: </font>" + createHtmlSpace(2) + "<b>" + dischargeReportDetails.getCompletingHCP().getIMosName() + "</b>" + " on <b>" + dischargeReportDetails.getDateOfCompletion() + "</b><br>";
						consultantCell.setValue(display);
						consultantCell.setTooltip(display);

					}
					else
					{
						DynamicGridCell consultantCell = row.getCells().newCell(getColumnByIdentifier(CONSULTANT_COLUMN), DynamicCellType.HTMLVIEW);
						String display = "Initiating HCP: <b>" + createHtmlSpace(6) + dischargeDetails.get(i).getInitiatingHCP().getIMosName() + "</b> on <b> " + (dischargeDetails.get(i).getSystemInformationIsNotNull() ? dischargeDetails.get(i).getSystemInformation().getCreationDateTime() : null) + "</b><br>";
						consultantCell.setValue(display);
						consultantCell.setTooltip(display);
					}

				}
				else
				{
					DynamicGridCell consultantCell = row.getCells().newCell(getColumnByIdentifier(CONSULTANT_COLUMN), DynamicCellType.HTMLVIEW);
					String display = "Initiating HCP: <b>" + createHtmlSpace(6) + dischargeDetails.get(i).getInitiatingHCP().getIMosName() + "</b> on <b> " + (dischargeDetails.get(i).getSystemInformationIsNotNull() ? dischargeDetails.get(i).getSystemInformation().getCreationDateTime() : null) + "</b><br>";
					consultantCell.setValue(display);
					consultantCell.setTooltip(display);
				}
			}

			DynamicGridCell wardCell = row.getCells().newCell(getColumnByIdentifier(WARD_COLUMN), DynamicCellType.HTMLVIEW);
			wardCell.setValue(dischargeDetails.get(i).getDischargingWardIsNotNull() ? dischargeDetails.get(i).getDischargingWard().getIGenericItemInfoName() : null);
			//WDEV-14703
			wardCell.setTooltip(dischargeDetails.get(i).getDischargingWardIsNotNull() ? dischargeDetails.get(i).getDischargingWard().getIGenericItemInfoName() : "");

			DynamicGridCell dischargeDateCell = row.getCells().newCell(getColumnByIdentifier(DISCHARGE_DATE_COLUMN), DynamicCellType.HTMLVIEW);
			dischargeDateCell.setValue(dischargeDetails.get(i).getDateOfDischargeIsNotNull() ? (dischargeDetails.get(i).getDateOfDischarge().toString()) : "");
			dischargeDateCell.setTooltip(dischargeDetails.get(i).getDateOfDischargeIsNotNull() ? (dischargeDetails.get(i).getDateOfDischarge().toString()) : "");

			if (dischargeDetails.get(i).getCareContext() != null)
			{
				PatientShort patient = domain.getPatientByCareContext(dischargeDetails.get(i).getCareContext());
				dischargeDetails.get(i).setPatient(patient);
				
				if (patient != null)
				{
					DynamicGridCell patientNameCell = row.getCells().newCell(getColumnByIdentifier(PATIENT_NAME_COLUMN), DynamicCellType.HTMLVIEW);
					patientNameCell.setValue(patient.getNameIsNotNull() ? patient.getName().toString() : "");
					patientNameCell.setTooltip(patient.getNameIsNotNull() ? patient.getName().toString() : "");
					row.setIdentifier(patient);
					row.setValue(dischargeDetails.get(i));

					DynamicGridCell hospitalNoCell = row.getCells().newCell(getColumnByIdentifier(IDENTIFIER_COLUMN), DynamicCellType.HTMLVIEW);
					hospitalNoCell.setValue(patient.getHospnum() != null ? patient.getHospnum().getValue() : "");
					hospitalNoCell.setTooltip(patient.getHospnum() != null ? patient.getHospnum().getValue() : "");
				}
			}

			DynamicGridCell letterStatusCell = row.getCells().newCell(getColumnByIdentifier(LETTER_STATUS_COLUMN), DynamicCellType.HTMLVIEW);
			
			letterStatusCell.setValue(dischargeDetails.get(i).getDischargeLetterStatusIsNotNull() ? (dischargeDetails.get(i).getDischargeLetterStatus().getImage() != null ? 
					("<img src='" + dischargeDetails.get(i).getDischargeLetterStatus().getImage().getImagePath() + "'> ") : "") + 
					dischargeDetails.get(i).getDischargeLetterStatus().getIItemText() : "");
			
			letterStatusCell.setTextColor(dischargeDetails.get(i).getDischargeLetterStatusIsNotNull() ? dischargeDetails.get(i).getDischargeLetterStatus().getTextColor() : Color.Black);
			
			letterStatusCell.setTooltip(dischargeDetails.get(i).getDischargeLetterStatusIsNotNull() ? (dischargeDetails.get(i).getDischargeLetterStatus().getImage() != null ? 
					("<img src='" + dischargeDetails.get(i).getDischargeLetterStatus().getImage().getImagePath() + "'> ") : "") + 
					dischargeDetails.get(i).getDischargeLetterStatus().getIItemText() : "");
		}
		
		long endTimeDisplay = System.currentTimeMillis();
		
		setFooter(form.dyngrdDischargeDetails().getRows().size(), endTimeDB-startTimeDB, endTimeDisplay-startTimeDisplay);
	}

	private Integer getSearchDateIntervalType() 
	{
		GroupSearchDateIntervalEnumeration searchType = form.GroupSearchDateInterval().getValue();
		if (GroupSearchDateIntervalEnumeration.rdoDischarge.equals(searchType))
			return DISCHARGE_DATE;
		if (GroupSearchDateIntervalEnumeration.rdoCompleted.equals(searchType))
			return COMPLETED_DATE;
		if (GroupSearchDateIntervalEnumeration.rdoInitiatedDate.equals(searchType))
			return INITIATED_DAE;
		
		return null;
	}
	
	private void setSearchDateIntervalType(Integer searchType) 
	{
		switch (searchType)
		{
			case DISCHARGE_DATE:
				form.GroupSearchDateInterval().setValue(GroupSearchDateIntervalEnumeration.rdoDischarge);
				break;
			case COMPLETED_DATE:
				form.GroupSearchDateInterval().setValue(GroupSearchDateIntervalEnumeration.rdoCompleted);
				break;
			case INITIATED_DAE:
				form.GroupSearchDateInterval().setValue(GroupSearchDateIntervalEnumeration.rdoInitiatedDate);
				break;
		}
	}

	private DynamicGridColumn getColumnByIdentifier(int consultantColumn) 
	{
		return form.dyngrdDischargeDetails().getColumns().getByIdentifier(consultantColumn);
	}
	
	private void initializeDynamicGrid(GroupSearchByEnumeration searchBy)
	{
		form.dyngrdDischargeDetails().clear();
		form.dyngrdDischargeDetails().setSelectable(true);
		form.dyngrdDischargeDetails().setReadOnly(true);
		form.dyngrdDischargeDetails().setFooterMaxHeight(18);
		
		if (searchBy != null)
		{
			DynamicGridColumn consultantColumn = null;
			
			if (searchBy.equals(GroupSearchByEnumeration.rdoCompletingHCP))
			{
				consultantColumn = form.dyngrdDischargeDetails().getColumns().newColumn("Completing HCP", true);
			}
			else if (searchBy.equals(GroupSearchByEnumeration.rdoInitiatingHCP))
			{
				consultantColumn = form.dyngrdDischargeDetails().getColumns().newColumn("Initiating HCP", true);				
			}
			
			consultantColumn.setIdentifier(CONSULTANT_COLUMN);
			consultantColumn.setWidth(200);
		}

		DynamicGridColumn wardColumn = form.dyngrdDischargeDetails().getColumns().newColumn("Discharge Ward", true);
		wardColumn.setSortMode(SortMode.MANUAL);
		wardColumn.setIdentifier(WARD_COLUMN);
		wardColumn.setWidth(130);			
		
		DynamicGridColumn dischargeDateColumn = form.dyngrdDischargeDetails().getColumns().newColumn("Discharge Date", true);	//wdev-18920
		dischargeDateColumn.setSortMode(SortMode.MANUAL);
		dischargeDateColumn.setIdentifier(DISCHARGE_DATE_COLUMN);
		dischargeDateColumn.setWidth(103);	
		
		DynamicGridColumn patientColumn = form.dyngrdDischargeDetails().getColumns().newColumn("Patient Name", true);
		patientColumn.setSortMode(SortMode.MANUAL);
		patientColumn.setIdentifier(PATIENT_NAME_COLUMN);
		patientColumn.setWidth(150);			
		
		DynamicGridColumn identifierColumn = form.dyngrdDischargeDetails().getColumns().newColumn("Hospital No", true);
		identifierColumn.setSortMode(SortMode.MANUAL);
		identifierColumn.setIdentifier(IDENTIFIER_COLUMN);
		identifierColumn.setWidth(100);		
			
		DynamicGridColumn letterStatusColumn = form.dyngrdDischargeDetails().getColumns().newColumn("Letter Status", true);
		letterStatusColumn.setSortMode(SortMode.MANUAL);
		letterStatusColumn.setIdentifier(LETTER_STATUS_COLUMN);
		letterStatusColumn.setWidth(-1);		
	}
	
	@Override
	protected void onRadioButtonGroupSearchByValueChanged()
			throws PresentationLogicException 
	{		
				
		updateCompletingInitiating();		
	}


	private void updateCompletingInitiating()
	{
		if (form.GroupSearchBy().getValue().equals(GroupSearchByEnumeration.rdoCompletingHCP))
		{
			
			
			if (form.ccCompletingHCP().getValue() instanceof HcpLiteVo)
			{
				HcpLiteVo completing = (HcpLiteVo) form.ccCompletingHCP().getValue();
				if (!HcpDisType.MEDICAL.equals(completing.getHcpType()))
					form.ccCompletingHCP().clear();
			}
			else
			{
				form.ccCompletingHCP().clear();
			}
			form.ccCompletingHCP().initialize(MosType.MEDIC);
			form.lblCompletingOrInitiating().setValue("Completing HCP :");
			
		}
		else if (form.GroupSearchBy().getValue().equals(GroupSearchByEnumeration.rdoInitiatingHCP))
		{
			form.ccCompletingHCP().initialize(MosType.HCP);
			form.lblCompletingOrInitiating().setValue("Initiating HCP :");
			
		}
	}
	
	private void clearControls()
	{
		form.ccCompletingHCP().clear();
		form.ccResponsibleHCP().clear();
		form.cmbWard().setValue(null);
		form.cmbStatus().setValue(null);
		form.cmbSpecialty().setValue(null);
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.cmbComplete().setValue(null);
		form.cmbTTA().setValue(null);
		form.chkNonCornish().setValue(null);
		form.chkTTA().setValue(null);
		
		//WDEV-18634 
		form.cmbCurrentWard().setValue(null);
		form.chkExcludeDischarged().setValue(null);
		
		
		
	}
	
	private void clearResults()
	{
		form.dyngrdDischargeDetails().getRows().clear();
		form.dyngrdDischargeDetails().setFooterValue("(0) patients records"); //WDEV-14703
		form.getContextMenus().Clinical.getEDischargeListViewItem().setVisible(false);
	}
	
	private void clearAll()
	{
		clearControls();
		clearResults();
		form.getContextMenus().Clinical.getEDischargeListViewItem().setVisible(false);
	}
	@Override
	protected void onDyngrdDischargeDetailsRowSelectionChanged(
			DynamicGridRow row) 
	{		
		if (row != null &&
				row.getIdentifier() != null &&
					row.getIdentifier() instanceof PatientShort &&
						row.getValue() != null &&
							row.getValue() instanceof DischargeDetailsVo)
		{
			form.getGlobalContext().Core.setPatientShort((PatientShort) row.getIdentifier());
			
			CareContextRefVo careContextRefVo = ((DischargeDetailsVo) row.getValue()).getCareContextIsNotNull() ? ((DischargeDetailsVo) row.getValue()).getCareContext() : null;
			if (careContextRefVo != null)
			{
				CareContextShortVo careContextShortVo = domain.getCareContextShort(careContextRefVo);
				if (careContextShortVo != null)
				{
					form.getGlobalContext().Core.setCurrentCareContext(careContextShortVo);
					form.getContextMenus().Clinical.getEDischargeListViewItem().setVisible(true);
					resetPIDBarText(); //WDEV-14654
				}				
			}			
		}
		else
		{
			clearSelectedPatient();
		}
	}
	
	//WDEV-14654 
	private void resetPIDBarText()
	{
		if (form.getGlobalContext().Core.getPatientShort() == null)
			return;

		new ResetPIDBarHelper(engine, form.getGlobalContext().Core.getPatientShort() , domain.getPIDDiagnosisInfo(form.getGlobalContext().Core.getCurrentCareContext(), form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare()));
	}


	private void clearSelectedPatient()
	{
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setCurrentCareContext(null);
		form.getContextMenus().Clinical.getEDischargeListViewItem().setVisible(false);
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender)
			throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.ClinicalNamespace.EDischargeList.View:
			viewDischargeDetails();
				break;
			default:
				break;
		}	
		
	}
	private void viewDischargeDetails() 
	{
		engine.open(form.getForms().Clinical.EDischarge);		
	}


	@Override
	protected void onChkTTAValueChanged() throws PresentationLogicException
	{
		if (form.chkTTA().getValue())
			form.cmbTTA().setValue(TTORequired.REQUIRED);
	}


	@Override
	protected void onCmbTTAValueChanged() throws PresentationLogicException 
	{
		if (form.chkTTA().getValue()
			&&  ( (form.cmbTTA().getValue() != null	&& ! form.cmbTTA().getValue().equals(TTORequired.REQUIRED))
				|| form.cmbTTA().getValue() == null) )
			form.chkTTA().setValue(false);
	}


	@Override
	protected void onDyngrdDischargeDetailsColumnHeaderClicked(DynamicGridColumn column)
	{
		sortColumn((Integer) column.getIdentifier());
		
	}
	
	private void sortColumn(int dynamicGridColumnId)
	{
		DischargeDetailsVo temp = null;
		if (form.dyngrdDischargeDetails().getValue() instanceof DischargeDetailsVo)
			temp = (DischargeDetailsVo) form.dyngrdDischargeDetails().getValue();
		DischargeDetailsVoCollection values = new DischargeDetailsVoCollection();
		
		for (int i = 0 ; i < form.dyngrdDischargeDetails().getRows().size() ; i++)
			values.add((DischargeDetailsVo) form.dyngrdDischargeDetails().getRows().get(i).getValue());
		
		form.dyngrdDischargeDetails().getRows().clear();
		
		switch (dynamicGridColumnId)
		{
			case WARD_COLUMN:
				form.getLocalContext().setSortOrderWard(SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderWard()) ? SortOrder.DESCENDING : SortOrder.ASCENDING);
				values.sort(new WardComparator(form.getLocalContext().getSortOrderWard()));
				addColumnSortToSearchCriteriaGC(WARD_COLUMN, form.getLocalContext().getSortOrderWard());
			break;
			case DISCHARGE_DATE_COLUMN:
				form.getLocalContext().setSortOrderDischargeDate(SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderDischargeDate()) ? SortOrder.DESCENDING : SortOrder.ASCENDING);
				values.sort(new DischargeDateComparator(form.getLocalContext().getSortOrderDischargeDate()));
				addColumnSortToSearchCriteriaGC(DISCHARGE_DATE_COLUMN, form.getLocalContext().getSortOrderDischargeDate());
			break;
			case PATIENT_NAME_COLUMN:
				form.getLocalContext().setSortOrderPatientName(SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderPatientName()) ? SortOrder.DESCENDING : SortOrder.ASCENDING);
				values.sort(new PatientNameComparator(form.getLocalContext().getSortOrderPatientName()));
				addColumnSortToSearchCriteriaGC(PATIENT_NAME_COLUMN, form.getLocalContext().getSortOrderPatientName());
			break;
			case IDENTIFIER_COLUMN:
				form.getLocalContext().setSortOrderIdentifier(SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderIdentifier()) ? SortOrder.DESCENDING : SortOrder.ASCENDING);
				values.sort(new IdentifierComparator(form.getLocalContext().getSortOrderIdentifier()));
				addColumnSortToSearchCriteriaGC(IDENTIFIER_COLUMN, form.getLocalContext().getSortOrderIdentifier());
			break;
			case LETTER_STATUS_COLUMN:
				form.getLocalContext().setSortOrderLetterStatus(SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderLetterStatus()) ? SortOrder.DESCENDING : SortOrder.ASCENDING);
				values.sort(new LetterStatusComparator(form.getLocalContext().getSortOrderLetterStatus()));
				addColumnSortToSearchCriteriaGC(LETTER_STATUS_COLUMN, form.getLocalContext().getSortOrderLetterStatus());
			break;
			default:
			break;
		}
		
		populateDischargesGrid(values);
		form.dyngrdDischargeDetails().setValue(temp);
	}


	private void addColumnSortToSearchCriteriaGC(int identifierColumnId, SortOrder sortOrder)
	{
		if (form.getGlobalContext().getEDischargeSearchCriteria() == null)
			return;
		
		ColumnSortOrderVo columnSortOrder = new ColumnSortOrderVo();
		
		columnSortOrder.setColumnId(identifierColumnId);
		
		if (SortOrder.ASCENDING.equals(sortOrder))
			columnSortOrder.setSortOrder(1);
		else
			columnSortOrder.setSortOrder(-1);
		
		form.getGlobalContext().getEDischargeSearchCriteria().setColumnSortOrder(columnSortOrder);
		
	}
	
	public class WardComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public WardComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public WardComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof DischargeDetailsVo )
			{
				DischargeDetailsVo ps1 = (DischargeDetailsVo)ob1;
				rez1 = ps1.getDischargingWard() != null  ? ps1.getDischargingWard().getIGenericItemInfoName():null;
			}
			if(ob2 instanceof DischargeDetailsVo)
			{
				DischargeDetailsVo ps2 = (DischargeDetailsVo)ob2;
				rez2 = ps2.getDischargingWard() != null  ? ps2.getDischargingWard().getIGenericItemInfoName():null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class DischargeDateComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public DischargeDateComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public DischargeDateComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			DateTime rez1 = null;
			DateTime rez2 = null;
			
			if(ob1 instanceof DischargeDetailsVo )
			{
				DischargeDetailsVo ps1 = (DischargeDetailsVo)ob1;
				rez1 = ps1.getDateOfDischarge();
			}
			if(ob2 instanceof DischargeDetailsVo)
			{
				DischargeDetailsVo ps2 = (DischargeDetailsVo)ob2;
				rez2 = ps2.getDateOfDischarge();
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareTo(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class PatientNameComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public PatientNameComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public PatientNameComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof DischargeDetailsVo )
			{
				DischargeDetailsVo ps1 = (DischargeDetailsVo)ob1;
				rez1 = ps1.getPatient() != null && ps1.getPatient().getName() != null ? ps1.getPatient().getName().toString() : null;
			}
			if(ob2 instanceof DischargeDetailsVo)
			{
				DischargeDetailsVo ps2 = (DischargeDetailsVo)ob2;
				rez2 = ps2.getPatient() != null && ps2.getPatient().getName() != null ? ps2.getPatient().getName().toString() : null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class IdentifierComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public IdentifierComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public IdentifierComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof DischargeDetailsVo )
			{
				DischargeDetailsVo ps1 = (DischargeDetailsVo)ob1;
				rez1 = ps1.getPatient() != null && ps1.getPatient().getHospnum() != null ? ps1.getPatient().getHospnum().getValue() : null;
			}
			if(ob2 instanceof DischargeDetailsVo)
			{
				DischargeDetailsVo ps2 = (DischargeDetailsVo)ob2;
				rez2 = ps2.getPatient() != null && ps2.getPatient().getHospnum() != null ? ps2.getPatient().getHospnum().getValue() : null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class LetterStatusComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public LetterStatusComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public LetterStatusComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof DischargeDetailsVo )
			{
				DischargeDetailsVo ps1 = (DischargeDetailsVo)ob1;
				rez1 = ps1.getDischargeLetterStatus() != null ? ps1.getDischargeLetterStatus().getIItemText() : null;
			}
			if(ob2 instanceof DischargeDetailsVo)
			{
				DischargeDetailsVo ps2 = (DischargeDetailsVo)ob2;
				rez2 = ps2.getDischargeLetterStatus() != null ? ps2.getDischargeLetterStatus().getIItemText() : null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
}
