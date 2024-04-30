/*
* En esta sección se regulan las acciones de los checkbox "Interior", "Exterior" y "Completo".
* En caso de que "Completo" esté seleccionado, quita la selección de "Interior" y "Exterior" si están seleccionados.
* En caso de que "Interior" o "Exterior" estén seleccionados, quita la selección de "Completo" si está seleccionado.
*/

document.addEventListener('DOMContentLoaded', function() {
	// Obtener referencias a los campos de formulario
	let matriculaInput = document.getElementById('matricula'); // Recoge el valor de matricula
	let interiorCheckbox = document.getElementById('interior'); // Recoger valor del checkbox interior
	let exteriorCheckbox = document.getElementById('exterior'); // Recoger valor del checkbox exterior
	let completoCheckbox = document.getElementById('completo'); // Recoger valor del checkbox completo
	let interiorCheckmark = document.getElementById('checkmarkInterior'); // Recoger el "visto" del checkbox interior
	let exteriorCheckmark = document.getElementById('checkmarkExterior'); // Recoger el "visto" del checkbox exterior
	let completoCheckmark = document.getElementById('checkmarkCompleto'); // Recoger el "visto" del checkbox completo
	let repostaje = document.getElementById('repostaje'); // Recoger el valor de repostaje
	let observaciones = document.getElementById('observaciones'); // Recoger el valor de observaciones
	let botonRegistrarOperacion = document.getElementById('registrarOperacion'); // Recoger el clic del boton registrarOperacion
	

	// Agregar eventos de cambio a los checkboxes
	interiorCheckbox.addEventListener('change', handleCheckboxChange);
	exteriorCheckbox.addEventListener('change', handleCheckboxChange);
	completoCheckbox.addEventListener('change', handleCheckboxChange);

	// Función para manejar los cambios en los checkboxes
	function handleCheckboxChange() {

		// Establecer clases y color de fondo según el estado del checkbox
		interiorCheckmark.classList.toggle('not-selected', !interiorCheckbox.checked);
		exteriorCheckmark.classList.toggle('not-selected', !exteriorCheckbox.checked)
		completoCheckmark.classList.toggle('not-selected', !completoCheckbox.checked);

	}

	// Agregar evento de clic al botón "botonRegistrarOperacion"
	botonRegistrarOperacion.addEventListener('click', function(event) {

		// Expresión regular para validar matrícula: 4 números seguidos de 3 letras
        let regex = /^\d{4}[a-zA-Z]{3}$/;
        let matricula = matriculaInput.value.trim();
        
		// Verificar si el campo de matrícula está vacío
		if (matricula === '') {
			// Mostrar un alert indicando que la matrícula es obligatoria
			alert('La matrícula es obligatoria');
			// Prevenir el envío del formulario
            event.preventDefault();
            return; // Salir de la función si la matrícula está vacía
            
        /*
		* Verificar si el formato de matrícula es correcto,
		* si alguno de los checkbox se ha seleccionado
		* y si los campos tienen alguna información. Si no, no se 
		* puede continuar y se avisa al operario
		*/
		}else if(!regex.test(matricula)){
			alert("El formato de matrícula no es correcto, debe ser 0000AAA");
			event.preventDefault();
            return; // Salir de la función si la matrícula está vacía
		} else if(!interiorCheckbox.checked && 
		   !exteriorCheckbox.checked && 
		   !completoCheckbox.checked && 
		   repostaje.value.trim() === '' && 
		   observaciones.value.trim() === ''){
			alert("No ha seleccionado ninguna operación para la matrícula " + matricula);
			event.preventDefault();
		}
		
		
	});

})