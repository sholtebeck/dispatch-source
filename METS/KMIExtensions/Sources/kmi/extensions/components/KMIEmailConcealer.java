package kmi.extensions.components;

import com.webobjects.appserver.WOAssociation;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOElement;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSDictionary;

import er.extensions.components.ERXDynamicElement;

public class KMIEmailConcealer extends ERXDynamicElement {


	
	public KMIEmailConcealer(String name,
			NSDictionary<String, WOAssociation> associations, WOElement template) {
		super(name, associations, template);
		// TODO Auto-generated constructor stub
	}


	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);

		
		WOComponent component = context.component();
		
		response.appendContentString("<script type = \"text/javascript\">\n");
		response.appendContentString("<!--\n");
		response.appendContentString("var contact = \"");
		response.appendContentString(stringValueForBinding("contact", component).replace("\"","\\\""));
		response.appendContentString("\";\n");
		response.appendContentString("var email = \"");
		response.appendContentString(stringValueForBinding("email", component));
		response.appendContentString("\";\n");
		response.appendContentString("var emailHost = \"");
		response.appendContentString(stringValueForBinding("emailHost", component));
		response.appendContentString("\";\n");
		response.appendContentString("document.write(\"<a");
		if(hasBinding("class") && valueForBinding("class", component) != null) {
			response.appendContentString(" class = \\\"");
			response.appendContentString(stringValueForBinding("class", component));
			response.appendContentString("\\\"");
		}
		if(hasBinding("id") && valueForBinding("id", component) != null) {
			response.appendContentString(" id = \\\"");
			response.appendContentString(stringValueForBinding("id", component));
			response.appendContentString("\\\"");
		}
		response.appendContentString(" href=\" + \"mail\" + \"to:\" + email + \"@\" + emailHost"); 
		
		boolean hasSubject = hasBinding("subject") && valueForBinding("subject", component) != null;
		if(hasSubject) {
			response.appendContentString(" + \"?subject=");
			response.appendContentString(_escapedString(stringValueForBinding("subject", component)));
		}
		
		boolean hasBody = hasBinding("body") && valueForBinding("body", component) != null;
		if(hasBody) {
			if(hasSubject) {
				response.appendContentString("&");
			} else {
				response.appendContentString("+ \"?");
			}
			response.appendContentString("body=");
			response.appendContentString(_escapedString(stringValueForBinding("body", component)));
		}

		if(hasBody || hasSubject) {
			response.appendContentString("\"");
		}
		
		if(hasBinding("style") && valueForBinding("style", component) != null) {
			response.appendContentString(" + \" style = \'");
			response.appendContentString(stringValueForBinding("style", component));
			response.appendContentString("\'\"");
		}

		response.appendContentString(" + \">\" + contact + \"</a>\");");
		response.appendContentString("//-->\n");
		response.appendContentString("</script>\n");
		response.appendContentString("<noscript>");
		response.appendContentString("<a href = \"mailto:");
		response.appendContentString(stringValueForBinding("email", component));
		response.appendContentString("&#64;");
		response.appendContentString(stringValueForBinding("emailHost", component));
		if(hasSubject) {
			response.appendContentString("?subject=");
			response.appendContentString(_escapedString(stringValueForBinding("subject", component)));
		}
		if(hasBody) {
			if(hasSubject) {
				response.appendContentString("&");
			} else {
				response.appendContentString("?");
			}
			response.appendContentString("body=");
			response.appendContentString(_escapedString(stringValueForBinding("body", component)));
		}
		response.appendContentString("\"");
		if(hasBinding("class") && valueForBinding("class", component) != null) {
			response.appendContentString(" class = \"");
			response.appendContentString(stringValueForBinding("class", component));
			response.appendContentString("\"");
		}
		if(hasBinding("style") && valueForBinding("style", component) != null) {
			response.appendContentString(" style = \"");
			response.appendContentString(stringValueForBinding("style", component));
			response.appendContentString("\"");
		}
		if(hasBinding("id") && valueForBinding("id", component) != null) {
			response.appendContentString(" id = \"");
			response.appendContentString(stringValueForBinding("id", component));
			response.appendContentString("\"");
		}
		response.appendContentString(">");
		response.appendContentString(stringValueForBinding("contact", component));
		response.appendContentString("</a>");
		response.appendContentString("</noscript>");
	}
	
	
	private String _escapedString(String unescapedString) {
		StringBuilder sb = new StringBuilder();
		String[] components = unescapedString.split(" ");
		for(String component : components) {
			sb.append(component).append("%20");
		}
		return sb.toString();
	}
	

}