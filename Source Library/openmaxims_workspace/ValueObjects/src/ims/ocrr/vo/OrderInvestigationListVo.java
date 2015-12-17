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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class OrderInvestigationListVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IGenericItemType
{
	private static final long serialVersionUID = 1L;

	public OrderInvestigationListVo()
	{
	}
	public OrderInvestigationListVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderInvestigationListVo(ims.ocrr.vo.beans.OrderInvestigationListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		this.ordinvstatushistory = ims.ocrr.vo.OrderedInvestigationStatusVoCollection.buildFromBeanCollection(bean.getOrdInvStatusHistory());
		this.requestedlocation = bean.getRequestedLocation() == null ? null : bean.getRequestedLocation().buildVo();
		this.passessecurity = bean.getPassesSecurity();
		this.ordinvxostatushistory = ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection.buildFromBeanCollection(bean.getOrdInvXOStatusHistory());
		if(bean.getSpecimen() != null)
		{
			this.specimen = new ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection();
			for(int specimen_i = 0; specimen_i < bean.getSpecimen().length; specimen_i++)
			{
				this.specimen.add(new ims.ocrr.orderingresults.vo.OrderSpecimenRefVo(new Integer(bean.getSpecimen()[specimen_i].getId()), bean.getSpecimen()[specimen_i].getVersion()));
			}
		}
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.placerordnum = bean.getPlacerOrdNum();
		this.reorderreason = bean.getReorderReason();
		this.collectiontype = bean.getCollectionType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionType.buildLookup(bean.getCollectionType());
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.accessionnumber = bean.getAccessionNumber();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderInvestigationListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		this.ordinvstatushistory = ims.ocrr.vo.OrderedInvestigationStatusVoCollection.buildFromBeanCollection(bean.getOrdInvStatusHistory());
		this.requestedlocation = bean.getRequestedLocation() == null ? null : bean.getRequestedLocation().buildVo(map);
		this.passessecurity = bean.getPassesSecurity();
		this.ordinvxostatushistory = ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection.buildFromBeanCollection(bean.getOrdInvXOStatusHistory());
		if(bean.getSpecimen() != null)
		{
			this.specimen = new ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection();
			for(int specimen_i = 0; specimen_i < bean.getSpecimen().length; specimen_i++)
			{
				this.specimen.add(new ims.ocrr.orderingresults.vo.OrderSpecimenRefVo(new Integer(bean.getSpecimen()[specimen_i].getId()), bean.getSpecimen()[specimen_i].getVersion()));
			}
		}
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.placerordnum = bean.getPlacerOrdNum();
		this.reorderreason = bean.getReorderReason();
		this.collectiontype = bean.getCollectionType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionType.buildLookup(bean.getCollectionType());
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.accessionnumber = bean.getAccessionNumber();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderInvestigationListVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderInvestigationListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderInvestigationListVoBean();
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
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("ORDINVSTATUSHISTORY"))
			return getOrdInvStatusHistory();
		if(fieldName.equals("REQUESTEDLOCATION"))
			return getRequestedLocation();
		if(fieldName.equals("PASSESSECURITY"))
			return getPassesSecurity();
		if(fieldName.equals("ORDINVXOSTATUSHISTORY"))
			return getOrdInvXOStatusHistory();
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("EXPECTEDDATETIME"))
			return getExpectedDateTime();
		if(fieldName.equals("PLACERORDNUM"))
			return getPlacerOrdNum();
		if(fieldName.equals("REORDERREASON"))
			return getReorderReason();
		if(fieldName.equals("COLLECTIONTYPE"))
			return getCollectionType();
		if(fieldName.equals("REQUIREDBYDATE"))
			return getRequiredByDate();
		if(fieldName.equals("ACCESSIONNUMBER"))
			return getAccessionNumber();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.InvestigationUnderSpecimenListVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.InvestigationUnderSpecimenListVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrdInvCurrentStatusIsNotNull()
	{
		return this.ordinvcurrentstatus != null;
	}
	public ims.ocrr.vo.OrderedInvestigationStatusVo getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.OrderedInvestigationStatusVo value)
	{
		this.isValidated = false;
		this.ordinvcurrentstatus = value;
	}
	public boolean getOrdInvStatusHistoryIsNotNull()
	{
		return this.ordinvstatushistory != null;
	}
	public ims.ocrr.vo.OrderedInvestigationStatusVoCollection getOrdInvStatusHistory()
	{
		return this.ordinvstatushistory;
	}
	public void setOrdInvStatusHistory(ims.ocrr.vo.OrderedInvestigationStatusVoCollection value)
	{
		this.isValidated = false;
		this.ordinvstatushistory = value;
	}
	public boolean getRequestedLocationIsNotNull()
	{
		return this.requestedlocation != null;
	}
	public ims.core.vo.LocationLiteVo getRequestedLocation()
	{
		return this.requestedlocation;
	}
	public void setRequestedLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.requestedlocation = value;
	}
	public boolean getPassesSecurityIsNotNull()
	{
		return this.passessecurity != null;
	}
	public Boolean getPassesSecurity()
	{
		return this.passessecurity;
	}
	public void setPassesSecurity(Boolean value)
	{
		this.isValidated = false;
		this.passessecurity = value;
	}
	public boolean getOrdInvXOStatusHistoryIsNotNull()
	{
		return this.ordinvxostatushistory != null;
	}
	public ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection getOrdInvXOStatusHistory()
	{
		return this.ordinvxostatushistory;
	}
	public void setOrdInvXOStatusHistory(ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection value)
	{
		this.isValidated = false;
		this.ordinvxostatushistory = value;
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
	}
	public boolean getExpectedDateTimeIsNotNull()
	{
		return this.expecteddatetime != null;
	}
	public ims.framework.utils.DateTime getExpectedDateTime()
	{
		return this.expecteddatetime;
	}
	public void setExpectedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.expecteddatetime = value;
	}
	public boolean getPlacerOrdNumIsNotNull()
	{
		return this.placerordnum != null;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public static int getPlacerOrdNumMaxLength()
	{
		return 20;
	}
	public void setPlacerOrdNum(String value)
	{
		this.isValidated = false;
		this.placerordnum = value;
	}
	public boolean getReorderReasonIsNotNull()
	{
		return this.reorderreason != null;
	}
	public String getReorderReason()
	{
		return this.reorderreason;
	}
	public static int getReorderReasonMaxLength()
	{
		return 255;
	}
	public void setReorderReason(String value)
	{
		this.isValidated = false;
		this.reorderreason = value;
	}
	public boolean getCollectionTypeIsNotNull()
	{
		return this.collectiontype != null;
	}
	public ims.ocrr.vo.lookups.SpecimenCollectionType getCollectionType()
	{
		return this.collectiontype;
	}
	public void setCollectionType(ims.ocrr.vo.lookups.SpecimenCollectionType value)
	{
		this.isValidated = false;
		this.collectiontype = value;
	}
	public boolean getRequiredByDateIsNotNull()
	{
		return this.requiredbydate != null;
	}
	public ims.framework.utils.DateTime getRequiredByDate()
	{
		return this.requiredbydate;
	}
	public void setRequiredByDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.requiredbydate = value;
	}
	public boolean getAccessionNumberIsNotNull()
	{
		return this.accessionnumber != null;
	}
	public String getAccessionNumber()
	{
		return this.accessionnumber;
	}
	public static int getAccessionNumberMaxLength()
	{
		return 200;
	}
	public void setAccessionNumber(String value)
	{
		this.isValidated = false;
		this.accessionnumber = value;
	}
	/**
	* IGenericItemType interface methods
	*/
		public ims.core.vo.enums.SelectItemType getIGenericItemTypeSelectItemType()
		{
			return ims.core.vo.enums.SelectItemType.ORDERINV;
		}
		
		public Integer getIGenericItemInfoID()
		{
			return this.id;
		}
		
		public Boolean getIGenericItemInfoIsActive()
		{
			return true;
		}
		public String getIGenericItemInfoName()
		{
			if(this.getInvestigationIsNotNull() && this.getInvestigation().getInvestigationIndexIsNotNull())
				return this.getInvestigation().getInvestigationIndex().getName();
			
			return "";
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
		if(this.investigation != null)
		{
			if(!this.investigation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ordinvcurrentstatus != null)
		{
			if(!this.ordinvcurrentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ordinvstatushistory != null)
		{
			if(!this.ordinvstatushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.requestedlocation != null)
		{
			if(!this.requestedlocation.isValidated())
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
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.investigation != null)
		{
			String[] listOfOtherErrors = this.investigation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ordinvcurrentstatus == null)
			listOfErrors.add("OrdInvCurrentStatus is mandatory");
		if(this.ordinvcurrentstatus != null)
		{
			String[] listOfOtherErrors = this.ordinvcurrentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ordinvstatushistory != null)
		{
			String[] listOfOtherErrors = this.ordinvstatushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.requestedlocation != null)
		{
			String[] listOfOtherErrors = this.requestedlocation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.placerordnum != null)
			if(this.placerordnum.length() > 20)
				listOfErrors.add("The length of the field [placerordnum] in the value object [ims.ocrr.vo.OrderInvestigationListVo] is too big. It should be less or equal to 20");
		if(this.reorderreason != null)
			if(this.reorderreason.length() > 255)
				listOfErrors.add("The length of the field [reorderreason] in the value object [ims.ocrr.vo.OrderInvestigationListVo] is too big. It should be less or equal to 255");
		if(this.accessionnumber != null)
			if(this.accessionnumber.length() > 200)
				listOfErrors.add("The length of the field [accessionnumber] in the value object [ims.ocrr.vo.OrderInvestigationListVo] is too big. It should be less or equal to 200");
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
	
		OrderInvestigationListVo clone = new OrderInvestigationListVo(this.id, this.version);
		
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.InvestigationUnderSpecimenListVo)this.investigation.clone();
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocrr.vo.OrderedInvestigationStatusVo)this.ordinvcurrentstatus.clone();
		if(this.ordinvstatushistory == null)
			clone.ordinvstatushistory = null;
		else
			clone.ordinvstatushistory = (ims.ocrr.vo.OrderedInvestigationStatusVoCollection)this.ordinvstatushistory.clone();
		if(this.requestedlocation == null)
			clone.requestedlocation = null;
		else
			clone.requestedlocation = (ims.core.vo.LocationLiteVo)this.requestedlocation.clone();
		clone.passessecurity = this.passessecurity;
		if(this.ordinvxostatushistory == null)
			clone.ordinvxostatushistory = null;
		else
			clone.ordinvxostatushistory = (ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection)this.ordinvxostatushistory.clone();
		clone.specimen = this.specimen;
		if(this.expecteddatetime == null)
			clone.expecteddatetime = null;
		else
			clone.expecteddatetime = (ims.framework.utils.DateTime)this.expecteddatetime.clone();
		clone.placerordnum = this.placerordnum;
		clone.reorderreason = this.reorderreason;
		if(this.collectiontype == null)
			clone.collectiontype = null;
		else
			clone.collectiontype = (ims.ocrr.vo.lookups.SpecimenCollectionType)this.collectiontype.clone();
		if(this.requiredbydate == null)
			clone.requiredbydate = null;
		else
			clone.requiredbydate = (ims.framework.utils.DateTime)this.requiredbydate.clone();
		clone.accessionnumber = this.accessionnumber;
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
		if (!(OrderInvestigationListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderInvestigationListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OrderInvestigationListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OrderInvestigationListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.investigation != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.ordinvstatushistory != null)
			count++;
		if(this.requestedlocation != null)
			count++;
		if(this.passessecurity != null)
			count++;
		if(this.ordinvxostatushistory != null)
			count++;
		if(this.specimen != null)
			count++;
		if(this.expecteddatetime != null)
			count++;
		if(this.placerordnum != null)
			count++;
		if(this.reorderreason != null)
			count++;
		if(this.collectiontype != null)
			count++;
		if(this.requiredbydate != null)
			count++;
		if(this.accessionnumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.ocrr.vo.InvestigationUnderSpecimenListVo investigation;
	protected ims.ocrr.vo.OrderedInvestigationStatusVo ordinvcurrentstatus;
	protected ims.ocrr.vo.OrderedInvestigationStatusVoCollection ordinvstatushistory;
	protected ims.core.vo.LocationLiteVo requestedlocation;
	protected Boolean passessecurity;
	protected ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection ordinvxostatushistory;
	protected ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection specimen;
	protected ims.framework.utils.DateTime expecteddatetime;
	protected String placerordnum;
	protected String reorderreason;
	protected ims.ocrr.vo.lookups.SpecimenCollectionType collectiontype;
	protected ims.framework.utils.DateTime requiredbydate;
	protected String accessionnumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
