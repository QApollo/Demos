class Score
{
    public StrategyBase Strategy;


    //code

    public void CallAlgorithm()
    {
        System.out.println(Strategy.Algorithm());
    }
}


abstract class StrategyBase
{
    public abstract String Algorithm();
}


class ConcreteStrategyA extends StrategyBase
{
    public String Algorithm()
    {
        return "Concrete Strategy A";
    }
}


class ConcreteStrategyB extends StrategyBase
{
    public String Algorithm()
    {
        return "Concrete Strategy B";
    }
}