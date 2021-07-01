import contacts.Email;
import contacts.Phone;
import invoice.Address;
import invoice.Sender;
import org.junit.jupiter.api.Test;

public class SenderJavaTest {

    @Test
    public void should_instantiate_a_sender_correctly() {
        var address1 = new Address.LocationWithContacts(
                "Tanzania",
                "Dar Es Salaam",
                "Bunju",
                new Phone("254711111122"),
                new Email("andy@lamax.net")
        );
        var address2 = new Address.Description("Michigan");
        var sender = new Sender("", "Test Sender", address2);
    }
}
