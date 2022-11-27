package generic28;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//28
public class ClassList {
        ArrayList <File> list;
        String path;
    public ClassList (String Path) throws IOException {
        path = Path;
        list = new ArrayList<File>();
        File f = new File(path);
        File[] files = f.listFiles();
        int n = 0;
        for (File file : files) {
            list.add(file);
            System.out.println(file.getName());
        }
    }
    public void print() throws IOException{
        System.out.println();
        System.out.println("First 5 items: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i).getName());
        }
    }
}
