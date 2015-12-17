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

package ims.emergency.domain;

// Generated from form domain impl
public interface AllocateCubicle extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.emergency.vo.CubicleAllocationShortVoCollection listCubicleAllocationShortVo(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.CubicleAllocationVo getCubicleAllocation(ims.emergency.vo.CubicleAllocationRefVo cubicleRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.CubicleAllocationVo saveCubicleAllocation(ims.emergency.vo.CubicleAllocationVo record, ims.emergency.vo.TrackingForAllocateCubicleVo tracking) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingForAllocateCubicleVo getTracking(ims.emergency.vo.TrackingRefVo trackingRef);

	// Generated from form domain interface definition
	public ims.framework.utils.DateTime getAttendanceRegistrationDateTime(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingAreaCubiclesVo getTrackingAreaCubicles(ims.emergency.configuration.vo.TrackingAreaRefVo trackingAreaRef);

	// Generated from form domain interface definition
	public Boolean isAllocateCubicleForCurrentTrackingArea(ims.emergency.configuration.vo.TrackingAreaRefVo trackingAreaRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingLiteVo getTrackingLiteVo(ims.emergency.vo.TrackingRefVo trackingRef);
}
