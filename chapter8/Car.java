package chapter8;
public class Car
{
    private String make;
    private String model;
    public Car(String ma, String mo)
    {
        make  = ma;
        model = mo;
    }
    @Override
    public String toString() {return make + " " + model; }
}
