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
    var fristID = $('[name="queryCategoryLevel1"]').val();
    if (fristID > 0) {
        SelectThwooClass(fristID)
    }
}

//根据二级分类查询三级分类
function ThreeAPP() {
    var twoID = $('[name="queryCategoryLevel2"]').val();
    if (twoID > 0) {
        SelectThreeClass(twoID);
    }
}

//传入一级分类查询二级分类
function SelectThwooClass(fristID) {
    //清空三级分类
    $('[name="queryCategoryLevel3"]').html(" ");

    $.get("/twoAPPClass/getTwoAPPClass?firstAPPClassId=" + fristID, function (data) {
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


//传入二级分类的id查询三级分类
function SelectThreeClass(twoID) {
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
