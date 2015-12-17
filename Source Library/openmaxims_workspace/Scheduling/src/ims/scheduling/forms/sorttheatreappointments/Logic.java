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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3467.22451)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.sorttheatreappointments;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.scheduling.forms.sorttheatreappointments.GenForm.grdApptsRow;
import ims.scheduling.forms.sorttheatreappointments.GenForm.grdSessionsRow;
import ims.scheduling.vo.BookingAppointmentTheatreLiteVo;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.BookingAppointmentTheatreVoCollection;
import ims.scheduling.vo.Sch_Session_Appointment_OrderVo;
import ims.scheduling.vo.SessionLiteVo;
import ims.scheduling.vo.SessionLiteVoCollection;
import ims.scheduling.vo.SessionParentChildSlotVo;
import ims.scheduling.vo.SessionParentChildSlotVoCollection;
import ims.scheduling.vo.SessionTheatreVo;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.vo.interfaces.IMos;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();

		if (engine.getParentDialogFormName() != null && engine.getParentDialogFormName().equals(form.getForms().RefMan.BookTheatreDialog) && form.getGlobalContext().Scheduling.getAppointmentIdsIsNotNull())
			engine.open(form.getForms().Scheduling.PrintAppointment);
	}

	private void initialize()
	{
		// if we have a Session in the context - auto-select it and find the
		// Sch_Session_Appointment_OrderVo record to populate screen
		if (form.getGlobalContext().Scheduling.getTheatreSessionIsNotNull())
		{
			Sch_Session_Appointment_OrderVo voSessionApptOrder = domain.getSessionApptOrderBySession(form.getGlobalContext().Scheduling.getTheatreSession());
			if (voSessionApptOrder == null)
			{
				engine.showMessage("No Appts Booked for this Session");
				return;
			}

			form.getLocalContext().setSessApptOrder(voSessionApptOrder);
			if (voSessionApptOrder.getSessionIsNotNull() && voSessionApptOrder.getSession().getSessionDateIsNotNull())
			{
				form.dteSession().setValue(voSessionApptOrder.getSession().getSessionDate());
				// Search Sessions and select the row
				searchSessions();
				form.grdSessions().setValue(voSessionApptOrder.getSession());
			}
		}

		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		form.grdAppts().setColHospitalNoCaption(dispIdType.getText());

	}

	private void open()
	{
		form.setMode(FormMode.VIEW);
		clearInstanceControls();

		if (form.grdSessions().getValue() != null)
			grdSessionsSelectionChanged();

		updateControlState();
	}

	private void populateScreenFromData(Sch_Session_Appointment_OrderVo voSessionApptOrder)
	{
		if (voSessionApptOrder == null)
			return;

		if (voSessionApptOrder.getSessionIsNotNull())
		{

			form.txtDate().setValue(voSessionApptOrder.getSession().getSessionDate().toString());

			form.txtTheatreDetail().setValue(voSessionApptOrder.getSession().getName());
			if (voSessionApptOrder.getFinalisedByIsNotNull())
				form.txtFinalisedBy().setValue(voSessionApptOrder.getFinalisedBy().toString());

			if (voSessionApptOrder.getFinalisedDateTimeIsNotNull())
				form.txtFinalisedDT().setValue(voSessionApptOrder.getFinalisedDateTime().toString());

			if (voSessionApptOrder.getSession().getListOwnersIsNotNull())
				form.txtListOwner().setValue(voSessionApptOrder.getSession().getListOwners().toString());

		}

		if (voSessionApptOrder.getAppointmentsIsNotNull())
		{
			populateAppointmentsGridFromData(voSessionApptOrder.getAppointments());
		}
	}

	/**
	 * @param voAppts
	 */
	private void populateAppointmentsGridFromData(BookingAppointmentTheatreVoCollection voAppts)
	{
		for (BookingAppointmentTheatreVo voAppt : voAppts)
		{
			if (voAppt.getApptStatus().equals(Status_Reason.CANCELLED) || voAppt.getApptStatus().equals(Status_Reason.DNA))
				continue;

			grdApptsRow aRow = form.grdAppts().getRows().newRow();

			// WDEV-11777 - keep the currently selected TheatreSlot in memory as
			// we may need to update
			aRow.setColCurrentTheatreSlot(voAppt.getTheatreSlot());

			if (voAppt.getPatientIsNotNull())
			{
				if (voAppt.getPatient().getDisplayId() != null)
					aRow.setColHospitalNo(voAppt.getPatient().getDisplayId().getValue());
				if (voAppt.getPatient().getNameIsNotNull())
				{
					aRow.setColSurname(voAppt.getPatient().getName().getSurname());
					aRow.setColForename(voAppt.getPatient().getName().getForename());
				}
				if (voAppt.getPatient().getSexIsNotNull())
					aRow.setColSex(voAppt.getPatient().getSex().getText());
				if (voAppt.getPatient().getDobIsNotNull())
					aRow.setColDob(voAppt.getPatient().getDob().toString());
			}
			if (voAppt.getTheatreBookingIsNotNull())
			{
				if (voAppt.getTheatreBooking().getProcedureIsNotNull())
				{
					aRow.setColProcedure(voAppt.getTheatreBooking().getProcedure().getProcedureName());
					aRow.setTooltipForColProcedure(voAppt.getTheatreBooking().getProcedure().getProcedureName());
				}
			}
			aRow.setValue(voAppt);
		}
	}

	private void updateControlState()
	{
		// WDEV-22773 
		form.btnEdit().setVisible(form.getMode().equals(FormMode.VIEW) && form.grdSessions().getValue()!=null && form.getLocalContext().getSessApptOrderIsNotNull()); //WDEV-23114
	
		updateContextMenuState();
	}

	private void updateContextMenuState()
	{
		form.getContextMenus().Scheduling.hideAllSortTheatreAppointmentsMenuItems();
		if (form.getMode().equals(FormMode.EDIT))
		{
			if (form.grdAppts().getRows().size() > 1)
			{
				if (form.grdAppts().getSelectedRow() != null)
				{
					//WDEV-22773 
					/*
					 * Users should not be able to move any appointment that has any theatre times recorded (has a state) 
					 * Ensure context menu options displayed are correct
					 */
//					if (form.grdAppts().canMoveCurrentUp())
//						form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEUPItem().setVisible(true);
//					if (form.grdAppts().canMoveCurrentDown())
//						form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEDOWNItem().setVisible(true);


					//Determine row index of highest row with state
					int idxOfHighestRowWithState = 0;
					for (int x=0; x<form.grdAppts().getRows().size() ;x++)
					{
						if (form.grdAppts().getRows().get(x).getValue().getTheatreBooking().getState() != null)
						{
							idxOfHighestRowWithState = x;
						}
					}
					//Determine row index of row above selected row
					int idxOfRowAbove = 0;
					if (form.grdAppts().getSelectedRowIndex() > 0) //Check if top row
					{
						idxOfRowAbove = form.grdAppts().getSelectedRowIndex() - 1;
					}
						
					//If selected row index < highest row with state, then row can only move move down
					if (form.grdAppts().getSelectedRowIndex() < idxOfHighestRowWithState)
					{
						if (form.grdAppts().canMoveCurrentDown())
							form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEDOWNItem().setVisible(true);
					}

					//if the row above selected row is selectable row then row can move up and down
					else if (form.grdAppts().getRows().get(idxOfRowAbove).isSelectable())
					{
						if (form.grdAppts().canMoveCurrentUp())
							form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEUPItem().setVisible(true);
						if (form.grdAppts().canMoveCurrentDown())
							form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEDOWNItem().setVisible(true);
					}
					
					else
					{
						if (form.grdAppts().canMoveCurrentDown())
							form.getContextMenus().Scheduling.getSortTheatreAppointmentsMOVEDOWNItem().setVisible(true);
					} //WDEV-22773
				}
			}
		}
		
		setSelectableRows(); //WDEV-22773
		
	}

	private void clearInstanceControls()
	{
		form.txtTheatreDetail().setValue("");
		form.txtListOwner().setValue("");
		form.txtDate().setValue("");
		form.txtFinalisedBy().setValue("");
		form.txtFinalisedDT().setValue("");
		form.grdAppts().getRows().clear();
	}

	@Override
	protected void onGrdApptsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateContextMenuState();
	}

	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	private boolean save(Sch_Session_Appointment_OrderVo voSessApptOrder)
	{
		// need to update the session :
		// Start from the start time of the session and put bookings into slots in order ensuring the parentchild slots are used according to procedure length
		// also update the appointment start and end times
		// finally ensure that the appointment to slot link is correct
		
		SessionTheatreVo session = voSessApptOrder.getSession();
		BookingAppointmentTheatreVoCollection apptsReducingSet = new BookingAppointmentTheatreVoCollection();
		SessionParentChildSlotVoCollection newSlotsCollection = new SessionParentChildSlotVoCollection();
	
		//Iterate thru the grid of appts
		for (int nAppts = 0 ; nAppts < form.grdAppts().getRows().size() ; nAppts++)
			apptsReducingSet.add(form.grdAppts().getRows().get(nAppts).getValue());
			
		session.getParentChildSlots().sort(ims.framework.enumerations.SortOrder.ASCENDING);
		for ( int i = 0 ; i < session.getParentChildSlots().size() && apptsReducingSet.size() > 0; i++)
		{
			if(session.getParentChildSlots().get(i).getReUsed() == null || Boolean.FALSE.equals(session.getParentChildSlots().get(i).getReUsed()) )
			{
				BookingAppointmentTheatreVo appointment = apptsReducingSet.get(0);
				
				SessionParentChildSlotVoCollection slotsForThisAppt = retrieveSlots(session, session.getParentChildSlots().get(i), appointment.getCustomProcedureDuration());
				
				Time startSlotTime = null;
				Time endSlotTime = null;
				for (int nSlots = 0 ; slotsForThisAppt != null && nSlots < slotsForThisAppt.size() ; nSlots++)
				{
					slotsForThisAppt.get(nSlots).setReUsed(true);
					
					slotsForThisAppt.get(nSlots).setStatus(Status_Reason.BOOKED);
					slotsForThisAppt.get(nSlots).setStatusReason(Status_Reason.APPOINTMENTMOVED);
					
					if (nSlots == 0)
					{
						voSessApptOrder.getAppointments().get(voSessApptOrder.getAppointments().indexOf(appointment)).setParentChildSlot(null);
						slotsForThisAppt.get(nSlots).setAppointment(new BookingAppointmentTheatreLiteVo(appointment.getID_Booking_Appointment(),0));
						slotsForThisAppt.get(nSlots).setParentSlot(null);
						
						startSlotTime = slotsForThisAppt.get(nSlots).getStartTime();
					}
					else
					{
						slotsForThisAppt.get(nSlots).setParentSlot(session.getParentChildSlots().get(i));
						slotsForThisAppt.get(nSlots).setAppointment(null);
						int nDuration = slotsForThisAppt.get(nSlots).getDuration();
						endSlotTime = ((Time)slotsForThisAppt.get(nSlots).getStartTime().clone());
						endSlotTime.addMinutes(nDuration);
					}

					newSlotsCollection.add(slotsForThisAppt.get(nSlots));
				}
				
				//find the appt in the list on voSessApptOrder.getAppointments()
				voSessApptOrder.getAppointments().get(voSessApptOrder.getAppointments().indexOf(appointment)).setApptStartTime(startSlotTime);
				voSessApptOrder.getAppointments().get(voSessApptOrder.getAppointments().indexOf(appointment)).setApptEndTime(endSlotTime);
			
				apptsReducingSet.remove(0);
			}
		}
		//Complete the session, add in remaining unused slots with the appointment cleared out
		for (int nClearOut = 0 ; nClearOut < session.getParentChildSlots().size() ; nClearOut++)
		{
			if ( ! newSlotsCollection.contains(session.getParentChildSlots().get(nClearOut)) )
			{
				SessionParentChildSlotVo slotClearOut = session.getParentChildSlots().get(nClearOut);
				slotClearOut.setReUsed(true);
				slotClearOut.setAppointment(null);
				slotClearOut.setParentSlot(null);
				slotClearOut.setStatus(Status_Reason.CLOSED);
				slotClearOut.setStatusReason(Status_Reason.CLOSED);
				
				newSlotsCollection.add(slotClearOut);
			}
		}
		
		voSessApptOrder.getSession().setParentChildSlots(newSlotsCollection);
		
		String[] arrErrors = voSessApptOrder.validate();
		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}

		try
		{
			domain.saveReOrderedSession(voSessApptOrder);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());

			// WDEV-11908
			open();
			return false;
		}

		return true;
	}

	public SessionParentChildSlotVoCollection retrieveSlots(SessionTheatreVo session, SessionParentChildSlotVo parentSlot, Integer apptDuration)
	{
		if (parentSlot == null)
			throw new ims.framework.exceptions.CodingRuntimeException("parentSlot cannot be null in method calculateChildSlots");
		if (apptDuration == null)
			throw new ims.framework.exceptions.CodingRuntimeException("apptDuration cannot be null in method calculateChildSlots");
		
		int duration = apptDuration;
		
		SessionParentChildSlotVoCollection voCollChildSlots = new SessionParentChildSlotVoCollection();
		boolean startPointReached = false;
		if(session.getParentChildSlotsIsNotNull())
		{
			for(SessionParentChildSlotVo voSlot : session.getParentChildSlots())
			{
				if(startPointReached && duration >0)
				{
					if(voSlot.getStatusIsNotNull() 
						//	&& voSlot.getStatus().equals(ims.scheduling.vo.lookups.Status_Reason.SLOTOPENED)
							&& (voSlot.getReUsed() == null || Boolean.FALSE.equals(voSlot.getReUsed()) ))
					{
						duration-= voSlot.getDuration();
						voCollChildSlots.add(voSlot);
					}
					else
						return null;
				}
				else if(parentSlot.equals(voSlot)) //starting point
				{
					duration -= parentSlot.getDuration();
					startPointReached = true;
					voCollChildSlots.add(voSlot);
				}
			}
		}

		return voCollChildSlots;
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = populateDataFromScreen();
		
		voSessApptOrder.setFinalisedBy((IMos) domain.getMosUser());
		voSessApptOrder.setFinalisedDateTime(new DateTime());

		if (save(voSessApptOrder))
		{
			open();
		}
	}

	private Sch_Session_Appointment_OrderVo populateDataFromScreen()
	{
		Sch_Session_Appointment_OrderVo voSessApptOrder = form.getLocalContext().getSessApptOrder();
		if (voSessApptOrder == null)
			return null;

		BookingAppointmentTheatreVoCollection voCollTheatreAppt = new BookingAppointmentTheatreVoCollection();
		for (int i = 0; i < form.grdAppts().getRows().size(); i++)
		{
			grdApptsRow apptsRow = form.grdAppts().getRows().get(i);
			BookingAppointmentTheatreVo voAppt = apptsRow.getValue();
			//voAppt.setParentChildSlot(null);
			voCollTheatreAppt.add(voAppt);
		}

		voSessApptOrder.setAppointments(voCollTheatreAppt);

		return voSessApptOrder;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-22773 Need to check if row being moved can acually move up
		//Determine row index of highest row with state
		int idxOfHighestRowWithState = 0;
		for (int x=0; x<form.grdAppts().getRows().size() ;x++)
		{
			if (form.grdAppts().getRows().get(x).getValue().getTheatreBooking().getState() != null)
			{
				idxOfHighestRowWithState = x;
			}
		} //WDEV-22773

		switch (menuItemID)
		{
			case GenForm.ContextMenus.SchedulingNamespace.SortTheatreAppointments.MOVEUP:
				//WDEV-22773
//				form.grdAppts().moveUp();
//				updateContextMenuState(); 
				if (form.grdAppts().getSelectedRowIndex() > idxOfHighestRowWithState )
				{
					form.grdAppts().moveUp();
					updateContextMenuState();					
				} //WDEV-22773

				break;
			case GenForm.ContextMenus.SchedulingNamespace.SortTheatreAppointments.MOVEDOWN:
				form.grdAppts().moveDown();
				updateContextMenuState();
				break;
			default:
		}
		
	}

	//WDEV-22773
	private void setSelectableRows()
	{
		for (int x=0; x<form.grdAppts().getRows().size() ;x++)
		{
			if (form.grdAppts().getRows().get(x).getValue().getTheatreBooking().getState() != null)
			{
				form.grdAppts().getRows().get(x).setSelectable(false);
			}
			else
			{
				form.grdAppts().getRows().get(x).setSelectable(true);
			}
		} 

	}

	@Override
	protected void onGrdSessionsSelectionChanged() throws PresentationLogicException
	{
		grdSessionsSelectionChanged();
	}

	private void grdSessionsSelectionChanged()
	{
		Sch_Session_Appointment_OrderVo voSessionApptOrder = domain.getSessionApptOrderBySession(form.grdSessions().getValue());
		clearInstanceControls();
		form.getLocalContext().setSessApptOrder(voSessionApptOrder);

		updateControlState();
		if (voSessionApptOrder == null)
		{
			engine.showMessage("No Appts Booked for this Session");
			return;
		}

		populateScreenFromData(voSessionApptOrder);
	}

	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		clearScreen();
//		form.btnEdit().setVisible(false); //WDEV-22773
	}

	private void clearScreen()
	{
		form.dteSession().setValue(null);
		form.grdSessions().getRows().clear();
		clearInstanceControls();
	}

	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		searchSessions();
	}

	private void searchSessions()
	{
		if (form.dteSession().getValue() == null)
		{
			engine.showErrors(new String[] { "Session Date is mandatory" });
			return;
		}

		form.grdSessions().getRows().clear();
		clearInstanceControls();

		SessionLiteVoCollection voCollSession = domain.listSessionByDate(form.dteSession().getValue());
		if (voCollSession != null)
		{
			for (SessionLiteVo voSession : voCollSession)
			{
				grdSessionsRow sRow = form.grdSessions().getRows().newRow();
				sRow.setColSession(voSession.getName());
				sRow.setValue(voSession);
			}
		}

		//WDEV-22773
//		if (form.getMode().equals(FormMode.VIEW))
//			form.btnEdit().setVisible(false);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
	}
}
