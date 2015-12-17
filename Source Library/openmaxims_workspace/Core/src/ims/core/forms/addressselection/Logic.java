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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.65 build 3173.28387)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.addressselection;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.PersonAddress;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IAddress;
import ims.framework.interfaces.IAddressProvider;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	static IAddressProvider l_addressprovider;
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setpersonAddress(form.getGlobalContext().Core.getPersonAddress());
		displayRelevantFields(); //WDEV-17700 fields are now visible depending on DEMOGRAPHICS_TYPE flag
		displayAddress();
		
		//Do automatic search
		if (ConfigFlag.UI.CAPSCAN_ENABLED.getValue())
		{
			if (form.getGlobalContext().Core.getAddressSearchTypeIsNotNull() && form.getGlobalContext().Core.getAddressSearchType().equals("PCLOOKUP"))
			{
				//For this type of search, the only filed needed is the postcode
				form.getLocalContext().getpersonAddress().setAddressBuildingName("");
				form.getLocalContext().getpersonAddress().setAddressBuildingNumber("");
				form.getLocalContext().getpersonAddress().setAddressCounty("");
				form.getLocalContext().getpersonAddress().setAddressLocality("");
				form.getLocalContext().getpersonAddress().setAddressPostTown("");
				form.getLocalContext().getpersonAddress().setAddressStreet("");
			} else if (form.getGlobalContext().Core.getAddressSearchTypeIsNotNull() && form.getLocalContext().getpersonAddressIsNotNull())
			{
				searchAddress(form.getGlobalContext().Core.getAddressSearchType(),"","");
			}			
			else //default
				searchAddress("SEARCH","","");			
		}
		
		form.btnSelect().setEnabled(false);
	}
	
	private void displayRelevantFields() //WDEV-17700
	{
		boolean irishDemographicsEnabled = ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH");
		
		form.txtAddress5().setVisible(!irishDemographicsEnabled && !ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue());
		form.txtAddress5().setEnabled(Boolean.FALSE);
		form.cmbAreaOfResidence().setVisible(irishDemographicsEnabled);
		form.lblAreaOfResidence().setVisible(irishDemographicsEnabled);
		form.cmbAreaOfResidence().setEnabled(Boolean.FALSE);
		form.cmbCounty().setVisible(irishDemographicsEnabled);
		form.lblCounty().setVisible(irishDemographicsEnabled);
		form.cmbCounty().setEnabled(Boolean.FALSE);
		form.lblCCGCode().setVisible(!irishDemographicsEnabled);
		form.txtPctCode().setVisible(!irishDemographicsEnabled);
		form.txtPctCode().setEnabled(Boolean.FALSE);
	}

	private void searchAddress(String searchTypeText,String listItem,String searchStatus) 
	{
		boolean lbBuildingNameDisplayed = false;
		boolean lbBuildingNumberDisplayed = false;
		boolean lbPostTownDisplayed = false;
		boolean lbAddressStreetDisplayed = false;

		if (l_addressprovider == null)
			l_addressprovider = engine.getAddressProvider();
	
		PersonAddress[] personAddress = null;
		
		if (form.getLocalContext().getpersonAddressIsNotNull())
		{
			try
			{				
				//pass the generic search text through IAddress for first search
				if ((searchStatus == null) || searchStatus.equals(""))
					form.getLocalContext().getpersonAddress().setAddressSearchText(form.getGlobalContext().Core.getAddressSearchText());
				
				personAddress = (PersonAddress[]) l_addressprovider.getAddress(form.getLocalContext().getpersonAddress(),searchTypeText,listItem,form.getLocalContext().getpersonAddress().getAddressSearchText()); // return result or ambiglist
			}
			catch (PresentationLogicException pe)
			{
				engine.showMessage(pe.getMessage());
			}
			
			//fill out rest of address fields if somthing found
			if (personAddress != null && personAddress.length == 1)
			{
				//fill out rest of address fields if somthing found
				if (personAddress != null && personAddress.length == 1)
				{
				
					if ((form.getLocalContext().getpersonAddress().getAddressBuildingName() !=  null && !form.getLocalContext().getpersonAddress().getAddressBuildingName().equals("")))
					{
						//address with building name
						if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
						{
							//WDEV-9025
							//WDEV-15963
							if (form.getLocalContext().getpersonAddress().getOrganisationIsNotNull() && !form.getLocalContext().getpersonAddress().getOrganisation().equals(""))
							{
								if (form.getLocalContext().getpersonAddress().getOrganisation().length() 
										+ form.getLocalContext().getpersonAddress().getAddressBuildingName().length() 
										<= ConfigFlag.DOM.HEARTS_ADDRESS_LINE_MAXLEN.getValue())
								{
									lbBuildingNameDisplayed = true;
									form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getOrganisation() + "," + form.getLocalContext().getpersonAddress().getAddressBuildingName());																
								}
								else
								{
									//special case for where there is a sub building
									form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getOrganisation().substring(0, form.getLocalContext().getpersonAddress().getOrganisation().length()<=30?form.getLocalContext().getpersonAddress().getOrganisation().length():30));																
								}
							}
							else
							{
								form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName());
								lbBuildingNameDisplayed = true;
							}						
		
							if (lbBuildingNameDisplayed)
							{
								form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingNumber());
								lbBuildingNumberDisplayed = true;
							}
							else
							{
								if ((form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressBuildingNumber()).length() 
										<= ConfigFlag.DOM.HEARTS_ADDRESS_LINE_MAXLEN.getValue())
								{
									form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressBuildingNumber());
									lbBuildingNumberDisplayed = true;
								}
								else
								{
									form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName());								
								}							
							}						

							String address3 = "";
							if (lbBuildingNumberDisplayed)
							{
								address3 += form.getLocalContext().getpersonAddress().getAddressLocality() != null ? form.getLocalContext().getpersonAddress().getAddressLocality() : "";
								address3 += form.getLocalContext().getpersonAddress().getAddressPostTown() != null ? (address3.length() > 0 ? "," : "") + form.getLocalContext().getpersonAddress().getAddressPostTown() : "";
								lbPostTownDisplayed = true;
							}
							else
							{
								address3 += form.getLocalContext().getpersonAddress().getAddressBuildingNumber() + ",";
								address3 += form.getLocalContext().getpersonAddress().getAddressLocality() != null ? form.getLocalContext().getpersonAddress().getAddressLocality() : "";
								
								if ((address3 + form.getLocalContext().getpersonAddress().getAddressPostTown()).length() 
										<= ConfigFlag.DOM.HEARTS_ADDRESS_LINE_MAXLEN.getValue())
								{
									address3 += form.getLocalContext().getpersonAddress().getAddressPostTown() != null ? (address3.length() > 0 ? "," : "") + form.getLocalContext().getpersonAddress().getAddressPostTown() : "";
									lbPostTownDisplayed = true;
								}							
							}						
							form.txtAddress3().setValue(address3);// 	WDEV-17432
							
							if (lbPostTownDisplayed)
								form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressCounty()!=null?form.getLocalContext().getpersonAddress().getAddressCounty():null);
							else
								form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown() != null ? form.getLocalContext().getpersonAddress().getAddressPostTown(): null 
										+ form.getLocalContext().getpersonAddress().getAddressCounty()!= null? form.getLocalContext().getpersonAddress().getAddressCounty():null);
							
							form.txtAddress5().setValue("");
							//WDEV-15963						
						}
						else
						{
							//WDEV-15963						
							if (form.getLocalContext().getpersonAddress().getOrganisationIsNotNull() && !form.getLocalContext().getpersonAddress().getOrganisation().equals(""))
							{
								if (form.getLocalContext().getpersonAddress().getOrganisation().length() + form.getLocalContext().getpersonAddress().getAddressBuildingName().length() 
										<= ConfigFlag.DOM.HEARTS_ADDRESS_LINE_MAXLEN.getValue())
								{
									lbBuildingNameDisplayed = true;
									form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getOrganisation() + "," + form.getLocalContext().getpersonAddress().getAddressBuildingName());								
								}
								else
								{
									form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getOrganisation().substring(0, form.getLocalContext().getpersonAddress().getOrganisation().length()<=30?form.getLocalContext().getpersonAddress().getOrganisation().length():30));																
								}
							}
							else
							{
								form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName());
								lbBuildingNameDisplayed = true;
							}
							
							if (form.getLocalContext().getpersonAddress().getAddressStreet() != null && !form.getLocalContext().getpersonAddress().getAddressStreet().equals(""))
							{
								if (form.getLocalContext().getpersonAddress().getAddressLocality() != null && !form.getLocalContext().getpersonAddress().getAddressLocality().equals(""))
								{
									//WDEV-15963
									if (lbBuildingNameDisplayed)
									{
										form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressStreet());
										lbBuildingNumberDisplayed = true; // at this point there will be no building number
									}
									else
									{
										//form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressStreet());
										if ((form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressStreet()).length() 
												<= ConfigFlag.DOM.HEARTS_ADDRESS_LINE_MAXLEN.getValue())
										{
											form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressBuildingNumber());
											lbBuildingNameDisplayed = true;
											lbBuildingNumberDisplayed = true;
										}
										else
										{
											form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName());										
										}							
									}									
									//WDEV-15963
									
									if (!lbBuildingNumberDisplayed)
									{
										form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingNumber() + "," +
												form.getLocalContext().getpersonAddress().getAddressLocality());
									}
									else
										form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressLocality());
									
									form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
									form.txtAddress5().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());	
								}
								else
								{
									//WDEV-15963
									if (lbBuildingNameDisplayed)
									{
										form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressStreet());
										lbBuildingNumberDisplayed = true;
									}
									else
									{
										//form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressStreet());
										if ((form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressStreet()).length() 
												<= ConfigFlag.DOM.HEARTS_ADDRESS_LINE_MAXLEN.getValue())
										{
											form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName() + "," + form.getLocalContext().getpersonAddress().getAddressBuildingNumber());
											lbBuildingNameDisplayed = true;
											lbBuildingNumberDisplayed = true;
										}
										else
										{
											form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName());										
										}																
									}
									//WDEV-15963
									
									if (!lbBuildingNumberDisplayed)
									{	
										form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingNumber() + "," +
												form.getLocalContext().getpersonAddress().getAddressPostTown());									
									}
									else
										form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
									
									if (form.getLocalContext().getpersonAddress().getAddressCounty() != null 
											&& !form.getLocalContext().getpersonAddress().getAddressCounty().equals(form.getLocalContext().getpersonAddress().getAddressPostTown()))// 	WDEV-17810
										form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());
									else
										form.txtAddress4().setValue("");
									form.txtAddress5().setValue("");
								}
								if (form.getLocalContext().getpersonAddress().getCounty() != null)
									form.cmbCounty().setValue(form.getLocalContext().getpersonAddress().getCounty());
								if (form.getLocalContext().getpersonAddress().getAreaOfResidence() != null)
									form.cmbAreaOfResidence().setValue(form.getLocalContext().getpersonAddress().getAreaOfResidence());
							}						
							else
							{
								if (form.getLocalContext().getpersonAddress().getAddressLocality() != null && !form.getLocalContext().getpersonAddress().getAddressLocality().equals(""))
								{
									//WDEV-15963
									if (lbBuildingNameDisplayed)
										form.txtAddress2().setValue("");//WDEV-15211
									else
										form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressBuildingName());
									//WDEV-15963
																	
									form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressLocality());
									form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
									form.txtAddress5().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());					
								}
								else
								{
									form.txtAddress2().setValue("");//WDEV-15211
									form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
									form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());
									form.txtAddress5().setValue("");
								}					
							}
						}
					}
					else
					{					
						//WDEV-15963
						if (form.getLocalContext().getpersonAddress().getOrganisationIsNotNull() 
								&& !form.getLocalContext().getpersonAddress().getOrganisation().equals(""))
						{
							if ((form.getLocalContext().getpersonAddress().getOrganisation() + "," + form.getLocalContext().getpersonAddress().getAddressStreet()).length()
									<= ConfigFlag.DOM.HEARTS_ADDRESS_LINE_MAXLEN.getValue())
							{
								form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getOrganisation() + "," 
									+ form.getLocalContext().getpersonAddress().getAddressStreet());
								lbAddressStreetDisplayed = true;
							}
							else
							{
								form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getOrganisation().substring(0, form.getLocalContext().getpersonAddress().getOrganisation().length()<=30?form.getLocalContext().getpersonAddress().getOrganisation().length():30));
							}						
						}
						else
						{						
							form.txtAddress1().setValue(form.getLocalContext().getpersonAddress().getAddressStreet());
							lbAddressStreetDisplayed = true;
						}
						
						
						if (form.getLocalContext().getpersonAddress().getAddressLocality() != null && !form.getLocalContext().getpersonAddress().getAddressLocality().equals(""))
						{
							if (!lbAddressStreetDisplayed)
							{
								form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressStreet() + "," 
										+ form.getLocalContext().getpersonAddress().getAddressLocality());
							}
							else
								form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressLocality());
							
							form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
							
							if (form.getLocalContext().getpersonAddress().getAddressCounty() != null && !form.getLocalContext().getpersonAddress().getAddressCounty().equals(form.getLocalContext().getpersonAddress().getAddressPostTown()))
								form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());
							else
								form.txtAddress4().setValue("");
							
							form.txtAddress5().setValue("");
						}
						else
						{
							form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
							form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());
							form.txtAddress4().setValue("");
							form.txtAddress5().setValue("");
						}					
						
					}
		
					form.txtPost().setValue(form.getLocalContext().getpersonAddress().getAddressPostCode());
					form.txtPctCode().setValue(form.getLocalContext().getpersonAddress().getPCT());
						
					form.btnSelect().setEnabled(true);
				}
			}
			else
			{
				//display ambiguity list for selection
				displayAmbiguity(personAddress);
			}
		}		
	}
	
	private void displayAmbiguity(IAddress[] listAddressAmbiguity) 
	{
		
        int i;
        int len;
        
        if (listAddressAmbiguity == null || ((len = listAddressAmbiguity.length) == 0)) {
            return;
        }        
        
        for (i = 1; i < len; i++)
        {        	
        	TreeNode treenode = form.treAmbig().getNodes().add(i, listAddressAmbiguity[i].getAddressBuildingNumber()==null?"":listAddressAmbiguity[i].getAddressBuildingNumber().toString(),false);
        	treenode.setEnabled(true);
        }
        		
	}

	private void displayAddress() 
	{
		boolean lbBuildingNameDisplayed = false;
		
		if (form.getLocalContext().getpersonAddressIsNotNull())
		{
			PersonAddress personAddress = form.getLocalContext().getpersonAddress();
			if (personAddress.getAddressBuildingName() != "")
			{
				//address with building name
				//WDEV-15963
				if (personAddress.getOrganisationIsNotNull() && !personAddress.getOrganisation().equals(""))
					if ((personAddress.getOrganisation() + "," + personAddress.getAddressBuildingName()).length()
							<= ims.core.vo.PersonAddress.getLine1MaxLength())
					{
						form.txtAddress1().setValue(personAddress.getOrganisation() + "," + personAddress.getAddressBuildingName());
						lbBuildingNameDisplayed = true;
					}
					else
						form.txtAddress1().setValue(personAddress.getAddressBuildingName());
				else				
					form.txtAddress1().setValue(personAddress.getAddressBuildingName());
				
				if (personAddress.getAddressStreet() != null && !personAddress.getAddressStreet().equals(""))
				{
					if (personAddress.getAddressLocality() != null && !personAddress.getAddressLocality().equals(""))
					{
						if (!lbBuildingNameDisplayed && !personAddress.getAddressBuildingName().equals(""))
						{
							form.txtAddress2().setValue(personAddress.getAddressBuildingName() + "," + personAddress.getAddressStreet());
						}
						else
							form.txtAddress2().setValue(personAddress.getAddressStreet());
						
						form.txtAddress3().setValue(personAddress.getAddressLocality());
						form.txtAddress4().setValue(personAddress.getAddressPostTown());
						form.txtAddress5().setValue(personAddress.getAddressCounty());	
					}
					else
					{
						form.txtAddress2().setValue(personAddress.getAddressStreet());
						form.txtAddress3().setValue(personAddress.getAddressPostTown());
						form.txtAddress4().setValue(personAddress.getAddressCounty());
						form.txtAddress5().setValue("");
					}
				}
				else
				{
					if (personAddress.getAddressLocality() != null && !personAddress.getAddressLocality().equals(""))
					{
						form.txtAddress3().setValue(personAddress.getAddressLocality());
						form.txtAddress4().setValue(personAddress.getAddressPostTown());
						form.txtAddress5().setValue(personAddress.getAddressCounty());					
					}
					else
					{
						form.txtAddress3().setValue(personAddress.getAddressPostTown());
						form.txtAddress4().setValue(personAddress.getAddressCounty());
						form.txtAddress5().setValue("");
					}					
				}
			}
			else
			{
				//WDEV-15963
				if (personAddress.getOrganisationIsNotNull() && !personAddress.getOrganisation().equals(""))
					form.txtAddress1().setValue(personAddress.getOrganisation() + "," + personAddress.getAddressStreet());
				else				
					form.txtAddress1().setValue(personAddress.getAddressStreet());
				
				
				if (form.getLocalContext().getpersonAddress().getAddressLocality() != null && !form.getLocalContext().getpersonAddress().getAddressLocality().equals(""))
				{
					form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressLocality());
					form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
					form.txtAddress4().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());	
					form.txtAddress5().setValue("");
				}
				else
				{
					form.txtAddress2().setValue(form.getLocalContext().getpersonAddress().getAddressPostTown());
					form.txtAddress3().setValue(form.getLocalContext().getpersonAddress().getAddressCounty());
					form.txtAddress4().setValue("");
					form.txtAddress5().setValue("");
				}					
			}
			
			form.txtPost().setValue(personAddress.getAddressPostCode());
			form.txtPctCode().setValue(personAddress.getPCT());
		}
	}
	
	@Override
	protected void onTreAmbigTreeViewSelectionChanged(TreeNode node) throws PresentationLogicException 
	{
		
		if (l_addressprovider == null)
			l_addressprovider = engine.getAddressProvider();
		
		if (node != null && node.getValue() != null)
		{			
			int l_index = Integer.parseInt(node.getValue().toString());
			l_index--;
			
			//clear ambiguity list
			form.treAmbig().clearSelection();
			form.treAmbig().getNodes().clear();
			
			searchAddress("SELECT",Integer.toString(l_index),form.getLocalContext().getpersonAddressIsNotNull()?form.getLocalContext().getpersonAddress().getAddressSearchText():"");
		}
		else
			return;
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		engine.close(DialogResult.CANCEL);		
	}

	@Override
	protected void onBtnSelectClick() throws PresentationLogicException 
	{	
		form.getGlobalContext().Core.setPersonAddress(form.getLocalContext().getpersonAddress());
		engine.close(DialogResult.OK);
	}
}
