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
package ims.core.admin.pas.domain.objects;

/**
 * 
 * @author John MacEnri
 * Generated.
 */


public class ConsultantStay extends ims.domain.DomainObject implements java.io.Serializable {
	public static final int CLASSID = 1014100005;
	private static final long serialVersionUID = 1014100005L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	private ims.core.resource.people.domain.objects.Medic consultant;
	/** transferDateTime */
	private java.util.Date transferDateTime;
	private java.util.Date endDateTime;
	private ims.domain.lookups.LookupInstance specialty;
	/** Coding Status for FCE */
	private ims.domain.lookups.LookupInstance codingStatus;
	/** Coding Comments in Maxims
	  * Collection of ims.clinical.domain.objects.CodingComment.
	  */
	private java.util.List codingComment;
	/** Histology Status */
	private ims.domain.lookups.LookupInstance histologyStatus;
	private ims.core.clinical.domain.objects.Service service;
	/** Patient Status */
	private ims.domain.lookups.LookupInstance patientStatus;
    public ConsultantStay (Integer id, int ver)
    {
    	super(id, ver);
    }
    public ConsultantStay ()
    {
    	super();
    }
    public ConsultantStay (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.admin.pas.domain.objects.ConsultantStay.class;
	}


	public ims.core.resource.people.domain.objects.Medic getConsultant() {
		return consultant;
	}
	public void setConsultant(ims.core.resource.people.domain.objects.Medic consultant) {
		this.consultant = consultant;
	}

	public java.util.Date getTransferDateTime() {
		return transferDateTime;
	}
	public void setTransferDateTime(java.util.Date transferDateTime) {
		this.transferDateTime = transferDateTime;
	}

