/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

import com.eam.proyecto.DTO.Comparendo;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Daryl Ospina
 */
public class ComparendoNegocio extends Negocio<Comparendo> {
    
    public ComparendoNegocio(Class<Comparendo> entityClass) {
        super(entityClass);
    }
    
    public ArrayList<Comparendo> cargarConConsulta(String consulta){
        return new ArrayList<>(this.dao.cargarConsulta(consulta, Comparendo.class));
    }

    public ArrayList<Object[]> cargarPrecios() {
        String consulta = ""
                + "SELECT "
                + "     (SELECT V.VALOR_SALARIO_MINIMO FROM Valores V)*TF.Salarios_Minimos,C.Id "
                + "FROM "
                + "     Tipo_Infraccion TF JOIN Comparendo C ON(C.Tipo_Infraccion_Codigo=TF.Codigo)";

        return new ArrayList(this.dao.cargarConsulta(consulta, null));
    }

    public String transformarComparendosConPreciosEnJson(ArrayList<Object[]> precios, ArrayList<Comparendo> comparendos) {

        JSONArray array = new JSONArray();

        for (int i = 0; i < comparendos.size(); i++) {
            JSONObject objTotal = new JSONObject(), agente = new JSONObject(), infractor = new JSONObject(), municipioId = new JSONObject(),
                    tipoInfraccionCodigo = new JSONObject(), vehiculoPlaca = new JSONObject(), testigo = new JSONObject();

            Comparendo comparendo = comparendos.get(i);

            //Agente
            agente.put("direccion", comparendo.getAgente().getDireccion());
            agente.put("eps", comparendo.getAgente().getEps());
            agente.put("fechaNacimiento", comparendo.getAgente().getFechaNacimiento().toString());
            JSONObject agenteMuni = new JSONObject();
            agenteMuni.put("id", comparendo.getAgente().getMunicipioId().getId());
            agenteMuni.put("nombre", comparendo.getAgente().getMunicipioId().getNombre());
            agente.put("municipioId", agenteMuni);
            agente.put("nip", comparendo.getAgente().getNip());
            agente.put("nombreCompleto", comparendo.getAgente().getNombreCompleto());
            if (comparendo.getAgente().getPlacaAgente() != null) {
                agente.put("placaAgente", comparendo.getAgente().getPlacaAgente());
            }
            agente.put("telefono", comparendo.getAgente().getTelefono());
            JSONObject agenteTipoD = new JSONObject();
            agenteTipoD.put("id", comparendo.getAgente().getTipoDocumento().getId());
            agenteTipoD.put("nombre", comparendo.getAgente().getTipoDocumento().getNombre());
            agente.put("tipoDocumento", agenteTipoD);

            //infractor
            infractor.put("direccion", comparendo.getInfractor().getDireccion());
            infractor.put("eps", comparendo.getInfractor().getEps());
            infractor.put("fechaNacimiento", comparendo.getInfractor().getFechaNacimiento().toString());
            JSONObject infractorMuni = new JSONObject();
            infractorMuni.put("id", comparendo.getInfractor().getMunicipioId().getId());
            infractorMuni.put("nombre", comparendo.getInfractor().getMunicipioId().getNombre());
            infractor.put("municipioId", agenteMuni);
            infractor.put("nip", comparendo.getInfractor().getNip());
            infractor.put("nombreCompleto", comparendo.getInfractor().getNombreCompleto());
            if (comparendo.getInfractor().getPlacaAgente() != null) {
                infractor.put("placaAgente", comparendo.getInfractor().getPlacaAgente());
            }
            infractor.put("telefono", comparendo.getInfractor().getTelefono());
            JSONObject infractorTipoD = new JSONObject();
            infractorTipoD.put("id", comparendo.getInfractor().getTipoDocumento().getId());
            infractorTipoD.put("nombre", comparendo.getInfractor().getTipoDocumento().getNombre());
            infractor.put("tipoDocumento", agenteTipoD);

            //tipoInfraccion
            tipoInfraccionCodigo.put("codigo", comparendo.getTipoInfraccionCodigo().getCodigo());
            tipoInfraccionCodigo.put("descripcion", comparendo.getTipoInfraccionCodigo().getDescripcion());
            tipoInfraccionCodigo.put("inmovilizacion", comparendo.getTipoInfraccionCodigo().getInmovilizacion());
            tipoInfraccionCodigo.put("salariosMinimos", comparendo.getTipoInfraccionCodigo().getSalariosMinimos());
            tipoInfraccionCodigo.put("suspencionLicencia", comparendo.getTipoInfraccionCodigo().getSuspencionLicencia());

            //Vehiculo
            vehiculoPlaca.put("capacidadCarga", comparendo.getVehiculoPlaca().getCapacidadCarga());
            vehiculoPlaca.put("claseVehiculo", comparendo.getVehiculoPlaca().getClaseVehiculo());
            if (comparendo.getVehiculoPlaca().getEmpresaNit() != null) {
                JSONObject vehiculoEmpresa = new JSONObject();
                vehiculoEmpresa.put("nit", comparendo.getVehiculoPlaca().getEmpresaNit().getNit());
                vehiculoEmpresa.put("nombre", comparendo.getVehiculoPlaca().getEmpresaNit().getNombre());
                vehiculoPlaca.put("empresaNit", vehiculoEmpresa);
                vehiculoPlaca.put("licenciaTransito", comparendo.getVehiculoPlaca().getLicenciaTransito());
            }
            vehiculoPlaca.put("linea", comparendo.getVehiculoPlaca().getLinea());
            vehiculoPlaca.put("lugarMatricula", comparendo.getVehiculoPlaca().getLugarMatricula());
            vehiculoPlaca.put("marca", comparendo.getVehiculoPlaca().getMarca());
            vehiculoPlaca.put("modelo", comparendo.getVehiculoPlaca().getModelo());
            vehiculoPlaca.put("nacionalidad", comparendo.getVehiculoPlaca().getNacionalidad());
            vehiculoPlaca.put("noTargetaOperacion", comparendo.getVehiculoPlaca().getNoTargetaOperacion());
            vehiculoPlaca.put("numeroPasajeros", comparendo.getVehiculoPlaca().getNumeroPasajeros());
            vehiculoPlaca.put("placa", comparendo.getVehiculoPlaca().getPlaca());
            vehiculoPlaca.put("tipoVehiculo", comparendo.getVehiculoPlaca().getTipoVehiculo());

            //Comparendo
            objTotal.put("agente", agente);
            objTotal.put("descripcion", comparendo.getDescripcion());
            objTotal.put("estado", comparendo.getEstado());
            objTotal.put("fecha", comparendo.getFecha().toString());
            objTotal.put("id", comparendo.getId());
            objTotal.put("infractor", infractor);
            objTotal.put("localidadComuna", comparendo.getLocalidadComuna());
            objTotal.put("modalidadTransporte", comparendo.getModalidadTransporte());
            municipioId.put("id", comparendo.getMunicipioId().getId());
            municipioId.put("nombre", comparendo.getMunicipioId().getNombre());
            objTotal.put("municipioId", municipioId);
            objTotal.put("radioAccion", comparendo.getRadioAccion());
            objTotal.put("tipoInfraccionCodigo", tipoInfraccionCodigo);
            objTotal.put("tipoInfractor", comparendo.getTipoInfractor());
            objTotal.put("vehiculoPlaca", vehiculoPlaca);
            objTotal.put("viaPrincipal", comparendo.getViaPrincipal());
            objTotal.put("viaSecundaria", comparendo.getViaSecundaria());

            //Testigo
            if (comparendo.getTestigo() != null) {
                testigo.put("direccion", comparendo.getTestigo().getDireccion());
                testigo.put("eps", comparendo.getTestigo().getEps());
                testigo.put("fechaNacimiento", comparendo.getTestigo().getFechaNacimiento().toString());
                JSONObject testigoMuni = new JSONObject();
                testigoMuni.put("id", comparendo.getTestigo().getMunicipioId().getId());
                testigoMuni.put("nombre", comparendo.getTestigo().getMunicipioId().getNombre());
                testigo.put("municipioId", testigoMuni);
                testigo.put("nip", comparendo.getTestigo().getNip());
                testigo.put("nombreCompleto", comparendo.getTestigo().getNombreCompleto());
                if (comparendo.getTestigo().getPlacaAgente() != null) {
                    testigo.put("placaAgente", comparendo.getTestigo().getPlacaAgente());
                }
                testigo.put("telefono", comparendo.getTestigo().getTelefono());
                JSONObject testigoTipoD = new JSONObject();
                testigoTipoD.put("id", comparendo.getTestigo().getTipoDocumento().getId());
                testigoTipoD.put("nombre", comparendo.getTestigo().getTipoDocumento().getNombre());
                testigo.put("tipoDocumento", testigoTipoD);

                objTotal.put("testigo", testigo);
            }

            //Añadir precio
            for (int k = 0; k < precios.size(); k++) {
                if (comparendo.getId().intValueExact() == (new BigDecimal(precios.get(k)[1].toString())).intValueExact()) {
                    objTotal.put("Precio", precios.get(k)[0]);
                    break;
                }
            }

            //añadir a el arrayJson
            array.add(objTotal);

        }

        return array.toString();
    }

}
