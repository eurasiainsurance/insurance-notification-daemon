package tech.lapsa.insurance.notifierDaemon.mail;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.mail.Session;

import tech.lapsa.javax.mail.MailBuilderException;
import tech.lapsa.javax.mail.MailFactory;
import tech.lapsa.javax.mail.impl.SessionMailFactory;

@Dependent
public class MailFactoryCDIProducer {

    public static final String JNDI_MAIL_COMPANY = "insurance/mail/messaging/CompanyNotification";
    public static final String JNDI_MAIL_USER = "insurance/mail/messaging/UserNotification";

    @Resource(mappedName = JNDI_MAIL_COMPANY)
    private Session companyMailSession;

    @Produces
    @QRecipientCompany
    public MailFactory companyMailFactory() throws MailBuilderException {
	return new SessionMailFactory(companyMailSession);
    }

    @Resource(mappedName = JNDI_MAIL_USER)
    private Session userMailSession;

    @Produces
    @QRecipientUser
    public MailFactory userMailFactory() throws MailBuilderException {
	return new SessionMailFactory(userMailSession);
    }
}
