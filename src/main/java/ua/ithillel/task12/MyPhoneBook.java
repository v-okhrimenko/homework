package ua.ithillel.task12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class MyPhoneBook {

    private final Collection<PhoneRecord> phoneNumbers = new ArrayList<>();
    private int id = 1;

    private class PhoneRecord {
        private final int id;
        private String name;
        private String phone;

        public PhoneRecord(String name, String phone) {
            this.name = name;
            this.phone = phone;
            this.id = MyPhoneBook.this.id++;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "PhoneRecord{" + id + " " +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    public void addPhoneNumber(String name, String phone) {
        phoneNumbers.add(new PhoneRecord(name, phone));
    }

    public void printPhoneBook() {
        phoneNumbers.forEach(System.out::println);
    }

    public void sortByName() {
        phoneNumbers.stream().sorted(new Comparator<PhoneRecord>() {
            @Override
            public int compare(PhoneRecord phoneRecord1, PhoneRecord phoneRecord2) {
                return phoneRecord1.getName().compareTo(phoneRecord2.getName());
            }
        }).forEach(System.out::println);

    }

    public void sortByPhoneNumber() {
        phoneNumbers.stream().sorted(Comparator.comparing(PhoneRecord::getPhone)).forEach(System.out::println);
    }
}
