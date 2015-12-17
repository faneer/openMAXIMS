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

package ims.ocrr.forms.ordersrequiringauthorisation;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
		Core = new CoreContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

			PathologyResults = new PathologyResultsContext(context);
		}
		public final class PathologyResultsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PathologyResultsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getOrderIsNotNull()
			{
				return !cx_OCRRPathologyResultsOrder.getValueIsNull(context);
			}
			public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrder()
			{
				return (ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo)cx_OCRRPathologyResultsOrder.getValue(context);
			}
		public void setOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
		{
				cx_OCRRPathologyResultsOrder.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRPathologyResultsOrder = new ims.framework.ContextVariable("OCRR.PathologyResults.Order", "_cv_OCRR.PathologyResults.Order");
			private ims.framework.Context context;
		}

		public boolean getOrderAwaitingAuthorisationIsNotNull()
		{
			return !cx_OCRROrderAwaitingAuthorisation.getValueIsNull(context);
		}
		public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrderAwaitingAuthorisation()
		{
			return (ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo)cx_OCRROrderAwaitingAuthorisation.getValue(context);
		}
		public void setOrderAwaitingAuthorisation(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
		{
			cx_OCRROrderAwaitingAuthorisation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRROrderAwaitingAuthorisation = new ims.framework.ContextVariable("OCRR.OrderAwaitingAuthorisation", "_cv_OCRR.OrderAwaitingAuthorisation");
		public boolean getOrdersRequiringAuthorisationSearchCriteriaIsNotNull()
		{
			return !cx_OCRROrdersRequiringAuthorisationSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo getOrdersRequiringAuthorisationSearchCriteria()
		{
			return (ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo)cx_OCRROrdersRequiringAuthorisationSearchCriteria.getValue(context);
		}
		public void setOrdersRequiringAuthorisationSearchCriteria(ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo value)
		{
			cx_OCRROrdersRequiringAuthorisationSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRROrdersRequiringAuthorisationSearchCriteria = new ims.framework.ContextVariable("OCRR.OrdersRequiringAuthorisationSearchCriteria", "_cvp_OCRR.OrdersRequiringAuthorisationSearchCriteria");

		public PathologyResultsContext PathologyResults;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
	public CoreContext Core;
}
