
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.camel.Exchange;

import org.acme.bean.Respuesta;
import org.acme.bindy.ftp.Header;

public class ValidationProcessor implements Processor{

     @Override
    public void process(Exchange exchange) throws Exception {

        System.out.println("=====GET INFOR VALIDATOR");  

        //Boolean flgGenToken = false;
        int cantidadLimite = 0;
        int cantTotalSubTram = 0;
        Header query = exchange.getIn().getBody(Header.class);
        
        System.out.println("=====GET INFOR VALIDATOR111111" + query);  

        String tipoCons = query.tipoConsulta.trim();

        System.out.println("=====GET INFOR VALIDATOR3333" + query.subTramaConsulta);  

        switch (tipoCons) {
            case "1":

                cantidadLimite = 153;
                //flgGenToken = true;

                break;
            case "2":

                cantidadLimite = 30;
                //flgGenToken = true;

                break;
            default:
                exchange.getIn().setBody(new Respuesta(query.getTramaHeader() + "5010"));
                return;
                
        }

        cantTotalSubTram = query.subTramaConsulta.length();

        if(cantTotalSubTram != cantidadLimite )
        {
            
            System.out.println("=====ERROR en cantidad limite:" + cantTotalSubTram );  
            System.out.println("=====ERROR en cantidad limite2:" + cantidadLimite );  

            exchange.getIn().setBody(new Respuesta(query.getTramaHeader() + (cantTotalSubTram == 0 ? "5011" : "5100")));

            return;
        }

        exchange.getIn().setBody(query.getTramaHeader2());

        return ;

        // if(flgGenToken == true)
        // {

        //     String jwtToken =
        //         Jwt.issuer("https://example.com/issuer") 
        //         .upn("jdoe@quarkus.io") 
        //         .claim("agencia", query.agenciaInstSolic) 
        //         .claim("servidor", query.codServerReniec)
        //         .sign();

        //         System.out.println("=====Token" + jwtToken);  

        //         System.out.println("=====ok");  

        //         query.setToken(jwtToken);

        //         // exchange.getIn().setBody(new RespuestaToken(query.version,
        //         // query.lonCabecera,
        //         // query.tipoServicio,
        //         // query.longTotalTrama,
        //         // query.fragmentacion,
        //         // query.TTL,
        //         // query.tipoConsulta,
        //         // query.caractVerif,
        //         // query.codInstitucion,
        //         // query.codServerReniec,
        //         // query.agenciaInstSolic,
        //         // query.usuarioFinalInst,
        //         // query.hostFinalInst,
        //         // query.reservado,
        //         // query.subTramaConsulta,
        //         // query.token
        //         // ));
        //         exchange.getIn().setBody(query.getTramaHeaderToken());
        //         //exchange.getIn().setBody(query);
        //         return;
        // }


        // if(!tipoCons.equalsIgnoreCase("1") && !tipoCons.equalsIgnoreCase("2") ){
        
        //     System.out.println("=====ERROR en tipo consulta:" + tipoCons );  

        //     exchange.getIn().setBody(new Respuesta(query.getTramaHeader() + "5010"));

        //     return;
        // }else{

        //     String jwtToken =
        //     Jwt.issuer("https://example.com/issuer") 
        //         .upn("jdoe@quarkus.io") 
        //         .claim("agencia", query.agenciaInstSolic) 
        //         .claim("servidor", query.codServerReniec)
        //     .sign();

        //     System.out.println("=====Token" + jwtToken);  

        //     System.out.println("=====ok");  

        //     query.setToken(jwtToken);

        //     //exchange.getIn().setBody(new RespuestaToken(query.getTramaHeaderToken()));
        //     exchange.getIn().setBody(new RespuestaToken(query.version,
        //     query.lonCabecera,
        //     query.tipoServicio,
        //     query.longTotalTrama,
        //     query.fragmentacion,
        //     query.TTL,
        //     query.tipoConsulta,
        //     query.caractVerif,
        //     query.codInstitucion,
        //     query.codServerReniec,
        //     query.agenciaInstSolic,
        //     query.usuarioFinalInst,
        //     query.hostFinalInst,
        //     query.reservado,
        //     query.token
        //     ));
        //     return;
        // }

    }

    //  private String calcularSHA256(String texto) {
    //     try {
    //         // Obtener una instancia de MessageDigest con el algoritmo SHA-256

    //         System.out.println("=====Token1222:" + texto);  

    //         MessageDigest digest = MessageDigest.getInstance("SHA-256");


    //         System.out.println("=====Token122333:");  

    //         // Obtener el arreglo de bytes del texto
    //         byte[] hashBytes = digest.digest(texto.getBytes(StandardCharsets.UTF_8));

    //         System.out.println("=====Token4444:" + hashBytes);  

    //         String resultado = Base64.getEncoder().encodeToString(hashBytes);

    //         System.out.println("=====Token5555:" + resultado);  

    //         // Convertir el arreglo de bytes a una representación Base64
    //         return resultado;
    //     } catch (NoSuchAlgorithmException e) {
    //         // Manejar la excepción según tus necesidades
    //         throw new RuntimeException("Error al calcular el hash SHA-256", e);
    //     }
    // }
}