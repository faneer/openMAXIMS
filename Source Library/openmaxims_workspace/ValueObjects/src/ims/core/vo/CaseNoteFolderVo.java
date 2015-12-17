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

package ims.core.vo;


public class CaseNoteFolderVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CaseNoteFolderVo()
	{
	}
	public CaseNoteFolderVo(ims.core.vo.beans.CaseNoteFolderVoBean bean)
	{
		this.volume = bean.getVolume();
		this.location = bean.getLocation();
		this.moveto = bean.getMoveTo();
		this.locdate = bean.getLocDate() == null ? null : bean.getLocDate().buildDate();
		this.loctime = bean.getLocTime() == null ? null : bean.getLocTime().buildTime();
		this.comments = bean.getComments();
		this.unam = bean.getUNAM();
		this.rdat = bean.getRDAT() == null ? null : bean.getRDAT().buildDate();
		this.rtim = bean.getRTIM() == null ? null : bean.getRTIM().buildTime();
		this.hospnum = bean.getHOSPNUM();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CaseNoteFolderVoBean bean)
	{
		this.volume = bean.getVolume();
		this.location = bean.getLocation();
		this.moveto = bean.getMoveTo();
		this.locdate = bean.getLocDate() == null ? null : bean.getLocDate().buildDate();
		this.loctime = bean.getLocTime() == null ? null : bean.getLocTime().buildTime();
		this.comments = bean.getComments();
		this.unam = bean.getUNAM();
		this.rdat = bean.getRDAT() == null ? null : bean.getRDAT().buildDate();
		this.rtim = bean.getRTIM() == null ? null : bean.getRTIM().buildTime();
		this.hospnum = bean.getHOSPNUM();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CaseNoteFolderVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CaseNoteFolderVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CaseNoteFolderVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getVolumeIsNotNull()
	{
		return this.volume != null;
	}
	public String getVolume()
	{
		return this.volume;
	}
	public static int getVolumeMaxLength()
	{
		return 255;
	}
	public void setVolume(String value)
	{
		this.isValidated = false;
		this.volume = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public String getLocation()
	{
		return this.location;
	}
	public static int getLocationMaxLength()
	{
		return 255;
	}
	public void setLocation(String value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getMoveToIsNotNull()
	{
		return this.moveto != null;
	}
	public String getMoveTo()
	{
		return this.moveto;
	}
	public static int getMoveToMaxLength()
	{
		return 255;
	}
	public void setMoveTo(String value)
	{
		this.isValidated = false;
		this.moveto = value;
	}
	public boolean getLocDateIsNotNull()
	{
		return this.locdate != null;
	}
	public ims.framework.utils.Date getLocDate()
	{
		return this.locdate;
	}
	public void setLocDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.locdate = value;
	}
	public boolean getLocTimeIsNotNull()
	{
		return this.loctime != null;
	}
	public ims.framework.utils.Time getLocTime()
	{
		return this.loctime;
	}
	public void setLocTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.loctime = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 255;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getUNAMIsNotNull()
	{
		return this.unam != null;
	}
	public String getUNAM()
	{
		return this.unam;
	}
	public static int getUNAMMaxLength()
	{
		return 255;
	}
	public void setUNAM(String value)
	{
		this.isValidated = false;
		this.unam = value;
	}
	public boolean getRDATIsNotNull()
	{
		return this.rdat != null;
	}
	public ims.framework.utils.Date getRDAT()
	{
		return this.rdat;
	}
	public void setRDAT(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.rdat = value;
	}
	public boolean getRTIMIsNotNull()
	{
		return this.rtim != null;
	}
	public ims.framework.utils.Time getRTIM()
	{
		return this.rtim;
	}
	public void setRTIM(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.rtim = value;
	}
	public boolean getHOSPNUMIsNotNull()
	{
		return this.hospnum != null;
	}
	public String getHOSPNUM()
	{
		return this.hospnum;
	}
	public static int getHOSPNUMMaxLength()
	{
		return 255;
	}
	public void setHOSPNUM(String value)
	{
		this.isValidated = false;
		this.hospnum = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof CaseNoteFolderVo))
			return false;
		CaseNoteFolderVo compareObj = (CaseNoteFolderVo)obj;
		if(this.getVolume() == null && compareObj.getVolume() != null)
			return false;
		if(this.getVolume() != null && compareObj.getVolume() == null)
			return false;
		if(this.getVolume() != null && compareObj.getVolume() != null)
			if(!this.getVolume().equals(compareObj.getVolume()))
				return false;
		if(this.getLocation() == null && compareObj.getLocation() != null)
			return false;
		if(this.getLocation() != null && compareObj.getLocation() == null)
			return false;
		if(this.getLocation() != null && compareObj.getLocation() != null)
			if(!this.getLocation().equals(compareObj.getLocation()))
				return false;
		if(this.getRDAT() == null && compareObj.getRDAT() != null)
			return false;
		if(this.getRDAT() != null && compareObj.getRDAT() == null)
			return false;
		if(this.getRDAT() != null && compareObj.getRDAT() != null)
			if(!this.getRDAT().equals(compareObj.getRDAT()))
				return false;
		if(this.getRTIM() == null && compareObj.getRTIM() != null)
			return false;
		if(this.getRTIM() != null && compareObj.getRTIM() == null)
			return false;
		if(this.getRTIM() != null && compareObj.getRTIM() != null)
			return this.getRTIM().equals(compareObj.getRTIM());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		CaseNoteFolderVo clone = new CaseNoteFolderVo();
		
		clone.volume = this.volume;
		clone.location = this.location;
		clone.moveto = this.moveto;
		if(this.locdate == null)
			clone.locdate = null;
		else
			clone.locdate = (ims.framework.utils.Date)this.locdate.clone();
		if(this.loctime == null)
			clone.loctime = null;
		else
			clone.loctime = (ims.framework.utils.Time)this.loctime.clone();
		clone.comments = this.comments;
		clone.unam = this.unam;
		if(this.rdat == null)
			clone.rdat = null;
		else
			clone.rdat = (ims.framework.utils.Date)this.rdat.clone();
		if(this.rtim == null)
			clone.rtim = null;
		else
			clone.rtim = (ims.framework.utils.Time)this.rtim.clone();
		clone.hospnum = this.hospnum;
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
		if (!(CaseNoteFolderVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CaseNoteFolderVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CaseNoteFolderVo compareObj = (CaseNoteFolderVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getVolume() == null && compareObj.getVolume() != null)
				return -1;
			if(this.getVolume() != null && compareObj.getVolume() == null)
				return 1;
			if(this.getVolume() != null && compareObj.getVolume() != null)
			{
				if(caseInsensitive)
					retVal = this.getVolume().toLowerCase().compareTo(compareObj.getVolume().toLowerCase());
				else
					retVal = this.getVolume().compareTo(compareObj.getVolume());
			}
		}
		if (retVal == 0)
		{
			if(this.getLocation() == null && compareObj.getLocation() != null)
				return -1;
			if(this.getLocation() != null && compareObj.getLocation() == null)
				return 1;
			if(this.getLocation() != null && compareObj.getLocation() != null)
			{
				if(caseInsensitive)
					retVal = this.getLocation().toLowerCase().compareTo(compareObj.getLocation().toLowerCase());
				else
					retVal = this.getLocation().compareTo(compareObj.getLocation());
			}
		}
		if (retVal == 0)
		{
			if(this.getRDAT() == null && compareObj.getRDAT() != null)
				return -1;
			if(this.getRDAT() != null && compareObj.getRDAT() == null)
				return 1;
			if(this.getRDAT() != null && compareObj.getRDAT() != null)
				retVal = this.getRDAT().compareTo(compareObj.getRDAT());
		}
		if (retVal == 0)
		{
			if(this.getRTIM() == null && compareObj.getRTIM() != null)
				return -1;
			if(this.getRTIM() != null && compareObj.getRTIM() == null)
				return 1;
			if(this.getRTIM() != null && compareObj.getRTIM() != null)
				retVal = this.getRTIM().compareTo(compareObj.getRTIM());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.volume != null)
			count++;
		if(this.location != null)
			count++;
		if(this.moveto != null)
			count++;
		if(this.locdate != null)
			count++;
		if(this.loctime != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.unam != null)
			count++;
		if(this.rdat != null)
			count++;
		if(this.rtim != null)
			count++;
		if(this.hospnum != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected String volume;
	protected String location;
	protected String moveto;
	protected ims.framework.utils.Date locdate;
	protected ims.framework.utils.Time loctime;
	protected String comments;
	protected String unam;
	protected ims.framework.utils.Date rdat;
	protected ims.framework.utils.Time rtim;
	protected String hospnum;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
