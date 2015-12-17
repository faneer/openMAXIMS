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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.patientgphistory;

import ims.core.forms.patientgphistory.GenForm.grdHistoryRow;
import ims.core.vo.PDSPatientGPListVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-21863 
		PDSPatientGPListVoCollection histList = form.getGlobalContext().Core.getPatientShort() != null ? domain.listPatientGpHistory(form.getGlobalContext().Core.getPatientShort()) : null;
		
		populateScreenFromData(histList);
	}

	private void populateScreenFromData(PDSPatientGPListVoCollection histList)
	{
		form.grdHistory().getRows().clear();
		
		if (histList == null)
			return;
		
		for(int i = 0; i < histList.size(); i++)
		{
			grdHistoryRow row = form.grdHistory().getRows().newRow();
			
			if(histList.get(i).getGp() != null)
				row.setcolGP(histList.get(i).getGp().getName().toString());

			if(histList.get(i).getBeffdate() != null)
				row.setcolEffectiveDate(histList.get(i).getBeffdate().toString());
			
			if(histList.get(i).getBetdateIsNotNull())
				row.setcolDate(histList.get(i).getBetdate().toString());
		}
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
}
