import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        assertThrows(IllegalArgumentException.class, () -> {ContactItem addItem = new ContactItem("", "", "", "");});

    }


    @Test
    public void creationSucceedsWithBlankFirstName() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        assertEquals("", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("John@doe.com", list.get(0).getEmail());

    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "", "817-333-1212", "John@doe.com");
        list.add(addItem);
        assertEquals("John", list.get(0).getFirstName());
        assertEquals("", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("John@doe.com", list.get(0).getEmail());
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "", "John@doe.com");
        list.add(addItem);
        assertEquals("John", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("", list.get(0).getPhone());
        assertEquals("John@doe.com", list.get(0).getEmail());
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "");
        list.add(addItem);
        assertEquals("John", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("", list.get(0).getEmail());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        assertEquals("John", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("John@doe.com", list.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setFirstName("John");
        list.get(0).setLastName("Doe");
        list.get(0).setPhone("817-333-1212");
        list.get(0).setEmail("");

        assertEquals("John", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("", list.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setFirstName("");
        list.get(0).setLastName("Doe");
        list.get(0).setPhone("817-333-1212");
        list.get(0).setEmail("John@doe.com");

        assertEquals("", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("John@doe.com", list.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setFirstName("John");
        list.get(0).setLastName("");
        list.get(0).setPhone("817-333-1212");
        list.get(0).setEmail("John@doe.com");

        assertEquals("John", list.get(0).getFirstName());
        assertEquals("", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("John@doe.com", list.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setFirstName("John");
        list.get(0).setLastName("Doe");
        list.get(0).setPhone("817-333-1212");
        list.get(0).setEmail("");

        assertEquals("John", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("", list.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setFirstName("John");
        list.get(0).setLastName("Doe");
        list.get(0).setPhone("817-333-1212");
        list.get(0).setEmail("John@doe.com");

        assertEquals("John", list.get(0).getFirstName());
        assertEquals("Doe", list.get(0).getLastName());
        assertEquals("817-333-1212", list.get(0).getPhone());
        assertEquals("John@doe.com", list.get(0).getEmail());
    }


    }
