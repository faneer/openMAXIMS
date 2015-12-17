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

package ims.emergency.vo.enums;

public final class EDWhiteBoardDynGrdComboValues extends ims.framework.utils.Enum
{
	public final static EDWhiteBoardDynGrdComboValues REQUIRED = new EDWhiteBoardDynGrdComboValues(0, "Required", new ims.framework.utils.ImagePath(102250, "Images/Core/CriticalError.gif"), ims.framework.utils.Color.Default);
	public final static EDWhiteBoardDynGrdComboValues COMPLETE = new EDWhiteBoardDynGrdComboValues(1, "Complete", new ims.framework.utils.ImagePath(111150, "Images/Correspondence/new_patient_document.png"), ims.framework.utils.Color.Default);
	public final static EDWhiteBoardDynGrdComboValues NOT_REQUIRED = new EDWhiteBoardDynGrdComboValues(2, "Not Required", new ims.framework.utils.ImagePath(111104, "Images/Correspondence/cancel.gif"), ims.framework.utils.Color.Default);

	private EDWhiteBoardDynGrdComboValues(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
