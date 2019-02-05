package com.oracle.hadoop.client;

import com.oracle.hadoop.bean.IngestionInputEvents;
import com.oracle.hadoop.util.JsonUtil;


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

        IngestionInputEvents call = new IngestionInputEvents();
        call.setName("smbDistCp2");
        //How can I set the Metadata?
//        call.setMetadata("");
        //How can I set the Properties
        String jsonCall = JsonUtil.convertJavaToJson(call);

        System.out.println(jsonCall);

        System.out.println("=============================================================================");

        IngestionInputEvents call1 = JsonUtil.convertJsonToJava(jsonCall, IngestionInputEvents.class);
        System.out.println(call1.getName()+" "+call1.getMetadata()+" "+call1.getProperties());
    }

}