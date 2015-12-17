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

public final class InternalReferralsGridColumns extends ims.framework.utils.Enum
{
	public final static InternalReferralsGridColumns COL_URGENT = new InternalReferralsGridColumns(0, "Urgent", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_REFERRAL_DATE = new InternalReferralsGridColumns(1, "Referral Date", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_IP_OR_OP = new InternalReferralsGridColumns(2, "I/P or O/P", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_WARD = new InternalReferralsGridColumns(3, "Current Ward", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_NHS = new InternalReferralsGridColumns(4, "NHS No.", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_SURNAME = new InternalReferralsGridColumns(5, "Surname", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_FORENAME = new InternalReferralsGridColumns(6, "Forename", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_DOB = new InternalReferralsGridColumns(7, "DOB", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_REFERRING_HCP = new InternalReferralsGridColumns(8, "Referring HCP", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_SERVICE = new InternalReferralsGridColumns(9, "Service", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_REF_TO = new InternalReferralsGridColumns(10, "Ref. To", null, ims.framework.utils.Color.Default);
	public final static InternalReferralsGridColumns COL_STATUS = new InternalReferralsGridColumns(11, "Status", null, ims.framework.utils.Color.Default);

	private InternalReferralsGridColumns(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
