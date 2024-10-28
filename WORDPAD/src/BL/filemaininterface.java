package BL;
import DTO.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public interface filemaininterface {
boolean saveFile(String a,String b) throws SQLException;
  String openfile(String name);
List<String> viewallfiles();
String txttostring(String name);
boolean deleteFile(String fileName);
}
