//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use(['element', 'form', 'layer'], function () {
    var element = layui.element;
    var form = layui.form;
    var layer = layui.layer;
    //监听子级提交
    form.on('submit(scheduleFormCh)', function (data) {
        $.ajax({
            url: "/schedule/saveOrUpdate"
            , data: data.field
            , type: "POST"
            , dataType: "json"
            , success: function (result) {
                schedulelist.appendCh(result);
                $("#scheduleAddChForm form")[0].reset()
                // scheduleId
            }
            , error: function () {
                alert("保存失败");
            }
        });
        // layer.msg(JSON.stringify(data.field));
        return false;
    });
    //监听顶级提交
    form.on('submit(scheduleForm)', function (data) {
        $.ajax({
            url: "/schedule/saveOrUpdate"
            , data: data.field
            , type: "POST"
            , dataType: "json"
            , success: function (result) {
                schedulelist.prepend(result);
                $("#scheduleAddForm form")[0].reset()
                // scheduleId
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
    /**
     * 初始化主节点列表
     */
    var init = function (page, size) {
        $.ajax({
            url: "/schedule/findPageSchedule"
            , data: {"page": page, "size": size}
            , type: "get"
            , dataType: "json"
            , success: function (result) {
                $("#schedulelist").empty();
                $.map(result.content, function (n) {
                    append(n)
                });
            }
            , error: function () {
                alert("加载失败，服务器错误");
            }
        });
    };
    /**
     * 向前追加子节点
     * @param n
     */
    var appendCh = function (n) {
        var html = "<div class='scheduleListChList'>" + n.text + "</div>";
        $("#schedulelist #list_" + n.pid + " .chList").prepend(html);
    };
    /**
     * 生成主节点所有html代码，并移除要添加的节点同ID的节点
     * @param n
     * @returns {string}
     */
    var genHtml = function (n) {
        $(".layui-colla-item#list_" + n.id).remove();
        var html = "<div id='list_" + n.id + "' class=\"layui-colla-item\">\n" +
            "<div class=\"layui-colla-title\">\n" +
            "<div style='width: 150px;display: inline-block;padding-right: 10px;'>" + dateTimeUtil.format({st:n.updateTime}) + "</div>" +
            "<div style='width: 600px;display: inline-block;padding-right: 10px;'>" + n.title + "</div>" +
            "<div style='width: 60px;display: inline;'>优先级：";
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
        html += "</div><div style='width: 70px;display: inline;'>状态：";
        switch (n.status) {
            case -1:
                html += "<span style='color: #666666;'>结束</span>";
                break;
            case 1:
                html += "<span style='color: #00FF00;'>开始</span>";
                break;
            case 0:
                html += "<span style='color: #3399cc;'>挂起</span>";
                break;
        }
        html += "</div>&nbsp;&nbsp;&nbsp;&nbsp;<button style='margin: 5px 5px;' class='layui-btn layui-btn-normal layui-btn-sm' onclick='schedulelist.reEdit(" + n.id + ")'>编辑</button>";
        if (n.status != -1) {
            html += "<button style='margin: 5px 5px;' class='layui-btn layui-btn-warm layui-btn-sm' onclick='schedulelist.theEnd(" + n.id + ")'>结束</button>";
        }
        html += "</div>\n" +
            "<div class=\"layui-colla-content\">\n" +
            n.text + "\n";

        html += "<div class=\"layui-form\" id=\"scheduleAddChForm\">\n" +
            "        <form>\n" +
            "            <input type=\"hidden\" name=\"pid\" value='" + n.id + "'/>\n" +
            "            <div class=\"layui-form-item layui-form-text\">\n" +
            "                <label class=\"layui-form-label\">内容</label>\n" +
            "                <div class=\"layui-input-block\">\n" +
            "                    <textarea name=\"text\" lay-verify=\"required\" placeholder=\"\" class=\"layui-textarea\"></textarea>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"layui-form-item\">\n" +
            "                <div class=\"layui-input-block\">\n" +
            "                    <button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"scheduleFormCh\">提交</button>\n" +
            "                    <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </form>\n" +
            "    </div>";

        html += "<div class='chList' style=\"border: 1px solid #555555;padding: 0 5px 0 5px;\">\n";
        $.map(n.chilSchedules, function (cn) {
            html += "<div class=\"scheduleListChList\">\n" +
                "" + cn.text + "\n" +
                "</div>\n";
        });
        html += "</div>\n" +
            "</div>\n" +
            "</div>";
        return html;
    };
    /**
     * 向后追加主节点
     * @param n
     */
    var append = function (n) {
        $("#schedulelist").append(genHtml(n));
        layui.element.render({
            elem: "#schedulelist"
        });
    };
    /**
     * 向前追加主节点
     * @param n
     */
    var prepend = function (n) {
        $("#schedulelist").prepend(genHtml(n));
        layui.element.render({
            elem: "#schedulelist"
        });
    }
    /**
     * 重新编辑主节点回填方法
     * @param id
     * @param e
     */
    var reEdit = function (id, e) {
        $.ajax({
            url: "/schedule/findById"
            , type: "GET"
            , data: {id: id}
            , dataType: "json"
            , success: function (reselt) {
                $("#scheduleAddForm [name='id']").val(reselt.id);
                $("#scheduleAddForm [name='title']").val(reselt.title);
                $("#scheduleAddForm [name='text']").text(reselt.text);
                $("#scheduleAddForm [name='priority']").val(reselt.priority);
                $("#scheduleAddForm [name='status']").val(reselt.status);
                ////更新全部渲染
                layui.form.render();
            }
            , error: function () {
                alert("请求编辑失败");
            }
        });
        //如果提供了事件对象，则这是一个非IE浏览器
        if (e && e.stopPropagation)
        //因此它支持W3C的stopPropagation()方法
            e.stopPropagation();
        else
        //否则，我们需要使用IE的方式来取消事件冒泡
            window.event.cancelBubble = true;
    };

    /**
     * 根据ID删除主节点
     * @param id
     */
    var theEnd = function (id) {
        $.ajax({
            url: "/schedule/endById"
            , type: "GET"
            , data: {id: id}
            , dataType: "json"
            , success: function (result) {
                prepend(result);
            }
            , error: function () {
                alert("结束失败");
            }
        })
    };
    return {
        init: init
        , append: append
        , prepend: prepend
        , appendCh: appendCh
        , reEdit: reEdit
        , theEnd: theEnd
    }
}();