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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.43 build 2229.25474)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.util.ArrayList;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.therapies.admin.domain.objects.TreatmentEquipmentConfig;
import ims.therapies.domain.base.impl.BaseTreatmentEquipmentConfigImpl;
import ims.therapies.vo.TreatmentEquipmentConfigVo;
import ims.therapies.vo.TreatmentEquipmentConfigVoCollection;
import ims.therapies.vo.domain.TreatmentEquipmentConfigVoAssembler;
import ims.therapies.vo.lookups.TreatmentEquipmentTypeConfig;

public class TreatmentEquipmentConfigImpl extends BaseTreatmentEquipmentConfigImpl
{

	public TreatmentEquipmentConfigVoCollection list(TreatmentEquipmentTypeConfig lkpTreatmentEquipmentTypeConfig)
	{
		DomainFactory factory = getDomainFactory();				
		
		
		TreatmentEquipmentConfigVoCollection voTreatEquipConfigVoColl = new TreatmentEquipmentConfigVoCollection();
		java.util.List tecList = null;
		if (lkpTreatmentEquipmentTypeConfig == null)
		{
			tecList = factory.listDomainObjects(TreatmentEquipmentConfig.class);
		}
		else
		{
			ArrayList markers = new ArrayList();
			ArrayList values = new ArrayList();
			StringBuffer condStr = new StringBuffer();
			String hql = "from TreatmentEquipmentConfig t where ";
			
			condStr.append(" t.type = :equipmentType");
			markers.add("equipmentType");
			values.add(getDomLookup(lkpTreatmentEquipmentTypeConfig));			
			
			hql += condStr.toString();
			tecList = factory.find(hql, markers, values);
		}
		
		voTreatEquipConfigVoColl = TreatmentEquipmentConfigVoAssembler.createTreatmentEquipmentConfigVoCollectionFromTreatmentEquipmentConfig(tecList);
		
		if(voTreatEquipConfigVoColl.size()>0)
			return voTreatEquipConfigVoColl;
		else
			return null;
	}

	public TreatmentEquipmentConfigVo save(TreatmentEquipmentConfigVo voTreatEquipConfig) throws StaleObjectException
	{
		if(!voTreatEquipConfig.isValidated())
			throw new DomainRuntimeException("This Treatment Equipment Configuration has not been validated");
	
		DomainFactory factory = getDomainFactory();
		TreatmentEquipmentConfig doTreatEquipConfig = TreatmentEquipmentConfigVoAssembler.extractTreatmentEquipmentConfig(factory, voTreatEquipConfig);
		factory.save(doTreatEquipConfig);
		return TreatmentEquipmentConfigVoAssembler.create(doTreatEquipConfig);
	}
}
