package km.content.eo.migration;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel14 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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
		ERXMigrationTable kmiWebDocumentsKeyWordsTable = database.newTableNamed("DocumentsKeyWords");
		kmiWebDocumentsKeyWordsTable.newIntegerColumn("document_id", false);
		kmiWebDocumentsKeyWordsTable.newIntegerColumn("key_word_id", false);
		kmiWebDocumentsKeyWordsTable.create();
	 	kmiWebDocumentsKeyWordsTable.setPrimaryKey("document_id", "key_word_id");

		kmiWebDocumentsKeyWordsTable.addForeignKey("document_id", "Document", "id");
		kmiWebDocumentsKeyWordsTable.addForeignKey("key_word_id", "DocumentKeyWord", "id");
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {
	}

}