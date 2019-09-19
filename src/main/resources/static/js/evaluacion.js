const app = new Vue({
	el: "#app",
	data:{
		usuarios : new Array(),
		usuario : {
			idUsuario : 0,
			nombres : "",
			apellidos : "",
			estudioSup : "",
			edad : 0,
			domicilio : "",
			curp : ""
		},
		idElimina : 0 
	},
	mounted(){
		axios.get('http://localhost:8080/usuarios')
			.then(result => {
				this.usuarios = result.data;
			}, error => {
				console.log(error)
		});
	},
	methods: {
		agregarM : function (){
			this.usuario = {
				idUsuario : 0,
				nombres : "",
				apellidos : "",
				estudioSup : "",
				edad : 0,
				domicilio : "",
				curp : ""
			}
			$('#usuario').modal('show')
		},
		cerrar : function(){
			this.usuario = {
				idUsuario : 0,
				nombres : "",
				apellidos : "",
				estudioSup : "",
				edad : 0,
				domicilio : "",
				curp : ""
			}
			alertify.error('Cancelado')
			$('#usuario').modal('hide')
		},
		elimina : function(){
			axios.delete('http://localhost:8080/usuario/'+this.idElimina)
				.then(result => {
					alertify.success('Eliminado')
					$('#elimina').modal('hide')
					this.carga()
				}, error => {
					alertify.error('Error al eliminar')
					console.log(error)
			});
		},
		validaelimina: function(id){
			this.idElimina = id
			$('#elimina').modal('show')
		},
		cancelaElimina : function (){
			$('#elimina').modal('hide')
			alertify.error('Cancelado')
		},
		actualiza : function(id){
			axios.get('http://localhost:8080/usuario/'+id)
				.then(result => {
					this.usuario = result.data
				}, error => {
					alertify.error('Error al eminar')
			});
			$('#usuario').modal('show')
		},
		guardar : function(id){
			if(this.usuario.idUsuario == 0){
				axios.post('http://localhost:8080/usuario/',this.usuario)
					.then(result => {
						this.carga()
						$('#usuario').modal('hide')
						alertify.success('Guardado')
					}, error => {
						alertify.error('Error al guardar')
						console.log(error)
				});
			}else{
				axios.put('http://localhost:8080/usuario/'+id,this.usuario)
					.then(result => {
						this.carga()
						$('#usuario').modal('hide')
						alertify.success('Actualizado')
					}, error => {
						alertify.error('Error actualizar')
						console.log(error)
				});
			}
		},
		carga : function(){
			axios.get('http://localhost:8080/usuarios')
				.then(result => {
					this.usuarios = result.data;
				}, error => {
					console.log(error)
			});
		}
	}
	
});