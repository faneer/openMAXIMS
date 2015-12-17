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
// This code was generated by Peter Martin using IMS Development Environment (version 1.39 build 2173.22508)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.homevisitaccess;

import java.util.ArrayList;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.enumerations.FormMode;
import ims.framework.utils.Color;
import ims.therapies.homeandenvironmentalvisit.vo.HomeVisitRefVo;
import ims.therapies.vo.BathingFacilityVo;
import ims.therapies.vo.BathingFacilityVoCollection;
import ims.therapies.vo.HomeDetailsVo;
import ims.therapies.vo.HomeVisitShortVo;
import ims.therapies.vo.HomeVisitVo;
import ims.therapies.vo.VisitAssessmentComponentVo;
import ims.spinalinjuries.vo.lookups.EnvironmentalHomeVisitComponentType;
import ims.therapies.vo.HomeVisitShortVoCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{		
		initialize();
		open();
	}
	private void initialize()
	{		
		loadTherapistCombo();
	}
	private void loadContactRecords()
	{
		boolean currentClinicalContactFound = false;
			
		HomeVisitShortVoCollection voHomeVisitShortColl = domain.listHomeVisitAccContacts(form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext());

		loadHomeVisitsOfCareContext(voHomeVisitShortColl);
		if(voHomeVisitShortColl != null)
		{
			for(int i=0; i<voHomeVisitShortColl.size(); i++)
			{
				if(voHomeVisitShortColl.get(i).getClinicalContactIsNotNull())
				{
					currentClinicalContactFound = loadHomeVisitsOfClinicalContact(voHomeVisitShortColl.get(i));
				}
			}
		}
		if(!currentClinicalContactFound)
		{
			loadCurrentClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact(), Color.Green);
		}
	}	

	private void loadHomeVisitsOfCareContext(HomeVisitShortVoCollection voHomeVisitShortColl)
	{
		if(voHomeVisitShortColl != null)
		{
			voHomeVisitShortColl.sort(); //WDEV-13700
			for(int i=0; i<voHomeVisitShortColl.size(); i++)
			{
				HomeVisitShortVo voHomeVisit = voHomeVisitShortColl.get(i);
				if(voHomeVisit.getClinicalContact() == null && voHomeVisit.getCareContext().getID_CareContext().equals(form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext()))
				{
					loadHomeVisitsForACareContext(voHomeVisit);
				}
				else //start WDEV-13700
					if (voHomeVisit !=null && voHomeVisit.getIsRIE() != null && voHomeVisit.getIsRIE()) 
					{
						form.recbrContact().newRow(voHomeVisit, "\t\t\t\tClinical Contact:"+ voHomeVisit.getClinicalContact().getStartDateTime() +" - "+ voHomeVisit.getClinicalContact().getSeenBy());
					}
					//end
			}
		}
	}
	private void loadHomeVisitsForACareContext(HomeVisitShortVo voHomeVisit)
	{
		// A care context can have a number of Environmental Visits
		if(form.getGlobalContext().Core.getCurrentClinicalContact() == null)
			form.recbrContact().newRow(voHomeVisit, "\t\t\t\t "+ voHomeVisit.getAuthoringInformation().getAuthoringDateTime() + " - " + voHomeVisit.getAuthoringInformation().getAuthoringHcp().getName(), Color.Green);
		else
			form.recbrContact().newRow(voHomeVisit, "\t\t\t\t "+ voHomeVisit.getAuthoringInformation().getAuthoringDateTime() + " - " + voHomeVisit.getAuthoringInformation().getAuthoringHcp().getName());

	}
	private boolean loadHomeVisitsOfClinicalContact(HomeVisitShortVo voHomeVisit)
	{
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		//A Clinical Contact can only have one Environmental Visit Record
		if(voClinicalContact != null && voClinicalContact.getID_ClinicalContact().equals(voHomeVisit.getClinicalContact().getID_ClinicalContact()))
		{
			//this Clinical Contact has been selected from the patient summary
			loadCurrentClinicalContact(voHomeVisit.getClinicalContact(), Color.Green);
			return true;
		}
		else
		{
			loadCurrentClinicalContact(voHomeVisit.getClinicalContact(), null);
		}

		return false;
	}
	private void loadCurrentClinicalContact(ClinicalContactShortVo voClinicalContact, Color selected)
	{
		//Populates recordBrowser with Clinical Contact info
		if (voClinicalContact == null)
			return;
		
		if (!engine.isRIEMode()) //WDEV-13700
			{
			form.recbrContact().newRow(voClinicalContact, "\t\t\t\tClinical Contact:"+ voClinicalContact.getStartDateTime() +" - "+ voClinicalContact.getSeenBy(), selected);
			if(selected != null )
				form.recbrContact().setValue(voClinicalContact);
			}
	}
	private void open() 
	{
		form.setMode(FormMode.VIEW);
		fillRecordBrowser();
	}
	
	private void fillRecordBrowser()
	{
		form.recbrContact().clear();
		
		loadCurrentCareContext();
		loadContactRecords();	
		browserRecord();
	}
	private void loadCurrentCareContext()
	{
		CareContextShortVo voCurrentCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			form.recbrContact().newRow(voCurrentCareContext, voCurrentCareContext.getRecordBrowserText());
		else
			form.recbrContact().newRow(voCurrentCareContext, voCurrentCareContext.getRecordBrowserText(), Color.Green);
		
	}
	private void loadTherapistCombo() 
	{
		form.cboTherapist().clear();
		
		HcpLiteVoCollection voHCPColl = domain.listHcpLiteByDisciplineType(HcpDisType.THERAPY);
		
		if(voHCPColl != null)
		{
			for (int i = 0; i < voHCPColl.size(); i++)
			{
				addNewTherapist(voHCPColl.get(i));
			}
		}
	}

	private void clearInstanceControls() 
	{
		form.customControlAuthoring() .setValue(null);
		form.cboTherapist().setValue(null);
		form.txtAddress().setValue(null);
		form.cmbAccomodationype().setValue(null);
		form.cmbOwnershipStatus().setValue(null);
		form.dteVisit().setValue(null);
		form.txtOthersPresent().setValue("");
		form.txtExternalAccess().setValue("");
		form.txtExternalShortTerm().setValue("");
		form.txtExternalLongTerm().setValue("");
		form.txtExternalAccess().setValue("");
		form.txtExternalShortTerm().setValue("");
		form.txtExternalLongTerm().setValue("");
		form.txtExternalAccess().setValue("");
		form.txtExternalShortTerm().setValue("");
		form.txtExternalLongTerm().setValue("");
		form.txtAccessBack().setValue("");
		form.txtAccessBackLongTerm().setValue("");
		form.txtAccessBackShortTerm().setValue("");
		form.txtAccessFront().setValue("");
		form.txtAccessFrontLongTerm().setValue("");
		form.txtAccessFrontShortTerm().setValue("");
		form.txtAddress().setValue("");
		form.txtExternalAccess().setValue("");
		form.txtExternalLongTerm().setValue("");
		form.txtExternalShortTerm().setValue("");
		form.txtOthersPresent().setValue("");
		
	}

	private void populateScreen()
	{
		HomeVisitVo voHomeVisit = form.getLocalContext().getHomeVisitVo();
		form.getGlobalContext().Therapies.setHomeVisit(voHomeVisit);
		if (voHomeVisit != null)
		{
			form.customControlAuthoring().setValue(voHomeVisit.getAuthoringInformation());
			setTherapistValue(voHomeVisit.getTherapistPresent());
			
			HomeDetailsVo voHomeDetails = voHomeVisit.getHouseDetails();
			if(voHomeDetails != null)
			{
				form.txtAddress().setValue(voHomeDetails.getAddress());
				form.cmbAccomodationype().setValue(voHomeDetails.getAccommodationType());
				form.cmbOwnershipStatus().setValue(voHomeDetails.getOwnershipStatus());
			}
			
			form.dteVisit().setValue(voHomeVisit.getVisitDate());
			form.txtOthersPresent().setValue(voHomeVisit.getOthersPresent());
			
			BathingFacilityVoCollection collBathingFacilityVo = voHomeVisit.getHomeAssessmentComponent();
			if(collBathingFacilityVo==null)
				collBathingFacilityVo = new BathingFacilityVoCollection();
			
			for(int i=0; i<collBathingFacilityVo.size(); i++)
			{
				VisitAssessmentComponentVo voVisitAssessmentComponent = collBathingFacilityVo.get(i);
				if(voVisitAssessmentComponent.getType().equals(EnvironmentalHomeVisitComponentType.HOMEVISITEXTERNALACCESSANDPARKING))
				{
					form.txtExternalAccess().setValue(voVisitAssessmentComponent.getDetails());
					form.txtExternalShortTerm().setValue(voVisitAssessmentComponent.getShortTermPlan());
					form.txtExternalLongTerm().setValue(voVisitAssessmentComponent.getLongTermPlan());
				}
				else if(voVisitAssessmentComponent.getType().equals(EnvironmentalHomeVisitComponentType.ACCESSFRONT))
				{
					form.txtAccessFront().setValue(voVisitAssessmentComponent.getDetails());
					form.txtAccessFrontShortTerm().setValue(voVisitAssessmentComponent.getShortTermPlan());
					form.txtAccessFrontLongTerm().setValue(voVisitAssessmentComponent.getLongTermPlan());
				}
				else if(voVisitAssessmentComponent.getType().equals(EnvironmentalHomeVisitComponentType.ACCESSBACK))
				{
					form.txtAccessBack().setValue(voVisitAssessmentComponent.getDetails());
					form.txtAccessBackShortTerm().setValue(voVisitAssessmentComponent.getShortTermPlan());
					form.txtAccessBackLongTerm().setValue(voVisitAssessmentComponent.getLongTermPlan());
				}
			}
		}
	}

	protected void onNewClick() throws PresentationLogicException 
	{
		newInstance();
	}

	private void newInstance()
	{
		form.getGlobalContext().Therapies.setHomeVisit(null);
		form.getLocalContext().setHomeVisitVo(null);
		
		clearInstanceControls();
		form.setMode(FormMode.EDIT);
		form.customControlAuthoring().initializeComponent();
		form.customControlAuthoring().setIsRequiredPropertyToControls(Boolean.TRUE);
		form.setcustomControlAuthoringEnabled(true);
	}

	protected void onUpdateClick() throws PresentationLogicException 
	{
		updateInstance();
	}

	private void updateInstance()
	{
		form.setMode(FormMode.EDIT);
		form.setcustomControlAuthoringEnabled(false);
	}
	protected void onSaveClick() throws PresentationLogicException 
	{
		if (save())
			open(); 
	}

	private boolean save()
	{
		HomeVisitVo voHomeVisitVo = form.getLocalContext().getHomeVisitVo();
		if (voHomeVisitVo == null)
			voHomeVisitVo = new HomeVisitVo();
		
		voHomeVisitVo = populateHomeVisitVo(voHomeVisitVo);
		
		voHomeVisitVo.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voHomeVisitVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		String[] uiErrors = getUiErrors();
		String[] errors = voHomeVisitVo.validate(uiErrors);
	
		if (errors != null)
		{
			engine.showErrors("Validation Errors", errors);
			return false;
		}
	
		try 
		{
			form.getLocalContext().setHomeVisitVo(domain.saveHomeVisitAccess(voHomeVisitVo));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A meeting with the same criteria already exists.   " + e.getMessage());
			open();
			return false;			
		}
		form.getGlobalContext().Therapies.setHomeVisit(form.getLocalContext().getHomeVisitVo());
		return true;
	}
	private String[] getUiErrors()
	{
		
		ArrayList<String> errors = new ArrayList<String>();
		if (form.customControlAuthoring().getValue() == null) 
		{
			boolean add = errors.add("Authoring Information is mandatory");
		}
		if (form.customControlAuthoring().getValue() != null && form.customControlAuthoring().getValue().getAuthoringHcp() == null) 
		{
			errors.add("Authoring Information HCP is mandatory");
		}
		if (form.customControlAuthoring().getValue() != null && form.customControlAuthoring().getValue().getAuthoringDateTime() == null) 
		{
			errors.add("Authoring Information Date Time is mandatory");
		}
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			return searchErrors;
		}
		return null;
	}
	private HomeVisitVo populateHomeVisitVo(HomeVisitVo voHomeVisitVo) 
	{
		voHomeVisitVo.setAuthoringInformation(form.customControlAuthoring().getValue());
		voHomeVisitVo.setTherapistPresent(form.cboTherapist().getValue());
		
		HomeDetailsVo voHomeDetails = new HomeDetailsVo();
		voHomeDetails.setAddress(form.txtAddress().getValue());
		voHomeDetails.setAccommodationType(form.cmbAccomodationype().getValue());
		voHomeDetails.setOwnershipStatus(form.cmbOwnershipStatus().getValue());
		voHomeVisitVo.setHouseDetails(voHomeDetails);
		
		voHomeVisitVo.setVisitDate(form.dteVisit().getValue());
		
		voHomeVisitVo.setOthersPresent(form.txtOthersPresent().getValue());
		
		BathingFacilityVoCollection collBathingFacilityVo = voHomeVisitVo.getHomeAssessmentComponent();
		if(collBathingFacilityVo==null)
			collBathingFacilityVo = new BathingFacilityVoCollection();
		
		BathingFacilityVo voParkingComponent = null;
		voParkingComponent = getComponent(collBathingFacilityVo, EnvironmentalHomeVisitComponentType.HOMEVISITEXTERNALACCESSANDPARKING);
		
		if(voParkingComponent==null)
			voParkingComponent = new BathingFacilityVo();
		voParkingComponent.setType(EnvironmentalHomeVisitComponentType.HOMEVISITEXTERNALACCESSANDPARKING);
		voParkingComponent.setDetails(form.txtExternalAccess().getValue());
		voParkingComponent.setShortTermPlan(form.txtExternalShortTerm().getValue());
		voParkingComponent.setLongTermPlan(form.txtExternalLongTerm().getValue());
		if(voParkingComponent.getID_VisitAssessmentComponent()==null)
			collBathingFacilityVo.add(voParkingComponent);
		
		BathingFacilityVo voAccessFrontComponent = null;
		voAccessFrontComponent = getComponent(collBathingFacilityVo, EnvironmentalHomeVisitComponentType.ACCESSFRONT);
		
		if(voAccessFrontComponent==null)
			voAccessFrontComponent = new BathingFacilityVo();
		voAccessFrontComponent.setType(EnvironmentalHomeVisitComponentType.ACCESSFRONT);
		voAccessFrontComponent.setDetails(form.txtAccessFront().getValue());
		voAccessFrontComponent.setShortTermPlan(form.txtAccessFrontShortTerm().getValue());
		voAccessFrontComponent.setLongTermPlan(form.txtAccessFrontLongTerm().getValue());
		if(voAccessFrontComponent.getID_VisitAssessmentComponent()==null)
			collBathingFacilityVo.add(voAccessFrontComponent);
		
		BathingFacilityVo voAccessBackComponent = null;
		voAccessBackComponent = getComponent(collBathingFacilityVo, EnvironmentalHomeVisitComponentType.ACCESSBACK);
		
		if(voAccessBackComponent == null)
			voAccessBackComponent = new BathingFacilityVo();
		voAccessBackComponent.setType(EnvironmentalHomeVisitComponentType.ACCESSBACK);
		voAccessBackComponent.setDetails(form.txtAccessBack().getValue());
		voAccessBackComponent.setShortTermPlan(form.txtAccessBackShortTerm().getValue());
		voAccessBackComponent.setLongTermPlan(form.txtAccessBackLongTerm().getValue());
		if(voAccessBackComponent.getID_VisitAssessmentComponent() == null)
			collBathingFacilityVo.add(voAccessBackComponent);
		
		voHomeVisitVo.setHomeAssessmentComponent(collBathingFacilityVo);
		return voHomeVisitVo;
	}

	private BathingFacilityVo getComponent(BathingFacilityVoCollection collComponents, EnvironmentalHomeVisitComponentType componentType) 
	{
		for(int i=0; i<collComponents.size(); i++)
		{
			if(collComponents.get(i).getType().equals(componentType))
				return collComponents.get(i);
		}
		return null;
	}
	
	protected void onCancelClick() throws PresentationLogicException 
	{
		open();
	}

	protected void onRecbrContactValueChanged() throws PresentationLogicException 
	{
		browserRecord();
	}
	private void browserRecord()
	{
		clearInstanceControls();
		form.getLocalContext().setHomeVisitVo(null);
		if(form.recbrContact().getValue() instanceof HomeVisitShortVo)
		{
			form.getLocalContext().setHomeVisitVo(domain.getHomeVisit((HomeVisitRefVo) form.recbrContact().getValue()));
		}
		if(form.recbrContact().getValue() instanceof ClinicalContactShortVo)
		{
			form.getLocalContext().setHomeVisitVo(domain.getHomeVisitAccByClinicalContact((ClinicalContactRefVo) form.recbrContact().getValue()));
		}
		if(form.recbrContact().getValue() instanceof CareContextVo)
		{
			form.getLocalContext().setHomeVisitVo(domain.getHomeVisitAccByCareContext((CareContextRefVo) form.recbrContact().getValue()));
		}
		
		populateScreen();
		isRecordEditable();
	}
	private void isRecordEditable()
	{
		if(form.recbrContact().getValue()!= null)
		{
			if(form.recbrContact().getValue() instanceof ClinicalContactShortVo && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
					&& form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact().equals(((ClinicalContactRefVo) form.recbrContact().getValue()).getID_ClinicalContact()))
			{
				displayButtonsForRecord();
			}
			else if((form.recbrContact().getValue() instanceof CareContextShortVo || form.recbrContact().getValue() instanceof HomeVisitShortVo) && form.getGlobalContext().Core.getCurrentClinicalContact() == null)
			{
				//If the current Care Context is selected then there is always an option of many environment records.
				displayButtonsForRecord();
				form.btnNew().setVisible(true);
				form.btnNew().setEnabled(true);
			}
			else
				showButtonsForRecord(false, false);
		}
	}
	private void displayButtonsForRecord()
	{
		if(form.getLocalContext().getHomeVisitVo() == null)
			showButtonsForRecord(true, false);
		else
			showButtonsForRecord(false, true);
	}
	private void showButtonsForRecord(boolean newVisible, boolean updateVisible)
	{
		if(form.getMode().equals(FormMode.VIEW)){
			form.btnNew().setVisible(newVisible);
			form.btnUpdate().setVisible(updateVisible);
		}
	}
	
	private void addNewTherapist(HcpLiteVo hcpLiteVo)
	{
		form.cboTherapist().newRow(hcpLiteVo, hcpLiteVo.getName().toString());
	}
	
	private void setTherapistValue(HcpLiteVo therapistPresent)
	{
		if(therapistPresent != null && form.cboTherapist().getValues().indexOf(therapistPresent) < 0)
			addNewTherapist(therapistPresent);
			
		form.cboTherapist().setValue(therapistPresent);
	}
}
