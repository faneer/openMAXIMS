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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.adviceleafletsconfig;

import ims.clinical.vo.ClinicalProblemShortVo;
import ims.clinical.vo.ClinicalProblemShortVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.TemplateForReportTemplateSearchVo;
import ims.core.vo.enums.ReportTemplateSearchEvent;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.forms.adviceleafletsconfig.GenForm.grdProblemsRow;
import ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.lblTemplateName().setValue(null);
		open();
	}

	private void open()
	{

		form.ccReportTemplateSearch().refresh();
		form.setMode(FormMode.VIEW);
	}

	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (DialogResult.OK.equals(result))
		{
			populateProblemsGrid(form.getGlobalContext().Emergency.getSelectedProblems());
		}
	}

	@Override
	protected void onCcReportTemplateSearchValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (ReportTemplateSearchEvent.BTNSEARCHEVENT.equals(form.ccReportTemplateSearch().getSelectedEvent()))
		{
			clearInstanceControls();
		}
		else if (ReportTemplateSearchEvent.GRIDSELECTIONEVENT.equals(form.ccReportTemplateSearch().getSelectedEvent()))
		{
			form.getLocalContext().setselectedTemplate(form.ccReportTemplateSearch().getSelectedTemplate());
			if (form.getLocalContext().getselectedTemplate()!=null)
			{	
				form.getLocalContext().setcurrentAdviceLeaflet(domain.getAdviceLeafletByTemplate(form.getLocalContext().getselectedTemplate()));
				populateInstanceControls(form.getLocalContext().getcurrentAdviceLeaflet());
			}
		}
		updateControlsState();
	}

	private void populateInstanceControls(AdviceLeafletsForPresentingProblemConfigVo adviceLeaflet)
	{		
		form.grdProblems().getRows().clear();
		
		if (adviceLeaflet == null)
		{
			form.lblTemplateName().setValue(form.getLocalContext().getselectedTemplate().getName());
			form.chkTemplateAvailable().setValue(null);	
			return;
		}
			
		form.lblTemplateName().setValue(adviceLeaflet.getTemplate().getName());
		form.chkTemplateAvailable().setValue(adviceLeaflet.getIsGenericAdviceLeaflet());

		populateProblemsGrid(adviceLeaflet.getProblems());
	}

	private void populateProblemsGrid(ClinicalProblemShortVoCollection collProblems)
	{
		form.grdProblems().getRows().clear();
		
		if (collProblems == null)
			return;
		
		collProblems.sort(new ProblemsNameComparator(SortOrder.ASCENDING));
		
		for (int i = 0; i < collProblems.size(); i++)
		{
			ClinicalProblemShortVo clinicalProblem = collProblems.get(i);

			grdProblemsRow row = form.grdProblems().getRows().newRow();
			row.setcolProblem(clinicalProblem.getPCName());
			row.setValue(clinicalProblem);
		}
	}

	public class ProblemsNameComparator implements Comparator
	{
		private int direction = 1;
		
		public ProblemsNameComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public ProblemsNameComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String p1Name = null;
			String p2Name = null;
			if(ob1 instanceof ClinicalProblemShortVo )
			{
				ClinicalProblemShortVo problem1Name = (ClinicalProblemShortVo)ob1;
				p1Name = problem1Name != null ? problem1Name.getPCName():null;
			}
			if(ob2 instanceof ClinicalProblemShortVo )
			{
				ClinicalProblemShortVo problem2Name = (ClinicalProblemShortVo)ob2;
				p2Name = problem2Name != null ? problem2Name.getPCName():null;
			}
			if(p1Name != null )
				return  p1Name.toUpperCase().compareTo(p2Name.toUpperCase())*direction;
			if(p2Name != null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	private void clearInstanceControls()
	{
		form.lblTemplateName().setValue(null);
		form.chkTemplateAvailable().setValue(null);
		form.grdProblems().getRows().clear();
		form.grdProblems().setValue(null);
		form.getGlobalContext().Emergency.setSelectedProblems(null);
		form.getLocalContext().setcurrentAdviceLeaflet(null);
		form.getLocalContext().setselectedTemplate(null);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	private boolean save()
	{
		AdviceLeafletsForPresentingProblemConfigVo adviceLeafletToSave = populateDataFromScreen(form.getLocalContext().getcurrentAdviceLeaflet());

		String[] errors = adviceLeafletToSave.validate();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		// Check SOE
		if (adviceLeafletToSave.getID_AdviceLeafletsConfigIsNotNull() && domain.isStale(adviceLeafletToSave))
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			// form.getLocalContext().setselectedClinicianNote(null);
			open();
			return false;
		}

		try
		{
			form.getLocalContext().setcurrentAdviceLeaflet(domain.save(adviceLeafletToSave));
		}

		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}

		return true;
	}

	private AdviceLeafletsForPresentingProblemConfigVo populateDataFromScreen(AdviceLeafletsForPresentingProblemConfigVo adviceLeaflet)
	{
		if (adviceLeaflet == null)
			adviceLeaflet = new AdviceLeafletsForPresentingProblemConfigVo();

		adviceLeaflet.setTemplate(form.getLocalContext().getselectedTemplate());
		adviceLeaflet.setIsGenericAdviceLeaflet(form.chkTemplateAvailable().getValue());

		ClinicalProblemShortVoCollection collProblems = new ClinicalProblemShortVoCollection();
		for (int i = 0; i < form.grdProblems().getRows().size(); i++)
		{
			collProblems.add(form.grdProblems().getRows().get(i).getValue());
		}
		adviceLeaflet.setProblems(collProblems);

		return adviceLeaflet;
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnRemoveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdProblems().removeSelectedRow();
		updateControlsState();
	}

	@Override
	protected void onGrdProblemsSelectionChanged()
	{
		updateControlsState();
	}

	@Override
	protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ClinicalProblemShortVoCollection collProblems = new ClinicalProblemShortVoCollection();
		
		for (int i = 0; i < form.grdProblems().getRows().size(); i++)
		{
			collProblems.add(form.grdProblems().getRows().get(i).getValue());
		}
		
		form.getGlobalContext().Emergency.setSelectedProblems(collProblems);
		
		engine.open(form.getForms().Emergency.ProblemSelectDialog);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();

	}

	private void updateControlsState()
	{
		form.ccReportTemplateSearch().setEnabled(FormMode.VIEW.equals(form.getMode()));
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && form.ccReportTemplateSearch().getSelectedTemplate() instanceof TemplateForReportTemplateSearchVo);

		//form.btnAdd().setVisible(FormMode.EDIT.equals(form.getMode()));
		//form.btnRemove().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdProblems().getValue() instanceof ClinicalProblemShortVo);
		
		form.btnAdd().setEnabled(FormMode.EDIT.equals(form.getMode()) && !form.chkTemplateAvailable().getValue());
		form.btnRemove().setEnabled(FormMode.EDIT.equals(form.getMode()) && !form.chkTemplateAvailable().getValue() && form.grdProblems().getValue() instanceof ClinicalProblemShortVo);
		form.grdProblems().setEnabled(FormMode.EDIT.equals(form.getMode()) && !form.chkTemplateAvailable().getValue());
		
		form.chkTemplateAvailable().setEnabled(FormMode.EDIT.equals(form.getMode()));

	}

	@Override
	protected void onChkTemplateAvailableValueChanged() throws PresentationLogicException
	{
		if (form.chkTemplateAvailable().getValue())
		{
			form.grdProblems().getRows().clear();
			form.grdProblems().setValue(null);
		}
		
		updateControlsState();
		
	}
}
