package uk.ac.ucl;

import java.util.List;
import java.util.ArrayList;

/**
 * This class implements methods common to all concrete set implementations but does not
 * represent a complete set implementation.<br />
 *
 * New set objects are created using a MySetFactory.
 */

public abstract class AbstractMySet<T extends Comparable<T>> implements MySet<T>
{
  @Override
  public boolean equals(MySet<T> aSet)
  {
    // TODO write a working method body.
    return false;
  }

  @Override
  public int hashCode()
  {
    return toList().hashCode();
  }

  public List<T> toList()
  {
    // TODO write the code to return a List of the set contents.
      for (T setValue : this )
      {
        System.out.print(setValue + " ");
      }

    return new ArrayList<>();
  }

  public MySet<T> union(MySet<T> mySet) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet();

    //TODO write the statements needed to find the union

    for (T value : this){
      result.add(value);
    }
    for (T value : mySet){
      result.add(value);
    }


    return result;
  }

  public MySet<T> intersection(MySet<T> mySet) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet();

    // TODO write the statements needed to find the intersection.
    for (T value1 : this){
      for (T value2 : mySet){
        if (value1 == value2){
          result.add(value1);
        }
      }
    }

    return result;
  }

  public MySet<T> difference(MySet<T> mySet) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet();


    // TODO write the statements needed to find the difference.
    for (T value1 : this){
      if (mySet.contains(value1) == false){
        result.add(value1);
      }
    }

    for (T value2 : mySet){
      if (this.contains(value2) == false){
        result.add(value2);
      }
    }


    return result;
  }

  protected void checkSize(int maximumSize)
    throws MySetException
  {
     // TODO throw an exception if the set exceeds its maximum size.
  }

  // A helper method that might be useful.
  private void addAll(MySet<T> source, MySet<T> destination)
    throws MySetException
  {
    for (T value : source)
    {
      destination.add(value);
    }
  }
}
