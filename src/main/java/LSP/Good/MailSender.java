package LSP.Good;

import java.util.List;
import java.util.Objects;

public abstract class MailSender {
    private List<String> emails;

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void send() {
        if (Objects.nonNull(emails)) {
            for (String mailAddress : emails) {
                System.out.println("Sent to " + mailAddress);
            }
        } else {
            System.out.println("No email to send");
        }

    }
}
