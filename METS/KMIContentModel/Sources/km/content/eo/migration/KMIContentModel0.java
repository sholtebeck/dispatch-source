package km.content.eo.migration;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class KMIContentModel0 extends ERXMigrationDatabase.Migration {

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
		ERXMigrationTable kmiAbstractAssetTable = database.newTableNamed("Asset");
		kmiAbstractAssetTable.newTimestampColumn("create_date", true);
		kmiAbstractAssetTable.newIntegerColumn("groupID", true);
		kmiAbstractAssetTable.newIntegerColumn("id", false);
		kmiAbstractAssetTable.newTimestampColumn("last_modified", true);
		kmiAbstractAssetTable.newStringColumn("name", 50, true);
		kmiAbstractAssetTable.newIntegerColumn("type", true);
		kmiAbstractAssetTable.create();
	 	kmiAbstractAssetTable.setPrimaryKey("id");

		ERXMigrationTable kmiAbstractDocumentTable = database.newTableNamed("Document");
		kmiAbstractDocumentTable.newTimestampColumn("create_date", true);
		kmiAbstractDocumentTable.newIntegerColumn("id", false);
		kmiAbstractDocumentTable.newTimestampColumn("last_modified", true);
		kmiAbstractDocumentTable.newStringColumn("name", 50, true);
		kmiAbstractDocumentTable.newIntegerColumn("type", true);
		kmiAbstractDocumentTable.create();
	 	kmiAbstractDocumentTable.setPrimaryKey("id");

		ERXMigrationTable kmiAbstractNodeTable = database.newTableNamed("Node");
		kmiAbstractNodeTable.newTimestampColumn("create_date", true);
		kmiAbstractNodeTable.newIntegerColumn("document_id", true);
		kmiAbstractNodeTable.newIntegerColumn("id", false);
		kmiAbstractNodeTable.newTimestampColumn("last_modified", true);
		kmiAbstractNodeTable.newStringColumn("name", 50, true);
		kmiAbstractNodeTable.newIntegerColumn("type", true);
		kmiAbstractNodeTable.create();
	 	kmiAbstractNodeTable.setPrimaryKey("id");

		ERXMigrationTable kmiAbstractNodeAttributeTable = database.newTableNamed("NodeAttribute");
		kmiAbstractNodeAttributeTable.newIntegerColumn("id", false);
		kmiAbstractNodeAttributeTable.newStringColumn("name", 50, true);
		kmiAbstractNodeAttributeTable.newIntegerColumn("type", true);
		kmiAbstractNodeAttributeTable.newStringColumn("value", 255, true);
		kmiAbstractNodeAttributeTable.create();
	 	kmiAbstractNodeAttributeTable.setPrimaryKey("id");

		ERXMigrationTable kmiAssetGalleryTable = database.newTableNamed("AssetGallery");
		kmiAssetGalleryTable.newTimestampColumn("create_date", true);
		kmiAssetGalleryTable.newIntegerColumn("id", false);
		kmiAssetGalleryTable.newTimestampColumn("last_modified", true);
		kmiAssetGalleryTable.newStringColumn("name", 50, true);
		kmiAssetGalleryTable.create();
	 	kmiAssetGalleryTable.setPrimaryKey("id");

		ERXMigrationTable kmiAssetGalleryAssetsTable = database.newTableNamed("AssetGalleryAssets");
		kmiAssetGalleryAssetsTable.newIntegerColumn("kmiAbstractAssetId", false);
		kmiAssetGalleryAssetsTable.newIntegerColumn("kmiAssetGalleryId", false);
		kmiAssetGalleryAssetsTable.create();
	 	kmiAssetGalleryAssetsTable.setPrimaryKey("kmiAbstractAssetId", "kmiAssetGalleryId");

		ERXMigrationTable kmiAssetGroupTable = database.newTableNamed("AssetGroup");
		kmiAssetGroupTable.newTimestampColumn("create_date", true);
		kmiAssetGroupTable.newIntegerColumn("id", false);
		kmiAssetGroupTable.newTimestampColumn("last_modified", true);
		kmiAssetGroupTable.newStringColumn("name", 50, true);
		kmiAssetGroupTable.create();
	 	kmiAssetGroupTable.setPrimaryKey("id");

		ERXMigrationTable kmiImageAssetTable = database.existingTableNamed("Asset");
		kmiImageAssetTable.newIntegerColumn("attachment_id", true);

		ERXMigrationTable kmiWebDocumentTable = database.existingTableNamed("Document");
		kmiWebDocumentTable.newStringColumn("meta_description", 255, true);
		kmiWebDocumentTable.newStringColumn("page_title", 100, true);
		kmiWebDocumentTable.newIntegerColumn("parent_id", true);
		kmiWebDocumentTable.newIntegerColumn("position", true);
		kmiWebDocumentTable.newTimestampColumn("publish_date", true);
		kmiWebDocumentTable.newStringColumn("slug", 100, true);

		ERXMigrationTable kmiWebDocumentTemplateTable = database.existingTableNamed("Document");

		ERXMigrationTable kmihtmlNodeTable = database.existingTableNamed("Node");
		kmihtmlNodeTable.newIntegerColumn("parent_node_id", true);
		kmihtmlNodeTable.newIntegerColumn("position", true);
		kmihtmlNodeTable.newStringColumn("tag_name", 16, true);

		ERXMigrationTable kmihtmlImageNodeTable = database.existingTableNamed("Node");
		kmihtmlImageNodeTable.newIntegerColumn("asset_id", true);

		ERXMigrationTable kmihtmlLayoutNodeTable = database.existingTableNamed("Node");
		kmihtmlLayoutNodeTable.newLargeStringColumn("text_content", true);

		ERXMigrationTable kmihtmlNodeAttributeTable = database.existingTableNamed("NodeAttribute");
		kmihtmlNodeAttributeTable.newIntegerColumn("node_id", true);

		kmiAbstractAssetTable.addForeignKey("groupID", "AssetGroup", "id");
		kmiAbstractNodeTable.addForeignKey("document_id", "Document", "id");
		kmiAssetGalleryAssetsTable.addForeignKey("kmiAbstractAssetId", "Asset", "id");
		kmiAssetGalleryAssetsTable.addForeignKey("kmiAssetGalleryId", "AssetGallery", "id");
		kmiImageAssetTable.addForeignKey("attachment_id", "ERAttachment", "id");
		kmiWebDocumentTable.addForeignKey("parent_id", "Document", "id");
		kmihtmlNodeTable.addForeignKey("parent_node_id", "Node", "id");
		kmihtmlImageNodeTable.addForeignKey("asset_id", "Asset", "id");
		kmihtmlNodeAttributeTable.addForeignKey("node_id", "Node", "id");
	}
}