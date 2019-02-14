package com.oracle.hadoop.client;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.oracle.hadoop.bean.IngestionInputEvents;
import com.oracle.hadoop.util.HadoopUtil;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.List;




/*
 HDFS is going to have four folders, inputFolder, queueFolder, outputFolder and dataFolder

 1.- Create a HdfsUtil.class in the Util folder for the methods we need to call for HDFS Input / Output

 2.- Read from the inputFolder (Parse the JSON format into a POJO)
 3.- Move it into the queue following the next set of rules:
    3.1.- The Queue folder only can be 2 workflows
    3.2.- Check the field "PATHS" to avoid any duplication or reworking from input JSON folder, for exmple:
        3.2.1.- Check first in HDFS, if that "path/folder/file" is already there fail the action if not continue
        3.2.2.- Check in the "path/folder/file" in the queue, if is already there fail the action if not continue
    3.3.- Don't copy any folder that is already in HDFS.
 4.- Save it in HDFS in a propertly format (JSON format) in the outputFolder.

*/


public class Test {

    public static void main(String []args) {

        //HadoopUtil test = new HadoopUtil();
        //test.CatFileFromHdfs("/user/oozie/");
        //test.CatFileFromHdfs("/user/vs485e/Lab01/data.json");
        //test.GetFilesFromHdfs("data.json", "/user/vs485e/Lab01/","/Users/ernestosamanom/IdeaProjects/IngestionData/src/main/java/com/oracle/hadoop/bean/");
        //test.ListFilesFromHdfs("/user/vs485e/Lab01/");

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