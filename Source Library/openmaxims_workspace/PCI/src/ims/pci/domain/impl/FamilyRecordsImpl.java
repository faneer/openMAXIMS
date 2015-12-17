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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.62 build 3082.19902)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.domain.impl;

import java.util.List;

import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CommChannelVo;
import ims.core.vo.CommChannelVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.PersonAddress;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.ChannelType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.pci.domain.ClientDemographics;
import ims.pci.domain.base.impl.BaseFamilyRecordsImpl;
import ims.pci.vo.ClientAddressVo;
import ims.pci.vo.ClientVo;
import ims.pci.vo.CommunityCareVo;
import ims.pci.vo.PciAddressHistoryVo;
import ims.pci.vo.PciAddressHistoryVoCollection;

public class FamilyRecordsImpl extends BaseFamilyRecordsImpl
{
	private static final long serialVersionUID = 1L;

	public PatientShortCollection listChilds(PatientRefVo parentId)
	{
		if(parentId == null || (parentId != null && !parentId.getID_PatientIsNotNull()))
			throw new CodingRuntimeException("Cannot search on null parent!");
		
		DomainFactory factory = getDomainFactory();
		
		List clients = null;
		
		StringBuffer hql = new StringBuffer(" from Patient p " +
				" where p.clientParent.id = :parentId ");
		
		clients = factory.find(hql.toString(), new String[]{"parentId"}, new Object[]{parentId.getID_Patient()});
		
		PatientShortCollection listChilds = PatientShortAssembler.createPatientShortCollectionFromPatient(clients);
		
		return listChilds;
	}

	public void updateChild(PatientShort child, PatientShort parent) throws StaleObjectException, UniqueKeyViolationException 
	{
		ClientDemographics impl = (ClientDemographics) getDomainImpl(ClientDemographicsImpl.class);
		
		ClientVo childClient = getClientFull(child);
		childClient.setClientParent(parent);
		childClient.setIsChild(parent != null ? true : null);
		
		childClient.validate();
		
		childClient = impl.saveClient(childClient);
	}

	public ClientVo getClientFull(PatientShort client) throws StaleObjectException 
	{
		if(client == null)
			throw new DomainRuntimeException("Client not provided for get call.");
		
		ClientDemographics impl = (ClientDemographics) getDomainImpl(ClientDemographicsImpl.class);
		
		return impl.getClientFull(client);
	}

