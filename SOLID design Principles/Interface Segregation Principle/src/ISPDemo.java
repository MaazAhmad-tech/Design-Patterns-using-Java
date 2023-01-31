
class Document
{
}
interface Machine
{
    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d) throws Exception;
}

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine
{
    public void print(Document d)
    {
        //a
    }

    public void fax(Document d)
    {
        //
    }

    public void scan(Document d)
    {
        //
    }
}

//but here ifi you need to implement an old fashion printer which only needs to print then you are forced to implement the rest of the functions in the interface which is not even needed
class OldFashionedPrinter implements Machine
{
    public void print(Document d)
    {
        // yep
    }

    public void fax(Document d) throws Exception
    {
        throw new Exception();
    }

    public void scan(Document d) throws Exception
    {
        throw new Exception();
    }
}

//so its better to have an interface with as much small task as possible
interface Printer
{
    void Print(Document d) throws Exception;
}

interface IScanner
{
    void Scan(Document d) throws Exception;
}

class JustAPrinter implements Printer
{
    public void Print(Document d)
    {
            //print
    }
}

//if we want a photocopier we can implement Printer & Scanner
class Photocopier implements Printer, IScanner
{
    public void Print(Document d) throws Exception
    {
        throw new Exception();
    }

    public void Scan(Document d) throws Exception
    {
        throw new Exception();
    }
}

interface MultiFunctionDevice extends Printer, IScanner //
{

}

class MultiFunctionMachine implements MultiFunctionDevice
{
    // compose this out of several modules
    private Printer printer;
    private IScanner scanner;

    public MultiFunctionMachine(Printer printer, IScanner scanner)
    {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void Print(Document d) throws Exception
    {
        printer.Print(d);
    }

    public void Scan(Document d) throws Exception
    {
        scanner.Scan(d);
    }
}public class ISPDemo {
}
