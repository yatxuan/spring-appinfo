$(function () {

    selectFirstClass();

    var appid = getUrlParam("appid");
    $.get("/appInfoS/getAppInfoId", {id: appid}, function (data) {
        $('[name="softwareName"]').val(data.data.softwareName);
        $('[name="APKName"]').val(data.data.apkname);
        $('[name="supportROM"]').val(data.data.supportROM);
        $('[name="softwareSize"]').val(data.data.softwareSize);
        $('[name="statusName"]').val(data.data.statusType);
        $('[name="appInfo"]').val(data.data.appIntroduction);

        $("#pricate").attr("src", data.data.logoPicPath);

        SelectThwooClass(data.data.firstAPPClassId);
        SelectThreeClass(data.data.twoAPPClassId);

        $('[name="language"]').find("option[value='" + data.data.interfaceLanguageId + "']")
            .attr("selected", true);
        $('[name="queryFlatformId"]').find("option[value='" + data.data.flatformId + "']")
            .attr("selected", true);
        $('[name="queryCategoryLevel1"]').find("option[value='" + data.data.firstAPPClassId + "']")
            .attr("selected", true);
        $('[name="queryCategoryLevel2"]').find("option[value='" + data.data.twoAPPClassId + "']")
            .attr("selected", true);
        $('[name="queryCategoryLevel3"]').find("option[value='" + data.data.threeAPPClassId + "']")
            .attr("selected", true);

    })
})

