package kmi.foundation.ecommerce;

import java.util.Vector;

public class KMIAIMTransactionResponse {

    private static final int AVS_RESPONSE_INDEX = 5;
    private static final int RESPONSE_REASON_INDEX = 3;
    private static final int RESPONSE_REASON_CODE_INDEX = 2;
    private static final int RESPONSE_CODE_INDEX = 0;
    private static final String APPROVED = "1";
    private static final String DECLINED = "2";
    private static final String ERROR = "3";
    private static final String HELD_FOR_REVIEW = "4";
    
    private String _responseCode;
    private String _responseReason;
    private String _responseReasonCode;
    private String _avsResponse;

    public KMIAIMTransactionResponse() {
    	
    }
    
    public KMIAIMTransactionResponse(String delimChar, String rawResponse) {
        Vector<String> responseVector = _split(delimChar, rawResponse); 
        setResponseCode(responseVector.elementAt(RESPONSE_CODE_INDEX));
        setResponseReasonCode(responseVector.elementAt(RESPONSE_REASON_CODE_INDEX));
        setResponseReason(responseVector.elementAt(RESPONSE_REASON_INDEX));
        setAvsResponse(responseVector.elementAt(AVS_RESPONSE_INDEX));
    }
    
    private Vector<String> _split(String pattern, String in) {
         int s1=0, s2=-1;
         Vector<String> out = new Vector<String>(30);
         while(true) {
              s2 = in.indexOf(pattern, s1);
              if(s2 != -1) {
                   out.addElement(in.substring(s1,s2));
              } else {
                   String _ = in.substring(s1);
                   if(_ != null && !_.equals("")) {
                        out.addElement(_);
                   }
                   break;
              }
              s1 = s2;
              s1 += pattern.length();
         }
         return out;
    }

    public boolean wasApproved() {
         return responseCode().equals(APPROVED);
    }
    
    public boolean wasDeclined() {
         return responseCode().equals(DECLINED);
    }

    public boolean wasProcessingError() {
         return responseCode().equals(ERROR);
    }

    public boolean wasHeldForReview() {
         return responseCode().equals(HELD_FOR_REVIEW);
    }
    
    private void setResponseCode(String responseCode) {
         this._responseCode = responseCode;
    }

    private String responseCode() {
         return _responseCode;
    }

    public void setResponseReason(String responseReason) {
         this._responseReason = responseReason;
    }

    public String responseReason() {
         return _responseReason;
    }

    private void setResponseReasonCode(String responseReasonCode) {
         this._responseReasonCode = responseReasonCode;
    }
    
    @SuppressWarnings("unused")
    private String responseReasonCode() {
         return _responseReasonCode;
    }

    private void setAvsResponse(String avsResponse) {
         _avsResponse = avsResponse;
    }

    private String _avsResponse() {
         return _avsResponse;
    }
    
    public String avsResponse() {
         String avsResponse = "";
         if(_avsResponse() != null) {
              switch (_avsResponse().toCharArray()[0]) {
              case 'A':
                   avsResponse = "Address (Street) matches, ZIP does not";
                   break;
              case 'B':
                   avsResponse = "Address information not provided for AVS check";
                   break;
              case 'E':
                   avsResponse = "AVS error";
                   break;
              case 'G':
                   avsResponse = "Non-U.S. Card Issuing Bank";
                   break;
              case 'N':
                   avsResponse = "No Match on Address (Street) or ZIP";
                   break;
              case 'P':
                   avsResponse = "AVS not applicable for this transaction";
                   break;
              case 'R':
                   avsResponse = "Retry – System unavailable or timed out";
                   break;
              case 'S':
                   avsResponse = "Service not supported by issuer";
                   break;
              case 'U':
                   avsResponse = "Address information is unavailable";
                   break;
              case 'W':
                   avsResponse = "Nine digit ZIP matches, Address (Street) does not";
                   break;
              case 'X':
                   avsResponse = "Address (Street) and nine digit ZIP match";
                   break;
              case 'Y':
                   avsResponse = "Address (Street) and five digit ZIP match";
                   break;
              case 'Z':
                   avsResponse = "Five digit ZIP matches, Address (Street) does not";
                   break;
              default:
                   break;
              }
         }
         
         return avsResponse;
    }


}
