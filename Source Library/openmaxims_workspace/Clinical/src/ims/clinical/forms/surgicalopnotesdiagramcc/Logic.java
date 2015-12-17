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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.surgicalopnotesdiagramcc;

import java.io.File;
import java.security.SecureRandom;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

import ims.assessment.vo.GraphicAssessmentShortVo;
import ims.assessment.vo.GraphicAssessmentShortVoCollection;
import ims.assessment.vo.GraphicAssessmentVo;
import ims.assessment.vo.PatientAssessmentDataVo;
import ims.assessment.vo.PatientAssessmentVo;
import ims.assessment.vo.UserAssessmentVo;
import ims.clinical.vo.SurgicalOperationNotesDiagramVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.clinical.vo.ServiceRefVoCollection;
import ims.core.resource.people.domain.objects.Nurse;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicVo;
import ims.core.vo.NurseVo;
import ims.core.vo.PatientAssessmentInfoVo;
import ims.core.vo.PatientDocumentStatusVo;
import ims.core.vo.PatientDocumentStatusVoCollection;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.TherapistVo;
import ims.core.vo.enums.AuthoringLabelType;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.DocumentCreationType;
import ims.core.vo.lookups.DocumentStatus;
import ims.core.vo.lookups.FileType;
import ims.core.vo.lookups.PatientAssessmentStatusReason;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.UserAssessmentCategory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
		
		form.fireCustomControlValueChanged();
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}

	@Override
	/**
	 * WDEV-13973
	 */
	protected void onChkCompleteValueChanged() throws PresentationLogicException
	{
		form.ccCompletingAuthInfo().initializeComponent();
		
		updateControlState();
	}

	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (DialogResult.OK.equals(result))
		{
			if (form.getForms().Clinical.SearchGraphicalAssessment.equals(formName))
			{
				populateScreenFromData(form.getGlobalContext().Core.getGraphicAssessmentShortVo());
				form.setMode(FormMode.EDIT);
				
			}
		}
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		updateControlState();
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
		{
			//WDEV-14724
			if(form.getLocalContext().getCurentSurgicalOpNotes() != null && form.getLocalContext().getCurentSurgicalOpNotes().getDiagram() != null && PatientAssessmentStatusReason.COMPLETED.equals(form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getStatus()) 
					&& form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getAssessmentData() != null && form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getAssessmentData().getGraphic() != null 
					&& form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getAssessmentData().getGraphic().getAssociatedReportForPrinting() != null
					&& Boolean.TRUE.equals(ConfigFlag.UI.SAVE_PATIENTDOCUMENT_ON_ASSESSMENTCOMPLETED.getValue()))
			{
				createAndSavePatientDocument();
			}
			
			open();
		}
	}
	
	//	WDEV-14724
	private void createAndSavePatientDocument() 
	{
		if(form.getLocalContext().getCurentSurgicalOpNotes() == null || form.getLocalContext().getCurentSurgicalOpNotes().getDiagram() == null)
			return;
		
		PatientAssessmentVo patientAssessment = (PatientAssessmentVo) form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().clone();
		
		StringBuilder path = new StringBuilder();
		path.append(ConfigFlag.GEN.PDF_STORE_PATH.getValue());
		
		if(!(path.toString().endsWith("/") || path.toString().endsWith("\\")))
			path.append("/");
		
		try
		{
			if (!Boolean.TRUE.equals(ConfigFlag.UI.SAVE_PATIENTDOCUMENT_ON_ASSESSMENTCOMPLETED.getValue()))
			{
				if (domain.isSaved(patientAssessment))
				{
					engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					return;
				}
			}
			
			ServerDocumentVo serverDocument = null;
			
			if (patientAssessment.getAssessmentData().getGraphicIsNotNull())
			{
				serverDocument = printPatientAssessment(patientAssessment, patientAssessment.getAssessmentData().getGraphic().getAssociatedReportForPrinting(), null);
			}

			if (serverDocument == null)
				return;
			
			path.append(serverDocument.getFileName());

			// Create Patient Document VO
			PatientDocumentVo patientDocument = new PatientDocumentVo();
			patientDocument.setPatient(form.getGlobalContext().Core.getPatientShort());
			patientDocument.setEpisodeofCare(form.getGlobalContext().Core.getEpisodeofCareShort());
			patientDocument.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			//patientDocument.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			
			if (patientAssessment.getAssessmentData().getGraphicIsNotNull())
			{
				patientDocument.setName(patientAssessment.getAssessmentData().getGraphic().getName());
			}
			
			patientDocument.setServerDocument(serverDocument);
			patientDocument.setCreationType(DocumentCreationType.GENERATED);
			
			patientDocument.setCategory(DocumentCategory.ASSESSMENT);
			
			patientDocument.setStatus(PreActiveActiveInactiveStatus.ACTIVE);
			patientDocument.setRecordingUser(domain.getMosUser() instanceof MemberOfStaffRefVo ? (MemberOfStaffRefVo) domain.getMosUser() : null);
			patientDocument.setRecordingDateTime(new DateTime());
			patientDocument.setAuthoringHCP(patientAssessment.getCompletedHCP());
			patientDocument.setAuthoringDateTime(patientAssessment.getCompletedDateTime());
			patientDocument.setResponsibleHCP(form.getGlobalContext().Core.getEpisodeofCareShort().getResponsibleHCP());
			patientDocument.setSpecialty(form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty());
			patientDocument.setCorrespondenceStatus(DocumentStatus.COMPLETED);

			// Create a new PatientDocumentStatusVo
			PatientDocumentStatusVo status = new PatientDocumentStatusVo();
			status.setCorrespondenceStatus(DocumentStatus.COMPLETED);
			status.setRecordingUser(patientDocument.getRecordingUser());
			status.setRecordingDateTime(patientDocument.getRecordingDateTime());

			patientDocument.setCurrentDocumentStatus(status);
			patientDocument.setDocumentStatusHistory(new PatientDocumentStatusVoCollection());
			patientDocument.getDocumentStatusHistory().add(status);
			
			patientDocument.setDocumentDate(form.getGlobalContext().Core.getCurrentCareContext() != null ? form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime().getDate() : patientDocument.getRecordingDateTime().getDate());//WDEV-13638
			
			// Update current Patient Assessment
			patientAssessment.setIsAssessmentDocumentSaved(Boolean.TRUE);

			// Validate Patient Assessment and Patient Document records
			String[] errors = patientDocument.validate();
			errors = patientAssessment.validate(errors);

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return;
			}

			domain.savePatientDocument(patientDocument, patientAssessment);
			
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
			
			// Attempt to delete uploaded document if stale occurs
			File file = new File(path.toString());
			if (file.exists() && file.canWrite())
				file.delete();
			
			return;
		}
	}
	
	//	WDEV-14724
	private ServerDocumentVo printPatientAssessment(PatientAssessmentVo patientAssessment, TemplateBoRefVo templateReport, String printerName) 
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		String obj[] = domain.getReportAndTemplate(templateReport);
		
		if(obj == null)
		{
			engine.showMessage("I could not get the report and template linked to this assessment !");
			return null;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		client.addSeed(new SeedValue("PatientAssessment_id", patientAssessment.getID_PatientAssessment(), Integer.class));
		client.addSeed(new SeedValue("CareContext_id", form.getGlobalContext().Core.getCurrentCareContextIsNotNull() ? form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext() : null, Integer.class));
		//client.addSeed(new SeedValue("ClinicalContact_id", form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() ? form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact() : null, Integer.class));
		
		try
		{
			byte[] reportContent = client.buildReport(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, printerName, 1);
			
			String fileName = generateName() + ".pdf";
			engine.uploadFile(ConfigFlag.GEN.PDF_UPLOAD_URL.getValue(), reportContent, fileName, ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "\\");
			
			String path = null;
			
			int year  = new DateTime().getDate().getYear();
			int month = new DateTime().getDate().getMonth();
			int day   = new DateTime().getDate().getDay();
			
			if(fileName != null && fileName.length() > 0)
				path = year + "\\" + month + "\\" + day + "\\" + fileName;

			// Create Server document VO if uploads succeeds
			ServerDocumentVo document = new ServerDocumentVo();
			document.setFileName(path);
			document.setFileType(FileType.PDF);
			
			return document;
		} 
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return null;
		}
		catch (Exception e)
		{
			engine.showMessage("Could not upload file: " + e.getMessage());
			return null;
		}
	}
	
	//	WDEV-14724
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
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	private boolean save()
	{
		if (Boolean.TRUE.equals(form.chkComplete().getValue()))
		{
			String errors = form.ccCompletingAuthInfo().getErrors();
			
			if (errors != null && errors.length() > 0)
			{
				engine.showMessage(form.ccCompletingAuthInfo().getErrors(), "Errors", MessageButtons.OK);
				return false;
			}
		}

		SurgicalOperationNotesDiagramVo record = form.getLocalContext().getCurentSurgicalOpNotes();
		if (record == null)
		{
			record = new SurgicalOperationNotesDiagramVo();
			record.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			AuthoringInformationVo aut = createDefaultAuthoringInfo();
			record.setAuthoringInfo(aut);
		}

		record.setDiagram(form.ccGraphicAssesment().getPatientAssessment());
		
		// WDEV-13973
		// Initially set the status to INPROGRESS for diagram Patient Assessment
		// Or to COMPLETED if the user marked assessment as completed
		if (record.getDiagramIsNotNull())
		{
			if (Boolean.TRUE.equals(form.chkComplete().getValue()))
			{
				record.getDiagram().setStatus(PatientAssessmentStatusReason.COMPLETED);
				
				AuthoringInformationVo completingAuthoring = form.ccCompletingAuthInfo().getValue();
				record.getDiagram().setCompletedHCP(completingAuthoring.getAuthoringHcp());
				record.getDiagram().setCompletedDateTime(completingAuthoring.getAuthoringDateTime());
			}
			else
			{
				record.getDiagram().setStatus(PatientAssessmentStatusReason.INPROGRESS);
			}
		}
		
		String[] errors = null;
		
		if (Boolean.TRUE.equals(form.chkComplete().getValue()))
		{
			errors = record.validate(form.ccGraphicAssesment().validateData());
		}
		else
		{
			errors = record.validate();
		}

		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			form.getLocalContext().setCurentSurgicalOpNotes(domain.save(record));//	WDEV-14724
		}
		catch (DomainInterfaceException e)
		{
			engine.showErrors(new String[] { e.getMessage() });
			return false;
		}
		catch (StaleObjectException e)
		{
			engine.showErrors(new String[] { ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue() });
			open();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showErrors(new String[] { "A record with this unique key already exists" });
			return false;
		}

		return true;
	}

	private AuthoringInformationVo createDefaultAuthoringInfo()
	{
		AuthoringInformationVo aut = new AuthoringInformationVo();
		aut.setAuthoringDateTime(new DateTime());
		aut.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		return aut;
	}

	@Override
	protected void onBtnSearchAssesmentClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
		Object hcp = domain.getHcpUser();
		if (validateScreenAndDataBeforeSearch(hcp))
		{
			searchAssesment(hcp);
		}
		updateControlState();
		
	}
	private boolean validateScreenAndDataBeforeSearch(Object hcp) throws PresentationLogicException
	{
		
		if (hcp  == null)		//wdev-16116
			throw new PresentationLogicException("Current user is not HCP");		//wdev-16116
		String filter = form.txtName().getValue();
		if (filter == null || filter.length()<3)
		{
			engine.showErrors(new String[]{"Please enter at least 3 character to search for "});
			return false;
		}
		return true;
	}
	private void searchAssesment(Object hcp)
	{
		//wdev-16116
		Specialty spec = null;
		if( hcp instanceof MedicVo)
			spec = ((MedicVo)hcp).getSpecialty();
		else if (hcp instanceof NurseVo)
			spec = ((NurseVo)hcp).getSpecialty();
		else if ( hcp instanceof TherapistVo)
			spec = ((TherapistVo)hcp).getSpecialty();
		
		GraphicAssessmentShortVoCollection assessments = domain.listGraphicalAssesments(spec, form.txtName().getValue());	//wdev-16116
		if (assessments == null || assessments.size()==0)
		{
			engine.showMessage( "No results found","No Results", MessageButtons.OK, MessageIcon.INFORMATION);
			return;
		}
		if (assessments.size()==1)
		{
			
			populateScreenFromData(assessments.get(0));
			form.setMode(FormMode.EDIT);
			return;
		}
		Object[] args = new Object[3];
		args[0] = assessments;
		args[1] = form.txtName().getValue();
		args[2] = Boolean.FALSE;
		engine.open(form.getForms().Clinical.SearchGraphicalAssessment,args);
		
	}
	private void populateScreenFromData(GraphicAssessmentShortVo assessment) {
		form.txtName().setValue(assessment.getName());
		form.pnl1().setValue("Graphical Assessment");
		form.ccGraphicAssesment().setPatientAssessment(createNewPatientAssessment(domain.getFullGraphicalAssessmet(assessment)),PatientAssessmentInfoVo.getInstance(form.getGlobalContext().Core.getPatientShort()));
	}
	private PatientAssessmentVo createNewPatientAssessment(GraphicAssessmentVo gAss)
	{
		if (gAss == null )
			return null;
		PatientAssessmentVo patAss =  new PatientAssessmentVo();
		
		//WDEV-11721
		patAss.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		//WDEV-11526
		patAss.setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		patAss.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		patAss.setAuthoringInformation(createDefaultAuthoringInfo());
		patAss.setAssessmentData(new PatientAssessmentDataVo());
		patAss.getAssessmentData().setGraphic(domain.getFullGraphicalAssessmet(gAss));
		return patAss;
		
	}
	/**
	* Sets the component in ReadOnly/ReadWrite mode
	*/
	public void setReadOnly(Boolean isRead)
	{
		form.getLocalContext().setReadOnly(isRead);
	}

	/**
	* Runs the open() method.
	* The OnFormOpen() does not run that method, so this is the only way to show data on screen
	*/
	public void refresh()
	{
		open();
	}
	private void initialize()
	{
		form.ccGraphicAssesment().setEnabled(true);
		form.ccGraphicAssesment().clear(true);
		
		// WDEV-13973
		form.ccCompletingAuthInfo().setIsRequiredPropertyToControls(Boolean.TRUE);
		form.ccCompletingAuthInfo().setLabels(AuthoringLabelType.COMPLETING_COMPLETED);
	}
	
	private void open()
	{
		form.ccGraphicAssesment().clear(true);
		
		form.txtName().setValue(null);
		form.chkComplete().setValue(null);						// WDEV-13973
		form.ccCompletingAuthInfo().setValue(null);				// WDEV-13973
		form.pnl1().setValue("Select a Graphical Assessment");
		form.getLocalContext().setCurentSurgicalOpNotes(domain.getSurgicalOperationNotes(form.getGlobalContext().Core.getCurrentCareContext()));
		if (form.getLocalContext().getCurentSurgicalOpNotesIsNotNull()&& form.getLocalContext().getCurentSurgicalOpNotes().getDiagramIsNotNull())
		{
			form.pnl1().setValue("Graphical Assessment");
			form.txtName().setValue(form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getAssessmentData().getGraphic().getName());
			form.ccGraphicAssesment().setPatientAssessment(form.getLocalContext().getCurentSurgicalOpNotes().getDiagram());
			
			// WDEV-13973
			if (PatientAssessmentStatusReason.COMPLETED.equals(form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getStatus()))
			{
				form.chkComplete().setValue(Boolean.TRUE);
				
				AuthoringInformationVo completingAuthoring = new AuthoringInformationVo();
				completingAuthoring.setAuthoringHcp(form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getCompletedHCP());
				completingAuthoring.setAuthoringDateTime(form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getCompletedDateTime());
				
				form.ccCompletingAuthInfo().setValue(completingAuthoring);
			}
		}
		form.setMode(FormMode.VIEW);
		
		//
	}
	
	/**
	 *	WDEV-13973
	 *	Function used to update the state of the controls
	 */
	private void updateControlState()
	{
		boolean viewMode = FormMode.VIEW.equals(form.getMode());
		boolean readWrite	= !(form.getLocalContext().getReadOnlyIsNotNull() && form.getLocalContext().getReadOnly());
		boolean isPatAssSelected = form.getLocalContext().getCurentSurgicalOpNotesIsNotNull() && form.getLocalContext().getCurentSurgicalOpNotes().getDiagramIsNotNull();
		boolean isPatAssCompleted = isPatAssSelected && PatientAssessmentStatusReason.COMPLETED.equals(form.getLocalContext().getCurentSurgicalOpNotes().getDiagram().getStatus());
	
		form.ccGraphicAssesment().setEnabled(!viewMode && readWrite );
		
		form.ccCompletingAuthInfo().setMode(form.getMode());
		form.setccCompletingAuthInfoVisible(Boolean.TRUE.equals(form.chkComplete().getValue()));
		form.setccCompletingAuthInfoEnabled(!viewMode && readWrite && !isPatAssCompleted && Boolean.TRUE.equals(form.chkComplete().getValue()));
		form.ccCompletingAuthInfo().setEnabledAuthoringHCP(!viewMode && readWrite && !isPatAssCompleted);
		form.ccCompletingAuthInfo().setEnabledDateTime(!viewMode && readWrite && !isPatAssCompleted);
		
		if (viewMode)
		{
			form.btnEdit().setVisible(isPatAssSelected);
			form.btnEdit().setEnabled(readWrite && !isPatAssCompleted);
			form.chkComplete().setVisible(isPatAssSelected);
			form.chkComplete().setEnabled(false);
			form.txtName().setEnabled(!isPatAssSelected && readWrite);
			form.btnSearch().setVisible(!isPatAssSelected);
			form.btnSearch().setEnabled(readWrite);
		}
	}
}
