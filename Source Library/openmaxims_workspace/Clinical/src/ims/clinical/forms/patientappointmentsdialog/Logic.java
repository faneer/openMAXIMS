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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4027.29767)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.patientappointmentsdialog;

import ims.RefMan.vo.OrderInvApptListVo;
import ims.RefMan.vo.ReferralForFitForSurgeryVo;
import ims.clinical.forms.patientappointmentsdialog.GenForm.grdApptsRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.scheduling.vo.BookingAppointmentForFitForSurgeryAssessmentVo;
import ims.scheduling.vo.lookups.Status_Reason;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open() 
	{
		ReferralForFitForSurgeryVo referral = domain.getReferralByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if(referral == null)
			return;
		
		populateGrid(referral);
		updateControlsState();
	}
	
	private void populateGrid(ReferralForFitForSurgeryVo referral) 
	{
		if(referral == null || !referral.getAppointmentsIsNotNull())
			return;
		
		referral.getAppointments().sort(new DateComparator(SortOrder.ASCENDING)); //WDEV-15320
		
		for(int i=0; i<referral.getAppointments().size(); i++)
		{
			BookingAppointmentForFitForSurgeryAssessmentVo appt = referral.getAppointments().get(i);
			if(appt == null)
				continue;
			
			if(Status_Reason.CANCELLED.equals(appt.getApptStatus()) || Status_Reason.DNA.equals(appt.getApptStatus()) || appt.getTheatreBookingIsNotNull())
				continue;
			
			if(!findAnyInvestigationForThisAppointment(referral, appt))
			{
				addAppointmentRow(appt);
			}
		}
	}

	private boolean findAnyInvestigationForThisAppointment(ReferralForFitForSurgeryVo referral,	BookingAppointmentForFitForSurgeryAssessmentVo appt) 
	{
		if(referral.getOrderInvAppts() != null)
		{
			for(int i=0; i<referral.getOrderInvAppts().size(); i++)
			{
				OrderInvApptListVo order = referral.getOrderInvAppts().get(i);
				
				if (order.getAppointmentIsNotNull()	&& appt.getID_Booking_Appointment().equals(order.getAppointment().getID_Booking_Appointment()))
					return true;
			}
		}
		
		return false;
	}

	private void addAppointmentRow(BookingAppointmentForFitForSurgeryAssessmentVo appt) 
	{
		if(appt == null)
			return;
		
		grdApptsRow row = form.grdAppts().getRows().newRow();
		
		String dateTimeStr = "";
		
		if(appt.getAppointmentDateIsNotNull())
			dateTimeStr += appt.getAppointmentDate().toString() + " ";
		if(appt.getApptStartTimeIsNotNull())
			dateTimeStr += appt.getApptStartTime().toString();
		else if(appt.getTheatreBookingIsNotNull() && appt.getTheatreBooking().getTCITimeIsNotNull())
			dateTimeStr += appt.getTheatreBooking().getTCITime().getText();

		row.setcolDateTime(dateTimeStr);
		
		if(appt.getSessionIsNotNull())
		{
			row.setcolClinic(appt.getSession().getName());
			
			if(appt.getSession().getServiceIsNotNull())
				row.setcolService(appt.getSession().getService().getServiceName());
		}
	
		row.setcolStatus(appt.getApptStatus());
		
		row.setValue(appt);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Clinical.setAppointmentForFitForSurgery(form.grdAppts().getValue());
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onGrdApptsSelectionChanged()	throws PresentationLogicException 
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.btnOk().setEnabled(form.grdAppts().getValue() instanceof BookingAppointmentForFitForSurgeryAssessmentVo);
	}
	
	//WDEV-15320
	public class DateComparator implements Comparator
	{
		private int direction = 1;
		
		public DateComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public DateComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		
		public int compare(Object ob1, Object ob2) 
		{
			DateTime name1 = null;
			DateTime name2 = null;
			
			if(ob1 instanceof BookingAppointmentForFitForSurgeryAssessmentVo )
			{
				BookingAppointmentForFitForSurgeryAssessmentVo ps1 = (BookingAppointmentForFitForSurgeryAssessmentVo)ob1;
				
				if (ps1 != null && ps1.getAppointmentDateIsNotNull() && ps1.getApptStartTimeIsNotNull())
					{
						name1 = new DateTime();
						name1.setDateTime(ps1.getAppointmentDate(), ps1.getApptStartTime());
					}
			}
			
			if(ob2 instanceof BookingAppointmentForFitForSurgeryAssessmentVo)
			{
				BookingAppointmentForFitForSurgeryAssessmentVo ps2 = (BookingAppointmentForFitForSurgeryAssessmentVo)ob2;
				
				if (ps2 != null && ps2.getAppointmentDateIsNotNull() && ps2.getApptStartTimeIsNotNull())
				{
					name2 = new DateTime();
					name2.setDateTime(ps2.getAppointmentDate(), ps2.getApptStartTime());
				}	
			}
			
			if(name1 != null )
				return  name1.compareTo(name2)*direction;
			if(name2 != null)
				return (-1)*direction;
			
			return 0;
		}
	}

	
}
