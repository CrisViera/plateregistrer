package com.example.recar.recar.controllers;

//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//import com.example.recar.recar.models.CentrosdeTrabajo;
import com.example.recar.recar.models.MySqlConnection;


@Controller
@SessionAttributes("operacion")
public class IndexController {

    // Controladora principal de la vista index
    @GetMapping("/")
    public String index(
    			SessionStatus session,
                MySqlConnection buscarCentrosDeTrabajo,
                @RequestParam(name = "errorUsuario", required = false) String errorUsuario,
                Model model) {
        if(session != null) {
        	// Elimina el atributo de sesión 'operacion'
        	session.setComplete();
        }
        /* 
        // Crea una lista de centros de trabajo
        List<CentrosdeTrabajo> listadoDeCentros = new ArrayList<>();

        // Abre la conexión y crea la consulta
        buscarCentrosDeTrabajo.open();
        String consultaCentros = "SELECT * FROM empresas";

        // Ejecuta la consulta, añade valores al objeto "centrosDeTrabajo" y a la lista
        try {
            ResultSet resultadoCentros = buscarCentrosDeTrabajo.executeSelect(consultaCentros);
            while (resultadoCentros.next()) {
            	CentrosdeTrabajo centrosDeTrabajo = new CentrosdeTrabajo();
                centrosDeTrabajo.setCif(resultadoCentros.getString("cif"));
                centrosDeTrabajo.setCentroDeTrabajo(resultadoCentros.getString("empresa"));
                centrosDeTrabajo.setCodigo(resultadoCentros.getString("codigo"));
                centrosDeTrabajo.setIsla(resultadoCentros.getString("isla"));

                listadoDeCentros.add(centrosDeTrabajo);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            buscarCentrosDeTrabajo.close();
        }

        model.addAttribute("centrosDeTrabajo", listadoDeCentros);
        */
        model.addAttribute("titulo", "Recar");
        if(errorUsuario != null) {
        	model.addAttribute("errorUsuario");
        }

        return "index";
    }
    
}
