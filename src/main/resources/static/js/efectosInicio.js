/*
document.addEventListener('DOMContentLoaded', function() {
	// Animar el menu de registro de jornada y produccion

	let formularioInicial = document.getElementById("usuario");
	let registroProduccion = document.getElementById("login_produccion");
	let registroJornada = document.getElementById("reg_jornada");
	let registroAdministracion = document.getElementById("login_administracion");
	let inputJornada = document.getElementById("jornada");
	let inputProduccion = document.getElementById("produccion");
	let inputAdministrador = document.getElementById("administracion");
	let botonAtras = document.getElementById("atras");

	/*
	Funcines para esconder el formulario de elección de
	registro de jornada o producción
	*/


	// Mostrar el formulario para registrar la jornada
	/*
	inputJornada.addEventListener("click", () => {
		formularioInicial.classList.add("ocultar_formulario_usuario");
		formularioInicial.classList.remove("usuario");
		document.getElementById("img_logo").style.display = "none";
		botonAtras.classList.add("mostrarAtras");
		botonAtras.classList.remove("atras");
		registroJornada.classList.add("mostrar_reg_jornada");
		registroJornada.classList.remove("registro_jornada");
	})

	// Mostrar el formulario para registrar la produccion

	inputProduccion.addEventListener("click", () => {
		formularioInicial.classList.add("ocultar_formulario_usuario");
		formularioInicial.classList.remove("usuario");
		botonAtras.classList.add("mostrarAtras");
		botonAtras.classList.remove("atras");
		registroProduccion.classList.add("mostrar_reg_produccion");
		registroProduccion.classList.remove("registro_produccion");
	})
	/*
	// Mostrar el formulario para la administración
		
	inputAdministrador.addEventListener("click", () => {
		formularioInicial.classList.add("ocultar_formulario_usuario");
		formularioInicial.classList.remove("usuario");
		botonAtras.classList.add("mostrarAtras");
		botonAtras.classList.remove("atras");
		registroAdministracion.classList.add("mostrar_reg_administracion");
		registroAdministracion.classList.remove("formularioAdministracion");
	})
	*/
	// Condiciones para mostrar el boton de "Volver"
	/*
	botonAtras.addEventListener("click", () => {

		document.getElementById("img_logo").style.display = "flex";

		if (registroJornada.className == "mostrar_reg_jornada") {
			registroJornada.classList.add("registro_jornada");
			registroJornada.classList.remove("mostrar_reg_jornada");
			botonAtras.classList.add("atras");
			botonAtras.classList.remove("mostrarAtras");
			formularioInicial.classList.add("usuario");
			formularioInicial.classList.remove("ocultar_formulario_usuario");
		} else if (registroProduccion.className == "mostrar_reg_produccion") {
			registroProduccion.classList.add("registro_produccion");
			registroProduccion.classList.remove("mostrar_reg_produccion");
			botonAtras.classList.add("atras");
			botonAtras.classList.remove("mostrarAtras");
			formularioInicial.classList.add("usuario");
			formularioInicial.classList.remove("ocultar_formulario_usuario");
		} else if (registroAdministracion.className == "mostrar_reg_administracion") {
			registroAdministracion.classList.add("formularioAdministracion");
			registroAdministracion.classList.remove("mostrar_reg_administracion");
			botonAtras.classList.add("atras");
			botonAtras.classList.remove("mostrarAtras");
			formularioInicial.classList.add("usuario");
			formularioInicial.classList.remove("ocultar_formulario_usuario");
		}
	})
})
*/






