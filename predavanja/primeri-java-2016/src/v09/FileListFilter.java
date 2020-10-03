package v09;
import java.io.File;
import java.io.FilenameFilter;

public class FileListFilter implements FilenameFilter {
  private String name;        // File name filter
  private String extension;   // File extension filter

  // Constructor
  public FileListFilter(String name, String extension) {
    this.name = name;
    this.extension = extension;
  }

  public boolean accept(File directory, String filename) {
    boolean fileOK = true;

    // If there is a name filter specified, check the file name
    if (name != null)
      fileOK &= filename.startsWith(name);

    // If there is an extension filter, check the file extension
    if (extension != null)
      fileOK &= filename.endsWith('.' + extension);

    return fileOK;
  }
}
