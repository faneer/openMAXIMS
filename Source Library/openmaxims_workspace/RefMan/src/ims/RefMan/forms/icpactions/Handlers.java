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

package ims.RefMan.forms.icpactions;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnk1Click() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPreviousClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNextClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyr1TabChanged(ims.framework.LayerBridge tab);
	abstract protected void onlyrNursingTabChanged(ims.framework.LayerBridge tab);

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormOpen(args);
			}
		});
		this.form.lnk1().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnk1Click();
			}
		});
		this.form.btnPrevious().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviousClick();
			}
		});
		this.form.btnNext().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNextClick();
			}
		});
		this.form.lyr1().tabActions().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabActionsActivated();
			}
		});
		this.form.lyr1().tabConsultant().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabConsultantActivated();
			}
		});
		this.form.lyr1().tabNursing().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabNursingActivated();
			}
		});
		this.form.lyr1().tabAnaesthetist().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabAnaesthetistActivated();
			}
		});
		this.form.lyr1().tabTherapy().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabTherapyActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabPatientDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabPatientDetailsActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabBasObs().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabBasObsActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabMedication().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabMedicationActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabReason().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabReasonActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabHealth().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabHealthActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabClexane().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabClexaneActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabSupport().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabSupportActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabDischarge().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabDischargeActivated();
			}
		});
		this.form.lyr1().tabNursing().lyrNursing().tabInvestigations().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrNursingtabInvestigationsActivated();
			}
		});
	}
	private void onlyr1tabActionsActivated()
	{
		this.form.lyr1().showtabActions();
		onlyr1TabChanged(this.form.lyr1().tabActions());
	}
	private void onlyr1tabConsultantActivated()
	{
		this.form.lyr1().showtabConsultant();
		onlyr1TabChanged(this.form.lyr1().tabConsultant());
	}
	private void onlyr1tabNursingActivated()
	{
		this.form.lyr1().showtabNursing();
		onlyr1TabChanged(this.form.lyr1().tabNursing());
	}
	private void onlyr1tabAnaesthetistActivated()
	{
		this.form.lyr1().showtabAnaesthetist();
		onlyr1TabChanged(this.form.lyr1().tabAnaesthetist());
	}
	private void onlyr1tabTherapyActivated()
	{
		this.form.lyr1().showtabTherapy();
		onlyr1TabChanged(this.form.lyr1().tabTherapy());
	}
	private void onlyrNursingtabPatientDetailsActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabPatientDetails();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabPatientDetails());
	}
	private void onlyrNursingtabBasObsActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabBasObs();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabBasObs());
	}
	private void onlyrNursingtabMedicationActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabMedication();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabMedication());
	}
	private void onlyrNursingtabReasonActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabReason();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabReason());
	}
	private void onlyrNursingtabHealthActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabHealth();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabHealth());
	}
	private void onlyrNursingtabClexaneActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabClexane();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabClexane());
	}
	private void onlyrNursingtabSupportActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabSupport();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabSupport());
	}
	private void onlyrNursingtabDischargeActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabDischarge();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabDischarge());
	}
	private void onlyrNursingtabInvestigationsActivated()
	{
		this.form.lyr1().tabNursing().lyrNursing().showtabInvestigations();
		onlyrNursingTabChanged(this.form.lyr1().tabNursing().lyrNursing().tabInvestigations());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
