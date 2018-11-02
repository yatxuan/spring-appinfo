$(function () {
    // 查询APP所属平台
    $.get("/flatForm/getFlatForm", function (data) {
        var html = "<option value='0'>--请选择--</option>";
        if (data.success) {
            var result = data.data;
            for (var i = 0; i < result.length; i++) {
                var item = result[i];
                html += "<option value=" + item.id + ">" + item.flatformname + "</option>"
            }
            $('[name="queryFlatformId"]').html(html);
        } else {
            alert(data.message);
        }
    });
})
