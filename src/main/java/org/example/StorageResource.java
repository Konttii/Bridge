package org.example;

public abstract class StorageResource {

    protected CloudProvider provider;

    public StorageResource(CloudProvider provider){
        this.provider = provider;
    }

    public void changeProvider(CloudProvider newProvider){
        System.out.println(">>> Switching storage provider at runtime...");
        this.provider = newProvider;
    }

    public abstract void processAndSave();
}
