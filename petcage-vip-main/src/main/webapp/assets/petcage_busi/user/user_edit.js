/**
 * 详情对话框
 */
var PetInfoDlg = {
    data: {
        pet_type: "",
        variety: ""
    }
};


layui.use(['form', 'ax', 'admin'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/petcage/pet_detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('petEditForm', result.data);

    // 点击品种时
    $('#pet_type1').click(function () {
        var formName = encodeURIComponent("parent.PetInfoDlg.data.pet_type");
        var treeUrl = encodeURIComponent("/petcage/pet/type_tree");

        var formId = '0';
        if (formName === '狗') {
            formId = '1'
        } else if (formName === '猫') {
            formId = '2'
        } else if (formName === '其他动物') {
            formId = '3'
        } else if (formName === '鱼') {
            formId = '4'
        } else if (formName === '鸟') {
            formId = '5'
        }

        layer.open({
            type: 2,
            title: '宠物类型选择',
            area: ['300px', '400px'],
            content: Feng.ctxPath + '/system/commonTree?formName=' + formName + "&formId=" + formId + "&treeUrl=" + treeUrl,
            end: function () {
                console.log(PetInfoDlg.data);
                $("#pet_type").val(PetInfoDlg.data.pet_type);
                $("#variety").val(PetInfoDlg.data.variety);
            }
        });
    });

    // 点击品种时
    $('#variety1').click(function () {
        var formName = encodeURIComponent("parent.PetInfoDlg.data.variety");
        var formId = encodeURIComponent("parent.PetInfoDlg.data.pet_type");
        var treeUrl = encodeURIComponent("/petcage_busi/pet/variety_tree");

        layer.open({
            type: 2,
            title: '宠物类型品种选择',
            area: ['300px', '400px'],
            content: Feng.ctxPath + '/system/commonTree?formName=' + formName + "&formId=" + formId + "&treeUrl=" + treeUrl,
            end: function () {
                console.log(PetInfoDlg.data);
                $("#pet_type").val(PetInfoDlg.data.pet_type);
                $("#variety").val(PetInfoDlg.data.variety);
            }
        });
    });

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        console.log("update pet info: " + data)
        var ajax = new $ax(Feng.ctxPath + "/petcage/pet/edit", function (data) {
            Feng.success("更新成功！");

            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);

            //关掉对话框
            admin.closeThisDialog();

        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

});