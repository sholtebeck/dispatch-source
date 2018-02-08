package km.content.eo.migration;

import km.content.eo.KMIWebDocumentCategory;
import km.content.eo.KMIWebDocumentKeyWord;
import kmi.foundation.extensions.KMIStringUtilities;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel15 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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
		kmiWebDocumentCategoryTable.newStringColumn("slug", 50, true);

		ERXMigrationTable kmiWebDocumentKeyWordTable = database.existingTableNamed("DocumentKeyWord");
		kmiWebDocumentKeyWordTable.newStringColumn("slug", 50, true);
	
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {
		
		NSArray<KMIWebDocumentCategory> categories = KMIWebDocumentCategory.fetchAllKMIWebDocumentCategories(editingContext);
		for(KMIWebDocumentCategory category : categories) {
			category.setSlug(KMIStringUtilities.toPrettyURL(category.name()));
			editingContext.saveChanges();
		}

		NSArray<KMIWebDocumentKeyWord> keyWords = KMIWebDocumentKeyWord.fetchAllKMIWebDocumentKeyWords(editingContext);
		for(KMIWebDocumentKeyWord keyWord : keyWords) {
			keyWord.setSlug(KMIStringUtilities.toPrettyURL(keyWord.name()));
			editingContext.saveChanges();
		}
		
	}

}