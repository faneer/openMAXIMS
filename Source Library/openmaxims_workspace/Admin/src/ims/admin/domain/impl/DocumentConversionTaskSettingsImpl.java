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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.71 build 3937.27059)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseDocumentConversionTaskSettingsImpl;
import ims.admin.vo.domain.DocumentConversionSettingsVoAssembler;
import ims.core.configuration.domain.objects.DocumentConversionSettings;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class DocumentConversionTaskSettingsImpl extends BaseDocumentConversionTaskSettingsImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* getConfiguration
	*/
	public ims.admin.vo.DocumentConversionSettingsVo getConfiguration(ims.admin.vo.ConfiguredJobVo configuredJob)
	{
		if(configuredJob == null)
			throw new CodingRuntimeException("Invalid job");
		DomainFactory factory = getDomainFactory();
		DocumentConversionSettings bo = DocumentConversionSettings.getDocumentConversionSettingsFromConfiguredJob(factory, configuredJob.getBoId());
		return DocumentConversionSettingsVoAssembler.create(bo);
	}

	/**
	* saveConfiguration
	*/
	public ims.admin.vo.DocumentConversionSettingsVo saveConfiguration(ims.admin.vo.DocumentConversionSettingsVo configuration) throws ims.domain.exceptions.StaleObjectException
	{
		if(configuration == null)
			throw new CodingRuntimeException("Invalid configuration");
		if(!configuration.isValidated())
			throw new CodingRuntimeException("Configuration not validated");
		DomainFactory factory = getDomainFactory();
		DocumentConversionSettings bo = DocumentConversionSettingsVoAssembler.extractDocumentConversionSettings(factory, configuration);
		getDomainFactory().save(bo);
		return DocumentConversionSettingsVoAssembler.create(bo); 
	}
}
