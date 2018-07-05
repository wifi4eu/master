package cec.budg.soa.gui;

import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class AsynchronousInvocationForm extends CustomComponent implements Button.ClickListener {
	
	private static Logger LOGGER = Logger.getLogger("budg.soa.logging");
	private static final long serialVersionUID = -4657076247283424408L;
	private TextField messageCorrelation;
	private Button okBtn, discardBtn;
	private BeanFieldGroup<SoaMessageCall> fieldGroup;
	private BeanItemContainer<SoaMessageCall> messagesContainer;

	
	public AsynchronousInvocationForm(BeanItemContainer<SoaMessageCall> messagesContainer,  String selectionDescription) {
		this.messagesContainer = messagesContainer;
		FormLayout layout = new FormLayout();

		messageCorrelation = new TextField("\n Message Correlation");
		messageCorrelation.setRequired(false);

		layout.addComponent(messageCorrelation);
		layout.addComponent(new Label(selectionDescription, ContentMode.HTML));
	
		HorizontalLayout buttonBar = new HorizontalLayout();
		buttonBar.setSpacing(true);
		okBtn = new Button("Submit");
		okBtn.addClickListener(this);
		discardBtn = new Button("Clear messages");
		discardBtn.addClickListener(this);
		buttonBar.addComponent(okBtn);
		buttonBar.addComponent(discardBtn);
		layout.addComponent(buttonBar);
		fieldGroup = new BeanFieldGroup<SoaMessageCall>(SoaMessageCall.class);
		fieldGroup.setItemDataSource(new SoaMessageCall());
		fieldGroup.bindMemberFields(this);
		setCompositionRoot(layout);
	}

	
	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getSource() == okBtn) {
			SoaMessageCall msgCall = fieldGroup.getItemDataSource().getBean();
			msgCall.setInvMethod("ASYNC");
			try {
				fieldGroup.commit();
				LOGGER.info("Message Correlation="+msgCall.getMessageCorrelation());
				if(msgCall.getMessageCorrelation()!=null && msgCall.getMessageCorrelation().isEmpty() ){
					msgCall.setMessageCorrelation(UUID.randomUUID().toString());
				}

				HashMap<String,String> retHashMap = ((Budg_soa_webUI)UI.getCurrent()).getJmsProducer().sendMessage(msgCall.getMessageCorrelation());
				msgCall.setDatabaseName(retHashMap.get("DB_NAME"));
				msgCall.setAppVersion(retHashMap.get("APP_VERSION"));
				msgCall.setSuccessfullInvocation(true);

				messagesContainer.addBean(msgCall);

				fieldGroup.setItemDataSource(new SoaMessageCall());

			} catch (CommitException e) {
				Notification.show("Submit exception", "Unable to submit input.",
						Notification.Type.ERROR_MESSAGE);
			}
			catch (Exception e) {
				LOGGER.error("Error",e);
				msgCall.setErrorMessage(e.getMessage());
				msgCall.setSuccessfullInvocation(false);
				messagesContainer.addBean(msgCall);
				fieldGroup.setItemDataSource(new SoaMessageCall());
			}
		} else {
			messagesContainer.removeAllItems();
			fieldGroup.discard();
		}
	}
}