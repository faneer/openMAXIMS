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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40629.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.careplanoverview;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTimeFormat;
import ims.nursing.vo.CarePlanOverview;
import ims.nursing.vo.CarePlanOverviewCollection;
import ims.nursing.vo.CarePlanOverviewSearchCriteriaVo;
import ims.nursing.vo.CarePlanStatus;
import ims.nursing.vo.CarePlanStatusCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		//WDEV-13535 set default status 
		defaultcbFilterLookupValue();
		
		boolean isCcoSpecific = ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().equals("CCO");
		if(!isCcoSpecific)
			form.cbFilter().removeRow(ims.nursing.vo.lookups.CarePlanStatus.ALL_ADMISSIONS);
			
		
		//WDEV-19389 --- start
		if (!(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getGlobalContext().Nursing.getCarePlanOverviewSearchCriteriaIsNotNull() && form.getGlobalContext().Nursing.getCarePlanOverviewSearchCriteria().getCareContextIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().equals(form.getGlobalContext().Nursing.getCarePlanOverviewSearchCriteria().getCareContext())))
			form.getGlobalContext().Nursing.setCarePlanOverviewSearchCriteria(null);
		
		if(form.getGlobalContext().Nursing.getCarePlanOverviewSearchCriteriaIsNotNull())
		{
			setSearchCriteria(form.getGlobalContext().Nursing.getCarePlanOverviewSearchCriteria());
		}
		
		//WDEV-19389 --- end
		
		listCarePlans();
		//wdev-13495
		if(engine.isRIEMode())
			form.gridCarePlans().setSelectable(false);
		else
			form.gridCarePlans().setSelectable(true);
		updateControlsState();//WDEV-14924
		
	}
	
	private CarePlanOverviewSearchCriteriaVo getSearchCriteria()
	{
		CarePlanOverviewSearchCriteriaVo searchCriteria = new CarePlanOverviewSearchCriteriaVo();
		
		searchCriteria.setView(form.cbFilter().getValue());
		searchCriteria.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		return searchCriteria;
	}
	
	
	private void setSearchCriteria(CarePlanOverviewSearchCriteriaVo carePlanOverviewSearchCriteriaVo)
	{
		form.cbFilter().setValue(carePlanOverviewSearchCriteriaVo.getView());	
		listCarePlans();
		updateControlsState();
	}
	
	//WDEV-14924
	private void updateControlsState()
	{
		form.btnViewAndCopy().setVisible(!currentEpisodeHaveCarePlans());
		
	}
	
	//WDEV-14924
	private boolean currentEpisodeHaveCarePlans()
	{
		try 
		{
				CarePlanOverviewCollection coll = domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext(), null, false);
				if (coll==null || coll.size()==0)
					return false;
				return true;
		} 
		catch (DomainInterfaceException e) 
		{
			throw new DomainRuntimeException("DomainInterfaceException occurred listing careplans.\r\n" + e.getMessage(), e);
		}
		
		
	}

	protected void onCFilterValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		listCarePlans();
	}
	protected void onGCarePlansSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// Put the CarePlanId into the global context and call the careplan details form
		form.getGlobalContext().COE.setCarePlanID(form.gridCarePlans().getValue().getID_CarePlan());
		engine.open(form.getForms().Nursing.CarePlanDetails);
	}
	
	/**
	 * Method to list the careplans for the current episode
	 * it will list either all or active.
	 *
	 */
	private void listCarePlans()
	{
		CarePlanOverviewCollection coll = null;
		CarePlanOverviewCollection collOtherCarePlans = null;
		
		CarePlanStatus statusFilter = new CarePlanStatus();
		if(form.cbFilter().getValue()!=null)
			statusFilter.setStatus(form.cbFilter().getValue());
		else{
			engine.showMessage("Please select a Filter.");
			form.getGlobalContext().Nursing.setCarePlanOverviewSearchCriteria(null);//WDEV-19389 
			return;
		}
		
		try 
		{
			if(form.cbFilter().getValue().equals(ims.nursing.vo.lookups.CarePlanStatus.ALL)){
				coll = domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext(), null, false);
			}
			else if(form.cbFilter().getValue().equals(ims.nursing.vo.lookups.CarePlanStatus.ALL_ADMISSIONS)){
				boolean isCcoSpecific = ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().equals("CCO");
				if(isCcoSpecific){
					collOtherCarePlans = domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext(), null, true);
					coll = domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext(), null, false);
				}
			}
			else
				coll = domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext(), statusFilter, false);
		} 
		catch (DomainInterfaceException e) 
		{
			throw new DomainRuntimeException("DomainInterfaceException occurred listing careplans.\r\n" + e.getMessage(), e);
		}
		
		form.gridCarePlans().getRows().clear();
		populateCarePlansGrid(coll, false);
		form.gridCarePlans().sort(4, SortOrder.ASCENDING);
		populateCarePlansGrid(collOtherCarePlans, true);	
		form.getGlobalContext().Nursing.setCarePlanOverviewSearchCriteria(getSearchCriteria());//WDEV-19389 
	}
	private void populateCarePlansGrid(CarePlanOverviewCollection coll, boolean bOtherCarePlans) {
		if (coll != null)
		{
			GenForm.gridCarePlansRow row;
			for (int i=0; i<coll.size(); i++)
			{
				CarePlanOverview overview = coll.get(i);
				row = form.gridCarePlans().getRows().newRow();
				row.setValue(overview);
				row.setcolCarePlanTitle(overview.getTitle());
				if(overview!=null && overview.getCarePlanStatusIsNotNull())
				{
					for(int x=0; x<overview.getCarePlanStatus().size(); x++)
					{
						overview.getCarePlanStatus().sort(SortOrder.ASCENDING);
						if(overview.getCarePlanStatus().get(x).getStatus().equals(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE))
						{
							if(overview.getCarePlanStatus().get(x).getDateTime().getDate() != null)
								row.setcolInitiatedOn(overview.getCarePlanStatus().get(x).getDateTime().getDate());
							
							if(overview.getCarePlanStatus().get(x).getHCP() != null)
							{
								if(overview.getCarePlanStatus().get(x).getHCP().getName() != null)
									row.setcolInitiateBy(overview.getCarePlanStatus().get(x).getHCP().getName().toShortForm());
							}
							break; //you could have a number of actives, i.e.active,then suspended,then active, you want
								   //the first active, so ASCENDING - get first active - need break.
						}
					}
				}
				if (overview.getCurrentCarePlanStatus()!=null && overview.getCurrentCarePlanStatus().getStatus().equals(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE) && !bOtherCarePlans)
				{
					if (overview.getNextEvaluationDate() != null)
						row.setcolNextEvaluation(overview.getNextEvaluationDate());
				
					// If the careplan evaluation is due today, we want to set the row green
					if (overview.getNextEvaluationDate() != null && overview.getNextEvaluationDate().equals(new ims.framework.utils.Date()))
						row.setBackColor(Color.Orange);
					// If the careplan is overdue, we want to set the row red
					if (overview.getNextEvaluationDate() != null && overview.getNextEvaluationDate().isLessThan(new ims.framework.utils.Date()))
						row.setBackColor(Color.LightCoral);
				}
				
				if(bOtherCarePlans){
					if (overview.getNextEvaluationDate() != null)
						row.setcolNextEvaluation(overview.getNextEvaluationDate());
					
					row.setBackColor(Color.LightSlateGray);
				}
				
				if(overview.getCurrentCarePlanStatus()!=null)
					row.setcolStatus(overview.getCurrentCarePlanStatus().getStatus().getText());
				row.setTooltipForcolStatus(fillToolTip(overview.getCarePlanStatus()));
			}
		}
	}
	private String fillToolTip(CarePlanStatusCollection voCarePlanStatusCollection)
	{
		StringBuffer tooltip = new StringBuffer();
	    tooltip.append("<p align=\"center\"><font color=\"#FF0000\"><b>CARE PLAN STATUS</b></font>&nbsp;</p>");
	    final String newLine = "<br>";
	    CarePlanStatus voCarePlanStatus;
	    if(voCarePlanStatusCollection != null)
	    {
	    	voCarePlanStatusCollection.sort(SortOrder.ASCENDING);
	        for(int i=0; i<voCarePlanStatusCollection.size(); i++)
	        {
	        	voCarePlanStatus = voCarePlanStatusCollection.get(i);
	           if(voCarePlanStatus.getDateTimeIsNotNull())
	            {
	                tooltip.append("<b>" + "Date/Time: " + "</b>" + voCarePlanStatus.getDateTime().toString(DateTimeFormat.STANDARD) + "</b>");
	            }
	            if(voCarePlanStatus.getHCPIsNotNull())
	            {
	            	tooltip.append(newLine);
	                tooltip.append("<b>" + "HCP: " + "</b>" + voCarePlanStatus.getHCP().getMos().getName().toString());
	            }
	            else
	            {
	            	tooltip.append(newLine);
	                tooltip.append("<b>" + "HCP: " + "</b>");
	            }
	            if(voCarePlanStatus.getStatusIsNotNull())
	            {
	                tooltip.append(newLine);
	                tooltip.append("<b>" + "Status: " + "</b>" + voCarePlanStatus.getStatus().toString());
	            }
	       
	            tooltip.append(newLine);
	            tooltip.append(newLine);
	        }
	    }
        return tooltip.toString();
	}
	//WDEV-14924
	@Override
	protected void onBtnViewAndCopyClick() throws PresentationLogicException
	{
		Object hcpUser = domain.getHcpLiteUser();
		if (hcpUser ==null)
		{
			engine.showMessage("User must be of type HCP.");
			return ;
		}
		
		if (currentEpisodeHaveCarePlans())
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			listCarePlans();
			updateControlsState();
			return ;
		}
		
		engine.open(form.getForms().Nursing.CopyCarePlans);	 	
	}

	//WDEV-14924
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		listCarePlans();
		updateControlsState();
		
	}
}

