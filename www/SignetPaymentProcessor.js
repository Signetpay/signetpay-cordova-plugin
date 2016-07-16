var exec = require('cordova/exec');

exports.process = function(params, success, error) {
    exec(success, error, "SignetPaymentProcessor", "process", [params]);
};
