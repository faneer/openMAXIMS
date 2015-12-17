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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2389.16953)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.
// 7/09/2006 - WDEV-1665 - Added a combobox which was loaded with the linked Role 
// and we could select a role and see the question we can answer.  
 
package ims.assessment.forms.userassessmentpreview;

import java.util.Comparator;

import ims.assessment.vo.AssessmentRoleVo;
import ims.assessment.vo.UserAssessmentShortVo;
import ims.assessment.vo.UserAssessmentVo;
import ims.admin.vo.AppRoleShortVo;
import ims.core.vo.AssessmentQuestionGroupVo;
import ims.core.vo.AssessmentQuestionVo;
import ims.core.vo.PatientShort;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getGlobalContext().Core.getSelectedUserAssessment().getID_UserAssessment() == null)
			throw new PresentationLogicException("Invalid user asessment selected");

		UserAssessmentShortVo voUserAssessmentShort = form.getGlobalContext().Core.getSelectedUserAssessment();
		UserAssessmentVo voUserAssessment = this.domain.getAssessment(voUserAssessmentShort.getID_UserAssessment());
		form.getLocalContext().setUserAssessmentVo(voUserAssessment);
		populateControls(voUserAssessment);
		populateRolesCombo(voUserAssessment);
	}

	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}

	void populateControls(UserAssessmentVo voUserAssessment) throws PresentationLogicException
	{
		populateGrid(voUserAssessment);
	}

	private void populateRolesCombo(UserAssessmentVo voUserAssessment)
	{
		form.cmbRoles().clear();
		if(voUserAssessment != null && voUserAssessment.getAssessmentRolesIsNotNull())
		{
			voUserAssessment.getAssessmentRoles().sort(new RoleComparator(SortOrder.ASCENDING));  //wdev-16161
			for (int i = 0; i < voUserAssessment.getAssessmentRoles().size(); i++)
			{
				AssessmentRoleVo voAssessmentRole = voUserAssessment.getAssessmentRoles().get(i);
				form.cmbRoles().newRow(voAssessmentRole, voAssessmentRole.getAppRoleIsNotNull()?voAssessmentRole.getAppRole().getName():"");
			}
		}
	}

	protected void onCmbRolesValueChanged() throws PresentationLogicException
	{
		AssessmentRoleVo voAssessmentRole = form.cmbRoles().getValue();
		UserAssessmentVo voUserAssesment = form.getLocalContext().getUserAssessmentVo();
		if(voAssessmentRole != null && (voAssessmentRole.getAnswerAll() == null || !voAssessmentRole.getAnswerAll().booleanValue()))
		{
			populateGrid(getFilteredOnRoleUserAssessment(voUserAssesment, voAssessmentRole));
		}
		else
		{
			populateGrid(voUserAssesment);
		}
	}
	
	private void populateGrid(UserAssessmentVo voUserAssessment) throws PresentationLogicException
	{
		form.customAssessment().preview(voUserAssessment);
	}
	
	//Remove the AssessmentQuestions that doesn't have associated the role
	private UserAssessmentVo getFilteredOnRoleUserAssessment(UserAssessmentVo voUserAssesmentOriginal, AssessmentRoleVo voAssessmentRole)
	{
		if(voUserAssesmentOriginal == null)
			return voUserAssesmentOriginal;
		
		UserAssessmentVo voUserAssesment = (UserAssessmentVo) voUserAssesmentOriginal.clone();
		if (voUserAssesment != null && voAssessmentRole != null && voUserAssesment.getAssessmentRoles().size() > 0)
		{
			for (int i = 0; voUserAssesment.getQuestionGroupsIsNotNull() && i < voUserAssesment.getQuestionGroups().size(); i++)
			{
				boolean deleted = true;
				while (deleted)
				{
					deleted = false;
					AssessmentQuestionGroupVo voAssessQuestion = voUserAssesment.getQuestionGroups().get(i);
					for (int j = 0; j < voAssessQuestion.getQuestions().size(); j++)
					{
						AssessmentQuestionVo assessmentQuestionVo = voAssessQuestion.getQuestions().get(j);
						boolean found = isRoleAdded(voAssessmentRole, assessmentQuestionVo);

						if (found == false)
						{
							voAssessQuestion.getQuestions().remove(j);
							deleted = true;
							break;
						}
					}
				}
			}
		}

		return voUserAssesment;
	}

	private boolean isRoleAdded(AssessmentRoleVo voAssessmentRole, AssessmentQuestionVo assessmentQuestionVo)
	{
		if(voAssessmentRole == null || assessmentQuestionVo == null)
			return false;

		for (int k = 0; k < assessmentQuestionVo.getAssessmentAnswerRole().size(); k++)
		{
			AppRoleShortVo appRoleVo = assessmentQuestionVo.getAssessmentAnswerRole().get(k).getAppRole();
			if(appRoleVo != null && appRoleVo.equals(voAssessmentRole.getAppRole()))
			{
				return true;
			}
		}
		return false;
	}
	//wdev-16161
	public class RoleComparator implements Comparator
	{
		private int direction = 1;
		
		public RoleComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public RoleComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String name1 = null;
			String name2 = null;
			if(ob1 instanceof AssessmentRoleVo )
			{
				AssessmentRoleVo ps1 = (AssessmentRoleVo)ob1;
				name1 = ps1.getAppRoleIsNotNull() ? ps1.getAppRole().getName() : null;
			}
			if(ob2 instanceof AssessmentRoleVo)
			{
				AssessmentRoleVo ps2 = (AssessmentRoleVo)ob2;
				name2 = ps2.getAppRoleIsNotNull() ? ps2.getAppRole().getName():null;
			}
			if(name1 != null )
				return  name1.toUpperCase().compareTo(name2.toUpperCase())*direction;
			if(name2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}

}
