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
package ims.pathways.domain.objects;

/**
 * 
 * @author Cristian Belciug
 * Generated.
 */


public class PatientJourneyBreach extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1088100014;
	private static final long serialVersionUID = 1088100014L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	private ims.domain.lookups.LookupInstance breachReason;
	private String breachReasonComment;
	private java.util.Date breachReasonDate;
	private ims.core.resource.people.domain.objects.MemberOfStaff breachReasonRecordingMOS;
	private String correctionComments;
	private ims.core.clinical.domain.objects.RecordingUserInformation correctionAuthoringInfo;
	private Boolean corrected;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public PatientJourneyBreach (Integer id, int ver)
    {
    	super(id, ver);
    }
    public PatientJourneyBreach ()
    {
    	super();
    }
    public PatientJourneyBreach (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.pathways.domain.objects.PatientJourneyBreach.class;
	}


	public ims.domain.lookups.LookupInstance getBreachReason() {
		return breachReason;
	}
	public void setBreachReason(ims.domain.lookups.LookupInstance breachReason) {
		this.breachReason = breachReason;
	}

	public String getBreachReasonComment() {
		return breachReasonComment;
	}
	public void setBreachReasonComment(String breachReasonComment) {
		this.breachReasonComment = breachReasonComment;
	}

	public java.util.Date getBreachReasonDate() {
		return breachReasonDate;
	}
	public void setBreachReasonDate(java.util.Date breachReasonDate) {
		this.breachReasonDate = breachReasonDate;
	}

	public ims.core.resource.people.domain.objects.MemberOfStaff getBreachReasonRecordingMOS() {
		return breachReasonRecordingMOS;
	}
	public void setBreachReasonRecordingMOS(ims.core.resource.people.domain.objects.MemberOfStaff breachReasonRecordingMOS) {
		this.breachReasonRecordingMOS = breachReasonRecordingMOS;
	}

	public String getCorrectionComments() {
		return correctionComments;
	}
	public void setCorrectionComments(String correctionComments) {
		this.correctionComments = correctionComments;
	}

	public ims.core.clinical.domain.objects.RecordingUserInformation getCorrectionAuthoringInfo() {
		return correctionAuthoringInfo;
	}
	public void setCorrectionAuthoringInfo(ims.core.clinical.domain.objects.RecordingUserInformation correctionAuthoringInfo) {
		this.correctionAuthoringInfo = correctionAuthoringInfo;
	}

	public Boolean isCorrected() {
		return corrected;
	}
	public void setCorrected(Boolean corrected) {
		this.corrected = corrected;
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
		
		auditStr.append("\r\n*breachReason* :");
		if (breachReason != null)
			auditStr.append(breachReason.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*breachReasonComment* :");
		auditStr.append(breachReasonComment);
	    auditStr.append("; ");
		auditStr.append("\r\n*breachReasonDate* :");
		auditStr.append(breachReasonDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*breachReasonRecordingMOS* :");
		if (breachReasonRecordingMOS != null)
		{
			auditStr.append(toShortClassName(breachReasonRecordingMOS));
				
		    auditStr.append(breachReasonRecordingMOS.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*correctionComments* :");
		auditStr.append(correctionComments);
	    auditStr.append("; ");
		auditStr.append("\r\n*correctionAuthoringInfo* :");
		if (correctionAuthoringInfo != null)
		{
			auditStr.append(toShortClassName(correctionAuthoringInfo));
				
		    auditStr.append(correctionAuthoringInfo.toString());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*corrected* :");
		auditStr.append(corrected);
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
		
		String keyClassName = "PatientJourneyBreach";
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
		if (this.getBreachReason() != null)
		{
			sb.append("<breachReason>");
			sb.append(this.getBreachReason().toXMLString()); 
			sb.append("</breachReason>");		
		}
		if (this.getBreachReasonComment() != null)
		{
			sb.append("<breachReasonComment>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getBreachReasonComment().toString()));
			sb.append("</breachReasonComment>");		
		}
		if (this.getBreachReasonDate() != null)
		{
			sb.append("<breachReasonDate>");
			sb.append(new ims.framework.utils.DateTime(this.getBreachReasonDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</breachReasonDate>");		
		}
		if (this.getBreachReasonRecordingMOS() != null)
		{
			sb.append("<breachReasonRecordingMOS>");
			sb.append(this.getBreachReasonRecordingMOS().toXMLString(domMap)); 	
			sb.append("</breachReasonRecordingMOS>");		
		}
		if (this.getCorrectionComments() != null)
		{
			sb.append("<correctionComments>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getCorrectionComments().toString()));
			sb.append("</correctionComments>");		
		}
		if (this.getCorrectionAuthoringInfo() != null)
		{
			sb.append("<correctionAuthoringInfo>");
			sb.append(this.getCorrectionAuthoringInfo().toXMLString(domMap)); 	
			sb.append("</correctionAuthoringInfo>");		
		}
		if (this.isCorrected() != null)
		{
			sb.append("<corrected>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isCorrected().toString()));
			sb.append("</corrected>");		
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
			PatientJourneyBreach domainObject = getPatientJourneyBreachfromXML(itemEl, factory, domMap);

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
			PatientJourneyBreach domainObject = getPatientJourneyBreachfromXML(itemEl, factory, domMap);

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
		
	public static PatientJourneyBreach getPatientJourneyBreachfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getPatientJourneyBreachfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static PatientJourneyBreach getPatientJourneyBreachfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!PatientJourneyBreach.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!PatientJourneyBreach.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the PatientJourneyBreach class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (PatientJourneyBreach)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(PatientJourneyBreach.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		PatientJourneyBreach ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (PatientJourneyBreach)factory.getImportedDomainObject(PatientJourneyBreach.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new PatientJourneyBreach();
		}
		String keyClassName = "PatientJourneyBreach";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (PatientJourneyBreach)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, PatientJourneyBreach obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("breachReason");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setBreachReason(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("breachReasonComment");
		if(fldEl != null)
		{	
    		obj.setBreachReasonComment(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("breachReasonDate");
		if(fldEl != null)
		{	
    		obj.setBreachReasonDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("breachReasonRecordingMOS");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setBreachReasonRecordingMOS(ims.core.resource.people.domain.objects.MemberOfStaff.getMemberOfStafffromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("correctionComments");
		if(fldEl != null)
		{	
    		obj.setCorrectionComments(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("correctionAuthoringInfo");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setCorrectionAuthoringInfo(ims.core.clinical.domain.objects.RecordingUserInformation.getRecordingUserInformationfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("corrected");
		if(fldEl != null)
		{	
    		obj.setCorrected(new Boolean(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String BreachReason = "breachReason";
		public static final String BreachReasonComment = "breachReasonComment";
		public static final String BreachReasonDate = "breachReasonDate";
		public static final String BreachReasonRecordingMOS = "breachReasonRecordingMOS";
		public static final String CorrectionComments = "correctionComments";
		public static final String CorrectionAuthoringInfo = "correctionAuthoringInfo";
		public static final String Corrected = "corrected";
	}
}

