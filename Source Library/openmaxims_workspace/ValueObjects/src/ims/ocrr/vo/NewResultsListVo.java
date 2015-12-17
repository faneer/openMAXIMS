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
public class NewResultsListVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NewResultsListVo()
	{
	}
	public NewResultsListVo(Integer id, int version)
	{
		super(id, version);
	}
	public NewResultsListVo(ims.ocrr.vo.beans.NewResultsListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		this.specimen = ims.ocrr.vo.OrderSpecimenCommentsVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvxostatushistory = ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection.buildFromBeanCollection(bean.getOrdInvXOStatusHistory());
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo();
		this.allocatedhcpforreview = bean.getAllocatedHCPforReview() == null ? null : bean.getAllocatedHCPforReview().buildVo();
		this.allocateddateforreview = bean.getAllocatedDateForReview() == null ? null : bean.getAllocatedDateForReview().buildDateTime();
		this.ordinvseq = bean.getOrdInvSeq();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.NewResultsListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo(map);
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		this.specimen = ims.ocrr.vo.OrderSpecimenCommentsVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvxostatushistory = ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection.buildFromBeanCollection(bean.getOrdInvXOStatusHistory());
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo(map);
		this.allocatedhcpforreview = bean.getAllocatedHCPforReview() == null ? null : bean.getAllocatedHCPforReview().buildVo(map);
		this.allocateddateforreview = bean.getAllocatedDateForReview() == null ? null : bean.getAllocatedDateForReview().buildDateTime();
		this.ordinvseq = bean.getOrdInvSeq();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.NewResultsListVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.NewResultsListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.NewResultsListVoBean();
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
		if(fieldName.equals("DISPLAYDATETIME"))
			return getDisplayDateTime();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("REPDATETIME"))
			return getRepDateTime();
		if(fieldName.equals("RESULTSTATUS"))
			return getResultStatus();
		if(fieldName.equals("ORDINVXOSTATUSHISTORY"))
			return getOrdInvXOStatusHistory();
		if(fieldName.equals("RESULTCONCLUSIONCOMMENTS"))
			return getResultConclusionComments();
		if(fieldName.equals("RESULTDETAILS"))
			return getResultDetails();
		if(fieldName.equals("ALLOCATEDHCPFORREVIEW"))
			return getAllocatedHCPforReview();
		if(fieldName.equals("ALLOCATEDDATEFORREVIEW"))
			return getAllocatedDateForReview();
		if(fieldName.equals("ORDINVSEQ"))
			return getOrdInvSeq();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.vo.NewResultsListOrderDetailsVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.NewResultsListOrderDetailsVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.NewResultsListInvestigationVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.NewResultsListInvestigationVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrdInvCurrentStatusIsNotNull()
	{
		return this.ordinvcurrentstatus != null;
	}
	public ims.ocrr.vo.NewResultsListOrderInvestigationStatusVo getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.NewResultsListOrderInvestigationStatusVo value)
	{
		this.isValidated = false;
		this.ordinvcurrentstatus = value;
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocrr.vo.OrderSpecimenCommentsVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.OrderSpecimenCommentsVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
	}
	public boolean getRepDateTimeIsNotNull()
	{
		return this.repdatetime != null;
	}
	public ims.framework.utils.DateTime getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.repdatetime = value;
	}
	public boolean getResultStatusIsNotNull()
	{
		return this.resultstatus != null;
	}
	public ims.ocrr.vo.lookups.ResultStatus getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.ocrr.vo.lookups.ResultStatus value)
	{
		this.isValidated = false;
		this.resultstatus = value;
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
	public boolean getResultConclusionCommentsIsNotNull()
	{
		return this.resultconclusioncomments != null;
	}
	public ims.ocrr.vo.ResultCommentsLiteVoCollection getResultConclusionComments()
	{
		return this.resultconclusioncomments;
	}
	public void setResultConclusionComments(ims.ocrr.vo.ResultCommentsLiteVoCollection value)
	{
		this.isValidated = false;
		this.resultconclusioncomments = value;
	}
	public boolean getResultDetailsIsNotNull()
	{
		return this.resultdetails != null;
	}
	public ims.ocrr.vo.ResultDetailsForNewResultsListVo getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.ResultDetailsForNewResultsListVo value)
	{
		this.isValidated = false;
		this.resultdetails = value;
	}
	public boolean getAllocatedHCPforReviewIsNotNull()
	{
		return this.allocatedhcpforreview != null;
	}
	public ims.core.vo.HcpLiteVo getAllocatedHCPforReview()
	{
		return this.allocatedhcpforreview;
	}
	public void setAllocatedHCPforReview(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.allocatedhcpforreview = value;
	}
	public boolean getAllocatedDateForReviewIsNotNull()
	{
		return this.allocateddateforreview != null;
	}
	public ims.framework.utils.DateTime getAllocatedDateForReview()
	{
		return this.allocateddateforreview;
	}
	public void setAllocatedDateForReview(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.allocateddateforreview = value;
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
		if(this.orderdetails != null)
		{
			if(!this.orderdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.specimen != null)
		{
			if(!this.specimen.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resultdetails != null)
		{
			if(!this.resultdetails.isValidated())
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
		if(this.displaydatetime == null)
			listOfErrors.add("DisplayDateTime is mandatory");
		if(this.orderdetails == null)
			listOfErrors.add("OrderDetails is mandatory");
		if(this.orderdetails != null)
		{
			String[] listOfOtherErrors = this.orderdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
		if(this.specimen != null)
		{
			String[] listOfOtherErrors = this.specimen.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.resultdetails != null)
		{
			String[] listOfOtherErrors = this.resultdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ordinvseq == null)
			listOfErrors.add("ordInvSeq is mandatory");
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
	
		NewResultsListVo clone = new NewResultsListVo(this.id, this.version);
		
		if(this.displaydatetime == null)
			clone.displaydatetime = null;
		else
			clone.displaydatetime = (ims.framework.utils.DateTime)this.displaydatetime.clone();
		if(this.orderdetails == null)
			clone.orderdetails = null;
		else
			clone.orderdetails = (ims.ocrr.vo.NewResultsListOrderDetailsVo)this.orderdetails.clone();
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.NewResultsListInvestigationVo)this.investigation.clone();
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocrr.vo.NewResultsListOrderInvestigationStatusVo)this.ordinvcurrentstatus.clone();
		if(this.specimen == null)
			clone.specimen = null;
		else
			clone.specimen = (ims.ocrr.vo.OrderSpecimenCommentsVoCollection)this.specimen.clone();
		if(this.repdatetime == null)
			clone.repdatetime = null;
		else
			clone.repdatetime = (ims.framework.utils.DateTime)this.repdatetime.clone();
		if(this.resultstatus == null)
			clone.resultstatus = null;
		else
			clone.resultstatus = (ims.ocrr.vo.lookups.ResultStatus)this.resultstatus.clone();
		if(this.ordinvxostatushistory == null)
			clone.ordinvxostatushistory = null;
		else
			clone.ordinvxostatushistory = (ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection)this.ordinvxostatushistory.clone();
		if(this.resultconclusioncomments == null)
			clone.resultconclusioncomments = null;
		else
			clone.resultconclusioncomments = (ims.ocrr.vo.ResultCommentsLiteVoCollection)this.resultconclusioncomments.clone();
		if(this.resultdetails == null)
			clone.resultdetails = null;
		else
			clone.resultdetails = (ims.ocrr.vo.ResultDetailsForNewResultsListVo)this.resultdetails.clone();
		if(this.allocatedhcpforreview == null)
			clone.allocatedhcpforreview = null;
		else
			clone.allocatedhcpforreview = (ims.core.vo.HcpLiteVo)this.allocatedhcpforreview.clone();
		if(this.allocateddateforreview == null)
			clone.allocateddateforreview = null;
		else
			clone.allocateddateforreview = (ims.framework.utils.DateTime)this.allocateddateforreview.clone();
		clone.ordinvseq = this.ordinvseq;
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
		if (!(NewResultsListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NewResultsListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NewResultsListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NewResultsListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.displaydatetime != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.investigation != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.specimen != null)
			count++;
		if(this.repdatetime != null)
			count++;
		if(this.resultstatus != null)
			count++;
		if(this.ordinvxostatushistory != null)
			count++;
		if(this.resultconclusioncomments != null)
			count++;
		if(this.resultdetails != null)
			count++;
		if(this.allocatedhcpforreview != null)
			count++;
		if(this.allocateddateforreview != null)
			count++;
		if(this.ordinvseq != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.framework.utils.DateTime displaydatetime;
	protected ims.ocrr.vo.NewResultsListOrderDetailsVo orderdetails;
	protected ims.ocrr.vo.NewResultsListInvestigationVo investigation;
	protected ims.ocrr.vo.NewResultsListOrderInvestigationStatusVo ordinvcurrentstatus;
	protected ims.ocrr.vo.OrderSpecimenCommentsVoCollection specimen;
	protected ims.framework.utils.DateTime repdatetime;
	protected ims.ocrr.vo.lookups.ResultStatus resultstatus;
	protected ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection ordinvxostatushistory;
	protected ims.ocrr.vo.ResultCommentsLiteVoCollection resultconclusioncomments;
	protected ims.ocrr.vo.ResultDetailsForNewResultsListVo resultdetails;
	protected ims.core.vo.HcpLiteVo allocatedhcpforreview;
	protected ims.framework.utils.DateTime allocateddateforreview;
	protected Integer ordinvseq;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
