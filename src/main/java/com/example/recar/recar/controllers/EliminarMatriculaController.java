package com.example.recar.recar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recar.recar.models.MySqlConnection;

@Controller
public class EliminarMatriculaController {

	@GetMapping(value="/eliminarOperacion")
	public String eliminarOperacion(
			@RequestParam(name = "eliminar") String matriculaEliminar,
			MySqlConnection eliminarOperacion) {
		
		eliminarOperacion.open();
		String consulta = "DELETE FROM operacionesrecord WHERE matricula = '" + matriculaEliminar + "'";
		try {
			eliminarOperacion.executeUpdateOrDelete(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eliminarOperacion.close();
		}
		
		return "redirect:/produccion";
	}
}
