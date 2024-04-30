package com.example.recar.recar.controllers;

import java.sql.ResultSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.recar.recar.models.Administrador;
import com.example.recar.recar.models.MySqlConnection;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("administrador")
public class InicioSesionAdminController {
	@PostMapping("/administracion")
	public String administracion(@RequestParam("usuario") String usuario, @RequestParam("password") String password,
			MySqlConnection administracion, HttpSession session, Model model) {

		boolean dniEncontrado = false;
		administracion.open();
		String consulta = "SELECT * FROM administradores";

		// Se obtienen los administradores de la BBDD
		try {
			ResultSet listadoAdministradores = administracion.executeSelect(consulta);
			while (listadoAdministradores.next()) {
				if (listadoAdministradores.getString("dni").toUpperCase().equalsIgnoreCase(usuario)
						&& listadoAdministradores.getString("password").toUpperCase().equalsIgnoreCase(password)) {

					Administrador administrador = new Administrador();
					administrador.setDni(listadoAdministradores.getString("dni").toUpperCase());
					administrador.setNombre(listadoAdministradores.getString("nombre").toUpperCase());
					session.setAttribute("administrador", administrador);
					dniEncontrado = true;
				}
				
			}

			// Si no se encontró el usuario, redirigir con mensaje de error
			if (!dniEncontrado) {

				return "redirect:/?errorUsuario";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			administracion.close();
		}

		return "redirect:/panelAdministracion";
	}

}
