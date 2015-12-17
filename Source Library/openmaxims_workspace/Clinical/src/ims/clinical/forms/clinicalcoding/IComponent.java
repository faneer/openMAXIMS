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

package ims.clinical.forms.clinicalcoding;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	public void setCodingItemType(ims.clinical.vo.lookups.CodingItemType lkpCodingItemType);

	public void setCodingItemType(ims.clinical.vo.lookups.CodingItemType lkpCodingItemType, Boolean enableDescriptionField);

	public ims.clinical.vo.lookups.CodingItemType getCodingItemType();

	/**
	* A boolean that determines whether 'hotlist' radio buttons and domain methods are selected and invoked.
	*/
	public void setHotlist(Boolean bHotlist);

	public Boolean getHotlist();

	public void setSpecialty(ims.core.vo.lookups.Specialty lkpSpecialty);

	public ims.vo.ValueObject getSelectedItem();

	public Boolean isAllSelected();

	public String getDescription();

	public Boolean getParentEditing();

	public void setParentEditing(Boolean bEditing);

	public void setSelectedItem(ims.vo.ValueObject voSelectedItem);

	public void setDescription(String strDescription);

	public void clear();

	public void search();

	public void setSearchAllSelected(Boolean bSearchAllSelected);

	/**
	* getValue
	*/
	public ims.vo.interfaces.IClinicalCodingValue getValue();

	public void setValue(ims.vo.interfaces.IClinicalCodingValue iCCI);

	public void setParentEditing(Boolean bEditing, Boolean bEnabled);

	/**
	* sets the Focus to the Clinical Term field
	*/
	public void setFocus();

	/**
	* setClinicalTermMandatory
	*/
	public void setClinicalTermMandatory(Boolean isMandatory);

	/**
	* sets Description as Mandatory
	*/
	public void setDescriptionMandatory(Boolean isMandatory);

	public void search(String value);

	public void setTaxonomySearch(Boolean value);

	public void setEnabled(Boolean value);

	public void populateTerms(Boolean value);

	public void setIsRequired(Boolean value);

	public Boolean isNoSuitableTermFound();

	public void setCustomHotlist(ims.clinical.forms.clinicalcoding.Logic.IClinicalCodingCustomHotlistProvider hotlistProvider);

	public void search(Boolean showOpened);

	public void showOpened();

	public void removeNoSuitableTermItem(ims.clinical.vo.lookups.CodingItemType lkpCodingType);

	/**
	* Hides the taxonomy search button 
	*/
	public void hideTaxonomySearch();

	public void setDivisionOrDiagnosesDatabase(ims.core.vo.lookups.DiagnosisDivisions division, Boolean searchDiagnosesDatabase);

	public Boolean isDiagnosesDatabaseSelected();

	public void setOutpatientOnly(Boolean outpat);

	public void setDrugsAlreadyAddedToPrescriptionStringID(String drugsAlreadyAddedToPrescriptionStringID);
}
