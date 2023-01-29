import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//SRP states single responsibility to a single class
//This Journal class will only be responsible for making and deleting entries
class Journal
{
    private final List<String> entries= new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text)
    {
        entries.add(""+ (++count) + ": " + text);
    }

    public void removeEntry(int index)
    {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

}

//This class will be responsible for saving and loading
//If we put the below functionalities in the same class Journal then this cacnnot be SRP
class Persistence {
    public void savetoFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if(overwrite || new File(filename).exists())
        {
            try(PrintStream out = new PrintStream(filename))
            {
                out.println(journal.toString());
            }
        }
    }
    public void load(String filename){}
    public void load(URL url){}
}
public class Demo {

    public static void main(String[] args) throws IOException {

        Journal j = new Journal();
        j.addEntry("I am learning Design patterns using JAVA");
        j.addEntry("I read a book today");
        j.addEntry("I got a bug in Production");

        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "E:\\Java Design Patterns\\SOLID design Principles\\Single Responsibility principle\\resources\\journal.txt";
        p.savetoFile(j, filename, true);

        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}
