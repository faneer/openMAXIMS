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

package ims.ocrr.forms.alternativecontainerdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAlternativeAdultContainerIsNotNull()
		{
			return !cx_OCRRAlternativeAdultContainer.getValueIsNull(context);
		}
		public ims.ocrr.vo.AlternativeAdultContainerVo getAlternativeAdultContainer()
		{
			return (ims.ocrr.vo.AlternativeAdultContainerVo)cx_OCRRAlternativeAdultContainer.getValue(context);
		}
		public void setAlternativeAdultContainer(ims.ocrr.vo.AlternativeAdultContainerVo value)
		{
			cx_OCRRAlternativeAdultContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRAlternativeAdultContainer = new ims.framework.ContextVariable("OCRR.AlternativeAdultContainer", "_cv_OCRR.AlternativeAdultContainer");
		public boolean getAlternativePaedContainerIsNotNull()
		{
			return !cx_OCRRAlternativePaedContainer.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenContainerVo getAlternativePaedContainer()
		{
			return (ims.ocrr.vo.SpecimenContainerVo)cx_OCRRAlternativePaedContainer.getValue(context);
		}
		public void setAlternativePaedContainer(ims.ocrr.vo.SpecimenContainerVo value)
		{
			cx_OCRRAlternativePaedContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRAlternativePaedContainer = new ims.framework.ContextVariable("OCRR.AlternativePaedContainer", "_cv_OCRR.AlternativePaedContainer");
		public boolean getAdultSpecimenContainerIsNotNull()
		{
			return !cx_OCRRAdultSpecimenContainer.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenContainerVo getAdultSpecimenContainer()
		{
			return (ims.ocrr.vo.SpecimenContainerVo)cx_OCRRAdultSpecimenContainer.getValue(context);
		}
		public void setAdultSpecimenContainer(ims.ocrr.vo.SpecimenContainerVo value)
		{
			cx_OCRRAdultSpecimenContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRAdultSpecimenContainer = new ims.framework.ContextVariable("OCRR.AdultSpecimenContainer", "_cv_OCRR.AdultSpecimenContainer");
		public boolean getPaediatricsContainerIsNotNull()
		{
			return !cx_OCRRPaediatricsContainer.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenContainerVo getPaediatricsContainer()
		{
			return (ims.ocrr.vo.SpecimenContainerVo)cx_OCRRPaediatricsContainer.getValue(context);
		}
		public void setPaediatricsContainer(ims.ocrr.vo.SpecimenContainerVo value)
		{
			cx_OCRRPaediatricsContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRPaediatricsContainer = new ims.framework.ContextVariable("OCRR.PaediatricsContainer", "_cv_OCRR.PaediatricsContainer");
		public boolean getAlternativePaediatricsContainerIsNotNull()
		{
			return !cx_OCRRAlternativePaediatricsContainer.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenContainerVo getAlternativePaediatricsContainer()
		{
			return (ims.ocrr.vo.SpecimenContainerVo)cx_OCRRAlternativePaediatricsContainer.getValue(context);
		}
		public void setAlternativePaediatricsContainer(ims.ocrr.vo.SpecimenContainerVo value)
		{
			cx_OCRRAlternativePaediatricsContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRAlternativePaediatricsContainer = new ims.framework.ContextVariable("OCRR.AlternativePaediatricsContainer", "_cv_OCRR.AlternativePaediatricsContainer");
		public boolean getSpecimenContainersIsNotNull()
		{
			return !cx_OCRRSpecimenContainers.getValueIsNull(context);
		}
		public ims.ocrr.vo.PathSpecimenContainerDetailVoCollection getSpecimenContainers()
		{
			return (ims.ocrr.vo.PathSpecimenContainerDetailVoCollection)cx_OCRRSpecimenContainers.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRRSpecimenContainers = new ims.framework.ContextVariable("OCRR.SpecimenContainers", "_cv_OCRR.SpecimenContainers");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
}
