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

package ims.clinical.forms.clinicalnotedrawing;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "Clinical";
	}
	public String getFormName()
	{
		return "ClinicalNoteDrawing";
	}
	public int getWidth()
	{
		return 848;
	}
	public int getHeight()
	{
		return 632;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_COE.SkinBodyChart.SelectedSkinAssessment", "_cv_COE.SkinBodyChart.SkinAssessmentVO", "_cv_COE.SkinBodyChart.Areas", "_cv_COE.SkinBodyChart.FindingsVO", "_cv_COE.SkinBodyChart.Groups", "_cv_COE.SkinBodyChart.ReadOnlyAssessment", "_cv_Core.ClinicalNotingMode", "_cv_Nursing.AssessmentComponent", "_cv_Nursing.AssessmentHeaderInfo", "_cv_Clinical.UnsavedSOAPINformation", "_cv_ProtoTemp.CliniacalNoteDrawingText", "_cv_Core.ClinicalNotesShort", "_cv_Clinical.PatientAssessment.EditComponent", "_cv_Clinical.PatientAssessment.EditedComponent", "_cv_Clinical.PatientAssessment.SelectedAssessment", "_cv_Clinical.ReturnToFormCDIDescription", "_cv_Clinical.ReturnToFormMode", "_cv_ProtoTemp.ClinicalNoteDrawingReturnFormName", "_cv_Clinical.ReturnToFormCDITitle", "_cv_Clinical.ReturnToFormName", "_cv_Core.UserDefinedObjectSelected", "_cv_Clinical.DialogFormName", "_cv_Assessment.PatientUserDefinedObject", "_cv_Clinical.ReturnToFormCDISubjectiveProblem" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_Clinical.ClinicalNoteDrawing.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[2];
		componentsInfo[0] = new ims.core.forms.authoringinfo.FormInfo(102228);
		componentsInfo[1] = new ims.assessment.forms.graphicassessmentcomponent.FormInfo(127104);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/Clinical/clinical_note_drawing_48.png";
	}
}
