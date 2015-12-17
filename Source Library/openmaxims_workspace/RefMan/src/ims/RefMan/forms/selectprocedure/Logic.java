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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.66 build 3257.22034)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.selectprocedure;

import ims.RefMan.forms.selectprocedure.GenForm.grd1Row;
import ims.RefMan.forms.selectprocedure.GenForm.grd2Row;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.ProcedureLiteVoCollection;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		ProcedureLiteVoCollection showProcedures=new ProcedureLiteVoCollection();
		ProcedureLiteVoCollection procedures = domain.listProcedures();
		ProcedureLiteVoCollection existingProcedures = form.getGlobalContext().RefMan.getunavailableProcedures();
		if (existingProcedures==null)
		{
			showProcedures=procedures;
		}
		else
		{
			for (ProcedureLiteVo item: procedures)
			{
				if (!existingProcedures.contains(item))
				showProcedures.add(item);
			}
		}
		
		populateSelectProceduresGrid(showProcedures);
		populateSelectedProceduresGrid(form.getGlobalContext().RefMan.getAssociatedProcedures());
		
		
	}
	
	private void populateSelectedProceduresGrid(ProcedureLiteVoCollection existingProcedures) 
	{	
		if (existingProcedures!=null)
			for (ProcedureLiteVo item: existingProcedures)
			{
				grd2Row row = form.grd2().getRows().newRow();
				row.setColProcedure(item.getProcedureName());
				row.setValue(item);
			}
	}

	private void populateSelectProceduresGrid(ProcedureLiteVoCollection showProcedures) 
	{	
		for (ProcedureLiteVo item: showProcedures)
		{
			grd1Row row = form.grd1().getRows().newRow();
			row.setProcedure(item.getProcedureName());
			row.setValue(item);
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ProcedureLiteVoCollection procedures=new ProcedureLiteVoCollection();
		for (int i=0;i<form.grd2().getRows().size();i++)
		{
			procedures.add(form.grd2().getRows().get(i).getValue());
		}
		form.getGlobalContext().RefMan.setprocedureListForActivity(procedures);
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtn2Click() throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i=0;i<form.grd2().getRows().size();i++)
		{
			grd2Row row = form.grd2().getRows().get(i);
			if (row.getcolSelect())
			{
				form.grd2().getRows().remove(i);
				i--;
				grd1Row row1 = form.grd1().getRows().newRow();
				row1.setProcedure(row.getColProcedure());
				row1.setcolSelect(false);
				row1.setValue(row.getValue());
				
			}
		}
	}
	@Override
	protected void onBtn1Click() throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i=0;i<form.grd1().getRows().size();i++)
		{
			grd1Row row = form.grd1().getRows().get(i);
			if (row.getcolSelect())
			{
				form.grd1().getRows().remove(i);
				i--;
				grd2Row row2 = form.grd2().getRows().newRow();
				row2.setColProcedure(row.getProcedure());
				row2.setcolSelect(false);
				row2.setValue(row.getValue());
				
			}
		}
	}
}
