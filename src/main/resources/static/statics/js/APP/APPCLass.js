$(function () {
    // 查询一级分类
    $.get("/firstAPPClass/getFirstAPPClass", function (data) {
        var html = "<option value='0'>--请选择--</option>";
        if (data.success) {
            var result = data.data;
            for (var i = 0; i < result.length; i++) {
                var item = result[i];
                html += "<option value=" + item.id + ">" + item.firstappname + "</option>"
            }
            $('[name="queryCategoryLevel1"]').html(html);
        } else {
            alert(data.message);
        }
    });
})

//根据一级分类查询二级分类
function TwoAPP() {
    var firstid = $('[name="queryCategoryLevel1"]').val();
    if (firstid > 0) {
        //清空三级分类
        $('[name="queryCategoryLevel3"]').html(" ");

        $.get("/twoAPPClass/getTwoAPPClass?firstAPPClassId=" + firstid, function (data) {
            var html = "<option value='0'>--请选择--</option>";
            if (data.success) {
                var result = data.data;
                for (var i = 0; i < result.length; i++) {
                    var item = result[i];
                    html += "<option value=" + item.id + ">" + item.twoappname + "</option>"
                }
                $('[name="queryCategoryLevel2"]').html(html);
            } else {
                alert(data.message);
            }
        });
    }
}

//根据二级分类查询三级分类
function ThreeAPP() {
    var twoID = $('[name="queryCategoryLevel2"]').val();
    if (twoID > 0) {

        //清空三级分类
        $('[name="queryCategoryLevel3"]').html(" ");

        $.get("/threeAPPClass/getThreeAPPClass?twoAPPClassId=" + twoID, function (data) {
            var html = "<option value='0'>--请选择--</option>";
            if (data.success) {
                var result = data.data;
                for (var i = 0; i < result.length; i++) {
                    var item = result[i];
                    html += "<option value=" + item.id + ">" + item.threeappname + "</option>"
                }
                $('[name="queryCategoryLevel3"]').html(html);
            } else {
                alert(data.message);
            }
        });
    }
}
