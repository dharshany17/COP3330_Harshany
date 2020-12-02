import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingContactItemsIncreasesSize() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe2", "817-333-1212", "john@doe.com");
        list.add(addItem);
        assertEquals(1, list.size());
        //done
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);



        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3).setFirstName("John");;
        });
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setPhone("");

        assertEquals("", list.get(0).getPhone());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setFirstName("");

        assertEquals("", list.get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setLastName("");

        assertEquals("", list.get(0).getLastName());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-333-1212", "John@doe.com");
        list.add(addItem);
        list.get(0).setEmail("");

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

    @Test
    public void newContactListIsEmpty() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        assertEquals(0, list.size());
    }

    @Test
    public void removingContactItemsDecreasesSize() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "Doe", "817-999-2106", "John@doe.com");
        list.add(addItem);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void removingContactItemsFailsWithInvalidIndex() {
        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.remove(2);});
    }

    @Test
    public void gettingContactItemFirstNameFailsWithInvalidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(2).getFirstName();});

    }

    @Test
    public void gettingContactItemFirstNameSucceedsWithValidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertEquals("John", list.get(0).getFirstName());
    }

    @Test
    public void gettingContactItemLastNameFailsWithInvalidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(2).getLastName();});

    }

    @Test
    public void gettingContactItemLastNameSucceedsWithValidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertEquals("doe", list.get(0).getLastName());
    }

    @Test
    public void gettingContactItemPhoneNumberFailsWithInvalidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(2).getPhone();});

    }

    @Test
    public void gettingContactItemPhoneNumberSucceedsWithValidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertEquals("813-327-8777", list.get(0).getPhone());
    }

    @Test
    public void gettingContactItemEmailFailsWithInvalidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(2).getEmail();});

    }

    @Test
    public void gettingContactItemEmailSucceedsWithValidIndex() {

        ArrayList<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem addItem = new ContactItem("John", "doe", "813-327-8777", "john@doe.com");
        list.add(addItem);
        assertEquals("john@doe.com", list.get(0).getEmail());
    }

}