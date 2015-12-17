// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.referralstatuslist;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "RefMan";
	}
	public String getFormName()
	{
		return "ReferralStatusList";
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
		return new String[] { "_cv_Core.PatientToBeDisplayed", "_cv_RefMan.ReferralReviewDetailsMode", "_cv_RefMan.IsClinicalContactStarted", "_cv_RefMan.IsConsultationStarted", "_cv_RefMan.OpenApptAndInvTab", "_cv_RefMan.EndOfCareDate", "_cv_RefMan.SpecimenWorkListItemForReports", "_cv_RefMan.RejectionReason", "_cv_Core.Html2View", "_cv_RefMan.ReferralOutcomeReportType", "_cv_RefMan.PrintRejectionLetters", "_cv_RefMan.ChosenTime" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_RefMan.ReferralStatusList.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[1];
		componentsInfo[0] = new ims.core.forms.mosquery.FormInfo(102256);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/RefMan/patient_refferal_48.png";
	}
}
