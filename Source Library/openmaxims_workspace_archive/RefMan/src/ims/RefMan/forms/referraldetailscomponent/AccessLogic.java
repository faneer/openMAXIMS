// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3763.19232)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.referraldetailscomponent;

import java.io.Serializable;

public final class AccessLogic extends BaseAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public boolean isAccessible()
	{
		if(!super.isAccessible())
			return false;

		// TODO: Add your conditions here.
		return true;
	}
	public boolean isReadOnly()
	{
		if(super.isReadOnly())
			return true;

		// TODO: Add your conditions here.
		return false;
	}
}
