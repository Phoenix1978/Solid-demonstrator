package b_OpenClosed;

import a_SingleResonsability.Bad_Employee;

public class Bad_PriceCalculator {

    public double calculates(Product product) {

        Freight freight = new Freight();
        double discount = 0d;

        int rule = product.getPaymentMethod();

        switch (rule) {
            case 1:
                System.out.println("Cash Sale");
                PriceTableSimplePayment table1 = new PriceTableSimplePayment();
                discount = table1.calculatesDiscount(product.getValue());
                break;
            case 2:
                System.out.println("Credit Sale");
                PriceTablePaymentInInstallments table2 = new PriceTablePaymentInInstallments();
                discount = table2.calculatesDiscount(product.getValue());
                break;
        }

        double freightValue = freight.calculatesFreight(product.getState());
        return product.getValue() * (1 - discount) + freightValue;
    }

}


class Freight {

    public double calculatesFreight(String geoRegion) {

        if ("SAO PAULO".equals(geoRegion.toUpperCase())) {
            return 7.5;
        } else if ("MINAS GERAIS".equals(geoRegion.toUpperCase())) {
            return 12.5;
        } else if ("RIO DE JANEIRO".equals(geoRegion.toUpperCase())) {
            return 10.5;
        } else {
            return 10.0;
        }
    }
}

class PriceTablePaymentInInstallments {

    public double calculatesDiscount(double value) {
        if (value > 100.0) {
            return 0.01;
        } else if (value > 500.0) {
            return 0.02;
        } else if (value > 1000.0) {
            return 0.05;
        } else {
            return 0d;
        }
    }
}

class PriceTableSimplePayment {

    public double calculatesDiscount(double value) {
        if (value > 100.0) {
            return 0.05;
        } else if (value > 500.0) {
            return 0.07;
        } else if (value > 1000.0) {
            return 0.10;
        } else {
            return 0d;
        }
    }
}

class Product {
    Double value;
    String state;
    int paymentMethod;

    public Product(Double value, String state, int paymentMethod) {
        this.value = value;
        this.state = state;
        this.paymentMethod = paymentMethod;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

class TesterBadPriceCalculator {
    static void go() {
        Product prodA = new Product(165.32, "SAO PAULO", 1);
        Product prodB = new Product(654987.21, "RIO DE JANEIRO", 2);
        Bad_PriceCalculator myCalculator = new Bad_PriceCalculator();
        System.out.println(myCalculator.calculates(prodA));
        System.out.println(myCalculator.calculates(prodB));
    }
}