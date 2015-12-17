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

package ims.core.vo;

/**
 * Linked to core.clinical.SocialHistory business object (ID: 1003100026).
 */
public class SocialHistoryVo extends ims.core.vo.SocialHistoryLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SocialHistoryVo()
	{
	}
	public SocialHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public SocialHistoryVo(ims.core.vo.beans.SocialHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.smokingstatus = bean.getSmokingStatus() == null ? null : ims.core.vo.lookups.SmokingStatus.buildLookup(bean.getSmokingStatus());
		this.smokingdetails = ims.core.vo.SmokingDetailsCollection.buildFromBeanCollection(bean.getSmokingDetails());
		this.alcohol = bean.getAlcohol() == null ? null : bean.getAlcohol().buildVo();
		this.illicitdrugs = bean.getIllicitDrugs();
		this.occupation = bean.getOccupation() == null ? null : ims.core.vo.lookups.Occupation.buildLookup(bean.getOccupation());
		this.liveswith = bean.getLivesWith() == null ? null : ims.core.vo.lookups.LivesWith.buildLookup(bean.getLivesWith());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.fittocareforpatient = bean.getFitToCareForPatient() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getFitToCareForPatient());
		this.fittotakehome = bean.getFitToTakeHome() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getFitToTakeHome());
		this.occupationtext = bean.getOccupationText();
		this.socialhistorynotes = bean.getSocialHistoryNotes();
		this.maritalstatus = bean.getMaritalStatus() == null ? null : bean.getMaritalStatus().buildVo();
		this.mobilityindependence = bean.getMobilityIndependence();
		this.occupationstatus = bean.getOccupationStatus() == null ? null : ims.core.vo.lookups.OccupationStatus.buildLookup(bean.getOccupationStatus());
		this.diet = bean.getDiet() == null ? null : ims.core.vo.lookups.SocialHistoryDiet.buildLookup(bean.getDiet());
		this.illicitdrugslist = bean.getIllicitDrugsList() == null ? null : bean.getIllicitDrugsList().buildVo();
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.SocialHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.smokingstatus = bean.getSmokingStatus() == null ? null : ims.core.vo.lookups.SmokingStatus.buildLookup(bean.getSmokingStatus());
		this.smokingdetails = ims.core.vo.SmokingDetailsCollection.buildFromBeanCollection(bean.getSmokingDetails());
		this.alcohol = bean.getAlcohol() == null ? null : bean.getAlcohol().buildVo(map);
		this.illicitdrugs = bean.getIllicitDrugs();
		this.occupation = bean.getOccupation() == null ? null : ims.core.vo.lookups.Occupation.buildLookup(bean.getOccupation());
		this.liveswith = bean.getLivesWith() == null ? null : ims.core.vo.lookups.LivesWith.buildLookup(bean.getLivesWith());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.fittocareforpatient = bean.getFitToCareForPatient() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getFitToCareForPatient());
		this.fittotakehome = bean.getFitToTakeHome() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getFitToTakeHome());
		this.occupationtext = bean.getOccupationText();
		this.socialhistorynotes = bean.getSocialHistoryNotes();
		this.maritalstatus = bean.getMaritalStatus() == null ? null : bean.getMaritalStatus().buildVo(map);
		this.mobilityindependence = bean.getMobilityIndependence();
		this.occupationstatus = bean.getOccupationStatus() == null ? null : ims.core.vo.lookups.OccupationStatus.buildLookup(bean.getOccupationStatus());
		this.diet = bean.getDiet() == null ? null : ims.core.vo.lookups.SocialHistoryDiet.buildLookup(bean.getDiet());
		this.illicitdrugslist = bean.getIllicitDrugsList() == null ? null : bean.getIllicitDrugsList().buildVo(map);
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.SocialHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.SocialHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.SocialHistoryVoBean();
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
		if(fieldName.equals("SMOKINGSTATUS"))
			return getSmokingStatus();
		if(fieldName.equals("SMOKINGDETAILS"))
			return getSmokingDetails();
		if(fieldName.equals("ALCOHOL"))
			return getAlcohol();
		if(fieldName.equals("ILLICITDRUGS"))
			return getIllicitDrugs();
		if(fieldName.equals("OCCUPATION"))
			return getOccupation();
		if(fieldName.equals("LIVESWITH"))
			return getLivesWith();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("FITTOCAREFORPATIENT"))
			return getFitToCareForPatient();
		if(fieldName.equals("FITTOTAKEHOME"))
			return getFitToTakeHome();
		if(fieldName.equals("OCCUPATIONTEXT"))
			return getOccupationText();
		if(fieldName.equals("SOCIALHISTORYNOTES"))
			return getSocialHistoryNotes();
		if(fieldName.equals("MARITALSTATUS"))
			return getMaritalStatus();
		if(fieldName.equals("MOBILITYINDEPENDENCE"))
			return getMobilityIndependence();
		if(fieldName.equals("OCCUPATIONSTATUS"))
			return getOccupationStatus();
		if(fieldName.equals("DIET"))
			return getDiet();
		if(fieldName.equals("ILLICITDRUGSLIST"))
			return getIllicitDrugsList();
		if(fieldName.equals("RECORDINGINFORMATION"))
			return getRecordingInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSmokingStatusIsNotNull()
	{
		return this.smokingstatus != null;
	}
	public ims.core.vo.lookups.SmokingStatus getSmokingStatus()
	{
		return this.smokingstatus;
	}
	public void setSmokingStatus(ims.core.vo.lookups.SmokingStatus value)
	{
		this.isValidated = false;
		this.smokingstatus = value;
	}
	public boolean getSmokingDetailsIsNotNull()
	{
		return this.smokingdetails != null;
	}
	public ims.core.vo.SmokingDetailsCollection getSmokingDetails()
	{
		return this.smokingdetails;
	}
	public void setSmokingDetails(ims.core.vo.SmokingDetailsCollection value)
	{
		this.isValidated = false;
		this.smokingdetails = value;
	}
	public boolean getAlcoholIsNotNull()
	{
		return this.alcohol != null;
	}
	public ims.core.vo.AlcoholVo getAlcohol()
	{
		return this.alcohol;
	}
	public void setAlcohol(ims.core.vo.AlcoholVo value)
	{
		this.isValidated = false;
		this.alcohol = value;
	}
	public boolean getIllicitDrugsIsNotNull()
	{
		return this.illicitdrugs != null;
	}
	public String getIllicitDrugs()
	{
		return this.illicitdrugs;
	}
	public static int getIllicitDrugsMaxLength()
	{
		return 1000;
	}
	public void setIllicitDrugs(String value)
	{
		this.isValidated = false;
		this.illicitdrugs = value;
	}
	public boolean getOccupationIsNotNull()
	{
		return this.occupation != null;
	}
	public ims.core.vo.lookups.Occupation getOccupation()
	{
		return this.occupation;
	}
	public void setOccupation(ims.core.vo.lookups.Occupation value)
	{
		this.isValidated = false;
		this.occupation = value;
	}
	public boolean getLivesWithIsNotNull()
	{
		return this.liveswith != null;
	}
	public ims.core.vo.lookups.LivesWith getLivesWith()
	{
		return this.liveswith;
	}
	public void setLivesWith(ims.core.vo.lookups.LivesWith value)
	{
		this.isValidated = false;
		this.liveswith = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getFitToCareForPatientIsNotNull()
	{
		return this.fittocareforpatient != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getFitToCareForPatient()
	{
		return this.fittocareforpatient;
	}
	public void setFitToCareForPatient(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.fittocareforpatient = value;
	}
	public boolean getFitToTakeHomeIsNotNull()
	{
		return this.fittotakehome != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getFitToTakeHome()
	{
		return this.fittotakehome;
	}
	public void setFitToTakeHome(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.fittotakehome = value;
	}
	public boolean getOccupationTextIsNotNull()
	{
		return this.occupationtext != null;
	}
	public String getOccupationText()
	{
		return this.occupationtext;
	}
	public static int getOccupationTextMaxLength()
	{
		return 100;
	}
	public void setOccupationText(String value)
	{
		this.isValidated = false;
		this.occupationtext = value;
	}
	public boolean getSocialHistoryNotesIsNotNull()
	{
		return this.socialhistorynotes != null;
	}
	public String getSocialHistoryNotes()
	{
		return this.socialhistorynotes;
	}
	public static int getSocialHistoryNotesMaxLength()
	{
		return 1000;
	}
	public void setSocialHistoryNotes(String value)
	{
		this.isValidated = false;
		this.socialhistorynotes = value;
	}
	public boolean getMaritalStatusIsNotNull()
	{
		return this.maritalstatus != null;
	}
	public ims.core.vo.SocialHistoryMaritalStatusVo getMaritalStatus()
	{
		return this.maritalstatus;
	}
	public void setMaritalStatus(ims.core.vo.SocialHistoryMaritalStatusVo value)
	{
		this.isValidated = false;
		this.maritalstatus = value;
	}
	public boolean getMobilityIndependenceIsNotNull()
	{
		return this.mobilityindependence != null;
	}
	public String getMobilityIndependence()
	{
		return this.mobilityindependence;
	}
	public static int getMobilityIndependenceMaxLength()
	{
		return 500;
	}
	public void setMobilityIndependence(String value)
	{
		this.isValidated = false;
		this.mobilityindependence = value;
	}
	public boolean getOccupationStatusIsNotNull()
	{
		return this.occupationstatus != null;
	}
	public ims.core.vo.lookups.OccupationStatus getOccupationStatus()
	{
		return this.occupationstatus;
	}
	public void setOccupationStatus(ims.core.vo.lookups.OccupationStatus value)
	{
		this.isValidated = false;
		this.occupationstatus = value;
	}
	public boolean getDietIsNotNull()
	{
		return this.diet != null;
	}
	public ims.core.vo.lookups.SocialHistoryDiet getDiet()
	{
		return this.diet;
	}
	public void setDiet(ims.core.vo.lookups.SocialHistoryDiet value)
	{
		this.isValidated = false;
		this.diet = value;
	}
	public boolean getIllicitDrugsListIsNotNull()
	{
		return this.illicitdrugslist != null;
	}
	public ims.core.vo.IllicitDrugsVo getIllicitDrugsList()
	{
		return this.illicitdrugslist;
	}
	public void setIllicitDrugsList(ims.core.vo.IllicitDrugsVo value)
	{
		this.isValidated = false;
		this.illicitdrugslist = value;
	}
	public boolean getRecordingInformationIsNotNull()
	{
		return this.recordinginformation != null;
	}
	public ims.core.vo.RecordingUserInformationVo getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.RecordingUserInformationVo value)
	{
		this.isValidated = false;
		this.recordinginformation = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.smokingdetails != null)
		{
			if(!this.smokingdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.alcohol != null)
		{
			if(!this.alcohol.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.maritalstatus != null)
		{
			if(!this.maritalstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.illicitdrugslist != null)
		{
			if(!this.illicitdrugslist.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.recordinginformation != null)
		{
			if(!this.recordinginformation.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.smokingdetails != null)
		{
			String[] listOfOtherErrors = this.smokingdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.alcohol != null)
		{
			String[] listOfOtherErrors = this.alcohol.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.illicitdrugs != null)
			if(this.illicitdrugs.length() > 1000)
				listOfErrors.add("The length of the field [illicitdrugs] in the value object [ims.core.vo.SocialHistoryVo] is too big. It should be less or equal to 1000");
		if(this.occupationtext != null)
			if(this.occupationtext.length() > 100)
				listOfErrors.add("The length of the field [occupationtext] in the value object [ims.core.vo.SocialHistoryVo] is too big. It should be less or equal to 100");
		if(this.socialhistorynotes != null)
			if(this.socialhistorynotes.length() > 1000)
				listOfErrors.add("The length of the field [socialhistorynotes] in the value object [ims.core.vo.SocialHistoryVo] is too big. It should be less or equal to 1000");
		if(this.maritalstatus != null)
		{
			String[] listOfOtherErrors = this.maritalstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.mobilityindependence != null)
			if(this.mobilityindependence.length() > 500)
				listOfErrors.add("The length of the field [mobilityindependence] in the value object [ims.core.vo.SocialHistoryVo] is too big. It should be less or equal to 500");
		if(this.illicitdrugslist != null)
		{
			String[] listOfOtherErrors = this.illicitdrugslist.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.recordinginformation != null)
		{
			String[] listOfOtherErrors = this.recordinginformation.validate();
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
	
		SocialHistoryVo clone = new SocialHistoryVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.smokingstatus == null)
			clone.smokingstatus = null;
		else
			clone.smokingstatus = (ims.core.vo.lookups.SmokingStatus)this.smokingstatus.clone();
		if(this.smokingdetails == null)
			clone.smokingdetails = null;
		else
			clone.smokingdetails = (ims.core.vo.SmokingDetailsCollection)this.smokingdetails.clone();
		if(this.alcohol == null)
			clone.alcohol = null;
		else
			clone.alcohol = (ims.core.vo.AlcoholVo)this.alcohol.clone();
		clone.illicitdrugs = this.illicitdrugs;
		if(this.occupation == null)
			clone.occupation = null;
		else
			clone.occupation = (ims.core.vo.lookups.Occupation)this.occupation.clone();
		if(this.liveswith == null)
			clone.liveswith = null;
		else
			clone.liveswith = (ims.core.vo.lookups.LivesWith)this.liveswith.clone();
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.fittocareforpatient == null)
			clone.fittocareforpatient = null;
		else
			clone.fittocareforpatient = (ims.core.vo.lookups.YesNoUnknown)this.fittocareforpatient.clone();
		if(this.fittotakehome == null)
			clone.fittotakehome = null;
		else
			clone.fittotakehome = (ims.core.vo.lookups.YesNoUnknown)this.fittotakehome.clone();
		clone.occupationtext = this.occupationtext;
		clone.socialhistorynotes = this.socialhistorynotes;
		if(this.maritalstatus == null)
			clone.maritalstatus = null;
		else
			clone.maritalstatus = (ims.core.vo.SocialHistoryMaritalStatusVo)this.maritalstatus.clone();
		clone.mobilityindependence = this.mobilityindependence;
		if(this.occupationstatus == null)
			clone.occupationstatus = null;
		else
			clone.occupationstatus = (ims.core.vo.lookups.OccupationStatus)this.occupationstatus.clone();
		if(this.diet == null)
			clone.diet = null;
		else
			clone.diet = (ims.core.vo.lookups.SocialHistoryDiet)this.diet.clone();
		if(this.illicitdrugslist == null)
			clone.illicitdrugslist = null;
		else
			clone.illicitdrugslist = (ims.core.vo.IllicitDrugsVo)this.illicitdrugslist.clone();
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.RecordingUserInformationVo)this.recordinginformation.clone();
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
		if (!(SocialHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SocialHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SocialHistoryVo compareObj = (SocialHistoryVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_SocialHistory() == null && compareObj.getID_SocialHistory() != null)
				return -1;
			if(this.getID_SocialHistory() != null && compareObj.getID_SocialHistory() == null)
				return 1;
			if(this.getID_SocialHistory() != null && compareObj.getID_SocialHistory() != null)
				retVal = this.getID_SocialHistory().compareTo(compareObj.getID_SocialHistory());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.smokingstatus != null)
			count++;
		if(this.smokingdetails != null)
			count++;
		if(this.alcohol != null)
			count++;
		if(this.illicitdrugs != null)
			count++;
		if(this.occupation != null)
			count++;
		if(this.liveswith != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.fittocareforpatient != null)
			count++;
		if(this.fittotakehome != null)
			count++;
		if(this.occupationtext != null)
			count++;
		if(this.socialhistorynotes != null)
			count++;
		if(this.maritalstatus != null)
			count++;
		if(this.mobilityindependence != null)
			count++;
		if(this.occupationstatus != null)
			count++;
		if(this.diet != null)
			count++;
		if(this.illicitdrugslist != null)
			count++;
		if(this.recordinginformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 17;
	}
	protected ims.core.vo.lookups.SmokingStatus smokingstatus;
	protected ims.core.vo.SmokingDetailsCollection smokingdetails;
	protected ims.core.vo.AlcoholVo alcohol;
	protected String illicitdrugs;
	protected ims.core.vo.lookups.Occupation occupation;
	protected ims.core.vo.lookups.LivesWith liveswith;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.core.vo.lookups.YesNoUnknown fittocareforpatient;
	protected ims.core.vo.lookups.YesNoUnknown fittotakehome;
	protected String occupationtext;
	protected String socialhistorynotes;
	protected ims.core.vo.SocialHistoryMaritalStatusVo maritalstatus;
	protected String mobilityindependence;
	protected ims.core.vo.lookups.OccupationStatus occupationstatus;
	protected ims.core.vo.lookups.SocialHistoryDiet diet;
	protected ims.core.vo.IllicitDrugsVo illicitdrugslist;
	protected ims.core.vo.RecordingUserInformationVo recordinginformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
