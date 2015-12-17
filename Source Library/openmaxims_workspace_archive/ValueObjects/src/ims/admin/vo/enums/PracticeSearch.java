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

package ims.admin.vo.enums;

public final class PracticeSearch extends ims.framework.utils.Enum
{
	public final static PracticeSearch SEARCH = new PracticeSearch(0, "Search", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch CLEAR = new PracticeSearch(1, "Clear", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch SELECT = new PracticeSearch(2, "Select", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch NEWPRACTICE = new PracticeSearch(3, "New Practice", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch EDITPRACTICE = new PracticeSearch(4, "Edit Practice", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch REMOVEPRACTICE = new PracticeSearch(5, "Remove Practice", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch NEWSURGERY = new PracticeSearch(6, "New Surgery", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch EDITSURGERY = new PracticeSearch(7, "Edit Surgery", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch REMOVESURGERY = new PracticeSearch(8, "Remove Surgery", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch SURGERYREMOVED = new PracticeSearch(9, "Surgery was removed", null, ims.framework.utils.Color.Default);
	public final static PracticeSearch PRACTICEREMOVED = new PracticeSearch(10, "Practice Was Removed", null, ims.framework.utils.Color.Default);

	private PracticeSearch(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
