package org.acme;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.acme.bean.Respuesta2;
import org.acme.bean.Respuesta4;
import org.acme.bindy.ftp.Header;
import org.acme.bindy.ftp.HeaderConsulta;
import org.acme.bindy.ftp.HeaderConsulta2;
import org.acme.processor.ValidationProcessor;
import org.acme.processor.ValidationProcessor2;
import org.acme.processor.ValidationProcessor3;
import org.acme.processor.ValidationProcessor4;
import org.acme.processor.ValidationProcessor5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Clase para hacer pruebas unitarias
 */
@QuarkusTest
class GreetingResourceTest {

     /**
      * Test del metodo procesarData de la clase ValidationProcessor en caso se le
      * envie un Header correcto (y el tipo consulta es 2)
      */
     @Test
     void testValidationProcessorPorDNICorrecto() {
          var validationProcessor = new ValidationProcessor();
          var query = new Header();
          query.headVersion = "0002";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = "2";
          query.headCaractVerif = "RENIECPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC001 ";
          query.headAgenciaInstSolic = "0000INS000";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = "706006481                     ";

          var rpta = validationProcessor.procesarData(query);
          assertNull(rpta, "la respuesta deberia ser null");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor en caso se le
      * envie un Header incorrecto
      */
     @ParameterizedTest
     @CsvSource({
               "'1', '706006481                     '", // PorDNI
               "'2', ''", // Por nombre
               "'3', ''",// tipo incorrecto
     })
     void testValidationProcessorInCorrecto(String tipo, String trama) {
          var validationProcessor = new ValidationProcessor();
          var query = new Header();
          query.headVersion = "0002";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = tipo;
          query.headCaractVerif = "RENIECPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC001 ";
          query.headAgenciaInstSolic = "0000INS000";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = trama;

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta deberia ser incorrecta");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor en caso se le
      * envie un Header incorrecto
      */
     @Test
     void testValidationProcessorPorDNIVersionIncorrecto() {
          var validationProcessor = new ValidationProcessor();
          var query = new Header();
          query.headVersion = "0003";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = "2";
          query.headCaractVerif = "RENIECPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC001 ";
          query.headAgenciaInstSolic = "0000INS000";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = "706006481                     ";

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta deberia ser incorrecta");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor en caso se le
      * envie un Header incorrecto
      */
     @Test
     void testValidationProcessorPorDNICaractVerifIncorrecto() {
          var validationProcessor = new ValidationProcessor();
          var query = new Header();
          query.headVersion = "0002";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = "2";
          query.headCaractVerif = "RENIXXPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC001 ";
          query.headAgenciaInstSolic = "0000INS000";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = "706006481                     ";

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta deberia ser incorrecta");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor en caso se le
      * envie un Header incorrecto
      */
     @Test
     void testValidationProcessorPorDNIServidorIncorrecto() {
          var validationProcessor = new ValidationProcessor();
          var query = new Header();
          query.headVersion = "0002";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = "2";
          query.headCaractVerif = "RENIECPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC991 ";
          query.headAgenciaInstSolic = "0000INS000";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = "706006481                     ";

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta deberia ser incorrecta");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor en caso se le
      * envie un Header incorrecto
      */
     @Test
     void testValidationProcessorPorAgenciaIncorrecto() {
          var validationProcessor = new ValidationProcessor();
          var query = new Header();
          query.headVersion = "0002";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = "2";
          query.headCaractVerif = "RENIECPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC001 ";
          query.headAgenciaInstSolic = "";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = "706006481                     ";

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta deberia ser incorrecta");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor en caso se le
      * envie un Header incorrecto
      */
     @Test
     void testValidationProcessorTipoConsIncorrecto() {
          var validationProcessor = new ValidationProcessor();
          var query = new Header();
          query.headVersion = "0002";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = "";
          query.headCaractVerif = "RENIECPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC001 ";
          query.headAgenciaInstSolic = "0000INS000";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = "706006481                     ";

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta deberia ser incorrecta");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor2 en caso se le
      * envie un query correcto
      */
     @Test
     void testValidationProcessor2Correcto() {
          var validationProcessor = new ValidationProcessor2();
          var rpta = validationProcessor.procesarData(
                    "00020128000000023000                      0000000002RENIECPERURENIECDE2116    RENIEC001 0000INS00070600648  HOST000000          706006481                     ");
          assertNull(rpta, "la respuesta deberia ser null");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor2 en caso se le
      * envie un query incorrecto
      */
     @Test
     void testValidationProcessor2Incorrecto() {
          var validationProcessor = new ValidationProcessor2();
          var rpta = validationProcessor.procesarData("00020128000000023000                      0000000002RENIECPE");
          assertNotNull(rpta, "la respuesta deberia ser incorrecta");
     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor3
      */
     @Test
     void testValidationProcessor() {
          var validationProcessor = new ValidationProcessor3();

          var query = new HeaderConsulta();
          query.version = "0002";
          query.lonCabecera = "0128";
          query.tipoServicio = "000";
          query.longTotalTrama = "000023000";
          query.fragmentacion = "                      ";
          query.ttl = "000000000";
          query.tipoConsulta = "2";
          query.caractVerif = "RENIECPERURENIEC";
          query.codInstitucion = "DE2116    ";
          query.codServerReniec = "RENIEC001 ";
          query.agenciaInstSolic = "0000INS000";
          query.usuarioFinalInst = "70600648  ";
          query.hostFinalInst = "HOST000000";
          query.reservado = "          ";
          query.nroDNI = "706006481";
          query.tipoSubConsulta = "     ";
          query.formatoFirma = " ";
          query.reservadoSubTrama = "                ";

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta no deberia ser null");
     }

     /**
      * Test de los metodos getTramaHeader2 de las clases Header y HeaderConsulta
      */
     @Test
     void testHeader() {
          var query = new Header();
          query.headVersion = "0002";
          query.headLonCabecera = "0128";
          query.headTipoServicio = "000";
          query.headLongTotalTrama = "000023000";
          query.headFragmentacion = "                      ";
          query.headTtl = "000000000";
          query.headTipoConsulta = "2";
          query.headCaractVerif = "RENIECPERURENIEC";
          query.headCodInstitucion = "DE2116    ";
          query.headCodServerReniec = "RENIEC001 ";
          query.headAgenciaInstSolic = "0000INS000";
          query.headUsuarioFinalInst = "70600648  ";
          query.headHostFinalInst = "HOST000000";
          query.headReservado = "          ";
          query.headSubTramaConsulta = "706006481                     ";

          assertEquals(
                    "00020128000000023000                      0000000002RENIECPERURENIECDE2116    RENIEC001 0000INS00070600648  HOST000000          706006481                     ",
                    query.getTramaHeader2(), "metodo getTramaHeader2 incorrecto");

          var query2 = new HeaderConsulta();
          query2.version = "0002";
          query2.lonCabecera = "0128";
          query2.tipoServicio = "000";
          query2.longTotalTrama = "000023000";
          query2.fragmentacion = "                      ";
          query2.ttl = "000000000";
          query2.tipoConsulta = "2";
          query2.caractVerif = "RENIECPERURENIEC";
          query2.codInstitucion = "DE2116    ";
          query2.codServerReniec = "RENIEC001 ";
          query2.agenciaInstSolic = "0000INS000";
          query2.usuarioFinalInst = "70600648  ";
          query2.hostFinalInst = "HOST000000";
          query2.reservado = "          ";
          query2.nroDNI = "706006481";
          query2.tipoSubConsulta = "     ";
          query2.formatoFirma = " ";
          query2.reservadoSubTrama = "               ";
          assertEquals(query.getTramaHeader(), query2.getTramaHeader(), "metodo getTramaHeader incorrecto");

          var query3 = new HeaderConsulta2();
          query3.header2Version = "0002";
          query3.header2LonCabecera = "0128";
          query3.header2TipoServicio = "000";
          query3.header2LongTotalTrama = "000023000";
          query3.header2Fragmentacion = "                      ";
          query3.header2Ttl = "000000000";
          query3.header2TipoConsulta = "2";
          query3.header2CaractVerif = "RENIECPERURENIEC";
          query3.header2CodInstitucion = "DE2116    ";
          query3.header2CodServerReniec = "RENIEC001 ";
          query3.header2AgenciaInstSolic = "0000INS000";
          query3.header2UsuarioFinalInst = "70600648  ";
          query3.header2HostFinalInst = "HOST000000";
          query3.header2Reservado = "          ";
          query3.header2Coincidencias = "706006481";
          query3.header2Grupo = "     ";
          query3.header2ApellidoPaterno = " ";
          query3.header2ApellidoMaterno = "               ";
          query3.header2Prenombres = "               ";
          query3.header2ReservadoSubConsulta = "               ";
          assertEquals(query3.getTramaHeader(), query3.getTramaHeader(), "metodo getTramaHeader incorrecto");

          var respuesta = new Respuesta2(query2.version,
                    query2.lonCabecera,
                    query2.tipoServicio,
                    query2.longTotalTrama,
                    query2.fragmentacion,
                    query2.ttl,
                    query2.tipoConsulta,
                    query2.caractVerif,
                    query2.codInstitucion,
                    query2.codServerReniec,
                    query2.agenciaInstSolic,
                    query2.usuarioFinalInst,
                    query2.hostFinalInst,
                    query2.reservado,
                    query2.nroDNI,
                    query2.tipoSubConsulta,
                    query2.formatoFirma,
                    query2.reservadoSubTrama);

          assertEquals(query2.version, respuesta.getVersion(), "metodo getVersion incorrecto");
          assertEquals(query2.lonCabecera, respuesta.getLonCabecera(), "metodo getLonCabecera incorrecto");
          assertEquals(query2.tipoServicio, respuesta.getTipoServicio(), "metodo getTipoServicio incorrecto");
          assertEquals(query2.longTotalTrama, respuesta.getLongTotalTrama(), "metodo getLongTotalTrama incorrecto");
          assertEquals(query2.fragmentacion, respuesta.getFragmentacion(), "metodo getFragmentacion incorrecto");
          assertEquals(query2.ttl, respuesta.getTtl(), "metodo getTtl incorrecto");
          assertEquals(query2.tipoConsulta, respuesta.getTipoConsulta(), "metodo getTipoConsulta incorrecto");
          assertEquals(query2.caractVerif, respuesta.getCaractVerif(), "metodo getCaractVerif incorrecto");
          assertEquals(query2.codInstitucion, respuesta.getCodInstitucion(), "metodo getCodInstitucion incorrecto");
          assertEquals(query2.codServerReniec, respuesta.getCodServerReniec(), "metodo getCodInstitucion incorrecto");
          assertEquals(query2.agenciaInstSolic, respuesta.getAgenciaInstSolic(), "metodo getCodInstitucion incorrecto");
          assertEquals(query2.usuarioFinalInst, respuesta.getUsuarioFinalInst(),
                    "metodo getUsuarioFinalInst incorrecto");
          assertEquals(query2.hostFinalInst, respuesta.getHostFinalInst(), "metodo getHostFinalInst incorrecto");
          assertEquals(query2.reservado, respuesta.getReservado(), "metodo getReservado incorrecto");
          assertEquals(query2.nroDNI, respuesta.getNroDNI(), "metodo getNroDNI incorrecto");
          assertEquals(query2.tipoSubConsulta, respuesta.getTipoSubConsulta(), "metodo getTipoSubConsulta incorrecto");
          assertEquals(query2.formatoFirma, respuesta.getFormatoFirma(), "metodo getFormatoFirma incorrecto");
          assertEquals(query2.reservadoSubTrama, respuesta.getReservadoSubTrama(),
                    "metodo getReservadoSubTrama incorrecto");

          var respuestaNombres = new Respuesta4(query3.header2Version,
                    query3.header2LonCabecera,
                    query3.header2TipoServicio,
                    query3.header2LongTotalTrama,
                    query3.header2Fragmentacion,
                    query3.header2Ttl,
                    query3.header2TipoConsulta,
                    query3.header2CaractVerif,
                    query3.header2CodInstitucion,
                    query3.header2CodServerReniec,
                    query3.header2AgenciaInstSolic,
                    query3.header2UsuarioFinalInst,
                    query3.header2HostFinalInst,
                    query3.header2Reservado,
                    query3.header2Coincidencias,
                    query3.header2Grupo,
                    query3.header2ApellidoPaterno,
                    query3.header2ApellidoMaterno,
                    query3.header2Prenombres,
                    query3.header2ReservadoSubConsulta);

          assertEquals(query3.header2Version, respuestaNombres.getRptaVersion(), "metodo getVersion incorrecto");
          assertEquals(query3.header2LonCabecera, respuestaNombres.getRptaLonCabecera(),
                    "metodo getLonCabecera incorrecto");
          assertEquals(query3.header2TipoServicio, respuestaNombres.getRptaTipoServicio(),
                    "metodo getTipoServicio incorrecto");
          assertEquals(query3.header2LongTotalTrama, respuestaNombres.getRptaLongTotalTrama(),
                    "metodo getLongTotalTrama incorrecto");
          assertEquals(query3.header2Fragmentacion, respuestaNombres.getRptaFragmentacion(),
                    "metodo getFragmentacion incorrecto");
          assertEquals(query3.header2Ttl, respuestaNombres.getRptaTtl(), "metodo getTtl incorrecto");
          assertEquals(query3.header2TipoConsulta, respuestaNombres.getRptaTipoConsulta(),
                    "metodo getTipoConsulta incorrecto");
          assertEquals(query3.header2CaractVerif, respuestaNombres.getRptaCaractVerif(),
                    "metodo getCaractVerif incorrecto");
          assertEquals(query3.header2CodInstitucion, respuestaNombres.getRptaCodInstitucion(),
                    "metodo getCodInstitucion incorrecto");
          assertEquals(query3.header2CodServerReniec, respuestaNombres.getRptaCodServerReniec(),
                    "metodo getCodInstitucion incorrecto");
          assertEquals(query3.header2AgenciaInstSolic, respuestaNombres.getRptaAgenciaInstSolic(),
                    "metodo getCodInstitucion incorrecto");
          assertEquals(query3.header2UsuarioFinalInst, respuestaNombres.getRptaUsuarioFinalInst(),
                    "metodo getUsuarioFinalInst incorrecto");
          assertEquals(query3.header2HostFinalInst, respuestaNombres.getRptaHostFinalInst(),
                    "metodo getHostFinalInst incorrecto");
          assertEquals(query3.header2Reservado, respuestaNombres.getRptaReservado(), "metodo getReservado incorrecto");
          assertEquals(query3.header2Coincidencias, respuestaNombres.getRptaCoincidencias(),
                    "metodo getNroDNI incorrecto");
          assertEquals(query3.header2Grupo, respuestaNombres.getRptaGrupo(), "metodo getTipoSubConsulta incorrecto");
          assertEquals(query3.header2ApellidoPaterno, respuestaNombres.getRptaApellidoPaterno(),
                    "metodo getFormatoFirma incorrecto");
          assertEquals(query3.header2ApellidoMaterno, respuestaNombres.getRptaApellidoMaterno(),
                    "metodo getReservadoSubTrama incorrecto");
          assertEquals(query3.header2Prenombres, respuestaNombres.getRptaPrenombres(),
                    "metodo getReservadoSubTrama incorrecto");
          assertEquals(query3.header2ReservadoSubConsulta, respuestaNombres.getRptaReservadoSubConsulta(),
                    "metodo getReservadoSubTrama incorrecto");

     }

     /**
      * Test del metodo procesarData de la clase ValidationProcessor4
      */

     @Test
     void testValidationProcessor2() {
          var validationProcessor = new ValidationProcessor4();

          var query = new HeaderConsulta2();
          query.header2Version = "0002";
          query.header2LonCabecera = "0128";
          query.header2TipoServicio = "000";
          query.header2LongTotalTrama = "000023000";
          query.header2Fragmentacion = "                      ";
          query.header2Ttl = "000000000";
          query.header2TipoConsulta = "2";
          query.header2CaractVerif = "RENIECPERURENIEC";
          query.header2CodInstitucion = "DE2116    ";
          query.header2CodServerReniec = "RENIEC001 ";
          query.header2AgenciaInstSolic = "0000INS000";
          query.header2UsuarioFinalInst = "70600648  ";
          query.header2HostFinalInst = "HOST000000";
          query.header2Reservado = "          ";
          query.header2Coincidencias = "0030";
          query.header2Grupo = "0060";
          query.header2ApellidoPaterno = "Beltran                                 ";
          query.header2ApellidoMaterno = "Chavez                                  ";
          query.header2Prenombres = "Jorges                                                      ";
          query.header2ReservadoSubConsulta = "     ";

          var rpta = validationProcessor.procesarData(query);
          assertNotNull(rpta, "la respuesta no deberia ser null");
     }

}