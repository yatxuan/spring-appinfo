$(function () {
    SelectApp();
})

//多条件查询APP信息
function SelectApp() {

    //获取软件名称
    var softwareName = $('[ name="querySoftwareName"]').val();

    //获取当前页面
    var currNo = $('[ name="page"]').val();

    //获取所属平台id
    var flatFormId = $('[ name="queryFlatformId"]').val();

    //获取一级分类id
    var firstAPPClassId = $('[ name="queryCategoryLevel1"]').val();

    //获取二级分类id
    var twoAPPClassId = $('[ name="queryCategoryLevel2"]').val();

    //获取二级分类id
    var threeAPPClassId = $('[ name="queryCategoryLevel3"]').val();

    //获取上架状态id
    var frameId = $('[ name="frameId"]').val();

    //获取审核状态id
    var statusId = $('[ name="queryStatus"]').val();

    //获取三个span标签的值
    /* var size = $('[name="size"]').text();
     var currNo = $('[name="currNo"]').text();
     var pageCurrNo = $('[name="pageCurrNo"]').text();*/

    var html = "<thead>" +
        "<tr role=\"row\">" +
        "    <th class=\"sorting_asc\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"First name: activate to sort column descending\"" +
        "        aria-sort=\"ascending\">软件名称" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        APK名称" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        软件大小(单位:M)" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        所属平台" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        所属分类(一级分类、二级分类、三级分类)" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        审核状态" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        上架状态" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        下载次数" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        最新版本号" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        style=\"width: 124px;\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        操作" +
        "    </th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";

    $.get("/appInfoS/getAppInfoS", {
        softwareName: softwareName,
        statusId: statusId,
        frameId: frameId,
        threeAPPClassId: threeAPPClassId,
        twoAPPClassId: twoAPPClassId,
        firstAPPClassId: firstAPPClassId,
        flatFormId: flatFormId,
        currNo: currNo
    }, function (data) {
        if (data.success) {
            var list = data.data.list;
            var page = data.data.page;

            for (var i = 0; i < list.length; i++) {
                html += "<tr role=\"row\" class=\"odd\">" +
                    "    <td tabindex=\"0\" class=\"sorting_1\">" + list[i].softwareName + "</td>" +
                    "    <td>" + list[i].aPKName + "</td>" +
                    "    <td>" + list[i].softwareSize + "</td>" +
                    "    <td>" + list[i].flatformName + "</td>" +
                    "    <td>" + list[i].firstAPPName + " -> " + list[i].twoAPPName + " -> " + list[i].threeAPPName + "</td>" +
                    "    <td><span id=\"appInfoStatusid\">" + list[i].statusType + "</span></td>" +
                    "    <td>" + list[i].frameType + "</td>" +
                    "    <td>" + list[i].downloads + "</td>" +
                    "    <td>" + list[i].versionNo + "</td>" +
                    "    <td>" +
                    "        <div class=\"btn-group\">" +
                    "            <button type=\"button\" class=\"btn btn-danger\">点击操作</button>" +
                    "            <button type=\"button\" class=\"btn btn-danger dropdown-toggle\"" +
                    "                    data-toggle=\"dropdown\" aria-expanded=\"false\">" +
                    "                <span class=\"caret\"></span>" +
                    "                <span class=\"sr-only\">Toggle Dropdown</span>" +
                    "            </button>" +
                    "            <ul class=\"dropdown-menu\" role=\"menu\">" +
                    "                <li>" +
                    "                    <a class=\"saleSwichOpen\" saleSwitch=\"open\"" +
                    "                       data-toggle=\"tooltip\" data-placement=\"top\" title=\"\"" +
                    "                       data-original-title=\"恭喜您，您的审核已经通过，您可以点击上架发布您的APP\" onclick='AppShelf(" + list[i].appId + ")'" +
                    "                    >上架</a>" +
                    "                    <a class=\"saleSwichClose\" saleSwitch=\"close\"" +
                    "                       data-toggle=\"tooltip\" data-placement=\"top\" title=\"\"" +
                    "                       data-original-title=\"您可以点击下架来停止发布您的APP，市场将不提供APP的下载\" onclick='AppObtained(" + list[i].appId + ")'" +
                    "                    >下架</a>" +
                    "                </li>" +
                    "                <li>" +
                    "                    <a class=\"addVersion\"" +
                    "                       data-toggle=\"tooltip\" data-placement=\"top\" title=\"\"" +
                    "                       data-original-title=\"新增APP版本信息\" onclick=\"AppVersionAdd(" + list[i].appId + ")\"" +
                    "                    >新增版本</a>" +
                    "                </li>" +
                    "                <li>" +
                    "                    <a class=\"modifyVersion\"" +
                    "                       data-toggle=\"tooltip\" data-placement=\"top\" title=\"\"" +
                    "                       data-original-title=\"修改APP最新版本信息\" onclick=\"APPVersionUpdate(" + list[i].appId + ")\"" +
                    "                    >修改版本</a>" +
                    "                </li>" +
                    "                <li>" +
                    "                    <a class=\"modifyAppInfo\"" +
                    "                       data-toggle=\"tooltip\" data-placement=\"top\" title=\"\"" +
                    "                       data-original-title=\"修改APP基础信息\" onclick=\"APPUpdate(" + list[i].appId + ")\"" +
                    "                    >修改</a>" +
                    "                </li>" +
                    "                <li>" +
                    "                    <a class=\"viewApp\" data-toggle=\"tooltip\"" +
                    "                       data-placement=\"top\" title=\"\"" +
                    "                       data-original-title=\"查看APP基础信息以及全部版本信息\"" +
                    "                       onclick=\"APPSelect(" + list[i].appId + ")\"" +
                    "                    >查看</a>" +
                    "                </li>" +
                    "                <li>" +
                    "                    <a class=\"deleteApp\"" +
                    "                       data-toggle=\"tooltip\" data-placement=\"top\" title=\"\"" +
                    "                       data-original-title=\"删除APP基础信息以及全部版本信息\"" +
                    "                       onclick=\"APPDelete(" + list[i].appId + ")\"" +
                    "                    >删除</a>" +
                    "                </li>" +
                    "            </ul>" +
                    "        </div>" +
                    "    </td>" +
                    "</tr>";
            }

            //设置三个span标签的值
            $('[name="size"]').text(page.totalSize);
            $('[name="currNo"]').text(page.currNo);
            $('[name="pageCurrNo"]').text(page.totalCurrNo);

            html += "</tbody>";

        } else {
            alert(data.message);
        }
        $("#datatable-responsive").html(html);
    })
}

//第一页查询
function FirstPage() {
    $('[ name="page"]').val(1);
    SelectApp();
}

//上一页查询
function PerviousPage() {
    $('[ name="page"]').val($('[ name="page"]').val() - 1);
    SelectApp();
}

//下一页查询
function NextPage() {
    $('[ name="page"]').val($('[ name="page"]').val() + 1);
    SelectApp();
}

//末页页查询
function lastPage() {
    $('[ name="page"]').val($('[name="pageCurrNo"]').text());
    SelectApp();
}

//修改APP信息
function APPUpdate(appid) {
    $("/appInfoS/getAppinfo", {id: appid}, function (data) {
        if (data.success) {
            window.location.replace("/developer/appinfomodify.html")
        } else {
            alert(data.message);
        }
    })
}
