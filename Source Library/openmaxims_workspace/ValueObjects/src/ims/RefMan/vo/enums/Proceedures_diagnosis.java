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

package ims.RefMan.vo.enums;

public final class Proceedures_diagnosis extends ims.framework.utils.Enum
{
	public final static Proceedures_diagnosis SUSPECTED_GALL_BLADDER_DISEASE = new Proceedures_diagnosis(0, "Suspected gall bladder disease", null, ims.framework.utils.Color.Default);
	public final static Proceedures_diagnosis UPPER_ABDOMINAL_PAIN = new Proceedures_diagnosis(1, "Upper abdominal pain", null, ims.framework.utils.Color.Default);
	public final static Proceedures_diagnosis LOWER_ABDOMINAL_PAIN = new Proceedures_diagnosis(2, "Lower abdominal pain", null, ims.framework.utils.Color.Default);
	public final static Proceedures_diagnosis KNOWN_RHEUMATOID = new Proceedures_diagnosis(3, "Known Rheumatoid", null, ims.framework.utils.Color.Default);
	public final static Proceedures_diagnosis PREVIOUS_TRAUMA = new Proceedures_diagnosis(4, "Previous Trauma", null, ims.framework.utils.Color.Default);

	private Proceedures_diagnosis(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
