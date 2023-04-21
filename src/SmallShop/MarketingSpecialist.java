package SmallShop;

import java.math.BigDecimal;

import static SmallShop.ErrorMessages.CAMPAIGN_COST_BIGGER_THAN_BUDGET;

public class MarketingSpecialist extends Worker {
    private BigDecimal budget = BigDecimal.valueOf(5000);

    public MarketingSpecialist() {
        Shop workingShop = Shop.getInstance();
        workingShop.addWorker(this);
    }

    public void spendMoney(BigDecimal marketingCampaignCost) {
        try {
            if (this.budget.compareTo(marketingCampaignCost) < 0) {
                String messageException = String.format(CAMPAIGN_COST_BIGGER_THAN_BUDGET, budget);
                throw new IllegalArgumentException(messageException);
            }
            this.budget = budget.subtract(marketingCampaignCost);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public BigDecimal getBudget() {
        return this.budget;
    }
}