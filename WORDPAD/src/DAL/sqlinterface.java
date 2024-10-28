package DAL;
import java.sql.SQLException;
import java.util.List;

import DTO.File;
public interface sqlinterface {
boolean savetodb(String a,String b) throws SQLException;
public List <File> openfilefromdb(String name);
public List<File> viewallfilesdb();
public String txttostring(String name);
public boolean deleteFileFromDb(String fileName);
}