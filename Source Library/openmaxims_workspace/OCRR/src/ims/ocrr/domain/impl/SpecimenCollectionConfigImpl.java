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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.45 build 2259.24726)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import java.util.List;

import ims.core.configuration.domain.objects.PublicHolidays;
import ims.core.vo.PublicHolidaysVo;
import ims.core.vo.PublicHolidaysVoCollection;
import ims.core.vo.domain.PublicHolidaysVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.ocrr.configuration.domain.objects.SpecimenCollectionListConfig;
import ims.ocrr.domain.base.impl.BaseSpecimenCollectionConfigImpl;
import ims.ocrr.vo.SpecimenCollectionListConfigDetailsVoCollection;
import ims.ocrr.vo.SpecimenCollectionListConfigVo;
import ims.ocrr.vo.SpecimenCollectionListConfigVoCollection;
import ims.ocrr.vo.domain.SpecimenCollectionListConfigDetailsVoAssembler;
import ims.ocrr.vo.domain.SpecimenCollectionListConfigVoAssembler;
import ims.ocrr.vo.lookups.DayOfWeek;
import ims.ocrr.vo.lookups.SpecimenCollectionMethod;

public class SpecimenCollectionConfigImpl extends BaseSpecimenCollectionConfigImpl
{
	private static final long serialVersionUID = 1L;

	public PublicHolidaysVoCollection getPublicHolidays() 
	{
		DomainFactory factory = getDomainFactory();
		List exceptionDates = factory.find("from PublicHolidays as ph order by ph.date asc ");//	WDEV-15083
		if(exceptionDates != null && exceptionDates.size() > 0)
			return PublicHolidaysVoAssembler.createPublicHolidaysVoCollectionFromPublicHolidays(exceptionDates); 
			
		return null;
	}

	public SpecimenCollectionListConfigVo saveSpecimenCollectionConfig(SpecimenCollectionListConfigVo specimenCollectionConfig) throws StaleObjectException 
	{
		if(specimenCollectionConfig == null)
			throw new CodingRuntimeException("specimenCollectionConfig parameter is null - method saveSpecimenCollectionConfig");
			
		if(!specimenCollectionConfig.isValidated())
			throw new DomainRuntimeException("SpecimenCollectionListConfigVo has not been validated");
		
		DomainFactory factory = getDomainFactory();
		SpecimenCollectionListConfig domSpecimenCollectionListConfig = SpecimenCollectionListConfigVoAssembler.extractSpecimenCollectionListConfig(factory, specimenCollectionConfig);
		factory.save(domSpecimenCollectionListConfig);

		return SpecimenCollectionListConfigVoAssembler.create(domSpecimenCollectionListConfig);		
	}

	public SpecimenCollectionListConfigVo getSpecimenCollectionConfig(SpecimenCollectionMethod lookUpId) 
	{
		if(lookUpId == null)
			throw new DomainRuntimeException("Id has not been provided for get call. ");
		
		DomainFactory factory = getDomainFactory();
		
		List listSpecCollectionList = factory.find("from SpecimenCollectionListConfig sclc where sclc.listType = :ltype",new String[]{"ltype"},new Object[]{getDomLookup(lookUpId)});		
		if(listSpecCollectionList != null && listSpecCollectionList.size() > 0)
		{ 
			SpecimenCollectionListConfigVoCollection voCollSpecimen = SpecimenCollectionListConfigVoAssembler.createSpecimenCollectionListConfigVoCollectionFromSpecimenCollectionListConfig(listSpecCollectionList);
			if(voCollSpecimen != null && voCollSpecimen.size() > 0)
				return voCollSpecimen.get(0);
		}
		return null;
	}

	public PublicHolidaysVo savePublicHolidays(PublicHolidaysVo voPublicHolidays) throws StaleObjectException 
	{
		//Ensure the value object has been validated
		if (!voPublicHolidays.isValidated())
			throw new DomainRuntimeException("Public Holidays has not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		PublicHolidays domPublicHolidays = PublicHolidaysVoAssembler.extractPublicHolidays(factory, voPublicHolidays);
		factory.save(domPublicHolidays);
		
		return PublicHolidaysVoAssembler.create(domPublicHolidays);
	}

	public SpecimenCollectionListConfigDetailsVoCollection listSpecimenCollectionDetails(SpecimenCollectionMethod type, Date date)
	{
		if(type == null || date == null)
			throw new CodingRuntimeException("Coding Error = type or date is null (listSpecimenCollectionDetails) ");
	
		DayOfWeek dayInst = getDayOfWeek(date);
			
		DomainFactory factory = getDomainFactory();
		List cfgSpecs =  factory.find("from SpecimenCollectionListConfigDetails detail where detail.dayOfWeek = :dayOfWeekInst and id in (select header.detail.id from SpecimenCollectionListConfig header where header.listType = :listType)", new String[]{"dayOfWeekInst","listType"}, new Object[] { getDomLookup(dayInst),getDomLookup(type)});
		SpecimenCollectionListConfigDetailsVoCollection voCollSpecimenListConfigDetail = null;
		if(cfgSpecs != null && cfgSpecs.size() > 0)
			voCollSpecimenListConfigDetail = SpecimenCollectionListConfigDetailsVoAssembler.createSpecimenCollectionListConfigDetailsVoCollectionFromSpecimenCollectionListConfigDetails(cfgSpecs);
		
		return voCollSpecimenListConfigDetail;	
	}

	private DayOfWeek getDayOfWeek(Date date)
	{
		if(date == null)
			throw new CodingRuntimeException("Coding Error = date is null (getDayOfWeek) ");
		
		DomainFactory factory = getDomainFactory();
		List hols = factory.find("from PublicHolidays hol where hol.date = :date", new String[]{"date"}, new Object[] {date.getDate()});
		if(hols != null && hols.size() > 0)
			return DayOfWeek.PUBLICHOLIDAY;
			
		DayOfWeek inst = null;
		ims.framework.utils.DayOfWeek day = date.getDayOfWeek();
		
		if(day.equals(ims.framework.utils.DayOfWeek.MONDAY))
			inst = DayOfWeek.MONDAY;
		else if(day.equals(ims.framework.utils.DayOfWeek.TUESDAY))
			inst = DayOfWeek.TUESDAY;
		else if(day.equals(ims.framework.utils.DayOfWeek.WEDNESDAY))
			inst = DayOfWeek.WEDNESDAY;
		else if(day.equals(ims.framework.utils.DayOfWeek.THURSDAY))
			inst = DayOfWeek.THURSDAY;
		else if(day.equals(ims.framework.utils.DayOfWeek.FRIDAY))
			inst = DayOfWeek.FRIDAY;
		else if(day.equals(ims.framework.utils.DayOfWeek.SATURDAY))
			inst = DayOfWeek.SATURDAY;
		else if(day.equals(ims.framework.utils.DayOfWeek.SUNDAY))
			inst = DayOfWeek.SUNDAY;
		
		return inst;
	}
}
