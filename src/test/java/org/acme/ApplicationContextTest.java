package org.acme;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*Clase para hacer Test de la clase ApplicationContext*/
public class ApplicationContextTest {
    ApplicationContext context = new ApplicationContext();

    /*Test del connection Factory*/
    @Test
    public void testConnectionFactory() throws JMSException {
        // Configurar datos de prueba
        // Establece el nombre del host para la conexión
        context.setHost("qm1-ibm-mq.reniec.svc.cluster.local");
        // Establece el puerto para la conexión
        context.setPort(1414);
        // Establece el canalpara la conexión
        context.setChannel("DEV.APP.SVRCONN");
        // Establece el administrador de colas para la conexión
        context.setQueuemgr("qm1");
        // Establece el usuario para la conexión
        context.setUser("root");
        // Establece la contraseña  para la conexión
        context.setPassword("passw0rd");
        // Llamar al método de prueba
        ConnectionFactory connectionFactory = context.connectionFactory();
        // Aserciones adicionales
        assertNotNull(connectionFactory);

    }

    @Test
    void testConnectionFactoryWithInvalidConfiguration() {
        // Configuracion  del contexto con configuración incorrecta, por ejemplo, host no válido.
        context.setHost("invalidHost");
        assertThrows(JMSException.class, context::connectionFactory);
    }


}
