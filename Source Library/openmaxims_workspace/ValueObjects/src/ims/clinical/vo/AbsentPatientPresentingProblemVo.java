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
 * Linked to clinical.AbsentPresentingProblems business object (ID: 1072100045).
 */
public class AbsentPatientPresentingProblemVo extends ims.clinical.vo.AbsentPresentingProblemsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AbsentPatientPresentingProblemVo()
	{
	}
	public AbsentPatientPresentingProblemVo(Integer id, int version)
	{
		super(id, version);
	}
	public AbsentPatientPresentingProblemVo(ims.clinical.vo.beans.AbsentPatientPresentingProblemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo();
		this.note = bean.getNote();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.AbsentPatientPresentingProblemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo(map);
		this.note = bean.getNote();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.AbsentPatientPresentingProblemVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.AbsentPatientPresentingProblemVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.AbsentPatientPresentingProblemVoBean();
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
		if(fieldName.equals("PROBLEM"))
			return getProblem();
		if(fieldName.equals("NOTE"))
			return getNote();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProblemIsNotNull()
	{
		return this.problem != null;
	}
	public ims.clinical.vo.ClinicalProblemShortVo getProblem()
	{
		return this.problem;
	}
	public void setProblem(ims.clinical.vo.ClinicalProblemShortVo value)
	{
		this.isValidated = false;
		this.problem = value;
	}
	public boolean getNoteIsNotNull()
	{
		return this.note != null;
	}
	public String getNote()
	{
		return this.note;
	}
	public static int getNoteMaxLength()
	{
		return 500;
	}
	public void setNote(String value)
	{
		this.isValidated = false;
		this.note = value;
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
		if(this.problem != null)
		{
			if(!this.problem.isValidated())
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
		if(this.problem == null)
			listOfErrors.add("Problem is mandatory");
		if(this.problem != null)
		{
			String[] listOfOtherErrors = this.problem.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.note != null)
			if(this.note.length() > 500)
				listOfErrors.add("The length of the field [note] in the value object [ims.clinical.vo.AbsentPatientPresentingProblemVo] is too big. It should be less or equal to 500");
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
	
		AbsentPatientPresentingProblemVo clone = new AbsentPatientPresentingProblemVo(this.id, this.version);
		
		if(this.problem == null)
			clone.problem = null;
		else
			clone.problem = (ims.clinical.vo.ClinicalProblemShortVo)this.problem.clone();
		clone.note = this.note;
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
		if (!(AbsentPatientPresentingProblemVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AbsentPatientPresentingProblemVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AbsentPatientPresentingProblemVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AbsentPatientPresentingProblemVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.problem != null)
			count++;
		if(this.note != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinical.vo.ClinicalProblemShortVo problem;
	protected String note;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
