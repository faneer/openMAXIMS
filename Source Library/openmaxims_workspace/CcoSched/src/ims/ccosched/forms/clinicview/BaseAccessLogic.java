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

package ims.ccosched.forms.clinicview;

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
			CcoSched = new CcoSchedForms();
		}
		public final class CcoSchedForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CcoSchedForms()
			{
				ClinicViewOutcomeComplete = new LocalFormName(128121);
				ClinicViewOutcomeIncomplete = new LocalFormName(128122);
				ClinicViewArrival = new LocalFormName(128117);
				ClinicViewCancel = new LocalFormName(128118);
				ClinicViewDNA = new LocalFormName(128119);
				ArrivedPatients = new LocalFormName(128105);
				TemplateSelect = new LocalFormName(128157);
				BookingCommentUpdate = new LocalFormName(128111);
				ClinicViewTPlanComment = new LocalFormName(128124);
				ClinicViewTumourDetails = new LocalFormName(128125);
				ClinicViewHistory = new LocalFormName(128120);
				LkupSelect = new LocalFormName(128158);
				ClinicViewSeen = new LocalFormName(128123);
				PrintLetter = new LocalFormName(128164);
			}
			public final FormName ClinicViewOutcomeComplete;
			public final FormName ClinicViewOutcomeIncomplete;
			public final FormName ClinicViewArrival;
			public final FormName ClinicViewCancel;
			public final FormName ClinicViewDNA;
			public final FormName ArrivedPatients;
			public final FormName TemplateSelect;
			public final FormName BookingCommentUpdate;
			public final FormName ClinicViewTPlanComment;
			public final FormName ClinicViewTumourDetails;
			public final FormName ClinicViewHistory;
			public final FormName LkupSelect;
			public final FormName ClinicViewSeen;
			public final FormName PrintLetter;
		}

		public CcoSchedForms CcoSched;
	}
}
