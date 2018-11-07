$(function () {
    $("#send").click(function () {
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

                        $.get("/appInfoS/saveAppInfo", {
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
                        }, function (data) {
                            if (data.success) {
                                alert("APP新增成功");
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
    })
})
