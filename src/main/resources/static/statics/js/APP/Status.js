$(function () {
    // 查询APP审核状态
    $.get("/status/getStatus", function (data) {
        var html = "<option value='0'>--请选择--</option>";
        if (data.success) {
            var result = data.data;
            for (var i = 0; i < result.length; i++) {
                var item = result[i];
                html += "<option value=" + item.id + ">" + item.statustype + "</option>"
            }
            $('[name="queryStatus"]').html(html);
        } else {
            alert(data.message);
        }
    });
})
