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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2257.28884)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.clinicalimagingresults;

import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.ServiceCategory;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.DateTimeFormat;
import ims.framework.utils.Image;
import ims.framework.utils.Time;
import ims.ocrr.forms.clinicalimagingresults.GenForm.Group1Enumeration;
import ims.ocrr.forms.clinicalimagingresults.GenForm.GroupInpatientOutpatientEnumeration;
import ims.ocrr.forms.clinicalimagingresults.GenForm.GrpCriteriaEnumeration;
import ims.ocrr.forms.clinicalimagingresults.GenForm.grdClinicalImagingRow;
import ims.ocrr.vo.InvestigationIndexLiteVoCollection;
import ims.ocrr.vo.OcsPathRadResultVo;
import ims.ocrr.vo.OcsPathRadResultVoCollection;
import ims.ocrr.vo.OrderedInvestigationStatusClinicalImagingVo;
import ims.ocrr.vo.RadiologyOrdersResultsSearchCriteriaVo;
import ims.ocrr.vo.RadiologyResultListVo;
import ims.ocrr.vo.RadiologyResultListVoCollection;
import ims.ocrr.vo.ResultCommentsLiteVo;
import ims.ocrr.vo.ResultCommentsLiteVoCollection;
import ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo;
import ims.ocrr.vo.SecurityLevelConfigVo;
import ims.ocrr.vo.lookups.AuthorisationOrderStatus;
import ims.ocrr.vo.lookups.Category;
import ims.ocrr.vo.lookups.OrderInvStatus;

public class Logic extends BaseLogic
{
	private static final int IPOP_ALL = 1;
	private static final int IPOP_INPATIENT = 2;
	private static final int IPOP_OUTPATIENT = 3;
	
	private static final int LIST_ALL				= 1;
	private static final int LIST_RESULTS_ONLY		= 2;
	private static final int LIST_COMPLETED			= 3;
	
	
	
	
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		form.Group1().setValue(Group1Enumeration.rdoAll);
		form.GrpCriteria().setValue(GrpCriteriaEnumeration.rdoBegins);
		form.GroupInpatientOutpatient().setValue(GroupInpatientOutpatientEnumeration.rdoIPOPAll);
		loadCmbDepartment();
		updateTotal();
		
		form.Group1().setVisible(Group1Enumeration.rdoComplete, ConfigFlag.UI.DISPLAY_COMPLETE_FILTER_RESULTS_STATUS.getValue());//wdev-17322
		
		//security level WDEV-9780
		RoleDisciplineSecurityLevelLiteGCVo voRoleDisciplineSecurityLevels = form.getGlobalContext().OCRR.getRoleDisciplineSecurityLevels();
		if(voRoleDisciplineSecurityLevels == null || (voRoleDisciplineSecurityLevels != null &&  voRoleDisciplineSecurityLevels.getIsConfigLoadedIsNotNull() && !voRoleDisciplineSecurityLevels.getIsConfigLoaded().equals(false)))
			form.getGlobalContext().OCRR.setRoleDisciplineSecurityLevels(domain.getRoleDisciplineSecurityLevels(engine.getLoggedInRole()));
		
		//WDEV-19389 
		if(form.getGlobalContext().OCRR.getRadiologyOrdersResultsSearchCriteriaIsNotNull())
		{
			if(form.getGlobalContext().Core.getPatientShortIsNotNull() &&
		       form.getGlobalContext().Core.getPatientShort().equals(form.getGlobalContext().OCRR.getRadiologyOrdersResultsSearchCriteria().getPatient())	)
			{
				setSearchCriteria(form.getGlobalContext().OCRR.getRadiologyOrdersResultsSearchCriteria());
				if(doSearch())
				{
					form.getGlobalContext().OCRR.setRadiologyOrdersResultsSearchCriteria(getSearchCriteria());
				}
			}
			else
				form.getGlobalContext().OCRR.setRadiologyOrdersResultsSearchCriteria(null);
		}
		
