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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.65 build 3218.18820)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.domain.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import ims.admin.domain.PatientKioskConfig;
import ims.admin.domain.impl.PatientKioskConfigImpl;
import ims.admin.vo.PatientKioskAppointmentVo;
import ims.admin.vo.PatientKioskAppointmentVoCollection;
import ims.admin.vo.PatientKioskBookingVo;
import ims.admin.vo.PatientKioskBookingVoCollection;
import ims.admin.vo.PatientKioskPatientVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PatientKioskSettingsVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.PatientShortAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.enumerations.SystemLogType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.Time;
import ims.scheduling.domain.PatientAppointmentManagement;
import ims.scheduling.domain.base.impl.BasePatientKioskOperationsImpl;
import ims.scheduling.vo.Booking_AppointmentShortVo;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.Booking_AppointmentVoCollection;
import ims.scheduling.vo.domain.Booking_AppointmentShortVoAssembler;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.lookups.Status_Reason;

public class PatientKioskOperationsImpl extends BasePatientKioskOperationsImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Return all the patients with appointments for today based on filters
	*/
	public ims.admin.vo.PatientKioskBookingVoCollection listPatientKioskBookingsForToday(String surname, ims.framework.utils.Date dateOfBirth, Integer genderId, String kioskId)
	{
		this.createSystemLogEntry(SystemLogType.KIOSK, SystemLogLevel.INFORMATION, "List Patients (kiosk ID: " + kioskId + ")");
		
		DomainFactory factory = getDomainFactory();
		Date today = new Date();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		StringBuffer hql = new StringBuffer();
		String query = "from Booking_Appointment as BA where BA.apptStatus.id = :apptSt and (DATEPART(yyyy,BA.appointmentDate) = :yearOfToday) and (DATEPART(mm,BA.appointmentDate) = :monthOfToday) and (DATEPART(dd,BA.appointmentDate) = :dayOfToday) ";
		
		markers.add("apptSt");
		values.add(Status_Reason.BOOKED.getId());
		
		markers.add("yearOfToday");
		values.add(today.getYear());
		
		markers.add("monthOfToday");
		values.add(today.getMonth());
		
		markers.add("dayOfToday");
		values.add(today.getDay());
		
		if(surname != null)
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("BA.patient.name.surname = :surname");
			markers.add("surname");
			values.add(surname);
		}
		
		if(dateOfBirth != null)
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("BA.patient.dob = :dobP");
			markers.add("dobP");
			
			Integer dobPatient = 10000*dateOfBirth.getYear() + 100*dateOfBirth.getMonth() + dateOfBirth.getDay(); 
			values.add(dobPatient);
		}
		
		if(genderId != null)
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append(" BA.patient.sex.id = :sex");
			markers.add("sex");
			values.add(genderId);
		}
		
		hql.append(" order by BA.apptStartTime");
	
		query += hql.toString();
		List bookingAppointmentList = factory.find(query, markers, values);
		
		Booking_AppointmentVoCollection bookingAppointmentCol = Booking_AppointmentVoAssembler.createBooking_AppointmentVoCollectionFromBooking_Appointment(bookingAppointmentList);
		
		PatientKioskBookingVoCollection patientKioskBookingCol = new PatientKioskBookingVoCollection();
		
		if(bookingAppointmentCol.size() > 0)
		{
			for(int i=0; i<bookingAppointmentCol.size(); i++)
			{
				if(bookingAppointmentCol.get(i) != null && bookingAppointmentCol.get(i).getPatientIsNotNull() && bookingAppointmentCol.get(i).getPatient().getID_PatientIsNotNull())
				{
					if(patientIsNotAdded(patientKioskBookingCol, bookingAppointmentCol.get(i).getPatient().getID_Patient()))
					{
						addNewPatientKioskBooking(patientKioskBookingCol, bookingAppointmentCol.get(i));
					}
					else
					{
						addNewAppointmentToPatient(patientKioskBookingCol, bookingAppointmentCol.get(i));
					}
				}
			}
		}
		
		return patientKioskBookingCol;
	}

	private void addNewAppointmentToPatient(PatientKioskBookingVoCollection patientKioskBookingCol,	Booking_AppointmentVo booking_AppointmentVo) 
	{
		if(patientKioskBookingCol == null)
			throw new CodingRuntimeException("Cannot add on a null collection!");
		
		if(booking_AppointmentVo == null)
			return;
		
		for(int i=0; i<patientKioskBookingCol.size(); i++)
		{
			if(patientKioskBookingCol.get(i) != null && patientKioskBookingCol.get(i).getPatientIsNotNull() && patientKioskBookingCol.get(i).getPatient().getIDIsNotNull() 
					&& booking_AppointmentVo.getPatientIsNotNull() && booking_AppointmentVo.getPatient().getID_PatientIsNotNull() 
						&& patientKioskBookingCol.get(i).getPatient().getID() == booking_AppointmentVo.getPatient().getID_Patient())
			{
				PatientKioskAppointmentVo newAppointment = new PatientKioskAppointmentVo();
				
				newAppointment.setName(booking_AppointmentVo.getSessionIsNotNull() ? booking_AppointmentVo.getSession().getName() : null);
				newAppointment.setDate(booking_AppointmentVo.getAppointmentDate());
				newAppointment.setTime(booking_AppointmentVo.getApptStartTime());
				newAppointment.setID(booking_AppointmentVo.getID_Booking_Appointment());
				
				if(patientKioskBookingCol.get(i).getAppointmentsIsNotNull())
				{
					patientKioskBookingCol.get(i).getAppointments().add(newAppointment);
				}
				else
				{
					PatientKioskAppointmentVoCollection newAppointmentCol = new PatientKioskAppointmentVoCollection();
					newAppointmentCol.add(newAppointment);
					
					patientKioskBookingCol.get(i).setAppointments(newAppointmentCol);
				}
			}
		}
	}

	private void addNewPatientKioskBooking(PatientKioskBookingVoCollection patientKioskBookingCol, Booking_AppointmentVo booking_AppointmentVo) 
	{
		if(patientKioskBookingCol == null)
			throw new CodingRuntimeException("Cannot add on a null collection!");
		
		if(booking_AppointmentVo == null)
			return;
		
		PatientKioskPatientVo newPatient = null;
		
		if(booking_AppointmentVo.getPatientIsNotNull())
		{
			newPatient = populatePatientKioskFromBookingAppointment(booking_AppointmentVo.getPatient());
		}
		
		if(newPatient != null)
		{
			PatientKioskAppointmentVoCollection newAppointmentCol = new PatientKioskAppointmentVoCollection();
			PatientKioskAppointmentVo newAppointment = new PatientKioskAppointmentVo();
			
			newAppointment.setName(booking_AppointmentVo.getSessionIsNotNull() ? booking_AppointmentVo.getSession().getName() : null);
			newAppointment.setDate(booking_AppointmentVo.getAppointmentDate());
			newAppointment.setTime(booking_AppointmentVo.getApptStartTime());
			newAppointment.setID(booking_AppointmentVo.getID_Booking_Appointment());
			
			newAppointmentCol.add(newAppointment);
			
			PatientKioskBookingVo newPatientKiosBooking = new PatientKioskBookingVo();
			newPatientKiosBooking.setPatient(newPatient);
			newPatientKiosBooking.setAppointments(newAppointmentCol);
			
			patientKioskBookingCol.add(newPatientKiosBooking);
		}
	}

	private PatientKioskPatientVo populatePatientKioskFromBookingAppointment(PatientRefVo patient) 
	{
		if(patient == null || patient.getID_Patient() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		ims.core.patient.domain.objects.Patient doPatient = (Patient) factory.getDomainObject(Patient.class, patient.getID_Patient());
		PatientShort patientShort = PatientShortAssembler.create(doPatient);
		
		if(patientShort != null)
		{
			PatientKioskPatientVo newPatient = new PatientKioskPatientVo();
			newPatient.setID(patientShort.getID_Patient());
			newPatient.setSurname(patientShort.getNameIsNotNull() ? patientShort.getName().getSurname() : null);
			newPatient.setDOB(patientShort.getDob() != null ? patientShort.getDob().toDate() : null);
			newPatient.setDisplayName(patientShort.getNameIsNotNull() ? patientShort.getName().toString() : null);
			newPatient.setGender(patientShort.getSex());
			newPatient.setPostCode(patientShort.getAddress() != null ? removeString(patientShort.getAddress().getPostCode(), " ") : null);
			
			return newPatient;
		}
		
		return null;
	}

	private String removeString(String postCode, String removeString) 
	{
		if(postCode == null )
			return null;
		
		if(removeString == null || removeString.length() == 0)
			removeString = " ";
		
		StringTokenizer st = new StringTokenizer(postCode, removeString, false);
		String returnString = "";
		
		while(st.hasMoreElements())
		{
			returnString += st.nextElement();
		}
		
		return returnString;
	}

	private boolean patientIsNotAdded(PatientKioskBookingVoCollection patientKioskBookingCol, Integer patient) 
	{
		if(patient == null)
			throw new CodingRuntimeException("Cannot search on null ID!");
		
		if(patientKioskBookingCol == null || (patientKioskBookingCol != null && patientKioskBookingCol.size() == 0))
			return true;
		
		for(int i=0; i<patientKioskBookingCol.size(); i++)
		{
			if(patientKioskBookingCol.get(i) != null 
					&& patientKioskBookingCol.get(i).getPatientIsNotNull() 
						&& patientKioskBookingCol.get(i).getPatient().getIDIsNotNull()
							&& patientKioskBookingCol.get(i).getPatient().getID() == patient)
				return false;
		}
		
		return true;
	}
	
	private Booking_AppointmentShortVo getBookingAppointment(Integer apointmentId) 
	{
		if(apointmentId == null)
			throw new CodingRuntimeException("Client not provided for get call.");
		
		DomainFactory factory = getDomainFactory();
		ims.scheduling.domain.objects.Booking_Appointment doBooking = (ims.scheduling.domain.objects.Booking_Appointment) factory.getDomainObject(ims.scheduling.domain.objects.Booking_Appointment.class, apointmentId);
		
		return Booking_AppointmentShortVoAssembler.create(doBooking);
	}

	public void confirmPatientKioskAppointmentsForToday(Integer[] appointmentIds, String kioskId) throws DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{	
		if(appointmentIds == null || (appointmentIds != null && appointmentIds.length == 0))
			throw new CodingRuntimeException("Cannot confirm appointments for a null array of appointments.");
		
		this.createSystemLogEntry(SystemLogType.KIOSK, SystemLogLevel.INFORMATION, "Confirm Patient Appointments (kiosk ID: " + kioskId + ")");
		
		for(int i=0; i<appointmentIds.length; i++)
		{
			if(appointmentIds[i] != null)
			{
				Booking_AppointmentShortVo newBooking = getBookingAppointment(appointmentIds[i]);
				
				if(newBooking instanceof Booking_AppointmentShortVo)
				{
					newBooking.setApptStatus(Status_Reason.ARRIVAL);
					newBooking.setArrivalTime(new Time());
					
					PatientAppointmentManagement impl = (PatientAppointmentManagement) getDomainImpl(PatientAppointmentMangementRefManImpl.class);
					
					if (!newBooking.isValidated())
					{
						newBooking.validate();
					}
					
					impl.saveBookingAppt(newBooking, false,false);	//wdev-12090					
				}
			}	
		}
	}

	public Boolean isPatientLate(Integer patientId) throws DomainInterfaceException 
	{
		if(patientId == null)
			throw new DomainInterfaceException("Cannot search on a null Patient ID!");
		
		Booking_AppointmentVoCollection bookingAppointmentCol = getBookingAppointmentColl(patientId);
		
		if(bookingAppointmentCol == null || bookingAppointmentCol.size() == 0)
			throw new DomainInterfaceException("Patient doesn't have an appointment.");
		
		Booking_AppointmentVo firstAppointment = getFirstAppointment(bookingAppointmentCol);//null;
		
		if(firstAppointment == null || !firstAppointment.getApptStartTimeIsNotNull())
			throw new DomainInterfaceException("Patient doesn't have an appointment.");
	
		//get delay from PatientKioskConfigImpl
		Integer delayInMinutes = getDelay();
		
		Time timeForFirstAppointment = firstAppointment.getApptStartTime();
		Time currentTime = new Time();
		
		Time testTime = (Time) timeForFirstAppointment.clone();
		testTime.addMinutes(delayInMinutes);
		
		if(testTime.isLessThan(timeForFirstAppointment))
			throw new DomainInterfaceException("Error. AppointmentTime + Delay > 23:59:59!");
						
		timeForFirstAppointment.addMinutes(delayInMinutes);
		
		return currentTime.isGreaterThan(timeForFirstAppointment) ? true : false;
	}

	private Booking_AppointmentVo getFirstAppointment(Booking_AppointmentVoCollection bookingAppointmentCol) 
	{
		if(bookingAppointmentCol == null || bookingAppointmentCol.size() == 0)
			return null;
		
		for(int i=0; i<bookingAppointmentCol.size(); i++)
		{
			if(bookingAppointmentCol.get(i) != null)
			{
				return bookingAppointmentCol.get(i);
			}
		}
		
		return null;
	}

	private Booking_AppointmentVoCollection getBookingAppointmentColl(Integer patientId) 
	{
		if(patientId == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		Date today = new Date();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		String query = "from Booking_Appointment as BA where BA.apptStatus.id = :apptSt and (DATEPART(yyyy,BA.appointmentDate) = :yearOfToday) and (DATEPART(mm,BA.appointmentDate) = :monthOfToday) and (DATEPART(dd,BA.appointmentDate) = :dayOfToday) and BA.patient.id = :patienID order by BA.apptStartTime asc";
		
		markers.add("apptSt");
		values.add(Status_Reason.BOOKED.getId());
		
		markers.add("yearOfToday");
		values.add(today.getYear());
		
		markers.add("monthOfToday");
		values.add(today.getMonth());
		
		markers.add("dayOfToday");
		values.add(today.getDay());
		
		markers.add("patienID");
		values.add(patientId);
		
		List bookingAppointmentList = factory.find(query, markers, values);
		
		return Booking_AppointmentVoAssembler.createBooking_AppointmentVoCollectionFromBooking_Appointment(bookingAppointmentList);
	}

	private int getDelay() 
	{
		PatientKioskConfig impl = (PatientKioskConfig) getDomainImpl(PatientKioskConfigImpl.class);
		PatientKioskSettingsVo patientKioskSettings = impl.getPatientKioskSettings(null);
		
		Integer delayInMinutes = 0;
		if(patientKioskSettings != null && patientKioskSettings.getAllowedDelayIsNotNull())
		{
			delayInMinutes = patientKioskSettings.getAllowedDelay();
		}
		
		return delayInMinutes;
	}
}
