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

package ims.emergency.vo;

/**
 * Linked to core.admin.TIIG business object (ID: 1086100025).
 */
public class TIIGVo extends ims.core.admin.vo.TIIGRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TIIGVo()
	{
	}
	public TIIGVo(Integer id, int version)
	{
		super(id, version);
	}
	public TIIGVo(ims.emergency.vo.beans.TIIGVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.hadpatientconsumedalcohol = bean.getHadPatientConsumedAlcohol() == null ? null : ims.emergency.vo.lookups.ConsumedAlcoholThreeHoursPriorToIncident.buildLookup(bean.getHadPatientConsumedAlcohol());
		this.assaultweapon = bean.getAssaultWeapon() == null ? null : ims.emergency.vo.lookups.AssaultWeapon.buildLookup(bean.getAssaultWeapon());
		this.assaultlocation = bean.getAssaultLocation() == null ? null : ims.emergency.vo.lookups.AssaultLocation.buildLookup(bean.getAssaultLocation());
		this.relationshiptoattacker = bean.getRelationshipToAttacker() == null ? null : ims.emergency.vo.lookups.RelationshipToAttacker.buildLookup(bean.getRelationshipToAttacker());
		this.intendtoinformpolice = bean.getIntendToInformPolice() == null ? null : ims.emergency.vo.lookups.PoliceInformed.buildLookup(bean.getIntendToInformPolice());
		this.consumedorpurchasedalcoholfrom = bean.getConsumedOrPurchasedAlcoholFrom() == null ? null : ims.emergency.vo.lookups.ConsumedOrPurchasedAlcoholFrom.buildLookup(bean.getConsumedOrPurchasedAlcoholFrom());
		this.numberofattackers = bean.getNumberOfAttackers() == null ? null : ims.emergency.vo.lookups.NumberOfAttackers.buildLookup(bean.getNumberOfAttackers());
		this.genderofattacker = bean.getGenderofAttacker() == null ? null : ims.emergency.vo.lookups.GenderofAttacker.buildLookup(bean.getGenderofAttacker());
		this.previouslyassulatedbyattacker = bean.getPreviouslyAssulatedByAttacker() == null ? null : ims.emergency.vo.lookups.PatientPreviouslyAssaultedByAttacker.buildLookup(bean.getPreviouslyAssulatedByAttacker());
		this.assaultlocationdetails = bean.getAssaultLocationDetails();
		this.relationshiptoattackerdetails = bean.getRelationshipToAttackerDetails();
		this.assaultweapondetails = bean.getAssaultWeaponDetails();
		this.lastdrinklocationdetails = bean.getLastDrinkLocationDetails();
		this.attackerhadconsumedalcohol = bean.getAttackerHadConsumedAlcohol() == null ? null : ims.emergency.vo.lookups.AttackerHadConsumedAlcohol.buildLookup(bean.getAttackerHadConsumedAlcohol());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TIIGVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.hadpatientconsumedalcohol = bean.getHadPatientConsumedAlcohol() == null ? null : ims.emergency.vo.lookups.ConsumedAlcoholThreeHoursPriorToIncident.buildLookup(bean.getHadPatientConsumedAlcohol());
		this.assaultweapon = bean.getAssaultWeapon() == null ? null : ims.emergency.vo.lookups.AssaultWeapon.buildLookup(bean.getAssaultWeapon());
		this.assaultlocation = bean.getAssaultLocation() == null ? null : ims.emergency.vo.lookups.AssaultLocation.buildLookup(bean.getAssaultLocation());
		this.relationshiptoattacker = bean.getRelationshipToAttacker() == null ? null : ims.emergency.vo.lookups.RelationshipToAttacker.buildLookup(bean.getRelationshipToAttacker());
		this.intendtoinformpolice = bean.getIntendToInformPolice() == null ? null : ims.emergency.vo.lookups.PoliceInformed.buildLookup(bean.getIntendToInformPolice());
		this.consumedorpurchasedalcoholfrom = bean.getConsumedOrPurchasedAlcoholFrom() == null ? null : ims.emergency.vo.lookups.ConsumedOrPurchasedAlcoholFrom.buildLookup(bean.getConsumedOrPurchasedAlcoholFrom());
		this.numberofattackers = bean.getNumberOfAttackers() == null ? null : ims.emergency.vo.lookups.NumberOfAttackers.buildLookup(bean.getNumberOfAttackers());
		this.genderofattacker = bean.getGenderofAttacker() == null ? null : ims.emergency.vo.lookups.GenderofAttacker.buildLookup(bean.getGenderofAttacker());
		this.previouslyassulatedbyattacker = bean.getPreviouslyAssulatedByAttacker() == null ? null : ims.emergency.vo.lookups.PatientPreviouslyAssaultedByAttacker.buildLookup(bean.getPreviouslyAssulatedByAttacker());
		this.assaultlocationdetails = bean.getAssaultLocationDetails();
		this.relationshiptoattackerdetails = bean.getRelationshipToAttackerDetails();
		this.assaultweapondetails = bean.getAssaultWeaponDetails();
		this.lastdrinklocationdetails = bean.getLastDrinkLocationDetails();
		this.attackerhadconsumedalcohol = bean.getAttackerHadConsumedAlcohol() == null ? null : ims.emergency.vo.lookups.AttackerHadConsumedAlcohol.buildLookup(bean.getAttackerHadConsumedAlcohol());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TIIGVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TIIGVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TIIGVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("HADPATIENTCONSUMEDALCOHOL"))
			return getHadPatientConsumedAlcohol();
		if(fieldName.equals("ASSAULTWEAPON"))
			return getAssaultWeapon();
		if(fieldName.equals("ASSAULTLOCATION"))
			return getAssaultLocation();
		if(fieldName.equals("RELATIONSHIPTOATTACKER"))
			return getRelationshipToAttacker();
		if(fieldName.equals("INTENDTOINFORMPOLICE"))
			return getIntendToInformPolice();
		if(fieldName.equals("CONSUMEDORPURCHASEDALCOHOLFROM"))
			return getConsumedOrPurchasedAlcoholFrom();
		if(fieldName.equals("NUMBEROFATTACKERS"))
			return getNumberOfAttackers();
		if(fieldName.equals("GENDEROFATTACKER"))
			return getGenderofAttacker();
		if(fieldName.equals("PREVIOUSLYASSULATEDBYATTACKER"))
			return getPreviouslyAssulatedByAttacker();
		if(fieldName.equals("ASSAULTLOCATIONDETAILS"))
			return getAssaultLocationDetails();
		if(fieldName.equals("RELATIONSHIPTOATTACKERDETAILS"))
			return getRelationshipToAttackerDetails();
		if(fieldName.equals("ASSAULTWEAPONDETAILS"))
			return getAssaultWeaponDetails();
		if(fieldName.equals("LASTDRINKLOCATIONDETAILS"))
			return getLastDrinkLocationDetails();
		if(fieldName.equals("ATTACKERHADCONSUMEDALCOHOL"))
			return getAttackerHadConsumedAlcohol();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getHadPatientConsumedAlcoholIsNotNull()
	{
		return this.hadpatientconsumedalcohol != null;
	}
	public ims.emergency.vo.lookups.ConsumedAlcoholThreeHoursPriorToIncident getHadPatientConsumedAlcohol()
	{
		return this.hadpatientconsumedalcohol;
	}
	public void setHadPatientConsumedAlcohol(ims.emergency.vo.lookups.ConsumedAlcoholThreeHoursPriorToIncident value)
	{
		this.isValidated = false;
		this.hadpatientconsumedalcohol = value;
	}
	public boolean getAssaultWeaponIsNotNull()
	{
		return this.assaultweapon != null;
	}
	public ims.emergency.vo.lookups.AssaultWeapon getAssaultWeapon()
	{
		return this.assaultweapon;
	}
	public void setAssaultWeapon(ims.emergency.vo.lookups.AssaultWeapon value)
	{
		this.isValidated = false;
		this.assaultweapon = value;
	}
	public boolean getAssaultLocationIsNotNull()
	{
		return this.assaultlocation != null;
	}
	public ims.emergency.vo.lookups.AssaultLocation getAssaultLocation()
	{
		return this.assaultlocation;
	}
	public void setAssaultLocation(ims.emergency.vo.lookups.AssaultLocation value)
	{
		this.isValidated = false;
		this.assaultlocation = value;
	}
	public boolean getRelationshipToAttackerIsNotNull()
	{
		return this.relationshiptoattacker != null;
	}
	public ims.emergency.vo.lookups.RelationshipToAttacker getRelationshipToAttacker()
	{
		return this.relationshiptoattacker;
	}
	public void setRelationshipToAttacker(ims.emergency.vo.lookups.RelationshipToAttacker value)
	{
		this.isValidated = false;
		this.relationshiptoattacker = value;
	}
	public boolean getIntendToInformPoliceIsNotNull()
	{
		return this.intendtoinformpolice != null;
	}
	public ims.emergency.vo.lookups.PoliceInformed getIntendToInformPolice()
	{
		return this.intendtoinformpolice;
	}
	public void setIntendToInformPolice(ims.emergency.vo.lookups.PoliceInformed value)
	{
		this.isValidated = false;
		this.intendtoinformpolice = value;
	}
	public boolean getConsumedOrPurchasedAlcoholFromIsNotNull()
	{
		return this.consumedorpurchasedalcoholfrom != null;
	}
	public ims.emergency.vo.lookups.ConsumedOrPurchasedAlcoholFrom getConsumedOrPurchasedAlcoholFrom()
	{
		return this.consumedorpurchasedalcoholfrom;
	}
	public void setConsumedOrPurchasedAlcoholFrom(ims.emergency.vo.lookups.ConsumedOrPurchasedAlcoholFrom value)
	{
		this.isValidated = false;
		this.consumedorpurchasedalcoholfrom = value;
	}
	public boolean getNumberOfAttackersIsNotNull()
	{
		return this.numberofattackers != null;
	}
	public ims.emergency.vo.lookups.NumberOfAttackers getNumberOfAttackers()
	{
		return this.numberofattackers;
	}
	public void setNumberOfAttackers(ims.emergency.vo.lookups.NumberOfAttackers value)
	{
		this.isValidated = false;
		this.numberofattackers = value;
	}
	public boolean getGenderofAttackerIsNotNull()
	{
		return this.genderofattacker != null;
	}
	public ims.emergency.vo.lookups.GenderofAttacker getGenderofAttacker()
	{
		return this.genderofattacker;
	}
	public void setGenderofAttacker(ims.emergency.vo.lookups.GenderofAttacker value)
	{
		this.isValidated = false;
		this.genderofattacker = value;
	}
	public boolean getPreviouslyAssulatedByAttackerIsNotNull()
	{
		return this.previouslyassulatedbyattacker != null;
	}
	public ims.emergency.vo.lookups.PatientPreviouslyAssaultedByAttacker getPreviouslyAssulatedByAttacker()
	{
		return this.previouslyassulatedbyattacker;
	}
	public void setPreviouslyAssulatedByAttacker(ims.emergency.vo.lookups.PatientPreviouslyAssaultedByAttacker value)
	{
		this.isValidated = false;
		this.previouslyassulatedbyattacker = value;
	}
	public boolean getAssaultLocationDetailsIsNotNull()
	{
		return this.assaultlocationdetails != null;
	}
	public String getAssaultLocationDetails()
	{
		return this.assaultlocationdetails;
	}
	public static int getAssaultLocationDetailsMaxLength()
	{
		return 200;
	}
	public void setAssaultLocationDetails(String value)
	{
		this.isValidated = false;
		this.assaultlocationdetails = value;
	}
	public boolean getRelationshipToAttackerDetailsIsNotNull()
	{
		return this.relationshiptoattackerdetails != null;
	}
	public String getRelationshipToAttackerDetails()
	{
		return this.relationshiptoattackerdetails;
	}
	public static int getRelationshipToAttackerDetailsMaxLength()
	{
		return 200;
	}
	public void setRelationshipToAttackerDetails(String value)
	{
		this.isValidated = false;
		this.relationshiptoattackerdetails = value;
	}
	public boolean getAssaultWeaponDetailsIsNotNull()
	{
		return this.assaultweapondetails != null;
	}
	public String getAssaultWeaponDetails()
	{
		return this.assaultweapondetails;
	}
	public static int getAssaultWeaponDetailsMaxLength()
	{
		return 200;
	}
	public void setAssaultWeaponDetails(String value)
	{
		this.isValidated = false;
		this.assaultweapondetails = value;
	}
	public boolean getLastDrinkLocationDetailsIsNotNull()
	{
		return this.lastdrinklocationdetails != null;
	}
	public String getLastDrinkLocationDetails()
	{
		return this.lastdrinklocationdetails;
	}
	public static int getLastDrinkLocationDetailsMaxLength()
	{
		return 200;
	}
	public void setLastDrinkLocationDetails(String value)
	{
		this.isValidated = false;
		this.lastdrinklocationdetails = value;
	}
	public boolean getAttackerHadConsumedAlcoholIsNotNull()
	{
		return this.attackerhadconsumedalcohol != null;
	}
	public ims.emergency.vo.lookups.AttackerHadConsumedAlcohol getAttackerHadConsumedAlcohol()
	{
		return this.attackerhadconsumedalcohol;
	}
	public void setAttackerHadConsumedAlcohol(ims.emergency.vo.lookups.AttackerHadConsumedAlcohol value)
	{
		this.isValidated = false;
		this.attackerhadconsumedalcohol = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.assaultlocationdetails != null)
			if(this.assaultlocationdetails.length() > 200)
				listOfErrors.add("The length of the field [assaultlocationdetails] in the value object [ims.emergency.vo.TIIGVo] is too big. It should be less or equal to 200");
		if(this.relationshiptoattackerdetails != null)
			if(this.relationshiptoattackerdetails.length() > 200)
				listOfErrors.add("The length of the field [relationshiptoattackerdetails] in the value object [ims.emergency.vo.TIIGVo] is too big. It should be less or equal to 200");
		if(this.assaultweapondetails != null)
			if(this.assaultweapondetails.length() > 200)
				listOfErrors.add("The length of the field [assaultweapondetails] in the value object [ims.emergency.vo.TIIGVo] is too big. It should be less or equal to 200");
		if(this.lastdrinklocationdetails != null)
			if(this.lastdrinklocationdetails.length() > 200)
				listOfErrors.add("The length of the field [lastdrinklocationdetails] in the value object [ims.emergency.vo.TIIGVo] is too big. It should be less or equal to 200");
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
	
		TIIGVo clone = new TIIGVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
		if(this.hadpatientconsumedalcohol == null)
			clone.hadpatientconsumedalcohol = null;
		else
			clone.hadpatientconsumedalcohol = (ims.emergency.vo.lookups.ConsumedAlcoholThreeHoursPriorToIncident)this.hadpatientconsumedalcohol.clone();
		if(this.assaultweapon == null)
			clone.assaultweapon = null;
		else
			clone.assaultweapon = (ims.emergency.vo.lookups.AssaultWeapon)this.assaultweapon.clone();
		if(this.assaultlocation == null)
			clone.assaultlocation = null;
		else
			clone.assaultlocation = (ims.emergency.vo.lookups.AssaultLocation)this.assaultlocation.clone();
		if(this.relationshiptoattacker == null)
			clone.relationshiptoattacker = null;
		else
			clone.relationshiptoattacker = (ims.emergency.vo.lookups.RelationshipToAttacker)this.relationshiptoattacker.clone();
		if(this.intendtoinformpolice == null)
			clone.intendtoinformpolice = null;
		else
			clone.intendtoinformpolice = (ims.emergency.vo.lookups.PoliceInformed)this.intendtoinformpolice.clone();
		if(this.consumedorpurchasedalcoholfrom == null)
			clone.consumedorpurchasedalcoholfrom = null;
		else
			clone.consumedorpurchasedalcoholfrom = (ims.emergency.vo.lookups.ConsumedOrPurchasedAlcoholFrom)this.consumedorpurchasedalcoholfrom.clone();
		if(this.numberofattackers == null)
			clone.numberofattackers = null;
		else
			clone.numberofattackers = (ims.emergency.vo.lookups.NumberOfAttackers)this.numberofattackers.clone();
		if(this.genderofattacker == null)
			clone.genderofattacker = null;
		else
			clone.genderofattacker = (ims.emergency.vo.lookups.GenderofAttacker)this.genderofattacker.clone();
		if(this.previouslyassulatedbyattacker == null)
			clone.previouslyassulatedbyattacker = null;
		else
			clone.previouslyassulatedbyattacker = (ims.emergency.vo.lookups.PatientPreviouslyAssaultedByAttacker)this.previouslyassulatedbyattacker.clone();
		clone.assaultlocationdetails = this.assaultlocationdetails;
		clone.relationshiptoattackerdetails = this.relationshiptoattackerdetails;
		clone.assaultweapondetails = this.assaultweapondetails;
		clone.lastdrinklocationdetails = this.lastdrinklocationdetails;
		if(this.attackerhadconsumedalcohol == null)
			clone.attackerhadconsumedalcohol = null;
		else
			clone.attackerhadconsumedalcohol = (ims.emergency.vo.lookups.AttackerHadConsumedAlcohol)this.attackerhadconsumedalcohol.clone();
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
		if (!(TIIGVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TIIGVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TIIGVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TIIGVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.hadpatientconsumedalcohol != null)
			count++;
		if(this.assaultweapon != null)
			count++;
		if(this.assaultlocation != null)
			count++;
		if(this.relationshiptoattacker != null)
			count++;
		if(this.intendtoinformpolice != null)
			count++;
		if(this.consumedorpurchasedalcoholfrom != null)
			count++;
		if(this.numberofattackers != null)
			count++;
		if(this.genderofattacker != null)
			count++;
		if(this.previouslyassulatedbyattacker != null)
			count++;
		if(this.assaultlocationdetails != null)
			count++;
		if(this.relationshiptoattackerdetails != null)
			count++;
		if(this.assaultweapondetails != null)
			count++;
		if(this.lastdrinklocationdetails != null)
			count++;
		if(this.attackerhadconsumedalcohol != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.emergency.vo.lookups.ConsumedAlcoholThreeHoursPriorToIncident hadpatientconsumedalcohol;
	protected ims.emergency.vo.lookups.AssaultWeapon assaultweapon;
	protected ims.emergency.vo.lookups.AssaultLocation assaultlocation;
	protected ims.emergency.vo.lookups.RelationshipToAttacker relationshiptoattacker;
	protected ims.emergency.vo.lookups.PoliceInformed intendtoinformpolice;
	protected ims.emergency.vo.lookups.ConsumedOrPurchasedAlcoholFrom consumedorpurchasedalcoholfrom;
	protected ims.emergency.vo.lookups.NumberOfAttackers numberofattackers;
	protected ims.emergency.vo.lookups.GenderofAttacker genderofattacker;
	protected ims.emergency.vo.lookups.PatientPreviouslyAssaultedByAttacker previouslyassulatedbyattacker;
	protected String assaultlocationdetails;
	protected String relationshiptoattackerdetails;
	protected String assaultweapondetails;
	protected String lastdrinklocationdetails;
	protected ims.emergency.vo.lookups.AttackerHadConsumedAlcohol attackerhadconsumedalcohol;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
