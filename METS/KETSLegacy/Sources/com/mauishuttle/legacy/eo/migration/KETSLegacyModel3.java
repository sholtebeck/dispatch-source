package com.mauishuttle.legacy.eo.migration;
import com.mauishuttle.eo.MESDispatch;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSValidation;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KETSLegacyModel3 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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

		NSArray<MESDispatch> dispatches = MESDispatch.fetchAllMESDispatchs(editingContext);

		for(MESDispatch dispatch : dispatches) {
			try {
				dispatch.delete();
				editingContext.saveChanges();
			} catch(NSValidation.ValidationException e) {
				e.printStackTrace();
			}
		}
		
	}



}