$().ready(function() {
	validateRule();
    $(".chosen-select").chosen({
        maxHeight : 200
    });
    $(".form_datetime1").datetimepicker({format: 'yyyy-mm-dd hh:ii:ss'});
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/system/lesson/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
    jQuery.validator.addMethod("subjectidNum",function(value, element){
       if(""==value){
		return false;
	   }
        return true;
    },"必填");
    $("#signupForm").validate({
		rules : {
            lessonname : {
				required : true
			},
            subjectid : {
                required : true,
                subjectidNum:true
            },
            teacherid : {
                required : true,
                subjectidNum:true
            },
            num : {
                required : true
            },
            starttime : {
                required : true
            },
            endtime : {
                required : true
            }
		},
		messages : {
            lessonname : {
				required : icon + "请输入课程名称"
			},
            subjectid : {
                required :icon + "请输入学科",
                subjectidNum:icon + "请输入学科11"
            },
            teacherid : {
                required : icon + "请输入授课老师"
            },
            num : {
                required : icon + "请输入授课次数"
            },
            starttime : {
                required : icon + "开课时间必须输入"
            },
            endtime : {
                required : icon + "结课时间必须输入"
            }
		}
	})
}


