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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.22 build 50106.1515)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.vitalsignsventilationchart;

import ims.core.forms.vitalsignsventilationchart.GenForm.grdVentilationRow;
import ims.core.vo.FluidBalanceDetailsVo;
import ims.core.vo.FluidBalanceDetailsVoCollection;
import ims.core.vo.ShiftDetailsVoCollection;
import ims.core.vo.VSVentilationChartVo;
import ims.core.vo.VitalSignsVo;
import ims.core.vo.VitalSignsVoCollection;
import ims.core.vo.lookups.FluidBalanceType;
import ims.core.vo.lookups.YesNo;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final String VS="Vital Signs";
	private static final String TEMP="Temperature";
	private static final String BP="BP";
	private static final String PULSE="Pulse";
	private static final String VENT="Ventilation";
	private static final String SUCTION="Suction";
	private static final String PHYSIO="Physio";
	private static final String MODE="Mode";
	private static final String PRESSURE="Peak Pressure";
	private static final String PEEP="PEEP/CPAP";
	private static final String TIDAL="Tidal Volume";
	private static final String MINUTE="Minute Volume";
	private static final String RATE="Rate (Ventilator set to)";
	private static final String SPRATE="Spontaneous Rate";
	private static final String SPMV="Spontaneous MV";
	private static final String CUFF="Cuff";
	private static final String HUMID="Humidifier";
	private static final String SATS="Oxygen Sats / Fraction Rate";
	private static final String PROBE="Probe Change";
	private static final String POS_PAR="Position ";
	private static final String POSITION="Position";
	private static final String FLUID_IN="Fluid In";
	private static final String ORAL="Oral";
	private static final String FLUSH="Flush/Drugs";
	private static final String CVP="CVP";
	private static final String NGFEED="NG Feeds";//WDEV-1666
	private static final String IV="IV Intake";
	private static final String TOTAL_IN="Total Intake";
	private static final String FLUID_OUT="Fluid Out";
	private static final String URINE="Urine";
	private static final String GASTRIC="Gastric";
	private static final String DRAINS="Drains";
	private static final String TOTAL_OUT="Total Output";
	private static final String PAIN="Pain";
	private static final String PAIN_SCALE="Pain Scale";
	
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}
	
	private void open()
	{
		populateBaseGrid();
		form.getGlobalContext().Core.setVentilationChartDateTime(null);
		// List ventilation chart for the given clinical contact
		ShiftDetailsVoCollection shiftDetailsColl = domain.listShiftDetails(form.getGlobalContext().Core.getCurrentCareContext());
		form.cmbAllRecords().clear();
		DateTime[] dates = new DateTime[shiftDetailsColl.size()];
		for (int i=0; i<shiftDetailsColl.size(); i++)
		{
			DateTime dt = shiftDetailsColl.get(i).getStartDateTime();
			if ( dt != null )
				dates[i] = dt;
			
			form.cmbAllRecords().newRow(shiftDetailsColl.get(i), shiftDetailsColl.get(i).getStartDateTime().toString() + " to " + shiftDetailsColl.get(i).getEndDateTime().toString());
		}
		if (dates != null && dates.length > 0)
		{
			form.getGlobalContext().Core.setVentilationChartDateTime(dates);
			// For each date, populate it into the all Records combo
			/*
			form.cmbAllRecords().clear();
			for (int i=0; i<dates.length; i++)
			{
				DateTime curDate = dates[i];
				form.cmbAllRecords().newRow(curDate.getDate(), curDate.getDate().toString());
			}
			*/
		
			// Set the combo value to the latest one
			//form.cmbAllRecords().setValue(dates[dates.length-1].getDate());
			if(shiftDetailsColl.size()>0)
				form.cmbAllRecords().setValue(shiftDetailsColl.get(0));
			
			// List all the ventilation chart records for the given Clinical Contact and this date
			VitalSignsVoCollection coll = domain.listVentilationCharts(form.getGlobalContext().Core.getCurrentCareContext(), form.cmbAllRecords().getValue());
			if (coll != null && coll.size() > 0)
			{
				populateGrid(coll);
				form.btnUpdate().setEnabled(false);
			}
			else
				form.cmbRecordToUpdate().clear();  //wdev-13637
				
		}
		
		updateControlsState();
	}
	
	private void updateControlsState()
	{
		form.cmbRecordToUpdate().setEnabled(form.cmbAllRecords().getValue() != null);
		form.btnUpdate().setEnabled(form.cmbRecordToUpdate().getValue() != null);
		form.getLocalContext().setSelectedVitalSignsVo(form.cmbRecordToUpdate().getValue());
	}

	private void populateBaseGrid()
	{
		// Populate the LHS column
		form.grdVentilation().getRows().clear();
		
		GenForm.grdVentilationRow row;
		row = setRow(VS, null);
		setRow(TEMP, row);
		setRow(BP, row);
		setRow(PULSE, row);
		row = setRow(VENT, null);
		setRow(SUCTION, row);
		setRow(PHYSIO, row);
		setRow(MODE, row);
		setRow(PRESSURE, row);
		setRow(PEEP, row);
		setRow(TIDAL, row);
		setRow(MINUTE, row);
		setRow(RATE, row);
		setRow(SPRATE, row);
		setRow(SPMV, row);
		setRow(CUFF, row);
		setRow(HUMID, row);
		setRow(SATS, row);
		setRow(PROBE, row);
		row = setRow(POS_PAR, null);
		setRow(POSITION, row);
		row = setRow(FLUID_IN, null);
		setRow(ORAL, row);
		setRow(FLUSH, row);
		setRow(CVP, row);
		setRow(IV, row);
		setRow(NGFEED, row);//WDEV-1666
		setRow(TOTAL_IN, row);
		row = setRow(FLUID_OUT, null);
		setRow(URINE, row);
		setRow(GASTRIC, row);
		setRow(DRAINS, row);
		setRow(TOTAL_OUT, row);
		row = setRow(PAIN, null);
		setRow(PAIN_SCALE, row);
		
	}
	
	private GenForm.grdVentilationRow setRow(String value, GenForm.grdVentilationRow parentRow)
	{
		GenForm.grdVentilationRow row;
		if (parentRow != null)
			row = parentRow.getRows().newRow();
		else
		{
			row = form.grdVentilation().getRows().newRow();
			row.setBackColor(Color.LemonChiffon);
			row.setBold(true);
		}
		row.setValue(value);
		row.setColVentilationChart(value);
		return row;
	}
	
	private void populateGrid(VitalSignsVoCollection coll)
	{
		form.cmbRecordToUpdate().clear();
		for (int i=0; i<coll.size(); i++)
		{
			VitalSignsVo vo = coll.get(i);
			GenForm.grdVentilationRow row=null;
			String value = null;

			if (vo.getBloodPressureIsNotNull())
			{
				row = form.grdVentilation().getRowByValue(BP);
				if(vo.getBloodPressure().getBPSittingSys() != null && vo.getBloodPressure().getBPSittingDias() != null)
					value = vo.getBloodPressure().getBPSittingSys().toString() + " / " + vo.getBloodPressure().getBPSittingDias().toString();
				setRowValue(row, value, vo);	
			}
			if (vo.getTemperatureIsNotNull())
			{
				row = form.grdVentilation().getRowByValue(TEMP);
				value = vo.getTemperature().getTemperature().toString();
				setRowValue(row, value, vo);
			}
			if (vo.getPulseIsNotNull())
			{
				row = form.grdVentilation().getRowByValue(PULSE);
				if(vo.getPulse().getPulseRateRadial() != null)
					value = vo.getPulse().getPulseRateRadial().toString();
				setRowValue(row, value, vo);
				//PulseRateApex will have to go in here
			}
			if (vo.getLungFunctionTestIsNotNull())
			{
				row = form.grdVentilation().getRowByValue(TIDAL);
				if(vo.getLungFunctionTest().getTidalVolume() != null)
					value = vo.getLungFunctionTest().getTidalVolume().toString();
				setRowValue(row, value, vo);
				row = form.grdVentilation().getRowByValue(MINUTE);
				if(vo.getLungFunctionTest().getMinuteVolume() != null)
					value = vo.getLungFunctionTest().getMinuteVolume().toString();
				setRowValue(row, value, vo);
			}
			if (vo.getRespiratoryIsNotNull())
			{
				row = form.grdVentilation().getRowByValue(RATE);
				value = vo.getRespiratory().getRespRate().toString();
				setRowValue(row, value, vo);
			}
			if (vo.getOxygenSaturationIsNotNull())
			{
				row = form.grdVentilation().getRowByValue(SATS);
				if (vo.getOxygenSaturationIsNotNull())
					if (vo.getOxygenSaturation().getOxygenSaturationLevelIsNotNull())
						value = vo.getOxygenSaturation().getOxygenSaturationLevel().toString() + ( vo.getOxygenSaturation().getFractionRateIsNotNull() ? " / " + vo.getOxygenSaturation().getFractionRate().toString() : "");
				if(vo.getOxygenSaturation().getFractionRate() == null)
					row.setColVentilationChart(row.getColVentilationChart().replace(" / Fraction Rate", ""));
				
				setRowValue(row, value, vo);
			}
			if (vo.getVentilationChartIsNotNull())
			{
				VSVentilationChartVo chart = vo.getVentilationChart();
				if (chart.getSuctionIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(SUCTION);
					value = chart.getSuction().getText();
					setRowValue(row, value, vo);
				}
				if (chart.getPhysioIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(PHYSIO);
					value = chart.getPhysio().getText();
					setRowValue(row, value, vo);
				}
				if (chart.getModeIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(MODE);
					value = chart.getMode().getText();
					setRowValue(row, value, vo);
				}
				if (chart.getPeakPressureIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(PRESSURE);
					value = chart.getPeakPressure().toString();
					setRowValue(row, value, vo);
				}
				if (chart.getPEEPCPAPIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(PEEP);
					value = chart.getPEEPCPAP().toString();
					setRowValue(row, value, vo);
				}
				if (chart.getRateIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(SPRATE);
					value = chart.getRate().toString();
					setRowValue(row, value, vo);
				}
				if (chart.getSpontaneousMVIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(SPMV);
					value= chart.getSpontaneousMV().toString();
					setRowValue(row, value, vo);
				}
				if (chart.getCuffIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(CUFF);
					value = chart.getCuff().getText();
					setRowValue(row, value, vo);
				}
				if (chart.getHumidifierTempIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(HUMID);
					value = chart.getHumidifierTemp().toString();
					setRowValue(row, value, vo);
				}
				if (chart.getProbeChangeIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(PROBE);
					value="";
					if (chart.getProbeChange().equals(YesNo.YES))
						value = "Yes";
					else if (chart.getProbeChange().equals(YesNo.NO))
						value= "No";
					setRowValue(row, value, vo);
				}
				if (chart.getPositionIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(POSITION);
					value = chart.getPosition().getText();
					setRowValue(row, value, vo);
				}
				if (chart.getPainScaleIsNotNull())
				{
					row = form.grdVentilation().getRowByValue(PAIN_SCALE);
					value= chart.getPainScale().getText();
					setRowValue(row, value, vo);
				}
				if (chart.getFluidBalanceInstanceIsNotNull())
				{
					if (chart.getFluidBalanceInstance().getFluidIntake() != null)
					{
						FluidBalanceDetailsVoCollection inColl = chart.getFluidBalanceInstance().getFluidIntake();
						for (int j=0; j<inColl.size(); j++)
						{
							FluidBalanceDetailsVo det = inColl.get(j);
							if (det.getType().equals(FluidBalanceType.ORAL))
								row = form.grdVentilation().getRowByValue(ORAL);
							else if (det.getType().equals(FluidBalanceType.FLUSHDRUGS))
								row = form.grdVentilation().getRowByValue(FLUSH);
							else if (det.getType().equals(FluidBalanceType.CVP))
								row = form.grdVentilation().getRowByValue(CVP);
							else if (det.getType().equals(FluidBalanceType.IVINTAKE))
								row = form.grdVentilation().getRowByValue(IV);
							else if (det.getType().equals(FluidBalanceType.NGFEED))//wdev-1666
								row = form.grdVentilation().getRowByValue(NGFEED);

							value = det.getValue().toString();
							setRowValue(row, value, vo);
						}
					}
					if (chart.getFluidBalanceInstance().getTotalIntakeIsNotNull())
					{
						row = form.grdVentilation().getRowByValue(TOTAL_IN);
						value= chart.getFluidBalanceInstance().getTotalIntake().toString();
						setRowValue(row, value, vo);
					}
					if (chart.getFluidBalanceInstance().getFluidOutput() != null)
					{
						FluidBalanceDetailsVoCollection outColl = chart.getFluidBalanceInstance().getFluidOutput();
						for (int j=0; j<outColl.size(); j++)
						{
							FluidBalanceDetailsVo det = outColl.get(j);
							if (det.getType().equals(FluidBalanceType.URINE))
								row = form.grdVentilation().getRowByValue(URINE);
							else if (det.getType().equals(FluidBalanceType.GASTRIC))
								row = form.grdVentilation().getRowByValue(GASTRIC);
							else if (det.getType().equals(FluidBalanceType.DRAINS))
								row = form.grdVentilation().getRowByValue(DRAINS);
							value = det.getValue().toString();
							setRowValue(row, value, vo);
						}

					}
					if (chart.getFluidBalanceInstance().getTotalOutputIsNotNull())
					{
						row = form.grdVentilation().getRowByValue(TOTAL_OUT);
						value= chart.getFluidBalanceInstance().getTotalOutput().toString();
						setRowValue(row, value, vo);
					}
				}
			}
		}
		form.grdVentilation().expandAll();

	}
	
	private void setRowValue(GenForm.grdVentilationRow row, String value, VitalSignsVo vo)
	{
		if (row == null)
			return;
		// Which column needs to be populated?
		int hour = vo.getVitalsTakenDateTime().getTime().getHour();
		switch (hour)
		{
			case 0:
				row.setCol24(value);
				form.cmbRecordToUpdate().newRow(vo, "24:00");
				break;
			case 1:
				row.setCol01(value);
				form.cmbRecordToUpdate().newRow(vo, "01:00");
				break;
			case 2:
				row.setCol02(value);
				form.cmbRecordToUpdate().newRow(vo, "02:00");
				break;
			case 3:
				row.setCol03(value);
				form.cmbRecordToUpdate().newRow(vo, "03:00");
				break;
			case 4:
				row.setCol04(value);
				form.cmbRecordToUpdate().newRow(vo, "04:00");
				break;
			case 5:
				row.setCol05(value);
				form.cmbRecordToUpdate().newRow(vo, "05:00");
				break;
			case 6:
				row.setCol06(value);
				form.cmbRecordToUpdate().newRow(vo, "06:00");
				break;
			case 7:
				row.setCol07(value);
				form.cmbRecordToUpdate().newRow(vo, "07:00");
				break;
			case 8:
				row.setCol08(value);
				form.cmbRecordToUpdate().newRow(vo, "08:00");
				break;
			case 9:
				row.setCol09(value);
				form.cmbRecordToUpdate().newRow(vo, "09:00");
				break;
			case 10:
				row.setCol10(value);
				form.cmbRecordToUpdate().newRow(vo, "10:00");
				break;
			case 11:
				row.setCol11(value);
				form.cmbRecordToUpdate().newRow(vo, "11:00");
				break;
			case 12:
				row.setCol12(value);
				form.cmbRecordToUpdate().newRow(vo, "12:00");
				break;
			case 13:
				row.setCol13(value);
				form.cmbRecordToUpdate().newRow(vo, "13:00");
				break;
			case 14:
				row.setCol14(value);
				form.cmbRecordToUpdate().newRow(vo, "14:00");
				break;
			case 15:
				row.setCol15(value);
				form.cmbRecordToUpdate().newRow(vo, "15:00");
				break;
			case 16:
				row.setCol16(value);
				form.cmbRecordToUpdate().newRow(vo, "16:00");
				break;
			case 17:
				row.setCol17(value);
				form.cmbRecordToUpdate().newRow(vo, "17:00");
				break;
			case 18:
				row.setCol18(value);
				form.cmbRecordToUpdate().newRow(vo, "18:00");
				break;
			case 19:
				row.setCol19(value);
				form.cmbRecordToUpdate().newRow(vo, "19:00");
				break;
			case 20:
				row.setCol20(value);
				form.cmbRecordToUpdate().newRow(vo, "20:00");
				break;
			case 21:
				row.setCol21(value);
				form.cmbRecordToUpdate().newRow(vo, "21:00");
				break;
			case 22:
				row.setCol22(value);
				form.cmbRecordToUpdate().newRow(vo, "22:00");
				break;
			case 23:
				row.setCol23(value);
				form.cmbRecordToUpdate().newRow(vo, "23:00");
				break;
		}

	}
	
	protected void onCmbAllRecordsValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbRecordToUpdate().clear();
		clearGridContent();
		form.btnUpdate().setEnabled(false);
		
		if (form.cmbAllRecords().getValue() != null)
		{
			//populateBaseGrid();
			// List all the ventilation chart records for the given Clinical Contact and this date
			VitalSignsVoCollection coll = domain.listVentilationCharts(form.getGlobalContext().Core.getCurrentCareContext(), form.cmbAllRecords().getValue());
			if (coll != null && coll.size() > 0)
				 populateGrid(coll);
			
//			form.btnUpdate().setEnabled(true);
		}
