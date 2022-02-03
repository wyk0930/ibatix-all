package com.ibatix.sample;

import java.io.FileWriter;
import java.text.MessageFormat;

public class HostFileCreatorSample {
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("D:/hosts.txt");
        String template = "192.168.7.{0}  \tnode{1}.vm.local";
        for (int i = 2; i < 255; i++) {
            String[] arr = new String[2];
            arr[0] = String.valueOf(i);
            arr[1] = String.format("%03d", i);
            String record = MessageFormat.format(template, arr);
            fileWriter.write(record);
            fileWriter.write("\r\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
