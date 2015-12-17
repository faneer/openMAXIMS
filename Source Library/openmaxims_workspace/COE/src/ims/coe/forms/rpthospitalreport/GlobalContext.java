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

package ims.coe.forms.rpthospitalreport;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

			Reports = new ReportsContext(context);
		}
		public final class ReportsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ReportsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getStartDateIsNotNull()
			{
				return !cx_CoreReportsStartDate.getValueIsNull(context);
			}
			public ims.framework.utils.Date getStartDate()
			{
				return (ims.framework.utils.Date)cx_CoreReportsStartDate.getValue(context);
			}

			private ims.framework.ContextVariable cx_CoreReportsStartDate = new ims.framework.ContextVariable("Core.Reports.StartDate", "_cv_Core.Reports.StartDate");
			public boolean getEndDateIsNotNull()
			{
				return !cx_CoreReportsEndDate.getValueIsNull(context);
			}
			public ims.framework.utils.Date getEndDate()
			{
				return (ims.framework.utils.Date)cx_CoreReportsEndDate.getValue(context);
			}

			private ims.framework.ContextVariable cx_CoreReportsEndDate = new ims.framework.ContextVariable("Core.Reports.EndDate", "_cv_Core.Reports.EndDate");
			public boolean getEndTimeIsNotNull()
			{
				return !cx_CoreReportsEndTime.getValueIsNull(context);
			}
			public ims.framework.utils.Time getEndTime()
			{
				return (ims.framework.utils.Time)cx_CoreReportsEndTime.getValue(context);
			}

			private ims.framework.ContextVariable cx_CoreReportsEndTime = new ims.framework.ContextVariable("Core.Reports.EndTime", "_cv_Core.Reports.EndTime");
			public boolean getStartTimeIsNotNull()
			{
				return !cx_CoreReportsStartTime.getValueIsNull(context);
			}
			public ims.framework.utils.Time getStartTime()
			{
				return (ims.framework.utils.Time)cx_CoreReportsStartTime.getValue(context);
			}

			private ims.framework.ContextVariable cx_CoreReportsStartTime = new ims.framework.ContextVariable("Core.Reports.StartTime", "_cv_Core.Reports.StartTime");
			private ims.framework.Context context;
		}

		public boolean getHospitalIsNotNull()
		{
			return !cx_CoreHospital.getValueIsNull(context);
		}
		public ims.core.vo.LocMostVo getHospital()
		{
			return (ims.core.vo.LocMostVo)cx_CoreHospital.getValue(context);
		}
		public void setHospital(ims.core.vo.LocMostVo value)
		{
			cx_CoreHospital.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreHospital = new ims.framework.ContextVariable("Core.Hospital", "_cv_Core.Hospital");
		public boolean getWardIsNotNull()
		{
			return !cx_CoreWard.getValueIsNull(context);
		}
		public ims.core.vo.LocMostVo getWard()
		{
			return (ims.core.vo.LocMostVo)cx_CoreWard.getValue(context);
		}
		public void setWard(ims.core.vo.LocMostVo value)
		{
			cx_CoreWard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreWard = new ims.framework.ContextVariable("Core.Ward", "_cv_Core.Ward");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");

		public ReportsContext Reports;
		private ims.framework.Context context;
	}

	public CoreContext Core;
}
