package org.example;

public class UserAvatar extends StorageResource{
    private String username;
    private String imagePixels;

    public UserAvatar(CloudProvider provider, String username, String imagePixels){
        super(provider);
        this.username = username;
        this.imagePixels = imagePixels;
    }
    @Override
    public void processAndSave(){
        System.out.println("Processing YsrAvatar for: " + username);
        System.out.println("- Cropping image to 200x200...");
        System.out.println("- Compressing image quality...");

        String fileName = username + "_avtaar.jpg";
        provider.store(fileName, imagePixels);
    }
}
