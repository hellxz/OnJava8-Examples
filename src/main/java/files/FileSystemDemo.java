package files;

// files/FileSystemDemo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.nio.file.*;

public class FileSystemDemo {
  static void show(String id, Object o) {
    System.out.println(id + ": " + o);
  }
  public static void main(String[] args) {
    System.out.println(System.getProperty("os.name"));
    FileSystem fsys = FileSystems.getDefault();
    for(FileStore fs : fsys.getFileStores())
      show("File Store", fs);
    for(Path rd : fsys.getRootDirectories())
      show("Root Directory", rd);
    show("Separator", fsys.getSeparator());
    show("UserPrincipalLookupService",
      fsys.getUserPrincipalLookupService());
    show("isOpen", fsys.isOpen());
    show("isReadOnly", fsys.isReadOnly());
    show("FileSystemProvider", fsys.provider());
    show("File Attribute Views",
      fsys.supportedFileAttributeViews());
  }
}
/* Output:
Windows 10
File Store: (C:)
File Store: System Reserved (E:)
File Store: (F:)
File Store: Google Drive (G:)
Root Directory: C:\
Root Directory: D:\
Root Directory: E:\
Root Directory: F:\
Root Directory: G:\
Separator: \
UserPrincipalLookupService:
sun.nio.fs.WindowsFileSystem$LookupService$1@1bd4fdd
isOpen: true
isReadOnly: false
FileSystemProvider:
sun.nio.fs.WindowsFileSystemProvider@55183b20
File Attribute Views: [owner, dos, acl, basic, user]
*/
