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
 * Linked to RefMan.ReferralEROD business object (ID: 1096100062).
 */
public class ReferralERODDetailsVo extends ims.RefMan.vo.ReferralERODRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralERODDetailsVo()
	{
	}
	public ReferralERODDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralERODDetailsVo(ims.RefMan.vo.beans.ReferralERODDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eroddate1 = bean.getERODDate1() == null ? null : bean.getERODDate1().buildDate();
		this.eroddate2 = bean.getERODDate2() == null ? null : bean.getERODDate2().buildDate();
		this.patavailfromdate = bean.getPatAvailFromDate() == null ? null : bean.getPatAvailFromDate().buildDate();
		this.erodtype = bean.getERODType() == null ? null : ims.RefMan.vo.lookups.ERODType.buildLookup(bean.getERODType());
		this.sequence = bean.getSequence();
		this.isactive = bean.getIsActive();
		this.erodstatus = bean.getErodStatus() == null ? null : ims.RefMan.vo.lookups.ERODStatus.buildLookup(bean.getErodStatus());
		this.erodreason = bean.getERODReason() == null ? null : ims.RefMan.vo.lookups.ERODReason.buildLookup(bean.getERODReason());
		this.erodreasoncomment = bean.getERODReasonComment();
		this.pathwayclock = bean.getPathWayClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getPathWayClock().getId()), bean.getPathWayClock().getVersion());
		this.isextendeddelay = bean.getIsExtendedDelay();
		this.reasonableoffer = bean.getReasonableOffer();
		this.dateofoffer = bean.getDateOfOffer() == null ? null : bean.getDateOfOffer().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ReferralERODDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eroddate1 = bean.getERODDate1() == null ? null : bean.getERODDate1().buildDate();
		this.eroddate2 = bean.getERODDate2() == null ? null : bean.getERODDate2().buildDate();
		this.patavailfromdate = bean.getPatAvailFromDate() == null ? null : bean.getPatAvailFromDate().buildDate();
		this.erodtype = bean.getERODType() == null ? null : ims.RefMan.vo.lookups.ERODType.buildLookup(bean.getERODType());
		this.sequence = bean.getSequence();
		this.isactive = bean.getIsActive();
		this.erodstatus = bean.getErodStatus() == null ? null : ims.RefMan.vo.lookups.ERODStatus.buildLookup(bean.getErodStatus());
		this.erodreason = bean.getERODReason() == null ? null : ims.RefMan.vo.lookups.ERODReason.buildLookup(bean.getERODReason());
		this.erodreasoncomment = bean.getERODReasonComment();
		this.pathwayclock = bean.getPathWayClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getPathWayClock().getId()), bean.getPathWayClock().getVersion());
		this.isextendeddelay = bean.getIsExtendedDelay();
		this.reasonableoffer = bean.getReasonableOffer();
		this.dateofoffer = bean.getDateOfOffer() == null ? null : bean.getDateOfOffer().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ReferralERODDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ReferralERODDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ReferralERODDetailsVoBean();
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
		if(fieldName.equals("ERODDATE1"))
			return getERODDate1();
		if(fieldName.equals("ERODDATE2"))
			return getERODDate2();
		if(fieldName.equals("PATAVAILFROMDATE"))
			return getPatAvailFromDate();
		if(fieldName.equals("ERODTYPE"))
			return getERODType();
		if(fieldName.equals("SEQUENCE"))
			return getSequence();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ERODSTATUS"))
			return getErodStatus();
		if(fieldName.equals("ERODREASON"))
			return getERODReason();
		if(fieldName.equals("ERODREASONCOMMENT"))
			return getERODReasonComment();
		if(fieldName.equals("PATHWAYCLOCK"))
			return getPathWayClock();
		if(fieldName.equals("ISEXTENDEDDELAY"))
			return getIsExtendedDelay();
		if(fieldName.equals("REASONABLEOFFER"))
			return getReasonableOffer();
		if(fieldName.equals("DATEOFOFFER"))
			return getDateOfOffer();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getERODDate1IsNotNull()
	{
		return this.eroddate1 != null;
	}
	public ims.framework.utils.Date getERODDate1()
	{
		return this.eroddate1;
	}
	public void setERODDate1(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.eroddate1 = value;
	}
	public boolean getERODDate2IsNotNull()
	{
		return this.eroddate2 != null;
	}
	public ims.framework.utils.Date getERODDate2()
	{
		return this.eroddate2;
	}
	public void setERODDate2(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.eroddate2 = value;
	}
	public boolean getPatAvailFromDateIsNotNull()
	{
		return this.patavailfromdate != null;
	}
	public ims.framework.utils.Date getPatAvailFromDate()
	{
		return this.patavailfromdate;
	}
	public void setPatAvailFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.patavailfromdate = value;
	}
	public boolean getERODTypeIsNotNull()
	{
		return this.erodtype != null;
	}
	public ims.RefMan.vo.lookups.ERODType getERODType()
	{
		return this.erodtype;
	}
	public void setERODType(ims.RefMan.vo.lookups.ERODType value)
	{
		this.isValidated = false;
		this.erodtype = value;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getErodStatusIsNotNull()
	{
		return this.erodstatus != null;
	}
	public ims.RefMan.vo.lookups.ERODStatus getErodStatus()
	{
		return this.erodstatus;
	}
	public void setErodStatus(ims.RefMan.vo.lookups.ERODStatus value)
	{
		this.isValidated = false;
		this.erodstatus = value;
	}
	public boolean getERODReasonIsNotNull()
	{
		return this.erodreason != null;
	}
	public ims.RefMan.vo.lookups.ERODReason getERODReason()
	{
		return this.erodreason;
	}
	public void setERODReason(ims.RefMan.vo.lookups.ERODReason value)
	{
		this.isValidated = false;
		this.erodreason = value;
	}
	public boolean getERODReasonCommentIsNotNull()
	{
		return this.erodreasoncomment != null;
	}
	public String getERODReasonComment()
	{
		return this.erodreasoncomment;
	}
	public static int getERODReasonCommentMaxLength()
	{
		return 1500;
	}
	public void setERODReasonComment(String value)
	{
		this.isValidated = false;
		this.erodreasoncomment = value;
	}
	public boolean getPathWayClockIsNotNull()
	{
		return this.pathwayclock != null;
	}
	public ims.pathways.vo.PathwayClockRefVo getPathWayClock()
	{
		return this.pathwayclock;
	}
	public void setPathWayClock(ims.pathways.vo.PathwayClockRefVo value)
	{
		this.isValidated = false;
		this.pathwayclock = value;
	}
	public boolean getIsExtendedDelayIsNotNull()
	{
		return this.isextendeddelay != null;
	}
	public Boolean getIsExtendedDelay()
	{
		return this.isextendeddelay;
	}
	public void setIsExtendedDelay(Boolean value)
	{
		this.isValidated = false;
		this.isextendeddelay = value;
	}
	public boolean getReasonableOfferIsNotNull()
	{
		return this.reasonableoffer != null;
	}
	public Boolean getReasonableOffer()
	{
		return this.reasonableoffer;
	}
	public void setReasonableOffer(Boolean value)
	{
		this.isValidated = false;
		this.reasonableoffer = value;
	}
	public boolean getDateOfOfferIsNotNull()
	{
		return this.dateofoffer != null;
	}
	public ims.framework.utils.Date getDateOfOffer()
	{
		return this.dateofoffer;
	}
	public void setDateOfOffer(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateofoffer = value;
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
		if(this.eroddate1 == null)
			listOfErrors.add("Earliest Date Offered is mandatory");
		if(this.erodtype == null)
			listOfErrors.add("ERODType is mandatory");
		if(this.erodreasoncomment != null)
			if(this.erodreasoncomment.length() > 1500)
				listOfErrors.add("The length of the field [erodreasoncomment] in the value object [ims.RefMan.vo.ReferralERODDetailsVo] is too big. It should be less or equal to 1500");
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
	
		ReferralERODDetailsVo clone = new ReferralERODDetailsVo(this.id, this.version);
		
		if(this.eroddate1 == null)
			clone.eroddate1 = null;
		else
			clone.eroddate1 = (ims.framework.utils.Date)this.eroddate1.clone();
		if(this.eroddate2 == null)
			clone.eroddate2 = null;
		else
			clone.eroddate2 = (ims.framework.utils.Date)this.eroddate2.clone();
		if(this.patavailfromdate == null)
			clone.patavailfromdate = null;
		else
			clone.patavailfromdate = (ims.framework.utils.Date)this.patavailfromdate.clone();
		if(this.erodtype == null)
			clone.erodtype = null;
		else
			clone.erodtype = (ims.RefMan.vo.lookups.ERODType)this.erodtype.clone();
		clone.sequence = this.sequence;
		clone.isactive = this.isactive;
		if(this.erodstatus == null)
			clone.erodstatus = null;
		else
			clone.erodstatus = (ims.RefMan.vo.lookups.ERODStatus)this.erodstatus.clone();
		if(this.erodreason == null)
			clone.erodreason = null;
		else
			clone.erodreason = (ims.RefMan.vo.lookups.ERODReason)this.erodreason.clone();
		clone.erodreasoncomment = this.erodreasoncomment;
		clone.pathwayclock = this.pathwayclock;
		clone.isextendeddelay = this.isextendeddelay;
		clone.reasonableoffer = this.reasonableoffer;
		if(this.dateofoffer == null)
			clone.dateofoffer = null;
		else
			clone.dateofoffer = (ims.framework.utils.Date)this.dateofoffer.clone();
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
		if (!(ReferralERODDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralERODDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralERODDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralERODDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.eroddate1 != null)
			count++;
		if(this.eroddate2 != null)
			count++;
		if(this.patavailfromdate != null)
			count++;
		if(this.erodtype != null)
			count++;
		if(this.sequence != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.erodstatus != null)
			count++;
		if(this.erodreason != null)
			count++;
		if(this.erodreasoncomment != null)
			count++;
		if(this.pathwayclock != null)
			count++;
		if(this.isextendeddelay != null)
			count++;
		if(this.reasonableoffer != null)
			count++;
		if(this.dateofoffer != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.framework.utils.Date eroddate1;
	protected ims.framework.utils.Date eroddate2;
	protected ims.framework.utils.Date patavailfromdate;
	protected ims.RefMan.vo.lookups.ERODType erodtype;
	protected Integer sequence;
	protected Boolean isactive;
	protected ims.RefMan.vo.lookups.ERODStatus erodstatus;
	protected ims.RefMan.vo.lookups.ERODReason erodreason;
	protected String erodreasoncomment;
	protected ims.pathways.vo.PathwayClockRefVo pathwayclock;
	protected Boolean isextendeddelay;
	protected Boolean reasonableoffer;
	protected ims.framework.utils.Date dateofoffer;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
