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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.65 build 3198.21681)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.referraloverviewandkpis;

import ims.RefMan.forms.referraloverviewandkpis.GenForm.grdLinkedReferralsRow;
import ims.RefMan.forms.referraloverviewandkpis.GenForm.grdReferralStatusRow;
import ims.RefMan.vo.CatsReferralForLinkRefVo;
import ims.RefMan.vo.CatsReferralForOverviewVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralStatusVo;
import ims.RefMan.vo.CatsReferralStatusVoCollection;
import ims.RefMan.vo.LinkedCatsReferralForLinkRefVo;
import ims.RefMan.vo.LinkedCatsReferralForLinkRefVoCollection;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.RefMan.vo.lookups.ReferralRelationType;
import ims.RefMan.vo.lookups.ReferralUrgency;
import ims.core.vo.lookups.SourceOfReferral;
import ims.framework.enumerations.SortOrder;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}
	
	private void open()
	{
		if(form.getLocalContext().getCurrentCatsReferralIsNotNull() && form.getLocalContext().getCurrentCatsReferral().getID_CatsReferralIsNotNull())
		{
			CatsReferralForOverviewVo catsReferralFull = domain.getCatsReferral(form.getLocalContext().getCurrentCatsReferral());
			
			form.getLocalContext().setCatsReferralFull(catsReferralFull);
			populateScreenFromData(catsReferralFull);
			
			updateControlsState(catsReferralFull); //WDEV-20944
		}
		
		
	}

	private void updateControlsState(CatsReferralForOverviewVo catsReferralFull) //WDEV-20944
	{
		boolean isEmergencyReferral = catsReferralFull!=null && (Boolean.TRUE.equals(catsReferralFull.getIsEmergencyReferral()) || ReferralUrgency.EMERGENCY.equals(catsReferralFull.getUrgency()));
		
		form.pnlRTTDetails().setVisible(!isEmergencyReferral);
		form.lblPathwayIDLabel().setVisible(!isEmergencyReferral);
		form.lblPathwayID().setVisible(!isEmergencyReferral);
		form.lblRTTCurrentStatusLabel().setVisible(!isEmergencyReferral);
		form.lblRTTCurrentStatus().setVisible(!isEmergencyReferral);
		form.lblRTTBreachDateLabel().setVisible(!isEmergencyReferral);
		form.lblRTTBreachDate().setVisible(!isEmergencyReferral);
		form.lbl31DayTargetLabel().setVisible(!isEmergencyReferral);
		form.lbl31DayTarget().setVisible(!isEmergencyReferral);
		form.lbl62DayTargetLabel().setVisible(!isEmergencyReferral);
		form.lbl62DayTarget().setVisible(!isEmergencyReferral);
		
		form.txtUBRN().setEnabled(false); //WDEV-22873
	}

	private void populateScreenFromData(CatsReferralForOverviewVo catsReferralFull) 
	{
		clearScreen();
		
		if(catsReferralFull == null)
			return;
		
		form.lblPathwayID().setValue(catsReferralFull.getPathwayID());//wdev-18432
		form.lblUrgency().setValue(catsReferralFull.getUrgency() != null ? catsReferralFull.getUrgency().getText() : null);
		
		if(catsReferralFull.getReferralDetailsIsNotNull())
		{
			form.lblService().setValue(catsReferralFull.getReferralDetails().getService() != null ? catsReferralFull.getReferralDetails().getService().getServiceName() : null);
			form.lblFunction().setValue((catsReferralFull.getReferralDetails().getFunction() != null && catsReferralFull.getReferralDetails().getFunction().getFunction() != null) ? catsReferralFull.getReferralDetails().getFunction().getFunction().getText() : null);
			form.lblResponsibleHCP().setValue((catsReferralFull.getReferralDetails().getConsultant() != null && catsReferralFull.getReferralDetails().getConsultant().getMos() != null && catsReferralFull.getReferralDetails().getConsultant().getMos().getName() != null) ? catsReferralFull.getReferralDetails().getConsultant().getMos().getName().toString() : null);
			
			//WDEV-20383 //WDEV-20686
			if(SourceOfReferral.TRANSFER.equals(catsReferralFull.getReferralDetails().getReferrerType()))
			{
				form.lbl7().setValue("IPT RTT Start Date: ");
				form.lblOriginalReferralDate().setValue(catsReferralFull.getReferralDetails().getOriginalDateOfReferral() != null ? catsReferralFull.getReferralDetails().getOriginalDateOfReferral().toString() : null);
			}
			else 
			{
				form.lbl7().setValue("Original Referral Date: ");
				form.lblOriginalReferralDate().setValue(catsReferralFull.getReferralDetails().getOriginalDateOfReferral() != null ? catsReferralFull.getReferralDetails().getOriginalDateOfReferral().toString() : null);		//wdev-20860
			}
			//WDEV-20686 ends here
			

			//WDEV-22497
			if(catsReferralFull.getICABReferralIsNotNull() && catsReferralFull.getICABReferral().getUBRNIsNotNull())
			{
				form.lbl1UBRNLabel().setVisible(Boolean.TRUE);
				form.txtUBRN().setValue(catsReferralFull.getICABReferral().getUBRN()); //WDEV-22873
			}
			else 
			{
				form.lbl1UBRNLabel().setVisible(Boolean.FALSE);
				form.txtUBRN().setVisible(Boolean.FALSE); //WDEV-22873
			}
			//WDEV-22497 ends here

			form.lblDateOfReferral().setValue(catsReferralFull.getReferralDetails().getDateOfReferralIsNotNull() ? catsReferralFull.getReferralDetails().getDateOfReferral().toString() : null);
			form.lblDateReferralLetter().setValue(catsReferralFull.getReferralDetails().getDateReferralReceivedIsNotNull() ? catsReferralFull.getReferralDetails().getDateReferralReceived().toString() : null);
			
			form.lblRTTBreachDate().setValue(!Boolean.TRUE.equals(catsReferralFull.getIsEmergencyReferral()) && catsReferralFull.getReferralDetails().getEnd18WW() != null ? catsReferralFull.getReferralDetails().getEnd18WW().toString() : null);
		}
		
		if(catsReferralFull.getConsultationApptIsNotNull())
		{
			form.lblConsultationAppointment().setValue((catsReferralFull.getConsultationAppt().getAppointmentDateIsNotNull() ? catsReferralFull.getConsultationAppt().getAppointmentDate().toString(): "") + " " + (catsReferralFull.getConsultationAppt().getApptStartTimeIsNotNull() ? catsReferralFull.getConsultationAppt().getApptStartTime().toString() : "" ));
		}
		
		//WDEV-22688
		if(catsReferralFull.getContractIsNotNull() && catsReferralFull.getContract().getID_ContractConfigIsNotNull() && catsReferralFull.getStatusHistoryIsNotNull())
		{
			form.lblTriage().setValue(searchForStatusTime(catsReferralFull.getStatusHistory()));
		}
		
		String rttCurrentStatus = "";
		String rttCurrentStatusTooltip = "";
		
		if (catsReferralFull.getCurrentRTTStatus() != null && catsReferralFull.getCurrentRTTStatus().getRTTStatusIsNotNull())
		{
			rttCurrentStatus = catsReferralFull.getCurrentRTTStatus().getRTTStatus().getNationalCodeIsNotNull() ? catsReferralFull.getCurrentRTTStatus().getRTTStatus().getNationalCode().toString() + ". " + catsReferralFull.getCurrentRTTStatus().getRTTStatus().getDescription() : catsReferralFull.getCurrentRTTStatus().getRTTStatus().getDescription();
			rttCurrentStatusTooltip = rttCurrentStatus;
			if (rttCurrentStatus.length() > 35)
			{
				rttCurrentStatus = rttCurrentStatus.substring(0,32) + "...";
			}
		}
		
		//WDEV-20686
		/*if (form.getGlobalContext().RefMan.getReferralTransfer() != null && form.getGlobalContext().RefMan.getReferralTransfer().getCurrentRTTStatus() != null && form.getGlobalContext().RefMan.getReferralTransfer().getCurrentRTTStatus().getDescription() != null)
		{
			rttCurrentStatus = form.getGlobalContext().RefMan.getReferralTransfer().getCurrentRTTStatus().getDescription();
			rttCurrentStatusTooltip = rttCurrentStatus;
			if (rttCurrentStatus.length() > 35)
			{
				rttCurrentStatus = rttCurrentStatus.substring(0,32) + "...";
			}
		}*/
		//WDEV-20686 ends here
		
		form.lblRTTCurrentStatus().setValue(rttCurrentStatus);
		form.lblRTTCurrentStatus().setTooltip(null);//WDEV-20648
		form.lblRTTCurrentStatus().setTooltip(rttCurrentStatusTooltip);
		
		
		populateReferralStatus(catsReferralFull.getStatusHistory());
		
		// WDEV-20416
		if (catsReferralFull.getCurrent31TargetDateIsNotNull())
		{
			form.lbl31DayTarget().setValue(catsReferralFull.getCurrent31TargetDate().toString());
			form.lbl31DayTarget().setVisible(true);
		}
		else
		{
			form.lbl31DayTarget().setVisible(false);
		}
		
		if (catsReferralFull.getCurrent62TargetDateIsNotNull())
		{
			form.lbl62DayTarget().setValue(catsReferralFull.getCurrent62TargetDate().toString());
			form.lbl62DayTarget().setVisible(true);
		}
		else
		{
			form.lbl62DayTarget().setVisible(false);
		}

		
		form.lblNoProviderCancellation().setValue(catsReferralFull.getNumProviderCancelledAppts() != null ? catsReferralFull.getNumProviderCancelledAppts().toString() : null);
		form.lblNoPatientCancellation().setValue(catsReferralFull.getNumPatientCancelledAppts() != null ? catsReferralFull.getNumPatientCancelledAppts().toString() : null);
		
		//wdev-20721
		form.grdLinkedReferrals().getRows().clear();
		CatsReferralForLinkRefVo parentWithChilds = domain.getParentCatsReferralByChild(form.getLocalContext().getCurrentCatsReferral());
		
		if( parentWithChilds == null )
		{
			CatsReferralForLinkRefVo  parent = domain.getParentCatsRef(form.getLocalContext().getCurrentCatsReferral());  //wdev-20816
			if( parent != null && parent.getLinkedReferralsIsNotNull() && parent.getLinkedReferrals().size() > 0)
				populateLinkedReferralsGrid(parent);
		}
		else
		{
			populateLinkedReferralsGrid(parentWithChilds);
		}
		
		//-----------
	}
	private void populateLinkedReferralsGrid(CatsReferralForLinkRefVo record)
	{
		if( record == null )
			return;
		
		grdLinkedReferralsRow row = null;
		if( record.getReferralDetailsIsNotNull() )
		{
			 
			row = form.grdLinkedReferrals().getRows().newRow();
			row.setColumnService(record.getReferralDetails().getServiceIsNotNull() ? record.getReferralDetails().getService().getServiceName():"");
			row.setTooltipForColumnService(record.getReferralDetails().getServiceIsNotNull() ? record.getReferralDetails().getService().getServiceName():"");
			
			if( hasCatsReferralTransferOfCareChild(record.getLinkedReferrals()) == false)
			{
				row.setColumnRTTBreachDate(record.getReferralDetails().getEnd18WWIsNotNull() ? record.getReferralDetails().getEnd18WW().toString():"");
				row.setTooltipForColumnRTTBreachDate(record.getReferralDetails().getEnd18WWIsNotNull() ? record.getReferralDetails().getEnd18WW().toString():"");
			}
			
			row.setColumnReceivedDate(record.getReferralDetails().getDateOfReferralIsNotNull()? record.getReferralDetails().getDateOfReferral().toString():""); //WDEV-20752
			row.setTooltipForColumnReceivedDate(record.getReferralDetails().getDateOfReferralIsNotNull()? record.getReferralDetails().getDateOfReferral().toString():"");//WDEV-20752
			
			
			if(form.getLocalContext().getCurrentCatsReferral() != null &&  record.getID_CatsReferral().equals(form.getLocalContext().getCurrentCatsReferral().getID_CatsReferral()))
			{
				row.setBackColor(Color.Green);
			}
			
			
		}
		
		if( record.getLinkedReferrals() != null && record.getLinkedReferrals().size() > 0)
		{
			row.setExpanded(true);
			for(int i = 0; i < record.getLinkedReferrals().size();i++)
			{
				CatsReferralForLinkRefVo tempVo = record.getLinkedReferrals().get(i).getReferral();
				if( tempVo != null && tempVo.getReferralDetailsIsNotNull() )
				{
					 
					grdLinkedReferralsRow rowc = row.getRows().newRow();
					
					if( tempVo.getReferralDetails().getReferrerTypeIsNotNull())
					{
						if( SourceOfReferral.TRANSFER_OF_CARE.equals(tempVo.getReferralDetails().getReferrerType()))
						{
							rowc.setColumnIm(form.getImages().Core.RightArrowEnabled16);
							rowc.setTooltipForColumnIm("Transfer Of Care");
						}
						else if( SourceOfReferral.REQUEST_FOR_SERVICE.equals(tempVo.getReferralDetails().getReferrerType()))
						{
							rowc.setColumnIm(form.getImages().RefMan.RequestForService16);
							rowc.setTooltipForColumnIm("Request For Service");
						}
					}
					
					
					rowc.setColumnService(tempVo.getReferralDetails().getServiceIsNotNull() ? tempVo.getReferralDetails().getService().getServiceName():"");
					rowc.setTooltipForColumnService(tempVo.getReferralDetails().getServiceIsNotNull() ? tempVo.getReferralDetails().getService().getServiceName():"");
					
					
					rowc.setColumnRTTBreachDate(tempVo.getReferralDetails().getEnd18WWIsNotNull() ? tempVo.getReferralDetails().getEnd18WW().toString():"");
					rowc.setTooltipForColumnRTTBreachDate(tempVo.getReferralDetails().getEnd18WWIsNotNull() ? tempVo.getReferralDetails().getEnd18WW().toString():"");
					
					
					rowc.setColumnReceivedDate(tempVo.getReferralDetails().getDateOfReferralIsNotNull()? tempVo.getReferralDetails().getDateOfReferral().toString():""); //WDEV-20752
					rowc.setTooltipForColumnReceivedDate(tempVo.getReferralDetails().getDateOfReferralIsNotNull()? tempVo.getReferralDetails().getDateOfReferral().toString():""); //WDEV-20752
					
					
					if( form.getLocalContext().getCurrentCatsReferral() != null &&  tempVo.getID_CatsReferral().equals(form.getLocalContext().getCurrentCatsReferral().getID_CatsReferral()))
					{
						rowc.setBackColor(Color.Green);
					}
					
					
				}
			}
		}
	}
	private boolean hasCatsReferralTransferOfCareChild(LinkedCatsReferralForLinkRefVoCollection  collrec)
	{
		if( collrec == null || collrec.size() == 0)
			return false;
		for(int i = 0; i < collrec.size();i++)
		{
			LinkedCatsReferralForLinkRefVo tempVo = collrec.get(i);
			if( tempVo != null && tempVo.getReferralRelationTypeIsNotNull() && ReferralRelationType.TRANSFER_OF_CARE.equals(tempVo.getReferralRelationType()))
			{
				return true;
			}
		}
		return false;
	}
	
	private void populateReferralStatus(CatsReferralStatusVoCollection statusHistory)
	{
		if(statusHistory == null)
			return;
		
		statusHistory.sort(SortOrder.DESCENDING);
		
		for(CatsReferralStatusVo status : statusHistory)
		{
			addStatusRow(status);
		}
	}

	private void addStatusRow(CatsReferralStatusVo status)
	{
		if(status == null)
			return;
		
		grdReferralStatusRow row = form.grdReferralStatus().getRows().newRow();
		
		row.setColDate(status.getStatusDateTimeIsNotNull() ? status.getStatusDateTime().toString() : null);
		row.setColStatus(status.getReferralStatusIsNotNull() ? status.getReferralStatus().getIItemText() : null);
	}

	private String searchForStatusTime(CatsReferralStatusVoCollection statusHistoryColl) 
	{
		if(statusHistoryColl == null)
			return null;
		
		for(int i=0; i<statusHistoryColl.size(); i++)
		{
			if(statusHistoryColl.get(i) != null && statusHistoryColl.get(i).getReferralStatusIsNotNull() && (statusHistoryColl.get(i).getReferralStatus().equals(ReferralApptStatus.REFERRAL_ACCEPTED) || statusHistoryColl.get(i).getReferralStatus().equals(ReferralApptStatus.REFERRAL_REJECTED)))
			{
				return statusHistoryColl.get(i).getStatusDateTimeIsNotNull() ? statusHistoryColl.get(i).getStatusDateTime().toString() : null;
			}
		}
		
		return null;
	}

	private void initialize() 
	{
		clearScreen();
	}
	
	private void clearScreen() 
	{
		form.lblService().setValue(null);
		form.lblFunction().setValue(null);
		form.lblUrgency().setValue(null);
		form.lblResponsibleHCP().setValue(null);
		
		form.lblOriginalReferralDate().setValue(null);
		form.lblDateOfReferral().setValue(null);
		form.lblDateReferralLetter().setValue(null);
		form.lblTriage().setValue(null);
		form.lblConsultationAppointment().setValue(null);
		
		form.lblPathwayID().setValue(null);
		form.lblRTTCurrentStatus().setValue(null);
		form.lblRTTBreachDate().setValue(null);
		form.lbl31DayTarget().setValue(null);
		form.lbl62DayTarget().setValue(null);
		
		form.grdReferralStatus().getRows().clear();
		
		form.lblNoProviderCancellation().setValue(null);
		form.lblNoPatientCancellation().setValue(null);
		
		form.grdReferralStatus().getRows().clear();
	}
	
	public void initialize(CatsReferralRefVo catsReferral) 
	{
		form.getLocalContext().setCurrentCatsReferral(catsReferral);
		form.ccERODHistory().initialise(catsReferral);
		
		open();
	}
}
