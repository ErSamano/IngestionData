package com.oracle.hadoop.util;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class HdfsCat {

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
    }
}