	public PatientShort getParent(PatientShort child) throws StaleObjectException 
	{
		if(child == null)
			throw new DomainRuntimeException("Client not provided for get call.");
		
		ClientVo childClient = getClientFull(child);

		if(childClient.getClientParentIsNotNull() && childClient.getClientParent().getID_PatientIsNotNull())
		{
			DomainFactory factory = getDomainFactory();
			ims.core.patient.domain.objects.Patient clientDO = (ims.core.patient.domain.objects.Patient) factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, childClient.getClientParent().getID_Patient().intValue());
			if (clientDO == null)
				return null;
			
			return PatientShortAssembler.create(clientDO);
		}
		return null;
	}

	private Boolean updateClientAddress(ClientVo client, ClientAddressVo clientAddresses, CommChannelVoCollection commChannel) 
	{
		Boolean isAddressChanged = false;
		
		if(client == null || clientAddresses == null || (clientAddresses != null && !clientAddresses.getPersonAddressIsNotNull()))
			return false;
		
		PersonAddress familyAddress = clientAddresses.getPersonAddress();
		familyAddress.setUpdateDate(new DateTime());
		familyAddress.setNotificationDate(new Date());
		
		client.setAddress(familyAddress);
		
		if(clientAddresses.getCommunityCare() != null 
				&& clientAddresses.getCommunityCare().getAddressHistoryIsNotNull() 
					&& clientAddresses.getCommunityCare().getAddressHistory().get(0) != null)
		{
			PciAddressHistoryVo newAddress = clientAddresses.getCommunityCare().getAddressHistory().get(0);
			
			PciAddressHistoryVoCollection clientAddressHistory = client.getCommunityCare().getAddressHistory();
			if(clientAddressHistory.get(0) != null && hasAddressChanged(newAddress, clientAddressHistory.get(0)))
			{
				newAddress.setUpdateDate(new DateTime());
				newAddress.setNotificationDate(new Date());
				clientAddressHistory.add(0, newAddress);
				isAddressChanged =  true;
			}
			
			CommunityCareVo newClientCommunityCare = clientAddresses.getCommunityCare();
			newClientCommunityCare.setAddressHistory(clientAddressHistory);
			
			populateCommunityCare(client.getCommunityCare(), newClientCommunityCare);
		}
		
		
		Boolean isCommChannelChanged = populateCommChannels(client, commChannel);
		
		if(!isAddressChanged)
			isAddressChanged = isCommChannelChanged;
		
		return isAddressChanged;
	}

	private Boolean populateCommChannels(ClientVo client, CommChannelVoCollection commChannel) 
	{
		if(client == null || commChannel == null)
			return false;
		
		if(!client.getCommChannelsIsNotNull())
		{
			client.setCommChannels(commChannel);
			return true;
		}
		
		Boolean isChanged = false;
		
		for(int i=0; i<commChannel.size(); i++)
		{
			Boolean isChangedTemp = populateClientWithCommChannel(client,commChannel.get(i));
			
			if(!isChanged)
				isChanged = isChangedTemp;
		}
		
		return isChanged;
	}

	private Boolean populateClientWithCommChannel(ClientVo client,	CommChannelVo commChannelVo) 
	{
		if(client == null || commChannelVo == null)
			return false;
		
		if(commChannelVo.getChannelType().equals(ChannelType.HOME_PHONE))
		{
			if(client.getAddress() != null)
			{
				client.getAddress().setPhone(commChannelVo.getCommValue());
			}
		}
		
		if(client.getCommChannelsIsNotNull())
		{
			Boolean changes = false;
			Boolean channelFound = false;
			
			for(int i=0; i<client.getCommChannels().size(); i++)
			{
				if(client.getCommChannels().get(i).getChannelType().equals(commChannelVo.getChannelType()))
				{
					channelFound = true;
					
					if(!client.getCommChannels().get(i).getCommValue().equals(commChannelVo.getCommValue()))
					{
						client.getCommChannels().get(i).setCommValue(commChannelVo.getCommValue());
						changes = true;
						break;
					}
				}
			}
			
			if(!channelFound)
			{
				client.getCommChannels().add(commChannelVo);
				changes = true;
			}
			return changes;
		}
		return false;
	}

	private CommunityCareVo populateCommunityCare(CommunityCareVo clientCommunityCare, CommunityCareVo communityCareWithNewAddress) 
	{
		if(clientCommunityCare == null)
			clientCommunityCare = new CommunityCareVo();
		
		clientCommunityCare.setLho(communityCareWithNewAddress.getLho());
		clientCommunityCare.setCca(communityCareWithNewAddress.getCca());
		clientCommunityCare.setSector(communityCareWithNewAddress.getSector());
		clientCommunityCare.setPhnDistrict(communityCareWithNewAddress.getPhnDistrict());
		clientCommunityCare.setDED(communityCareWithNewAddress.getDED());
		clientCommunityCare.setAddressHistory(communityCareWithNewAddress.getAddressHistory());
		
		return clientCommunityCare;
	}
	
	private Boolean hasAddressChanged(PciAddressHistoryVo newAddress, PciAddressHistoryVo historyAddress)
	{
		if ((newAddress.getLine1() != null && historyAddress.getLine1() != null) && !newAddress.getLine1().equals(historyAddress.getLine1())) return true;
		if ((newAddress.getLine1() != null && historyAddress.getLine1() == null) || (newAddress.getLine1() == null && historyAddress.getLine1() != null)) return true;

		if ((newAddress.getLine2() != null && historyAddress.getLine2() != null) && !newAddress.getLine2().equals(historyAddress.getLine2())) return true;
		if ((newAddress.getLine2() != null && historyAddress.getLine2() == null) || (newAddress.getLine2() == null && historyAddress.getLine2() != null)) return true;

		if ((newAddress.getLine3() != null && historyAddress.getLine3() != null) && !newAddress.getLine3().equals(historyAddress.getLine3())) return true;
		if ((newAddress.getLine3() != null && historyAddress.getLine3() == null) || (newAddress.getLine3() == null && historyAddress.getLine3() != null)) return true;

		if ((newAddress.getLine4() != null && historyAddress.getLine4() != null) && !newAddress.getLine4().equals(historyAddress.getLine4())) return true;
		if ((newAddress.getLine4() != null && historyAddress.getLine4() == null) || (newAddress.getLine4() == null && historyAddress.getLine4() != null)) return true;

		if ((newAddress.getLine5() != null && historyAddress.getLine5() != null) && !newAddress.getLine5().equals(historyAddress.getLine5())) return true;
		if ((newAddress.getLine5() != null && historyAddress.getLine5() == null) || (newAddress.getLine5() == null && historyAddress.getLine5() != null)) return true;

		if ((newAddress.getPostCode() != null && historyAddress.getPostCode() != null) && !newAddress.getPostCode().equals(historyAddress.getPostCode())) return true;
		if ((newAddress.getPostCode() != null && historyAddress.getPostCode() == null) || (newAddress.getPostCode() == null && historyAddress.getPostCode() != null)) return true;

		if ((newAddress.getCounty() != null && historyAddress.getCounty() != null) && !newAddress.getCounty().equals(historyAddress.getCounty())) return true;
		if ((newAddress.getCounty() != null && historyAddress.getCounty() == null) || (newAddress.getCounty()== null && historyAddress.getCounty() != null)) return true;
		
		//community care
		if ((newAddress.getLho() != null && historyAddress.getLho() != null) && !newAddress.getLho().equals(historyAddress.getLho())) return true;
		if ((newAddress.getLho() != null && historyAddress.getLho() == null) || (newAddress.getLho()== null && historyAddress.getLho() != null)) return true;
		
		if ((newAddress.getCca() != null && historyAddress.getCca() != null) && !newAddress.getCca().equals(historyAddress.getCca())) return true;
		if ((newAddress.getCca() != null && historyAddress.getCca() == null) || (newAddress.getCca()== null && historyAddress.getCca() != null)) return true;
		
		if ((newAddress.getSector() != null && historyAddress.getSector() != null) && !newAddress.getSector().equals(historyAddress.getSector())) return true;
		if ((newAddress.getSector() != null && historyAddress.getSector() == null) || (newAddress.getSector()== null && historyAddress.getSector() != null)) return true;
		
		if ((newAddress.getPhnDistrict() != null && historyAddress.getPhnDistrict() != null) && !newAddress.getPhnDistrict().equals(historyAddress.getPhnDistrict())) return true;
		if ((newAddress.getPhnDistrict() != null && historyAddress.getPhnDistrict() == null) || (newAddress.getPhnDistrict()== null && historyAddress.getPhnDistrict() != null)) return true;
		
		if ((newAddress.getDED() != null && historyAddress.getDED() != null) && !newAddress.getDED().equals(historyAddress.getDED())) return true;
		if ((newAddress.getDED() != null && historyAddress.getDED() == null) || (newAddress.getDED()== null && historyAddress.getDED() != null)) return true;

		return false;
	}
	
	public PatientShort getPatientShort(PatientRefVo patientRef) 
	{
		if(patientRef == null || (patientRef != null && !patientRef.getID_PatientIsNotNull()))
			throw new DomainRuntimeException("Patient not provided for get call.");
		
		DomainFactory factory = getDomainFactory();
		ims.core.patient.domain.objects.Patient clientDO = (ims.core.patient.domain.objects.Patient) factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, patientRef.getID_Patient().intValue());
		if (clientDO == null)
			return null;
		
		return PatientShortAssembler.create(clientDO);
	}

	public Boolean verifyFamilyTree(PatientShort parent, PatientShort newChild) 
	{
		if(parent == null || (parent != null && !parent.getID_PatientIsNotNull()) || newChild == null || (!newChild.getID_PatientIsNotNull()))
			throw new DomainRuntimeException("Parent or Child not provided for get call.");
		
		if(parent.equals(newChild))
			return false;
		
		PatientShort parentOfParent = null;
		
		try 
		{
			parentOfParent = getParent(parent);
		} 
		catch (StaleObjectException e) 
		{
			//e.printStackTrace();
		}
		
		if(parentOfParent != null)
			return verifyFamilyTree(parentOfParent, newChild);
		
		return true;
	}

	public Integer saveClient(PatientShort client, ClientAddressVo newAddress,	PatientShort parent, CommChannelVoCollection commChannel) throws StaleObjectException, UniqueKeyViolationException 
	{
		if(client == null || newAddress == null || (newAddress !=null && !newAddress.getPersonAddressIsNotNull()))
			throw new DomainRuntimeException("Cannot save client.");
	
		ClientDemographics impl = (ClientDemographics) getDomainImpl(ClientDemographicsImpl.class);
		
		ClientVo clientFull = impl.getClientFull(client);
		Boolean isAddressUpdated = updateClientAddress(clientFull, newAddress, commChannel);
		if(parent != null)
		{
			clientFull.setClientParent(parent);
		}
		clientFull.validate();
		
		clientFull = impl.saveClient(clientFull);
		
		if(isAddressUpdated)
			return 1;
		
		return 0;
	}

	public Boolean isParent(PatientRefVo parent) 
	{
		if(parent == null || (parent != null && !parent.getID_PatientIsNotNull()))
			throw new CodingRuntimeException("Cannot count number of childs on null parent!");
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "select count(p.id) from Patient p where p.clientParent.id = :parentId ";
		
		long noOfChilds = factory.countWithHQL(hql.toString(), new String[]{"parentId"}, new Object[]{parent.getID_Patient()});
		
		return noOfChilds > 0 ? true : false;
	}
}
