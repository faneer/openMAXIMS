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
 * Linked to OCRR.OrderingResults.ResultComponent business object (ID: 1070100008).
 */
public class ChartResultVo extends ims.ocrr.orderingresults.vo.ResultComponentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChartResultVo()
	{
	}
	public ChartResultVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChartResultVo(ims.core.vo.beans.ChartResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.analyte = bean.getAnalyte() == null ? null : bean.getAnalyte().buildVo();
		this.resultval = bean.getResultVal();
		this.isabnormal = bean.getIsAbnormal();
		this.obsdatetime = bean.getObsDateTime() == null ? null : bean.getObsDateTime().buildDateTime();
		this.obstimesupplied = bean.getObsTimeSupplied();
		this.comments = ims.ocrr.vo.ResultComponentCommentsVoCollection.buildFromBeanCollection(bean.getComments());
		this.refrange = bean.getRefRange();
		this.investigationdata = bean.getInvestigationData() == null ? null : bean.getInvestigationData().buildVo();
		this.specimencomments = bean.getSpecimenComments() == null ? null : bean.getSpecimenComments().buildVo();
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.pathologyresultid = bean.getPathologyResultId();
		this.resvaltype = bean.getResValType() == null ? null : ims.ocrr.vo.lookups.ResultValueType.buildLookup(bean.getResValType());
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.analyte = bean.getAnalyte() == null ? null : bean.getAnalyte().buildVo(map);
		this.resultval = bean.getResultVal();
		this.isabnormal = bean.getIsAbnormal();
		this.obsdatetime = bean.getObsDateTime() == null ? null : bean.getObsDateTime().buildDateTime();
		this.obstimesupplied = bean.getObsTimeSupplied();
		this.comments = ims.ocrr.vo.ResultComponentCommentsVoCollection.buildFromBeanCollection(bean.getComments());
		this.refrange = bean.getRefRange();
		this.investigationdata = bean.getInvestigationData() == null ? null : bean.getInvestigationData().buildVo(map);
		this.specimencomments = bean.getSpecimenComments() == null ? null : bean.getSpecimenComments().buildVo(map);
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.pathologyresultid = bean.getPathologyResultId();
		this.resvaltype = bean.getResValType() == null ? null : ims.ocrr.vo.lookups.ResultValueType.buildLookup(bean.getResValType());
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartResultVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartResultVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartResultVoBean();
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
		if(fieldName.equals("ANALYTE"))
			return getAnalyte();
		if(fieldName.equals("RESULTVAL"))
			return getResultVal();
		if(fieldName.equals("ISABNORMAL"))
			return getIsAbnormal();
		if(fieldName.equals("OBSDATETIME"))
			return getObsDateTime();
		if(fieldName.equals("OBSTIMESUPPLIED"))
			return getObsTimeSupplied();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("REFRANGE"))
			return getRefRange();
		if(fieldName.equals("INVESTIGATIONDATA"))
			return getInvestigationData();
		if(fieldName.equals("SPECIMENCOMMENTS"))
			return getSpecimenComments();
		if(fieldName.equals("SPECIMENSOURCE"))
			return getSpecimenSource();
		if(fieldName.equals("RESULTSPECIMENTYPE"))
			return getResultSpecimenType();
		if(fieldName.equals("PATHOLOGYRESULTID"))
			return getPathologyResultId();
		if(fieldName.equals("RESVALTYPE"))
			return getResValType();
		if(fieldName.equals("UNITOFMEASURE"))
			return getUnitOfMeasure();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAnalyteIsNotNull()
	{
		return this.analyte != null;
	}
	public ims.ocrr.vo.ChartResultAnalyteVo getAnalyte()
	{
		return this.analyte;
	}
	public void setAnalyte(ims.ocrr.vo.ChartResultAnalyteVo value)
	{
		this.isValidated = false;
		this.analyte = value;
	}
	public boolean getResultValIsNotNull()
	{
		return this.resultval != null;
	}
	public String getResultVal()
	{
		return this.resultval;
	}
	public static int getResultValMaxLength()
	{
		return 1000;
	}
	public void setResultVal(String value)
	{
		this.isValidated = false;
		this.resultval = value;
	}
	public boolean getIsAbnormalIsNotNull()
	{
		return this.isabnormal != null;
	}
	public Boolean getIsAbnormal()
	{
		return this.isabnormal;
	}
	public void setIsAbnormal(Boolean value)
	{
		this.isValidated = false;
		this.isabnormal = value;
	}
	public boolean getObsDateTimeIsNotNull()
	{
		return this.obsdatetime != null;
	}
	public ims.framework.utils.DateTime getObsDateTime()
	{
		return this.obsdatetime;
	}
	public void setObsDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.obsdatetime = value;
	}
	public boolean getObsTimeSuppliedIsNotNull()
	{
		return this.obstimesupplied != null;
	}
	public Boolean getObsTimeSupplied()
	{
		return this.obstimesupplied;
	}
	public void setObsTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.obstimesupplied = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public ims.ocrr.vo.ResultComponentCommentsVoCollection getComments()
	{
		return this.comments;
	}
	public void setComments(ims.ocrr.vo.ResultComponentCommentsVoCollection value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getRefRangeIsNotNull()
	{
		return this.refrange != null;
	}
	public String getRefRange()
	{
		return this.refrange;
	}
	public static int getRefRangeMaxLength()
	{
		return 60;
	}
	public void setRefRange(String value)
	{
		this.isValidated = false;
		this.refrange = value;
	}
	public boolean getInvestigationDataIsNotNull()
	{
		return this.investigationdata != null;
	}
	public ims.ocrr.vo.OrderInvestigationChartVo getInvestigationData()
	{
		return this.investigationdata;
	}
	public void setInvestigationData(ims.ocrr.vo.OrderInvestigationChartVo value)
	{
		this.isValidated = false;
		this.investigationdata = value;
	}
	public boolean getSpecimenCommentsIsNotNull()
	{
		return this.specimencomments != null;
	}
	public ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo getSpecimenComments()
	{
		return this.specimencomments;
	}
	public void setSpecimenComments(ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo value)
	{
		this.isValidated = false;
		this.specimencomments = value;
	}
	public boolean getSpecimenSourceIsNotNull()
	{
		return this.specimensource != null;
	}
	public ims.ocrr.vo.lookups.SpecimenType getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.ocrr.vo.lookups.SpecimenType value)
	{
		this.isValidated = false;
		this.specimensource = value;
	}
	public boolean getResultSpecimenTypeIsNotNull()
	{
		return this.resultspecimentype != null;
	}
	public ims.vo.LookupInstVo getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstVo value)
	{
		this.isValidated = false;
		this.resultspecimentype = value;
	}
	public boolean getPathologyResultIdIsNotNull()
	{
		return this.pathologyresultid != null;
	}
	public Integer getPathologyResultId()
	{
		return this.pathologyresultid;
	}
	public void setPathologyResultId(Integer value)
	{
		this.isValidated = false;
		this.pathologyresultid = value;
	}
	public boolean getResValTypeIsNotNull()
	{
		return this.resvaltype != null;
	}
	public ims.ocrr.vo.lookups.ResultValueType getResValType()
	{
		return this.resvaltype;
	}
	public void setResValType(ims.ocrr.vo.lookups.ResultValueType value)
	{
		this.isValidated = false;
		this.resvaltype = value;
	}
	public boolean getUnitOfMeasureIsNotNull()
	{
		return this.unitofmeasure != null;
	}
	public ims.ocrr.vo.lookups.ResultUnitOfMeasure getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.ocrr.vo.lookups.ResultUnitOfMeasure value)
	{
		this.isValidated = false;
		this.unitofmeasure = value;
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
		if(this.analyte != null)
		{
			if(!this.analyte.isValidated())
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
		if(this.analyte == null)
			listOfErrors.add("Analyte is mandatory");
		if(this.analyte != null)
		{
			String[] listOfOtherErrors = this.analyte.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.resultval != null)
			if(this.resultval.length() > 1000)
				listOfErrors.add("The length of the field [resultval] in the value object [ims.core.vo.ChartResultVo] is too big. It should be less or equal to 1000");
		if(this.isabnormal == null)
			listOfErrors.add("isAbnormal is mandatory");
		if(this.obsdatetime == null)
			listOfErrors.add("ObsDateTime is mandatory");
		if(this.obstimesupplied == null)
			listOfErrors.add("ObsTimeSupplied is mandatory");
		if(this.refrange != null)
			if(this.refrange.length() > 60)
				listOfErrors.add("The length of the field [refrange] in the value object [ims.core.vo.ChartResultVo] is too big. It should be less or equal to 60");
		if(this.resvaltype == null)
			listOfErrors.add("ResValType is mandatory");
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
	
		ChartResultVo clone = new ChartResultVo(this.id, this.version);
		
		if(this.analyte == null)
			clone.analyte = null;
		else
			clone.analyte = (ims.ocrr.vo.ChartResultAnalyteVo)this.analyte.clone();
		clone.resultval = this.resultval;
		clone.isabnormal = this.isabnormal;
		if(this.obsdatetime == null)
			clone.obsdatetime = null;
		else
			clone.obsdatetime = (ims.framework.utils.DateTime)this.obsdatetime.clone();
		clone.obstimesupplied = this.obstimesupplied;
		if(this.comments == null)
			clone.comments = null;
		else
			clone.comments = (ims.ocrr.vo.ResultComponentCommentsVoCollection)this.comments.clone();
		clone.refrange = this.refrange;
		if(this.investigationdata == null)
			clone.investigationdata = null;
		else
			clone.investigationdata = (ims.ocrr.vo.OrderInvestigationChartVo)this.investigationdata.clone();
		if(this.specimencomments == null)
			clone.specimencomments = null;
		else
			clone.specimencomments = (ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo)this.specimencomments.clone();
		if(this.specimensource == null)
			clone.specimensource = null;
		else
			clone.specimensource = (ims.ocrr.vo.lookups.SpecimenType)this.specimensource.clone();
		clone.resultspecimentype = this.resultspecimentype;
		clone.pathologyresultid = this.pathologyresultid;
		if(this.resvaltype == null)
			clone.resvaltype = null;
		else
			clone.resvaltype = (ims.ocrr.vo.lookups.ResultValueType)this.resvaltype.clone();
		if(this.unitofmeasure == null)
			clone.unitofmeasure = null;
		else
			clone.unitofmeasure = (ims.ocrr.vo.lookups.ResultUnitOfMeasure)this.unitofmeasure.clone();
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
		if (!(ChartResultVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartResultVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ChartResultVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ChartResultVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.analyte != null)
			count++;
		if(this.resultval != null)
			count++;
		if(this.isabnormal != null)
			count++;
		if(this.obsdatetime != null)
			count++;
		if(this.obstimesupplied != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.refrange != null)
			count++;
		if(this.investigationdata != null)
			count++;
		if(this.specimencomments != null)
			count++;
		if(this.specimensource != null)
			count++;
		if(this.resultspecimentype != null)
			count++;
		if(this.pathologyresultid != null)
			count++;
		if(this.resvaltype != null)
			count++;
		if(this.unitofmeasure != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.ocrr.vo.ChartResultAnalyteVo analyte;
	protected String resultval;
	protected Boolean isabnormal;
	protected ims.framework.utils.DateTime obsdatetime;
	protected Boolean obstimesupplied;
	protected ims.ocrr.vo.ResultComponentCommentsVoCollection comments;
	protected String refrange;
	protected ims.ocrr.vo.OrderInvestigationChartVo investigationdata;
	protected ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo specimencomments;
	protected ims.ocrr.vo.lookups.SpecimenType specimensource;
	protected ims.vo.LookupInstVo resultspecimentype;
	protected Integer pathologyresultid;
	protected ims.ocrr.vo.lookups.ResultValueType resvaltype;
	protected ims.ocrr.vo.lookups.ResultUnitOfMeasure unitofmeasure;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
