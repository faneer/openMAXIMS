// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseInvestigationsComponentImpl extends DomainImpl implements ims.RefMan.domain.InvestigationsComponent, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistResults(ims.RefMan.vo.CatsReferralRefVo referral)
	{
		if(referral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'referral' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistResults(ims.core.patient.vo.PatientRefVo patient)
	{
		if(patient == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patient' of type 'ims.core.patient.vo.PatientRefVo' cannot be null.");
	}
}
