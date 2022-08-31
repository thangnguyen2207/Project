$(window).ready(function () {
	dataTable('mainTable');
	if (typeof errorStatus != 'undefined') {
	    onErrorStatus(errorStatus, addAction, addTitle, updateAction, updateTitle);
	}
	    		
	if (showToast == 'add') {
	    $('#addToast').toast('show');
	}
	if (showToast == 'update') {
	    $('#updateToast').toast('show');
	}
	if (showToast == 'delete') {
	    $('#deleteToast').toast('show');
	}
	    		
	$('#loadingScreen').hide();
});