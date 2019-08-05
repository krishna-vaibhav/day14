Basics of java mail
  

The JavaMail is an API that is used to compose, write and read electronic messages (emails).

The JavaMail API provides protocol-independent and platform independent framework for sending and receiving mails.

The javax.mail and javax.mail.activation packages contains the core classes of JavaMail API.

The JavaMail facility can be applied to many events. It can be used at the time of registering the user (sending notification such as thanks for your interest to my site), forgot password (sending password to the users email id), sending notifications for important updates etc. So there can be various usage of java mail api.




Protocols used in JavaMail API
There are some protocols that are used in JavaMail API.

    SMTP
    POP
    IMAP
    MIME
    NNTP and others

SMTP

SMTP is an acronym for Simple Mail Transfer Protocol. It provides a mechanism to deliver the email. We can use Apache James server, Postcast server, cmail server etc. as an SMTP server. But if we purchase the host space, an SMTP server is bydefault provided by the host provider. For example, my smtp server is mail.abc.com. If we use the SMTP server provided by the host provider, authentication is required for sending and receiving emails.
POP

POP is an acronym for Post Office Protocol, also known as POP3. It provides a mechanism to receive the email. It provides support for single mail box for each user. We can use Apache James server, cmail server etc. as an POP server. But if we purchase the host space, an POP server is bydefault provided by the host provider. For example, the pop server provided by the host provider for my site is mail.abc.com. This protocol is defined in RFC 1939.
IMAP

IMAP is an acronym for Internet Message Access Protocol. IMAP is an advanced protocol for receiving messages. It provides support for multiple mail box for each user ,in addition to, mailbox can be shared by multiple users. It is defined in RFC 2060.
MIME
Multiple Internet Mail Extension (MIME) tells the browser what is being sent e.g. attachment, format of the messages etc. It is not known as mail transfer protocol but it is used by your mail program.
NNTP and Others

There are many protocols that are provided by third-party providers. Some of them are Network News Transfer Protocol (NNTP), Secure Multipurpose Internet Mail Extensions (S/MIME) etc.
JavaMail Architecture

The java application uses JavaMail API to compose, send and receive emails. The JavaMail API uses SPI (Service Provider Interfaces) that provides the intermediatory services to the java application to deal with the different protocols. Let's understand it with the figure given below:
JavaMail API Architecture
JavaMail API Core Classes

There are two packages that are used in Java Mail API: javax.mail and javax.mail.internet package. These packages contains many classes for Java Mail API. They are:

    javax.mail.Session class
    javax.mail.Message class
    javax.mail.internet.MimeMessage class
    javax.mail.Address class
    javax.mail.internet.InternetAddress class
    javax.mail.Authenticator class
    javax.mail.PasswordAuthentication class
    javax.mail.Transport class
    javax.mail.Store class
    javax.mail.Folder class etc.


------------------------
java send mail explaination

Before explaining the Java program to send email, I will explain the classes and methods used here from Java Mail API, that will provide some background knowledge about the stuff here. This code is configured to send email from Gmail to any email service provider by using Java programming language. If you wish to send email from any other email service provider, then you need to change host (d_host) and port number (d_port) corresponding to the service provider. This requires Mail.jar to be downloaded which can be done here
Authenticator

This class obtains authentication for network connection. Authentication can be done by means of providing username, password. When authentication is required, the system will invoke a method on the subclass getPasswordAuthentication() and this will query about the authentication to number of inherited methods and returns the result.  

MIME Message

                This class represents MIME style email message.  This class provides methods to set various stuffs for sending emails. Some basic methods required for sending emails are setSubject, setFrom, addRecipient, setText these are self-explanatory by name.  Even bigger emails with HTML content can be sent through setContent method. Emails can also be sent to multiple people through addRecipients method. There are lot more interesting methods inside MIME Message.

Transport.send

                Transport is an abstract class that that models a message transport.  Send is a static method that sends the message to specified address along with data stored in MIME Message. If any invalid email is found it returns SendFailedException

JavaMail.java  - Download

package javamail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class JavaMail {    
    String d_email = "fromAddress@gmail.com",
            d_password = "password", //your email password
            d_host = "smtp.gmail.com",
            d_port = "465",
            m_to = "ToAddress", // Target email address
            m_subject = "Testing",
            m_text = "Hey, this is a test email.";
    
    public JavaMail() {
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);     
            MimeMessage msg = new MimeMessage(session);
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
   
    public static void main(String[] args) {
        JavaMail blah = new JavaMail();
    }
  
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
}



 

Possible Exceptions:

1) Unknown SMTP host: smtp.gmail.com - This error might occur if you do not have a valid internet connection.
2) Could not connect to SMTP host: smtp.gmail.com  - If you face this error, first disable your firewall and try running the code, still if you face this issue, then check your Antivirus settings.


-----------------------------
Java receive mail explaination

Lets see how to read/retreive email in your inbox using Javamail API. Its very simple, this tutorial explains this step by step. If you have not configured Javamail API in your IDE, please download it from here and get it configured only then you will be able to run this program.
                 As explained in the previous tutorial let me explain the classes and method used here, that will make us to understand the program in a better way. Below are the steps to read email :

Step 1 - Define Protocol
Step 2 - Get a session instance to read email
Step 3 - Access emails through store class
Step 4 - Read Inbox

Step 1 : Define Protocol
props.setProperty("mail.store.protocol", "imaps")
               First we need to define the protocol for processing emails.
SMTP - is the protocol to send email
POP3 -  is the protocol to receive emails
IMAP- IMAP is an acronym for Internet Message Access Protocol. Its an advanced protocol for receiving messages.
              This property takes two parameters (key, Value) key is "mail.store.protocol" and its value is "imaps" since we are going to read email protocol is defined as "imaps"

Step 2 : Get a session instance to read email
                  This property is used to get a session instance for reading email and its done as shown below in the code.
Session session = Session.getInstance(props, null);

Step 3 : Access emails through store class
Store - An abstract class that models a message store and its access protocol, for storing and retrieving messages. Store provides many common methods for naming stores, connecting to stores, and listening to connection events.
                We will be making use of connect(String host,String user,String password) method to connect to specified host and get access to Inbox.
Store store = session.getStore();
store.connect("imap.gmail.com", "yourEmailId@gmail.com", "password");
Folder inbox = store.getFolder("INBOX");

 Then we need to open the required folder in Read mode.
 inbox.open(Folder.READ_ONLY);

Summary: So far we have created a session and connected to gmail host with our username and password and got read access to Inbox.
 
Step 4 : Read Inbox
              We are almost done, now get access to your email using 'Message' class as shown below and typecast the content of the mail to Multipart to read the body of the email.
 Message msg = inbox.getMessage(1);

Here 1 indicates the first email received in your inbox and getMessageCount() will give you the number of emails in your inbox. So read the latest email use,
 Message msg = inbox.getMessage(inbox.getMessageCount());

import java.util.*;
import javax.mail.*;

public class ReadingEmail {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "yourEmailId@gmail.com", "password");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + bp.getContent());
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
}
