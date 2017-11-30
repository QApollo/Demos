abstract class AlgorithmBase
{
    public void TemplateMethod()
    {
        Step1();
        Step2();
        Step3();
    }

    public abstract void Step1();

    public abstract void Step2();

    public abstract void Step3();
}


class ConcreteAlgorithmA extends AlgorithmBase
{
    public void Step1()
    {
        System.out.println("Algorithm A, Step 1");
    }

    public void Step2()
    {
        System.out.println("Algorithm A, Step 2");
    }

    public void Step3()
    {
        System.out.println("Algorithm A, Step 3");
    }
}


class ConcreteAlgorithmB extends AlgorithmBase
{
    public void Step1()
    {
        System.out.println("Algorithm B, Step 1");
    }

    public void Step2()
    {
        System.out.println("Algorithm B, Step 2");
    }

    public void Step3()
    {
        System.out.println("Algorithm B, Step 3");
    }
}