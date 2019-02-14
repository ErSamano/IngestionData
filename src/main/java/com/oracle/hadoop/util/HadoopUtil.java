package com.oracle.hadoop.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.log4j.BasicConfigurator;

public class HadoopUtil {

    /*
    Needs to create a global variable to handle hdfs address
     */

    public String CatFileFromHdfs(String path){

        String filePath="hdfs://localhost:9000"+path;

        BasicConfigurator.configure();
        Configuration conf = new Configuration();
        InputStream in = null;
        try {
            FileSystem fs = FileSystem.get(URI.create(filePath), conf);
            in = fs.open(new Path(filePath));
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
        return null;
    }

    public String ListFilesFromHdfs(String pathToList){
        BasicConfigurator.configure();

        String uri = "hdfs://localhost:9000/"+pathToList;
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
        return null;
    }

    public String MakeDirInHdfs(String pathForDir, String newDir){
        BasicConfigurator.configure();

        String uri = "hdfs://localhost:9000/"+pathForDir+"/"+newDir;
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(uri), conf);
            boolean respond = fs.mkdirs(new Path(uri));
            System.out.println("Status of the given directory is "+respond);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String PutLocalFilesInHdfs(String localPathFile, String destinationPathOnHdfs){
        BasicConfigurator.configure();

//        String fileLocalPath="/home/user/data.json";
//        String destinationPath = "MyNewDir";
        String uri = "hdfs://localhost:9000/"+destinationPathOnHdfs;
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(uri), conf);
            fs.copyFromLocalFile(true, new Path(localPathFile), new Path(uri));
            //No using serialization or de-serialization
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String GetFilesFromHdfs(String nameFile, String sourcePath, String destinationPath){
        BasicConfigurator.configure();
        //String destinationPath="/home/user/";
        String uri = "hdfs://localhost:9000/"+sourcePath+nameFile;
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(uri), conf);
            fs.copyToLocalFile(new Path(uri), new Path(destinationPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String RemoveFilesFromHdfs(String fileName, String pathFile){
        BasicConfigurator.configure();
        //String fileName="someFile";
        //String destinationPath = "MyNewDir/";
        String uri = "hdfs://localhost:9000/"+pathFile+fileName;

        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(uri), conf);
            fs.delete(new Path(uri), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

