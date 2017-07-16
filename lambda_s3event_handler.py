import boto3

s3_client = boto3.client('s3')


def lambda_handler(event, context):
    for record in event['Records']:
        if record['s3']['object']['key'].__eq__('exception'):
            response = s3_client.get_object(Bucket="polaris-bucket", Key="exception")
            emailcontent = response['Body'].read().decode('utf-8')
            send_email(emailcontent)


def send_email(emailcontent):
    import smtplib
    gmail_user = "polarislambda@gmail.com"
    gmail_pwd = "Worldworld111"
    TO = "minaievmykola@ukr.net"

    headers = [
        "From: " + gmail_user,
        "Subject: " + "Polaris application exception",
        "To: " + TO,
        "MIME-Version: 1.0",
        "Content-Type: text/html"]
    headers = "\r\n".join(headers)
    try:
        server = smtplib.SMTP("smtp.gmail.com", 587)
        server.ehlo()
        server.starttls()
        server.login(gmail_user, gmail_pwd)
        server.sendmail(gmail_user, TO, headers + '\r\n\r\n' + emailcontent)
        server.close()
        print('successfully sent the mail')
    except smtplib.SMTPException:
        print("failed to send mail")