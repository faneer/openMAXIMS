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
package ims.nursing.assessment.domain.objects;

/**
 * 
 * @author Sinead McDermott
 * Generated.
 */


public class CleansingandDressingComponent extends ims.nursing.assessment.domain.objects.AssessmentComponent implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1015100017;
	private static final long serialVersionUID = 1015100017L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Hygiene Activities
	  * Collection of ims.nursing.assessment.domain.objects.PersonalHygieneActivities.
	  */
	private java.util.Set hygieneActivities;
	/** Dressing And Grooming
	  * Collection of ims.nursing.assessment.domain.objects.DressingandGroomingActivities.
	  */
	private java.util.Set dressingAndGrooming;
	/** Ususal bathing pattern */
	private ims.domain.lookups.LookupInstance bathingPattern;
	/** Frequency of bathing */
	private String frequency;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public CleansingandDressingComponent (Integer id, int ver)
    {
    	super(id, ver);
    }
    public CleansingandDressingComponent ()
    {
    	super();
    }
    public CleansingandDressingComponent (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.nursing.assessment.domain.objects.CleansingandDressingComponent.class;
	}


	public java.util.Set getHygieneActivities() {
		if ( null == hygieneActivities ) {
			hygieneActivities = new java.util.HashSet();
		}
		return hygieneActivities;
	}
	public void setHygieneActivities(java.util.Set paramValue) {
		this.hygieneActivities = paramValue;
	}

	public java.util.Set getDressingAndGrooming() {
		if ( null == dressingAndGrooming ) {
			dressingAndGrooming = new java.util.HashSet();
		}
		return dressingAndGrooming;
	}
	public void setDressingAndGrooming(java.util.Set paramValue) {
		this.dressingAndGrooming = paramValue;
	}

	public ims.domain.lookups.LookupInstance getBathingPattern() {
		return bathingPattern;
	}
	public void setBathingPattern(ims.domain.lookups.LookupInstance bathingPattern) {
		this.bathingPattern = bathingPattern;
	}

	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
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
		
		auditStr.append(super.toAuditString());
		auditStr.append("\r\n*hygieneActivities* :");
		if (hygieneActivities != null)
		{
			java.util.Iterator it1 = hygieneActivities.iterator();
			int i1=0;
			while (it1.hasNext())
			{
				if (i1 > 0)
					auditStr.append(",");
				ims.nursing.assessment.domain.objects.PersonalHygieneActivities obj = (ims.nursing.assessment.domain.objects.PersonalHygieneActivities)it1.next();
		if (obj != null)
		{
		   if (i1 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i1++;
		}
		if (i1 > 0)
			auditStr.append("] " + i1);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*dressingAndGrooming* :");
		if (dressingAndGrooming != null)
		{
			java.util.Iterator it2 = dressingAndGrooming.iterator();
			int i2=0;
			while (it2.hasNext())
			{
				if (i2 > 0)
					auditStr.append(",");
				ims.nursing.assessment.domain.objects.DressingandGroomingActivities obj = (ims.nursing.assessment.domain.objects.DressingandGroomingActivities)it2.next();
		if (obj != null)
		{
		   if (i2 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i2++;
		}
		if (i2 > 0)
			auditStr.append("] " + i2);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*bathingPattern* :");
		if (bathingPattern != null)
			auditStr.append(bathingPattern.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*frequency* :");
		auditStr.append(frequency);
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
		
		String keyClassName = "CleansingandDressingComponent";
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
		sb.append(super.fieldsToXMLString(domMap));
		if (this.getHygieneActivities() != null)
		{
			if (this.getHygieneActivities().size() > 0 )
			{
			sb.append("<hygieneActivities>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getHygieneActivities(), domMap));
			sb.append("</hygieneActivities>");		
			}
		}
		if (this.getDressingAndGrooming() != null)
		{
			if (this.getDressingAndGrooming().size() > 0 )
			{
			sb.append("<dressingAndGrooming>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getDressingAndGrooming(), domMap));
			sb.append("</dressingAndGrooming>");		
			}
		}
		if (this.getBathingPattern() != null)
		{
			sb.append("<bathingPattern>");
			sb.append(this.getBathingPattern().toXMLString()); 
			sb.append("</bathingPattern>");		
		}
		if (this.getFrequency() != null)
		{
			sb.append("<frequency>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getFrequency().toString()));
			sb.append("</frequency>");		
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
			CleansingandDressingComponent domainObject = getCleansingandDressingComponentfromXML(itemEl, factory, domMap);

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
			CleansingandDressingComponent domainObject = getCleansingandDressingComponentfromXML(itemEl, factory, domMap);

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
		
	public static CleansingandDressingComponent getCleansingandDressingComponentfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getCleansingandDressingComponentfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static CleansingandDressingComponent getCleansingandDressingComponentfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!CleansingandDressingComponent.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!CleansingandDressingComponent.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the CleansingandDressingComponent class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (CleansingandDressingComponent)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(CleansingandDressingComponent.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		CleansingandDressingComponent ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (CleansingandDressingComponent)factory.getImportedDomainObject(CleansingandDressingComponent.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new CleansingandDressingComponent();
		}
		String keyClassName = "CleansingandDressingComponent";
		Class clz = ret.getClass().getSuperclass();
		while (!clz.equals(ims.domain.DomainObject.class))
		{
			int dotIndex = clz.getName().lastIndexOf(".") + 1;
			keyClassName = clz.getName().substring(dotIndex); 
			clz = clz.getSuperclass();
		}

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (CleansingandDressingComponent)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, CleansingandDressingComponent obj, java.util.HashMap domMap) throws Exception
	{
		ims.nursing.assessment.domain.objects.AssessmentComponent.fillFieldsfromXML(el, factory, obj, domMap);
		org.dom4j.Element fldEl;
		fldEl = el.element("hygieneActivities");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setHygieneActivities(ims.nursing.assessment.domain.objects.PersonalHygieneActivities.fromSetXMLString(fldEl, factory, obj.getHygieneActivities(), domMap));
		}
		fldEl = el.element("dressingAndGrooming");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setDressingAndGrooming(ims.nursing.assessment.domain.objects.DressingandGroomingActivities.fromSetXMLString(fldEl, factory, obj.getDressingAndGrooming(), domMap));
		}
		fldEl = el.element("bathingPattern");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setBathingPattern(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("frequency");
		if(fldEl != null)
		{	
    		obj.setFrequency(new String(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "hygieneActivities"
		, "dressingAndGrooming"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String HygieneActivities = "hygieneActivities";
		public static final String DressingAndGrooming = "dressingAndGrooming";
		public static final String BathingPattern = "bathingPattern";
		public static final String Frequency = "frequency";
	}
}

