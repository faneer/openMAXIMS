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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.vo.interfaces;

/*
 * Pending Admission Details (can be a simple Patient) - to help display the data necessary for admiting a patient.
 */
public interface IPendingAdmissionDetails extends Comparable, IPendingAdmission
{
	/*
	 * Returns the service for Pending Admission.
	 */
	 ims.core.vo.ServiceLiteVo getPendingAdmissionService();
	/*
	 * Returns Pending Admission Specialty
	 */
	 ims.core.vo.lookups.Specialty getPendingAdmissionSpecialty();
	/*
	 * Returns Pending Admission consultant.
	 */
	 ims.core.vo.MemberOfStaffLiteVo getPendingAdmissionConsultant();
	/*
	 * Returns Pending Admission method of admission
	 */
	 ims.core.vo.lookups.MethodOfAdmission getPendingAdmissionMethodOfAdmission();
	/*
	 * Returns Pending Admission patient category
	 */
	 ims.core.vo.lookups.PatientStatus getPendingAdmissionPatientCategory();
	/*
	 * Returns Pending Admission anticipated stay
	 */
	 Integer getPendingAdmissionAnticipatedStay();
	/*
	 * Returns Pending Admission source of emergency referral
	 */
	 ims.core.vo.lookups.SourceOfEmergencyReferral getPendingAdmissionSourceOfEmergencyReferral();
	/*
	 * Returns Pending Admission source of referral
	 */
	 ims.core.vo.lookups.SourceOfReferral getPendingAdmissionSourceOfReferral();
	/*
	 * Returns Pending Admission reason for admission
	 */
	 String getPendingAdmissionReasonForAdmission();
	/*
	 * Returns Pending Admission referring consultant
	 */
	 ims.core.vo.MedicLiteVo getPendingAdmissionReferringConsultant();
	/*
	 * Returns Pending Admission self admit
	 */
	 Boolean getPendingAdmissionSelfAdmit();
}
