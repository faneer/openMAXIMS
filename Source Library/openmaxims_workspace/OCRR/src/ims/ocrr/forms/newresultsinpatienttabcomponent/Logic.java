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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.newresultsinpatienttabcomponent;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.LocationType;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Date;
import ims.ocrr.forms.newresultsinpatienttabcomponent.GenForm.ListResultsByEnumeration;
import ims.ocrr.forms.newresultsinpatienttabcomponent.GenForm.grdDisciplinesRow;
import ims.ocrr.vo.NewResultsCriteriaVo;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int INPATIENT = 3;

	@Override
	protected void onImbAddDisciplineClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().OCRR.setSelectedDisciplines(getDisciplines());
		engine.open(form.getForms().OCRR.SearchDisciplines);
	}
	
	public void initialize()
	{
		clear();
		
		Object hcp = domain.getHcpLiteUser();
		if(hcp instanceof HcpLiteVo)
		{
			form.getLocalContext().setCurrentHCP((HcpLiteVo) hcp);
		}
		
		populateHospital();
		populateWard();
		
		form.chkCurrentInpatientsOnly().setValue(true);
		form.chkInpatientOrdersPatientDischarged().setValue(true);
		
		form.ccResponsibleHCP().initializeResponsibleHcp(MosType.HCP, true);
		
		form.chkOrder().setValue(true);
		form.chkCurrentIP().setValue(true);
		
		form.chkNew().setValue(true);
		form.chkSeenChecked().setValue(false);
		form.chkChecked().setValue(false);
		form.chkReview().setValue(true);
		form.chkCompleted().setVisible(ConfigFlag.UI.DISPLAY_COMPLETE_FILTER_RESULTS_STATUS.getValue());//wdev-17322
		form.chkCompleted().setValue(ConfigFlag.UI.DISPLAY_COMPLETE_FILTER_RESULTS_STATUS.getValue());//wdev-17322
		
		populateDays(ConfigFlag.DOM.OCS_NEWRES_DAYS_MAX.getValue());
		resetDaysToDefault();
		
		form.ListResultsBy().setValue(ListResultsByEnumeration.rdoNewestFirst);
		
		updateControlsState();
	}

	private void populateWard() 
	{
		ILocation loc = engine.getCurrentLocation();
		
		if(loc instanceof LocationLiteVo)
		{
			LocationLiteVo locLite = (LocationLiteVo) loc;
			if(LocationType.WARD.equals(locLite.getType()))
			{
				form.qmbOrderingLocation().newRow(locLite, locLite.getName());
				form.qmbOrderingLocation().setValue(locLite);
			}
		}
	}

	private void resetDaysToDefault() 
	{
		form.cmbDays().setValue(new Integer(ConfigFlag.DOM.OCS_NEWRES_DAYS_DEFAULT.getValue()));
		calculateAndSetDateRange();
	}
	
	private void calculateAndSetDateRange()
	{
		if (form.cmbDays().getValue() != null)
		{
			int days = form.cmbDays().getValue().intValue();
			form.dteTo().setValue(new Date());
			form.dteFrom().setValue(new Date().addDay(-1 * days));
		}
	}

	private void populateHospital() 
	{
		form.cmbHospital().clear();
		
		LocationLiteVoCollection hospColl = domain.listHospitals();
		
		if(hospColl == null)
			return;
		
		for (int i = 0; i < hospColl.size(); i++)
		{
			LocationLiteVo hosp = hospColl.get(i);
			form.cmbHospital().newRow(hosp, hosp.getName());
		}
		
		LocationLiteVo currentHospital = domain.getCurrentHospital(engine.getCurrentLocation());
		form.cmbHospital().setValue(currentHospital);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(form.getForms().OCRR.SearchDisciplines.equals(formName))
		{
			if(DialogResult.OK.equals(result))
			{
				populateDisciplineGrid(form.getGlobalContext().OCRR.getSelectedDisciplines());
			}
		}
	}

	private void populateDisciplineGrid(ServiceLiteVoCollection disciplines) 
	{
		form.grdDisciplines().getRows().clear();
		
		if(disciplines == null)
			return;
		
		for(ServiceLiteVo dis : disciplines)
		{
			if(dis == null)
				continue;
			
			if(!disciplineIsAdded(dis))
			{
				grdDisciplinesRow newRow = form.grdDisciplines().getRows().newRow();
				newRow.setColDis(dis.getServiceName());
			
				newRow.setValue(dis);
			}
		}
	}

	private boolean disciplineIsAdded(ServiceLiteVo dis) 
	{
		if(dis == null)
			return false;
		
		for(int i=0; i<form.grdDisciplines().getRows().size(); i++)
		{
			if(dis.equals(form.grdDisciplines().getRows().get(i).getValue()))
				return true;
		}
		
		return false;
	}

	@Override
	protected void onGrdDisciplinesSelectionChanged() throws PresentationLogicException 
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.qmbOrderingLocation().setEnabled(form.cmbHospital().getValue() != null);
		form.ccResponsibleHCP().setEnabled(form.chkOrder().getValue() || form.chkCurrentIP().getValue());
		
		boolean isResponsibleChecked = true;
		
		form.lblResponsibleHCPFor().setVisible(isResponsibleChecked);
		form.chkOrder().setVisible(isResponsibleChecked);
		form.chkCurrentIP().setVisible(isResponsibleChecked);
		form.lblHCP().setVisible(isResponsibleChecked);
		form.ccResponsibleHCP().setVisible(isResponsibleChecked);
		form.lblReviewingHCP().setVisible(isResponsibleChecked);
		form.qmbReviewingHCP().setVisible(isResponsibleChecked);
		
		if(!form.chkOrder().getValue() && !form.chkCurrentIP().getValue())
		{
			form.ccResponsibleHCP().clear();
		}
		
		form.imbRemoveDiscipline().setEnabled(form.grdDisciplines().getValue() != null);
		form.chkAbnormalPathologyResultsOnly().setVisible(Boolean.TRUE.equals(ConfigFlag.UI.SHOW_ABNORMAL_RESULTS_SEARCH_FILTER.getValue()));
	}

	@Override
	protected void onImbRemoveDisciplineClick()	throws PresentationLogicException 
	{
		removeDiscipline();
		updateControlsState();
	}

	private void removeDiscipline() 
	{
		if(form.grdDisciplines().getSelectedRowIndex() < 0)
			return;
		
		form.grdDisciplines().getRows().remove(form.grdDisciplines().getSelectedRowIndex());
	}
	
	private void populateDays(int maxDays)
	{
		form.cmbDays().clear();
		for (int x = 1; x <= maxDays; x++)
		{
			form.cmbDays().newRow(new Integer(x), String.valueOf(x));
		}
	}

	public NewResultsCriteriaVo getValue() 
	{
		NewResultsCriteriaVo newResultsSearchCriteria = new NewResultsCriteriaVo();
		
		//newResultsSearchCriteria.setInpatientOrders(true);
		
		newResultsSearchCriteria.setSelectedTab(INPATIENT);
		
		newResultsSearchCriteria.setHospital(form.cmbHospital().getValue());
		newResultsSearchCriteria.setInpatientHospital(form.cmbHospital().getValue());
		
		newResultsSearchCriteria.setInpatientWard(form.qmbOrderingLocation().getValue());
		
		newResultsSearchCriteria.setCurrentInpatientsOnly(form.chkCurrentInpatientsOnly().getValue());
		newResultsSearchCriteria.setInpatientOrdersPatientDischarged(form.chkInpatientOrdersPatientDischarged().getValue());
		
		newResultsSearchCriteria.setOrder(form.chkOrder().getValue());
		newResultsSearchCriteria.setCurrenIP(form.chkCurrentIP().getValue());
		newResultsSearchCriteria.setHCP(form.ccResponsibleHCP().getValue());
		
		newResultsSearchCriteria.setReviewingHCP(form.qmbReviewingHCP().getValue());
		
		newResultsSearchCriteria.setNewUpdated(form.chkNew().getValue());
		newResultsSearchCriteria.setSeenChecked(form.chkSeenChecked().getValue());
		newResultsSearchCriteria.setChecked(form.chkChecked().getValue());
		newResultsSearchCriteria.setForReview(form.chkReview().getValue());
		newResultsSearchCriteria.setCompleted(form.chkCompleted().getValue());
	
		newResultsSearchCriteria.setFromDate(form.dteFrom().getValue());
		newResultsSearchCriteria.setToDate(form.dteTo().getValue());	
		newResultsSearchCriteria.setDays(form.cmbDays().getValue());
		newResultsSearchCriteria.setNewestFirst(ListResultsByEnumeration.rdoNewestFirst.equals(form.ListResultsBy().getValue()) ? true : false);
		
		newResultsSearchCriteria.setDiscipline(getDisciplines());
		newResultsSearchCriteria.setAbnormalPathologyResultsOnly(form.chkAbnormalPathologyResultsOnly().getValue());
		
		return newResultsSearchCriteria;
	}

	private ServiceLiteVoCollection getDisciplines() 
	{
		if(form.grdDisciplines().getRows().size() == 0)
			return null;
		
		ServiceLiteVoCollection coll = new ServiceLiteVoCollection();
		
		for(int i=0; i<form.grdDisciplines().getRows().size(); i++)
		{
			coll.add(form.grdDisciplines().getRows().get(i).getValue());
		}
		
		return coll;
	}

	@Override
	protected void onCmbDaysValueChanged() throws PresentationLogicException 
	{
		calculateAndSetDateRange();
	}

	@Override
	protected void onQmbReviewingHCPValueChanged() throws PresentationLogicException 
	{
		if (form.qmbReviewingHCP().getValue() != null)
		{
			form.chkReview().setValue(true);
		}
	}

	@Override
	protected void onQmbReviewingHCPTextSubmited(String value) throws PresentationLogicException 
	{
		populateReviweingHCP(domain.listReviewingHCP(value));
	}
	
	private void populateReviweingHCP(HcpLiteVoCollection reviewingHCPs)
	{
		form.qmbReviewingHCP().clear();
		
		if (reviewingHCPs == null)
			return;
		
		for (HcpLiteVo hcp : reviewingHCPs)
		{
			form.qmbReviewingHCP().newRow(hcp, hcp.getName() != null ? hcp.getName().toString() : "<unknown HCP>");
		}
		
		if (reviewingHCPs.size() != 1)
		{
			form.qmbReviewingHCP().showOpened();
		}
		else if (reviewingHCPs.size() == 1)
		{
			form.qmbReviewingHCP().setValue(reviewingHCPs.get(0));
			form.chkReview().setValue(true);
		}
	}

	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException 
	{
		form.qmbOrderingLocation().clear();
		updateControlsState();
	}

	public String[] validate() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if(!form.chkCurrentInpatientsOnly().getValue() && !form.chkInpatientOrdersPatientDischarged().getValue())
		{
			errors.add("At least one of the options must be selected: \"Current Inpatients Only\" or \"Inpatient Orders - patient discharged\"");
		}
		
		if (form.dteFrom().getValue() != null && form.dteTo().getValue() != null)
		{
			if (form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
			{
				errors.add("The \"From Date\" is after the \"To Date\"");
			}
		}

		if ((form.dteFrom().getValue() == null || form.dteTo().getValue() == null) && form.cmbDays().getValue() == null)
		{
			errors.add("Invalid date range specified.");
		}
		
		if ((form.dteFrom().getValue() == null || form.dteTo().getValue() == null) && form.cmbDays().getValue() != null)
		{
			calculateAndSetDateRange();
		}
		
		if (form.qmbReviewingHCP().getValue() != null && form.chkReview().getValue() == false)
		{
			errors.add("If Reviewing HCP is selected, 'For Review' status must be checked.");
		}

		if (form.chkNew().getValue() == false && form.chkSeenChecked().getValue() == false && form.chkChecked().getValue() == false && form.chkReview().getValue() == false && form.chkCompleted().getValue() == false)
		{
			errors.add("At least one of the checkboxes for Result Status must be checked");
		}
		
		if(errors != null && errors.size() > 0)
		{
			String[] errorsS = new String[errors.size()];
			errors.toArray(errorsS);
			
			return errorsS;
		}
		
		return null;
	}

	public void setEnabled(Boolean value) 
	{
		boolean val = Boolean.TRUE.equals(value);
		
		form.cmbHospital().setEnabled(val);
		form.qmbOrderingLocation().setEnabled(val);
		form.chkCurrentInpatientsOnly().setEnabled(val);
		form.chkInpatientOrdersPatientDischarged().setEnabled(val);
		form.chkOrder().setEnabled(val);
		form.chkCurrentIP().setEnabled(val);
		form.ccResponsibleHCP().setEnabled(val);
		form.qmbReviewingHCP().setEnabled(val);
		form.chkNew().setEnabled(val);
		form.chkSeenChecked().setEnabled(val);
		form.chkChecked().setEnabled(val);
		form.chkReview().setEnabled(val);
		form.chkCompleted().setEnabled(val);
		form.dteFrom().setEnabled(val);
		form.dteTo().setEnabled(val);
		form.cmbDays().setEnabled(val);
		form.ListResultsBy().setEnabled(val);
		form.grdDisciplines().setEnabled(val);
		form.imbAddDiscipline().setEnabled(val);
		form.imbRemoveDiscipline().setEnabled(val);
		form.chkAbnormalPathologyResultsOnly().setEnabled(val);
		
		if(value)
			updateControlsState();
	}

	public void clear() 
	{
		form.cmbHospital().setValue(null);
		form.qmbOrderingLocation().setEnabled(false);
		form.qmbOrderingLocation().setValue(null);
		form.chkCurrentInpatientsOnly().setValue(null);
		form.chkInpatientOrdersPatientDischarged().setValue(null);
		form.chkOrder().setValue(null);
		form.chkCurrentIP().setValue(null);
		form.ccResponsibleHCP().clear();
		form.qmbReviewingHCP().clear();				

		form.chkNew().setValue(false);
		form.chkSeenChecked().setValue(false);
		form.chkChecked().setValue(false);
		form.chkReview().setValue(false);	
		form.chkCompleted().setValue(false); 
		
		form.grdDisciplines().getRows().clear();
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.cmbDays().setValue(null);
		
		form.ListResultsBy().setValue(ListResultsByEnumeration.rdoNewestFirst);
		form.chkAbnormalPathologyResultsOnly().setValue(null);
	}

	@Override
	protected void onChkCurrentIPValueChanged()	throws PresentationLogicException 
	{
		updateControlsState();
	}

	@Override
	protected void onChkOrderValueChanged() throws PresentationLogicException 
	{
		updateControlsState();
	}

	@Override
	protected void onQmbOrderingLocationTextSubmited(String value) throws PresentationLogicException 
	{
		searchLocations(value);
	}
	
	private void searchLocations(String value)
	{
		if (value == null)
			return;

		form.qmbOrderingLocation().clear();

		LocationLiteVoCollection locations = domain.listWards(value, form.cmbHospital().getValue());

		if (locations != null)
		{
			for (int x = 0; x < locations.size(); x++)
			{
				addLocation(locations.get(x));
			}
		}

		if (locations != null && locations.size() > 1)
			form.qmbOrderingLocation().showOpened();
		else if (locations != null && locations.size() == 1)
			form.qmbOrderingLocation().setValue(locations.get(0));
	}
	
	private void addLocation(LocationLiteVo location)
	{
		addLocation(location, false);
	}

	private void addLocation(LocationLiteVo location, boolean select)
	{
		if (location == null)
			return;
		
		form.qmbOrderingLocation().newRow(location, location.getNameIsNotNull() ? location.getName() : "<unknown>");
		
		if (select)
			form.qmbOrderingLocation().setValue(location);
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		// Nothing to do here for a component
		// Keep this event handler (even if empty) as it is needed for data binding
	}

	public void setValue(NewResultsCriteriaVo criteria) 
	{
		clear();
		
		if(criteria == null)
			return;
		
		form.cmbHospital().setValue(criteria.getHospital());
		
		if(criteria.getInpatientWard() != null)
		{
			form.qmbOrderingLocation().newRow(criteria.getInpatientWard(), criteria.getInpatientWard().toString());
			form.qmbOrderingLocation().setValue(criteria.getInpatientWard());
		}
		
		form.chkCurrentInpatientsOnly().setValue(criteria.getCurrentInpatientsOnly());
		form.chkInpatientOrdersPatientDischarged().setValue(criteria.getInpatientOrdersPatientDischarged());
		
		form.chkOrder().setValue(criteria.getOrder());
		form.chkCurrentIP().setValue(criteria.getCurrenIP());
		
		form.ccResponsibleHCP().setValue(criteria.getHCP());
		
		if (criteria.getReviewingHCP() != null && !form.qmbReviewingHCP().getValues().contains(criteria.getReviewingHCP()))
		{
			form.qmbReviewingHCP().newRow(criteria.getReviewingHCP(), criteria.getReviewingHCP().toString());
		}
		form.qmbReviewingHCP().setValue(criteria.getReviewingHCP());			

		form.chkNew().setValue(criteria.getNewUpdated());
		form.chkSeenChecked().setValue(criteria.getSeenChecked());
		form.chkChecked().setValue(criteria.getChecked());
		form.chkReview().setValue(criteria.getForReview());	
		form.chkCompleted().setValue(criteria.getCompleted()); 
		
		populateDisciplineGrid(criteria.getDiscipline());
		
		form.dteFrom().setValue(criteria.getFromDate());
		form.dteTo().setValue(criteria.getToDate());
		form.cmbDays().setValue(criteria.getDays());
		
		form.ListResultsBy().setValue(Boolean.TRUE.equals(criteria.getNewestFirst()) ? ListResultsByEnumeration.rdoNewestFirst : ListResultsByEnumeration.rdoOldestFirst );
		form.chkAbnormalPathologyResultsOnly().setValue(criteria.getAbnormalPathologyResultsOnly());
		
		updateControlsState();
	}

	@Override
	protected void onDteToValueChanged() throws PresentationLogicException 
	{
		if (form.dteTo().getValue() != null)
		{
			form.cmbDays().setValue(null);
			if (form.dteFrom().getValue() == null)
				form.dteFrom().setValue(form.dteTo().getValue());
		}
	}

	@Override
	protected void onDteFromValueChanged() throws PresentationLogicException 
	{
		if (form.dteFrom().getValue() != null)
		{
			form.cmbDays().setValue(null);
			if (form.dteTo().getValue() == null)
				form.dteTo().setValue(form.dteFrom().getValue());
		}
	}

	public SortOrder getSortOrder() 
	{
		if(ListResultsByEnumeration.rdoNewestFirst.equals(form.ListResultsBy().getValue()))
			return SortOrder.DESCENDING;
		else if(ListResultsByEnumeration.rdoOldestFirst.equals(form.ListResultsBy().getValue()))
			return SortOrder.ASCENDING;
		
		return SortOrder.DESCENDING;
	}
}
