function findProduct(name, limit) {
	$.post("search-product/" + name + "&" + limit).done(function (fragment) {
		$("#search-dropdown").empty();
		$("#search-dropdown").append(fragment);
	});
}