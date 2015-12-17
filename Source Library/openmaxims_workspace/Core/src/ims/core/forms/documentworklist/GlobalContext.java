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

package ims.core.forms.documentworklist;

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

		}

		public boolean getPatientDocumentsCollectionIsNotNull()
		{
			return !cx_CorePatientDocumentsCollection.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentforDocumentWorklistVoCollection getPatientDocumentsCollection()
		{
			return (ims.core.vo.PatientDocumentforDocumentWorklistVoCollection)cx_CorePatientDocumentsCollection.getValue(context);
		}
		public void setPatientDocumentsCollection(ims.core.vo.PatientDocumentforDocumentWorklistVoCollection value)
		{
			cx_CorePatientDocumentsCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDocumentsCollection = new ims.framework.ContextVariable("Core.PatientDocumentsCollection", "_cv_Core.PatientDocumentsCollection");
		public boolean getPatientCorrespondenceIsNotNull()
		{
			return !cx_CorePatientCorrespondence.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentVo getPatientCorrespondence()
		{
			return (ims.core.vo.PatientDocumentVo)cx_CorePatientCorrespondence.getValue(context);
		}
		public void setPatientCorrespondence(ims.core.vo.PatientDocumentVo value)
		{
			cx_CorePatientCorrespondence.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientCorrespondence = new ims.framework.ContextVariable("Core.PatientCorrespondence", "_cv_Core.PatientCorrespondence");
		public boolean getKeepPatientInContextIsNotNull()
		{
			return !cx_CoreKeepPatientInContext.getValueIsNull(context);
		}
		public Boolean getKeepPatientInContext()
		{
			return (Boolean)cx_CoreKeepPatientInContext.getValue(context);
		}
		public void setKeepPatientInContext(Boolean value)
		{
			cx_CoreKeepPatientInContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreKeepPatientInContext = new ims.framework.ContextVariable("Core.KeepPatientInContext", "_cvp_Core.KeepPatientInContext");
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
		public boolean getDocumentWorklistSearchCriteriaIsNotNull()
		{
			return !cx_CoreDocumentWorklistSearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.DocumentWorklistSearchCriteriaVo getDocumentWorklistSearchCriteria()
		{
			return (ims.core.vo.DocumentWorklistSearchCriteriaVo)cx_CoreDocumentWorklistSearchCriteria.getValue(context);
		}
		public void setDocumentWorklistSearchCriteria(ims.core.vo.DocumentWorklistSearchCriteriaVo value)
		{
			cx_CoreDocumentWorklistSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreDocumentWorklistSearchCriteria = new ims.framework.ContextVariable("Core.DocumentWorklistSearchCriteria", "_cvp_Core.DocumentWorklistSearchCriteria");
		public boolean getPatientDocumentsErrorsIsNotNull()
		{
			return !cx_CorePatientDocumentsErrors.getValueIsNull(context);
		}
		public ims.correspondence.vo.PatientDocumentErrorVoCollection getPatientDocumentsErrors()
		{
			return (ims.correspondence.vo.PatientDocumentErrorVoCollection)cx_CorePatientDocumentsErrors.getValue(context);
		}
		public void setPatientDocumentsErrors(ims.correspondence.vo.PatientDocumentErrorVoCollection value)
		{
			cx_CorePatientDocumentsErrors.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDocumentsErrors = new ims.framework.ContextVariable("Core.PatientDocumentsErrors", "_cv_Core.PatientDocumentsErrors");
		public boolean getNewDocumentStatusIsNotNull()
		{
			return !cx_CoreNewDocumentStatus.getValueIsNull(context);
		}
		public ims.core.vo.lookups.DocumentStatus getNewDocumentStatus()
		{
			return (ims.core.vo.lookups.DocumentStatus)cx_CoreNewDocumentStatus.getValue(context);
		}
		public void setNewDocumentStatus(ims.core.vo.lookups.DocumentStatus value)
		{
			cx_CoreNewDocumentStatus.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreNewDocumentStatus = new ims.framework.ContextVariable("Core.NewDocumentStatus", "_cv_Core.NewDocumentStatus");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
