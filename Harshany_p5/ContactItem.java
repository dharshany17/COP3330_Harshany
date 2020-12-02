public class ContactItem {

        private String firstName;
        private String lastName;
        private String phone;
        private String email;

    public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactItem(String firstName, String lastName, String phone, String email) throws IllegalArgumentException {
            if(firstName.length() == 0  && lastName.length() == 0  && phone.length() == 0 && email.length() == 0) {
                throw new IllegalArgumentException();
            }
            if(!phone.matches("...-...-....") && !phone.matches("")){
                throw new IllegalArgumentException();
            }

            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + firstName + " " + lastName + "\nPhone: " + phone + "\nEmail: " + email;
        }

        public void update(String firstName, String lastName, String phone, String email)throws IllegalArgumentException {
            if(firstName.length() == 0  && lastName.length() == 0  && phone.length() == 0 && email.length() == 0) {
                throw new IllegalArgumentException();
            }
            if(!phone.matches("...-...-....") && !phone.matches("")){
                throw new IllegalArgumentException();
            }

            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.email = email;
        }


    }

