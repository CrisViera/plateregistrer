package com.example.recar.recar.controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.recar.recar.models.MySqlConnection;
import com.example.recar.recar.models.Operacion;
import com.example.recar.recar.models.Trabajador;

import jakarta.servlet.http.HttpSession;


@Controller
@SessionAttributes("operacion")
public class InicioSesionController {

	/*
	 * Controladora que recoge los datos de inicio de sesion, comprueba la BBDD y
	 * verifica que existe.
	 */

	@PostMapping("/inicioSesion")
	public String inicioSesion(
			@RequestParam("dni") String dni, 
			@RequestParam("isla") String isla,
			@RequestParam("empresa") String cod_empresa,
			MySqlConnection operarios,
			HttpSession session,
			Model model) {
		
		// Se crea una lista para guardar los operarios obtenidos de la BBDD
		List<Trabajador> listaOperarios = new ArrayList<Trabajador>();
		boolean dniEncontrado = false;
		operarios.open();
		String consulta = "SELECT * FROM operarios";
		
		// Se obtienen los usuarios de la BBDD
		try {
			ResultSet listadoOperarios = operarios.executeSelect(consulta);
			while (listadoOperarios.next()) {
		        Trabajador trabajador = new Trabajador();
		        trabajador.setDni(listadoOperarios.getString("dni").toUpperCase());
		        trabajador.setNombre(listadoOperarios.getString("nombre").toUpperCase());
		        listaOperarios.add(trabajador);

		        // Verificar si el DNI coincide
		        if (trabajador.getDni().equals(dni.toUpperCase())) {
		            dniEncontrado = true;

		            // Crear objeto Operacion y agregar a la variable de sesion
		            Operacion datosOperacion = new Operacion();
		            datosOperacion.setDni(trabajador.getDni());
		            datosOperacion.setNombre(trabajador.getNombre());
		            datosOperacion.setCodigo(cod_empresa);
		            session.setAttribute("operacion", datosOperacion);
		        }
		    }

		    // Si no se encontró el DNI, redirigir con mensaje de error
		    if (!dniEncontrado) {
		        
		        return "redirect:/?errorOperario";
		    }

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			operarios.close();
		}
		
		return "redirect:/operaciones";
	}

}
