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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.65 build 3210.27143)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.domain.impl;

import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.OrderInvAppt;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralVo;
import ims.RefMan.vo.domain.CatsReferralVoAssembler;
import ims.RefMan.vo.lookups.AdditionalInvestigationAppointmentsStatus;
import ims.chooseandbook.vo.lookups.ActionRequestType;
import ims.configuration.gen.ConfigFlag;
import ims.core.documents.domain.objects.PatientDocument;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.DocumentCreationType;
import ims.core.vo.lookups.FileType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.DomainSession;
import ims.domain.Transaction;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.IMSCriteria;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.ocrr.vo.lookups.OrderMessageStatus;
import ims.scheduling.domain.base.impl.BaseDnaBatchUpdateImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.domain.objects.DnaBactchJob;
import ims.scheduling.domain.objects.ExternalSystemEvent;
import ims.scheduling.helper.CABRequests;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentShortVo;
import ims.scheduling.vo.Booking_AppointmentShortVoCollection;
import ims.scheduling.vo.DnaBatchUpdateVo;
import ims.scheduling.vo.domain.Booking_AppointmentShortVoAssembler;
import ims.scheduling.vo.domain.DnaBatchUpdateVoAssembler;
import ims.scheduling.vo.lookups.ExternalSystemEventTypes;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.vo.LookupInstVo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.quartz.old.JobExecutionContext;
import org.quartz.old.Job;
import org.quartz.old.JobExecutionException;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class DnaBatchUpdateImpl extends BaseDnaBatchUpdateImpl implements Job
{

	private static final long serialVersionUID = 1L;
	private static int hours=0;
	private static int count=0;
	private static ims.framework.utils.Date creationDate=null;
	private static String triggeredFrecuency="";
	
	private static final int TIMEOUT = 1000 * 60 * 15;
	private static final int MAX_BUFFER_LIMIT_NO_WARNING = 1024*1024;
	
	private static final Logger	LOG	= Logger.getLogger(DnaBatchUpdateImpl.class);
	
	public void execute(JobExecutionContext job)
	{
			
		DomainFactory factory=getDomainFactory();
		
		try
		{
			factory.setDomainSession(DomainSession.getSession());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Transaction transaction = factory.beginTransaction();
		
		IMSCriteria imsc=new IMSCriteria (Booking_Appointment.class,factory);
		DnaBatchUpdateVo oldBatch = getJob();
		//I will set another batch vo as I can show the information in the grid each time the job is launched.
		DnaBatchUpdateVo batch=null;
		
		if (oldBatch==null)
		{
			batch=new DnaBatchUpdateVo();
			batch.setName("Dna Batch Update");
			batch.setCreationDate(creationDate);
			batch.setTriggerFrecuency(triggeredFrecuency);
		}
		else
			batch=oldBatch;
		
	
		batch.setLastRun(new ims.framework.utils.DateTime(job.getFireTime()));
		batch.setNextRun(new ims.framework.utils.DateTime(job.getNextFireTime()));
		//I calculate the DateTime from when the bookings' status will be changed from book to dna. Current time - the amount of hours the user selected.
		GregorianCalendar g=new GregorianCalendar();
		g.add(Calendar.HOUR, -hours);
		//I create nowtime (current time) and fromtime as i can compare the bookings' datetime.
		DateTime nowTime=new DateTime();
		DateTime fromTime=new DateTime(g.getTime());
		//I retrieve the appointments which Date between the current date and the fromDate and which status is booked
		imsc.between("appointmentDate", g.getTime(), new Date());
		imsc.equal("apptStatus.id", Status_Reason.BOOKED.getID());
		
		List appointments=imsc.find();
		Booking_AppointmentShortVoCollection dnaAppointments= new Booking_AppointmentShortVoCollection();
		for (int i=0;i<appointments.size();i++)
		{
			
			Booking_AppointmentShortVo appt=Booking_AppointmentShortVoAssembler.create((Booking_Appointment) appointments.get(i));
			//I create a datetime with the date and the time of the appointment
			DateTime apptStartTime=new DateTime();
			apptStartTime.setDateTime(appt.getAppointmentDate(), appt.getApptStartTime());
			//If the appointment's datetime is greater than fromTime and is less than current time we update it's status to DNA.
			if ((apptStartTime.compareTo(fromTime)>=0)&&(apptStartTime.compareTo(nowTime)<=0))
			{
				appt.setApptStatus(Status_Reason.DNA);
				dnaAppointments.add(appt);		
			}

		}
		save2(dnaAppointments, factory);
		
		List listCats = null;
		if(dnaAppointments.size() > 0)//wdev-8288
		{
			StringBuilder sb = new StringBuilder();
			sb.append("select c1_1.id, c1_1.patient.id, b1_1.id from CatsReferral as c1_1 join c1_1.appointments as b1_1 where ");
			sb.append(" b1_1.id in (");
			for (int i = 0; i < dnaAppointments.size(); i++)
			{
				if(i > 0)
					sb.append(",");
				
				sb.append(dnaAppointments.get(i).getID_Booking_Appointment().toString());
			}
			sb.append(")");
			sb.append(" order by c1_1.id asc, c1_1.patient asc, b1_1.id asc ");
			
			LOG.info(sb.toString());
			
			listCats = factory.find(sb.toString());

			/*
			try 
			{
				updateCatsReferralsNowWithHasDNAApptsForReview(factory, listCats);
			} 
			catch (StaleObjectException e) 
			{
				e.printStackTrace();
			}
			*/
		}
		
		//batch.setNumAppointmentsUpdated(dnaAppointments.size());
		
		try 
		{
			save2(batch, factory);
		} 
		catch (StaleObjectException e1) 
		{
			e1.printStackTrace();
		}

		try
		{
			transaction.commit();
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			LOG.error(e.toString());
		}
		
		if(dnaAppointments.size() > 0)
		{
			//we group the appointments by CATSReferral
			String queryServerUrl = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
			String reportServerUrl = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
			
			QueryBuilderClient qb = new QueryBuilderClient(queryServerUrl, null);
			
			//we get the report and template
			String query = "select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name";
			Integer id = new Integer(158);
			List rep = factory.find(query, new String[] {"imsid"}, new Object[] {id});	
			String repXml = "";
			String templXml = "";
			
			if(rep == null || rep.size() == 0)
			{
				LOG.error("Could not retrieve report and template for ImsId = " + id);
				throw new RuntimeException("Could not retrieve report and template for ImsId = " + id);
			}
			
			repXml = (String) ((Object[])rep.get(0))[0];
			templXml = (String) ((Object[])rep.get(0))[1];
			
			Object lastCatsReferralId = null;
			Object lastPID = null;
			
			Date now = new Date();
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(now);
			
			for (Object object : listCats)
			{
				/*
				 * obj[0] = CatsReferral_id
				 * obj[1] = Patient_id
				 * obj[2] = Booking_Appointment_id
				 */
				Object[] obj = (Object[]) object;
				
				if(lastCatsReferralId != null && !lastCatsReferralId.equals(obj[0]))
				{
					try
					{
						qb.addSeed(new SeedValue("PID", lastPID , Integer.class));
						byte[] doc = qb.buildReport(repXml, templXml, reportServerUrl, QueryBuilderClient.PDF , batch.getPrintAgentTo(), 1);
	
						//fileName = folderName + "Patient DNA Letters_" + lastCatsReferralId + "_" + lastPID + "_" + df.format(now) + ".pdf";
						savePatientDocument(lastCatsReferralId, doc);
					}
					catch (QueryBuilderClientException e)
					{
						e.printStackTrace();
						LOG.error(e.toString());
					}
					
					qb.getSeeds().clear();
				}
				
				qb.addSeed(new SeedValue("APPT_ID", obj[2] , Integer.class));
				
				lastPID = obj[1];
				lastCatsReferralId = obj[0];
			}
			
			if(qb.getSeeds().size() > 0)
			{
				try
				{
					qb.addSeed(new SeedValue("PID", lastPID , Integer.class));
					byte[] doc = qb.buildReport(repXml, templXml, reportServerUrl, QueryBuilderClient.PDF , batch.getPrintAgentTo(), 1);
					//byte[] doc = qb.buildReport(repXml, templXml, reportServerUrl, QueryBuilderClient.PDF , "", 1);
					
					//fileName = folderName + "Patient DNA Letters_" + lastCatsReferralId + "_" + lastPID + "_" + df.format(now) + ".pdf";
					//writeToFile(fileName, doc);
					savePatientDocument(lastCatsReferralId, doc);
				}
				catch (QueryBuilderClientException e)
				{
					e.printStackTrace();
					LOG.error(e.toString());
				}
				
				qb.getSeeds().clear();
			}
		}

		count++;
	}

	/*WDEV-22375
	//wdev-8288
	private void updateCatsReferralsNowWithHasDNAApptsForReview(DomainFactory factory, List listCats) throws StaleObjectException 
	{
		for (Object object : listCats)
		{
			Object[] obj = (Object[]) object;
			Object CatsReferralId = obj[0];

			if(CatsReferralId != null)
			{
				ims.RefMan.vo.CatsReferralRefVo catsReferralRefVo = new CatsReferralRefVo();
				catsReferralRefVo.setID_CatsReferral((Integer)CatsReferralId);
				
				CatsReferralVo catsReferral = getCatsReferral(catsReferralRefVo);

				CatsReferral doCatsReferral = CatsReferralVoAssembler.extractCatsReferral(factory, catsReferral);
				
				doCatsReferral.setHasDNAApptsForReview(Boolean.TRUE);
			
				factory.save(doCatsReferral);
			}
		}
	}
	 */
	private void savePatientDocument(Object lastCatsReferralId, byte[] doc)
	{
		String urlPdfUploadServer = ConfigFlag.GEN.PDF_UPLOAD_URL.getValue();
		if ("".equals(urlPdfUploadServer))
		{
			LOG.error("PDF_UPLOAD_URL flag need to be set");
			return;
		}
		
		String fileName = generateName() + ".pdf";

		//Date date = new Date();
		//int year = date.getYear();
		//int month = date.getMonth();
		//int day = date.getDay();			
		
		if (doc == null || doc.length == 0) 
		{
			LOG.error("PDF size is zero");
			return;
		}							
		
		try 
		{
			uploadFile(doc, fileName, ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue());
		}
		catch (Exception e)
		{
			LOG.error(e.toString());
			return; 
		} 	

		ims.RefMan.vo.CatsReferralRefVo catsReferralRefVo = new CatsReferralRefVo();
		catsReferralRefVo.setID_CatsReferral((Integer)lastCatsReferralId);
		
		CatsReferralVo catsReferral = getCatsReferral(catsReferralRefVo);
		
		PatientDocumentVo vo = populatePatientDocumentVo(populateServerDocumentVo(fileName), catsReferral);	
		
		String[] str = vo.validate();
		if (str != null && str.length > 0)
		{
			LOG.error(str.toString());
			return;
		}
						
		try 
		{
			savePatientDocument(vo, catsReferral);			
		} 
		catch (StaleObjectException e) 
		{			
			LOG.error(e.toString());
			return;
		}
		
	}

	@SuppressWarnings("deprecation")
	private ServerDocumentVo populateServerDocumentVo(String fileName) 
	{
		Date date = new Date();
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();			

		ServerDocumentVo vo = new ServerDocumentVo();
		String filePath = year + "/" + month + "/" + day + "/" + fileName;			
		vo.setFileName(filePath);
		vo.setFileType(FileType.PDF);		
		return vo;		
	}	
	
	public void setHours(Integer numHours)
	{
		if (count==0)
			//I set the creation date the first time it is launched.
			creationDate=new ims.framework.utils.Date();
		hours=numHours;
	}

	public void save2(Booking_AppointmentShortVoCollection dnaAppointments, DomainFactory factory)
	{	
		//TODO call impl
		//PatientAppointmentManagement  impl = (PatientAppointmentManagement) getDomainImpl(PatientAppointmentMangementRefManImpl.class);
		for (Booking_AppointmentShortVo booking: dnaAppointments)
		{
			try
			{
				booking.validate();
				saveBookingAppt(factory, booking);
			}
			catch (StaleObjectException e)
			{
				e.printStackTrace();
				LOG.error(e.toString());
			}
		}	
	}
	
	private void saveBookingAppt(DomainFactory factory, Booking_AppointmentShortVo appt) throws StaleObjectException
	{
		if(appt == null)
			throw new CodingRuntimeException("appt parameter is null in method saveBookingAppt");
		
		if(!appt.isValidated())
			throw new CodingRuntimeException("appt parameter has not been validated");
	
		Booking_Appointment doBookAppt = Booking_AppointmentShortVoAssembler.extractBooking_Appointment(factory, appt);
		
		//increment slots remaining if its a cancel
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
			doBookAppt.getSession().incrementRemainingSlots(1);
		
		List ordinvList = null;
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)) || doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.ARRIVAL)))
			ordinvList = factory.find("from OrderInvAppt ordInvAppt where ordInvAppt.appointment.id = " + doBookAppt.getId());
		
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
		{
			//WDEV-5711 - generateOrderPatientDNAEvent or generateOrderCancelEvent
			if(ordinvList != null && ordinvList.size() >= 0)
			{
				Iterator it = ordinvList.iterator();
				boolean catsReferralUpdated = false;
				while(it.hasNext())
				{
					OrderInvAppt doOrderInvAppt = (OrderInvAppt) it.next();
					if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
					{
						generateOrderPatientDNAEvent(new Booking_AppointmentRefVo(doOrderInvAppt.getAppointment().getId(), doOrderInvAppt.getAppointment().getVersion()), new OrderInvestigationRefVo(doOrderInvAppt.getOrderInvestigation().getId(), doOrderInvAppt.getOrderInvestigation().getVersion()));
						//WDEV-5727 
						if(!catsReferralUpdated)
						{
							saveCatsReferralwithAddtionalInvApptStatus(factory, doOrderInvAppt, AdditionalInvestigationAppointmentsStatus.DNA);
							catsReferralUpdated = true;
						}
						
						//WDEV-5740
						OrderedInvestigationStatus voOrdInvStatus = new OrderedInvestigationStatus();
						voOrdInvStatus.setChangeDateTime(new ims.framework.utils.Date().getDate());
						voOrdInvStatus.setProcessedDateTime(new java.util.Date());
						voOrdInvStatus.setOrdInvStatus(getDomLookup(OrderInvStatus.HOLD_REQUESTED));
						voOrdInvStatus.setStatusReason("Patient DNA'd associated Appt");
						doOrderInvAppt.getOrderInvestigation().setOrdInvCurrentStatus(voOrdInvStatus);
						doOrderInvAppt.getOrderInvestigation().getOrdInvStatusHistory().add(voOrdInvStatus);
						factory.save(doOrderInvAppt);
					}	
				}
			}
			if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
			{
				if(ConfigFlag.GEN.ICAB_ENABLED.getValue())
				{
					if(doBookAppt.isIsCABBooking() != null && doBookAppt.isIsCABBooking().booleanValue())
						CABRequests.sendRequestandUpdateReferences(factory, getDomLookup(ActionRequestType.NOTIFY_DNA), doBookAppt, "Appt DNA Requested from DNA Batch Update Job");
				}
			}
		}
		
		//WDEV-10864 - when dna'ing set the requiresrebook flag to true if its
		if(doBookAppt != null && doBookAppt.getApptStatus() != null)
		{
			if((doBookAppt.isIsCABBooking() == null || !doBookAppt.isIsCABBooking()) && doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
			{
				doBookAppt.setRequiresRebook(true);
				//break link between slot and appt
				if (doBookAppt.getSessionSlot() != null)
				{
					doBookAppt.getSessionSlot().setStatus(getDomLookup(Status_Reason.DNA));
					doBookAppt.getSessionSlot().setAppointment(null);
					doBookAppt.setSessionSlot(null);
				}	
			}
		}
		
		factory.save(doBookAppt);		
	}
	
	private void saveCatsReferralwithAddtionalInvApptStatus(DomainFactory factory, OrderInvAppt doOrderInvAppt, AdditionalInvestigationAppointmentsStatus status) throws StaleObjectException
	{
		if(factory == null || doOrderInvAppt == null || status == null)
			throw new CodingRuntimeException("all mandatory params not populated for method saveCatsReferralwithAddtionalInvApptStatus");
		
		List lstCatsRef = factory.find("from CatsReferral catsRef join fetch catsRef.orderInvAppts ordInvAppt where ordInvAppt.id = '" + doOrderInvAppt.getId() + "'");
		if(lstCatsRef != null && lstCatsRef.size() == 1)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			doCatsRef.setAdditionalInvApptsStatus(getDomLookup(status));
			factory.save(doCatsRef);
		}
	}
	
	public void generateOrderPatientDNAEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws StaleObjectException
	{
		createExternalEvent(appointment, investigation, ExternalSystemEventTypes.PATIENTDNA);
	}
	
	private void createExternalEvent(Booking_AppointmentRefVo appointment, OrderInvestigationRefVo investigation, LookupInstVo type) throws StaleObjectException
	{
		if (null == appointment)
			throw new DomainRuntimeException("Appointment Cannot be NULL");

		DomainFactory factory = getDomainFactory();
		ExternalSystemEvent event = new ExternalSystemEvent();
		
		// We need to deal with null investigations
		// when (not )sending the messages
		if (null != investigation) 
		{
			OrderInvestigation domInv = (OrderInvestigation) factory.getDomainObject(investigation);
			
			//WDEV-5912 For Investigations marked as NoInterface there are no interface calls
			if(domInv.getInvestigation() != null && domInv.getInvestigation().getInvestigationIndex() != null &&  domInv.getInvestigation().getInvestigationIndex().isNoInterface() != null && domInv.getInvestigation().getInvestigationIndex().isNoInterface())
				return;
			
			event.setInvestigation(domInv);
			event.setProviderSystem(domInv.getInvestigation().getProviderService().getProviderSystem());
		}

		Booking_Appointment domBookAppt = (Booking_Appointment) factory.getDomainObject(appointment);
		event.setAppointment(domBookAppt);
		event.setWasProcessed(Boolean.FALSE);
		event.setMessageStatus(getDomLookup(OrderMessageStatus.CREATED));
		event.setEventType(getDomLookup(type));
		factory.save(event);
	}

	public void setTriggerFrecuency(String triggerFrecuency)
	{
		triggeredFrecuency=triggerFrecuency;
	}
	
	public void save(DnaBatchUpdateVo batch) throws StaleObjectException
	{
		DomainFactory factory= getDomainFactory();
		factory.save(DnaBatchUpdateVoAssembler.extractDnaBactchJob(factory, batch));
	}

	public void save2(DnaBatchUpdateVo batch, DomainFactory factory) throws StaleObjectException
	{
		factory.save(DnaBatchUpdateVoAssembler.extractDnaBactchJob(factory, batch));
	}
	
	public DnaBatchUpdateVo getJob()
	{
		DomainFactory factory=getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(DnaBactchJob.class,factory);
		List jobs=imsc.find();
		if (jobs.size()>0)
			return DnaBatchUpdateVoAssembler.create((DnaBactchJob) jobs.get(0));
		return null;
		
	}
	
	private String getOutputFolder() throws JobExecutionException
	{
		String folderName = null;
		
		if(ConfigFlag.GEN.BATCH_JOB_EXPORT_FOLDER.getValue() == null || ConfigFlag.GEN.BATCH_JOB_EXPORT_FOLDER.getValue().length() == 0)
		{
			if ( System.getProperty("catalina.home") == null)
			{
				LOG.error("The JVM parameter 'catalina.home' was not found !");
				throw new JobExecutionException("The JVM parameter 'catalina.home' was not found !");				
			}
			
			folderName = System.getProperty("catalina.home") + "/TransactionExport/";				
		}
		else
		{
			folderName = ConfigFlag.GEN.BATCH_JOB_EXPORT_FOLDER.getValue();
			
			if(!(folderName.endsWith("\\") || folderName.endsWith("/")))
			{
				folderName += System.getProperty("file.separator");
			}
		}

		File folder = new File(folderName);
		
		if(folder.exists() == false)
		{
			boolean bSuccess = folder.mkdir();
			
			if(bSuccess == false)
			{
				LOG.error("The JVM parameter 'catalina.home' was not found !");
				throw new JobExecutionException("I could not create the folder '" + folder.getAbsolutePath() + "' !");
			}
		}
		
		return folderName;
	}
	
	private void writeToFile(String fileName, byte[] buffer) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(fileName, false);
		fos.write(buffer);
		fos.flush();
		fos.close();
	}
	
	private String generateName()
	{
		String str = "";

		try
		{
			//Get Random Segment
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(prng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get CurrentTimeMillis() segment
			str += Long.toHexString(System.currentTimeMillis());
			while (str.length() < 12)
			{
				str = '0' + str;
			}

			//Get Random Segment
			SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(secondPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get IdentityHash() segment
			str += Long.toHexString(System.identityHashCode((Object) this));
			while (str.length() < 8)
			{
				str = '0' + str;
			}
			//Get Third Random Segment
			byte bytes[] = new byte[16];
			SecureRandom thirdPrng = SecureRandom.getInstance("SHA1PRNG");
			thirdPrng.nextBytes(bytes);
			str += Integer.toHexString(thirdPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}
		}
		catch (java.security.NoSuchAlgorithmException ex)
		{
			ex.getMessage();
		}

		return str;
	}
	
	public String uploadFile(byte[] file, String fileName, String localFolder)
	{
		if(ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() == null || ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue().length() == 0)
		{
			LOG.error("ConfigFlag GEN.FILE_UPLOAD_DIR is null");

			return null;
		}
		
		HttpClient conn = null;	  				
		StringBuffer sb = new StringBuffer(500);
	
		PostMethod filePost = new PostMethod(ConfigFlag.GEN.PDF_UPLOAD_URL.getValue());
		conn = new HttpClient(new MultiThreadedHttpConnectionManager());
		conn.getHttpConnectionManager().getParams().setConnectionTimeout(TIMEOUT);		
		conn.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE, true);
		conn.getParams().setIntParameter(HttpMethodParams.BUFFER_WARN_TRIGGER_LIMIT, MAX_BUFFER_LIMIT_NO_WARNING);
		  	  	  
		Part[] data = 
		{
		    new StringPart("name", localFolder), 
		    new StringPart("filename", fileName),	           
		    new FilePart(fileName, new ByteArrayPartSource(fileName, file))	           
		};
		  		
		filePost.setRequestEntity(new MultipartRequestEntity(data, filePost.getParams()));
	  		
	    int iGetResultCode;
		try
		{
			iGetResultCode = conn.executeMethod(filePost);
			if (iGetResultCode == HttpStatus.SC_OK) 
			{
				sb.append("Upload complete, status=" + iGetResultCode);
				sb.append("\nUpload complete, response=" + HttpStatus.getStatusText(iGetResultCode));
				sb.append("\nUpload complete, response=" + filePost.getResponseBodyAsString());
				
				LOG.info(sb.toString());
				
				if (filePost.getResponseBodyAsString() != null &&
						filePost.getResponseBodyAsString().length() != 0 &&
							filePost.getResponseBodyAsString() != "")  	     		   
				    			return parse(filePost.getResponseBodyAsString());
				
			}
			else 
			{
				sb.append("Upload failed, response=" + HttpStatus.getStatusText(iGetResultCode));
				sb.append("Upload failed, response=" + filePost.getResponseBodyAsString());
				LOG.error("Upload failed, response=" + HttpStatus.getStatusText(iGetResultCode));
			}
		} 
		catch (HttpException e)
		{			 			 
			LOG.error(e.toString());
		} 
		catch (IOException e)
		{			
			LOG.error(e.toString());
		}
		finally
		{
			filePost.releaseConnection();
		}
	  	
	  	return null;		
	}	
	
	private String parse(String xml)
	{
		if (xml == null)
			return null;
		
		return (xml.split("\""))[1];	
	}
	
	public ims.RefMan.vo.CatsReferralVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef)
	{
		return CatsReferralVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsRef.getID_CatsReferral()));
	}	
	
	@SuppressWarnings("unchecked")
	public void savePatientDocument(ims.core.vo.PatientDocumentVo document, ims.RefMan.vo.CatsReferralVo catReferral) throws ims.domain.exceptions.StaleObjectException
	{
		if (document != null)
		{
			if (!document.isValidated())
				throw new DomainRuntimeException("PatientDocumentVo not validated");
		}
		
		DomainFactory factory = getDomainFactory();
		PatientDocument doc = PatientDocumentVoAssembler.extractPatientDocument(factory, document);
		factory.save(doc);				

		CatsReferral doCatsReferral = CatsReferralVoAssembler.extractCatsReferral(factory, catReferral);
			doCatsReferral.getReferralDocuments().add(doc);	
			
		doCatsReferral.setHasDocuments(Boolean.TRUE);
		
		//wdev-8288
		//WDEV-22375 doCatsReferral.setHasDNAApptsForReview(Boolean.TRUE);
		
		factory.save(doCatsReferral);
	}
	
	private PatientDocumentVo populatePatientDocumentVo(ServerDocumentVo serverDocumentVo, CatsReferralVo catReferral)
	{
		PatientDocumentVo vo = new PatientDocumentVo();
		vo.setPatient(catReferral.getPatient());
		vo.setEpisodeofCare(null);
		vo.setCareContext(null);
		vo.setClinicalContact(null);
		vo.setReferral(null);
				
		vo.setName("Letter to patient DNA");
		vo.setServerDocument(serverDocumentVo);
		vo.setCreationType(DocumentCreationType.GENERATED);
		vo.setCategory(DocumentCategory.LETTER_TO_PATIENT_DNA);
		
		vo.setRecordingUser(null);
		vo.setRecordingDateTime(new DateTime());
		vo.setStatus(PreActiveActiveInactiveStatus.ACTIVE);
		return vo;
	}

	public void removeTask() throws ForeignKeyViolationException 
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(DnaBactchJob.class,factory);
		List jobs=imsc.find();
		if (jobs.size()>0)
			factory.delete((DnaBactchJob) jobs.get(0));
	}	
}
