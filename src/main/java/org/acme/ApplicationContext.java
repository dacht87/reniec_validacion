package org.acme;

import org.apache.camel.component.jms.JmsComponent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.io.IOException;
import jakarta.jms.JMSException;
import lombok.Getter;
import lombok.Setter;

import com.ibm.msg.client.jakarta.jms.JmsConnectionFactory;
import com.ibm.msg.client.jakarta.jms.JmsConstants;
import com.ibm.msg.client.jakarta.jms.JmsFactoryFactory;
import com.ibm.msg.client.jakarta.wmq.common.CommonConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.jms.ConnectionFactory;

/**
 * Clase que configura la conexion a las colass de mq
 * */
@ApplicationScoped
@Getter
@Setter
public class ApplicationContext {

    /*host del mq*/
    @ConfigProperty(name = "app.jms.host")
    private String host;

    /*puerto del mq*/
    @ConfigProperty(name = "app.jms.port")
    private int port;

    /*canal de la cola mq*/
    @ConfigProperty(name = "app.jms.channel")
    private String channel;

    /*queue manager de la cola mq*/
    @ConfigProperty(name = "app.jms.queuemgr")
    private String queuemgr;

    /*usuario de la cola mq*/
    @ConfigProperty(name = "app.jms.user")
    private String user;

    /*contraseña de la cola mq*/
    @ConfigProperty(name = "app.jms.password")
    private String password;

    /**
     * Metodo que configura la conexion a las colass de mq
     * @return el ConnectionFactory con la configuracion de mq
     * */
    @Produces
    @Default
    public ConnectionFactory connectionFactory() throws JMSException {
        
        JmsFactoryFactory ff;
        JmsConnectionFactory factory; 
        try {        
            ff = JmsFactoryFactory.getInstance(JmsConstants.JAKARTA_WMQ_PROVIDER);
            factory = ff.createConnectionFactory();
            factory.setIntProperty(CommonConstants.WMQ_CONNECTION_MODE, CommonConstants.WMQ_CM_CLIENT);
            factory.setStringProperty(CommonConstants.WMQ_HOST_NAME, this.host);
            factory.setIntProperty(CommonConstants.WMQ_PORT, this.port);
            factory.setStringProperty(CommonConstants.WMQ_CHANNEL, this.channel);
            factory.setStringProperty(CommonConstants.WMQ_QUEUE_MANAGER, this.queuemgr);
            factory.setStringProperty(JmsConstants.USERID, this.user);
            factory.setStringProperty(JmsConstants.PASSWORD, this.password);
            factory.setBooleanProperty(JmsConstants.USER_AUTHENTICATION_MQCSP, true);
        } catch (JMSException je) {
            throw je;
        }
        return factory;
    }

    
    /**
     * Metodo que configura el JmsComponet que contiene el ConnectionFactory
     * @return el JmsComponent
     * */
    @Produces
    @Default
    public JmsComponent jms() throws IOException, JMSException {
      try(var jmsComponent = new JmsComponent()){
        jmsComponent.setConnectionFactory(connectionFactory());
        return jmsComponent;
      }
    }

}
