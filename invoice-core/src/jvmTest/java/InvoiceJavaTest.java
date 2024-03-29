import invoice.Invoice;
import invoice.Tax;
import invoice.TaxAgency;
import kash.Currency;
import kotlinx.datetime.LocalDate;
import org.junit.jupiter.api.Test;

import static expect.Builders.expect;

public class InvoiceJavaTest {

    @Test
    public void body_should_calculate_tax_appropriately() {
        var SRS = new TaxAgency("South Africa Revenue Service");
        var body1 = TestUtils.makeBody(new Tax("GST", 10, SRS));
        expect(body1.getCostBeforeTax()).toBe(5500000L);
        expect(body1.getCostAfterTax()).toBe(6050000L);

        var body2 = TestUtils.makeBody(Tax.GENERIC_ZERO);
        expect(body2.getCostBeforeTax()).toBe(5500000L);
        expect(body2.getCostBeforeTax()).toBe(body2.getCostAfterTax());

        var body3 = TestUtils.makeBody(new Tax("GST", 10, SRS), new Tax("VAT", 15, SRS));
        System.out.println(body3.getTaxRates());
    }

    @Test
    public void should_create_a_minimalistic_invoice() {
        var address = TestUtils.makeAddress();
        var sender = TestUtils.makeSender(address);
        var receiver = TestUtils.makeReceiver(address);
        var createdOn = new LocalDate(2021, 1, 1);
        var header = new Invoice.Header(sender, receiver, Currency.TZS, createdOn);
        var body = TestUtils.makeBody();
        var invoice = new Invoice(TestUtils.UNSET, header, body);
        System.out.println(invoice);
    }
}
