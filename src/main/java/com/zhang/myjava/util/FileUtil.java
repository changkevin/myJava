package com.zhang.myjava.util;


import java.io.File;
import java.util.LinkedList;

import org.apache.log4j.Logger;

public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	public static void traverseFolderIteration(String path) {
		int fileNum = 0, folderNum = 0;

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
            	log.info("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	log.info("文件夹:" + file2.getAbsolutePath());
                        folderNum++;
                        traverseFolderIteration(file2.getAbsolutePath());
                    } else {
                    	log.info("文件:" + file2.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
        	log.info("文件不存在!");
        }
        
        log.info("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
        
    }
	
	public static void traverseFolder(String path) {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                	log.info("文件夹:" + file2.getAbsolutePath());
                    list.add(file2);
                    folderNum++;
                } else {
                	log.info("文件:" + file2.getAbsolutePath());
                    fileNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	log.info("文件夹:" + file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
                    	log.info("文件:" + file2.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
        	log.info("文件不存在!");
        }
        log.info("文件夹共有:" + folderNum + ",文件共有:" + fileNum);

    }
	
	public static void main(String args[]) {
		String path = "E:\\矮大紧指北";
		FileUtil.traverseFolder(path);
	}
}
