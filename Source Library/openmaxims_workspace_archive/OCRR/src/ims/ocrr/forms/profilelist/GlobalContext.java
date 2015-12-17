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

package ims.ocrr.forms.profilelist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getNewProfileIsNotNull()
		{
			return !cx_OCRRNewProfile.getValueIsNull(context);
		}
		public Boolean getNewProfile()
		{
			return (Boolean)cx_OCRRNewProfile.getValue(context);
		}
		public void setNewProfile(Boolean value)
		{
			cx_OCRRNewProfile.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRNewProfile = new ims.framework.ContextVariable("OCRR.NewProfile", "_cv_OCRR.NewProfile");
		public boolean getProfileListSearchCriteriaIsNotNull()
		{
			return !cx_OCRRProfileListSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestigationProfileListSearchCriteriaVo getProfileListSearchCriteria()
		{
			return (ims.ocrr.vo.InvestigationProfileListSearchCriteriaVo)cx_OCRRProfileListSearchCriteria.getValue(context);
		}
		public void setProfileListSearchCriteria(ims.ocrr.vo.InvestigationProfileListSearchCriteriaVo value)
		{
			cx_OCRRProfileListSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRProfileListSearchCriteria = new ims.framework.ContextVariable("OCRR.ProfileListSearchCriteria", "_cv_OCRR.ProfileListSearchCriteria");
		public boolean getNewInvestigationIsNotNull()
		{
			return !cx_OCRRNewInvestigation.getValueIsNull(context);
		}
		public Boolean getNewInvestigation()
		{
			return (Boolean)cx_OCRRNewInvestigation.getValue(context);
		}
		public void setNewInvestigation(Boolean value)
		{
			cx_OCRRNewInvestigation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRNewInvestigation = new ims.framework.ContextVariable("OCRR.NewInvestigation", "_cv_OCRR.NewInvestigation");
		public boolean getSelectedTestIsNotNull()
		{
			return !cx_OCRRSelectedTest.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestigationIndexVo getSelectedTest()
		{
			return (ims.ocrr.vo.InvestigationIndexVo)cx_OCRRSelectedTest.getValue(context);
		}
		public void setSelectedTest(ims.ocrr.vo.InvestigationIndexVo value)
		{
			cx_OCRRSelectedTest.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedTest = new ims.framework.ContextVariable("OCRR.SelectedTest", "_cv_OCRR.SelectedTest");
		public boolean getItemSelectionTypeIsNotNull()
		{
			return !cx_OCRRItemSelectionType.getValueIsNull(context);
		}
		public ims.ocrr.vo.lookups.ItemSelectionType getItemSelectionType()
		{
			return (ims.ocrr.vo.lookups.ItemSelectionType)cx_OCRRItemSelectionType.getValue(context);
		}
		public void setItemSelectionType(ims.ocrr.vo.lookups.ItemSelectionType value)
		{
			cx_OCRRItemSelectionType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRItemSelectionType = new ims.framework.ContextVariable("OCRR.ItemSelectionType", "_cv_OCRR.ItemSelectionType");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
}
