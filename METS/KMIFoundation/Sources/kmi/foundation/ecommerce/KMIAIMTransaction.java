package kmi.foundation.ecommerce;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.foundation.ERXStringUtilities;


public class KMIAIMTransaction {

    private static final String NET_AUTHORIZE_PAYMENT_GATEWAY_KEY = "net.authorize.paymentGateway";
    private static final String NET_AUTHORIZE_TEST_REQUEST_KEY = "net.authorize.testRequest";
    private static final String NET_AUTHORIZE_VERSION_KEY = "net.authorize.version";
    private static final String NET_AUTHORIZE_PASSWORD_KEY = "net.authorize.password";
    private static final String NET_AUTHORIZE_TRANSACTION_KEY = "net.authorize.transactionKey";
    private static final String NET_AUTHORIZE_LOGIN_KEY = "net.authorize.login";
    private final static String DELIM_CHAR = "|";
    
    private KMIAIMCustomer _customer;
	private KMIAIMCustomer _shippingAddress;
    private KMIAIMTransactionResponse _response;
    private KMICreditCard _creditCard;
    private String _login;
    private String _transactionKey;
    private String _password;
    private String _version;
    private String _testRequest;
    private String _paymentGateway;
    private String _transactionDescription;
    private String _method;
    private String _transactionType;
    private Double _amount;

    public KMIAIMTransaction() {
    	this._login = System.getProperty(NET_AUTHORIZE_LOGIN_KEY);
    	this._transactionKey = System.getProperty(NET_AUTHORIZE_TRANSACTION_KEY);
    	this._password = System.getProperty(NET_AUTHORIZE_PASSWORD_KEY);
    	this._version = System.getProperty(NET_AUTHORIZE_VERSION_KEY);
    	this._testRequest = System.getProperty(NET_AUTHORIZE_TEST_REQUEST_KEY);
    	this._paymentGateway = System.getProperty(NET_AUTHORIZE_PAYMENT_GATEWAY_KEY);
    }

    public KMIAIMTransaction(String login,
            String transactionKey,
            String password,
            String version,
            String testRequest) {
    	
    	this._login = login;
    	this._transactionKey = transactionKey;
    	this._password = password;
    	this._version = version;
    	this._testRequest = testRequest;
    	
    }


    private NSDictionary<String, Object> _transactionDictionary() throws NullPointerException {

         if(null == customer()) {
              throw new NullPointerException("A customer must be defined to set up the transaction dictionary");
         }
         
         if(null == creditCard()) {
              throw new NullPointerException("A credit card must be defined to set up the transaction dictionary");
         }

         NSMutableDictionary<String, Object> transactionDictionary = new NSMutableDictionary<String, Object>();
         transactionDictionary.takeValueForKey(login(), "x_login");
         transactionDictionary.takeValueForKey(transactionKey(), "x_tran_key");
         transactionDictionary.takeValueForKey(password(), "x_password");
         transactionDictionary.takeValueForKey(version(), "x_version");
         transactionDictionary.takeValueForKey(testRequest(), "x_test_request");
         
         transactionDictionary.takeValueForKey(amount(), "x_amount");
         transactionDictionary.takeValueForKey(method(), "x_method");
         transactionDictionary.takeValueForKey(transactionType(), "x_type");

         // I don't see a need to be able to configure these options.
         transactionDictionary.takeValueForKey(Boolean.TRUE, "x_delim_data");
         transactionDictionary.takeValueForKey(DELIM_CHAR, "x_delim_char");
         transactionDictionary.takeValueForKey(Boolean.FALSE, "x_relay_response");

         transactionDictionary.takeValueForKey(customer().firstName(), "x_first_name");
         transactionDictionary.takeValueForKey(customer().lastName(), "x_last_name");
         transactionDictionary.takeValueForKey(customer().address(), "x_address");
         transactionDictionary.takeValueForKey(customer().city(), "x_city");
         transactionDictionary.takeValueForKey(customer().region(), "x_state");
         transactionDictionary.takeValueForKey(customer().country(), "x_country");
         transactionDictionary.takeValueForKey(customer().zipCode(), "x_zip");
         transactionDictionary.takeValueForKey(customer().phone(), "x_phone");
         transactionDictionary.takeValueForKey(customer().email(), "x_email");
         
         transactionDictionary.takeValueForKey(creditCard().creditCardNumber(), "x_card_num");
         transactionDictionary.takeValueForKey(creditCard().expirationDate(), "x_exp_date");
         transactionDictionary.takeValueForKey(creditCard().securityID(), "x_card_code");

         if(ERXStringUtilities.stringIsNullOrEmpty(transactionDescription()) == false) {
             transactionDictionary.takeValueForKey(transactionDescription(), "x_description");
         }
         
         if(shippingAddress() != null) {
        	 
             transactionDictionary.takeValueForKey(shippingAddress().firstName(), "x_ship_to_first_name");
             transactionDictionary.takeValueForKey(shippingAddress().lastName(), "x_ship_to_last_name");
             transactionDictionary.takeValueForKey(shippingAddress().address(), "x_ship_to_address");
             transactionDictionary.takeValueForKey(shippingAddress().city(), "x_ship_to_city");
             transactionDictionary.takeValueForKey(shippingAddress().region(), "x_ship_to_state");
             transactionDictionary.takeValueForKey(shippingAddress().country(), "x_ship_to_country");
             transactionDictionary.takeValueForKey(shippingAddress().zipCode(), "x_ship_to_zip");

         }
         
         return transactionDictionary;
    
    }
    
