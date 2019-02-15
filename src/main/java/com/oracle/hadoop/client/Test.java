package com.oracle.hadoop.client;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.hadoop.bean.IngestionInputEvents;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.BasicConfigurator;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import static org.apache.hadoop.fs.FileSystem.get;



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

        /*..::How can I create a method to invoke this call to hdfs::..*/
        BasicConfigurator.configure();
        String uri = "hdfs://localhost:9000/user/vs485e/Lab01/data.json";
        Configuration conf = new Configuration();
        InputStream in = null;

        try {
            FileSystem fs = FileSystem.get(URI.create(uri), conf);
            in = fs.open(new Path(uri));
            //CAT command
            IOUtils.copyBytes(in, System.out, 4096, false);
            //End CAT command
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
 
        IngestionInputEvents mycall = new IngestionInputEvents();
        call.setName("smbDistCp2");
        call.getMetadata().setDataFunctionType("Wind Tunnel");
        //call.setProperties().setSambaShareServer("fs-pt-oracle.com");

        //How can I set the Properties
        String jsonCall = JsonUtil.convertJavaToJson(call);

        System.out.println(jsonCall);

        System.out.println("=======================================================================");

        IngestionInputEvents call1 = JsonUtil.convertJsonToJava(jsonCall, IngestionInputEvents.class);
        System.out.println(call1.getName()+" "+call1.getMetadata()+" "+call1.getProperties());
    }
}
