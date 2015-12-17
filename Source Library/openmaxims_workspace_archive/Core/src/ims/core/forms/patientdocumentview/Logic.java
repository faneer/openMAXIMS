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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3708.14700)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.patientdocumentview;

import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private String fileName = null;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(args);
	}
	private void initialize(Object[] args) throws PresentationLogicException 
	{
		if(args != null && args.length > 0)
		{
			fileName = (String) args[0];
		}
		
		previewFile();
	}
	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	public void previewFile() throws ims.framework.exceptions.PresentationLogicException
	{
		form.htmDocPreviewer().setHTML("<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + fileName +  "'></IFRAME>");
	}
}
