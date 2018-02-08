package km.content.eo.migration;

import km.content.eo.KMIWebSite;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.foundation.ERXMutableDictionary;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel4 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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

		ERXMigrationTable kmiWebSiteTable = database.existingTableNamed("WebSite");
		kmiWebSiteTable.newBlobColumn("properties", true);
	
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {

		NSArray<KMIWebSite> websites = KMIWebSite.fetchAllKMIWebSites(editingContext);

		for(KMIWebSite website : websites) {
			website.setProperties(new ERXMutableDictionary<String, Object>());
			editingContext.saveChanges();
		}
	
	}
	
	

}