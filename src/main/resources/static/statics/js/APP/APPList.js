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
        "        下载次数" +
        "    </th>" +
        "    <th class=\"sorting\" tabindex=\"0\"" +
        "        aria-controls=\"datatable-responsive\" rowspan=\"1\" colspan=\"1\"" +
        "        aria-label=\"Last name: activate to sort column ascending\">" +
        "        最新版本号" +
        "    </th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";

    $.get("/appInfoS/getAppInfoS", {
        softwareName: softwareName,
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
                    "    <td>" + list[i].APKName + "</td>" +
                    "    <td>" + list[i].softwareSize + "</td>" +
                    "    <td>" + list[i].flatformName + "</td>" +
                    "    <td>" + list[i].firstAPPName + " -> " + list[i].twoAPPName + " -> " + list[i].threeAPPName + "</td>" +
                    "    <td>" + list[i].downloads + "</td>" +
                    "    <td>" + list[i].versionNo + "</td>" +
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

$(function () {
    SelectApp();
})
