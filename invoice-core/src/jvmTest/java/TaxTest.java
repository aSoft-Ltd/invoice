import invoice.Tax;
import org.junit.jupiter.api.Test;

import static expect.Builders.*;

public class TaxTest {

    @Test
    public void should_fail() {
        var error = expect(() -> new Tax("VAT", 200)).toFail();
        System.out.println(error.getMessage());
    }
}
