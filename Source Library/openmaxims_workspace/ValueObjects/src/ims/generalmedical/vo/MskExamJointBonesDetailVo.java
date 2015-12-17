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

package ims.generalmedical.vo;

/**
 * Linked to medical.MSkExamJointBonesDetail business object (ID: 1072100035).
 */
public class MskExamJointBonesDetailVo extends ims.medical.vo.MSkExamJointBonesDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MskExamJointBonesDetailVo()
	{
	}
	public MskExamJointBonesDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public MskExamJointBonesDetailVo(ims.generalmedical.vo.beans.MskExamJointBonesDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.group = bean.getGroup() == null ? null : bean.getGroup().buildVo();
		this.isjoint = bean.getIsJoint();
		this.joint = bean.getJoint() == null ? null : bean.getJoint().buildVo();
		this.bone = bean.getBone() == null ? null : ims.spinalinjuries.vo.lookups.MskBones.buildLookup(bean.getBone());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRonly.buildLookup(bean.getLaterality());
		this.generalfindingsbone = ims.spinalinjuries.vo.lookups.GeneralFindingsBoneCollection.buildFromBeanCollection(bean.getGeneralFindingsBone());
		this.generalfindingsjoint = ims.spinalinjuries.vo.lookups.GeneralFindingsJointCollection.buildFromBeanCollection(bean.getGeneralFindingsJoint());
		this.ligamentstests = bean.getLigamentsTests();
		this.interpretation = bean.getInterpretation();
		this.selectedmovements = ims.core.vo.MskJointMovementVoCollection.buildFromBeanCollection(bean.getSelectedMovements());
		this.isproblem = bean.getIsProblem();
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.MskExamJointBonesDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.group = bean.getGroup() == null ? null : bean.getGroup().buildVo(map);
		this.isjoint = bean.getIsJoint();
		this.joint = bean.getJoint() == null ? null : bean.getJoint().buildVo(map);
		this.bone = bean.getBone() == null ? null : ims.spinalinjuries.vo.lookups.MskBones.buildLookup(bean.getBone());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRonly.buildLookup(bean.getLaterality());
		this.generalfindingsbone = ims.spinalinjuries.vo.lookups.GeneralFindingsBoneCollection.buildFromBeanCollection(bean.getGeneralFindingsBone());
		this.generalfindingsjoint = ims.spinalinjuries.vo.lookups.GeneralFindingsJointCollection.buildFromBeanCollection(bean.getGeneralFindingsJoint());
		this.ligamentstests = bean.getLigamentsTests();
		this.interpretation = bean.getInterpretation();
		this.selectedmovements = ims.core.vo.MskJointMovementVoCollection.buildFromBeanCollection(bean.getSelectedMovements());
		this.isproblem = bean.getIsProblem();
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.MskExamJointBonesDetailVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.MskExamJointBonesDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.MskExamJointBonesDetailVoBean();
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
		if(fieldName.equals("GROUP"))
			return getGroup();
		if(fieldName.equals("ISJOINT"))
			return getIsJoint();
		if(fieldName.equals("JOINT"))
			return getJoint();
		if(fieldName.equals("BONE"))
			return getBone();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		if(fieldName.equals("GENERALFINDINGSBONE"))
			return getGeneralFindingsBone();
		if(fieldName.equals("GENERALFINDINGSJOINT"))
			return getGeneralFindingsJoint();
		if(fieldName.equals("LIGAMENTSTESTS"))
			return getLigamentsTests();
		if(fieldName.equals("INTERPRETATION"))
			return getInterpretation();
		if(fieldName.equals("SELECTEDMOVEMENTS"))
			return getSelectedMovements();
		if(fieldName.equals("ISPROBLEM"))
			return getIsProblem();
		if(fieldName.equals("PROBLEM"))
			return getProblem();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGroupIsNotNull()
	{
		return this.group != null;
	}
	public ims.core.vo.MskGroupVo getGroup()
	{
		return this.group;
	}
	public void setGroup(ims.core.vo.MskGroupVo value)
	{
		this.isValidated = false;
		this.group = value;
	}
	public boolean getIsJointIsNotNull()
	{
		return this.isjoint != null;
	}
	public Boolean getIsJoint()
	{
		return this.isjoint;
	}
	public void setIsJoint(Boolean value)
	{
		this.isValidated = false;
		this.isjoint = value;
	}
	public boolean getJointIsNotNull()
	{
		return this.joint != null;
	}
	public ims.core.vo.MskJointVo getJoint()
	{
		return this.joint;
	}
	public void setJoint(ims.core.vo.MskJointVo value)
	{
		this.isValidated = false;
		this.joint = value;
	}
	public boolean getBoneIsNotNull()
	{
		return this.bone != null;
	}
	public ims.spinalinjuries.vo.lookups.MskBones getBone()
	{
		return this.bone;
	}
	public void setBone(ims.spinalinjuries.vo.lookups.MskBones value)
	{
		this.isValidated = false;
		this.bone = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public ims.core.vo.lookups.LateralityLRonly getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.core.vo.lookups.LateralityLRonly value)
	{
		this.isValidated = false;
		this.laterality = value;
	}
	public boolean getGeneralFindingsBoneIsNotNull()
	{
		return this.generalfindingsbone != null;
	}
	public ims.spinalinjuries.vo.lookups.GeneralFindingsBoneCollection getGeneralFindingsBone()
	{
		return this.generalfindingsbone;
	}
	public void setGeneralFindingsBone(ims.spinalinjuries.vo.lookups.GeneralFindingsBoneCollection value)
	{
		this.isValidated = false;
		this.generalfindingsbone = value;
	}
	public boolean getGeneralFindingsJointIsNotNull()
	{
		return this.generalfindingsjoint != null;
	}
	public ims.spinalinjuries.vo.lookups.GeneralFindingsJointCollection getGeneralFindingsJoint()
	{
		return this.generalfindingsjoint;
	}
	public void setGeneralFindingsJoint(ims.spinalinjuries.vo.lookups.GeneralFindingsJointCollection value)
	{
		this.isValidated = false;
		this.generalfindingsjoint = value;
	}
	public boolean getLigamentsTestsIsNotNull()
	{
		return this.ligamentstests != null;
	}
	public String getLigamentsTests()
	{
		return this.ligamentstests;
	}
	public static int getLigamentsTestsMaxLength()
	{
		return 200;
	}
	public void setLigamentsTests(String value)
	{
		this.isValidated = false;
		this.ligamentstests = value;
	}
	public boolean getInterpretationIsNotNull()
	{
		return this.interpretation != null;
	}
	public String getInterpretation()
	{
		return this.interpretation;
	}
	public static int getInterpretationMaxLength()
	{
		return 100;
	}
	public void setInterpretation(String value)
	{
		this.isValidated = false;
		this.interpretation = value;
	}
	public boolean getSelectedMovementsIsNotNull()
	{
		return this.selectedmovements != null;
	}
	public ims.core.vo.MskJointMovementVoCollection getSelectedMovements()
	{
		return this.selectedmovements;
	}
	public void setSelectedMovements(ims.core.vo.MskJointMovementVoCollection value)
	{
		this.isValidated = false;
		this.selectedmovements = value;
	}
	public boolean getIsProblemIsNotNull()
	{
		return this.isproblem != null;
	}
	public Boolean getIsProblem()
	{
		return this.isproblem;
	}
	public void setIsProblem(Boolean value)
	{
		this.isValidated = false;
		this.isproblem = value;
	}
	public boolean getProblemIsNotNull()
	{
		return this.problem != null;
	}
	public ims.generalmedical.vo.MedicalProbOnAdmisVo getProblem()
	{
		return this.problem;
	}
	public void setProblem(ims.generalmedical.vo.MedicalProbOnAdmisVo value)
	{
		this.isValidated = false;
		this.problem = value;
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
		if(this.group != null)
		{
			if(!this.group.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.joint != null)
		{
			if(!this.joint.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.selectedmovements != null)
		{
			if(!this.selectedmovements.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.group != null)
		{
			String[] listOfOtherErrors = this.group.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.joint != null)
		{
			String[] listOfOtherErrors = this.joint.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ligamentstests != null)
			if(this.ligamentstests.length() > 200)
				listOfErrors.add("The length of the field [ligamentstests] in the value object [ims.generalmedical.vo.MskExamJointBonesDetailVo] is too big. It should be less or equal to 200");
		if(this.interpretation != null)
			if(this.interpretation.length() > 100)
				listOfErrors.add("The length of the field [interpretation] in the value object [ims.generalmedical.vo.MskExamJointBonesDetailVo] is too big. It should be less or equal to 100");
		if(this.selectedmovements != null)
		{
			String[] listOfOtherErrors = this.selectedmovements.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		MskExamJointBonesDetailVo clone = new MskExamJointBonesDetailVo(this.id, this.version);
		
		if(this.group == null)
			clone.group = null;
		else
			clone.group = (ims.core.vo.MskGroupVo)this.group.clone();
		clone.isjoint = this.isjoint;
		if(this.joint == null)
			clone.joint = null;
		else
			clone.joint = (ims.core.vo.MskJointVo)this.joint.clone();
		if(this.bone == null)
			clone.bone = null;
		else
			clone.bone = (ims.spinalinjuries.vo.lookups.MskBones)this.bone.clone();
		if(this.laterality == null)
			clone.laterality = null;
		else
			clone.laterality = (ims.core.vo.lookups.LateralityLRonly)this.laterality.clone();
		if(this.generalfindingsbone == null)
			clone.generalfindingsbone = null;
		else
			clone.generalfindingsbone = (ims.spinalinjuries.vo.lookups.GeneralFindingsBoneCollection)this.generalfindingsbone.clone();
		if(this.generalfindingsjoint == null)
			clone.generalfindingsjoint = null;
		else
			clone.generalfindingsjoint = (ims.spinalinjuries.vo.lookups.GeneralFindingsJointCollection)this.generalfindingsjoint.clone();
		clone.ligamentstests = this.ligamentstests;
		clone.interpretation = this.interpretation;
		if(this.selectedmovements == null)
			clone.selectedmovements = null;
		else
			clone.selectedmovements = (ims.core.vo.MskJointMovementVoCollection)this.selectedmovements.clone();
		clone.isproblem = this.isproblem;
		if(this.problem == null)
			clone.problem = null;
		else
			clone.problem = (ims.generalmedical.vo.MedicalProbOnAdmisVo)this.problem.clone();
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
		if (!(MskExamJointBonesDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MskExamJointBonesDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MskExamJointBonesDetailVo compareObj = (MskExamJointBonesDetailVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_MSkExamJointBonesDetail() == null && compareObj.getID_MSkExamJointBonesDetail() != null)
				return -1;
			if(this.getID_MSkExamJointBonesDetail() != null && compareObj.getID_MSkExamJointBonesDetail() == null)
				return 1;
			if(this.getID_MSkExamJointBonesDetail() != null && compareObj.getID_MSkExamJointBonesDetail() != null)
				retVal = this.getID_MSkExamJointBonesDetail().compareTo(compareObj.getID_MSkExamJointBonesDetail());
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
		if(this.group != null)
			count++;
		if(this.isjoint != null)
			count++;
		if(this.joint != null)
			count++;
		if(this.bone != null)
			count++;
		if(this.laterality != null)
			count++;
		if(this.generalfindingsbone != null)
			count++;
		if(this.generalfindingsjoint != null)
			count++;
		if(this.ligamentstests != null)
			count++;
		if(this.interpretation != null)
			count++;
		if(this.selectedmovements != null)
			count++;
		if(this.problem != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.core.vo.MskGroupVo group;
	protected Boolean isjoint;
	protected ims.core.vo.MskJointVo joint;
	protected ims.spinalinjuries.vo.lookups.MskBones bone;
	protected ims.core.vo.lookups.LateralityLRonly laterality;
	protected ims.spinalinjuries.vo.lookups.GeneralFindingsBoneCollection generalfindingsbone;
	protected ims.spinalinjuries.vo.lookups.GeneralFindingsJointCollection generalfindingsjoint;
	protected String ligamentstests;
	protected String interpretation;
	protected ims.core.vo.MskJointMovementVoCollection selectedmovements;
	protected Boolean isproblem;
	protected ims.generalmedical.vo.MedicalProbOnAdmisVo problem;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
