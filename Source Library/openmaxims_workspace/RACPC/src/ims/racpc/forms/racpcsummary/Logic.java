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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.racpc.forms.racpcsummary;

import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.AppSiteVo;
import ims.core.vo.CommChannelVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.lookups.ApplicationSiteName;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.DocumentCreationType;
import ims.core.vo.lookups.FileType;
import ims.core.vo.lookups.PatIdType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.racpc.vo.PatientDocumentForRACPCSummaryVo;
import ims.racpc.vo.RACPCSummaryVo;

import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int RACPCSUMMARY_REPORT_IMSID = 299; 
	private static final String SUMMARY_DOCUMENT_NAME = "RACPC Summary report";
	private static final String CARE_CONTEXT_SEED = "CareContext_id";
	private static final String EMAIL_SUBJECT = "  Patient Data - ";//WDEV-13753,wdev-16298
	
	private static String SMTP_HOST_NAME;
	private static int 	  SMTP_PORT;
	private static String SMTP_AUTH;
	private static String emailFromAddress;

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	private void updateControlsState() 
	{
		boolean enableFields = FormMode.EDIT.equals(form.getMode()) && (((form.getLocalContext().getRACPCSummary() == null || (form.getLocalContext().getRACPCSummary().getIsClinicalDetailsCompleteIsNotNull() && !form.getLocalContext().getRACPCSummary().getIsClinicalDetailsComplete()))) || engine.hasRight(ims.configuration.AppRight.CAN_UNDO_RACPC_CLINICAL_DETAILS_COMPLETE));
		
		form.chkClinicalDetails().setEnabled(enableFields);
		
		if(FormMode.VIEW.equals(form.getMode()))
		{
			form.btnEdit().setVisible(true);
			form.btnEdit().setEnabled(engine.hasRight(ims.configuration.AppRight.CAN_UNDO_RACPC_CLINICAL_DETAILS_COMPLETE) || !form.chkClinicalDetails().getValue());
		}
	}
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	private void open()
	{
		form.getLocalContext().setRACPCSummary(domain.getRACPCSummary(form.getGlobalContext().Core.getCurrentCareContext()));
		
		populateScreenFromData(form.getLocalContext().getRACPCSummary());
		
		if(form.getLocalContext().getRACPCSummaryIsNotNull() && form.getLocalContext().getRACPCSummary().getSummaryDocumentIsNotNull())
			displayDocument(form.getLocalContext().getRACPCSummary().getSummaryDocument());
		else
			buildRACPCSummaryReport(true);
		
		form.setMode(FormMode.VIEW);
	}
	
	private void displayDocument(PatientDocumentForRACPCSummaryVo patientDocument) 
	{
		if(patientDocument == null || patientDocument.getServerDocument() == null)
			return;
		
		String fullPath = getMaximsDocumentStorePath();
		String fileName = patientDocument.getServerDocument().getFileName();
		
		fullPath += fileName;
		
		form.getLocalContext().setHTMLValue("<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + fullPath +  "'></IFRAME>");
		form.htmReport().setHTML(form.getLocalContext().getHTMLValue());
	}
	
	private String getMaximsDocumentStorePath()
	{
		String storePath = ConfigFlag.GEN.FILE_SERVER_URL.getValue();//WDEV-13366
		
		if(!(storePath.endsWith("/") || storePath.endsWith("\\")))
			storePath = storePath + "/";
				
		return storePath;
	}

	private void populateScreenFromData(RACPCSummaryVo racpcSummary) 
	{
		clear();
		
		if(racpcSummary == null)
			return;
		
		form.chkClinicalDetails().setValue(racpcSummary.getIsClinicalDetailsComplete());
		form.dteDateOfCompletion().setValue(racpcSummary.getDateClinicalDetailsComplete());
	}
	
	private boolean validateReportConfigFlags() 
	{
		String queryServerUrl = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String reportServerUrl = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		ArrayList<String> errors = new ArrayList<String>();
		
		if(queryServerUrl == null || queryServerUrl.length() == 0 || queryServerUrl.equals(ConfigFlag.GEN.QUERY_SERVER_URL.getDefaultValue()))
		{
			errors.add("The config flag QUERY_SERVER_URL is not set!");
		}
		
		if(reportServerUrl == null || reportServerUrl.length() == 0 || reportServerUrl.equals(ConfigFlag.GEN.REPORT_SERVER_URL.getDefaultValue()))
		{
			errors.add("The config flag REPORT_SERVER_URL is not set !");
		}
		
		if(errors.size() == 0)
			return true;
		
		engine.showMessage(getErrors(errors.toArray(new String[errors.size()])), "Errors", MessageButtons.OK, MessageIcon.ERROR);
		
		return false;
	}

	private byte[] buildRACPCSummaryReport(boolean onlyForView) 
	{
		if(!validateReportConfigFlags())
			return null;
		
		String queryServerUrl = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String reportServerUrl = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		Object[] obj = domain.getSystemReportAndTemplate(RACPCSUMMARY_REPORT_IMSID);
		
		QueryBuilderClient client = new QueryBuilderClient(queryServerUrl, engine.getSessionId()); 
		
		client.addSeed(new SeedValue(CARE_CONTEXT_SEED, form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext(), Integer.class));	
		
		if(obj == null || obj.length < 2)
		{
			engine.showMessage("I could not get the report and template !");
			return null;
		}

		if(obj[0] == null || obj[1] == null)
		{
			engine.showMessage("The report has not been deployed !");
			return null;
		}
		
		String result = "";
		byte[] report = null;
		
		try
		{	
			if(onlyForView)
			{
				result = client.buildReportAsUrlInlineFrame((String)obj[0], (String)obj[1], reportServerUrl, QueryBuilderClient.PDF, "", 1);
			}
			else
			{
				report = client.buildReport((String)obj[0], (String)obj[1], reportServerUrl, QueryBuilderClient.PDF, "", 1);
			}
		}
		catch (QueryBuilderClientException ex)
		{
			engine.showMessage("Error creating report: " + ex.getMessage());
			return null;
		}	
		
		if(onlyForView)
			form.htmReport().setHTML(result);
		
		return report;
	}

	private void clear() 
	{
		form.htmReport().setHTML("");
		form.getLocalContext().setHTMLValue(null);
		form.dteDateOfCompletion().setValue(null);
		form.chkClinicalDetails().setValue(null);
	}

	private void initialize() 
	{
		form.lblGP().setValue(null);
		form.getLocalContext().setRecipient(domain.getPatientGp(form.getGlobalContext().Core.getPatientShort()));

		if(form.getLocalContext().getRecipientIsNotNull() && form.getLocalContext().getRecipient().getEmail() != null)
		{
			form.lblGP().setValue(form.getLocalContext().getRecipient().getName().toString());
		}
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//check for stale
		if((form.getLocalContext().getRACPCSummary() == null || form.getLocalContext().getRACPCSummary().getID_RACPCSummary() == null) && domain.getRACPCSummary(form.getGlobalContext().Core.getCurrentCareContext()) != null)
		{
			form.htmReport().setHTML("");//WDEV-13664 
			form.getLocalContext().setStaleMessageID(engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue(), "Errors", MessageButtons.OK, MessageIcon.ERROR));//WDEV-13664 
			return;
		}
		
		if(save(false))
			open();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.getLocalContext().getRACPCSummary() != null 
			&& form.getLocalContext().getRACPCSummary().getIsClinicalDetailsComplete() 
			&& form.getLocalContext().getRACPCSummary().getSummaryDocument() == null 
			&& form.getLocalContext().getRecipientIsNotNull() 
			&& form.getLocalContext().getRecipient().getEmail() != null)
		{
			emailToGP();
		}
		else
		{
			print();
		}
	}
	
	private void emailToGP() 
	{
		if(save(true))
		{
			open();
			
			//String emailSubjectTxt = EMAIL_SUBJECT + form.getGlobalContext().Core.getPatientShort().getName().getSurname();//WDEV-13753
			String emailSubjectTxt = null;
			//wdev-16298
			try 
			{ 
				AppSiteVo site = domain.getSite();
				if(site.getSite().equals(ApplicationSiteName.RCHT))
				{
					emailSubjectTxt = EMAIL_SUBJECT + getnhsNumber(form.getGlobalContext().Core.getPatientShort().getIdentifiers()) + " - Hospital Correspondence";
				}
				else
				{
					emailSubjectTxt = EMAIL_SUBJECT + form.getGlobalContext().Core.getPatientShort().getName().getSurname();//WDEV-13753
				}
			
			} 
			catch (DomainInterfaceException e) 
			{ 
				engine.showMessage(e.getMessage()); 
				return;
			} 
			//-----------
			
			
			String emailMsgTxt = SUMMARY_DOCUMENT_NAME;
			String attachFile = null;
			String gpMail = null;
			
			if(form.getLocalContext().getRecipient() == null)
				return;
			
			CommChannelVo channel = form.getLocalContext().getRecipient().getEmail();
			gpMail = channel.getCommValue();
			
			if (gpMail == null || gpMail.length() == 0)
			{
				form.htmReport().setHTML("");
				engine.showMessage("Patient's Gp, " + (form.getLocalContext().getRecipient().getName() != null ? form.getLocalContext().getRecipient().getName().toString() : "") + ", doesn't have an email address.", "Errors", MessageButtons.OK, MessageIcon.ERROR);
				return;
			}

			if (form.getLocalContext().getRACPCSummaryIsNotNull() && form.getLocalContext().getRACPCSummary().getSummaryDocumentIsNotNull())
			{
				ServerDocumentVo document = form.getLocalContext().getRACPCSummary().getSummaryDocument().getServerDocument();
				if (document != null)
				{
					attachFile = (getPDFStorePath() + document.getFileName()).replace("/", "\\");
				}
			}

			try
			{
				new SendMail().sendSSLMessage(gpMail, emailSubjectTxt, emailMsgTxt, attachFile);
			}
			catch (MessagingException e)
			{
				form.htmReport().setHTML("");
				engine.showMessage("Mail could not be sent.", "Errors", MessageButtons.OK, MessageIcon.ERROR);
				e.printStackTrace();
				return;
			}
			
			form.htmReport().setHTML("");
			engine.showMessage("Mail sent successfull to " + (form.getLocalContext().getRecipient().getName() != null ? form.getLocalContext().getRecipient().getName().toString() : ""), "", MessageButtons.OK, MessageIcon.INFORMATION);	
		}
	}
	//wdev-16298
	private String getnhsNumber(PatientIdCollection patidcoll)
	{
		if( patidcoll == null || patidcoll.size() == 0)
			return "";
		for(int i = 0; i < patidcoll.size();i++)
		{
			if( PatIdType.NHSN.equals(patidcoll.get(i).getType()))
			{
				
				//nhsn format xxx xxx xxxx
				java.lang.StringBuffer nhsn = new java.lang.StringBuffer("");
				String str = patidcoll.get(i).getIdValue().replace(" ", "");
				if ( str.length() > 6)
				{
					nhsn.append(str.substring(0, 3));
					nhsn.append(" ");
					nhsn.append(str.substring(3, 6));
					nhsn.append(" ");
					nhsn.append(str.substring(6));
						
					return nhsn.toString();
				}			
				else
					return patidcoll.get(i).getIdValue();

				//return patidcoll.get(i).getIdValue();
			}
		}
		for(int i = 0; i < patidcoll.size();i++)
		{
			if( PatIdType.HOSPNUM.equals(patidcoll.get(i).getType()))
				return PatIdType.HOSPNUM.getIItemText()+" : " +patidcoll.get(i).getIdValue();
		}
		return "";
	}
	//-----------
	private String getPDFStorePath()
	{
		String storePath = ConfigFlag.GEN.PDF_STORE_PATH.getValue();

		if (!(storePath.endsWith("/") || storePath.endsWith("\\")))
			storePath = storePath + "/";

		return storePath;
	}

	private String createAndUploadDocument() 
	{
		byte[] report = buildRACPCSummaryReport(false);
		
		if(report != null)
		{
			String pdfFileName = generateName() + ".pdf";
			
			try 
			{								
				engine.uploadFile(ConfigFlag.GEN.PDF_UPLOAD_URL.getValue(), report, pdfFileName, ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "\\");
			}
			catch (Exception e)
			{
				engine.showMessage(e.getMessage());
				return null;
			}
			
			int year  = new DateTime().getDate().getYear();
			int month = new DateTime().getDate().getMonth();
			int day   = new DateTime().getDate().getDay();
			
			if(pdfFileName != null && pdfFileName.length() > 0)
				return year + "\\" + month + "\\" + day + "\\" + pdfFileName;
		}
		
		return null;
	}
	
	private String generateName()
	{
		String str = "";

		try
		{
			// Get Random Segment
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(prng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			// Get CurrentTimeMillis() segment
			str += Long.toHexString(System.currentTimeMillis());
			while (str.length() < 12)
			{
				str = '0' + str;
			}

			// Get Random Segment
			SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(secondPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			// Get IdentityHash() segment
			str += Long.toHexString(System.identityHashCode((Object) this));
			while (str.length() < 8)
			{
				str = '0' + str;
			}
			// Get Third Random Segment
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

	private boolean save(boolean createSummaryDocument) 
	{
		form.getLocalContext().setRACPCSummary(populateDataFromScreen(form.getLocalContext().getRACPCSummary(), createSummaryDocument));
		
		String[] uiErrors =  form.getLocalContext().getRACPCSummary().validate(validateUIRules());
		
		if(uiErrors != null && uiErrors.length > 0)
		{
			form.htmReport().setHTML("");
			engine.showMessage(getErrors(uiErrors), "Errors", MessageButtons.OK, MessageIcon.ERROR);
			return false;
		}
		
		try 
		{
			form.getLocalContext().setRACPCSummary(domain.saveRACPCSummary(form.getLocalContext().getRACPCSummary()));
		} 
		catch (DomainInterfaceException e) 
		{
			e.printStackTrace();
			form.htmReport().setHTML("");//WDEV-13664 
			engine.showMessage(e.getMessage(), "Errors", MessageButtons.OK, MessageIcon.ERROR);//WDEV-13664 
			return false;
		} 
		catch (StaleObjectException e) 
		{
			e.printStackTrace();
			form.htmReport().setHTML("");//WDEV-13664 
			form.getLocalContext().setStaleMessageID(engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue(), "Errors", MessageButtons.OK, MessageIcon.ERROR));//WDEV-13664 
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			e.printStackTrace();
			form.htmReport().setHTML("");//WDEV-13664 
			engine.showMessage(e.getMessage(), "Errors", MessageButtons.OK, MessageIcon.ERROR);//WDEV-13664 
			return false;
		}
		
		return true;
	}

	private String getErrors(String[] uiErrors) 
	{
		if(uiErrors == null || uiErrors.length == 0)
			return "";
		
		String errors = "";
		
		for(int i=0; i<uiErrors.length; i++)
		{
			if(uiErrors[i] == null)
				continue;
			
			errors += uiErrors[i] + "\n";
		}
		
		return errors;
	}

	private String[] validateUIRules() 
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if(form.chkClinicalDetails().getValue() && form.dteDateOfCompletion().getValue() == null)
		{
			uiErrors.add("Date of Completion is mandatory.");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private RACPCSummaryVo populateDataFromScreen(RACPCSummaryVo racpcSummaryVo, boolean createSummaryDocument) 
	{
		if(racpcSummaryVo == null)
			racpcSummaryVo = new RACPCSummaryVo();
		
		if(racpcSummaryVo.getPatient() == null)
			racpcSummaryVo.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		if(racpcSummaryVo.getCareContext() == null)
			racpcSummaryVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		racpcSummaryVo.setDateClinicalDetailsComplete(form.dteDateOfCompletion().getValue());
		racpcSummaryVo.setIsClinicalDetailsComplete(form.chkClinicalDetails().getValue());
		
		if(!form.chkClinicalDetails().getValue())
			racpcSummaryVo.setSummaryDocument(null);
		
		if(createSummaryDocument)
		{
			racpcSummaryVo.setSummaryDocument(populatePatientDocument());
		}
		
		return racpcSummaryVo;
	}

	private PatientDocumentForRACPCSummaryVo populatePatientDocument() 
	{
		String fileName = createAndUploadDocument();
		
		if(fileName != null)
		{
			PatientDocumentForRACPCSummaryVo summaryDocument = new PatientDocumentForRACPCSummaryVo();
			
			summaryDocument.setName(SUMMARY_DOCUMENT_NAME);
			summaryDocument.setPatient(form.getGlobalContext().Core.getPatientShort());
			summaryDocument.setEpisodeofCare(form.getGlobalContext().Core.getEpisodeofCareShort());
			summaryDocument.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			summaryDocument.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			summaryDocument.setCreationType(DocumentCreationType.GENERATED);
			summaryDocument.setStatus(PreActiveActiveInactiveStatus.ACTIVE);
			summaryDocument.setCategory(DocumentCategory.RACPCSUMMARY);//	WDEV-13632
			
			Object mos = domain.getMosUser();
			if(mos instanceof MemberOfStaffRefVo)
			{
				summaryDocument.setRecordingUser((MemberOfStaffRefVo) mos);
			}
			
			summaryDocument.setRecordingDateTime(new DateTime());
			
			Object hcp = domain.getHcpLiteUser();
			if(hcp instanceof HcpLiteVo)
			{
				summaryDocument.setAuthoringHCP((HcpRefVo) hcp);
			}
			else
			{
				if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
				{
					summaryDocument.setAuthoringHCP(form.getGlobalContext().Core.getCurrentCareContext().getResponsibleHCP() instanceof HcpRefVo ? (HcpRefVo) form.getGlobalContext().Core.getCurrentCareContext().getResponsibleHCP() : null);
				}
			}
			
			summaryDocument.setAuthoringDateTime(new DateTime());
			
			if(form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull())
			{
				summaryDocument.setSpecialty(form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty());
			}
			
			if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			{
				summaryDocument.setDocumentDate(form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime() != null ? form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime().getDate() : null);
				summaryDocument.setResponsibleHCP(form.getGlobalContext().Core.getCurrentCareContext().getResponsibleHCP() instanceof HcpRefVo ? (HcpRefVo) form.getGlobalContext().Core.getCurrentCareContext().getResponsibleHCP() : null);
			}
			
			ServerDocumentVo doc = new ServerDocumentVo();
			doc.setFileName(fileName);
			doc.setFileType(FileType.PDF);
			
			summaryDocument.setServerDocument(doc);
			
			return summaryDocument;
		}
		
		return null;
	}

	private void print() 
	{
		if(form.getLocalContext().getRACPCSummaryIsNotNull())
		{
			if(form.getLocalContext().getRACPCSummary().getIsClinicalDetailsComplete() && form.getLocalContext().getRACPCSummary().getSummaryDocument() == null)
			{
				if(!save(true))
					return;
				
				open();
			}
		}
		
		form.getGlobalContext().RACPC.setRACPCSummary(form.getLocalContext().getRACPCSummary());
		
		if(form.getGlobalContext().RACPC.getRACPCSummary() == null)
			form.getGlobalContext().RACPC.setRACPCSummary(new RACPCSummaryVo());
		
		form.htmReport().setHTML("");
		engine.open(form.getForms().RACPC.RACPCPrintSummaryDialog);
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	
	private void updateInstance() 
	{
		form.setMode(FormMode.EDIT);
	}
	
	// send mail class
	private class SendMail
	{
		private SendMail()
		{
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

			SMTP_HOST_NAME = ConfigFlag.FW.SMTP_SERVER.getValue();
			SMTP_PORT = ConfigFlag.FW.SMTP_PORT.getValue();
			SMTP_AUTH = ConfigFlag.FW.SMTP_AUTH.getValue();
			emailFromAddress = ConfigFlag.FW.SMTP_SENDER.getValue();
		}

		public void sendSSLMessage(String recipient, String subject, String message, String atach) throws MessagingException
		{
			System.out.println("Send email to: " + recipient + " with subject :" + subject + " and message : " + message + " and attach file: " + atach);

			boolean debug = false;
			Properties props = new Properties();
			props.put("mail.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "false");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					String[] auth = SMTP_AUTH.split(":");
					return new PasswordAuthentication(auth[0], auth[1]);
				}
			});

			session.setDebug(debug);

			Message msg = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(emailFromAddress);
			msg.setFrom(addressFrom);

			InternetAddress addressTo = new InternetAddress(recipient);
			msg.setRecipient(Message.RecipientType.TO, addressTo);

			// Setting the Subject and Content Type
			msg.setSubject(subject);
			msg.setContent(message, "text/plain");

			// create and fill the first message part
			MimeBodyPart firstMsgBodyPart = new MimeBodyPart();
			firstMsgBodyPart.setText("");//WDEV-13753

			// create the second message part
			MimeBodyPart secondMsgBodyPart = new MimeBodyPart();

			// attach the file to the message
			FileDataSource fds = new FileDataSource(atach);
			secondMsgBodyPart.setDataHandler(new DataHandler(fds));
			secondMsgBodyPart.setFileName(fds.getName());

			// create the Multipart and add its parts to it
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(firstMsgBodyPart);
			mp.addBodyPart(secondMsgBodyPart);

			// add the Multipart to the message
			msg.setContent(mp);

			// set the Date: header
			msg.setSentDate(new java.util.Date());

			Transport tr = session.getTransport("smtp");
			tr.connect(SMTP_HOST_NAME, SMTP_PORT, null, null);
			msg.saveChanges();
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
		}
	}

	@Override
	protected void onChkClinicalDetailsValueChanged() throws PresentationLogicException 
	{
		if(!form.chkClinicalDetails().getValue())
		{
			form.dteDateOfCompletion().setValue(null);
			return;//	WDEV-13632
		}
		
		form.htmReport().setHTML("");//	WDEV-13632
		engine.open(form.getForms().RACPC.RACPCSummaryCompleteDate);//	WDEV-13632
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		//	WDEV-13632
		if(form.getForms().RACPC.RACPCSummaryCompleteDate.equals(formName))
		{
			if(DialogResult.OK.equals(result))
			{
				form.dteDateOfCompletion().setValue(form.getGlobalContext().RACPC.getDateOfCompletion());
			}
			else if(DialogResult.CANCEL.equals(result))//	WDEV-13632
			{
				form.chkClinicalDetails().setValue(false);
			}
		}
		
		if(form.getLocalContext().getHTMLValue() == null)
		{
			buildRACPCSummaryReport(true);
			return;
		}
		
		form.htmReport().setHTML(form.getLocalContext().getHTMLValue());
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException 
	{
		//WDEV-13664 
		if(form.getLocalContext().getStaleMessageIDIsNotNull() && form.getLocalContext().getStaleMessageID() == messageBoxId)
		{
			form.getLocalContext().setStaleMessageID(null);
			open();
			return;
		}
		
		if(form.getLocalContext().getHTMLValue() == null)
		{
			buildRACPCSummaryReport(true);
			return;
		}
		
		form.htmReport().setHTML(form.getLocalContext().getHTMLValue());
	}
}
