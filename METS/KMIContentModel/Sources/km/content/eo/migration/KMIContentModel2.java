package km.content.eo.migration;

import km.content.eo.KMIWebDocumentCategory;
import kmi.foundation.extensions.KMIStringUtilities;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel2 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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
	 	
		ERXMigrationTable kmiWebDocumentCategoryTable = database.existingTableNamed("DocumentCategory");
		kmiWebDocumentCategoryTable.newStringColumn("unique_identifier", 50, true);
		kmiWebDocumentCategoryTable.newIntegerColumn("parent_id", true);
		kmiWebDocumentCategoryTable.addForeignKey("parent_id", "DocumentCategory", "id");
		
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {

		NSArray<KMIWebDocumentCategory> categories = KMIWebDocumentCategory.fetchAllKMIWebDocumentCategories(editingContext);
		
		for(KMIWebDocumentCategory category : categories) {
			category.setUniqueIdentifier(KMIStringUtilities.sixtyFourBitHash(KMIStringUtilities.randomString(16)));
			editingContext.saveChanges();
		}

	}

}