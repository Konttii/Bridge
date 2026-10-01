package org.example;

public class DatabaseBackup extends StorageResource {
    private String dbName;
    private String rawSqlDump;

    public DatabaseBackup(CloudProvider provider, String dbName, String rawSqlDump){
        super(provider);
        this.dbName = dbName;
        this.rawSqlDump = rawSqlDump;
    }

    @Override
    public void processAndSave(){
        System.out.println("Processing DatabaseBackup for: " + dbName);
        System.out.println("- Zipping raw SQL dump...");
        System.out.println("- Encrypting zip file...");

        String fileName = dbName + "_backup_" + System.currentTimeMillis() + ".zip";
        provider.store(fileName, rawSqlDump);

    }
}
