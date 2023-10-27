package org.example;

import java.util.ArrayList;
import java.util.List;

public class InputRequest {
    String status;
    String action;
    String queryString;
    List<String> paramNames;
    List<String> paramValues;

    // ex: 삭제?id=3&type=ai&save=true
    InputRequest(String status) {
        paramNames = new ArrayList<>();
        paramValues = new ArrayList<>();

        this.status = status;

        String[] statusSplit = status.split("\\?", 2);
        action = statusSplit[0].trim();
        queryString = statusSplit[1].trim();

        String[] queryStringSplit = queryString.split("&");

        for (int i = 0; i < queryStringSplit.length; i++) {
            String queryParamString = queryStringSplit[i];
            String[] queryParamStringSplit = queryParamString.split("=");

            String paramName = queryParamStringSplit[0];
            String paramValue = queryParamStringSplit[1];

            paramNames.add(paramName);
            paramValues.add(paramValue);
        }
    }

    String getAction() {
        return action;
    }

    public int getIndexByParam(String paramName, int defaultValue) {
        int index = paramNames.indexOf(paramName);

        if (index == -1) {
            return defaultValue;
        }

        String paramValue = paramValues.get(index);

        try {
            return Integer.parseInt(paramValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}
