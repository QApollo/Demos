import java.util.ArrayList;

abstract class SubjectBase
{
    private ArrayList<ObserverBase> _observers = new ArrayList();

    public void Attach(ObserverBase o)
    {
        _observers.add(o);
    }

    public void Detach(ObserverBase o)
    {
        _observers.remove(o);
    }

    public void Notify()
    {
        for (ObserverBase o : _observers)
        {
            o.Update();
        }
    }
}

class ConcreteSubject extends SubjectBase
        {
private String _state;

public String GetState()
        {
        return _state;
        }

public void SetState(String newState)
        {
        _state = newState;
        Notify();
        }
        }


abstract class ObserverBase
{
    public abstract void Update();
}


class ConcreteObserver extends ObserverBase
{
    private ConcreteSubject _subject;

    public ConcreteObserver(ConcreteSubject subject)
    {
        _subject = subject;
    }

    public void Update()
    {
        String subjectState = _subject.GetState();
        System.out.println(subjectState);
    }
}