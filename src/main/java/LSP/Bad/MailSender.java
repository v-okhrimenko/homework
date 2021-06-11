package LSP.Bad;

public abstract class MailSender {
    private String mailAddress;

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void send() {
        System.out.println("send to: " + this.mailAddress);
        if (mailAddress == null) {
            throw new NullPointerException("Email is null");
        }
//        or

//        if(this instanceof GroupMail) {
//            ...
//        }

    }
}