    public void processTransaction() throws MalformedURLException, IOException, NullPointerException {
         
         URLConnection connection = _connection();
         DataOutputStream out = new DataOutputStream(connection.getOutputStream());
         out.write(_request().getBytes());
         out.flush();
         out.close();
         setResponse(connection);
    }
    
    private void setResponse(URLConnection connection) throws IOException {
         BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         String rawResponse = in.readLine();
         in.close();
         setResponse(new KMIAIMTransactionResponse(DELIM_CHAR, rawResponse));
    }

    private String _request() throws NullPointerException {
         StringBuilder request = new StringBuilder();
         for(String key : _transactionDictionary().allKeys()) {
              request.append(key).append("=").append(_transactionDictionary().valueForKey(key));
              if(! _transactionDictionary().allKeys().lastObject().equals(key)) {
                   request.append("&");
              }
         }
         return request.toString();
    }

    private URLConnection _connection() throws MalformedURLException, IOException {
         URL url = new URL(paymentGateway());
         URLConnection connection = url.openConnection();
         connection.setDoOutput(true);
         connection.setUseCaches(false);
         connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         return connection;
    }
    
    public void setCustomer(KMIAIMCustomer customer) {
         this._customer = customer;
    }

    public KMIAIMCustomer customer() {
         return _customer;
    }

    public void setCreditCard(KMICreditCard creditCard) {
         this._creditCard = creditCard;
    }

    public KMICreditCard creditCard() {
         return _creditCard;
    }

    public void setLogin(String login) {
         this._login = login;
    }

    public String login() {
         return _login;
    }

    public void setTransactionKey(String transactionKey) {
         this._transactionKey = transactionKey;
    }

    public String transactionKey() {
         return _transactionKey;
    }

    public void setPassword(String password) {
         this._password = password;
    }

    public String password() {
         return _password;
    }

    public void setVersion(String version) {
         this._version = version;
    }

    public String version() {
         return _version;
    }

    public void setTestRequest(String testRequest) {
         this._testRequest = testRequest;
    }

    public String testRequest() {
         return _testRequest;
    }

    public void setMethod(String method) {
         this._method = method;
    }

    /*
     * can be one of two values CC or ECHECK
     */
    public String method() {
         if(_method == null) _method = "CC";
         return _method;
    }

    public void setTransactionType(String transactionType) {
         this._transactionType = transactionType;
    }

    /*
     *  can be one of these values: AUTH_CAPTURE, AUTH_ONLY, CAPTURE_ONLY, CREDIT, PRIOR_AUTH_CAPTURE, VOID
     */
    public String transactionType() {
         if(_transactionType == null) _transactionType = "AUTH_CAPTURE";
         return _transactionType;
    }

    public void setAmount(Double amount) {
         this._amount = amount;
    }

    public Double amount() {
         return _amount;
    }

    public void setResponse(KMIAIMTransactionResponse response) {
         this._response = response;
    }

    public KMIAIMTransactionResponse response() {
         return _response;
    }

    public void setPaymentGateway(String paymentGateway) {
         this._paymentGateway = paymentGateway;
    }

    public String paymentGateway() {
         return _paymentGateway;
    }

	public String transactionDescription() {
		return _transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this._transactionDescription = transactionDescription;
	}
	
	public KMIAIMCustomer shippingAddress() {
		return _shippingAddress;
	}

	public void setShippingAddress(KMIAIMCustomer shippingAddress) {
		// TODO Auto-generated method stub
		
	}
    
}
