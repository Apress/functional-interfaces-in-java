package chapter2;
public class Receipt
{
    String item;
    double price;
    double discount;
    double tax;
    public Receipt(String i, double a, double d, double s)
    {
        item     = i;
        price    = a;
        discount = d;
        tax      = s;
    }
    public Receipt(Receipt r)
    {
        item     = r.item;
        price    = r.price;
        discount = r.discount;
        tax      = r.tax;
    }
}
