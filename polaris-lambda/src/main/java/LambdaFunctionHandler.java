import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class LambdaFunctionHandler implements RequestHandler<S3Event, Object> {

    private static final Logger LOG = LoggerFactory.getLogger(LambdaFunctionHandler.class);

    private static final String KEY = "exception";
    private static final String SENDER = "polarislambda@gmail.com";
    private static final String RECIPIENT = "minaievmykola@ukr.net";
    private static final String HOST = "smtp.gmail.com";
    private static final String SUBJECT = "Polaris application exception";
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static final String SMTP_PORT = "465";
    private static final String GMAIL_PASSWORD = "Worldworld111";
    private static final String INTRODUCTION = "<html><body>Dear " + RECIPIENT + ", please review following stack trace:<br><br><br>";
    private static final String CONCLUSION = "<br><br><br>Best regards,<br>Polaris support team</body></html>";

    public Object handleRequest(S3Event s3Event, Context context) {
        if (s3Event.toJson().contains(KEY)) {
            String bucketName = s3Event.getRecords().get(0).getS3().getBucket().getName();
            AmazonS3 s3Client = new AmazonS3Client();
            S3Object s3Object = s3Client.getObject(bucketName, KEY);
            InputStream objectData = s3Object.getObjectContent();
            String emailData = readFromS3ObjectContent(objectData);
            sendEmailToRecipient(emailData);
        }
        return null;
    }

    private String readFromS3ObjectContent(InputStream objectData) {
        StringBuilder result = new StringBuilder();
        String line;
        result.append("<div style=\"text-shadow:1px 1px 1px;font-weight:normal;letter-spacing:0pt;word-spacing:2pt;font-size:12px;" +
                "text-align:left;font-family:comic sans, comic sans ms, cursive, verdana, arial, sans-serif;line-height:1;\">");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(objectData))){
            while ((line = reader.readLine()) != null) {
                result.append(line).append("<br>");
            }
        } catch (IOException e) {
            LOG.error(format("Can't read from %s", objectData));
        }
        result.append("</div>");
        return result.toString().trim();
    }

    private void sendEmailToRecipient(String email) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", SMTP_PORT);
        properties.setProperty("mail.smtp.socketFactory.port", SMTP_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.transport.protocol", "smtp");
        try {
            Session session = Session.getDefaultInstance(properties,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(SENDER, GMAIL_PASSWORD);
                        }
                    });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
            message.setSubject(SUBJECT);
            message.setContent(INTRODUCTION + email + CONCLUSION, "text/html");
            Transport.send(message);
            LOG.info("Sent message successfully");
        } catch (MessagingException mex) {
            LOG.info(format("Message sendind was failed: %s", mex.getMessage()));
        }
    }
}
