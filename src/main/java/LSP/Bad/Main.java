package LSP.Bad;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SingleMail singleMail = new SingleMail();
        singleMail.setMailAddress("mail@mail.com");
        singleMail.send();

        System.out.println("\n+++++++++++++++++++++++++\n");

        GroupMail groupMail = new GroupMail();
        groupMail.setMailAddress(List.of("mail2@mail.com", "mail3@mail.com", "mail4@mail.com"));
        groupMail.send();

        System.out.println("\n+++++++++++++++++++++++++\n");

//        MailSender mailSender = new GroupMail();
//        mailSender.setMailAddress(List.of("mail2@mail.com","mail3@mail.com","mail4@mail.com"));
//

    }
}
