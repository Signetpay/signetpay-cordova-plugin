package com.signetpay.cordova;

import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.signetpay.android.PaymentParams;
import com.signetpay.android.PaymentProcessor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignetPaymentProcessor extends CordovaPlugin {
    public static String TAG_NAME = "Signetpay Cordova Plugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("process")) {
            JSONObject jsonObject = args.getJSONObject(0);
            PaymentParams paymentParams = new PaymentParams();
            ResponseHandler responseHandler = ResponseHandler.getInstance();
            responseHandler.setCallbackContext(callbackContext);
            paymentParams.setPayId(jsonObject.getString("payId"));
            paymentParams.setOrderId(jsonObject.getString("orderId"));
            paymentParams.setCustomerName(jsonObject.getString("customerName"));
            paymentParams.setCustomerPhone(jsonObject.getString("customerPhone"));
            paymentParams.setCustomerEmail(jsonObject.getString("customerEmail"));
            paymentParams.setCurrencyCode(jsonObject.getString("currencyCode"));
            paymentParams.setProductDesc(jsonObject.getString("productDesc"));
            paymentParams.setTxnType(jsonObject.getString("txnType"));
            paymentParams.setProductAmount(jsonObject.getString("productAmount"));
            paymentParams.setKey(jsonObject.getString("secretKey"));
            PaymentProcessor processor = new PaymentProcessor();
            processor.process(this.cordova.getActivity(),paymentParams, jsonObject.getInt("sdkMode"),jsonObject.getBoolean("flagMerchantHosted"));
            return true;
        }
        Log.e(SignetPaymentProcessor.TAG_NAME, "Internal System Exception");
        return false;
    }
}
