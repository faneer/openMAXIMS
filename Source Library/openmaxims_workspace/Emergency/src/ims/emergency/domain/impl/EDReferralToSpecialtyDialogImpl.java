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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.lookups.PatIdType;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupInstance;
import ims.emergency.domain.EDPartialAdmissionDialog;
import ims.emergency.domain.base.impl.BaseEDReferralToSpecialtyDialogImpl;
import ims.emergency.domain.objects.EDPartialAdmission;
import ims.emergency.domain.objects.ReferralToSpecTeam;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.EDPartialAdmissionVo;
import ims.emergency.vo.ReferToSpecialtyConfigVo;
import ims.emergency.vo.ReferToSpecialtyConfigVoCollection;
import ims.emergency.vo.ReferralToSpecTeamRefVo;
import ims.emergency.vo.ReferralToSpecialtyTeamVo;
import ims.emergency.vo.ReferralToSpecialtyTeamVoCollection;
import ims.emergency.vo.TrackingForReferalToSpecialtyVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.TrackingWithPartialAdmissionVo;
import ims.emergency.vo.domain.EDPartialAdmissionVoAssembler;
import ims.emergency.vo.domain.EmergencyAttendanceForTrackingVoAssembler;
import ims.emergency.vo.domain.ReferToSpecialtyConfigVoAssembler;
import ims.emergency.vo.domain.ReferralToSpecialtyTeamVoAssembler;
import ims.emergency.vo.domain.TrackingForReferalToSpecialtyVoAssembler;
import ims.emergency.vo.domain.TrackingWithPartialAdmissionVoAssembler;
import ims.emergency.vo.lookups.AllocationStatus;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.ocrr.vo.lookups.Category;

import java.util.ArrayList;
import java.util.List;

