package km.content.eo.interfaces;

import km.content.eo.KMIHTMLNode;

import com.webobjects.appserver.WOActionResults;


public interface KMIWebDocumentEditorInterface {

	public static final String DOCUMENT_INFO_INSPECTOR_PAGE_KEY = "DocumentInfo";
	
	public KMIHTMLNode kMIWebDocumentEditorSelectedNode();
	public void setKMIWebDocumentEditorSelectedNode(KMIHTMLNode node);
	
	public String kMIWebDocumentEditorInspectorPageKey();
	public void setKMIWebDocumentEditorInspectorPageKey(String value);

	public WOActionResults addNodeToKMIWebDocument();
	
}
