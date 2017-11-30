abstract class SubjectBase_
{
    public abstract void PerformAction();
}


class RealSubject extends SubjectBase_
{
    public void PerformAction()
    {
        System.out.println("RealSubject action performed.");
    }
}


class Proxy extends SubjectBase
{
    private RealSubject _realSubject;

    public void PerformAction()
    {
        if (_realSubject == null)
        _realSubject = new RealSubject();

        _realSubject.PerformAction();
    }
}