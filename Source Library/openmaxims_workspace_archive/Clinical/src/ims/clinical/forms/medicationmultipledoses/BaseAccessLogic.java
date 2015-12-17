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

package ims.clinical.forms.medicationmultipledoses;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{
		if(!form.getGlobalContext().Core.getPatientShortIsNotNull())
			return false;

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Core = new CoreForms();
			Clinical = new ClinicalForms();
		}
		public final class CoreForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CoreForms()
			{
				YesNoDialog = new LocalFormName(102107);
				TaxonomySearch = new LocalFormName(104102);
			}
			public final FormName YesNoDialog;
			public final FormName TaxonomySearch;
		}
		public final class ClinicalForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicalForms()
			{
				CopyMedication = new LocalFormName(122127);
				MedicationDiscontinue = new LocalFormName(122157);
				MedicationMultipleDosesOnDischarge = new LocalFormName(122162);
				MedicationMultipleDosesOnAdmission = new LocalFormName(122161);
				MedicationMultipleDosesOPD = new LocalFormName(122163);
				MedicationMultipleDosesPatientDetails = new LocalFormName(122173);
				MedicationMultipleDoses_Dialog = new LocalFormName(122179);
			}
			public final FormName CopyMedication;
			public final FormName MedicationDiscontinue;
			public final FormName MedicationMultipleDosesOnDischarge;
			public final FormName MedicationMultipleDosesOnAdmission;
			public final FormName MedicationMultipleDosesOPD;
			public final FormName MedicationMultipleDosesPatientDetails;
			public final FormName MedicationMultipleDoses_Dialog;
		}

		public CoreForms Core;
		public ClinicalForms Clinical;
	}
}
