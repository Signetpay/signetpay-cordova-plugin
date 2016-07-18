# signetpay-cordova-plugin
Official Cordova plugin for integrating Signet Payment Gateway. (Only Android OS Support)

How to guide:
### Install the plugin
```sh
$ cd your_cordova_project_folder
$ cordova plugin add https://github.com/Signetpay/signetpay-cordova-plugin.git --save
```

### Integration codes for Cordova Application
##### Note: 
- Following code sinppet can be added to your Cordova application after 'deviceready' event
- You should follow the documentation before making valid payment request 


```sh
      var paymentRequest = {
            payId			    :  '1607061625198989',
            orderId			    :  'CordovaOrder123',
            customerName	    :  'your customer name',
            customerPhone	    :  '987654321',
            customerEmail	    :  'name@domain.com',
            currencyCode	    :  '356',
            productDesc		    :  'Signetpay Cordova Plugin',
            txnType			    :  'SALE',
            productAmount	    :  '200',
            secretKey		    :  '2734814a0225210',
            sdkMode             :  1,
            flagMerchantHosted  :  false
        }

var successCallback = function(jsonResponse) {
    //console.log('response: ' + jsonResponse);
    //write your own logic
}

var errorCallback = function(error) {
    //console.log('error: '+error);
}
SignetPaymentProcessor.process(paymentRequest, successCallback, cancelCallback);
```
### Important 

- Add following codes to the file 'MainActivty.java' in your Cordova application
```sh
//imports
import com.signetpay.android.ResponseParams;
import com.signetpay.cordova.ResponseHandler;

//method
 public void processResult(ResponseParams responseParams, boolean securityFlag, boolean userCancelFlag) {
        ResponseHandler.getObject().handleResponse(responseParams, securityFlag, userCancelFlag);
    }
```
- Add following codes to 'AndroidManifest.xml'
```sh
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 
    <application android:theme="@style/AppTheme" ----------------->
    --
    --
    </application>
```
- You need to declare this 'AppTheme' in the file 'styles.xml' in android platorm of your Cordova application.
- Add following codes in styles.xml
```sh
<resources>
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">#bf0a0a</item>
        <item name="colorPrimaryDark">#090f33</item>
        <item name="colorAccent">#FF4081</item>
    </style>
</resources>
```
