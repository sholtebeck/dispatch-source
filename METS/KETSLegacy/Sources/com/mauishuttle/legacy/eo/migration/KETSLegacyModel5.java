package com.mauishuttle.legacy.eo.migration;
import com.mauishuttle.eo.MESDriver;
import com.mauishuttle.eo.MESHub;
import com.mauishuttle.legacy.eo.Driver;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSValidation;

import er.extensions.foundation.ERXStringUtilities;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KETSLegacyModel5 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model)
			throws Throwable {

		NSArray<Driver> drivers = Driver.fetchDrivers(editingContext, Driver.ACTIVE.eq("Yes"), Driver.DRIVERLNAME.ascs());
		MESHub hub = MESHub.fetchRequiredMESHub(editingContext, MESHub.NAME.eq("The Big Island"));

		for(Driver driver : drivers) {
			
			try {

				MESDriver newDriver = MESDriver.createMESDriver(editingContext, hub);
				newDriver.setActive(true);
				String firstName = ERXStringUtilities.stringIsNullOrEmpty(driver.driverfname()) ? "Unknown" : driver.driverfname();
				String lastName = ERXStringUtilities.stringIsNullOrEmpty(driver.driverlname()) ? "Unknown" : driver.driverlname();
				newDriver.setFirstName(firstName);
				newDriver.setLastName(lastName);
				editingContext.saveChanges();
				
			} catch(NSValidation.ValidationException e) {
				e.printStackTrace();
			}
			
		}
		
	}



}