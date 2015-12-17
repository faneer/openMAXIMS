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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.18 build 40701.1100)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.forms.bookingaction;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;

import ims.ccosched.forms.bookingaction.GenForm.gActionsRow;
import ims.dto.Result;
import ims.dto.client.Sd_sess_appts;
import ims.dto.client.Sd_sess_avail;
import ims.framework.controls.GridComboBox;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.StringUtils;
import ims.ccosched.ActionData.ActionData;
import ims.ccosched.ActionSession.ActionSession;

public class Logic extends BaseLogicDTO
{
	private static String error = "-1"; 
	private static ArrayList<String> initialActionID = new ArrayList<String>();  //WDEV-14335
	protected void OnFormOpen()
	{
		if(Open() == 0)
		{
			// If no records were retrieved display the screen in edit mode, ready to add a new record.
			form.setMode(FormMode.EDIT);
		}
	}
	protected void OnButtonCancel() throws ims.framework.exceptions.PresentationLogicException
	{
		// WDEV-14335
		ArrayList Dates = form.getGlobalContext().CcoSched.Booking.getCalendarSelectedDates();
		ActionSession actionSession;

		if (Dates != null)
		{
			for (int i = 0; i < Dates.size(); i++)
			{
				actionSession = (ActionSession) Dates.get(i);
				actionSession.setActionID(initialActionID.get(i));
			}
		}
		engine.close(DialogResult.CANCEL);
	}
	protected void OnButtonSave() throws ims.framework.exceptions.PresentationLogicException
	{
		//Check to see if there were errors
		GenForm.gActionsRow row;
		StringBuffer message = new StringBuffer();
		String msg = "";
		boolean bCloseDialog = true;
		for(int i=0; i<form.gActions().getRows().size(); i++)
		{
			row = form.gActions().getRows().get(i);
			if(row.getError() != null && row.getError().equals(error))
			{
				msg = row.getDate().toString(DateFormat.STANDARD) + ", \"" +  (row.getActions()!=null?GetActionName(row.getActions().toString()):"empty");
				if(message.length() == 0)
				{
					message.append("There are no sessions available for \r\n");
					message.append(msg);
					message.append("\" action");
				}
				else
				{
					message.append("\r\n");
					message.append(msg);
					message.append("\" action");
				}
				bCloseDialog = false;
			}
		}
		if(message.length() > 0)
			message.append(".");

		//"There are no sessions available for " + row.getDate().toString(DateFormat.STANDARD) + " and \"" +  GetActionName(row.getActions().toString()) + "\" action.")
		if(!bCloseDialog)
			ShowMessage(message.toString());
		
		if(bCloseDialog)
		{
			engine.close(DialogResult.OK);
		}
	}
	
	private int  Open()
	{
		//Populate the Actions combo
		PopulateActionCombo();		
		PopulateGrid();
		return 0;
	}
	private void PopulateActionCombo()
	{
		ArrayList actions = form.getGlobalContext().CcoSched.Booking.getSelectedActions();
		GridComboBox actionCbo = form.gActions().ActionsComboBox();
		for(int i=0; i < actions.size(); i++)
		{
			Object[] actionObj = (Object[])actions.get(i);
			actionCbo.newRow(actionObj[0].toString(), actionObj[1].toString());
		}
	}
	private void PopulateGrid()
	{
		form.gActions().getRows().clear();
		//Sort the array by date
		//SortSelectedDates();
		ArrayList Dates = form.getGlobalContext().CcoSched.Booking.getCalendarSelectedDates();
		
		ActionSession actionSession;
		if(Dates != null)
		{
			initialActionID.clear(); //WDEV-14335
				
			for(int i=0; i<Dates.size(); i++)
			{
				GenForm.gActionsRow row = form.gActions().getRows().newRow();
				actionSession = (ActionSession)Dates.get(i);
				initialActionID.add(actionSession.getAction().toString()); //WDEV-14335
				row.setDate(actionSession.getSessionDate());
				row.setTime(actionSession.getSessionTime());
				row.setActions(actionSession.getAction());
				row.setValue(actionSession.getAppt_id());
				row.setReadOnly(false);
			}
		}
	}
	private void SortSelectedDates()
	{
		ArrayList Dates = form.getGlobalContext().CcoSched.Booking.getCalendarSelectedDates();
		if(Dates == null || Dates.size() < 1)
			return;
		boolean bSorted;
		ActionSession actionSession1,actionSession2, tmpActionSession;
		do{
			bSorted = true;
		
			for(int i=0; i<Dates.size()-1; i++)
			{
				actionSession1 = (ActionSession)Dates.get(i);
				actionSession2 = (ActionSession)Dates.get(i+1);
				if(actionSession1.getSessionDate().isGreaterThan(actionSession2.getSessionDate()))
				{
					//Swap the actionSession
					bSorted = false;
					tmpActionSession = actionSession1;
					Dates.set(i, actionSession2);
					Dates.set(i+1, tmpActionSession);
				}
			}
			
		}while(!bSorted);
		form.getGlobalContext().CcoSched.Booking.setCalendarSelectedDates(Dates);
	}
	
