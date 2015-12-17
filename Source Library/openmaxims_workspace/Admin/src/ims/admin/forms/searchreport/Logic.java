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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4680.16533)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.forms.searchreport;

import ims.admin.vo.SystemReportVoCollection;
import ims.admin.vo.enums.ReportSearchAction;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.txtReportName().setValue(null);
		form.getLocalContext().setevent(ims.admin.vo.enums.ReportSearchAction.CLEAR);
		form.fireCustomControlValueChanged();
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}

	private void search()
	{
		form.getLocalContext().setreportCollection(domain.listReports(form.getLocalContext().getsystemReportsOnly(), form.txtReportName().getValue()));
		form.getLocalContext().setevent(ims.admin.vo.enums.ReportSearchAction.SEARCH);
		form.fireCustomControlValueChanged();
	}

	public SystemReportVoCollection getReportCollection()
	{
		return form.getLocalContext().getreportCollection();
	}

	public void initialize(Boolean displaySystemReportsOnly)
	{
		form.getLocalContext().setsystemReportsOnly(displaySystemReportsOnly);
	}

	public void doSearch()
	{
		search();
	}

	public ReportSearchAction getEvent()
	{
		return form.getLocalContext().getevent();
	}

	public void clearEvent()
	{
		form.getLocalContext().setevent(null);
	}

	public void clear()
	{
		form.txtReportName().setValue(null);
	}

}
