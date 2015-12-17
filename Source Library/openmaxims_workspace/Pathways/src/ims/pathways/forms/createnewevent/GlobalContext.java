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

package ims.pathways.forms.createnewevent;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Pathways = new PathwaysContext(context);
	}
	public final class PathwaysContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PathwaysContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedPatientJourneyTargetIsNotNull()
		{
			return !cx_PathwaysSelectedPatientJourneyTarget.getValueIsNull(context);
		}
		public ims.pathways.vo.PatientJourneyTargetVo getSelectedPatientJourneyTarget()
		{
			return (ims.pathways.vo.PatientJourneyTargetVo)cx_PathwaysSelectedPatientJourneyTarget.getValue(context);
		}
		public void setSelectedPatientJourneyTarget(ims.pathways.vo.PatientJourneyTargetVo value)
		{
			cx_PathwaysSelectedPatientJourneyTarget.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysSelectedPatientJourneyTarget = new ims.framework.ContextVariable("Pathways.SelectedPatientJourneyTarget", "_cv_Pathways.SelectedPatientJourneyTarget");
		public boolean getSelectedPathwayIsNotNull()
		{
			return !cx_PathwaysSelectedPathway.getValueIsNull(context);
		}
		public ims.pathways.configuration.vo.PathwayRefVo getSelectedPathway()
		{
			return (ims.pathways.configuration.vo.PathwayRefVo)cx_PathwaysSelectedPathway.getValue(context);
		}
		public void setSelectedPathway(ims.pathways.configuration.vo.PathwayRefVo value)
		{
			cx_PathwaysSelectedPathway.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysSelectedPathway = new ims.framework.ContextVariable("Pathways.SelectedPathway", "_cv_Pathways.SelectedPathway");
		public boolean getSelectedPatientPathwayJourneyIsNotNull()
		{
			return !cx_PathwaysSelectedPatientPathwayJourney.getValueIsNull(context);
		}
		public ims.pathways.vo.PatientPathwayJourneyRefVo getSelectedPatientPathwayJourney()
		{
			return (ims.pathways.vo.PatientPathwayJourneyRefVo)cx_PathwaysSelectedPatientPathwayJourney.getValue(context);
		}
		public void setSelectedPatientPathwayJourney(ims.pathways.vo.PatientPathwayJourneyRefVo value)
		{
			cx_PathwaysSelectedPatientPathwayJourney.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysSelectedPatientPathwayJourney = new ims.framework.ContextVariable("Pathways.SelectedPatientPathwayJourney", "_cv_Pathways.SelectedPatientPathwayJourney");

		private ims.framework.Context context;
	}

	public PathwaysContext Pathways;
}
