package databaseService;

import archive.Archive;
import archive.User;
import databaseDao.ArchiveDao;
import databaseDao.DaoFactory;

public class ArchiveService {
	private ArchiveDao archiveDao;
	
	public ArchiveService() {
		archiveDao = DaoFactory.getInstace().createArchiveDao();
		System.out.println("archiveDao: " + archiveDao);
	}
	
	public void add(Archive archive) {
		if(archive == null)
			System.out.println("Invalid addition!!");
		else
			archiveDao.addArchive(archive);
	}
	
	public Archive query(int code) {
		int count = archiveDao.getCount();
		if(count <= 0)
			return null;
		Archive archive = archiveDao.getArchive(code);
		if(archive == null)
			System.out.println("The query result is empty!!");
		else
			System.out.println(archive.toString());
		return archive;
	}
	
	public void delete(Archive archive) {
		if(archive.getCode() <= 0)
			System.out.println("Invalid information, cannot delete!!");
		else
			archiveDao.delete(archive);
	}
	
	public Archive[] getAll(User user) {
		Archive[] archives = archiveDao.getArchives(user);
		if(archives.length == 0) {
			System.out.println("Empty table!!");
			return null;
		} else
			return archives;
	}
}
