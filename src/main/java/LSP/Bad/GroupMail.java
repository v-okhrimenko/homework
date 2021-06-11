package LSP.Bad;

import java.util.List;

public class GroupMail extends MailSender {
    private List<String> mailsToSend;

    public void setMailAddress(List<String> mailAddress) {
        this.mailsToSend = mailAddress;
    }

    @Override
    public void send() {
        for (String s : mailsToSend) {
            System.out.println("Sent to: " + s);
        }
    }
}
