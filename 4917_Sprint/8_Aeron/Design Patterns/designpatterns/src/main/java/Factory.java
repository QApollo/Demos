abstract class FactoryBase
{
    public abstract ProductBase FactoryMethod(int type) throws Exception;
}


class ConcreteFactory extends FactoryBase
{
    public ProductBase FactoryMethod(int type) throws Exception {
        switch (type)
        {
            case 1: return new ConcreteProduct1();
            case 2: return new ConcreteProduct2();
            default: throw new Exception("Invalid type");
        }
    }
}


abstract class ProductBase { }

class ConcreteProduct1 extends ProductBase { }

class ConcreteProduct2 extends ProductBase { }