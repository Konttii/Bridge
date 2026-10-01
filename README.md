

# Assignment #3: Bridge Design Pattern 🌉

**Course:** Software Design Patterns (ShP-2216)  
**Institution:** Astana IT University  
**Topic:** Cloud Storage System (Option B - Free topic)

## About the Project
This project demonstrates the **Bridge Structural Design Pattern** in Java.

The domain of the project is a **Cloud Storage System**. In real backend development, we often need to save different types of files (like User Avatars or Database Backups) to different storage locations (like AWS Cloud or a Local Hard Drive).

### The Problem (Without Bridge)
If we use standard inheritance for 2 file types and 2 storage types, we would have to create 4 combined classes: `AwsAvatar`, `LocalAvatar`, `AwsBackup`, and `LocalBackup`. If we add a new storage type, the number of classes grows too fast. This is called "class explosion."

### The Solution (With Bridge)
The Bridge pattern separates the system into two independent parts:
1. **Abstraction** (WHAT we are saving)
2. **Implementation** (WHERE we are saving)

Instead of inheritance, we use **Composition**. The file (Abstraction) contains a reference to the storage (Implementation) and delegates the saving process to it. This is the "Bridge".

---

## Project Structure

### 1. The Implementation (Right side of the bridge)
This part handles the physical storage of data.
* `CloudProvider` - The main interface (Implementor).
* `AWSCloudProvider` - Simulates uploading files to Amazon S3.
* `LocalServerProvider` - Simulates writing files to a local disk.

### 2. The Abstraction (Left side of the bridge)
This part handles the business logic of the files.
* `StorageResource` - The abstract base class. It holds the `CloudProvider` variable (this is the bridge).
* `UserAvatar` - A refined abstraction. It crops and compresses the image, then uses the provider to save it.
* `DatabaseBackup` - A refined abstraction. It zips and encrypts the SQL dump, then uses the provider to save it.

---

## Clean Code Principles Applied
This code strictly follows 5 Clean Code principles (marked with comments inside the `.java` files):

1. **Single Responsibility Principle (SRP):** The `UserAvatar` class only prepares the image. It does not know how the internet or hard drives work. The `CloudProvider` handles the actual saving.
2. **Open/Closed Principle (OCP):** We can easily add a new `GoogleCloudProvider` without touching the code inside `UserAvatar` or `DatabaseBackup`.
3. **Don't Repeat Yourself (DRY):** The logic for storing and switching the `provider` is written only once in the parent `StorageResource` class.
4. **Meaningful Names:** Class names clearly explain their roles (e.g., `CloudProvider` instead of `Manager` or `Handler`).
5. **Small, Focused Classes:** Each class does only one specific job, keeping the code short and easy to read.

---

## How to Run
1. Clone this repository to your local machine.
2. Open the project in **IntelliJ IDEA** (Requires Java JDK 17+).
3. Find the `Main.java` file inside the `bridge` package.
4. Click **Run**.
5. Look at the console. You will see how objects process their data and seamlessly switch their storage providers at runtime!