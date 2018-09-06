//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use(['element', 'form', 'layer'], function () {
    var element = layui.element;
    var form = layui.form;
    var layer = layui.layer;
    //监听提交
    form.on('submit(scheduleForm)', function (data) {
        $.ajax({
            url: "/schedule/save"
            , data: data.field
            , type: "POST"
            , dataType: "json"
            , success: function (result) {
                schedulelist.append(result);
            }
            , error: function () {
                alert("保存失败");
            }
        });
        // layer.msg(JSON.stringify(data.field));
        return false;
    });
});
var schedulelist = function () {
    var loadschedulelist = function () {
        $.ajax({
            url: "/schedule/findPageSchedule"
            , data: {"page": 0, "size": 10}
            , type: "get"
            , dataType: "json"
            , success: function (result) {
                $("#schedulelist").empty();
                $.map(result.content, function (n) {
                    genHtml(n)
                });
            }
            , error: function () {
                alert("加载失败，服务器错误");
            }
        });
    };
    var genHtml = function (n) {
        var html = "<div class=\"layui-colla-item\">\n" +
            "<div class=\"layui-colla-title\">\n" +
            n.title +
            "&nbsp;&nbsp;&nbsp;优先级：";
        switch (n.priority) {
            case 0:
                html += "<span style='color: #ff5522;'>高</span>";
                break;
            case 1:
                html += "<span style='color: #ff9900;'>中</span>";
                break;
            case 2:
                html += "<span style='color: #888888;'>低</span>"
                break;
        }
        html += "&nbsp;&nbsp;&nbsp;状态：";
        switch (n.status) {
            case 0:
                html += "<span style='color: #666666'>结束</span>";
                break;
            case 1:
                html += "<span style='color: #00FF00;'>开始(进行中)</span>";
                break;
            case 2:
                html += "<span style='color: #3399cc'>挂起</span>";
                break;
        }
        html += "</div>\n" +
            "<div class=\"layui-colla-content\">\n" +
            n.text + "\n" +
            "<div style=\"border: 1px solid #555555;padding: 0 5px 0 5px;\">\n";
        $.map(n.chilSchedules, function (cn) {
            html += "<div class=\"layui-card\">\n" +
                "<div class=\"layui-card-header\">" + cn.title +
                "&nbsp;&nbsp;&nbsp;优先级：";
            switch (cn.priority) {
                case 0:
                    html += "<span style='color: #ff5522;'>高</span>";
                    break;
                case 1:
                    html += "<span style='color: #ff9900;'>中</span>";
                    break;
                case 2:
                    html += "<span style='color: #888888;'>低</span>"
                    break;
            }
            html += "</div>\n" +
                "<div class=\"layui-card-body\">\n" +
                "" + cn.text + "\n" +
                "</div>\n" +
                "</div>\n";
        });
        html += "</div>\n" +
            "</div>\n" +
            "</div>";
        $("#schedulelist").append(html);
        layui.element.render({
            elem: "#schedulelist"
        });
    };
    return {
        init: loadschedulelist
        , append: genHtml
    }
}();