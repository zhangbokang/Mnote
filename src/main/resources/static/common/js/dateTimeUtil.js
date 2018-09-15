var dateTimeUtil = function () {
    var timeFormat = {
        fs: "yyyy-MM-dd HH:mm:ss"
        , st: 0
    };
    /**
     * 根据timeFormat的fs生成时间每位的长度
     * 比如：yyyy-MM-dd HH:mm:ss
     * 返回：[4,2,2,2,2,2]
     * 以此来判断最终显示要显示多少位
     * @param fs
     * @returns {Array}
     */
    var seeif = function (fs) {
        var tmp = fs.split(" ");
        var out = [];
        $.map(tmp[0].split("-"), function (n) {
            out.push(n.length);
        });
        $.map(tmp[1].split(":"), function (n) {
            out.push(n.length);
        });
        return out;
    };
    /**
     * 格式化并返回日期时间字符串
     * @param json
     * @returns {string}
     */
    var formatDateTime = function (json) {
        json = $.extend(timeFormat, json);
        //拿到各位的长度
        var out = seeif(json.fs);
        var now = new Date(json.st);
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        if (out[1] > 1 && parseInt(month) < 10) {
            month = "0" + month;
        }
        var date = now.getDate();
        if (out[2] > 1 && parseInt(date) < 10) {
            date = "0" + date;
        }
        var hour = now.getHours();
        if (out[3] > 1 && parseInt(hour) < 10) {
            hour = "0" + hour;
        }
        var minute = now.getMinutes();
        if (out[4] > 1 && parseInt(minute) < 10) {
            minute = "0" + minute;
        }
        var second = now.getSeconds();
        if (out[5] > 1 && parseInt(second) < 10) {
            second = "0" + second;
        }
        return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
    };
    /**
     * 格式化并返回日期字符串
     * @param json
     * @returns {string}
     */
    var formatDate = function (json) {
        json = $.extend(timeFormat, json);
        //拿到各位的长度
        var out = seeif(json.fs);
        var now = new Date(json.st);
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        if (out[1] > 1 && parseInt(month) < 10) {
            month = "0" + month;
        }
        var date = now.getDate();
        if (out[2] > 1 && parseInt(date) < 10) {
            date = "0" + date;
        }
        return year + "-" + month + "-" + date;
    };
    /**
     * 格式化并返回时间字符串
     * @param json
     * @returns {string}
     */
    var formatTime = function (json) {
        json = $.extend(timeFormat, json);
        //拿到各位的长度
        var out = seeif(json.fs);
        var now = new Date(json.st);
        var hour = now.getHours();
        if (out[3] > 1 && parseInt(hour) < 10) {
            hour = "0" + hour;
        }
        var minute = now.getMinutes();
        if (out[4] > 1 && parseInt(minute) < 10) {
            minute = "0" + minute;
        }
        var second = now.getSeconds();
        if (out[5] > 1 && parseInt(second) < 10) {
            second = "0" + second;
        }
        return hour + ":" + minute + ":" + second;
    };
    return {
        formatDateTime: formatDateTime
        , formatDate: formatDate
        , formatTime: formatTime
    }
}();