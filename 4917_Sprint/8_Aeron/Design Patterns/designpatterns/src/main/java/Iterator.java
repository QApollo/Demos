import java.util.ArrayList;

class Client
{
    public void UseIterator()
    {
        ConcreteAggregate aggr = new ConcreteAggregate();
        aggr.Add("One");
        aggr.Add("Two");
        aggr.Add("Three");
        aggr.Add("Four");
        aggr.Add("Five");

        IteratorBase iterator = aggr.CreateIterator();

        String item = (String)iterator.First();
        while (!iterator.IsDone())
        {
            System.out.println(item);
            item = (String)iterator.Next();
        }
    }
}


abstract class AggregateBase
{
    public abstract IteratorBase CreateIterator();
}


class ConcreteAggregate extends AggregateBase
{
    private ArrayList<Object> _items = new ArrayList();

    public IteratorBase CreateIterator()
    {
        return new ConcreteIterator(this);
    }

    public Object getArray(int position)
    {
        return _items.get(position);
    }

    public int getCount()
    {
        return _items.size();
    }

    public void Add(Object o)
    {
        _items.add(o);
    }
}


abstract class IteratorBase
{
    public abstract Object First();

    public abstract Object Next();

    public abstract Object CurrentItem();

    public abstract boolean IsDone();
}


class ConcreteIterator extends IteratorBase
{
    private ConcreteAggregate _aggregate;
    int _position;

    public ConcreteIterator(ConcreteAggregate aggregate)
    {
        _aggregate = aggregate;
        _position = 0;
    }

    public Object First()
    {
        _position = 0;
        return CurrentItem();
    }

    public Object Next()
    {
        _position++;
        return CurrentItem();
    }

    public Object CurrentItem()
    {
        if (_position < _aggregate.getCount())
            return _aggregate.getArray(_position);
        else
            return null;
    }

    public boolean IsDone()
    {
        return _position >= _aggregate.getCount();
    }
}
