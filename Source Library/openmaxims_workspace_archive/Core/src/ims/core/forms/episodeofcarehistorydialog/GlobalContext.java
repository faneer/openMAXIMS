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

package ims.core.forms.episodeofcarehistorydialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getEpisodeOfCareWithHistoryIsNotNull()
		{
			return !cx_ClinicalEpisodeOfCareWithHistory.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeOfCareSmallVo getEpisodeOfCareWithHistory()
		{
			return (ims.core.vo.EpisodeOfCareSmallVo)cx_ClinicalEpisodeOfCareWithHistory.getValue(context);
		}
		public void setEpisodeOfCareWithHistory(ims.core.vo.EpisodeOfCareSmallVo value)
		{
			cx_ClinicalEpisodeOfCareWithHistory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalEpisodeOfCareWithHistory = new ims.framework.ContextVariable("Clinical.EpisodeOfCareWithHistory", "_cv_Clinical.EpisodeOfCareWithHistory");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
}
