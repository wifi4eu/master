(function () {
    var OPENID_LOGIN_CONFIGURATION_URL = "assets/openid-login-config." + OPENID_LOGIN_ENVIRONMENT + ".json";
    var SESSION_STORAGE_KEY_ID_TOKEN = 'ux-openid-connect-id-token';
    var SESSION_STORAGE_KEY_USER_DETAILS = 'ux-openid-connect-user-details';
    var REQUEST_PARAMETER_ORIGINAL_URL = 'ux-openid-connect-original-url';
    
    var openidLoginConfig = null;

    function loadConfiguration(configurationLoader) {
        var request = new XMLHttpRequest();
        request.open("GET", OPENID_LOGIN_CONFIGURATION_URL, false);  // false means synchronous request
        request.send(null);
        if (request.status === 200) {
            openidLoginConfig = JSON.parse(request.responseText);
        }
    }

    function extractIdTokenFromLocation() {
        var hash = window.location.hash;

        var idTokenIndex = hash.indexOf('#id_token=');
        if (idTokenIndex < 0) {
            idTokenIndex = hash.indexOf('&id_token=');
        }

        if (idTokenIndex >= 0) {
            return hash.substr(idTokenIndex).split('&')[0].split('=')[1];
        } else {
            return undefined;
        }
    }

    function getRequestParameter(name) {
        if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(window.location.search)) {
            return decodeURIComponent(name [1]);
        } else {
            return null;
        }
    }

    function renewIdToken() {
        // Check for errors first:
        var search = window.location.search;
        if (search.indexOf('?error=invalid_client') < 0 && search.indexOf('&error=invalid_client') < 0) {
            var nounce = new Date().getTime();

            window.location.href = openidLoginConfig.openIdConnect.authorizeUrl +
                '?client_id=' + openidLoginConfig.openIdConnect.spaClientId +
                '&response_type=id_token&scope=openid profile email' +
                '&redirect_uri=' + encodeURIComponent(openidLoginConfig.openIdConnect.spaRedirectUrl) + "?" + encodeURIComponent(REQUEST_PARAMETER_ORIGINAL_URL) + "=" + encodeURIComponent(window.location.href) +
                '&nonce=' + nounce;
        } else {
            throw 'EU Login does not recognise the application; please configure a proper OpenID Connect client ID.\n' +
            'This is configured in the spaClientId environment variable.';
        }
    }

    function saveUserToSessionStorage(idToken) {
        sessionStorage.setItem(SESSION_STORAGE_KEY_ID_TOKEN, idToken);
        var base64Url = idToken.split('.')[1];
        var base64 = base64Url.replace('-', '+').replace('_', '/');
        var tokenObject = JSON.parse(window.atob(base64));

        sessionStorage.setItem(SESSION_STORAGE_KEY_USER_DETAILS, JSON.stringify({
            departmentNumber: null,
            domain: tokenObject.domain,
            domainUsername: tokenObject.preferred_username,
            email: tokenObject.email,
            firstName: tokenObject.given_name,
            lastName: tokenObject.family_name
        }));
    }

    function removeLocationHash() {
        var location = window.location;
        if ('pushState' in history) {
            history.pushState('', document.title, location.pathname + location.search);
        } else {
            location.hash = '';
        }
    }

    function navigateToOriginallyRequestedUrl() {
        var originalUrl = getRequestParameter(REQUEST_PARAMETER_ORIGINAL_URL);
        if (originalUrl != null) {
            window.location.href = decodeURIComponent(originalUrl);
        }
    }

    function loginWithOpenIDConnect() {
        // First check if there is a new ID token coming back from EU Login:
        var idToken = extractIdTokenFromLocation();
        if (idToken != null) {
            saveUserToSessionStorage(idToken);
            navigateToOriginallyRequestedUrl();
            removeLocationHash();
        } else {
            // There is no new ID token; check if there is already one in the session storage:
            if (sessionStorage.getItem(SESSION_STORAGE_KEY_ID_TOKEN) == null) {
                renewIdToken();
            }
        }
    }

    try {
        loadConfiguration();
        if (openidLoginConfig.openIdConnect.enabled) {
            loginWithOpenIDConnect();
        }
    } catch (error) {}
})();