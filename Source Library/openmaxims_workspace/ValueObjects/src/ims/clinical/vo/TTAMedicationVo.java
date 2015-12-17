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

package ims.clinical.vo;

/**
 * Linked to eDischarge.TTAMedication business object (ID: 1099100003).
 */
public class TTAMedicationVo extends ims.edischarge.vo.TTAMedicationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TTAMedicationVo()
	{
	}
	public TTAMedicationVo(Integer id, int version)
	{
		super(id, version);
	}
	public TTAMedicationVo(ims.clinical.vo.beans.TTAMedicationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication();
		this.datedispensed = bean.getDateDispensed() == null ? null : bean.getDateDispensed().buildDateTime();
		this.doseamount = bean.getDoseAmount();
		this.doseunit = bean.getDoseUnit() == null ? null : ims.core.vo.lookups.MedicationDoseUnit.buildLookup(bean.getDoseUnit());
		this.dayssupply = bean.getDaysSupply();
		this.frequency = bean.getFrequency();
		this.gptocontinue = bean.getGpToContinue() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getGpToContinue());
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.medcomments = ims.clinical.vo.TTANoteVoCollection.buildFromBeanCollection(bean.getMedComments());
		this.sortorder = bean.getSortOrder();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.TTAMedicationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medication = bean.getMedication();
		this.datedispensed = bean.getDateDispensed() == null ? null : bean.getDateDispensed().buildDateTime();
		this.doseamount = bean.getDoseAmount();
		this.doseunit = bean.getDoseUnit() == null ? null : ims.core.vo.lookups.MedicationDoseUnit.buildLookup(bean.getDoseUnit());
		this.dayssupply = bean.getDaysSupply();
		this.frequency = bean.getFrequency();
		this.gptocontinue = bean.getGpToContinue() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getGpToContinue());
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.medcomments = ims.clinical.vo.TTANoteVoCollection.buildFromBeanCollection(bean.getMedComments());
		this.sortorder = bean.getSortOrder();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.TTAMedicationVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.TTAMedicationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.TTAMedicationVoBean();
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
		if(fieldName.equals("MEDICATION"))
			return getMedication();
		if(fieldName.equals("DATEDISPENSED"))
			return getDateDispensed();
		if(fieldName.equals("DOSEAMOUNT"))
			return getDoseAmount();
		if(fieldName.equals("DOSEUNIT"))
			return getDoseUnit();
		if(fieldName.equals("DAYSSUPPLY"))
			return getDaysSupply();
		if(fieldName.equals("FREQUENCY"))
			return getFrequency();
		if(fieldName.equals("GPTOCONTINUE"))
			return getGpToContinue();
		if(fieldName.equals("ROUTE"))
			return getRoute();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("MEDCOMMENTS"))
			return getMedComments();
		if(fieldName.equals("SORTORDER"))
			return getSortOrder();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMedicationIsNotNull()
	{
		return this.medication != null;
	}
	public String getMedication()
	{
		return this.medication;
	}
	public static int getMedicationMaxLength()
	{
		return 100;
	}
	public void setMedication(String value)
	{
		this.isValidated = false;
		this.medication = value;
	}
	public boolean getDateDispensedIsNotNull()
	{
		return this.datedispensed != null;
	}
	public ims.framework.utils.DateTime getDateDispensed()
	{
		return this.datedispensed;
	}
	public void setDateDispensed(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datedispensed = value;
	}
	public boolean getDoseAmountIsNotNull()
	{
		return this.doseamount != null;
	}
	public Float getDoseAmount()
	{
		return this.doseamount;
	}
	public void setDoseAmount(Float value)
	{
		this.isValidated = false;
		this.doseamount = value;
	}
	public boolean getDoseUnitIsNotNull()
	{
		return this.doseunit != null;
	}
	public ims.core.vo.lookups.MedicationDoseUnit getDoseUnit()
	{
		return this.doseunit;
	}
	public void setDoseUnit(ims.core.vo.lookups.MedicationDoseUnit value)
	{
		this.isValidated = false;
		this.doseunit = value;
	}
	public boolean getDaysSupplyIsNotNull()
	{
		return this.dayssupply != null;
	}
	public Integer getDaysSupply()
	{
		return this.dayssupply;
	}
	public void setDaysSupply(Integer value)
	{
		this.isValidated = false;
		this.dayssupply = value;
	}
	public boolean getFrequencyIsNotNull()
	{
		return this.frequency != null;
	}
	public String getFrequency()
	{
		return this.frequency;
	}
	public static int getFrequencyMaxLength()
	{
		return 200;
	}
	public void setFrequency(String value)
	{
		this.isValidated = false;
		this.frequency = value;
	}
	public boolean getGpToContinueIsNotNull()
	{
		return this.gptocontinue != null;
	}
	public ims.core.vo.lookups.YesNo getGpToContinue()
	{
		return this.gptocontinue;
	}
	public void setGpToContinue(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.gptocontinue = value;
	}
	public boolean getRouteIsNotNull()
	{
		return this.route != null;
	}
	public ims.core.vo.lookups.MedicationRoute getRoute()
	{
		return this.route;
	}
	public void setRoute(ims.core.vo.lookups.MedicationRoute value)
	{
		this.isValidated = false;
		this.route = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getMedCommentsIsNotNull()
	{
		return this.medcomments != null;
	}
	public ims.clinical.vo.TTANoteVoCollection getMedComments()
	{
		return this.medcomments;
	}
	public void setMedComments(ims.clinical.vo.TTANoteVoCollection value)
	{
		this.isValidated = false;
		this.medcomments = value;
	}
	public boolean getSortOrderIsNotNull()
	{
		return this.sortorder != null;
	}
	public Integer getSortOrder()
	{
		return this.sortorder;
	}
	public void setSortOrder(Integer value)
	{
		this.isValidated = false;
		this.sortorder = value;
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
		if(this.medication != null)
			if(this.medication.length() > 100)
				listOfErrors.add("The length of the field [medication] in the value object [ims.clinical.vo.TTAMedicationVo] is too big. It should be less or equal to 100");
		if(this.frequency != null)
			if(this.frequency.length() > 200)
				listOfErrors.add("The length of the field [frequency] in the value object [ims.clinical.vo.TTAMedicationVo] is too big. It should be less or equal to 200");
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
	
		TTAMedicationVo clone = new TTAMedicationVo(this.id, this.version);
		
		clone.medication = this.medication;
		if(this.datedispensed == null)
			clone.datedispensed = null;
		else
			clone.datedispensed = (ims.framework.utils.DateTime)this.datedispensed.clone();
		clone.doseamount = this.doseamount;
		if(this.doseunit == null)
			clone.doseunit = null;
		else
			clone.doseunit = (ims.core.vo.lookups.MedicationDoseUnit)this.doseunit.clone();
		clone.dayssupply = this.dayssupply;
		clone.frequency = this.frequency;
		if(this.gptocontinue == null)
			clone.gptocontinue = null;
		else
			clone.gptocontinue = (ims.core.vo.lookups.YesNo)this.gptocontinue.clone();
		if(this.route == null)
			clone.route = null;
		else
			clone.route = (ims.core.vo.lookups.MedicationRoute)this.route.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.medcomments == null)
			clone.medcomments = null;
		else
			clone.medcomments = (ims.clinical.vo.TTANoteVoCollection)this.medcomments.clone();
		clone.sortorder = this.sortorder;
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
		if (!(TTAMedicationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TTAMedicationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TTAMedicationVo compareObj = (TTAMedicationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSortOrder() == null && compareObj.getSortOrder() != null)
				return -1;
			if(this.getSortOrder() != null && compareObj.getSortOrder() == null)
				return 1;
			if(this.getSortOrder() != null && compareObj.getSortOrder() != null)
				retVal = this.getSortOrder().compareTo(compareObj.getSortOrder());
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
		if(this.medication != null)
			count++;
		if(this.datedispensed != null)
			count++;
		if(this.doseamount != null)
			count++;
		if(this.doseunit != null)
			count++;
		if(this.dayssupply != null)
			count++;
		if(this.frequency != null)
			count++;
		if(this.gptocontinue != null)
			count++;
		if(this.route != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.medcomments != null)
			count++;
		if(this.sortorder != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected String medication;
	protected ims.framework.utils.DateTime datedispensed;
	protected Float doseamount;
	protected ims.core.vo.lookups.MedicationDoseUnit doseunit;
	protected Integer dayssupply;
	protected String frequency;
	protected ims.core.vo.lookups.YesNo gptocontinue;
	protected ims.core.vo.lookups.MedicationRoute route;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.clinical.vo.TTANoteVoCollection medcomments;
	protected Integer sortorder;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
