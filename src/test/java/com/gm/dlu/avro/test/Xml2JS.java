package com.gm.dlu.avro.test;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Xml2JS {

    public static void main(String[] args) throws JSONException {
        String xmlStr = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
        JSONObject xmlJSONObj = XML.toJSONObject(xmlStr);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        System.out.println(jsonPrettyPrintString);
    }

}
