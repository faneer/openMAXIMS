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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 12/10/2015, 13:28
 *
 */
package ims.oncology.domain.objects;

/**
 * 
 * @author Rory Fitzpatrick
 * Generated.
 */


public class InternalReferral extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1074100041;
	private static final long serialVersionUID = 1074100041L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Status */
	private ims.domain.lookups.LookupInstance status;
	/** Date of Referral (Default to today) */
	private java.util.Date referralDate;
	/** Type of Referral (e.g Physiotherapy / Occupational Therapy etc.) */
	private ims.domain.lookups.LookupInstance referralType;
	/** Source of the referral (Individual Wards / Outpatient clinic etc) */
	private ims.domain.lookups.LookupInstance referralSource;
	/** Referred By */
	private ims.core.resource.people.domain.objects.Hcp referredBy;
	/** Diagnosis (Free text field) */
	private String diagnosisText;
	/** Planned discharge date */
	private java.util.Date plannedDischargeDate;
	/** Treatment start date */
	private java.util.Date treatmentStartDate;
	/** Treatment end date */
	private java.util.Date treatmentEndDate;
	/** Free text Comments Field */
	private String comments;
	/** Internal Referral Outcome */
	private ims.oncology.domain.objects.InternalReferralOutcome internalReferralOutcome;
	/** Referral Reason
	  * Collection of ims.domain.lookups.LookupInstance.
	  */
	private java.util.List referralReason;
	/** Patient */
	private ims.core.patient.domain.objects.Patient patient;
	/** EpisodeOfCare */
	private ims.core.admin.domain.objects.EpisodeOfCare episodeOfCare;
	private Boolean referralSeen;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public InternalReferral (Integer id, int ver)
    {
    	super(id, ver);
    }
    public InternalReferral ()
    {
    	super();
    }
    public InternalReferral (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.oncology.domain.objects.InternalReferral.class;
	}


	public ims.domain.lookups.LookupInstance getStatus() {
		return status;
	}
	public void setStatus(ims.domain.lookups.LookupInstance status) {
		this.status = status;
	}

	public java.util.Date getReferralDate() {
		return referralDate;
	}
	public void setReferralDate(java.util.Date referralDate) {
		this.referralDate = referralDate;
	}

	public ims.domain.lookups.LookupInstance getReferralType() {
		return referralType;
	}
	public void setReferralType(ims.domain.lookups.LookupInstance referralType) {
		this.referralType = referralType;
	}

	public ims.domain.lookups.LookupInstance getReferralSource() {
		return referralSource;
	}
	public void setReferralSource(ims.domain.lookups.LookupInstance referralSource) {
		this.referralSource = referralSource;
	}

	public ims.core.resource.people.domain.objects.Hcp getReferredBy() {
		return referredBy;
	}
	public void setReferredBy(ims.core.resource.people.domain.objects.Hcp referredBy) {
		this.referredBy = referredBy;
	}

	public String getDiagnosisText() {
		return diagnosisText;
	}
	public void setDiagnosisText(String diagnosisText) {
		if ( null != diagnosisText && diagnosisText.length() > 255 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for diagnosisText. Tried to set value: "+
				diagnosisText);
		}
		this.diagnosisText = diagnosisText;
	}

	public java.util.Date getPlannedDischargeDate() {
		return plannedDischargeDate;
	}
	public void setPlannedDischargeDate(java.util.Date plannedDischargeDate) {
		this.plannedDischargeDate = plannedDischargeDate;
	}

	public java.util.Date getTreatmentStartDate() {
		return treatmentStartDate;
	}
	public void setTreatmentStartDate(java.util.Date treatmentStartDate) {
		this.treatmentStartDate = treatmentStartDate;
	}

	public java.util.Date getTreatmentEndDate() {
		return treatmentEndDate;
	}
	public void setTreatmentEndDate(java.util.Date treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}

	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		if ( null != comments && comments.length() > 1000 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for comments. Tried to set value: "+
				comments);
		}
		this.comments = comments;
	}

	public ims.oncology.domain.objects.InternalReferralOutcome getInternalReferralOutcome() {
		return internalReferralOutcome;
	}
	public void setInternalReferralOutcome(ims.oncology.domain.objects.InternalReferralOutcome internalReferralOutcome) {
		this.internalReferralOutcome = internalReferralOutcome;
	}

	public java.util.List getReferralReason() {
		if ( null == referralReason ) {
			referralReason = new java.util.ArrayList();
		}
		return referralReason;
	}
	public void setReferralReason(java.util.List paramValue) {
		this.referralReason = paramValue;
	}

	public ims.core.patient.domain.objects.Patient getPatient() {
		return patient;
	}
	public void setPatient(ims.core.patient.domain.objects.Patient patient) {
		this.patient = patient;
	}

	public ims.core.admin.domain.objects.EpisodeOfCare getEpisodeOfCare() {
		return episodeOfCare;
	}
	public void setEpisodeOfCare(ims.core.admin.domain.objects.EpisodeOfCare episodeOfCare) {
		this.episodeOfCare = episodeOfCare;
	}

	public Boolean isReferralSeen() {
		return referralSeen;
	}
	public void setReferralSeen(Boolean referralSeen) {
		this.referralSeen = referralSeen;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*status* :");
		if (status != null)
			auditStr.append(status.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*referralDate* :");
		auditStr.append(referralDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*referralType* :");
		if (referralType != null)
			auditStr.append(referralType.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*referralSource* :");
		if (referralSource != null)
			auditStr.append(referralSource.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*referredBy* :");
		if (referredBy != null)
		{
			auditStr.append(toShortClassName(referredBy));
				
		    auditStr.append(referredBy.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*diagnosisText* :");
		auditStr.append(diagnosisText);
	    auditStr.append("; ");
		auditStr.append("\r\n*plannedDischargeDate* :");
		auditStr.append(plannedDischargeDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*treatmentStartDate* :");
		auditStr.append(treatmentStartDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*treatmentEndDate* :");
		auditStr.append(treatmentEndDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*comments* :");
		auditStr.append(comments);
	    auditStr.append("; ");
		auditStr.append("\r\n*internalReferralOutcome* :");
		if (internalReferralOutcome != null)
		{
			auditStr.append(toShortClassName(internalReferralOutcome));
				
		    auditStr.append(internalReferralOutcome.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*referralReason* :");
		if (referralReason != null)
		{
		int i12=0;
		for (i12=0; i12<referralReason.size(); i12++)
		{
			if (i12 > 0)
				auditStr.append(",");
			ims.domain.lookups.LookupInstance obj = (ims.domain.lookups.LookupInstance)referralReason.get(i12);
			auditStr.append(obj.getText());
		}
		if (i12 > 0)
			auditStr.append("] " + i12);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*patient* :");
		if (patient != null)
		{
			auditStr.append(toShortClassName(patient));
				
		    auditStr.append(patient.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*episodeOfCare* :");
		if (episodeOfCare != null)
		{
			auditStr.append(toShortClassName(episodeOfCare));
				
		    auditStr.append(episodeOfCare.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*referralSeen* :");
		auditStr.append(referralSeen);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "InternalReferral";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getStatus() != null)
		{
			sb.append("<status>");
			sb.append(this.getStatus().toXMLString()); 
			sb.append("</status>");		
		}
		if (this.getReferralDate() != null)
		{
			sb.append("<referralDate>");
			sb.append(new ims.framework.utils.DateTime(this.getReferralDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</referralDate>");		
		}
		if (this.getReferralType() != null)
		{
			sb.append("<referralType>");
			sb.append(this.getReferralType().toXMLString()); 
			sb.append("</referralType>");		
		}
		if (this.getReferralSource() != null)
		{
			sb.append("<referralSource>");
			sb.append(this.getReferralSource().toXMLString()); 
			sb.append("</referralSource>");		
		}
		if (this.getReferredBy() != null)
		{
			sb.append("<referredBy>");
			sb.append(this.getReferredBy().toXMLString(domMap)); 	
			sb.append("</referredBy>");		
		}
		if (this.getDiagnosisText() != null)
		{
			sb.append("<diagnosisText>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getDiagnosisText().toString()));
			sb.append("</diagnosisText>");		
		}
		if (this.getPlannedDischargeDate() != null)
		{
			sb.append("<plannedDischargeDate>");
			sb.append(new ims.framework.utils.DateTime(this.getPlannedDischargeDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</plannedDischargeDate>");		
		}
		if (this.getTreatmentStartDate() != null)
		{
			sb.append("<treatmentStartDate>");
			sb.append(new ims.framework.utils.DateTime(this.getTreatmentStartDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</treatmentStartDate>");		
		}
		if (this.getTreatmentEndDate() != null)
		{
			sb.append("<treatmentEndDate>");
			sb.append(new ims.framework.utils.DateTime(this.getTreatmentEndDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</treatmentEndDate>");		
		}
		if (this.getComments() != null)
		{
			sb.append("<comments>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getComments().toString()));
			sb.append("</comments>");		
		}
		if (this.getInternalReferralOutcome() != null)
		{
			sb.append("<internalReferralOutcome>");
			sb.append(this.getInternalReferralOutcome().toXMLString(domMap)); 	
			sb.append("</internalReferralOutcome>");		
		}
		if (this.getReferralReason() != null)
		{
			if (this.getReferralReason().size() > 0 )
			{
			sb.append("<referralReason>");
			sb.append(ims.domain.lookups.LookupInstance.toXMLString(this.getReferralReason())); 
			sb.append("</referralReason>");		
			}
		}
		if (this.getPatient() != null)
		{
			sb.append("<patient>");
			sb.append(this.getPatient().toXMLString(domMap)); 	
			sb.append("</patient>");		
		}
		if (this.getEpisodeOfCare() != null)
		{
			sb.append("<episodeOfCare>");
			sb.append(this.getEpisodeOfCare().toXMLString(domMap)); 	
			sb.append("</episodeOfCare>");		
		}
		if (this.isReferralSeen() != null)
		{
			sb.append("<referralSeen>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isReferralSeen().toString()));
			sb.append("</referralSeen>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			InternalReferral domainObject = getInternalReferralfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			InternalReferral domainObject = getInternalReferralfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static InternalReferral getInternalReferralfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getInternalReferralfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static InternalReferral getInternalReferralfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!InternalReferral.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!InternalReferral.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the InternalReferral class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (InternalReferral)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(InternalReferral.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		InternalReferral ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (InternalReferral)factory.getImportedDomainObject(InternalReferral.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new InternalReferral();
		}
		String keyClassName = "InternalReferral";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (InternalReferral)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, InternalReferral obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("status");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setStatus(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("referralDate");
		if(fldEl != null)
		{	
    		obj.setReferralDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("referralType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setReferralType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("referralSource");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setReferralSource(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("referredBy");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setReferredBy(ims.core.resource.people.domain.objects.Hcp.getHcpfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("diagnosisText");
		if(fldEl != null)
		{	
    		obj.setDiagnosisText(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("plannedDischargeDate");
		if(fldEl != null)
		{	
    		obj.setPlannedDischargeDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("treatmentStartDate");
		if(fldEl != null)
		{	
    		obj.setTreatmentStartDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("treatmentEndDate");
		if(fldEl != null)
		{	
    		obj.setTreatmentEndDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("comments");
		if(fldEl != null)
		{	
    		obj.setComments(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("internalReferralOutcome");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setInternalReferralOutcome(ims.oncology.domain.objects.InternalReferralOutcome.getInternalReferralOutcomefromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("referralReason");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setReferralReason(ims.domain.lookups.LookupInstance.fromListXMLString(fldEl, factory, obj.getReferralReason())); 
		}
		fldEl = el.element("patient");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setPatient(ims.core.patient.domain.objects.Patient.getPatientfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("episodeOfCare");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setEpisodeOfCare(ims.core.admin.domain.objects.EpisodeOfCare.getEpisodeOfCarefromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("referralSeen");
		if(fldEl != null)
		{	
    		obj.setReferralSeen(new Boolean(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "referralReason"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String Status = "status";
		public static final String ReferralDate = "referralDate";
		public static final String ReferralType = "referralType";
		public static final String ReferralSource = "referralSource";
		public static final String ReferredBy = "referredBy";
		public static final String DiagnosisText = "diagnosisText";
		public static final String PlannedDischargeDate = "plannedDischargeDate";
		public static final String TreatmentStartDate = "treatmentStartDate";
		public static final String TreatmentEndDate = "treatmentEndDate";
		public static final String Comments = "comments";
		public static final String InternalReferralOutcome = "internalReferralOutcome";
		public static final String ReferralReason = "referralReason";
		public static final String Patient = "patient";
		public static final String EpisodeOfCare = "episodeOfCare";
		public static final String ReferralSeen = "referralSeen";
	}
}

