package edu.berkeley.ischool.aep;
import java.io.*;

/**
 * Created by Sonali on 2/14/14.
 */

// Quantity understands unit equivalence.
public class Quantity {
    //private final double value;
    //private Unit unit;
    protected final double value;
    protected Unit unit;

    public Quantity(Unit unit,double value )
    {
        this.value=value;
        this.unit = unit;
    }

    @Override
    public String toString()
    {
        return value+ " "+unit;
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == this) return true;
        if (!(other instanceof Quantity)) return false;
        Quantity otherQuantity = (Quantity)other;
        double Othervalue =  otherQuantity.unit.convertTo(otherQuantity.value, this.unit);
        return this.value == Othervalue;
    }

    @Override
    public int hashCode(){
        // you can give any value here
        return 42;
    }

    public Quantity better(Quantity other)
    {
        if (other.value < this.unit.convertTo(this.value,other.unit))
        {
            return this;
        }
        else
        {
            return other;
        }
    }
    //public abstract Quantity add(Quantity other);

   /* public Quantity add(Quantity other)
    { // 2inch.add(2 inch)
            if(!this.unit.isConvertible(other.unit))
            {
                throw new RuntimeException("Oops wrong units!!");
            }
            else
            {
                double result = this.value + other.unit.convertTo(other.value,this.unit);
                return (new Quantity(this.unit, result));
            }

    } */


}

