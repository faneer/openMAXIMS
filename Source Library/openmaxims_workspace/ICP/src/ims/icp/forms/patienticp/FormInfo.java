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

package ims.icp.forms.patienticp;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "ICP";
	}
	public String getFormName()
	{
		return "PatientICP";
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
		return new String[] { "_cv_ICP.HardcodedDataAdded", "_cv_ICP.ICPList", "_cv_ICP.EvaluationNote", "_cv_ICP.Stages", "_cv_ICP.PatientICPRecord", "_cv_ICP.ActionStatus", "_cv_ICP.TypeToSelect", "_cv_ICP.PatientCriticalEvent" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_ICP.PatientICP.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[5];
		componentsInfo[0] = new ims.core.forms.authoringinfo.FormInfo(102228);
		componentsInfo[1] = new ims.assessment.forms.structuralassessment.FormInfo(127109);
		componentsInfo[2] = new ims.core.forms.assessmentasreport.FormInfo(102275);
		componentsInfo[3] = new ims.assessment.forms.graphicalassessment.FormInfo(127114);
		componentsInfo[4] = new ims.icp.forms.patienticpactionlinkeddetailscomponent.FormInfo(118121);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/ICP/patient_icp_48.png";
	}
}
