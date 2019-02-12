package com.oracle.hadoop.util;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class HdfsLs {

    public static void main(String []args) {
        BasicConfigurator.configure();
        String uri = "hdfs://localhost:9000/";
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(uri), conf);
            FileStatus[] files = fs.listStatus(new Path(uri));

            for(FileStatus file:files){
                System.out.println(file.getPath().getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
