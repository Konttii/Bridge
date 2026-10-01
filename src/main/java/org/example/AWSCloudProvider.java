package org.example;

public class AWSCloudProvider implements CloudProvider {
    @Override
    public void store(String fileName, String data){
        System.out.println("[AWS S3] Uploading file" + fileName);
        System.out.println("[AWS S3] Data size: " + data.length() + "bytes. Status: SUCCESS.\n");
    }
}
