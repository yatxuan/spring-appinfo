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

//查询上架状态信息
function FrameList() {
    var statusId = $('[ name="queryStatus"]').val();
    if (statusId = 2) {
        $("#Frame").show();
        //查询上架状态信息
        $.get("/frame/getFrame", function (data) {
            var html = "<option value='0'>--请选择--</option>";
            if (data.success) {
                var result = data.data;
                for (var i = 0; i < result.length; i++) {
                    var item = result[i];
                    html += "<option value=" + item.id + ">" + item.frametype + "</option>"
                }
                $('[name="frameId"]').html(html);
            } else {
                alert(data.message);
            }
        });
    }else {
        $("#Frame").hide();
        $('[name="frameId"]').html("<option value='0'>--请选择--</option>");
    }
}
