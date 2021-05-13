package ua.ithillel.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public class MyPhone {
    public MyPhoneBook phoneBook;
    public Camera camera;
    private boolean isSwitchOn;

    public MyPhone() {
        phoneBook = new MyPhoneBook();
        camera = new Camera();
    }

    public void switchOn() {
        if (!isSwitchOn) {

            System.out.println("Loading PhoneBook records…");

            phoneBook.addPhoneNumber("Petr", "380631234567");
            phoneBook.addPhoneNumber("Nikolay", "3806723412345");
            phoneBook.addPhoneNumber("Denis", "380682343443");
            phoneBook.addPhoneNumber("Maria", "380444111236");
            phoneBook.addPhoneNumber("Yulia", "380988765487");
            phoneBook.addPhoneNumber("Yaroslav", "380990233983");
            phoneBook.addPhoneNumber("Mikhail", "380574563459");
            phoneBook.addPhoneNumber("Alex", "380917658496");
            phoneBook.addPhoneNumber("Dmitriy", "380978473478");
            phoneBook.addPhoneNumber("Eugen", "380956548765");

            System.out.println("Loading is complete");
            isSwitchOn = true;
        }

    }

    public void call(int x) {
        Optional<MyPhoneBook.PhoneRecord> d = phoneBook.phoneNumbers.stream().filter(a -> a.getId() == x).findFirst();
        if (d.isEmpty()) {
            System.out.println("This number is not in the phone book.");
        } else {
            System.out.println("Calling to " + d.get().getId() + ": " + d.get());
        }
    }

    static class MyPhoneBook {
        private int id = 1;
        private final Collection<MyPhoneBook.PhoneRecord> phoneNumbers = new ArrayList<>();

        private class PhoneRecord {
            private final int id;
            private String name;
            private String phone;

            public PhoneRecord(String name, String phone) {
                this.name = name;
                this.phone = phone;
                this.id = MyPhoneBook.this.id++;
            }

            public int getId() {
                return id;
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
                return "PhoneRecord{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", phone='" + phone + '\'' +
                        '}';
            }
        }

        void addPhoneNumber(String name, String phone) {
            phoneNumbers.add(new PhoneRecord(name, phone));
        }

        void printPhoneBook() {
            if (!isEmptyPhoneBook()) {
                phoneNumbers.forEach(System.out::println);
            }
        }

        void sortByName() {
            if (!isEmptyPhoneBook()) {
                phoneNumbers.stream().sorted(new Comparator<>() {
                    @Override
                    public int compare(PhoneRecord phoneRecord1, PhoneRecord phoneRecord2) {
                        return phoneRecord1.getName().compareTo(phoneRecord2.getName());
                    }
                }).forEach(System.out::println);
            }
        }

        void sortByPhoneNumber() {
            if (!isEmptyPhoneBook()) {
                phoneNumbers.stream().sorted(Comparator.comparing(PhoneRecord::getPhone)).forEach(System.out::println);
            }
        }

        private boolean isEmptyPhoneBook() {
            if (phoneNumbers.isEmpty()) {
                System.out.println("PhoneBook empty!");
            }
            return phoneNumbers.isEmpty();
        }
    }

    public static class Camera {
        private boolean isPowerOn = false;

        void powerOn() {
            isPowerOn = true;
            System.out.println("Camera PowerOn");
        }

        void powerOff() {
            isPowerOn = false;
            System.out.println("Camera PowerOff");
        }

        void takePhoto() {
            if (isPowerOn) {
                System.out.println("Taking photo...");
            } else {
                System.out.println("Cant take photo. Camera is off, you need switch on camera");
            }
        }
    }

}

