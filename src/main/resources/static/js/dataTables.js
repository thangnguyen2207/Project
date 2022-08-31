function dataTable(tableId) {
	if (document.getElementById(tableId) != null) {
		let tableColsLength = document.getElementById(tableId).rows[0].cells.length - 1;
		$('#' + tableId).DataTable({
			"language": {
				"search": "Tìm kiếm:",
				"lengthMenu": "Hiện _MENU_ kết quả",
				"emptyTable": "Không có kết quả nào",
				"paginate": {
					"first": "Đầu",
					"last": "Cuối",
					"next": "Tiếp theo",
					"previous": "Trước đó",
				},
				"zeroRecords":    "Không tìm thấy kết quả",
				"info": "Hiển thị _START_ đến _END_ trong _TOTAL_ kết quả",
				"infoEmpty": "Hiển thị 0 đến 0 trong 0 kết quả",
			},
			columnDefs: [
				{ orderable: false, targets: tableColsLength }
			],
			"autoWidth": false,
		});
	}
};