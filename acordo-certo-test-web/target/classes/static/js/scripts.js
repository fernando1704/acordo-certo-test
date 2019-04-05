$(document).ready(function() {

	$("#clientes-add").submit(function(event) {

		// stop submit the form, we will post it manually.
		event.preventDefault();

		fire_ajax_submit();

	});

});

function fire_ajax_submit() {

	$
			.post({
				url : "/clientes/adicionar",
				data : $('form[name=clientes-add]').serialize(),
				success : function(data) {
					
					console.log(data);
					var classe = '';

					if (data.resultado == '1') {

						classe = 'alert-success';

					} else {

						classe = 'alert-danger';
					}

					var json = "<pre class='" + classe + "'>"
							+ JSON.stringify(data.msg, null, 4) + "</pre>";

					$('#feedback').html(json);
					
					
					$('#clientes-add').trigger("reset");

				},
				error : function(e) {

					var json = "<pre class='alert-danger'>" + e.responseText
							+ "</pre>";
					$('#feedback').html(json.msg);

					console.log("ERROR : ", e);
				}
			});
}