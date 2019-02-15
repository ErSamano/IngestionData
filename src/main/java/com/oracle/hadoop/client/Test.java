package com.oracle.hadoop.client;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.oracle.hadoop.util.HadoopUtil;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Test {

    public static void main(String []args) {

        HadoopUtil test = new HadoopUtil();
        test.CatFileFromHdfs("/user/oozie/");
        test.CatFileFromHdfs("/user/vs485e/Lab01/data.json");
        test.ListFilesFromHdfs("/user/vs485e/Lab01/");

        try {
            ObjectMapper mapper = new ObjectMapper();
            File myFile = new File("/Users/ernestosamanom/IdeaProjects/IngestionData/src/main/java/com/oracle/hadoop/bean/inputData.json");
            JsonNode node = mapper.readTree(myFile);
            System.out.println(node.get("IngestionInputEvents").get("properties").get("sambaShareName").textValue());


            Iterator<JsonNode> elements = node.get("IngestionInputEvents").get("properties").get("sambaShareDirectories").elements();
            while (elements.hasNext()) {
                System.out.println(elements.next().textValue());
            }
            ((ObjectNode) node.get("IngestionInputEvents").get("properties")).put("sambaShareName", "External_Share_02");
            System.out.println(node.toString());

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}