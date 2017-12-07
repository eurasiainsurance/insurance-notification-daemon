package tech.lapsa.insurance.notificationDaemon.drivenBeans;

import static tech.lapsa.insurance.shared.jms.InsuranceDestinations.*;

import java.util.Locale;

import javax.ejb.MessageDriven;

import com.lapsa.insurance.domain.InsuranceRequest;
import com.lapsa.insurance.domain.Request;
import com.lapsa.international.localization.LocalizationLanguage;

import tech.lapsa.insurance.shared.notification.NotificationMessages;

@MessageDriven(mappedName = NOTIFIER_NEW_INSURANCE_COMPANY_PUSH)
public class NewInsuranceCompanyPushDrivenBean extends PushRequestNotificationBase<InsuranceRequest> {

    public NewInsuranceCompanyPushDrivenBean() {
	super(InsuranceRequest.class);
    }

    private static final LocalizationLanguage DEFAULT_LANGUAGE = LocalizationLanguage.RUSSIAN;

    @Override
    protected NotificationMessages getTitleMessageBudnle() {
	return NotificationMessages.INSURANCE_COMPANY_PUSH_TITLE;
    }

    @Override
    protected NotificationMessages getBodyMessageBudnle() {
	return NotificationMessages.INSURANCE_COMPANY_PUSH_BODY;
    }

    @Override
    protected String getChannelIdConfigurationProperty() {
	return Constants.PROPERTY_COMPANY_PUSH_CHANNEL_ID;
    }

    @Override
    protected String getPushURLConfigurationProperty() {
	return Constants.PROPERTY_COMPANY_PUSH_URL;
    }

    @Override
    protected Locale locale(final Request request) {
	return DEFAULT_LANGUAGE.getLocale();
    }

}