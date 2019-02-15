# IngestionData

HDFS is going to have four folders, inputFolder, queueFolder, outputFolder and dataFolder

* Create a HdfsUtil.class in the Util folder for the methods we need to call for HDFS Input / Output
* Read from the inputFolder (Parse the JSON format into a POJO)
* Move it into the queue following the next set of rules:
* The Queue folder only can be 2 workflows
* Check the field "PATHS" to avoid any duplication or reworking from input JSON folder, for exmple:
* Check first in HDFS, if that "path/folder/file" is already there fail the action if not continue
* Check in the "path/folder/file" in the queue, if is already there fail the action if not continue
* Don't copy any folder that is already in HDFS.
* Save it in HDFS in a propertly format (JSON format) in the outputFolder.
