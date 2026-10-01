package org.example;

public class LocalServerProvider implements CloudProvider {
    @Override
    public void store(String fileName, String data){
        System.out.println("[Local Server] Writing file dick: /var/storage/" + fileName);
        System.out.println("[Local Server] Data successfully saved to local HDD. \n");
    }
}
