/**
 * JTNC JavaScript library for easy communication
 * with Java level extensions.  This includes a wrapper
 * for all calls to JTNC extensions, some common transactions
 * are canned for convenience, etc.
 */

var jtnc = {
	// types of calls allowed to jtnc java layer
	callType: { 
		SYSTEM : 1,
		EXTENSION : 2
	}
};

/**
 * Call data should include:
 *   - (String) extensionName
 *   - (String) actionName
 *   - (Object[]) arguments
 *   - (Boolean) isAsync (default is false)
 *     -- (String) progress (callback to progress handler, only for async calls)
 *     -- (String) error (callback to error handler, only for async calls)
 *     -- (String) success (callback to success handler, only for async calls)
 */
jtnc.callExtension = function(callData) {
	JTNC_sendMessage(jtnc.callType.EXTENSION, callData);
};

jtnc.systemInfo = function() {
	// return sysinfo object
};
