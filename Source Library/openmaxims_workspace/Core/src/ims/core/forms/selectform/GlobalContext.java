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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.selectform;

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

		public boolean getLinkedItemIsNotNull()
		{
			return !cx_ICPLinkedItem.getValueIsNull(context);
		}
		public ims.vo.interfaces.IActionICPLinkedItem getLinkedItem()
		{
			return (ims.vo.interfaces.IActionICPLinkedItem)cx_ICPLinkedItem.getValue(context);
		}
		public void setLinkedItem(ims.vo.interfaces.IActionICPLinkedItem value)
		{
			cx_ICPLinkedItem.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPLinkedItem = new ims.framework.ContextVariable("ICP.LinkedItem", "_cv_ICP.LinkedItem");
		public boolean getLinkedFormIsNotNull()
		{
			return !cx_ICPLinkedForm.getValueIsNull(context);
		}
		public ims.admin.vo.AppFormVo getLinkedForm()
		{
			return (ims.admin.vo.AppFormVo)cx_ICPLinkedForm.getValue(context);
		}
		public void setLinkedForm(ims.admin.vo.AppFormVo value)
		{
			cx_ICPLinkedForm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPLinkedForm = new ims.framework.ContextVariable("ICP.LinkedForm", "_cv_ICP.LinkedForm");

		private ims.framework.Context context;
	}

	public ICPContext ICP;
}