	private String GetActionName(String ActionID)
	{
		ArrayList actions = form.getGlobalContext().CcoSched.Booking.getSelectedActions();
		for(int i=0; i < actions.size(); i++)
		{
			Object[] actionObj = (Object[])actions.get(i);
			if(actionObj[0].toString().equals(ActionID))
				return actionObj[1].toString();
		}
		return "";
	}
	
	private Date GetDateFromString(String date)
	{
		Date dt = null;
		if(date != null && (date.equals("")== false))
		{
			try{dt = new Date(date, DateFormat.ISO);}catch(ParseException e){ShowMessage(e.getMessage());}
		}
		return dt;
	}
	private void ShowMessage(String message)
	{
		engine.showMessage(message);
	}
	
	private Integer GetInteger(String val)
	{
		Integer newVal = null;
		if(val != null && !val.equals(""))
		{
			try{newVal = Integer.valueOf(val);}
			catch(NumberFormatException e)
			{ShowMessage(e.getMessage());}
		}

		return newVal;	
	}
	protected void onGActionsGridComboBoxSelectionChanged(int column, gActionsRow row, Object value) throws PresentationLogicException 
	{
		//get the ActionSession based on the date
		Hashtable session = new Hashtable();
		ArrayList selectedDates = form.getGlobalContext().CcoSched.Booking.getCalendarSelectedDates();
		ActionSession actionSession = getActionSession(row, selectedDates);
		if(actionSession != null)
		{
			if(row.getActions()!=null){
				session = getSessionAvailability(actionSession, row.getActions().toString());
				actionSession.setSession(session);
				actionSession.setActionID(row.getActions().toString());
			}
			if(session == null || session.size() == 0)
			{
				//error occured
				row.setError(error);
			}
			else
			{
				actionSession.setActionChanged(true);
				row.setError(null);
			}
			//Set back the context
			form.getGlobalContext().CcoSched.Booking.setCalendarSelectedDates(selectedDates);
		}
	}

