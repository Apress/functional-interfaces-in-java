package chapter1.version2;
@FunctionalInterface
public interface ReceiptPrinter<X extends Receipt>
{
    void print(X receipt);

    default double computeTotal(X receipt)
    {
        double discountedPrice = receipt.price 
            - (receipt.price * receipt.discount);
        return discountedPrice + (discountedPrice * receipt.tax);
    }
}
