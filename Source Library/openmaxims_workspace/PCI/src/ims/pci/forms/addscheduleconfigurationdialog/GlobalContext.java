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

package ims.pci.forms.addscheduleconfigurationdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		PCI = new PCIContext(context);
		Core = new CoreContext(context);
	}
	public final class PCIContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PCIContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getClientAddScheduleIsNotNull()
		{
			return !cx_PCIClientAddSchedule.getValueIsNull(context);
		}
		public ims.pci.vo.ScheduleConfigurationVo getClientAddSchedule()
		{
			return (ims.pci.vo.ScheduleConfigurationVo)cx_PCIClientAddSchedule.getValue(context);
		}
		public void setClientAddSchedule(ims.pci.vo.ScheduleConfigurationVo value)
		{
			cx_PCIClientAddSchedule.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCIClientAddSchedule = new ims.framework.ContextVariable("PCI.ClientAddSchedule", "_cv_PCI.ClientAddSchedule");
		public boolean getClientSchedulesIsNotNull()
		{
			return !cx_PCIClientSchedules.getValueIsNull(context);
		}
		public ims.pci.vo.ScheduleConfigurationRefVoCollection getClientSchedules()
		{
			return (ims.pci.vo.ScheduleConfigurationRefVoCollection)cx_PCIClientSchedules.getValue(context);
		}
		public void setClientSchedules(ims.pci.vo.ScheduleConfigurationRefVoCollection value)
		{
			cx_PCIClientSchedules.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCIClientSchedules = new ims.framework.ContextVariable("PCI.ClientSchedules", "_cv_PCI.ClientSchedules");
		public boolean getClientImmunisationScheduleIsNotNull()
		{
			return !cx_PCIClientImmunisationSchedule.getValueIsNull(context);
		}
		public ims.pci.vo.ClientImmunisationScheduleVo getClientImmunisationSchedule()
		{
			return (ims.pci.vo.ClientImmunisationScheduleVo)cx_PCIClientImmunisationSchedule.getValue(context);
		}
		public void setClientImmunisationSchedule(ims.pci.vo.ClientImmunisationScheduleVo value)
		{
			cx_PCIClientImmunisationSchedule.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PCIClientImmunisationSchedule = new ims.framework.ContextVariable("PCI.ClientImmunisationSchedule", "_cv_PCI.ClientImmunisationSchedule");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}

	public PCIContext PCI;
	public CoreContext Core;
}
