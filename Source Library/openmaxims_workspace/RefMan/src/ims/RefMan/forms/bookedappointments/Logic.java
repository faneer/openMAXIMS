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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.bookedappointments;

import ims.RefMan.forms.bookedappointments.GenForm.grdApptsRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo;
import ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVoCollection;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// form.btnOk().setEnabled(false); WDEV-11911
		loadAppointments();
		updateControlsState(); // WDEV-11911
	}

	private void loadAppointments()
	{
		form.grdAppts().getRows().clear();

		if (form.getGlobalContext().Rotherham.getBookedAppointmentsIsNotNull())
		{
			ReferralAppointmentDetailsBookingAppointmentVoCollection voCollAppts = form.getGlobalContext().Rotherham.getBookedAppointments();
			for (ReferralAppointmentDetailsBookingAppointmentVo voAppt : voCollAppts)
			{
				grdApptsRow row = form.grdAppts().getRows().newRow();
				if (voAppt.getAppointmentDateIsNotNull())
				{
					StringBuffer sDateTime = new StringBuffer();
					sDateTime.append(voAppt.getAppointmentDate().toString());
					if (voAppt.getApptStartTimeIsNotNull())
					{
						sDateTime.append(" ");
						sDateTime.append(voAppt.getApptStartTime().toString());
					}
					else if (voAppt.getTheatreBookingIsNotNull())
					{
						if (voAppt.getTheatreBooking().getTCITimeIsNotNull())
						{
							sDateTime.append(" ");
							sDateTime.append(voAppt.getTheatreBooking().getTCITime().getText());
						}
					}
					row.setcolDateTime(sDateTime.toString());
				}
				if (voAppt.getSessionIsNotNull())
				{
					row.setcolClinic(voAppt.getSession().getName());
					if (voAppt.getSession().getServiceIsNotNull())
						row.setcolService(voAppt.getSession().getService().getServiceName());
				}
				row.setcolStatus(voAppt.getApptStatus());
				
				//WDEV-11996
				if (voAppt.getTheatreBookingIsNotNull())
					row.setSelectable(false);
				
				row.setValue(voAppt);
			}
		}
	}

	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Rotherham.setAppointmentToLink(form.grdAppts().getValue());
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Rotherham.setAppointmentToLink(null);
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onGrdApptsSelectionChanged() throws PresentationLogicException
	{
		// WDEV-11911
		updateControlsState();
	}

	// WDEV-11911
	private void updateControlsState()
	{
		form.btnOk().setEnabled(form.grdAppts().getValue() != null && form.grdAppts().getValue().getTheatreBooking() == null);
	}
}
