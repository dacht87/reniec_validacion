package org.acme.adapter;

import org.acme.bean.Respuesta4;
import org.acme.bean.consultanombres.ConsultaNombresResponse;
import org.acme.bean.header.Header;
import org.acme.utils.Constants;

public class ConsultaNombresAdapter {
	public ConsultaNombresResponse adaptConsultaByNamesResponse(Respuesta4 respuesta) {
		Header headers = new Header(
				respuesta.getRptaVersion(), 
				respuesta.getRptaLonCabecera(), 
				respuesta.getRptaTipoServicio(), 
				respuesta.getRptaLongTotalTrama(), 
				respuesta.getRptaFragmentacion(), 
				respuesta.getRptaTtl(), 
				respuesta.getRptaTipoConsulta(), 
				respuesta.getRptaCaractVerif(), 
				respuesta.getRptaCodInstitucion(), 
				respuesta.getRptaCodServerReniec(), 
				respuesta.getRptaAgenciaInstSolic(), 
				respuesta.getRptaUsuarioFinalInst(), 
				respuesta.getRptaHostFinalInst(), 
				Constants.RESERVADO_HEADER_LENGTH);
		int numCoincidenciasSolicitadas = Integer.parseInt(respuesta.getRptaCoincidencias());
		int inicioGrupo = Integer.parseInt(respuesta.getRptaGrupo());
		String apellidoPaterno = respuesta.getRptaApellidoPaterno().trim();
		String apellidoMaterno = respuesta.getRptaApellidoMaterno().trim();
		String prenombres = respuesta.getRptaPrenombres().trim();
		int reservadoSubTrama = Constants.RESERVADO_REQUEST_BY_NAME_SUB_TRAMA_LENGTH;
		ConsultaNombresResponse response = new ConsultaNombresResponse(
				headers, 
				numCoincidenciasSolicitadas, 
				inicioGrupo, 
				apellidoPaterno, 
				apellidoMaterno, 
				prenombres, 
				reservadoSubTrama);
		response.validate();
		return response;
	}
}
