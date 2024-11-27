$(document).ready(function() {
	// Khi người dùng chọn radio button
	$("input[name='amount']").change(function() {
		$(".input-amount").val(''); // Xóa giá trị nhập tay nếu chọn radio
		$(".error-message").remove(); // Xóa thông báo lỗi nếu có
	});

	// Khi người dùng nhập số tiền vào ô input
	$(".input-amount").on("input", function() {
		$("input[name='amount']:checked").prop("checked", false); // Bỏ chọn radio
		$(".error-message").remove(); // Xóa thông báo lỗi nếu có
	});
});