$(document).on('click', "#del", function () {
    $("#pricate").hide();
    $("#del").hide();
    $('[name="a_logoPicPath"]').toggle();
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

// 查询一级分类
function selectFirstClass() {
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
}

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

//保存后提交修改
function keepReview() {
    var picture = $('[name="a_logoPicPath"]').val();
    if (picture == "") {
        saveReview()
    } else {
        saveImgReview();
    }
}

//保存
function keep() {
    var picture = $('[name="a_logoPicPath"]').val();
    if (picture == "") {
        save()
    } else {
        alert(1)
        saveImg();
    }
}

//修改方法，有图片修改
function saveImg() {
    var formData = new FormData();
    formData.append("file", document.getElementById("a_logoPicPath").files[0]);
    $.ajax({
        type: 'post',
        url: "/file/pictureFile",
        data: formData,
        cache: false,
        processData: false,
        contentType: false
    }).success(function (data) {
        var filebool = data.success;
        var logoPicPath = data.data.logoPicPath;
        var logoLocPath = data.data.logoLocPath;

        if (filebool) {
            $.get("/login/loginUser", function (user) {
                if (user.success) {
                    var createdBy = user.data.id;
                    var softwareName = $('[name="softwareName"]').val();
                    var APKName = $('[name="APKName"]').val();
                    var supportROM = $('[name="supportROM"]').val();
                    var language = $('[name="language"]').val();
                    var softwareSize = $('[name="softwareSize"]').val();
                    var queryFlatformId = $('[name="queryFlatformId"]').val();
                    var queryCategoryLevel1 = $('[name="queryCategoryLevel1"]').val();
                    var queryCategoryLevel2 = $('[name="queryCategoryLevel2"]').val();
                    var queryCategoryLevel3 = $('[name="queryCategoryLevel3"]').val();
                    var appInfo = $('[name="appInfo"]').val();
                    var appid = getUrlParam("appid");

                    $.get("/appInfoS/updateAppinfoS", {
                        softwarename: softwareName,
                        apkname: APKName,
                        supportrom: supportROM,
                        interfacelanguageid: language,
                        softwaresize: softwareSize,
                        devuserid: createdBy,
                        createdby: createdBy,
                        appintroduction: appInfo,
                        flatformid: queryFlatformId,
                        firstappclassid: queryCategoryLevel1,
                        twoappclassid: queryCategoryLevel2,
                        threeappclassid: queryCategoryLevel3,
                        logopicpath: logoPicPath,
                        logolocpath: logoLocPath,
                        id: appid
                    }, function (data) {
                        if (data.success) {
                            alert("APP修改成功");
                            window.location.replace("/developer/appinfolist.html")
                        } else {
                            alert(data.message);
                        }
                    })
                }
            })
        }
    }).error(function () {
        alert("上传失败");
    });
}

//修改方法，无图片修改
function save() {
    $.get("/login/loginUser", function (user) {
        if (user.success) {
            var createdBy = user.data.id;
            var softwareName = $('[name="softwareName"]').val();
            var APKName = $('[name="APKName"]').val();
            var supportROM = $('[name="supportROM"]').val();
            var language = $('[name="language"]').val();
            var softwareSize = $('[name="softwareSize"]').val();
            var queryFlatformId = $('[name="queryFlatformId"]').val();
            var queryCategoryLevel1 = $('[name="queryCategoryLevel1"]').val();
            var queryCategoryLevel2 = $('[name="queryCategoryLevel2"]').val();
            var queryCategoryLevel3 = $('[name="queryCategoryLevel3"]').val();
            var appInfo = $('[name="appInfo"]').val();
            var appid = getUrlParam("appid");

            $.get("/appInfoS/updateAppinfoS", {
                softwarename: softwareName,
                apkname: APKName,
                supportrom: supportROM,
                interfacelanguageid: language,
                softwaresize: softwareSize,
                devuserid: createdBy,
                createdby: createdBy,
                appintroduction: appInfo,
                flatformid: queryFlatformId,
                firstappclassid: queryCategoryLevel1,
                twoappclassid: queryCategoryLevel2,
                threeappclassid: queryCategoryLevel3,
                id: appid
            }, function (data) {
                if (data.success) {
                    alert("APP修改成功");
                    window.location.replace("/developer/appinfolist.html")
                } else {
                    alert(data.message);
                }
            })
        }
    })
}


//修改后，审核方法，有图片修改
function saveImgReview() {
    var formData = new FormData();
    formData.append("file", document.getElementById("a_logoPicPath").files[0]);
    $.ajax({
        type: 'post',
        url: "/file/pictureFile",
        data: formData,
        cache: false,
        processData: false,
        contentType: false
    }).success(function (data) {
        var filebool = data.success;
        var logoPicPath = data.data.logoPicPath;
        var logoLocPath = data.data.logoLocPath;

        if (filebool) {
            $.get("/login/loginUser", function (user) {
                if (user.success) {
                    var createdBy = user.data.id;
                    var softwareName = $('[name="softwareName"]').val();
                    var APKName = $('[name="APKName"]').val();
                    var supportROM = $('[name="supportROM"]').val();
                    var language = $('[name="language"]').val();
                    var softwareSize = $('[name="softwareSize"]').val();
                    var queryFlatformId = $('[name="queryFlatformId"]').val();
                    var queryCategoryLevel1 = $('[name="queryCategoryLevel1"]').val();
                    var queryCategoryLevel2 = $('[name="queryCategoryLevel2"]').val();
                    var queryCategoryLevel3 = $('[name="queryCategoryLevel3"]').val();
                    var appInfo = $('[name="appInfo"]').val();
                    var appid = getUrlParam("appid");

                    $.get("/appInfoS/updateAppinfoS", {
                        softwarename: softwareName,
                        apkname: APKName,
                        supportrom: supportROM,
                        interfacelanguageid: language,
                        softwaresize: softwareSize,
                        devuserid: createdBy,
                        createdby: createdBy,
                        appintroduction: appInfo,
                        flatformid: queryFlatformId,
                        firstappclassid: queryCategoryLevel1,
                        twoappclassid: queryCategoryLevel2,
                        threeappclassid: queryCategoryLevel3,
                        logopicpath: logoPicPath,
                        logolocpath: logoLocPath,
                        statusid: 1,
                        id: appid
                    }, function (data) {
                        if (data.success) {
                            alert("APP修改成功");
                            window.location.replace("/developer/appinfolist.html")
                        } else {
                            alert(data.message);
                        }
                    })
                }
            })
        }
    }).error(function () {
        alert("上传失败");
    });
}

//修改后，审核方法，无图片修改
function saveReview() {
    $.get("/login/loginUser", function (user) {
        if (user.success) {
            var createdBy = user.data.id;
            var softwareName = $('[name="softwareName"]').val();
            var APKName = $('[name="APKName"]').val();
            var supportROM = $('[name="supportROM"]').val();
            var language = $('[name="language"]').val();
            var softwareSize = $('[name="softwareSize"]').val();
            var queryFlatformId = $('[name="queryFlatformId"]').val();
            var queryCategoryLevel1 = $('[name="queryCategoryLevel1"]').val();
            var queryCategoryLevel2 = $('[name="queryCategoryLevel2"]').val();
            var queryCategoryLevel3 = $('[name="queryCategoryLevel3"]').val();
            var appInfo = $('[name="appInfo"]').val();
            var appid = getUrlParam("appid");

            $.get("/appInfoS/updateAppinfoS", {
                softwarename: softwareName,
                apkname: APKName,
                supportrom: supportROM,
                interfacelanguageid: language,
                softwaresize: softwareSize,
                devuserid: createdBy,
                createdby: createdBy,
                appintroduction: appInfo,
                flatformid: queryFlatformId,
                firstappclassid: queryCategoryLevel1,
                twoappclassid: queryCategoryLevel2,
                threeappclassid: queryCategoryLevel3,
                statusid: 1,
                id: appid
            }, function (data) {
                if (data.success) {
                    alert("APP修改成功");
                    window.location.replace("/developer/appinfolist.html")
                } else {
                    alert(data.message);
                }
            })
        }
    })
}
