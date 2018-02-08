package com.mauishuttle.legacy.eo.migration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mauishuttle.eo.MESAbstractZone;
import com.mauishuttle.eo.MESLocation;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KETSLegacyModel8 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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

		try {
			
			File csvFile = new File("/Users/johnnymiller/Desktop/Book1.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile)));
			String line = reader.readLine();
			
			while(line != null) {

				String[] locationParts = line.split(",");
				MESAbstractZone zone = MESAbstractZone.fetchRequiredMESAbstractZone(editingContext, MESAbstractZone.NAME.eq(locationParts[5]));
				MESLocation location = MESLocation.createMESLocation(editingContext);
				location.setZoneRelationship(zone);
				location.setName(locationParts[1]);
				location.setPhoneNumber(locationParts[3]);
				location.setAddress(locationParts[4]);
				editingContext.saveChanges();
				line = reader.readLine();

			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}