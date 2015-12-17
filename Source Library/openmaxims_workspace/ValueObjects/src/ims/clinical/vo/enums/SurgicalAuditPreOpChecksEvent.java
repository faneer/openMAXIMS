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

package ims.clinical.vo.enums;

public final class SurgicalAuditPreOpChecksEvent extends ims.framework.utils.Enum
{
	public final static SurgicalAuditPreOpChecksEvent SAVE = new SurgicalAuditPreOpChecksEvent(0, "SAVE", null, ims.framework.utils.Color.Default);
	public final static SurgicalAuditPreOpChecksEvent CANCEL = new SurgicalAuditPreOpChecksEvent(1, "CANCEL", null, ims.framework.utils.Color.Default);
	public final static SurgicalAuditPreOpChecksEvent NEW = new SurgicalAuditPreOpChecksEvent(2, "NEW", null, ims.framework.utils.Color.Default);
	public final static SurgicalAuditPreOpChecksEvent EDIT = new SurgicalAuditPreOpChecksEvent(3, "EDIT", null, ims.framework.utils.Color.Default);
	public final static SurgicalAuditPreOpChecksEvent CONFIRMPATIENTDETAILS_NO = new SurgicalAuditPreOpChecksEvent(4, "Confirm_Patient_Details_No", null, ims.framework.utils.Color.Default);
	public final static SurgicalAuditPreOpChecksEvent CANCELOPERATION = new SurgicalAuditPreOpChecksEvent(5, "CancelOperation", null, ims.framework.utils.Color.Default);
	public final static SurgicalAuditPreOpChecksEvent CONFIRM_PATIENT_DETAILS_YES = new SurgicalAuditPreOpChecksEvent(6, "Confirm_Patient_Details_Yes", null, ims.framework.utils.Color.Default);

	private SurgicalAuditPreOpChecksEvent(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
