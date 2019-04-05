$("#queryCategoryLevel1").change(function () {
    var $queryCategoryLevel1Value = $("#queryCategoryLevel1").val();
    $.getJSON("getClassification", {"parentId": $queryCategoryLevel1Value}, function (data) {

        if (data != null) {
            $("#queryCategoryLevel2").html("");
            var options = "<option value=\"\">--请选择--</option>"
            for (var i = 0; i < data.length; i++) {
                options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>"
            }
            $("#queryCategoryLevel2").html(options);
        }
    })

})

$("#queryCategoryLevel2").change(function () {
    var $queryCategoryLevel2Value = $("#queryCategoryLevel2").val();
    $.getJSON("getClassification", {"parentId": $queryCategoryLevel2Value}, function (data) {

        if (data != null) {
            $("#queryCategoryLevel3").html("");
            var options = "<option value=\"\">--请选择--</option>"
            for (var i = 0; i < data.length; i++) {
                options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>"
            }
            $("#queryCategoryLevel3").html(options);
        }
    })

})

/* 删除APP */
$(".deleteApp").click(function () {
    var logoLocPath = $(this).attr("logoLocPath");
    var appInfoId = $(this).attr("appinfoid");
    var appSoft = confirm("确定要删除" + $(this).attr("appsoftwarename") + "吗？");
    if (appSoft) {
        $.getJSON("deleteApp", {"appInfoId": appInfoId, "logoLocPath": logoLocPath}, function (data) {
            if (data == "1") {
                alert("删除成功！");
            } else {
                alert("删除失败！")
            }
            window.location = "list";

        });
    }
})