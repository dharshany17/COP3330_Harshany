import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ContactList {

        private List<ContactItem> items;

        public ContactList() {
            this.items = new ArrayList<>();
        }

        public int size() {
            return items.size();
        }

        public void add(ContactItem item) {
            items.add(item);
        }

        public ContactItem get(int index) {
            return items.get(index);
        }

        public void remove(int index) {
            items.remove(index);
        }


    public String view() {
        StringBuilder sb = new StringBuilder();
        ContactItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
                sb.append(String.format("%d) %s%n", i, item));
        }
        return sb.toString();
    }


        public void update(int index, String firstName, String lastName, String phone, String email) {
            this.get(index).update(firstName, lastName, phone, email);
        }

        public void save(String filename) {
            try (Formatter output = new Formatter(filename)) {
                output.format("contacts%n");
                for (ContactItem item : items) {
                    output.format("%s%n", item.getFirstName());
                    output.format("%s%n", item.getLastName());
                    output.format("%s%n", item.getPhone());
                    output.format("%s%n", item.getEmail());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void load(String filename) {
            List<ContactItem> backupList = items;

            items = new ArrayList<>();
            try (Scanner input = new Scanner(Paths.get(filename))) {
                String header = input.nextLine();
                if (header.equalsIgnoreCase("contacts")) {
                    while (input.hasNext()) {
                        String firstName = input.nextLine();
                        String lastName = input.nextLine();
                        String phone = input.nextLine();
                        String email = input.nextLine();

                        ContactItem item = new ContactItem(firstName, lastName, phone, email);
                        this.add(item);
                    }
                } else {
                    items = backupList;
                    throw new InputMismatchException("Warning: filename is not valid");
                }
            } catch (FileNotFoundException e) {
                items = backupList;
                throw new InputMismatchException("Warning: file not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

