package cec.budg.soa.gui;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;

import cec.budg.soatube.client.async.JmsProducerLocal;
import cec.budg.soatube.client.sync.SoatubeWSClientLocal;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;



@SuppressWarnings("serial")
@Theme("jms-vaadtheme")

public class Budg_soa_webUI extends UI {

	private static Logger LOGGER = Logger.getLogger("budg.soa.logging");
	private static final long serialVersionUID = -6733290242808872455L;
	private static final String DESCRIPTION = "DG BUDG basic services connectivity";

	private AsynchronousInvocationForm beanItemContainerForm;
	private SynchronousInvocationForm    synchronousInvocationForm;
	private BeanItemContainer<SoaMessageCall> messageContainer;
	private SoatubeWSClientLocal soaTubeWSClient;
	private JmsProducerLocal jmsProducer;

	//@WebServlet(value = "/*", asyncSupported = false)
	@WebServlet(urlPatterns = {"/UIDL","/UIDL/*","/VAADIN","/VAADIN/*"})
	@VaadinServletConfiguration(productionMode = true, ui = Budg_soa_webUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		try {
			InitialContext ic = new InitialContext();
//			soaTubeWSClient = (SoatubeWSClientLocal)ic.lookup("java:comp/env/ejb/SoatubeWSClient");
//			jmsProducer = (JmsProducerLocal)ic.lookup("java:comp/env/ejb/JmsProducer");
			jmsProducer = (JmsProducerLocal)ic.lookup("java:global/wifi4eu-financial/wifi4eu-financial-web/JmsProducer");
			soaTubeWSClient = (SoatubeWSClientLocal)ic.lookup("java:global/wifi4eu-financial/wifi4eu-financial-web/SoatubeWSClient");

		} catch (Exception e) {
			e.printStackTrace();
		}

		buildMessagesContainer();
		setContent(buildLayout());
	}

	public SoatubeWSClientLocal getSoaTubeWSClient() {

		return soaTubeWSClient;

	}
	public JmsProducerLocal getJmsProducer() {

		return jmsProducer;

	}

	private Component buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		buildBeanItemContainerForm();
		TabSheet tabsheet = new TabSheet();
		tabsheet.addTab(beanItemContainerForm, "Asynchronous Invocation");
		tabsheet.addTab(synchronousInvocationForm, "Synchronous Invocation");
		layout.setWidth("100%");
		layout.addComponent(new Label(DESCRIPTION));
		layout.addComponent(tabsheet);


		layout.addComponent(buildMessageInfoTable());
		return layout;
	}
	private void buildBeanItemContainerForm() {
		beanItemContainerForm = new AsynchronousInvocationForm(messageContainer,
				"Asynchronous service invocation : Please choose a message correlation (will be auto-generated  if left empty)");



		synchronousInvocationForm = new SynchronousInvocationForm(messageContainer,
				"Synchronous service invocation : Please choose a message correlation (will be auto-generated  if left empty)");
	}
	private Table buildMessageInfoTable() {
		Table messageInfoTable = new Table();
		messageInfoTable.setWidth("100%");
		messageInfoTable.setContainerDataSource(messageContainer);
		messageInfoTable.setVisibleColumns("messageCorrelation", "status" , "invMethod" , "databaseName");
		messageInfoTable.setColumnHeaders( new String[] {" Correlation ID","Status", "Invocation method", " Database Name"} );
		messageInfoTable.setSelectable(true);



		messageInfoTable.setCellStyleGenerator(new Table.CellStyleGenerator() {
			@Override
			public String getStyle( Table table , Object itemId, Object propertyId) {

				String styleName=null;

				if(propertyId!=null){
					if(propertyId.equals("status")){
						Item item = table.getItem(itemId);

						boolean success= (Boolean) item.getItemProperty("successfullInvocation").getValue();
						if(success){
							return "success";
						}
						else{
							return "failure";
						}
					}
				}
				return styleName;
			}
		});


		messageInfoTable.addValueChangeListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(Property.ValueChangeEvent event) {
				SoaMessageCall  soaMessageCall = ((SoaMessageCall)event.getProperty().getValue());
				if(soaMessageCall!=null && soaMessageCall.isSuccessfullInvocation()==false){
					String errMsg=soaMessageCall.getErrorMessage()==null? "" : soaMessageCall.getErrorMessage();
					Notification notif = new Notification("Response Error", errMsg, Notification.Type.ERROR_MESSAGE);
					notif.show(Page.getCurrent());
				}
			}
		});
		return messageInfoTable;
	}


	private void buildMessagesContainer() {
		messageContainer = new BeanItemContainer<SoaMessageCall>(SoaMessageCall.class);
	}
}


