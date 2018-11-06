$(function () {
    var appid = getUrlParam("appid");
    $('[name="appinfoid"]').val(appid);
    getVersion();
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

//查询APP历史版本信息
function getVersion() {
    var appid = getUrlParam("appid");
    $('[name="appinfoid"]').val(appid);
    $.get("/appVersion/getAppVersionS", {appId: appid}, function (data) {
        var result = data.data;
        var html = "<thead>\n" +
            "<tr role=\"row\">\n" +
            "    <th class=\"sorting_asc\" tabindex=\"0\"\n" +
            "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "        style=\"width: 70px;\"\n" +
            "        aria-label=\"First name: activate to sort column descending\"\n" +
            "        aria-sort=\"ascending\">软件名称\n" +
            "    </th>\n" +
            "    <th class=\"sorting\" tabindex=\"0\"\n" +
            "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "        style=\"width: 10px;\"\n" +
            "        aria-label=\"Last name: activate to sort column ascending\">\n" +
            "        版本号\n" +
            "    </th>\n" +
            "    <th class=\"sorting\" tabindex=\"0\"\n" +
            "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "        style=\"width: 90px;\"\n" +
            "        aria-label=\"Last name: activate to sort column ascending\">\n" +
            "        版本大小(单位:M)\n" +
            "    </th>\n" +
            "    <th class=\"sorting\" tabindex=\"0\"\n" +
            "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "        style=\"width: 50px;\"\n" +
            "        aria-label=\"Last name: activate to sort column ascending\">\n" +
            "        发布状态\n" +
            "    </th>\n" +
            "    <th class=\"sorting\" tabindex=\"0\"\n" +
            "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "        style=\"width: 50px;\"\n" +
            "        aria-label=\"Last name: activate to sort column ascending\">\n" +
            "        APK文件下载\n" +
            "    </th>\n" +
            "    <th class=\"sorting\" tabindex=\"0\"\n" +
            "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "        style=\"width: 50px;\"\n" +
            "        aria-label=\"Last name: activate to sort column ascending\">\n" +
            "        最新更新时间\n" +
            "    </th>" +
            "    <th class=\"sorting\" tabindex=\"0\"\n" +
            "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"\n" +
            "        style=\"width: 50px;\"\n" +
            "        aria-label=\"Last name: activate to sort column ascending\">\n" +
            "        操作\n" +
            "     </th>\n" +
            "</tr>\n" +
            "</thead>" +
            "<tbody>";
        if (data.success) {
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
                    "    <td>" +
                    "         <a appversionid=" + result[i].appVersionId+ " style='cursor:pointer' id='optAPP'>选择APP版本</a>" +
                    "    </td>\n" +
                    "</tr>\n";
            }
        }
        html += "</tbody>";
        $('#datatable-responsive').html(html);
    })
}


