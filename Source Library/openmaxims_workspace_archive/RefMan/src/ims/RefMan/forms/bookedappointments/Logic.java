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
