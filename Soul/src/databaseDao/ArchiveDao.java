package databaseDao;

import archive.Archive;
import archive.User;

public interface ArchiveDao {
	public void addArchive(Archive archive);
	public Archive getArchive(int code);
	public Archive[] getArchives(User user);
	public int update(Archive archive);
	public int delete(Archive archive);
	public int getCount(User user);
	public int getCount();
}