//		else
//		{
//			form.btnUpdate().setEnabled(false);		
//		}
		
		updateControlsState();
	}
	
	private void clearGridContent()
	{
		for (int i = 0; i < form.grdVentilation().getRows().size(); i++)
		{
			grdVentilationRow parentRow = form.grdVentilation().getRows().get(i);
			
			for (int j = 0; j < parentRow.getRows().size(); j++)
			{
				grdVentilationRow childRow = parentRow.getRows().get(j);
				
				childRow.setCol01(null);
				childRow.setCol02(null);
				childRow.setCol03(null);
				childRow.setCol04(null);
				childRow.setCol05(null);
				childRow.setCol06(null);
				childRow.setCol07(null);
				childRow.setCol08(null);
				childRow.setCol09(null);
				childRow.setCol10(null);
				childRow.setCol11(null);
				childRow.setCol12(null);
				childRow.setCol13(null);
				childRow.setCol14(null);
				childRow.setCol15(null);
				childRow.setCol16(null);
				childRow.setCol17(null);
				childRow.setCol18(null);
				childRow.setCol19(null);
				childRow.setCol20(null);
				childRow.setCol21(null);
				childRow.setCol22(null);
				childRow.setCol23(null);
				childRow.setCol24(null);
			}
		}
		
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbRecordToUpdate().getValue() == null)
		{
			engine.showMessage("Please select a record to update");
			return;
		}
		
		form.getGlobalContext().Core.setVitalSign(form.cmbRecordToUpdate().getValue());
		engine.open(form.getForms().Core.VitalSignsVentilationChartDialog);
		
	}
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setVitalSign(null);
		engine.open(form.getForms().Core.VitalSignsVentilationChartDialog);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if (result.equals(DialogResult.OK))
			open();
	}

	protected void onCmbRecordToUpdateValueChanged() throws PresentationLogicException
	{
//		if(form.cmbRecordToUpdate().getValue() == null)
//			form.btnUpdate().setEnabled(false);
//		else
//			form.btnUpdate().setEnabled(true);
		
		updateControlsState();
	}
}
