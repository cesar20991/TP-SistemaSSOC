<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
function initCasoCriminal(caso){
		$("#hdrCodigoCaso").empty();
		$("#hdrEstado").empty();
		$("#hdrReferencia").empty();
		$("#hdrCreador").empty();
		$("#hdrFecCreacion").empty();
		
		$("#spnCodigo").empty();
		$("#spnEstado").empty();
		$("#spnFecCreacion").empty();
		$("#spnReferencia").empty();
		$("#spnAsunto").empty();
		$("#spnDescripcion").empty();
			 				
		$("#hdrCodigoCaso").append(caso.codigo);
		$("#hdrEstado").append(caso.estado);
		$("#hdrReferencia").append(caso.referencia);
		$("#hdrCreador").append('<a href="toPerfil-'+caso.idPerfil+'">'+caso.primerNombre+ ' ' +caso.segundoNombre+ ' ' +caso.apePaterno+ ' ' +caso.apeMaterno+ '('+caso.tipoFiscal+')</a>');
		$("#hdrFecCreacion").text(timeStampFormatted(caso.fecCreacion));
		
		$("#spnCodigo").append(caso.codigo);
		$("#spnEstado").append(caso.estado);
		$("#spnFecCreacion").append(timeStampFormatted(caso.fecCreacion));
		$("#spnReferencia").append(caso.referencia);
		$("#spnAsunto").append(caso.asunto);
		$("#spnDescripcion").append(caso.descripcion);
}
$(document).ready(function(){
	var idCaso = $("#hdnIdCaso").text();
	$.ajax({
 		url: 'getCaso-'+idCaso,
 		type: 'post',
 		dataType: 'json',
 		data: '',
 		success: function(caso){
 			initCasoCriminal(caso);
 		}
 	});
	//
	$("#formEditarCasoCriminal").validate({
		submitHandler: function(form){
			$("#hdnIdCasoCriminal").val($("#hdnIdCaso").text());
			$.ajax({
				url: 'editarCasoCriminal',
		 		type: 'post',
		 		dataType: 'json',
		 		data: $("#formEditarCasoCriminal").serialize(),
		 		success: function(caso){
		 			initCasoCriminal(caso);
		 			$("#divMostrarCasoCriminal").show();
		 			$("#divEditarCasoCriminal").hide();
		 		}
			});
		}
	});
});
$(document).on('click','#btnEditarCasoCriminal', function(e){
	//TABS A OCULTAR Y MOSTRAR
	$("#divMostrarCasoCriminal").hide();
	$("#divEditarCasoCriminal").show();
});
$(document).on('click','#btnCancelEditar', function(e){
	//TABS A OCULTAR Y MOSTRAR
	$("#divMostrarCasoCriminal").show();
	$("#divEditarCasoCriminal").hice();
});
</script>
<div id="divCasoCriminal">
	<div id="divMostrarCasoCriminal">
	<form:form class="form-horizontal">
		<fieldset>
			<legend>
				<span class=""><span class="colored">///</span> Datos del Caso Criminal:</span>
				<span class="offset3"><button class="btn btn-primary btn-small" type="button" id="btnEditarCasoCriminal"><i class="icon-edit"></i> Editar</button></span>
			</legend>
			<div class="control-group">
				<label class="control-label">Codigo: </label>
				<div class="controls">
					<span id="spnCodigo">&nbsp;</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Estado: </label>
				<div class="controls">
					<span id="spnEstado">&nbsp;</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Fecha de Creacion: </label>
				<div class="controls">
					<span id="spnFecCreacion">&nbsp;</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Referencia: </label>
				<div class="controls">
					<span id="spnReferencia">&nbsp;</span>
				</div>
			</div>
			<div class="control-group" id="divRango">
				<label class="control-label">Asunto: </label>
				<div class="controls">
					<span id="spnAsunto">&nbsp;</span>
				</div>
			</div>
			<div class="control-group" id="divRango">
				<label class="control-label">Description: </label>
				<div class="controls">
					<p id="spnDescripcion">&nbsp;</p>
				</div>
			</div>
		</fieldset>
	</form:form>
</div>
<!-- EDITAR CAOS CRIMINAL -->
	<fieldset class="well" style="display: none;" id="divEditarCasoCriminal">
		<form:form class="form-horizontal" id="formEditarCasoCriminal" action="editarCasoCriminal" commandName="editarCasoCriminal">
				<input type="hidden" name="idCasoCriminalAux" id="hdnIdCasoCriminal">
				<legend>
			       	<span class="colored">///</span> Editar Caso Criminal:
		       	</legend>
		       	<div class="control-group">
	          		<label class="control-label">Asunto: </label>
	          		<div class="controls">
	          			<input class="span3" type="text" name="asunto" id="txtAsunto" data-rule-required="true" data-msg-required="*">
	          		</div>
	       		</div>
				<hr/>
				<div class="control-group">
	          		<label class="control-label">Referencia: </label>
	          		<div class="controls">
	          			<input class="span3" type="text" name="referencia" id="txtReferencia" data-rule-required="true" data-msg-required="*">
	          		</div>
	       		</div>
				<hr/>
				<div class="control-group">
	          		<label class="control-label">Description: </label>
	          		<div class="controls">
	          			<input class="span3" type="text" name="referencia" id="txtDescripcion" data-rule-required="true" data-msg-required="*">
	          		</div>
	       		</div>
				<!-- BOTONES -->
				<div class="form-actions">
					<button class="btn btn-success" id="btnGuardar" type="submit"><i class="icon-ok icon-white"></i> Guardar</button>
			        <button class="btn btn-danger" type="reset"><i class="icon-refresh icon-white"></i> Reset</button>
			        <button class="btn btn-warning" type="button" id="btnCancelEditar"><i class="icon-arrow-left icon-white"></i> Cancel</button>
			    </div>
			</form:form>
		</fieldset>
</div>