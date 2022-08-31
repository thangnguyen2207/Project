var modal = document.getElementById('mainModal');

if (modal != null) {
	modal.addEventListener('hide.bs.modal', function () {
		$('.is-invalid').removeClass('is-invalid');
		$('div.text-danger').css('display', 'none');
	});
}

function onErrorStatus(status, addAction, addTitle, updateAction, updateTitle) {
	if (status == null) {
		$('#mainModal').modal('hide');
	} else {
		$('#mainModal').modal('show');
		if (status == "add") {
			$('#mainForm').attr("action", addAction);
			$('#idField').addClass('d-none');
			$('#mainModalLabel').text(addTitle);
		} else if (status == "update") {
			$('#mainForm').attr("action", updateAction);
			$('#idField').removeClass('d-none');
			$('#mainModalLabel').text(updateTitle);
		}
	}				
}