		updateControlsState();			
	}
	

	
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		form.getGlobalContext().OCRR.setOrderAwaitingAuthorisation(null);//	WDEV-11097
		
		if(formName.equals(form.getForms().OCRR.ResultDialog) && DialogResult.YES.equals(result))
		{
			engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
			return;
		}
		
		doSearch();
	}

	
	protected void onRadioButtonGroup1ValueChanged() throws PresentationLogicException
	{
		form.getGlobalContext().OCRR.setLastUpdatedPathRadResult(null);
		
		form.chkChecked().setValue(null);
		form.chkUnchecked().setValue(null);
		
		updateControlsState();
		
		//WDEV-19389 
		if (doSearch())
			form.getGlobalContext().OCRR.setRadiologyOrdersResultsSearchCriteria(getSearchCriteria());
	}

	
	private void updateControlsState()
	{
		form.chkChecked().setVisible(Group1Enumeration.rdoResults.equals(form.Group1().getValue()) && Boolean.TRUE.equals(ConfigFlag.UI.PATIENT_RADIOLOGY_FILTERS.getValue()));
		form.chkUnchecked().setVisible(Group1Enumeration.rdoResults.equals(form.Group1().getValue()) && Boolean.TRUE.equals(ConfigFlag.UI.PATIENT_RADIOLOGY_FILTERS.getValue()));
	}



	private RadiologyOrdersResultsSearchCriteriaVo getSearchCriteria()
	{
		RadiologyOrdersResultsSearchCriteriaVo searchCriteria = new RadiologyOrdersResultsSearchCriteriaVo();
		
		searchCriteria.setRespClinician(form.qmbClinician().getValue());
		searchCriteria.setService(form.cmbDepartment().getValue());
		searchCriteria.setInpatientOutpatientOption(getInpatientOutpatientSearchType());
		searchCriteria.setFromDate(form.dteFrom().getValue());
		searchCriteria.setToDate(form.dteTo().getValue());
		searchCriteria.setSearchType(getSearchType());
		searchCriteria.setChecked(form.chkChecked().getValue());
		searchCriteria.setUnchecked(form.chkUnchecked().getValue());
		searchCriteria.setInvestigation(form.qmbResultType().getValue());
		searchCriteria.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		return searchCriteria;
	}

	private void setSearchCriteria(RadiologyOrdersResultsSearchCriteriaVo radiologyOrdersResultsSearchCriteriaVo) 
	{
		if (radiologyOrdersResultsSearchCriteriaVo.getRespClinicianIsNotNull())
		{
			form.qmbClinician().newRow(radiologyOrdersResultsSearchCriteriaVo.getRespClinician(), radiologyOrdersResultsSearchCriteriaVo.getRespClinician().getName().toString());
			form.qmbClinician().setValue(radiologyOrdersResultsSearchCriteriaVo.getRespClinician());
		}
		if (radiologyOrdersResultsSearchCriteriaVo.getInvestigationIsNotNull())
		{
			form.qmbResultType().newRow(radiologyOrdersResultsSearchCriteriaVo.getInvestigation(), radiologyOrdersResultsSearchCriteriaVo.getInvestigation().getName());
			form.qmbResultType().setValue(radiologyOrdersResultsSearchCriteriaVo.getInvestigation());
		}
		
		form.dteFrom().setValue(radiologyOrdersResultsSearchCriteriaVo.getFromDate());
		form.dteTo().setValue(radiologyOrdersResultsSearchCriteriaVo.getToDate());
		form.cmbDepartment().setValue(radiologyOrdersResultsSearchCriteriaVo.getService());
		setInpatientOutpatientSearchType(radiologyOrdersResultsSearchCriteriaVo.getInpatientOutpatientOption());
		setSearchType(radiologyOrdersResultsSearchCriteriaVo.getSearchType());
		
	}
	
	
	private void setInpatientOutpatientSearchType(Integer inpatientOutpatientOption)
	{
		if (inpatientOutpatientOption == null)
			return;
		
		switch (inpatientOutpatientOption)
		{
			case IPOP_ALL:
				form.GroupInpatientOutpatient().setValue(GroupInpatientOutpatientEnumeration.rdoIPOPAll);
				break;
				
			case IPOP_INPATIENT:
				form.GroupInpatientOutpatient().setValue(GroupInpatientOutpatientEnumeration.rdoIPOPInpatient);
				break;
				
			case IPOP_OUTPATIENT:
				form.GroupInpatientOutpatient().setValue(GroupInpatientOutpatientEnumeration.rdoIPOPOutpatient);
				break;
		}
	}



	private void setSearchType(Integer searchType)
	{
		if (searchType == null)
			return;
		
		switch (searchType)
		{
		case LIST_ALL:
			form.Group1().setValue(Group1Enumeration.rdoAll);
			break;
		case LIST_RESULTS_ONLY:
			form.Group1().setValue(Group1Enumeration.rdoResults);
			break;
		case LIST_COMPLETED:
			form.Group1().setValue(Group1Enumeration.rdoComplete);
			break;
		}			
	}
	
	
	private Integer getInpatientOutpatientSearchType()
	{
		GroupInpatientOutpatientEnumeration inpatientOutpatientOption = form.GroupInpatientOutpatient().getValue();
		
		if (GroupInpatientOutpatientEnumeration.rdoIPOPAll.equals(inpatientOutpatientOption))
			return IPOP_ALL;

		if (GroupInpatientOutpatientEnumeration.rdoIPOPInpatient.equals(inpatientOutpatientOption))
			return IPOP_INPATIENT;
		
		if (GroupInpatientOutpatientEnumeration.rdoIPOPOutpatient.equals(inpatientOutpatientOption))
			return IPOP_OUTPATIENT;

		return null;
	}
	

	private Integer getSearchType()
	{
		Group1Enumeration searchType = form.Group1().getValue();
		if (Group1Enumeration.rdoAll.equals(searchType))
		{
			return LIST_ALL;
		}
		if (Group1Enumeration.rdoResults.equals(searchType))
		{
			return LIST_RESULTS_ONLY;
		}
		if (Group1Enumeration.rdoComplete.equals(searchType))
		{
			return LIST_COMPLETED;
		}
		
		return null;
	}

	protected void onQmbClinicianTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		HcpLiteVoCollection coll = domain.listClinicians("%" + value + "%");
		
		form.qmbClinician().clear();
		
		for (int i = 0; i < coll.size(); i++)
		{
			// 	 WDEV-8204
			form.qmbClinician().newRow(coll.get(i), coll.get(i).getName().toString());//.getSurname() + " " + coll.get(i).getName().getForename());
		}
		
		if(coll.size() == 1)
		{
			form.qmbClinician().setValue(coll.get(0));
		}
		else if(coll.size() > 1)
		{
			form.qmbClinician().showOpened();
		}
	}
	
	protected void onQmbResultTypeTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		//InvestigationIndexLiteVoCollection coll = domain.listExams("%" + value + "%");
		InvestigationIndexLiteVoCollection coll = domain.listExamsSynonyms( value, form.GrpCriteria().getValue().equals(GrpCriteriaEnumeration.rdoBegins));
		
		form.qmbResultType().clear();
		
		for (int i = 0; i < coll.size(); i++)
		{
			form.qmbResultType().newRow(coll.get(i), coll.get(i).getName());
		}
		
		if(coll.size() == 1)
		{
			form.qmbResultType().setValue(coll.get(0));
		}
		else if(coll.size() > 1)
		{
			form.qmbResultType().showOpened();
		}
	}
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().OCRR.setLastUpdatedPathRadResult(null);
		//WDEV-19389 
		if (doSearch())
			form.getGlobalContext().OCRR.setRadiologyOrdersResultsSearchCriteria(getSearchCriteria());
	}
	private boolean doSearch()
	{
		form.grdClinicalImaging().getRows().clear();
		
		DateTime dt1 = null;
		DateTime dt2 = null;

		if(form.dteFrom().getValue() != null && form.dteTo().getValue() == null)
		{
			engine.showMessage("A 'To' date must be entered.");
			return false;
		}

		if(form.dteFrom().getValue() == null && form.dteTo().getValue() != null)
		{
			engine.showMessage("A 'From' date must be entered.");
			return false;
		}
		
		if(form.dteFrom().getValue() != null && form.dteTo().getValue() != null)
		{
			if(form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
			{
				engine.showMessage("'From' date must not be after 'To' date.");
				return false;
			}

			Time t1 = new Time(0, 0, 0);
			Time t2 = new Time(23, 59, 50);
			
			dt1 = new DateTime(form.dteFrom().getValue(), t1);
			dt2 = new DateTime(form.dteTo().getValue(), t2);
		}
		
		
		Integer nNewResUnseenDays = new Integer(ConfigFlag.DOM.OCS_NEWRES_UNSEEN_CUTOFF.getValue());
		Date dateUnseen = new Date().addDay(-1 * nNewResUnseenDays.intValue());
		
		RadiologyResultListVoCollection coll = domain.listResults(dt1, dt2, form.cmbDepartment().getValue(), form.qmbResultType().getValue(), form.qmbClinician().getValue(), getInpatientOutpatientSearchType(),  form.Group1().getValue().equals(Group1Enumeration.rdoResults) ? Boolean.TRUE : Boolean.FALSE, form.getGlobalContext().Core.getPatientShortIsNotNull() ? form.getGlobalContext().Core.getPatientShort() : null, form.Group1().getValue().equals(Group1Enumeration.rdoComplete) ? Boolean.TRUE : Boolean.FALSE, form.chkChecked().getValue(), form.chkUnchecked().getValue());
		
		displayResults(coll, dateUnseen);
		return true;
	}
	private void displayResults(RadiologyResultListVoCollection coll, Date dateUnseen)
	{
		OcsPathRadResultVoCollection selectedClinicalResults = form.getGlobalContext().OCRR.getSelectedPathRadResults();
		
		if(selectedClinicalResults == null)
			selectedClinicalResults = new OcsPathRadResultVoCollection();
		else
			selectedClinicalResults.clear();

		for (int i = 0; i < coll.size(); i++)
		{
			Color backColour = ((i % 2) == 0 ? Color.Beige : Color.Default);
			addResult(coll.get(i), dateUnseen, selectedClinicalResults, backColour);
		}

		form.getGlobalContext().OCRR.setSelectedPathRadResults(selectedClinicalResults);
		if(form.grdClinicalImaging().getRows().size() == 0)
		{
			engine.showMessage("No records match your search criteria.");
		}
		updateTotal();
	}
	private void addResult(RadiologyResultListVo result, Date dateUnseen, OcsPathRadResultVoCollection selectedClinicalResults, Color backColour)
	{		
		if(result != null)
		{
			//WDEV-9780
			if(form.getGlobalContext().OCRR.getRoleDisciplineSecurityLevelsIsNotNull())
			{
				ServiceRefVo voInvService =  result.getInvestigationIsNotNull() && result.getInvestigation().getProviderServiceIsNotNull() && result.getInvestigation().getProviderService().getLocationServiceIsNotNull() && result.getInvestigation().getProviderService().getLocationService().getServiceIsNotNull() ? result.getInvestigation().getProviderService().getLocationService().getService() : null;
				SecurityLevelConfigVo voInvSecurityLevel = result.getInvestigationIsNotNull() && result.getInvestigation().getInvestigationIndexIsNotNull() ? result.getInvestigation().getInvestigationIndex().getSecurityLevel() : null;

				if(!form.getGlobalContext().OCRR.getRoleDisciplineSecurityLevels().doesInvPassSecurityCheck(voInvService, voInvSecurityLevel, false)) //WDEV-11622
					return;
			}	
		}

		
		OcsPathRadResultVo res = new OcsPathRadResultVo();
		res.setCategory(Category.CLINICALIMAGING);
		res.setOrderInvestigation(result);
		res.setDescription(result.getInvestigationIsNotNull() && result.getInvestigation().getInvestigationIndexIsNotNull() ? result.getInvestigation().getInvestigationIndex().getName() : "<not set>");
		
		//WDEV-11484
		if(result.getResultDetails() != null && result.getResultDetails().getClinicalResultDetailsIsNotNull())//WDEV-16232
			selectedClinicalResults.add(res);
		
		grdClinicalImagingRow row = form.grdClinicalImaging().getRows().newRow();
		
		row.setValue(res);
		row.setBackColor(backColour);
		
		//display date & time
		if(result.getDisplayDateTimeIsNotNull())
			row.setColDateTime(result.getDisplayDateTime().toString(DateTimeFormat.STANDARD));
		
		if(result.getInvestigationIsNotNull() && result.getInvestigation().getInvestigationIndexIsNotNull())
			row.setColExamName(result.getInvestigation().getInvestigationIndex().getName());
		

		//WDEV-12054
		if(result.getOrdInvXOStatusHistoryIsNotNull())
			row.setTooltipForColExamName(result.getOrdInvXOStatusHistory().generateXoStatusTooltip());
		
		if(result.getInvestigationIsNotNull() && result.getInvestigation().getProviderServiceIsNotNull() && result.getInvestigation().getProviderService().getLocationServiceIsNotNull() && result.getInvestigation().getProviderService().getLocationService().getServiceIsNotNull())
			row.setColDepartment(result.getInvestigation().getProviderService().getLocationService().getService().getServiceName());
		
		if (result.getPatientLocation() != null && LocationType.WARD.equals(result.getPatientLocation().getType()))
		{
			row.setColType("I/P");
		}
		else if (result.getPatientClinic() != null || result.getOrderDetails().getOutpatientDept() != null)
		{
			row.setColType("O/P");
		}
		

		if(result.getOrderDetailsIsNotNull())
		{
			row.setColOrderingLocation(result.getOrderDetails().getCorrectLocation());
			//WDEV-2908 
			row.setTooltipForColOrderingLocation(result.getOrderDetails().getCorrectLocation());
		}

		if(result.getOrderDetailsIsNotNull())
		{
			row.setColClinician(result.getOrderDetails().getCorrectClinician());
			//WDEV-2908 
			row.setTooltipForColClinician(result.getOrderDetails().getCorrectClinician());
		}
		
		
		if(result.getResultStatusIsNotNull())
		{
			//row.setColStatus(domain.getMappingForResultStatextul tusLookup(result.getResultStatus(), TaxonomyType.DISPLAY_TEXT));//WDEV-15709
			row.setColStatus(result.getResultStatus().getText());// 	WDEV-15783
		}
		
		if(result.getDisplayFlagIsNotNull())
		{
			row.setColImage(result.getDisplayFlag().getIItemImage());
			row.setTooltipForColImage(result.getDisplayFlag().getText());
		}
		
		// Status
		String szTooltip = "";
		if (result.getOrdInvCurrentStatusIsNotNull() && result.getOrdInvCurrentStatus().getOrdInvStatusIsNotNull())
		{
			OrderInvStatus currStat = result.getOrdInvCurrentStatus().getOrdInvStatus();
		
			Image image = currStat.getImage();
			szTooltip = generateStatusTooltip(result.getOrdInvCurrentStatus());
			
			//WDEV-16679
			if (currStat.equals(OrderInvStatus.REVIEW) && result.getAllocatedHCPforReview() != null)
			{
				szTooltip = (szTooltip + "<br><b>Review HCP: </b>" + result.getAllocatedHCPforReview().toString());
			}

			if (result.getRepDateTimeIsNotNull() && dateUnseen != null)
			{
				if (currStat.equals(OrderInvStatus.NEW_RESULT) ||
					currStat.equals(OrderInvStatus.UPDATED_RESULT))
				{
					if (result.getRepDateTime().getDate().isLessThan(dateUnseen))
					{
						row.setBold(true);
						szTooltip = (szTooltip + "<br>Unseen");
					}
				}
				else if (currStat.equals(OrderInvStatus.REVIEW))
				{
					if (result.getOrdInvCurrentStatus().getChangeDateTime().getDate().isLessThan(dateUnseen))
					{
						row.setBold(true);
						szTooltip = (szTooltip + "<br>Requires Attention");
					}
				}
			}
			
			row.setColInvStatus(image);
			row.setTooltipForColInvStatus(szTooltip);
		}
		
		// WDEV-13872
		// Display last comment (with Authoring HCP & Authoring Date + Correction HCP, Correction Date + Correction Reason) 
		if (result.getResultConclusionCommentsIsNotNull() && result.getResultConclusionComments().size() > 0)
		{
			ResultCommentsLiteVoCollection comments = result.getResultConclusionComments();
			
			comments.sort(SortOrder.DESCENDING);
			ResultCommentsLiteVo lastComment = comments.get(0);

			szTooltip += "<br><b>Last Annotation Comment: " + lastComment.getAuthoringInformation().getAuthoringDateTime().toString() + " ";
			szTooltip += lastComment.getAuthoringInformation().getAuthoringHcp().getName().toString() + ":</b> " + lastComment.getComment();
			
			// WDEV-13872 - Append correction
			if (lastComment.getCorrectingDateTimeIsNotNull())
			{
				szTooltip += "<br><b>Corrected " + lastComment.getCorrectingDateTime().toString() + " ";
				szTooltip += lastComment.getCorrectingHcp().getName().toString() + ":</b> " + lastComment.getCorrectionReason();
			}

			row.setTooltipForColInvStatus(szTooltip);
		}
		
		if(result.getAppointmentDateIsNotNull()){
			if(ConfigFlag.UI.HIDE_APPOINTMENT_TIME_FOR_RADIOLOGY.getValue())
				row.setColApptDate(result.getAppointmentDate().getDate().toString());
			else
				row.setColApptDate(result.getAppointmentDate().toString());
		}
	}

	private String generateStatusTooltip(OrderedInvestigationStatusClinicalImagingVo ordInvCurrentStatus)
	{
		if (ordInvCurrentStatus != null && ordInvCurrentStatus.getOrdInvStatus() != null)
		{
			StringBuffer sb =  new StringBuffer();
			sb.append("<b>Current status: </b>" + ordInvCurrentStatus.getOrdInvStatus().getText());
			
			if (ordInvCurrentStatus.getStatusReason() != null && ordInvCurrentStatus.getStatusReason().length() > 0 && ordInvCurrentStatus.getOrdInvStatus().equals(OrderInvStatus.CANCELLED))
				sb.append("<br><b>Current status reason: </b>" + ordInvCurrentStatus.getStatusReason());
			
			sb.append("<br><b>Date changed: </b>" + ordInvCurrentStatus.getChangeDateTime());
			sb.append("<br><b>Changed by: </b>" + (ordInvCurrentStatus.getChangeUserIsNotNull() ? ordInvCurrentStatus.getChangeUser().toString() : ""));
			
			return sb.toString();
		}
		return null;
	}
	
	private void updateTotal()
	{
		StringBuffer total = new StringBuffer();
		total.append("<b>");
		total.append("Total: ");		
		total.append(form.grdClinicalImaging().getRows().size());
		total.append("</b>");
		form.grdClinicalImaging().setFooterValue(total.toString());		
	}

	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearchCriteria();
		form.grdClinicalImaging().getRows().clear();
		updateTotal();
		
		form.getGlobalContext().OCRR.setRadiologyOrdersResultsSearchCriteria(null);//WDEV-19389 
	}
	private void clearSearchCriteria()
	{
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.qmbClinician().clear();
		form.cmbDepartment().setValue(null);
		form.qmbResultType().clear();
		form.Group1().setValue(Group1Enumeration.rdoAll);
		form.GroupInpatientOutpatient().setValue(GroupInpatientOutpatientEnumeration.rdoIPOPAll);
		form.chkChecked().setValue(null);
		form.chkUnchecked().setValue(null);
	}
	protected void onGrdClinicalImagingSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (hasResults(form.grdClinicalImaging().getSelectedRow()))
		{
			viewResults();
		}
		else
		{
			viewSelectedOrder();
		}		
	}
	
	private void viewSelectedOrder()
	{
		form.getGlobalContext().OCRR.setCurrentPathRadResult(form.grdClinicalImaging().getValue());
		RadiologyResultListVo res = (RadiologyResultListVo)form.grdClinicalImaging().getValue().getOrderInvestigation();
		form.getGlobalContext().OCRR.PathologyResults.setOrder(res.getOrderDetails());
		form.getGlobalContext().OCRR.setLastUpdatedPathRadResult(null);
		
		//WDEV-11097
		if(AuthorisationOrderStatus.AWAITING_AUTHORISATION.equals(res.getOrderDetails().getAuthorisationOrderStatus()))
		{
			form.getGlobalContext().OCRR.setOrderAwaitingAuthorisation(res.getOrderDetails());
		}
		
		engine.open(form.getForms().OCRR.OrderSummaryDialog);
	}
	
	private boolean hasResults(grdClinicalImagingRow selectedRow)
	{
		RadiologyResultListVo res = (RadiologyResultListVo)selectedRow.getValue().getOrderInvestigation();
		return (res.getResultDetails() != null && res.getResultDetails().getClinicalResultDetails() != null);//WDEV-16232
	}
	
	protected void loadCmbDepartment()
	{
		ServiceLiteVoCollection coll = domain.listServices("%%%", ServiceCategory.RADIOLOGY_MODALITY);
		
		form.cmbDepartment().clear();
		
		for (int i = 0; i < coll.size(); i++)
		{
			form.cmbDepartment().newRow(coll.get(i), coll.get(i).getServiceName());
		}
	}
	private void viewResults()
	{
		form.getGlobalContext().OCRR.setCurrentPathRadResult(form.grdClinicalImaging().getValue());
		form.getGlobalContext().OCRR.setLastUpdatedPathRadResult(null);
		engine.open(form.getForms().OCRR.ResultDialog, false);
	}
}
