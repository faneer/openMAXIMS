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

package ims.emergency.forms.emergencyattendancedetailscc;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	public void clearAttendanceDetails();

	public void initialize();

	public void setValue(ims.vo.ValueObject rowValue);

	public ims.emergency.vo.enums.EmergencyAttendanceEvent getSelectedEvent();

	public void resetSelectedEvent();

	public void newInstance();

	public void editInstance();

	public void setLocalCondextDisplayPrintReport(Boolean displayPrintReport);

	public void saveAttendance(ims.emergency.vo.EmergencyAttendanceBillingVo invoiceBilling, ims.emergency.vo.ChartRequestedVo chartRequested, ims.emergency.vo.EmergencyAttendanceNonInsuranceHealthCoverVo insuranceDetails);

	public void setIsFinalTab(Boolean isFinalTab);
}
