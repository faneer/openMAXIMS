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

/**
 * Linked to NAES.ActionPlan business object (ID: 1097100001).
 */
public class ActionPlanVo extends ims.naes.vo.ActionPlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActionPlanVo()
	{
	}
	public ActionPlanVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActionPlanVo(ims.core.vo.beans.ActionPlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datecommenced = bean.getDateCommenced() == null ? null : bean.getDateCommenced().buildDate();
		this.ordernumber = bean.getOrderNumber();
		this.datecompleted = bean.getDateCompleted() == null ? null : bean.getDateCompleted().buildDate();
		this.comment = bean.getComment();
		this.recall = bean.getRecall() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getRecall());
		this.recallin = bean.getRecallIn();
		this.recallperiod = bean.getRecallPeriod() == null ? null : ims.core.vo.lookups.TimeWeeksMonthsYears.buildLookup(bean.getRecallPeriod());
		this.actions = ims.naes.vo.ActionDetailVoCollection.buildFromBeanCollection(bean.getActions());
		this.ncpcomment = bean.getNcpComment();
		this.naesreferral = bean.getNAESReferral() == null ? null : bean.getNAESReferral().buildVo();
		this.sclera = bean.getSclera();
		this.quarteryear = bean.getQuarterYear();
		this.finalcure = bean.getFinalCure();
		this.batchnumber = bean.getBatchNumber();
		this.sixmonthopenperiod = bean.getSixMonthOpenPeriod() == null ? null : bean.getSixMonthOpenPeriod().buildDate();
		this.actionsaddedwithin6monthperiod = bean.getActionsAddedWithin6MonthPeriod();
		this.quarterhistory = ims.naes.vo.ActionPlanQuarterVoCollection.buildFromBeanCollection(bean.getQuarterHistory());
		this.eyesinordernumber = bean.getEyesInOrderNumber() == null ? null : bean.getEyesInOrderNumber().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ActionPlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datecommenced = bean.getDateCommenced() == null ? null : bean.getDateCommenced().buildDate();
		this.ordernumber = bean.getOrderNumber();
		this.datecompleted = bean.getDateCompleted() == null ? null : bean.getDateCompleted().buildDate();
		this.comment = bean.getComment();
		this.recall = bean.getRecall() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getRecall());
		this.recallin = bean.getRecallIn();
		this.recallperiod = bean.getRecallPeriod() == null ? null : ims.core.vo.lookups.TimeWeeksMonthsYears.buildLookup(bean.getRecallPeriod());
		this.actions = ims.naes.vo.ActionDetailVoCollection.buildFromBeanCollection(bean.getActions());
		this.ncpcomment = bean.getNcpComment();
		this.naesreferral = bean.getNAESReferral() == null ? null : bean.getNAESReferral().buildVo(map);
		this.sclera = bean.getSclera();
		this.quarteryear = bean.getQuarterYear();
		this.finalcure = bean.getFinalCure();
		this.batchnumber = bean.getBatchNumber();
		this.sixmonthopenperiod = bean.getSixMonthOpenPeriod() == null ? null : bean.getSixMonthOpenPeriod().buildDate();
		this.actionsaddedwithin6monthperiod = bean.getActionsAddedWithin6MonthPeriod();
		this.quarterhistory = ims.naes.vo.ActionPlanQuarterVoCollection.buildFromBeanCollection(bean.getQuarterHistory());
		this.eyesinordernumber = bean.getEyesInOrderNumber() == null ? null : bean.getEyesInOrderNumber().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ActionPlanVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ActionPlanVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ActionPlanVoBean();
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
		if(fieldName.equals("DATECOMMENCED"))
			return getDateCommenced();
		if(fieldName.equals("ORDERNUMBER"))
			return getOrderNumber();
		if(fieldName.equals("DATECOMPLETED"))
			return getDateCompleted();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("RECALL"))
			return getRecall();
		if(fieldName.equals("RECALLIN"))
			return getRecallIn();
		if(fieldName.equals("RECALLPERIOD"))
			return getRecallPeriod();
		if(fieldName.equals("ACTIONS"))
			return getActions();
		if(fieldName.equals("NCPCOMMENT"))
			return getNcpComment();
		if(fieldName.equals("NAESREFERRAL"))
			return getNAESReferral();
		if(fieldName.equals("SCLERA"))
			return getSclera();
		if(fieldName.equals("QUARTERYEAR"))
			return getQuarterYear();
		if(fieldName.equals("FINALCURE"))
			return getFinalCure();
		if(fieldName.equals("BATCHNUMBER"))
			return getBatchNumber();
		if(fieldName.equals("SIXMONTHOPENPERIOD"))
			return getSixMonthOpenPeriod();
		if(fieldName.equals("ACTIONSADDEDWITHIN6MONTHPERIOD"))
			return getActionsAddedWithin6MonthPeriod();
		if(fieldName.equals("QUARTERHISTORY"))
			return getQuarterHistory();
		if(fieldName.equals("EYESINORDERNUMBER"))
			return getEyesInOrderNumber();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateCommencedIsNotNull()
	{
		return this.datecommenced != null;
	}
	public ims.framework.utils.Date getDateCommenced()
	{
		return this.datecommenced;
	}
	public void setDateCommenced(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datecommenced = value;
	}
	public boolean getOrderNumberIsNotNull()
	{
		return this.ordernumber != null;
	}
	public String getOrderNumber()
	{
		return this.ordernumber;
	}
	public static int getOrderNumberMaxLength()
	{
		return 25;
	}
	public void setOrderNumber(String value)
	{
		this.isValidated = false;
		this.ordernumber = value;
	}
	public boolean getDateCompletedIsNotNull()
	{
		return this.datecompleted != null;
	}
	public ims.framework.utils.Date getDateCompleted()
	{
		return this.datecompleted;
	}
	public void setDateCompleted(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datecompleted = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getRecallIsNotNull()
	{
		return this.recall != null;
	}
	public ims.core.vo.lookups.YesNo getRecall()
	{
		return this.recall;
	}
	public void setRecall(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.recall = value;
	}
	public boolean getRecallInIsNotNull()
	{
		return this.recallin != null;
	}
	public Integer getRecallIn()
	{
		return this.recallin;
	}
	public void setRecallIn(Integer value)
	{
		this.isValidated = false;
		this.recallin = value;
	}
	public boolean getRecallPeriodIsNotNull()
	{
		return this.recallperiod != null;
	}
	public ims.core.vo.lookups.TimeWeeksMonthsYears getRecallPeriod()
	{
		return this.recallperiod;
	}
	public void setRecallPeriod(ims.core.vo.lookups.TimeWeeksMonthsYears value)
	{
		this.isValidated = false;
		this.recallperiod = value;
	}
	public boolean getActionsIsNotNull()
	{
		return this.actions != null;
	}
	public ims.naes.vo.ActionDetailVoCollection getActions()
	{
		return this.actions;
	}
	public void setActions(ims.naes.vo.ActionDetailVoCollection value)
	{
		this.isValidated = false;
		this.actions = value;
	}
	public boolean getNcpCommentIsNotNull()
	{
		return this.ncpcomment != null;
	}
	public String getNcpComment()
	{
		return this.ncpcomment;
	}
	public static int getNcpCommentMaxLength()
	{
		return 255;
	}
	public void setNcpComment(String value)
	{
		this.isValidated = false;
		this.ncpcomment = value;
	}
	public boolean getNAESReferralIsNotNull()
	{
		return this.naesreferral != null;
	}
	public ims.naes.vo.NAESReferralVo getNAESReferral()
	{
		return this.naesreferral;
	}
	public void setNAESReferral(ims.naes.vo.NAESReferralVo value)
	{
		this.isValidated = false;
		this.naesreferral = value;
	}
	public boolean getScleraIsNotNull()
	{
		return this.sclera != null;
	}
	public String getSclera()
	{
		return this.sclera;
	}
	public static int getScleraMaxLength()
	{
		return 1;
	}
	public void setSclera(String value)
	{
		this.isValidated = false;
		this.sclera = value;
	}
	public boolean getQuarterYearIsNotNull()
	{
		return this.quarteryear != null;
	}
	public Integer getQuarterYear()
	{
		return this.quarteryear;
	}
	public void setQuarterYear(Integer value)
	{
		this.isValidated = false;
		this.quarteryear = value;
	}
	public boolean getFinalCureIsNotNull()
	{
		return this.finalcure != null;
	}
	public String getFinalCure()
	{
		return this.finalcure;
	}
	public static int getFinalCureMaxLength()
	{
		return 1;
	}
	public void setFinalCure(String value)
	{
		this.isValidated = false;
		this.finalcure = value;
	}
	public boolean getBatchNumberIsNotNull()
	{
		return this.batchnumber != null;
	}
	public String getBatchNumber()
	{
		return this.batchnumber;
	}
	public static int getBatchNumberMaxLength()
	{
		return 8;
	}
	public void setBatchNumber(String value)
	{
		this.isValidated = false;
		this.batchnumber = value;
	}
	public boolean getSixMonthOpenPeriodIsNotNull()
	{
		return this.sixmonthopenperiod != null;
	}
	public ims.framework.utils.Date getSixMonthOpenPeriod()
	{
		return this.sixmonthopenperiod;
	}
	public void setSixMonthOpenPeriod(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.sixmonthopenperiod = value;
	}
	public boolean getActionsAddedWithin6MonthPeriodIsNotNull()
	{
		return this.actionsaddedwithin6monthperiod != null;
	}
	public Boolean getActionsAddedWithin6MonthPeriod()
	{
		return this.actionsaddedwithin6monthperiod;
	}
	public void setActionsAddedWithin6MonthPeriod(Boolean value)
	{
		this.isValidated = false;
		this.actionsaddedwithin6monthperiod = value;
	}
	public boolean getQuarterHistoryIsNotNull()
	{
		return this.quarterhistory != null;
	}
	public ims.naes.vo.ActionPlanQuarterVoCollection getQuarterHistory()
	{
		return this.quarterhistory;
	}
	public void setQuarterHistory(ims.naes.vo.ActionPlanQuarterVoCollection value)
	{
		this.isValidated = false;
		this.quarterhistory = value;
	}
	public boolean getEyesInOrderNumberIsNotNull()
	{
		return this.eyesinordernumber != null;
	}
	public ims.core.vo.EyesInOrderNumberVo getEyesInOrderNumber()
	{
		return this.eyesinordernumber;
	}
	public void setEyesInOrderNumber(ims.core.vo.EyesInOrderNumberVo value)
	{
		this.isValidated = false;
		this.eyesinordernumber = value;
	}
	/**
	* isLabCompletionActionCompleted
	*/
		public boolean isLabCompletionActionCompleted()
		{
			if (this == null)
				return false;
		
			int countlabcompletions = 0;
			if (this.getActionsIsNotNull())
			{
				for (ims.naes.vo.ActionDetailVo voAction : this.getActions())
				{
					if (voAction.getActionIsNotNull() 
						&& voAction.getID_ActionDetail() == null
						&& voAction.getAction().equals(ims.naes.vo.lookups.Action.LABCOMP) 
						&& voAction.getCurrentStatusIsNotNull() 
						&& voAction.getCurrentStatus().getStatusIsNotNull() 
						&& voAction.getCurrentStatus().getStatus().equals(ims.naes.vo.lookups.NaesActionStatus.COMPLETED))
						countlabcompletions++;
				}
			}
		
			return countlabcompletions > 0;
		}
	/**
	* calculateYearQuater
	*/
	/*
	 * This code calculates the the year quarter in the batch code for an action plan
	 * 
	 * The start date was mid year so it wasn't as straight forward as first though.
	 */
	
	public int calculateYearQuater()
	{
	
		ims.framework.utils.Date now = null;
	
		ims.framework.utils.Date start = null;
		try
		{
			start = new ims.framework.utils.Date("01/06/1989");
	
			now = new ims.framework.utils.Date();
		}
		catch (java.text.ParseException e)
		{
	
			e.printStackTrace();
		}
	
		// get the current month
		int month = now.getMonth();
	
		Double quarter = 0.00;
	
		switch (month)
		{
			case 1 :
				quarter = -1.00;
			break;
			case 2 :
				quarter = -1.00;
			break;
			case 3 :
				quarter = -1.00;
			break;
			case 4 :
				quarter = 0.00;
			break;
			case 5 :
				quarter = 0.00;
			break;
			case 6 :
				quarter = 0.00;
			break;
			case 7 :
				quarter = 1.00;
			break;
			case 8 :
				quarter = 1.00;
			break;
			case 9 :
				quarter = 1.00;
			break;
			case 10 :
				quarter = 2.00;
			break;
			case 11 :
				quarter = 2.00;
			break;
			case 12 :
				quarter = 2.00;
			break;
		}
	
		/*
		 * Quarter is calculated by subtracting the start year from the current year. and the adding the quarter variable which is determined above.
		 */
		Double dif = ((now.getYear() - start.getYear()) * (4.00)) + quarter;
	
		int x = (int) Math.round(dif);
	
		return x;
	
	}
	/**
	* countCurrentLabCompletions
	*/
	public int countCurrentLabCompletions(boolean persisted)
	{
		//lab completions
		int countlabcompletions = 0;
		if (this.getActionsIsNotNull())
		{
			for (ims.naes.vo.ActionDetailVo voAction : this.getActions())
			{
				if (voAction.getActionIsNotNull() && voAction.getAction().equals(ims.naes.vo.lookups.Action.LABCOMP) && voAction.getCurrentStatusIsNotNull() && voAction.getCurrentStatus().getStatusIsNotNull() && voAction.getCurrentStatus().getStatus().equals(ims.naes.vo.lookups.NaesActionStatus.COMPLETED))
				{
					if(persisted)
					{
						if(voAction.getID_ActionDetailIsNotNull())
							countlabcompletions++;
					}
					else
						countlabcompletions++;
				}	
			}	
		}
		
		return countlabcompletions;
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
		if(this.actions != null)
		{
			if(!this.actions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.naesreferral != null)
		{
			if(!this.naesreferral.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.quarterhistory != null)
		{
			if(!this.quarterhistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.eyesinordernumber != null)
		{
			if(!this.eyesinordernumber.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.datecommenced == null)
			listOfErrors.add("DateCommenced is mandatory");
		if(this.ordernumber == null || this.ordernumber.length() == 0)
			listOfErrors.add("OrderNumber is mandatory");
		else if(this.ordernumber.length() > 25)
			listOfErrors.add("The length of the field [ordernumber] in the value object [ims.core.vo.ActionPlanVo] is too big. It should be less or equal to 25");
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.core.vo.ActionPlanVo] is too big. It should be less or equal to 255");
		if(this.actions != null)
		{
			String[] listOfOtherErrors = this.actions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ncpcomment != null)
			if(this.ncpcomment.length() > 255)
				listOfErrors.add("The length of the field [ncpcomment] in the value object [ims.core.vo.ActionPlanVo] is too big. It should be less or equal to 255");
		if(this.naesreferral == null)
			listOfErrors.add("NAESReferral is mandatory");
		if(this.naesreferral != null)
		{
			String[] listOfOtherErrors = this.naesreferral.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.sclera != null)
			if(this.sclera.length() > 1)
				listOfErrors.add("The length of the field [sclera] in the value object [ims.core.vo.ActionPlanVo] is too big. It should be less or equal to 1");
		if(this.finalcure != null)
			if(this.finalcure.length() > 1)
				listOfErrors.add("The length of the field [finalcure] in the value object [ims.core.vo.ActionPlanVo] is too big. It should be less or equal to 1");
		if(this.batchnumber != null)
			if(this.batchnumber.length() > 8)
				listOfErrors.add("The length of the field [batchnumber] in the value object [ims.core.vo.ActionPlanVo] is too big. It should be less or equal to 8");
		if(this.quarterhistory != null)
		{
			String[] listOfOtherErrors = this.quarterhistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.eyesinordernumber != null)
		{
			String[] listOfOtherErrors = this.eyesinordernumber.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		ActionPlanVo clone = new ActionPlanVo(this.id, this.version);
		
		if(this.datecommenced == null)
			clone.datecommenced = null;
		else
			clone.datecommenced = (ims.framework.utils.Date)this.datecommenced.clone();
		clone.ordernumber = this.ordernumber;
		if(this.datecompleted == null)
			clone.datecompleted = null;
		else
			clone.datecompleted = (ims.framework.utils.Date)this.datecompleted.clone();
		clone.comment = this.comment;
		if(this.recall == null)
			clone.recall = null;
		else
			clone.recall = (ims.core.vo.lookups.YesNo)this.recall.clone();
		clone.recallin = this.recallin;
		if(this.recallperiod == null)
			clone.recallperiod = null;
		else
			clone.recallperiod = (ims.core.vo.lookups.TimeWeeksMonthsYears)this.recallperiod.clone();
		if(this.actions == null)
			clone.actions = null;
		else
			clone.actions = (ims.naes.vo.ActionDetailVoCollection)this.actions.clone();
		clone.ncpcomment = this.ncpcomment;
		if(this.naesreferral == null)
			clone.naesreferral = null;
		else
			clone.naesreferral = (ims.naes.vo.NAESReferralVo)this.naesreferral.clone();
		clone.sclera = this.sclera;
		clone.quarteryear = this.quarteryear;
		clone.finalcure = this.finalcure;
		clone.batchnumber = this.batchnumber;
		if(this.sixmonthopenperiod == null)
			clone.sixmonthopenperiod = null;
		else
			clone.sixmonthopenperiod = (ims.framework.utils.Date)this.sixmonthopenperiod.clone();
		clone.actionsaddedwithin6monthperiod = this.actionsaddedwithin6monthperiod;
		if(this.quarterhistory == null)
			clone.quarterhistory = null;
		else
			clone.quarterhistory = (ims.naes.vo.ActionPlanQuarterVoCollection)this.quarterhistory.clone();
		if(this.eyesinordernumber == null)
			clone.eyesinordernumber = null;
		else
			clone.eyesinordernumber = (ims.core.vo.EyesInOrderNumberVo)this.eyesinordernumber.clone();
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
		if (!(ActionPlanVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActionPlanVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ActionPlanVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ActionPlanVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.datecommenced != null)
			count++;
		if(this.ordernumber != null)
			count++;
		if(this.datecompleted != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.recall != null)
			count++;
		if(this.recallin != null)
			count++;
		if(this.recallperiod != null)
			count++;
		if(this.actions != null)
			count++;
		if(this.ncpcomment != null)
			count++;
		if(this.naesreferral != null)
			count++;
		if(this.sclera != null)
			count++;
		if(this.quarteryear != null)
			count++;
		if(this.finalcure != null)
			count++;
		if(this.batchnumber != null)
			count++;
		if(this.sixmonthopenperiod != null)
			count++;
		if(this.actionsaddedwithin6monthperiod != null)
			count++;
		if(this.quarterhistory != null)
			count++;
		if(this.eyesinordernumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 18;
	}
	protected ims.framework.utils.Date datecommenced;
	protected String ordernumber;
	protected ims.framework.utils.Date datecompleted;
	protected String comment;
	protected ims.core.vo.lookups.YesNo recall;
	protected Integer recallin;
	protected ims.core.vo.lookups.TimeWeeksMonthsYears recallperiod;
	protected ims.naes.vo.ActionDetailVoCollection actions;
	protected String ncpcomment;
	protected ims.naes.vo.NAESReferralVo naesreferral;
	protected String sclera;
	protected Integer quarteryear;
	protected String finalcure;
	protected String batchnumber;
	protected ims.framework.utils.Date sixmonthopenperiod;
	protected Boolean actionsaddedwithin6monthperiod;
	protected ims.naes.vo.ActionPlanQuarterVoCollection quarterhistory;
	protected ims.core.vo.EyesInOrderNumberVo eyesinordernumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
