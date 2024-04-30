package com.example.recar.recar.controllers;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.recar.recar.models.Administrador;
import com.example.recar.recar.models.MySqlConnection;
import com.example.recar.recar.models.Operacion;

@Controller
@SessionAttributes("administrador")
public class AdministracionController {

	@GetMapping("/panelAdministracion")
	public String administracion(MySqlConnection panelAdministracion,
			@SessionAttribute("administrador") Administrador administrador, LocalDate fechaActual, Model model) {

		// Lista donde se guardará toda la producción
		List<Operacion> listaOperaciones = new ArrayList<Operacion>();
		panelAdministracion.open();

		String consulta = "SELECT * FROM operacionesrecord";
		try {
			ResultSet listadoProduccion = panelAdministracion.executeSelect(consulta);
			while (listadoProduccion.next()) {
				Operacion datosOperacion = new Operacion();
				datosOperacion.setMatricula(listadoProduccion.getNString("matricula"));
				datosOperacion.setInterior(listadoProduccion.getInt("interior"));
				datosOperacion.setExterior(listadoProduccion.getInt("exterior"));
				datosOperacion.setCompleto(listadoProduccion.getInt("completo"));
				datosOperacion.setOzono(listadoProduccion.getInt("ozono"));
				datosOperacion.setRepostaje(listadoProduccion.getDouble("repostaje"));
				datosOperacion.setObservaciones(listadoProduccion.getString("observaciones"));

				listaOperaciones.add(datosOperacion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			panelAdministracion.close();
		}

		// Define el formato de la fecha
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
		model.addAttribute("administrador", administrador.getNombre());
		model.addAttribute("fechaActual", LocalDate.now().format(formato));
		model.addAttribute("listaOperaciones", listaOperaciones);
		return "/views/panelAdministracion";
	}
}
