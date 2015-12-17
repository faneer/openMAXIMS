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

package ims.nursing.vo;

/**
 * Linked to nursing.care plans.Care Plan business object (ID: 1010100003).
 */
public class CopyCarePlanVo extends ims.nursing.careplans.vo.CarePlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CopyCarePlanVo()
	{
	}
	public CopyCarePlanVo(Integer id, int version)
	{
		super(id, version);
	}
	public CopyCarePlanVo(ims.nursing.vo.beans.CopyCarePlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.title = bean.getTitle();
		this.nextevaluationdate = bean.getNextEvaluationDate() == null ? null : bean.getNextEvaluationDate().buildDate();
		this.lastrevieweddate = bean.getLastReviewedDate() == null ? null : bean.getLastReviewedDate().buildDateTime();
		this.lastreviewedby = bean.getLastReviewedBy() == null ? null : bean.getLastReviewedBy().buildVo();
		this.careplanstatus = ims.nursing.vo.CarePlanStatusCollection.buildFromBeanCollection(bean.getCarePlanStatus());
		this.currentcareplanstatus = bean.getCurrentCarePlanStatus() == null ? null : bean.getCurrentCarePlanStatus().buildVo();
		this.newnextevaluationdate = bean.getNewNextEvaluationDate() == null ? null : bean.getNewNextEvaluationDate().buildDate();
		this.newnextevaluationtime = bean.getNewNextEvaluationTime() == null ? null : bean.getNewNextEvaluationTime().buildTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.CopyCarePlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.title = bean.getTitle();
		this.nextevaluationdate = bean.getNextEvaluationDate() == null ? null : bean.getNextEvaluationDate().buildDate();
		this.lastrevieweddate = bean.getLastReviewedDate() == null ? null : bean.getLastReviewedDate().buildDateTime();
		this.lastreviewedby = bean.getLastReviewedBy() == null ? null : bean.getLastReviewedBy().buildVo(map);
		this.careplanstatus = ims.nursing.vo.CarePlanStatusCollection.buildFromBeanCollection(bean.getCarePlanStatus());
		this.currentcareplanstatus = bean.getCurrentCarePlanStatus() == null ? null : bean.getCurrentCarePlanStatus().buildVo(map);
		this.newnextevaluationdate = bean.getNewNextEvaluationDate() == null ? null : bean.getNewNextEvaluationDate().buildDate();
		this.newnextevaluationtime = bean.getNewNextEvaluationTime() == null ? null : bean.getNewNextEvaluationTime().buildTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.CopyCarePlanVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.CopyCarePlanVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.CopyCarePlanVoBean();
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
		if(fieldName.equals("TITLE"))
			return getTitle();
		if(fieldName.equals("NEXTEVALUATIONDATE"))
			return getNextEvaluationDate();
		if(fieldName.equals("LASTREVIEWEDDATE"))
			return getLastReviewedDate();
		if(fieldName.equals("LASTREVIEWEDBY"))
			return getLastReviewedBy();
		if(fieldName.equals("CAREPLANSTATUS"))
			return getCarePlanStatus();
		if(fieldName.equals("CURRENTCAREPLANSTATUS"))
			return getCurrentCarePlanStatus();
		if(fieldName.equals("NEWNEXTEVALUATIONDATE"))
			return getNewNextEvaluationDate();
		if(fieldName.equals("NEWNEXTEVALUATIONTIME"))
			return getNewNextEvaluationTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTitleIsNotNull()
	{
		return this.title != null;
	}
	public String getTitle()
	{
		return this.title;
	}
	public static int getTitleMaxLength()
	{
		return 255;
	}
	public void setTitle(String value)
	{
		this.isValidated = false;
		this.title = value;
	}
	public boolean getNextEvaluationDateIsNotNull()
	{
		return this.nextevaluationdate != null;
	}
	public ims.framework.utils.Date getNextEvaluationDate()
	{
		return this.nextevaluationdate;
	}
	public void setNextEvaluationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.nextevaluationdate = value;
	}
	public boolean getLastReviewedDateIsNotNull()
	{
		return this.lastrevieweddate != null;
	}
	public ims.framework.utils.DateTime getLastReviewedDate()
	{
		return this.lastrevieweddate;
	}
	public void setLastReviewedDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastrevieweddate = value;
	}
	public boolean getLastReviewedByIsNotNull()
	{
		return this.lastreviewedby != null;
	}
	public ims.core.vo.Hcp getLastReviewedBy()
	{
		return this.lastreviewedby;
	}
	public void setLastReviewedBy(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.lastreviewedby = value;
	}
	public boolean getCarePlanStatusIsNotNull()
	{
		return this.careplanstatus != null;
	}
	public ims.nursing.vo.CarePlanStatusCollection getCarePlanStatus()
	{
		return this.careplanstatus;
	}
	public void setCarePlanStatus(ims.nursing.vo.CarePlanStatusCollection value)
	{
		this.isValidated = false;
		this.careplanstatus = value;
	}
	public boolean getCurrentCarePlanStatusIsNotNull()
	{
		return this.currentcareplanstatus != null;
	}
	public ims.nursing.vo.CarePlanStatus getCurrentCarePlanStatus()
	{
		return this.currentcareplanstatus;
	}
	public void setCurrentCarePlanStatus(ims.nursing.vo.CarePlanStatus value)
	{
		this.isValidated = false;
		this.currentcareplanstatus = value;
	}
	public boolean getNewNextEvaluationDateIsNotNull()
	{
		return this.newnextevaluationdate != null;
	}
	public ims.framework.utils.Date getNewNextEvaluationDate()
	{
		return this.newnextevaluationdate;
	}
	public void setNewNextEvaluationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.newnextevaluationdate = value;
	}
	public boolean getNewNextEvaluationTimeIsNotNull()
	{
		return this.newnextevaluationtime != null;
	}
	public ims.framework.utils.Time getNewNextEvaluationTime()
	{
		return this.newnextevaluationtime;
	}
	public void setNewNextEvaluationTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.newnextevaluationtime = value;
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
		if(this.title != null)
			if(this.title.length() > 255)
				listOfErrors.add("The length of the field [title] in the value object [ims.nursing.vo.CopyCarePlanVo] is too big. It should be less or equal to 255");
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
	
		CopyCarePlanVo clone = new CopyCarePlanVo(this.id, this.version);
		
		clone.title = this.title;
		if(this.nextevaluationdate == null)
			clone.nextevaluationdate = null;
		else
			clone.nextevaluationdate = (ims.framework.utils.Date)this.nextevaluationdate.clone();
		if(this.lastrevieweddate == null)
			clone.lastrevieweddate = null;
		else
			clone.lastrevieweddate = (ims.framework.utils.DateTime)this.lastrevieweddate.clone();
		if(this.lastreviewedby == null)
			clone.lastreviewedby = null;
		else
			clone.lastreviewedby = (ims.core.vo.Hcp)this.lastreviewedby.clone();
		if(this.careplanstatus == null)
			clone.careplanstatus = null;
		else
			clone.careplanstatus = (ims.nursing.vo.CarePlanStatusCollection)this.careplanstatus.clone();
		if(this.currentcareplanstatus == null)
			clone.currentcareplanstatus = null;
		else
			clone.currentcareplanstatus = (ims.nursing.vo.CarePlanStatus)this.currentcareplanstatus.clone();
		if(this.newnextevaluationdate == null)
			clone.newnextevaluationdate = null;
		else
			clone.newnextevaluationdate = (ims.framework.utils.Date)this.newnextevaluationdate.clone();
		if(this.newnextevaluationtime == null)
			clone.newnextevaluationtime = null;
		else
			clone.newnextevaluationtime = (ims.framework.utils.Time)this.newnextevaluationtime.clone();
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
		if (!(CopyCarePlanVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CopyCarePlanVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CopyCarePlanVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CopyCarePlanVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.title != null)
			count++;
		if(this.nextevaluationdate != null)
			count++;
		if(this.lastrevieweddate != null)
			count++;
		if(this.lastreviewedby != null)
			count++;
		if(this.careplanstatus != null)
			count++;
		if(this.currentcareplanstatus != null)
			count++;
		if(this.newnextevaluationdate != null)
			count++;
		if(this.newnextevaluationtime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected String title;
	protected ims.framework.utils.Date nextevaluationdate;
	protected ims.framework.utils.DateTime lastrevieweddate;
	protected ims.core.vo.Hcp lastreviewedby;
	protected ims.nursing.vo.CarePlanStatusCollection careplanstatus;
	protected ims.nursing.vo.CarePlanStatus currentcareplanstatus;
	protected ims.framework.utils.Date newnextevaluationdate;
	protected ims.framework.utils.Time newnextevaluationtime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
