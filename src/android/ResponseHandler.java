package com.signetpay.cordova;

import android.util.Log;
import com.signetpay.android.ResponseParams;
import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseHandler {
    private CallbackContext callbackContext;
    private static ResponseHandler responseHandlerObject;

    private ResponseHandler(){}

    public static ResponseHandler getInstance(){
        responseHandlerObject = new ResponseHandler();
        return responseHandlerObject;
    }

    public static ResponseHandler getObject(){
        return responseHandlerObject;
    }

    public void setCallbackContext(CallbackContext callbackContext){
        this.callbackContext = callbackContext;
    }

    public void handleResponse(ResponseParams responseParams, boolean securityFlag, boolean userCancelFlag) {
        JSONObject responseObject = new JSONObject();
        try{
            if(responseParams!=null){
                responseObject.put("payId", responseParams.getPayId());
                responseObject.put("orderId", responseParams.getOrderId());
                responseObject.put("txnType", responseParams.getTxnType());
                responseObject.put("productAmount", responseParams.getProductAmount());
                responseObject.put("currencyCode", responseParams.getCurrencyCode());
                responseObject.put("txnId", responseParams.getTxnId());
                responseObject.put("responseCode", responseParams.getResponseCode());
                responseObject.put("responseMessage", responseParams.getResponseMessage());
                responseObject.put("authCode", responseParams.getAuthCode());
                responseObject.put("rrn", responseParams.getRrn());
                responseObject.put("status", responseParams.getStatus());
                responseObject.put("customerEmail", responseParams.getCustomerEmail());
                responseObject.put("productDesc", responseParams.getProductDesc());
                responseObject.put("responseDateTime", responseParams.getResponseDateTime());
            }
            responseObject.put("securityFlag", securityFlag);
            responseObject.put("userCancelFlag", userCancelFlag);
            callbackContext.success(responseObject.toString());
        }catch (JSONException e){
            Log.d(SignetPaymentProcessor.TAG_NAME, "Internal System Exception :"+e);
            callbackContext.error(responseObject.toString());
        }
    }
}
