class Director
{
    public void Construct(Builder builder)
    {
        builder.BuildPart1();
        builder.BuildPart2();
        builder.BuildPart3();
    }
}


abstract class Builder
{
    public abstract void BuildPart1();
    public abstract void BuildPart2();
    public abstract void BuildPart3();
    public abstract Product GetProduct();
}


class ConcreteBuilder extends Builder
{
    private Product _product = new Product();

    public void BuildPart1()
    {
        _product.Part1 = "Part 1";
    }

    public void BuildPart2()
    {
        _product.Part2 = "Part 2";
    }

    public void BuildPart3()
    {
        _product.Part3 = "Part 3";
    }

    public Product GetProduct()
    {
        return _product;
    }
}


class Product
{
    public String Part1;
    public String Part2;
    public String Part3;

    public String getPart1()
    {
        return this.Part1;
    }
    public void setPart1(String part1)
    {
        this.Part1 = part1;
    }

    public String getPart2()
    {
        return this.Part2;
    }
    public void setPart2(String part2)
    {
        this.Part2 = part2;
    }

    public String getPart3()
    {
        return this.Part3;
    }
    public void setPart3(String part3)
    {
        this.Part3 = part3;
    }
}