public class EDReferralToSpecialtyDialogImpl extends BaseEDReferralToSpecialtyDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ReferralToSpecialtyTeamVo getReferralToSpecialty(ReferralToSpecTeamRefVo referralToSpecialtyRef)
	{
		DomainFactory factory = getDomainFactory();

		if (referralToSpecialtyRef == null || referralToSpecialtyRef.getID_ReferralToSpecTeam()==null)
		{
			throw new CodingRuntimeException("Cannot get ReferralsToSpec on null Id ");
		}

		StringBuffer hql = new StringBuffer();

		hql.append(" select Referral from ReferralToSpecTeam as Referral where Referral.id = :referralID");

		List<?> list = factory.find(hql.toString(), new String[] { "referralID" }, new Object[] { referralToSpecialtyRef.getID_ReferralToSpecTeam() });

		if (list != null && list.size() > 0)
			return ReferralToSpecialtyTeamVoAssembler.createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(list).get(0);

		return null;
	}

	public ReferralToSpecialtyTeamVoCollection getAllReferralsToSpec(Integer careContextID)
	{
		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		if (careContextID == null)
		{
			throw new CodingRuntimeException("Cannot get ReferralsToSpec on null Id ");
		}
		StringBuffer hql = new StringBuffer();

		hql.append(" select Referral from ReferralToSpecTeam as Referral left join Referral.attendance as contextID where contextID.id = :contextID order by Referral.systemInformation.creationDateTime desc"); //WDEV-17411
		markers.add("contextID");
		values.add(careContextID);

		return ReferralToSpecialtyTeamVoAssembler.createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(factory.find(hql.toString(), markers, values));
	}

	public Boolean isNewEnabled(Integer careContextID)
	{
		DomainFactory factory = getDomainFactory();

		if (careContextID == null)
		{
			throw new CodingRuntimeException("Cannot get ReferralsToSpec on null Id ");
		}

		StringBuffer hql = new StringBuffer();

		hql.append(" select count(Referral.id) from ReferralToSpecTeam as Referral left join Referral.attendance as contextID where contextID.id = :careContextID and Referral.completionDateTime is null ");

		Object[] count = factory.find(hql.toString(), new String[] { "careContextID" }, new Object[] { careContextID }).toArray();

		if (count != null && count.length > 0)
			if (((Long) count[0]).intValue() == 0)
				return true;

		return false;
	}

	public TrackingForReferalToSpecialtyVo getTrackingForReferral(TrackingRefVo trackingRef)
	{
		if (trackingRef == null || trackingRef.getID_Tracking() == null)
		{
			throw new CodingRuntimeException("Cannot get TrackingAreaRefVo on null Id for Tracking ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select tracking from Tracking as tracking where tracking.id = :trackingID ");

		List<?> list = factory.find(hql.toString(), new String[] { "trackingID" }, new Object[] { trackingRef.getID_Tracking() });
	
		if (list!=null && list.size()>0)
		{
			return TrackingForReferalToSpecialtyVoAssembler.create((Tracking) list.get(0));
		}

		return null;

	}

	public DateTime getAttendanceRegistrationDateTime(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get AllocatedMedicVoCollection on null Id for CareContext ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select att from EmergencyAttendance as att where att.careContext.id = :careContextID ");

		List<?> list = factory.find(hql.toString(), new String[] { "careContextID" }, new Object[] { careContextRef.getID_CareContext() });

		return EmergencyAttendanceForTrackingVoAssembler.createEmergencyAttendanceForTrackingVoCollectionFromEmergencyAttendance(list).get(0).getRegistrationDateTime();
	}

	public ReferralToSpecialtyTeamVo save(ReferralToSpecialtyTeamVo referralToSpecialty, TrackingForReferalToSpecialtyVo trackingToSave, ReferralToSpecialtyTeamVo referralToSpecialtyMustSavedAsCompleted) throws StaleObjectException
	{
		if (referralToSpecialty == null && trackingToSave == null)
			throw new CodingRuntimeException("Cannot save null ReferralToSpecialtyTeamVo or TrackingForReferalToSpecialtyVo ");

		DomainFactory factory = getDomainFactory();

		if (referralToSpecialtyMustSavedAsCompleted!=null)
		{
			ReferralToSpecTeam domainReferralToSpecMustSavedAsCompleted = ReferralToSpecialtyTeamVoAssembler.extractReferralToSpecTeam(factory, referralToSpecialtyMustSavedAsCompleted);
			factory.save(domainReferralToSpecMustSavedAsCompleted);
		}
		
		if (referralToSpecialty != null && trackingToSave == null)
		{
			if (!referralToSpecialty.isValidated())
				throw new DomainRuntimeException("ReferralToSpecialtyTeamVo Not Validated.");

			ReferralToSpecTeam domainReferralToSave = ReferralToSpecialtyTeamVoAssembler.extractReferralToSpecTeam(factory, referralToSpecialty);
			factory.save(domainReferralToSave);

			return ReferralToSpecialtyTeamVoAssembler.create(domainReferralToSave);
		}
		else if (referralToSpecialty == null && trackingToSave != null)
		{
			if (!trackingToSave.isValidated())
				throw new DomainRuntimeException("TrackingForReferalToSpecialtyVo Not Validated.");

			Tracking domainTrackingforReferral = TrackingForReferalToSpecialtyVoAssembler.extractTracking(factory, trackingToSave);
			factory.save(domainTrackingforReferral);

			TrackingForReferalToSpecialtyVo track = TrackingForReferalToSpecialtyVoAssembler.create(domainTrackingforReferral);

			if (track != null)
				return track.getCurrentReferral();
		}
		else if (referralToSpecialty != null && trackingToSave != null)
		{
			if (!referralToSpecialty.isValidated())
				throw new DomainRuntimeException("TrackingForReferalToSpecialtyVo Not Validated.");

			if (!trackingToSave.isValidated())
				throw new DomainRuntimeException("TrackingForAllocatedMedicVo Not Validated.");

			Tracking domainTrackingforReferral = TrackingForReferalToSpecialtyVoAssembler.extractTracking(factory, trackingToSave);
			factory.save(domainTrackingforReferral);

			ReferralToSpecTeam domainReferralToSave = ReferralToSpecialtyTeamVoAssembler.extractReferralToSpecTeam(factory, referralToSpecialty);
			factory.save(domainReferralToSave);

			return ReferralToSpecialtyTeamVoAssembler.create(domainReferralToSave);
		}

		return null;

	}

	public Boolean isStale(ReferralToSpecialtyTeamVo referralToSave)
	{
		if (referralToSave == null || referralToSave.getID_ReferralToSpecTeam() == null)
		{
			throw new CodingRuntimeException("Cannot get ReferralToSpecialtyTeamVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		ReferralToSpecTeam domainReferralToSave = (ReferralToSpecTeam) factory.getDomainObject(ReferralToSpecTeam.class, referralToSave.getID_ReferralToSpecTeam());

		if (domainReferralToSave == null)
		{
			return true;
		}

		if (domainReferralToSave.getVersion() > referralToSave.getVersion_ReferralToSpecTeam())
		{
			return true;
		}

		return false;
	}


	public Boolean isLastEntry(CareContextRefVo careContext, ReferralToSpecialtyTeamVo referralToSpecialty)
	{
		if (careContext == null || careContext.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get check if ReferralToSpecialty is the last one without a valid CareContext record.");
		}
		
		String query = "SELECT COUNT (referral.id) FROM ReferralToSpecTeam AS referral LEFT JOIN referral.attendance AS context WHERE referral.systemInformation.creationDateTime >= :DATE_TO_CHECK AND referral.id <> :REFFERRAL_ID AND context.id = :CONTEXT_ID";
		
		long records = getDomainFactory().countWithHQL(query, new String[] {"DATE_TO_CHECK", "REFFERRAL_ID", "CONTEXT_ID"}, new Object[] {referralToSpecialty.getSystemInformation().getCreationDateTime().getJavaDate(), referralToSpecialty.getID_ReferralToSpecTeam(), careContext.getID_CareContext()} );
		
		if (records > 0)
			return false;
		
		return true;
	}

	public ReferralToSpecialtyTeamVo getUncompletedReferralToSpecialtyByCareContext(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get SeenByHCPVoCollection on null Id for CareContext ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select allRefSpecTeam from ReferralToSpecTeam as allRefSpecTeam where allRefSpecTeam.attendance.id = :attID and allRefSpecTeam.completionDateTime is null and ( allRefSpecTeam.notAccepted is null or allRefSpecTeam.notAccepted = 0) order by allRefSpecTeam.referredDateTime desc ");

		List<?> list = factory.find(hql.toString(), new String[] { "attID" }, new Object[] { careContextRef.getID_CareContext() });

		if (list!=null && list.size()>0)
			return ReferralToSpecialtyTeamVoAssembler.create((ReferralToSpecTeam)list.get(0));
		
		return null;
	}

	//WDEV-17641
	public SpecialtyCollection listSpecialties()
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select lookInst from Lookup as look left join look.instances as lookInst left join lookInst.mappings as mappings where (look.id = 621 and mappings.extSystem = 'MAXIMS' and mappings.extCode like 'EDREFER%' and lookInst.active = 1)");

		List<?> list = factory.find(hql.toString());

		if (list!=null && list.size()>0)
		{
			SpecialtyCollection coll = new SpecialtyCollection();
			
			for (int i=0;i<list.size();i++)
			{
				LookupInstance doLookInst=(LookupInstance)list.get(i);
				ims.core.vo.lookups.Specialty voLookup = new ims.core.vo.lookups.Specialty(doLookInst.getId(),doLookInst.getText(),doLookInst.isActive(),null,doLookInst.getImage(),doLookInst.getColor());	
				coll.add(voLookup);
			}
			
			return coll;
		}
		
		return null;
	}

	//WDEV-19006 
	public TrackingWithPartialAdmissionVo getTrackingWithEDPartialAdmission(TrackingRefVo trackingRef)
	{
		if(trackingRef == null || trackingRef.getID_Tracking() == null)
			throw new CodingRuntimeException("Cannot get Tracking record on null Tracking Id.");
		
		DomainFactory factory = getDomainFactory();
		Tracking doTracking = (Tracking) factory.getDomainObject(Tracking.class, trackingRef.getID_Tracking());
		
		return TrackingWithPartialAdmissionVoAssembler.create(doTracking);
	}

	//WDEV-19006 
	public EDPartialAdmissionVo cancelCurrentPartialAdmission(EDPartialAdmissionVo edPartialAdmissionVo, TrackingForReferalToSpecialtyVo trackingRecord) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		if( edPartialAdmissionVo != null )
		{
			edPartialAdmissionVo.setAllocatedStatus(AllocationStatus.CANCELLED_ADMISSION);
			EDPartialAdmission  doEDPartialAdmission = EDPartialAdmissionVoAssembler.extractEDPartialAdmission(factory, edPartialAdmissionVo);
			factory.save(doEDPartialAdmission);
	
			if (trackingRecord != null)
			{
				Tracking dotrackingRecord = TrackingForReferalToSpecialtyVoAssembler.extractTracking(factory, trackingRecord);
				dotrackingRecord.setBedAvailability(null);
				dotrackingRecord.setCurrentPartialAdmission(null);
				factory.save(dotrackingRecord);
				
				EDPartialAdmissionDialog dom = (EDPartialAdmissionDialog) getDomainImpl(EDPartialAdmissionDialogImpl.class);
				try
				{
					dom.triggerCancelPartialAdmission(trackingRecord.getAttendance(), edPartialAdmissionVo);
				}
				catch (DomainInterfaceException e)
				{
					e.printStackTrace();
				}
			}
			
			return EDPartialAdmissionVoAssembler.create(doEDPartialAdmission);
		}
		return null;
	}

	//wdev-22313
	public ReferToSpecialtyConfigVo getReferToSpecialtyConfigVo()
	{
		DomainFactory factory = getDomainFactory();
		List<?> refertospec =  factory.find("select r1_1 from ReferToSpecialtyConfig as r1_1 where (r1_1.isRIE = 0 or r1_1.isRIE is null ) ");
		
		if( refertospec != null && refertospec.size() > 0 )
		{
			ReferToSpecialtyConfigVoCollection tempColl = ReferToSpecialtyConfigVoAssembler.createReferToSpecialtyConfigVoCollectionFromReferToSpecialtyConfig(refertospec);
			if( tempColl != null && tempColl.size() > 0 )
				return tempColl.get(0);
		}
		
		
		return null;
	}

	//WDEV-23527
	public PatIdType getPrimaryIDFromProviderSystem(Category category)
	{
		ims.emergency.domain.Tracking impl = (ims.emergency.domain.Tracking )getDomainImpl(TrackingImpl.class);
		return impl.getPrimaryIDFromProviderSystem(category);
	}

}
