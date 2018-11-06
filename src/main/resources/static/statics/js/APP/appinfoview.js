$(function () {
    selAPPInfo();
    selAPPVersion();
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

        var html = "<input type=\"hidden\" name=\"id\" value=" + appid + ">\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">软件名称 <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input class=\"form-control col-md-7 col-xs-12\"\n" +
            "               value=" + result.softwareName + "\n" +
            "               type=\"text\" readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">APK名称 <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input type=\"text\" class=\"form-control col-md-7 col-xs-12\"\n" +
            "               value=" + result.apkname + " readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">支持ROM <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input class=\"form-control col-md-7 col-xs-12\"\n" +
            "               value=" + result.supportROM + " type=\"text\" readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">界面语言 <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input class=\"form-control col-md-7 col-xs-12\" readonly=\"readonly\"\n" +
            "               value=" + result.language + " type=\"text\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">软件大小 <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input type=\"text\" value=" + result.softwareSize + "\n" +
            "               class=\"form-control col-md-7 col-xs-12\" readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">下载次数 <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input type=\"text\" value=" + result.downloads + "\n" +
            "               class=\"form-control col-md-7 col-xs-12\" readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">所属平台 <span\n" +
            "            class=\"required\">*</span></label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input type=\"text\" class=\"form-control col-md-7 col-xs-12\"\n" +
            "               value=" + result.flatformName + " readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">所属分类 <span\n" +
            "            class=\"required\">*</span></label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input type=\"text\" class=\"form-control col-md-7 col-xs-12\"\n" +
            "               value=\"" + result.firstAPPName + ' --> ' + result.twoAPPName + ' --> ' + result.threeAPPName + "\" readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">APP状态 <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "        <input type=\"text\" class=\"form-control col-md-7 col-xs-12\"\n" +
            "               value=" + result.frameType + " readonly=\"readonly\">\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">应用简介\n" +
            "        <span class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">\n" +
            "              <textarea class=\"form-control col-md-7 col-xs-12\" readonly=\"readonly\">\n" +
            "              " + result.appIntroduction + "</textarea>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div class=\"item form-group\">\n" +
            "    <label class=\"control-label col-md-3 col-sm-3 col-xs-12\">LOGO图片 <span\n" +
            "            class=\"required\">*</span>\n" +
            "    </label>\n" +
            "    <div class=\"col-md-6 col-sm-6 col-xs-12\">";
        if (result.logoPicPath == null) {
            html += "暂无" + "</div></div>";
        } else {
            html += "<img src=" + result.logoPicPath + " width=100px;/>" + "</div></div>";
        }

        $("#selAppInfo").html(html);
    })
}

//查看APP的历史版本信息
function selAPPVersion() {
    var appid = getUrlParam("appid");

    $.get("/appVersion/getAppVersionS", {appId: appid}, function (data) {
        var result = data.data;

        var html = "<thead>\n" +
            "    <tr role=\"row\">\n" +
            "        <th class=\"sorting_asc\" tabindex=\"0\"\n" +
            "            aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "            style=\"width: 70px;\"\n" +
            "            aria-label=\"First name: activate to sort column descending\"\n" +
            "            aria-sort=\"ascending\">软件名称\n" +
            "        </th>\n" +
            "        <th class=\"sorting\" tabindex=\"0\"\n" +
            "            aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "            style=\"width: 10px;\"\n" +
            "            aria-label=\"Last name: activate to sort column ascending\">\n" +
            "            版本号\n" +
            "        </th>\n" +
            "        <th class=\"sorting\" tabindex=\"0\"\n" +
            "            aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "            style=\"width: 90px;\"\n" +
            "            aria-label=\"Last name: activate to sort column ascending\">\n" +
            "            版本大小(单位:M)\n" +
            "        </th>\n" +
            "        <th class=\"sorting\" tabindex=\"0\"\n" +
            "            aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "            style=\"width: 50px;\"\n" +
            "            aria-label=\"Last name: activate to sort column ascending\">\n" +
            "            发布状态\n" +
            "        </th>\n" +
            "        <th class=\"sorting\" tabindex=\"0\"\n" +
            "            aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "            style=\"width: 50px;\"\n" +
            "            aria-label=\"Last name: activate to sort column ascending\">\n" +
            "            APK文件下载\n" +
            "        </th>\n" +
            "        <th class=\"sorting\" tabindex=\"0\"\n" +
            "            aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "            style=\"width: 50px;\"\n" +
            "            aria-label=\"Last name: activate to sort column ascending\">\n" +
            "            最新更新时间\n" +
            "        </th>\n" +
            "    </tr>\n" +
            "    </thead>\n" +
            "    <tbody>";
        if (result.length > 0) {
            for (var i = 0; i < result.length; i++) {
                html += "<tr role=\"row\" class=\"odd\">\n" +
                    "    <td tabindex=\"0\" class=\"sorting_1\">" + result[i].softwareName + "</td>\n" +
                    "    <td>" + result[i].versionNo + "</td>\n" +
                    "    <td>" + result[i].versionSize + "</td>\n" +
                    "    <td>" + result[i].releaseStatusName + "</td>\n" +
                    "    <td>\n" +
                    "        <a href=http://" + result[i].apkLocPath + ">" + result[i].apkFileName + "\n" +
                    "    </td>\n" +
                    "    <td>" + result[i].modifyDate + "</td>\n" +
                    "</tr>\n";
            }
        } else {
            html += "<tr role=row class=odd><td colspan=\"6\">该APP占无历史版本信息</td></tr>";
        }

        html += "</tbody>";
        $("#datatable-responsive").html(html);
    })
}

//隐藏历史版本信息
function content() {
    $(".x_content").toggle();
}
