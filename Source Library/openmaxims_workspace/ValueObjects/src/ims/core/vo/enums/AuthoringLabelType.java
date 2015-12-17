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

package ims.core.vo.enums;

public final class AuthoringLabelType extends ims.framework.utils.Enum
{
	public final static AuthoringLabelType AUTHORING = new AuthoringLabelType(0, "Authoring", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType CONFIRMED = new AuthoringLabelType(1, "Confirmed", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType CONFIRMING = new AuthoringLabelType(2, "Confirming", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType INSERTED = new AuthoringLabelType(3, "Inserted", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType RECORDING = new AuthoringLabelType(4, "Recording", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType REMOVAL = new AuthoringLabelType(5, "Removal", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType RESOLVING = new AuthoringLabelType(6, "Resolving", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType REVIEWING = new AuthoringLabelType(7, "Reviewing", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType START = new AuthoringLabelType(8, "Start", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType COMPLETING_COMPLETED = new AuthoringLabelType(9, "Completing HCP, Completed Date/Time", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType SCANNED = new AuthoringLabelType(10, "Scanned", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType IMPORTED = new AuthoringLabelType(11, "Imported", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType CHANGING = new AuthoringLabelType(12, "Changing", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType INITIALLY = new AuthoringLabelType(13, "Initially", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType LAST = new AuthoringLabelType(14, "Last", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType DISCHARGING = new AuthoringLabelType(15, "Discharging", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType PRESCRIBING = new AuthoringLabelType(16, "Prescribing", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType THEATRENURSE = new AuthoringLabelType(17, "Theatre Nurse", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType AUTHORED = new AuthoringLabelType(18, "Authored", null, ims.framework.utils.Color.Default);
	public final static AuthoringLabelType AUTHORISING = new AuthoringLabelType(19, "Authorising", null, ims.framework.utils.Color.Default);

	private AuthoringLabelType(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
