//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.icp.forms.icpconfiglinkactions;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		ICP = new ICPContext(context);
	}
	public final class ICPContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ICPContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getLinkedActionsIsNotNull()
		{
			return !cx_ICPLinkedActions.getValueIsNull(context);
		}
		public ims.icps.configuration.vo.ICPActionRefVoCollection getLinkedActions()
		{
			return (ims.icps.configuration.vo.ICPActionRefVoCollection)cx_ICPLinkedActions.getValue(context);
		}
		public void setLinkedActions(ims.icps.configuration.vo.ICPActionRefVoCollection value)
		{
			cx_ICPLinkedActions.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPLinkedActions = new ims.framework.ContextVariable("ICP.LinkedActions", "_cv_ICP.LinkedActions");

		private ims.framework.Context context;
	}

	public ICPContext ICP;
}
