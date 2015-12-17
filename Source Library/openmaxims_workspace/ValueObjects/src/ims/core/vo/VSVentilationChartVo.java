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
 * Linked to core.vitals.VentilationChart business object (ID: 1022100018).
 */
public class VSVentilationChartVo extends ims.core.vitals.vo.VentilationChartRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VSVentilationChartVo()
	{
	}
	public VSVentilationChartVo(Integer id, int version)
	{
		super(id, version);
	}
	public VSVentilationChartVo(ims.core.vo.beans.VSVentilationChartVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.suction = bean.getSuction() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSuction());
		this.physio = bean.getPhysio() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPhysio());
		this.mode = bean.getMode() == null ? null : ims.core.vo.lookups.VentilationMode.buildLookup(bean.getMode());
		this.peakpressure = bean.getPeakPressure();
		this.peepcpap = bean.getPEEPCPAP();
		this.rate = bean.getRate();
		this.spontaneousmv = bean.getSpontaneousMV();
		this.cuff = bean.getCuff() == null ? null : ims.core.vo.lookups.CuffStatus.buildLookup(bean.getCuff());
		this.humidifiertemp = bean.getHumidifierTemp();
		this.probechange = bean.getProbeChange() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getProbeChange());
		this.position = bean.getPosition() == null ? null : ims.core.vo.lookups.PatientPosition.buildLookup(bean.getPosition());
		this.painscale = bean.getPainScale() == null ? null : ims.nursing.vo.lookups.PainSeverity.buildLookup(bean.getPainScale());
		this.fluidbalanceinstance = bean.getFluidBalanceInstance() == null ? null : bean.getFluidBalanceInstance().buildVo();
		this.dailyfluidbalance = bean.getDailyFluidBalance() == null ? null : bean.getDailyFluidBalance().buildVo();
		this.shiftdetails = bean.getShiftDetails() == null ? null : bean.getShiftDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.VSVentilationChartVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.suction = bean.getSuction() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSuction());
		this.physio = bean.getPhysio() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPhysio());
		this.mode = bean.getMode() == null ? null : ims.core.vo.lookups.VentilationMode.buildLookup(bean.getMode());
		this.peakpressure = bean.getPeakPressure();
		this.peepcpap = bean.getPEEPCPAP();
		this.rate = bean.getRate();
		this.spontaneousmv = bean.getSpontaneousMV();
		this.cuff = bean.getCuff() == null ? null : ims.core.vo.lookups.CuffStatus.buildLookup(bean.getCuff());
		this.humidifiertemp = bean.getHumidifierTemp();
		this.probechange = bean.getProbeChange() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getProbeChange());
		this.position = bean.getPosition() == null ? null : ims.core.vo.lookups.PatientPosition.buildLookup(bean.getPosition());
		this.painscale = bean.getPainScale() == null ? null : ims.nursing.vo.lookups.PainSeverity.buildLookup(bean.getPainScale());
		this.fluidbalanceinstance = bean.getFluidBalanceInstance() == null ? null : bean.getFluidBalanceInstance().buildVo(map);
		this.dailyfluidbalance = bean.getDailyFluidBalance() == null ? null : bean.getDailyFluidBalance().buildVo(map);
		this.shiftdetails = bean.getShiftDetails() == null ? null : bean.getShiftDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.VSVentilationChartVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.VSVentilationChartVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.VSVentilationChartVoBean();
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
		if(fieldName.equals("SUCTION"))
			return getSuction();
		if(fieldName.equals("PHYSIO"))
			return getPhysio();
		if(fieldName.equals("MODE"))
			return getMode();
		if(fieldName.equals("PEAKPRESSURE"))
			return getPeakPressure();
		if(fieldName.equals("PEEPCPAP"))
			return getPEEPCPAP();
		if(fieldName.equals("RATE"))
			return getRate();
		if(fieldName.equals("SPONTANEOUSMV"))
			return getSpontaneousMV();
		if(fieldName.equals("CUFF"))
			return getCuff();
		if(fieldName.equals("HUMIDIFIERTEMP"))
			return getHumidifierTemp();
		if(fieldName.equals("PROBECHANGE"))
			return getProbeChange();
		if(fieldName.equals("POSITION"))
			return getPosition();
		if(fieldName.equals("PAINSCALE"))
			return getPainScale();
		if(fieldName.equals("FLUIDBALANCEINSTANCE"))
			return getFluidBalanceInstance();
		if(fieldName.equals("DAILYFLUIDBALANCE"))
			return getDailyFluidBalance();
		if(fieldName.equals("SHIFTDETAILS"))
			return getShiftDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSuctionIsNotNull()
	{
		return this.suction != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getSuction()
	{
		return this.suction;
	}
	public void setSuction(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.suction = value;
	}
	public boolean getPhysioIsNotNull()
	{
		return this.physio != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getPhysio()
	{
		return this.physio;
	}
	public void setPhysio(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.physio = value;
	}
	public boolean getModeIsNotNull()
	{
		return this.mode != null;
	}
	public ims.core.vo.lookups.VentilationMode getMode()
	{
		return this.mode;
	}
	public void setMode(ims.core.vo.lookups.VentilationMode value)
	{
		this.isValidated = false;
		this.mode = value;
	}
	public boolean getPeakPressureIsNotNull()
	{
		return this.peakpressure != null;
	}
	public Integer getPeakPressure()
	{
		return this.peakpressure;
	}
	public void setPeakPressure(Integer value)
	{
		this.isValidated = false;
		this.peakpressure = value;
	}
	public boolean getPEEPCPAPIsNotNull()
	{
		return this.peepcpap != null;
	}
	public String getPEEPCPAP()
	{
		return this.peepcpap;
	}
	public static int getPEEPCPAPMaxLength()
	{
		return 255;
	}
	public void setPEEPCPAP(String value)
	{
		this.isValidated = false;
		this.peepcpap = value;
	}
	public boolean getRateIsNotNull()
	{
		return this.rate != null;
	}
	public Integer getRate()
	{
		return this.rate;
	}
	public void setRate(Integer value)
	{
		this.isValidated = false;
		this.rate = value;
	}
	public boolean getSpontaneousMVIsNotNull()
	{
		return this.spontaneousmv != null;
	}
	public Integer getSpontaneousMV()
	{
		return this.spontaneousmv;
	}
	public void setSpontaneousMV(Integer value)
	{
		this.isValidated = false;
		this.spontaneousmv = value;
	}
	public boolean getCuffIsNotNull()
	{
		return this.cuff != null;
	}
	public ims.core.vo.lookups.CuffStatus getCuff()
	{
		return this.cuff;
	}
	public void setCuff(ims.core.vo.lookups.CuffStatus value)
	{
		this.isValidated = false;
		this.cuff = value;
	}
	public boolean getHumidifierTempIsNotNull()
	{
		return this.humidifiertemp != null;
	}
	public Float getHumidifierTemp()
	{
		return this.humidifiertemp;
	}
	public void setHumidifierTemp(Float value)
	{
		this.isValidated = false;
		this.humidifiertemp = value;
	}
	public boolean getProbeChangeIsNotNull()
	{
		return this.probechange != null;
	}
	public ims.core.vo.lookups.YesNo getProbeChange()
	{
		return this.probechange;
	}
	public void setProbeChange(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.probechange = value;
	}
	public boolean getPositionIsNotNull()
	{
		return this.position != null;
	}
	public ims.core.vo.lookups.PatientPosition getPosition()
	{
		return this.position;
	}
	public void setPosition(ims.core.vo.lookups.PatientPosition value)
	{
		this.isValidated = false;
		this.position = value;
	}
	public boolean getPainScaleIsNotNull()
	{
		return this.painscale != null;
	}
	public ims.nursing.vo.lookups.PainSeverity getPainScale()
	{
		return this.painscale;
	}
	public void setPainScale(ims.nursing.vo.lookups.PainSeverity value)
	{
		this.isValidated = false;
		this.painscale = value;
	}
	public boolean getFluidBalanceInstanceIsNotNull()
	{
		return this.fluidbalanceinstance != null;
	}
	public ims.core.vo.FluidBalanceInstanceVo getFluidBalanceInstance()
	{
		return this.fluidbalanceinstance;
	}
	public void setFluidBalanceInstance(ims.core.vo.FluidBalanceInstanceVo value)
	{
		this.isValidated = false;
		this.fluidbalanceinstance = value;
	}
	public boolean getDailyFluidBalanceIsNotNull()
	{
		return this.dailyfluidbalance != null;
	}
	public ims.core.vo.DailyFluidBalanceVo getDailyFluidBalance()
	{
		return this.dailyfluidbalance;
	}
	public void setDailyFluidBalance(ims.core.vo.DailyFluidBalanceVo value)
	{
		this.isValidated = false;
		this.dailyfluidbalance = value;
	}
	public boolean getShiftDetailsIsNotNull()
	{
		return this.shiftdetails != null;
	}
	public ims.core.vo.ShiftDetailsVo getShiftDetails()
	{
		return this.shiftdetails;
	}
	public void setShiftDetails(ims.core.vo.ShiftDetailsVo value)
	{
		this.isValidated = false;
		this.shiftdetails = value;
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
		if(this.fluidbalanceinstance != null)
		{
			if(!this.fluidbalanceinstance.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.dailyfluidbalance != null)
		{
			if(!this.dailyfluidbalance.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.shiftdetails != null)
		{
			if(!this.shiftdetails.isValidated())
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
		if(this.fluidbalanceinstance != null)
		{
			String[] listOfOtherErrors = this.fluidbalanceinstance.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dailyfluidbalance != null)
		{
			String[] listOfOtherErrors = this.dailyfluidbalance.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.shiftdetails != null)
		{
			String[] listOfOtherErrors = this.shiftdetails.validate();
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
	
		VSVentilationChartVo clone = new VSVentilationChartVo(this.id, this.version);
		
		if(this.suction == null)
			clone.suction = null;
		else
			clone.suction = (ims.core.vo.lookups.YesNoUnknown)this.suction.clone();
		if(this.physio == null)
			clone.physio = null;
		else
			clone.physio = (ims.core.vo.lookups.YesNoUnknown)this.physio.clone();
		if(this.mode == null)
			clone.mode = null;
		else
			clone.mode = (ims.core.vo.lookups.VentilationMode)this.mode.clone();
		clone.peakpressure = this.peakpressure;
		clone.peepcpap = this.peepcpap;
		clone.rate = this.rate;
		clone.spontaneousmv = this.spontaneousmv;
		if(this.cuff == null)
			clone.cuff = null;
		else
			clone.cuff = (ims.core.vo.lookups.CuffStatus)this.cuff.clone();
		clone.humidifiertemp = this.humidifiertemp;
		if(this.probechange == null)
			clone.probechange = null;
		else
			clone.probechange = (ims.core.vo.lookups.YesNo)this.probechange.clone();
		if(this.position == null)
			clone.position = null;
		else
			clone.position = (ims.core.vo.lookups.PatientPosition)this.position.clone();
		if(this.painscale == null)
			clone.painscale = null;
		else
			clone.painscale = (ims.nursing.vo.lookups.PainSeverity)this.painscale.clone();
		if(this.fluidbalanceinstance == null)
			clone.fluidbalanceinstance = null;
		else
			clone.fluidbalanceinstance = (ims.core.vo.FluidBalanceInstanceVo)this.fluidbalanceinstance.clone();
		if(this.dailyfluidbalance == null)
			clone.dailyfluidbalance = null;
		else
			clone.dailyfluidbalance = (ims.core.vo.DailyFluidBalanceVo)this.dailyfluidbalance.clone();
		if(this.shiftdetails == null)
			clone.shiftdetails = null;
		else
			clone.shiftdetails = (ims.core.vo.ShiftDetailsVo)this.shiftdetails.clone();
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
		if (!(VSVentilationChartVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VSVentilationChartVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		VSVentilationChartVo compareObj = (VSVentilationChartVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_VentilationChart() == null && compareObj.getID_VentilationChart() != null)
				return -1;
			if(this.getID_VentilationChart() != null && compareObj.getID_VentilationChart() == null)
				return 1;
			if(this.getID_VentilationChart() != null && compareObj.getID_VentilationChart() != null)
				retVal = this.getID_VentilationChart().compareTo(compareObj.getID_VentilationChart());
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
		if(this.suction != null)
			count++;
		if(this.physio != null)
			count++;
		if(this.mode != null)
			count++;
		if(this.peakpressure != null)
			count++;
		if(this.peepcpap != null)
			count++;
		if(this.rate != null)
			count++;
		if(this.spontaneousmv != null)
			count++;
		if(this.cuff != null)
			count++;
		if(this.humidifiertemp != null)
			count++;
		if(this.probechange != null)
			count++;
		if(this.position != null)
			count++;
		if(this.painscale != null)
			count++;
		if(this.fluidbalanceinstance != null)
			count++;
		if(this.shiftdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.core.vo.lookups.YesNoUnknown suction;
	protected ims.core.vo.lookups.YesNoUnknown physio;
	protected ims.core.vo.lookups.VentilationMode mode;
	protected Integer peakpressure;
	protected String peepcpap;
	protected Integer rate;
	protected Integer spontaneousmv;
	protected ims.core.vo.lookups.CuffStatus cuff;
	protected Float humidifiertemp;
	protected ims.core.vo.lookups.YesNo probechange;
	protected ims.core.vo.lookups.PatientPosition position;
	protected ims.nursing.vo.lookups.PainSeverity painscale;
	protected ims.core.vo.FluidBalanceInstanceVo fluidbalanceinstance;
	protected ims.core.vo.DailyFluidBalanceVo dailyfluidbalance;
	protected ims.core.vo.ShiftDetailsVo shiftdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
