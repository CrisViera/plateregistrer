package com.example.recar.recar.controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.recar.recar.models.MySqlConnection;
import com.example.recar.recar.models.Operacion;

@Controller
@SessionAttributes("operacion")
public class MostrarProduccionController {

	@GetMapping("/produccion")
	public String produccion(@SessionAttribute("operacion") Operacion operacion,
			MySqlConnection produccion,
			Model model) {
		
		// Lista donde se guardará toda la producción
		List<Operacion> listaOperaciones = new ArrayList<Operacion>();
		produccion.open();
		
		String consulta = "SELECT * FROM operacionesrecord WHERE dniOperario = '" + operacion.getDni() + "'";
		try {
			ResultSet listadoProduccion = produccion.executeSelect(consulta);
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
			produccion.close();
		}
		
		model.addAttribute("listaOperaciones", listaOperaciones);
		return "/views/produccion";
	}
}
