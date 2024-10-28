package BL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAL.sqlinterface;
import DTO.File;
public class filemain implements  filemaininterface{
	sqlinterface o ;
	public filemain(sqlinterface o){
		this.o=o;
	}
public boolean saveFile(String name,String content) throws SQLException {
	if (o.savetodb(name,content)) {
		return true;
	}
	else {
		return false;
	}
}
@Override
public String openfile(String name) {
	String result="";
	List<File> files=new ArrayList<>();
	files=o.openfilefromdb(name);
	if (files.isEmpty()) {
		return "No file found"+":"+ "File don,t exist";
	}
	else {
		for(File f: files){
			result=f.getname()+":"+f.getdata();
		}
		return result;
	}
}
public List<String> viewallfiles() {
List<String> filestring=new ArrayList<>();
List<File>files =new ArrayList<>();
files=o.viewallfilesdb();
if (files.isEmpty()) {
	
	filestring.add("No files exist");
}
else {
	for (File f:files) {
		filestring.add(f.getname());
	}
}

return filestring;
}
public String txttostring(String name) {
	String re=o.txttostring(name);
	return re;
	
}
public boolean deleteFile(String fileName) {
    if (o.deleteFileFromDb(fileName)) {
        System.out.println("File '" + fileName + "' deleted successfully.");
    } else {
        System.out.println("Failed to delete file '" + fileName + "'. It may not exist.");
    }
	return true;
}

}
