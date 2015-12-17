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

package ims.ccosched.forms.clinicview;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "CcoSched";
	}
	public String getFormName()
	{
		return "ClinicView";
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
		return new String[] { "_cv_Core.LkupSelect.LkupID", "_cv_CcoSched.ClinicView.AppointmentID", "_cv_CcoSched.TemplateCategoryIDList", "_cv_CcoSched.PatientSearch.Alive", "_cv_CcoSched.LkupSelect.LkupTypeID", "_cv_CcoSched.LkupSelect.LkupID", "_cv_Core.LkupSelect.LkupTypeID", "_cv_Core.TemplateID", "_cv_Core.TemplateCategory", "_cv_CcoSched.ClinicView.ApptHead_id", "_cv_CcoSched.ClinicView.ApptId", "_cv_CcoSched.ClinicView.BookingComment", "_cv_CcoSched.ClinicView.Category", "_cv_CcoSched.ClinicView.ClinicName", "_cv_CcoSched.ClinicView.Date", "_cv_CcoSched.ClinicView.Inpatient", "_cv_CcoSched.ClinicView.IsCommentDialog", "_cv_CcoSched.ClinicView.Reason", "_cv_CcoSched.ClinicView.Status", "_cv_CcoSched.ClinicViewCancel.DialogTitle", "_cv_CcoSched.ClinicView.ActionId", "_cv_CcoSched.ClinicView.AppointmentHeaderID", "_cv_CcoSched.SelectedTemplateID", "_cv_CcoSched.SelectedPrinter", "_cv_Oncology.SelectedPrimaryTumourDetail", "_cv_CcoSched.ClinicView.ScreenDate", "_cv_CcoSched.ClinicView.Appt_stat", "_cv_CcoSched.ClinicView.Prfile_sess_id", "_cv_CcoSched.ClinicView.Prfiled_sess_id", "_cv_PatTreatmentPlan", "_cv_CcoSched.ClinicView.ApptActionInfo" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_CcoSched.ClinicView.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[0];
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/CcoSched/clinic_view_48.png";
	}
}
