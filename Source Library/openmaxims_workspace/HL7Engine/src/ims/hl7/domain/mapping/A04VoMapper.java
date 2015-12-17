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
package ims.hl7.domain.mapping;

import ims.core.vo.OutPatientAttendanceVo;
import ims.core.vo.Patient;
import ims.hl7.domain.EventResponse;
import ims.hl7.utils.HL7Errors;
import ims.hl7.utils.HL7Utils;
import ims.ocrr.vo.ProviderSystemVo;
import ims.scheduling.vo.lookups.Status_Reason;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v24.segment.EVN;

public class A04VoMapper extends VoMapper
{

	//WDEV-20112
//	public Message processEvent(Message msg, ProviderSystemVo providerSystem) throws HL7Exception
	public EventResponse processEvent(Message msg, ProviderSystemVo providerSystem) throws HL7Exception //WDEV-20112
	{
		return(processPatientAttendance(msg, providerSystem));
	}

	public Message populateMessage()
	{
		return null;
	}
	

	//WDEV-20112
//	private Message processPatientAttendance(Message msg, ProviderSystemVo providerSystem) throws HL7Exception
	private EventResponse processPatientAttendance(Message msg, ProviderSystemVo providerSystem) throws HL7Exception
	{
		Patient patVo;
		//WDEV-20112
		EventResponse response = new EventResponse(); //WDEV-20112
		
		try
		{
			patVo = savePatient(msg, providerSystem);
			//WDEV-20112
			response.setPatient(patVo); //WDEV-20112
		}
		catch (Exception ex)
		{
			//WDEV-20112
//			return HL7Utils.buildRejAck( msg.get("MSH"), "Exception: " + ex.getMessage(), HL7Errors.APP_INT_ERROR, toConfigItemArray(providerSystem.getConfigItems()));
			response.setMessage(HL7Utils.buildRejAck(msg.get("MSH"), "Exception: " + ex.getMessage(), HL7Errors.APP_INT_ERROR, toConfigItemArray(providerSystem.getConfigItems())));
			return response; //WDEV-20112
		}
		OutPatientAttendanceVo attVo;
		try
		{
			attVo = fillAttFromMsg(msg, getOrgLoc(), getHcpAdmin(),providerSystem);
			
			attVo.getPasEvent().setPatient(patVo);
			OutPatientAttendanceVo dbAttVo = getADT().getOutpatientAppointment(attVo.getPasEvent());
			if (dbAttVo == null)
				dbAttVo = attVo;  // Create a new outpatient appointment if one is not found
				
			// WDEV-13455 
			// For Patient Diary, send the recording user which is sent in EVN-5
			EVN evn = (EVN) msg.get("EVN");
			// WDEV-15884 Check not null!
			if (evn != null && evn.getOperatorID() != null && evn.getOperatorID().length > 0)
				dbAttVo.setRecordingUser(evn.getOperatorID()[0].getIDNumber().getValue());
			
			dbAttVo.setAppointmentStatus(Status_Reason.CLOSED);
			dbAttVo.getPasEvent().setPatient(patVo);
			String[] errs = dbAttVo.validate();
			if (errs != null)
			{
				throw new HL7Exception("Validation of Attendance failed. " + VoMapper.toDisplayString(errs));				
			}
			errs = patVo.validate();
			if (errs != null)
			{
				throw new HL7Exception("Validation of Patient failed. " + VoMapper.toDisplayString(errs));				
			}
			getADT().recordOPAttendance(patVo, dbAttVo, null);
		}
		catch (Exception ex)
		{
			//WDEV-20112
//			return HL7Utils.buildRejAck( msg.get("MSH"), "Exception: " + ex.getMessage(), HL7Errors.APP_INT_ERROR, toConfigItemArray(providerSystem.getConfigItems()));
			response.setMessage(HL7Utils.buildRejAck(msg.get("MSH"), "Exception: " + ex.getMessage(), HL7Errors.APP_INT_ERROR, toConfigItemArray(providerSystem.getConfigItems())));
			return response; //WDEV-20112
		}

		//WDEV-20112
//		Message ack = HL7Utils.buildPosAck( msg.get("MSH"), toConfigItemArray(providerSystem.getConfigItems()));
//		return ack;
		response.setMessage(HL7Utils.buildPosAck( msg.get("MSH"), toConfigItemArray(providerSystem.getConfigItems())));
		return response; //WDEV-20112
	}
	
}
