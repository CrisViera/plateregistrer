package com.example.recar.recar.controllers;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.recar.recar.models.MySqlConnection;
import com.example.recar.recar.models.Operacion;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("operacion")
public class RegistrarOperacionController {

	// Controladora para mostrar la vista de insertar producción
	@GetMapping("/operaciones")
	public String insertarProduccion(Model model, @SessionAttribute("operacion") Operacion operacion) {

		model.addAttribute("nombre", operacion.getNombre());
		model.addAttribute("matricula", operacion.getMatricula());

		return "/views/modeloProduccion";
	}

	// Controladora para recibir y procesar las operaciones
	@PostMapping("/registroOperacion")
	public String registrarOperacion(@RequestParam(name = "matricula", defaultValue = "") String matricula,
			@RequestParam(name = "interior", defaultValue = "false") String interiorStr,
			@RequestParam(name = "exterior", defaultValue = "false") String exteriorStr,
			@RequestParam(name = "completo", defaultValue = "false") String completoStr,
			@RequestParam(name = "ozono", defaultValue = "false") String ozonoStr,
			@RequestParam(name = "repostaje", defaultValue = "0.0") String repostaje,
			@RequestParam(name = "observaciones", defaultValue = " ") String observaciones,
			@RequestParam(name = "errorMatricula", required = false) String errorMatricula,
			@RequestParam(name = "errorOperacion", required = false) String errorOperacion, HttpSession session,
			@SessionAttribute("operacion") Operacion operacion, MySqlConnection datosOperacion, LocalDate fechaActual,
			Model model) {

		int interiorValue = 0;
		int exteriorValue = 0;
		int completoValue = 0;
		int ozonoValue = 0;
		
		if(interiorStr.equals("on")) {
			interiorValue = 1;
		}
		if(exteriorStr.equals("on")) {
			exteriorValue = 1;
		}
		if(completoStr.equals("on")) {
			completoValue = 1;
		}
		if(ozonoStr.equals("on")) {
			ozonoValue = 1;
		}

		// Comprueba que la matrícula no esté vacía o en blanco
		if (matricula.isEmpty() || matricula.isBlank()) {
			return "redirect:/operaciones?errorMatricula";
		}

		// Comprueba que la matrícula tenga el formato correcto

		// Patrón para validar matrícula: 4 números seguidos de 3 letras
		String patron = "\\d{4}[a-zA-Z]{3}";

		// Compila el patrón en un objeto Pattern
		Pattern pattern = Pattern.compile(patron);

		// Crea un objeto Matcher con la matrícula y el patrón
		Matcher matcher = pattern.matcher(matricula);

		// Comprueba si la matrícula coincide con el patrón
		if (!matcher.matches()) {
			return "redirect:/operaciones?errorMatricula";
		}

		// Guarda la matrícula en la variable de sesión

		operacion.setMatricula(matricula);
		session.setAttribute("operacion", operacion);

		// Comprueba que hay alguna operación seleccionada
		if (interiorStr.equals("false") && exteriorStr.equals("false") && completoStr.equals("false")) {

			return "redirect:/operaciones?errorOperacion";
		}

		// Comprueba si completo e interior están seleccionadas
		if (completoStr.equals("on") && interiorStr.equals("on")) {
			return "redirect:/operaciones?operacionInvalida";
		}

		// Comprueba si completo y exterior están seleccionadas
		if (completoStr.equals("on") && exteriorStr.equals("on")) {
			return "redirect:/operaciones?operacionInvalida";
		}

		// Comprueba si interior y exterior están seleccionadas
		if (interiorStr.equals("on") && exteriorStr.equals("on")) {
			interiorValue = 0;
			exteriorValue = 0;
			completoValue = 1;
		}

		// Inserta los datos en la BBDD
		datosOperacion.open();

		String datosOperaciones = "INSERT INTO operacionesrecord (" + "dniOperario," + "matricula," + " empresa,"
				+ " interior," + " exterior," + " completo," + " ozono," + " repostaje," + " observaciones," + " fecha)"
				+ "VALUES ('" + operacion.getDni() + "'," + " '" + matricula + "'," + " '" + operacion.getCodigo()
				+ "'," + " '" + interiorValue + "'," + " '" + exteriorValue + "'," + " '" + completoValue + "'," + " '"
				+ ozonoValue + "'," + " '" + repostaje + "'," + " '" + observaciones + "'," + " '" + LocalDate.now()
				+ "');" + "";

		try {
			datosOperacion.executeInsert(datosOperaciones);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			datosOperacion.close();
		}

		return "redirect:/operaciones?success";
	}
}
