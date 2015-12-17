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
// This code was generated by John MacEnri using IMS Development Environment (version 1.51 build 2469.17966)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseNavigationAdminImpl;
import ims.admin.vo.AppFormVo;
import ims.admin.vo.AppFormVoCollection;
import ims.admin.vo.AppNavShortVoCollection;
import ims.admin.vo.AppNavigationVo;
import ims.admin.vo.domain.AppFormVoAssembler;
import ims.admin.vo.domain.AppNavShortVoAssembler;
import ims.admin.vo.domain.AppNavigationVoAssembler;
import ims.assessment.configuration.domain.objects.GraphicAssessment;
import ims.assessment.configuration.domain.objects.UserAssessment;
import ims.assessment.configuration.vo.GraphicAssessmentRefVo;
import ims.assessment.configuration.vo.UserAssessmentRefVo;
import ims.assessment.vo.GraphicAssessmentShortVoCollection;
import ims.assessment.vo.UserAssessmentLiteVoCollection;
import ims.assessment.vo.domain.GraphicAssessmentShortVoAssembler;
import ims.assessment.vo.domain.UserAssessmentLiteVoAssembler;
import ims.core.configuration.domain.objects.AppForm;
import ims.core.configuration.domain.objects.AppNavigation;
import ims.core.configuration.vo.AppNavigationRefVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;

public class NavigationAdminImpl extends BaseNavigationAdminImpl
{
	private static final long serialVersionUID = 1L;

	public AppNavShortVoCollection listNavigations()
	{
		return AppNavShortVoAssembler.createAppNavShortVoCollectionFromAppNavigation(getDomainFactory().find(" from AppNavigation ")).sort();
	}

	public AppNavigationVo getNavigation(AppNavigationRefVo navRef)
	{
		return AppNavigationVoAssembler.create((AppNavigation)getDomainFactory().getDomainObject(navRef));
	}

	public AppFormVoCollection listNavigableForms()
	{
		String hql = " from AppForm af where af.isDialog = :isDialog and af.isComponent = :isComponent and af.canBeInNavigation = :canBeInNavigation";
		return AppFormVoAssembler.createAppFormVoCollectionFromAppForm(getDomainFactory().find(hql, new String[]{"isDialog","isComponent","canBeInNavigation"}, new Object[]{Boolean.FALSE, Boolean.FALSE, Boolean.TRUE},500)).sort();
	}

	public void saveNavigation(AppNavigationVo nav) throws StaleObjectException, UniqueKeyViolationException
	{
		if (!nav.isValidated())
			throw new DomainRuntimeException("Navigation VO param was not validated ");
		
		DomainFactory factory = this.getDomainFactory();
		
		AppNavigation domNav = AppNavigationVoAssembler.extractAppNavigation(factory, nav);
		
		try
		{
			factory.save(domNav);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("A Navigation with the same name already exists.");
		}
	}

	public UserAssessmentLiteVoCollection listAssessments()
	{
		String hql = "from UserAssessment u where u.activeStatus = :activeStatus and u.assessmentType.id not in (" + UserDefinedAssessmentType.DPP.getID() + ")";
		return UserAssessmentLiteVoAssembler.createUserAssessmentLiteVoCollectionFromUserAssessment(this.getDomainFactory().find(hql, new String[]{"activeStatus"}, new Object[]{getDomLookup(PreActiveActiveInactiveStatus.ACTIVE)})).sort();
	}

	public ims.vo.ValueObject getAssessment(ims.vo.ValueObjectRef refVo)
	{
		if (refVo instanceof UserAssessmentRefVo)
		{
			UserAssessmentRefVo assess = (UserAssessmentRefVo)refVo;
			return UserAssessmentLiteVoAssembler.create((UserAssessment)getDomainFactory().getDomainObject(assess));
		}
		else if (refVo instanceof GraphicAssessmentRefVo)
		{
			GraphicAssessmentRefVo assess = (GraphicAssessmentRefVo)refVo;
			return GraphicAssessmentShortVoAssembler.create((GraphicAssessment)getDomainFactory().getDomainObject(assess));
		}
		else
		{
			return null;
		}
	}

	public AppFormVo getAppForm(Integer formId)
	{
		return AppFormVoAssembler.create((AppForm)getDomainFactory().getDomainObject(AppForm.class, formId));
	}

	public GraphicAssessmentShortVoCollection listGraphicAssessments()
	{
		String hql = "from GraphicAssessment g where g.activeStatus = :activeStatus and g.assessmentType.id not in (" + UserDefinedAssessmentType.DPP.getID() + ")";
		return GraphicAssessmentShortVoAssembler.createGraphicAssessmentShortVoCollectionFromGraphicAssessment(this.getDomainFactory().find(hql, new String[]{"activeStatus"}, new Object[]{getDomLookup(PreActiveActiveInactiveStatus.ACTIVE)})).sort();
	}

}
