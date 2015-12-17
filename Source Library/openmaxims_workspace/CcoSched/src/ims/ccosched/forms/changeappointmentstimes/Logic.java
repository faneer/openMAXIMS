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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.15 build 40430.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.forms.changeappointmentstimes;

import ims.ccosched.forms.changeappointmentstimes.GenForm.DefaultGridRow;
import ims.ccosched.forms.changeappointmentstimes.GenForm.MainGridRow;
import ims.dto.Result;
import ims.dto.client.Sd_action;
import ims.dto.client.Sd_appt;
import ims.dto.client.Sd_appt_dts;
import ims.dto.client.Sd_sess_appts;
import ims.dto.client.Sd_sessconflicts;
import ims.dto.client.Sd_session;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FrameworkInternalException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.StringUtils;
import ims.framework.utils.Time;
import ims.framework.utils.TimeFormat;
import ims.framework.utils.TimeSpan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Logic extends BaseLogicDTO
{
	private String newline = new String("<br>");
	protected void onFormOpen()
	{
		form.DefaultGrid().setEnabled(true);
		form.DefaultGrid().setReadOnly(false);
		form.AvailabilityPattern().setEnabled(true);
		form.Pattern().setEnabled(true);
		form.Save().setEnabled(false);
		ShowControls(0);

		form.MainGrid().getRows().clear();
		form.AvailabilityPattern().clear();

//		#region populate grid
		for(int i=0; i<form.getGlobalContext().CcoSched.PatientAppointments.getChildren().size(); i++)
//		foreach (dto.Sd_appt_dtsDTO.Sd_appt_dtsClient app in form._GlobalContext.Scheduler.PatientAppointments.Children.Value)
		{
			Sd_appt_dts.Sd_appt_dtsRecord app = (Sd_appt_dts.Sd_appt_dtsRecord)form.getGlobalContext().CcoSched.PatientAppointments.getChildren().get(i);
			GenForm.MainGridRow row = form.MainGrid().getRows().newRow();
			Date ddt = GetDateFromString(app.Appt_dt);
			if (ddt == null)
			{
				ShowError("Appointment date is null");
				return;
			}
			row.setDate(ddt.toString(DateFormat.STANDARD));
			Time stm = GetTimeFromString(app.Stm);
			if (stm == null)
			{
				ShowError("Appointment start time is null");
				return;
			}
			row.setOldTime(stm.toString(TimeFormat.DEFAULT));
			row.setNewTime("");
			row.setValue(app);
		}
//		#endregion
//		#region populate pattern control
		Date min = new Date(maxDate);
		Date max = new Date(minDate);

		Hashtable ht = new Hashtable();
		Hashtable ht2 = new Hashtable();

		Result result = null;
		//foreach (dto.Sd_appt_dtsDTO.Sd_appt_dtsClient app in form._GlobalContext.Scheduler.PatientAppointments.Children.Value)
		for(int k=0; k<form.getGlobalContext().CcoSched.PatientAppointments.getChildren().size(); k++)
		{
			Sd_appt_dts.Sd_appt_dtsRecord app = (Sd_appt_dts.Sd_appt_dtsRecord)form.getGlobalContext().CcoSched.PatientAppointments.getChildren().get(k);
			Sd_sess_appts session = (Sd_sess_appts) domain.getDTOInstance(Sd_sess_appts.class);
			session.Filter.clear();
			session.Filter.Prfile_sess_id = app.Prfile_sess_id;
			session.Filter.Prfiled_sess_id = app.Prfiled_sess_id;

			result = session.get();
			if (result != null)
			{
				ShowError(result.getMessage());
				return;
			}
			if (session.DataCollection.count() != 1)
			{
				ShowError("Failed to get session (ID=" + app.Prfile_sess_id + ")");
				return;
			}
			Sd_sess_appts.Sd_sess_apptsRecord s = session.DataCollection.get(0);

			Date date = GetDateFromString(s.Sess_dt);
			if (date == null)
			{
				ShowError("Failed to get session date (ID=" + app.Prfile_sess_id + ")");
				return;
			}
			//Date date = dt.Value;

			Time startTime = GetTimeFromString(s.Stm);
			if (startTime == null)
			{
				ShowError("Internal error: Session start time not returned.");
				return;
			}
			//DateTime startTime = dt.Value;

			Time endTime = GetTimeFromString(s.Etm);
			if (endTime == null)
			{
				ShowError("Internal error: Session end time not returned.");
				return;
			}
			//DateTime endTime = dt.Value;
			//AddDate
						
			try
			{
				if (checkTime(new Time(8,0), startTime.copy()))
					form.AvailabilityPattern().addUnavailableTime(new Date(date), new Time(8,0), new Time(8,01));
				else
					form.AvailabilityPattern().addUnavailableTime(new Date(date), new Time(8,0), startTime.copy());
				
				if (checkTime(endTime.copy(), new Time(19,59)))
					form.AvailabilityPattern().addUnavailableTime(new Date(date), new Time(19,58), new Time(19,59));
				else
					form.AvailabilityPattern().addUnavailableTime(new Date(date), endTime.copy(), new Time(19,59));
			}
			catch (FrameworkInternalException fe)
			{
				engine.showMessage(fe.getMessage());
			}
			
			//form.AvailabilityPattern().addUnavailableTime(date, new Time(8,0), startTime);
			//form.AvailabilityPattern().addUnavailableTime(date, endTime, new Time(19,59));

			Integer di = GetIntegerFromString(s.Tno_appts);
			Integer di2 = GetIntegerFromString(s.Tno_fappts);

			int i1 = (di  == null? 0 : di.intValue());
			int i2 = (di2 == null? 0 : di2.intValue());

			if (!ht.containsKey(date))
			{
				ht.put(date, new Integer(i1));
				ht2.put(date, new Integer(i2));
			}
			else
			{
				int i = ((Integer)ht.get(date)).intValue();
				i += i1;
				ht.put(date, new Integer(i));

				int j = ((Integer)ht2.get(date)).intValue();
				j += i2;
				ht2.put(date, new Integer(j));
			}

			if (date.isLessThan(min)) min = new Date(date);
			if (date.isGreaterThan(max)) max = new Date(date);

			for(int m=0; m<s.Seqno2Collection.count(); m++)
			{
				Sd_sess_appts.Sd_sess_apptsSeqno2Record times = s.Seqno2Collection.get(m);
				Time startTime1 = GetTimeFromString(times.Stm2);
				if (startTime1 == null)
				{
					ShowError("Failed to get exluded start time (ID=" + app.Prfile_sess_id + ")");
					return;
				}

				Time endTime1 = GetTimeFromString(times.Etm2);
				if (endTime1 == null)
				{
					ShowError("Failed to get exluded end time (ID=" + app.Prfile_sess_id + ")");
					return;
				}
				
				try {
					form.AvailabilityPattern().addBookedTime(date, startTime1, endTime1);
				} catch (FrameworkInternalException e) {
					engine.showMessage(e.getMessage());
				}
			}

			for(int n=0; n<s.Seqno3Collection.count(); n++)
			{
				Sd_sess_appts.Sd_sess_apptsSeqno3Record times = s.Seqno3Collection.get(n);
				if ((times.Appt_stat.equals("-2190")==false) && (times.Appt_stat.equals("-2193")==false) && (times.Appt_stat.equals("-2197")==false)) //Cancelled
				{			
					Time startTime2 = GetTimeFromString(times.Appt_stm);
					if (startTime2 == null)
					{
						ShowError("Failed to get appointment start time (ID=" + app.Prfile_sess_id + ")");
						return;
					}

					Time endTime2 = GetTimeFromString(times.Appt_etm);
					if (endTime2 == null)
					{
						ShowError("Failed to get appointment end time (ID=" + app.Prfile_sess_id + ")");
						return;
					}
					try {
						form.AvailabilityPattern().addBookedTime(date, startTime2, endTime2);
					} catch (FrameworkInternalException e) {
						engine.showMessage(e.getMessage());
					}
				}
			}
		}
		form.AvailabilityPattern().setStartDate(new Date(min));
		form.AvailabilityPattern().setEndDate(new Date(max));

		Enumeration apptsKeys = ht.keys();
		while(apptsKeys.hasMoreElements())
		{
			Date date = (Date)apptsKeys.nextElement();
			StringBuffer sb = new StringBuffer(100);
			sb.append(date.toString(DateFormat.STANDARD));
			sb.append(newline);
			sb.append("First appointments: ");
			sb.append(ht2.get(date));
			sb.append(newline);
			sb.append("Total number of appointments: ");
			sb.append(ht.get(date));
			form.AvailabilityPattern().addTooltip(date, sb.toString());
		}
//		#endregion
//		#region get the Rounding for the Attendance Time
		Sd_session sess = (Sd_session) domain.getDTOInstance(Sd_session.class);
		sess.Filter.clear();
		sess.Filter.Prfile_sess_id = ((Sd_appt_dts.Sd_appt_dtsRecord)form.getGlobalContext().CcoSched.PatientAppointments.getChildren().get(0)).Prfile_sess_id;
		result = sess.get();
		if (result != null)
		{
			ShowError(result.getMessage());
			return;
		}
		if (sess.DataCollection.count() == 0)
		{
			ShowError("Session is not found.");
			return;
		}

		Time ddt2 = GetTimeFromString(sess.DataCollection.get(0).Stm);
		if (ddt2 == null)
		{
			ShowError("Session start time not returned.");
			return;
		}
		form.getLocalContext().setSessionStartTime(new Time(ddt2.getHour(), ddt2.getMinute(), ddt2.getSecond()));

		Integer si = GetIntegerFromString(sess.DataCollection.get(0).Tci_rnding_int);
		form.getLocalContext().setRounding(si == null? new Integer(0) : si);
//		#endregion

//Test		
/*		form.AvailabilityPattern().setEnabled(true);
		form.AvailabilityPattern().clear();
		Date date = new Date();
		Date tomorrow = new Date();
		Date afterTomorrow = new Date();
		tomorrow.setDay(date.getDay()+1);
		afterTomorrow.setDay(tomorrow.getDay()+1);
		Time time1 = new Time();
		Time time2 = new Time();
		Time time3 = new Time();
		time1.setHour(8);
		time1.setMinute(30);
		time2.setHour(17);
		time2.setMinute(30);
		time3.setHour(10);
		time3.setMinute(00);
		
		form.AvailabilityPattern().addBookedTime(date, time1, time2);
		form.AvailabilityPattern().addUnavailableTime(date, time1, time3);
		
		form.AvailabilityPattern().addBookedTime(tomorrow, time1, time2);
		form.AvailabilityPattern().addUnavailableTime(date, time1, time3);
		
		form.AvailabilityPattern().addBookedTime(afterTomorrow, time3, time2);
		
	   form.AvailabilityPattern().setStartDate(date);
		form.AvailabilityPattern().setEndDate(afterTomorrow);
		form.AvailabilityPattern().addTooltip(date,"today");
		form.AvailabilityPattern().addTooltip(tomorrow,"tomorrow");*/
	}

	private boolean checkTime(Time startTime, Time endTime)
	{
		int diff = TimeSpan.getTimeSpan(endTime, startTime).getMinutes();
		return(diff <= 0);
	}

	protected void OnPattern() throws PresentationLogicException 
	{
		ShowControls(0);
		form.MainGrid().setValue(null);//CurrentSelection = -1;
	}

	protected void OnDefaultTime(int column, DefaultGridRow row, boolean isChecked) throws PresentationLogicException 
	{
//		#region Deselect other default times
		if (isChecked)
		{
			for (int i = 0; i < form.DefaultGrid().getRows().size(); ++i)
			{
				if (form.DefaultGrid().getRows().get(i).getSelect() && (form.DefaultGrid().getRows().get(i).equals(row.getValue()) == false))
					form.DefaultGrid().getRows().get(i).setSelect(false);
			}
		}			
//		#endregion

//		#region Set selected time

		if (form.MainGrid().getSelectedRowIndex() > -1)
			form.MainGrid().getRows().get(form.MainGrid().getSelectedRowIndex()).setNewTime((isChecked ? row.getValue().toString(TimeFormat.DEFAULT) : ""));
		else
			for (int i = 0; i < form.MainGrid().getRows().size(); ++i)
				form.MainGrid().getRows().get(i).setNewTime((isChecked ? row.getValue().toString(TimeFormat.DEFAULT) : ""));
//		#endregion

//		#region Check conflicts
		if (isChecked)
		{
			form.Save().setEnabled(false);
			for (int k = 0; k < form.MainGrid().getRows().size(); ++k)
			{
				form.MainGrid().getRows().get(k).setBackColor(Color.White);
				form.MainGrid().getRows().get(k).setTextColor(Color.Black);
			}
			Sd_sessconflicts conflicts = (Sd_sessconflicts) domain.getDTOInstance(Sd_sessconflicts.class);
			conflicts.DataCollection.add();
			Sd_sessconflicts.Sd_sessconflictsRecord conflict = conflicts.DataCollection.get(0);
			if(form.getGlobalContext().CcoSched.getLoggedInUserIdIsNotNull())
				conflict.Userid = form.getGlobalContext().CcoSched.getLoggedInUserId();

			boolean rowSelected = false;
			for (int k = 0; k < form.MainGrid().getRows().size(); ++k)
			{
				MainGridRow mainGridRow;
			 	//WDEV-3501 - of a record selected, then check against that record only
				if(form.MainGrid().getSelectedRowIndex() >= 0)
				{
					mainGridRow = form.MainGrid().getSelectedRow();
					rowSelected = true;	
				}
				else
				{
					mainGridRow = form.MainGrid().getRows().get(k);
				}
				
				if (mainGridRow.getNewTime() != null)
				{
					Time time = GetTimeFromGridString(mainGridRow.getNewTime());
					int i = conflict.SeqnoCollection.add();
					Sd_sessconflicts.Sd_sessconflictsSeqnoRecord rep = conflict.SeqnoCollection.get(i);
					rep.Sessionid = mainGridRow.getValue().Prfile_sess_id;
					rep.Sessiondid = mainGridRow.getValue().Prfiled_sess_id;
					if(time != null)
					{
                        rep.App_stm = time.toString(TimeFormat.FLAT6);
                        if(form.getLocalContext().getTimeRequiredIsNotNull())
                            time.addMinutes(form.getLocalContext().getTimeRequired().intValue());
                        rep.App_etm = time.toString(TimeFormat.FLAT6);
                    }
				}
				
				if(rowSelected)
					break;
			}
			
			Result result = conflicts.transferData("VERIFY");
			if (result != null)
			{
				ShowError(result.getMessage());
				return;
			}

			conflict = conflicts.DataCollection.get(0);
			boolean flag = false;
//			foreach (dto.Sd_sessconflictsDTO.SeqnoClient rep in conflict.SeqnoCollection)
			for(int i=0; i<conflict.SeqnoCollection.count(); i++)
			{
				Sd_sessconflicts.Sd_sessconflictsSeqnoRecord rep = conflict.SeqnoCollection.get(i);
				for (int k = 0; k < form.MainGrid().getRows().size(); ++k)
				{
					if (form.MainGrid().getRows().get(k).getValue().Prfile_sess_id.equals(rep.Sessionid) && form.MainGrid().getRows().get(k).getValue().Prfiled_sess_id.equals(rep.Sessiondid))
					{
						if (rep.Timavail.equalsIgnoreCase("N") || rep.Userstatusflg.equals("N") || (rep.Userstatusflg.equals("U") && rep.Conflictflg.equals("Y")))
						{
							form.MainGrid().getRows().get(k).setBackColor(Color.Red);
							form.MainGrid().getRows().get(k).setTextColor(Color.White);
							flag = true;

						}
						if (rep.Userstatusflg.equals("S") && rep.Conflictflg.equals("Y"))
						{
							form.MainGrid().getRows().get(k).setBackColor(Color.MistyRose);
							form.MainGrid().getRows().get(k).setTextColor(Color.Black);
						}
					}
				}
			}
			form.Save().setEnabled(!flag);
		}
//		#endregion
	}

	protected void OnCancel() throws PresentationLogicException 
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void OnSave() throws PresentationLogicException 
	{
		Sd_appt appointments = form.getGlobalContext().CcoSched.PatientAppointments.getParent();
		Result result = appointments.getForUpdate();
		if (result != null)
		{
			ShowError(result.getMessage());
			return;
		}

		//foreach (dto.Sd_apptDTO.Appt_idClient app in appointments.Sd_apptCollection[0].Appt_idCollection)
		for(int j=0; j<appointments.DataCollection.get(0).Appt_idCollection.count(); j++)
		{
			Sd_appt.Sd_apptAppt_idRecord app = appointments.DataCollection.get(0).Appt_idCollection.get(j);
			for (int i = 0; i < form.MainGrid().getRows().size(); ++i)
			{
				if (form.MainGrid().getRows().get(i).getNewTime() != null)
				{
					if (app.Appt_id.equals(form.MainGrid().getRows().get(i).getValue().Appt_id))
					{
						Time time = GetTimeFromGridString(form.MainGrid().getRows().get(i).getNewTime());
						if(time != null)
						{	
                            app.App_stm = time.toString(TimeFormat.FLAT6);//Utility.GetStringFromTime(time);

                            //Bug reported by Kevin (make a clone to the start time and leave it unchanged when passed to GetRoundingTime method)
                            Time endTime = time.copy(); 
    						if(form.getLocalContext().getTimeRequiredIsNotNull())
                                endTime.addMinutes(form.getLocalContext().getTimeRequired().intValue());
    						app.App_etm = endTime.toString(TimeFormat.FLAT6);

    						int rounding = form.getLocalContext().getRounding()!=null?form.getLocalContext().getRounding().intValue():0;
    						app.Att_tm = (rounding == 0 ? app.App_stm : (GetRoundingTime(rounding, time)).toString(TimeFormat.FLAT6));
                        }
					}
				}
			}
		}

		result = appointments.update();
		if (result != null)
		{
			ShowError(result.getMessage());
			return;
		}

		engine.close(DialogResult.OK);
	}

	private void CreateSlots(Time border, Sd_appt_dts.Sd_appt_dtsRecord firstApp)
	{
		form.DefaultGrid().getRows().clear();
	
	//	#region Get required time for the action
		Result result = null;
		if (!form.getLocalContext().getTimeRequiredIsNotNull())
		{
			Sd_action actions = (Sd_action) domain.getDTOInstance(Sd_action.class);
			actions.Filter.clear();
			actions.Filter.Action_id = firstApp.Action_id;
			result = actions.get();
			if (result != null)
			{
				ShowError(result.getMessage());
				return;
			}
			if (actions.DataCollection.count() != 1)
			{
				ShowError("Action is not found");
				return;
			}
	
			Integer di = GetIntegerFromString(actions.DataCollection.get(0).Tim_req);
			if (di == null)
			{
				ShowError("Time required is null");
				return;
			}
			form.getLocalContext().setTimeRequired(new Integer(di.intValue()));
		}
		int timeRequired = form.getLocalContext().getTimeRequired().intValue();
//		#endregion
		
		Sd_sess_appts sessionAppointments = (Sd_sess_appts) domain.getDTOInstance(Sd_sess_appts.class);
		sessionAppointments.Filter.clear();
		sessionAppointments.Filter.Prfile_sess_id = firstApp.Prfile_sess_id;
		sessionAppointments.Filter.Prfiled_sess_id = firstApp.Prfiled_sess_id;
		if(form.getGlobalContext().CcoSched.getLoggedInUserIdIsNotNull())
			sessionAppointments.Filter.Userrights = form.getGlobalContext().CcoSched.getLoggedInUserId();
		//15/08/2003 - Bug not logged - "list owner is not found." error message displayed even list owner exists
		if(!firstApp.Lo_id.equals(""))
			sessionAppointments.Filter.Loid   = firstApp.Lo_id;
		result = sessionAppointments.get();
		if (result != null)
		{
			ShowError(result.getMessage());
			return;
		}
		if (sessionAppointments.DataCollection.count() == 0)
		{
			ShowError("No data return for session.");
			return;
		}
		Sd_sess_appts.Sd_sess_apptsRecord sessionAppointment = sessionAppointments.DataCollection.get(0);
	
		Time startTime = GetTimeFromString(sessionAppointment.Stm);
		if (startTime == null)
		{
			ShowError("Session start time not returned.");
			return;
		}
	
		Time endTime = GetTimeFromString(sessionAppointment.Etm);
		if (endTime == null)
		{
			ShowError("Session end time not returned.");
			return;
		}
	//
	//	#region 1. find booked periods
		ArrayList bookedPeriods = new ArrayList();
		for(int m=0; m<sessionAppointment.Seqno3Collection.count(); m++)
		{
			Sd_sess_appts.Sd_sess_apptsSeqno3Record r = sessionAppointment.Seqno3Collection.get(m);
			if (!r.Appt_stat.equals("-2190") && !r.Appt_stat.equals("-2193") && !r.Appt_stat.equals("-2197")) //Cancelled
			{
				Time startTimeBooked = GetTimeFromString(r.Appt_stm);
				if (startTimeBooked == null)
				{
					ShowError("Appointment start time not returned.");
					return;
				}
	
				Time endTimeBooked = GetTimeFromString(r.Appt_etm);
				if (endTimeBooked == null)
				{
					ShowError("Appointment end time not returned.");
					return;
				}
	
				boolean self = r.Pkey.equals(firstApp.Pkey);
				ArrayList intersectedPeriods = new ArrayList();
				for(int i=0; i<bookedPeriods.size(); i++)
				{
					Object[] period = (Object[]) bookedPeriods.get(i);  
					if (startTimeBooked.isLessThan((Time)period[1]) && endTimeBooked.isGreaterThan((Time)period[0]))
						intersectedPeriods.add(period);
				}
				
				Time min = startTimeBooked.copy();
				Time max = endTimeBooked.copy();
				for(int i=0; i<intersectedPeriods.size(); i++)
				{
					Object[] period = (Object[]) intersectedPeriods.get(i);
					if (((Time)period[0]).isLessThan(min))
						min = ((Time)period[0]).copy();
					if (((Time)period[1]).isGreaterThan(max))
						max = ((Time)period[1]).copy();
				}
				int i = 1;
				for(int j=0;j<intersectedPeriods.size(); j++)
				{
					Object[] o = (Object[]) intersectedPeriods.get(j);
					i += ((Integer)o[2]).intValue();
					self |= ((Boolean)o[3]).booleanValue();
					bookedPeriods.remove(o);
				}
	
				bookedPeriods.add(new Object[]{min, max, new Integer(i), new Boolean(self)});
			}
		}
	//	#endregion
	
	//	#region 2. find exluded periods
		ArrayList excludedPeriods = new ArrayList();
		//foreach (dto.Sd_sess_apptsDTO.Seqno2Client r in sessionAppointment.Seqno2Collection)
		for(int i=0;i<sessionAppointment.Seqno2Collection.count(); i++)
		{
			Sd_sess_appts.Sd_sess_apptsSeqno2Record r = sessionAppointment.Seqno2Collection.get(i);
			Time startTimeExclusion = GetTimeFromString(r.Stm2);
			if (startTimeExclusion == null)
			{
				ShowError("failed to get exclusion time record.");
				return;
			}
	
			Time endTimeExclusion = GetTimeFromString(r.Etm2);
			if (endTimeExclusion == null)
			{
				ShowError("failed to get exclusion time record.");
				return;
			}
	
			ArrayList intersectedPeriods = new ArrayList();
			for(int j=0; j<intersectedPeriods.size(); j++)
			{
				Time[] period = (Time[])excludedPeriods.get(j);
				if (startTimeExclusion.isLessOrEqualThan((Time)period[1]) && endTimeExclusion.isGreaterOrEqualThan((Time)period[0]))
					intersectedPeriods.add(period);
			}
	
			Time min = startTimeExclusion.copy();//.getHour(), startTimeExclusion.getMinute(), startTimeExclusion.getSecond());
			Time max = endTimeExclusion.copy();//getHour(), endTimeExclusion.getMinute(), endTimeExclusion.getSecond());
			for(int j=0; j<intersectedPeriods.size(); j++)
			{
				Time[] period = (Time[])intersectedPeriods.get(j);
				if ((period[0]).isLessThan(min))
					min = period[0].copy();
				if ((period[1]).isGreaterThan(max))
					max = period[1].copy();
			}
			for(int j=0; j<intersectedPeriods.size(); j++)
				excludedPeriods.remove(intersectedPeriods);
	
			excludedPeriods.add(new Time[]{min, max});
		}
	//	#endregion
	
	//	#region 3. find purely exluded periods
		ArrayList tmpArr = new ArrayList();
		for(int i=0; i<bookedPeriods.size(); i++)
		//foreach (object[] bookedPeriod in bookedPeriods)
		{
			Object[] bookedPeriod = (Object[]) bookedPeriods.get(i);
			Time s = (Time)bookedPeriod[0];
			Time e = (Time)bookedPeriod[1];
	
			tmpArr.clear();
			for(int j=0; j<excludedPeriods.size(); j++)
				tmpArr.add(excludedPeriods.get(j));
			excludedPeriods.clear();

			for(int j=0; j<tmpArr.size(); j++)
			{
				Time[] excludedPeriod = (Time[]) tmpArr.get(j);
				if (s.isGreaterThan(excludedPeriod[1]) || e.isLessThan(excludedPeriod[0]))
					excludedPeriods.add(excludedPeriod);
				else if (s.isGreaterOrEqualThan(excludedPeriod[0]) && s.isLessOrEqualThan(excludedPeriod[1]) && e.isGreaterThan(excludedPeriod[1]))
					excludedPeriods.add(new Time[]{excludedPeriod[1], e});
				else if (s.isLessThan(excludedPeriod[0]) && e.isGreaterOrEqualThan(excludedPeriod[0]) && e.isLessOrEqualThan(excludedPeriod[1]))
					excludedPeriods.add(new Time[]{s, excludedPeriod[0]});
				else if (s.isGreaterThan(excludedPeriod[0]) && s.isLessThan(excludedPeriod[1]) && e.isGreaterThan(excludedPeriod[0]) && e.isLessThan(excludedPeriod[1]))
				{
					excludedPeriods.add(new Time[]{excludedPeriod[0], s});
					excludedPeriods.add(new Time[]{e, excludedPeriod[1]});
				}
			}
		}
	//	#endregion
	
	//	#region 4. find HCP period
		Time startTimeListOwner = null;
		Time endTimeListOwner 	= null;
		if (!firstApp.Lo_id.equals(""))
		{
			for(int j=0; j<sessionAppointment.LoseqnoCollection.count(); j++)
			//foreach ( dto.Sd_sess_apptsDTO.LoseqnoClient listOwner in sessionAppointment.LoseqnoCollection)
			{
				Sd_sess_appts.Sd_sess_apptsLoseqnoRecord listOwner = sessionAppointment.LoseqnoCollection.get(j);
				if (listOwner.Mos_id.equals(firstApp.Lo_id))//wdev-14848
				{
					startTimeListOwner = GetTimeFromString(listOwner.Stm1);
					if (startTimeListOwner == null)
					{
						ShowError("start time for list owner is not supplied.");
						return;
					}
					//startTimeListOwner = new SqlDateTime(ddt.Value);
	
					endTimeListOwner = GetTimeFromString(listOwner.Etm1);
					if (endTimeListOwner == null)
					{
						ShowError("end time for list owner is not supplied.");
						return;
					}
					//endTimeListOwner = new SqlDateTime(ddt.Value);
					break;
				}
			}
			if (startTimeListOwner == null)
			{
				ShowError("list owner is not found.");
				return;
			}
		}
	//	#endregion
	//
	//	#region 5. create slots
		boolean flag = true;
		
		if (sessionAppointment.Userrights.equals("-100"))
			flag = false;
		else if (!firstApp.Lo_id.equals("") && sessionAppointment.Userrights.equals("-101"))
			for(int j=0; j<sessionAppointment.LoseqnoCollection.count(); j++)
			{
				//foreach (dto.Sd_sess_apptsDTO.LoseqnoClient listOwner in sessionAppointment.LoseqnoCollection)
				Sd_sess_appts.Sd_sess_apptsLoseqnoRecord listOwner =  sessionAppointment.LoseqnoCollection.get(j);
				if (listOwner.Mos_id.equals(firstApp.Lo_id))//wdev-14848
				{
					Integer si = GetIntegerFromString(listOwner.Loremnoapp);
					if (si != null && si.intValue() == 0)
						flag = false;
					break;
				}
			}
		if (flag)
		{
			Time slotStartTime = startTime.copy();
			while (true)
			{
				Time slotEndTime = slotStartTime.copy();
				slotEndTime.addMinutes(timeRequired);
				if (slotEndTime.isGreaterThan(endTime))
					break;
	
				flag = false;
				if (sessionAppointment.Userrights.equals("-102"))
					flag = true;
				else
				{
					if (firstApp.Lo_id.equals(""))
						flag = true;
					else
					{
						if (startTimeListOwner.isLessOrEqualThan(slotStartTime) && slotStartTime.isLessThan(endTimeListOwner))
							flag = true;
						else
							slotStartTime = slotEndTime.copy();
					}
				}
	
	
				if (flag)
				{
					GenForm.DefaultGridRow row = null;
					if (slotStartTime.isGreaterThan(border))
					{
						row = form.DefaultGrid().getRows().newRow();
						row.setValue(slotStartTime);
						row.setSlots(slotStartTime.toString(TimeFormat.DEFAULT));//ToString("HH:mm")
						if (startTimeListOwner != null)
						{
							if (startTimeListOwner.isLessOrEqualThan(slotStartTime) && slotStartTime.isLessThan(endTimeListOwner))
								row.setBackColor(Color.LightYellow);
						}
					}					
	
					flag = true;
					//foreach (object[] bookedPeriod in bookedPeriods)
					for(int j=0; j<bookedPeriods.size(); j++)
					{	
						Object[] bookedPeriod = (Object[]) bookedPeriods.get(j);
						if (slotStartTime.isLessThan((Time)bookedPeriod[1]) && slotEndTime.isGreaterThan((Time)bookedPeriod[0]))
						{
							if (row != null)
							{
								row.setStatus("Booked (" + bookedPeriod[2].toString() + ")");
								row.setBackColor(Color.White);//((bool)bookedPeriod[3] ? Color.PaleTurquoise : Color.White);
							}
							slotStartTime = ((Time)bookedPeriod[1]).copy();
							flag = false;
							break;
						}
					}
					if (flag)
					{
						//foreach (DateTime[] excludedPeriod in excludedPeriods)
						for(int j=0; j<excludedPeriods.size(); j++)
						{
							Time[] excludedPeriod = (Time[]) excludedPeriods.get(j); 
							if (slotStartTime.isLessThan(excludedPeriod[1]) && slotEndTime.isGreaterThan(excludedPeriod[0]))
							{
								if (row != null)
								{
									row.setStatus("Excluded");
									row.setBackColor(Color.LightGray);
								}
								slotStartTime = ((Time)excludedPeriod[1]).copy();
								flag = false;
								break;
							}
						}
						if (flag)
						{
							if (row != null)
								row.setStatus("Available");
							slotStartTime = slotEndTime.copy();
						}
					}
				}
			}
		}
	//	#endregion
	
		ShowControls(1);
	}

	protected void OnMainGrid() throws PresentationLogicException 
	{
		Time ddt = new Time(8, 0, 0);//String.Format("{0:D2}{1:D2}{2:D2}", 8, 0, 0));
		if (ddt == null)
		{
			ShowError("Wrong time format");
			return;
		}
		CreateSlots(ddt, form.MainGrid().getValue());
		
	}

	protected void OnAvailabilityPatternClick(Time value) throws PresentationLogicException 
	{
		if (value.getHour() != 8 || value.getMinute() != 0)
			value.addMinutes(-30);

		Time ddt = new Time(value.getHour(), value.getMinute(), 0);
		if (ddt == null)
		{
			ShowError("Wrong time format");
			return;
		}
		CreateSlots(ddt, (Sd_appt_dts.Sd_appt_dtsRecord)form.getGlobalContext().CcoSched.PatientAppointments.getChildren().get(0));
	}
	
	private void ShowControls(int state)
	{
		form.AvailabilityPattern().setVisible(state == 0);
		form.DefaultGrid().setVisible(state == 1);
		form.Pattern().setVisible(state == 1);
	}
	
	private Time GetRoundingTime(int rounding, Time time)
	{		
		int i;
		int hour = time.getHour();
		int min;
		String minStr;
		int remainder = 60%rounding;
		if (remainder != 0)
		{
			if (time.getMinute() < rounding)
			{
				if (time.getHour() == form.getLocalContext().getSessionStartTime().getHour())
					return form.getLocalContext().getSessionStartTime();

				time.addHours(-1);
				hour = time.getHour();
				for (i =60; (i%rounding) != 0; i--) {}
					min = i;
			}				
			else
			{
				for (i = 0; (rounding * (i+1)) <= time.getMinute(); i++) {}
				min = rounding * i;	
			}
		}
		else
		{
			for (i = 0; (rounding * (i+1)) <= time.getMinute(); i++) {}					
			min = rounding * i;	
		}

		if (min <= 9)
			minStr = "0" + Integer.toString(min);
		else
			minStr = Integer.toString(min);

		Time ddt = GetTimeFromString(String.valueOf(hour) +  minStr + "00");
		if (ddt == null)
		{
			ShowError("Wrong time format.");
			return new Time(0,0);
		}
		return ddt;
	}
	
	private Date GetDateFromString(String date)
	{
		Date dt = null;
		if(date != null && date.equals("") == false)
		try{dt = new Date(date, DateFormat.ISO);}catch(ParseException e){ShowError(e.getMessage());}
		return dt;
	}
	
	private Time GetTimeFromString(String time)
	{
		Time tm = null;
		if(time != null && (time.equals("") == false))
		{
			try{ tm = new Time(time, TimeFormat.FLAT6);}catch(RuntimeException e){ShowError(e.getMessage());}
		}
		return tm;
	}
	
	private Integer GetIntegerFromString(String val)
	{
		Integer newVal = null;
		if(val != null && val.length() > 0)
		{
			try{newVal = Integer.valueOf(val);}
			catch(NumberFormatException e)
			{e.printStackTrace();}
		}

		return newVal;	
	}
	
	//Returns a Time from a String in hh:mm format
	private Time GetTimeFromGridString(String gridTime)
	{
		if(gridTime != null)
		{
			String newTime[] = StringUtils.splitString(gridTime, ":");
			if(newTime != null && newTime.length==2)
				return GetTimeFromString(newTime[0] + newTime[1] + "00");
		}
		
		return null; 
	}
		
	private void ShowError(String error)
	{
		engine.showMessage(error);
	}
				
	private Date minDate = new Date(1, 1, 1);
	private Date maxDate = new Date(9999, 12, 31);
}
