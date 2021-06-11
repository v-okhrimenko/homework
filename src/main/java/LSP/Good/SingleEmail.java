package LSP.Good;

import java.util.List;

public class SingleEmail extends MailSender {
    private String email;

    public void setEmail(String email) {
        this.email = email;
        setEmails(List.of(email));
    }
}
