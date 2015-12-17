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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4041.27591)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import java.util.ArrayList;

import ims.clinicaladmin.domain.base.impl.BaseTumourHistologyConfigImpl;
import ims.clinicaladmin.vo.TumourHistologyLiteVoCollection;
import ims.clinicaladmin.vo.TumourHistologyVo;
import ims.clinicaladmin.vo.domain.TumourHistologyLiteVoAssembler;
import ims.clinicaladmin.vo.domain.TumourHistologyVoAssembler;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.oncology.configuration.domain.objects.TumourHistology;
import ims.oncology.configuration.vo.TumourHistologyRefVo;

public class TumourHistologyConfigImpl extends BaseTumourHistologyConfigImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * WDEV-12455
	 * List TumourHistologies records based on the required criteria (for now will list back all records)
	 */
	public TumourHistologyLiteVoCollection listHistologies(TumourHistologyRefVo currentRecord, String description, Boolean activeOnly)
	{
		StringBuilder query = new StringBuilder();
		query.append(" from TumourHistology as histology");
		
		String aux = " where ";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		if (currentRecord != null && currentRecord.getID_TumourHistologyIsNotNull())
		{
			query.append(aux);
			query.append("histology.id = :SELECTED_ID");
			aux = " or ";
			
			paramNames.add("SELECTED_ID");
			paramValues.add(currentRecord.getID_TumourHistology());
		}
		
		if (description != null)
		{
			query.append(aux);
			query.append("UPPER(histology.histologyDescription) like :DESCRIPTION");
			aux = " and ";
			
			paramNames.add("DESCRIPTION");
			paramValues.add("%" + description.toUpperCase() + "%");
		}
		
		if (Boolean.TRUE.equals(activeOnly))
		{
			query.append(aux);
			query.append("histology.isActive = 1");
		}
		else if (activeOnly != null)
		{
			query.append(aux);
			query.append("(histology.isActive = 1 or histology.isActive = 0)");
		}
		
		return TumourHistologyLiteVoAssembler.createTumourHistologyLiteVoCollectionFromTumourHistology(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	/**
	* Function used to return specified TumourHistology record
	*/
	public TumourHistologyVo getHistology(TumourHistologyRefVo histology)
	{
		if (histology == null || !histology.getID_TumourHistologyIsNotNull())
			return null;
		
		return TumourHistologyVoAssembler.create((TumourHistology) getDomainFactory().getDomainObject(TumourHistology.class, histology.getID_TumourHistology()));
	}

	/**
	* Saves a TumourHistology record to database
	*/
	public TumourHistologyVo saveHistology(TumourHistologyVo histology) throws StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException, UnqViolationUncheckedException
	{
		// Check for value to save
		if (histology == null)
			throw new DomainRuntimeException("Domain Error - Can not save a null histology record");
		
		// Check for validated record
		if (!histology.isValidated())
			throw new DomainRuntimeException("Domain Error - Histology record must be validated before save");
		
		// Get domain object
		TumourHistology tumourHistology = TumourHistologyVoAssembler.extractTumourHistology(getDomainFactory(), histology);
		
		// Attempt save
		getDomainFactory().save(tumourHistology);
		
		return TumourHistologyVoAssembler.create(tumourHistology);
	}
}
