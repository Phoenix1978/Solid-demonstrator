package b_OpenClosed;

public class Good_PriceCalculator {
    private PriceTable table;
    private FreightService freight;

    public Good_PriceCalculator(PriceTable table, FreightService freight) {
        this.table = table;
        this.freight = freight;
    }

    public double calculates(ProductG product) {
        double discount = table.calculatesDiscount(product.getValue());
        double freightValue = freight.calculatesFreight(product.getState());
        return product.getValue() * (1 - discount) + freightValue;
    }
}

interface FreightService {

    public double calculatesFreight(String state);

}

class FreightG implements FreightService {

    @Override
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

interface PriceTable {

    public double calculatesDiscount(double value);

}

class PriceTableSimplePaymentG implements PriceTable {

    @Override
    public double calculatesDiscount(double value) {

        System.out.println("Cash Sale");
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

class PriceTablePaymentInInstallmentsG implements PriceTable {

    @Override
    public double calculatesDiscount(double value) {
        System.out.println("Credit Sale");
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

class ProductG {
    Double value;
    String state;

    public ProductG(Double value, String state) {
        this.value = value;
        this.state = state;
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

}

class TesterGoodPriceCalculator {
    static void go() {
        ProductG prodA = new ProductG(165.32, "SAO PAULO");
        Good_PriceCalculator myCalculator = new Good_PriceCalculator(new PriceTableSimplePaymentG(), new FreightG());
        System.out.println(myCalculator.calculates(prodA));
        Good_PriceCalculator myCalculator2 = new Good_PriceCalculator(new PriceTablePaymentInInstallmentsG(), new FreightG());
        ProductG prodB = new ProductG(654987.21, "RIO DE JANEIRO");
        System.out.println(myCalculator2.calculates(prodB));
    }
}