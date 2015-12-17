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

package ims.core.forms.casenoteopentrequestsgridcc;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	public void initialize(Boolean displaySelectColumn);

	public void initialize(Boolean displaySelectColumn, ims.core.vo.CaseNoteRequestsColumnWidthVo columnWidths);

	public void initialize(Boolean displaySelectColumn, Boolean selectableGrid);

	public void initialize(Boolean displaySelectColumn, Boolean selectableGrid, ims.core.vo.CaseNoteRequestsColumnWidthVo columnWidths);

	public void initialize(Boolean displaySelectColumn, Boolean selectableGrid, Boolean showContextMenu);

	public void setValue(ims.core.patient.vo.PatientRefVo patient);

	public void setValue(ims.core.patient.vo.PatientRefVo patient, ims.core.clinical.vo.PatientCaseNoteRefVo caseNote);

	public void setValue(ims.core.patient.vo.PatientRefVo patient, ims.core.clinical.vo.PatientCaseNoteRefVo caseNote, Boolean caseNotesInMedicalRecordsOnly);

	public void disableOpenRequestGrid(Boolean disable);

	public ims.core.vo.PatientCaseNoteRequestShortVo getSelectedRowValue();

	public ims.core.vo.PatientCaseNoteRequestShortVoCollection getCheckedValues();

	public void setSelection(ims.core.vo.PatientCaseNoteRequestShortVo value);

	public void initialize(Boolean displaySelectColumn, Boolean selectableGrid, Boolean showContextMenu, ims.core.vo.CaseNoteRequestsColumnWidthVo columnWidths);

	public ims.core.vo.enums.CaseNoteOpenRequestComponentAction getComponentAction();

	public void clearComponentAction();

	public void allowSelectable(ims.core.clinical.vo.PatientCaseNoteRefVo caseNote, ims.core.resource.place.vo.LocationRefVo location);

	public void setValue(ims.core.patient.vo.PatientRefVo patient, ims.core.clinical.vo.PatientCaseNoteRefVo caseNoteFolder, ims.core.resource.place.vo.LocationRefVo location, ims.framework.utils.DateTime dateFrom, ims.framework.utils.DateTime dateTo);

	public void refreshContextMenu(Boolean isCaseNoteFolderSelected);
}
