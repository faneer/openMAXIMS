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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.62 build 3084.20071)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.forms.patientappointments;

import ims.RefMan.vo.CatsReferralForTheatreListVo;
import ims.RefMan.vo.CatsReferralListVo;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.scheduling.forms.patientappointments.GenForm.grdAppointmentsRow;
import ims.scheduling.vo.Appointment_StatusVo;
import ims.scheduling.vo.Appointment_StatusVoCollection;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.Booking_AppointmentShortVo;
import ims.scheduling.vo.Booking_AppointmentShortVoCollection;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.SessionIntermediateVo;
import ims.scheduling.vo.SessionServiceAndSlotActivityVo;
import ims.scheduling.vo.SessionServiceProcedureConsultantVo;
import ims.scheduling.vo.lookups.Status_Reason;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final String CONSULTANT_HEADER = "Consultant";////WDEV-12214
	private static final String LISTOWNER_HEADER = "List Owner";////WDEV-12214

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}
	
	private void initialize()
	{
		int nMonths = ConfigFlag.UI.SEARCH_APPOINTMENTS_RANGE_MONTHS.getValue();
		form.dteFromDate().setValue(new Date().addMonth(-nMonths));
		form.dteToDate().setValue(new Date().addMonth(nMonths));
		form.getLocalContext().setAppointmentId(null);
		
		form.grdAppointments().setConsultantCaption(getConsultantHeader());//WDEV-12214
	}

	//WDEV-12214
	private String getConsultantHeader() 
	{
		if(ConfigFlag.UI.SCHEDULING_PATIENT_APPTS_CONSULTANT_DISPLAY.getValue().equals("Listowner"))
		{
			return LISTOWNER_HEADER;
		}
		
		return CONSULTANT_HEADER;
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearGridsAndInstanceControls();
		clearSearchControls();
		
		form.getLocalContext().setAppointmentId(null);
		form.getGlobalContext().Scheduling.setBookingAppointment(null);
		form.getGlobalContext().Scheduling.setBookingAppointmentRef(null);
		
	}
	protected void clearSearchControls()
	{
		form.dteFromDate().setValue(null);
		form.dteToDate().setValue(null);
	}
	private void clearGridsAndInstanceControls()
	{
		form.grdAppointments().getRows().clear();
		form.getLocalContext().setAppointmentId(null);
		updateControlsState();
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearGridsAndInstanceControls(); //WDEV-15314
		form.getGlobalContext().Scheduling.setBookingAppointment(null);
		form.getGlobalContext().Scheduling.setBookingAppointmentRef(null);
		
		if (validateSearchCriteria())
			listAppointmentsForPatientAndDate();
	}
	
	private void listAppointmentsForPatientAndDate()
	{
		Booking_AppointmentShortVoCollection voCollBookingAppointment = domain.listBookingAppointmentByPatientAndDates((PatientRefVo)form.getGlobalContext().Core.getPatientShort(), form.dteFromDate().getValue(), form.dteToDate().getValue());
		populateApptsGrid(voCollBookingAppointment);
		if (voCollBookingAppointment.size() == 0)
			engine.showMessage("No Appointments Found.");
	}

	private void populateApptsGrid(Booking_AppointmentShortVoCollection voCollBookingAppointment)
	{
		if(voCollBookingAppointment != null)
		{
			for(int i=0;i<voCollBookingAppointment.size();i++)
			{
				Booking_AppointmentShortVo voBooking = voCollBookingAppointment.get(i);
				grdAppointmentsRow row = form.grdAppointments().getRows().newRow();
				
				if(voBooking.getSessionIsNotNull())
					row.setClinicName(voBooking.getSession().getName());
				
				//WDEV-13255 
				if(voBooking.getTheatreBookingIsNotNull())
				{
					if(voBooking.getTheatreBooking().getConsultantIsNotNull())
						row.setConsultant(voBooking.getTheatreBooking().getConsultant().toString());
				}
				else
				{
					if(ConfigFlag.UI.SCHEDULING_PATIENT_APPTS_CONSULTANT_DISPLAY.getValue().equals("Booking Consultant"))
					{
						if(voBooking.getSeenByIsNotNull())
							row.setConsultant(voBooking.getSeenBy().toString());
					}
					else if(ConfigFlag.UI.SCHEDULING_PATIENT_APPTS_CONSULTANT_DISPLAY.getValue().equals("Listowner"))
					{
						if(voBooking.getSessionSlotIsNotNull() && voBooking.getSessionSlot().getSessionIsNotNull() && voBooking.getSessionSlot().getSession().getListOwnersIsNotNull() && voBooking.getSessionSlot().getSession().getListOwners().size() > 0)
							row.setConsultant(voBooking.getSessionSlot().getSession().getListOwners().get(0).getHcp().toString());
						else if(voBooking.getSessionIsNotNull() && voBooking.getSession().getListOwnersIsNotNull() && voBooking.getSession().getListOwners().size() > 0)	//	WDEV-12214
							row.setConsultant(voBooking.getSession().getListOwners().get(0).getHcp().toString());
					}
				}

				
				
				if(voBooking.getSessionIsNotNull())
					row.setClinicName(voBooking.getSession().getName());
				
				StringBuffer sb = new StringBuffer();
				if(voBooking.getAppointmentDateIsNotNull())
					sb.append(voBooking.getAppointmentDate().toString() + "  ");

				if(voBooking.getApptStartTimeIsNotNull())
					sb.append(voBooking.getApptStartTime().toString());
				
				row.setAppointmentTime(sb.toString());
				if(voBooking.getApptStatusIsNotNull())
				{
					row.setStatus(voBooking.getApptStatus().toString());
					row.setBooking(voBooking.getApptStatus().getImage());
				}
				
				//WDEV-11830
				if(voBooking.getActivityIsNotNull())
					row.setActivity(voBooking.getActivity().getName());
				
				row.setValue(voBooking);
			}
		}
	}

	private boolean validateSearchCriteria()
	{
		if (form.dteFromDate().getValue() == null || form.dteToDate().getValue() == null)
		{
			engine.showMessage("Please provide both From and To dates for searching.", "Error Searching", MessageButtons.OK, MessageIcon.WARNING);
			return false;
		}

		if (form.dteFromDate().getValue() != null && form.dteToDate().getValue() != null)
		{
			if (form.dteFromDate().getValue().isGreaterThan(form.dteToDate().getValue()))
			{
				engine.showMessage("Date From is greater than Date To.", "Error Searching", MessageButtons.OK, MessageIcon.WARNING); //WDEV-14847 
				return false;

			}
		}

		return true;
	}

	@Override
	protected void onGrdAppointmentsSelectionChanged() throws PresentationLogicException 
	{
		if (form.grdAppointments().getSelectedRow() != null  && form.grdAppointments().getSelectedRow().getValue() != null)
		{
			form.getLocalContext().setAppointmentId(form.grdAppointments().getSelectedRow().getValue());
			form.getGlobalContext().Scheduling.setBookingAppointment(null);//wdev-15207
			form.getGlobalContext().Scheduling.setBookingAppointmentRef(null);//wdev-15207
			form.getGlobalContext().RefMan.setCatsReferral(domain.getCatsReferralForAppointment(form.grdAppointments().getValue()));
		}
		else
		{
			form.getLocalContext().setAppointmentId(null);
			form.getGlobalContext().Scheduling.setBookingAppointment(null);//wdev-15207
			form.getGlobalContext().Scheduling.setBookingAppointmentRef(null);//wdev-15207
			form.getGlobalContext().RefMan.setCatsReferral(null);
		}
		
		updateControlsState();
	}

	private void updateControlsState()
	{
		Boolean rowSelected = form.grdAppointments().getValue() != null;
		
		Boolean isTheatreAppt = rowSelected && form.grdAppointments().getValue().getTheatreBooking() != null;
		Boolean icpCompleted = domain.isReferralICPCompleted(form.getGlobalContext().RefMan.getCatsReferral());

		CatsReferralForTheatreListVo referralStatus = domain.getCatsReferralStatus(form.grdAppointments().getValue());
		Boolean isReferralEOC = referralStatus != null && referralStatus.getCurrentStatus() != null && ReferralApptStatus.END_OF_CARE.equals(referralStatus.getCurrentStatus().getReferralStatus());
		Boolean isReferralProviderCancelled = referralStatus != null && referralStatus.getCurrentStatus() != null && ReferralApptStatus.REFERRAL_CANCELLED_BY_PROVIDER.equals(referralStatus.getCurrentStatus().getReferralStatus());

		form.getContextMenus().Scheduling.hideAllPatientAppointmentsMenuItems();
		// WDEV8891
		form.getContextMenus().Scheduling.getPatientAppointmentsCANCELItem().setVisible(rowSelected && Status_Reason.BOOKED.equals(form.grdAppointments().getSelectedRow().getValue().getApptStatus()));
		
		//WDEV-18006
		form.getContextMenus().Scheduling.getPatientAppointmentsREBOOK_THEATRE_APPTItem().setVisible(rowSelected && Boolean.TRUE.equals(form.grdAppointments().getValue().getRequiresRebook()) && isTheatreAppt && !icpCompleted && ConfigFlag.UI.CAN_CONFIGURE_THEATRE_PROFILES.getValue() && !isReferralEOC && !isReferralProviderCancelled);
		form.getContextMenus().Scheduling.getPatientAppointmentsVIEW_APPT_HISTORYItem().setVisible(rowSelected);
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.SchedulingNamespace.PatientAppointments.CANCEL:
			{
				Booking_AppointmentShortVo voAppt = form.grdAppointments().getValue();
				
				boolean isTheatreAppt = voAppt != null && voAppt.getTheatreBooking() != null;
				
				if(voAppt != null)
				{
					SessionServiceAndSlotActivityVo voServiceAndActivity = null;
					//flexible appointment cancel WDEV-7766
					boolean flexible = false;
					if(voAppt.getSessionIsNotNull() && voAppt.getSession().getIsFixedIsNotNull() && !voAppt.getSession().getIsFixed())
						flexible = true;
					
					voServiceAndActivity = domain.getServiceAndActivityByAppt(voAppt, flexible);
					if(voServiceAndActivity != null)
					{
						//WDEV-12783 - Start
						CatsReferralListVo voReferral = domain.getCatsReferralForAppointment(voAppt);
						form.getGlobalContext().RefMan.setCatsReferralStatus(voReferral != null ? voReferral.getCurrentStatus() : null);
						//WDEV-12783 - End
						form.getGlobalContext().Scheduling.setBookingAppointmentRef(voAppt);
						form.getGlobalContext().Scheduling.setBookingActivity(voServiceAndActivity.getSlotActivity());
						form.getGlobalContext().Scheduling.setBookingService(voServiceAndActivity.getSessionService());
						form.getGlobalContext().Scheduling.setBookingSession(voAppt.getSession());
						engine.open(form.getForms().Scheduling.CancelAppointmentDialog, new Object[] {null, isTheatreAppt});
					}
					else  //wdev-12783
					{
						if(voAppt.getTheatreBookingIsNotNull())
						{
							SessionServiceProcedureConsultantVo voServiceProcedureConsultant = domain.getServiceProcedureConsultantByAppt(voAppt);
							if(voServiceProcedureConsultant != null)
							{
								//wdev-11902
								CatsReferralListVo voReferral = domain.getCatsReferralForAppointment(form.grdAppointments().getValue());
								form.getGlobalContext().RefMan.setCatsReferralStatus(voReferral.getCurrentStatus());
		
								form.getGlobalContext().Scheduling.setTheatreConsultant(voServiceProcedureConsultant.getConsultant());
								form.getGlobalContext().Scheduling.setTheatreService(voServiceProcedureConsultant.getService());
								form.getGlobalContext().Scheduling.setTheatreProcedure(voServiceProcedureConsultant.getProcedure());
								form.getGlobalContext().Scheduling.setBookingSession(voAppt.getSession());
								SessionIntermediateVo tempSessVo = null;
								if(voAppt.getSessionIsNotNull())
								{
									tempSessVo = domain.getSession(voAppt.getSession());
								}
								form.getGlobalContext().Scheduling.setTheatreType(tempSessVo != null ? tempSessVo.getTheatreType():null);
								
								engine.open(form.getForms().Scheduling.CancelAppointmentDialog, new Object[] {null, isTheatreAppt});
							}
						}
					}
				}
				break;
			}
			
			case GenForm.ContextMenus.SchedulingNamespace.PatientAppointments.REBOOK_THEATRE_APPT:
				BookingAppointmentTheatreVo voTheatreAppt = domain.getTheatreAppointment(form.grdAppointments().getValue());
				rebookTheatreAppt(voTheatreAppt, form.grdAppointments().getValue());
				break;
				
			case GenForm.ContextMenus.SchedulingNamespace.PatientAppointments.VIEW_APPT_HISTORY:
				viewAppHistory();
				break;
				
			default:
		}	
	}

	private void viewAppHistory()
	{
		engine.open(form.getForms().Scheduling.AppointmentHistoryDialog,new Object[]{domain.listAppointmentHistory(form.grdAppointments().getValue())});
	}

	private boolean cancelAppt() 
	{
		Booking_AppointmentShortVo voAppt = form.grdAppointments().getValue();
		if(form.getGlobalContext().Scheduling.getApptCancelStatusIsNotNull())
		{
			//appt status and status history
			voAppt.setApptStatus(Status_Reason.CANCELLED);
			voAppt.setApptStatusReas(form.getGlobalContext().Scheduling.getApptCancelStatus().getStatusReason());
			
			Appointment_StatusVo voStatus = new Appointment_StatusVo();
			voStatus.setApptDate(voAppt.getAppointmentDate());
			voStatus.setApptTime(voAppt.getApptStartTime());
			voStatus.setStatusChangeDateTime(new DateTime());
			
			voStatus.setStatus(Status_Reason.CANCELLED);
			if(form.getGlobalContext().Scheduling.getApptCancelStatusIsNotNull())
			{
				voStatus.setCancellationReason(form.getGlobalContext().Scheduling.getApptCancelStatus().getCancellationReason());
				voStatus.setComment(form.getGlobalContext().Scheduling.getApptCancelStatus().getComment()); //WDEV-15458
				if(form.getGlobalContext().Scheduling.getApptCancelStatus().getRebookSelectedIsNotNull())
					voAppt.setRequiresRebook(form.getGlobalContext().Scheduling.getApptCancelStatus().getRebookSelected());
			}
			Appointment_StatusVoCollection voCollStatusHistory = voAppt.getApptStatusHistory();
			if(voCollStatusHistory == null)
				voCollStatusHistory =  new Appointment_StatusVoCollection();
			
			voCollStatusHistory.add(voStatus);
			voAppt.setCurrentStatusRecord(voStatus); // wdev-6034
			voAppt.setApptStatusHistory(voCollStatusHistory);	
		}

		String[] arrErrors = voAppt.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}	
		
		Booking_AppointmentVo voApptFull = null;
		try
		{
			voApptFull = domain.saveBookingAppt(voAppt);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			clearGridsAndInstanceControls();
			return false;
		}
		
		form.getGlobalContext().Scheduling.setBookingAppointment(voApptFull);
		return true;
	}
	
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if(formName.equals(form.getForms().Scheduling.CancelAppointmentDialog))
		{
			if(result.equals(DialogResult.OK))
			{
				if(!cancelAppt())
					return;
				
				//WDEV-12783 -Start
				CatsReferralListVo voReferral = domain.getCatsReferralForAppointment(form.grdAppointments().getValue());
				try
				{
					//WDEV-14344
					if (voReferral!=null)
					{
						domain.updateCatsReferralForCancelledAppt(voReferral);
						
						if(ConfigFlag.GEN.USE_ELECTIVE_LIST_FUNCTIONALITY.getValue() && form.getGlobalContext().Scheduling.getBookingAppointment() != null && form.getGlobalContext().Scheduling.getBookingAppointment().getTheatreBooking() != null && form.getGlobalContext().Scheduling.getApptCancelStatusIsNotNull() && Boolean.TRUE.equals(form.getGlobalContext().Scheduling.getApptCancelStatus().getCancelTCI())) //WDEV-18249
						{
							domain.cancelTCIAndReferralEROD(voReferral, form.getGlobalContext().Scheduling.getBookingAppointment(), Status_Reason.HOSPITALCANCELLED.equals(form.getGlobalContext().Scheduling.getBookingAppointment().getApptStatusReas()), Status_Reason.PATIENTCANCELLED.equals(form.getGlobalContext().Scheduling.getBookingAppointment().getApptStatusReas()));//WDEV-18249
						}
					}
					
				}
				catch (StaleObjectException e)
				{
					engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					return;
				}
				//WDEV-12783 -end 
				//open book appointment
				if(form.getGlobalContext().Scheduling.getApptCancelStatusIsNotNull() && form.getGlobalContext().Scheduling.getApptCancelStatus().getRebookSelectedIsNotNull() && form.getGlobalContext().Scheduling.getApptCancelStatus().getRebookSelected())
				{
					form.getGlobalContext().Core.setPatientShort(form.grdAppointments().getValue().getPatient());
					//WDEV-12783 -Start
					if(form.grdAppointments().getValue().getTheatreBookingIsNotNull())  //wdev-12783
					{				
						if (form.getGlobalContext().RefMan.getCatsReferral() == null)//WDEV-15294
							form.getGlobalContext().RefMan.setCatsReferral(voReferral); 
						
						rebookTheatreAppt(domain.getTheatreAppointment(form.grdAppointments().getValue()),form.grdAppointments().getValue());
						return;
					}
					else
					{
												
						if(ConfigFlag.UI.BOOKAPPT_UI_TYPE.getValue().equals("CARE_UK"))
						{
							form.getGlobalContext().RefMan.setCatsReferral(voReferral);
							form.getGlobalContext().RefMan.setReferralContractTypeForPatient(voReferral.getContractIsNotNull() ? voReferral.getContract().getContractType() : null );//wdev-12682
	
							engine.open(form.getForms().RefMan.BookAppointment);
						}
						else
							engine.open(form.getForms().Scheduling.BookAppointmentDialog); // wdev-17851
					}
					
					//WDEV-12783 -end engine.open(form.getForms().Scheduling.BookAppointment);
				}
				else
					onImbSearchClick();
			}
			if(result.equals(DialogResult.CANCEL))
			{
				form.getGlobalContext().Scheduling.setBookingActivity(null);
				form.getGlobalContext().Scheduling.setBookingService(null);
			}
		}
		else //wdev-12783
			onImbSearchClick();
	}
	//wdev-12783
	private void rebookTheatreAppt(BookingAppointmentTheatreVo voAppt,Booking_AppointmentShortVo voAp)
	{
		

		boolean isTheatreAppt = voAppt != null && voAppt.getTheatreBooking() != null;

		
		if (voAppt != null 
			&& voAppt.getRequiresRebookIsNotNull() 
			&& voAppt.getRequiresRebook() 
			&& isTheatreAppt
			&& voAppt.getApptStatusIsNotNull()
			&& (voAppt.getApptStatus().equals(Status_Reason.CANCELLED) || voAppt.getApptStatus().equals(Status_Reason.DNA)))	//WDEV-9091
		{
			form.getGlobalContext().Scheduling.setTheatreAppointment(voAppt);

			if(voAppt.getSessionIsNotNull())
				form.getGlobalContext().Scheduling.setTheatreType(voAppt.getSession().getTheatreType());
			
			SessionServiceProcedureConsultantVo voPsc = domain.getServiceProcedureConsultantByAppt(voAp);
			if(voPsc != null)
			{
				form.getGlobalContext().Scheduling.setTheatreService(voPsc.getService());
				form.getGlobalContext().Scheduling.setTheatreProcedure(voPsc.getProcedure());
				form.getGlobalContext().Scheduling.setTheatreConsultant(voPsc.getConsultant());
				
				//WDEV-12918
				if(ConfigFlag.DOM.THEATRE_SESSION_TYPE.getValue().equals("TCI"))
					engine.open(form.getForms().RefMan.BookTheatreDialog);
				else
					engine.open(form.getForms().RefMan.BookTheatreSlot);
			}
		}
	}
	
}
