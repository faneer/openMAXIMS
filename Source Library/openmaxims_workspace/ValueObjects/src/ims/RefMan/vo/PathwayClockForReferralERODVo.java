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

package ims.RefMan.vo;

/**
 * Linked to Pathways.PathwayClock business object (ID: 1088100005).
 */
public class PathwayClockForReferralERODVo extends ims.pathways.vo.PathwayClockRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathwayClockForReferralERODVo()
	{
	}
	public PathwayClockForReferralERODVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathwayClockForReferralERODVo(ims.RefMan.vo.beans.PathwayClockForReferralERODVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		if(bean.getPauseDetails() != null)
		{
			this.pausedetails = new ims.pathways.vo.PauseDetailsRefVoCollection();
			for(int pausedetails_i = 0; pausedetails_i < bean.getPauseDetails().length; pausedetails_i++)
			{
				this.pausedetails.add(new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getPauseDetails()[pausedetails_i].getId()), bean.getPauseDetails()[pausedetails_i].getVersion()));
			}
		}
		this.currentpause = bean.getCurrentPause() == null ? null : new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getCurrentPause().getId()), bean.getCurrentPause().getVersion());
		this.stopdate = bean.getStopDate() == null ? null : bean.getStopDate().buildDate();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo();
		this.rttstatushistory = ims.pathways.vo.PathwayRTTStatusLiteVoCollection.buildFromBeanCollection(bean.getRTTStatusHistory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PathwayClockForReferralERODVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		if(bean.getPauseDetails() != null)
		{
			this.pausedetails = new ims.pathways.vo.PauseDetailsRefVoCollection();
			for(int pausedetails_i = 0; pausedetails_i < bean.getPauseDetails().length; pausedetails_i++)
			{
				this.pausedetails.add(new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getPauseDetails()[pausedetails_i].getId()), bean.getPauseDetails()[pausedetails_i].getVersion()));
			}
		}
		this.currentpause = bean.getCurrentPause() == null ? null : new ims.pathways.vo.PauseDetailsRefVo(new Integer(bean.getCurrentPause().getId()), bean.getCurrentPause().getVersion());
		this.stopdate = bean.getStopDate() == null ? null : bean.getStopDate().buildDate();
		this.currentrttstatus = bean.getCurrentRTTStatus() == null ? null : bean.getCurrentRTTStatus().buildVo(map);
		this.rttstatushistory = ims.pathways.vo.PathwayRTTStatusLiteVoCollection.buildFromBeanCollection(bean.getRTTStatusHistory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PathwayClockForReferralERODVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PathwayClockForReferralERODVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PathwayClockForReferralERODVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PAUSEDETAILS"))
			return getPauseDetails();
		if(fieldName.equals("CURRENTPAUSE"))
			return getCurrentPause();
		if(fieldName.equals("STOPDATE"))
			return getStopDate();
		if(fieldName.equals("CURRENTRTTSTATUS"))
			return getCurrentRTTStatus();
		if(fieldName.equals("RTTSTATUSHISTORY"))
			return getRTTStatusHistory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPauseDetailsIsNotNull()
	{
		return this.pausedetails != null;
	}
	public ims.pathways.vo.PauseDetailsRefVoCollection getPauseDetails()
	{
		return this.pausedetails;
	}
	public void setPauseDetails(ims.pathways.vo.PauseDetailsRefVoCollection value)
	{
		this.isValidated = false;
		this.pausedetails = value;
	}
	public boolean getCurrentPauseIsNotNull()
	{
		return this.currentpause != null;
	}
	public ims.pathways.vo.PauseDetailsRefVo getCurrentPause()
	{
		return this.currentpause;
	}
	public void setCurrentPause(ims.pathways.vo.PauseDetailsRefVo value)
	{
		this.isValidated = false;
		this.currentpause = value;
	}
	public boolean getStopDateIsNotNull()
	{
		return this.stopdate != null;
	}
	public ims.framework.utils.Date getStopDate()
	{
		return this.stopdate;
	}
	public void setStopDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.stopdate = value;
	}
	public boolean getCurrentRTTStatusIsNotNull()
	{
		return this.currentrttstatus != null;
	}
	public ims.pathways.vo.PathwayRTTStatusLiteVo getCurrentRTTStatus()
	{
		return this.currentrttstatus;
	}
	public void setCurrentRTTStatus(ims.pathways.vo.PathwayRTTStatusLiteVo value)
	{
		this.isValidated = false;
		this.currentrttstatus = value;
	}
	public boolean getRTTStatusHistoryIsNotNull()
	{
		return this.rttstatushistory != null;
	}
	public ims.pathways.vo.PathwayRTTStatusLiteVoCollection getRTTStatusHistory()
	{
		return this.rttstatushistory;
	}
	public void setRTTStatusHistory(ims.pathways.vo.PathwayRTTStatusLiteVoCollection value)
	{
		this.isValidated = false;
		this.rttstatushistory = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PathwayClockForReferralERODVo clone = new PathwayClockForReferralERODVo(this.id, this.version);
		
		clone.pausedetails = this.pausedetails;
		clone.currentpause = this.currentpause;
		if(this.stopdate == null)
			clone.stopdate = null;
		else
			clone.stopdate = (ims.framework.utils.Date)this.stopdate.clone();
		if(this.currentrttstatus == null)
			clone.currentrttstatus = null;
		else
			clone.currentrttstatus = (ims.pathways.vo.PathwayRTTStatusLiteVo)this.currentrttstatus.clone();
		if(this.rttstatushistory == null)
			clone.rttstatushistory = null;
		else
			clone.rttstatushistory = (ims.pathways.vo.PathwayRTTStatusLiteVoCollection)this.rttstatushistory.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PathwayClockForReferralERODVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathwayClockForReferralERODVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathwayClockForReferralERODVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathwayClockForReferralERODVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pausedetails != null)
			count++;
		if(this.currentpause != null)
			count++;
		if(this.stopdate != null)
			count++;
		if(this.currentrttstatus != null)
			count++;
		if(this.rttstatushistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.pathways.vo.PauseDetailsRefVoCollection pausedetails;
	protected ims.pathways.vo.PauseDetailsRefVo currentpause;
	protected ims.framework.utils.Date stopdate;
	protected ims.pathways.vo.PathwayRTTStatusLiteVo currentrttstatus;
	protected ims.pathways.vo.PathwayRTTStatusLiteVoCollection rttstatushistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
