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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.42 build 2221.27776)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.inpatientlist;

import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.pas.vo.InpatientEpisodeRefVo;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.vo.CurrentInpatientListFilterVo;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.InpatientEpisodeVoCollection;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.PatientFilter;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.PersonName;
import ims.core.vo.RCHTInpatientDischargeVo;
import ims.core.vo.lookups.DocumentStatus;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.MedicGrade;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.icp.vo.InpatientEpisodeWithICPInfoVo;

import java.util.Comparator;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		
		refreshSearchCriteria();
	}

	private void refreshSearchCriteria()
	{
		CurrentInpatientListFilterVo voFilter = form.getGlobalContext().STHK.getCurrentInpatientListFilter();
		if (voFilter != null)
		{
			//WDEV-15526
			form.cmbType().setValue(voFilter.getIDType());
			form.txtIdentifier().setValue(voFilter.getHospNum());
			form.txtSurname().setValue(voFilter.getSurname());
			form.txtForename().setValue(voFilter.getForename());
			
			form.cmbHospital().setValue(null);
			for(int i = 0 ; voFilter.getHospitalIsNotNull() && form.cmbHospital().getValues() != null&& i < form.cmbHospital().getValues().size() ; i++)
			{
				LocationLiteVo voHosp = (LocationLiteVo)form.cmbHospital().getValues().get(i);
				if (voHosp.getID_Location().equals(voFilter.getHospital().getID_Location()))
					form.cmbHospital().setValue((LocationLiteVo)form.cmbHospital().getValues().get(i));
			}
			if ( form.cmbHospital().getValue() == null && voFilter.getHospitalIsNotNull())
			{
				LocationLiteVo voHosp = domain.getHospital(voFilter.getHospital());
				form.cmbHospital().newRow(voHosp, voHosp.getName().toString());
				form.cmbHospital().setValue(voHosp);
			}
			hospitalValueChanged();

			form.qmbConsultants().clear();
			if ( form.qmbConsultants().getValue() == null && voFilter.getConsultantIsNotNull())
			{
				HcpLiteVo voHcp = domain.getHCP(voFilter.getConsultant().getID_Hcp());
				form.qmbConsultants().newRow(voHcp, voHcp.getMos().getName().toString());
				form.qmbConsultants().setValue(voHcp);
			}
			
			
			form.cmbWard().setValue(null);
			for(int i = 0 ; voFilter.getWardIsNotNull() && i < form.cmbWard().getValues().size() ; i++)
			{
				LocationLiteVo voWard = (LocationLiteVo)form.cmbWard().getValues().get(i);
				if (voWard.getID_Location().equals(voFilter.getWard().getID_Location()))
					form.cmbWard().setValue((LocationLiteVo)form.cmbWard().getValues().get(i));
			}
			if ( form.cmbWard().getValue() == null&& voFilter.getWardIsNotNull())
			{
				LocationLiteVo voWard = domain.getWard(voFilter.getWard());
				form.cmbWard().newRow(voWard, voWard.getName());
				form.cmbWard().setValue(voWard);
			}
			
			form.cmbSpecialty().setValue(voFilter.getSpecialty());
			
			form.cmbWard().setVisible(true);
			form.lblWard().setVisible(true);
			
			search();
		}
		
	}

	protected void onGrdWardsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{					
		form.getGlobalContext().Core.setPatientShort(null);
		

		if (ConfigFlag.UI.INPAT_CREATE_CORRESPONDENCE_DETAILS.getValue())
		{
			selectionChanged();
		}
		else if (engine.hasRight(AppRight.CAN_DISCHARGE_INPATIENT_IN_RCHT))
		{
			selectionChanged();
		}
		else if (ConfigFlag.UI.MAXIMS_ADT_NO_INTERFACE.getValue())
		{
			selectionChanged();
		}
		else
		{
			showDemographics();
		}

	}

	private void showDemographics() 
	{
		if (form.grdInpatients().getValue() != null &&
				form.grdInpatients().getValue().getPasEventIsNotNull() &&
					form.grdInpatients().getValue().getPasEvent().getPatientIsNotNull())
		{
			PatientShort ps = form.grdInpatients().getValue().getPasEvent().getPatient();		
			form.getGlobalContext().Core.setPatientToBeDisplayed(ps);
			setPatientFilterDetails();
			setPatientInfoBar(ps);		
			engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
		}				
	}

	private void selectionChanged()
	{
		setContextVariablesForSelection();
		setContextMenusState();
		if (form.isReadOnly())
			engine.showMessage("Read only form");
	}

	private void setContextMenusState() 
	{							
		DocumentStatus lkpStatus = null;
		
		lkpStatus = form.grdInpatients().getSelectedRowIndex() < 0 ? null : form.grdInpatients().getSelectedRow().getValue().getPasEvent().getCspDocumentStatus();
			
		boolean boolCanAddCSP = false;
		boolean boolCanViewCSP = false; 
		if (lkpStatus != null)
		{
			boolCanAddCSP = lkpStatus.equals(DocumentStatus.LETTERREQUIRED);
			boolCanViewCSP = lkpStatus.equals(DocumentStatus.GENNOTPRINTED) || lkpStatus.equals(DocumentStatus.PRINTEDNOSIGNATURE) || lkpStatus.equals(DocumentStatus.SIGNED);
			//boolCanPreviewLetter = lkpStatus.equals(DocumentStatus.GENNOTPRINTED) || lkpStatus.equals(DocumentStatus.PRINTEDNOSIGNATURE) || lkpStatus.equals(DocumentStatus.SIGNED);
			
			//TODO
			/*
			if (form.getLocalContext().getSelectedCorrespondenceInstanceIsNotNull())
				boolCanViewDocStatusHistory = form.getLocalContext().getSelectedCorrespondenceInstance().getCspStatusHistoryIsNotNull() ? true : false;
			else
				boolCanViewDocStatusHistory = false;
			*/
				
			//boolCanViewContacts = true;
			//boolCanSetLetterRequired = lkpStatus.equals(DocumentStatus.NOLETTERREQUIRED);
			//boolCanSetNOLetterRequired = lkpStatus.equals(DocumentStatus.LETTERREQUIRED);
		}
				
		enableAllContextMenus();
		form.getContextMenus().hideAllADTMenuMenuItems();
		form.getContextMenus().getADTMenuAddItem().setVisible(boolCanAddCSP);
		form.getContextMenus().getADTMenuViewItem().setVisible(boolCanViewCSP);
		form.getContextMenus().getADTMenuDemographicsItem().setVisible(form.grdInpatients().getValue() != null);//WDEV-15975
		
		form.getContextMenus().getADTMenuDischargeItem().setVisible(false);//wdev-15489
		if (engine.hasRight(AppRight.CAN_DISCHARGE_INPATIENT_IN_RCHT))
		{
			form.getContextMenus().getADTMenuDischargeItem().setVisible(form.grdInpatients().getValue() != null);// 	WDEV-15975
		}
		
		if (ConfigFlag.UI.MAXIMS_ADT_NO_INTERFACE.getValue())
		{
			if (form.grdInpatients().getSelectedRow() !=null
				&& form.grdInpatients().getSelectedRow().getValue() != null)
				form.getContextMenus().getADTMenuTransferItem().setVisible(true);

			if (form.grdInpatients().getSelectedRow() !=null
				&& form.grdInpatients().getSelectedRow().getValue() != null)
			{
				if(form.grdInpatients().getSelectedRow().getValue().getWardStays() == null
					|| (form.grdInpatients().getSelectedRow().getValue().getWardStaysIsNotNull()
						&& form.grdInpatients().getSelectedRow().getValue().getWardStays().size() == 0) // initialised but empty.
					|| (form.grdInpatients().getSelectedRow().getValue().getWardStaysIsNotNull()
						&& form.grdInpatients().getSelectedRow().getValue().getWardStays().size() == 1)	)
				{
					InpatientEpisodeVo voIP = domain.getInpatientEpisode(form.grdInpatients().getSelectedRow().getValue());
					if (voIP == null
						|| 
						(voIP != null
						&& voIP.getPasEventIsNotNull()
						&& voIP.getPasEvent().getLocationIsNotNull()
						&& form.grdInpatients().getSelectedRow().getValue() != null
						&& form.grdInpatients().getSelectedRow().getValue().getPasEvent() != null
						&&  ! voIP.getPasEvent().getLocation().equals(form.grdInpatients().getSelectedRow().getValue().getPasEvent().getLocation())))
					{
						engine.showMessage("This In-Patient record has already been updated by another user. The screen will be refreshed.");
						performSearch();
						return;
					}
					form.getContextMenus().getADTMenuCancelAdmissionItem().setVisible(true);
					
				}
			}
			if ( !engine.hasRight(AppRight.CAN_DISCHARGE_INPATIENT_IN_RCHT) && engine.hasRight(AppRight.MAXIMS_ADT_CAN_DISCHARGE))  //wdev-16427
			{
				form.getContextMenus().getADTMenuDischargeItem().setVisible(form.grdInpatients().getValue() != null);
			}
		}

	}
	
	private void enableAllContextMenus()
	{
		form.getContextMenus().getADTMenuAddItem().setVisible(true);
		form.getContextMenus().getADTMenuAddItem().setEnabled(true);
		form.getContextMenus().getADTMenuViewItem().setEnabled(true);
	}

	private void clearContextVariables()
	{
		form.getLocalContext().setSelectedCorrespondenceInstance(null);

		form.getGlobalContext().Correspondence.setCorrespondenceDetails(null);
		form.getGlobalContext().Correspondence.setDocDetailIdReportSeed(null);
		form.getGlobalContext().Correspondence.setGenerateFormMode(null);
		form.getGlobalContext().Core.setPasEvent(null);
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setPatientToBeDisplayed(null);//WDEV-16020
	}

	private void setContextVariablesForSelection() 
	{
		clearContextVariables();
		InpatientEpisodeVo voInpatientListRow = null;
		//PatientShort voPatientShort = null;
		//PasContactVo voPasContact = null;
		PASEventRefVo voRefPasEvent = null;

		if (form.grdInpatients().getSelectedRowIndex() >= 0 && form.grdInpatients().getRows().get(form.grdInpatients().getSelectedRowIndex()).getValue() != null) 					
		{
			voInpatientListRow = form.grdInpatients().getSelectedRow().getValue();
			//voPasContact = voInpatientListRow.getPasContact();
			//voPatientShort = voInpatientListRow.getPasEvent().getPatient();
			voRefPasEvent = voInpatientListRow.getPasEvent();
			
			form.getGlobalContext().Core.setPatientShort(voInpatientListRow.getPasEvent().getPatient());
		
			/*
			if (voRefPasEvent == null && voPasContact != null)
			{
				voRefPasEvent = getOrCreatePasEventForPasContact(voPasContact, voPatient, patientListType);			
	
				if (patientListType.equals(PatientListType.INPATIENTLIST))
				{
					voInpatientListRow.setPasContact(voPasContact);
					voInpatientListRow.setPasEvent(voRefPasEvent);
					form.grdInpatients().setValue(voInpatientListRow);					
				}
				else
				{
					voOutPatientListRow.setPasContact(voPasContact);
					voOutPatientListRow.setPasEvent(voRefPasEvent);
					form.lyrPatientLists().tabOutpatientList().grdOPList().setValue(voOutPatientListRow);
				}
	
				form.getGlobalContext().Core.setPasEvent(voRefPasEvent);			
	
			}
			else
			*/
			
			form.getGlobalContext().Core.setPasEvent(voRefPasEvent);
			//wdev-16427
			if( voRefPasEvent != null)
				form.getGlobalContext().Core.setCurrentCareContext(domain.getCareContextShortVoByPasEventId(voRefPasEvent));
			//----------
			form.getLocalContext().setSelectedCorrespondenceInstance(domain.getCorrespondenceDetailsByPasEvent(voRefPasEvent));
			form.getGlobalContext().Correspondence.setCorrespondenceDetails(form.getLocalContext().getSelectedCorrespondenceInstance());
	
		}
	}				
	

	private void setPatientFilterDetails()
	{		
		PatientFilter voPatFilter = new PatientFilter();		
		PatientShort patient = form.grdInpatients().getValue().getPasEvent().getPatient();		
		voPatFilter.setForename(patient.getNameIsNotNull() ? patient.getName().getForename() : null);
		voPatFilter.setSurname(patient.getNameIsNotNull() ? patient.getName().getSurname() : null);
		voPatFilter.setSex(patient.getSex());
		voPatFilter.setDob(patient.getDob());
		
		form.getGlobalContext().Core.setPatientFilter(voPatFilter);
	}
	
	private void setPatientInfoBar(PatientShort ps)
	{
		if (ps.getIsDead() != null && ps.getIsDead().booleanValue())
		{
			engine.setPatientInfo(ps.getPatientInfo(), ims.configuration.gen.ConfigFlag.UI.RIP_INFO_COLOUR.getValue());
		}
		else
		{
			engine.setPatientInfo(ps.getPatientInfo());
		}
	}

	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clear();

	}

	private void clear()
	{
		clearSearchCriteria();
		clearPatientList();
		
		form.getContextMenus().hideAllADTMenuMenuItems();
		form.getContextMenus().getADTMenuViewItem().setVisible(false);
		form.getContextMenus().getADTMenuDemographicsItem().setVisible(false);
	}

	private void setTotalLabel(int count)
	{
		form.lblTotal().setValue("Total : " + count);		
	}

	private void clearSearchCriteria()
	{
		//WDEV-15526
		form.cmbType().setValue(null);
		form.txtIdentifier().setValue(null);
		form.txtSurname().setValue(null);
		form.txtForename().setValue(null);
		
		form.cmbWard().setVisible(false);
		form.lblWard().setVisible(false);
		form.cmbHospital().setValue(null);
		form.cmbWard().clear();
		form.cmbWard().setValue(null);
		form.qmbConsultants().clear();
		form.cmbSpecialty().setValue(null);
		form.getGlobalContext().STHK.setCurrentInpatientListFilter(null);

	}

	protected void onCmbHospitalFilterValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		hospitalValueChanged();
	}

	private void hospitalValueChanged()
	{
		if (form.cmbHospital().getValue() == null)
		{
			form.lblWard().setVisible(false);
			form.cmbWard().setVisible(false);
		}
		else
		{
			form.lblWard().setVisible(true);
			form.cmbWard().setVisible(true);

			clearPatientList();

			populateWardCombo();
		}
	}

	private void populateHospitalListCombo()
	{
		LocationLiteVoCollection voLocColl = domain.listActiveHospitals();
		if (voLocColl != null)
		{
			int currentLocName;
			for (int i = 0; i < voLocColl.size(); i++)
			{
				LocationLiteVo voLoc = voLocColl.get(i);
				form.cmbHospital().newRow(voLoc, voLoc.getName());

				if (engine.getCurrentLocation() != null)
				{
					currentLocName = engine.getCurrentLocation().getID();
					if (currentLocName == voLoc.getID())
					{
						form.cmbHospital().setValue(voLoc);
					}
				}
			}

			if (form.cmbHospital().getValue() != null)
				hospitalValueChanged();
		}

	}

	private void populateWardCombo()
	{
		form.cmbWard().clear();

		if (form.cmbHospital().getValue().getType() != null && form.cmbHospital().getValue().getType().equals(LocationType.HOSP))
		{
			LocShortMappingsVoCollection voLocShortMapColl = domain.listActiveWardsForHospital(form.cmbHospital().getValue());
			if (voLocShortMapColl != null)
			{
				for (int i = 0; i < voLocShortMapColl.size(); i++)
				{
					LocShortMappingsVo voLocShortMap = voLocShortMapColl.get(i);
					form.cmbWard().newRow(voLocShortMap, voLocShortMap.getName());
				}
			}
		}

	}
	
	private void initialize()
	{
		form.lblWard().setVisible(false);
		form.cmbWard().setVisible(false);

		prePopulateControls();

		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		form.grdInpatients().setcolHospnumCaption(dispIdType.getText());
		
		//WDEV-12991
		if(ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("CCO"))
			form.grdInpatients().setcolAdmissionDateCaption("Admission Reason");
	}

	private void prePopulateControls()
	{
		populateHospitalListCombo();
		prePopulateConsultantCombo();

	}
	private void prePopulateConsultantCombo()
	{
		Object currUser = domain.getHcpUser();
		if (currUser instanceof MedicVo && MedicGrade.CONS.equals(((MedicVo)currUser).getGrade()))
		{
			HcpLiteVo hcpUser = (HcpLiteVo) domain.getHcpLiteUser();
			form.qmbConsultants().clear();
			form.qmbConsultants().newRow(hcpUser,hcpUser.getName()!= null ? hcpUser.getName().toString() : "");
			form.qmbConsultants().setValue(hcpUser);
		}
		
	}

	protected void onImbSearchClick() throws PresentationLogicException
	{
		search();
	}

	private void search()
	{
		clearContextVariables();//WDEV-15975

		performSearch();
		
	}

	private void performSearch()
	{
		clearPatientList();
		form.getContextMenus().hideAllADTMenuMenuItems();
		form.getGlobalContext().STHK.setCurrentInpatientListFilter(null);

		//WDEV-15526
		if (form.txtIdentifier().getValue() != null && form.cmbType().getValue() == null)
		{
			engine.showMessage("Please select a Patient ID Type");
			return ;
		}
		if (form.txtSurname().getValue() == null && form.txtForename().getValue() != null)
		{
			engine.showMessage("Please enter a valid Surname search string.");
			return;
		}
	
		if (form.cmbWard().getValue() == null && form.qmbConsultants().getValue() == null && form.cmbSpecialty().getValue() == null)
		{
			if (form.txtIdentifier().getValue() == null)
			{
				if (form.txtSurname().getValue() == null)
				{
					engine.showMessage("Valid search criteria must be specified. A minimum of Surname or ID or Hospital/Ward/Consultant/Specialty is required to search.");//WDEV-15644 //WDEV-15621
					return;
				}

				// Mandatory Search on forname
				if((ConfigFlag.UI.SEARCH_REQ_FORENAME.getValue())
					&&(form.txtForename().getValue() == null || form.txtForename().getValue().replaceAll("[^a-zA-Z%]", "").length() == 0))
				{
					engine.showMessage("Please enter a valid Forename search string");
					return;
				}
			}
		}

		if (form.txtIdentifier().getValue() == null
			&& form.txtSurname().getValue() == null)
		{
			if (form.cmbHospital().getValue() == null)
			{
				engine.showMessage("Valid search criteria must be specified. A minimum of Surname or ID or Hospital/Ward/Consultant/Specialty is required to search.");//WDEV-15644 //WDEV-15621
				return;
			}
			if (form.cmbWard().getValue() == null && form.qmbConsultants().getValue() == null && form.cmbSpecialty().getValue() == null)
			{
				engine.showMessage("Valid search criteria must be specified. A minimum of Surname or ID or Hospital/Ward/Consultant/Specialty is required to search.");//WDEV-15644 //WDEV-15621
				return;
			}
		}
		
		//WDEV-15644
		if (form.cmbType().getValue()!=null && form.txtIdentifier().getValue()!=null)
		{
			form.txtSurname().setValue(null);
			form.txtForename().setValue(null);
			
			form.cmbWard().setVisible(false);
			form.lblWard().setVisible(false);
			form.cmbHospital().setValue(null);
			form.cmbWard().clear();
			form.cmbWard().setValue(null);
			form.qmbConsultants().clear();
			form.cmbSpecialty().setValue(null);
		}
		
		//WDEV-15526
		//populateListControl(domain.listInPatients(form.cmbHospital().getValue(), form.cmbWard().getValue(), form.qmbConsultants().getValue(),form.cmbSpecialty().getValue()));
		populateListControl(domain.listInpatientsBySearchCriteria(form.cmbType().getValue(),form.txtIdentifier().getValue(),form.txtSurname().getValue(),form.txtForename().getValue(),form.cmbHospital().getValue(), form.cmbWard().getValue(), form.qmbConsultants().getValue(),form.cmbSpecialty().getValue()));

	}

	private void populateListControl(InpatientEpisodeVoCollection voInpatientEpisColl)
	{

		if (voInpatientEpisColl != null)
		{
			if (voInpatientEpisColl.size() == 0)
			{
				engine.showMessage("No matching patients found.");
				return;
			}
			
			storeSearchCriteria();
			
			GenForm.grdInpatientsRow row = null;
			//wdev-11026
			if( voInpatientEpisColl != null && voInpatientEpisColl.size() > 0)
				voInpatientEpisColl.sort(new SurnameComparator(SortOrder.ASCENDING));
			//-------
			for (int i = 0; i < voInpatientEpisColl.size(); i++)
			{
				InpatientEpisodeVo voInpatient = voInpatientEpisColl.get(i);
				if (voInpatient.getPasEvent().getPatientIsNotNull())
				{
					row = form.grdInpatients().getRows().newRow();
					if(voInpatient.getIsOnLeaveIsNotNull() && voInpatient.getIsOnLeave().equals(Boolean.TRUE))
					{
						row.setcolLeave(form.getImages().Core.Home);
						row.setTooltipForcolLeave("Patient is currently on Leave");
					}

					if (voInpatient.getPasEvent().getPatient().getNameIsNotNull())
					{
						row.setcolForename(voInpatient.getPasEvent().getPatient().getName().getForename());
						row.setTooltipForcolForename(voInpatient.getPasEvent().getPatient().getName().getForename());
						row.setcolSurname(voInpatient.getPasEvent().getPatient().getName().getSurname());
						row.setTooltipForcolSurname(voInpatient.getPasEvent().getPatient().getName().getSurname());
					}

					ims.core.vo.PatientId voPatId = voInpatient.getPasEvent().getPatient().getDisplayId();
					if (voPatId != null)
					{
						row.setcolHospnum(voPatId.getValue());
					}
					
					//WDEV-16710
					StringBuffer patientIdentifiers = new StringBuffer();
					PatientIdCollection identifiers = voInpatient.getPasEvent().getPatient().getIdentifiers();
					
					if (identifiers != null)
					{
						for (int a = 0; a < identifiers.size(); a++)
						{
							patientIdentifiers.append("<b>" + identifiers.get(a).getType().toString() + ":</b> " + identifiers.get(a).getValue() + "<br>");
						}
					}
					
					row.setTooltipForcolHospnum(patientIdentifiers.toString());

					if (voInpatient.getPasEvent().getPatient().getDobIsNotNull())
					{
						row.setcolDob(voInpatient.getPasEvent().getPatient().getDob().toString());
						row.setTooltipForcolDob(voInpatient.getPasEvent().getPatient().getDob().toString());
					}

					if (voInpatient.getPasEvent().getPatient().calculateAgeText()!=null)
					{
						String patientAge = voInpatient.getPasEvent().getPatient().calculateAgeText();
						row.setColAge(patientAge);
						row.setTooltipForColAge(patientAge);
					}

					if (voInpatient.getPasEvent().getPatient().getSexIsNotNull())
					{
						row.setcolSex(voInpatient.getPasEvent().getPatient().getSex().getText());
						row.setTooltipForcolSex(voInpatient.getPasEvent().getPatient().getSex().getText());
					}

					if (voInpatient.getPasEvent().getLocationIsNotNull())
					{
						row.setcolWard(voInpatient.getPasEvent().getLocation().getName());
						row.setTooltipForcolWard(voInpatient.getPasEvent().getLocation().getName());
					}

					if (voInpatient.getPasEvent().getConsultantIsNotNull())
					{
						row.setcolConsultant(voInpatient.getPasEvent().getConsultant().getName().toString());
						row.setTooltipForcolConsultant(voInpatient.getPasEvent().getConsultant().getName().toString());
					}

					//WDEV-12991
					if(ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("CCO"))
					{
						row.setcolAdmissionDate(voInpatient.getReasonForAdmission());
						row.setTooltipForcolAdmissionDate(voInpatient.getReasonForAdmission());
					}
					else if (voInpatient.getAdmissionDateTimeIsNotNull())
					{
						row.setcolAdmissionDate(voInpatient.getAdmissionDateTime().getDate().toString());
						row.setTooltipForcolAdmissionDate(voInpatient.getAdmissionDateTime().getDate().toString());
					}

					if (voInpatient.getPasEvent().getPatient().getIsDead() != null && voInpatient.getPasEvent().getPatient().getIsDead().booleanValue())
						row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());

					if (ConfigFlag.UI.INPAT_CREATE_CORRESPONDENCE_DETAILS.getValue())
					{
						if (voInpatient.getPasEventIsNotNull()
							&& voInpatient.getPasEvent().getCspDocumentStatusIsNotNull())
						{
							row.setcolDocStatus(voInpatient.getPasEvent().getCspDocumentStatus().getImage() != null ? voInpatient.getPasEvent().getCspDocumentStatus().getImage() : null);
							row.setTooltipForcolDocStatus(voInpatient.getPasEvent().getCspDocumentStatus().getText());
						}
					}

					row.setValue(voInpatient);
				}
			}
		}
		setTotalLabel(form.grdInpatients().getRows().size());
	}

	private void storeSearchCriteria() 
	{
		CurrentInpatientListFilterVo voCriteria = new CurrentInpatientListFilterVo();
		voCriteria.setConsultant(form.qmbConsultants().getValue());
		voCriteria.setHospital(form.cmbHospital().getValue());
		voCriteria.setWard(form.cmbWard().getValue());
		voCriteria.setSpecialty(form.cmbSpecialty().getValue());
		
		//WDEV-15526
		voCriteria.setIDType(form.cmbType().getValue());
		voCriteria.setHospNum(form.txtIdentifier().getValue());
		voCriteria.setSurname(form.txtSurname().getValue());
		voCriteria.setForename(form.txtForename().getValue());
		
		form.getGlobalContext().STHK.setCurrentInpatientListFilter(voCriteria);
	}

	private void clearPatientList()
	{
		form.grdInpatients().getRows().clear();
		setTotalLabel(0);
	}

	protected void onQmbConsultantsTextSubmited(String value) throws PresentationLogicException 
	{
		if (value != null)
		{
			HcpFilter voHCPFilter = new HcpFilter();
			PersonName name = new PersonName();
			name.setSurname(value);
			voHCPFilter.setQueryName(name);
			voHCPFilter.setHcpType(HcpDisType.MEDICAL);
			
			HcpLiteVoCollection voColl = domain.listHCPs(voHCPFilter);

			form.qmbConsultants().clear();
			for (int i = 0; i < voColl.size(); i++)
			{
				form.qmbConsultants().newRow(voColl.get(i), voColl.get(i).getName().toString());
			}
			if (voColl.size() == 1)
				form.qmbConsultants().setValue(voColl.get(0));
			else if (voColl.size() > 1)
				form.qmbConsultants().showOpened();
		}
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.InpatientTransferDialog)
			&& result.equals(DialogResult.OK))
		{
			PatientShort ps = null;
			try
			{
				if (form.grdInpatients().getValue() != null
					&& form.grdInpatients().getValue().getPasEventIsNotNull()
					&& form.grdInpatients().getValue().getPasEvent().getPatientIsNotNull())
		 		{
		 			ps = domain.getPatient(form.grdInpatients().getValue().getPasEvent().getPatient());
			 		if (ps != null)
			 			setPatientInfoBar(ps);		
		 		}
			}
			catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
			}

			performSearch();
		}
		else if (formName.equals(form.getForms().Admin.RCHTManualDischargeDialog)
			&& result.equals(DialogResult.OK))
		{
			if( domain.inpatientWasDischarged(form.getGlobalContext().Core.getPatientShort()) == true) 	//wdev-15823
				engine.showMessage(" The In-Patient has been discharged by another user. The screen will be refreshed. ");								//wdev-15823
			else
				dischargeInpatientRecord(form.grdInpatients().getValue(), form.getGlobalContext().Core.getRCHTInpatientDischarge());
			
			search();
		}
		else if (result.equals(DialogResult.OK) || result.equals(DialogResult.YES))
			search();
		
		setContextMenusState();//WDEV-15975
	}

	private void dischargeInpatientRecord(InpatientEpisodeVo value, RCHTInpatientDischargeVo inpatientDischarge) 
	{
		PatientShort pat = form.getGlobalContext().Core.getPatientShort();
		DischargedEpisodeVo disc = new DischargedEpisodeVo();
		disc.setDischargeDateTime(inpatientDischarge.getDischargeDateTime());
		disc.setDischargeDestination(inpatientDischarge.getDischargeDestination());
		disc.setMethodOfDischarge(inpatientDischarge.getMethodOfDischarge());
		
		String[] errs = pat.validate();
		if (errs != null)	
		{
			engine.showErrors(errs);
		}
		errs = disc.validate();
		if (errs != null)
		{
			engine.showErrors(errs);
		}
		try
		{
			domain.dischargePatient(pat, disc);
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}

	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		if ((ConfigFlag.UI.INPAT_CREATE_CORRESPONDENCE_DETAILS.getValue()
				|| engine.hasRight(AppRight.CAN_DISCHARGE_INPATIENT_IN_RCHT) 
				|| ConfigFlag.UI.MAXIMS_ADT_NO_INTERFACE.getValue() 
			)
			&& form.getGlobalContext().Core.getPatientShortIsNotNull()
			)
		{
			switch(menuItemID)
			{	
				case GenForm.ContextMenus.ADTMenu.Add:
					addDocumentDetails();
					break;
				case GenForm.ContextMenus.ADTMenu.View:
					viewDocumentDetails();
					break;
				case GenForm.ContextMenus.ADTMenu.Demographics:
					showDemographics();
					break;
				case GenForm.ContextMenus.ADTMenu.Discharge:
					if( !engine.hasRight(AppRight.CAN_DISCHARGE_INPATIENT_IN_RCHT) && ConfigFlag.UI.MAXIMS_ADT_NO_INTERFACE.getValue() && engine.hasRight(AppRight.MAXIMS_ADT_CAN_DISCHARGE))  //wdev-16427
						dischargeInpatientForLeopardstown();
					else
						dischargeInpatientForRCHT();
					break;
				case GenForm.ContextMenus.ADTMenu.Transfer:
					transferPatient();
					break;
				case GenForm.ContextMenus.ADTMenu.CancelAdmission:
					cancelAdmission();
					break;
			}	
		}
	}
	
	private void cancelAdmission()
	{
		StringBuffer sb = new StringBuffer();
		
		InpatientEpisodeVo voIP = domain.getInpatientEpisode(form.grdInpatients().getSelectedRow().getValue());
		if (voIP == null
			|| 
			(voIP != null
			&& voIP.getPasEventIsNotNull()
			&& voIP.getPasEvent().getLocationIsNotNull()
			&& form.grdInpatients().getSelectedRow().getValue() != null
			&& form.grdInpatients().getSelectedRow().getValue().getPasEvent() != null
			&&  ! voIP.getPasEvent().getLocation().equals(form.grdInpatients().getSelectedRow().getValue().getPasEvent().getLocation())))
		{
			engine.showMessage("This In-Patient record has already been updated by another user. The screen will be refreshed.");
			performSearch();
			return;
		}

		if (voIP != null
			&& voIP.getPasEventIsNotNull()
			&& voIP.getPasEvent().getLocationIsNotNull())
		{
			sb.append("Confirm admission to ward '");
			sb.append(voIP.getPasEvent().getLocation().getName());
			sb.append("' on '");
			sb.append(voIP.getAdmissionDateTimeIsNotNull() ? voIP.getAdmissionDateTime().toString() : "");
			sb.append("' for patient '");
		}
		else
			sb.append("Confirm admission for ");
		
		if (voIP != null
			&& voIP.getPasEventIsNotNull()
			&& voIP.getPasEvent().getPatientIsNotNull()
			&& voIP.getPasEvent().getPatient().getNameIsNotNull())
			sb.append(voIP.getPasEvent().getPatient().getName().toString());
		
		sb.append("' is to be cancelled.");
		
		engine.showMessage(sb.toString(), "Cancel Admission ", MessageButtons.CONFIRMCANCEL, MessageIcon.QUESTION);
	}

	private void transferPatient()
	{
		InpatientEpisodeWithICPInfoVo voIp = domain.getInpatientEpisodeWithICPInfo((InpatientEpisodeRefVo)form.grdInpatients().getSelectedRow().getValue());
		if (voIp == null
			|| 
			(voIp != null
			&& voIp.getPasEventIsNotNull()
			&& voIp.getPasEvent().getLocationIsNotNull()
			&& form.grdInpatients().getSelectedRow().getValue() != null
			&& form.grdInpatients().getSelectedRow().getValue().getPasEvent() != null
			&&  ! voIp.getPasEvent().getLocation().equals(form.grdInpatients().getSelectedRow().getValue().getPasEvent().getLocation())))
		{
			engine.showMessage("This In-Patient record has already been updated by another user. The screen will be refreshed.");
			performSearch();
			return;
		}
		
		if (voIp != null)
			engine.open(form.getForms().Core.InpatientTransferDialog, new Object[]{ voIp});
	}

	private void dischargeInpatientForRCHT() 
	{
		engine.open(form.getForms().Admin.RCHTManualDischargeDialog);
	}
	//wdev-16427
	private void dischargeInpatientForLeopardstown()
	{
		
		engine.open(form.getForms().Core.ADTPatientAdmission,new Object[]{ new Boolean(true)});
	}

	private void addDocumentDetails() 
	{				
		form.getGlobalContext().Correspondence.setGenerateFormMode(FormMode.EDIT);	
		engine.open(form.getForms().Correspondence.CorrespondenceDetail);		
	}
	
	private void viewDocumentDetails()
	{
		form.getGlobalContext().Correspondence.setGenerateFormMode(FormMode.VIEW);
		engine.open(form.getForms().Correspondence.CorrespondenceDetail);
	}
	//wdev-11026
	public class SurnameComparator implements Comparator
	{
		private int direction = 1;
		
		public SurnameComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public SurnameComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String pdate1 = null;
			String pdate2 = null;
			if(ob1 instanceof InpatientEpisodeVo )
			{
				InpatientEpisodeVo ps1 = (InpatientEpisodeVo)ob1;
				pdate1 = (ps1.getPasEvent() != null && ps1.getPasEvent().getPatient() != null && ps1.getPasEvent().getPatient().getName() != null) ? ps1.getPasEvent().getPatient().getName().getSurname():null;
			}
			if(ob2 instanceof InpatientEpisodeVo)
			{
				InpatientEpisodeVo ps2 = (InpatientEpisodeVo)ob2;
				pdate2 = (ps2.getPasEvent() != null && ps2.getPasEvent().getPatient() != null && ps2.getPasEvent().getPatient().getName() != null) ? ps2.getPasEvent().getPatient().getName().getSurname():null;
			}
			if(pdate1 != null )
				return  pdate1.compareToIgnoreCase(pdate2)*direction;
			if(pdate2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}
	@Override
	protected void onBtnPrintReportClick() throws PresentationLogicException
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

		
		if(form.cmbWard().getValue()==null)		
		{
			engine.showMessage("Please select a ward !");
			return;
		}
		
		//we need a better way to do this
		Object[] obj = domain.getSystemReportAndTemplate(new Integer(297));
		
		if(obj == null || obj.length < 2)
		{
			engine.showMessage("I could not get the report and template !");
			return;
		}
		
		if(obj[0] == null || obj[1] == null)
		{
			engine.showMessage("The report has not been deployed !");
			return;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
				
		client.addSeed(new SeedValue("Ward",  form.cmbWard().getValue().getID_Location().intValue(), Integer.class));
		client.addSeed(new SeedValue("Consultant",  form.qmbConsultants().getValue()==null?null:form.qmbConsultants().getValue().getIMosId().intValue(), Integer.class));
		client.addSeed(new SeedValue("Specialty",  form.cmbSpecialty().getValue()==null?null:form.cmbSpecialty().getValue().getID(), Integer.class));
		
		
		
		String resultUrl = "";
		try
		{
			resultUrl = client.buildReportAsUrl((String)obj[0], (String)obj[1], urlReportServer, "PDF", "", 1);
		} 
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return;
		}
		
		engine.openUrl(resultUrl);
		
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		//Currently only one message box on this form so .....its a CancelAdmission
		if (result.equals(DialogResult.CONFIRM))
		{
			PatientShort pat = form.getGlobalContext().Core.getPatientShort();
			if (pat == null)
			{
				search();
				return;
			}
			String[] errs = pat.validate();
			
			if (errs != null)	
			{
				engine.showErrors(errs);
				return;
			}

			try
			{
				domain.cancelAdmission(pat);
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
			catch (ForeignKeyViolationException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
			
			search();
		}
		else
			search();// refresh - could have pressed cancel - and i/p reord was removed in another session.

	}
}
