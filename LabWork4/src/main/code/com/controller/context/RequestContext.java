package main.code.com.controller.context;

import java.util.HashMap;
import java.util.Map;

public class RequestContext {
    private Map<String, String> requestParameters;
    private Map<String, Object> requestAttributes;
    private Map<String, Object> sessionAttributes;

    RequestContext(Map<String, String> requestParameters, Map<String, Object> requestAttributes, Map<String, Object> sessionAttributes) {
        this.requestParameters = requestParameters;
        this.requestAttributes = requestAttributes;
        this.sessionAttributes = sessionAttributes;
    }

    public Map<String, Object> getAllRequestAttributes() {
        return new HashMap<String, Object>(requestAttributes);
    }

    public Map<String, Object> getAllSessionAttributes() {
        return new HashMap<String, Object>(sessionAttributes);
    }

    public void addSessionAttribute(String key, Object value) {
        sessionAttributes.put(key, value);
    }

    public Object getSessionAttribute(String key) {
        return sessionAttributes.get(key);
    }

    public String getRequestParameter(String key) {
        return requestParameters.get(key);
    }

    public void addRequestParameter(String key, String value) {
        requestParameters.put(key, value);
    }

    public Object getRequestAttribute(String key) {
        return requestAttributes.get(key);
    }

    public void removeRequestParameter(String key) {
        requestParameters.put(key, null);
    }

    public void addRequestAttribute(String key, Object value) {
        requestAttributes.put(key, value);
    }

    public void removeSessionAttribute(String key) {
        sessionAttributes.put(key, null);
    }
}