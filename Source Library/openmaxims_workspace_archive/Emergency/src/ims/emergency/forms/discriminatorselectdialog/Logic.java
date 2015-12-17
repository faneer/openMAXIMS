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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.discriminatorselectdialog;

import java.util.Comparator;

import ims.emergency.forms.discriminatorselectdialog.GenForm.grdDiscriminatorSelectRow;
import ims.emergency.forms.discriminatorselectdialog.GenForm.grdDiscriminatorSelectRowCollection;
import ims.emergency.forms.discriminatorselectdialog.GenForm.grdSelectedDiscriminatorsRow;
import ims.emergency.forms.discriminatorselectdialog.GenForm.grdSelectedDiscriminatorsRowCollection;
import ims.emergency.vo.DiscriminatorConfigVo;
import ims.emergency.vo.DiscriminatorConfigVoCollection;
import ims.emergency.vo.ProtocolDiscriminatorVo;
import ims.emergency.vo.ProtocolDiscriminatorVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	private void open()
	{
		form.txtSearch().setFocus();
		clearInstanceControls();
		form.setMode(FormMode.EDIT);
		updateControlsState();
	}

	private void clearInstanceControls()
	{
		form.txtSearch().setValue(null);
		form.grdDiscriminatorSelect().getRows().clear();
		form.grdSelectedDiscriminators().getRows().clear();
		form.cmbDefaultPriority().setValue(null);
		form.getGlobalContext().Emergency.setManchesterTriageProtocol(null);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		setGlobalContextValues();
	}

	private void setGlobalContextValues()
	{
		grdSelectedDiscriminatorsRowCollection colDiscriminators = form.grdSelectedDiscriminators().getRows();
		ProtocolDiscriminatorVoCollection discriminatorsList = new ProtocolDiscriminatorVoCollection();

		for (int i = 0; i < colDiscriminators.size(); i++)
		{
			if (colDiscriminators.get(i).getcolSelected() == true)
			{
				ProtocolDiscriminatorVo protocolDiscriminator = new ProtocolDiscriminatorVo();
				protocolDiscriminator.setDiscriminator(colDiscriminators.get(i).getValue());
				protocolDiscriminator.setPriority(form.cmbDefaultPriority().getValue());
				discriminatorsList.add(protocolDiscriminator);
			}
		}

		String[] errors = discriminatorsList.validate();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}

		form.getGlobalContext().Emergency.setManchesterTriageProtocol(discriminatorsList);
		engine.close(DialogResult.OK);

	}

	@Override
	protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		doSearch();
	}

	private void doSearch()
	{
		populateDiscriminatorGrid(domain.listDiscriminators(form.txtSearch().getValue()));
		updateControlsState();
	}

	private void populateDiscriminatorGrid(DiscriminatorConfigVoCollection discriminators)
	{
		form.grdDiscriminatorSelect().getRows().clear();
		if (discriminators == null)
		{
			engine.showMessage("No Discriminators found for the search criteria.");
			return;
		}

		discriminators.sort(new StringComparator(SortOrder.ASCENDING));

		for (int i = 0; i < discriminators.size(); i++)
		{
			grdDiscriminatorSelectRow rowDiscriminator = form.grdDiscriminatorSelect().getRows().newRow();
			rowDiscriminator.setcolDiscriminatorName(discriminators.get(i).getDiscriminatorName());
			rowDiscriminator.setValue(discriminators.get(i));
		}
	}

	private void updateControlsState()
	{
		if (form.grdDiscriminatorSelect().getRows().size() > 0)
		{
			form.btnSelectAll().setEnabled(true);
		}
		else
		{
			form.btnSelectAll().setEnabled(false);
		}
		if (itemsSelected())
		{
			form.btnAddToList().setEnabled(true);
			form.btnDeselectAll().setEnabled(true);
		}
		else
		{
			form.btnAddToList().setEnabled(false);
			form.btnDeselectAll().setEnabled(false);
		}

	}

	private boolean itemsSelected()
	{
		grdDiscriminatorSelectRowCollection rows = form.grdDiscriminatorSelect().getRows();

		for (int i = 0; i < rows.size(); i++)
		{
			if (rows.get(i).getcolSelect() == true)
				return true;
		}

		return false;
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{}

	@Override
	protected void onBtnAddToListClick() throws PresentationLogicException
	{
		grdDiscriminatorSelectRowCollection rows = form.grdDiscriminatorSelect().getRows();
		DiscriminatorConfigVo firstPriority = null;

//		for (int i = rows.size() - 1; i >= 0; i--)
		for (int i = 0 ; i < rows.size() ; i++)
		{
			grdDiscriminatorSelectRow discriminator = rows.get(i);

			if (form.grdSelectedDiscriminators().getRows().size() >= 1)
			{
				if (form.grdSelectedDiscriminators().getRows().get(0) != null)
				{
					firstPriority = form.grdSelectedDiscriminators().getRows().get(0).getValue();
				}
			}

			if (discriminator.getcolSelect() == true)
			{
				if (!isAlreadyAdded(discriminator))
				{
					grdSelectedDiscriminatorsRow rowDiscriminator = form.grdSelectedDiscriminators().getRows().newRow();
					rowDiscriminator.setcolSelectedDiscriminatorName(discriminator.getcolDiscriminatorName());
					rowDiscriminator.setcolSelected(true);
					rowDiscriminator.setValue(discriminator.getValue());

					if (firstPriority != null && firstPriority.getDefaultTriagePriority() != null && !firstPriority.getDefaultTriagePriority().equals(discriminator.getValue().getDefaultTriagePriority()))
					{
						form.cmbDefaultPriority().setValue(null);
					}
					else if (form.grdSelectedDiscriminators().getRows().size() == 1)
					{
						form.cmbDefaultPriority().setValue(discriminator.getValue().getDefaultTriagePriority());
					}

					form.grdDiscriminatorSelect().getRows().remove(i);
					i--;
				}
				else
				{
					form.grdDiscriminatorSelect().getRows().remove(i);
					i--;
				}
			}
		}
		updateControlsState();
	}

	private boolean isAlreadyAdded(grdDiscriminatorSelectRow discriminator)
	{
		grdSelectedDiscriminatorsRowCollection rows = form.grdSelectedDiscriminators().getRows();

		for (int i = 0; i < rows.size(); i++)
		{
			if (rows.get(i).getValue().equals(discriminator.getValue()))
			{
				rows.get(i).setcolSelected(true);
				return true;
			}
		}
		return false;
	}

	@Override
	protected void onBtnDeselectAllClick() throws PresentationLogicException
	{
		grdDiscriminatorSelectRowCollection rows = form.grdDiscriminatorSelect().getRows();

		for (int i = 0; i < rows.size(); i++)
		{
			rows.get(i).setcolSelect(false);
		}

		updateControlsState();
	}

	@Override
	protected void onBtnSelectAllClick() throws PresentationLogicException
	{
		grdDiscriminatorSelectRowCollection rows = form.grdDiscriminatorSelect().getRows();

		for (int i = 0; i < rows.size(); i++)
		{
			rows.get(i).setcolSelect(true);
		}

		updateControlsState();
	}

	@Override
	protected void onGrdDiscriminatorSelectGridCheckBoxClicked(int column, grdDiscriminatorSelectRow row, boolean isChecked) throws PresentationLogicException
	{
		updateControlsState();
	}

	public class StringComparator implements Comparator
	{
		private int direction = 1;

		public StringComparator()
		{
			this(SortOrder.ASCENDING);
		}

		public StringComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;

		}

		public int compare(Object ob1, Object ob2)
		{
			String name1 = null;
			String name2 = null;
			
			if (ob1 instanceof DiscriminatorConfigVo)
			{
				DiscriminatorConfigVo ps1 = (DiscriminatorConfigVo) ob1;
				name1 = ps1 != null ? ps1.getDiscriminatorName() : null;
			}
			
			if (ob2 instanceof DiscriminatorConfigVo)
			{
				DiscriminatorConfigVo ps2 = (DiscriminatorConfigVo) ob2;
				name2 = ps2 != null ? ps2.getDiscriminatorName() : null;
			}
			
			if (name1 != null)
				return name1.compareTo(name2) * direction;
			
			if (name2 != null)
				return (-1) * direction;

			return 0;
		}

	}
}
