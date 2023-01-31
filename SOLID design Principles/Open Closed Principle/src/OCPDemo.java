import java.util.List;
import java.util.stream.Stream;


/**
 * In object-oriented programming, the open–closed principle (OCP) states "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification"; that is, such an entity can allow its behaviour to be extended without modifying its source code.
 * In this OCP Demo we will also learn about Specification Design Pattern
 * */

enum Color
{
    RED, GREEN, BLUE
}
enum Size
{
    SMALL, MEDIUM, LARGE, HUGE
}

class Product
{
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter
{
    public Stream<Product> filterByColor(List<Product> products, Color color)
    {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size)
    {
        return products.stream().filter(p -> p.size == size);
    }
}

interface Specification<T>
{
    boolean isSatisfied(T item);
}
interface Filter<T>
{
    Stream<T> filter(List<T> items, Specification<T> spec);
}
class ColorSpecification implements Specification<Product>
{
    private Color color;
    public ColorSpecification(Color color) {
        this.color = color;
    }
    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}
class SizeSpecification implements Specification<Product>
{
    private Size size;
    public SizeSpecification(Size size) {
        this.size = size;
    }
    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}
//Now here do not need to modify our better filter class but wew can use inheritance of the interfaces and create as many filters as we want.
class BetterFilter implements Filter<Product>
{
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p-> spec.isSatisfied(p));
    }
}
public class OCPDemo
{
    public static void main(String[] args) {

        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.HUGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products(old): ");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(
                        "-" + p.name +" is green"
                ));

        System.out.println("Large products(old): ");
        pf.filterBySize(products, Size.LARGE)
                .forEach(p-> System.out.println(
                        "-" + p.name + " is Large in size"
                ));

        BetterFilter bf = new BetterFilter();
        System.out.println("Green products(new): ");
        bf.filter(products, new ColorSpecification(Color.GREEN)).
                forEach(p-> System.out.println(
                        "-" + p.name + " is Green"
                ));

    }

}
