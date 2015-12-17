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

package ims.clinicaladmin.forms.cancerstagingclassifications;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		ClinicalAdmin = new ClinicalAdminContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTaxonomySearchForNameIsNotNull()
		{
			return !cx_CoreTaxonomySearchForName.getValueIsNull(context);
		}
		public String getTaxonomySearchForName()
		{
			return (String)cx_CoreTaxonomySearchForName.getValue(context);
		}
		public void setTaxonomySearchForName(String value)
		{
			cx_CoreTaxonomySearchForName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTaxonomySearchForName = new ims.framework.ContextVariable("Core.TaxonomySearchForName", "_cv_Core.TaxonomySearchForName");
		public boolean getTaxonomyMapIsNotNull()
		{
			return !cx_CoreTaxonomyMap.getValueIsNull(context);
		}
		public ims.core.vo.TaxonomyMap getTaxonomyMap()
		{
			return (ims.core.vo.TaxonomyMap)cx_CoreTaxonomyMap.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreTaxonomyMap = new ims.framework.ContextVariable("Core.TaxonomyMap", "_cv_Core.TaxonomyMap");

		private ims.framework.Context context;
	}
	public final class ClinicalAdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalAdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getChosenTumourGroupListVoCollectionIsNotNull()
		{
			return !cx_ClinicalAdminChosenTumourGroupListVoCollection.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourGroupListVoCollection getChosenTumourGroupListVoCollection()
		{
			return (ims.clinicaladmin.vo.TumourGroupListVoCollection)cx_ClinicalAdminChosenTumourGroupListVoCollection.getValue(context);
		}
		public void setChosenTumourGroupListVoCollection(ims.clinicaladmin.vo.TumourGroupListVoCollection value)
		{
			cx_ClinicalAdminChosenTumourGroupListVoCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminChosenTumourGroupListVoCollection = new ims.framework.ContextVariable("ClinicalAdmin.ChosenTumourGroupListVoCollection", "_cv_ClinicalAdmin.ChosenTumourGroupListVoCollection");

		private ims.framework.Context context;
	}
	public boolean getSelectedStagingClassificationVoIsNotNull()
	{
		return !cx_SelectedStagingClassificationVo.getValueIsNull(context);
	}
	public ims.clinicaladmin.vo.StagingClassificationVo getSelectedStagingClassificationVo()
	{
		return (ims.clinicaladmin.vo.StagingClassificationVo)cx_SelectedStagingClassificationVo.getValue(context);
	}
		public void setSelectedStagingClassificationVo(ims.clinicaladmin.vo.StagingClassificationVo value)
		{
		cx_SelectedStagingClassificationVo.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_SelectedStagingClassificationVo = new ims.framework.ContextVariable("SelectedStagingClassificationVo", "_cv_SelectedStagingClassificationVo");

	public CoreContext Core;
	public ClinicalAdminContext ClinicalAdmin;
}
