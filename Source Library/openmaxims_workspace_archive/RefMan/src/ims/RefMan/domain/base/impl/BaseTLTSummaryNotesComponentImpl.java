// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseTLTSummaryNotesComponentImpl extends DomainImpl implements ims.RefMan.domain.TLTSummaryNotesComponent, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistTLTSummaryNotes(ims.RefMan.vo.CatsReferralRefVo catsRefVo)
	{
		if(catsRefVo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'catsRefVo' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveTLTSummaryNotes(ims.RefMan.vo.TltSummaryNoteVo followUpNoteVo)
	{
		if(followUpNoteVo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'followUpNoteVo' of type 'ims.RefMan.vo.TltSummaryNoteVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetTLTNote(ims.RefMan.vo.TltSummaryNoteRefVo note)
	{
		if(note == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'note' of type 'ims.RefMan.vo.TltSummaryNoteRefVo' cannot be null.");
	}
}
