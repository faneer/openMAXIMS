// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface AllocateTasksDialog extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* save
	*/
	public Boolean saveAllocations(ims.RefMan.vo.WorkAllocationVoCollection voAllocations) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.WorkAllocationVoCollection listAllocatedTasks(String referralIDs);

	// Generated from form domain interface definition
	/**
	* list CATS referrals
	*/
	public ims.RefMan.vo.CatsReferralListManualAssemblyVoCollection listCATSReferrals(ims.RefMan.vo.CATSReferralFilterVo voCATSFilter, Boolean bIncludeICPColumn, Boolean bIncludeELEColumn);
}
