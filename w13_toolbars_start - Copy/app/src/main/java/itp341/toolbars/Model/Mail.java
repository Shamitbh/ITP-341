package itp341.toolbars.Model;

import java.util.ArrayList;

public class Mail {
    private String sender;
    private String title;
    private String message;

    private boolean isRead;

    private Mail(String sender, String title, String message) {
        this.sender = sender;
        this.title = title;
        this.message = message;
        this.isRead = false;
    }

    public String getSender() {
        return sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public static class MailSingleton
    {
        private static MailSingleton mInstance;

        private ArrayList<Mail> mMailList;

        public MailSingleton() {
            mMailList = new ArrayList<>();
        }

        public static MailSingleton getInstance()
        {
            if (mInstance == null)
            {
                mInstance = new MailSingleton();
                mInstance.addMail("Rob", "Howdy!", "What a wonderful day for toolbars!");
                mInstance.addMail("Sean", "Yo!", "Let me know if you need any help!");
                mInstance.addMail("Neelam", "Hi!", "Nice to see you in class again!");
                mInstance.addMail("Karthik", "Hello!", "We are covering some cool topics!");
                mInstance.addMail("Mocha", "Woof woof woof woof woof woof woof woof woof woof!",
                        "Woof woof woof WOOF WOOF WOOF wooF Woof Woof. Woof woof woof. Woof Woof " +
                                ",WOOF WoOF, WooF. WOof, WOOF woof woof woof. Woof woof woof " +
                                "woof, wOOF.");
                mInstance.addMail("Chris", "Hey!", "Why am I on the bottom?");
            }
            return mInstance;
        }

        public ArrayList<Mail> getAllMail()
        {
            return mMailList;
        }

        public void addMail(String sender, String title, String message)
        {
            mMailList.add(new Mail(sender, title, message));
        }

        public void deleteMail(int index)
        {
            if (index == -1)
            {
                return;
            }

            mMailList.remove(index);
        }

        public void markReadStatus(int index, boolean isRead)
        {
            if (index == -1)
            {
                return;
            }

            mMailList.get(index).setRead(isRead);
        }

        public Mail getMail(int index)
        {
            if (index < 0)
            {
                return null;
            }

            return mMailList.get(index);
        }
    }
}
