# Sistema para “Gestión de pedidos en una cafetería universitaria digital"

## ACTIVIDAD 1: Abstracción
### Objetivos del Sistema:
Gestionar de manera eficiente los pedidos de una cafetería universitaria, reduciendo el tiempo de espera en fila y optimizando comunicación del estudiante y/o maestro con la cocina.

### Actores:
-	**Estudiante / Profesor (Cliente):** Revisar el Menú y Realizar Pedidos.
-	**Personal de Cocina:** Recibir las Ordenes y Marcar Pedido Listo.
-	**Administrador:** Gestionar el Menú.
-	**Sistema de Pago (Sistema Externo):** Procesa la transacción bancaria.

### Funciones Principales:
-	Mostrar Catálogo de productos
-	Registrar Pedido
-	Procesar Pago
-	Informar Sobre el Estado del Pedido
  
### Límites del Sistema:
No incluye una muestra del inventario de ingredientes.

### Diagrama de contexto:

<img width="621" height="441" alt="Diagrama de Contexto" src="https://github.com/user-attachments/assets/d2e5c4b9-ac57-4eec-858e-5a66f6c92d66" />

## ACTIVIDAD 2: MODULARIDAD

<img width="1081" height="571" alt="Diagrama de Módulo" src="https://github.com/user-attachments/assets/43d7dc29-8066-41c8-a5f4-2fe89b7d7d83" />

## ACTIVIDAD 3: REFINAMIENTO
### Pseudocódigo de la función crearPedidos:

'''
  Funcion
  
    FUNCION crearPedidos (usuario_id, lista_items):
  
	  //1. Validar Disponibilidad
	  PARA CADA item EN lista_items:
		    SI item.stock < cantidad_solicitada:
			      RETORNAR error “El Producto” + item.nombre +  “ Se Encuentra Agotado”
  
	  //2. Calcular Costos
	  subtotal = MULTIPLICAR(item.precio * cantidad)
	  total = subtotal + impuestos

	  //3. Crear Registro Preliminar
	  orden = NUEVA Orden(usuario_id, lista_items, estado="PENDIENTE_PAGO")

	  //4. Procesar Pago
	  resultado_pago = ModuloPagos.procesar(tarjeta_usuario, total)
	  SI resultado_pago ES "EXITOSO": 
        orden.estado = "EN_PREPARACION"
        GUARDAR orden EN BaseDeDatos
        DISMINUIR stock de ítems
        ModuloNotificaciones.enviar(usuario_id, "Tu pedido #" + orden.id + " se está cocinando")
        ModuloCocina.agregarAlaCola(orden) 
        RETORNAR "Éxito, pedido realizado"
	  SINO:
        orden.estado = "CANCELADO"
        RETORNAR error "El pago fue rechazado"

    FIN FUNCION
'''

## ACTIVIDAD 4: Aplicación de Principios

1.	¿Cómo es flexible el diseño? 
El diseño es flexible porque utiliza una arquitectura modular. Si mañana la universidad decide cambiar la pasarela de pagos (por ejemplo, de un banco local a PayPal), solo se necesita modificar el "Módulo de Pagos". El resto del sistema (Cocina, Menú, Pedidos) no se entera del cambio y sigue funcionando igual. Esto se llama bajo acoplamiento.

2.	¿Cómo permite pruebas (Testing)?
Al haber separado la lógica en funciones específicas (como en el pseudocódigo), podemos crear pruebas unitarias. Podemos probar la función calcularTotal enviándole precios falsos para ver si suma bien, sin necesidad de hacer un pago real con tarjeta de crédito. También podemos usar "Mocks" (simuladores) para la cocina y probar el sistema sin tener cocineros conectados.

3.	¿Cómo reutiliza componentes?
El "Módulo de Autenticación" es altamente reutilizable. Si la universidad crea luego una app para la "Biblioteca" o el "Gimnasio", puede usar exactamente el mismo código de login para que el estudiante entre con la misma cuenta. Igualmente, el "Componente de Botones" de la interfaz gráfica se diseña una vez y se usa en todas las pantallas.

4.	¿Qué pasaría si crece a varias sedes?
(Escalabilidad) Si el sistema crece, la base de datos debe incluir un campo sede_id en todas las tablas (Menú, Pedidos, Cocina).
- En la Arquitectura: Se puede usar un balanceador de carga para distribuir el tráfico.
- En el Menú: Al filtrar el menú, el sistema primero preguntará: SELECT * FROM menu WHERE sede_id = 'Sede_Norte'. Esto permite que cada cafetería tenga su propio stock y precios, pero usando el mismo sistema centralizado (Software as a Service - SaaS).

## ACTIVIDAD 5: Arquitectura

<img width="701" height="591" alt="Diagrama de despliegue" src="https://github.com/user-attachments/assets/bea8adbf-2d18-4ccc-9960-9d7d301d7422" />

