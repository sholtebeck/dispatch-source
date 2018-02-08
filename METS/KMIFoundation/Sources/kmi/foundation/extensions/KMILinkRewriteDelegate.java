package kmi.foundation.extensions;

import com.webobjects.foundation.NSDictionary;

public interface KMILinkRewriteDelegate {
	public String rewriteUrl(NSDictionary<String, Object> queryParameters);	
}
