<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Evaluacion</title>
		<link rel="stylesheet"	href="<c:url value="/css/bootstrap/css/bootstrap.css"/>" />
		<link rel="stylesheet"	href="<c:url value="/css/fontawesome/web-fonts-with-css/css/fontawesome-all.css"/>" />
		<link rel="stylesheet"	href="<c:url value="/css/alertify.css"/>" />
		<link rel="stylesheet"	href="<c:url value="/css/alertify.rtl.css"/>" />
	</head>
	<body >
		<div id="app">
			<h1>Evaluacion</h1>
			<div class="container">
				<div class="row m-2">
					<label class="m-2">Agrregar un usuario</label> <button class="m-2 btn btn-success" @click="agregarM()"> Agregar </button>
				</div>
				<table class="table">
				  <thead class="thead-light">
					    <tr>
					      <th scope="col">Nombre(s)</th>
					      <th scope="col">Apellidos</th>
					      <th scope="col">Estudios</th>
					      <th scope="col">Edad</th>
					      <th scope="col">Domicilio</th>
					      <th scope="col">Curp</th>
					      <th scope="col">Actualiza</th>
					      <th scope="col">Elimina</th>
					    </tr>
				  </thead>
				  <tbody>
				  	<tr v-for="u in usuarios ">
				      <td>{{u.nombres}}</td>
				      <td>{{u.apellidos}}</td>
				      <td>{{u.estudioSup}}</td>
				      <td>{{u.edad}}</td>
				      <td>{{u.domicilio}}</td>
				      <td>{{u.curp}}</td>
				      <td>
				      	<button type="button" aria-label="Close" class="btn btn-warning" @click="actualiza(u.idUsuario )">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </td>
				      <td>
				      	<button type="button" aria-label="Close" class="btn btn-danger" @click="validaelimina(u.idUsuario )">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </td>
				   	</tr>
				  </tbody>
				</table>
				<div class="modal fade" id="usuario" tabindex="-1" role="dialog" aria-labelledby="usuario" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel">Guardar usuario</h5>
				        <button type="button" aria-label="Close" class="btn" @click="cerrar()">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        
						<div class="input-group mb-3">
							<label for="basic-url" class="m-2">Nombre</label>
						  	<input type="text" class="form-control" placeholder="Nombre" v-model="usuario.nombres">
						</div>
						
						<div class="input-group mb-3">
							<label for="basic-url" class="m-2">Apellidos</label>
						  	<input type="text" class="form-control" placeholder="Apellidos" v-model="usuario.apellidos">
						</div>
						
						<div class="input-group mb-3">
							<label for="basic-url" class="m-2">Estudios superior</label>
						  	<input type="text" class="form-control" placeholder="Estudios superior" v-model="usuario.estudioSup">
						</div>
						
						<div class="input-group mb-3">
							<label for="basic-url" class="m-2">Edad</label>
						  	<input type="number" class="form-control" v-model="usuario.edad">
						</div>
						
						<div class="input-group mb-3">
							<label for="basic-url" class="m-2">Domicilio</label>
						  	<input type="text" class="form-control" placeholder="Domicilio" v-model="usuario.domicilio">
						</div>
						
						<div class="input-group mb-3">
							<label for="basic-url" class="m-2">CURP</label>
						  	<input type="text" class="form-control" placeholder="CURP" v-model="usuario.curp">
						</div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-danger" @click="cerrar()">Cancelar</button>
				        <button type="button" class="btn btn-success" @click="guardar(usuario.idUsuario)">Guardar</button>
				      </div>
				    </div>
				  </div>
				</div>
				<div class="modal fade" id="elimina" tabindex="-1" role="dialog" aria-labelledby="elimina" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel">Confirma la eliminacion del usuario</h5>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-danger" @click="elimina()">Confirmar</button>
				        <button type="button" class="btn btn-success" @click="cancelaElimina()">Cancelar</button>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</div>
	</body>
	
	<script src="<c:url value="/js/jquery.js"/>"></script>
	<script src="<c:url value="/js/bootstrap/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/js/vue.js"/>"></script>
	<script src="<c:url value="/js/axios.js"/>"></script>
	<script src="<c:url value="/js/alertify.js"/>"></script>
	<script src="<c:url value="/js/evaluacion.js"/>"></script>
	
</html>