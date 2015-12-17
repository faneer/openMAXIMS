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

package ims.clinical.vo;


public class EMISSummaryVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EMISSummaryVo()
	{
	}
	public EMISSummaryVo(ims.clinical.vo.beans.EMISSummaryVoBean bean)
	{
		this.currentgppractice = bean.getCurrentGPPractice();
		this.problems = ims.clinical.vo.EMISObservationVoCollection.buildFromBeanCollection(bean.getProblems());
		this.medications = ims.clinical.vo.EMISMedicationVoCollection.buildFromBeanCollection(bean.getMedications());
		this.allergies = ims.clinical.vo.EMISAllergiesVoCollection.buildFromBeanCollection(bean.getAllergies());
		this.alerts = ims.clinical.vo.EMISAlertsVoCollection.buildFromBeanCollection(bean.getAlerts());
		this.diaries = ims.clinical.vo.EMISDiariesVoCollection.buildFromBeanCollection(bean.getDiaries());
		this.lastconsultations = ims.clinical.vo.EMISLastConsultationsVoCollection.buildFromBeanCollection(bean.getLastConsultations());
		this.healthstatus = ims.clinical.vo.EMISHealthStatusVoCollection.buildFromBeanCollection(bean.getHealthStatus());
		this.acute = ims.clinical.vo.EMISAcuteVoCollection.buildFromBeanCollection(bean.getAcute());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EMISSummaryVoBean bean)
	{
		this.currentgppractice = bean.getCurrentGPPractice();
		this.problems = ims.clinical.vo.EMISObservationVoCollection.buildFromBeanCollection(bean.getProblems());
		this.medications = ims.clinical.vo.EMISMedicationVoCollection.buildFromBeanCollection(bean.getMedications());
		this.allergies = ims.clinical.vo.EMISAllergiesVoCollection.buildFromBeanCollection(bean.getAllergies());
		this.alerts = ims.clinical.vo.EMISAlertsVoCollection.buildFromBeanCollection(bean.getAlerts());
		this.diaries = ims.clinical.vo.EMISDiariesVoCollection.buildFromBeanCollection(bean.getDiaries());
		this.lastconsultations = ims.clinical.vo.EMISLastConsultationsVoCollection.buildFromBeanCollection(bean.getLastConsultations());
		this.healthstatus = ims.clinical.vo.EMISHealthStatusVoCollection.buildFromBeanCollection(bean.getHealthStatus());
		this.acute = ims.clinical.vo.EMISAcuteVoCollection.buildFromBeanCollection(bean.getAcute());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EMISSummaryVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EMISSummaryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EMISSummaryVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getCurrentGPPracticeIsNotNull()
	{
		return this.currentgppractice != null;
	}
	public String getCurrentGPPractice()
	{
		return this.currentgppractice;
	}
	public static int getCurrentGPPracticeMaxLength()
	{
		return 255;
	}
	public void setCurrentGPPractice(String value)
	{
		this.isValidated = false;
		this.currentgppractice = value;
	}
	public boolean getProblemsIsNotNull()
	{
		return this.problems != null;
	}
	public ims.clinical.vo.EMISObservationVoCollection getProblems()
	{
		return this.problems;
	}
	public void setProblems(ims.clinical.vo.EMISObservationVoCollection value)
	{
		this.isValidated = false;
		this.problems = value;
	}
	public boolean getMedicationsIsNotNull()
	{
		return this.medications != null;
	}
	public ims.clinical.vo.EMISMedicationVoCollection getMedications()
	{
		return this.medications;
	}
	public void setMedications(ims.clinical.vo.EMISMedicationVoCollection value)
	{
		this.isValidated = false;
		this.medications = value;
	}
	public boolean getAllergiesIsNotNull()
	{
		return this.allergies != null;
	}
	public ims.clinical.vo.EMISAllergiesVoCollection getAllergies()
	{
		return this.allergies;
	}
	public void setAllergies(ims.clinical.vo.EMISAllergiesVoCollection value)
	{
		this.isValidated = false;
		this.allergies = value;
	}
	public boolean getAlertsIsNotNull()
	{
		return this.alerts != null;
	}
	public ims.clinical.vo.EMISAlertsVoCollection getAlerts()
	{
		return this.alerts;
	}
	public void setAlerts(ims.clinical.vo.EMISAlertsVoCollection value)
	{
		this.isValidated = false;
		this.alerts = value;
	}
	public boolean getDiariesIsNotNull()
	{
		return this.diaries != null;
	}
	public ims.clinical.vo.EMISDiariesVoCollection getDiaries()
	{
		return this.diaries;
	}
	public void setDiaries(ims.clinical.vo.EMISDiariesVoCollection value)
	{
		this.isValidated = false;
		this.diaries = value;
	}
	public boolean getLastConsultationsIsNotNull()
	{
		return this.lastconsultations != null;
	}
	public ims.clinical.vo.EMISLastConsultationsVoCollection getLastConsultations()
	{
		return this.lastconsultations;
	}
	public void setLastConsultations(ims.clinical.vo.EMISLastConsultationsVoCollection value)
	{
		this.isValidated = false;
		this.lastconsultations = value;
	}
	public boolean getHealthStatusIsNotNull()
	{
		return this.healthstatus != null;
	}
	public ims.clinical.vo.EMISHealthStatusVoCollection getHealthStatus()
	{
		return this.healthstatus;
	}
	public void setHealthStatus(ims.clinical.vo.EMISHealthStatusVoCollection value)
	{
		this.isValidated = false;
		this.healthstatus = value;
	}
	public boolean getAcuteIsNotNull()
	{
		return this.acute != null;
	}
	public ims.clinical.vo.EMISAcuteVoCollection getAcute()
	{
		return this.acute;
	}
	public void setAcute(ims.clinical.vo.EMISAcuteVoCollection value)
	{
		this.isValidated = false;
		this.acute = value;
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
		if(!(obj instanceof EMISSummaryVo))
			return false;
		EMISSummaryVo compareObj = (EMISSummaryVo)obj;
		if(this.getCurrentGPPractice() == null && compareObj.getCurrentGPPractice() != null)
			return false;
		if(this.getCurrentGPPractice() != null && compareObj.getCurrentGPPractice() == null)
			return false;
		if(this.getCurrentGPPractice() != null && compareObj.getCurrentGPPractice() != null)
			return this.getCurrentGPPractice().equals(compareObj.getCurrentGPPractice());
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
		if(this.problems != null)
		{
			if(!this.problems.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.medications != null)
		{
			if(!this.medications.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.allergies != null)
		{
			if(!this.allergies.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.alerts != null)
		{
			if(!this.alerts.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.diaries != null)
		{
			if(!this.diaries.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastconsultations != null)
		{
			if(!this.lastconsultations.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.healthstatus != null)
		{
			if(!this.healthstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.acute != null)
		{
			if(!this.acute.isValidated())
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
		if(this.problems != null)
		{
			String[] listOfOtherErrors = this.problems.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.medications != null)
		{
			String[] listOfOtherErrors = this.medications.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.allergies != null)
		{
			String[] listOfOtherErrors = this.allergies.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.alerts != null)
		{
			String[] listOfOtherErrors = this.alerts.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.diaries != null)
		{
			String[] listOfOtherErrors = this.diaries.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastconsultations != null)
		{
			String[] listOfOtherErrors = this.lastconsultations.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.healthstatus != null)
		{
			String[] listOfOtherErrors = this.healthstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.acute != null)
		{
			String[] listOfOtherErrors = this.acute.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		EMISSummaryVo clone = new EMISSummaryVo();
		
		clone.currentgppractice = this.currentgppractice;
		if(this.problems == null)
			clone.problems = null;
		else
			clone.problems = (ims.clinical.vo.EMISObservationVoCollection)this.problems.clone();
		if(this.medications == null)
			clone.medications = null;
		else
			clone.medications = (ims.clinical.vo.EMISMedicationVoCollection)this.medications.clone();
		if(this.allergies == null)
			clone.allergies = null;
		else
			clone.allergies = (ims.clinical.vo.EMISAllergiesVoCollection)this.allergies.clone();
		if(this.alerts == null)
			clone.alerts = null;
		else
			clone.alerts = (ims.clinical.vo.EMISAlertsVoCollection)this.alerts.clone();
		if(this.diaries == null)
			clone.diaries = null;
		else
			clone.diaries = (ims.clinical.vo.EMISDiariesVoCollection)this.diaries.clone();
		if(this.lastconsultations == null)
			clone.lastconsultations = null;
		else
			clone.lastconsultations = (ims.clinical.vo.EMISLastConsultationsVoCollection)this.lastconsultations.clone();
		if(this.healthstatus == null)
			clone.healthstatus = null;
		else
			clone.healthstatus = (ims.clinical.vo.EMISHealthStatusVoCollection)this.healthstatus.clone();
		if(this.acute == null)
			clone.acute = null;
		else
			clone.acute = (ims.clinical.vo.EMISAcuteVoCollection)this.acute.clone();
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
		if (!(EMISSummaryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EMISSummaryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EMISSummaryVo compareObj = (EMISSummaryVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCurrentGPPractice() == null && compareObj.getCurrentGPPractice() != null)
				return -1;
			if(this.getCurrentGPPractice() != null && compareObj.getCurrentGPPractice() == null)
				return 1;
			if(this.getCurrentGPPractice() != null && compareObj.getCurrentGPPractice() != null)
			{
				if(caseInsensitive)
					retVal = this.getCurrentGPPractice().toLowerCase().compareTo(compareObj.getCurrentGPPractice().toLowerCase());
				else
					retVal = this.getCurrentGPPractice().compareTo(compareObj.getCurrentGPPractice());
			}
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
		if(this.currentgppractice != null)
			count++;
		if(this.problems != null)
			count++;
		if(this.medications != null)
			count++;
		if(this.allergies != null)
			count++;
		if(this.alerts != null)
			count++;
		if(this.diaries != null)
			count++;
		if(this.lastconsultations != null)
			count++;
		if(this.healthstatus != null)
			count++;
		if(this.acute != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String currentgppractice;
	protected ims.clinical.vo.EMISObservationVoCollection problems;
	protected ims.clinical.vo.EMISMedicationVoCollection medications;
	protected ims.clinical.vo.EMISAllergiesVoCollection allergies;
	protected ims.clinical.vo.EMISAlertsVoCollection alerts;
	protected ims.clinical.vo.EMISDiariesVoCollection diaries;
	protected ims.clinical.vo.EMISLastConsultationsVoCollection lastconsultations;
	protected ims.clinical.vo.EMISHealthStatusVoCollection healthstatus;
	protected ims.clinical.vo.EMISAcuteVoCollection acute;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
