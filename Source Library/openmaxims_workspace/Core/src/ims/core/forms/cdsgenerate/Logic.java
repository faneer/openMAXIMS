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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.71 build 3607.26880)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.cdsgenerate;

import ims.admin.helper.QuartzProperties;
import ims.configuration.gen.ConfigFlag;
import ims.core.domain.impl.CDSGenerateImpl;
import ims.core.vo.CDSResultVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

import java.util.Date;
import java.util.Properties;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Logic extends BaseLogic
{
	//the next 3 definitions should be declared identically in CDSgenerateImpl.java
	private static final String	INPATIENT_REPORT_TYPE	= "INPATIENT_REPORT";
	private static final String	OUTPATIENT_REPORT_TYPE	= "OUTPATIENT_REPORT";
	private static final String	HRG_REPORT_TYPE	= "HRG_REPORT";
	private static final String	ELECTIVELIST_REPORT_TYPE = "ELECTIVELIST_REPORT"; //WDEV-18912
	
	private static final long	serialVersionUID		= 1L;
	private static final int	INPATIENT_REPORT_ID		= 215;
	private static final int	OUTPATIENT_REPORT_ID	= 216;
	private static final int	HRG_GROUPER_REPORT_ID	= 246;
	private static final int	ELECTIVELIST_REPORT_ID	= 217; //WDEV-18912

	private static JobDetail jd;
	Properties properties=null;

	@Override
	protected void onBtnInpatientClick() throws PresentationLogicException
	{
		buildReport(INPATIENT_REPORT_ID);
	}
	@Override
	protected void onBtnOutpatientClick() throws PresentationLogicException
	{
		buildReport(OUTPATIENT_REPORT_ID);
	}
	@Override
	protected void onBtnHrgGrouperClick() throws PresentationLogicException 
	{
		buildReport(HRG_GROUPER_REPORT_ID);
	}
	@Override
	protected void onBtnOutpatientDataClick() throws PresentationLogicException
	{
		if (createScheduledJob("OUTPATIENT") == 0)
			engine.showMessage("Outpatient CDS Data Generation Job has been Scheduled");
	}
	
	protected void onBtnInpatientDataClick() throws PresentationLogicException 
	{		
		if (createScheduledJob("INPATIENT") == 0)
			engine.showMessage("Inpatient CDS Data Generation Job has been Scheduled");
	}
	
	
	
	protected int createScheduledJob(String reportType)
	{
		if (form.dtimScheduled().getValue() == null || form.dtimScheduled().getValue().isLessThan(new DateTime()))
		{
			engine.showMessage("Please specify a valid future date/time value to schedule this job");
			return -1;
		}
		
		if(checkDateInterval() == false)
			return -1;
	
		
		Properties properties = QuartzProperties.getProperties();
		if( properties == null)
		{
			System.out.println("Quartz start without property file");
		}
		
		SchedulerFactory sf;
		try 
		{
			sf = new StdSchedulerFactory(properties);
			SimpleTrigger simpleCron=null;
			
			try
			{
				Scheduler sched = sf.getScheduler();
				if (!sched.isStarted())	{
					sched.start();
				}				
				
				jd = new JobDetail(reportType + CDSGenerateImpl.class.getSimpleName(), "CDS", CDSGenerateImpl.class);
				jd.setRequestsRecovery(true);		
				jd.setDescription(CDSGenerateImpl.class.getSimpleName());
				JobDataMap mp = new JobDataMap();
				mp.put("JOB_TYPE", reportType);
				mp.put("DATE_FROM", form.dteFrom().getValue());
				mp.put("DATE_TO", form.dteTo().getValue());
				
//				if(HRG_REPORT_TYPE.equals(reportType) || INPATIENT_REPORT_TYPE.equals(reportType) || OUTPATIENT_REPORT_TYPE.equals(reportType))
				if(HRG_REPORT_TYPE.equals(reportType) || INPATIENT_REPORT_TYPE.equals(reportType) || OUTPATIENT_REPORT_TYPE.equals(reportType))
				{
					String nlc;
					if(form.lblCode().getValue() == null || form.lblCode().getValue().length() == 0)
						nlc = "%";
					else
						nlc = form.lblCode().getValue();
					
					mp.put("NLC", nlc);
					mp.put("REQURL", engine.getRequestUrl());
				}
				
				jd.setJobDataMap(mp);
				
				simpleCron = new SimpleTrigger(reportType + CDSGenerateImpl.class.getSimpleName(), CDSGenerateImpl.class.getSimpleName(), form.dtimScheduled().getValue().getJavaDate(), null, 0, 0);
				simpleCron.setStartTime(form.dtimScheduled().getValue().getJavaDate());																	
				
				sched.scheduleJob(jd, simpleCron);		
				
			}
			catch (SchedulerException error)
			{
				if (error instanceof ObjectAlreadyExistsException)
					engine.showMessage("A CDS job of this type already exists, please clear scheduled jobs and try again");
				else
					engine.showMessage("SchedulerException: " +  error.getMessage());
				return -1;
			}		
			
		} 
		catch (SchedulerException err) {
			
			System.out.println(err.getMessage());
		}
		return 0;
						
	}

	private void buildReport(int reportId)
	{
		if(checkConfigFlags() == false)
			return;

		if(checkDateInterval() == false)
			return;
		
		form.htmResult().setHTML("");
		form.htmDownload().setHTML("");
		form.htmDownload().setEnabled(false);
		
		String nlc;
		if(form.lblCode().getValue() == null || form.lblCode().getValue().length() == 0)
			nlc = "%";
		else
			nlc = form.lblCode().getValue();
		
		try
		{
			CDSResultVo res = domain.buildCDSReport(form.dteFrom().getValue(), form.dteTo().getValue(), nlc, reportId, engine.getSessionId(), engine.getRequestUrl());

			if(Boolean.TRUE.equals(res.getSuccessful()))
			{
				if(res.getResultUrlIsNotNull())
				{
					String url = res.getResultUrl();
					int index = url.lastIndexOf('/');
					
					if(index > -1)
						url = url.substring(index+1);
					
					form.htmDownload().setHTML("<b><a style=\"float: right\" href='" + res.getResultUrl() + "'><font color='blue'>" + url + "</font></a><span style=\"float: right\">Download file:  &nbsp;</span></b>");
					form.htmDownload().setEnabled(true);
				}
				
				form.htmResult().setHTML("<IFRAME id=\"ResultFrame123\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + res.getLogUrl() + "'></IFRAME>");
			}
			else
			{
				engine.showMessage(res.getErrorMessage());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
		}
	}

	private boolean checkDateInterval()
	{
		if(form.dteFrom().getValue() == null)
		{
			engine.showMessage("Please enter the start date !");
			return false;
		}

		if(form.dteTo().getValue() == null)
		{
			engine.showMessage("Please enter the end date !");
			return false;
		}
		
		return true;
	}
	private boolean checkConfigFlags()
	{
		String queryServerUrl = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String reportServerUrl = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		if(queryServerUrl == null || queryServerUrl.length() == 0 || queryServerUrl.equals(ConfigFlag.GEN.QUERY_SERVER_URL.getDefaultValue()))
		{
			engine.showMessage("The config flag QUERY_SERVER_URL was not set !");
			return false;
		}
		
		if(reportServerUrl == null || reportServerUrl.length() == 0 || reportServerUrl.equals(ConfigFlag.GEN.REPORT_SERVER_URL.getDefaultValue()))
		{
			engine.showMessage("The config flag REPORT_SERVER_URL was not set !");
			return false;
		}
		
		return true;
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
	}
	
	@Override
	protected void onQmbLocationTextSubmited(String value) throws PresentationLogicException
	{
		form.qmbLocation().clear();
		
		LocationLiteVoCollection col = domain.listLocation(value);
		
		for(LocationLiteVo loc : col)
		{
			form.qmbLocation().newRow(loc, loc.getName());	
		}
		
		if(col.size() == 1)
		{
			form.qmbLocation().setValue(col.get(0));
			onQmbLocationValueChanged();
		}
		else
			form.qmbLocation().showOpened();
	}
	@Override
	protected void onQmbLocationValueChanged() throws PresentationLogicException
	{
		form.lblCode().setValue(null);
		
		LocationLiteVo loc = form.qmbLocation().getValue();
		
		if(loc != null)
			form.lblCode().setValue(domain.getNationalLocationCode(loc));
	}

	@Override
	protected void onBtnClearCurrentJobsClick()
			throws PresentationLogicException 
	{
		if (properties == null)
		{
			properties = QuartzProperties.getProperties();
		}
		StdSchedulerFactory sf;
		try {
			sf = new StdSchedulerFactory(properties);
		
			Scheduler sched = sf.getScheduler();
			sched.deleteJob("INPATIENT" + CDSGenerateImpl.class.getSimpleName(), "CDS");
			sched.deleteJob("OUTPATIENT" + CDSGenerateImpl.class.getSimpleName(), "CDS");
			sched.deleteJob(INPATIENT_REPORT_TYPE + CDSGenerateImpl.class.getSimpleName(), "CDS");
			sched.deleteJob(OUTPATIENT_REPORT_TYPE + CDSGenerateImpl.class.getSimpleName(), "CDS");
			sched.deleteJob(HRG_REPORT_TYPE + CDSGenerateImpl.class.getSimpleName(), "CDS");
			
			
			engine.showMessage("All Scheduled CDS Jobs have now been deleted");
		} 
		catch (SchedulerException e) 
		{
			engine.showMessage("SchedulerException occurred deleting jobs - " + e.getMessage());
		}
	}
	
	/**
	 * This method will check to see what the current schedule is for the Inpatient CDS i.e.
	 * if there is a job scheduled
	 */
	@Override
	protected void onBtnCheckInpatientSchedClick() throws PresentationLogicException 
	{
		checkForJobs("INPATIENT");
	}

	
	/**
	 * This method will check to see what the current schedule is for the Outpatient CDS i.e.
	 * if there is a job scheduled
	 */
	@Override
	protected void onBtnCheckOutpatientClick() throws PresentationLogicException 
	{
		checkForJobs("OUTPATIENT");		
	}

	
	private void checkForJobs(String jobType)
	{
		if (properties == null)
		{
			properties = QuartzProperties.getProperties();
		}
		StdSchedulerFactory sf;
		try {
			sf = new StdSchedulerFactory(properties);
		
			Scheduler sched = sf.getScheduler();
			JobDetail jd = sched.getJobDetail(jobType + CDSGenerateImpl.class.getSimpleName(), "CDS");
			
			if (jd == null)
			{
				engine.showMessage("There is currently no job scheduled to generate " + jobType + " Data");
			}
			else
			{

				// See if there is a job currently running
				@SuppressWarnings("rawtypes")
				java.util.List lst = sched.getCurrentlyExecutingJobs();
				if (lst != null && lst.size() > 0)
				{
					StringBuffer jobList = new StringBuffer();

					for (int i=0; i<lst.size(); i++)
					{
						JobExecutionContext jec = (JobExecutionContext) lst.get(i);
						JobDetail groupJob = jec.getJobDetail();
						if (!groupJob.getGroup().equals("CDS") || !groupJob.getFullName().startsWith("CDS." +jobType))
							continue;
						
						Date dt = jec.getFireTime();
						jobList.append(jobType).append(" Job ").append(jec.getJobDetail().getName()).append(" currently running\r");
						jobList.append("   this job was fired at " + dt.toString() + "\r\n");
					}
					
					if (jobList.length() > 0)
					{
						engine.showMessage(jobList.toString());
						return;
					}
				}

				Trigger[] trigg = sched.getTriggersOfJob(jobType + CDSGenerateImpl.class.getSimpleName(), "CDS");
				if (trigg != null && trigg.length > 0)
				{
					SimpleTrigger trig = (SimpleTrigger) trigg[0];
					Date dt = trig.getNextFireTime();
					
					JobDataMap map = jd.getJobDataMap();
					ims.framework.utils.Date dteFrom = (ims.framework.utils.Date) map.get("DATE_FROM");
					ims.framework.utils.Date dteTo = (ims.framework.utils.Date) map.get("DATE_TO");
					if (dt != null)
						engine.showMessage("CDS Generate type " + jobType + " scheduled to be executed " + dt.toString() + "\r with a date range of " + dteFrom + " and " + dteTo);
					else
						engine.showMessage("CDS Generate type " + jobType + " scheduled to be executed \r with a date range of " + dteFrom + " and " + dteTo);
				}
				else
					engine.showMessage("No information could be retrieved at this time");
					
				
			}
			
		} 
		catch (SchedulerException e) 
		{
			engine.showMessage("SchedulerException occurred deleting jobs - " + e.getMessage());
		}
		
	}
	@Override
	protected void onBtnGenInpatClick() throws PresentationLogicException 
	{
		try 
		{
			if(checkDateInterval() == false)
				return;
			Integer noGenerated = domain.generateInpatCDSData(form.dteFrom().getValue(), form.dteTo().getValue());
			engine.showMessage("Generation Complete - " + noGenerated + " records inserted");
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			
		}
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		}		
		
	}
	@Override
	protected void onBtnGenOutpatClick() throws PresentationLogicException
	{
		try 
		{
			if(checkDateInterval() == false)
				return;
			
			Integer noGenerated = domain.generateOutpatCDSData(form.dteFrom().getValue(), form.dteTo().getValue());
			engine.showMessage("Generation Complete - " + noGenerated + " records inserted");
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			
		}
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		}	
		
	}

	private class MaxLine
	{
		private int maxline;
		private int records;

		public void incRecords()
		{
			this.records++;
		}
		
		public int getMaxline()
		{
			return maxline;
		}
		
		public int getRecords()
		{
			return records;
		}

		public void setMaxline(int maxline)
		{
			this.maxline = maxline;
		}

		public MaxLine(int maxline)
		{
			super();
			this.maxline = maxline;
			this.records = 0;
		}
	}

	@Override
	protected void onBtnViewHistoryClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Core.CDSHistory);
	}
	@Override
	protected void onBtnScheduleHRGGrouperClick() throws PresentationLogicException
	{
		if (createScheduledJob(HRG_REPORT_TYPE) == 0)
			engine.showMessage("HRG grouping CDS Report Job has been Scheduled");
	}
	@Override
	protected void onBtnScheduleOutpatientReportClick() throws PresentationLogicException
	{
		if (createScheduledJob(OUTPATIENT_REPORT_TYPE) == 0)
			engine.showMessage("Outpatient CDS Report Job has been Scheduled");
	}
	@Override
	protected void onBtnScheduleInpatientReportClick() throws PresentationLogicException
	{
		if (createScheduledJob(INPATIENT_REPORT_TYPE) == 0)
			engine.showMessage("Inpatient CDS Report Job has been Scheduled");
	}
	
	//WDEV-18912
	@Override
	protected void onBtnScheduleElectiveListReport() throws PresentationLogicException
	{
		if (createScheduledJob(ELECTIVELIST_REPORT_TYPE) == 0)
			engine.showMessage("Elective List CDS Report Job has been Scheduled");
	}
	
	@Override
	protected void onBtnElectiveListClick() throws PresentationLogicException
	{
		buildReport(ELECTIVELIST_REPORT_ID);
	}
	
	@Override
	protected void onBtnGenElectiveListClick() throws PresentationLogicException
	{
		try 
		{
			if(checkDateInterval() == false)
				return;
			Integer noGenerated = domain.generateElectiveListCDSData(form.dteFrom().getValue(), form.dteTo().getValue());
			engine.showMessage("Generation Complete - " + noGenerated + " records inserted");
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());		
		}
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		}	
	}

	@Override
	protected void onBtnCheckElectiveLIstClick() throws PresentationLogicException
	{
		checkForJobs("ELECTIVELIST");	
	}
	
	@Override
	protected void onBtnElectiveListDataClick() throws PresentationLogicException
	{
		if (createScheduledJob("ELECTIVELIST") == 0)
			engine.showMessage("Elective List CDS Data Generation Job has been Scheduled");
	}
}
