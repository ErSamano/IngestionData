package com.oracle.hadoop.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }
    public static String convertJavaToJson(Object object){

        String jsonResult = "";
        try {
            jsonResult = mapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            System.out.println("Exception occured while converting Java Object into Json: "+e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Exception occured while converting Java Object into Json: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception occured while converting Java Object into Json: "+e.getMessage());
        }

        return jsonResult;
    }

    public static <T> T convertJsonToJava(String jsonString,Class<T> cls){

        T result = null;
        try {
            result = mapper.readValue(jsonString, cls);
        } catch (JsonParseException e) {
            System.out.println("Exception occcured while converting JSON into Java: "+e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Exception occcured while converting JSON into Java: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception occcured while converting JSON into Java: "+e.getMessage());
        }
        return result;
    }

}
