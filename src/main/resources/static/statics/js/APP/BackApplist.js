$(function () {
    SelectApp();
})

//多条件查询APP信息
function SelectApp() {

    //获取软件名称
    var softwareName = $('[ name="querySoftwareName"]').val();

    //获取当前页面
    var currNo = $('[ name="currentPage"]').val();

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
        currNo: currNo,
        statusId: 1
    }, function (data) {
        if (data.success) {
            var list = data.data.list;
            var page = data.data.page;

            for (var i = 0; i < list.length; i++) {
                html += "<tr role=\"row\" class=\"odd\">" +
                    "    <td tabindex=\"0\" class=\"sorting_1\">" + list[i].softwareName + "</td>" +
                    "    <td>" + list[i].apkname + "</td>" +
                    "    <td>" + list[i].softwareSize + "M</td>" +
                    "    <td>" + list[i].flatformName + "</td>" +
                    "    <td>" + list[i].firstAPPName + " -> " + list[i].twoAPPName + " -> " + list[i].threeAPPName + "</td>" +
                    "    <td><span id=\"appInfoStatusid\">" + list[i].statusType + "</span></td>" +
                    "    <td>" + list[i].frameType + "</td>" +
                    "    <td>" + list[i].downloads + "</td>" +
                    "    <td>" + list[i].versionNo + "</td>" +
                    "    <td>" +
                    "    <button type=\"button\" id='Review'  class=\"btn btn-default checkApp\"" +
                    "       data-toggle=\"tooltip\" data-placement=\"top\"" +
                    "       title=\"\" data-original-title=\"查看并审核APP\" appid='" + list[i].appId + "'>" +
                    "       审核</button>" +
                    "    </td></tr>";
            }

            //设置三个span标签的值
            $('[name="size"]').text(page.totalSize);
            $('[name="currNo"]').text(page.currNo);
            $('[name="pageCurrNo"]').text(page.totalCurrNo);

        } else {
            alert(data.message);
        }
        html += "</tbody>";
        $("#datatable-responsive").html(html);
    })
}

//第一页查询
function FirstPage() {
    $('[ name="currentPage"]').val(1);
    SelectApp();
}

//上一页查询
function PerviousPage() {
    $('[ name="currentPage"]').val($('[ name="currentPage"]').val() - 1);
    SelectApp();
}

//下一页查询
function NextPage() {
    $('[ name="currentPage"]').val($('[ name="currentPage"]').val() + 1);
    SelectApp();
}

//末页页查询
function lastPage() {
    $('[ name="currentPage"]').val($('[name="currentPage"]').text());
    SelectApp();
}

//APP上架方法
$(document).on('click', "#Review", function () {
    var appid = $(this).attr("appid");
    window.location.replace("/backend/appcheck.html?appid=" + appid);
})
