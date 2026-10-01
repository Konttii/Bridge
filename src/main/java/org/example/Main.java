package org.example;

public class Main{
    public static void main(String[] args){
        System.out.println("=== BRIDGE PATTERN DEM0NSTRATION ===\n");

    CloudProvider aws = new AWSCloudProvider();
    CloudProvider local = new LocalServerProvider();

    StorageResource avatar = new UserAvatar(aws, "konti", "pixel_data_2008020");

    avatar.processAndSave();

    avatar.changeProvider(local);
    avatar.processAndSave();

    System.out.println("------------------------------------------------\n");

    StorageResource backup = new DatabaseBackup(local, "main_production_db", "INSERT INTO users...");

    backup.processAndSave();
    backup.changeProvider(aws);
    backup.processAndSave();

    }
}