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

package ims.core.forms.pdsgpdetailsindemographicscc;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	public ims.core.vo.enums.PatientDetailsTab getAction();

	public void setAction(ims.core.vo.enums.PatientDetailsTab action);

	public void showHideGPButton(Boolean showhide);

	public void requiredGPName(Boolean requir);

	public void setvalue(ims.core.vo.Patient pat);

	public Boolean validateGPDetails();

	public void initialize();

	public void clearScreen();

	public ims.core.vo.Patient getPatientWithGPetails();

	public void setConfigurableFields(ims.core.vo.DemographicControlsConfigVoCollection collfields);

	public String[] getUIErrorsForConfigurableMode(Boolean skipGP);

	/**
	* validateData
	*/
	public Boolean validateData(java.util.ArrayList<String> errors, Boolean skipGP);

	/**
	* populateDataFromScreen
	*/
	public void populateDataFromScreen(ims.core.vo.Patient patient);

	/**
	* showHideGPDetailsButton
	*/
	public void showHideGPDetailsButton(Boolean showHide);

	public void setPDSMandatoryFields(Boolean mandatory);
}
