package Esecuzione;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainE {

    public static void main(String[] args) {
        //Prodotti books
        Product book1 = new Product(766876L,"Il Muro","Books",19.99);
        Product book2 = new Product(3894579756L,"Non Luoghi","Books",9.56);
        Product book3 = new Product(47693L,"Storia Antica","Books",156.99);
        //Prodotti Baby
        Product baby1 = new Product(458937L,"Pannolini","Baby",14.99);
        Product baby2 = new Product(34563424L,"Talco","Baby",4.76);
        Product baby3 = new Product(234657L,"Latte in polvere","Baby",34.99);
        //Prodotti Boys
        Product boys1 = new Product(4356737L,"Manga","Boys",8.99);
        Product boys2 = new Product(23454657L,"Scarpe","Boys",158.67);
        Product boys3 = new Product(23452345L,"Moto","Boys",3750.00);


        //lista prodotti
        List<Product> prodotti= List.of(book1,book2,book3,baby1,book3);
        List<Product> prodotti2 = List.of(book3,baby2,boys2);
        List<Product> prodotti3 = List.of(baby3,baby2,book3,boys2);

        //Clienti
        Customer c1 = new Customer(23435L,"Naruto Uzumaki",4);
        Customer c2 = new Customer(768458L,"Sasuke Uchiha",1);
        Customer c3 = new Customer(436398L,"Sakura Haruno",3);

        //Ordini
        Order or1 = new Order(345456L, "Spedito", LocalDate.of(2020,5,12),LocalDate.of(2020,5,29),prodotti,c1);
        Order or2 = new Order(344567L,"In consegna",LocalDate.of(2020,2,10),LocalDate.of(2020,6,20),prodotti2,c3);
        Order or3 = new Order(976457L,"Consegnato",LocalDate.of(2020,4,1),LocalDate.of(2020,9,24),prodotti3,c2);

        //Lista ordini
        List<Order> ordiniGlobali = List.of(or1,or2,or3);

        //Esercizio #1
        //Raggruppare gli ordini per cliente utilizzando Stream e Lambda Expressions.
        // Crea una mappa in cui la chiave è il cliente e il valore è una lista di ordini effettuati da quel cliente

        System.out.println("Esercizio 1");
       Map<Customer,List<Product>> es1 = ordiniGlobali.stream().collect(Collectors.toMap(Order::getCustomer,Order::getProducts));
        System.out.println("Es1 : " + es1);
        System.out.println("=================================");
        System.out.println();
        //Esercizio #2
        //ato un elenco di ordini, calcola il totale delle vendite per ogni cliente utilizzando Stream e Lambda Expressions.
        //Crea una mappa in cui la chiave è il cliente e il valore è l'importo totale dei suoi acquisti
        System.out.println("Esercizio 2");
         Map<Customer,Double> es2 =  ordiniGlobali.stream().collect(Collectors.toMap(Order::getCustomer,order -> order.getProducts().stream().
                mapToDouble(Product::getPrice).sum(),Double::sum));
        System.out.println("Es2 : " + es2);
        System.out.println("=================================");
        System.out.println();

        //Dato un elenco di prodotti, trova i prodotti più costosi utilizzando Stream e Lambda

        DoubleSummaryStatistics es3 = prodotti.stream().collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println( "Es3 : " + es3.getMax());
        System.out.println("=================================");
        System.out.println();
        //Esercizio #4
        //Dato un elenco di ordini, calcola la media degli importi degli ordini utilizzando Stream e Lambda Expressions
       Double es4 = ordiniGlobali.stream().map(order -> order.getProducts().stream().collect(Collectors.averagingDouble(Product::getPrice)));






    }



}
