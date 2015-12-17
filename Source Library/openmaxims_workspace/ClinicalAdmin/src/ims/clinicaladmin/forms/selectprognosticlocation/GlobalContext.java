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

package ims.clinicaladmin.forms.selectprognosticlocation;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		ClinicalAdmin = new ClinicalAdminContext(context);
	}
	public final class ClinicalAdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalAdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedPrognosticLocationIsNotNull()
		{
			return !cx_ClinicalAdminSelectedPrognosticLocation.getValueIsNull(context);
		}
		public ims.oncology.vo.PrognosticLocationConfigVo getSelectedPrognosticLocation()
		{
			return (ims.oncology.vo.PrognosticLocationConfigVo)cx_ClinicalAdminSelectedPrognosticLocation.getValue(context);
		}
		public void setSelectedPrognosticLocation(ims.oncology.vo.PrognosticLocationConfigVo value)
		{
			cx_ClinicalAdminSelectedPrognosticLocation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminSelectedPrognosticLocation = new ims.framework.ContextVariable("ClinicalAdmin.SelectedPrognosticLocation", "_cv_ClinicalAdmin.SelectedPrognosticLocation");

		private ims.framework.Context context;
	}

	public ClinicalAdminContext ClinicalAdmin;
}