	//Get the ActionSession corresponding to a unique date
	private ActionSession getActionSession(gActionsRow selRow, ArrayList selectedDates)
	{
		ActionSession actionSession = null;
		for(int j=0; j<selectedDates.size(); j++)
		{
			actionSession = (ActionSession)selectedDates.get(j);
			if(actionSession.getSessionDate().equals(selRow.getDate()))
			{
				if(actionSession.equals("") == false)
				{
					if(selRow.getValue() != null && selRow.getValue().equals(actionSession.getAppt_id()))
						return actionSession;
				}
				else
				{
					return actionSession;
				}
			}
		}
		return null;
	}
	private Hashtable getSessionAvailability(ActionSession actionSession, String ActionID)
	{
		ActionData actionData = actionSession.getActionData();
		Sd_sess_avail sessionAvailability = (Sd_sess_avail)domain.getDTOInstance(Sd_sess_avail.class);
		sessionAvailability.Filter.clear();
		sessionAvailability.Filter.Grp_id 	= actionData.getGroupID();
		sessionAvailability.Filter.Activ_id = actionData.getActivityID();
		sessionAvailability.Filter.Act_id 	= ActionID;
		sessionAvailability.Filter.Sess_dt  = actionSession.getSessionDate().toString(DateFormat.ISO);
		sessionAvailability.Filter.Mc_id 	= actionData.getResourceID();
		sessionAvailability.Filter.Lo_id 	= actionData.getListOwnerID();
		Result result = sessionAvailability.list();
		if (result != null)
		{
			ShowMessage(result.getMessage());
			return null;
		}

		Hashtable sessionList = new Hashtable();
		for(int k=0; k<sessionAvailability.DataCollection.count(); k++)
		{
			Sd_sess_avail.Sd_sess_availRecord sa = sessionAvailability.DataCollection.get(k);
			Date ddt = GetDateFromString(sa.Sess_dt);
			if (ddt == null)
			{	
				ShowMessage("Session date is null.");
				return null;
			}
			Date date = null;
			date = new Date(ddt.getYear(), ddt.getMonth(), ddt.getDay());
			Integer si = GetInteger(sa.Rem_tm);
			if (si == null)
			{
				ShowMessage("No value for remaining time.");
				return null;
			}
			int remaining = si.intValue();

			Integer totalTime = GetInteger(sa.Total_tm);
			if (totalTime == null)
			{
				ShowMessage("No value for total time.");
				return null;
			}
			int total = totalTime.intValue();
			if (remaining > total)
			{
				ShowMessage("Error calculating remaining or total time.");
				return null;
			}
			if (actionData.getListOwnerID() != null && actionData.getListOwnerID().equals("") == false)// form.ListOwner().getValue() != null
			{
				String[] sessions = sa.Sessiond_ids.split(",");
				String[] session = StringUtils.splitString(sessions[0],"+");//the index is form.getGlobalContext().CcoSched.Booking.getSessionIndex().intValue()
				Sd_sess_appts sessAppts = (Sd_sess_appts)domain.getDTOInstance(Sd_sess_appts.class);
				sessAppts.Filter.clear();
				sessAppts.Filter.Prfile_sess_id = session[0];
				sessAppts.Filter.Prfiled_sess_id = session[1];
				sessAppts.Filter.Loid = actionData.getListOwnerID();
				result = sessAppts.get();
				if (result == null)
				{
					for(int j=0; j< sessAppts.DataCollection.get(0).LoseqnoCollection.count(); j++)
					{
						Sd_sess_appts.Sd_sess_apptsLoseqnoRecord s = sessAppts.DataCollection.get(0).LoseqnoCollection.get(j);
						if (s.Mos_id.equalsIgnoreCase(actionData.getListOwnerID()))
						{
							Integer di1 = GetInteger(s.Lomaxnoapp);
							Integer di2 = GetInteger(s.Loremnoapp);
							if (di1 != null && di2 != null )
							{
								total = di1.intValue();
								remaining = di2.intValue();
								break;
							}
						}
					}						
				}
			}
			actionSession.setPercentage((int)((total - remaining) * 100.0f / total));
			if (sa.Sessiond_ids.length() == 0)
			{
				ShowMessage("No session details return for " + date.toString(DateFormat.STANDARD));
				return null;
			}
			if (sessionList.containsKey(date))
				sessionList.put(date.toString(DateFormat.ISO), sa.Sessiond_ids);
			else
				sessionList.put(date.toString(DateFormat.ISO), sa.Sessiond_ids);
		}
		//Warn the user about no sessions for the specific action
		if(sessionList.size() == 0)
		{
			ShowMessage("There are no sessions available for " + actionSession.getSessionDate().toString(DateFormat.STANDARD) + " and \"" +  GetActionName(ActionID) + "\" action.");
		}
		
		return sessionList;
	}
	
	private boolean furtherAppointment()
	{
		if(form.getGlobalContext().CcoSched.TreatmentPlan.getFurtherAppointmentIsNotNull() && 
		   form.getGlobalContext().CcoSched.TreatmentPlan.getFurtherAppointment().equals(Boolean.TRUE))
			return true;
		
		return false;
	}
}