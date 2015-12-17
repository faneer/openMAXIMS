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
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.66 build 3253.22551)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.naes.forms.naes_referral;

import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.CareContextVoCollection;
import ims.core.vo.CareSpellVo;
import ims.core.vo.EpisodeofCareVo;
import ims.core.vo.EpisodeofCareVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.lookups.CareSpelltoEpisodeRelationship;
import ims.core.vo.lookups.ContextType;
import ims.core.vo.lookups.Language;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.YesNoUnknown;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.naes.vo.NAESReferralVo;
import ims.naes.vo.NAESReferralVoCollection;
import ims.vo.interfaces.IHcp;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	private void open()
	{
		NAESReferralVo referral = null;
		NAESReferralVo globalRef = null;

		init();

		populateRecordBrowser();

		if (form.recbrReferrals().getValues() != null && form.recbrReferrals().getValues().size() == 0)
		{
			form.btnEdit().setEnabled(false);
			form.btnBookAppt().setEnabled(false);
		}
		if (form.recbrReferrals().getValue() != null)
		{
			referral = form.recbrReferrals().getValue();
			globalRef = new NAESReferralVo();

			globalRef = (NAESReferralVo) referral.clone();

		}

		populateScreenFromData(referral);
		form.getLocalContext().setReferal(referral);
		if (referral != null)
		{
			if (referral.getIsRIE() == null)
				form.getGlobalContext().Naes.setReferral(globalRef);
			else if (referral.getIsRIE())
			{
				form.getGlobalContext().Naes.setReferral(null);
			}
		}
		else
		{
			form.getGlobalContext().Naes.setReferral(referral);
		}
		if (form.recbrReferrals().getValues().size() == 0 && form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			form.getGlobalContext().Core.setCurrentCareContext(null);
		}
		
		form.setMode(FormMode.VIEW);
	}

	private void init()
	{
		clear();
		form.lblLanguage().setVisible(false);
		form.lblImplantType().setVisible(false);
		form.lblUnderLying().setVisible(false);

		form.cmbLanguage().setVisible(false);
		form.cmbUnderLyingReason().setVisible(false);
		form.cmbImplantType().setVisible(false);

	}

	private void populateRecordBrowser()
	{

		form.recbrReferrals().clear();

		NAESReferralVoCollection referrals = domain.getReferral(form.getGlobalContext().Core.getPatientShort().toPatientRefVo());

		for (int index = 0; index < referrals.size(); index++)
		{
			String doctor = "Referring Doctor:";
			String hospital = "Hospital: ";
			String date = "Date Received: ";

			if (referrals.get(index).getReferringDoctorIsNotNull())
				doctor += referrals.get(index).getReferringDoctor();

			if (referrals.get(index).getReferringHospitalIsNotNull())
				hospital += referrals.get(index).getReferringHospital();
			if (referrals.get(index).getDateReferralReceivedIsNotNull())
				date += referrals.get(index).getDateReferralReceived().toString();

			form.recbrReferrals().newRow(referrals.get(index), doctor + "  " + hospital + "  " + date);

			if (referrals.size() > 0)
				form.recbrReferrals().setValue(referrals.get(0));
		}
	}

	private void populateScreenFromData(NAESReferralVo referral)
	{
		clear();
		form.lblKPIValue().setValue("");
		form.lbl3KPI().setVisible(false);
		form.lbl6KPI().setVisible(false);
		if (referral != null)
		{
			if (referral.getIsRIE() != null && referral.getIsRIE() == true)
			{
				form.getGlobalContext().Naes.setReferral(null);
				form.getGlobalContext().Core.setCurrentCareContext(null);
			}
			else
				form.getGlobalContext().Core.setCurrentCareContext(referral.getCareContext());

					
			if (referral.getDateOfSurgeryIsNotNull())
				form.dteDateOfSurgery().setValue(referral.getDateOfSurgery());
			if (referral.getDateReferralReceivedIsNotNull())
				form.dteReceived().setValue(referral.getDateReferralReceived());
			if (referral.getAffectedEyeIsNotNull())
				form.cmbAffectedEye().setValue(referral.getAffectedEye());
			if (referral.getImplantIsNotNull())
			{
				form.cmbImplant().setValue(referral.getImplant());
				if (referral.getImplant().equals(YesNoUnknown.YES))
				{
					form.cmbImplantType().setVisible(true);
					form.lblImplantType().setVisible(true);
					form.cmbImplantType().setValue(referral.getImplantType());
			
					if (referral.getSixWeekKPIIsNotNull()){
						form.lbl6KPI().setVisible(true);
						form.lblKPIValue().setValue(referral.getSixWeekKPI().toString());
					}
				}
				else if (referral.getImplant().equals(YesNoUnknown.NO)  || referral.getImplant().equals(YesNoUnknown.UNKNOWN)) //WDEV-10638
				{					
					if (referral.getThreeWeekKPIIsNotNull()){
						form.lbl3KPI().setVisible(true);
						form.lblKPIValue().setValue(referral.getThreeWeekKPI().toString());
					}
					form.cmbImplantType().setVisible(false);
					form.lblImplantType().setVisible(false);
				}
			}
			else
			{
				form.lblKPIValue().setValue("");
				form.lbl3KPI().setVisible(false);
				form.lbl6KPI().setVisible(false);

			}

			if (referral.getImplantTypeIsNotNull())
				form.cmbImplantType().setValue(referral.getImplantType());

			if (referral.getReferralReasonIsNotNull())
				form.cmbReferralReason().setValue(referral.getReferralReason());
			if (referral.getSecondarySurgeryIsNotNull())
			{
				form.cmbSurgeryRequired().setValue(referral.getSecondarySurgery());

				if (referral.getSecondarySurgery().equals(YesNoUnknown.YES))
				{
					form.cmbUnderLyingReason().setVisible(true);
					form.lblUnderLying().setVisible(true);
					form.cmbUnderLyingReason().setValue(referral.getUnderlyingReason());

				}
				else
				{
					form.cmbUnderLyingReason().setVisible(false);
					form.lblUnderLying().setVisible(false);

				}
			}

			if (referral.getUnderlyingReasonIsNotNull())
				form.cmbUnderLyingReason().setValue(referral.getUnderlyingReason());
			if (referral.getReferredByIsNotNull())
				form.cmbReferredBy().setValue(referral.getReferredBy());

			if (referral.getReferringDoctorIsNotNull())
				form.txtDoctor().setValue(referral.getReferringDoctor());
			if (referral.getReferringHospitalIsNotNull())
				form.txtHospital().setValue(referral.getReferringHospital());

			if (referral.getInterpreterRequiredIsNotNull())
			{
				form.cmbInterpreterRequired().setValue(referral.getInterpreterRequired());
				if (referral.getInterpreterRequired().equals(YesNoUnknown.YES))
				{
					form.lblLanguage().setVisible(true);
					form.cmbLanguage().setVisible(true);

					if (referral.getLanguageIsNotNull())
					{
						form.cmbLanguage().setValue(referral.getLanguage());
						if (referral.getLanguage().equals(Language.OTHER) && referral.getInterpreterRequired().equals(YesNoUnknown.YES))
						{
							if (referral.getLanguageIfOtherIsNotNull())
								form.txtOtherLanguage().setValue(referral.getLanguageIfOther());
						}
					}
				}
				else
				{
					form.lblLanguage().setVisible(false);
					form.cmbLanguage().setVisible(false);

				}

			}
			else												//wdev-10596
			{
				form.lblLanguage().setVisible(false);
				form.cmbLanguage().setVisible(false);

			}

			form.btnBookAppt().setEnabled(true);
			
			if(referral.getPreferredClinicIsNotNull())
				form.txtPreferredClinic().setValue(referral.getPreferredClinic());
			
			if(referral.getNotesIsNotNull())
				form.txtNotes().setValue(referral.getNotes());
			
		}
	}

	private void clear()
	{
		form.dteDateOfSurgery().setValue(null);
		form.dteReceived().setValue(null);
		form.cmbReferredBy().setValue(null);
		form.cmbAffectedEye().setValue(null);
		form.cmbImplant().setValue(null);
		form.cmbImplantType().setValue(null);
		form.cmbInterpreterRequired().setValue(null);
		form.cmbLanguage().setValue(null);
		form.cmbReferralReason().setValue(null);
		form.cmbSurgeryRequired().setValue(null);
		form.cmbUnderLyingReason().setValue(null);
		form.txtDoctor().setValue(null);
		form.txtHospital().setValue(null);
		form.txtOtherLanguage().setValue(null);
		form.lblKPIValue().setValue("");
		form.lbl3KPI().setVisible(false);
		form.lbl6KPI().setVisible(false);
		form.txtPreferredClinic().setValue(null);
		form.txtNotes().setValue(null);
	}

	@Override
	protected void onBtnNewClicked() throws PresentationLogicException
	{
		form.getLocalContext().setReferal(null);
		form.getGlobalContext().Core.setCurrentCareContext(null);
		init();
		form.setMode(FormMode.EDIT);
		form.btnBookAppt().setEnabled(false);
	}

	protected void onBtnCancelClicked() throws PresentationLogicException
	{
		clear();
		if (form.getGlobalContext().Naes.getReferral() != null)
			populateScreenFromData(domain.getReferralVo(form.getGlobalContext().Naes.getReferral()));	//wdev-10596
		//WDEV-16612
		if (form.recbrReferrals().getValue() != null)
		{	
			form.getLocalContext().setReferal(domain.getReferralVo(form.recbrReferrals().getValue()));
			populateScreenFromData(form.getLocalContext().getReferal());
		}	
		form.setMode(FormMode.VIEW);
	}

	protected void onRcbValueChanged() throws PresentationLogicException
	{
		form.getLocalContext().setReferal(domain.getReferralVo(form.recbrReferrals().getValue()));	//wdev-10596

		form.getGlobalContext().Naes.setReferral(form.getLocalContext().getReferal());				//wdev-10596
		form.getGlobalContext().Core.setCurrentCareContext(form.getLocalContext().getReferal().getCareContext());	//wdev-10596

		populateScreenFromData(form.getLocalContext().getReferal());
		
	}

	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.btnBookAppt().setEnabled(false);
	}

	@Override
	protected void onBtnSaveClicked() throws PresentationLogicException
	{
		NAESReferralVo referral = populateDataFromScreen();
		String[] errors = referral.validate(validateUI(referral));
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}
		try
		{
			NAESReferralVo savedReferral = domain.save(referral);
			form.recbrReferrals().newRow(savedReferral, referral.getReferringDoctor() + " " + referral.getReferralReason() + " " + referral.getDateOfSurgery());
			valueChanged(savedReferral);

			form.getLocalContext().setReferal(savedReferral);
			form.getGlobalContext().Core.setCurrentCareContext(savedReferral.getCareContext());

			form.getGlobalContext().Naes.setReferral((NAESReferralVo) form.getLocalContext().getReferal().clone());
			form.setMode(FormMode.VIEW);
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (UniqueKeyViolationException e)
		{
			e.printStackTrace();
		}
		
		form.btnBookAppt().setEnabled(true);
		form.btnEdit().setEnabled(true);
	}

	private String[] validateUI(NAESReferralVo referral)
	{
		String[] valErrors = null;
		List<String> errors = new ArrayList<String>();

		if (referral.getInterpreterRequired() != null)
		{
			if (referral.getInterpreterRequired().equals(YesNoUnknown.YES) && referral.getLanguage() == null)
			{
				errors.add("Please select a language for which an interpreter is required.");
			}
		}

		return valErrors = errors.toArray(new String[0]);

	}

	private NAESReferralVo populateDataFromScreen()
	{
		NAESReferralVo referralVo = null;

		if (form.getLocalContext().getReferal() == null)
		{
			referralVo = new NAESReferralVo();
		}
		else
		{
			referralVo = form.recbrReferrals().getValue();
		}
		referralVo.setReferredBy(form.cmbReferredBy().getValue());
		referralVo.setReferringDoctor(form.txtDoctor().getValue());
		referralVo.setReferringHospital(form.txtHospital().getValue());
		referralVo.setDateOfSurgery(form.dteDateOfSurgery().getValue());
		referralVo.setDateReferralReceived(form.dteReceived().getValue());
		referralVo.setSecondarySurgery(form.cmbSurgeryRequired().getValue());
		referralVo.setUnderlyingReason(form.cmbUnderLyingReason().getValue());
		referralVo.setReferralReason(form.cmbReferralReason().getValue());
		referralVo.setAffectedEye(form.cmbAffectedEye().getValue());
		referralVo.setImplant(form.cmbImplant().getValue());
		referralVo.setImplantType(form.cmbImplantType().getValue());
		referralVo.setInterpreterRequired(form.cmbInterpreterRequired().getValue());
		referralVo.setLanguage(form.cmbLanguage().getValue());
		referralVo.setLanguageIfOther(form.txtOtherLanguage().getValue());
		referralVo.setPatient(form.getGlobalContext().Core.getPatientShort());
		referralVo.setPreferredClinic(form.txtPreferredClinic().getValue());
		referralVo.setNotes(form.txtNotes().getValue());
		
		CareContextShortVo careContextVo = createCareContext(referralVo);

		if (careContextVo != null)
			referralVo.setCareContext(careContextVo);
		else
			return null;
		if (form.cmbImplant().getValue() != null)
		{
			if (form.cmbImplant().getValue().equals(YesNoUnknown.NO)  || form.cmbImplant().getValue().equals(YesNoUnknown.UNKNOWN)) //WDEV-10638
			{
				if (form.getLocalContext().getKpiDateIsNotNull())
				{
					referralVo.setThreeWeekKPI(form.getLocalContext().getKpiDate());
				}
			}
			else if (form.cmbImplant().getValue().equals(YesNoUnknown.YES))
			{
				if (form.getLocalContext().getKpiDateIsNotNull())
				{
					referralVo.setSixWeekKPI(form.getLocalContext().getKpiDate());
				}
			}
		}
		
		if (form.getLocalContext().getKpiDate()==null)
		{
			referralVo.setSixWeekKPI(null);
			referralVo.setThreeWeekKPI(null);
		}

		return referralVo;
	}

	private CareContextShortVo createCareContext(NAESReferralVo referralVo)
	{
		EpisodeofCareVo episodeVo = null;
		CareContextVo careContextVo = null;
		CareSpellVo careSpellVo = createCareSpell();

		if (careSpellVo != null)
			episodeVo = createEpisode(careSpellVo);
		else
			return null;
		if (careSpellVo.getEpisodes().get(0).getCareContexts() != null && careSpellVo.getEpisodes().get(0).getCareContexts().get(0) != null)
			careContextVo = careSpellVo.getEpisodes().get(0).getCareContexts().get(0);
		else
			careContextVo = new CareContextVo();

		careContextVo.setEndDateTime(null);
		careContextVo.setPasEvent(null);
		careContextVo.setLocationType(null);
		careContextVo.setStartDateTime(new DateTime());
		careContextVo.setEpisodeOfCare(episodeVo);
		careContextVo.setContext(ContextType.OUTPATIENT);
		careContextVo.setResponsibleHCP((IHcp) domain.getHcpLiteUser());

		if (referralVo.getIsRIE() != null)
			if (referralVo.getIsRIE())
				careContextVo.setIsRIE(true);

		if (episodeVo.getCareContexts() == null)
			episodeVo.setCareContexts(new CareContextVoCollection());

		episodeVo.getCareContexts().add(careContextVo);

		String[] errors = careSpellVo.validate();

		if (errors != null)
		{
			engine.showErrors(errors);
			return null;

		}

		try
		{
			careSpellVo = domain.saveCareSpell(careSpellVo);
			return careSpellVo.getEpisodes().get(0).getCareContexts().get(0);
		}
		catch (DomainInterfaceException e)
		{

			e.printStackTrace();
		}
		catch (StaleObjectException e)
		{

			e.printStackTrace();
		}
		catch (ForeignKeyViolationException e)
		{

			e.printStackTrace();
		}
		catch (UniqueKeyViolationException e)
		{

			e.printStackTrace();
		}
		return null;

	}

	private EpisodeofCareVo createEpisode(CareSpellVo careSpellVo)
	{
		EpisodeofCareVo episode = null;

		if (careSpellVo.getEpisodes() != null && careSpellVo.getEpisodes().get(0) != null)
			episode = careSpellVo.getEpisodes().get(0);
		else
			episode = new EpisodeofCareVo();

		episode.setResponsibleHCP((HcpLiteVo) domain.getHcpLiteUser());
		episode.setCareSpell(careSpellVo);
		episode.setEndDate(null);
		episode.setStartDate(new Date());
		episode.setRelationship(CareSpelltoEpisodeRelationship.PRIMARY);
		episode.setSpecialty(Specialty.CORRESPONDENCE);

		if (careSpellVo.getEpisodes() == null)
		{
			careSpellVo.setEpisodes(new EpisodeofCareVoCollection());
		}

		careSpellVo.getEpisodes().add(episode);

		return episode;
	}

	private CareSpellVo createCareSpell()
	{
		CareSpellVo careSpellVo = null;

		if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			careSpellVo = domain.getCareSpell(form.getGlobalContext().Core.getCurrentCareContext().getEpisodeOfCare().getCareSpell());
		else
			careSpellVo = new CareSpellVo();

		careSpellVo.setEndDate(null);
		careSpellVo.setPatient(form.getGlobalContext().Core.getPatientShort());
		careSpellVo.setStartDate(new Date());
		return careSpellVo;

	}

	@Override
	protected void onFormModeChanged()
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.cmbLanguage().setEnabled(true);
			form.cmbImplantType().setEnabled(true);
			form.cmbUnderLyingReason().setEnabled(true);
			form.txtPreferredClinic().setEnabled(true);
			form.txtNotes().setEnabled(true);			
		}

		if (form.getMode().equals(FormMode.VIEW))
		{
			if (form.recbrReferrals().getValues().size() > 0)
			{
				form.btnEdit().setVisible(true);
				form.btnBookAppt().setVisible(true);
			}
			else
				form.btnEdit().setVisible(false);

			form.btnNew().setVisible(true);

			form.cmbLanguage().setEnabled(false);
			form.cmbImplantType().setEnabled(false);
			form.cmbUnderLyingReason().setEnabled(false);
			form.txtPreferredClinic().setEnabled(false);
			form.txtNotes().setEnabled(false);
		}
		
		updateControlsState();
	}

	private void valueChanged(NAESReferralVo referralVo)
	{
		populateRecordBrowser();
		form.recbrReferrals().setValue(referralVo);
		
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.btnBookAppt().setEnabled(true);
			form.btnEdit().setEnabled(true);
		}
	}

	@Override
	protected void onCmbSurgeryValueChanged() throws PresentationLogicException
	{
		form.cmbUnderLyingReason().setValue(null);

		if (form.cmbSurgeryRequired().getValue() != null)
		{
			if (form.cmbSurgeryRequired().getValue().equals(YesNoUnknown.YES))
			{
				form.cmbUnderLyingReason().setVisible(true);
				form.lblUnderLying().setVisible(true);
			}
			else
			{
				if (form.getLocalContext().getReferal() != null)
				{
					form.getLocalContext().getReferal().setUnderlyingReason(null);
				}
				form.cmbUnderLyingReason().setVisible(false);
				form.lblUnderLying().setVisible(false);

			}
			return;
		}

		if (form.getLocalContext().getReferal() != null)
		{
			form.getLocalContext().getReferal().setUnderlyingReason(null);
		}
		form.cmbUnderLyingReason().setVisible(false);
		form.lblUnderLying().setVisible(false);
	}

	@Override
	protected void onCmbImplantValueChanged() throws PresentationLogicException
	{
		form.getLocalContext().setKpiDate(null);
		form.cmbImplantType().setValue(null);

		if (form.cmbImplant().getValue() != null && form.dteReceived().getValue() != null)
		{
			if (form.cmbImplant().getValue().equals(YesNoUnknown.YES))
			{
				form.lbl6KPI().setVisible(true);
				form.lbl3KPI().setVisible(false);
				form.lblKPIValue().setValue("");
				if (form.dteReceived().getValue() != null)
					form.lblKPIValue().setValue(calculateSixWeekKPI(new Date(form.dteReceived().getValue())));

				form.cmbImplantType().setVisible(true);
				form.lblImplantType().setVisible(true);

			}
			else if (form.cmbImplant().getValue().equals(YesNoUnknown.NO) || form.cmbImplant().getValue().equals(YesNoUnknown.UNKNOWN)) //WDEV-10638
			{
				form.lbl3KPI().setVisible(true);
				form.lbl6KPI().setVisible(false);
				form.lblKPIValue().setValue("");
				if (form.dteReceived().getValue() != null)
					form.lblKPIValue().setValue(calculateThreeWeekKPI(new Date(form.dteReceived().getValue())));

				if (form.getLocalContext().getReferal() != null)
				{
					form.getLocalContext().getReferal().setImplantType(null);
				}
				form.cmbImplantType().setVisible(false);
				form.lblImplantType().setVisible(false);
			}
			else
			{
				form.lbl3KPI().setVisible(false);
				form.lbl6KPI().setVisible(false);
				form.lblKPIValue().setValue("");

				if (form.getLocalContext().getReferal() != null)
				{
					form.getLocalContext().getReferal().setImplantType(null);
				}
				form.cmbImplantType().setVisible(false);
				form.lblImplantType().setVisible(false);

			}
			return;

		}
		else
		{
			form.lbl3KPI().setVisible(false);
			form.lbl6KPI().setVisible(false);
			form.lblKPIValue().setValue("");
		}

		if (form.getLocalContext().getReferal() != null)
		{
			form.getLocalContext().getReferal().setImplantType(null);
		}
		form.cmbImplantType().setVisible(false);
		form.lblImplantType().setVisible(false);
		
		if (form.cmbImplant().getValue() != null && form.cmbImplant().getValue().equals(YesNoUnknown.YES)){
			form.cmbImplantType().setVisible(true);
			form.lblImplantType().setVisible(true);
		}
	}

	private String calculateThreeWeekKPI(Date date)
	{
		if(date != null)
		{
			Date threeKpiDate = new Date();
			threeKpiDate = date.addDay(21);
			form.getLocalContext().setKpiDate(threeKpiDate);
			return threeKpiDate.toString();
		}
		
		return "";
	}

	private String calculateSixWeekKPI(Date date)
	{
		if(date != null)
		{
			Date sixKpiDate = new Date();
			sixKpiDate = date.addDay(42);
			form.getLocalContext().setKpiDate(sixKpiDate);
			return sixKpiDate.toString();
		}
		
		return "";
	}

	@Override
	protected void onCmbLanguageChanged() throws PresentationLogicException
	{
		updateControlsState();
	}

	protected void onCmbInterpreterReqChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbLanguage().setValue(null);
		if (form.cmbInterpreterRequired().getValue() != null)
		{
			if (form.cmbInterpreterRequired().getValue().equals(YesNoUnknown.YES))
			{
				form.cmbLanguage().setVisible(true);
				form.lblLanguage().setVisible(true);
			}
			else
			{
				if (form.getLocalContext().getReferal() != null)
				{
					form.getLocalContext().getReferal().setLanguage(null);
					form.getLocalContext().getReferal().setLanguageIfOther(null);
				}
				form.lblLanguage().setVisible(false);
				form.cmbLanguage().setVisible(false);
			}
		}
		else
		{
			if (form.getLocalContext().getReferal() != null)
			{
				form.getLocalContext().getReferal().setLanguage(null);
				form.getLocalContext().getReferal().setLanguageIfOther(null);
			}
			form.lblLanguage().setVisible(false);
			form.cmbLanguage().setVisible(false);
		}
		
		updateControlsState();
	}

	@Override
	protected void onBtnBookApptClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Scheduling.BookAppointmentDialog);
	}

	@Override
	protected void onDteReceivedValueChanged() throws PresentationLogicException
	{
		form.getLocalContext().setKpiDate(null);
		if (form.cmbImplant().getValue() != null && form.dteReceived().getValue() != null)
		{
			form.lbl6KPI().setVisible(true);
			form.lbl3KPI().setVisible(false);
			form.lblKPIValue().setValue("");
			if (form.dteReceived().getValue() != null && form.cmbImplant().getValue() == null)

				form.lblKPIValue().setValue(calculateSixWeekKPI(new Date(form.dteReceived().getValue())));

			else if (form.dteReceived().getValue() != null && form.cmbImplant().getValue().equals(YesNoUnknown.YES))
			{
				form.lblKPIValue().setValue(calculateSixWeekKPI(new Date(form.dteReceived().getValue())));
				form.lbl6KPI().setVisible(true);
				form.lbl3KPI().setVisible(false);
			}
			else if (form.dteReceived().getValue() != null && (form.cmbImplant().getValue().equals(YesNoUnknown.NO) || form.cmbImplant().getValue().equals(YesNoUnknown.UNKNOWN)))
			{
				form.lblKPIValue().setValue(calculateThreeWeekKPI(new Date(form.dteReceived().getValue())));
				form.lbl6KPI().setVisible(false);
				form.lbl3KPI().setVisible(true);
			}
		}
		else
		{
			form.lbl3KPI().setVisible(false);
			form.lbl6KPI().setVisible(false);
			form.lblKPIValue().setValue("");
		}
	}
	
	private void updateControlsState()
	{
		Boolean isOtherLanguageVisible = Language.OTHER.equals(form.cmbLanguage().getValue());
		
		form.txtOtherLanguage().setVisible(isOtherLanguageVisible);
		form.lblOther().setVisible(isOtherLanguageVisible);
		
		form.txtOtherLanguage().setEnabled(FormMode.EDIT.equals(form.getMode()) && isOtherLanguageVisible);
		form.lblOther().setEnabled(FormMode.EDIT.equals(form.getMode()) && isOtherLanguageVisible);
	}
}
