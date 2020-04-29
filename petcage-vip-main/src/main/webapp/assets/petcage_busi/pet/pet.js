layui.use(['table', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var func = layui.func;

    /**
     * 宠物表管理
     */
    var DictType = {
        tableId: "pet"
    };

    /**
     * 初始化表格的列
     */
    DictType.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', align: "center", sort: true, title: '宠物id'},
            {field: 'open_id', align: "center", sort: true, title: '用户open_id'},
            {field: 'contact', align: "center", sort: true, title: '联系人'},
            {field: 'pet_type', align: "center", sort: true, title: '宠物类型'},
            {field: 'variety', align: "center", sort: true, title: '宠物品种'},
            {field: 'nick_name', align: "center", sort: true, title: '昵称'},
            // {field: 'gender', align: "center", sort: true, title: '性别'},
            {
                field: 'gender', align: "center", sort: true, title: '性别', templet: function (d) {
                    if (d.gender === '1') {
                        return "公";
                    }
                    else if (d.gender === '0') {
                        return "母";
                    } else {
                        return "未知";
                    }
                }
            },
            {field: 'birthday', align: "center", sort: true, title: '出生日期'},
            {field: 'avatar_url', align: "center", sort: true, title: '头像url'},
            {field: 'description', align: "center", sort: true, title: '描述'},
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
            title: '添加宠物',
            content: Feng.ctxPath + '/petcage/pet/add',
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
            title: '修改宠物信息',
            content: Feng.ctxPath + '/petcage/pet_edit?id=' + data.id,
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
            var ajax = new $ax(Feng.ctxPath + "/petcage/pet/delete", function (data) {
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
        url: Feng.ctxPath + '/petcage/pet_list',
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
