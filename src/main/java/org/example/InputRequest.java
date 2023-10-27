package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputRequest {
    String status;
    String action;
    String queryString;
    Map<String, String> paramsMap;



    // ex: 삭제?id=3&type=ai&save=true
    InputRequest(String status) {
        paramsMap = new HashMap<>();

        this.status = status;

        String[] statusSplit = status.split("\\?", 2);
        action = statusSplit[0].trim();

        if (statusSplit.length == 1) {
            return;
        }

        queryString = statusSplit[1].trim();

        String[] queryStringSplit = queryString.split("&");

        for (int i = 0; i < queryStringSplit.length; i++) {
            String queryParamString = queryStringSplit[i];
            String[] queryParamStringSplit = queryParamString.split("=");

            String paramName = queryParamStringSplit[0];
            String paramValue = queryParamStringSplit[1];

            paramsMap.put(paramName, paramValue);
        }
    }

    String getAction() {
        return action;
    }

    public int getIndexByParam(String paramName, int defaultValue) {
        String paramValue = paramsMap.get(paramName);

        if (paramValue != null) {
            try {
                return Integer.parseInt(paramValue);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

}
