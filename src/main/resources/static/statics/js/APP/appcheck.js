$(function () {
    selAPPInfo();
})


//获取url中的参数
function getUrlParam(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}

//查看APP基本信息
function selAPPInfo() {
    var appid = getUrlParam("appid");

    $.get("/appInfoS/getAppInfoId", {id: appid}, function (data) {
        var result = data.data;

        $('[name="softwareName"]').val(result.softwareName);
        $('[name="apkname"]').val(result.apkname);
        $('[name="supportROM"]').val(result.supportROM);
        $('[name="language"]').val(result.language);
        $('[name="softwareSize"]').val(result.softwareSize);
        $('[name="downloads"]').val(result.downloads);
        $('[name="flatformName"]').val(result.flatformName);
        $('[name="category"]').val(result.firstAPPName + ' --> ' + result.twoAPPName + ' --> ' + result.threeAPPName);
        $('[name="appIntroduction"]').text(result.appIntroduction);

        if (result.logoPicPath == null) {
            $("#pricate1").show();
            $("#pricate").hide();

        } else {
            $("#pricate1").hide();
            $("#pricate").show();
            $("#pricate").attr("src", result.logoPicPath);
        }

    })
}

//审核通过
function examinationPassed() {
    var appid = getUrlParam("appid");
    $.get("/appInfoS/updateAppinfoS", {
        statusid: 2,
        id: appid
    }, function (data) {
        if (data.success) {
            alert("APP修改成功");
            window.location.replace("/backend/applist.html")
        } else {
            alert(data.message);
        }
    })
}

//审核不通过
function AuditNotPassed() {
    var appid = getUrlParam("appid");
    $.get("/appInfoS/updateAppinfoS", {
        statusid: 3,
        id: appid
    }, function (data) {
        if (data.success) {
            alert("APP修改成功");
            window.location.replace("/backend/applist.html")
        } else {
            alert(data.message);
        }
    })
}

