let menuCb = document.getElementsByName('menuCb');

for (let i = 0; i < menuCb.length; i++) {
	menuCb[i].addEventListener('change', function () {
		hide(menuCb[i], 'mainTable');
	});
};

function hide(checkbox, tableID) {
	if (checkbox.checked)
		$('#' + tableID + ' tr > *:nth-child(' + checkbox.value + ')').show();
	else
		$('#' + tableID + ' tr > *:nth-child(' + checkbox.value + ')').hide();
}

let menuBtn = document.getElementById('menuBtn');
			    
if (menuBtn != null) {
	menuBtn.addEventListener('show.bs.dropdown', function () {
	$('#drop').removeClass('dropdown').addClass('dropup');
	});
	menuBtn.addEventListener('hide.bs.dropdown', function () {
		$('#drop').removeClass('dropup').addClass('dropdown');
	});
}