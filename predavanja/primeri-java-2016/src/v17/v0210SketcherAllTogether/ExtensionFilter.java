package v17.v0210SketcherAllTogether;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ExtensionFilter extends FileFilter
{
	private String description; // Filter description
	private String extension; // File extension

	public ExtensionFilter(String ext, String descr)
	{
		extension = ext.toLowerCase(); // Store the extension as
		// lower case
		description = descr; // Store the description
	}

	public boolean accept(File file)
	{
		return (
			file.isDirectory() || file.getName().toLowerCase().endsWith(extension));
	}

	public String getDescription()
	{
		return description;
	}

}
