package SmallShop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final Shop instance = new Shop();
    private final List<Worker> workers = new ArrayList<>();

    private Shop() {
    }

    public static Shop getInstance() {
        return instance;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public BigDecimal getTurnover() {
        BigDecimal turnOver = BigDecimal.ZERO;
        for (Worker worker : this.workers) {
            if (worker instanceof SalesConsultant) {
                turnOver = turnOver.add(((SalesConsultant) worker).getMoney());
            }

            if (worker instanceof MarketingSpecialist) {
                turnOver = turnOver.add(((MarketingSpecialist) worker).getBudget());
            }
        }

        return turnOver;
    }
}