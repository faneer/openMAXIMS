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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class OrderInvestigationVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderInvestigationVo()
	{
	}
	public OrderInvestigationVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderInvestigationVo(ims.ocrr.vo.beans.OrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.orderpriority = bean.getOrderPriority() == null ? null : ims.ocrr.vo.lookups.OrderPriority.buildLookup(bean.getOrderPriority());
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.wasordered = bean.getWasOrdered();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		if(bean.getSpecimen() != null)
		{
			this.specimen = new ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection();
			for(int specimen_i = 0; specimen_i < bean.getSpecimen().length; specimen_i++)
			{
				this.specimen.add(new ims.ocrr.orderingresults.vo.OrderSpecimenRefVo(new Integer(bean.getSpecimen()[specimen_i].getId()), bean.getSpecimen()[specimen_i].getVersion()));
			}
		}
		this.orderdetails = bean.getOrderDetails() == null ? null : new ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo(new Integer(bean.getOrderDetails().getId()), bean.getOrderDetails().getVersion());
		this.ordinvseq = bean.getOrdInvSeq();
		this.requestedlocation = bean.getRequestedLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getRequestedLocation().getId()), bean.getRequestedLocation().getVersion());
		this.sitecd = bean.getSiteCd() == null ? null : ims.ocrr.vo.lookups.SpecimenSite.buildLookup(bean.getSiteCd());
		this.accessionnumber = bean.getAccessionNumber();
		this.hascontainerchoice = bean.getHasContainerChoice();
		this.chosencontainer = bean.getChosenContainer() == null ? null : bean.getChosenContainer().buildVo();
		this.container = ims.ocrr.vo.OrderSpecimenContainerVoCollection.buildFromBeanCollection(bean.getContainer());
		this.reorderreason = bean.getReorderReason();
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.ordinvstatushistory = ims.ocrr.vo.OrderedInvestigationStatusVoCollection.buildFromBeanCollection(bean.getOrdInvStatusHistory());
		this.collectiontype = bean.getCollectionType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionType.buildLookup(bean.getCollectionType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.orderpriority = bean.getOrderPriority() == null ? null : ims.ocrr.vo.lookups.OrderPriority.buildLookup(bean.getOrderPriority());
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.wasordered = bean.getWasOrdered();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		if(bean.getSpecimen() != null)
		{
			this.specimen = new ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection();
			for(int specimen_i = 0; specimen_i < bean.getSpecimen().length; specimen_i++)
			{
				this.specimen.add(new ims.ocrr.orderingresults.vo.OrderSpecimenRefVo(new Integer(bean.getSpecimen()[specimen_i].getId()), bean.getSpecimen()[specimen_i].getVersion()));
			}
		}
		this.orderdetails = bean.getOrderDetails() == null ? null : new ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo(new Integer(bean.getOrderDetails().getId()), bean.getOrderDetails().getVersion());
		this.ordinvseq = bean.getOrdInvSeq();
		this.requestedlocation = bean.getRequestedLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getRequestedLocation().getId()), bean.getRequestedLocation().getVersion());
		this.sitecd = bean.getSiteCd() == null ? null : ims.ocrr.vo.lookups.SpecimenSite.buildLookup(bean.getSiteCd());
		this.accessionnumber = bean.getAccessionNumber();
		this.hascontainerchoice = bean.getHasContainerChoice();
		this.chosencontainer = bean.getChosenContainer() == null ? null : bean.getChosenContainer().buildVo(map);
		this.container = ims.ocrr.vo.OrderSpecimenContainerVoCollection.buildFromBeanCollection(bean.getContainer());
		this.reorderreason = bean.getReorderReason();
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.ordinvstatushistory = ims.ocrr.vo.OrderedInvestigationStatusVoCollection.buildFromBeanCollection(bean.getOrdInvStatusHistory());
		this.collectiontype = bean.getCollectionType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionType.buildLookup(bean.getCollectionType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderInvestigationVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderInvestigationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderInvestigationVoBean();
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
		if(fieldName.equals("ORDERPRIORITY"))
			return getOrderPriority();
		if(fieldName.equals("DISPLAYDATETIME"))
			return getDisplayDateTime();
		if(fieldName.equals("DISPLAYFLAG"))
			return getDisplayFlag();
		if(fieldName.equals("WASORDERED"))
			return getWasOrdered();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("ORDINVSEQ"))
			return getOrdInvSeq();
		if(fieldName.equals("REQUESTEDLOCATION"))
			return getRequestedLocation();
		if(fieldName.equals("SITECD"))
			return getSiteCd();
		if(fieldName.equals("ACCESSIONNUMBER"))
			return getAccessionNumber();
		if(fieldName.equals("HASCONTAINERCHOICE"))
			return getHasContainerChoice();
		if(fieldName.equals("CHOSENCONTAINER"))
			return getChosenContainer();
		if(fieldName.equals("CONTAINER"))
			return getContainer();
		if(fieldName.equals("REORDERREASON"))
			return getReorderReason();
		if(fieldName.equals("REQUIREDBYDATE"))
			return getRequiredByDate();
		if(fieldName.equals("ORDINVSTATUSHISTORY"))
			return getOrdInvStatusHistory();
		if(fieldName.equals("COLLECTIONTYPE"))
			return getCollectionType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.InvestigationUnderSpecimenVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.InvestigationUnderSpecimenVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrderPriorityIsNotNull()
	{
		return this.orderpriority != null;
	}
	public ims.ocrr.vo.lookups.OrderPriority getOrderPriority()
	{
		return this.orderpriority;
	}
	public void setOrderPriority(ims.ocrr.vo.lookups.OrderPriority value)
	{
		this.isValidated = false;
		this.orderpriority = value;
	}
	public boolean getDisplayDateTimeIsNotNull()
	{
		return this.displaydatetime != null;
	}
	public ims.framework.utils.DateTime getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.displaydatetime = value;
	}
	public boolean getDisplayFlagIsNotNull()
	{
		return this.displayflag != null;
	}
	public ims.ocrr.vo.lookups.OcsDisplayFlag getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.ocrr.vo.lookups.OcsDisplayFlag value)
	{
		this.isValidated = false;
		this.displayflag = value;
	}
	public boolean getWasOrderedIsNotNull()
	{
		return this.wasordered != null;
	}
	public Boolean getWasOrdered()
	{
		return this.wasordered;
	}
	public void setWasOrdered(Boolean value)
	{
		this.isValidated = false;
		this.wasordered = value;
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
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
	}
	public boolean getOrdInvSeqIsNotNull()
	{
		return this.ordinvseq != null;
	}
	public Integer getOrdInvSeq()
	{
		return this.ordinvseq;
	}
	public void setOrdInvSeq(Integer value)
	{
		this.isValidated = false;
		this.ordinvseq = value;
	}
	public boolean getRequestedLocationIsNotNull()
	{
		return this.requestedlocation != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getRequestedLocation()
	{
		return this.requestedlocation;
	}
	public void setRequestedLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.requestedlocation = value;
	}
	public boolean getSiteCdIsNotNull()
	{
		return this.sitecd != null;
	}
	public ims.ocrr.vo.lookups.SpecimenSite getSiteCd()
	{
		return this.sitecd;
	}
	public void setSiteCd(ims.ocrr.vo.lookups.SpecimenSite value)
	{
		this.isValidated = false;
		this.sitecd = value;
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
	public boolean getHasContainerChoiceIsNotNull()
	{
		return this.hascontainerchoice != null;
	}
	public Boolean getHasContainerChoice()
	{
		return this.hascontainerchoice;
	}
	public void setHasContainerChoice(Boolean value)
	{
		this.isValidated = false;
		this.hascontainerchoice = value;
	}
	public boolean getChosenContainerIsNotNull()
	{
		return this.chosencontainer != null;
	}
	public ims.ocrr.vo.SpecimenContainerVo getChosenContainer()
	{
		return this.chosencontainer;
	}
	public void setChosenContainer(ims.ocrr.vo.SpecimenContainerVo value)
	{
		this.isValidated = false;
		this.chosencontainer = value;
	}
	public boolean getContainerIsNotNull()
	{
		return this.container != null;
	}
	public ims.ocrr.vo.OrderSpecimenContainerVoCollection getContainer()
	{
		return this.container;
	}
	public void setContainer(ims.ocrr.vo.OrderSpecimenContainerVoCollection value)
	{
		this.isValidated = false;
		this.container = value;
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
		if(this.ordinvcurrentstatus != null)
		{
			if(!this.ordinvcurrentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.container != null)
		{
			if(!this.container.isValidated())
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
		if(this.displaydatetime == null)
			listOfErrors.add("DisplayDateTime is mandatory");
		if(this.displayflag == null)
			listOfErrors.add("DisplayFlag is mandatory");
		if(this.wasordered == null)
			listOfErrors.add("wasOrdered is mandatory");
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
		if(this.orderdetails == null)
			listOfErrors.add("OrderDetails is mandatory");
		if(this.ordinvseq == null)
			listOfErrors.add("ordInvSeq is mandatory");
		if(this.accessionnumber != null)
			if(this.accessionnumber.length() > 200)
				listOfErrors.add("The length of the field [accessionnumber] in the value object [ims.ocrr.vo.OrderInvestigationVo] is too big. It should be less or equal to 200");
		if(this.container != null)
		{
			String[] listOfOtherErrors = this.container.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.reorderreason != null)
			if(this.reorderreason.length() > 255)
				listOfErrors.add("The length of the field [reorderreason] in the value object [ims.ocrr.vo.OrderInvestigationVo] is too big. It should be less or equal to 255");
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
	
		OrderInvestigationVo clone = new OrderInvestigationVo(this.id, this.version);
		
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.InvestigationUnderSpecimenVo)this.investigation.clone();
		if(this.orderpriority == null)
			clone.orderpriority = null;
		else
			clone.orderpriority = (ims.ocrr.vo.lookups.OrderPriority)this.orderpriority.clone();
		if(this.displaydatetime == null)
			clone.displaydatetime = null;
		else
			clone.displaydatetime = (ims.framework.utils.DateTime)this.displaydatetime.clone();
		if(this.displayflag == null)
			clone.displayflag = null;
		else
			clone.displayflag = (ims.ocrr.vo.lookups.OcsDisplayFlag)this.displayflag.clone();
		clone.wasordered = this.wasordered;
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocrr.vo.OrderedInvestigationStatusVo)this.ordinvcurrentstatus.clone();
		clone.specimen = this.specimen;
		clone.orderdetails = this.orderdetails;
		clone.ordinvseq = this.ordinvseq;
		clone.requestedlocation = this.requestedlocation;
		if(this.sitecd == null)
			clone.sitecd = null;
		else
			clone.sitecd = (ims.ocrr.vo.lookups.SpecimenSite)this.sitecd.clone();
		clone.accessionnumber = this.accessionnumber;
		clone.hascontainerchoice = this.hascontainerchoice;
		if(this.chosencontainer == null)
			clone.chosencontainer = null;
		else
			clone.chosencontainer = (ims.ocrr.vo.SpecimenContainerVo)this.chosencontainer.clone();
		if(this.container == null)
			clone.container = null;
		else
			clone.container = (ims.ocrr.vo.OrderSpecimenContainerVoCollection)this.container.clone();
		clone.reorderreason = this.reorderreason;
		if(this.requiredbydate == null)
			clone.requiredbydate = null;
		else
			clone.requiredbydate = (ims.framework.utils.DateTime)this.requiredbydate.clone();
		if(this.ordinvstatushistory == null)
			clone.ordinvstatushistory = null;
		else
			clone.ordinvstatushistory = (ims.ocrr.vo.OrderedInvestigationStatusVoCollection)this.ordinvstatushistory.clone();
		if(this.collectiontype == null)
			clone.collectiontype = null;
		else
			clone.collectiontype = (ims.ocrr.vo.lookups.SpecimenCollectionType)this.collectiontype.clone();
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
		if (!(OrderInvestigationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderInvestigationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OrderInvestigationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OrderInvestigationVo)obj).getBoId());
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
		if(this.orderpriority != null)
			count++;
		if(this.displaydatetime != null)
			count++;
		if(this.displayflag != null)
			count++;
		if(this.wasordered != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.specimen != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.ordinvseq != null)
			count++;
		if(this.requestedlocation != null)
			count++;
		if(this.sitecd != null)
			count++;
		if(this.accessionnumber != null)
			count++;
		if(this.hascontainerchoice != null)
			count++;
		if(this.chosencontainer != null)
			count++;
		if(this.container != null)
			count++;
		if(this.reorderreason != null)
			count++;
		if(this.requiredbydate != null)
			count++;
		if(this.ordinvstatushistory != null)
			count++;
		if(this.collectiontype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 19;
	}
	protected ims.ocrr.vo.InvestigationUnderSpecimenVo investigation;
	protected ims.ocrr.vo.lookups.OrderPriority orderpriority;
	protected ims.framework.utils.DateTime displaydatetime;
	protected ims.ocrr.vo.lookups.OcsDisplayFlag displayflag;
	protected Boolean wasordered;
	protected ims.ocrr.vo.OrderedInvestigationStatusVo ordinvcurrentstatus;
	protected ims.ocrr.orderingresults.vo.OrderSpecimenRefVoCollection specimen;
	protected ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo orderdetails;
	protected Integer ordinvseq;
	protected ims.core.resource.place.vo.LocationRefVo requestedlocation;
	protected ims.ocrr.vo.lookups.SpecimenSite sitecd;
	protected String accessionnumber;
	protected Boolean hascontainerchoice;
	protected ims.ocrr.vo.SpecimenContainerVo chosencontainer;
	protected ims.ocrr.vo.OrderSpecimenContainerVoCollection container;
	protected String reorderreason;
	protected ims.framework.utils.DateTime requiredbydate;
	protected ims.ocrr.vo.OrderedInvestigationStatusVoCollection ordinvstatushistory;
	protected ims.ocrr.vo.lookups.SpecimenCollectionType collectiontype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}