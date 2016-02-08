import org.junit.*;
import static org.junit.Assert.*;

public class ProfitTest {
    @Test
    public void should_calculate_total_profits_for_the_year() {
        final double[] EXPECTED_SALES_JAN_TO_DEC =
            new double[] { 42.0, 45.6, 43.6, 50.2, 55.6, 54.7,
                    58.0, 57.3, 62.0, 60.3, 71.2, 88.8};
        final Sales sales = new Sales(EXPECTED_SALES_JAN_TO_DEC);

        final FixedCosts fixedCosts = new FixedCosts(15.0);
        final IncrementalCosts incrementalCosts =
                new IncrementalCosts(5.1, 0.15);

        final Profit profit = new Profit(
                sales,
                incrementalCosts,
                fixedCosts
        );

        double totalProfits = 0.0;
        for(int i = 1; i <= 12; i++) {
            totalProfits += profit.valueAt(i);
        }

        assertEquals(1, totalProfits);
    }
}