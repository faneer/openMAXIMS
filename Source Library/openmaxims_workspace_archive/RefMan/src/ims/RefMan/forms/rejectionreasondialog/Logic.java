// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.62 build 3110.16630)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.rejectionreasondialog;

import ims.RefMan.vo.RejectReferralVo;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().RefMan.setPrintRejectionLetters(Boolean.FALSE);

		form.btnPrint().setEnabled(false);
		
		if (form.getGlobalContext().RefMan.getRejectionReasonIsNotNull() )
			open();
	}


	private void open()
	{
		RejectReferralVo voReject = form.getGlobalContext().RefMan.getRejectionReason();

		form.cmbReason().setValue(voReject.getReason());
		form.txtNotes().setValue(voReject.getRejectionComments());
		form.chkGP().setValue(voReject.getWasGPContacted());
		form.chkPatient().setValue(voReject.getWasPatientContacted());
		if (voReject.getWasGPContacted() || voReject.getWasPatientContacted())
			form.btnPrint().setEnabled(true);
			
	}


	protected void onBtnCancel() throws PresentationLogicException
	{
		form.getGlobalContext().RefMan.setRejectionReason(null);
		
		engine.close(DialogResult.CANCEL); 
	}

	protected void onBtnOk() throws PresentationLogicException
	{
		if (form.cmbReason().getValue() == null)
		{
			engine.showMessage("A Rejection Reason is Mandatory", "Error", MessageButtons.OK, MessageIcon.ERROR);
			return;
		}
		
		save();
		
		engine.close(DialogResult.OK);
	}


	@Override
	protected void onBtnPrintGPClick() throws PresentationLogicException 
	{
		if (form.chkGP().getValue() || form.chkPatient().getValue())
			form.getGlobalContext().RefMan.setPrintRejectionLetters(Boolean.TRUE);
		
		if (form.cmbReason().getValue() == null)
		{
			engine.showMessage("A Rejection Reason is Mandatory", "Error", MessageButtons.OK, MessageIcon.ERROR);
			return;
		}
		
		save();

		engine.close(DialogResult.OK);
	}


	private void save() 
	{
		RejectReferralVo voReject = new RejectReferralVo();

		voReject.setReason(form.cmbReason().getValue());
		voReject.setRejectionComments(form.txtNotes().getValue());
		voReject.setWasGPContacted(form.chkGP().getValue());
		voReject.setWasPatientContacted(form.chkPatient().getValue());
		
		form.getGlobalContext().RefMan.setRejectionReason(voReject);
	}


	@Override
	protected void onChkPatientValueChanged() throws PresentationLogicException 
	{
		if (form.chkPatient().getValue())
			form.btnPrint().setEnabled(true);

		if (! form.chkGP().getValue() && ! form.chkPatient().getValue())
			form.btnPrint().setEnabled(false);
	}


	@Override
	protected void onChkGPValueChanged() throws PresentationLogicException 
	{
		if (form.chkGP().getValue())
			form.btnPrint().setEnabled(true);

		if (! form.chkGP().getValue() && ! form.chkPatient().getValue())
			form.btnPrint().setEnabled(false);
	}
}
