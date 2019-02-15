package com.oracle.hadoop.util;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class HdfsMkdir {

    public static void main(String []args) {
        BasicConfigurator.configure();
        String newDir = "MyNewDir";

        String uri = "hdfs://localhost:9000/"+newDir;
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(uri), conf);
            boolean respond = fs.mkdirs(new Path(uri));
            System.out.println("Status of the given directory is "+respond);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
