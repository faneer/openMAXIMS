//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinicaladmin.forms.tumouroverallprognostic;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Oncology = new OncologyContext(context);
		ClinicalAdmin = new ClinicalAdminContext(context);
	}
	public final class OncologyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OncologyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedRecordForOverallPrognosticDialogIsNotNull()
		{
			return !cx_OncologySelectedRecordForOverallPrognosticDialog.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.OverallPrognosticGroupingVo getSelectedRecordForOverallPrognosticDialog()
		{
			return (ims.clinicaladmin.vo.OverallPrognosticGroupingVo)cx_OncologySelectedRecordForOverallPrognosticDialog.getValue(context);
		}
		public void setSelectedRecordForOverallPrognosticDialog(ims.clinicaladmin.vo.OverallPrognosticGroupingVo value)
		{
			cx_OncologySelectedRecordForOverallPrognosticDialog.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologySelectedRecordForOverallPrognosticDialog = new ims.framework.ContextVariable("Oncology.SelectedRecordForOverallPrognosticDialog", "_cv_Oncology.SelectedRecordForOverallPrognosticDialog");
		public boolean getOverallPrognosticDynamicGridCollectionIsNotNull()
		{
			return !cx_OncologyOverallPrognosticDynamicGridCollection.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.OverallPrognosticGroupingVoCollection getOverallPrognosticDynamicGridCollection()
		{
			return (ims.clinicaladmin.vo.OverallPrognosticGroupingVoCollection)cx_OncologyOverallPrognosticDynamicGridCollection.getValue(context);
		}
		public void setOverallPrognosticDynamicGridCollection(ims.clinicaladmin.vo.OverallPrognosticGroupingVoCollection value)
		{
			cx_OncologyOverallPrognosticDynamicGridCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyOverallPrognosticDynamicGridCollection = new ims.framework.ContextVariable("Oncology.OverallPrognosticDynamicGridCollection", "_cv_Oncology.OverallPrognosticDynamicGridCollection");

		private ims.framework.Context context;
	}
	public final class ClinicalAdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalAdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTumourGroupIsNotNull()
		{
			return !cx_ClinicalAdminTumourGroup.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourGroupVo getTumourGroup()
		{
			return (ims.clinicaladmin.vo.TumourGroupVo)cx_ClinicalAdminTumourGroup.getValue(context);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourGroup = new ims.framework.ContextVariable("ClinicalAdmin.TumourGroup", "_cv_ClinicalAdmin.TumourGroup");

		private ims.framework.Context context;
	}

	public OncologyContext Oncology;
	public ClinicalAdminContext ClinicalAdmin;
}
