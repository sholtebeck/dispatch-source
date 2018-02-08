package kmi.extensions.components;

import com.webobjects.appserver.WOAssociation;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOElement;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver._private.WODynamicElementCreationException;
import com.webobjects.foundation.NSDictionary;

import er.extensions.appserver.ERXApplication;
import er.extensions.components.ERXDynamicElement;
import er.extensions.foundation.ERXStringUtilities;

public class KMIStaticResourceLink extends ERXDynamicElement {

	public KMIStaticResourceLink(String name, NSDictionary<String, WOAssociation> associations, WOElement template) {
		super(name, associations, template);
	}
	
	public void appendToResponse(WOResponse response, WOContext context) {

		WOComponent component = context.component();
		
		String fileName = stringValueForBinding("filename", component);
		String framework = stringValueForBinding("framework", "app", component);

		if(ERXStringUtilities.stringIsNullOrEmpty(fileName)) {
			throw new WODynamicElementCreationException("Filename must be defined.");
		}

		String elementName = stringValueForBinding("elementName", "a", component);
		response.appendContentString("<");
		response.appendContentString(elementName);
		
		appendTagAttributeToResponse(response, "class", stringValueForBinding("class", component));
		appendTagAttributeToResponse(response, "alt", valueForBinding("alt", component));
		appendTagAttributeToResponse(response, "style", valueForBinding("style", component));
		appendTagAttributeToResponse(response, "rel", valueForBinding("rel", component));
		appendTagAttributeToResponse(response, "target", valueForBinding("target", component));
		
		String url = ERXApplication.application().resourceManager().urlForResourceNamed(fileName, framework, null, context.request());
		appendTagAttributeToResponse(response, "href", url);
		response.appendContentString(">");
		
		appendChildrenToResponse(response, context);
		
		response.appendContentString("</");
		response.appendContentString(elementName);
		response.appendContentString(">");
			
	}
	
	
	


}