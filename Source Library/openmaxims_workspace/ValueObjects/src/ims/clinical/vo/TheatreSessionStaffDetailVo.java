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
 * Linked to clinical.TheatreSessionStaffDetail business object (ID: 1072100117).
 */
public class TheatreSessionStaffDetailVo extends ims.clinical.vo.TheatreSessionStaffDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TheatreSessionStaffDetailVo()
	{
	}
	public TheatreSessionStaffDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public TheatreSessionStaffDetailVo(ims.clinical.vo.beans.TheatreSessionStaffDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatresession = bean.getTheatreSession() == null ? null : bean.getTheatreSession().buildVo();
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		this.assistingsurgeons = ims.core.vo.MedicLiteVoCollection.buildFromBeanCollection(bean.getAssistingSurgeons());
		this.circulatorsscrubnurses = ims.core.vo.NurseLiteVoCollection.buildFromBeanCollection(bean.getCirculatorsScrubNurses());
		this.other = bean.getOther();
		this.noanaesthetistpresentla = bean.getNoAnaesthetistPresentLA();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.TheatreSessionStaffDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatresession = bean.getTheatreSession() == null ? null : bean.getTheatreSession().buildVo(map);
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		this.assistingsurgeons = ims.core.vo.MedicLiteVoCollection.buildFromBeanCollection(bean.getAssistingSurgeons());
		this.circulatorsscrubnurses = ims.core.vo.NurseLiteVoCollection.buildFromBeanCollection(bean.getCirculatorsScrubNurses());
		this.other = bean.getOther();
		this.noanaesthetistpresentla = bean.getNoAnaesthetistPresentLA();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.TheatreSessionStaffDetailVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.TheatreSessionStaffDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.TheatreSessionStaffDetailVoBean();
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
		if(fieldName.equals("THEATRESESSION"))
			return getTheatreSession();
		if(fieldName.equals("ANAESTHETIST"))
			return getAnaesthetist();
		if(fieldName.equals("ASSISTINGANAESTHETIST"))
			return getAssistingAnaesthetist();
		if(fieldName.equals("SUPERVISINGANAESTHETIST"))
			return getSupervisingAnaesthetist();
		if(fieldName.equals("ANAESTHETICPRACTIONER"))
			return getAnaestheticPractioner();
		if(fieldName.equals("OPERATINGSURGEON"))
			return getOperatingSurgeon();
		if(fieldName.equals("SUPERVISINGSURGEON"))
			return getSupervisingSurgeon();
		if(fieldName.equals("ASSISTINGSURGEONS"))
			return getAssistingSurgeons();
		if(fieldName.equals("CIRCULATORSSCRUBNURSES"))
			return getCirculatorsScrubNurses();
		if(fieldName.equals("OTHER"))
			return getOther();
		if(fieldName.equals("NOANAESTHETISTPRESENTLA"))
			return getNoAnaesthetistPresentLA();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTheatreSessionIsNotNull()
	{
		return this.theatresession != null;
	}
	public ims.scheduling.vo.SessionTheatreDetailsLiteVo getTheatreSession()
	{
		return this.theatresession;
	}
	public void setTheatreSession(ims.scheduling.vo.SessionTheatreDetailsLiteVo value)
	{
		this.isValidated = false;
		this.theatresession = value;
	}
	public boolean getAnaesthetistIsNotNull()
	{
		return this.anaesthetist != null;
	}
	public ims.vo.interfaces.IMos getAnaesthetist()
	{
		return this.anaesthetist;
	}
	public void setAnaesthetist(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.anaesthetist = (ims.core.vo.MedicLiteVo)value;
	}
	public boolean getAssistingAnaesthetistIsNotNull()
	{
		return this.assistinganaesthetist != null;
	}
	public ims.vo.interfaces.IMos getAssistingAnaesthetist()
	{
		return this.assistinganaesthetist;
	}
	public void setAssistingAnaesthetist(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.assistinganaesthetist = (ims.core.vo.MedicLiteVo)value;
	}
	public boolean getSupervisingAnaesthetistIsNotNull()
	{
		return this.supervisinganaesthetist != null;
	}
	public ims.vo.interfaces.IMos getSupervisingAnaesthetist()
	{
		return this.supervisinganaesthetist;
	}
	public void setSupervisingAnaesthetist(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.supervisinganaesthetist = (ims.core.vo.MedicLiteVo)value;
	}
	public boolean getAnaestheticPractionerIsNotNull()
	{
		return this.anaestheticpractioner != null;
	}
	public ims.vo.interfaces.IMos getAnaestheticPractioner()
	{
		return this.anaestheticpractioner;
	}
	public void setAnaestheticPractioner(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.anaestheticpractioner = (ims.core.vo.MedicVo)value;
	}
	public boolean getOperatingSurgeonIsNotNull()
	{
		return this.operatingsurgeon != null;
	}
	public ims.vo.interfaces.IMos getOperatingSurgeon()
	{
		return this.operatingsurgeon;
	}
	public void setOperatingSurgeon(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.operatingsurgeon = (ims.core.vo.MedicVo)value;
	}
	public boolean getSupervisingSurgeonIsNotNull()
	{
		return this.supervisingsurgeon != null;
	}
	public ims.vo.interfaces.IMos getSupervisingSurgeon()
	{
		return this.supervisingsurgeon;
	}
	public void setSupervisingSurgeon(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.supervisingsurgeon = (ims.core.vo.MedicVo)value;
	}
	public boolean getAssistingSurgeonsIsNotNull()
	{
		return this.assistingsurgeons != null;
	}
	public ims.core.vo.MedicLiteVoCollection getAssistingSurgeons()
	{
		return this.assistingsurgeons;
	}
	public void setAssistingSurgeons(ims.core.vo.MedicLiteVoCollection value)
	{
		this.isValidated = false;
		this.assistingsurgeons = value;
	}
	public boolean getCirculatorsScrubNursesIsNotNull()
	{
		return this.circulatorsscrubnurses != null;
	}
	public ims.core.vo.NurseLiteVoCollection getCirculatorsScrubNurses()
	{
		return this.circulatorsscrubnurses;
	}
	public void setCirculatorsScrubNurses(ims.core.vo.NurseLiteVoCollection value)
	{
		this.isValidated = false;
		this.circulatorsscrubnurses = value;
	}
	public boolean getOtherIsNotNull()
	{
		return this.other != null;
	}
	public String getOther()
	{
		return this.other;
	}
	public static int getOtherMaxLength()
	{
		return 1000;
	}
	public void setOther(String value)
	{
		this.isValidated = false;
		this.other = value;
	}
	public boolean getNoAnaesthetistPresentLAIsNotNull()
	{
		return this.noanaesthetistpresentla != null;
	}
	public Boolean getNoAnaesthetistPresentLA()
	{
		return this.noanaesthetistpresentla;
	}
	public void setNoAnaesthetistPresentLA(Boolean value)
	{
		this.isValidated = false;
		this.noanaesthetistpresentla = value;
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
		if(this.assistingsurgeons != null)
		{
			if(!this.assistingsurgeons.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.circulatorsscrubnurses != null)
		{
			if(!this.circulatorsscrubnurses.isValidated())
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
		if(this.assistingsurgeons != null)
		{
			String[] listOfOtherErrors = this.assistingsurgeons.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.circulatorsscrubnurses != null)
		{
			String[] listOfOtherErrors = this.circulatorsscrubnurses.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.other != null)
			if(this.other.length() > 1000)
				listOfErrors.add("The length of the field [other] in the value object [ims.clinical.vo.TheatreSessionStaffDetailVo] is too big. It should be less or equal to 1000");
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
	
		TheatreSessionStaffDetailVo clone = new TheatreSessionStaffDetailVo(this.id, this.version);
		
		if(this.theatresession == null)
			clone.theatresession = null;
		else
			clone.theatresession = (ims.scheduling.vo.SessionTheatreDetailsLiteVo)this.theatresession.clone();
		clone.anaesthetist = this.anaesthetist;
		clone.assistinganaesthetist = this.assistinganaesthetist;
		clone.supervisinganaesthetist = this.supervisinganaesthetist;
		clone.anaestheticpractioner = this.anaestheticpractioner;
		clone.operatingsurgeon = this.operatingsurgeon;
		clone.supervisingsurgeon = this.supervisingsurgeon;
		if(this.assistingsurgeons == null)
			clone.assistingsurgeons = null;
		else
			clone.assistingsurgeons = (ims.core.vo.MedicLiteVoCollection)this.assistingsurgeons.clone();
		if(this.circulatorsscrubnurses == null)
			clone.circulatorsscrubnurses = null;
		else
			clone.circulatorsscrubnurses = (ims.core.vo.NurseLiteVoCollection)this.circulatorsscrubnurses.clone();
		clone.other = this.other;
		clone.noanaesthetistpresentla = this.noanaesthetistpresentla;
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
		if (!(TheatreSessionStaffDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TheatreSessionStaffDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TheatreSessionStaffDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TheatreSessionStaffDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.theatresession != null)
			count++;
		if(this.anaesthetist != null)
			count++;
		if(this.assistinganaesthetist != null)
			count++;
		if(this.supervisinganaesthetist != null)
			count++;
		if(this.anaestheticpractioner != null)
			count++;
		if(this.operatingsurgeon != null)
			count++;
		if(this.supervisingsurgeon != null)
			count++;
		if(this.assistingsurgeons != null)
			count++;
		if(this.circulatorsscrubnurses != null)
			count++;
		if(this.other != null)
			count++;
		if(this.noanaesthetistpresentla != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.scheduling.vo.SessionTheatreDetailsLiteVo theatresession;
	protected ims.core.vo.MedicLiteVo anaesthetist;
	protected ims.core.vo.MedicLiteVo assistinganaesthetist;
	protected ims.core.vo.MedicLiteVo supervisinganaesthetist;
	protected ims.core.vo.MedicVo anaestheticpractioner;
	protected ims.core.vo.MedicVo operatingsurgeon;
	protected ims.core.vo.MedicVo supervisingsurgeon;
	protected ims.core.vo.MedicLiteVoCollection assistingsurgeons;
	protected ims.core.vo.NurseLiteVoCollection circulatorsscrubnurses;
	protected String other;
	protected Boolean noanaesthetistpresentla;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
