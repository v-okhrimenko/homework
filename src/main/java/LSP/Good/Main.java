package LSP.Good;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SingleEmail singleEmail = new SingleEmail();
        singleEmail.setEmail("single@mail.ua");
        singleEmail.send();

        System.out.println("\n+++++++++++++++++++++++++\n");

        GroupSender groupSender = new GroupSender();
        groupSender.setEmails(List.of("mail1@mail.com", "mail2@gmail.ru", "mail3@mail.ua"));
        groupSender.send();

        System.out.println("\n+++++++++++++++++++++++++\n");

        MailSender mailSender = new GroupSender();
        mailSender.setEmails(List.of("mail4@ewp.com", "mail5@jh.ru", "mail6@mail.ua"));
        mailSender.send();

        System.out.println("\n+++++++++++++++++++++++++\n");

        MailSender mailSender_new = new SingleEmail();
        mailSender_new.setEmails(List.of("mail7@ewp.com"));
        mailSender_new.send();


    }

}
