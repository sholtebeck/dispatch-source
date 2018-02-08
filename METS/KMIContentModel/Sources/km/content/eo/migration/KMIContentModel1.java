package km.content.eo.migration;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class KMIContentModel1 extends ERXMigrationDatabase.Migration {

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

		ERXMigrationTable kmiWebSiteTable = database.newTableNamed("WebSite");
		kmiWebSiteTable.newIntegerColumn("id", false);
		kmiWebSiteTable.newIntegerColumn("type", true);
		kmiWebSiteTable.create();
	 	kmiWebSiteTable.setPrimaryKey("id");

	 	ERXMigrationTable kmiAbstractAssetTable = database.existingTableNamed("Asset");

		kmiAbstractAssetTable.newIntegerColumn("site_id", false);

		ERXMigrationTable kmiAbstractDocumentTable = database.existingTableNamed("Document");
		kmiAbstractDocumentTable.newIntegerColumn("site_id", false);

		ERXMigrationTable kmiAssetGalleryTable = database.existingTableNamed("AssetGallery");
		kmiAssetGalleryTable.newIntegerColumn("site_id", false);

		ERXMigrationTable kmiAssetGroupTable = database.existingTableNamed("AssetGroup");
		kmiAssetGroupTable.newIntegerColumn("site_id", false);

		ERXMigrationTable kmiWebDocumentTable = database.existingTableNamed("Document");
		kmiWebDocumentTable.newIntegerColumn("category_id", true);
		kmiWebDocumentTable.newBooleanColumn("comments_enabled", true, true);

		ERXMigrationTable kmiWebDocumentCategoryTable = database.newTableNamed("DocumentCategory");
		kmiWebDocumentCategoryTable.newIntegerColumn("id", false);
		kmiWebDocumentCategoryTable.newStringColumn("name", 50, true);
		kmiWebDocumentCategoryTable.newIntegerColumn("site_id", false);
		kmiWebDocumentCategoryTable.create();
	 	kmiWebDocumentCategoryTable.setPrimaryKey("id");

		ERXMigrationTable kmiWebDocumentCommentTable = database.newTableNamed("DocumentComment");
		kmiWebDocumentCommentTable.newStringColumn("comment", 1000, true);
		kmiWebDocumentCommentTable.newStringColumn("commenter_email", 255, true);
		kmiWebDocumentCommentTable.newStringColumn("commenterName", 50, true);
		kmiWebDocumentCommentTable.newTimestampColumn("creation_date", true);
		kmiWebDocumentCommentTable.newIntegerColumn("document_id", false);
		kmiWebDocumentCommentTable.newBooleanColumn("flagged", true);
		kmiWebDocumentCommentTable.newIntegerColumn("id", false);
		kmiWebDocumentCommentTable.create();
	 	kmiWebDocumentCommentTable.setPrimaryKey("id");

		ERXMigrationTable kmiWebDocumentKeyWordTable = database.newTableNamed("DocumentKeyWord");
		kmiWebDocumentKeyWordTable.newIntegerColumn("id", false);
		kmiWebDocumentKeyWordTable.newStringColumn("name", 50, true);
		kmiWebDocumentKeyWordTable.newIntegerColumn("site_id", false);
		kmiWebDocumentKeyWordTable.create();
	 	kmiWebDocumentKeyWordTable.setPrimaryKey("id");

		kmiWebDocumentKeyWordTable.addForeignKey("site_id", "WebSite", "id");
	 	kmiWebDocumentCommentTable.addForeignKey("document_id", "Document", "id");	 	
		kmiWebDocumentCategoryTable.addForeignKey("site_id", "WebSite", "id");
		kmiWebDocumentTable.addForeignKey("category_id", "DocumentCategory", "id");
		kmiAssetGroupTable.addForeignKey("site_id", "WebSite", "id");
		kmiAssetGalleryTable.addForeignKey("site_id", "WebSite", "id");		
		kmiAbstractAssetTable.addForeignKey("site_id", "WebSite", "id");	 	
		kmiAbstractDocumentTable.addForeignKey("site_id", "WebSite", "id");		
		
	 	
	 	
	}
}