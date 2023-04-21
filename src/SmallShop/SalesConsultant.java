package SmallShop;

import java.math.BigDecimal;

public class SalesConsultant extends Worker {
    private BigDecimal earnedMoney = BigDecimal.ZERO;

    public SalesConsultant() {
        Shop workingShop = Shop.getInstance();
        workingShop.addWorker(this);
    }

    public void sellProduct(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            price = BigDecimal.ZERO;
        }
        this.earnedMoney = earnedMoney.add(price);
    }

    public BigDecimal getMoney() {
        return this.earnedMoney;
    }
}