	public java.util.Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(java.util.Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public ims.domain.lookups.LookupInstance getSpecialty() {
		return specialty;
	}
	public void setSpecialty(ims.domain.lookups.LookupInstance specialty) {
		this.specialty = specialty;
	}

	public ims.domain.lookups.LookupInstance getCodingStatus() {
		return codingStatus;
	}
	public void setCodingStatus(ims.domain.lookups.LookupInstance codingStatus) {
		this.codingStatus = codingStatus;
	}

	public java.util.List getCodingComment() {
		if ( null == codingComment ) {
			codingComment = new java.util.ArrayList();
		}
		return codingComment;
	}
	public void setCodingComment(java.util.List paramValue) {
		this.codingComment = paramValue;
	}

	public ims.domain.lookups.LookupInstance getHistologyStatus() {
		return histologyStatus;
	}
	public void setHistologyStatus(ims.domain.lookups.LookupInstance histologyStatus) {
		this.histologyStatus = histologyStatus;
	}

	public ims.core.clinical.domain.objects.Service getService() {
		return service;
	}
	public void setService(ims.core.clinical.domain.objects.Service service) {
		this.service = service;
	}

	public ims.domain.lookups.LookupInstance getPatientStatus() {
		return patientStatus;
	}
	public void setPatientStatus(ims.domain.lookups.LookupInstance patientStatus) {
		this.patientStatus = patientStatus;
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
		
		auditStr.append("\r\n*consultant* :");
		if (consultant != null)
		{
			auditStr.append(toShortClassName(consultant));
				
		    auditStr.append(consultant.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*transferDateTime* :");
		auditStr.append(transferDateTime);
	    auditStr.append("; ");
		auditStr.append("\r\n*endDateTime* :");
		auditStr.append(endDateTime);
	    auditStr.append("; ");
		auditStr.append("\r\n*specialty* :");
		if (specialty != null)
			auditStr.append(specialty.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*codingStatus* :");
		if (codingStatus != null)
			auditStr.append(codingStatus.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*codingComment* :");
		if (codingComment != null)
		{
		int i6=0;
		for (i6=0; i6<codingComment.size(); i6++)
		{
			if (i6 > 0)
				auditStr.append(",");
			ims.clinical.domain.objects.CodingComment obj = (ims.clinical.domain.objects.CodingComment)codingComment.get(i6);
		    if (obj != null)
			{
				if (i6 == 0)
				{
				auditStr.append(toShortClassName(obj));
				auditStr.append("[");
				}
		        auditStr.append(obj.getId());
			}
		}
		if (i6 > 0)
			auditStr.append("] " + i6);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*histologyStatus* :");
		if (histologyStatus != null)
			auditStr.append(histologyStatus.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*service* :");
		if (service != null)
		{
			auditStr.append(toShortClassName(service));
				
		    auditStr.append(service.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*patientStatus* :");
		if (patientStatus != null)
			auditStr.append(patientStatus.getText());
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
		
		String keyClassName = "ConsultantStay";
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
		if (this.getConsultant() != null)
		{
			sb.append("<consultant>");
			sb.append(this.getConsultant().toXMLString(domMap)); 	
			sb.append("</consultant>");		
		}
		if (this.getTransferDateTime() != null)
		{
			sb.append("<transferDateTime>");
			sb.append(new ims.framework.utils.DateTime(this.getTransferDateTime()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</transferDateTime>");		
		}
		if (this.getEndDateTime() != null)
		{
			sb.append("<endDateTime>");
			sb.append(new ims.framework.utils.DateTime(this.getEndDateTime()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</endDateTime>");		
		}
		if (this.getSpecialty() != null)
		{
			sb.append("<specialty>");
			sb.append(this.getSpecialty().toXMLString()); 
			sb.append("</specialty>");		
		}
		if (this.getCodingStatus() != null)
		{
			sb.append("<codingStatus>");
			sb.append(this.getCodingStatus().toXMLString()); 
			sb.append("</codingStatus>");		
		}
		if (this.getCodingComment() != null)
		{
			if (this.getCodingComment().size() > 0 )
			{
			sb.append("<codingComment>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getCodingComment(), domMap));
			sb.append("</codingComment>");		
			}
		}
		if (this.getHistologyStatus() != null)
		{
			sb.append("<histologyStatus>");
			sb.append(this.getHistologyStatus().toXMLString()); 
			sb.append("</histologyStatus>");		
		}
		if (this.getService() != null)
		{
			sb.append("<service>");
			sb.append(this.getService().toXMLString(domMap)); 	
			sb.append("</service>");		
		}
		if (this.getPatientStatus() != null)
		{
			sb.append("<patientStatus>");
			sb.append(this.getPatientStatus().toXMLString()); 
			sb.append("</patientStatus>");		
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
			ConsultantStay domainObject = getConsultantStayfromXML(itemEl, factory, domMap);

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
			ConsultantStay domainObject = getConsultantStayfromXML(itemEl, factory, domMap);

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
		
	public static ConsultantStay getConsultantStayfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getConsultantStayfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static ConsultantStay getConsultantStayfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!ConsultantStay.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!ConsultantStay.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the ConsultantStay class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (ConsultantStay)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(ConsultantStay.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		ConsultantStay ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (ConsultantStay)factory.getImportedDomainObject(ConsultantStay.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new ConsultantStay();
		}
		String keyClassName = "ConsultantStay";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (ConsultantStay)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, ConsultantStay obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("consultant");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setConsultant(ims.core.resource.people.domain.objects.Medic.getMedicfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("transferDateTime");
		if(fldEl != null)
		{	
    		obj.setTransferDateTime(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("endDateTime");
		if(fldEl != null)
		{	
    		obj.setEndDateTime(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("specialty");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setSpecialty(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("codingStatus");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setCodingStatus(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("codingComment");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setCodingComment(ims.clinical.domain.objects.CodingComment.fromListXMLString(fldEl, factory, obj.getCodingComment(), domMap));
		}
		fldEl = el.element("histologyStatus");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setHistologyStatus(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("service");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setService(ims.core.clinical.domain.objects.Service.getServicefromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("patientStatus");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setPatientStatus(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "codingComment"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String Consultant = "consultant";
		public static final String TransferDateTime = "transferDateTime";
		public static final String EndDateTime = "endDateTime";
		public static final String Specialty = "specialty";
		public static final String CodingStatus = "codingStatus";
		public static final String CodingComment = "codingComment";
		public static final String HistologyStatus = "histologyStatus";
		public static final String Service = "service";
		public static final String PatientStatus = "patientStatus";
	}
}

