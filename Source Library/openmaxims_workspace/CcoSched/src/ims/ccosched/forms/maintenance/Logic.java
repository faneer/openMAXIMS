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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.20 build 40811.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.forms.maintenance;

import ims.alerts.PatientAlertCCO;
import ims.core.vo.PatientShort;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.dto.client.Lkup;
import ims.dto.client.Patient;
import ims.dto.client.Sd_appt;
import ims.dto.client.Sd_appt_dts;
import ims.dto.client.Sd_clinicview;
import ims.dto.client.Sd_prfile;
import ims.framework.delegates.CancelArgs;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.Time;
import ims.framework.utils.TimeFormat;
public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		clearPIDAndPatient();
		//Default to today
		form.Date().setValue(new Date());
		form.ListPatients().setEnabled(false);			
		EnableButtons(false);
		form.MainGrid().getRows().clear();

		if (form.Clinic().getValues().size() == 0)
		{
			
			Sd_prfile profiles;
			try
			{
				profiles = domain.listProfiles();
			}
			catch (DomainInterfaceException e)
			{
				displayMessage(e.getMessage());
				return;
			}
			
			//foreach (dto.Sd_prfileDTO.Sd_prfileClient profile in profiles.Sd_prfileCollection)
			for (int i = 0; i < profiles.DataCollection.count(); i++)
			{
				Sd_prfile.Sd_prfileRecord profile = profiles.DataCollection.get(i);
				form.Clinic().newRow(profile, profile.Prfile_desc);
			}
		}

		// Status
		if (form.Status().getValues().size() == 0)
		{
			Lkup lookupDto = null;;
			try
			{
				lookupDto = domain.getLookupInstance("3449");
			}
			catch (DomainInterfaceException e)
			{
				displayMessage(e.getMessage());
				return;
			}
		
			form.getLocalContext().setStatus(lookupDto);

			if (lookupDto.DataCollection.count() > 1)
			{
				form.Status().newRow("-1", "All Status");
				//03/06/2003 - ICCO705
				form.Status().newRow("-2", GetStatusText("-2189")+" / "+GetStatusText("-2196")+" / "+GetStatusText("-2192"));//Open/Arrived/Attended
			}
			for(int i=0; i<lookupDto.DataCollection.count(); i++)
			{
				if (lookupDto.DataCollection.get(i).Lkup_id == "-2189") // Open
					form.Status().newRow(lookupDto.DataCollection.get(i).Lkup_id, lookupDto.DataCollection.get(i).Lkup_nm + " / " + GetStatusText("-2196"));
				else if ((lookupDto.DataCollection.get(i).Lkup_id != "-2194") && // if not Arrived, Moved or Rebooked
					(lookupDto.DataCollection.get(i).Lkup_id != "-2195") &&
					(lookupDto.DataCollection.get(i).Lkup_id != "-2196"))
					form.Status().newRow(lookupDto.DataCollection.get(i).Lkup_id, lookupDto.DataCollection.get(i).Lkup_nm);
			}
			form.Status().setValue("-1"); // All Status is the default value.
		}
	}
	
	private void clearPIDAndPatient()
	{
		engine.clearAlertsByType(PatientAlertCCO.class);
		form.getGlobalContext().Core.setPatientShort(null);
	}
	
	private String GetStatusText(String lkup_id)
	{
		if(form.getLocalContext().getStatus() != null)
		{
			Lkup lookupDto = form.getLocalContext().getStatus();
			for(int i=0; i<lookupDto.DataCollection.count(); i++)
			{
				if (lookupDto.DataCollection.get(i).Lkup_id.equals(lkup_id))
					return lookupDto.DataCollection.get(i).Lkup_nm;
			}
		}

		return "";
	}
	private void EnableButtons(boolean flag)
	{
		if (flag == true)
		{
			form.UnArrive().setEnabled(false);
			form.UnAttend().setEnabled(false);
			form.InComplete().setEnabled(false);
			form.Complete().setEnabled(false);
			form.UnDNA().setEnabled(false);
			form.UnCancel().setEnabled(false);
			if (form.getLocalContext().getAppt_dtsDTO() != null)
			{
				if (form.getLocalContext().getAppt_dtsDTO().Appt_stat.equals("-2196")) // Arrived
				{
					form.UnArrive().setEnabled(true);
				}
				else if (form.getLocalContext().getAppt_dtsDTO().Appt_stat.equals("-2191")) // DNA
				{
					form.UnDNA().setEnabled(true);
				}
				else if ((form.getLocalContext().getAppt_dtsDTO().Appt_stat.equals("-2190")) || // Cancelled
					(form.getLocalContext().getAppt_dtsDTO().Appt_stat.equals("-2193")) || EnableUnCancelButton()) 
				{
					form.UnCancel().setEnabled(true);
				}
				else if (form.getLocalContext().getAppt_dtsDTO().Appt_stat.equals("-2192")) //Attended
				{
					form.UnAttend().setEnabled(true);
					if (form.getLocalContext().getAppt_dtsDTO().Act_comp_flg.equalsIgnoreCase("Y"))
						form.InComplete().setEnabled(true);
					else												
						form.Complete().setEnabled(true);						
				}				
			}
		}
		else
		{
			form.UnArrive().setEnabled(false);
			form.UnAttend().setEnabled(false);
			form.InComplete().setEnabled(false);
			form.Complete().setEnabled(false);
			form.UnDNA().setEnabled(false);
			form.UnCancel().setEnabled(false);
		}
	}
	private boolean EnableUnCancelButton()
	{
		Sd_appt_dts.Sd_appt_dtsRecord appt_dts = null;
		
		if(form.MainGrid().getSelectedRowIndex() >= 0)
			appt_dts = form.MainGrid().getValue(); 

		if(form.getGlobalContext().Core.getPatientShortIsNotNull() && appt_dts != null)
		{
			if(form.getGlobalContext().Core.getPatientShort().getDod() == null && appt_dts.Appt_stat.equals("-2197"))
			{
				return true;
			}
		}

		return false;
	}
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.MainGrid().getSelectedRowIndex() >= 0)
		{
			Sd_appt_dts.Sd_appt_dtsRecord tmp = form.MainGrid().getValue();
			onListPatientsClick();
			for (int i = 0; i < form.MainGrid().getRows().size(); ++i)
				if (form.MainGrid().getRows().get(i).getValue().Appt_head_id.equals(tmp.Appt_head_id) && 
					form.MainGrid().getRows().get(i).getValue().Appt_id.equals(tmp.Appt_id))
				{
					//Equivalent to Form.MainGrid.CurrentSelection = i;
					form.MainGrid().setValue(form.MainGrid().getRows().get(i).getValue());
					//Call manually GridSelectionChanged
					onMainGridSelectionChanged();
					break;
				}
		}
	}
	protected void onUnAttendClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sd_appt appointments = null;
		try
		{
			appointments = domain.getSd_appt(form.getLocalContext().getAppt_dtsDTO().Appt_head_id);
			appointments = domain.getForUpdate(appointments);
		}
		catch (DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}

		//foreach (dto.Sd_apptDTO.Appt_idClient app in appointments.Sd_apptCollection[0].Appt_idCollection)
		for (int i = 0; appointments != null && i < appointments.DataCollection.get(0).Appt_idCollection.count(); i++)
		{
			Sd_appt.Sd_apptAppt_idRecord app = appointments.DataCollection.get(0).Appt_idCollection.get(i);
			if (app.Appt_id.equals(form.getLocalContext().getAppt_dtsDTO().Appt_id))
			{					
				app.Appt_stat = "-2189"; //Open
				app.Tm_seen = "";//Utility.GetStringFromDate(SqlDateTime.Null);
				app.Appt_stat_reason = "";
				app.Act_comp_flg= "";
				//20/01/2005 - if appt_stat = -2189 then set the Inpat status to null
				app.Appinpatstat = null;
				break;
			}
		}
		
		try
		{
			domain.update(appointments);
		}
		catch(DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}
			
		int currentSelection = form.MainGrid().getSelectedRowIndex();
		onListPatientsClick();
		//Form.MainGrid.CurrentSelection = currentSelection;
		if(currentSelection < form.MainGrid().getRows().size())
		{
			form.MainGrid().setValue(form.MainGrid().getRows().get(currentSelection).getValue());
			onMainGridSelectionChanged();
		}
		displayMessage("UnAttend completed successfully.");
	}
	protected void onUnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sd_appt appointments;
		try
		{
			appointments = domain.getSd_appt(form.getLocalContext().getAppt_dtsDTO().Appt_head_id);
			appointments = domain.getForUpdate(appointments);
		}
		catch (DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}
		
		//foreach (dto.Sd_apptDTO.Appt_idClient t in appointments.Sd_apptCollection[0].Appt_idCollection)
		for(int i=0; i<appointments.DataCollection.get(0).Appt_idCollection.count(); i++)
		{
			Sd_appt.Sd_apptAppt_idRecord t = appointments.DataCollection.get(0).Appt_idCollection.get(i);
			if (t.Appt_id.equals(form.getLocalContext().getAppt_dtsDTO().Appt_id))					
			{					
				t.Hcp_booking1 = "";
				t.Appt_stat_reason = "";
				t.Appt_stat = "-2189"; // Open
				//20/01/2005 - if appt_stat = -2189 then set the Inpat status to null
				t.Appinpatstat = null;
				break;
			}
		}
		try
		{
			appointments = domain.update(appointments);
		}
		catch (DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}

		int currentSelection = form.MainGrid().getSelectedRowIndex();
		onListPatientsClick();
		//Form.MainGrid.CurrentSelection = currentSelection;
		if(currentSelection < form.MainGrid().getRows().size())
		{
			form.MainGrid().setValue(form.MainGrid().getRows().get(currentSelection).getValue());
			onMainGridSelectionChanged();
		}
		displayMessage("UnCancel completed successfully.");
	}
	protected void onUnDNAClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sd_appt appointments = null;
		try
		{
			appointments = domain.getSd_appt(form.getLocalContext().getAppt_dtsDTO().Appt_head_id);
		}
		catch (DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}
		
		//foreach (dto.Sd_apptDTO.Appt_idClient t in appointments.Sd_apptCollection[0].Appt_idCollection)
		for(int i=0; i<appointments.DataCollection.get(0).Appt_idCollection.count(); i++)
		{
			Sd_appt.Sd_apptAppt_idRecord t = appointments.DataCollection.get(0).Appt_idCollection.get(i);
			if (t.Appt_id.equals(form.getLocalContext().getAppt_dtsDTO().Appt_id))					
			{
				try
				{
					appointments = domain.getForUpdate(appointments);
				}
				catch (DomainInterfaceException e)
				{
					displayMessage(e.getMessage());
					return;
				}

				t.Appt_stat_reason = "";
				t.Appt_stat 	   = "-2189"; // Open
				t.Hcp_booking1 	   = "";
				//20/01/2005 - if appt_stat = -2189 then set the Inpat status to null
				t.Appinpatstat = null;

				try
				{
					domain.update(appointments);
				}
				catch (DomainInterfaceException e)
				{
					displayMessage(e.getMessage());
					return;
				}

				break;
			}
		}

		int currentSelection = form.MainGrid().getSelectedRowIndex();
		onListPatientsClick();
		if(currentSelection < form.MainGrid().getRows().size())
		{
			form.MainGrid().setValue(form.MainGrid().getRows().get(currentSelection).getValue());
			onMainGridSelectionChanged();
		}
		displayMessage("UnDNA completed successfully.");
	}
	protected void onCompleteClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().CcoSched.ClinicView.setApptDetails(form.MainGrid().getValue());
		engine.open(form.getForms().CcoSched.ClinicViewOutcomeComplete);	
	}
	protected void onInCompleteClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().CcoSched.ClinicView.setApptDetails(form.MainGrid().getValue());
		engine.open(form.getForms().CcoSched.ClinicViewOutcomeIncomplete);		
	}
	protected void onUnArriveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Sd_appt appointments = null;
		try
		{
			appointments = domain.getSd_appt(form.getLocalContext().getAppt_dtsDTO().Appt_head_id);
		}
		catch (DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}

		//foreach (dto.Sd_apptDTO.Appt_idClient t in appointments.Sd_apptCollection[0].Appt_idCollection)
		for(int i=0; appointments != null && i< appointments.DataCollection.get(0).Appt_idCollection.count(); i++)
		{
			Sd_appt.Sd_apptAppt_idRecord t = appointments.DataCollection.get(0).Appt_idCollection.get(i);
			if (t.Appt_id.equals(form.getLocalContext().getAppt_dtsDTO().Appt_id))					
			{
				try
				{
					appointments = domain.getForUpdate(appointments);
				}
				catch (DomainInterfaceException e)
				{
					displayMessage(e.getMessage());
					return;
				}

				t.Arr_tme  = "";//Utility.GetStringFromTime(SqlDateTime.Null);
				t.Att_stat = "";
				t.Hcp_booking1 = "";
				t.Appt_stat    = "-2189"; // Open
				//20/01/2005 - if appt_stat = -2189 then set the Inpat status to null
				t.Appinpatstat = null;

				try
				{
					appointments = domain.update(appointments);
				}
				catch (DomainInterfaceException e)
				{
					displayMessage(e.getMessage());
					return;
				}
				break;
			}		
		}
		int currentSelection = form.MainGrid().getSelectedRowIndex();
		onListPatientsClick();
		//Equivalent to form.MainGrid.CurrentSelection = currentSelection;
		if(currentSelection < form.MainGrid().getRows().size())
		{
			form.MainGrid().setValue(form.MainGrid().getRows().get(currentSelection).getValue());
			onMainGridSelectionChanged();
		}
		displayMessage("UnArrive completed successfully.");
	}
	protected void onMainGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setAppt_dtsDTO(form.MainGrid().getValue());
		form.getGlobalContext().CcoSched.ClinicView.setApptDetails(form.MainGrid().getValue());//Context.ContextClinicView.ApptDetails = Form.MainGrid.SelectedValue;
		form.getGlobalContext().CcoSched.ClinicView.setAppointmentHeaderID(form.MainGrid().getValue().Appt_head_id);//Context.ContextClinicView.AppointmentHeaderID = Form.MainGrid.SelectedValue.attAppt_head_id;
		form.getGlobalContext().CcoSched.ClinicView.setAppointmentID(form.MainGrid().getValue().Appt_id);//Context.ContextClinicView.AppointmentID = Form.MainGrid.SelectedValue.attAppt_id;

		//20/01/2005 Set the inpatient value
		form.getGlobalContext().CcoSched.ClinicView.setInpatient((isInpatient(form.MainGrid().getValue().Ploc))?"Y":"N");
		//----------------------------------
		Patient patient = null;
		try
		{
			// WDEV-14223
			// Build a Patient Short and set the id from grid
			PatientShort patVo = new PatientShort(new Integer(form.MainGrid().getValue().Patient), 0);
			ims.core.vo.Patient fullPatVo = domain.getPatient(patVo);
			if (fullPatVo != null)
			{
				form.getGlobalContext().Core.setPatientShort(fullPatVo);
			}
		}
		catch (DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}
		catch (StaleObjectException e) 
		{
			displayMessage(e.getMessage());
			return;
		}
		
		//Save the patient in the context before calling other services that might fail!!!!			
		form.getGlobalContext().CcoSched.PatientSearch.setAlive(new Boolean(true));

		form.getGlobalContext().CcoSched.ClinicView.setBookingComment(form.MainGrid().getValue().Appt_cmts);
		
		EnableButtons(true);
		
		setPIDTooltip();
	}
	
	private void setPIDTooltip()
	{
		engine.clearAlertsByType(ims.alerts.PatientAlertCCO.class);
		engine.addAlert(new ims.alerts.PatientAlertCCO(new ims.ccosched.Helper.PIDTooltip().getTooltip(form.getGlobalContext().Core.getPatientShort(), null, null)));
	}
	
	
	protected void onListPatientsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clear();
		
		String[] tmp = form.ClinicDetails().getValue();
		if (tmp == null)
		{
			displayMessage("Cannot find patients as Clinic Details is empty."); //WDEV-18762
			return;
		}
			
		String prfile_sess_id = tmp[0];//test value - 5482
		String prfiled_sess_id = null;
		String act_comp_flg = null;
		String appt_stat = null;
		
		if (!tmp[1].equals("-1"))
			prfiled_sess_id = tmp[1];
		if (form.Status().getValue() != null && !form.Status().getValue().equals("-1"))
		{
			if (form.Status().getValue().equals("-2189")) // When Open we want the Moved, Arrived and Rebooked as well.
				appt_stat = form.Status().getValue() + " || " + "-2194" + " || " + "-2195" + " || " + "-2196"; 
			else if(form.Status().getValue().equals("-2"))
			{
				//ICCO705
				appt_stat = "-2189|-2192|-2196";//Open/Arrived/Attended
				act_comp_flg = "~";
			}
			else
				appt_stat = form.Status().getValue();
		}

		Sd_appt_dts appointments;
		try
		{
			appointments = domain.listSd_appt_dts(prfile_sess_id, prfiled_sess_id, appt_stat, act_comp_flg);
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		for (int i = 0; i < appointments.DataCollection.count(); i++)
		{
			Sd_appt_dts.Sd_appt_dtsRecord appointment = appointments.DataCollection.get(i); 
			
			GenForm.MainGridRow row = form.MainGrid().getRows().newRow();
			row.setValue(appointment);
			if (appointment.First_appt_id.equals(appointment.Appt_id))
				row.setBooking(form.getImages().CcoSched.First);
			else if (appointment.Last_appt_id.equals(appointment.Appt_id))
				row.setBooking(form.getImages().CcoSched.Last);
			/*if (appointment.Attnd_asid.equals("-401") || appointment.Attnd_asid.equals("-402"))
				row.setInpatient(form.getImages().Scheduler.Inpatient);*/
			if(isInpatient(appointment.Ploc))
				row.setInpatient(form.getImages().CcoSched.Inpatient);
			Time apptTime = getTimeFromString(appointment.Stm);
			row.setAppointmentTime(apptTime == null ? "" : apptTime.toString());
			Time attTime = getTimeFromString(appointment.Att_tm);
			row.setAttendanceTime(attTime == null ? "" : attTime.toString());
			row.setHospitalNumber(appointment.Hospnum);
			String name = appointment.Titl + " " + appointment.Fnm1 + " " + appointment.Snm;
			row.setName(name);
			row.setTooltipForName(name);
			row.setTransport(appointment.Trans_typtxt);
			row.setTooltipForTransport(appointment.Trans_typtxt);
			row.setConsultant(appointment.Act_consulttxt);
			row.setTooltipForConsultant(appointment.Act_consulttxt);
			row.setCategory(appointment.Txcattypetxt);
			row.setTooltipForCategory(appointment.Txcattypetxt);
			row.setLocation(appointment.Att_stattxt);
			row.setTooltipForLocation(appointment.Att_stattxt);
			row.setStatus(appointment.Appt_stattxt);				
			row.setTooltipForStatus(appointment.Appt_stattxt);
			if (appointment.Act_comp_flg.equalsIgnoreCase("Y"))
				row.setCompleteIncomplete(form.getImages().CcoSched.Complete);
			else if (appointment.Act_comp_flg.equalsIgnoreCase("N"))
				row.setCompleteIncomplete(form.getImages().CcoSched.Incomplete);
			else 
				row.setCompleteIncomplete(null);
			if (appointment.Appt_stat.equals("-2196")) // Arrived
				row.setBackColor(Color.Tan);
		}
		if (form.MainGrid().getRows().size() == 0)
			displayMessage("No records.");
		
		form.NumBookings().setValue(String.valueOf(appointments.DataCollection.count()));
		EnableButtons(false);
	}
	protected void onListClinicDetailsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.ClinicDetails().clear();
		clear();
		
		if(getUIErrors())
			return;
		
		Sd_clinicview sessions;
		try
		{
			sessions = domain.listClinicDetails(form.Clinic().getValue().Prfile_id, form.Date().getValue().toString(DateFormat.ISO));
		}
		catch (DomainInterfaceException e)
		{
			displayMessage(e.getMessage());
			return;
		}
		for (int i = 0; i < sessions.DataCollection.count(); i++)
		{
			Sd_clinicview.Sd_clinicviewRecord session = sessions.DataCollection.get(i);
			
			Sd_clinicview tmp;
			try
			{
				tmp = domain.getClinicDetails(session.Prfile_sess_id);
			}
			catch (DomainInterfaceException e)
			{
				displayMessage(e.getMessage());
				return;
			}

			Sd_clinicview.Sd_clinicviewRecord obj = tmp.DataCollection.get(0);
			if (obj.Prfiled_sess_id1Collection.count() > 1)
				form.ClinicDetails().newRow(new String[]{session.Prfile_sess_id, "-1"}, "All Details");
			//foreach (dto.Sd_clinicviewDTO.Prfiled_sess_id1Client c in obj.Prfiled_sess_id1Collection)
			for (int j = 0; j < obj.Prfiled_sess_id1Collection.count(); j++)
			{
				Sd_clinicview.Sd_clinicviewPrfiled_sess_id1Record c = obj.Prfiled_sess_id1Collection.get(j); 
				
				String[] value = new String[]{obj.Prfile_sess_id, c.Prfiled_sess_id1};
				form.ClinicDetails().newRow(value, obj.Sess_desc + " " + c.Sessd_desc);
				if(i == 0)
					form.ClinicDetails().setValue(value);
			}
		}
		if (form.ClinicDetails().getValues().size() == 0)
			displayMessage("No records.");
		
		if (form.ClinicDetails().getValues().size() > 0)
			form.ListPatients().setEnabled(true);
		else
			form.ListPatients().setEnabled(false);

		EnableButtons(false);
	}
	private boolean getUIErrors()
	{
		StringBuilder errors = new StringBuilder();
		if(form.Clinic().getValue() == null)
			errors.append("Clinic Name is mandatory");
		
		if(form.Date().getValue() == null)
		{
			if(errors.length() > 0)
				errors.append("\n");
			errors.append("Date is mandatory");
		}

		if(errors.length() > 0)
		{
			engine.showMessage(errors.toString());
			return true;
		}
		
		return false;
	}

	private void clear()
	{
		form.MainGrid().getRows().clear();
		form.NumBookings().setValue("0");
	}
	private Time getTimeFromString(String value)
	{
		Time time = null;
		try
		{	time = new Time(value, TimeFormat.FLAT6);
		} catch (RuntimeException e)
		{
			time = null;
		}
		return time;
	}
	private void displayMessage(String message)
	{
		engine.showMessage(message);
	}
	protected void onFormClosing(CancelArgs args) throws PresentationLogicException 
	{
		//20/01/2005 - Clear the Inpatient flag - as the variable is persistant
		if(form.getGlobalContext().CcoSched.ClinicView.getInpatientIsNotNull())
			form.getGlobalContext().CcoSched.ClinicView.setInpatient(null);
	}
	private boolean isInpatient(String Ploc)
	{
		Integer ploc = GetInteger(Ploc);
		if(ploc == null || ploc.intValue() == 0)
			return false;
		else
			return true;
	}
	private Integer GetInteger(String val)
	{
		Integer newVal = null;
		if(val != null && !val.equals(""))
		{
			try{newVal = Integer.valueOf(val);}
			catch(NumberFormatException e)
			{engine.showMessage(e.getMessage());}
		}

		return newVal;	
	}
}
