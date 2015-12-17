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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.19 build 40709.1515)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.hospitalreport;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;
import ims.coe.vo.HospitalReport;
import ims.coe.vo.HospitalReportCollection;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PatIdType;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.nursing.vo.HospitalReportSearchCriteriaVo;
import ims.core.vo.LocMostVoCollection;
import ims.core.vo.LocMostVo;
import ims.core.vo.PatientShort;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		Date yesterday = new Date();
		yesterday.setDay(yesterday.getDay() - 1);
		form.dteFrom().setValue(yesterday);

		DateTime nowTime = new DateTime();

		form.timFrom().setValue(nowTime.getTime());

		form.dteTo().setValue(nowTime.getDate());
		form.timTo().setValue(nowTime.getTime());

		// List Hosptals and add to Hospital combo
		fillHospitalListCombo();

		form.btnPrint().setEnabled(false);

		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		form.grdReport().setColHospnumCaption(dispIdType.getText());
		
		//WDEV-19389 
		if (form.getGlobalContext().Nursing.getHospitalReportSearchCriteriaIsNotNull())
		{
			setSearchCriteria(form.getGlobalContext().Nursing.getHospitalReportSearchCriteria());
			try
			{
				onImbSearchClick();
			}
			catch (PresentationLogicException e)
			{e.printStackTrace();}
		}

	}

	private HospitalReportSearchCriteriaVo getSearchCriteria()
	{
		HospitalReportSearchCriteriaVo searchCriteria = new HospitalReportSearchCriteriaVo();
		
		searchCriteria.setHospital(form.cmbHospital().getValue());
		searchCriteria.setWard(form.cmbWard().getValue());
		searchCriteria.setFromDate(form.dteFrom().getValue());
		searchCriteria.setFromTime(form.timFrom().getValue());
		searchCriteria.setToDate(form.dteTo().getValue());
		searchCriteria.setToTime(form.timTo().getValue());
		
		return searchCriteria;
	}
	
	
	private void setSearchCriteria(HospitalReportSearchCriteriaVo hospitalReportSearchCriteriaVo)
	{
		form.cmbHospital().setValue(hospitalReportSearchCriteriaVo.getHospital());
		if (form.cmbHospital().getValue().getType() != null)
		{
			if (form.cmbHospital().getValue().getType().equals(LocationType.HOSP))
			{
				fillWardListCombo();
			}
		}
		form.cmbWard().setValue(hospitalReportSearchCriteriaVo.getWard());
		form.dteFrom().setValue(hospitalReportSearchCriteriaVo.getFromDate());
		form.timFrom().setValue(hospitalReportSearchCriteriaVo.getFromTime());
		form.dteTo().setValue(hospitalReportSearchCriteriaVo.getToDate());
		form.timTo().setValue(hospitalReportSearchCriteriaVo.getToTime());
	}
	
	/**
	 * 
	 */
	private void fillHospitalListCombo()
	{
		LocMostVo locationFilter = new LocMostVo();
		locationFilter.setType(LocationType.HOSP);
		locationFilter.setIsActive(Boolean.TRUE);
		// Wards are used in 2 different tabs so if wards already retrieved dont
		// hit DB
		LocMostVoCollection voCollHospitals = null;
		voCollHospitals = domain.listLocations(locationFilter);
		if (voCollHospitals != null)
		{
			for (int i = 0; i < voCollHospitals.size(); i++)
			{
				form.cmbHospital().newRow(voCollHospitals.get(i), voCollHospitals.get(i).getName());
			}
		}

	}

	protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.grdReport().getRows().size() == 0)
		{
			engine.showMessage("No data to print !");
			return;
		}

		engine.open(form.getForms().Core.Reports);
		
		/*
		if (ConfigFlag.GEN.REPORTS_TYPE.getValue().equals("Crystal"))
		{
			form.getGlobalContext().Core.setWard(form.cmbWard().getValue());
			form.getGlobalContext().Core.setHospital(form.cmbHospital().getValue());
			form.getGlobalContext().Core.Reports.setStartDate(form.dteFrom().getValue());
			form.getGlobalContext().Core.Reports.setEndDate(form.dteTo().getValue());
			form.getGlobalContext().Core.Reports.setStartTime(form.timFrom().getValue());
			form.getGlobalContext().Core.Reports.setEndTime(form.timTo().getValue());
			engine.open(form.getForms().COE.RptHospitalReport);
		}
		else if (ConfigFlag.GEN.REPORTS_TYPE.getValue().equals("QueryBuilder"))
			engine.open(form.getForms().Core.Reports);
		*/
	}

	private void listReports()
	{
		form.grdReport().getRows().clear();

		if (form.dteFrom().getValue() == null || form.timFrom().getValue() == null || form.dteTo().getValue() == null || form.timTo().getValue() == null)
		{
			engine.showMessage("Please enter a date and time range to search on.");
			return;
		}

		if (form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
		{
			engine.showMessage("'Date From' cannot be after 'Date To'");
			return;
		}
		else if (form.dteFrom().getValue().equals(form.dteTo().getValue()))
		{
			if (form.timFrom().getValue().isGreaterThan(form.timTo().getValue()))
			{
				engine.showMessage("'Time From' cannot be after 'Time To'");
				return;
			}
		}

		ims.framework.utils.DateTime dtFrom = new DateTime(form.dteFrom().getValue(), form.timFrom().getValue());
		ims.framework.utils.DateTime dtTo = new DateTime(form.dteTo().getValue(), form.timTo().getValue());
		HospitalReportCollection notesColl = null;

		if (form.cmbWard().getValue() == null)
			notesColl = domain.listHospitalReportsByHospital(form.cmbHospital().getValue(), dtFrom, dtTo);
		else
			notesColl = domain.listHospitalReports(form.cmbWard().getValue(), dtFrom, dtTo);

		form.getGlobalContext().Nursing.setHospitalReportSearchCriteria(getSearchCriteria()); // WDEV-19389 
		if (notesColl == null || notesColl.size() == 0) //WDEV-18763
		{
			engine.showMessage("No records were found that match the specified search criteria.", "No Data Found", MessageButtons.OK, MessageIcon.WARNING); //WDEV-18763
			return;
		}	
		GenForm.grdReportRow row;
		for (int i = 0; i < notesColl.size(); i++)
		{
			HospitalReport notes = notesColl.get(i);
			row = form.grdReport().getRows().newRow();
			if (notes.getAuthoringInfoIsNotNull())
			{
				if (notes.getAuthoringInfo().getAuthoringHcpIsNotNull())
					row.setColBy(notes.getAuthoringInfo().getAuthoringHcp().toString());

				if (notes.getAuthoringInfo().getAuthoringDateTimeIsNotNull())
					row.setColDate(notes.getAuthoringInfo().getAuthoringDateTime().toString());
			}
			PatientShort patient = domain.getPatientFromCareContext(notes.getCareContext());
			StringBuffer sb = new StringBuffer("");
			if (patient.getName().getSurname() != null)
				sb.append(patient.getName().getSurname());

			sb.append(", ");

			if (patient.getName().getForename() != null)
				sb.append(patient.getName().getForename());

			row.setColPatientName(sb.toString());

			row.setTooltipForColPatientName(patient.getName().toString());

			if (patient.getDisplayId() != null)
				row.setColHospnum(patient.getDisplayId().getValue().toString());

			row.setColClinicalNote(notes.getClinicalNote());
			if (notes.getWard().getName() != null)
				row.setcolWard(notes.getWard().getName());

			row.setValue(notes);
		}
		form.btnPrint().setEnabled(true);
	}

	protected void onCmbHospitalValueChanged() throws PresentationLogicException
	{
		form.cmbWard().clear();
		form.grdReport().getRows().clear();
		if (form.cmbHospital().getValue() == null)
			return;

		if (form.cmbHospital().getValue().getType() != null)
		{
			if (form.cmbHospital().getValue().getType().equals(LocationType.HOSP))
			{
				fillWardListCombo();
			}
		}

	}

	private void fillWardListCombo()
	{
		LocMostVo filter = new LocMostVo();
		filter.setType(LocationType.WARD);
		filter.setParentLocation(form.cmbHospital().getValue());
		filter.setIsActive(Boolean.TRUE);
		filter.setIsVirtual(Boolean.FALSE);
	

		LocMostVoCollection voColl = domain.listLocations(filter);
		for (int i = 0; i < voColl.size(); i++)
		{
			LocMostVo ward = voColl.get(i);
			form.cmbWard().newRow(ward, ward.getName());
		}

	}

	protected void onImbSearchClick() throws PresentationLogicException
	{
		if (form.cmbHospital().getValue() == null)
		{
			engine.showMessage("Please select a Hospital");
			return;
		}
		form.btnPrint().setEnabled(false);
		form.getGlobalContext().Core.setWard(form.cmbWard().getValue());
		form.getGlobalContext().Core.setHospital(form.cmbHospital().getValue());

		listReports();

	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (result.equals(DialogResult.OK) && formName.equals(form.getForms().Core.Reports))
		{
			printReport();
		}
	}

	private void printReport()
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer =ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

		String[] obj = null;
		try
		{
			obj = domain.getReportAndTemplate(form.getGlobalContext().Core.getReportID(), form.getGlobalContext().Core.getTemplateID());
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage("Error retrieving report template !\r\n" + e.getMessage());
			return;
		}

		if (obj == null || obj.length == 0)
		{
			engine.showMessage("I could not get the report and template !");
			return;
		}

		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		DateTime startDate = new DateTime(form.dteFrom().getValue(), form.timFrom().getValue());
		DateTime endDate = new DateTime(form.dteTo().getValue(), form.timTo().getValue());

		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		client.addSeed(new SeedValue("HOSPITAL", form.cmbHospital().getValue().getID_Location(), Integer.class));
		
		if(form.cmbWard().getValue() != null)
			client.addSeed(new SeedValue("WARD", form.cmbWard().getValue().getID_Location(), Integer.class));
		else
			client.addSeed(new SeedValue("WARD", null, Integer.class));
		
		client.addSeed(new SeedValue("DATE_START", startDate.getJavaDate(), java.util.Date.class));
		client.addSeed(new SeedValue("DATE_END", endDate.getJavaDate(), java.util.Date.class));
		client.addSeed(new SeedValue("PATIDTYPE", new Integer(dispIdType.getId()), Integer.class));

		String resultUrl = "";

		try
		{
			resultUrl = client.buildReportAsUrl(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
		}
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return;
		}

		engine.openUrl(resultUrl);
	}
}
