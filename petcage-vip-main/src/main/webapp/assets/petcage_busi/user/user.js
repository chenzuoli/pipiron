layui.use(['table', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var func = layui.func;

    /**
     * 用户表管理
     */
    var DictType = {
        tableId: "user"
    };

    /**
     * 初始化表格的列
     */
    DictType.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', align: "center", sort: true, title: '自增主键'},
            {field: 'phone', align: "center", sort: true, title: '手机号'},
            {field: 'open_id', align: "center", sort: true, title: 'open_id'},
            {field: 'union_id', align: "center", sort: true, title: 'union_id'},
            {field: 'pwd', align: "center", sort: true, title: '密码'},
            {field: 'user_type', align: "center", sort: true, title: '用户类型'},
            {field: 'balance', align: "center", sort: true, title: '余额'},
            {field: 'valid_start_date', align: "center", sort: true, title: '会员生效开始日期'},
            {field: 'valid_end_date', align: "center", sort: true, title: '会员生效结束日期'},
            {field: 'token', align: "center", sort: true, title: '微信小程序token'},
            {field: 'country', align: "center", sort: true, title: '国别'},
            {field: 'province', align: "center", sort: true, title: '省份'},
            {field: 'city', align: "center", sort: true, title: '城市'},
            {field: 'avatar_url', align: "center", sort: true, title: '头像'},
            {
                field: 'gender', align: "center", sort: true, title: '性别', templet: function (d) {
                    if (d.gender === '1') {
                        return "男";
                    }
                    else if (d.gender === '0') {
                        return "女";
                    } else {
                        return "未知";
                    }
                }
            },
            {field: 'nick_name', align: "center", sort: true, title: '昵称'},
            {field: 'language', align: "center", sort: true, title: '语言'},
            {field: 'birthday', align: "center", sort: true, title: '出生日期'},
            {field: 'create_time', align: "center", sort: true, title: '创建时间'},
            {field: 'update_time', align: "center", sort: true, title: '更新时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    DictType.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        queryData['systemFlag'] = $("#systemFlag").val();
        queryData['status'] = $("#status").val();
        table.reload(DictType.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    DictType.openAddDlg = function () {
        func.open({
            height: 630,
            title: '添加用户',
            content: Feng.ctxPath + '/petcage/user/add',
            tableId: DictType.tableId
        });
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    DictType.openEditDlg = function (data) {
        func.open({
            height: 630,
            title: '修改用户信息',
            content: Feng.ctxPath + '/petcage/user_edit?id=' + data.id,
            tableId: DictType.tableId
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    DictType.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/petcage/user/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(DictType.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };

        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + DictType.tableId,
        url: Feng.ctxPath + '/petcage/user_list',
        page: true,
        height: "full-98",
        cellMinWidth: 150,
        cols: DictType.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        DictType.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        DictType.openAddDlg();
    });

    // 工具条点击事件
    table.on('tool(' + DictType.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            DictType.openEditDlg(data);
        } else if (layEvent === 'delete') {
            DictType.onDeleteItem(data);
        }
    });
});
